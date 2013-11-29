/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.acceptance.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.acceptance.service.TacceptanceService;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.report.service.TprojectInfoAService;
import com.hopsun.tppas.api.report.service.TprojectInfoBService;
import com.hopsun.tppas.api.report.service.TreviewCommentsService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TattachmentService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.common.FileDownLoad;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Tacceptance;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectInfoA;
import com.hopsun.tppas.entity.TprojectInfoB;
import com.hopsun.tppas.entity.TprojectType;
import com.hopsun.tppas.entity.TreviewComments;

/**
 * 
 *@comments 项目验收
 *@author liyilin
 *@date 2013-8-9
 *@version 1.0
 */
public class TacceptanceAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(TacceptanceAction.class.getName());
	private static final long serialVersionUID = 1L;
	@Resource
	private TacceptanceService tacceptanceService;
	@Resource
	private TattachmentService tattachmentService;
	@Resource
	private MitemService mitemService;
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	@Resource
	private TprojectTypeService tprojectTypeService;
	/** 项目意见*/
	@Resource
	private TreviewCommentsService treviewCommentsService;
	/** TprojectInfoAService 对象的实例 */
	@Resource
	private TprojectInfoAService tprojectInfoAService;
	/** 非高新项目基本信息*/
	@Resource
	private TprojectInfoBService tprojectInfoBService;
	
	/** 项目申报 */
	private TprojectApplication tprojectApplication;
	/** 项目验收对象 */
	private Tacceptance tacceptance;
	/** 项目基本信息A */
	private TprojectInfoA tprojectInfoA;
	/** 项目基本信息B */
	private TprojectInfoB tprojectInfoB;
	/** 意见表 */
	private TreviewComments treviewComments;

	/** 验收分类*/
	private String typeFlag;
	/** 验收ID */
	private String acceptanceId;
	/** 验收状态 */
	private String acceptanceStatus;
	/** 部门ID */
	private String deptId;
	/** 项目分类 */
	private String typeId2;
	private String typeId3;
	/** 归口管理部 */ 
	private String centralizedType;
	/** 跳转页数 */
	private int pageNo;
	/** 跳转路径*/
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;
	/** 菜单List */ 
	private List<Mitem> menuList;
	/** 表名 */
	private String tableName;
	/** 文件类型 */
	private String fileType;
	/** 材料没有数据的信息 */
	private String msgErr;
	/** 材料是否有数据 */
	private String isPass = "1";
	/** 提交标志 */
	private String submitFlag;
	/** 项目分类 */
	private List<TprojectType> typeId2List;
	private List<TprojectType> typeId3List;
	/** 验收状态 */
	private List<Mitem> acceptanceStatusList;
	/** 高新处验收提交材料集合 */
	private List<Map<String, Object>> submitHighTechAcceptanceList;
	/** 非高新验收提交材料集合 */
	private List<Map<String, Object>> submitOtherAcceptanceList;
	
	/**
	 * @comments 取得项目验收列表
	 * @return
	 * @Version 1.0
	 */
	public String init() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	session.setAttribute(Constants.SESSION_CMDKEY, "tacceptance");
		
    	// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
    	// 取得部门ID
    	if(user.getScDept() != null && user.getScDept().getDeptId() != null && !"".equals(user.getScDept().getDeptId())){
    		deptId = user.getScDept().getDeptId();
    	} else {
    		logger.error("部门不存在！");
			return "LogOut";
    	}
    	// 初始化项目分类List
    	this.typeId2List = new ArrayList<TprojectType>();
    	this.typeId3List = new ArrayList<TprojectType>();
    	// 初始化验收状态List
    	this.acceptanceStatusList = new ArrayList<Mitem>();
    	
    	// 项目分类1
		this.typeId2List = tprojectTypeService.getFatherProjectTypeListByDeptId(deptId);
		// 验收状态
		this.acceptanceStatusList = mitemService.getListByTypeId(Constants.TYPE_ACCEPTANCE_STATUS);
    	
    	// 跳转到页面
		return "init";
	}
	
	/**
	 * @comments 根据查询条件取得list
	 * @return
	 * @Version 1.0
	 */
	public String getList(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (cmdkey == null || !"tacceptance".equals(cmdkey)) {
			logger.error("错误的令牌！");
			return "LogOut";
		}
		
		// 得到数据总个数
		setPager(new Pager());
		pager = new Pager();
    	if (this.getPageNo() != 0) {
    		pager.setPageNumber(this.getPageNo());
    	}

		// 检索条件
    	Map<String, Object> param = new HashMap<String, Object>();
    	param.put("projectName", tprojectApplication.getProjectName());
    	param.put("applicationUnit", tprojectApplication.getApplicationUnit());
    	param.put("typeId2", this.getTypeId2());
    	param.put("typeId3", this.getTypeId3());
    	param.put("acceptanceStatus", this.getAcceptanceStatus());
		
		// 取得项目验收管理一览
		pager = tacceptanceService.find(param, pager.getPageNumber(), pager.getPageSize());
		
		return "resultList";
	}

	/**
	 * @Comments 高新处项目验收申请menu初期化处理
	 * @return
	 * @Vsersion: 1.0
	 */
	public String highTechInit() {
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (cmdkey == null || !"tacceptance".equals(cmdkey)) {
			logger.error("错误的令牌！");
			return "LogOut";
		}
		// 菜单
		this.menuList = mitemService.getListByTypeId(Constants.API_ACCEPTANCE_HT_TYPE);
		
		return "highTechInit";
	}
	
	/**
	 * @Comments 高新处项目验收申请表封皮初期化处理
	 * @return
	 * @Vsersion: 1.0
	 */
	public String highTechCover() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	session.setAttribute(Constants.SESSION_CMDKEY, "highTechCover");
		
    	// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
		// 根据项目ID查询项目验收管理信息
		tacceptance = tacceptanceService.getTacceptanceById(acceptanceId);
		if(tacceptance != null && tacceptance.getTprojectApplication() != null){
			// 根据项目ID查询项目基本信息
			List<TprojectInfoA> tprojectInfoAList = new ArrayList<TprojectInfoA>();
			tprojectInfoAList = tprojectInfoAService.getTprojectInfoAById(tacceptance.getTprojectApplication().getProjectId());
			if(tprojectInfoAList != null && tprojectInfoAList.size() > 0){
				tprojectInfoA = tprojectInfoAList.get(0);
			}
		}

		return "highTechCover";
	}
	
	/**
	 * @Comments 高新处附件清单初期化处理
	 * @return
	 * @Vsersion: 1.0
	 */
	public String highTechIndex() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	session.setAttribute(Constants.SESSION_CMDKEY, "highTechIndex");
		
    	// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
		// 设置分页参数
		setPager(new Pager());
		pager = new Pager();
    	if (this.getPageNo() != 0) {
    		pager.setPageNumber(this.getPageNo());
    	}
		// 取得表名
		tableName = tattachmentService.getTableName(Tacceptance.class);
		// 取得附件一览信息
		pager = tattachmentService.find(tableName, acceptanceId, pager.getPageNumber(), pager.getPageSize());
		
		return "highTechIndex";
	}
	
	/**
	 * @Comments 高新处项目验收提交页面初期化处理
	 * @return
	 * @Vsersion: 1.0
	 */
	public String highTechSubmit() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	session.setAttribute(Constants.SESSION_CMDKEY, "highTechSubmit");
		
    	// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
    	
		submitHighTechAcceptanceList = tacceptanceService.getSubmitHighTechAcceptanceList(acceptanceId);
		StringBuilder sb = new StringBuilder();
		if (submitHighTechAcceptanceList != null && submitHighTechAcceptanceList.size() > 0) {
			for (int i = 0; i < submitHighTechAcceptanceList.size(); i++) {
				Map<String, Object> map = submitHighTechAcceptanceList.get(i);
				//材料类型没有
				if(map.get("isKey").equals("0")){
					sb.append(map.get("name"));
					sb.append("、");
					isPass = "0";
				}
			}
			String strString = sb.toString();
			if(strString != null && strString.length() > 0){
				this.msgErr = strString.substring(0, strString.length()-1);
			}
		}
		
		return "highTechSubmit";
	}

	/**
	 * 高新处项目验收提交
	 * @return String
	 */
	public String submitHighTechAcceptance(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (cmdkey == null || !"highTechSubmit".equals(cmdkey)) {
			logger.error("错误的令牌！");
			return "LogOut";
		}
		
		tacceptanceService.saveSubmitHighTechAcceptance(submitFlag, acceptanceId);

		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(this.getRequest().getContextPath() + "/api/acceptance/acceptance!init.action?now=" + new Date().getTime());

		return "systemInfoMain";
	}
	
	/**
	 * 验收打印(高新处)
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public void printHighTechAcceptance(){
		//取得pdf模板路径
		String pdfInputPath = mitemService.get(Constants.PDF_TEMPLATE_PATH).getItemDesc();
		//取得pdf输出路径
		String pdfOutputPath = mitemService.get(Constants.PDF_STORAGE_PATH).getItemDesc();
		String len  = pdfInputPath.substring(pdfInputPath.length() - 1 , pdfInputPath.length());
		
		// 判断目录是否完整
		if (!"/".equals(len)) {
			pdfInputPath = pdfInputPath + "/";
		}
		len  = pdfOutputPath.substring(pdfOutputPath.length() - 1 , pdfOutputPath.length());
		
		// 判断目录是否完整
		if (!"/".equals(len)) {
			pdfOutputPath = pdfOutputPath + "/";
		} 
		// 点击列表的打印时要重新生成pdf
		String filePath = tacceptanceService.printHighTechAcceptance(pdfInputPath, pdfOutputPath,acceptanceId);
		// 点列表的打印直接下载PDF
		HttpServletResponse response = ServletActionContext.getResponse();
		// pdf弹出的消息框的名字
		String fileName = this.getText("acceptance_pdf_name")+".pdf";
	    FileDownLoad fileDownLoad = new FileDownLoad();
	    try {
			fileDownLoad.writeDownloadStream(response, filePath, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Comments 非高新处项目验收申请menu初期化处理
	 * @return
	 * @Vsersion: 1.0
	 */
	public String otherInit() {
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (cmdkey == null || !"tacceptance".equals(cmdkey)) {
			logger.error("错误的令牌！");
			return "LogOut";
		}
		// 菜单
		this.menuList = mitemService.getListByTypeId(Constants.API_ACCEPTANCE_XM_TYPE);
		return "otherInit";
	}
	
	/**
	 * 
	 * @comments 非高新处项目验收申请表封皮初始化
	 * @return
	 * @version 1.0
	 * @author weina
	 */
	public String showAcceptanceinfoB(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	session.setAttribute(Constants.SESSION_CMDKEY, "showAcceptanceinfoB");
		
    	// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
		
		// 根据项目验收id查非高新验收信息
		this.tacceptance = this.tacceptanceService.getTacceptanceById(acceptanceId);
		if(tacceptance.getTprojectApplication().getProjectId()!=null){
			// 取得归口管理部信息
			if(tprojectApplicationService.get(tacceptance.getTprojectApplication().getProjectId()).getCentralizedType() != null){
				Mitem centralized = mitemService.get(tprojectApplicationService.get(tacceptance.getTprojectApplication().getProjectId()).getCentralizedType());
				this.centralizedType = centralized.getItemName();				
			}
		}
		// 根据项目ID查项目基本信息
		List<TprojectInfoB> tprojectInfoBList = new ArrayList<TprojectInfoB>();
		tprojectInfoBList = tprojectInfoBService.getList("tprojectApplication.projectId", tacceptance.getTprojectApplication().getProjectId());
		if(tprojectInfoBList != null && tprojectInfoBList.size() > 0){
			this.tprojectInfoB = tprojectInfoBList.get(0);
		}
		// 根据项目ID查项目意见信息
		List<TreviewComments> treviewCommentsList = new ArrayList<TreviewComments>();
		treviewCommentsList = treviewCommentsService.getList("tprojectApplication.projectId", tacceptance.getTprojectApplication().getProjectId());
		if(treviewCommentsList != null && treviewCommentsList.size() > 0){
			this.treviewComments = treviewCommentsList.get(0);
		}
		return "showAcceptanceinfoB";
			
	}
	
	/**
	 * 
	 * @comments  非高新附件列表
	 * @return
	 * @version 1.0
	 * @author weina
	 */
	public String showIndexList() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	session.setAttribute(Constants.SESSION_CMDKEY, "showIndexListb");
		
    	// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}

		// 设置分页参数
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}

		// 取得验收管理ID
		this.acceptanceId = this.getAcceptanceId();

		// 取得表名
		this.tableName = tattachmentService.getTableName(Tacceptance.class);
		// 取得附件一览信息
		pager = tattachmentService.find(tableName, acceptanceId,
				pager.getPageNumber(), pager.getPageSize());
		return "showIndexList";
	}
	
	/**
	 * 
	 * @comments 非高新验收提交页面初始化
	 * @return
	 * @version 1.0
	 */
	public String showOtherAcceptance(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	session.setAttribute(Constants.SESSION_CMDKEY, "showOtherAcceptance");
		
    	// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}

		submitOtherAcceptanceList = tacceptanceService.getSubmitOtherAcceptanceList(acceptanceId);
		StringBuilder str = new StringBuilder();
		if (submitOtherAcceptanceList != null && submitOtherAcceptanceList.size() > 0) {
			for (int i = 0; i < submitOtherAcceptanceList.size(); i++) {
				Map<String,Object> map = submitOtherAcceptanceList.get(i);
				//材料类型没有
				if(map.get("isKey").equals("0")){
					str.append(map.get("name"));
					str.append("、");
					isPass = "0";
				}
			}
			String strString = str.toString();
			if(strString!=null&&strString.length()>0){
				this.msgErr = strString.substring(0, strString.length()-1);
			}
		}

		return "otherAcceptanceSubmit";
	
	}
	/**
	 * 提交非高新验收信息
	 * @return String
	 */
	public String submitOtherAcceptance(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (cmdkey == null || !"showOtherAcceptance".equals(cmdkey)) {
			logger.error("错误的令牌！");
			return "LogOut";
		}
		
		tacceptanceService.saveSubmitOtherAcceptance(submitFlag, acceptanceId);

		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(this.getRequest().getContextPath()
				+ "/api/acceptance/acceptance!init.action?now="
				+ new Date().getTime());

		return "systemInfoMain";
	}
	
	/**
	 * @return the tacceptanceService
	 */
	public TacceptanceService getTacceptanceService() {
		return tacceptanceService;
	}

	/**
	 * @param tacceptanceService the tacceptanceService to set
	 */
	public void setTacceptanceService(TacceptanceService tacceptanceService) {
		this.tacceptanceService = tacceptanceService;
	}

	/**
	 * @return the tattachmentService
	 */
	public TattachmentService getTattachmentService() {
		return tattachmentService;
	}

	/**
	 * @param tattachmentService the tattachmentService to set
	 */
	public void setTattachmentService(TattachmentService tattachmentService) {
		this.tattachmentService = tattachmentService;
	}

	/**
	 * @return the mitemService
	 */
	public MitemService getMitemService() {
		return mitemService;
	}

	/**
	 * @param mitemService the mitemService to set
	 */
	public void setMitemService(MitemService mitemService) {
		this.mitemService = mitemService;
	}

	/**
	 * @return the tprojectTypeService
	 */
	public TprojectTypeService getTprojectTypeService() {
		return tprojectTypeService;
	}

	/**
	 * @param tprojectTypeService the tprojectTypeService to set
	 */
	public void setTprojectTypeService(TprojectTypeService tprojectTypeService) {
		this.tprojectTypeService = tprojectTypeService;
	}

	/**
	 * @return the tprojectApplication
	 */
	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}

	/**
	 * @param tprojectApplication the tprojectApplication to set
	 */
	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	/**
	 * @return the tacceptance
	 */
	public Tacceptance getTacceptance() {
		return tacceptance;
	}

	/**
	 * @param tacceptance the tacceptance to set
	 */
	public void setTacceptance(Tacceptance tacceptance) {
		this.tacceptance = tacceptance;
	}

	/**
	 * @return the typeFlag
	 */
	public String getTypeFlag() {
		return typeFlag;
	}

	/**
	 * @param typeFlag the typeFlag to set
	 */
	public void setTypeFlag(String typeFlag) {
		this.typeFlag = typeFlag;
	}

	/**
	 * @return the acceptanceId
	 */
	public String getAcceptanceId() {
		return acceptanceId;
	}

	/**
	 * @param acceptanceId the acceptanceId to set
	 */
	public void setAcceptanceId(String acceptanceId) {
		this.acceptanceId = acceptanceId;
	}

	/**
	 * @return the acceptanceStatus
	 */
	public String getAcceptanceStatus() {
		return acceptanceStatus;
	}

	/**
	 * @param acceptanceStatus the acceptanceStatus to set
	 */
	public void setAcceptanceStatus(String acceptanceStatus) {
		this.acceptanceStatus = acceptanceStatus;
	}

	/**
	 * @return the deptId
	 */
	public String getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return the typeId2
	 */
	public String getTypeId2() {
		return typeId2;
	}

	/**
	 * @param typeId2 the typeId2 to set
	 */
	public void setTypeId2(String typeId2) {
		this.typeId2 = typeId2;
	}

	/**
	 * @return the typeId3
	 */
	public String getTypeId3() {
		return typeId3;
	}

	/**
	 * @param typeId3 the typeId3 to set
	 */
	public void setTypeId3(String typeId3) {
		this.typeId3 = typeId3;
	}

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the retUrl
	 */
	public String getRetUrl() {
		return retUrl;
	}

	/**
	 * @param retUrl the retUrl to set
	 */
	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
	}

	/**
	 * @return the retMsg
	 */
	public String getRetMsg() {
		return retMsg;
	}

	/**
	 * @param retMsg the retMsg to set
	 */
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	/**
	 * @return the typeId2List
	 */
	public List<TprojectType> getTypeId2List() {
		return typeId2List;
	}

	/**
	 * @param typeId2List the typeId2List to set
	 */
	public void setTypeId2List(List<TprojectType> typeId2List) {
		this.typeId2List = typeId2List;
	}

	/**
	 * @return the typeId3List
	 */
	public List<TprojectType> getTypeId3List() {
		return typeId3List;
	}

	/**
	 * @param typeId3List the typeId3List to set
	 */
	public void setTypeId3List(List<TprojectType> typeId3List) {
		this.typeId3List = typeId3List;
	}

	/**
	 * @return the acceptanceStatusList
	 */
	public List<Mitem> getAcceptanceStatusList() {
		return acceptanceStatusList;
	}

	/**
	 * @param acceptanceStatusList the acceptanceStatusList to set
	 */
	public void setAcceptanceStatusList(List<Mitem> acceptanceStatusList) {
		this.acceptanceStatusList = acceptanceStatusList;
	}

	/**
	 * @return the menuList
	 */
	public List<Mitem> getMenuList() {
		return menuList;
	}

	/**
	 * @param menuList the menuList to set
	 */
	public void setMenuList(List<Mitem> menuList) {
		this.menuList = menuList;
	}

	/**
	 * @return the tprojectInfoAService
	 */
	public TprojectInfoAService getTprojectInfoAService() {
		return tprojectInfoAService;
	}

	/**
	 * @param tprojectInfoAService the tprojectInfoAService to set
	 */
	public void setTprojectInfoAService(TprojectInfoAService tprojectInfoAService) {
		this.tprojectInfoAService = tprojectInfoAService;
	}

	/**
	 * @return the tprojectInfoA
	 */
	public TprojectInfoA getTprojectInfoA() {
		return tprojectInfoA;
	}

	/**
	 * @param tprojectInfoA the tprojectInfoA to set
	 */
	public void setTprojectInfoA(TprojectInfoA tprojectInfoA) {
		this.tprojectInfoA = tprojectInfoA;
	}

	/**
	 * @return the tprojectInfoB
	 */
	public TprojectInfoB getTprojectInfoB() {
		return tprojectInfoB;
	}

	/**
	 * @param tprojectInfoB the tprojectInfoB to set
	 */
	public void setTprojectInfoB(TprojectInfoB tprojectInfoB) {
		this.tprojectInfoB = tprojectInfoB;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * @return the tprojectApplicationService
	 */
	public TprojectApplicationService getTprojectApplicationService() {
		return tprojectApplicationService;
	}

	/**
	 * @param tprojectApplicationService the tprojectApplicationService to set
	 */
	public void setTprojectApplicationService(
			TprojectApplicationService tprojectApplicationService) {
		this.tprojectApplicationService = tprojectApplicationService;
	}

	/**
	 * @return the treviewCommentsService
	 */
	public TreviewCommentsService getTreviewCommentsService() {
		return treviewCommentsService;
	}

	/**
	 * @param treviewCommentsService the treviewCommentsService to set
	 */
	public void setTreviewCommentsService(
			TreviewCommentsService treviewCommentsService) {
		this.treviewCommentsService = treviewCommentsService;
	}

	/**
	 * @return the tprojectInfoBService
	 */
	public TprojectInfoBService getTprojectInfoBService() {
		return tprojectInfoBService;
	}

	/**
	 * @param tprojectInfoBService the tprojectInfoBService to set
	 */
	public void setTprojectInfoBService(TprojectInfoBService tprojectInfoBService) {
		this.tprojectInfoBService = tprojectInfoBService;
	}

	/**
	 * @return the treviewComments
	 */
	public TreviewComments getTreviewComments() {
		return treviewComments;
	}

	/**
	 * @param treviewComments the treviewComments to set
	 */
	public void setTreviewComments(TreviewComments treviewComments) {
		this.treviewComments = treviewComments;
	}

	/**
	 * @return the centralizedType
	 */
	public String getCentralizedType() {
		return centralizedType;
	}

	/**
	 * @param centralizedType the centralizedType to set
	 */
	public void setCentralizedType(String centralizedType) {
		this.centralizedType = centralizedType;
	}

	/**
	 * @return the msgErr
	 */
	public String getMsgErr() {
		return msgErr;
	}

	/**
	 * @param msgErr the msgErr to set
	 */
	public void setMsgErr(String msgErr) {
		this.msgErr = msgErr;
	}

	/**
	 * @return the isPass
	 */
	public String getIsPass() {
		return isPass;
	}

	/**
	 * @param isPass the isPass to set
	 */
	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}

	/**
	 * @return the submitHighTechAcceptanceList
	 */
	public List<Map<String, Object>> getSubmitHighTechAcceptanceList() {
		return submitHighTechAcceptanceList;
	}

	/**
	 * @param submitHighTechAcceptanceList the submitHighTechAcceptanceList to set
	 */
	public void setSubmitHighTechAcceptanceList(
			List<Map<String, Object>> submitHighTechAcceptanceList) {
		this.submitHighTechAcceptanceList = submitHighTechAcceptanceList;
	}

	/**
	 * @return the submitOtherAcceptanceList
	 */
	public List<Map<String, Object>> getSubmitOtherAcceptanceList() {
		return submitOtherAcceptanceList;
	}

	/**
	 * @param submitOtherAcceptanceList the submitOtherAcceptanceList to set
	 */
	public void setSubmitOtherAcceptanceList(
			List<Map<String, Object>> submitOtherAcceptanceList) {
		this.submitOtherAcceptanceList = submitOtherAcceptanceList;
	}

	/**
	 * @return the submitFlag
	 */
	public String getSubmitFlag() {
		return submitFlag;
	}

	/**
	 * @param submitFlag the submitFlag to set
	 */
	public void setSubmitFlag(String submitFlag) {
		this.submitFlag = submitFlag;
	}

}

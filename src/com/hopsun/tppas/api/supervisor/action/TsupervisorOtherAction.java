/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.supervisor.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Tattachment;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.entity.TcontractContentsB;
import com.hopsun.tppas.entity.TcontractCoverA;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectInfoA;
import com.hopsun.tppas.entity.TprojectInfoB;
import com.hopsun.tppas.entity.TprojectType;
import com.hopsun.tppas.entity.Tsupervisor;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TattachmentService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.api.supervisor.service.TsupervisorService;
import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 *@comments 其它处室项目监理
 *@author wangxiaodong
 *@date 2013-8-6
 *@version 1.0
 */
public class TsupervisorOtherAction extends BaseAction{
  
	private static final long serialVersionUID = -8298763729920402555L;
	
	/**项目监理service*/
	@Resource
	private TsupervisorService tsupervisorService;
	
	/**项目申报service*/
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	
	/**项目分类信息Bservice*/
	@Resource
	private TprojectTypeService tprojectTypeService;
	
	/** 附件上传service*/
	@Resource
	private TattachmentService tattachmentService;
	
	/** 码表*/
	@Resource
	private MitemService apiMitemService;
	
	/**监理ID**/
	private String supervisorId;
	
	/**项目ID**/
	private String projectId;
	
	/**项目监理**/
	private Tsupervisor tsupervisor;
	
	/**项目信息**/
	private TprojectApplication tprojectApplication;
	
	/**项目基本信息**/
	private TprojectInfoA tprojectInfoA;
	
	/** 跳转页码 */
	private int pageNo;
	
	/** 跳转路径**/
	private String retUrl;

	/** 跳转页面massage**/
	private String retMsg;
	
	/** 表名 */
	private String tableName;
	
	/** 文件类型 */
	private String fileType;
	
	/** 附件顺序 */
	private String sequence;
	
	/** 附件id */
	private String attachmentId;
	
	/** 附件对象 */
	private Tattachment tattachment;
	
	/**材料类型是否都有*/
	private String isPass = "1";
	
	/**提交监理申请前业务数据是否存在集合*/
    private List<Map<String,Object>> submitList;
    
    /**判断是修改还是查看*/
    private String isEdit;
    
    /**项目基本信息B*/
    private TprojectInfoB tprojectInfoB;
    
    /**详细信息左边菜单*/
	private List<Mitem> menuList;
	
	/**合同封面对象*/
	private TcontractCoverA tcontractCoverA;
	
	/**合同内容对象*/
	private TcontractContentsB  tcontractContentsB;
	
	/**监理意见*/
	private String tsupervisorInfo;
	
	/**监理审批状态*/
	private String supervisorState;
	
	
	/**
	 * 其它初始项目监理详细信息
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getOtherManager(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
    	//详细信息时左边菜单
		menuList =  apiMitemService.getMitemListById(Constants.TSUPERVISOR_ADMIN_OTHER_TYPE);
    	
    	// 页面跳转
		return "otherManager";
	}
	
	/**
	 * 得到监理申请封面信息
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getCoverInfo(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
    	
    	//得到项目申报信息
    	tprojectApplication = tprojectApplicationService.get(projectId);
    	//封装项目计划类别
    	String planFlag = tprojectApplication.getPlanFlag();
    	if(planFlag!=null&&planFlag.length()>0){
    		TprojectType tprojectType = tprojectTypeService.get(planFlag);
    		if(tprojectType!=null){
    			tprojectApplication.setPlanFlag(tprojectType.getTypeRealName());
    		}
    	}
    	//封装归口管理单位
    	String gkdw = tprojectApplication.getCentralizedType();
    	if(gkdw!=null&&gkdw.length()>0){
    		Mitem mitem =  apiMitemService.get(gkdw);
    		if(mitem!=null){
    			tprojectApplication.setCentralizedType(mitem.getItemName());
    		}
    	}
    	
    	//项目基本信息B
    	List<TprojectInfoB>  all = tprojectApplication.getTprojectInfoBs();
    	if(all!=null&&all.size()>0){
    		tprojectInfoB = all.get(0);
    		if(tprojectInfoB!=null){
    			Mitem mitem = new Mitem();
    			StringBuffer addressStr = new StringBuffer();
    			if(tprojectInfoB.getRegionId1()!=null&&tprojectInfoB.getRegionId1().length()>0){
    				mitem = apiMitemService.get(tprojectInfoB.getRegionId1());
    				addressStr.append(mitem.getItemName());
    				if(tprojectInfoB.getRegionId2()!=null&&tprojectInfoB.getRegionId2().length()>0){
        				mitem = apiMitemService.get(tprojectInfoB.getRegionId2());
        				addressStr.append(mitem.getItemName());
        				if(tprojectInfoB.getRegionId3()!=null&&tprojectInfoB.getRegionId3().length()>0){
            				mitem = apiMitemService.get(tprojectInfoB.getRegionId3());
            				addressStr.append(mitem.getItemName());
            			}
        			}
    			}
    			addressStr.append(tprojectInfoB.getUnitAddress());
    			tprojectInfoB.setUnitAddress(addressStr.toString());
    		}
    	}
    	
    	//合同相关数据
    	List<Tcontract> tcontractList = tprojectApplication.getTcontracts();
    	if(tcontractList!=null&&tcontractList.size()>0){
    		Tcontract tcontract = tcontractList.get(0);
    		//合同封面
    		List<TcontractCoverA> tcontractCoverAList = tcontract.getTcontractCoverAs();
    		if(tcontractCoverAList!=null&&tcontractCoverAList.size()>0){
    			tcontractCoverA = tcontractCoverAList.get(0);
    		}else{
    			tcontractCoverA = new TcontractCoverA();
    		}
    		//合同内容
    		List<TcontractContentsB> TcontractContentsBList = tcontract.getTcontractContentsBs();
    		if(TcontractContentsBList!=null&&TcontractContentsBList.size()>0){
    			tcontractContentsB = TcontractContentsBList.get(0);
    		}else{
    			tcontractContentsB = new TcontractContentsB();
    		}
    	}
    	
    	//监理信息
    	tsupervisor = tsupervisorService.get(supervisorId);
    	
    	return "coverInfo";
	}
	/**
	 * 封面信息保存或下一步
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String saveOrNextCover(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
    	
    	//是保存还是下一步  0-保存    1-下一步
    	String optType = this.getParameter("optType");
    	
    	//封面保存或修改
    	Tsupervisor  oldTsupervisor= tsupervisorService.get(supervisorId);
    	oldTsupervisor.setWritePerson(tsupervisor.getWritePerson());
    	oldTsupervisor.setWriteTel(tsupervisor.getWriteTel());
    	oldTsupervisor.setWriteMobile(tsupervisor.getWriteMobile());
    	tsupervisorService.update(oldTsupervisor);
    	
    	//保存跳转
    	if(optType.equals("0")){
    		//提示操作信息
    		this.setRetMsg(this.getText("opt_save_suc"));
    		//跳转到封面页面
    		this.setRetUrl(super.getRequest().getContextPath()+ "/api/supervisor/supervisorOtherAction!getOtherManager.action?supervisorId="
    				+ supervisorId+"&projectId="+projectId+"&now="+ new Date().getTime());
    		return "systemInfo";
    	}else{//下一步跳转
    		//提示操作信息
    		this.setRetMsg(this.getText("opt_save_suc"));
    		//跳转到封面页面
    		this.setRetUrl(super.getRequest().getContextPath()+ "/api/supervisor/supervisorOtherAction!getComment.action?supervisorId="
    				+ supervisorId+"&projectId="+projectId+"&isEdit="+isEdit+"&now="+ new Date().getTime());
    	}
    	
		return "systemInfoNext";
	}
	
	/**
	 * 进入填表说明页面
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getComment(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
    	
		return "commentInfo";
	}
	
	/**
	 * 填表说明下一步
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String nextComment(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
	
		return "fundBInfo";
	}
	
	/**
	 * 进入项目承担单位真实性承诺
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getPromise(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
    	
		return "promiseInfo";
	}
	
	/**
	 * 
	 * @comments  附件列表
	 * @return
	 * @version 1.0
	 */
	public String showIndexList() {
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 设置分页参数
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}

		// 取得表名
		this.tableName = tattachmentService.getTableName(Tsupervisor.class);
		// 取得附件列表
		pager = tattachmentService.find(tableName, supervisorId,pager.getPageNumber(), pager.getPageSize());
		
		return "showIndexList";
	}
	
	/**
	 * @comments 附件上传页面初始化
	 * @return
	 * @version 1.0
	 */
	public String showIndexInsert() {
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
    	
		// 取得可上传的文件类型
		Mitem mitem = apiMitemService.get(Constants.FILE_UPLOAD_TYPE);
		if (mitem != null) {
			this.fileType = mitem.getItemDesc();
		}

		// 取得最大的序号+1
		this.sequence = tattachmentService.getMaxSequence(tableName,supervisorId);

		return "showIndexInsert";
	}
	
	/**
	 * @comments 附件上传、修改画面
	 * @return
	 * @version 1.0
	 */
	public String showIndexUpdate(){
		this.tattachment = tattachmentService.get(attachmentId);
		return "showIndexUpdate";
	}
	
	public String showIndexNext(){
		
		return "showIndexNext";
	}

	/**
	 * 提交项目监理前得到各项业务数据是否有
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String getOtherSubmitInfoList(){
		
		tsupervisor = tsupervisorService.get(supervisorId);
		submitList = tsupervisorService.getOtherSubmitInfoList(supervisorId);
		StringBuffer str = new StringBuffer();
		for(int i=0;i<submitList.size();i++){
			Map<String,Object> map = submitList.get(i);
			//材料类型没有
			if(map.get("isPass").equals("0")){
				str.append(map.get("name"));
				str.append("、");
				isPass = "0";
			}
		}
		String strString = str.toString();
		if(strString!=null&&strString.length()>0){
			retMsg = strString.substring(0, strString.length()-1);
		}
		return "submitList";
	}
	
	/**
	 * 其他处室项目监理审核
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String submitOtherSupervisor(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
    	
    	/*String pdfInputPath = apiMitemService.get(Constants.PDF_TEMPLATE_PATH).getItemDesc();
		String pdfOutputPath = apiMitemService.get(Constants.PDF_STORAGE_PATH).getItemDesc();
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
		tsupervisorService.saveOtherSupervisor(pdfInputPath, pdfOutputPath,supervisorId,user.getUserId());*/
		Map<String,Object> valueMap = new HashMap<String,Object>();
		valueMap.put("supervisorId",supervisorId);
		valueMap.put("tsupervisorInfo",tsupervisorInfo);
		valueMap.put("supervisorState",supervisorState);
		valueMap.put("user",user);
		tsupervisorService.saveSupervisorAudit(valueMap);
		
		this.setRetMsg(String.valueOf(this.getText("opt_save_suc")));
		this.setRetUrl(this.getRequest().getContextPath()
				+ "/api/supervisor/tsupervisorAction!supervisorManager.action?now=" + new Date().getTime());
		
		return "systemInfoMain";
	}

	public String getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Tsupervisor getTsupervisor() {
		return tsupervisor;
	}

	public void setTsupervisor(Tsupervisor tsupervisor) {
		this.tsupervisor = tsupervisor;
	}

	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	public TprojectInfoA getTprojectInfoA() {
		return tprojectInfoA;
	}

	public void setTprojectInfoA(TprojectInfoA tprojectInfoA) {
		this.tprojectInfoA = tprojectInfoA;
	}

	public String getRetUrl() {
		return retUrl;
	}

	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	public Tattachment getTattachment() {
		return tattachment;
	}

	public void setTattachment(Tattachment tattachment) {
		this.tattachment = tattachment;
	}

	public String getIsPass() {
		return isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}

	public List<Map<String, Object>> getSubmitList() {
		return submitList;
	}

	public void setSubmitList(List<Map<String, Object>> submitList) {
		this.submitList = submitList;
	}

	public String getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}

	public TprojectInfoB getTprojectInfoB() {
		return tprojectInfoB;
	}

	public void setTprojectInfoB(TprojectInfoB tprojectInfoB) {
		this.tprojectInfoB = tprojectInfoB;
	}

	public List<Mitem> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Mitem> menuList) {
		this.menuList = menuList;
	}

	public TcontractCoverA getTcontractCoverA() {
		return tcontractCoverA;
	}

	public void setTcontractCoverA(TcontractCoverA tcontractCoverA) {
		this.tcontractCoverA = tcontractCoverA;
	}

	public TcontractContentsB getTcontractContentsB() {
		return tcontractContentsB;
	}

	public void setTcontractContentsB(TcontractContentsB tcontractContentsB) {
		this.tcontractContentsB = tcontractContentsB;
	}

	public String getTsupervisorInfo() {
		return tsupervisorInfo;
	}

	public void setTsupervisorInfo(String tsupervisorInfo) {
		this.tsupervisorInfo = tsupervisorInfo;
	}

	public String getSupervisorState() {
		return supervisorState;
	}

	public void setSupervisorState(String supervisorState) {
		this.supervisorState = supervisorState;
	}
}
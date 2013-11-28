package com.hopsun.tppas.api.contract.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.api.dept.service.DeptService;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.contract.service.TcontractService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TattachmentService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeManagerService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.entity.TprojectType;

public class TcontractAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(TcontractAction.class.getName());
	
	private static final long serialVersionUID = -348199813121685455L;
	@Resource
	private TcontractService tcontractService;
	@Resource
	private TprojectTypeManagerService tprojectTypeManagerService;
	
	@Resource
	private MitemService mitemService;
	
	@Resource
	private DeptService deptService;
	
	@Resource
	private TprojectTypeService tprojectTypeService;
	
	@Resource
	private TattachmentService tattachmentService;
	
	// 合同列表
	private List<Tcontract> TcontractList;
	//合同管理表
	private Tcontract tcontract;
	//分页nomber
	private int pageNo;
	//合同ID
	private String tcontractId;

	//项目名称(查询条件)
	private String projectName;
	//申报单位(查询条件)
	private String applicationUnit;
	//合同状态(查询条件)
	private String contractStatus;
	//部门id
	private String deptId;
	//计财处分类
	private String planningFlag;
	//项目分类
	private String typeId1;
	private String typeId2;
	//合同状态List
	private List<Mitem> contractStatusList = new ArrayList<Mitem>();
	//合同类别List
	private List<Mitem> contractTypeList = new ArrayList<Mitem>();
	// 项目分类
	private List<TprojectType> typeId1List;
	private List<TprojectType> typeId2List;
	//跳转路径
	private String retUrl;
	//跳转页面message
	private String retMsg;
	//按钮是否显示标记
	private String Flag;
	//下发合同按钮是否显示
	private String userFlag;
	/** 表名 */
	private String tableName;
	/** 文件类型 */
	private String fileType;
	/** 附件顺序 */
	private String sequence;
	/** 下拉列表联动返回字符串 */
	private String backStr;
	private String pitemId;
	/** 菜单List */ 
	private List<Mitem> menuList;
	/**委托单位（甲方）*/
	private String entrustmentCompany;
	//审核意见
	private String approvalOpinion;
	//左边菜单
	private List<Map<String,Object>> submitList;
	private String isPass;
	private String contractType;
	  
	public String list(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 设置令牌
    	session.setAttribute(Constants.SESSION_CMDKEY, "contract");
		
    	// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
		
	   	// 合同状态
    	contractStatusList = new ArrayList<Mitem>();
		contractStatusList.addAll(mitemService.getMitemListById(Constants.TYPE_CONTRACT_STATE));
		//去掉前两个状态
    	if(contractStatusList.size() > 2){
    		contractStatusList.remove(0);
    		contractStatusList.remove(0);
    	}
    	
    	// 取得部门ID
    	if(user.getScDept() != null && user.getScDept().getDeptId() != null && !"".equals(user.getScDept().getDeptId())){
    		deptId = user.getScDept().getDeptId();
    	} else {
    		logger.error("部门不存在！");
			return "LogOut";
    	}
    	// 初始化项目分类List
    	this.typeId1List = new ArrayList<TprojectType>();
    	this.typeId2List = new ArrayList<TprojectType>();
    	this.typeId1List = tprojectTypeManagerService.getProjectTypeListByUser(user);
		return "init";
	}
	
	/**
	 * 
	 * @comments 查询列表
	 * @return
	 * @version 1.0
	 */
	public String queryList(){
    	// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 取得部门ID
    	if(user.getScDept() != null && user.getScDept().getDeptId() != null && !"".equals(user.getScDept().getDeptId())){
    		deptId = user.getScDept().getDeptId();
    	}
    	
    	Map<String,Object> param = new HashMap<String,Object>();
    	//业务处
//    	if(Constants.PLANNING_DEPARTMENT.equals(deptId)){
//    		param.put("deptId",null);
//    	}
//    	else{
//    		param.put("deptId",deptId);
//    	}
    	param.put("jhlb", tprojectTypeManagerService.getProjectTypeStrByUser(user));
		param.put("projectName",projectName);
		param.put("applicationUnit",applicationUnit);
		param.put("contractStatus",contractStatus);
		param.put("typeId1",typeId1);
		param.put("typeId2",typeId2);
	
		// 设置分页参数
    	if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		}
    	else{
    		pager = new Pager();
    		pager.setPageNumber(this.getPageNo());
    	}
    	// 取得项目验收一览信息
    	pager = tcontractService.find(param, pager.getPageNumber(), pager.getPageSize());
		if(Constants.PLANNING_DEPARTMENT.equals(deptId)){
			userFlag = "1";
		}else{
			userFlag = "0";
		}
		return "list";
	}
	
	/**
	 * 
	 * @comments  进入合同填报步骤画面
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */
	public String importTcontract() throws Exception{
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
		//更新合同状态为审核中
    	tcontract = tcontractService.get(this.tcontractId);
//    	if (this.tcontract.getContractStatus() != null){
//	    	if (this.tcontract.getContractStatus().equals(Constants.CONTRACT_STATE_SUBMIT)){
//			tcontractService.updateStatus(this.tcontractId,user.getUserId());
//	    	}
//    	}
		//取得合同填报步骤的菜单名
		this.menuList = mitemService.getListByTypeId(Constants.API_CONTRACT_MENU_NONTECH_TYPE);
		//设置画面是否可编辑的标记(计财处不可编辑，业务处可编辑)
		// 取得用户的部门ID
		String deptId = user.getScDept().getDeptId();

		if (Constants.PLANNING_DEPARTMENT.equals(deptId)) {
			//计财处
			this.Flag = "1";
		} else {
			// 计财处以外的部门
			this.Flag = "0";
		}
    	
    	return "Detailmanage";
	}


	/**
	 * 
	 * @comments 判断画面是否能修改 
	 * @param Type
	 * @return
	 * @version 1.0
	 */
	public String getflg(String Type){
		String flg = "";
		 if (Type.equals(Constants.CONTRACT_STATE_NOISSUED)){
			 flg= "0";
		 }
		 else if (Type.equals(Constants.CONTRACT_STATE_ISSUED)){
			 flg= "1";
		 }
		return flg;
	}
	
	/**
	 * 
	 * @comments  进入填表说明画面
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */
	public String initKnow() throws Exception{
    	return "initKnow";
	}
	
	/**
	 * 
	 * @comments 附件清单
	 * @return
	 * @version 1.0
	 */
	public String showIndexList(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}

    	// 设置分页参数
    	if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		}
    	else{
    		pager = new Pager();
    		pager.setPageNumber(this.getPageNo());
    	}
    	
    	// 取得合同管理ID
    	this.tcontractId = this.getTcontractId();
    	
    	// 取得表名
    	this.tableName = tattachmentService.getTableName(Tcontract.class);
    	// 取得附件一览信息
    	pager = tattachmentService.find(tableName, tcontractId, pager.getPageNumber(), pager.getPageSize());
		return "showIndexList";
	}
	
	
	/**
	 * @comments 合同审核画面初始化
	 * @return
	 * @version 1.0
	 */
	public String importSubmit(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
		tcontract = tcontractService.get(this.tcontractId);
//		if (!Constants.CONTRACT_STATE_SUBMIT.equals(tcontract.getContractStatus()) 
//				&&  !Constants.CONTRACT_STATE_VERIFY.equals(tcontract.getContractStatus())){
//			this.Flag = "0";
//		}
		approvalOpinion = this.tcontract.getApprovalOpinion();
		return "submitList";
	}
	
	/**
	 * 
	 * @comments 合同保存
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */	
	public String statusSave() throws Exception{
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
    	
    	tcontract = tcontractService.get(tcontractId);
    	tcontract.setApprovalOpinion(approvalOpinion);
		tcontractService.update(tcontract);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tcontract!list.action?now=" +  new Date().getTime());
    	return "systemInfoMain";
	}

	/**
	 * 
	 * @comments 合同签订 
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */
	public String statusOk() throws Exception{
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
    	
		tcontractService.updateStatusOk(this.tcontractId,user.getUserId(),approvalOpinion);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tcontract!list.action?now=" +  new Date().getTime());
    	return "systemInfoMain";
	}
	
	/**
	 * 
	 * @comments 合同不通过 （可修改）
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */
	public String statusNo() throws Exception{
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
    	
		tcontractService.updateStatusNo(this.tcontractId,user.getUserId(),approvalOpinion);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tcontract!list.action?now=" +  new Date().getTime());
    	return "systemInfoMain";
	}
	
	/**
	 * 
	 * @comments 合同不通过 （不可修改）
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */
	public String statusNoModify() throws Exception{
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
    	
		tcontractService.updateStatusNoModify(this.tcontractId,user.getUserId(),approvalOpinion);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tcontract!list.action?now=" +  new Date().getTime());
    	return "systemInfoMain";
	}
	
	
	/**
	 * @comments 合同下发按钮按下
	 * @return
	 * @version 1.0
	 */
	public String issuedContract(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
    	tcontractService.updateIssuedContract(this.tcontractId,user.getUserId(),contractType);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tcontract!list.action?now=" +  new Date().getTime());
    	return "systemInfoMain";
	}
	
	/**
	 * @comments 合同类型变更
	 * @return
	 * @version 1.0
	 */
	public String typeChange(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
    	tcontractService.updateType(this.tcontractId,user.getUserId(),contractType);
    	this.setRetMsg(this.getText("opt_type_change"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tcontract!list.action?now=" +  new Date().getTime());
    	return "systemInfoMain";
	}
	
	public TattachmentService getTattachmentService() {
		return tattachmentService;
	}

	public void setTattachmentService(TattachmentService tattachmentService) {
		this.tattachmentService = tattachmentService;
	}

	public List<Map<String, Object>> getSubmitList() {
		return submitList;
	}

	public void setSubmitList(List<Map<String, Object>> submitList) {
		this.submitList = submitList;
	}

	public String getIsPass() {
		return isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}

	public TcontractService getTcontractService() {
		return tcontractService;
	}

	public void setTcontractService(TcontractService tcontractService) {
		this.tcontractService = tcontractService;
	}

	public MitemService getMitemService() {
		return mitemService;
	}

	public void setMitemService(MitemService mitemService) {
		this.mitemService = mitemService;
	}

	public TprojectTypeService getTprojectTypeService() {
		return tprojectTypeService;
	}

	public void setTprojectTypeService(TprojectTypeService tprojectTypeService) {
		this.tprojectTypeService = tprojectTypeService;
	}

	public List<Tcontract> getTcontractList() {
		return TcontractList;
	}

	public void setTcontractList(List<Tcontract> tcontractList) {
		TcontractList = tcontractList;
	}

	public Tcontract getTcontract() {
		return tcontract;
	}

	public void setTcontract(Tcontract tcontract) {
		this.tcontract = tcontract;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getTcontractId() {
		return tcontractId;
	}

	public void setTcontractId(String tcontractId) {
		this.tcontractId = tcontractId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getApplicationUnit() {
		return applicationUnit;
	}

	public void setApplicationUnit(String applicationUnit) {
		this.applicationUnit = applicationUnit;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}


	public String getTypeId1() {
		return typeId1;
	}

	public void setTypeId1(String typeId1) {
		this.typeId1 = typeId1;
	}

	public String getTypeId2() {
		return typeId2;
	}

	public void setTypeId2(String typeId2) {
		this.typeId2 = typeId2;
	}

	public List<Mitem> getContractStatusList() {
		return contractStatusList;
	}

	public void setContractStatusList(List<Mitem> contractStatusList) {
		this.contractStatusList = contractStatusList;
	}

	public List<Mitem> getContractTypeList() {
		return contractTypeList;
	}

	public void setContractTypeList(List<Mitem> contractTypeList) {
		this.contractTypeList = contractTypeList;
	}


	public List<TprojectType> getTypeId1List() {
		return typeId1List;
	}

	public void setTypeId1List(List<TprojectType> typeId1List) {
		this.typeId1List = typeId1List;
	}

	public List<TprojectType> getTypeId2List() {
		return typeId2List;
	}

	public void setTypeId2List(List<TprojectType> typeId2List) {
		this.typeId2List = typeId2List;
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

	public String getFlag() {
		return Flag;
	}

	public void setFlag(String flag) {
		Flag = flag;
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

	public String getBackStr() {
		return backStr;
	}

	public void setBackStr(String backStr) {
		this.backStr = backStr;
	}

	public String getPitemId() {
		return pitemId;
	}

	public void setPitemId(String pitemId) {
		this.pitemId = pitemId;
	}

	public List<Mitem> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Mitem> menuList) {
		this.menuList = menuList;
	}

	public String getEntrustmentCompany() {
		return entrustmentCompany;
	}

	public void setEntrustmentCompany(String entrustmentCompany) {
		this.entrustmentCompany = entrustmentCompany;
	}

	public String getApprovalOpinion() {
		return approvalOpinion;
	}

	public void setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion = approvalOpinion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getPlanningFlag() {
		return planningFlag;
	}

	public void setPlanningFlag(String planningFlag) {
		this.planningFlag = planningFlag;
	}

	public static Logger getLogger() {
		return logger;
	}

	public String getUserFlag() {
		return userFlag;
	}

	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	
	
}

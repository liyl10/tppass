package com.hopsun.tppas.api.contract.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.contract.service.TcontractHighTechService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.CompanyInfoBean;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Tattachment;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TattachmentService;
import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class TcontractHighTechAction extends BaseAction{
  
	public final static Logger logger = Logger.getLogger(TcontractHighTechAction.class.getName());
	
	private static final long serialVersionUID = 174290278644710164L;
	
	@Resource
	private TcontractHighTechService tcontractHighTechService;
	
	@Resource
	private TattachmentService tattachmentService;
	
	@Resource
	private MitemService mitemService;

	// 合同列表
	private List<Tcontract> TcontractList;
	//分页nomber
	private int pageNo;
	//合同id
	private String tcontractId;
	//合同管理
	private Tcontract tcontract;
	//合同填报步骤
	private List<Map<String, String>> contractStep;
	//合同类型
	private String contractType;
	//模板类型
	private String modelType;
	//合同状态
	private String contractStatus;
	
	private List<Mitem> address1List;
	
	private List<Mitem> address2List;
	
	private List<Mitem> address3List;
	
	private String retUrl;
	
	private String retMsg;
	//按钮是否显示标记
	private String Flag;
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
	
	/**合同提交材料集合*/
	private List<Map<String,Object>> submitList;
	/**材料类型是否都有*/
	private String isPass = "1";
	/**委托单位*/
	private String entrustmentCompany;
	/**合同封皮备注*/
	private String contractComment;
	/** 附件id */
	private String attachmentId;
	/** 附件表 */
	private Tattachment tattachment;
	/** 
	 * 
	 */
	private String projectId;
	private String approvalOpinion;
	
//	/**
//	 * 合同填报列表
//	 * @comments 
//	 * @return
//	 * @version 1.0
//	 */
//	public String execute(){
//		// 取得登录用户的信息
//    	HttpSession session = this.getRequest().getSession();
//    	CompanyInfoBean companyInfoBean= (CompanyInfoBean) session.getAttribute(Constants.SESSION_COMPANYINFO);
///*	    if (companyInfoBean == null 
//	    		|| ("").equals(companyInfoBean.getPkUoiId())) {
//	      return "LogOut";
//	     }*/
//    	 // 设置令牌
//    	session.setAttribute(Constants.SESSION_CMDKEY, "contract");
//    	// 设置分页参数
//		if (pager == null && this.getPageNo() == 0) {
//			pager = new Pager();
//		} 
//		else {
//			pager = new Pager();
//			pager.setPageNumber(this.getPageNo());
//		}
//		//pager = tcontractService.getContractList(companyInfoBean.getPkUoiId(), pager.getPageNumber(), pager.getPageSize());
//		pager = tcontractService.getContractList("1", pager.getPageNumber(), pager.getPageSize());
//		return "list";
//	}
	
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
    	tcontract = tcontractHighTechService.get(this.tcontractId);
//    	if (this.tcontract.getContractStatus() != null){
//	    	if (this.tcontract.getContractStatus().equals(Constants.CONTRACT_STATE_SUBMIT)){
//	    		tcontractHighTechService.updateStatus(this.tcontractId,user.getUserId());
//	    	}
//    	}
		//取得合同填报步骤的菜单名
		this.menuList = mitemService.getListByTypeId(Constants.API_CONTRACT_MENU_NONTECH_TYPE);
    	if (Constants.CONTRACT_TYPE_FREE.equals(tcontract.getContractType())){
    		this.menuList = mitemService.getListByTypeId(Constants.API_CONTRACT_MENU_TYPE);
    	}
    	else{
    		this.menuList = mitemService.getListByTypeId(Constants.API_CONTRACT_MENU_TYPE,Constants.API_CONTRACT_MENU_03,Constants.API_CONTRACT_MENU_04);
    	}
		//设置画面是否可编辑的标记
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
	
	
//	/**
//	 * 
//	 * @comments 判断画面是否能修改 
//	 * @param Type
//	 * @return
//	 * @version 1.0
//	 */
//	public String getflg(String Type){
//		String flg = "";
//		 if (Type.equals(Constants.CONTRACT_STATE_SIGNED) 
//				|| Type.equals(Constants.CONTRACT_STATE_NOTPASS_MODIFI) 
//				|| Type.equals(Constants.CONTRACT_STATE_NOTPASS_NOMODIFY)){
//			flg= "0";
//		 }
//		return flg;
//	}
	
	/**
	 * @comments 跳转到说明画面
	 * @return
	 * @version 1.0
	 */
	public String importDescription(){
		return "description";
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
    	CompanyInfoBean companyInfoBean= (CompanyInfoBean) session.getAttribute(Constants.SESSION_COMPANYINFO);
    	// 设置令牌
    	session.setAttribute(Constants.SESSION_CMDKEY, "index");
    	if (companyInfoBean == null 
    			|| ("").equals(companyInfoBean.getPkUoiId())) {
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
	 * @comments 提交合同前得到各项材料是否有
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
		tcontract = tcontractHighTechService.get(this.tcontractId); 
//		if (!Constants.CONTRACT_STATE_SUBMIT.equals(tcontract.getContractStatus()) 
//				&&  !Constants.CONTRACT_STATE_VERIFY.equals(tcontract.getContractStatus())){
//			this.Flag = "0";
//		}
		approvalOpinion = this.tcontract.getApprovalOpinion();
		return "submitList";
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
    	tcontractHighTechService.updateStatusOk(this.tcontractId,user.getUserId(),approvalOpinion);
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
    	tcontractHighTechService.updateStatusNo(this.tcontractId,user.getUserId(),approvalOpinion);
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
    	tcontractHighTechService.updateStatusNoModify(this.tcontractId,user.getUserId(),approvalOpinion);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tcontract!list.action?now=" +  new Date().getTime());
    	return "systemInfoMain";
	}

	/**
	 * 修改信息
	 * @return String
	 */
	public String updateDept(){
		
		return SUCCESS;
			
	}
	
	/**
	 * 跳转到修改页面
	 * @return String
	 */
	public String modify(){
		return "modify";
	}
	

	public TcontractHighTechService getTcontractHighTechService() {
		return tcontractHighTechService;
	}


	public void setTcontractHighTechService(
			TcontractHighTechService tcontractHighTechService) {
		this.tcontractHighTechService = tcontractHighTechService;
	}


	public TattachmentService getTattachmentService() {
		return tattachmentService;
	}

	public void setTattachmentService(TattachmentService tattachmentService) {
		this.tattachmentService = tattachmentService;
	}

	public MitemService getMitemService() {
		return mitemService;
	}

	public void setMitemService(MitemService mitemService) {
		this.mitemService = mitemService;
	}

	public List<Tcontract> getTcontractList() {
		return TcontractList;
	}

	public void setTcontractList(List<Tcontract> tcontractList) {
		TcontractList = tcontractList;
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

	public Tcontract getTcontract() {
		return tcontract;
	}

	public void setTcontract(Tcontract tcontract) {
		this.tcontract = tcontract;
	}

	public List<Map<String, String>> getContractStep() {
		return contractStep;
	}

	public void setContractStep(List<Map<String, String>> contractStep) {
		this.contractStep = contractStep;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public List<Mitem> getAddress1List() {
		return address1List;
	}

	public void setAddress1List(List<Mitem> address1List) {
		this.address1List = address1List;
	}

	public List<Mitem> getAddress2List() {
		return address2List;
	}

	public void setAddress2List(List<Mitem> address2List) {
		this.address2List = address2List;
	}

	public List<Mitem> getAddress3List() {
		return address3List;
	}

	public void setAddress3List(List<Mitem> address3List) {
		this.address3List = address3List;
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

	public String getEntrustmentCompany() {
		return entrustmentCompany;
	}

	public void setEntrustmentCompany(String entrustmentCompany) {
		this.entrustmentCompany = entrustmentCompany;
	}

	public String getContractComment() {
		return contractComment;
	}

	public void setContractComment(String contractComment) {
		this.contractComment = contractComment;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}


	public String getApprovalOpinion() {
		return approvalOpinion;
	}


	public void setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion = approvalOpinion;
	}


	public static Logger getLogger() {
		return logger;
	}
	
	
}

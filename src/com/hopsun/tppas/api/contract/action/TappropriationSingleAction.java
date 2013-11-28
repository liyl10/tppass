package com.hopsun.tppas.api.contract.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.contract.service.TappropriationSingleService;
import com.hopsun.tppas.api.contract.service.TcontractContentsAService;
import com.hopsun.tppas.api.contract.service.TcontractContentsBService;
import com.hopsun.tppas.api.contract.service.TcontractService;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TappropriationSingle;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.entity.TcontractContentsA;
import com.hopsun.tppas.entity.TcontractContentsB;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectType;

public class TappropriationSingleAction extends BaseAction{

	private static final long serialVersionUID = 3232901371011005982L;
	@Resource
	private TappropriationSingleService tappropriationSingleService;
	
	@Resource 
	private TcontractContentsAService tcontractContentsAService;
	
	@Resource 
	private TcontractContentsBService tcontractContentsBService;
	
	@Resource
	private TcontractService tcontractService;
//	
	private TcontractContentsA tcontractContentsA;
	
	private TcontractContentsB tcontractContentsB;
	
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	
	@Resource
	private TprojectTypeService tprojectTypeService;
	
	private TappropriationSingle tappropriationSingle;
	
	private TprojectApplication tprojectApplication;
	//分页nomber
	private int pageNo;
	//合同id
	private String tcontractId;
	//合同表
	private Tcontract tcontract;
	//项目类型表
	private TprojectType tprojectType;
	//高新还是非高新
	private String highOrOtherFlag;
	//新增还是更新
	private String insertOrUpdateFlag;

	private String retUrl;
	
	private String retMsg;	
	
	private String mainFlag ;
	
	//拨款单id
	private String appropriationSingleId;
	
	
	public String init(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
	    if (user == null 
	    		|| ("").equals(user.getUserId())) {
	      return "LogOut";
	     }
    	 // 设置令牌
    	session.setAttribute(Constants.SESSION_CMDKEY, "TappropriationSingle");

    	// 设置分页参数
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} 
		else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}
		pager = tappropriationSingleService.getTappropriationSingleList(this.tcontractId, pager.getPageNumber(), pager.getPageSize());
		tcontract = tcontractService.get(tcontractId);
		highOrOther(tcontract.getTprojectApplication().getProjectId());
		return "init";
	}
	
	/**
	 * 跳转到添加页面
	 * @return String
	 */
	public String insert(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		tcontract = tcontractService.get(tcontractId);
		insertOrUpdateFlag = "1";
		tappropriationSingle = new TappropriationSingle();
		tappropriationSingle.setTasksEntrusted(tcontract.getTprojectApplication().getProjectName());
		tappropriationSingle.setUndertaker(tcontract.getTprojectApplication().getApplicationUnit());
		highOrOther(tcontract.getTprojectApplication().getProjectId());
		//高新处
		if ("1".equals(highOrOtherFlag)){
			TcontractContentsA contentsA = tcontractContentsAService.get("tcontract.TContractId", tcontractId);
			if (contentsA != null){
				tappropriationSingle.setBank(contentsA.getBank());
				tappropriationSingle.setAccount(contentsA.getBankAccount());
				tappropriationSingle.setPlanFunding(contentsA.getPartySubsidizePartyb().doubleValue());
				tappropriationSingle.setAmountFunding(0);
			}
		}
		//非高新处
		else{
			TcontractContentsB contentsB = tcontractContentsBService.get("tcontract.TContractId", tcontractId);
			if (contentsB != null){
				tappropriationSingle.setBank(contentsB.getBank());
				tappropriationSingle.setAccount(contentsB.getBankAccount());
				tappropriationSingle.setPlanFunding(0);
				tappropriationSingle.setAmountFunding(0);
			}
		}
		return "insertOrupdate";
	}
	
	/**
	 * 新增拨款单
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String inserttappropriationSingle(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
    	//保存项目经费使用表的信息TODO
		tappropriationSingleService.savetappropriationSingle(this.tappropriationSingle,this.tcontractId);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tappropriationSingle!init.action?tcontractId="+ this.tcontractId + "&mainFlag=" + this.mainFlag
				+"&now=" +  new Date().getTime());
		if (("1").equals(mainFlag)){
			return "systemInfoMain";	
		}
		else{
			return "systemInfo";	
		}
    	
			
	}	
	
	/**
	 * 跳转到添加页面
	 * @return String
	 */
	public String update(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		tcontract = tcontractService.get(tcontractId);
		tappropriationSingle = tappropriationSingleService.get(this.appropriationSingleId);
		tappropriationSingle.setTasksEntrusted(tcontract.getTprojectApplication().getProjectName());
		tappropriationSingle.setUndertaker(tcontract.getTprojectApplication().getApplicationUnit());
		return "insertOrupdate";
	}

	/**
	 * 修改拨款单
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String updatetappropriationSingle(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
    	//保存项目经费使用表的信息TODO
		tappropriationSingleService.updatetappropriationSingle(this.tappropriationSingle,this.tcontractId);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tappropriationSingle!init.action?tcontractId="+ this.tcontractId + "&mainFlag=" + this.mainFlag
				+"&now=" +  new Date().getTime());
		if (("1").equals(mainFlag)){
			return "systemInfoMain";	
		}
		else{
			return "systemInfo";	
		}	
	}	
	
	
	/**
	 * 删除拨款单
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String deletetappropriationSingle(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
    	//保存项目经费使用表的信息TODO
		tappropriationSingleService.deletetappropriationSingle(this.appropriationSingleId);
		this.setRetMsg(this.getText("opt_del_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tappropriationSingle!init.action?tcontractId="+ this.tcontractId 
				+"&now=" +  new Date().getTime());
		if (("1").equals(mainFlag)){
			return "systemInfoMain";	
		}
		else{
			return "systemInfo";	
		}	
	}	
	
	/**
	 * 
	 * @comments 判断是高新的还是非高新的申报 
	 * @version 1.0
	 */
	public String highOrOther(String projectId){
		if(projectId != null){
			tprojectApplication = tprojectApplicationService.get(projectId);
	    	tprojectType = tprojectTypeService.get(tprojectApplication.getTprojectType().getTypeId());
			
	    	if(Constants.HIGHTECH_DEPARTMENT.equals(tprojectType.getDepartmentId())){
				this.highOrOtherFlag = "1";
			}else{
				this.highOrOtherFlag = "0";
			}
		}
		return highOrOtherFlag;
	}
	
	/**
	 * 跳转到修改页面
	 * @return String
	 */
	public String modify(){
		return "modify";
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TappropriationSingle getTappropriationSingle() {
		return tappropriationSingle;
	}

	public void setTappropriationSingle(TappropriationSingle tappropriationSingle) {
		this.tappropriationSingle = tappropriationSingle;
	}

	public TcontractContentsA getTcontractContentsA() {
		return tcontractContentsA;
	}

	public void setTcontractContentsA(TcontractContentsA tcontractContentsA) {
		this.tcontractContentsA = tcontractContentsA;
	}

	public TcontractContentsB getTcontractContentsB() {
		return tcontractContentsB;
	}

	public void setTcontractContentsB(TcontractContentsB tcontractContentsB) {
		this.tcontractContentsB = tcontractContentsB;
	}

	public TprojectApplicationService getTprojectApplicationService() {
		return tprojectApplicationService;
	}

	public void setTprojectApplicationService(
			TprojectApplicationService tprojectApplicationService) {
		this.tprojectApplicationService = tprojectApplicationService;
	}

	public TprojectTypeService getTprojectTypeService() {
		return tprojectTypeService;
	}

	public void setTprojectTypeService(TprojectTypeService tprojectTypeService) {
		this.tprojectTypeService = tprojectTypeService;
	}

	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	public Tcontract getTcontract() {
		return tcontract;
	}

	public void setTcontract(Tcontract tcontract) {
		this.tcontract = tcontract;
	}

	public TprojectType getTprojectType() {
		return tprojectType;
	}

	public void setTprojectType(TprojectType tprojectType) {
		this.tprojectType = tprojectType;
	}

	public String getHighOrOtherFlag() {
		return highOrOtherFlag;
	}

	public void setHighOrOtherFlag(String highOrOtherFlag) {
		this.highOrOtherFlag = highOrOtherFlag;
	}

	public String getInsertOrUpdateFlag() {
		return insertOrUpdateFlag;
	}

	public void setInsertOrUpdateFlag(String insertOrUpdateFlag) {
		this.insertOrUpdateFlag = insertOrUpdateFlag;
	}

	public TcontractContentsAService getTcontractContentsAService() {
		return tcontractContentsAService;
	}

	public void setTcontractContentsAService(
			TcontractContentsAService tcontractContentsAService) {
		this.tcontractContentsAService = tcontractContentsAService;
	}

	public TcontractContentsBService getTcontractContentsBService() {
		return tcontractContentsBService;
	}

	public void setTcontractContentsBService(
			TcontractContentsBService tcontractContentsBService) {
		this.tcontractContentsBService = tcontractContentsBService;
	}

	public TappropriationSingleService getTappropriationSingleService() {
		return tappropriationSingleService;
	}

	public void setTappropriationSingleService(
			TappropriationSingleService tappropriationSingleService) {
		this.tappropriationSingleService = tappropriationSingleService;
	}

	public TcontractService getTcontractService() {
		return tcontractService;
	}

	public void setTcontractService(TcontractService tcontractService) {
		this.tcontractService = tcontractService;
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

	public String getAppropriationSingleId() {
		return appropriationSingleId;
	}

	public void setAppropriationSingleId(String appropriationSingleId) {
		this.appropriationSingleId = appropriationSingleId;
	}

	public String getMainFlag() {
		return mainFlag;
	}

	public void setMainFlag(String mainFlag) {
		this.mainFlag = mainFlag;
	}

}

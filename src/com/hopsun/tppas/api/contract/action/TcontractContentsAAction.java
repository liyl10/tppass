package com.hopsun.tppas.api.contract.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.contract.service.TcontractContentsAService;
import com.hopsun.tppas.api.contract.service.TcontractCoverAService;
import com.hopsun.tppas.api.contract.service.TcontractService;
import com.hopsun.tppas.api.contract.service.TfundsPlanAService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.entity.TcontractContentsA;
import com.hopsun.tppas.entity.TcontractCoverA;
import com.hopsun.tppas.entity.TfundsPlanA;

public class TcontractContentsAAction extends BaseAction{
  
	public final static Logger logger = Logger.getLogger(TcontractContentsAAction.class.getName());
	
	private static final long serialVersionUID = -3078650599874881168L;
	@Resource
	private TcontractContentsAService tcontractContentsAService;
	@Resource
	private TfundsPlanAService tfundsPlanAService;
	@Resource
	private TcontractService tcontractService;
	@Resource
	private MitemService mitemService;
	@Resource
	private TcontractCoverAService tcontractCoverAService;
	//可编辑标记
	private String Flag;
	//合同内容id
	private String tcontractContentsId;
	//和同id
	private String tcontractId;
	//项目名称
	private String projectName;
	//合同状态
	private String contractStatus;
	//合同类型
	private String contractType;
	//模板类型
	private String modelType;
	//合同内容
	private TcontractContentsA tcontractContentsA;
	//资金到位计划列表
	private List<TfundsPlanA> fundsplanAList;
	//开始年份
	private String startYear;
	//开始月份
	private String startMonth;
	//结束年份
	private String endYear;
	//结束月份
	private String endMonth;
	//支持方式
	private String SupportFunction;
	
	private Tcontract tcontract;
	
	private TcontractCoverA tcontractCoverA;
	
	private String retUrl;
	
	private String retMsg;
	
	private String centralizedManagement;
	
	/**委托单位*/
	private String entrustmentCompany;

	/**
	 * 
	 * @comments 合同内容画面初始化
	 * @return
	 * @version 1.0
	 */
	public String importContents(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	// 设置令牌
    	session.setAttribute(Constants.SESSION_CMDKEY, "contractcontents");
    	this.tcontract = tcontractService.get(this.tcontractId);
    	this.tcontractContentsA = tcontractContentsAService.get("tcontract.TContractId", this.tcontractId);
    	this.tcontractCoverA = tcontractCoverAService.get("tcontract.TContractId", this.tcontractId);
    	//开始年和月
    	if(tcontract.getTprojectApplication() != null){
	    	if(tcontract.getTprojectApplication().getStartTime() != null){
	    		this.startYear = tcontract.getTprojectApplication().getStartTime().toString().substring(0, 4);
	    		this.startMonth = tcontract.getTprojectApplication().getStartTime().toString().substring(5, 7);
	    	}
	    	//结束年和月
	    	if (tcontract.getTprojectApplication().getEndTime() != null){
	        	this.endYear = tcontract.getTprojectApplication().getEndTime().toString().substring(0, 4);
	        	this.endMonth = tcontract.getTprojectApplication().getEndTime().toString().substring(5, 7);   		
	    	}
    	}
    	//委托单位
    	/*if (mitemService.get(Constants.ENTRUSTMENT_COMPANY) != null){
    		this.entrustmentCompany = mitemService.get(Constants.ENTRUSTMENT_COMPANY).getItemDesc();
    	}*/
    	// 委托单位从合同表中取得 liyl 2013/6/21 edit
    	this.entrustmentCompany = tcontractCoverA.getAuthorized();
    	if (tcontract.getTprojectApplication() != null){
			// 归口管理单位的名称
			if (tcontract.getTprojectApplication().getCentralizedType() != null){
				this.centralizedManagement = mitemService.get((tcontract.getTprojectApplication().getCentralizedType())).getItemName();
			}
		}
    	//合同内容存在的情况
    	if (!Constants.COMMON_STATE_DEFAULT.equals(tcontractContentsA.getDeleteFlag()))
    	{
    		//查询资金到位计划表
    		fundsplanAList = tfundsPlanAService.getList("tcontractContentsA.contractContentsId", tcontractContentsA.getContractContentsId());
    	}
    	//合同内容不存在的情况
    	else
    	{
    		List<TfundsPlanA> fund1 = tfundsPlanAService.getList("tcontractContentsA.contractContentsId", tcontractContentsA.getContractContentsId());
    		if(fund1.size() > 0){
    			//查询资金到位计划表
	    		fundsplanAList = tfundsPlanAService.getList("tcontractContentsA.contractContentsId", tcontractContentsA.getContractContentsId());
    		}
    		else{
    			
	    		//完成年份差
	    	    int sum = Integer.parseInt(tcontractCoverA.getEndDate().toString().substring(0, 4)) - 
	    	    			Integer.parseInt(tcontractCoverA.getStartDate().toString().substring(0, 4));
	    		//实体化资金到位计划列表
	    	    fundsplanAList = new ArrayList<TfundsPlanA>();
	    	    //年分差等于0
	    	    if(sum == 0){
	    	    	for (int i = 0 ; i<3 ; i++)
	    	    	{
		    	    	TfundsPlanA fundsplanA = new TfundsPlanA();
		    	    	fundsplanAList.add(fundsplanA);
	    	    	}
	    	    }
	    	    //年份差大于0
	    	    else{
		    		for (int i = 0 ;i< sum; i++)
		    		{
						TfundsPlanA fundsplanA = new TfundsPlanA();
						fundsplanAList.add(fundsplanA);
		    		}
		    		if (fundsplanAList.size() <3)
		    		{
		    			int size = fundsplanAList.size();
		    			for(int i = 0; i < 3-size; i++){
		    				TfundsPlanA fundsplanA = new TfundsPlanA();
			    	    	fundsplanAList.add(fundsplanA);
		    			}
		    		}
	    	    }
    		}
    	}
    	if(Constants.CONTRACT_TYPE_FREE.equals(tcontract.getContractType())){
    		return "initContents";
    	}
    	else{
    		return "initContentscredit";
    	}
	}

	/**
	 * 
	 * @comments 合同内容保存
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */
    public String updatecontractContents() throws Exception{
    	// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
	  	  String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())
    			|| !"contractcontents".equals(cmdkey)) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
    	//保存合同内容和资金到位计划
    	tcontractContentsAService.updatecontractContentsA(tcontractContentsA,this.tcontractId,fundsplanAList);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tcontractContentsA!importContents.action?&Flag="+Flag
				+ "&tcontractId="+ tcontractId 
				+"&contractStatus="+contractStatus
				+"&modelType="+ modelType 
				+"&now=" + new Date().getTime());
    	return "systemInfo";
    }
	
	/**
	 * 
	 * @comments 合同内容下一步操作
	 * @return
	 * @version 1.0
	 */
	public String ContentsTofundUse(){
    	// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
	  	  String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())
    			|| !"contractcontents".equals(cmdkey)) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
		// 取得页面提交的合同封皮信息
		this.tcontractContentsA = this.getTcontractContentsA();
		this.fundsplanAList = this.getFundsplanAList();
		tcontractContentsAService.updatecontractContentsA(tcontractContentsA,this.tcontractId,fundsplanAList);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tfundUseA!importTfundUse.action?&Flag="+Flag
				+ "&tcontractId="+ tcontractId 
				+"&contractStatus="+contractStatus
				+"&modelType="+ modelType 
				+"&now=" + new Date().getTime());
        return "systemInfoNext";
	}
	
	/**
	 * 
	 * @comments 合同内容下一步操作
	 * @return
	 * @version 1.0
	 */
	public String ContentsTofundUseCredit(){
    	// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
	  	  String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())
    			|| !"contractcontents".equals(cmdkey)) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
		// 取得页面提交的合同封皮信息
		this.tcontractContentsA = this.getTcontractContentsA();
		this.fundsplanAList = this.getFundsplanAList();
		tcontractContentsAService.updatecontractContentsA(tcontractContentsA,this.tcontractId,fundsplanAList);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tappropriationSingle!init.action?&tcontractId="+ tcontractId 
				+"&now=" + new Date().getTime());
        return "systemInfoNext";
	}
	
	public String getContractType() {
		return contractType;
	}
	  
	public String list(){
		
		return "list";
	}
	
	/**
	 * 跳转到添加页面
	 * @return String
	 */
	public String insert(){
		
		return "insert";
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

	public TcontractContentsAService getTcontractContentsAService() {
		return tcontractContentsAService;
	}

	public void setTcontractContentsAService(
			TcontractContentsAService tcontractContentsAService) {
		this.tcontractContentsAService = tcontractContentsAService;
	}

	public TfundsPlanAService getTfundsPlanAService() {
		return tfundsPlanAService;
	}

	public void setTfundsPlanAService(TfundsPlanAService tfundsPlanAService) {
		this.tfundsPlanAService = tfundsPlanAService;
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

	public TcontractCoverAService getTcontractCoverAService() {
		return tcontractCoverAService;
	}

	public void setTcontractCoverAService(
			TcontractCoverAService tcontractCoverAService) {
		this.tcontractCoverAService = tcontractCoverAService;
	}

	public String getFlag() {
		return Flag;
	}

	public void setFlag(String flag) {
		Flag = flag;
	}

	public String getTcontractContentsId() {
		return tcontractContentsId;
	}

	public void setTcontractContentsId(String tcontractContentsId) {
		this.tcontractContentsId = tcontractContentsId;
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

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public TcontractContentsA getTcontractContentsA() {
		return tcontractContentsA;
	}

	public void setTcontractContentsA(TcontractContentsA tcontractContentsA) {
		this.tcontractContentsA = tcontractContentsA;
	}

	public List<TfundsPlanA> getFundsplanAList() {
		return fundsplanAList;
	}

	public void setFundsplanAList(List<TfundsPlanA> fundsplanAList) {
		this.fundsplanAList = fundsplanAList;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	public String getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}

	public String getSupportFunction() {
		return SupportFunction;
	}

	public void setSupportFunction(String supportFunction) {
		SupportFunction = supportFunction;
	}

	public Tcontract getTcontract() {
		return tcontract;
	}

	public void setTcontract(Tcontract tcontract) {
		this.tcontract = tcontract;
	}

	public TcontractCoverA getTcontractCoverA() {
		return tcontractCoverA;
	}

	public void setTcontractCoverA(TcontractCoverA tcontractCoverA) {
		this.tcontractCoverA = tcontractCoverA;
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

	public String getCentralizedManagement() {
		return centralizedManagement;
	}

	public void setCentralizedManagement(String centralizedManagement) {
		this.centralizedManagement = centralizedManagement;
	}

	public String getEntrustmentCompany() {
		return entrustmentCompany;
	}

	public void setEntrustmentCompany(String entrustmentCompany) {
		this.entrustmentCompany = entrustmentCompany;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	
	
}

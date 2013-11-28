package com.hopsun.tppas.api.contract.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.contract.service.TcontractContentsBService;
import com.hopsun.tppas.common.CommonTool;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.CompanyInfoBean;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TarrangementB;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.entity.TcontractContentsB;
import com.hopsun.tppas.entity.TcontractCoverA;
import com.hopsun.tppas.entity.TeconomicIndicatorsB;
import com.hopsun.tppas.entity.TprojectInfoB;
import com.hopsun.tppas.entity.TprojectLeaderB;
import com.hopsun.tppas.api.contract.service.TarrangementBService;
import com.hopsun.tppas.api.contract.service.TcontractCoverAService;
import com.hopsun.tppas.api.contract.service.TcontractService;
import com.hopsun.tppas.api.contract.service.TeconomicIndicatorsBService;
import com.hopsun.tppas.api.contract.service.TprojectLeaderBService;
import com.hopsun.tppas.api.report.service.TprojectInfoBService;
import com.hopsun.tppas.api.superadmin.service.MitemService;

public class TcontractContentsBAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(TcontractContentsBAction.class.getName());
	
	private static final long serialVersionUID = -2954819863247072779L;
	
	@Resource
	private TcontractContentsBService tcontractContentsBService;
	  
	@Resource
	private TcontractService tcontractService;
	
	@Resource
	private TcontractCoverAService tcontractCoverAService;
	//项目主要人员
	@Resource
	private TprojectLeaderBService tprojectLeaderBService;
	//项目主要人员
	@Resource
	private TarrangementBService tarrangementBService;
	//拟达到的经济指标
	@Resource
	private TeconomicIndicatorsBService teconomicIndicatorsBService;
	@Resource 
	private TprojectInfoBService tprojectInfoBService;
	@Resource
	private MitemService mitemService;
	
	//合同id
	private String tcontractId;
	//合同管理
	private Tcontract tcontract;
	//合同内容表
	private TcontractContentsB tcontractContentsB;
	//合同封皮表
	private TcontractCoverA tcontractCoverA;
	//主要协作单位
	private TprojectInfoB tprojectInfoB;
	//主要负责人员表
	private List<TprojectLeaderB> tprojectLeaderBList = new ArrayList<TprojectLeaderB>();
	//拟达到的经济指标表
	private List<TarrangementB> tarrangementBList = new ArrayList<TarrangementB>();
	//主要负责人员表
	private TeconomicIndicatorsB teconomicIndicatorsB = new TeconomicIndicatorsB();
	//合同填报步骤
	private List<Map<String, String>> contractStep;
	//合同类型
	private String contractType;
	//模板类型
	private String modelType;
	//合同状态
	private String contractStatus;
	
	private String retUrl;
	
	private String retMsg;
	//按钮是否显示标记
	private String Flag;
	//项目名称
	private String projectName;
	/** 表名 */
	private String tableName;
	/** 文件类型 */
	private String fileType;
	/** 下拉列表联动返回字符串 */
	private String backStr;
	private String pitemId;
	/** 菜单List */ 
	private List<Mitem> menuList;
	
	/**材料类型是否都有*/
	private String isPass = "1";
	/**委托单位*/
	private String entrustmentCompany;
	/**合同封皮备注*/
	private String contractComment;
	/**归口管理单位名称*/
	private String centralizedManagement;
	
	//近三年
	private int year1;
	//近两年
	private int year2;
	//近一年
	private int year3;
	
	/**
	 * 项目总体情况及主要内容页面初始化
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String initContents(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	// 设置令牌
    	session.setAttribute(Constants.SESSION_CMDKEY, "contractcontentsB");
    	//取得合同内容表
    	tcontractContentsB = tcontractContentsBService.get("tcontract.TContractId",tcontractId);
    	//取得合同封皮表
    	tcontractCoverA = tcontractCoverAService.get("tcontract.TContractId",tcontractId);
    	//取得合同管理表
    	tcontract = tcontractService.get(this.tcontractId);
    	//取得项目名称
    	if (tcontract != null)
    	{
    		this.projectName = tcontract.getTprojectApplication().getProjectName();
    	}
    	if (tcontractCoverA != null)
    	{
    		if (CommonTool.IsNotEmpty(tcontractCoverA.getTopicTitle())){
    			projectName = projectName + ":" + tcontractCoverA.getTopicTitle();
    		}
    	}
    	//项目负责人及主要人员
		tprojectLeaderBList = tprojectLeaderBService.getList("tcontract.TContractId", tcontractId);
		//项目实施阶段安排
		tarrangementBList = tarrangementBService.getList("tcontract.TContractId", tcontractId);
		//拟达到的经济指标
		teconomicIndicatorsB = teconomicIndicatorsBService.get("tcontract.TContractId", tcontractId);
    	
		if (tcontract != null)
    	{
    		if (tcontract.getTprojectApplication() != null){
    			if (tcontract.getTprojectApplication().getTprojectInfoBs() != null){
    				tprojectInfoB = tprojectInfoBService.get("tprojectApplication.projectId", tcontract.getTprojectApplication().getProjectId());	
    			}
    		}
    	}
    	
		String startTime = null;
    	String endTime = null;
    	String startYear = null;
    	String endYear = null;
    	if (tcontract != null){
	    	if (tcontract.getTprojectApplication() != null){
	    		if (tcontract.getTprojectApplication().getStartTime() != null){
	    			startTime = String.valueOf(tcontract.getTprojectApplication().getStartTime());
	    			endTime = String.valueOf(tcontract.getTprojectApplication().getEndTime());
	    		}
	    	}
    	}
    	if (startTime != null && endTime != null){
    		startYear = startTime.substring(0, 4);
    		endYear = endTime.substring(0, 4);
    		int sum =Integer.valueOf(endYear) - Integer.valueOf(startYear);
    		if (sum == 1){
    			year1 = Integer.valueOf(startYear);
    			year2 = Integer.valueOf(endYear);
    			year3 = Integer.valueOf(endYear) + 1;
    		}
    		else{
    			year1 = Integer.valueOf(startYear);
    			year2 = Integer.valueOf(startYear) + 1;
    			year3 = Integer.valueOf(endYear);
    		}
    	}
		if (tcontractCoverA != null){
			this.entrustmentCompany = tcontractCoverA.getAuthorized();
		}
		return "initContents";
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
	 * 合同说明画面初始化
	 * @comments 
	 * @return
	 * @version 1.0
	 */
	public String initObligation(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	// 设置令牌
    	session.setAttribute(Constants.SESSION_CMDKEY, "obligation");
    	//取得合同内容表
    	tcontractContentsB = tcontractContentsBService.get("tcontract.TContractId",tcontractId);
    	//取得合同封皮表
    	tcontractCoverA = tcontractCoverAService.get("tcontract.TContractId",tcontractId);
    	this.entrustmentCompany = tcontractCoverA.getAuthorized();
    	this.tcontract = tcontractService.get(tcontractId);
    	if (tcontract.getTprojectApplication() != null){
			// 归口管理单位的名称
			if (tcontract.getTprojectApplication().getCentralizedType() != null){
				this.centralizedManagement = mitemService.get((tcontract.getTprojectApplication().getCentralizedType())).getItemName();
			}
		}
		return "initObligation";
	}
	
	
	/**
	 * 
	 * @comments 项目总体情况及主要内容保存 
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */
    public String updatetContents() throws Exception{
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
	  	  String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())
    			|| !"contractcontentsB".equals(cmdkey)) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
	  	tcontractContentsBService.updatetContents(this.tcontractContentsB,
	  			this.tprojectLeaderBList,
	  			this.teconomicIndicatorsB,
	  			this.tarrangementBList,
	  			this.tcontractId);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tcontractContentsB!initContents.action?tcontractId="+ this.tcontractId 
				+"&Flag="+this.Flag
				+ "&contractStatus=" +contractStatus 
				+ "&modelType="+ modelType 
				+ "&now=" +  new Date().getTime());
    	return "systemInfo";
    }
	
	/**
	 * @comments 合同内容下一步操作
	 * @return
	 * @version 1.0
	 */
	public String nextContents(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
	  	  String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())
    			|| !"contractcontentsB".equals(cmdkey)) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
		// 取得页面提交的合同封皮信息
		this.tcontract = this.getTcontract();
		tcontractContentsBService.updatetContents(this.tcontractContentsB,
	  			this.tprojectLeaderBList,
	  			this.teconomicIndicatorsB,
	  			this.tarrangementBList,
	  			this.tcontractId);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tfundingPlanB!execute.action?&Flag="+Flag
				+ "&tcontractId="+ tcontractId 
				+"&contractStatus="+contractStatus
				+"&modelType="+ modelType 
				+"&now=" + new Date().getTime());
        return "systemInfoNext";
	}
	
	/**
	 * 
	 * @comments 合同说明保存 
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */
    public String updatetObligation() throws Exception{
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
	  	  String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())
    			|| !"obligation".equals(cmdkey)) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
	  	tcontractContentsBService.updatetObligation(this.tcontractContentsB,this.tcontractId);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tcontractContentsB!initObligation.action?tcontractId="+ this.tcontractId 
				+"&Flag="+this.Flag
				+ "&contractStatus=" +contractStatus 
				+ "&modelType="+ modelType 
				+ "&now=" +  new Date().getTime());
    	return "systemInfo";
    }
	
	/**
	 * @comments 合同说明下一步操作
	 * @return
	 * @version 1.0
	 */
	public String nextObligation(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
	  	  String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())
    			|| !"obligation".equals(cmdkey)) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
		// 取得页面提交的合同封皮信息
		this.tcontract = this.getTcontract();
		tcontractContentsBService.updatetObligation(this.tcontractContentsB,this.tcontractId);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tcontract!initKnow.action?&Flag="+Flag
				+ "&tcontractId="+ tcontractId 
				+"&contractStatus="+contractStatus
				+"&modelType="+ modelType 
				+"&now=" + new Date().getTime());
        return "systemInfoNext";
	}

	public String list(){
		
		return "list";
	}
	
	
	/**
	 * 跳转到修改页面
	 * @return String
	 */
	public String modify(){
		return "modify";
	}


	public TcontractContentsBService getTcontractContentsBService() {
		return tcontractContentsBService;
	}


	public void setTcontractContentsBService(
			TcontractContentsBService tcontractContentsBService) {
		this.tcontractContentsBService = tcontractContentsBService;
	}


	public TcontractService getTcontractService() {
		return tcontractService;
	}


	public void setTcontractService(TcontractService tcontractService) {
		this.tcontractService = tcontractService;
	}


	public TcontractCoverAService getTcontractCoverAService() {
		return tcontractCoverAService;
	}


	public void setTcontractCoverAService(
			TcontractCoverAService tcontractCoverAService) {
		this.tcontractCoverAService = tcontractCoverAService;
	}


	public TprojectLeaderBService getTprojectLeaderBService() {
		return tprojectLeaderBService;
	}


	public void setTprojectLeaderBService(
			TprojectLeaderBService tprojectLeaderBService) {
		this.tprojectLeaderBService = tprojectLeaderBService;
	}


	public TarrangementBService getTarrangementBService() {
		return tarrangementBService;
	}


	public void setTarrangementBService(TarrangementBService tarrangementBService) {
		this.tarrangementBService = tarrangementBService;
	}


	public TeconomicIndicatorsBService getTeconomicIndicatorsBService() {
		return teconomicIndicatorsBService;
	}


	public void setTeconomicIndicatorsBService(
			TeconomicIndicatorsBService teconomicIndicatorsBService) {
		this.teconomicIndicatorsBService = teconomicIndicatorsBService;
	}


	public TprojectInfoBService getTprojectInfoBService() {
		return tprojectInfoBService;
	}


	public void setTprojectInfoBService(TprojectInfoBService tprojectInfoBService) {
		this.tprojectInfoBService = tprojectInfoBService;
	}


	public MitemService getMitemService() {
		return mitemService;
	}


	public void setMitemService(MitemService mitemService) {
		this.mitemService = mitemService;
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


	public TcontractContentsB getTcontractContentsB() {
		return tcontractContentsB;
	}


	public void setTcontractContentsB(TcontractContentsB tcontractContentsB) {
		this.tcontractContentsB = tcontractContentsB;
	}


	public TcontractCoverA getTcontractCoverA() {
		return tcontractCoverA;
	}


	public void setTcontractCoverA(TcontractCoverA tcontractCoverA) {
		this.tcontractCoverA = tcontractCoverA;
	}


	public TprojectInfoB getTprojectInfoB() {
		return tprojectInfoB;
	}


	public void setTprojectInfoB(TprojectInfoB tprojectInfoB) {
		this.tprojectInfoB = tprojectInfoB;
	}


	public List<TprojectLeaderB> getTprojectLeaderBList() {
		return tprojectLeaderBList;
	}


	public void setTprojectLeaderBList(List<TprojectLeaderB> tprojectLeaderBList) {
		this.tprojectLeaderBList = tprojectLeaderBList;
	}


	public List<TarrangementB> getTarrangementBList() {
		return tarrangementBList;
	}


	public void setTarrangementBList(List<TarrangementB> tarrangementBList) {
		this.tarrangementBList = tarrangementBList;
	}


	public TeconomicIndicatorsB getTeconomicIndicatorsB() {
		return teconomicIndicatorsB;
	}


	public void setTeconomicIndicatorsB(TeconomicIndicatorsB teconomicIndicatorsB) {
		this.teconomicIndicatorsB = teconomicIndicatorsB;
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


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
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


	public String getCentralizedManagement() {
		return centralizedManagement;
	}


	public void setCentralizedManagement(String centralizedManagement) {
		this.centralizedManagement = centralizedManagement;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getYear1() {
		return year1;
	}


	public void setYear1(int year1) {
		this.year1 = year1;
	}


	public int getYear2() {
		return year2;
	}


	public void setYear2(int year2) {
		this.year2 = year2;
	}


	public int getYear3() {
		return year3;
	}


	public void setYear3(int year3) {
		this.year3 = year3;
	}
	
	
}

package com.hopsun.tppas.api.contract.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.contract.service.TfundUseAService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TfundUseA;
import com.hopsun.tppas.api.contract.service.TcontractService;

public class TfundUseAAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(TfundUseAAction.class.getName());
	private static final long serialVersionUID = -6282106131166815757L;
	@Resource
	private TfundUseAService tfundUseAService;
	
	@Resource
	private TcontractService tcontractService;
	
	//可编辑标记
	private String Flag;
	//和同id
	private String tcontractId;
	//合同状态
	private String contractStatus;
	//合同类型
	private String contractType;
	//模板类型
	private String modelType;
	//项目经费使用表
	private TfundUseA tfunduse;

	private String retUrl;
	
	private String retMsg;	
	
	/**
	 * 
	 * @comments 项目经费表页面初始化
	 * @return
	 * @version 1.0
	 */
	public String importTfundUse(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	// 设置令牌
    	session.setAttribute(Constants.SESSION_CMDKEY, "tfunduse");
		tfunduse = tfundUseAService.get("tcontract.TContractId",tcontractId);
		return "tfunduse";
	}
	  
	/**
	 * 
	 * @comments 更新项目经费使用表
	 * @return
	 * @version 1.0
	 */
	public String updatefundUse(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
	  	  String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())
    			|| !"tfunduse".equals(cmdkey)) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
    	//保存项目经费使用表的信息TODO
    	tfundUseAService.updatefundUse(this.tfunduse,this.tcontractId);
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/contract/tfundUseA!importTfundUse.action?tcontractId="+ this.tcontractId 
				+"&Flag="+this.Flag + 
				"&modelType=" + modelType 
				+"&contractStatus=" +contractStatus 
				+"&now=" +  new Date().getTime());
    	return "systemInfo";	
			
	}

	
	/**
	 * 
	 * @comments 项目经费使用表下一步操作
	 * @return
	 * @version 1.0
	 */
	public String FundUseTodescription(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
	  	  String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())
    			|| !"tfunduse".equals(cmdkey)) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
		//保存项目经费使用表的信息
		this.tfunduse = this.getTfunduse();
    	tfundUseAService.updatefundUse(this.tfunduse,this.tcontractId);
		this.setRetMsg(this.getText("opt_save_suc"));
			this.setRetUrl(super.getRequest().getContextPath()
					+ "/api/contract/tcontracthighTech!importDescription.action?tcontractId="+ this.tcontractId 
					+"&Flag="+this.Flag 
					+ "&modelType=" + modelType 
					+"&contractStatus=" +contractStatus 
					+ "&now=" +  new Date().getTime());
        return "systemInfoNext";
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

	public TfundUseAService getTfundUseAService() {
		return tfundUseAService;
	}

	public void setTfundUseAService(TfundUseAService tfundUseAService) {
		this.tfundUseAService = tfundUseAService;
	}

	public String getTcontractId() {
		return tcontractId;
	}

	public void setTcontractId(String tcontractId) {
		this.tcontractId = tcontractId;
	}

	public TfundUseA getTfunduse() {
		return tfunduse;
	}

	public void setTfunduse(TfundUseA tfunduse) {
		this.tfunduse = tfunduse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TcontractService getTcontractService() {
		return tcontractService;
	}

	public void setTcontractService(TcontractService tcontractService) {
		this.tcontractService = tcontractService;
	}

	public String getFlag() {
		return Flag;
	}

	public void setFlag(String flag) {
		Flag = flag;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
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
	
	
}

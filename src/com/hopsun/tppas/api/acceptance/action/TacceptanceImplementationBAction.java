package com.hopsun.tppas.api.acceptance.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.acceptance.service.TacceptanceImplementationBService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tacceptance;
import com.hopsun.tppas.entity.TacceptanceImplementationB;

public class TacceptanceImplementationBAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(TacceptanceImplementationBAction.class.getName());
	private static final long serialVersionUID = 7170938464878152630L;

	@Resource
	private TacceptanceImplementationBService tacceptanceImplementationBService;
	/**验收*/
	private Tacceptance tacceptance;
	/** 项目验收ID*/
	private String acceptanceId;
	/** 验收状态*/
	private String acceptanceStatus;
	/** 项目经费落实和使用情况*/
	private TacceptanceImplementationB tacceptanceImplementationB;
	/** 跳转路径 */ 
	private String retUrl;
	/** 跳转页面massage */  
	private String retMsg;
	
	public String shoumenu(){
		return "othermenu";
	}
	/**
	 * 
	 * @comments 画面初始化 
	 * @return
	 * @version 1.0
	 */
	public String showTacceptanceImplement(){
        // 取得登录用户的信息
 		HttpSession session = this.getRequest().getSession();
 		ScUsers user = (ScUsers) session.getAttribute("sysUser");
     	session.setAttribute(Constants.SESSION_CMDKEY, "showTacceptanceImplement");
     	// 判断是否失效
     	if (user == null || ("").equals(user.getUserId())) {
     		logger.error("用户不存在！");
 			return "LogOut";
 		}

		this.acceptanceId = this.getAcceptanceId();
		this.acceptanceStatus = this.getAcceptanceStatus();
    	// 获得项目经费落实和使用情况
		tacceptanceImplementationB = tacceptanceImplementationBService.get("tacceptance.acceptanceId",acceptanceId);
		
		return "tacceptanceImplementationB";
	}
	/**
	 * @return the tacceptanceImplementationBService
	 */
	public TacceptanceImplementationBService getTacceptanceImplementationBService() {
		return tacceptanceImplementationBService;
	}
	/**
	 * @param tacceptanceImplementationBService the tacceptanceImplementationBService to set
	 */
	public void setTacceptanceImplementationBService(
			TacceptanceImplementationBService tacceptanceImplementationBService) {
		this.tacceptanceImplementationBService = tacceptanceImplementationBService;
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
	 * @return the tacceptanceImplementationB
	 */
	public TacceptanceImplementationB getTacceptanceImplementationB() {
		return tacceptanceImplementationB;
	}
	/**
	 * @param tacceptanceImplementationB the tacceptanceImplementationB to set
	 */
	public void setTacceptanceImplementationB(
			TacceptanceImplementationB tacceptanceImplementationB) {
		this.tacceptanceImplementationB = tacceptanceImplementationB;
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
	
}

package com.hopsun.tppas.api.acceptance.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.acceptance.service.TacceptanceSummaryBService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tacceptance;
import com.hopsun.tppas.entity.TacceptanceSummaryB;

public class TacceptanceSummaryBAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(TacceptanceSummaryBAction.class.getName());
	private static final long serialVersionUID = 348882115553580616L;

	@Resource
	private TacceptanceSummaryBService tacceptanceSummaryBService;
	/**验收*/
	private Tacceptance tacceptance;
	/** 项目验收ID*/
	private String acceptanceId;
	/** 验收状态*/
	private String acceptanceStatus;
	/** 项目总结说明*/
	private TacceptanceSummaryB tacceptanceSummaryB;
	/** 跳转路径 */ 
	private String retUrl;
	/** 跳转页面massage */  
	private String retMsg;
	
	/**
	 * 
	 * @comments 页面初始化 
	 * @return
	 * @version 1.0
	 */
	public String showAcceptanceSummaryB(){
        // 取得登录用户的信息
 		HttpSession session = this.getRequest().getSession();
 		ScUsers user = (ScUsers) session.getAttribute("sysUser");
     	session.setAttribute(Constants.SESSION_CMDKEY, "showAcceptanceSummaryB");
     	// 判断是否失效
     	if (user == null || ("").equals(user.getUserId())) {
     		logger.error("用户不存在！");
 			return "LogOut";
 		}
		this.acceptanceId = this.getAcceptanceId();
		this.acceptanceStatus = this.getAcceptanceStatus();
		tacceptanceSummaryB = tacceptanceSummaryBService.get("tacceptance.acceptanceId",acceptanceId);
		
		return "showAcceptanceSummaryB";
	}

	/**
	 * @return the tacceptanceSummaryBService
	 */
	public TacceptanceSummaryBService getTacceptanceSummaryBService() {
		return tacceptanceSummaryBService;
	}

	/**
	 * @param tacceptanceSummaryBService the tacceptanceSummaryBService to set
	 */
	public void setTacceptanceSummaryBService(
			TacceptanceSummaryBService tacceptanceSummaryBService) {
		this.tacceptanceSummaryBService = tacceptanceSummaryBService;
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
	 * @return the tacceptanceSummaryB
	 */
	public TacceptanceSummaryB getTacceptanceSummaryB() {
		return tacceptanceSummaryB;
	}

	/**
	 * @param tacceptanceSummaryB the tacceptanceSummaryB to set
	 */
	public void setTacceptanceSummaryB(TacceptanceSummaryB tacceptanceSummaryB) {
		this.tacceptanceSummaryB = tacceptanceSummaryB;
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

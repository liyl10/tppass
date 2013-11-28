package com.hopsun.tppas.api.acceptance.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.acceptance.service.TacceptanceFundsAService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TacceptanceFundsA;

public class TacceptanceFundsAAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(TacceptanceFundsAAction.class.getName());
	private static final long serialVersionUID = -6374072125515496654L;

	@Resource
	private TacceptanceFundsAService tacceptanceFundsAService;
	
	/** 企业获得资金支持情况 */
	private TacceptanceFundsA tacceptanceFundsA;
	/** 验收ID */
	private String acceptanceId;
	/** 验收状态 */
	private String acceptanceStatus;
	/** 跳转路径 */
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;
	
	/**
	 * @Comments 企业获得资金支持情况画面初期化处理
	 * @return
	 * @Vsersion: 1.0
	 */
	public String fundsInit(){
		// 取得登录用户的信息
 		HttpSession session = this.getRequest().getSession();
 		ScUsers user = (ScUsers) session.getAttribute("sysUser");
     	session.setAttribute(Constants.SESSION_CMDKEY, "tacceptanceFundsA");
 		
     	// 判断是否失效
     	if (user == null || ("").equals(user.getUserId())) {
     		logger.error("用户不存在！");
 			return "LogOut";
 		}
		// 根据验收ID查询对照合同项目任务完成情况
		List<TacceptanceFundsA> fundsAList = new ArrayList<TacceptanceFundsA>();
		fundsAList = tacceptanceFundsAService.getList("tacceptance.acceptanceId", acceptanceId);
		if(fundsAList != null && fundsAList.size() > 0){
			tacceptanceFundsA = fundsAList.get(0);
		}
		
		return "fundsInit";
	}

	/**
	 * @return the tacceptanceFundsAService
	 */
	public TacceptanceFundsAService getTacceptanceFundsAService() {
		return tacceptanceFundsAService;
	}

	/**
	 * @param tacceptanceFundsAService the tacceptanceFundsAService to set
	 */
	public void setTacceptanceFundsAService(
			TacceptanceFundsAService tacceptanceFundsAService) {
		this.tacceptanceFundsAService = tacceptanceFundsAService;
	}

	/**
	 * @return the tacceptanceFundsA
	 */
	public TacceptanceFundsA getTacceptanceFundsA() {
		return tacceptanceFundsA;
	}

	/**
	 * @param tacceptanceFundsA the tacceptanceFundsA to set
	 */
	public void setTacceptanceFundsA(TacceptanceFundsA tacceptanceFundsA) {
		this.tacceptanceFundsA = tacceptanceFundsA;
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

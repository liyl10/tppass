package com.hopsun.tppas.api.acceptance.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.acceptance.service.TacceptanceMainAService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TacceptanceMainA;

public class TacceptanceMainAAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(TacceptanceMainAAction.class.getName());
	private static final long serialVersionUID = -8536697502003865652L;

	@Resource
	private TacceptanceMainAService tacceptanceMainAService;
	
	/** 项目主要参加人员名单 */
	private TacceptanceMainA tacceptanceMainA;
	/** 跳转页数 */
	private int pageNo;
	/** 项目参加人员ID */
	private String participateId;
	/** 验收ID */
	private String acceptanceId;
	/** 验收状态 */
	private String acceptanceStatus;
	/** 跳转路径 */
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;
	
	/**
	 * @Comments 项目主要参加人员名单画面初期化处理
	 * @return
	 * @Vsersion: 1.0
	 */
	public String mainInit(){
		// 取得登录用户的信息
 		HttpSession session = this.getRequest().getSession();
 		ScUsers user = (ScUsers) session.getAttribute("sysUser");
     	session.setAttribute(Constants.SESSION_CMDKEY, "tacceptanceMainA");
 		
     	// 判断是否失效
     	if (user == null || ("").equals(user.getUserId())) {
     		logger.error("用户不存在！");
 			return "LogOut";
 		}
		// 得到数据总个数
		setPager(new Pager());
		pager = new Pager();
    	if (this.getPageNo() != 0) {
    		pager.setPageNumber(this.getPageNo());
    	}
		pager = tacceptanceMainAService.find(pager.getPageNumber(), pager.getPageSize(), acceptanceId);
		
		return "mainInit";
	}
	
	/**
	 * 修改信息页面初期化处理
	 * @return String
	 */
	public String mainUpdateInit(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (cmdkey == null || !"tacceptanceMainA".equals(cmdkey)) {
			logger.error("错误的令牌！");
			return "LogOut";
		}
		// 通过ID取得项目主要参加人员信息
		tacceptanceMainA = tacceptanceMainAService.get("participateId", participateId);
		
		return "mainUpdateInit";
	}

	/**
	 * @return the tacceptanceMainAService
	 */
	public TacceptanceMainAService getTacceptanceMainAService() {
		return tacceptanceMainAService;
	}

	/**
	 * @param tacceptanceMainAService the tacceptanceMainAService to set
	 */
	public void setTacceptanceMainAService(
			TacceptanceMainAService tacceptanceMainAService) {
		this.tacceptanceMainAService = tacceptanceMainAService;
	}

	/**
	 * @return the tacceptanceMainA
	 */
	public TacceptanceMainA getTacceptanceMainA() {
		return tacceptanceMainA;
	}

	/**
	 * @param tacceptanceMainA the tacceptanceMainA to set
	 */
	public void setTacceptanceMainA(TacceptanceMainA tacceptanceMainA) {
		this.tacceptanceMainA = tacceptanceMainA;
	}

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the participateId
	 */
	public String getParticipateId() {
		return participateId;
	}

	/**
	 * @param participateId the participateId to set
	 */
	public void setParticipateId(String participateId) {
		this.participateId = participateId;
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

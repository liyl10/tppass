package com.hopsun.tppas.api.acceptance.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.acceptance.service.TacceptanceAccAService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TacceptanceAccA;

public class TacceptanceAccAAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(TacceptanceAccAAction.class.getName());
	private static final long serialVersionUID = 3286592652534680928L;
	@Resource
	private TacceptanceAccAService tacceptanceAccAService;
	
	/** 验收小组名单 */
	private TacceptanceAccA tacceptanceAccA;
	/** 跳转页数 */
	private int pageNo;
	/** 验收小组人员ID */
	private String accId;
	/** 验收ID */
	private String acceptanceId;
	/** 验收状态 */
	private String acceptanceStatus;
	/** 跳转路径 */
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;
	
	/**
	 * 验收小组名单初始化
	 * @return
	 * @Vsersion: 1.0
	 */
	public String accInit(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	session.setAttribute(Constants.SESSION_CMDKEY, "tacceptanceAccA");
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
		pager = tacceptanceAccAService.find(pager.getPageNumber(), pager.getPageSize(), acceptanceId);
		
		return "accInit";
	}
	
	/**
	 * 修改信息页面初期化处理
	 * @return String
	 */
	public String accUpdateInit(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
		// 取得令牌信息
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (cmdkey == null || !"tacceptanceAccA".equals(cmdkey)) {
			logger.error("错误的令牌！");
			return "LogOut";
		}
		// 通过ID取得项目主要参加人员信息
		tacceptanceAccA = tacceptanceAccAService.get("accId", accId);
		
		return "accUpdateInit";
	}

	/**
	 * @return the tacceptanceAccAService
	 */
	public TacceptanceAccAService getTacceptanceAccAService() {
		return tacceptanceAccAService;
	}

	/**
	 * @param tacceptanceAccAService the tacceptanceAccAService to set
	 */
	public void setTacceptanceAccAService(
			TacceptanceAccAService tacceptanceAccAService) {
		this.tacceptanceAccAService = tacceptanceAccAService;
	}

	/**
	 * @return the tacceptanceAccA
	 */
	public TacceptanceAccA getTacceptanceAccA() {
		return tacceptanceAccA;
	}

	/**
	 * @param tacceptanceAccA the tacceptanceAccA to set
	 */
	public void setTacceptanceAccA(TacceptanceAccA tacceptanceAccA) {
		this.tacceptanceAccA = tacceptanceAccA;
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
	 * @return the accId
	 */
	public String getAccId() {
		return accId;
	}

	/**
	 * @param accId the accId to set
	 */
	public void setAccId(String accId) {
		this.accId = accId;
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

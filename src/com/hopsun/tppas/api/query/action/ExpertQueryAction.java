/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.query.action;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;

/**
 * @comment 项目查询页面
 * @author lihf
 * @DATE: 2013-8-27 @TIME: 下午14:16:09
 * @Vsersion: 1.0
 */
public class ExpertQueryAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(ExpertQueryAction.class.getName());

	private static final long serialVersionUID = -6105606581261532536L;

	/** TacceptanceService 对象的实例 */
	//@Resource
//	private ProjectQueryService projectQueryService;

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
	 * @Comments 画面初期化处理
	 * @return
	 * @Vsersion: 1.0
	 */
	public String init() {
		// 取得登录用户的信息
//		HttpSession session = this.getRequest().getSession();
//		session.setAttribute(Constants.SESSION_CMDKEY, "tacceptance");
//		CompanyInfoBean company = (CompanyInfoBean) session.getAttribute(Constants.SESSION_COMPANYINFO);
//		// 如果用户为空或者企业为空，退出系统
//		if (company == null || ("").equals(company.getPkUoiId())) {
//			logger.error("缺少登录信息或者错误的令牌！");
//			return "LogOut";
//		}		
//		// 得到数据总个数
//		setPager(new Pager());
//		pager = new Pager();
//    	if (this.getPageNo() != 0) {
//    		pager.setPageNumber(this.getPageNo());
//    	}
//		pager = projectQueryService.find(pager.getPageNumber(), pager.getPageSize());
		
		return "init";
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

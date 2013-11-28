/*************** 版权声明***************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ********************************************
 */
package com.hopsun.tppas.api.report.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TexpectedResultsService;
import com.hopsun.tppas.entity.TexpectedResults;

/**
 * @comments 预期成果(非高新)
 * @author weina
 * @date 2013-9-26 @time 下午21:23:56
 * @Version 1.0
 */
public class TexpectedResultsAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3972312285679631712L;

	public final static Logger logger = Logger.getLogger(TexpectedResultsAction.class.getName());

	@Resource
	private TexpectedResultsService texpectedResultsService;
	/** 项目状态 */
	private String applyStatus;
	/** 项目ID */
	private String projectId;
	/** 预期成果对象 */
	private TexpectedResults texpectedResults;
	/** 跳转路径 */
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;

	/**
	 * @comments 显示摘要说明
	 * @return
	 * @Version 1.0
	 */
	public String showTexpectedResults() {

		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY,
		// "showTexpectedResults");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}
		// 取得项目Id
		this.projectId = this.getProjectId();

		// 取得项目状态
		this.applyStatus = this.getApplyStatus();

		// 取得预期成果
		this.texpectedResults = texpectedResultsService.get("tprojectApplication.projectId", projectId);

		return "showtexpectedresults";
	}

	/**
	 * @comments 保存预期成果
	 * @return
	 * @Version 1.0
	 */
	public String saveTexpectedResults() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// String cmdkey = (String)
		// session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}

		/*
		 * if (cmdkey == null || !"showTexpectedResults".equals(cmdkey)) {
		 * logger.error("错误的令牌！"); return "LogOut"; }
		 */
		// 取得预期成果
		this.texpectedResults = this.getTexpectedResults();

		texpectedResultsService.saveTexpectedResults(texpectedResults, user.getUserId());

		// 设置提示信息
		this.setRetMsg(this.getText("opt_save_suc"));

		// 设置actionUrl
		this.setRetUrl(super.getRequest().getContextPath() + "/server/report/texpectedResults!showTexpectedResults.action?projectId=" + this.projectId + "&applyStatus=" + this.getApplyStatus()
				+ "&now=" + new Date().getTime());

		return "systemInfo";
	}

	/**
	 * @comments 保存预期成果（下一步）
	 * @return
	 * @Version 1.0
	 */
	public String nextTexpectedResults() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// String cmdkey = (String)
		// session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}

		/*
		 * if (cmdkey == null || !"showTexpectedResults".equals(cmdkey)) {
		 * logger.error("错误的令牌！"); return "LogOut"; }
		 */
		// 取得摘要说明
		this.texpectedResults = this.getTexpectedResults();

		texpectedResultsService.saveTexpectedResults(texpectedResults, user.getUserId());

		// 设置提示信息
		this.setRetMsg(this.getText("opt_save_suc"));

		// 设置actionUrl
		this.setRetUrl(super.getRequest().getContextPath() + "/server/report/tresearcherActionB!list.action?projectId=" + this.projectId + "&applyStatus=" + this.getApplyStatus() + "&now="
				+ new Date().getTime());

		return "systemInfoNext";
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public TexpectedResults getTexpectedResults() {
		return texpectedResults;
	}

	public void setTexpectedResults(TexpectedResults texpectedResults) {
		this.texpectedResults = texpectedResults;
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

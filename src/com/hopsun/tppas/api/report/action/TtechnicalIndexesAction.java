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
import com.hopsun.tppas.api.report.service.TtechnicalIndexesService;
import com.hopsun.tppas.entity.TtechnicalIndexes;

/**
 * @comments 项目达到的主要技术指标(非高新)
 * @author weina
 * @date 2013-9-27 @time 上午9:13:56
 * @Version 1.0
 */
public class TtechnicalIndexesAction extends BaseAction {

	private static final long serialVersionUID = 3303791324795028883L;

	public final static Logger logger = Logger.getLogger(TtechnicalIndexesAction.class.getName());

	@Resource
	private TtechnicalIndexesService ttechnicalIndexesService;
	/** 项目状态 */
	private String applyStatus;
	/** 项目ID */
	private String projectId;
	/** 项目达到的主要技术指标对象 */
	private TtechnicalIndexes ttechnicalIndexes;
	/** 跳转路径 */
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;

	/**
	 * @comments 显示项目达到的主要技术指标
	 * @return
	 * @Version 1.0
	 */
	public String showTechnicalIndexes() {
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY,
		// "showTechnicalIndexes");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}
		// 取得项目Id
		this.projectId = this.getProjectId();

		// 取得项目状态
		this.applyStatus = this.getApplyStatus();

		// 取得摘要说明
		this.ttechnicalIndexes = ttechnicalIndexesService.get("tprojectApplication.projectId", projectId);

		return "showtechnicalindexes";
	}

	/**
	 * @comments 保存项目达到的主要技术指标
	 * @return
	 * @Version 1.0
	 */
	public String saveTechnicalIndexes() {
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
		 * if (cmdkey == null || !"showTechnicalIndexes".equals(cmdkey)) {
		 * logger.error("错误的令牌！"); return "LogOut"; }
		 */
		// 取得摘要说明
		this.ttechnicalIndexes = this.getTtechnicalIndexes();

		ttechnicalIndexesService.saveTtechnicalIndexes(ttechnicalIndexes, user.getUserId());

		// 设置提示信息
		this.setRetMsg(this.getText("opt_save_suc"));

		// 设置actionUrl
		this.setRetUrl(super.getRequest().getContextPath() + "/server/report/technicalIndexes!showTechnicalIndexes.action?projectId=" + this.projectId + "&applyStatus=" + this.getApplyStatus()
				+ "&now=" + new Date().getTime());

		return "systemInfo";
	}

	/**
	 * @comments 保存项目达到的主要技术指标（下一步）
	 * @return
	 * @Version 1.0
	 */
	public String nextTechnicalIndexes() {
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
		 * if (cmdkey == null || !"showTechnicalIndexes".equals(cmdkey)) {
		 * logger.error("错误的令牌！"); return "LogOut"; }
		 */
		// 取得摘要说明
		this.ttechnicalIndexes = this.getTtechnicalIndexes();

		ttechnicalIndexesService.saveTtechnicalIndexes(ttechnicalIndexes, user.getUserId());

		// 设置提示信息
		this.setRetMsg(this.getText("opt_save_suc"));

		// 设置actionUrl
		this.setRetUrl(super.getRequest().getContextPath() + "/server/report/teconomicIndicatorBAction!list.action?projectId=" + this.projectId + "&applyStatus=" + this.getApplyStatus() + "&now="
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

	public TtechnicalIndexesService getTtechnicalIndexesService() {
		return ttechnicalIndexesService;
	}

	public void setTtechnicalIndexesService(TtechnicalIndexesService ttechnicalIndexesService) {
		this.ttechnicalIndexesService = ttechnicalIndexesService;
	}

	public TtechnicalIndexes getTtechnicalIndexes() {
		return ttechnicalIndexes;
	}

	public void setTtechnicalIndexes(TtechnicalIndexes ttechnicalIndexes) {
		this.ttechnicalIndexes = ttechnicalIndexes;
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

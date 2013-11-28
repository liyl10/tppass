package com.hopsun.tppas.api.report.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TprojectOverviewAService;
import com.hopsun.tppas.entity.TprojectOverviewA;

public class TprojectOverviewAAction extends BaseAction {
	public final static Logger logger = Logger.getLogger(TprojectOverviewAAction.class.getName());

	private static final long serialVersionUID = 5678342830534050755L;
	@Resource
	private TprojectOverviewAService tprojectOverviewAService;
	/** 项目概况和市场分析 */
	private TprojectOverviewA tprojectOverviewa;
	/** 项目id */
	private String projectId;
	/** 项目状态 */
	private String applyStatus;

	/**
	 * 
	 * @comments 画面初始化
	 * @return
	 * @version 1.0
	 */
	public String showfileInsert() {
		HttpSession session = this.getRequest().getSession();
		// 取得登录用户的信息
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY, "showfileInsertt");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}
		this.projectId = this.getProjectId();
		this.applyStatus = this.getApplyStatus();
		this.tprojectOverviewa = tprojectOverviewAService.get("tprojectApplication.projectId", projectId);

		return "showfileInsert";
	}

	/**
	 * @return the tprojectOverviewAService
	 */
	public TprojectOverviewAService getTprojectOverviewAService() {
		return tprojectOverviewAService;
	}

	/**
	 * @param tprojectOverviewAService
	 *            the tprojectOverviewAService to set
	 */
	public void setTprojectOverviewAService(TprojectOverviewAService tprojectOverviewAService) {
		this.tprojectOverviewAService = tprojectOverviewAService;
	}

	/**
	 * @return the tprojectOverviewa
	 */
	public TprojectOverviewA getTprojectOverviewa() {
		return tprojectOverviewa;
	}

	/**
	 * @param tprojectOverviewa
	 *            the tprojectOverviewa to set
	 */
	public void setTprojectOverviewa(TprojectOverviewA tprojectOverviewa) {
		this.tprojectOverviewa = tprojectOverviewa;
	}

	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId
	 *            the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the applyStatus
	 */
	public String getApplyStatus() {
		return applyStatus;
	}

	/**
	 * @param applyStatus
	 *            the applyStatus to set
	 */
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

}

package com.hopsun.tppas.api.report.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TschedulingAService;
import com.hopsun.tppas.entity.TschedulingA;

public class TschedulingAAction extends BaseAction {
	public final static Logger logger = Logger.getLogger(TschedulingAAction.class.getName());

	private static final long serialVersionUID = -3611512177093093894L;
	@Resource
	private TschedulingAService tschedulingAService;
	/** 进度安排及预期达到的技术（含技术产权状况）和经济指标 */
	private TschedulingA tschedulinga;
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
		// session.setAttribute(Constants.SESSION_CMDKEY, "showfileInsert");
		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}

		this.projectId = this.getProjectId();
		this.applyStatus = this.getApplyStatus();
		this.tschedulinga = tschedulingAService.get("tprojectApplication.projectId", projectId);

		return "showschedulinga";
	}

	/**
	 * @comments 进度安排及预期达到的技术（非高新）
	 * @return
	 * @Version 1.0
	 */
	public String showTschedulingANonTech() {

		HttpSession session = this.getRequest().getSession();
		// 取得登录用户的信息
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY,
		// "showTschedulingANonTech");
		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}
		// 取得项目Id
		this.projectId = this.getProjectId();

		// 取得项目状态
		this.applyStatus = this.getApplyStatus();

		tschedulinga = tschedulingAService.get("tprojectApplication.projectId", projectId);

		return "showTschedulingANonTech";
	}

	/**
	 * @return the tschedulingAService
	 */
	public TschedulingAService getTschedulingAService() {
		return tschedulingAService;
	}

	/**
	 * @param tschedulingAService
	 *            the tschedulingAService to set
	 */
	public void setTschedulingAService(TschedulingAService tschedulingAService) {
		this.tschedulingAService = tschedulingAService;
	}

	/**
	 * @return the tschedulinga
	 */
	public TschedulingA getTschedulinga() {
		return tschedulinga;
	}

	/**
	 * @param tschedulinga
	 *            the tschedulinga to set
	 */
	public void setTschedulinga(TschedulingA tschedulinga) {
		this.tschedulinga = tschedulinga;
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

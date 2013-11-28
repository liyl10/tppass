package com.hopsun.tppas.api.report.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TtechnicalContentAService;
import com.hopsun.tppas.entity.TtechnicalContentA;

public class TtechnicalContentAAction extends BaseAction {
	public final static Logger logger = Logger.getLogger(TtechnicalContentAAction.class.getName());

	private static final long serialVersionUID = 1343138012408285922L;
	@Resource
	private TtechnicalContentAService ttechnicalContentAService;
	/** 主要技术内容与技术创新点 */
	private TtechnicalContentA technicalContenta;
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
		// session.setAttribute(Constants.SESSION_CMDKEY, "tshowfileInsert");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}
		this.projectId = this.getProjectId();
		this.applyStatus = this.getApplyStatus();
		this.technicalContenta = ttechnicalContentAService.get("tprojectApplication.projectId", projectId);

		return "showfileInsert";
	}

	/**
	 * @comments 显示主要技术内容与技术创新点（非高新）
	 * @return
	 * @Version 1.0
	 */
	public String showTechnicalNonTech() {
		HttpSession session = this.getRequest().getSession();
		// 取得登录用户的信息
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY,
		// "showTechnicalNonTech");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}

		technicalContenta = ttechnicalContentAService.get("tprojectApplication.projectId", projectId);

		return "showTechnicalNonTech";
	}

	/**
	 * @return the ttechnicalContentAService
	 */
	public TtechnicalContentAService getTtechnicalContentAService() {
		return ttechnicalContentAService;
	}

	/**
	 * @param ttechnicalContentAService
	 *            the ttechnicalContentAService to set
	 */
	public void setTtechnicalContentAService(TtechnicalContentAService ttechnicalContentAService) {
		this.ttechnicalContentAService = ttechnicalContentAService;
	}

	/**
	 * @return the technicalContenta
	 */
	public TtechnicalContentA getTechnicalContenta() {
		return technicalContenta;
	}

	/**
	 * @param technicalContenta
	 *            the technicalContenta to set
	 */
	public void setTechnicalContenta(TtechnicalContentA technicalContenta) {
		this.technicalContenta = technicalContenta;
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

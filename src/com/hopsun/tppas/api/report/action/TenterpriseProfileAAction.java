package com.hopsun.tppas.api.report.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TenterpriseProfileAService;
import com.hopsun.tppas.entity.TenterpriseProfileA;

public class TenterpriseProfileAAction extends BaseAction {
	public final static Logger logger = Logger.getLogger(TenterpriseProfileAAction.class.getName());

	private static final long serialVersionUID = 7065151600843613333L;
	@Resource
	private TenterpriseProfileAService tenterpriseProfileAService;
	/** 企业简介 */
	private TenterpriseProfileA tenterpriseProfilea;
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
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY, "fileInsert");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}
		this.projectId = this.getProjectId();
		this.tenterpriseProfilea = tenterpriseProfileAService.get("tprojectApplication.projectId", projectId);

		return "showfileInsert";
	}

	/**
	 * @return the tenterpriseProfileAService
	 */
	public TenterpriseProfileAService getTenterpriseProfileAService() {
		return tenterpriseProfileAService;
	}

	/**
	 * @param tenterpriseProfileAService
	 *            the tenterpriseProfileAService to set
	 */
	public void setTenterpriseProfileAService(TenterpriseProfileAService tenterpriseProfileAService) {
		this.tenterpriseProfileAService = tenterpriseProfileAService;
	}

	/**
	 * @return the tenterpriseProfilea
	 */
	public TenterpriseProfileA getTenterpriseProfilea() {
		return tenterpriseProfilea;
	}

	/**
	 * @param tenterpriseProfilea
	 *            the tenterpriseProfilea to set
	 */
	public void setTenterpriseProfilea(TenterpriseProfileA tenterpriseProfilea) {
		this.tenterpriseProfilea = tenterpriseProfilea;
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

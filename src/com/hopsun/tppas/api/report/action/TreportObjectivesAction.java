/*************** 版权声明***************
 *
 * Copyright (C) 2013 西安辉盛科技发展有限责任公司.
 *
 ********************************************
 */
package com.hopsun.tppas.api.report.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.report.service.TreportObjectivesService;
import com.hopsun.tppas.entity.TreportObjectives;

/**
 * @comments 项目实施目标
 * @author weina
 * @date 2013-9-28 @time 下午6:10:57
 * @Version 1.0
 */
public class TreportObjectivesAction extends BaseAction {
	public final static Logger LOGGER = Logger.getLogger(TreportObjectivesAction.class.getName());
	private static final long serialVersionUID = -8897277738064418240L;

	// weina start
	@Resource
	private TreportObjectivesService treportObjectivesService;
	@Resource
	private TprojectApplicationService tprojectApplicationService;

	/** 项目状态 */
	private String applyStatus;
	/** 项目ID */
	private String projectId;
	/** 项目投资计划 */
	private TreportObjectives treportObjectives;
	/** 项目实施目标ID */
	private String objectivesId;
	/** 跳转路径 */
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;

	/**
	 * @comments 显示项目实施目标
	 * @return
	 * @Version 1.0
	 */
	public String showTreportObjectives() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY, "showTreportObjectives");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			LOGGER.error("用户不存在！");
			return "LogOut";
		}

		// 取得项目Id
		this.projectId = this.getProjectId();

		// 取得项目状态
		this.applyStatus = this.getApplyStatus();

		// 取得项目实施目标
		this.treportObjectives = treportObjectivesService.get("tprojectApplication.projectId", projectId);

		return "showtreportobjectives";
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

	public TreportObjectivesService getTreportObjectivesService() {
		return treportObjectivesService;
	}

	public void setTreportObjectivesService(TreportObjectivesService treportObjectivesService) {
		this.treportObjectivesService = treportObjectivesService;
	}

	public TreportObjectives getTreportObjectives() {
		return treportObjectives;
	}

	public void setTreportObjectives(TreportObjectives treportObjectives) {
		this.treportObjectives = treportObjectives;
	}

	public String getObjectivesId() {
		return objectivesId;
	}

	public void setObjectivesId(String objectivesId) {
		this.objectivesId = objectivesId;
	}

	public TprojectApplicationService getTprojectApplicationService() {
		return tprojectApplicationService;
	}

	public void setTprojectApplicationService(TprojectApplicationService tprojectApplicationService) {
		this.tprojectApplicationService = tprojectApplicationService;
	}
	// weina end
}

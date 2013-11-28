/*************** 版权声明***************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ********************************************
 */
package com.hopsun.tppas.api.report.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TreportAbstractBService;
import com.hopsun.tppas.entity.TreportAbstractB;

/**
 * @comment 摘要说明(非高新)
 * @author liush
 * @DATE: 2013-8-29 @TIME: 下午2:36:55
 * @Vsersion: 1.0
 */
public class TreportAbstractBAction extends BaseAction {
	public final static Logger logger = Logger.getLogger(TreportAbstractBAction.class.getName());
	private static final long serialVersionUID = -1495556756502107000L;
	@Resource
	private TreportAbstractBService treportAbstractBService;

	/** 摘要说明对象 */
	private TreportAbstractB treportAbstractB;

	/** 项目ID */
	private String projectId;

	/**
	 * @comments 显示摘要说明
	 * @return
	 * @Version 1.0
	 */
	public String showReportAbstractB() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY, "reportAbstractB");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}

		// 取得摘要说明
		this.treportAbstractB = treportAbstractBService.get("tprojectApplication.projectId", projectId);

		return "showReportAbstractB";
	}

	public TreportAbstractBService getTreportAbstractBService() {
		return treportAbstractBService;
	}

	public void setTreportAbstractBService(TreportAbstractBService treportAbstractBService) {
		this.treportAbstractBService = treportAbstractBService;
	}

	public TreportAbstractB getTreportAbstractB() {
		return treportAbstractB;
	}

	public void setTreportAbstractB(TreportAbstractB treportAbstractB) {
		this.treportAbstractB = treportAbstractB;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
}

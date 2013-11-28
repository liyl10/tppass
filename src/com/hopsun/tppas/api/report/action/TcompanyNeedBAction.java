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
import com.hopsun.tppas.api.report.service.TcompanyNeedBService;
import com.hopsun.tppas.entity.TcompanyNeedB;

/**
 * @comment 国内外研究水平、发展趋势和市场需求(非高新)
 * @author liush
 * @DATE: 2013-8-29 @TIME: 下午3:45:19
 * @Vsersion: 1.0
 */
public class TcompanyNeedBAction extends BaseAction {
	public final static Logger logger = Logger.getLogger(TcompanyNeedBAction.class.getName());

	private static final long serialVersionUID = -2926219253285823570L;
	@Resource
	private TcompanyNeedBService tcompanyNeedBService;

	/** 项目ID */
	private String projectId;
	/** 摘要说明对象 */
	private TcompanyNeedB tcompanyNeedB;

	/**
	 * @comments 显示国内外研究水平、发展趋势和市场需求(非高新)
	 * @return
	 * @Version 1.0
	 */
	public String showCompanyNeedB() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY, "companyNeedB");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}

		// 取得示国内外研究水平、发展趋势和市场需求
		this.tcompanyNeedB = tcompanyNeedBService.get("tprojectApplication.projectId", projectId);

		return "showCompanyNeedB";
	}

	public TcompanyNeedBService getTcompanyNeedBService() {
		return tcompanyNeedBService;
	}

	public void setTcompanyNeedBService(TcompanyNeedBService tcompanyNeedBService) {
		this.tcompanyNeedBService = tcompanyNeedBService;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public TcompanyNeedB getTcompanyNeedB() {
		return tcompanyNeedB;
	}

	public void setTcompanyNeedB(TcompanyNeedB tcompanyNeedB) {
		this.tcompanyNeedB = tcompanyNeedB;
	}
}

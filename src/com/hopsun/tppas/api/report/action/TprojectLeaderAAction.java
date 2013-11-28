/*************** 版权声明***************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ********************************************
 */
package com.hopsun.tppas.api.report.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.report.service.TprojectLeaderAService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectLeaderA;

/**
 * @comment 项目负责人及主要人员
 * @author wanglw
 * @DATE: 2013-9-26 @TIME: 下午9:06:41
 * @Vsersion: 1.0
 */
public class TprojectLeaderAAction extends BaseAction {

	private static final long serialVersionUID = 66268830126487999L;

	public final static Logger LOGGER = Logger.getLogger(TprojectLeaderAAction.class.getName());
	@Resource
	private TprojectLeaderAService tprojectLeaderAService;
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	private TprojectApplication tprojectApplication;
	private String applyStatus;
	/** 性别 */
	private List<String> sexFlagList;
	private String projectId;
	/** 翻页 */
	private int pageNo;
	/** 跳转路径 */
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;
	private String projectLeaderAId;
	private TprojectLeaderA tprojectLeaderA;

	/**
	 * @comments 根据研究人员ID分页查询
	 * @return
	 * @version 1.0
	 */
	public String list() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// session.setAttribute(Constants.SESSION_CMDKEY,
		// "tprojectLeaderAAction");

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		// 翻页
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}
		if (projectId != null) {

			this.tprojectApplication = tprojectApplicationService.get(projectId);
			if (tprojectApplication != null) {
				if (Constants.PROJECT_REPORT_NOTPASS.equals(tprojectApplication.getApplyStatus()) || Constants.PROJECT_REPORT_WRITE.equals(tprojectApplication.getApplyStatus())) {
					this.applyStatus = "1";
				} else {
					this.applyStatus = "0";
				}
			}
		}
		// 获取项目申报的列表数据
		pager = tprojectLeaderAService.find(projectId, pager.getPageNumber(), pager.getPageSize());

		return "researcherlist";
	}

	/**
	 * 
	 * @comments 跳转到添加页面 初始化
	 * @return
	 * @version 1.0
	 */
	public String showResearcher() {

		/*
		 * HttpSession session = this.getRequest().getSession(); String cmdkey =
		 * (String) session.getAttribute(Constants.SESSION_CMDKEY); if (cmdkey
		 * == null || !"tprojectLeaderAAction".equals(cmdkey)) {
		 * LOGGER.error("错误的令牌！"); return "LogOut"; }
		 */

		// 性别
		this.sexFlagList = new ArrayList<String>();
		this.sexFlagList.add("男");
		this.sexFlagList.add("女");
		if (projectLeaderAId != null && !"".equals(projectLeaderAId)) {
			this.tprojectLeaderA = tprojectLeaderAService.get(projectLeaderAId);
		}
		return "showresearcher";
	}

	public List<String> getSexFlagList() {
		return sexFlagList;
	}

	public void setSexFlagList(List<String> sexFlagList) {
		this.sexFlagList = sexFlagList;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
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

	public TprojectApplicationService getTprojectApplicationService() {
		return tprojectApplicationService;
	}

	public void setTprojectApplicationService(TprojectApplicationService tprojectApplicationService) {
		this.tprojectApplicationService = tprojectApplicationService;
	}

	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public TprojectLeaderAService getTprojectLeaderAService() {
		return tprojectLeaderAService;
	}

	public void setTprojectLeaderAService(TprojectLeaderAService tprojectLeaderAService) {
		this.tprojectLeaderAService = tprojectLeaderAService;
	}

	public String getProjectLeaderAId() {
		return projectLeaderAId;
	}

	public void setProjectLeaderAId(String projectLeaderAId) {
		this.projectLeaderAId = projectLeaderAId;
	}

	public TprojectLeaderA getTprojectLeaderA() {
		return tprojectLeaderA;
	}

	public void setTprojectLeaderA(TprojectLeaderA tprojectLeaderA) {
		this.tprojectLeaderA = tprojectLeaderA;
	}
}

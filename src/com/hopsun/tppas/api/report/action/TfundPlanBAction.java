/*************** 版权声明***************
 *
 * Copyright (C) 2013 西安辉盛科技发展有限责任公司.
 *
 ********************************************
 */
package com.hopsun.tppas.api.report.action;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TfundPlanBService;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.entity.TfundPlanB;
import com.hopsun.tppas.entity.TprojectApplication;

/**
 * @comments 项目投资计划
 * @author weina
 * @date 2013-9-26 @time 下午5:10:57
 * @Version 1.0
 */
public class TfundPlanBAction extends BaseAction {

	private static final long serialVersionUID = -8897277738064418240L;

	public final static Logger logger = Logger.getLogger(TfundPlanBAction.class.getName());

	// weina start
	@Resource
	private TfundPlanBService tfundPlanBService;

	@Resource
	private TprojectApplicationService tprojectApplicationService;

	/** 项目状态 */
	private String applyStatus;
	/** 项目ID */
	private String projectId;
	/** 项目投资计划 */
	private TfundPlanB tfundPlanB;
	/** 项目申报信息 */
	private TprojectApplication tprojectApplication;
	/** 项目投资ID */
	private String fundPlanBId;
	private String year1;
	private String year2;
	private String year3;
	/** 跳转路径 */
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;

	/**
	 * @comments 显示资金用途及用款计划
	 * @return
	 * @Version 1.0
	 */
	public String showFundPlanB() {
		HttpSession session = this.getRequest().getSession();
		// 取得登录用户的信息
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY, "showFundPlanB");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}
		// 取得项目Id
		this.projectId = this.getProjectId();

		// 取得项目状态
		this.applyStatus = this.getApplyStatus();

		// 取得用款计划
		this.tfundPlanB = tfundPlanBService.get("tprojectApplication.projectId", projectId);
		// 项目信息
		this.tprojectApplication = tprojectApplicationService.get(projectId);

		int beingYear = Integer.valueOf(new SimpleDateFormat("yyyy").format(tprojectApplication.getStartTime()));
		int endYear = Integer.valueOf(new SimpleDateFormat("yyyy").format(tprojectApplication.getEndTime()));

		// 判断执行期限
		if (endYear - beingYear == 2) {
			year1 = String.valueOf(beingYear);
			year2 = String.valueOf(beingYear + 1);
			year3 = String.valueOf(endYear);
		} else if (endYear - beingYear == 1) {
			year1 = String.valueOf(beingYear);
			year2 = String.valueOf(endYear);
		} else if (endYear - beingYear == 0) {
			year1 = String.valueOf(beingYear);
		}
		return "showFundPlanB";
	}

	/**
	 * @comments 新增
	 * @return
	 * @Version 1.0
	 */
	public String insert() {

		return "";

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

	public TfundPlanB getTfundPlanB() {
		return tfundPlanB;
	}

	public void setTfundPlanB(TfundPlanB tfundPlanB) {
		this.tfundPlanB = tfundPlanB;
	}

	public TfundPlanBService getTfundPlanBService() {
		return tfundPlanBService;
	}

	public void setTfundPlanBService(TfundPlanBService tfundPlanBService) {
		this.tfundPlanBService = tfundPlanBService;
	}

	public TprojectApplicationService getTprojectApplicationService() {
		return tprojectApplicationService;
	}

	public void setTprojectApplicationService(TprojectApplicationService tprojectApplicationService) {
		this.tprojectApplicationService = tprojectApplicationService;
	}

	public String getFundPlanBId() {
		return fundPlanBId;
	}

	public void setFundPlanBId(String fundPlanBId) {
		this.fundPlanBId = fundPlanBId;
	}

	public String getYear1() {
		return year1;
	}

	public void setYear1(String year1) {
		this.year1 = year1;
	}

	public String getYear2() {
		return year2;
	}

	public void setYear2(String year2) {
		this.year2 = year2;
	}

	public String getYear3() {
		return year3;
	}

	public void setYear3(String year3) {
		this.year3 = year3;
	}

	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	// weina end
}

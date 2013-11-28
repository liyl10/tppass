package com.hopsun.tppas.api.report.action;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TcostEstimateBService;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TcostEstimateB;
import com.hopsun.tppas.entity.TprojectApplication;

public class TcostEstimateBAction extends BaseAction {
	public final static Logger LOGGER = Logger.getLogger(TcostEstimateBAction.class.getName());

	private static final long serialVersionUID = 7112890099268197592L;
	@Resource
	private TcostEstimateBService tcostEstimateBService;
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	private TprojectApplication tprojectApplication;
	private TcostEstimateB tcostEstimateB;
	/** 项目id */
	private String projectId;
	/** 项目状态 */
	private String applyStatus;
	private String costEstimateId;
	private String tempFlg;
	private String year;

	/**
	 * @Comments 页面初期化
	 * @return
	 * @Vsersion: 1.0
	 */
	public String list() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY, "tcostEstimateB");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			LOGGER.error("用户不存在！");
			return "LogOut";
		}

		tprojectApplication = tprojectApplicationService.get(projectId);
		if(tprojectApplication != null){
			year = new SimpleDateFormat("yyyy").format(tprojectApplication.getStartTime());
			
		}

		// 判断是否为产业处
		if (tprojectApplication != null && tprojectApplication.getTprojectType() != null) {
			// 产业处
			if (Constants.HIGHTECH_DEPARTMENT.equals(tprojectApplication.getTprojectType().getDepartmentId())) {
				tempFlg = "1";
			} else {
				tempFlg = "0";
			}
		}

		tcostEstimateB = tcostEstimateBService.get("tprojectApplication.projectId", projectId);
		return "list";
	}

	/**
	 * @return the tcostEstimateBService
	 */
	public TcostEstimateBService getTcostEstimateBService() {
		return tcostEstimateBService;
	}

	/**
	 * @param tcostEstimateBService
	 *            the tcostEstimateBService to set
	 */
	public void setTcostEstimateBService(TcostEstimateBService tcostEstimateBService) {
		this.tcostEstimateBService = tcostEstimateBService;
	}

	/**
	 * @return the tprojectApplicationService
	 */
	public TprojectApplicationService getTprojectApplicationService() {
		return tprojectApplicationService;
	}

	/**
	 * @param tprojectApplicationService
	 *            the tprojectApplicationService to set
	 */
	public void setTprojectApplicationService(TprojectApplicationService tprojectApplicationService) {
		this.tprojectApplicationService = tprojectApplicationService;
	}

	/**
	 * @return the tprojectApplication
	 */
	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}

	/**
	 * @param tprojectApplication
	 *            the tprojectApplication to set
	 */
	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	/**
	 * @return the tcostEstimateB
	 */
	public TcostEstimateB getTcostEstimateB() {
		return tcostEstimateB;
	}

	/**
	 * @param tcostEstimateB
	 *            the tcostEstimateB to set
	 */
	public void setTcostEstimateB(TcostEstimateB tcostEstimateB) {
		this.tcostEstimateB = tcostEstimateB;
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

	/**
	 * @return the costEstimateId
	 */
	public String getCostEstimateId() {
		return costEstimateId;
	}

	/**
	 * @param costEstimateId
	 *            the costEstimateId to set
	 */
	public void setCostEstimateId(String costEstimateId) {
		this.costEstimateId = costEstimateId;
	}

	/**
	 * @return the tempFlg
	 */
	public String getTempFlg() {
		return tempFlg;
	}

	/**
	 * @param tempFlg
	 *            the tempFlg to set
	 */
	public void setTempFlg(String tempFlg) {
		this.tempFlg = tempFlg;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}

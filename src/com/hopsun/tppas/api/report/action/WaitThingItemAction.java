package com.hopsun.tppas.api.report.action;

import java.util.List;

import javax.annotation.Resource;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.tppas.api.report.service.TplanService;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tplan;
import com.hopsun.tppas.entity.TprojectApplication;

/**
 * @comments 待办事项
 * @author yk
 * @date 2013-07-31
 * @version 1.0
 */
public class WaitThingItemAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	@Resource
	private TprojectApplicationService tprojectApplicationService;

	@Resource
	private TplanService tplanService;

	private List<TprojectApplication> listProjectApplicationApplyState;

	private List<TprojectApplication> listProjectApplicationFlowState;

	private List<Tplan> listtPlan;

	/**
	 * 获取代办事项带调配项目列表、待计划编制项目列表
	 * 
	 * @return
	 */
	public String query() {
		// HttpSession session = this.getRequest().getSession();
		// session.setAttribute(Constants.SESSION_CMDKEY,"waitThingItemAction");
		listProjectApplicationApplyState = tprojectApplicationService.queryProjectApplicationByApplyState(Constants.PROJECTAPPLICATION_APPLYSTATE);
		String[] params = new String[] { "'" + Constants.TACCEPTANCE_END + "'," + "'" + Constants.TACCEPTANCE_TACCEPTANCEGOOD + "'," + "'" + Constants.TACCEPTANCE_GOOD + "'",
				"'" + Constants.PROJECTAPPLICATION_FLOWSTATUS + "'," + "'" + Constants.PLAN_BUSINESSAPPOVE_STATE + "'" };
		listProjectApplicationFlowState = tprojectApplicationService.queryProjectApplicationByFlowState(params);
		listtPlan = tplanService.queryTPlanByPlanState(Constants.PLAN_SUBPLANSTATE);
		return "projectApplicationApplyState";
	}

	public List<TprojectApplication> getListProjectApplicationApplyState() {
		return listProjectApplicationApplyState;
	}

	public void setListProjectApplicationApplyState(List<TprojectApplication> listProjectApplicationApplyState) {
		this.listProjectApplicationApplyState = listProjectApplicationApplyState;
	}

	public List<TprojectApplication> getListProjectApplicationFlowState() {
		return listProjectApplicationFlowState;
	}

	public void setListProjectApplicationFlowState(List<TprojectApplication> listProjectApplicationFlowState) {
		this.listProjectApplicationFlowState = listProjectApplicationFlowState;
	}

	public List<Tplan> getListtPlan() {
		return listtPlan;
	}

	public void setListtPlan(List<Tplan> listtPlan) {
		this.listtPlan = listtPlan;
	}

}

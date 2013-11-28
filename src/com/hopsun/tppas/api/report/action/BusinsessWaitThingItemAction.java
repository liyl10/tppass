package com.hopsun.tppas.api.report.action;

import java.util.List;

import javax.annotation.Resource;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.tppas.api.acceptance.service.TacceptanceService;
import com.hopsun.tppas.api.contract.service.TcontractService;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.supervisor.service.TsupervisorService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tacceptance;
import com.hopsun.tppas.entity.Tcontract;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.Tsupervisor;

/**
 * @comments 业务处-待办事项
 * @author yk
 * @date 2013-08-08
 * @version 1.0
 */
public class BusinsessWaitThingItemAction extends BaseAction {

	private static final long serialVersionUID = -2980568850457415830L;

	@Resource
	private transient TprojectApplicationService tprojectApplicationService;

	@Resource
	private transient TcontractService tcontractService;

	@Resource
	private transient TsupervisorService tsupervisorService;

	@Resource
	private transient TacceptanceService tacceptanceService;

	@Resource
	private MitemService apiMitemService;
	/**
	 * 项目待初审
	 */
	private List<TprojectApplication> listProjectApplicationWaitCheck;

	/**
	 * 待审核项目
	 */
	public List<TprojectApplication> listWaitingApplicationCheckState;

	/**
	 * 待处长审核项目
	 */
	public List<TprojectApplication> listWaitChuzhangCheckProject;

	/**
	 * 待合同审核项目
	 */

	public List<Tcontract> listWaitContractCheckProject;

	/**
	 * 待监理项目
	 */
	public List<Tsupervisor> listWaitSupervisorProject;

	/**
	 * 待验收合同
	 */
	public List<Tacceptance> listWaitAcceptanceProject;

	/**
	 * 获取代办事项带调配项目列表、待计划编制项目列表
	 * 
	 * @return
	 */
	public String query() {
		// HttpSession session = this.getRequest().getSession();
		// session.setAttribute(Constants.SESSION_CMDKEY,"businsessWaitThingItemAction");
		/**
		 * 获取初审项目
		 */
		listProjectApplicationWaitCheck = tprojectApplicationService.queryProjectApplicationByApplyState(Constants.BUSINSESSPROJECTFIRSTCHECK_STATE);
		listWaitingApplicationCheckState = tprojectApplicationService.queryProjectApplicationByApplyState(Constants.BUSINESSPROJECTWATINGCHECK_STATE);
		listWaitChuzhangCheckProject = tprojectApplicationService.queryProjectApplicationByApplyState(Constants.BUSINESSPROJECTCHUZHANGCHECK_STATE);
		listWaitContractCheckProject = tcontractService.queryTacceptanceByState(Constants.WAITTINGCHECKCONSTRUTCT_STATE);
		listWaitSupervisorProject = tsupervisorService.queryTsupervisorByState(Constants.WAITINGPROJECT_JIANLI_STATE);
		listWaitAcceptanceProject = tacceptanceService.queryTacceptanceByState(Constants.WAITINGPROJECT_CHECK_STATE);
		return "success";
	}

	public List<TprojectApplication> getListProjectApplicationWaitCheck() {
		return listProjectApplicationWaitCheck;
	}

	public void setListProjectApplicationWaitCheck(List<TprojectApplication> listProjectApplicationWaitCheck) {
		this.listProjectApplicationWaitCheck = listProjectApplicationWaitCheck;
	}

	public List<TprojectApplication> getListWaitingApplicationCheckState() {
		return listWaitingApplicationCheckState;
	}

	public void setListWaitingApplicationCheckState(List<TprojectApplication> listWaitingApplicationCheckState) {
		this.listWaitingApplicationCheckState = listWaitingApplicationCheckState;
	}

	public List<TprojectApplication> getListWaitChuzhangCheckProject() {
		return listWaitChuzhangCheckProject;
	}

	public void setListWaitChuzhangCheckProject(List<TprojectApplication> listWaitChuzhangCheckProject) {
		this.listWaitChuzhangCheckProject = listWaitChuzhangCheckProject;
	}

	public List<Tcontract> getListWaitContractCheckProject() {
		return listWaitContractCheckProject;
	}

	public void setListWaitContractCheckProject(List<Tcontract> listWaitContractCheckProject) {
		this.listWaitContractCheckProject = listWaitContractCheckProject;
	}

	public List<Tsupervisor> getListWaitSupervisorProject() {
		return listWaitSupervisorProject;
	}

	public void setListWaitSupervisorProject(List<Tsupervisor> listWaitSupervisorProject) {
		this.listWaitSupervisorProject = listWaitSupervisorProject;
	}

	public List<Tacceptance> getListWaitAcceptanceProject() {
		return listWaitAcceptanceProject;
	}

	public void setListWaitAcceptanceProject(List<Tacceptance> listWaitAcceptanceProject) {
		this.listWaitAcceptanceProject = listWaitAcceptanceProject;
	}

	public MitemService getApiMitemService() {
		return apiMitemService;
	}

	public void setApiMitemService(MitemService apiMitemService) {
		this.apiMitemService = apiMitemService;
	}

}

package com.hopsun.tppas.api.report.action;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TfundingPlanReportService;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TfundingPlanReport;
import com.hopsun.tppas.entity.TprojectApplication;

/**
 * @comments 申请经费
 * @date 2013-8-28 @time 下午1:07:40
 * @Version 1.0
 */
public class TfundingPlanReportAction extends BaseAction {
	public final static Logger logger = Logger.getLogger(TfundingPlanReportAction.class.getName());
	private static final long serialVersionUID = 473689651341240305L;

	@Resource
	private TfundingPlanReportService tfundingPlanReportService;
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	@Resource
	private TprojectTypeService apitprojectTypeService;

	/** 项目 */
	private TprojectApplication tprojectApplication;
	/** 项目id */
	private String projectId;
	/** 合同填报步骤 */
	private List<Map<String, String>> contractStep;
	/** 模板类型 */
	private String modelType;
	/** 合同状态 */
	private String contractStatus;
	/** 跳转URL */
	private String retUrl;
	/** 跳转message */
	private String retMsg;
	/** 按钮是否显示标记 */
	private String Flag;
	/** 菜单List */
	private List<Mitem> menuList;
	/** 近一年 */
	private int year1;
	/** 近两年 */
	private int year2;
	/** 近三年 */
	private int year3;
	/** 年份标志 */
	private String yearFlag;
	/** 项目状态 */
	private String applyStatus;
	/** 企业信息显示Flag */
	private String isWriteFlag;
	/** 项目经费计划表 */
	private TfundingPlanReport tfundingPlanReport;

	/**
	 * @comments 画面初始化
	 * @return
	 * @Version 1.0
	 */
	public String execute() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// 取得登录用户的信息
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// session.setAttribute(Constants.SESSION_CMDKEY,
		// "showTexpectedResults");

		// 判断是否失效
		if (user == null || ("").equals(user.getUserId())) {
			logger.error("用户不存在！");
			return "LogOut";
		}

		tfundingPlanReport = tfundingPlanReportService.get("tprojectApplication.projectId", projectId);
		tprojectApplication = tprojectApplicationService.get(projectId);
		// 取得项目状态
		this.applyStatus = this.getApplyStatus();
		String startTime = null;
		String endTime = null;
		String startYear = null;
		String endYear = null;
		if (tprojectApplication != null) {
			if (tprojectApplication.getStartTime() != null) {
				startTime = String.valueOf(tprojectApplication.getStartTime());
				endTime = String.valueOf(tprojectApplication.getEndTime());
			}
		}
		if (startTime != null && endTime != null) {
			startYear = startTime.substring(0, 4);
			endYear = endTime.substring(0, 4);
			int sum = Integer.valueOf(endYear) - Integer.valueOf(startYear);
			if (sum == 1) {
				year1 = Integer.valueOf(startYear);
				year2 = Integer.valueOf(endYear);
				year3 = Integer.valueOf(endYear) + 1;
				this.yearFlag = "0";
			} else {
				year1 = Integer.valueOf(startYear);
				year2 = Integer.valueOf(startYear) + 1;
				year3 = Integer.valueOf(endYear);
				this.yearFlag = "1";
			}
		}

		// 是否存在企业信息
		if (apitprojectTypeService.getIsWrite(projectId)) {
			this.isWriteFlag = "1";
		} else {
			this.isWriteFlag = "0";
		}

		return "showfundingPlan";
	}

	/**
	 * 获得当前时间
	 * 
	 * @comments
	 * @return
	 * @version 1.0
	 */
	public String getYear() {
		Date now = new Date();
		// Calendar cal = Calendar.getInstance();
		DateFormat d1 = DateFormat.getDateInstance();
		String str1 = d1.format(now);
		return str1;
	}

	public TfundingPlanReport getTfundingPlanReport() {
		return tfundingPlanReport;
	}

	public void setTfundingPlanReport(TfundingPlanReport tfundingPlanReport) {
		this.tfundingPlanReport = tfundingPlanReport;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<Map<String, String>> getContractStep() {
		return contractStep;
	}

	public void setContractStep(List<Map<String, String>> contractStep) {
		this.contractStep = contractStep;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
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

	public String getFlag() {
		return Flag;
	}

	public void setFlag(String flag) {
		Flag = flag;
	}

	public List<Mitem> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Mitem> menuList) {
		this.menuList = menuList;
	}

	public int getYear1() {
		return year1;
	}

	public void setYear1(int year1) {
		this.year1 = year1;
	}

	public int getYear2() {
		return year2;
	}

	public void setYear2(int year2) {
		this.year2 = year2;
	}

	public int getYear3() {
		return year3;
	}

	public void setYear3(int year3) {
		this.year3 = year3;
	}

	public String getYearFlag() {
		return yearFlag;
	}

	public void setYearFlag(String yearFlag) {
		this.yearFlag = yearFlag;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	/**
	 * @return the isWriteFlag
	 */
	public String getIsWriteFlag() {
		return isWriteFlag;
	}

	/**
	 * @param isWriteFlag
	 *            the isWriteFlag to set
	 */
	public void setIsWriteFlag(String isWriteFlag) {
		this.isWriteFlag = isWriteFlag;
	}

}

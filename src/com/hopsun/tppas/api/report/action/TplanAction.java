package com.hopsun.tppas.api.report.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TplanService;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.report.service.TprojectInfoAService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Tplan;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectInfoA;

public class TplanAction extends BaseAction {

	private static final long serialVersionUID = 8425698640138143377L;
	@Resource
	private TplanService tplanService;
	@Resource
	private TprojectTypeService tprojectTypeService;
	@Resource
	private MitemService mitemService;
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	@Resource
	private TprojectInfoAService tprojectInfoAService;

	/** 分计划 */
	private Tplan tplan;
	/** 项目申报 */
	private TprojectApplication tprojectApplication;
	/** 项目申报列表 */
	private List<TprojectApplication> tprojectApplicationList;
	/** 项目基本信息 */
	private TprojectInfoA tprojectInfoA;
	/** 计划类别 */
	/*
	 * private List<TprojectType> projectTypeList1;
	 *//** 项目分类 */
	/*
	 * private List<TprojectType> projectTypeList2;
	 */
	/** 分计划状态 */
	private List<Mitem> planStateList;
	/** 计划批次 */
	private List<Mitem> planBatchList;
	/*	*//** 计划类别 */
	/*
	 * private String projectType1;
	 *//** 项目分类 */
	/*
	 * private String projectType2;
	 */
	/** 翻页 */
	private int pageNo;
	/** 分计划名称 */
	private String planName;
	/** 计划年度 */
	private String planYear;
	/** 分计划状态 */
	private String planState;
	/** 批次 */
	private String planBatch;
	/** 分计划id */
	private String planId;
	/** 项目分类id */
	private String typeId;
	/** 项目申报-项目名称 */
	private String projectName;
	/** 项目申报-申报单位 */
	private String applicationUnit;
	/** 项目申报-项目分类 */
	private String projectTypeName;
	/** 项目申报-单位性质 */
	private String unitProperties;
	/** 项目申报-当前项目状态 */
	private String applyStatus;
	/** 级联菜单返回值 */
	private String backStr;
	/** 跳转路径 */
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;

	/**
	 * 
	 * @comments 查询条件
	 * @return
	 * @version 1.0
	 */
	public String showPlanManage() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// session.setAttribute(Constants.SESSION_CMDKEY, "showPlanManage");

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		/*
		 * // 初始化计划类别 this.projectTypeList1 = new ArrayList<TprojectType>();
		 * this.projectTypeList1 =
		 * tprojectTypeService.getFatherProjectTypeListByDeptId(
		 * user.getScDept().getDeptId());
		 * 
		 * // 初始化项目分类 this.projectTypeList2 = new ArrayList<TprojectType>();
		 */

		// 分计划状态
		this.planStateList = new ArrayList<Mitem>();
		this.planStateList = mitemService.getListByTypeId(Constants.TYPE_PLAN_STATUS);

		// 计划批次
		this.planBatchList = new ArrayList<Mitem>();
		this.planBatchList = mitemService.getListByTypeId(Constants.TYPE_PLANBATCH_STATUS);

		return "showPlanManage";

	}

	/**
	 * @comments 分计划列表
	 * @return
	 * @Version 1.0
	 */
	public String getPlanList() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// String cmdkey =
		// (String)session.getAttribute(Constants.SESSION_CMDKEY);

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

		Map<String, Object> param = new HashMap<String, Object>();

		// 封装查询条件
		// 分计划id
		param.put("planId", planId);
		// 分计划名称
		param.put("planName", planName);

		// 计划年度
		param.put("planYear", planYear);

		// 分计划状态
		param.put("planState", planState);

		/*
		 * // 计划类别 param.put("projectType1", projectType1);
		 * 
		 * // 项目分类 param.put("projectType2", projectType2);
		 */

		// 批次
		param.put("planBatch", planBatch);

		// 取得项目一览信息
		pager = tplanService.getPlanList(param, pager.getPageNumber(), pager.getPageSize());

		return "getPlanList";
	}

	/**
	 * 查看分计划列表
	 * 
	 * @return String
	 */
	public String showPlanDetail() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// String cmdkey =
		// (String)session.getAttribute(Constants.SESSION_CMDKEY);

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

		// 根据外键planId获取项目申报的列表数据
		pager = tplanService.find(planId, pager.getPageNumber(), pager.getPageSize());

		return "showplandetaillist";

	}

	public TplanService getTplanService() {
		return tplanService;
	}

	public void setTplanService(TplanService tplanService) {
		this.tplanService = tplanService;
	}

	public List<Mitem> getPlanStateList() {
		return planStateList;
	}

	public void setPlanStateList(List<Mitem> planStateList) {
		this.planStateList = planStateList;
	}

	public List<Mitem> getPlanBatchList() {
		return planBatchList;
	}

	public void setPlanBatchList(List<Mitem> planBatchList) {
		this.planBatchList = planBatchList;
	}

	public TprojectTypeService getTprojectTypeService() {
		return tprojectTypeService;
	}

	public void setTprojectTypeService(TprojectTypeService tprojectTypeService) {
		this.tprojectTypeService = tprojectTypeService;
	}

	public MitemService getMitemService() {
		return mitemService;
	}

	public void setMitemService(MitemService mitemService) {
		this.mitemService = mitemService;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanYear() {
		return planYear;
	}

	public void setPlanYear(String planYear) {
		this.planYear = planYear;
	}

	public String getPlanState() {
		return planState;
	}

	public void setPlanState(String planState) {
		this.planState = planState;
	}

	public String getPlanBatch() {
		return planBatch;
	}

	public void setPlanBatch(String planBatch) {
		this.planBatch = planBatch;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getBackStr() {
		return backStr;
	}

	public void setBackStr(String backStr) {
		this.backStr = backStr;
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

	public Tplan getTplan() {
		return tplan;
	}

	public void setTplan(Tplan tplan) {
		this.tplan = tplan;
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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getApplicationUnit() {
		return applicationUnit;
	}

	public void setApplicationUnit(String applicationUnit) {
		this.applicationUnit = applicationUnit;
	}

	public String getProjectTypeName() {
		return projectTypeName;
	}

	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}

	public String getUnitProperties() {
		return unitProperties;
	}

	public void setUnitProperties(String unitProperties) {
		this.unitProperties = unitProperties;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public TprojectInfoA getTprojectInfoA() {
		return tprojectInfoA;
	}

	public void setTprojectInfoA(TprojectInfoA tprojectInfoA) {
		this.tprojectInfoA = tprojectInfoA;
	}

	public TprojectInfoAService getTprojectInfoAService() {
		return tprojectInfoAService;
	}

	public void setTprojectInfoAService(TprojectInfoAService tprojectInfoAService) {
		this.tprojectInfoAService = tprojectInfoAService;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public List<TprojectApplication> getTprojectApplicationList() {
		return tprojectApplicationList;
	}

	public void setTprojectApplicationList(List<TprojectApplication> tprojectApplicationList) {
		this.tprojectApplicationList = tprojectApplicationList;
	}

}

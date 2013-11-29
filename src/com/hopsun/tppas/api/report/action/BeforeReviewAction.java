package com.hopsun.tppas.api.report.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeManagerService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TprojectType;

public class BeforeReviewAction extends BaseAction {

	private static final long serialVersionUID = -1979934962468943400L;
	@Resource
	private TprojectApplicationService tprojectApplicationService;

	@Resource
	private MitemService mitemService;

	@Resource
	private TprojectTypeService tprojectTypeService;

	@Resource
	private TprojectTypeManagerService tprojectTypeManagerService;

	/** 翻页 */
	private int pageNo;

	/** 单位性质 */
	private List<Mitem> companyTypeList;

	/** 计划类别 */
	private List<TprojectType> projectTypeFirstList = new ArrayList<TprojectType>();;
	private List<TprojectType> projectTypeSecondList = new ArrayList<TprojectType>();;

	/** 审核状态 */
	private List<Mitem> auditStatusList;

	/** 单位性质(选中) */
	private String companyType;

	/** 计划类别(选中) */
	private String selectedProjectTypeFirst;

	/** 计划类别(选中) */
	private String selectedProjectTypeSecond;

	/** 审核状态(选中) */
	private String auditStatus;

	/** 项目名称 */
	private String projectName;

	/** 申报单位 */
	private String applicationUnit;

	/** 项目ID */
	private String projectId;

	/** 项目IDList */
	private String projectIdList;

	/** 跳转路径 */
	private String retUrl;

	/** 跳转页面massage */
	private String retMsg;

	/** 项目分类一级id */
	private String pitemId;

	/** 级联菜单返回值 */
	private String backStr;

	/** 项目详细信息左边菜单 */
	private List<Mitem> menuList;

	/** 初审意见 */
	private String beforeReviewComment;

	/**
	 * 
	 * @comments 项目初审查询条件初期化
	 * @return
	 * @version 1.0
	 */
	public String showBeforeReviewSearch() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		// session.setAttribute(Constants.SESSION_CMDKEY,"beforeReviewAction");

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 单位性质
		this.companyTypeList = new ArrayList<Mitem>();
		this.companyTypeList = mitemService.getList("mtype.typeId", Constants.TYPE_COMPANY_RETY);

		// 计划类别
		String deptId = user.getScDept().getDeptId();
		// 部门id为计财处的时候，显示所有的计划类别
		// 非计财处的时候，只显示本部门的计划类别
		if (Constants.PLANNING_DEPARTMENT.equals(deptId)) {
			this.projectTypeFirstList = tprojectTypeService.getListExceptId(null);
		} else {
			/*
			 * this.projectTypeFirstList = tprojectTypeService
			 * .getFatherProjectTypeListByDeptId(deptId);
			 */
			this.projectTypeFirstList = tprojectTypeManagerService.getProjectTypeListByUser(user);
		}

		return "beforeReviewSearch";
	}

	/**
	 * @comments 下拉列表联动
	 * @return
	 * @throws Exception
	 * @Version 1.0
	 */
	public String getSecondData() throws Exception {

		// 取得联动下拉列表数据List
		List<TprojectType> dataList = tprojectTypeService.getSonProjectTypeListByDeptId(pitemId);
		StringBuffer dataStr = new StringBuffer();

		if (dataList != null) {
			// 遍历下拉列表List 组成json字符串
			for (int i = 0; i < dataList.size(); i++) {
				dataStr.append(dataList.get(i).getTypeId());
				dataStr.append(",");
				dataStr.append(dataList.get(i).getTypeShowName());
				if (i != dataList.size() - 1) {
					dataStr.append(",");
				}
			}
		}
		this.backStr = dataStr.toString();
		return "getDataSuccess";
	}

	/**
	 * @comments 取得项目初审列表
	 * @return
	 * @version 1.0
	 */
	public String beforeReviewList() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
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
		// 项目名称
		param.put("projectName", projectName);

		// 单位性质
		param.put("companyType", companyType);
		// 申报单位
		param.put("applicationUnit", applicationUnit);
		// 计划类别
		param.put("selectedProjectTypeFirst", selectedProjectTypeFirst);
		param.put("selectedProjectTypeSecond", selectedProjectTypeSecond);

		// 审核状态(只查询状态为已提交和审核中的项目)
		param.put("auditStatus", Constants.PROJECT_REPORT_SUBMIT);
		param.put("auditStatus2", Constants.PROJECT_REPORT_BEFOREREIEW_ING);
		// 用户所在部门
		param.put("deptId", user.getScDept().getDeptId());
		// 通过用户得到用户对应的项目分类字符串
		param.put("projectTypeStr", tprojectTypeManagerService.getProjectTypeStrByUser(user));
		// 取得项目验收管理一览
		pager = tprojectApplicationService.getBeforeReviewProject(param, pager.getPageNumber(), pager.getPageSize());

		return "beforeReviewInit";
	}

	/**
	 * @comments 对单个项目进行初审
	 * @return
	 * @version 1.0
	 */
	public String beforeReview() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");

		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 封装条件
		Map<String, Object> param = new HashMap<String, Object>();
		// 项目ID
		param.put("projectId", projectId);
		// 审核状态 设定为初审通过状态
		param.put("applyStatus", Constants.PROJECT_REPORT_BEFOREREVIEW_PASS);
		// 更新用户
		param.put("updateUser", user.getUserId());
		// 初审意见
		param.put("beforeReviewComment", beforeReviewComment);
		// 用户部门
		// param.put("userDeptId", user.getScDept().getDeptId());

		tprojectApplicationService.updateApplyState(param);

		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath() + "/api/report/beforeReviewAction!showBeforeReviewSearch.action?now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * @comments 跳转到批量初审画面
	 * @return
	 * @version 1.0
	 */
	public String showBeforeReviewByList() {
		System.out.println(this.getProjectIdList());
		return "showBeforeReviewByList";
	}

	/**
	 * @comments 对checkbox选中的项目进行批量初审 同意
	 * @return
	 * @version 1.0
	 */
	public String agreeBeforeReviewByList() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");

		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 封装条件
		Map<String, Object> param = new HashMap<String, Object>();
		// 项目ID
		param.put("projectIdList", projectIdList);
		// 审核状态 设定为初审通过状态
		param.put("applyStatus", Constants.PROJECT_REPORT_BEFOREREVIEW_PASS);
		// 更新用户
		param.put("updateUser", user.getUserId());
		// 初审意见
		param.put("beforeReviewComment", beforeReviewComment);

		tprojectApplicationService.updateApplyStateByList(param);

		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath() + "/api/report/beforeReviewAction!showBeforeReviewSearch.action?now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * @comments 对项目进行初审 同意
	 * @return
	 * @version 1.0
	 */
	public String agreeBeforeReview() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");

		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 封装条件
		Map<String, Object> param = new HashMap<String, Object>();
		// 项目ID
		param.put("projectId", projectId);
		// 审核状态 设定为初审通过状态
		param.put("applyStatus", Constants.PROJECT_REPORT_BEFOREREVIEW_PASS);
		// 更新用户
		param.put("updateUser", user.getUserId());
		// 初审意见
		param.put("beforeReviewComment", beforeReviewComment);
		tprojectApplicationService.updateApplyState(param);

		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath() + "/api/report/beforeReviewAction!showBeforeReviewSearch.action?now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * @comments 对checkbox选中的项目进行批量初审 不同意（可修改）
	 * @return
	 * @version 1.0
	 */
	public String disagreeBeforeReviewByList() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");

		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 封装条件
		Map<String, Object> param = new HashMap<String, Object>();
		// 项目ID
		param.put("projectIdList", projectIdList);
		// 审核状态 设定为初审通过状态
		param.put("applyStatus", Constants.PROJECT_REPORT_BEFOREREVIEW_NOPASS);
		// 更新用户
		param.put("updateUser", user.getUserId());
		// 初审意见
		param.put("beforeReviewComment", beforeReviewComment);
		tprojectApplicationService.updateApplyStateByList(param);

		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath() + "/api/report/beforeReviewAction!showBeforeReviewSearch.action?now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * @comments 对checkbox选中的项目进行批量初审 不同意(不可修改)
	 * @return
	 * @version 1.0
	 */
	public String disagreeBeforeReviewByListUnedit() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");

		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 封装条件
		Map<String, Object> param = new HashMap<String, Object>();
		// 项目ID
		param.put("projectIdList", projectIdList);
		// 审核状态 设定为初审通过状态
		param.put("applyStatus", Constants.PROJECT_REPORT_BEFOREREVIEW_NOPASS_N);
		// 更新用户
		param.put("updateUser", user.getUserId());
		// 初审意见
		param.put("beforeReviewComment", beforeReviewComment);
		tprojectApplicationService.updateApplyStateByList(param);

		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath() + "/api/report/beforeReviewAction!showBeforeReviewSearch.action?now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * @comments 对项目进行初审 不同意（可修改）
	 * @return
	 * @version 1.0
	 */
	public String disagreeBeforeReview() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");

		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 封装条件
		Map<String, Object> param = new HashMap<String, Object>();
		// 项目ID
		param.put("projectId", projectId);
		// 审核状态 设定为初审通过状态
		param.put("applyStatus", Constants.PROJECT_REPORT_BEFOREREVIEW_NOPASS);
		// 更新用户
		param.put("updateUser", user.getUserId());
		// 初审意见
		param.put("beforeReviewComment", beforeReviewComment);
		tprojectApplicationService.updateApplyState(param);

		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath() + "/api/report/beforeReviewAction!showBeforeReviewSearch.action?now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * @comments 对项目进行初审 不同意（不可修改）
	 * @return
	 * @version 1.0
	 */
	public String disAgreeBeforeReviewUnedit() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");

		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 封装条件
		Map<String, Object> param = new HashMap<String, Object>();
		// 项目ID
		param.put("projectId", projectId);
		// 审核状态 设定为初审不通过（不可修改）
		param.put("applyStatus", Constants.PROJECT_REPORT_BEFOREREVIEW_NOPASS_N);
		// 初审意见
		param.put("beforeReviewComment", beforeReviewComment);
		// 更新用户
		param.put("updateUser", user.getUserId());

		tprojectApplicationService.updateApplyState(param);

		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath() + "/api/report/beforeReviewAction!showBeforeReviewSearch.action?now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * @comments 对项目进行初审 保存
	 * @return
	 * @version 1.0
	 */
	public String tempSave() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");

		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 封装条件
		Map<String, Object> param = new HashMap<String, Object>();
		// 项目ID
		param.put("projectId", projectId);
		// 更新用户
		param.put("updateUser", user.getUserId());
		// 初审意见
		param.put("beforeReviewComment", beforeReviewComment);
		tprojectApplicationService.updateApplyState(param);

		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath() + "/api/report/beforeReviewAction!showBeforeReviewSearch.action?now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * @comments 申请调配
	 * @return
	 * @version 1.0
	 */
	public String projectApplyRedistribute() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");

		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 封装条件
		Map<String, Object> param = new HashMap<String, Object>();
		// 项目ID
		param.put("projectId", projectId);
		// 审核状态
		param.put("applyStatus", Constants.PROJECT_REPORT_REDISTRIBUTE);
		// 更新用户
		param.put("updateUser", user.getUserId());

		tprojectApplicationService.updateApplyState(param);

		return null;
	}

	/**
	 * 专家评审时项目详细信息查看--高新处
	 * 
	 * @comments
	 * @return
	 * @version 1.0
	 */
	public String auditHighTechProjectManager() {
		HttpSession session = this.getRequest().getSession();
		// String cmdKey = (String)
		// session.getAttribute(Constants.SESSION_CMDKEY);
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		// 将项目的申报状态更新为：初审中
		// 封装条件
		Map<String, Object> param = new HashMap<String, Object>();
		// 项目ID
		param.put("projectId", projectId);
		// 审核状态:初审中
		param.put("applyStatus", Constants.PROJECT_REPORT_BEFOREREIEW_ING);
		// 更新用户
		param.put("updateUser", user.getUserId());

		tprojectApplicationService.updateApplyState(param);
		if (tprojectTypeService.getIsWrite(projectId)) {
			// 菜单列表
			this.menuList = mitemService.getListByTypeId(Constants.API_PROJECT_REPORT_MENU_TYPE);
		} else {
			// 菜单列表
			this.menuList = mitemService.getListByTypeId(Constants.API_PROJECT_REPORT_MENU_TYPE, Constants.API_PROJECT_REPORT_MENU_15);
		}

		return "highTechManager";
	}

	/**
	 * 专家评审时项目详细信息查看--非高新处
	 * 
	 * @comments
	 * @return
	 * @version 1.0
	 */
	public String auditOtherProjectManager() {
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		// 将项目的申报状态更新为：初审中
		// 封装条件
		Map<String, Object> param = new HashMap<String, Object>();
		// 项目ID
		param.put("projectId", projectId);
		// 审核状态:初审中
		param.put("applyStatus", Constants.PROJECT_REPORT_BEFOREREIEW_ING);
		// 更新用户
		param.put("updateUser", user.getUserId());

		tprojectApplicationService.updateApplyState(param);
		// 非高新处菜单
		if (tprojectTypeService.getIsWrite(projectId)) {
			this.menuList = mitemService.getListByTypeId(Constants.API_REPORT_NONTECT_MENU_TYPE);
		} else {
			this.menuList = mitemService.getListByTypeId(Constants.API_REPORT_NONTECT_MENU_TYPE, Constants.API_REPORT_NONTECT_MENU_16);
		}

		return "otherManager";
	}

	/**
	 * @comments 跳转初审画面
	 * @return
	 * @version 1.0
	 */
	public String initSubmit() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");

		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 根据项目id取得项目初审意见
		this.beforeReviewComment = tprojectApplicationService.get(projectId).getInitialAuditOpinion();

		return "showSubmit";
	}

	// ===========================
	// ====此分割线以下为get/set方法
	// ===========================
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<Mitem> getCompanyTypeList() {
		return companyTypeList;
	}

	public void setCompanyTypeList(List<Mitem> companyTypeList) {
		this.companyTypeList = companyTypeList;
	}

	public List<TprojectType> getProjectTypeFirstList() {
		return projectTypeFirstList;
	}

	public void setProjectTypeFirstList(List<TprojectType> projectTypeFirstList) {
		this.projectTypeFirstList = projectTypeFirstList;
	}

	public List<Mitem> getAuditStatusList() {
		return auditStatusList;
	}

	public void setAuditStatusList(List<Mitem> auditStatusList) {
		this.auditStatusList = auditStatusList;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getSelectedProjectTypeFirst() {
		return selectedProjectTypeFirst;
	}

	public void setSelectedProjectTypeFirst(String selectedProjectTypeFirst) {
		this.selectedProjectTypeFirst = selectedProjectTypeFirst;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectIdList() {
		return projectIdList;
	}

	public void setProjectIdList(String projectIdList) {
		this.projectIdList = projectIdList;
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

	public List<TprojectType> getProjectTypeSecondList() {
		return projectTypeSecondList;
	}

	public void setProjectTypeSecondList(List<TprojectType> projectTypeSecondList) {
		this.projectTypeSecondList = projectTypeSecondList;
	}

	public String getSelectedProjectTypeSecond() {
		return selectedProjectTypeSecond;
	}

	public void setSelectedProjectTypeSecond(String selectedProjectTypeSecond) {
		this.selectedProjectTypeSecond = selectedProjectTypeSecond;
	}

	public String getPitemId() {
		return pitemId;
	}

	public void setPitemId(String pitemId) {
		this.pitemId = pitemId;
	}

	public String getBackStr() {
		return backStr;
	}

	public void setBackStr(String backStr) {
		this.backStr = backStr;
	}

	public List<Mitem> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Mitem> menuList) {
		this.menuList = menuList;
	}

	public String getBeforeReviewComment() {
		return beforeReviewComment;
	}

	public void setBeforeReviewComment(String beforeReviewComment) {
		this.beforeReviewComment = beforeReviewComment;
	}

	public String getApplicationUnit() {
		return applicationUnit;
	}

	public void setApplicationUnit(String applicationUnit) {
		this.applicationUnit = applicationUnit;
	}

}

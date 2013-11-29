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
import com.hopsun.scenter.api.dept.service.DeptService;
import com.hopsun.scenter.entity.ScDept;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TprojectType;
import com.hopsun.tppas.view.VprojectInfoAll;

public class ProjectDeployAction extends BaseAction {

	private static final long serialVersionUID = -1979934962468943400L;
	@Resource
	private TprojectApplicationService tprojectApplicationService;

	@Resource
	private MitemService mitemService;

	@Resource
	private TprojectTypeService tprojectTypeService;

	@Resource
	private DeptService deptService;

	/** 翻页 */
	private int pageNo;

	/** 单位性质 */
	private List<Mitem> companyTypeList;

	/** 业务部门 */
	private List<ScDept> deptList = new ArrayList<ScDept>();

	/** 计划类别 */
	private List<TprojectType> projectTypeFirstList = new ArrayList<TprojectType>();;
	private List<TprojectType> projectTypeSecondList = new ArrayList<TprojectType>();;

	/** 审核状态 */
	private List<Mitem> auditStatusList;

	/** 单位性质(选中) */
	private String companyType;

	/**
	 * 部门id（调配后的部门id） 部门id（一览页面选择的部门id）
	 */
	private String selectedDeptId;

	/** 计划类别(选中) */
	private String selectedProjectTypeFirst;

	/** 计划类别(选中) */
	private String selectedProjectTypeSecond;

	/** 审核状态(选中) */
	private String auditStatus;

	/** 项目名称 */
	private String projectName;

	/** 项目ID */
	private String projectId;

	/** 跳转路径 */
	private String retUrl;

	/** 跳转页面massage */
	private String retMsg;

	/** 项目分类一级id */
	private String pitemId;

	/** 级联菜单返回值 */
	private String backStr;

	/** 初审意见 */
	private String deployComment;

	/** 项目信息 */
	private VprojectInfoAll project;

	/** 级联菜单查询flag */
	private String searchFlag;

	/** 跨模板调配flag */
	private String jumpFlag;

	/**
	 * 
	 * @comments 项目初审查询条件初期化
	 * @return
	 * @version 1.0
	 */
	public String showDeploySearch() {
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

		// 部门一览
		this.deptList = deptService.findDept(user.getScDept());

		// 审核状态
		// this.auditStatusList = new ArrayList<Mitem>();
		// this.auditStatusList =
		// mitemService.getList("mtype.typeId",Constants.TYPE_PROJECT_REPORT);

		return "showDeploySearch";
	}

	/**
	 * @comments 下拉列表联动
	 * @return
	 * @throws Exception
	 * @Version 1.0
	 */
	public String getSecondData() throws Exception {

		StringBuffer dataStr = new StringBuffer();
		List<TprojectType> dataList = null;
		if ("dept".equals(searchFlag)) {
			// 根据部门id取得一级项目分类
			dataList = tprojectTypeService.getFatherProjectTypeListByDeptId(pitemId);
		} else {
			// 取得联动下拉列表数据List
			dataList = tprojectTypeService.getSonProjectTypeListByDeptId(pitemId);
		}

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
	 * @comments 取得调配项目列表
	 * @return
	 * @version 1.0
	 */
	public String getDeployList() {
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

		// 部门id
		param.put("selectedDeptId", this.selectedDeptId);
		// 计划类别
		param.put("selectedProjectTypeFirst", selectedProjectTypeFirst);
		param.put("selectedProjectTypeSecond", selectedProjectTypeSecond);

		// 审核状态(只查询状态为等待调配的项目)
		param.put("auditStatus", Constants.PROJECT_REPORT_REDISTRIBUTE);

		// 用户所在部门
		// param.put("deptId", user.getScDept().getDeptId());

		// 取得调配项目一览
		pager = tprojectApplicationService.getDeployProjectList(param, pager.getPageNumber(), pager.getPageSize());

		return "deployList";
	}

	/**
	 * @comments 跳转到调配页面
	 * @return
	 * @version 1.0
	 */
	public String deploy() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");

		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		// 根据项目ID取得项目信息
		this.project = tprojectApplicationService.getProjectInfoAll(this.projectId);
		// 部门一览
		this.deptList = deptService.findDept(user.getScDept());

		// 画面跳转
		return "showDeployEdit";
	}

	/**
	 * @comments 对单个项目进行调配提交
	 * @return
	 * @version 1.0
	 */
	public String updateDeployProject() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");

		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		// 根据项目ID取得项目信息
		this.project = tprojectApplicationService.getProjectInfoAll(this.projectId);
		// 部门一览
		this.deptList = deptService.findDept(user.getScDept());

		// 更新参数作成
		Map<String, Object> param = new HashMap<String, Object>();
		// 跨模板调配区分
		param.put("jumpFlag", this.jumpFlag);
		// 项目id
		param.put("projectId", this.projectId);
		// 项目分类ID（一级）
		param.put("selectedProjectTypeFirst", selectedProjectTypeFirst);
		// 项目分类名称（一级）
		param.put("planFlagName", tprojectTypeService.getProjectTypeName(selectedProjectTypeFirst));
		// 项目分类ID（二级）
		param.put("selectedProjectTypeSecond", selectedProjectTypeSecond);
		// 项目分类名称（二级）
		param.put("typeName", tprojectTypeService.getProjectTypeName(selectedProjectTypeSecond));
		// 调配意见
		param.put("deployComment", this.deployComment);
		// 更新者
		param.put("updateUser", user.getUserId());
		// 申报状态(申报状态改为初审中)
		param.put("applyStatus", Constants.PROJECT_REPORT_BEFOREREIEW_ING);
		tprojectApplicationService.updateDeployProject(param);
		// 更新完成后画面跳转
		this.setRetMsg(this.getText("opt_save_suc"));
		this.setRetUrl(super.getRequest().getContextPath() + "/api/report/projectDeployAction!showDeploySearch.action?now=" + new Date().getTime());

		return "systemInfoMain";
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

	public List<ScDept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<ScDept> deptList) {
		this.deptList = deptList;
	}

	public String getSelectedDeptId() {
		return selectedDeptId;
	}

	public void setSelectedDeptId(String selectedDeptId) {
		this.selectedDeptId = selectedDeptId;
	}

	public VprojectInfoAll getProject() {
		return project;
	}

	public void setProject(VprojectInfoAll project) {
		this.project = project;
	}

	public String getDeployComment() {
		return deployComment;
	}

	public void setDeployComment(String deployComment) {
		this.deployComment = deployComment;
	}

	public String getSearchFlag() {
		return searchFlag;
	}

	public void setSearchFlag(String searchFlag) {
		this.searchFlag = searchFlag;
	}

	public String getJumpFlag() {
		return jumpFlag;
	}

	public void setJumpFlag(String jumpFlag) {
		this.jumpFlag = jumpFlag;
	}
}

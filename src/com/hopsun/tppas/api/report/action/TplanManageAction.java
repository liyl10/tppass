/*************** 版权声明***************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ********************************************
 */
package com.hopsun.tppas.api.report.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.report.service.TplanManageService;
import com.hopsun.tppas.api.report.service.TprojectApplicationAuditService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeManagerService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Tplan;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectType;
import com.hopsun.tppas.entity.TprojectTypeManager;

/**
 * @comments 分计划管理
 * @author wanglw
 * @date 2013-10-9 @time 上午9:22:37
 * @Version 1.0
 */
public class TplanManageAction extends BaseAction {

	private static final long serialVersionUID = 3394155728108350924L;

	@Resource
	private TplanManageService tplanManageService;

	@Resource
	private TprojectTypeService tprojectTypeService;

	@Resource
	private MitemService mitemService;

	@Resource
	private TprojectApplicationAuditService tprojectApplicationAuditService;

	@Resource
	private TprojectTypeManagerService tprojectTypeManagerService;

	/** 计划年度 */
	private List<Mitem> planYearList;

	/** 计划类别 */
	private List<TprojectType> projectTypeList1;

	/** 项目分类 */
	private List<TprojectType> projectTypeList2;

	/** 计划批次 */
	private List<Mitem> planBatchList;

	/** 计划状态 */
	private List<Mitem> planStatusList;

	/** 计划 */
	private String planName;

	/** 计划 */
	private String planYear;

	/** 计划类别 */
	private String projectType1;

	/** 项目分类 */
	private String projectType2;

	/** 计划类别 */
	private String projectType1Name;

	/** 项目分类 */
	private String projectType2Name;

	/** 计划批次 */
	private String planBatch;

	/** 计划状态 */
	private String planStatus;

	/** 项目名称 */
	private String projectName;

	/** 申报单位 */
	private String applyCompany;

	/** 翻页 */
	private int pageNo;

	/** 跳转路径 */
	private String retUrl;

	/** 跳转页面massage */
	private String retMsg;

	/** 分计划 */
	private Tplan tplan;

	/** 分计划ID */
	private String planId;

	/** 选择的项目ID */
	private String selectedProjectIds;

	/** 项目list */
	private List<TprojectApplication> proAppList;

	/** 项目list count */
	private int proAppListCount;

	/** 项目选择状态 */
	private List<Mitem> proSelectStatusList;

	/** 项目Id */
	private String projectId;

	/** 取得的项目列表 */
	private List<Map<String, Object>> unselectProList;

	/** 项目提交状态 */
	private String planApplyStatus;

	/**
	 * @comments 显示分计划管理
	 * @return
	 * @Version 1.0
	 */
	public String showPlanManage() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "planManage");

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 初始化计划类别
		this.projectTypeList1 = new ArrayList<TprojectType>();
		this.projectTypeList1 = tprojectTypeManagerService.getProjectTypeListByUser(user);

		// 初始化项目分类
		this.projectTypeList2 = new ArrayList<TprojectType>();

		// 计划年度
		this.planYearList = new ArrayList<Mitem>();
		// 取得当前年度
		int currentYear = this.getCurrentYear();
		// 封装年度列表
		for (int i = currentYear - 3; i < currentYear + 4; i++) {
			Mitem mitem = new Mitem();
			mitem.setItemId(String.valueOf(i));
			mitem.setItemName(String.valueOf(i));
			planYearList.add(mitem);
		}

		// 计划批次
		this.planBatchList = new ArrayList<Mitem>();
		this.planBatchList = mitemService.getListByTypeId(Constants.TYPE_PLANBATCH_STATUS);

		// 计划状态
		this.planStatusList = new ArrayList<Mitem>();
		this.planStatusList = mitemService.getListByTypeId(Constants.TYPE_PLAN_STATUS);

		return "showPlanManage";
	}

	/**
	 * @comments 取得分计划列表
	 * @return
	 * @Version 1.0
	 */
	public String getPlanManageList() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
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
		// 部门ID
		param.put("departmentId", user.getScDept().getDeptId());

		// 计划名称
		param.put("planName", planName);

		// 计划批次
		param.put("planBatch", planBatch);

		// 计划类别
		String projectTypeString = tprojectTypeManagerService.getProjectTypeStrByUser(user);
		param.put("projectTypeString", projectTypeString);

		// 计划类别
		param.put("projectType1", projectType1);

		// 项目分类
		param.put("projectType2", projectType2);

		// 计划年度
		param.put("planYear", planYear);

		// 计划状态
		param.put("planStatus", planStatus);

		pager = tplanManageService.getPlanList(param, pager.getPageNumber(), pager.getPageSize());

		return "getPlanManageList";
	}

	/**
	 * @comments 创建分计划（项目类型选择）
	 * @return
	 * @Version 1.0
	 */
	public String beforeCreatePlan() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
			return "LogOut";
		}

		Boolean projecTypeManager = (Boolean) session.getAttribute("projecTypeManager");

		if (projecTypeManager) {
			// 初始化计划类别
			this.projectTypeList1 = new ArrayList<TprojectType>();
			this.projectTypeList1 = tprojectTypeManagerService.getProjectTypeListByUser(user);

			// 初始化项目分类
			this.projectTypeList2 = new ArrayList<TprojectType>();
		} else {

			Map<String, Object> valueMap = new HashMap<String, Object>();
			valueMap.put("userId", user.getUserId());

			TprojectTypeManager ttm = tprojectTypeManagerService.getTprojectTypeManager(valueMap);

			// 初始化项目分类
			this.projectTypeList2 = new ArrayList<TprojectType>();
			if (ttm != null && ttm.getTypeId() != null && !"".equals(ttm.getTypeId())) {
				projectTypeList2 = tprojectTypeService.get(new String[] { ttm.getTypeId() });

				if (projectTypeList2 != null && projectTypeList2.size() > 0) {
					this.projectType1 = projectTypeList2.get(0).getParentTypeId();
				}
			}

		}

		return "beforeCreatePlan";
	}

	/**
	 * @comments 显示新增分计划
	 * @return
	 * @Version 1.0
	 */
	public String showNewPlan() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
			return "LogOut";
		}

		if (this.projectType1 == null || "".equals(this.projectType1)) {
			this.projectType1 = tprojectTypeService.get(projectType2).getParentTypeId();
		}
		// 项目类别
		this.projectType1Name = tprojectTypeService.getProjectTypeName(projectType1);
		// 分计划名称
		this.projectType2Name = tprojectTypeService.getProjectTypeName(projectType2);
		// 计划年度
		this.planYear = String.valueOf(this.getCurrentYear());
		// 计划批次
		this.planBatchList = new ArrayList<Mitem>();
		this.planBatchList = mitemService.getBatchListByTypeId(Constants.TYPE_PLANBATCH_STATUS);

		// 取得已编制的批次
		List<Mitem> batchList = new ArrayList<Mitem>();
		batchList = tplanManageService.getSelectedBatch(projectType2, "");
		if (batchList != null && batchList.size() > 0) {
			for (Mitem mitem : batchList) {

				planBatchList.remove(mitem);
			}
		}
		// 移除已编制的批次
		// planBatchList.removeAll(batchList);
		return "showNewPlan";
	}

	/**
	 * @comments
	 * @return
	 * @Version 1.0
	 */
	public String nextAndSelectProject() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
			return "LogOut";
		}

		// 保存分计划
		this.planId = tplanManageService.savePlan(tplan);

		// 设置提示信息
		this.setRetMsg(this.getText("opt_save_suc"));

		// 设置actionUrl
		this.setRetUrl(super.getRequest().getContextPath() + "/api/planManage/planManageAction!showSelectProject.action?planId=" + planId + "&now=" + new Date().getTime());

		return "systemMainNext";
	}

	/**
	 * @comments 显示选择项目页面
	 * @return
	 * @Version 1.0
	 */
	public String showSelectProject() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
			return "LogOut";
		}

		// 初始化计划类别
		this.projectTypeList1 = new ArrayList<TprojectType>();
		this.projectTypeList1 = tprojectTypeManagerService.getProjectTypeListByUser(user);

		this.planId = this.getPlanId();

		// 初始化项目分类
		this.projectTypeList2 = new ArrayList<TprojectType>();

		return "showSelectProject";
	}

	/**
	 * @comments 取得项目列表
	 * @return
	 * @Version 1.0
	 */
	public String getProjectList() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
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
		// 部门ID
		param.put("departmentId", user.getScDept().getDeptId());

		// 项目名称
		param.put("projectName", projectName);

		// 申报单位
		param.put("applyCompany", applyCompany);

		// 取得分计划
		Tplan planTemp = tplanManageService.get(planId);

		// 计划类别
		// String projectTypeString =
		// tprojectTypeManagerService.getProjectTypeStrByUser(user);
		// param.put("projectTypeString", projectTypeString);

		// 计划类别
		param.put("projectType1", planTemp.getPlanFlag());

		// 项目分类
		param.put("projectType2", planTemp.getTprojectType().getTypeId());

		// 取得项目一览信息
		pager = tprojectApplicationAuditService.getBatchProjectList(param, pager.getPageNumber(), pager.getPageSize());

		return "getProjectList";
	}

	/**
	 * @comments 保存已选择的项目
	 * @return
	 * @Version 1.0
	 */
	public String saveSelectedProject() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
			return "LogOut";
		}

		tplanManageService.saveSelectedProject(planId, selectedProjectIds);

		// 设置提示信息
		this.setRetMsg(this.getText("opt_save_suc"));

		// 设置actionUrl
		this.setRetUrl(super.getRequest().getContextPath() + "/api/planManage/planManageAction!showPlanManage.action?now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * @comments 删除分计划
	 * @return
	 * @Version 1.0
	 */
	public String deletePlan() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
			return "LogOut";
		}

		// 删除分计划
		tplanManageService.deletePlan(planId);

		// 设置提示信息
		this.setRetMsg(this.getText("opt_del_suc"));

		// 设置actionUrl
		this.setRetUrl(super.getRequest().getContextPath() + "/api/planManage/planManageAction!showPlanManage.action?now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * @comments 分计划修改
	 * @return
	 * @Version 1.0
	 */
	public String showPlanUpdate() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
			return "LogOut";
		}

		this.tplan = tplanManageService.get(planId);

		// 计划批次
		this.planBatchList = new ArrayList<Mitem>();
		this.planBatchList = mitemService.getBatchListByTypeId(Constants.TYPE_PLANBATCH_STATUS);

		// 取得已编制的批次
		List<Mitem> batchList = new ArrayList<Mitem>();
		if (tplan != null) {
			batchList = tplanManageService.getSelectedBatch(tplan.getTprojectType().getTypeId(), planId);
		}
		if (batchList != null) {
			// 移除已编制的批次
			planBatchList.removeAll(batchList);
		}

		if (tplan != null && tplan.getPlanState() != null && !Constants.PLAN_APPLY.equals(tplan.getPlanState())) {
			this.planApplyStatus = "0";
		} else {
			this.planApplyStatus = "1";
		}
		return "showPlanUpdate";
	}

	/**
	 * @comments 取得分计划选择的项目列表
	 * @return
	 * @Version 1.0
	 */
	public String getPlanUpdateList() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
			return "LogOut";
		}

		// 分计划选择状态
		this.proSelectStatusList = new ArrayList<Mitem>();
		this.proSelectStatusList = mitemService.getListByTypeId(Constants.TYPE_PLANSELECT_STATUS);

		// 取得项目列表
		this.proAppList = tprojectApplicationAuditService.getPlanUpdateList(planId);

		this.proAppListCount = proAppList.size();

		return "getPlanUpdateList";
	}

	/**
	 * @comments 取得分计划选择的项目列表
	 * @return
	 * @Version 1.0
	 */
	public String getPlanUpdateList1() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
			return "LogOut";
		}

		// 分计划选择状态
		this.proSelectStatusList = new ArrayList<Mitem>();
		this.proSelectStatusList = mitemService.getListByTypeId(Constants.TYPE_PLANSELECT_STATUS);

		// 取得项目列表
		this.proAppList = tprojectApplicationAuditService.getPlanUpdateList(planId);

		this.proAppListCount = proAppList.size();

		return "getPlanUpdateList1";
	}

	/**
	 * @comments 删除分计划选择的项目
	 * @return
	 * @Version 1.0
	 */
	public String deleteProject() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
			return "LogOut";
		}

		// 删除所选的项目
		tprojectApplicationAuditService.updateProSelectStatus(projectId);

		// 分计划选择状态
		this.proSelectStatusList = new ArrayList<Mitem>();
		this.proSelectStatusList = mitemService.getListByTypeId(Constants.TYPE_PLANSELECT_STATUS);

		// 取得项目列表
		this.proAppList = tprojectApplicationAuditService.getPlanUpdateList(planId);

		return "getPlanUpdateList";
	}

	/**
	 * @comments 批量删除分计划选择的项目
	 * @return
	 * @Version 1.0
	 */
	public String deleteBatchProject() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
			return "LogOut";
		}

		// 删除所选的项目
		tprojectApplicationAuditService.updateProSelectStatus(selectedProjectIds);

		// 分计划选择状态
		this.proSelectStatusList = new ArrayList<Mitem>();
		this.proSelectStatusList = mitemService.getListByTypeId(Constants.TYPE_PLANSELECT_STATUS);

		// 取得项目列表
		this.proAppList = tprojectApplicationAuditService.getPlanUpdateList(planId);

		return "getPlanUpdateList";
	}

	/**
	 * @comments 继续选择项目
	 * @return
	 * @Version 1.0
	 */
	public String showSelectProjectManage() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
			return "LogOut";
		}

		this.planId = this.getPlanId();

		return "showSelectProjectManage";
	}

	/**
	 * @comments 取得未选择的项目列表
	 * @return
	 * @throws UnsupportedEncodingException
	 * @Version 1.0
	 */
	public String getUnselectProject() throws UnsupportedEncodingException {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
			return "LogOut";
		}

		Map<String, Object> param = new HashMap<String, Object>();

		// 封装查询条件
		// 部门ID
		param.put("departmentId", user.getScDept().getDeptId());

		// 项目名称
		param.put("projectName", new String(projectName.getBytes("ISO-8859-1"), "UTF-8"));

		// 申报单位
		param.put("applyCompany", new String(applyCompany.getBytes("ISO-8859-1"), "UTF-8"));

		// 取得分计划
		Tplan planTemp = tplanManageService.get(planId);

		// 计划类别
		param.put("projectType1", planTemp.getPlanFlag());

		// 项目分类
		param.put("projectType2", planTemp.getTprojectType().getTypeId());

		this.unselectProList = tprojectApplicationAuditService.getSelectProjectList(param);

		return "getUnselectProject";
	}

	/**
	 * @comments 保存选择的项目列表
	 * @Version 1.0
	 */
	public void saveSelectProject() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
			return;
		}

		// 取得选择的项目Id
		this.selectedProjectIds = this.getSelectedProjectIds();

		tplanManageService.saveSelectedProject(planId, selectedProjectIds);
	}

	/**
	 * @comments 提交分计划
	 * @return
	 * @Version 1.0
	 */
	public String submitPlan() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
			return "LogOut";
		}

		tplanManageService.savePlan(tplan, proAppList);

		// 设置提示信息
		this.setRetMsg(this.getText("opt_save_suc"));

		// 设置actionUrl
		this.setRetUrl(super.getRequest().getContextPath() + "/api/planManage/planManageAction!showPlanManage.action?now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * @comments
	 * @return
	 * @Version 1.0
	 */
	public String showPlanDetail() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
			return "LogOut";
		}

		this.tplan = tplanManageService.get(planId);
		this.tplan.setPlanBatch(mitemService.getMitemNameById(tplan.getPlanBatch()));

		// 计划批次
		this.planBatchList = new ArrayList<Mitem>();
		this.planBatchList = mitemService.getBatchListByTypeId(Constants.TYPE_PLANBATCH_STATUS);

		// 取得已编制的批次
		List<Mitem> batchList = new ArrayList<Mitem>();
		batchList = tplanManageService.getSelectedBatch(user.getScDept().getDeptId(), planId);

		// 移除已编制的批次
		planBatchList.removeAll(batchList);

		// 取得项目列表
		this.proAppList = tprojectApplicationAuditService.getPlanUpdateList(planId);
		this.proAppListCount = proAppList.size();

		return "showPlanDetail";
	}

	/**
	 * @comments 打印分计划
	 * @throws IOException
	 * @throws WriteException
	 * @Version 1.0
	 */
	public void printPlan() throws IOException, WriteException {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"planManage".equals(cmdkey)) {
			return;
		}

		this.planId = this.getPlanId();

		// 取得分计划
		this.tplan = tplanManageService.get(planId);

		this.proAppList = tprojectApplicationAuditService.getPlanUpdateList(planId);

		// 取得文件名称
		String excelFileName = this.getText("plan_manage_file_name");

		this.exportData(excelFileName, proAppList, tplan);
	}

	/**
	 * @comments
	 * @param excelFileName
	 *            导出数据
	 * @param tpLsit
	 * @throws IOException
	 * @throws WriteException
	 * @Version 1.0
	 */
	private void exportData(String excelFileName, List<TprojectApplication> tpLsit, Tplan plan) throws IOException, WriteException {
		HttpServletResponse response = this.getResponse();

		OutputStream out = null;
		WritableWorkbook workbook = null;

		try {
			// 清空输出流
			response.reset();
			// 设定输出文件头
			response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(excelFileName.getBytes("GB2312"), "ISO_8859_1") + ".xls\"");
			// 定义输出类型
			response.setContentType("application/vnd.ms-excel");
			// 取得输出流
			out = response.getOutputStream();
			// 建立excel文件
			workbook = Workbook.createWorkbook(out);

			// 单元格边框格式
			WritableCellFormat cf = new WritableCellFormat();
			// 设置边框
			cf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			cf.setVerticalAlignment(VerticalAlignment.CENTRE);

			WritableFont wf2 = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD, false);
			cf.setFont(wf2);
			// 换行显示
			cf.setWrap(true);

			// 表头格式
			WritableCellFormat headerCf1 = new WritableCellFormat();
			// 设置边框
			headerCf1.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			headerCf1.setVerticalAlignment(VerticalAlignment.CENTRE);
			// headerCf.setBackground(Colour.ICE_BLUE);
			// 设置自动换行
			headerCf1.setWrap(true);
			WritableFont wf4 = new WritableFont(WritableFont.createFont("宋体"), 20, WritableFont.BOLD, false);
			headerCf1.setFont(wf4);
			// 水平居中显示
			headerCf1.setAlignment(Alignment.CENTRE);

			// 表头格式
			WritableCellFormat headerCf = new WritableCellFormat();
			// 设置边框
			headerCf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			headerCf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// headerCf.setBackground(Colour.ICE_BLUE);
			// 设置自动换行
			headerCf.setWrap(true);
			headerCf.setFont(wf2);
			// 水平居中显示
			headerCf.setAlignment(Alignment.CENTRE);

			// 设置字体
			WritableFont wf3 = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.NO_BOLD, false);
			// 百分比格式
			NumberFormat nf = new NumberFormat("0.0###");
			WritableCellFormat numberCf = new WritableCellFormat(nf);
			// 设置边框
			numberCf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			numberCf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// 水平居中显示
			numberCf.setAlignment(Alignment.RIGHT);
			// 设置字体
			numberCf.setFont(wf3);

			// 计划类别名称格式
			WritableCellFormat typeCf = new WritableCellFormat();
			// 设置边框
			typeCf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			typeCf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// 水平居中显示
			typeCf.setAlignment(Alignment.LEFT);

			typeCf.setFont(wf3);

			// 计划类别名称格式
			WritableCellFormat typeCf1 = new WritableCellFormat();
			// 设置边框
			typeCf1.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 垂直居中显示
			typeCf1.setVerticalAlignment(VerticalAlignment.CENTRE);
			// 水平居中显示
			typeCf1.setAlignment(Alignment.CENTRE);
			typeCf1.setFont(wf3);

			WritableSheet sh = workbook.createSheet(excelFileName, 0);

			// 设置标题
			sh.addCell(new Label(2, 2, plan.getPlanFlagName() + Constants.STRING_LINK + plan.getPlanName(), headerCf1));
			sh.mergeCells(2, 2, 14, 2);
			sh.setRowView(2, 800);

			// 设置表头
			sh.addCell(new Label(2, 4, this.getText("plan_title_no"), headerCf));
			sh.mergeCells(2, 4, 2, 5);

			sh.addCell(new Label(3, 4, this.getText("plan_title_project_no"), headerCf));
			sh.mergeCells(3, 4, 3, 5);

			sh.addCell(new Label(4, 4, this.getText("plan_title_project_name"), headerCf));
			sh.mergeCells(4, 4, 4, 5);

			sh.addCell(new Label(5, 4, this.getText("plan_title_content"), headerCf));
			sh.mergeCells(5, 4, 5, 5);

			sh.addCell(new Label(6, 4, this.getText("plan_title_app_unit"), headerCf));
			sh.mergeCells(6, 4, 6, 5);

			sh.addCell(new Label(7, 4, this.getText("plan_title_person"), headerCf));
			sh.mergeCells(7, 4, 7, 5);

			sh.addCell(new Label(8, 4, this.getText("plan_title_time"), headerCf));
			sh.mergeCells(8, 4, 8, 5);

			sh.addCell(new Label(9, 4, this.getText("plan_title_input_total"), headerCf));
			sh.mergeCells(9, 4, 11, 4);
			sh.setRowView(4, 400);

			sh.addCell(new Label(9, 5, this.getText("plan_title_total_1"), headerCf));
			sh.setRowView(5, 400);

			sh.addCell(new Label(10, 5, this.getText("plan_title_research_funs"), headerCf));

			sh.addCell(new Label(11, 5, this.getText("plan_title_self_funs"), headerCf));

			sh.addCell(new Label(12, 4, this.getText("plan_title_expect"), headerCf));
			sh.mergeCells(12, 4, 13, 4);

			sh.addCell(new Label(12, 5, this.getText("plan_title_output"), headerCf));

			sh.addCell(new Label(13, 5, this.getText("plan_title_tax"), headerCf));

			sh.addCell(new Label(14, 4, this.getText("plan_title_centralized"), headerCf));
			sh.mergeCells(14, 4, 14, 5);

			if (tpLsit != null && tpLsit.size() > 0) {

				SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM");

				for (int i = 0; i < tpLsit.size(); i++) {

					TprojectApplication tp = tpLsit.get(i);
					if (tp != null) {
						if (tp.getProjectId() != null && !"".equals(tp.getProjectId())) {
							// 序号
							sh.addCell(new Label(2, 6 + i, String.valueOf(i + 1), typeCf));
							sh.setRowView(6 + i, 400);
							// 项目编号
							sh.addCell(new Label(3, 6 + i, tp.getProjectNumber(), typeCf));
							// 项目名称
							sh.addCell(new Label(4, 6 + i, tp.getProjectName(), typeCf));
							// 主要内容
							sh.addCell(new Label(5, 6 + i, tp.getExpertAuditResearch(), typeCf));
							// 承担单位
							sh.addCell(new Label(6, 6 + i, tp.getApplicationUnit(), typeCf));
							// 项目负责人
							sh.addCell(new Label(7, 6 + i, tp.getRemark(), typeCf));

							// 起止时间
							sh.addCell(new Label(8, 6 + i, formatter.format(tp.getStartTime()) + Constants.STRING_LINK + formatter.format(tp.getEndTime()), typeCf));
							// 合计
							sh.addCell(new Label(9, 6 + i, String.valueOf(tp.getInputTotal()), numberCf));
							// 科研资金
							sh.addCell(new Label(10, 6 + i, String.valueOf(tp.getResearchFunds()), numberCf));
							// 自筹
							sh.addCell(new Label(11, 6 + i, String.valueOf(tp.getSelfFinancing()), numberCf));
							// 产值
							sh.addCell(new Label(12, 6 + i, String.valueOf(tp.getProjectExpectOutput()), numberCf));
							// 利税
							sh.addCell(new Label(13, 6 + i, String.valueOf(tp.getProjectExpectProfitTax()), numberCf));
							// 项目归口管理单位
							sh.addCell(new Label(14, 6 + i, tp.getCentralizedTypeName(), typeCf));

						}
						// 合计
						else {
							// 合计
							sh.addCell(new Label(2, 6 + i, this.getText("plan_title_total_2"), typeCf1));
							sh.mergeCells(2, 6 + i, 8, 6 + i);
							sh.setRowView(6 + i, 400);
							// 合计
							// 合计
							sh.addCell(new Label(9, 6 + i, String.valueOf(tp.getInputTotal()), numberCf));
							// 科研资金
							sh.addCell(new Label(10, 6 + i, String.valueOf(tp.getResearchFunds()), numberCf));
							// 自筹
							sh.addCell(new Label(11, 6 + i, String.valueOf(tp.getSelfFinancing()), numberCf));
							// 产值
							sh.addCell(new Label(12, 6 + i, String.valueOf(tp.getProjectExpectOutput()), numberCf));
							// 利税
							sh.addCell(new Label(13, 6 + i, String.valueOf(tp.getProjectExpectProfitTax()), numberCf));
							// 项目归口管理单位
							sh.addCell(new Label(14, 6 + i, "", typeCf));

							String projectInfo = plan.getPlanName() + ":" + "列入计划" + String.valueOf(tpLsit.size() - 1) + "项，" + "总投入" + String.valueOf(tp.getInputTotal()) + "万元，其中科研资金"
									+ String.valueOf(tp.getResearchFunds()) + "万元。";
							sh.addCell(new Label(2, 3, projectInfo, typeCf));
							sh.mergeCells(2, 3, 14, 3);
							sh.setRowView(3, 600);

						}

					}
				}
			}
			// ===========写入数据 end===========

			workbook.write();
			out.flush();
			response.flushBuffer();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != workbook) {
				workbook.close();
			}
			if (null != out) {
				out.close();
			}
		}
	}

	/**
	 * @comments 取得当前年份
	 * @return
	 * @Version 1.0
	 */
	private int getCurrentYear() {

		Calendar cal = Calendar.getInstance();

		return cal.get(Calendar.YEAR);
	}

	public TplanManageService getTplanManageService() {
		return tplanManageService;
	}

	public void setTplanManageService(TplanManageService tplanManageService) {
		this.tplanManageService = tplanManageService;
	}

	public List<Mitem> getPlanYearList() {
		return planYearList;
	}

	public void setPlanYearList(List<Mitem> planYearList) {
		this.planYearList = planYearList;
	}

	public List<TprojectType> getProjectTypeList1() {
		return projectTypeList1;
	}

	public void setProjectTypeList1(List<TprojectType> projectTypeList1) {
		this.projectTypeList1 = projectTypeList1;
	}

	public List<TprojectType> getProjectTypeList2() {
		return projectTypeList2;
	}

	public void setProjectTypeList2(List<TprojectType> projectTypeList2) {
		this.projectTypeList2 = projectTypeList2;
	}

	public List<Mitem> getPlanBatchList() {
		return planBatchList;
	}

	public void setPlanBatchList(List<Mitem> planBatchList) {
		this.planBatchList = planBatchList;
	}

	public List<Mitem> getPlanStatusList() {
		return planStatusList;
	}

	public void setPlanStatusList(List<Mitem> planStatusList) {
		this.planStatusList = planStatusList;
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

	public String getProjectType1() {
		return projectType1;
	}

	public void setProjectType1(String projectType1) {
		this.projectType1 = projectType1;
	}

	public String getProjectType2() {
		return projectType2;
	}

	public void setProjectType2(String projectType2) {
		this.projectType2 = projectType2;
	}

	public String getPlanBatch() {
		return planBatch;
	}

	public void setPlanBatch(String planBatch) {
		this.planBatch = planBatch;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getProjectType1Name() {
		return projectType1Name;
	}

	public void setProjectType1Name(String projectType1Name) {
		this.projectType1Name = projectType1Name;
	}

	public String getProjectType2Name() {
		return projectType2Name;
	}

	public void setProjectType2Name(String projectType2Name) {
		this.projectType2Name = projectType2Name;
	}

	public Tplan getTplan() {
		return tplan;
	}

	public void setTplan(Tplan tplan) {
		this.tplan = tplan;
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

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getApplyCompany() {
		return applyCompany;
	}

	public void setApplyCompany(String applyCompany) {
		this.applyCompany = applyCompany;
	}

	public String getSelectedProjectIds() {
		return selectedProjectIds;
	}

	public void setSelectedProjectIds(String selectedProjectIds) {
		this.selectedProjectIds = selectedProjectIds;
	}

	public List<TprojectApplication> getProAppList() {
		return proAppList;
	}

	public void setProAppList(List<TprojectApplication> proAppList) {
		this.proAppList = proAppList;
	}

	public List<Mitem> getProSelectStatusList() {
		return proSelectStatusList;
	}

	public void setProSelectStatusList(List<Mitem> proSelectStatusList) {
		this.proSelectStatusList = proSelectStatusList;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<Map<String, Object>> getUnselectProList() {
		return unselectProList;
	}

	public void setUnselectProList(List<Map<String, Object>> unselectProList) {
		this.unselectProList = unselectProList;
	}

	public int getProAppListCount() {
		return proAppListCount;
	}

	public void setProAppListCount(int proAppListCount) {
		this.proAppListCount = proAppListCount;
	}

	public String getPlanApplyStatus() {
		return planApplyStatus;
	}

	public void setPlanApplyStatus(String planApplyStatus) {
		this.planApplyStatus = planApplyStatus;
	}

}

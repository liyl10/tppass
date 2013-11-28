/*************** 版权声明***************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ********************************************
 */
package com.hopsun.tppas.api.report.action;

import java.io.UnsupportedEncodingException;
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
import com.hopsun.tppas.api.expert.service.TexpertScoreService;
import com.hopsun.tppas.api.expert.service.TexpertService;
import com.hopsun.tppas.api.report.service.TgroupExpertRealtionService;
import com.hopsun.tppas.api.report.service.TprojectApplicationAuditService;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.report.service.TprojectGroupService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeManagerService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.api.util.KeyUtil;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Texpert;
import com.hopsun.tppas.entity.TexpertScore;
import com.hopsun.tppas.entity.TgroupExpertRealtion;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectGroup;
import com.hopsun.tppas.entity.TprojectType;
import com.hopsun.tppas.view.VprojectInfo;

/**
 * @comments 项目评审
 * @author wanglw
 * @date 2013-9-10 @time 下午4:25:10
 * @Version 1.0
 */
public class TprojectApplicationAuditAction extends BaseAction {

	private static final long serialVersionUID = -1979934962468943400L;

	@Resource
	private TprojectApplicationAuditService tprojectApplicationAuditService;
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	@Resource
	private MitemService mitemService;

	@Resource
	private TexpertScoreService texpertScoreService;

	@Resource
	private TexpertService texpertService;

	@Resource
	private TprojectTypeService tprojectTypeService;

	@Resource
	private TprojectGroupService tprojectGroupService;

	@Resource
	private TprojectTypeManagerService tprojectTypeManagerService;
	
	@Resource
	private TgroupExpertRealtionService tgroupExpertRealtionService;

	/** 翻页 */
	private int pageNo;

	/** 单位性质 */
	private List<Mitem> companyTypeList;

	/** 计划类别 */
	private List<Mitem> projectTypeList;

	/** 计划类别 */
	private List<TprojectType> projectTypeList1;

	/** 项目分类 */
	private List<TprojectType> projectTypeList2;

	/** 项目分组 */
	private List<TprojectGroup> projectGroupList;

	/** 审核状态 */
	private List<Mitem> auditStatusList;

	/** 单位性质 */
	private String companyType;

	/** 计划类别 */
	private String projectType;

	/** 计划类别 */
	private String projectType1;

	/** 项目分类 */
	private String projectType2;

	/** 项目分组 */
	private String projectGroup;

	/** 项目分组(弹出页面) */
	private String projectGroupSon;

	/** 审核状态 */
	private String auditStatus;

	/** 项目名称 */
	private String projectName;

	/** 申报单位 */
	private String applyCompany;

	/** 选择的项目信息List */
	private List<Map<String, Object>> projectSelectList;

	/** 分组名称 */
	private String groupName;

	/** 分组ID */
	private String groupId;

	/** 数据是否显示 */
	private String groupDateFlag;

	/** 擅长专业 */
	private List<Mitem> goodProfessList;

	/** 信誉度等级 */
	private List<Mitem> credibyLevelList;

	/** 项目ID */
	private String projectId;

	/** 专家姓名 */
	private String expertName;

	/** 擅长专业 */
	private String goodProfess;

	/** 信誉度等级 */
	private String credibyLevel;

	/** 专家List */
	private List<Texpert> exList;

	/** 性别List */
	private List<Mitem> sexList;

	/** 毕业院校List */
	private List<Map<String, Object>> graduatedList;

	/** 出生年份List */
	private List<Mitem> birthdayYearList;

	/** 学历List */
	private List<Mitem> schoolingTypeList;

	/** 技术职称List */
	private List<Mitem> skilljobTypeList;

	/** 专业List */
	private List<Map<String, Object>> expertmajorTypeList;

	/** 性别 */
	private String sex;

	/** 毕业院校 */
	private String graduatedName;

	/** 出生年份 */
	private String birthdayYear;

	/** 学历 */
	private String schoolingType;

	/** 技术职称 */
	private String skilljobType;
	
	/** 专家职务 */
	private String expertJobType;

	/** 专业 */
	private String expertmajorType;

	/** 专家类型 */
	private String expertType;

	/** 选择的专家ID */
	private String selectedExpertIds;

	/** 专家ID */
	private String expertId;

	/** 选择的专家评分ID */
	private String selectedScoreIds;

	/** 专家评分ID */
	private String scoreId;

	/** 专家对象 */
	private Texpert expert;

	/** 选择的项目ID */
	private String selectedProjectIds;

	/** 专家评审列表 */
	private List<TexpertScore> texpertScoreList;

	/** 申报项目对象 */
	private TprojectApplication tprojectApplication;

	/** 申报项目信息 */
	private VprojectInfo vprojectInfo;

	/** 跳转路径 */
	private String retUrl;

	/** 跳转页面massage */
	private String retMsg;

	/** 擅长专业1集合 */
	private List<Mitem> expertMajor1List;

	/** 信用等级集合 */
	private List<Mitem> expertPrestigeList;

	/** 擅长专业1 */
	private String expertMajor1;

	/** 信用等级 */
	private String expertPrestige;

	/** 专家对象 */
	private Texpert texpert;

	/** 学历集合 */
	private List<Mitem> schoolingList;

	/** 学位集合 */
	private List<Mitem> expertdegreeList;

	/** 行政职务集合 */
	private List<Mitem> expertjobList;

	/** 技术职务集合 */
	private List<Mitem> skilljobList;
	
	/** 专家职务集合 */
	private List<Mitem>  expertJobTypeList;

	/** 擅长专业2集合 */
	private List<Mitem> expertMajor2List;

	/** 擅长专业3集合 */
	private List<Mitem> expertMajor3List;

	/** 信誉等级集合 */
	private List<Mitem> expertprestigeList;

	/** 单位性质集合 */
	private List<Mitem> depttypeList;

	/** 推荐意见集合 */
	private List<Mitem> recommendList;

	/** 专家类型集合 */
	private List<Mitem> expertTypeList;

	/** 页面跳转区分 */
	private String pageDirectFlag;

	/** 分组删除区分 */
	private boolean groupDeleteFlag;
	
	/** 选中的专家一览 */
	List<Map<String,Object>> selectedExpertList = new ArrayList<Map<String,Object>>();

	/** 分组专家关联ID*/
	private String relationId;
	
	/** 分组专家选择锁定区分  1：锁定 0：未锁定 */
	private String clockFlag;
	
	/** 专家意见填写Flag */
	private String expertOpinionFlag;
	/** ajax验证返回字符串 */
	private String backStr;
	
	/** 密钥 **/
	private String key;
	
	/**已选择专家个数*/
	private int selectedExpertNum;

	
	/**
	 * @comments 显示评审专家选择页面
	 * @return
	 * @Version 1.0
	 */
	public String showAuditExpertManage() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "auditExpertSelect");

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

		// 初始化审核状态
		this.auditStatusList = new ArrayList<Mitem>();
		this.auditStatusList = mitemService.getMitemListByPId("");

		// 初始化项目分组
		this.projectGroupList = new ArrayList<TprojectGroup>();
		//this.projectGroupList = tprojectGroupService.getProjectGroupListByDeptId(user.getScDept().getDeptId());
		String typeStr = tprojectTypeManagerService.getProjectTypeStrByUser(user);
		if(!"".equals(typeStr)){
			this.projectGroupList = tprojectGroupService.getProjectGroupListByTypeStr(typeStr);
		}
		
		return "showAuditExpertManage";
	}

	/**
	 * @comments 取得评审专家选择项目列表
	 * @return
	 * @Version 1.0
	 */
	public String getAuditExpertList() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
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

		// 计划类别
		param.put("projectType1", projectType1);

		// 项目分类
		param.put("projectType2", projectType2);

		// 项目分组
		param.put("projectGroup", projectGroup);
		// 计划类别（小分类）查询范围  in
		param.put("type1Str", tprojectTypeManagerService.getProjectTypeStrByUser(user));
		// 是否计财处用户
		boolean isPlanningUser = Constants.PLANNING_DEPARTMENT.equals(user.getScDept().getDeptId());
		param.put("isPlanningUser", isPlanningUser);
		// 取得项目一览信息
		pager = tprojectApplicationAuditService.getAuditExpertList(param, pager.getPageNumber(), pager.getPageSize());

		return "getAuditExpertList";
	}

	/**
	 * @comments 显示
	 * @return
	 * @Version 1.0
	 */
	public String showCreateGroup() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}
		Boolean projectManager = (Boolean)session.getAttribute("projecTypeManager");
		if(projectManager){
			// 初始化计划类别
			this.projectTypeList1 = new ArrayList<TprojectType>();
			this.projectTypeList1 = tprojectTypeManagerService.getProjectTypeListByUser(user);

			// 初始化项目分类
			this.projectTypeList2 = new ArrayList<TprojectType>();
		}else{
			this.projectType2 = tprojectTypeManagerService.getTprojectTypeByUser(user).getTypeId();
			this.projectType1 = tprojectTypeManagerService.getTprojectTypeByUser(user).getParentTypeId();
			this.projectType = tprojectTypeService.getProjectTypeName(projectType1)+ "-" + tprojectTypeService.getProjectTypeName(projectType2);
		}
		

		// 分组数据不显示
		this.groupDateFlag = "0";

		return "showCreateGroup";
	}

	/**
	 * @comments 创建分组时选择项目页面
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @Version 1.0
	 */
	public String showGroupSelectProjectManage() throws UnsupportedEncodingException {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}

		// 初始化计划类别
		this.projectType1 = this.getProjectType1();
		// this.projectTypeList1 = new ArrayList<TprojectType>();
		// this.projectTypeList1 =
		// tprojectTypeService.getFatherProjectTypeListByDeptId(
		// user.getScDept().getDeptId());

		// 初始化项目分类
		this.projectType2 = this.getProjectType2();
		// this.projectTypeList2 = new ArrayList<TprojectType>();

		/*
		 * // 初始化项目分组 this.projectGroupList = new ArrayList<TprojectGroup>();
		 * this.projectGroupList =
		 * tprojectGroupService.getProjectGroupListByDeptId(
		 * user.getScDept().getDeptId());
		 * 
		 * // 初始化审核状态 this.auditStatusList = new ArrayList<Mitem>();
		 * this.auditStatusList = mitemService.getMitemListByPId("");
		 */

		// 分组名称
		this.groupName = new String(this.getGroupName().getBytes("ISO-8859-1"),"UTF-8");
		this.groupId = this.getGroupId();
		return "showGroupSelectProjectManage";
	}

	/**
	 * @comments 取得新建分组时取得的项目List
	 * @return
	 * @throws UnsupportedEncodingException
	 * @Version 1.0
	 */
	public String getGroupSelectProjectList() throws UnsupportedEncodingException {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
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

		// 审核状态(仅查询初审通过状态的项目)
		param.put("auditStatus", Constants.PROJECT_REPORT_BEFOREREVIEW_PASS);

		// 项目分组
		param.put("projectGroup", projectGroup);

		// 项目分组Id
		param.put("groupId", groupId);

		if (!"".equals(groupId) && groupId != null) {
			TprojectGroup pg = tprojectGroupService.get(this.groupId);
			// 计划类别
			param.put("projectType1", pg.getPlanFlag());

			// 项目分类
			param.put("projectType2", pg.getTypeId());
		} else {
			// 计划类别
			param.put("projectType1", this.projectType1);

			// 项目分类
			param.put("projectType2", this.projectType2);
		}
		// 翻页
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}
		
		// 取得项目信息List
		this.pager = tprojectApplicationAuditService.getGroupSelectProjectPager(param,pager.getPageNumber(),
				pager.getPageSize());

		return "getGroupSelectProjectList";
	}

	/**
	 * @throws UnsupportedEncodingException
	 * @comments 保存项目分组选择的项目信息
	 * @Version 1.0
	 */
	public String saveGroupSelectedProject() throws UnsupportedEncodingException {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}

		// 取得的项目id是否为空
		if (!"".equals(selectedProjectIds) && selectedProjectIds != null) {

			// 分组名称
			this.groupName = new String(this.getGroupName().getBytes("ISO-8859-1"), "UTF-8");
			this.projectType1 = this.getProjectType1();
			this.projectType2 = this.getProjectType2();
			// 创建新分组，更新选择项目分组情况
			this.groupId = tprojectGroupService.saveGroupSelectProject(groupId, selectedProjectIds, groupName, user
					.getScDept().getDeptId(), this.projectType1, this.projectType2, user.getUserId());
		}
		this.pageDirectFlag = this.getPageDirectFlag();
		String url = "";
		if ("new".equals(pageDirectFlag)) {
			url = "/api/audit/projectApplication!showAuditExpertManage.action?";
		} else {
			url = "/api/audit/projectApplication!editGroup.action?groupId=" + this.getGroupId();
		}

		// 设置提示信息
		this.setRetMsg(this.getText("opt_save_suc"));

		this.setRetUrl(super.getRequest().getContextPath() + url + "&now=" + new Date().getTime());
		return "systemInfoMain";
	}

	/**
	 * 
	 * @comments 编辑分组
	 * @return
	 * @version 1.0
	 */
	public String editGroup() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}

		// 根据分组ID取得分组信息
		TprojectGroup projectGroup = tprojectGroupService.get(this.groupId);
		this.groupName = projectGroup.getGroupName();
		String typeName = tprojectTypeService.getProjectTypeName(projectGroup.getTypeId());
		String planName = tprojectTypeService.getProjectTypeName(projectGroup.getPlanFlag());
		this.projectType = planName + "-" + typeName;

		// 根据分组id取得该分组下的项目
		// 翻页
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}

		Map<String, Object> param = new HashMap<String, Object>();

		// 封装查询条件
		// 分组ID
		param.put("groupId", this.getGroupId());

		// 取得项目一览信息
		pager = tprojectApplicationAuditService.getGroupProjectList(param, pager.getPageNumber(), pager.getPageSize());

		return "editGroup";
	}

	/**
	 * 
	 * @comments 从分组中删除一个项目
	 * @return
	 * @version 1.0
	 */
	public String deleteProjectFromGroup() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}

		// 取得项目编号
		this.projectId = this.getProjectId();

		// 删除项目分组信息
		TprojectApplication tp = tprojectApplicationService.get(this.projectId);
		//tp.setTprojectGroup(null);
		tprojectGroupService.deleteProjecFromGroup(user.getUserId(), tp);
		//tprojectApplicationService.update(tp);
		String url = "";
		// 删除分组
		if (this.isGroupDeleteFlag()) {
			//TprojectGroup group = tprojectGroupService.get(this.getGroupId());
			tprojectGroupService.deleteGroup(this.groupId, user.getUserId());
			//group.setDeleteFlag("1");
			//group.setUpdateUser(user.getUserId());
			//group.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			//tprojectGroupService.update(group);
			url = "/api/audit/projectApplication!showAuditExpertManage.action?";
		} else {
			url = "/api/audit/projectApplication!editGroup.action?" + "groupId=" + this.groupId;
		}
		// 设置提示信息
		this.setRetMsg(this.getText("opt_del_suc"));

		this.setRetUrl(super.getRequest().getContextPath() + url + "&now=" + new Date().getTime());
		return "systemInfoMain";
	}

	public String getGroupSelectedProjectList() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}

		// 翻页
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}

		// 取得项目一览信息
		pager = tprojectApplicationAuditService.getGroupSelectedProjectList(groupId, pager.getPageNumber(),
				pager.getPageSize());

		return "getGroupSelectedProjectList";
	}

	/**
	 * 
	 * @comments 验证新建的分组名称是否已经存在（只验证在同一个项目分类下）
	 * @return
	 * @version 1.0
	 */
	public String checkGroupName(){
		String checkRes = "false";
		// 待验证分组名称
		String groupNameCheck = this.getGroupName().trim();
		String projectType2 = this.getProjectType2();
		// 取得分组中项目分类（小分类）为projectType2的分组
		List<TprojectGroup> groupList = new ArrayList<TprojectGroup>();
		groupList = tprojectGroupService.getProjectGroupListByTypeStr("'" + projectType2 + "'");
		for (TprojectGroup tprojectGroup : groupList) {
			if(tprojectGroup!=null && groupNameCheck.equals(tprojectGroup.getGroupName())){
				checkRes = "true";
				continue;
			}
		}
		this.backStr = checkRes;
		return "getDataSuccess";
	}
	/**
	 * @comments 保存、更新项目分组
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @Version 1.0
	 */
	public String saveOrUpdateGroup() throws UnsupportedEncodingException {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}
		String url = "";
		// 分组Id
		this.groupId = this.getGroupId();
		if (!"".equals(groupId) && groupId != null) {

			this.groupName = this.getGroupName();
			// TprojectGroup pg = tprojectGroupService.get(this.groupId);
			/*
			 * url =
			 * "/api/audit/projectApplication!showGroupSelectProjectManage.action?"
			 * + "groupName=" + this.groupName + "&projectType1=" +
			 * pg.getPlanFlag() + "&projectType2=" + pg.getTypeId() +
			 * "&groutId=" + this.groupId;
			 */
			tprojectGroupService.saveOrUpdateGroup(groupId, groupName, user.getScDept().getDeptId());
			url = "/api/audit/projectApplication!showAuditExpertManage.action?";
			// 设置提示信息
			this.setRetMsg(this.getText("opt_save_suc"));

			this.setRetUrl(super.getRequest().getContextPath() + url + "&now=" + new Date().getTime());
			return "systemInfoMain";
		} else {
			url = "/api/audit/projectApplication!showGroupSelectProjectManage.action?" + "groupName=" 
					+ java.net.URLEncoder.encode(this.groupName, "ISO-8859-1")
					+ "&projectType1=" + this.projectType1 + "&projectType2=" + this.projectType2 + "&pageDirectFlag="
					+ "new";
			// 设置提示信息
			this.setRetMsg(this.getText("opt_save_suc"));

			this.setRetUrl(super.getRequest().getContextPath() + url + "&now=" + new Date().getTime());
			return "systemMainNext";
		}
	}

	/**
	 * 
	 * @comments 删除分组
	 * @return
	 * @version 1.0
	 */
	public String deleteGroup() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}

		// 删除分组
		tprojectGroupService.deleteGroup(this.groupId, user.getUserId());

		String url = "";
		url = "/api/audit/projectApplication!showAuditExpertManage.action?";

		// 设置提示信息
		this.setRetMsg(this.getText("opt_del_suc"));

		this.setRetUrl(super.getRequest().getContextPath() + url + "&now=" + new Date().getTime());
		return "systemInfoMain";
	}

	/**
	 * 
	 * @comments 批量从分组中删除项目
	 * @return
	 * @version 1.0
	 */
	public String deleteProjectListFromGroup() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}

		// 取得项目编号
		this.selectedProjectIds = this.getSelectedProjectIds();
		if (!"".equals(selectedProjectIds) && selectedProjectIds != null) {
			// 删除项目分组信息
			String[] projectIdArr = selectedProjectIds.split(",");
			for (int i = 0; i < projectIdArr.length; i++) {
				String projectIdTemp = projectIdArr[i];
				TprojectApplication tp = tprojectApplicationService.get(projectIdTemp);
				if (tp != null) {
					tprojectGroupService.deleteProjecFromGroup(user.getUserId(), tp);
				}
			}
		}
		String url = "";
		// 删除分组
		if (this.isGroupDeleteFlag()) {
			/*TprojectGroup group = tprojectGroupService.get(this.getGroupId());
			group.setDeleteFlag("1");
			group.setUpdateUser(user.getUserId());
			group.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tprojectGroupService.update(group);*/
			tprojectGroupService.deleteGroup(this.groupId, user.getUserId());
			url = "/api/audit/projectApplication!showAuditExpertManage.action?";
		} else {
			url = "/api/audit/projectApplication!editGroup.action?" + "groupId=" + this.groupId;
		}
		// 设置提示信息
		this.setRetMsg(this.getText("opt_del_suc"));

		this.setRetUrl(super.getRequest().getContextPath() + url + "&now=" + new Date().getTime());
		return "systemInfoMain";
	}

	/**
	 * @comments 批量更新项目分组
	 * @return
	 * @Version 1.0
	 */
	public String cancelBatchGroupSelect() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}

		// 取消项目选择
		this.selectedProjectIds = this.getSelectedProjectIds();

		if (!"".equals(selectedProjectIds) && selectedProjectIds != null) {
			tprojectApplicationAuditService.updateBatchProjectGroup(selectedProjectIds);
		}

		// 翻页
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}

		// 取得项目一览信息
		pager = tprojectApplicationAuditService.getGroupSelectedProjectList(groupId, pager.getPageNumber(),
				pager.getPageSize());

		return "getGroupSelectedProjectList";
	}

	/**
	 * @comments 更新项目分组
	 * @return
	 * @Version 1.0
	 */
	public String cancelGroupSelect() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}

		// 取消项目选择
		this.projectId = this.getProjectId();

		if (!"".equals(projectId) && projectId != null) {
			tprojectApplicationAuditService.updateProjectGroup(projectId);
		}

		// 翻页
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}

		// 取得项目一览信息
		pager = tprojectApplicationAuditService.getGroupSelectedProjectList(groupId, pager.getPageNumber(),
				pager.getPageSize());

		return "getGroupSelectedProjectList";
	}

	/**
	 * @comments 显示项目分组选择页面
	 * @return
	 * @Version 1.0
	 */
	public String showGroupList() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}

		// 取得项目Id
		this.projectId = this.getProjectId();
		// 取得项目信息
		TprojectApplication tp = tprojectApplicationAuditService.get(projectId);

		if (tp != null) {
			this.projectGroupList = tprojectGroupService.getProjectGroupListByTypeId(tp.getTprojectType().getTypeId());
			this.projectGroupSon = tp.getTprojectGroup().getGroupId();
		}
		return "showGroupList";
	}

	/**
	 * @comments 改变项目分组
	 * @Version 1.0
	 */
	public void updateProjectGroup() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return;
		}

		// 取得项目ID
		this.projectId = this.getProjectId();
		// 取得分组ID
		this.groupId = this.getGroupId();
		// 先将该项目从旧分组中删除
		TprojectApplication tpa = tprojectApplicationService.get(this.projectId);
		String oldGroupId = tpa.getTprojectGroup().getGroupId();
		tprojectGroupService.deleteProjecFromGroup(user.getUserId(), tpa);
		// 将该项目设定到新的分组中
		tprojectApplicationAuditService.updateProjectGroup(projectId, groupId,oldGroupId);
	}

	/**
	 * 批量选择专家
	 * 
	 * @comments
	 * @return
	 * @Version 1.0
	 */
	public String showBatchSelectExpert() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}

		// 初始化擅长专业
		this.goodProfessList = new ArrayList<Mitem>();
		// 添加擅长专业1
		this.goodProfessList = mitemService.getListByTypeId(Constants.EXPERTMAJOR1_TYPE);
		// 添加擅长专业2
		this.goodProfessList.addAll(mitemService.getListByTypeId(Constants.EXPERTMAJOR2_TYPE));
		// 添加擅长专业3
		this.goodProfessList.addAll(mitemService.getListByTypeId(Constants.EXPERTMAJOR3_TYPE));

		// 初始化信誉等级
		this.credibyLevelList = new ArrayList<Mitem>();
		this.credibyLevelList = mitemService.getListByTypeId(Constants.EXPERTPRESTIGE_TYPE);

		// 取得选择的项目Id
		this.selectedProjectIds = this.getSelectedProjectIds();

		// 设置项目ID
		this.projectId = selectedProjectIds;

		return "showBatchSelectExpert";
	}

	/**
	 * @comments 取得已选择的专家信息
	 * @return
	 * @Version 1.0
	 */
	public String getSelectedList() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}

		// 取得分组id
		this.groupId = this.getGroupId();
		// 锁定区分
		TprojectGroup g = tprojectGroupService.get(this.groupId);
		if(null != g){
			this.clockFlag = g.getClockFlag();
		}
		
		/*// 查询条件
		Map<String, Object> param = new HashMap<String, Object>();

		// 封装查询条件
		if (!"".equals(groupId) && groupId != null) {
			param.put("groupId", groupId);
		}*/

		// 取得的已选专家一览		
		selectedExpertList = texpertScoreService.getSelectedExpertListByGroupId(groupId);

		return "getSelectedList";
	}

	/**
	 * 
	 * @comments 锁定该分组选择的专家 
	 * @return
	 * @version 1.0
	 */
	public String clockExpert() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}

		// 取得关联Id
		this.relationId = this.getRelationId();
		// 分组ID
		this.groupId = this.getGroupId();
		TprojectGroup closeGroup = tprojectGroupService.get(this.groupId);
		// 锁定专家
		if(null != closeGroup){
			closeGroup.setClockFlag("1");
			closeGroup.setUpdateUser(user.getUserId());
			closeGroup.setUpdateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tprojectGroupService.update(closeGroup);
		}

		// 页面跳转
		String url = "/api/audit/projectApplication!getSelectedList.action?" + "groupId=" + this.groupId;

		// 设置提示信息
		this.setRetMsg("专家锁定成功");

		this.setRetUrl(super.getRequest().getContextPath() + url + "&now=" + new Date().getTime());
		return "systemInfoMain";
	}
	/**
	 * @comments 已专家选择列表页面
	 * @return
	 * @Version 1.0
	 */
	public String showExpertSelected() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}

		// 项目Id
		this.projectId = this.getProjectId();

		// 初始化擅长专业
		this.goodProfessList = new ArrayList<Mitem>();
		// 添加擅长专业1
		this.goodProfessList = mitemService.getListByTypeId(Constants.EXPERTMAJOR1_TYPE);
		// 添加擅长专业2
		this.goodProfessList.addAll(mitemService.getListByTypeId(Constants.EXPERTMAJOR2_TYPE));
		// 添加擅长专业3
		this.goodProfessList.addAll(mitemService.getListByTypeId(Constants.EXPERTMAJOR3_TYPE));

		// 初始化信誉等级
		this.credibyLevelList = new ArrayList<Mitem>();
		this.credibyLevelList = mitemService.getListByTypeId(Constants.EXPERTPRESTIGE_TYPE);

		return "showExpertSelected";
	}

	/**
	 * @comments 批量删除选择的专家
	 * @return
	 * @Version 1.0
	 */
	public String deleteBatchExpert() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}

		// 取得选择的专家Id
		this.selectedExpertIds = this.getSelectedExpertIds();

		// 批量删除专家
		if (!"".equals(selectedExpertIds) && selectedExpertIds != null) {

			texpertScoreService.deleteBatchExpert(selectedExpertIds);
		}

		// 分组ID
		this.groupId = this.getGroupId();

		// 页面跳转
		String url = "/api/audit/projectApplication!getSelectedList.action?" + "groupId=" + this.groupId;

		// 设置提示信息
		this.setRetMsg(this.getText("opt_del_suc"));

		this.setRetUrl(super.getRequest().getContextPath() + url + "&now=" + new Date().getTime());
		return "systemInfoMain";
	}

	/**
	 * @comments 删除专家
	 * @return
	 * @Version 1.0
	 */
	public String deleteExpert() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return "LogOut";
		}

		// 取得关联Id
		this.relationId = this.getRelationId();
		// 分组ID
		this.groupId = this.getGroupId();
		// 删除专家
		texpertScoreService.deleteExpert(relationId);

		// 页面跳转
		String url = "/api/audit/projectApplication!getSelectedList.action?" + "groupId=" + this.groupId;

		// 设置提示信息
		this.setRetMsg(this.getText("opt_del_suc"));

		this.setRetUrl(super.getRequest().getContextPath() + url + "&now=" + new Date().getTime());
		return "systemInfoMain";
	}

	/**
	 * @comments 显示专家选择页面
	 * @return
	 * @Version 1.0
	 */
	public String showAuditSelectExpertManage() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		
		if(key != null && KeyUtil.checkKey(key)){
			this.key = "1";
		}else{
			// 如果用户为空或者企业为空，退出系统
			if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
				return "LogOut";
			}
		}

		// 取得项目ID
		this.projectId = this.getProjectId();

		// 初始化性别选择条件
		this.sexList = new ArrayList<Mitem>();
		this.sexList = mitemService.getListByTypeId(Constants.SEX_TYPE);

		// 初始化出生年份选择条件
		this.birthdayYearList = new ArrayList<Mitem>();
		this.birthdayYearList = mitemService.getListByTypeId(Constants.BIRTHDAY_YEAR);

		// 初始化学历选择条件
		this.schoolingTypeList = new ArrayList<Mitem>();
		this.schoolingTypeList = mitemService.getListByTypeId(Constants.SCHOOLING_TYPE);

		// 初始化技术职称选择条件
		this.skilljobTypeList = new ArrayList<Mitem>();
		this.skilljobTypeList = mitemService.getListByTypeId(Constants.SKILLJOB_TYPE);

		// 初始化专业选择条件
		this.expertmajorTypeList = new ArrayList<Map<String, Object>>();
		this.expertmajorTypeList = texpertService.getGraduatedList("expertmajorType", "expert_major");

		// 初始化毕业院校选择条件
		this.graduatedList = new ArrayList<Map<String, Object>>();
		this.graduatedList = texpertService.getGraduatedList("graduatedName", "graduate_School");

		// 初始化专家类型
		this.expertTypeList = new ArrayList<Mitem>();
		this.expertTypeList = mitemService.getListByTypeId(Constants.EXPERT_TYPE);
		
		// 初始化专家职务
		this.expertJobTypeList = new ArrayList<Mitem>();
		this.expertJobTypeList = mitemService.getListByTypeId(Constants.EXPERT_JOB_TYPE);
		
		// 取得该分组下已有的专家个数
		List<TgroupExpertRealtion> expertList = tgroupExpertRealtionService.getList("tprojectGroup.groupId", this.groupId);
		if(expertList!=null){
			this.selectedExpertNum = expertList.size();
		}
		return "showAuditSelectExpertManage";
		
	}

	/**
	 * @comments 取得未选择的专家列表信息
	 * @return
	 * @throws UnsupportedEncodingException
	 * @Version 1.0
	 */
	public String getAddAuditList() throws UnsupportedEncodingException {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		if(key != null && "1".equals(key)){
			this.key = "1";
		}else{
			// 如果用户为空或者企业为空，退出系统
			if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
				return "LogOut";
			}
		}

		// 取得项目编号
		this.projectId = this.getProjectId();

		Map<String, Object> param = new HashMap<String, Object>();

		// 封装查询条件
		// 项目ID
		param.put("groupId", groupId);

		// 姓名
		param.put("sex", sex);

		// 出生年份
		param.put("birthdayYear", birthdayYear);

		// 学历
		param.put("schoolingType", schoolingType);

		// 技术职称
		param.put("skilljobType", skilljobType);

		// 专家类型
		param.put("expertType", expertType);
		
		// 专家职务
		param.put("expertJobType", expertJobType);

		// 专家姓名
		if (expertName != null && !"".equals(expertName)) {

			// 中文编码转换
			expertName = new String(expertName.getBytes("ISO-8859-1"), "UTF-8");
		}
		param.put("expertName", expertName);

		// 专业
		if (expertmajorType != null && !"".equals(expertmajorType)) {

			// 中文编码转换
			expertmajorType = new String(expertmajorType.getBytes("ISO-8859-1"), "UTF-8");
		}
		param.put("expertmajorType", expertmajorType);

		// 毕业院校
		if (graduatedName != null && !"".equals(graduatedName)) {

			// 中文编码转换
			graduatedName = new String(graduatedName.getBytes("ISO-8859-1"), "UTF-8");
		}
		param.put("graduatedName", graduatedName);

		// 专家列表
		this.exList = texpertService.getAddAuditList(param);

		return "getAddAuditList";
	}

	/**
	 * @comments 关闭专家选择页面时，保存选择的专家信息
	 * @Version 1.0
	 */
	public void saveSelectedExpert() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
			return;
		}

		// 选择专家页面关闭时的操作
		// 是否已经选择专家
		if (selectedExpertIds != null && !"".equals(selectedExpertIds)) {

			// 取得分组ID
			this.groupId = this.getGroupId();

			// 保存选择的专家
			texpertScoreService.saveTexpertScores(groupId, selectedExpertIds,user.getUserId());
		}
	}

	/**
	 * @comments 显示新增专家页面
	 * @return
	 * @Version 1.0
	 */
	public String showAuditInsertExpert() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		if(key != null && "1".equals(key)){
			this.key = "1";
		}else{
			// 如果用户为空或者企业为空，退出系统
			if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
				return "LogOut";
			}
		}

		// 性别SEX_TYPE
		this.sexList = new ArrayList<Mitem>();
		this.sexList = mitemService.getMitemListById(Constants.SEX_TYPE);

		// 学历-SCHOOLING_TYPE
		this.schoolingList = new ArrayList<Mitem>();
		this.schoolingList = mitemService.getMitemListById(Constants.SCHOOLING_TYPE);

		// 学位-EXPERTDEGREE_TYPE
		this.expertdegreeList = new ArrayList<Mitem>();
		this.expertdegreeList = mitemService.getMitemListById(Constants.EXPERTDEGREE_TYPE);

		// 行政职务-EXPERTJOB_TYPE
		this.expertjobList = new ArrayList<Mitem>();
		this.expertjobList = mitemService.getMitemListById(Constants.EXPERTJOB_TYPE);

		// 技术职务-SKILLJOB_TYPE
		this.skilljobList = new ArrayList<Mitem>();
		this.skilljobList = mitemService.getMitemListById(Constants.SKILLJOB_TYPE);

		// 擅长专业1-EXPERTMAJOR1_TYPE
		this.expertMajor1List = new ArrayList<Mitem>();
		this.expertMajor1List = mitemService.getMitemListById(Constants.EXPERTMAJOR1_TYPE);

		// 擅长专业2-EXPERTMAJOR2_TYPE
		this.expertMajor2List = new ArrayList<Mitem>();
		this.expertMajor2List = mitemService.getMitemListById(Constants.EXPERTMAJOR2_TYPE);

		// 擅长专业3-EXPERTMAJOR3_TYPE
		this.expertMajor3List = new ArrayList<Mitem>();
		this.expertMajor3List = mitemService.getMitemListById(Constants.EXPERTMAJOR3_TYPE);

		// 信誉等级-EXPERTPRESTIGE_TYPE
		this.expertprestigeList = new ArrayList<Mitem>();
		this.expertprestigeList = mitemService.getMitemListById(Constants.EXPERTPRESTIGE_TYPE);

		// 单位性质-DEPTTYPE_TYPE
		this.depttypeList = new ArrayList<Mitem>();
		this.depttypeList = mitemService.getMitemListById(Constants.DEPTTYPE_TYPE);

		// 初始化专家类型
		this.expertTypeList = new ArrayList<Mitem>();
		this.expertTypeList = mitemService.getListByTypeId(Constants.EXPERT_TYPE);

		return "showAuditInsertExpert";
	}

	/**
	 * @comments 新增专家
	 * @Version 1.0
	 */
	public void insertAuditExpert() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		if(key != null && "1".equals(key)){
			this.key = "1";
			
			// 取得提交的专家信息
			this.expert = this.getExpert();

			// 新增专家
			texpertService.saveAuditExpert(expert, null);
		}else{
		// 如果用户为空或者企业为空，退出系统
			if (user == null || ("").equals(user.getUserId()) || !"auditExpertSelect".equals(cmdkey)) {
				return;
			}
	
			// 取得提交的专家信息
			this.expert = this.getExpert();
	
			// 新增专家
			texpertService.saveAuditExpert(expert, user.getUserId());
		}
	}

	/**
	 * @comments 项目审核
	 * @return
	 * @Version 1.0
	 */
	public String showAuditManage() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(Constants.SESSION_CMDKEY, "tprojectApplicationAudit");

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 初始化计划类别
		this.projectTypeList1 = new ArrayList<TprojectType>();
		this.projectTypeList1 = tprojectTypeService.getFatherProjectTypeListByDeptId(user.getScDept().getDeptId());

		// 初始化项目分类
		this.projectTypeList2 = new ArrayList<TprojectType>();

		// 初始化审核状态
		this.auditStatusList = new ArrayList<Mitem>();
		this.auditStatusList = mitemService.getMitemListByPId("");

		// 初始化项目分组
		this.projectGroupList = new ArrayList<TprojectGroup>();
		this.projectGroupList = tprojectGroupService.getProjectGroupListByDeptId(user.getScDept().getDeptId());

		return "auditManage";
	}

	/**
	 * @comments 项目审核List
	 * @return
	 * @Version 1.0
	 */
	public String getAuditList() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"tprojectApplicationAudit".equals(cmdkey)) {
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

		// 计划类别
		param.put("projectType1", projectType1);

		// 项目分类
		param.put("projectType2", projectType2);

		// 审核状态
		param.put("auditStatus", auditStatus);

		// 项目分组
		param.put("projectGroup", projectGroup);

		// 取得项目验收管理一览
		pager = tprojectApplicationAuditService.getProjectAuditList(param, pager.getPageNumber(), pager.getPageSize());

		return "auditResultList";
	}

	/**
	 * @comments 显示填写意见页面
	 * @return
	 * @Version 1.0
	 */
	public String showOpinions() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"jointAudit".equals(cmdkey)) {
			return "LogOut";
		}

		// 取得项目Id
		this.projectId = this.getProjectId();

		// 初始化推荐意见
		this.recommendList = new ArrayList<Mitem>();
		this.recommendList = mitemService.getMitemListById(Constants.COMPANY_RECOMMENDATION);

		// 取得专家评审列表
		this.texpertScoreList = new ArrayList<TexpertScore>();
		this.texpertScoreList = texpertScoreService.getExpertScoreList(projectId);

		// 取得项目申报对象
		this.tprojectApplication = tprojectApplicationAuditService.getProjectAppliaction(projectId);
		
		if(tprojectApplication != null 
				&& tprojectApplication.getExpertOpinionStatus() != null 
				&& "0".equals(tprojectApplication.getExpertOpinionStatus())){
			this.expertOpinionFlag = "0";
		}
		else{
			this.expertOpinionFlag = "1";
		}

		return "showOpinions";
	}

	/**
	 * @comments 保存评审意见
	 * @return
	 * @Version 1.0
	 */
	public String saveAuditOpinions() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"jointAudit".equals(cmdkey)) {
			return "LogOut";
		}

		// 取得专家评审意见
		this.texpertScoreList = this.getTexpertScoreList();

		// 取得项目评审意见
		this.tprojectApplication = this.getTprojectApplication();

		// 保存评审意见
		this.tprojectApplicationAuditService.saveAuditOpinions(texpertScoreList, tprojectApplication, user.getUserId());

		// 设置提示信息
		this.setRetMsg(this.getText("opt_save_suc"));

		// 设置actionUrl
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/audit/projectApplication!showOpinions.action?projectId=" + tprojectApplication.getProjectId()
				+ "&now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * @comments 提交评审意见
	 * @return
	 * @Version 1.0
	 */
	public String submitAuditOpinions() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"jointAudit".equals(cmdkey)) {
			return "LogOut";
		}

		// 取得专家评审意见
		this.texpertScoreList = this.getTexpertScoreList();

		// 取得项目评审意见
		this.tprojectApplication = this.getTprojectApplication();

		// 提交评审意见
		this.tprojectApplicationAuditService.saveAndSubmitAuditOpinions(texpertScoreList, tprojectApplication,
				user.getUserId());

		// 设置提示信息
		this.setRetMsg(this.getText("opt_save_suc"));

		// 设置actionUrl
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/audit/projectApplicationJoint!showJointAuditManage.action?" + "&now=" + new Date().getTime());

		return "systemInfoMain";
	}

	/**
	 * @comments 查看评审进度管理页面
	 * @return
	 * @Version 1.0
	 */
	public String showAuditPropress() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"tprojectApplicationAudit".equals(cmdkey)) {
			return "LogOut";
		}

		// 项目Id
		this.projectId = this.getProjectId();

		// 初始化擅长专业
		this.goodProfessList = new ArrayList<Mitem>();
		// 添加擅长专业1
		this.goodProfessList = mitemService.getListByTypeId(Constants.EXPERTMAJOR1_TYPE);
		// 添加擅长专业2
		this.goodProfessList.addAll(mitemService.getListByTypeId(Constants.EXPERTMAJOR2_TYPE));
		// 添加擅长专业3
		this.goodProfessList.addAll(mitemService.getListByTypeId(Constants.EXPERTMAJOR3_TYPE));

		// 初始化信誉等级
		this.credibyLevelList = new ArrayList<Mitem>();
		this.credibyLevelList = mitemService.getListByTypeId(Constants.EXPERTPRESTIGE_TYPE);

		return "auditPropressManage";
	}

	/**
	 * @comments 取得专家处理结果列表
	 * @return
	 * @Version 1.0
	 */
	public String getAuditProgressList() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"tprojectApplicationAudit".equals(cmdkey)) {
			return "LogOut";
		}

		// 翻页
		if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		} else {
			pager = new Pager();
			pager.setPageNumber(this.getPageNo());
		}

		// 取得项目编号
		this.projectId = this.getProjectId();

		// 查询条件
		Map<String, Object> param = new HashMap<String, Object>();

		// 封装查询条件
		// 项目ID
		param.put("projectId", projectId);

		// 专家名称
		param.put("expertName", expertName);

		// 擅长专业
		param.put("goodProfess", goodProfess);

		// 信誉度等级
		param.put("credibyLevel", credibyLevel);

		// 取得的已选专家一览
		pager = texpertScoreService.getProgressExpertList(param, pager.getPageNumber(), pager.getPageSize());

		return "auditProgressList";
	}

	/**
	 * @comments 发送通知
	 * @return
	 * @Version 1.0
	 */
	public String sendMessage() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"tprojectApplicationAudit".equals(cmdkey)) {
			return "LogOut";
		}

		// 取得项目Id
		this.projectId = this.getProjectId();

		// 设置专家Id
		this.expertId = this.getExpertId();

		return "showSendMessasePage";
	}

	// 分割线 TODO

	/**
	 * @comments 取得批量选择专家列表
	 * @return
	 * @Version 1.0
	 */
	public String getBatchSelectExpert() {
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

		// 取得选择的项目Id
		this.selectedProjectIds = this.getSelectedProjectIds();

		// 查询条件
		Map<String, Object> param = new HashMap<String, Object>();

		// 封装查询条件
		// 项目ID
		param.put("projectId", selectedProjectIds);

		// 专家名称
		param.put("expertName", expertName);

		// 擅长专业
		param.put("goodProfess", goodProfess);

		// 信誉度等级
		param.put("credibyLevel", credibyLevel);

		texpertScoreService.getBatchSelectedExpertList(param, pager.getPageNumber(), pager.getPageSize());

		return "batchSelectedExpert";
	}

	/**
	 * @comments 显示专家选择页面（批量）
	 * @return
	 * @Version 1.0
	 */
	public String showBatchAuditSelectExpertManage() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");

		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 取得选择的项目Id
		this.selectedProjectIds = this.getSelectedProjectIds();

		// 初始化性别选择条件
		this.sexList = new ArrayList<Mitem>();

		Mitem m0 = new Mitem();
		m0.setItemId("0");
		m0.setItemName("男");
		sexList.add(m0);

		Mitem m1 = new Mitem();
		m1.setItemId("1");
		m1.setItemName("女");
		sexList.add(m1);

		// 初始化毕业院校选择条件
		// this.graduatedList = texpertService.getGraduatedList();

		return "auditBatchSelectExpertManage";
	}

	/**
	 * @comments 取得未选择的专家列表信息（批量）
	 * @return
	 * @throws UnsupportedEncodingException
	 * @Version 1.0
	 */
	public String getBatchAddAuditList() throws UnsupportedEncodingException {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");

		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}

		// 取得选择的项目Id
		this.selectedProjectIds = this.getSelectedProjectIds();

		Map<String, Object> param = new HashMap<String, Object>();

		// 封装查询条件
		// 项目ID
		param.put("projectId", selectedProjectIds);

		// 信誉度等级
		param.put("sex", sex);

		// 毕业院校
		if (graduatedName != null && !"".equals(graduatedName)) {

			// 中文编码转换
			graduatedName = new String(graduatedName.getBytes("ISO-8859-1"), "UTF-8");
		}
		param.put("graduatedName", graduatedName);

		// 专家列表
		this.exList = texpertService.getBatchAddAuditList(param);

		return "addAuditBatchList";
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

	public TprojectApplicationAuditService getTprojectApplicationAuditService() {
		return tprojectApplicationAuditService;
	}

	public void setTprojectApplicationAuditService(TprojectApplicationAuditService tprojectApplicationAuditService) {
		this.tprojectApplicationAuditService = tprojectApplicationAuditService;
	}

	public MitemService getMitemService() {
		return mitemService;
	}

	public void setMitemService(MitemService mitemService) {
		this.mitemService = mitemService;
	}

	public TexpertScoreService getTexpertScoreService() {
		return texpertScoreService;
	}

	public void setTexpertScoreService(TexpertScoreService texpertScoreService) {
		this.texpertScoreService = texpertScoreService;
	}

	public TexpertService getTexpertService() {
		return texpertService;
	}

	public void setTexpertService(TexpertService texpertService) {
		this.texpertService = texpertService;
	}

	public List<Mitem> getCompanyTypeList() {
		return companyTypeList;
	}

	public void setCompanyTypeList(List<Mitem> companyTypeList) {
		this.companyTypeList = companyTypeList;
	}

	public List<Mitem> getProjectTypeList() {
		return projectTypeList;
	}

	public void setProjectTypeList(List<Mitem> projectTypeList) {
		this.projectTypeList = projectTypeList;
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

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
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

	public List<Mitem> getGoodProfessList() {
		return goodProfessList;
	}

	public void setGoodProfessList(List<Mitem> goodProfessList) {
		this.goodProfessList = goodProfessList;
	}

	public List<Mitem> getCredibyLevelList() {
		return credibyLevelList;
	}

	public void setCredibyLevelList(List<Mitem> credibyLevelList) {
		this.credibyLevelList = credibyLevelList;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getExpertName() {
		return expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}

	public String getGoodProfess() {
		return goodProfess;
	}

	public void setGoodProfess(String goodProfess) {
		this.goodProfess = goodProfess;
	}

	public String getCredibyLevel() {
		return credibyLevel;
	}

	public void setCredibyLevel(String credibyLevel) {
		this.credibyLevel = credibyLevel;
	}

	public List<Texpert> getExList() {
		return exList;
	}

	public void setExList(List<Texpert> exList) {
		this.exList = exList;
	}

	public List<Mitem> getSexList() {
		return sexList;
	}

	public void setSexList(List<Mitem> sexList) {
		this.sexList = sexList;
	}

	public List<Map<String, Object>> getGraduatedList() {
		return graduatedList;
	}

	public void setGraduatedList(List<Map<String, Object>> graduatedList) {
		this.graduatedList = graduatedList;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGraduatedName() {
		return graduatedName;
	}

	public void setGraduatedName(String graduatedName) {
		this.graduatedName = graduatedName;
	}

	public String getSelectedExpertIds() {
		return selectedExpertIds;
	}

	public void setSelectedExpertIds(String selectedExpertIds) {
		this.selectedExpertIds = selectedExpertIds;
	}

	public Texpert getExpert() {
		return expert;
	}

	public void setExpert(Texpert expert) {
		this.expert = expert;
	}

	public String getSelectedProjectIds() {
		return selectedProjectIds;
	}

	public void setSelectedProjectIds(String selectedProjectIds) {
		this.selectedProjectIds = selectedProjectIds;
	}

	public List<TexpertScore> getTexpertScoreList() {
		return texpertScoreList;
	}

	public void setTexpertScoreList(List<TexpertScore> texpertScoreList) {
		this.texpertScoreList = texpertScoreList;
	}

	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	public VprojectInfo getVprojectInfo() {
		return vprojectInfo;
	}

	public void setVprojectInfo(VprojectInfo vprojectInfo) {
		this.vprojectInfo = vprojectInfo;
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

	public String getApplyCompany() {
		return applyCompany;
	}

	public void setApplyCompany(String applyCompany) {
		this.applyCompany = applyCompany;
	}

	public String getGroupDateFlag() {
		return groupDateFlag;
	}

	public void setGroupDateFlag(String groupDateFlag) {
		this.groupDateFlag = groupDateFlag;
	}

	public List<TprojectGroup> getProjectGroupList() {
		return projectGroupList;
	}

	public void setProjectGroupList(List<TprojectGroup> projectGroupList) {
		this.projectGroupList = projectGroupList;
	}

	public String getProjectGroup() {
		return projectGroup;
	}

	public void setProjectGroup(String projectGroup) {
		this.projectGroup = projectGroup;
	}

	public List<Map<String, Object>> getProjectSelectList() {
		return projectSelectList;
	}

	public void setProjectSelectList(List<Map<String, Object>> projectSelectList) {
		this.projectSelectList = projectSelectList;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
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

	public String getProjectGroupSon() {
		return projectGroupSon;
	}

	public void setProjectGroupSon(String projectGroupSon) {
		this.projectGroupSon = projectGroupSon;
	}

	public String getExpertId() {
		return expertId;
	}

	public void setExpertId(String expertId) {
		this.expertId = expertId;
	}

	public String getSelectedScoreIds() {
		return selectedScoreIds;
	}

	public void setSelectedScoreIds(String selectedScoreIds) {
		this.selectedScoreIds = selectedScoreIds;
	}

	public String getScoreId() {
		return scoreId;
	}

	public void setScoreId(String scoreId) {
		this.scoreId = scoreId;
	}

	public List<Mitem> getBirthdayYearList() {
		return birthdayYearList;
	}

	public void setBirthdayYearList(List<Mitem> birthdayYearList) {
		this.birthdayYearList = birthdayYearList;
	}

	public List<Mitem> getSchoolingTypeList() {
		return schoolingTypeList;
	}

	public void setSchoolingTypeList(List<Mitem> schoolingTypeList) {
		this.schoolingTypeList = schoolingTypeList;
	}

	public List<Mitem> getSkilljobTypeList() {
		return skilljobTypeList;
	}

	public void setSkilljobTypeList(List<Mitem> skilljobTypeList) {
		this.skilljobTypeList = skilljobTypeList;
	}

	public List<Map<String, Object>> getExpertmajorTypeList() {
		return expertmajorTypeList;
	}

	public void setExpertmajorTypeList(List<Map<String, Object>> expertmajorTypeList) {
		this.expertmajorTypeList = expertmajorTypeList;
	}

	public String getBirthdayYear() {
		return birthdayYear;
	}

	public void setBirthdayYear(String birthdayYear) {
		this.birthdayYear = birthdayYear;
	}

	public String getSchoolingType() {
		return schoolingType;
	}

	public void setSchoolingType(String schoolingType) {
		this.schoolingType = schoolingType;
	}

	public String getSkilljobType() {
		return skilljobType;
	}

	public void setSkilljobType(String skilljobType) {
		this.skilljobType = skilljobType;
	}

	public String getExpertmajorType() {
		return expertmajorType;
	}

	public void setExpertmajorType(String expertmajorType) {
		this.expertmajorType = expertmajorType;
	}

	public List<Mitem> getExpertMajor1List() {
		return expertMajor1List;
	}

	public void setExpertMajor1List(List<Mitem> expertMajor1List) {
		this.expertMajor1List = expertMajor1List;
	}

	public List<Mitem> getExpertPrestigeList() {
		return expertPrestigeList;
	}

	public void setExpertPrestigeList(List<Mitem> expertPrestigeList) {
		this.expertPrestigeList = expertPrestigeList;
	}

	public String getExpertMajor1() {
		return expertMajor1;
	}

	public void setExpertMajor1(String expertMajor1) {
		this.expertMajor1 = expertMajor1;
	}

	public String getExpertPrestige() {
		return expertPrestige;
	}

	public void setExpertPrestige(String expertPrestige) {
		this.expertPrestige = expertPrestige;
	}

	public Texpert getTexpert() {
		return texpert;
	}

	public void setTexpert(Texpert texpert) {
		this.texpert = texpert;
	}

	public List<Mitem> getSchoolingList() {
		return schoolingList;
	}

	public void setSchoolingList(List<Mitem> schoolingList) {
		this.schoolingList = schoolingList;
	}

	public List<Mitem> getExpertdegreeList() {
		return expertdegreeList;
	}

	public void setExpertdegreeList(List<Mitem> expertdegreeList) {
		this.expertdegreeList = expertdegreeList;
	}

	public List<Mitem> getExpertjobList() {
		return expertjobList;
	}

	public void setExpertjobList(List<Mitem> expertjobList) {
		this.expertjobList = expertjobList;
	}

	public List<Mitem> getSkilljobList() {
		return skilljobList;
	}

	public void setSkilljobList(List<Mitem> skilljobList) {
		this.skilljobList = skilljobList;
	}

	public List<Mitem> getExpertMajor2List() {
		return expertMajor2List;
	}

	public void setExpertMajor2List(List<Mitem> expertMajor2List) {
		this.expertMajor2List = expertMajor2List;
	}

	public List<Mitem> getExpertMajor3List() {
		return expertMajor3List;
	}

	public void setExpertMajor3List(List<Mitem> expertMajor3List) {
		this.expertMajor3List = expertMajor3List;
	}

	public List<Mitem> getExpertprestigeList() {
		return expertprestigeList;
	}

	public void setExpertprestigeList(List<Mitem> expertprestigeList) {
		this.expertprestigeList = expertprestigeList;
	}

	public List<Mitem> getDepttypeList() {
		return depttypeList;
	}

	public void setDepttypeList(List<Mitem> depttypeList) {
		this.depttypeList = depttypeList;
	}

	public List<Mitem> getRecommendList() {
		return recommendList;
	}

	public void setRecommendList(List<Mitem> recommendList) {
		this.recommendList = recommendList;
	}

	public List<Mitem> getExpertTypeList() {
		return expertTypeList;
	}

	public void setExpertTypeList(List<Mitem> expertTypeList) {
		this.expertTypeList = expertTypeList;
	}

	public String getExpertType() {
		return expertType;
	}

	public void setExpertType(String expertType) {
		this.expertType = expertType;
	}

	public String getPageDirectFlag() {
		return pageDirectFlag;
	}

	public void setPageDirectFlag(String pageDirectFlag) {
		this.pageDirectFlag = pageDirectFlag;
	}

	public boolean isGroupDeleteFlag() {
		return groupDeleteFlag;
	}

	public void setGroupDeleteFlag(boolean groupDeleteFlag) {
		this.groupDeleteFlag = groupDeleteFlag;
	}
	
	public List<Map<String, Object>> getSelectedExpertList() {
		return selectedExpertList;
	}

	public void setSelectedExpertList(List<Map<String, Object>> selectedExpertList) {
		this.selectedExpertList = selectedExpertList;
	}

	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}
	
	public String getClockFlag() {
		return clockFlag;
	}

	public void setClockFlag(String clockFlag) {
		this.clockFlag = clockFlag;
	}

	public String getExpertOpinionFlag() {
		return expertOpinionFlag;
	}

	public void setExpertOpinionFlag(String expertOpinionFlag) {
		this.expertOpinionFlag = expertOpinionFlag;
	}

	public String getExpertJobType() {
		return expertJobType;
	}

	public void setExpertJobType(String expertJobType) {
		this.expertJobType = expertJobType;
	}

	public List<Mitem> getExpertJobTypeList() {
		return expertJobTypeList;
	}

	public void setExpertJobTypeList(List<Mitem> expertJobTypeList) {
		this.expertJobTypeList = expertJobTypeList;
	}

	public String getBackStr() {
		return backStr;
	}

	public void setBackStr(String backStr) {
		this.backStr = backStr;
	}
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public int getSelectedExpertNum() {
		return selectedExpertNum;
	}

	public void setSelectedExpertNum(int selectedExpertNum) {
		this.selectedExpertNum = selectedExpertNum;
	}

}

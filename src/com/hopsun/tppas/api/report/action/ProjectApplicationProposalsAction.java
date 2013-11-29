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
import com.hopsun.tppas.api.report.service.ProjectApplicationProposalsService;
import com.hopsun.tppas.api.report.service.TprojectApplicationService;
import com.hopsun.tppas.api.statistics.service.VprojectResultCollectService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeManagerService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.Texpert;
import com.hopsun.tppas.entity.TexpertScore;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectGroup;
import com.hopsun.tppas.entity.TprojectType;
import com.hopsun.tppas.view.VprojectInfo;
import com.hopsun.tppas.view.VprojectResultCollect;

/**
 * @comments 立项建议
 * @author wanglw
 * @date 2013-11-21 @time 下午1:56:33
 * @Version 1.0
 */
public class ProjectApplicationProposalsAction extends BaseAction{

	private static final long serialVersionUID = -1483113196038926377L;

	@Resource
	private ProjectApplicationProposalsService projectApplicationProposalsService;
	
	@Resource
	private TprojectApplicationService tprojectApplicationService;
	
	@Resource
	private TprojectTypeManagerService tprojectTypeManagerService;
	
	@Resource
	private MitemService mitemService;
	
	@Resource
	private VprojectResultCollectService vprojectResultCollectService;

	/** 翻页*/
    private int pageNo;
    
    /** 跳转路径*/
	private String retUrl;
	
	/** 跳转页面massage */
	private String retMsg;
	
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

	/** 计划类别 */
	private String projectType;
	
	/** 计划类别 */
	private String projectType1;
	
	/** 项目分类 */
	private String projectType2;
	
	/** 推荐意见*/
	private String recommendAtion;
	
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
	
	/** 分组名称*/
	private String groupName;
	
	/** 分组ID*/
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
	
	/** 专业 */
	private String expertmajorType; 
	
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
	
	/**擅长专业1集合*/
	private List<Mitem> expertMajor1List;
	
	/**信用等级集合*/
	private List<Mitem> expertPrestigeList;
	
	/**擅长专业1*/
	private String expertMajor1;

	/**信用等级*/
	private String expertPrestige;
	
	/**专家对象*/
	private  Texpert  texpert;
	

	/** 其他意见 */
	private String otherComments;
	
	/** 项目list */
	private List<TprojectApplication> projectList;
	/** 查询结果*/
	private String listFlag;
	/**项目企业信息打印按钮显示区分*/
	private String projectInfoBtnFlag;

	/**
	 * @comments 初始化页面
	 * @return
	 * @Version 1.0
	 */
	public String showProposalsManage(){
		
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
	    session.setAttribute(Constants.SESSION_CMDKEY, "proposals");
	    
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
		
		// 打印项目企业信息按钮表示区分取得  start
		String userDeptId = user.getScDept().getDeptId();
		// 取得查询条件
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("userDeptId", userDeptId);
		params.put("reportYear", mitemService.get(Constants.APPLY_YEAR).getItemDesc());
		String checkRes = "false";
		Map<String, List<VprojectResultCollect>> allResultData = vprojectResultCollectService.getAllResultData(params);
		if(allResultData == null || allResultData.size() <=0){
			checkRes = "true";
		}
		this.projectInfoBtnFlag = checkRes;
		// 打印项目企业信息按钮表示区分取得  end
//		// 初始化审核状态
//		this.auditStatusList = new ArrayList<Mitem>();
//		this.auditStatusList = mitemService.getMitemListByPId("");
//		
//		// 初始化项目分组
//		this.projectGroupList = new ArrayList<TprojectGroup>();
//		this.projectGroupList = tprojectGroupService.getProjectGroupListByDeptId(
//				user.getScDept().getDeptId());
		
		return "showProposalsManage";
	}
	
	/**
	 * @comments 取得联席会审核项目列表
	 * @return
	 * @Version 1.0
	 */
	public String getProposalsList(){
		
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"proposals".equals(cmdkey)) {
			return "LogOut";
		}
		
    	// 翻页
    	if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
			pager.setPageSize(Constants.PAGE_SIZE);
		}
    	else{
    		pager = new Pager();
    		pager.setPageNumber(this.getPageNo());
    		pager.setPageSize(Constants.PAGE_SIZE);
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
		String projectTypeString = tprojectTypeManagerService.getProjectTypeStrByUser(user);
		param.put("projectTypeString", projectTypeString);
		
		// 计划类别
		param.put("projectType1", projectType1);
		
		// 项目分类
		param.put("projectType2", projectType2);

		
		// 用户Id
		param.put("userId", user.getUserId());
		
				
		// 取得项目一览信息
		pager = projectApplicationProposalsService.getProposalsList(
				param, pager.getPageNumber(), pager.getPageSize());
		
		if (pager.getList().size() == 0){
			listFlag = "0";
		}
		return "showProposalsList";
	}
	
	
	/**
	 * @comments 批量推荐
	 * @return
	 * @Version 1.0
	 */
	public String recommend(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"proposals".equals(cmdkey)) {
			return "LogOut";
		}
		// 取得选择的项目Id
		this.selectedProjectIds = this.getSelectedProjectIds();
		
		this.projectId = selectedProjectIds;
		
		// 设置推荐意见
		this.recommendAtion = Constants.RECOMMENDATION_RECOMMEND;
		
		// 保存联席会审核意见
		projectApplicationProposalsService.updateRecommendAtion(projectId, 
				recommendAtion, user.getUserId());
		
		// 设置提示信息
		this.setRetMsg(this.getText("opt_save_suc"));
		
		// 设置actionUrl
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/audit/projectApplicationProposals!showProposalsManage.action?"
				+ "&now=" + new Date().getTime());
		
		return "systemInfoMain";
	}
	
	/**
	 * @comments 批量备选
	 * @return
	 * @Version 1.0
	 */
	public String alternative(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"proposals".equals(cmdkey)) {
			return "LogOut";
		}
		// 取得选择的项目Id
		this.selectedProjectIds = this.getSelectedProjectIds();
		
		this.projectId = selectedProjectIds;
		
		// 设置备选意见
		this.recommendAtion = Constants.RECOMMENDATION_ALTERNATIVE;
		
		// 保存联席会审核意见
		projectApplicationProposalsService.updateRecommendAtion(projectId, 
				recommendAtion, user.getUserId());
		
		// 设置提示信息
		this.setRetMsg(this.getText("opt_save_suc"));
		
		// 设置actionUrl
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/audit/projectApplicationProposals!showProposalsManage.action?"
				+ "&now=" + new Date().getTime());
		
		return "systemInfoMain";
	}
	
	/**
	 * @comments 批量落选
	 * @return
	 * @Version 1.0
	 */
	public String unsuccessful(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String)session.getAttribute(Constants.SESSION_CMDKEY);
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())
				|| !"proposals".equals(cmdkey)) {
			return "LogOut";
		}
		// 取得选择的项目Id
		this.selectedProjectIds = this.getSelectedProjectIds();
		
		this.projectId = selectedProjectIds;
		
		// 设置落选意见
		this.recommendAtion = Constants.RECOMMENDATION_FAIL;
		
		// 保存联席会审核意见
		projectApplicationProposalsService.updateRecommendAtion(projectId, 
				recommendAtion, user.getUserId());
		
		// 设置提示信息
		this.setRetMsg(this.getText("opt_save_suc"));
		
		// 设置actionUrl
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/audit/projectApplicationProposals!showProposalsManage.action?"
				+ "&now=" + new Date().getTime());
		
		return "systemInfoMain";
	}
	
	/**
	 * @comments 显示其他意见页面
	 * @return
	 * @Version 1.0
	 */
	public String showOtherComments() {

		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"proposals".equals(cmdkey)) {
			return "LogOut";
		}

		// 取得项目Id
		this.projectId = this.getProjectId();
		// 取得项目信息
		TprojectApplication tp = tprojectApplicationService.get(projectId);
		if (tp != null) {
			this.otherComments = tp.getExpertProofComposite();
		}
		return "showOtherComments";
	}
	
	/**
	 * @throws UnsupportedEncodingException 
	 * @comments 改变项目分组
	 * @Version 1.0
	 */
	public void updateOtherComments() throws UnsupportedEncodingException {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);

		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId()) || !"proposals".equals(cmdkey)) {
			return;
		}

		// 取得项目ID
		this.projectId = this.getProjectId();
		// 取得其他意见
		this.otherComments = new String(otherComments.getBytes("ISO-8859-1"), "utf-8");

		projectApplicationProposalsService.updateOtherComments(projectId, otherComments,user.getUserId());
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
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

	public List<TprojectGroup> getProjectGroupList() {
		return projectGroupList;
	}

	public void setProjectGroupList(List<TprojectGroup> projectGroupList) {
		this.projectGroupList = projectGroupList;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
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

	public String getProjectGroup() {
		return projectGroup;
	}

	public void setProjectGroup(String projectGroup) {
		this.projectGroup = projectGroup;
	}

	public String getProjectGroupSon() {
		return projectGroupSon;
	}

	public void setProjectGroupSon(String projectGroupSon) {
		this.projectGroupSon = projectGroupSon;
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

	public String getApplyCompany() {
		return applyCompany;
	}

	public void setApplyCompany(String applyCompany) {
		this.applyCompany = applyCompany;
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

	public String getGroupDateFlag() {
		return groupDateFlag;
	}

	public void setGroupDateFlag(String groupDateFlag) {
		this.groupDateFlag = groupDateFlag;
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

	public String getSelectedExpertIds() {
		return selectedExpertIds;
	}

	public void setSelectedExpertIds(String selectedExpertIds) {
		this.selectedExpertIds = selectedExpertIds;
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


	public List<TprojectApplication> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<TprojectApplication> projectList) {
		this.projectList = projectList;
	}


	public String getRecommendAtion() {
		return recommendAtion;
	}

	public void setRecommendAtion(String recommendAtion) {
		this.recommendAtion = recommendAtion;
	}

	public String getOtherComments() {
		return otherComments;
	}

	public void setOtherComments(String otherComments) {
		this.otherComments = otherComments;
	}

	public String getListFlag() {
		return listFlag;
	}

	public void setListFlag(String listFlag) {
		this.listFlag = listFlag;
	}
	public String getProjectInfoBtnFlag() {
		return projectInfoBtnFlag;
	}

	public void setProjectInfoBtnFlag(String projectInfoBtnFlag) {
		this.projectInfoBtnFlag = projectInfoBtnFlag;
	}
	
}


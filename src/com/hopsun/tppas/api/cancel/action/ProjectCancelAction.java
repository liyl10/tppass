/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.cancel.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.api.dept.service.DeptService;
import com.hopsun.scenter.entity.ScDept;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.cancel.service.ProjectCancelService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectInfoA;
import com.hopsun.tppas.entity.TprojectType;

/**
 * @comment 项目撤销页面
 * @author lihf
 * @DATE: 2013-8-27 @TIME: 下午14:16:09
 * @Vsersion: 1.0
 */
public class ProjectCancelAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(ProjectCancelAction.class.getName());

	private static final long serialVersionUID = -6105606581261532536L;

	/** TacceptanceService 对象的实例 */
	@Resource
	private ProjectCancelService projectCancelService;
	@Resource
	private MitemService mitemService;
	@Resource
	private TprojectTypeService tprojectTypeService;
	@Resource
	private DeptService deptService;
	/** 项目申报 */
	private TprojectApplication tprojectApplication;
	/** 项目基本信息 */
	private TprojectInfoA tprojectInfoa;
	/** 部门ID */
	private String deptId;
	/** 计财处区分 */
	private String planningFlag;
	/** 项目ID */
	private String projectId;
	/** 跳转页数 */
	private int pageNo;
	/** 跳转路径 */
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;
	// 项目分类
	private String typeId1;
	private String typeId2;
	private String typeId3;
	// 归口管理部门
	private List<Mitem> centralizedTypeList;
	// 项目分类
	private List<ScDept> typeId1List;
	private List<TprojectType> typeId2List;
	private List<TprojectType> typeId3List;
	// 所在区域List
	private List<Mitem> regionId1List;
	private List<Mitem> regionId2List;
	private List<Mitem> regionId3List;
	// 行业领域List
	private List<Mitem> industries1List;
	private List<Mitem> industries2List;
	private List<Mitem> industries3List;
	private List<Mitem> industries4List;
	// 单位性质List
	private List<Mitem> unitPropertiesList;
	// 技术领域List
	private List<Mitem> technicalFisldList;
	// 知识产权状况List
	private List<Mitem> intellectualPropertyList;
	// 技术来源List
	private List<Mitem> technologySourceList;
	
	/**
	 * @Comments 画面初期化处理
	 * @return
	 * @Vsersion: 1.0
	 */
	public String init() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
    	session.setAttribute(Constants.SESSION_CMDKEY, "projectCancel");
		
    	// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
    	// 取得部门ID
    	if(user.getScDept() != null && user.getScDept().getDeptId() != null && !"".equals(user.getScDept().getDeptId())){
    		deptId = user.getScDept().getDeptId();
    	} else {
    		logger.error("部门不存在！");
			return "LogOut";
    	}
    	
    	// 项目基本信息
    	tprojectInfoa = new TprojectInfoA();
    	// 初始化项目分类List
    	this.typeId1List = new ArrayList<ScDept>();
    	this.typeId2List = new ArrayList<TprojectType>();
    	this.typeId3List = new ArrayList<TprojectType>();
    	// 初始化所在区域List
		this.regionId1List = new ArrayList<Mitem>();
		this.regionId2List = new ArrayList<Mitem>();
		this.regionId3List = new ArrayList<Mitem>();
		// 初始化行业领域List
		this.industries1List = new ArrayList<Mitem>();
		this.industries2List = new ArrayList<Mitem>();
		this.industries3List = new ArrayList<Mitem>();
		this.industries4List = new ArrayList<Mitem>();
		// 单位性质List
		this.unitPropertiesList = new ArrayList<Mitem>();
		// 技术领域List
		this.technicalFisldList = new ArrayList<Mitem>();
		// 知识产权List
		this.intellectualPropertyList = new ArrayList<Mitem>();
		// 技术来源List
		this.technologySourceList = new ArrayList<Mitem>();
		// 是否计财处
    	if(Constants.PLANNING_DEPARTMENT.equals(deptId)){
    		planningFlag = "1";
    		// 部门列表
    		this.typeId1List = deptService.findDept(user.getScDept());
    	} else {
    		planningFlag = "0";
    		// 项目分类1
    		this.typeId2List = tprojectTypeService.getFatherProjectTypeListByDeptId(deptId);
    	}
		
		// 归口管理部门
		this.centralizedTypeList = mitemService.getListByTypeId(Constants.TYPE_CENTRALIZED_TYPE);
		// 取得行业领域省级信息
		this.regionId1List = mitemService.getListByTypeId(Constants.TYPE_REGION_1);
		// 初始化选择陕西省西安市
		//tprojectInfoa.setRegionId1(Constants.SHANNXI);
		//tprojectInfoa.setRegionId2(Constants.XIAN);
		//this.regionId2List = mitemService.getMitemListByPId(tprojectInfoa.getRegionId1());
		//this.regionId3List = mitemService.getMitemListByPId(tprojectInfoa.getRegionId2());
		
		// 取得行业领域信息单位行业领域1
		this.industries1List = mitemService.getListByTypeId(Constants.TYPE_INDUSTRIES1);
		// 单位性质List
		this.unitPropertiesList = mitemService.getListByTypeId(Constants.TYPE_COMPANY_RETY);
		// 取得技术领域信息
		this.technicalFisldList = mitemService.getListByTypeId(Constants.TYPE_PROJECTINFO_FIELD);
		// 取得知识产权信息
		this.intellectualPropertyList = mitemService.getListByTypeId(Constants.TYPE_INTELLECTUAL);
		// 取得技术来源信息
		this.technologySourceList = mitemService.getListByTypeId(Constants.TYPE_TECHNOLOGY);
    	
		return "init";
	}

	/**
	 * @Comments 项目查询处理
	 * @return
	 * @Vsersion: 1.0
	 */
	public String query() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (cmdkey == null || !"projectCancel".equals(cmdkey)) {
			logger.error("错误的令牌！");
			return "LogOut";
		}
		// 取得部门ID
    	if(user != null && user.getScDept() != null
    		&& user.getScDept().getDeptId() != null && !"".equals(user.getScDept().getDeptId())){
    		deptId = user.getScDept().getDeptId();
    	} else {
    		logger.error("部门不存在！");
			return "LogOut";
    	}
    	
		// 得到数据总个数
		setPager(new Pager());
		pager = new Pager();
    	if (this.getPageNo() != 0) {
    		pager.setPageNumber(this.getPageNo());
    	}
    	// 检索条件
    	Map<String, Object> param = new HashMap<String, Object>();
    	param.put("deptId", deptId);
    	param.put("projectName", tprojectApplication.getProjectName());
    	param.put("applicationUnit", tprojectApplication.getApplicationUnit());
    	param.put("centralizedType", tprojectApplication.getCentralizedType());
    	param.put("reportYear", tprojectApplication.getReportYear());
    	param.put("planningFlag", this.getPlanningFlag());
    	param.put("typeId1", this.getTypeId1());
    	param.put("typeId2", this.getTypeId2());
    	param.put("typeId3", this.getTypeId3());
    	param.put("regionId1", tprojectInfoa.getRegionId1());
    	param.put("regionId2", tprojectInfoa.getRegionId2());
    	param.put("regionId3", tprojectInfoa.getRegionId3());
    	param.put("unitAddress", tprojectInfoa.getUnitAddress());
    	param.put("industries1", tprojectInfoa.getIndustries1());
    	param.put("industries2", tprojectInfoa.getIndustries2());
    	param.put("industries3", tprojectInfoa.getIndustries3());
    	param.put("industries4", tprojectInfoa.getIndustries4());
    	param.put("unitProperties", tprojectInfoa.getUnitProperties());
    	param.put("assistUnit", tprojectInfoa.getAssistUnit());
    	param.put("technicalFisld", tprojectInfoa.getTechnicalFisld3());
    	param.put("intellectualProperty", tprojectInfoa.getIntellectualProperty());
    	param.put("technologySource", tprojectInfoa.getTechnologySource());
    	// 检索数据
		pager = projectCancelService.queryProjectInfo(param, pager.getPageNumber(), pager.getPageSize());
		
		return "query";
	}
	
	
	/**
	 * 撤销项目
	 * @return String
	 */
	public String cancelProject(){
		// 取得登录用户的信息
    	HttpSession session = this.getRequest().getSession();
    	ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 取得令牌信息
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		// 判断是否失效
    	if (user == null || ("").equals(user.getUserId())) {
    		logger.error("用户不存在！");
			return "LogOut";
		}
		if (cmdkey == null || !"projectCancel".equals(cmdkey)) {
			logger.error("错误的令牌！");
			return "LogOut";
		}
		// 删除信息
		projectCancelService.updateProject(projectId, user.getUserId());
		this.setRetMsg(this.getText("opt_del_suc"));
		this.setRetUrl(super.getRequest().getContextPath()
				+ "/api/cancel/projectCancel!init.action?now=" + new Date().getTime());
		
		return "systemInfoMain";
	}
	
	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the projectCancelService
	 */
	public ProjectCancelService getProjectCancelService() {
		return projectCancelService;
	}

	/**
	 * @param projectCancelService the projectCancelService to set
	 */
	public void setProjectCancelService(ProjectCancelService projectCancelService) {
		this.projectCancelService = projectCancelService;
	}

	/**
	 * @return the retUrl
	 */
	public String getRetUrl() {
		return retUrl;
	}

	/**
	 * @param retUrl the retUrl to set
	 */
	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
	}

	/**
	 * @return the retMsg
	 */
	public String getRetMsg() {
		return retMsg;
	}

	/**
	 * @param retMsg the retMsg to set
	 */
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	/**
	 * @return the mitemService
	 */
	public MitemService getMitemService() {
		return mitemService;
	}

	/**
	 * @param mitemService the mitemService to set
	 */
	public void setMitemService(MitemService mitemService) {
		this.mitemService = mitemService;
	}

	/**
	 * @return the centralizedTypeList
	 */
	public List<Mitem> getCentralizedTypeList() {
		return centralizedTypeList;
	}

	/**
	 * @param centralizedTypeList the centralizedTypeList to set
	 */
	public void setCentralizedTypeList(List<Mitem> centralizedTypeList) {
		this.centralizedTypeList = centralizedTypeList;
	}

	/**
	 * @return the regionId1List
	 */
	public List<Mitem> getRegionId1List() {
		return regionId1List;
	}

	/**
	 * @param regionId1List the regionId1List to set
	 */
	public void setRegionId1List(List<Mitem> regionId1List) {
		this.regionId1List = regionId1List;
	}

	/**
	 * @return the regionId2List
	 */
	public List<Mitem> getRegionId2List() {
		return regionId2List;
	}

	/**
	 * @param regionId2List the regionId2List to set
	 */
	public void setRegionId2List(List<Mitem> regionId2List) {
		this.regionId2List = regionId2List;
	}

	/**
	 * @return the regionId3List
	 */
	public List<Mitem> getRegionId3List() {
		return regionId3List;
	}

	/**
	 * @param regionId3List the regionId3List to set
	 */
	public void setRegionId3List(List<Mitem> regionId3List) {
		this.regionId3List = regionId3List;
	}

	/**
	 * @return the industries1List
	 */
	public List<Mitem> getIndustries1List() {
		return industries1List;
	}

	/**
	 * @param industries1List the industries1List to set
	 */
	public void setIndustries1List(List<Mitem> industries1List) {
		this.industries1List = industries1List;
	}

	/**
	 * @return the industries2List
	 */
	public List<Mitem> getIndustries2List() {
		return industries2List;
	}

	/**
	 * @param industries2List the industries2List to set
	 */
	public void setIndustries2List(List<Mitem> industries2List) {
		this.industries2List = industries2List;
	}

	/**
	 * @return the industries3List
	 */
	public List<Mitem> getIndustries3List() {
		return industries3List;
	}

	/**
	 * @param industries3List the industries3List to set
	 */
	public void setIndustries3List(List<Mitem> industries3List) {
		this.industries3List = industries3List;
	}

	/**
	 * @return the industries4List
	 */
	public List<Mitem> getIndustries4List() {
		return industries4List;
	}

	/**
	 * @param industries4List the industries4List to set
	 */
	public void setIndustries4List(List<Mitem> industries4List) {
		this.industries4List = industries4List;
	}

	/**
	 * @return the unitPropertiesList
	 */
	public List<Mitem> getUnitPropertiesList() {
		return unitPropertiesList;
	}

	/**
	 * @param unitPropertiesList the unitPropertiesList to set
	 */
	public void setUnitPropertiesList(List<Mitem> unitPropertiesList) {
		this.unitPropertiesList = unitPropertiesList;
	}

	/**
	 * @return the technicalFisldList
	 */
	public List<Mitem> getTechnicalFisldList() {
		return technicalFisldList;
	}

	/**
	 * @param technicalFisldList the technicalFisldList to set
	 */
	public void setTechnicalFisldList(List<Mitem> technicalFisldList) {
		this.technicalFisldList = technicalFisldList;
	}

	/**
	 * @return the intellectualPropertyList
	 */
	public List<Mitem> getIntellectualPropertyList() {
		return intellectualPropertyList;
	}

	/**
	 * @param intellectualPropertyList the intellectualPropertyList to set
	 */
	public void setIntellectualPropertyList(List<Mitem> intellectualPropertyList) {
		this.intellectualPropertyList = intellectualPropertyList;
	}

	/**
	 * @return the technologySourceList
	 */
	public List<Mitem> getTechnologySourceList() {
		return technologySourceList;
	}

	/**
	 * @param technologySourceList the technologySourceList to set
	 */
	public void setTechnologySourceList(List<Mitem> technologySourceList) {
		this.technologySourceList = technologySourceList;
	}

	/**
	 * @return the tprojectInfoa
	 */
	public TprojectInfoA getTprojectInfoa() {
		return tprojectInfoa;
	}

	/**
	 * @param tprojectInfoa the tprojectInfoa to set
	 */
	public void setTprojectInfoa(TprojectInfoA tprojectInfoa) {
		this.tprojectInfoa = tprojectInfoa;
	}

	/**
	 * @return the tprojectApplication
	 */
	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}

	/**
	 * @param tprojectApplication the tprojectApplication to set
	 */
	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	/**
	 * @return the tprojectTypeService
	 */
	public TprojectTypeService getTprojectTypeService() {
		return tprojectTypeService;
	}

	/**
	 * @param tprojectTypeService the tprojectTypeService to set
	 */
	public void setTprojectTypeService(TprojectTypeService tprojectTypeService) {
		this.tprojectTypeService = tprojectTypeService;
	}

	/**
	 * @return the typeId1
	 */
	public String getTypeId1() {
		return typeId1;
	}

	/**
	 * @param typeId1 the typeId1 to set
	 */
	public void setTypeId1(String typeId1) {
		this.typeId1 = typeId1;
	}

	/**
	 * @return the typeId2
	 */
	public String getTypeId2() {
		return typeId2;
	}

	/**
	 * @param typeId2 the typeId2 to set
	 */
	public void setTypeId2(String typeId2) {
		this.typeId2 = typeId2;
	}

	/**
	 * @return the deptService
	 */
	public DeptService getDeptService() {
		return deptService;
	}

	/**
	 * @param deptService the deptService to set
	 */
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	/**
	 * @return the typeId3
	 */
	public String getTypeId3() {
		return typeId3;
	}

	/**
	 * @param typeId3 the typeId3 to set
	 */
	public void setTypeId3(String typeId3) {
		this.typeId3 = typeId3;
	}

	/**
	 * @return the typeId1List
	 */
	public List<ScDept> getTypeId1List() {
		return typeId1List;
	}

	/**
	 * @param typeId1List the typeId1List to set
	 */
	public void setTypeId1List(List<ScDept> typeId1List) {
		this.typeId1List = typeId1List;
	}

	/**
	 * @return the typeId2List
	 */
	public List<TprojectType> getTypeId2List() {
		return typeId2List;
	}

	/**
	 * @param typeId2List the typeId2List to set
	 */
	public void setTypeId2List(List<TprojectType> typeId2List) {
		this.typeId2List = typeId2List;
	}

	/**
	 * @return the typeId3List
	 */
	public List<TprojectType> getTypeId3List() {
		return typeId3List;
	}

	/**
	 * @param typeId3List the typeId3List to set
	 */
	public void setTypeId3List(List<TprojectType> typeId3List) {
		this.typeId3List = typeId3List;
	}

	/**
	 * @return the deptId
	 */
	public String getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return the planningFlag
	 */
	public String getPlanningFlag() {
		return planningFlag;
	}

	/**
	 * @param planningFlag the planningFlag to set
	 */
	public void setPlanningFlag(String planningFlag) {
		this.planningFlag = planningFlag;
	}

	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

}

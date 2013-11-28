/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.statistics.action;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.api.dept.service.DeptService;
import com.hopsun.scenter.entity.ScDept;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.statistics.service.StatisticsProjectService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeManagerService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.common.ExcelIterator;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TprojectApplication;
import com.hopsun.tppas.entity.TprojectInfoB;
import com.hopsun.tppas.entity.TprojectType;

/**
 * @comment 项目统计页面
 * @author lihf
 * @DATE: 2013-8-27 @TIME: 下午14:16:09
 * @Vsersion: 1.0
 */
public class StatisticsProjectAction extends BaseAction{
	public final static Logger logger = Logger.getLogger(StatisticsProjectAction.class.getName());

	private static final long serialVersionUID = -6105606581261532536L;

	@Resource
	private StatisticsProjectService statisticsProjectService;
	@Resource
	private MitemService mitemService;
	@Resource
	private TprojectTypeService tprojectTypeService;
	@Resource
	private DeptService deptService;
	@Resource
	private TprojectTypeManagerService tprojectTypeManagerService;
	/** 项目申报 */
	private TprojectApplication tprojectApplication;
	/** 项目基本信息 */
	private TprojectInfoB tprojectInfob;
	/** 部门ID */
	private String deptId;
	/** 计财处区分 */
	private String planningFlag;
	/** 跳转页数 */
	private int pageNo;
	/** 跳转路径 */
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;
	/** 导出页面的字段 */
	private List<Object> mapList = new ArrayList<Object>();
	// 子画面信息
	List<Map<Object, Object>> subPageList = new ArrayList<Map<Object, Object>>();
	
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
	private List<Mitem> technicalFisld1List;
	private List<Mitem> technicalFisld2List;
	private List<Mitem> technicalFisld3List;
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
    	session.setAttribute(Constants.SESSION_CMDKEY, "projectQuery");
		
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
    	tprojectInfob = new TprojectInfoB();
    	// 初始化项目分类List
    	this.typeId1List = new ArrayList<ScDept>();
    	this.typeId2List = new ArrayList<TprojectType>();
    	this.typeId3List = new ArrayList<TprojectType>();
    	// 技术领域List
    	this.technicalFisld1List = new ArrayList<Mitem>();
    	this.technicalFisld2List = new ArrayList<Mitem>();
    	this.technicalFisld3List = new ArrayList<Mitem>();
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
    		this.typeId2List = tprojectTypeManagerService.getProjectTypeListByUser(user);
    	}
		
		// 归口管理部门
		this.centralizedTypeList = mitemService.getListByTypeId(Constants.TYPE_CENTRALIZED_TYPE);
		// 取得行业领域省级信息
		this.regionId1List = mitemService.getListByTypeId(Constants.TYPE_REGION_1);
		
		// 取得行业领域信息单位行业领域1
		this.industries1List = mitemService.getListByTypeId(Constants.TYPE_INDUSTRIES1);
		// 单位性质List
		this.unitPropertiesList = mitemService.getListByTypeId(Constants.TYPE_COMPANY_RETY);
		// 取得技术领域信息
		this.technicalFisld1List = mitemService.getListByTypeId(Constants.TYPE_PROJECTINFO_FIELD1);
		// 取得知识产权信息
		this.intellectualPropertyList = mitemService.getListByTypeId(Constants.TYPE_INTELLECTUAL);
		// 取得技术来源信息
		this.technologySourceList = mitemService.getListByTypeId(Constants.TYPE_TECHNOLOGY);
    	
		return "init";
	}

	/**
	 * @Comments 画面初期化处理
	 * @return
	 * @Vsersion: 1.0
	 */
	public String query() {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		//String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
//		if (cmdkey == null || !"projectQuery".equals(cmdkey)) {
//			logger.error("错误的令牌！");
//			return "LogOut";
//		}
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
    	param.put("jhlb", tprojectTypeManagerService.getProjectTypeStrByUser(user));
    	param.put("projectName", tprojectApplication.getProjectName());
    	param.put("applicationUnit", tprojectApplication.getApplicationUnit());
    	param.put("centralizedType", tprojectApplication.getCentralizedType());
    	param.put("reportYear", tprojectApplication.getReportYear());
    	param.put("planningFlag", this.getPlanningFlag());
    	param.put("typeId1", this.typeId1);
    	param.put("typeId2", this.typeId2);
    	param.put("typeId3", this.typeId3);
    	param.put("regionId1", tprojectInfob.getRegionId1());
    	param.put("regionId2", tprojectInfob.getRegionId2());
    	param.put("regionId3", tprojectInfob.getRegionId3());
    	param.put("unitAddress", tprojectInfob.getUnitAddress());
    	param.put("industries1", tprojectInfob.getIndustries1());
    	param.put("industries2", tprojectInfob.getIndustries2());
    	param.put("industries3", tprojectInfob.getIndustries3());
    	param.put("industries4", tprojectInfob.getIndustries4());
    	param.put("unitProperties", tprojectInfob.getUnitProperties());
    	param.put("assistUnit", tprojectInfob.getAssistUnit());
    	param.put("technicalFisld1", tprojectInfob.getTechnicalFisld1());
    	param.put("technicalFisld2", tprojectInfob.getTechnicalFisld2());
    	param.put("technicalFisld3", tprojectInfob.getTechnicalFisld3());
    	param.put("intellectualProperty", tprojectInfob.getIntellectualProperty());
    	param.put("technologySource", tprojectInfob.getTechnologySource());
    	// 检索数据
		pager = statisticsProjectService.queryProjectInfo(param, pager.getPageNumber(), pager.getPageSize());
		
		return "query";
	}
	
	/**
	 * @comments 页面查询条件
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws Exception
	 * @Version 1.0
	 */
	private Map<String, Object> getCondition2() throws UnsupportedEncodingException {
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		// 取得部门ID
    	if(user != null && user.getScDept() != null
    		&& user.getScDept().getDeptId() != null && !"".equals(user.getScDept().getDeptId())){
    		deptId = user.getScDept().getDeptId();
    	}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("deptId", deptId);
		param.put("jhlb", tprojectTypeManagerService.getProjectTypeStrByUser(user));
    	param.put("projectName", tprojectApplication.getProjectName());
    	param.put("applicationUnit", tprojectApplication.getApplicationUnit());
    	param.put("centralizedType", tprojectApplication.getCentralizedType());
    	param.put("reportYear", tprojectApplication.getReportYear());
    	param.put("planningFlag", this.getPlanningFlag());
    	param.put("typeId1", this.typeId1);
    	param.put("typeId2", this.typeId2);
    	param.put("typeId3", this.typeId3);
    	param.put("regionId1", tprojectInfob.getRegionId1());
    	param.put("regionId2", tprojectInfob.getRegionId2());
    	param.put("regionId3", tprojectInfob.getRegionId3());
    	param.put("unitAddress", tprojectInfob.getUnitAddress());
    	param.put("industries1", tprojectInfob.getIndustries1());
    	param.put("industries2", tprojectInfob.getIndustries2());
    	param.put("industries3", tprojectInfob.getIndustries3());
    	param.put("industries4", tprojectInfob.getIndustries4());
    	param.put("unitProperties", tprojectInfob.getUnitProperties());
    	param.put("assistUnit", tprojectInfob.getAssistUnit());
    	param.put("technicalFisld1", tprojectInfob.getTechnicalFisld1());
    	param.put("technicalFisld2", tprojectInfob.getTechnicalFisld2());
    	param.put("technicalFisld3", tprojectInfob.getTechnicalFisld3());
    	param.put("intellectualProperty", tprojectInfob.getIntellectualProperty());
    	param.put("technologySource", tprojectInfob.getTechnologySource());

		return param;
	}
	
	/**
	 * @comments 初始化导出数据页面
	 * @return
	 * @throws Exception
	 * @Version 1.0
	 */
	public String initExport() throws Exception {
		
		// 获取数据库中表的字段
		List<Object[]> list = this.getTableColName();

		if (null != list && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<Object, Object> mapInfo = new HashMap<Object, Object>();
				Object[] obj = (Object[]) list.get(i);
				mapInfo.put(obj[0] + "-" + obj[1], obj[2]);
				this.subPageList.add(mapInfo);
			}
		}

		return "initExport";
	}
	
	/**
	 * @comments 获取数据库中表的字段
	 * @return
	 * @Version 1.0
	 */
	private List<Object[]> getTableColName() {

		List<Object[]> returnList = new ArrayList<Object[]>();

		// 项目申报表、项目基本信息表、企业简介发展前景、项目概况市场分析、主要研究内容与技术创新点
		// 前期基础及现有条件和优势、进度安排经济指标
		String[] tableNames = new String[] { "T_PROJECT_APPLICATION"
				,"T_PROJECT_INFO_B", "T_REPORT_ABSTRACT_B",
				"T_COMPANY_NEED_B", "T_COMPANY_FOUNDATION_B",
				"T_SCHEDULING_A", "T_EXPECTED_RESULTS","T_TECHNICAL_INDEXES",
				"T_ECONOMIC_INDICATOR_B","T_ECONOMIC_INDICATOR_A",
				"T_COST_ESTIMATE_B","T_FUND_PLAN_B","T_FUNDING_PLAN_REPORT",
				"T_COMPANY_INFO","T_REVIEW_COMMENTS"
				};

		List<Object> list = statisticsProjectService.getTableInfo(tableNames);

		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			// 申报表
			if (obj[0].equals("T_PROJECT_APPLICATION")
					&& ( !obj[1].equals("USER_ID")
						&& ! obj[1].equals("START_TIME")
						&& ! obj[1].equals("END_TIME")
						&& ! obj[1].equals("HANDLE_TIME")
						&& ! obj[1].equals("PDF_URL")
						&& ! obj[1].equals("OPT_USER")
						&& ! obj[1].equals("CREATE_USER")
						&& ! obj[1].equals("CREATE_TIME")
						&& ! obj[1].equals("UPDATE_USER")
						&& ! obj[1].equals("UPDATE_TIME")
						&& ! obj[1].equals("REMARK")
						&& ! obj[1].equals("PLAN_ID")
						&& ! obj[1].equals("GROUP_ID")
						&& ! obj[1].equals("WRITEREPOT_TIME")
						&& ! obj[1].equals("SUPPORT_FUNCTION")
						&& ! obj[1].equals("SUPPORT_FLAG")
						&& ! obj[1].equals("PLAN_FLAG")
						&& ! obj[1].equals("COMPILATION_DEPT")
						&& ! obj[1].equals("COMPILATION_TIME")
						//归档状态
						&& ! obj[1].equals("IS_ARCHIVAL")
						//归档时间
						&& ! obj[1].equals("ARCHIVAL_TIME")
						&& ! obj[1].equals("PROJECT_NUMBER_TEMP")
						//专家意见状态
						&& ! obj[1].equals("EXPERT_OPINION_STATUS")
						//专家评分状态
						&& ! obj[1].equals("EXPERT_SCORE_STATUS")
						&& ! obj[1].equals("FIRST_SECOND")
						
						)) {
				boolean flag = true;
				for (int j = 0;j<returnList.size();j++){
					if (returnList.get(j)[0].equals(obj[0]) && returnList.get(j)[1].equals(obj[1])){
						flag = false;
					}
				}
				if (flag == true){
					returnList.add(obj);
				}
			}
			
			// 项目基本信息表
			if (obj[0].equals("T_PROJECT_INFO_B")
					&& !obj[1].equals("PROJECT_INFO_ID")
					&& !obj[1].equals("DELETE_FLAG")
					&& !obj[1].equals("CREATE_TIME")
					&& !obj[1].equals("CREATE_USER")
					&& !obj[1].equals("UPDATE_TIME")
					&& !obj[1].equals("UPDATE_USER")
					&& !obj[1].equals("PROJECT_ID")
					&& !obj[1].equals("REMARK")) {
				boolean flag = true;
				for (int j = 0;j<returnList.size();j++){
					if (returnList.get(j)[0].equals(obj[0]) && returnList.get(j)[1].equals(obj[1])){
						flag = false;
					}
				}
				if (flag == true){
					returnList.add(obj);
				}
			}
			//主要研究内容
			if (obj[0].equals("T_REPORT_ABSTRACT_B")
					&& (obj[1].equals("REMARK"))) {
				boolean flag = true;
				for (int j = 0;j<returnList.size();j++){
					if (returnList.get(j)[0].equals(obj[0]) && returnList.get(j)[1].equals(obj[1])){
						flag = false;
					}
				}
				if (flag == true){
					returnList.add(obj);
				}
			}
			// 国内外研究水平、发展趋势和市场需求
			if (obj[0].equals("T_COMPANY_NEED_B") && obj[1].equals("COMPANY_NEED")) {
				boolean flag = true;
				for (int j = 0;j<returnList.size();j++){
					if (returnList.get(j)[0].equals(obj[0]) && returnList.get(j)[1].equals(obj[1])){
						flag = false;
					}
				}
				if (flag == true){
					returnList.add(obj);
				}
			}
			// 前期研究基础（可附相关证明）及现有条件（含设备手段等）和优势
			if (obj[0].equals("T_COMPANY_FOUNDATION_B")
					&& obj[1].equals("COMPANY_FOUNDATION")) {
				boolean flag = true;
				for (int j = 0;j<returnList.size();j++){
					if (returnList.get(j)[0].equals(obj[0]) && returnList.get(j)[1].equals(obj[1])){
						flag = false;
					}
				}
				if (flag == true){
					returnList.add(obj);
				}
			}
			//项目进度计划
			if (obj[0].equals("T_SCHEDULING_A")
					&& obj[1].equals("SCHEDULING_TEXT")) {
				boolean flag = true;
				for (int j = 0;j<returnList.size();j++){
					if (returnList.get(j)[0].equals(obj[0]) && returnList.get(j)[1].equals(obj[1])){
						flag = false;
					}
				}
				if (flag == true){
					returnList.add(obj);
				}
			}
			//预期成果
			if (obj[0].equals("T_EXPECTED_RESULTS")
					&& obj[1].equals("EXPECTED_RESULTS")) {
				boolean flag = true;
				for (int j = 0;j<returnList.size();j++){
					if (returnList.get(j)[0].equals(obj[0]) && returnList.get(j)[1].equals(obj[1])){
						flag = false;
					}
				}
				if (flag == true){
					returnList.add(obj);
				}
			}
			//项目达到主要技术指标
			if (obj[0].equals("T_TECHNICAL_INDEXES")
					&& obj[1].equals("TECHNICAL_INDEXES")) {
				boolean flag = true;
				for (int j = 0;j<returnList.size();j++){
					if (returnList.get(j)[0].equals(obj[0]) && returnList.get(j)[1].equals(obj[1])){
						flag = false;
					}
				}
				if (flag == true){
					returnList.add(obj);
				}
			}
			//执行期内项目完成的经济指标
			if (obj[0].equals("T_ECONOMIC_INDICATOR_B")
					&& !obj[1].equals("ECONOMIC_INDICATOR_ID")
					&& !obj[1].equals("DELETE_FLAG")
					&& !obj[1].equals("CREATE_TIME")
					&& !obj[1].equals("CREATE_USER")
					&& !obj[1].equals("UPDATE_TIME")
					&& !obj[1].equals("UPDATE_USER")
					&& !obj[1].equals("PROJECT_ID")
					&& !obj[1].equals("REMARK")
					&& !obj[1].equals("YEAR1")
					&& !obj[1].equals("YEAR2")
					&& !obj[1].equals("YEAR3")) {
				boolean flag = true;
				for (int j = 0;j<returnList.size();j++){
					if (returnList.get(j)[0].equals(obj[0]) && returnList.get(j)[1].equals(obj[1])){
						flag = false;
					}
				}
				if (flag == true){
					returnList.add(obj);
				}
			}
			//执行期内企业完成的经济指标
			if (obj[0].equals("T_ECONOMIC_INDICATOR_A")
					&& !obj[1].equals("ECONOMIC_INDICATOR_ID")
					&& !obj[1].equals("DELETE_FLAG")
					&& !obj[1].equals("CREATE_TIME")
					&& !obj[1].equals("CREATE_USER")
					&& !obj[1].equals("UPDATE_TIME")
					&& !obj[1].equals("UPDATE_USER")
					&& !obj[1].equals("PROJECT_ID")
					&& !obj[1].equals("REMARK")
					&& !obj[1].equals("YEAR1")
					&& !obj[1].equals("YEAR2")
					&& !obj[1].equals("YEAR3")) {
				boolean flag = true;
				for (int j = 0;j<returnList.size();j++){
					if (returnList.get(j)[0].equals(obj[0]) && returnList.get(j)[1].equals(obj[1])){
						flag = false;
					}
				}
				if (flag == true){
					returnList.add(obj);
				}
			}
			//经费概算及投入进度
			if (obj[0].equals("T_COST_ESTIMATE_B")
					&& !obj[1].equals("COST_ESTIMATE_ID")
					&& !obj[1].equals("DELETE_FLAG")
					&& !obj[1].equals("CREATE_TIME")
					&& !obj[1].equals("CREATE_USER")
					&& !obj[1].equals("UPDATE_TIME")
					&& !obj[1].equals("UPDATE_USER")
					&& !obj[1].equals("PROJECT_ID")
					&& !obj[1].equals("REMARK")) {
				boolean flag = true;
				for (int j = 0;j<returnList.size();j++){
					if (returnList.get(j)[0].equals(obj[0]) && returnList.get(j)[1].equals(obj[1])){
						flag = false;
					}
				}
				if (flag == true){
					returnList.add(obj);
				}
			}
			//项目投资计划
			if (obj[0].equals("T_FUND_PLAN_B")
					&& !obj[1].equals("FUND_PLAN_B_ID")
					&& !obj[1].equals("DELETE_FLAG")
					&& !obj[1].equals("CREATE_TIME")
					&& !obj[1].equals("CREATE_USER")
					&& !obj[1].equals("UPDATE_TIME")
					&& !obj[1].equals("UPDATE_USER")
					&& !obj[1].equals("PROJECT_ID")
					&& !obj[1].equals("REMARK")
					&& !obj[1].equals("YEAR_1")
					&& !obj[1].equals("YEAR_2")
					&& !obj[1].equals("YEAR_3")) {
				boolean flag = true;
				for (int j = 0;j<returnList.size();j++){
					if (returnList.get(j)[0].equals(obj[0]) && returnList.get(j)[1].equals(obj[1])){
						flag = false;
					}
				}
				if (flag == true){
					returnList.add(obj);
				}
			}
			//申请经费
			if (obj[0].equals("T_FUNDING_PLAN_REPORT")
					&& !obj[1].equals("FUNDING_PLAN_REPORT_ID")
					&& !obj[1].equals("DELETE_FLAG")
					&& !obj[1].equals("CREATE_TIME")
					&& !obj[1].equals("CREATE_USER")
					&& !obj[1].equals("UPDATE_TIME")
					&& !obj[1].equals("UPDATE_USER")
					&& !obj[1].equals("PROJECT_ID")
					&& !obj[1].equals("REMARK")) {
				boolean flag = true;
				for (int j = 0;j<returnList.size();j++){
					if (returnList.get(j)[0].equals(obj[0]) && returnList.get(j)[1].equals(obj[1])){
						flag = false;
					}
				}
				if (flag == true){
					returnList.add(obj);
				}
			}
			//企业项目汇总表
			if (obj[0].equals("T_COMPANY_INFO")
					&& !obj[1].equals("COMPANY_INFO_ID")
					&& !obj[1].equals("DELETE_FLAG")
					&& !obj[1].equals("CREATE_TIME")
					&& !obj[1].equals("CREATE_USER")
					&& !obj[1].equals("UPDATE_TIME")
					&& !obj[1].equals("UPDATE_USER")
					&& !obj[1].equals("PROJECT_ID")
					&& !obj[1].equals("REMARK")
					&& !obj[1].equals("YEAR_BENEFIT_1")
					&& !obj[1].equals("YEAR_BENEFIT_2")
					&& !obj[1].equals("YEAR_BENEFIT_3")
					&& !obj[1].equals("YEAR_OPERATE_1")
					&& !obj[1].equals("YEAR_OPERATE_2")
					&& !obj[1].equals("YEAR_OPERATE_3")) {
				boolean flag = true;
				for (int j = 0;j<returnList.size();j++){
					if (returnList.get(j)[0].equals(obj[0]) && returnList.get(j)[1].equals(obj[1])){
						flag = false;
					}
				}
				if (flag == true){
					returnList.add(obj);
				}
			}
			//审查意见
			if (obj[0].equals("T_REVIEW_COMMENTS")
					&& !obj[1].equals("REVIEW_COMMENTS_ID")
					&& !obj[1].equals("DELETE_FLAG")
					&& !obj[1].equals("CREATE_TIME")
					&& !obj[1].equals("CREATE_USER")
					&& !obj[1].equals("UPDATE_TIME")
					&& !obj[1].equals("UPDATE_USER")
					&& !obj[1].equals("PROJECT_ID")
					&& !obj[1].equals("REMARK")
					&& !obj[1].equals("APPENDIX_FLAG")	
					&& !obj[1].equals("SUBMIT_FLAG")
					&& !obj[1].equals("CENTRALIZED_UNITS")
					&& !obj[1].equals("SCIENCE_UNITS")
					&& !obj[1].equals("EXAMINE_UNITS")) {
				boolean flag = true;
				for (int j = 0;j<returnList.size();j++){
					if (returnList.get(j)[0].equals(obj[0]) && returnList.get(j)[1].equals(obj[1])){
						flag = false;
					}
				}
				if (flag == true){
					returnList.add(obj);
				}
			}
		}
		

		return returnList;
	}
	
//	/**
//	 * @comments 设定mapList 
//	 * @version 1.0
//	 */
//	public void setMapList(){
//		HttpSession session = this.getRequest().getSession();
//		session.setAttribute("mapList", this.mapList);
//	}
	
	/**
	 * @comments 导出excel文件
	 * @throws Exception
	 * @Version 1.0
	 */
	public void exportDatas() throws Exception {

		HttpServletResponse response = ServletActionContext.getResponse();
		String[] val = this.getRequest().getParameterValues("mapList");
		mapList.clear();
		for (int i = 0 ;i<val.length ;i++){
			this.mapList.add(val[i]);
		}
		ExcelIterator excelWriter = new ExcelIterator();

		// 输出的文件数据
		List<Object[]> datas = new ArrayList<Object[]>();

		// Title行
		Object[] titleInfo = this.makeTitle();
		datas.add(titleInfo);

		List<Object> list = new ArrayList<Object>();

		// 获取码表信息
		Map<String, String> map = this.getMitemInfo();
				
		// data行
		list = statisticsProjectService.getExportDatas(getCondition2());
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Object[] obj = (Object[]) list.get(i);
				datas.add(this.makeDateList(obj,map));
			}
		}

		// EXCEL名称
		String exportFileName = this.getText("project_contents");
		// sheet名称
		String sheetName = "项目信息";

		excelWriter.exportExcel(exportFileName, datas, sheetName, response);
		
	}
	
	/**
	 * @comments 制作Title行数据
	 * @return
	 * @throws Exception
	 * @Version 1.0
	 */
	private Object[] makeTitle() throws Exception {
		

		Object[] returnObj = null;

		// 获取数据库中表的字段
		List<Object[]> list = this.getTableColName();

		returnObj = new Object[mapList.size()];
		int n = 0;
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Object[] obj = (Object[]) list.get(i);
				for (int j = 0; j < mapList.size(); j++) {
					Object mapObj = mapList.get(j);
					if (mapObj != null && mapObj.equals(obj[0] + "-" + obj[1])) {
						returnObj[n] = obj[2];
						n++;
					}
				}
			}
		}
		return returnObj;
	}
	
	/**
	 * @comments 获取Mitem码表信息
	 * @return
	 * @Version 1.0
	 */
	private Map<String, String> getMitemInfo() {
		Map<String, String> mitemMap = new HashMap<String, String>();
		List<Mitem> mitemList = mitemService.getMitemListInfo();
		if (mitemList != null && mitemList.size() > 0) {
			for (Mitem m : mitemList) {
				mitemMap.put(m.getItemId(), m.getItemName());
			}
		}
		return mitemMap;
	}
	
	/**
	 * @comments 制作Data行数据
	 * @param objInfo
	 * @return
	 * @throws Exception
	 * @Version 1.0
	 */
	private Object[] makeDateList(Object[] objInfo,Map<String, String> map) throws Exception {
		Object[] returnObj = null;
		
		int n = 0;
		// 获取数据库中表的字段
		List<Object[]> list = this.getTableColName();
		if (list != null && list.size() > 0) {
			returnObj = new Object[mapList.size()];
			for (int i = 0; i < list.size(); i++) {
				Object[] obj = (Object[]) list.get(i);

				if (obj[1] != null) {
					for (int j = 0; j < mapList.size(); j++) {
						Object mapObj = mapList.get(j);
						Object tempObj = obj[0] + "-" + obj[1];
						if (null != mapObj && tempObj.equals(mapObj)) {

							Object tableInfo = null;
							// 申报表
							if (obj[0].equals("T_PROJECT_APPLICATION")) {
								tableInfo = objInfo[0];
							}
							
							// 项目基本信息表
							if (obj[0].equals("T_PROJECT_INFO_B")) {
								tableInfo = objInfo[1];
							}

							// 项目主要研究内容
							else if (obj[0].equals("T_REPORT_ABSTRACT_B")) {
								tableInfo = objInfo[2];
							}

							// 研究水平、发展趋势和市场需求
							else if (obj[0].equals("T_COMPANY_NEED_B")) {
								tableInfo = objInfo[3];
							}

							// 前期基础及现有条件和优势
							else if (obj[0].equals("T_COMPANY_FOUNDATION_B")) {
								tableInfo = objInfo[4];
							}

							// 项目进度计划
							else if (obj[0].equals("T_SCHEDULING_A")) {
								tableInfo = objInfo[5];
							}
							// 预期成果
							else if (obj[0].equals("T_EXPECTED_RESULTS")) {
								tableInfo = objInfo[6];
							}
							// 项目达到的主要技术指标
							else if (obj[0].equals("T_TECHNICAL_INDEXES")) {
								tableInfo = objInfo[7];
							}
							
							// 执行期内项目完成的经济指标
							else if (obj[0].equals("T_ECONOMIC_INDICATOR_B")) {
								tableInfo = objInfo[8];
							}

							// 执行期内企业完成的经济指标
							else if (obj[0].equals("T_ECONOMIC_INDICATOR_A")) {
								tableInfo = objInfo[9];
							}
							
							// 经费概算
							else if (obj[0].equals("T_COST_ESTIMATE_B")) {
								tableInfo = objInfo[10];
							}
							
							// 项目投资计划
							else if (obj[0].equals("T_FUND_PLAN_B")) {
								tableInfo = objInfo[11];
							}
							
							//申请经费 
							else if (obj[0].equals("T_FUNDING_PLAN_REPORT")) {
								tableInfo = objInfo[12];
							}
							
							// 企业项目汇总表
							else if (obj[0].equals("T_COMPANY_INFO")) {
								tableInfo = objInfo[13];
							}
							
							// 审查意见
							else if (obj[0].equals("T_REVIEW_COMMENTS")) {
								tableInfo = objInfo[14];
							}

							String[] str = obj[1].toString().split("_");
							String methodName = "get";
							// 转换为首字母大写，其他字母小写的格式。
							for (int m = 0; m < str.length; m++) {
								str[m] = str[m].toLowerCase();
								str[m] = str[m].substring(0, 1).toUpperCase()
										+ str[m].substring(1);
								methodName = methodName + str[m];
							}
							// 得到对象属性值
							Object methodValus = null;
							if (tableInfo != null) {
								methodValus = invokeMethod(tableInfo,
										methodName);
							}
							// 小分类
							if (obj[1].equals("TYPE_ID") && obj[0].equals("T_PROJECT_APPLICATION")){
								TprojectApplication tproject = (TprojectApplication)tableInfo;
								methodValus = tproject.getTprojectType().getTypeShowName();
							}
							// 修改时间
							if (methodName.equals("getHandleTime")) {
								returnObj[n] = this.formatDate(methodValus,"yyyy-MM-dd HH:mm:ss");
							}
							// 开始时间 结束时间
							else if(methodName.equals("getStartTime") || methodName.equals("getEndTime")){
								returnObj[n] = this.formatDate(methodValus,"yyyy-MM");
							}
							// 填报时间
							else if(methodName.equals("getWriteReportTime")){
								returnObj[n] = this.formatDate(methodValus,"yyyy-MM-dd");
							}
							// 删除区分
							else if (methodName.equals("getDeleteFlag")) {
								if (methodName != null) {
									if ("0".equals(methodValus)) {
										returnObj[n] = "否";
									} else {
										returnObj[n] = "是";
									}
								}
							} else {
								if (methodValus == null) {
									returnObj[n] = "";
								} else {
									if (map.get(methodValus) != null
											&& map.get(methodValus).length() > 0) {
										returnObj[n] = map.get(methodValus);
									} else {
										returnObj[n] = methodValus;
									}
								}
							}

							n++;

						}
					}
				}
			}
		}
		return returnObj;
	}
	
	/**
	 * @comments 日期格式转换
	 * @param dataStr
	 * @return
	 * @Version 1.0
	 */
	private String formatDate(Object dataStr,String formatStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		String str = "";
		if (dataStr != null && !"".equals(dataStr)) {
			str = sdf.format(dataStr);
		}
		return str;
	}

	/**
	 * @comments 通过反射机制获取参数的值。
	 * @throws Exception
	 * @Version 1.0
	 */
	private Object invokeMethod(Object owner, String methodName)
			throws Exception {
		
		Class<? extends Object> ownerClass = owner.getClass();
		
		Method method = ownerClass.getMethod(methodName);
		
		return method.invoke(owner);
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
	 * @return the statisticsProjectService
	 */
	public StatisticsProjectService getStatisticsProjectService() {
		return statisticsProjectService;
	}

	/**
	 * @param statisticsProjectService the statisticsProjectService to set
	 */
	public void setStatisticsProjectService(
			StatisticsProjectService statisticsProjectService) {
		this.statisticsProjectService = statisticsProjectService;
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

	public List<Mitem> getTechnicalFisld1List() {
		return technicalFisld1List;
	}

	public void setTechnicalFisld1List(List<Mitem> technicalFisld1List) {
		this.technicalFisld1List = technicalFisld1List;
	}

	public List<Mitem> getTechnicalFisld2List() {
		return technicalFisld2List;
	}

	public void setTechnicalFisld2List(List<Mitem> technicalFisld2List) {
		this.technicalFisld2List = technicalFisld2List;
	}

	public List<Mitem> getTechnicalFisld3List() {
		return technicalFisld3List;
	}

	public void setTechnicalFisld3List(List<Mitem> technicalFisld3List) {
		this.technicalFisld3List = technicalFisld3List;
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


	public TprojectTypeManagerService getTprojectTypeManagerService() {
		return tprojectTypeManagerService;
	}

	public void setTprojectTypeManagerService(
			TprojectTypeManagerService tprojectTypeManagerService) {
		this.tprojectTypeManagerService = tprojectTypeManagerService;
	}

	public TprojectInfoB getTprojectInfob() {
		return tprojectInfob;
	}

	public void setTprojectInfob(TprojectInfoB tprojectInfob) {
		this.tprojectInfob = tprojectInfob;
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
	 * @return the mapList
	 */
	public List<Object> getMapList() {
		return mapList;
	}

	/**
	 * @param mapList the mapList to set
	 */
	public void setMapList(List<Object> mapList) {
		this.mapList = mapList;
	}

	/**
	 * @return the subPageList
	 */
	public List<Map<Object, Object>> getSubPageList() {
		return subPageList;
	}

	/**
	 * @param subPageList the subPageList to set
	 */
	public void setSubPageList(List<Map<Object, Object>> subPageList) {
		this.subPageList = subPageList;
	}

}

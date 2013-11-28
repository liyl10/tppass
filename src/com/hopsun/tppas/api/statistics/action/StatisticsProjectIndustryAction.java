/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.statistics.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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

import org.apache.log4j.Logger;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.scenter.entity.ScDept;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.tppas.api.statistics.service.StatisticsProjectIndustryService;
import com.hopsun.tppas.api.superadmin.service.MitemService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeManagerService;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Mitem;
import com.hopsun.tppas.entity.TprojectType;

/**
 * 
 * @comments 产业处项目统计
 * @author wanglw
 * @date 2013-11-13 @time 下午1:58:43
 * @Version 1.0
 */
public class StatisticsProjectIndustryAction extends BaseAction{

	public final static Logger logger = Logger.getLogger(StatisticsProjectAction.class.getName());
	
	private static final long serialVersionUID = -8338961242197869288L;
	
	@Resource
	private StatisticsProjectIndustryService statisticsProjectIndustryService;
	@Resource
	private MitemService mitemService;
	@Resource
	private TprojectTypeService tprojectTypeService;
	@Resource
	private TprojectTypeManagerService tprojectTypeManagerService;
	
	/** 翻页*/
    private int pageNo;
    /** 跳转路径*/
	private String retUrl;
	/** 跳转页面massage */
	private String retMsg;
	/** 单位性质List */
	private List<Mitem> unitPropertiesList;
	/** 归口管理部门List */
	private List<Mitem> centralizedTypeList;
	/** 只是产权状况 */
	private List<Mitem> intellectualPropertyList;
	/** 技术领域1List */
	private List<Mitem> technicalFisldList1;
	/** 技术领域2List */
	private List<Mitem> technicalFisldList2;
	/** 技术领域3List */
	private List<Mitem> technicalFisldList3;
	/** 技术来源List */
	private List<Mitem> technologySourceList;
	/** 行政区域1List */
	private List<Mitem> regionId1List;
	/** 行政区域2List */
	private List<Mitem> regionId2List;
	/** 行政区域3List */
	private List<Mitem> regionId3List;
	/** 行业领域1List */
	private List<Mitem> industries1List;
	/** 行业领域2List */
	private List<Mitem> industries2List;
	/** 行业领域3List */
	private List<Mitem> industries3List;
	/** 行业领域4List */
	private List<Mitem> industries4List;
	/** 部门List */
	private List<ScDept> typeId1List;
	/** 分计划List */
	private List<TprojectType> typeId2List;
	/** 项目分类List */
	private List<TprojectType> typeId3List;
	/** 项目名称 */
	private String projectName;
	/** 单位地址 */
	private String unitAddress;
	/** 申报单位  */
	private String applicationUnit;
	/** 协作单位 */
	private String assistUnit;
	/** 申报年度 */
	private String reportYear;
	/** 单位性质 */
	private String unitProperties;
	/** 归口管理部门 */
	private String centralizedType;
	/** 知识产权状况 */
	private String intellectualProperty;
	/** 技术领域1 */
	private String technicalFisld1;
	/** 技术领域2 */
	private String technicalFisld2;
	/** 技术领域3 */
	private String technicalFisld3;
	/** 技术来源 */
	private String technologySource;
	/** 所在区域1 */
	private String regionId1;
	/** 所在区域2 */
	private String regionId2;
	/** 所在区域3 */
	private String regionId3;
	/** 行业领域1 */
	private String industries1;
	/** 行业领域2 */
	private String industries2;
	/** 行业领域3 */
	private String industries3;
	/** 行业领域4 */
	private String industries4;
	/** 部门Id */
	private String typeId1;
	/** 分计划Id */
	private String typeId2;
	/** 项目分类Id */
	private String typeId3;
	/** 计财处Flag */
	private String planningFlag;
	/** 导出字段List */
	private List<Map<String, Object>> columnList;
	/** 选择导出字段 */
	private String columnName;
	private List<String> columnName1;
	
	/**
	 * @comments 显示产业处项目统计页面
	 * @return
	 * @Version 1.0
	 */
	public String showProjectIndustryManage(){
		
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
	    session.setAttribute(Constants.SESSION_CMDKEY, "industry");
	    
	    ScUsers user = (ScUsers) session.getAttribute("sysUser");
	    
		// 如果用户为空或者企业为空，退出系统
		if (user == null || ("").equals(user.getUserId())) {
			return "LogOut";
		}
		
		// 单位性质
		this.unitPropertiesList = new ArrayList<Mitem>();
		this.unitPropertiesList = mitemService.getListByTypeId(Constants.TYPE_COMPANY_RETY);
		// 初始化归口管理部门
		this.centralizedTypeList = new ArrayList<Mitem>();
		this.centralizedTypeList = mitemService.getListByTypeId(Constants.TYPE_CENTRALIZED_TYPE);
		// 知识产权状况
		this.intellectualPropertyList = new ArrayList<Mitem>();
		this.intellectualPropertyList = mitemService.getListByTypeId(Constants.TYPE_INTELLECTUAL);
		// 技术来源
		this.technologySourceList = new ArrayList<Mitem>();
		this.technologySourceList = mitemService.getListByTypeId(Constants.TYPE_TECHNOLOGY);
		// 所在区域1
		this.regionId1List = new ArrayList<Mitem>();
		// 所在区域2
		this.regionId2List = new ArrayList<Mitem>();
		// 所在区域3
		this.regionId3List = new ArrayList<Mitem>();
		
		// 取得所在区域（省）
		this.regionId1List = mitemService.getListByTypeId(Constants.TYPE_REGION_1);
		// 取得所在区域（市）
		//this.regionId2List = mitemService.getMitemListByPId(Constants.SHANNXI);
		// 设置默认选择陕西省
		//this.setRegionId1(Constants.SHANNXI);
		// 取得所在区域（区）
		//this.regionId3List = mitemService.getMitemListByPId(Constants.XIAN);
		// 设置默认选择西安市
		//this.setRegionId2(Constants.XIAN);
		
		// 行业领域1
		this.industries1List = new ArrayList<Mitem>();
		this.industries1List = mitemService.getListByTypeId(Constants.TYPE_INDUSTRIES1);
		// 行业领域2
		this.industries2List = new ArrayList<Mitem>();
		// 行业领域3
		this.industries3List = new ArrayList<Mitem>();
		// 行业领域4
		this.industries4List = new ArrayList<Mitem>();
		// 技术领域1
		this.technicalFisldList1 = new ArrayList<Mitem>();
		this.technicalFisldList1 = mitemService.getListByTypeId(Constants.TYPE_PROJECTINFO_FIELD1);
		// 技术领域2
		this.technicalFisldList2 = new ArrayList<Mitem>();
		// 技术领域3
		this.technicalFisldList3 = new ArrayList<Mitem>();
		// 部门
		this.typeId1List = new ArrayList<ScDept>();
		// 计划分类
		this.typeId2List = new ArrayList<TprojectType>();
		// 项目分类
		this.typeId3List = new ArrayList<TprojectType>();
		
		// 是否计财处
    	if(Constants.PLANNING_DEPARTMENT.equals(user.getScDept().getDeptId())){
    		planningFlag = "1";
    		// 部门列表
    		this.typeId2List = tprojectTypeService.getFatherProjectTypeListByDeptId(Constants.HIGHTECH_DEPARTMENT);
    	} else {
    		planningFlag = "0";
    		// 项目分类1
    		this.typeId2List = tprojectTypeManagerService.getProjectTypeListByUser(user);
    	}
		return "showProjectindustryManage";
	}
	
	/**
	 * @comments 取得产业处项目列表
	 * @return
	 * @Version 1.0
	 */
	public String getProjectList(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (cmdkey == null || !"industry".equals(cmdkey)) {
			logger.error("错误的令牌！");
			return "LogOut";
		}
		// 取得部门ID
    	if(user != null && user.getScDept() != null
    		&& user.getScDept().getDeptId() != null && !"".equals(user.getScDept().getDeptId())){
    	} else {
    		logger.error("部门不存在！");
			return "LogOut";
    	}
    	
    	// 翻页
    	if (pager == null && this.getPageNo() == 0) {
			pager = new Pager();
		}
    	else{
    		pager = new Pager();
    		pager.setPageNumber(this.getPageNo());
    	}
    	
    	Map<String, Object> param = new HashMap<String, Object>();
		
		// 封装查询条件
    	// 部门ID
    	param.put("departmentId", user.getScDept().getDeptId());
    	// 
    	if(!Constants.PLANNING_DEPARTMENT.equals(user.getScDept().getDeptId())){
    		// 计划类别
    		String projectTypeString = tprojectTypeManagerService.getProjectTypeStrByUser(user);
    		param.put("projectTypeString", projectTypeString);
    	}
		// 项目名称 
		param.put("projectName", projectName);
		// 单位地址
		param.put("unitAddress", unitAddress);
		// 申请单位
		param.put("applicationUnit", applicationUnit);
		// 协作单位
		param.put("assistUnit", assistUnit);
		// 申报年度
		param.put("reportYear", reportYear);
		// 单位性质
		param.put("unitProperties", unitProperties);
		// 归口管理部门
		param.put("centralizedType", centralizedType);
		// 知识产权状况
		param.put("intellectualProperty", intellectualProperty);
		// 技术领域
		param.put("technicalFisld1", technicalFisld1);
		// 技术领域
		param.put("technicalFisld2", technicalFisld2);
		// 技术领域
		param.put("technicalFisld3", technicalFisld3);
		// 技术来源
		param.put("technologySource", technologySource);
		// 所在区域
		param.put("regionId1", regionId1);
		// 所在区域
		param.put("regionId2", regionId2);
		// 所在区域
		param.put("regionId3", regionId3);
		// 行业领域
		param.put("industries1", industries1);
		// 行业领域
		param.put("industries2", industries2);
		// 行业领域
		param.put("industries3", industries3);
		// 行业领域
		param.put("industries4", industries4);
		// 部门
		// param.put("typeId1", typeId1);
		// 计划分类
		param.put("typeId2", typeId2);
		// 项目分类
		param.put("typeId3", typeId3);

		pager = statisticsProjectIndustryService.getProjectList(param, pager.getPageNumber(), pager.getPageSize());
		
		return "getProjectList";
	}
	
	/**
	 * @comments 项目导出页面
	 * @return
	 * @Version 1.0
	 */
	public String showExportProject(){
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (cmdkey == null || !"industry".equals(cmdkey)) {
			logger.error("错误的令牌！");
			return "LogOut";
		}
		// 取得部门ID
    	if(user != null && user.getScDept() != null
    		&& user.getScDept().getDeptId() != null && !"".equals(user.getScDept().getDeptId())){
    	} else {
    		logger.error("部门不存在！");
			return "LogOut";
    	}
    	
    	this.columnList = statisticsProjectIndustryService.getColumnList();
    	
		return "showExportProject";
	}
	
	/**
	 * @throws IOException 
	 * @throws WriteException 
	 * @comments 导出数据
	 * @Version 1.0
	 */
	public void exportData() throws IOException, WriteException{
		
		
		// 取得登录用户的信息
		HttpSession session = this.getRequest().getSession();
		String [] col = this.getRequest().getParameterValues("columnName1");
		ScUsers user = (ScUsers) session.getAttribute("sysUser");
		String cmdkey = (String) session.getAttribute(Constants.SESSION_CMDKEY);
		if (cmdkey == null || !"industry".equals(cmdkey)) {
			logger.error("错误的令牌！");
			return;
		}
		// 取得部门ID
    	if(user != null && user.getScDept() != null
    		&& user.getScDept().getDeptId() != null && !"".equals(user.getScDept().getDeptId())){
    	} else {
    		logger.error("部门不存在！");
			return;
    	}
		
    	Map<String, Object> param = new HashMap<String, Object>();
		
		// 封装查询条件
    	// 部门ID
    	param.put("departmentId", user.getScDept().getDeptId());
    	// 
    	if(!Constants.PLANNING_DEPARTMENT.equals(user.getScDept().getDeptId())){
    		// 计划类别
    		String projectTypeString = tprojectTypeManagerService.getProjectTypeStrByUser(user);
    		param.put("projectTypeString", projectTypeString);
    	}
		// 项目名称 
		param.put("projectName", new String(projectName.getBytes("ISO-8859-1"), "UTF-8"));
		// 单位地址
		param.put("unitAddress", new String(unitAddress.getBytes("ISO-8859-1"), "UTF-8"));
		// 申请单位
		param.put("applicationUnit", new String(applicationUnit.getBytes("ISO-8859-1"), "UTF-8"));
		// 协作单位
		param.put("assistUnit", new String(assistUnit.getBytes("ISO-8859-1"), "UTF-8"));
		// 申报年度
		param.put("reportYear", reportYear);
		// 单位性质
		param.put("unitProperties", unitProperties);
		// 归口管理部门
		param.put("centralizedType", centralizedType);
		// 知识产权状况
		param.put("intellectualProperty", intellectualProperty);
		// 技术领域
		param.put("technicalFisld1", technicalFisld1);
		// 技术领域
		param.put("technicalFisld2", technicalFisld2);
		// 技术领域
		param.put("technicalFisld3", technicalFisld3);
		// 技术来源
		param.put("technologySource", technologySource);
		// 所在区域
		param.put("regionId1", regionId1);
		// 所在区域
		param.put("regionId2", regionId2);
		// 所在区域
		param.put("regionId3", regionId3);
		// 行业领域
		param.put("industries1", industries1);
		// 行业领域
		param.put("industries2", industries2);
		// 行业领域
		param.put("industries3", industries3);
		// 行业领域
		param.put("industries4", industries4);
		// 部门
		// param.put("typeId1", typeId1);
		// 计划分类
		param.put("typeId2", typeId2);
		// 项目分类
		param.put("typeId3", typeId3);
		
		// 导出项
		if(col !=null && col.length > 0){
			for(int i=0; i<col.length; i++){
				columnName = columnName + col[i] + ",";
			}
		}
		if(columnName != null && !"".equals(columnName) && columnName.length() > 1){
			columnName = columnName.substring(0, columnName.length() -1);
		}
		
		// 取得选择的列名
		List<Object> columnNameList = statisticsProjectIndustryService.getColumnName(columnName);
		
		// 取得选择的列名对应的数据
		List<Object> projectList = statisticsProjectIndustryService.getProjectList(param, columnName);
    	this.printData(columnNameList, projectList);
	}
	
	/**
	 * @comments 打印导出的文件
	 * @param columnNameList
	 * @param projectList
	 * @throws IOException 
	 * @throws WriteException 
	 * @Version 1.0
	 */
	private void printData(List<Object> columnNameList, List<Object> projectList) throws IOException, WriteException{
		HttpServletResponse response = this.getResponse();
		
		String excelFileName = this.getText("industry_project_statistic");
		
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
			
			WritableSheet sh = workbook.createSheet(excelFileName, 0);
			
			// 表头
			if(columnNameList != null && columnNameList.size() > 0){
				for(int i=0;i<columnNameList.size(); i++){
					sh.addCell(new Label(i, 0, String.valueOf(columnNameList.get(i)), headerCf));
					sh.setColumnView(i, 20);
					sh.setRowView(0, 500);
				}
			}
			// 数据
			if(projectList != null && projectList.size() > 0){
				for(int i=0; i <projectList.size(); i++){
					Object[] obj = (Object[])projectList.get(i);
					if(obj !=null && obj.length > 0){
						for(int j=0; j<obj.length; j++){
							sh.addCell(new Label(j, i + 1, String.valueOf(obj[j]==null?"":obj[j]), typeCf));
							sh.setRowView(i + 1, 500);
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
		}finally{
			if (null != workbook) {
				workbook.close();
			}
			if (null != out) {
				out.close();
			}
		}
	}

	public List<Mitem> getUnitPropertiesList() {
		return unitPropertiesList;
	}

	public void setUnitPropertiesList(List<Mitem> unitPropertiesList) {
		this.unitPropertiesList = unitPropertiesList;
	}

	public List<Mitem> getCentralizedTypeList() {
		return centralizedTypeList;
	}

	public void setCentralizedTypeList(List<Mitem> centralizedTypeList) {
		this.centralizedTypeList = centralizedTypeList;
	}

	public List<Mitem> getIntellectualPropertyList() {
		return intellectualPropertyList;
	}

	public void setIntellectualPropertyList(List<Mitem> intellectualPropertyList) {
		this.intellectualPropertyList = intellectualPropertyList;
	}

	public List<Mitem> getTechnicalFisldList1() {
		return technicalFisldList1;
	}

	public void setTechnicalFisldList1(List<Mitem> technicalFisldList1) {
		this.technicalFisldList1 = technicalFisldList1;
	}

	public List<Mitem> getTechnicalFisldList2() {
		return technicalFisldList2;
	}

	public void setTechnicalFisldList2(List<Mitem> technicalFisldList2) {
		this.technicalFisldList2 = technicalFisldList2;
	}

	public List<Mitem> getTechnicalFisldList3() {
		return technicalFisldList3;
	}

	public void setTechnicalFisldList3(List<Mitem> technicalFisldList3) {
		this.technicalFisldList3 = technicalFisldList3;
	}

	public List<Mitem> getTechnologySourceList() {
		return technologySourceList;
	}

	public void setTechnologySourceList(List<Mitem> technologySourceList) {
		this.technologySourceList = technologySourceList;
	}

	public List<Mitem> getRegionId1List() {
		return regionId1List;
	}

	public void setRegionId1List(List<Mitem> regionId1List) {
		this.regionId1List = regionId1List;
	}

	public List<Mitem> getRegionId2List() {
		return regionId2List;
	}

	public void setRegionId2List(List<Mitem> regionId2List) {
		this.regionId2List = regionId2List;
	}

	public List<Mitem> getRegionId3List() {
		return regionId3List;
	}

	public void setRegionId3List(List<Mitem> regionId3List) {
		this.regionId3List = regionId3List;
	}

	public List<Mitem> getIndustries1List() {
		return industries1List;
	}

	public void setIndustries1List(List<Mitem> industries1List) {
		this.industries1List = industries1List;
	}

	public List<Mitem> getIndustries2List() {
		return industries2List;
	}

	public void setIndustries2List(List<Mitem> industries2List) {
		this.industries2List = industries2List;
	}

	public List<Mitem> getIndustries3List() {
		return industries3List;
	}

	public void setIndustries3List(List<Mitem> industries3List) {
		this.industries3List = industries3List;
	}

	public List<Mitem> getIndustries4List() {
		return industries4List;
	}

	public void setIndustries4List(List<Mitem> industries4List) {
		this.industries4List = industries4List;
	}

	public List<ScDept> getTypeId1List() {
		return typeId1List;
	}

	public void setTypeId1List(List<ScDept> typeId1List) {
		this.typeId1List = typeId1List;
	}

	public List<TprojectType> getTypeId2List() {
		return typeId2List;
	}

	public void setTypeId2List(List<TprojectType> typeId2List) {
		this.typeId2List = typeId2List;
	}

	public List<TprojectType> getTypeId3List() {
		return typeId3List;
	}

	public void setTypeId3List(List<TprojectType> typeId3List) {
		this.typeId3List = typeId3List;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getUnitAddress() {
		return unitAddress;
	}

	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}

	public String getApplicationUnit() {
		return applicationUnit;
	}

	public void setApplicationUnit(String applicationUnit) {
		this.applicationUnit = applicationUnit;
	}

	public String getAssistUnit() {
		return assistUnit;
	}

	public void setAssistUnit(String assistUnit) {
		this.assistUnit = assistUnit;
	}

	public String getReportYear() {
		return reportYear;
	}

	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}

	public String getPlanningFlag() {
		return planningFlag;
	}

	public void setPlanningFlag(String planningFlag) {
		this.planningFlag = planningFlag;
	}

	public String getUnitProperties() {
		return unitProperties;
	}

	public void setUnitProperties(String unitProperties) {
		this.unitProperties = unitProperties;
	}

	public String getCentralizedType() {
		return centralizedType;
	}

	public void setCentralizedType(String centralizedType) {
		this.centralizedType = centralizedType;
	}

	public String getIntellectualProperty() {
		return intellectualProperty;
	}

	public void setIntellectualProperty(String intellectualProperty) {
		this.intellectualProperty = intellectualProperty;
	}

	public String getTechnicalFisld1() {
		return technicalFisld1;
	}

	public void setTechnicalFisld1(String technicalFisld1) {
		this.technicalFisld1 = technicalFisld1;
	}

	public String getTechnicalFisld2() {
		return technicalFisld2;
	}

	public void setTechnicalFisld2(String technicalFisld2) {
		this.technicalFisld2 = technicalFisld2;
	}

	public String getTechnicalFisld3() {
		return technicalFisld3;
	}

	public void setTechnicalFisld3(String technicalFisld3) {
		this.technicalFisld3 = technicalFisld3;
	}

	public String getTechnologySource() {
		return technologySource;
	}

	public void setTechnologySource(String technologySource) {
		this.technologySource = technologySource;
	}

	public String getRegionId1() {
		return regionId1;
	}

	public void setRegionId1(String regionId1) {
		this.regionId1 = regionId1;
	}

	public String getRegionId2() {
		return regionId2;
	}

	public void setRegionId2(String regionId2) {
		this.regionId2 = regionId2;
	}

	public String getRegionId3() {
		return regionId3;
	}

	public void setRegionId3(String regionId3) {
		this.regionId3 = regionId3;
	}

	public String getIndustries1() {
		return industries1;
	}

	public void setIndustries1(String industries1) {
		this.industries1 = industries1;
	}

	public String getIndustries2() {
		return industries2;
	}

	public void setIndustries2(String industries2) {
		this.industries2 = industries2;
	}

	public String getIndustries3() {
		return industries3;
	}

	public void setIndustries3(String industries3) {
		this.industries3 = industries3;
	}

	public String getIndustries4() {
		return industries4;
	}

	public void setIndustries4(String industries4) {
		this.industries4 = industries4;
	}

	public String getTypeId1() {
		return typeId1;
	}

	public void setTypeId1(String typeId1) {
		this.typeId1 = typeId1;
	}

	public String getTypeId2() {
		return typeId2;
	}

	public void setTypeId2(String typeId2) {
		this.typeId2 = typeId2;
	}

	public String getTypeId3() {
		return typeId3;
	}

	public void setTypeId3(String typeId3) {
		this.typeId3 = typeId3;
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

	public List<Map<String, Object>> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<Map<String, Object>> columnList) {
		this.columnList = columnList;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}


	public void setColumnName1(List<String> columnName1) {
		this.columnName1 = columnName1;
	}

	public List<String> getColumnName1() {
		return columnName1;
	}
	
}


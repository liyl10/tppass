/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.statistics.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.statistics.dao.StatisticsProjectIndustryDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.view.VprojectCountdatasIn;

/**
 * @comments 产业处项目统计
 * @author wanglw
 * @date 2013-11-13 @time 下午2:01:24
 * @Version 1.0
 */
@Repository
public class StatisticsProjectIndustryDaoImpl extends BaseDaoImpl<VprojectCountdatasIn, String> implements StatisticsProjectIndustryDao{

	/**
	 * @comments 取得产业处项目列表
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getProjectList(Map<String, Object> param, int pageNo, int pageSize){
		// 创建Finder查询对象
		
		String hql = this.createProjectHql(param);
		
		Finder f = Finder.create(hql);
		
		// 排序条件
		// f.append("");
		
		Pager p = super.find(f, pageNo, pageSize);
		
		// 查询、返回
		return p;
	}
	
	/**
	 * @comments 产业处项目sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createProjectHql(Map<String, Object> param){
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from VprojectCountdatasIn t where 1=1 ");
		
		// 项目名称
	    String projectName = (String) param.get("projectName");
	    if (!isNullString(projectName)) {
			hql.append(" and t.projectName like '%" + projectName.trim() + "%'");
		}
	    
	    // 单位地址
	    String unitAddress = (String) param.get("unitAddress");
	    if (!isNullString(unitAddress)) {
			hql.append(" and t.unitAddress like '%" + unitAddress.trim() + "%'");
		}
	    
	    // 申报单位
	    String applicationUnit = (String) param.get("applicationUnit");
	    if (!isNullString(applicationUnit)) {
			hql.append(" and t.applicationUnit like '%" + applicationUnit.trim() + "%'");
		}
	    
	    // 协作单位
	    String assistUnit = (String) param.get("assistUnit");
	    if (!isNullString(assistUnit)) {
			hql.append(" and t.assistUnit like '%" + assistUnit.trim() + "%'");
			hql.append(" or t.assistUnit1 like '%" + assistUnit.trim() + "%'");
		}
	    
	    // 申报年度
	    String reportYear = (String) param.get("reportYear");
	    if (!isNullString(reportYear)) {
			hql.append(" and t.reportYear = '" + reportYear.trim() + "'");
		}
	    
	    // 单位性质
	    String unitProperties = (String) param.get("unitProperties");
	    if (!isNullString(unitProperties)) {
			hql.append(" and t.unitPropertiesCode = '" + unitProperties.trim() + "'");
		}
	    
	    // 归口管理部门
	    String centralizedType = (String) param.get("centralizedType");
	    if (!isNullString(centralizedType)) {
			hql.append(" and t.centralizedTypeCode = '" + centralizedType.trim() + "'");
		}
	    
	    // 知识产权状况
	    String intellectualProperty = (String) param.get("intellectualProperty");
	    if (!isNullString(intellectualProperty)) {
			hql.append(" and t.intellectualPropertyCode = '" + intellectualProperty.trim() + "'");
		}
	    
	    // 技术领域
	    String technicalFisld1 = (String) param.get("technicalFisld1");
	    if (!isNullString(technicalFisld1)) {
			hql.append(" and t.technicalFisld1Code = '" + technicalFisld1.trim() + "'");
		}
	    
	    // 技术领域
	    String technicalFisld2 = (String) param.get("technicalFisld2");
	    if (!isNullString(technicalFisld2)) {
			hql.append(" and t.technicalFisld2Code = '" + technicalFisld2.trim() + "'");
		}
	    
	    // 技术领域
	    String technicalFisld3 = (String) param.get("technicalFisld3");
	    if (!isNullString(technicalFisld3)) {
			hql.append(" and t.technicalFisld3Code = '" + technicalFisld3.trim() + "'");
		}
	    
	    // 技术来源
	    String technologySource = (String) param.get("technologySource");
	    if (!isNullString(technologySource)) {
			hql.append(" and t.technologySourceCode = '" + technologySource.trim() + "'");
		}
	    
	    // 所在区域
	    String regionId1 = (String) param.get("regionId1");
	    if (!isNullString(regionId1)) {
			hql.append(" and t.regionId1Code = '" + regionId1.trim() + "'");
		}
	    
	    // 所在区域
	    String regionId2 = (String) param.get("regionId2");
	    if (!isNullString(regionId2)) {
			hql.append(" and t.regionId2Code = '" + regionId2.trim() + "'");
		}
	    
	    // 所在区域
	    String regionId3 = (String) param.get("regionId3");
	    if (!isNullString(regionId3)) {
			hql.append(" and t.regionId3Code = '" + regionId3.trim() + "'");
		}
	    
	    // 行业领域
	    String industries1 = (String) param.get("industries1");
	    if (!isNullString(industries1)) {
			hql.append(" and t.industries1Code = '" + industries1.trim() + "'");
		}
	    
	    // 行业领域
	    String industries2 = (String) param.get("industries2");
	    if (!isNullString(industries2)) {
			hql.append(" and t.industries2Code = '" + industries2.trim() + "'");
		}
	    
	    // 行业领域
	    String industries3 = (String) param.get("industries3");
	    if (!isNullString(industries3)) {
			hql.append(" and t.industries3Code = '" + industries3.trim() + "'");
		}
	    
	    // 行业领域
	    String industries4 = (String) param.get("industries4");
	    if (!isNullString(industries4)) {
			hql.append(" and t.industries4Code = '" + industries4.trim() + "'");
		}
	    
	    // 计划分类
	    String typeId2 = (String) param.get("typeId2");
	    if (!isNullString(typeId2)) {
			hql.append(" and t.planFlagCode = '" + typeId2.trim() + "'");
			
		}
	    else{
	    	String departmentId = (String) param.get("departmentId");
	    	if (!isNullString(departmentId)) {
	    		
	    		// 计财处
	    		if(Constants.PLANNING_DEPARTMENT.equals(departmentId)){
	    			
	    		}
	    		else{
	    			// 管理员及专员
	    			String projectTypeString = (String) param.get("projectTypeString");
	    			if (!isNullString(projectTypeString)) {
	    				hql.append(" and t.typeIdCode in (" + projectTypeString.trim() + ")");
	    			}
	    		}
	    	}
	    }
	    
	    // 项目分类
	    String typeId3 = (String) param.get("typeId3");
	    if (!isNullString(typeId3)) {
			hql.append(" and t.typeIdCode = '" + typeId3.trim() + "'");
		}
	    
	    return hql.toString();
	}
	
	
	/**
	 * @comments 取得列名
	 * @return
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<Object> queryInfoBySql(){
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select a.column_name,a.comments from user_col_comments a ,all_tab_columns b ");
		sql.append(" WHERE a.table_name = b.table_name ");
		sql.append(" and a.column_name = b.column_name ");
		sql.append(" and a.comments  is not null ");
		sql.append(" and a.table_name='V_PROJECT_COUNTDATAS_IN' ");
		sql.append(" order by b.column_id asc");
		
    	// 创建Query 对象
		Query query = getSession().createSQLQuery(sql.toString());
		
		// 接收返回结果
		List<Object> list = query.list();
    	return list;
		
	}
	
	/**
	 * @comments 取得需要导出的列名
	 * @return
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getColumnName(String columnName){
		StringBuilder sql = new StringBuilder();
		sql.append(" select a.comments from user_col_comments a ,all_tab_columns b ");
		sql.append(" WHERE a.table_name = b.table_name ");
		sql.append(" and a.column_name = b.column_name ");
		sql.append(" and a.comments  is not null ");
		sql.append(" and a.table_name='V_PROJECT_COUNTDATAS_IN' ");
		String col = columnName.replaceAll(",", "','");
		sql.append(" and a.column_name in('" + col +"')");
		sql.append(" order by b.column_id asc");
		
    	// 创建Query 对象
		Query query = getSession().createSQLQuery(sql.toString());
		
		// 接收返回结果
		List<Object> list = query.list();
    	return list;
	}
	
	/**
	 * @comments 取得项目列表
	 * @param param
	 * @param columnName
	 * @return
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getProjectList(Map<String, Object> param, String columnName){
		
		String hql = this.createProjectHql(param, columnName);
		
		// 创建Query 对象
		Query query = getSession().createSQLQuery(hql);
		
		// 接收返回结果
		List<Object> list = query.list();
    	return list;
	}
	
	/**
	 * @comments 产业处项目sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createProjectHql(Map<String, Object> param, String columnName){
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" select " + columnName);
		hql.append(" from v_project_countdatas_in where 1=1 ");
		
		// 项目名称
	    String projectName = (String) param.get("projectName");
	    if (!isNullString(projectName)) {
			hql.append(" and project_name like '%" + projectName.trim() + "%'");
		}
	    
	    // 单位地址
	    String unitAddress = (String) param.get("unitAddress");
	    if (!isNullString(unitAddress)) {
			hql.append(" and unit_address like '%" + unitAddress.trim() + "%'");
		}
	    
	    // 申报单位
	    String applicationUnit = (String) param.get("applicationUnit");
	    if (!isNullString(applicationUnit)) {
			hql.append(" and application_unit like '%" + applicationUnit.trim() + "%'");
		}
	    
	    // 协作单位
	    String assistUnit = (String) param.get("assistUnit");
	    if (!isNullString(assistUnit)) {
			hql.append(" and assist_unit like '%" + assistUnit.trim() + "%'");
			hql.append(" or assist_unit1 like '%" + assistUnit.trim() + "%'");
		}
	    
	    // 申报年度
	    String reportYear = (String) param.get("reportYear");
	    if (!isNullString(reportYear)) {
			hql.append(" and report_year = '" + reportYear.trim() + "'");
		}
	    
	    // 单位性质
	    String unitProperties = (String) param.get("unitProperties");
	    if (!isNullString(unitProperties)) {
			hql.append(" and unit_properties_code = '" + unitProperties.trim() + "'");
		}
	    
	    // 归口管理部门
	    String centralizedType = (String) param.get("centralizedType");
	    if (!isNullString(centralizedType)) {
			hql.append(" and centralized_type_code = '" + centralizedType.trim() + "'");
		}
	    
	    // 知识产权状况
	    String intellectualProperty = (String) param.get("intellectualProperty");
	    if (!isNullString(intellectualProperty)) {
			hql.append(" and intellectual_property_code = '" + intellectualProperty.trim() + "'");
		}
	    
	    // 技术领域
	    String technicalFisld1 = (String) param.get("technicalFisld1");
	    if (!isNullString(technicalFisld1)) {
			hql.append(" and technical_fisld_1_code = '" + technicalFisld1.trim() + "'");
		}
	    
	    // 技术领域
	    String technicalFisld2 = (String) param.get("technicalFisld2");
	    if (!isNullString(technicalFisld2)) {
			hql.append(" and technical_fisld_2_code = '" + technicalFisld2.trim() + "'");
		}
	    
	    // 技术领域
	    String technicalFisld3 = (String) param.get("technicalFisld3");
	    if (!isNullString(technicalFisld3)) {
			hql.append(" and technical_fisld_3_code = '" + technicalFisld3.trim() + "'");
		}
	    
	    // 技术来源
	    String technologySource = (String) param.get("technologySource");
	    if (!isNullString(technologySource)) {
			hql.append(" and technology_source_code = '" + technologySource.trim() + "'");
		}
	    
	    // 所在区域
	    String regionId1 = (String) param.get("regionId1");
	    if (!isNullString(regionId1)) {
			hql.append(" and region_id_1_code = '" + regionId1.trim() + "'");
		}
	    
	    // 所在区域
	    String regionId2 = (String) param.get("regionId2");
	    if (!isNullString(regionId2)) {
			hql.append(" and region_id_2_code = '" + regionId2.trim() + "'");
		}
	    
	    // 所在区域
	    String regionId3 = (String) param.get("regionId3");
	    if (!isNullString(regionId3)) {
			hql.append(" and region_id_3_code = '" + regionId3.trim() + "'");
		}
	    
	    // 行业领域
	    String industries1 = (String) param.get("industries1");
	    if (!isNullString(industries1)) {
			hql.append(" and industries_1_code = '" + industries1.trim() + "'");
		}
	    
	    // 行业领域
	    String industries2 = (String) param.get("industries2");
	    if (!isNullString(industries2)) {
			hql.append(" and industries_2_code = '" + industries2.trim() + "'");
		}
	    
	    // 行业领域
	    String industries3 = (String) param.get("industries3");
	    if (!isNullString(industries3)) {
			hql.append(" and industries_3_code = '" + industries3.trim() + "'");
		}
	    
	    // 行业领域
	    String industries4 = (String) param.get("industries4");
	    if (!isNullString(industries4)) {
			hql.append(" and industries_4_code = '" + industries4.trim() + "'");
		}
	    
	    // 计划分类
	    String typeId2 = (String) param.get("typeId2");
	    if (!isNullString(typeId2)) {
			hql.append(" and plan_flag_code = '" + typeId2.trim() + "'");
			
		}
	    else{
	    	String departmentId = (String) param.get("departmentId");
	    	if (!isNullString(departmentId)) {
	    		
	    		// 计财处
	    		if(Constants.PLANNING_DEPARTMENT.equals(departmentId)){
	    			
	    		}
	    		else{
	    			// 管理员及专员
	    			String projectTypeString = (String) param.get("projectTypeString");
	    			if (!isNullString(projectTypeString)) {
	    				hql.append(" and type_id_code in (" + projectTypeString.trim() + ")");
	    			}
	    		}
	    	}
	    }
	    
	    // 项目分类
	    String typeId3 = (String) param.get("typeId3");
	    if (!isNullString(typeId3)) {
			hql.append(" and type_id_code = '" + typeId3.trim() + "'");
		}
	    
	    return hql.toString();
	}
	
	/**
	 * @comments 类型判断
	 * @param valueStr
	 * @return
	 * @Version 1.0
	 */
	private boolean isNullString(String valueStr) {
		if (valueStr != null && valueStr.length() > 0) {
			return false;
		} else {
			return true;
		}
	}
}


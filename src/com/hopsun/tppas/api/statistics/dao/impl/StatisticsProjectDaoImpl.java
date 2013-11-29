package com.hopsun.tppas.api.statistics.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.statistics.dao.StatisticsProjectDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.view.VprojectInfoAll;
/**
 * @Comments:   后台Dao实现类-主要用来实现项目统计操作的接口
 * @author  lihf
 * @date 2013-08-01
 * @version 1.0
 *
 */
@Repository
public class StatisticsProjectDaoImpl extends BaseDaoImpl<VprojectInfoAll, String> implements StatisticsProjectDao {
	
	/**
	 * @comments 项目查询
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager queryProjectInfo(Map<String, Object> param, int pageNo, int pageSize){
		//创建Finder查询对象
		Finder f = Finder.create(" from VprojectInfoAll vpi where vpi.deleteFlag=:deleteFlag");
		// 流程状态 ≠ 开始
		f.append(" and vpi.flowStatus not in ('" + Constants.FLOW_STATUS_START + "')");
		
	    // 项目分类
	    String typeId2 = (String) param.get("typeId2");
	    if (!isNullString(typeId2)) {
			f.append(" and vpi.planFlag = '" + typeId2.trim() + "'");
		}
	    String typeId3 = (String) param.get("typeId3");
	    if (!isNullString(typeId3)) {
			f.append(" and vpi.typeId = '" + typeId3.trim() + "'");
		}
	    
		// 部门ID
		String planningFlag = (String) param.get("planningFlag");
	    if (!isNullString(planningFlag) && "1".equals(planningFlag)) {
	    	String typeId1 = (String) param.get("typeId1");
		    if (!isNullString(typeId1)) {
		    	f.append(" and vpi.deptId = '" + typeId1.trim() + "'");
		    }
		} 
	    else {
		    //专员小分类
		    String jhlb = (String) param.get("jhlb");
		    if (!isNullString(jhlb)) {
				f.append(" and vpi.typeId in (" + jhlb.trim() + ")");
			}
		}
		// 项目名称
	    String projectName = (String) param.get("projectName");
	    if (!isNullString(projectName)) {
			f.append(" and vpi.projectName like '%" + projectName.trim() + "%'");
		}
	    // 承担单位
	    String applicationUnit = (String) param.get("applicationUnit");
	    if (!isNullString(applicationUnit)) {
			f.append(" and vpi.applicationUnit like '%" + applicationUnit.trim() + "%'");
		}
	    // 归口管理部门
	    String centralizedType = (String) param.get("centralizedType");
	    if (!isNullString(centralizedType)) {
			f.append(" and vpi.centralizedType = '" + centralizedType.trim() + "'");
		}
	    // 申报年度
	    String reportYear = (String) param.get("reportYear");
	    if (!isNullString(reportYear)) {
			f.append(" and vpi.reportYear = '" + reportYear.trim() + "'");
		}

	    
	    // 所在区域
	    String regionId1 = (String) param.get("regionId1");
	    if (!isNullString(regionId1)) {
			f.append(" and vpi.regionId1 = '" + regionId1.trim() + "'");
		}
	    String regionId2 = (String) param.get("regionId2");
	    if (!isNullString(regionId2)) {
			f.append(" and vpi.regionId2 = '" + regionId2.trim() + "'");
		}
	    String regionId3 = (String) param.get("regionId3");
	    if (!isNullString(regionId3)) {
			f.append(" and vpi.regionId3 = '" + regionId3.trim() + "'");
		}
	    // 单位地址
	    String unitAddress = (String) param.get("unitAddress");
	    if (!isNullString(unitAddress)) {
			f.append(" and vpi.unitAddress like '%" + unitAddress.trim() + "%'");
		}
	    // 行业分类
	    String industries1 = (String) param.get("industries1");
	    if (!isNullString(industries1)) {
			f.append(" and vpi.industries1 = '" + industries1.trim() + "'");
		}
	    String industries2 = (String) param.get("industries2");
	    if (!isNullString(industries2)) {
			f.append(" and vpi.industries2 = '" + industries2.trim() + "'");
		}
	    String industries3 = (String) param.get("industries3");
	    if (!isNullString(industries3)) {
			f.append(" and vpi.industries3 = '" + industries3.trim() + "'");
		}
	    String industries4 = (String) param.get("industries4");
	    if (!isNullString(industries4)) {
			f.append(" and vpi.industries4 = '" + industries4.trim() + "'");
		}
	    // 单位性质
	    String unitProperties = (String) param.get("unitProperties");
	    if (!isNullString(unitProperties)) {
			f.append(" and vpi.unitProperties = '" + unitProperties.trim() + "'");
		}
	    // 项目主要协作单位
	    String assistUnit = (String) param.get("assistUnit");
	    if (!isNullString(assistUnit)) {
			f.append(" and vpi.assistUnit like '%" + assistUnit.trim() + "%'");
		}
	    // 项目所属技术领域
	    String technicalFisld1 = (String) param.get("technicalFisld1");
	    if (!isNullString(technicalFisld1)) {
			f.append(" and vpi.technicalFisld1 = '" + technicalFisld1.trim() + "'");
		}
	    String technicalFisld2 = (String) param.get("technicalFisld2");
	    if (!isNullString(technicalFisld2)) {
			f.append(" and vpi.technicalFisld2 = '" + technicalFisld2.trim() + "'");
		}
	    String technicalFisld3 = (String) param.get("technicalFisld3");
	    if (!isNullString(technicalFisld3)) {
			f.append(" and vpi.technicalFisld3 = '" + technicalFisld3.trim() + "'");
		}
	    
	    // 知识产权状况
	    String intellectualProperty = (String) param.get("intellectualProperty");
	    if (!isNullString(intellectualProperty)) {
			f.append(" and vpi.intellectualProperty = '" + intellectualProperty.trim() + "'");
		}
	    // 技术来源
	    String technologySource = (String) param.get("technologySource");
	    if (!isNullString(technologySource)) {
			f.append(" and vpi.technologySource = '" + technologySource.trim() + "'");
		}
	    //部门
		f.append(" and vpi.deptId <> '" + Constants.HIGHTECH_DEPARTMENT + "'");
		
		f.append(" order by vpi.createTime desc");
		
		f.setParam("deleteFlag", Constants.COMMON_STATE_NOTDELETE);
		
		return super.find(f, pageNo, pageSize);
	}
	
	/**
     * @comments 取得表的属性
     * @param sql
     * @param params
     * @return
     * @Version 1.0
     */
	@SuppressWarnings("unchecked")
    public List<Object> getTableInfo(Object[] params){
    	StringBuilder sql = new StringBuilder();
		sql.append(" select a.table_name,a.column_name,a.comments comments, b.column_id");
		sql.append(" from user_col_comments a ,all_tab_columns b");
		sql.append(" where a.table_name = b.table_name");
		sql.append(" and a.column_name = b.column_name");
		if (params != null && params.length > 0) {
			sql.append(" and (a.table_name = '");
			sql.append(params[0] + "'");
			for (int i = 1; i < params.length; i++) {
				sql.append(" or a.table_name = '");
				sql.append(params[i] + "'");
			}
			sql.append(")");
		}
		sql.append("order by a.table_name asc, b.column_id asc");
		
    	// 创建Query 对象
		Query query = getSession().createSQLQuery(sql.toString());
		
		// 接收返回结果
		List<Object> list = query.list();

    	return list;
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
	
    /**
     * @comments 查询信息
     * @param hql
     * @return List
     * @Version 1.0
     */
	@SuppressWarnings("unchecked")
    public List<Object> queryListinfo(Map<String, Object> param){
    	
		StringBuilder hql = new StringBuilder(
				" from TprojectApplication t1, TprojectInfoB t2, ");
		hql.append(" TreportAbstractB t3, TcompanyNeedB t4, TcompanyFoundationB t5, ");
		hql.append(" TschedulingA t6, TexpectedResults t7, TtechnicalIndexes t8, ");
		hql.append(" TeconomicIndicatorB t9, TeconomicIndicatorA t10, TcostEstimateB t11, ");
		hql.append(" TfundPlanB t12, TfundingPlanReport t13, ");
		hql.append(" TcompanyInfo t14, TreviewComments t15");
		hql.append(" where t1.projectId = t2.tprojectApplication.projectId");
		hql.append(" and t1.projectId = t3.tprojectApplication.projectId ");
		hql.append(" and t1.projectId = t4.tprojectApplication.projectId ");
		hql.append(" and t1.projectId = t5.tprojectApplication.projectId");
		hql.append(" and t1.projectId = t6.tprojectApplication.projectId ");
		hql.append(" and t1.projectId = t7.tprojectApplication.projectId ");
		hql.append(" and t1.projectId = t8.tprojectApplication.projectId ");
		hql.append(" and t1.projectId = t9.tprojectApplication.projectId ");
		// 新加
		hql.append(" and t1.projectId = t10.tprojectApplication.projectId ");
		hql.append(" and t1.projectId = t11.tprojectApplication.projectId ");
		hql.append(" and t1.projectId = t12.tprojectApplication.projectId ");
		hql.append(" and t1.projectId = t13.tprojectApplication.projectId ");
		hql.append(" and t1.projectId = t14.tprojectApplication.projectId ");
		hql.append(" and t1.projectId = t15.tprojectApplication.projectId ");
		
		hql.append(getConditionDate(param));
    	// 创建Finder查询对象
    	Finder f = Finder.create(hql.toString());
    	// 执行操作返回结果集
		List<Object> list = super.find(f);
    	
    	return list;
    }
	
	/**
	 * @comments 查询条件
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private StringBuilder getConditionDate(Map<String, Object> param) {
		StringBuilder hql = new StringBuilder();

		// 项目名称
		String projectName = (String) param.get("projectName");
		if (isNotNullOrEmpty(projectName)) {
			hql.append(" and t1.projectName like '%" + projectName + "%'");
		}
		// 申报单位
		String applicationUnit = (String) param.get("applicationUnit");
		if (isNotNullOrEmpty(applicationUnit)) {
			hql.append(" and t1.applicationUnit like '%" + applicationUnit
					+ "%'");
		}
		// 单位地址
		String unitAddress = (String) param.get("unitAddress");
		if (isNotNullOrEmpty(unitAddress)) {
			hql.append(" and t2.unitAddress like '%" + unitAddress + "%'");
		}
		//申报年度
		String reportYear = (String) param.get("reportYear");
		if (isNotNullOrEmpty(reportYear)) {
			hql.append(" and t1.reportYear like '%" + reportYear + "%'");
		}
		//项目主要协作单位
		String assistUnit = (String) param.get("assistUnit");
	    if (isNotNullOrEmpty(assistUnit)) {
	    	hql.append(" and t2.assistUnit like '%" + assistUnit + "%'");
		}
		// 归口部门
		String centralizedType = (String) param.get("centralizedType");
		if (isNotNullOrEmpty(centralizedType)) {
			hql.append(" and t1.centralizedType = '" + centralizedType + "'");
		}
		//单位性质
	    String unitProperties = (String) param.get("unitProperties");
	    if (isNotNullOrEmpty(unitProperties)) {
	    	hql.append(" and t2.unitProperties = '" + unitProperties + "'");
		}
		//单位所属行业领域
	    String technicalFisld1 = (String) param.get("technicalFisld1");
	    if (isNotNullOrEmpty(technicalFisld1)) {
	    	hql.append(" and t2.technicalFisld1 = '" + technicalFisld1 + "'");
		}
	    String technicalFisld2 = (String) param.get("technicalFisld2");
	    if (isNotNullOrEmpty(technicalFisld2)) {
	    	hql.append(" and t2.technicalFisld2 = '" + technicalFisld2 + "'");
		}
	    String technicalFisld3 = (String) param.get("technicalFisld3");
	    if (isNotNullOrEmpty(technicalFisld3)) {
	    	hql.append(" and t2.technicalFisld3 = '" + technicalFisld3 + "'");
		}
	    //知识产权状况
	    String intellectualProperty = (String) param.get("intellectualProperty");
	    if (isNotNullOrEmpty(intellectualProperty)) {
	    	hql.append(" and t2.intellectualProperty = '" + intellectualProperty + "'");
		}
	    //项目分类
	    String typeId2 = (String) param.get("typeId2");
	    if (isNotNullOrEmpty(typeId2)) {
	    	hql.append(" and t1.planFlag = '" + typeId2 + "'");
		}
	    String typeId3 = (String) param.get("typeId3");
	    if (isNotNullOrEmpty(typeId3)) {
	    	hql.append(" and t1.tprojectType.typeId = '" + typeId3 + "'");
		}
	    
	    //技术来源
	    String technologySource = (String) param.get("technologySource");
	    if (isNotNullOrEmpty(technologySource)) {
	    	hql.append(" and t2.technologySource = '" + technologySource + "'");
		}
	    //所在区域
	    String regionId1 = (String) param.get("regionId1");
	    if (isNotNullOrEmpty(regionId1)) {
	    	hql.append(" and t2.regionId1 = '" + regionId1 + "'");
		}
	    String regionId2 = (String) param.get("regionId2");
	    if (isNotNullOrEmpty(regionId2)) {
	    	hql.append(" and t2.regionId2 = '" + regionId2 + "'");
		}
	    String regionId3 = (String) param.get("regionId3");
	    if (isNotNullOrEmpty(regionId3)) {
	    	hql.append(" and t2.regionId3 = '" + regionId3 + "'");
		}
	    //国民经济行业分类
	    String industries1 = (String) param.get("industries1");
	    if (isNotNullOrEmpty(industries1)) {
	    	hql.append(" and t2.industries1 = '" + industries1 + "'");
		}
	    String industries2 = (String) param.get("industries2");
	    if (isNotNullOrEmpty(industries2)) {
	    	hql.append(" and t2.industries2 = '" + industries2 + "'");
		}
	    String industries3 = (String) param.get("industries3");
	    if (isNotNullOrEmpty(industries3)) {
	    	hql.append(" and t2.industries3 = '" + industries3 + "'");
		}
	    String industries4 = (String) param.get("industries4");
	    if (isNotNullOrEmpty(industries4)) {
	    	hql.append(" and t2.industries4 = '" + industries4 + "'");
		}

	    
	    // 部门ID
		String planningFlag = (String) param.get("planningFlag");
	    if (isNotNullOrEmpty(planningFlag) && "1".equals(planningFlag)) {
	    	String typeId1 = (String) param.get("typeId1");
		    if (isNotNullOrEmpty(typeId1)) {
		    	hql.append(" and t1.tprojectType.departmentId = '" + typeId1.trim() + "'");
		    }
		} 
	    else {
		    //专员小分类
		    String jhlb = (String) param.get("jhlb");
		    if (isNotNullOrEmpty(jhlb)) {
		    	hql.append(" and t1.tprojectType.typeId in (" + jhlb + ")");
			}
		}
	    hql.append(" order by t1.createTime desc ");
	    
		return hql;
	}
	
	/**
	 * @comments 判断字符串是否为空
	 * @param obj
	 * @return
	 * @Version 1.0
	 */
	private Boolean isNotNullOrEmpty(Object obj) {

		if (!"".equals(obj) && obj != null) {
			return true;
		}
		return false;
	}
}

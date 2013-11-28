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
import com.hopsun.tppas.api.statistics.dao.VprojectResultCollectDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.view.VprojectResultCollect;

/**
 * 
 * @comments 项目结果汇总Dao实现类
 * @author liyilin
 * @date 2013-8-22
 * @version 1.0
 */
@Repository
public class VprojectResultCollectDaoImpl extends
		BaseDaoImpl<VprojectResultCollect, String> implements
		VprojectResultCollectDao {

	/**
	 * @comments 分页查询
	 * @param sql
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager find(String hql, int pageNo, int pageSize) {

		// 创建Finder查询对象
		Finder f = Finder.create(hql.toString());

		Pager p = super.find(f, pageNo, pageSize);

		return p;
	}

	/**
	 * 根据检索条件取得分页数据
	 */
	@Override
	public Pager find(Map<String, Object> param, int pageNo, int pageSize) {

		// 作成Finder
		Finder f = Finder.create(createHql(param));

		// 分页查询
		Pager p = super.find(f, pageNo, pageSize);
		// 返回查询结果
		return p;
	}

	/**
	 * 
	 * @comments 作成Hql字符串
	 * @param param
	 * @return
	 * @version 1.0
	 */
	private String createHql(Map<String, Object> param) {
		StringBuilder hql = new StringBuilder();
		hql.append(" from VprojectResultCollect c ");
		hql.append(" where 1=1 ");
		// 用户所在部门ID
		String userDeptId = param.get("userDeptId").toString();
		// 如果用户所在部门为计财处，则查询所有部门的项目
		// 如果用户所在部门为计财处以外的部门，只能查询本部门的项目
		Boolean isPlanningDept = Constants.PLANNING_DEPARTMENT
				.equals(userDeptId);
		if (notIsNullString(userDeptId) && !isPlanningDept) {
			hql.append(" and c.departmentId='");
			hql.append(userDeptId.trim());
			hql.append("'");
		}

		// 申报年度
		String reportYear = param.get("reportYear").toString();
		if (notIsNullString(reportYear)) {
			hql.append(" and c.reportYear='");
			hql.append(reportYear.trim());
			hql.append("'");
		}

		// 计财处用户根据选择的部门ID查询
		if (isPlanningDept) {
			// 部门ID
			String selectedDeptId = "";
			if(param.containsKey("selectedDeptId")){
				selectedDeptId = param.get("selectedDeptId").toString();
			}
			if (notIsNullString(selectedDeptId)) {
				hql.append(" and c.departmentId='");
				hql.append(selectedDeptId.trim());
				hql.append("'");
			}
			// 项目父分类（一级）
			String parentProjectType = "";
			if(param.containsKey("parentProjectType")){
				parentProjectType = param.get("parentProjectType").toString();
			}
			if (notIsNullString(parentProjectType)) {
				hql.append(" and c.parentTypeId='");
				hql.append(parentProjectType.trim());
				hql.append("'");
			}
			// 项目子分类（二级）
			String sonProjectType = "";
			if(param.containsKey("sonProjectType")){
				sonProjectType = param.get("sonProjectType").toString();
			}
			if (notIsNullString(sonProjectType)) {
				hql.append(" and c.typeId='");
				hql.append(sonProjectType.trim());
				hql.append("'");
			}
		}
		// 业务处室根据项目分类查询
		else {
			// 项目子分类（二级）
			String sonProjectType = "";
			if(param.containsKey("sonProjectType")){
				sonProjectType = param.get("sonProjectType").toString();
			}
			if (notIsNullString(sonProjectType)) {
				hql.append(" and c.typeId='");
				hql.append(sonProjectType.trim());
				hql.append("'");
			}else{
				// 项目父分类（一级）
				String parentProjectType = "";
				if(param.containsKey("parentProjectType")){
					parentProjectType = param.get("parentProjectType").toString();
				}
				if (notIsNullString(parentProjectType)) {
					hql.append(" and c.parentTypeId='");
					hql.append(parentProjectType.trim());
					hql.append("'");
				}else{
					String projectTypeStr = "";
					if(param.containsKey("projectTypeStr")){
						projectTypeStr = param.get("projectTypeStr").toString();
					}
					if (notIsNullString(projectTypeStr)) {
						hql.append(" and c.typeId in (" + projectTypeStr.trim() + ")");
					}
				}
			}
		}
		// 项目名称
		String projectName = "";
		if(param.containsKey("projectName")){
			projectName = param.get("projectName").toString();
		}
		if (notIsNullString(projectName)) {
			hql.append(" and c.projectName like '%");
			hql.append(projectName.trim());
			hql.append("%'");
		}
		// 申报单位
		String applicationUnit = "";
		if(param.containsKey("applicationUnit")){
			applicationUnit = param.get("applicationUnit").toString();
		}
		if (notIsNullString(applicationUnit)) {
			hql.append(" and c.applicationUnit like '%");
			hql.append(applicationUnit.trim());
			hql.append("%'");
		}
		
		// 所属园区
		String centralizedType = "";
		if(param.containsKey("centralizedType")){
			centralizedType = param.get("centralizedType").toString();
		}
		if (notIsNullString(centralizedType)) {
			hql.append(" and c.centralizedTypeId='");
			hql.append(centralizedType.trim());
			hql.append("'");
		}
		
		hql.append(" order by c.createTime desc");
		return hql.toString();
	}

	/**
	 * @comments 通过SQL语句查询信息
	 * @param sql
	 * @param params
	 * @return
	 * @Version 1.0
	 */
	public List<Object> queryInfoBySql(Object[] params) {
		/*
		 * StringBuilder sql = new StringBuilder(); sql.append(
		 * " select a.table_name,a.column_name,a.comments comments, b.column_id from user_col_comments a ,all_tab_columns b "
		 * ); sql.append(" WHERE a.table_name = b.table_name and ");
		 * sql.append(" a.column_name = b.column_name and( "); if (params !=
		 * null && params.length > 0) { sql.append("  a.table_name = '");
		 * sql.append(params[0] + "'"); for (int i = 1; i < params.length; i++)
		 * { sql.append(" or a.table_name = '"); sql.append(params[i] + "'"); }
		 * sql.append(")"); }
		 * sql.append("order by a.table_name asc, b.column_id asc");
		 * 
		 * // 创建Query 对象 Query query =
		 * getSession().createSQLQuery(sql.toString());
		 * 
		 * // 接收返回结果 List<Object> list = query.list();
		 */

		return null;
	}

	/**
	 * @comments 查询信息
	 * @param hql
	 * @return List
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<Object> queryListinfo(String hql) {

		// 创建Finder查询对象
		Finder f = Finder.create(hql);
		// 执行操作返回结果集
		List<Object> list = super.find(f);

		return list;
	}

	/**
	 * 查询申报年度List
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getReportYearList() {
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct a.reportYear from VprojectResultCollect a order by a.reportYear asc");

		// 创建Query 对象
		Query query = getSession().createQuery(sql.toString());

		// 接收返回结果
		List<String> list = query.list();

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
	 * @comments 类型判断
	 * @param valueStr
	 * @return
	 * @Version 1.0
	 */
	private boolean notIsNullString(String valueStr) {
		return !this.isNullString(valueStr);
	}

	/**
	 * 根据检索条件取得所有的查询结果
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<VprojectResultCollect> getAllResultData(
			Map<String, Object> params) {
		// 创建Query查询对象
		Query query = getSession().createQuery(this.createHql(params));

		return query.list();
	}

	/**
	 * 查询条件只选择了一级项目分类时，查询该一级分类下的子分类个数
	 */
	@Override
	public int getGroupCount(Map<String, Object> params) {
		StringBuilder hql = new StringBuilder();
		hql.append("select count(c.typeId) from VprojectResultCollect c ");
		hql.append(" where 1=1 ");
		// 用户所在部门ID
		String userDeptId = params.get("userDeptId").toString();
		// 如果用户所在部门为计财处，则查询所有部门的项目
		// // 如果用户所在部门为计财处以外的部门，只能查询本部门的项目
		if (notIsNullString(userDeptId)
				&& !Constants.DEPTTYPE_TYPE.equals(userDeptId)) {
			hql.append(" and c.departmentId='");
			hql.append(userDeptId.trim());
			hql.append("'");
		}

		// 申报年度
		String reportYear = params.get("reportYear").toString();
		if (notIsNullString(reportYear)) {
			hql.append(" and c.reportYear='");
			hql.append(reportYear.trim());
			hql.append("'");
		}

		// 项目父分类（一级）
		String parentProjectType = params.get("parentProjectType").toString();
		if (notIsNullString(parentProjectType)) {
			hql.append(" and c.parentTypeId='");
			hql.append(parentProjectType.trim());
			hql.append("'");
		}
		hql.append(" group by c.typeId");
		// 创建Query查询对象
		Query query = getSession().createQuery(hql.toString());

		return Integer.parseInt(query.list().get(0).toString());
	}

	/**
	 * 查询子分类ID
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getGroupInfo(Map<String, Object> params) {
		StringBuilder hql = new StringBuilder();
		hql.append("select distinct c.typeId from VprojectResultCollect c ");

		hql.append(" where 1=1 ");
		// 用户所在部门ID
		String userDeptId = params.get("userDeptId").toString();
		// 是否为计财处用户
		Boolean isPlanningDept = Constants.PLANNING_DEPARTMENT
				.equals(userDeptId);
		// 如果用户所在部门为计财处，则查询所有部门的项目
		// // 如果用户所在部门为计财处以外的部门，只能查询本部门的项目
		if (notIsNullString(userDeptId) && !isPlanningDept) {
			hql.append(" and c.departmentId='");
			hql.append(userDeptId.trim());
			hql.append("'");
		}

		// 申报年度
		String reportYear = params.get("reportYear").toString();
		if (notIsNullString(reportYear)) {
			hql.append(" and c.reportYear='");
			hql.append(reportYear.trim());
			hql.append("'");
		}

		// 项目父分类（一级）
		String parentProjectType = "";
		if(params.containsKey("parentProjectType")){
			parentProjectType = params.get("parentProjectType").toString();
		}
		if (notIsNullString(parentProjectType)) {
			hql.append(" and c.parentTypeId='");
			hql.append(parentProjectType.trim());
			hql.append("'");
		}else{
			String typeIdStr = "";
			if(params.containsKey("projectTypeStr")){
				typeIdStr = (String) params.get("projectTypeStr");
			}
			if (!isNullString(typeIdStr)) {
				hql.append(" and c.typeId in (" + typeIdStr.trim() + ")");
			}
		}

		// 创建Query 对象
		Query query = getSession().createQuery(hql.toString());

		// 接收返回结果
		List<String> list = query.list();

		return list;
	}

	/**
	 * 取得业务部门的部门idList
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getDeptList(Map<String, Object> params) {

		StringBuilder hql = new StringBuilder();
		hql.append("select distinct c.departmentId from VprojectResultCollect c ");

		hql.append(" where 1=1 ");

		// 申报年度
		String reportYear = params.get("reportYear").toString();
		if (notIsNullString(reportYear)) {
			hql.append(" and c.reportYear='");
			hql.append(reportYear.trim());
			hql.append("'");
		}

		// 创建Query 对象
		Query query = getSession().createQuery(hql.toString());

		// 接收返回结果
		List<String> list = query.list();

		return list;

	}

	/**
	 * 取得业务部门的部门下计划类别
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getProjectTypeListByDeptId(Map<String, Object> params) {
		StringBuilder hql = new StringBuilder();
		hql.append("select distinct c.parentTypeId from VprojectResultCollect c ");

		hql.append(" where 1=1 ");

		// 申报年度
		String reportYear = params.get("reportYear").toString();
		if (notIsNullString(reportYear)) {
			hql.append(" and c.reportYear='");
			hql.append(reportYear.trim());
			hql.append("'");
		}
		
		// 部门id
		String deptId = params.get("selectedDeptId").toString();
		if (notIsNullString(deptId)) {
			hql.append(" and c.departmentId='");
			hql.append(deptId.trim());
			hql.append("'");
		}

		// 创建Query 对象
		Query query = getSession().createQuery(hql.toString());

		// 接收返回结果
		List<String> list = query.list();

		return list;
	}
}

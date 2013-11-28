/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.scenter.api.util.Constant;
import com.hopsun.tppas.api.report.dao.TprojectApplicationAuditDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TprojectApplication;

/**
 * @comments 项目评审
 * @author wanglw
 * @date 2013-9-10 @time 下午4:28:09
 * @Version 1.0
 */
@Repository
public class TprojectApplicationAuditDaoImpl extends BaseDaoImpl<TprojectApplication, String> implements TprojectApplicationAuditDao {
	
	
	/**
	 * @comments 取得项目审核数据
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getAuditExpertList(Map<String, Object> param, int pageNo, int pageSize){
		
		// 创建Finder查询对象
		
		String hql = this.createAuditExpertHql(param);
		
		Finder f = Finder.create(hql);
		
		// 排序条件
		f.append(" order by t.tprojectGroup.createTime desc , t.createTime desc");
		
		Pager p = super.find(f, pageNo, pageSize);
		
		// 查询、返回
		return p;
	}
	
	/**
	 * @comments 生成评审专家选择sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createAuditExpertHql(Map<String, Object> param){
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from TprojectApplication t, ");
		hql.append(" VprojectInfo v ");
		hql.append(" where t.projectId = v.projectId ");
		
		// 判断是否计财处用户
		boolean isPlanningUser = Boolean.parseBoolean(param.get("isPlanningUser").toString());
		// 部门ID
		/* String departmentId = (String) param.get("departmentId");
	    if (!isPlanningUser && !isNullString(departmentId)) {
	    	hql.append(" and t.tprojectGroup.departmentId = '" + departmentId.trim() + "'");
	    }*/
	    
		// 项目名称
	    String projectName = (String) param.get("projectName");
	    if (!isNullString(projectName)) {
			hql.append(" and t.projectName like '%" + projectName.trim() + "%'");
		}
	    
	    // 单位性质
	    String applyCompany = (String) param.get("applyCompany");
	    if (!isNullString(applyCompany)) {
	    	hql.append(" and t.applicationUnit like '%" + applyCompany.trim() + "%'");
	    }
	    
	    // 计划类别
	    String projectType1 = (String) param.get("projectType1");
	    if (!isNullString(projectType1)) {
	    	hql.append(" and t.planFlag = '" + projectType1.trim() + "'");
	    }
	    
	    // 计划类别
	    String projectType2 = (String) param.get("projectType2");
	    if (!isNullString(projectType2)) {
	    	hql.append(" and t.tprojectType.typeId = '" + projectType2.trim() + "'");
	    }
	    
	    // 审核状态
	    String auditStatus = (String) param.get("auditStatus");
	    if (!isNullString(auditStatus)) {
	    	hql.append(" and t.applyStatus = '" + auditStatus.trim() + "'");
	    }
	    
	    // 项目分组
	    String projectGroup = (String) param.get("projectGroup");
	    if (!isNullString(projectGroup)) {
	    	hql.append(" and t.tprojectGroup.groupId = '" + projectGroup.trim() + "'");
	    }else if(isPlanningUser){
	    	hql.append(" and t.tprojectGroup.groupId is not null ");
	    }
	    
	    // 子分类查询范围 in
	    String type1Str = (String) param.get("type1Str");
	    if (!isPlanningUser && !isNullString(type1Str)) {
	    	hql.append(" and t.tprojectType.typeId in (" + type1Str + ")");
	    }
	    
	    return hql.toString();
	}
	
	/**
	 * @comments 取得创建分组时取得的项目List
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getGroupSelectProjectList(Map<String, Object> param){
		
		List<Object>  list = new ArrayList<Object>();
		
		String sql = this.createGroupSelectProjectHql(param);
		
		Finder f = Finder.create(sql);
		
		// 排序条件
		f.append(" order by t.createTime desc");
		
		list = super.find(f);
		
		return list;
	}
	
	/**
	 * @comments 生成取得创建分组时取得的项目sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createGroupSelectProjectHql(Map<String, Object> param){
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from TprojectApplication t, ");
		hql.append(" VprojectInfo v ");
		hql.append(" where t.projectId = v.projectId ");
		// 部门ID
	    /*String departmentId = (String) param.get("departmentId");
	    if (!isNullString(departmentId)) {
	    	hql.append(" and t.tprojectGroup.departmentId = '" + departmentId.trim() + "'");
	    }*/
	    
		// 项目名称
	    String projectName = (String) param.get("projectName");
	    if (!isNullString(projectName)) {
			hql.append(" and t.projectName like '%" + projectName.trim() + "%'");
		}
	    
	    // 单位性质
	    String applyCompany = (String) param.get("applyCompany");
	    if (!isNullString(applyCompany)) {
	    	hql.append(" and t.applicationUnit like '%" + applyCompany.trim() + "%'");
	    }
	    
	   /* // 计划类别
	    String projectType1 = (String) param.get("projectType1");
	    if (!isNullString(projectType1)) {
	    	hql.append(" and t.planFlag = '" + projectType1.trim() + "'");
	    }*/
	    
	    // 计划类别
	    String projectType2 = (String) param.get("projectType2");
	    if (!isNullString(projectType2)) {
	    	hql.append(" and t.tprojectType.typeId = '" + projectType2.trim() + "'");
	    }
	    
	    // 审核状态
	    String auditStatus = (String) param.get("auditStatus");
	    if (!isNullString(auditStatus)) {
	    	hql.append(" and t.applyStatus = '" + auditStatus.trim() + "'");
	    }
	    
	    /*// 项目分组
	    String projectGroup = (String) param.get("projectGroup");
	    if (!isNullString(projectGroup)) {
	    	hql.append(" and t.tprojectGroup.groupId = '" + projectGroup.trim() + "'");
	    }*/
	    
	    // 项目分组Id(排除已选择的项目)
	    hql.append(" and t.tprojectGroup.groupId is null ");
	    /*String groupId = (String) param.get("groupId");
	    if (!isNullString(groupId)) {
	    	hql.append(" and t.tprojectGroup.groupId is null ");
	    }*/

	    return hql.toString();
	}
	
	/**
	 * @comments 取得新建项目分组选择的项目list
	 * @param groupId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getGroupSelectedProjectList(String groupId, int pageNo, int pageSize){
		
		// 创建Finder查询对象
		
		String hql = this.createGroupSelectedProjectListSql(groupId);
		
		Finder f = Finder.create(hql);
		
		// 排序条件
		f.append(" order by t.tprojectGroup.createTime desc, t.tprojectGroup.groupId desc");
		
		Pager p = super.find(f, pageNo, pageSize);
		
		// 查询、返回
		return p;
	}
	
	/**
	 * @comments 创建取得新建项目分组选择的项目sql
	 * @param groupId
	 * @return
	 * @Version 1.0
	 */
	private String  createGroupSelectedProjectListSql(String groupId){
		
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from TprojectApplication t, ");
		hql.append(" VprojectInfo v ");
		hql.append(" where t.projectId = v.projectId ");
		hql.append(" and t.tprojectGroup.groupId='" + groupId +"' ");
		return hql.toString();
	}
	
	/**
	 * @comments 取得项目审核数据
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getProjectAuditList(Map<String, Object> param, int pageNo, int pageSize) {
		//创建Finder查询对象
		
		String hql = this.createHql(param);
		
		Finder f = Finder.create(hql);
		
		//排序条件
		f.append(" order by t.tprojectGroup.createTime desc, t.tprojectGroup.groupId desc");
		
		Pager p = super.find(f, pageNo, pageSize);
		
		//查询、返回
		return p;
	}
	
	
	
	
	/**
	 * @comments 生成hql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createHql(Map<String, Object> param){
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from TprojectApplication t, ");
		hql.append(" VprojectInfo v ");
		hql.append(" where t.projectId = v.projectId ");
		// 部门ID
	    String departmentId = (String) param.get("departmentId");
	    if (!isNullString(departmentId)) {
	    	hql.append(" and t.tprojectGroup.departmentId = '" + departmentId.trim() + "'");
	    }
	    
		// 项目名称
	    String projectName = (String) param.get("projectName");
	    if (!isNullString(projectName)) {
			hql.append(" and t.projectName like '%" + projectName.trim() + "%'");
		}
	    
	    // 单位性质
	    String applyCompany = (String) param.get("applyCompany");
	    if (!isNullString(applyCompany)) {
	    	hql.append(" and t.applicationUnit like '%" + applyCompany.trim() + "%'");
	    }
	    
	    // 计划类别
	    String projectType1 = (String) param.get("projectType1");
	    if (!isNullString(projectType1)) {
	    	hql.append(" and t.planFlag = '" + projectType1.trim() + "'");
	    }
	    
	    // 计划类别
	    String projectType2 = (String) param.get("projectType2");
	    if (!isNullString(projectType2)) {
	    	hql.append(" and t.tprojectType.typeId = '" + projectType2.trim() + "'");
	    }
	    
	    // 审核状态
	    String auditStatus = (String) param.get("auditStatus");
	    if (!isNullString(auditStatus)) {
	    	hql.append(" and t.applyStatus = '" + auditStatus.trim() + "'");
	    }
	    
	    // 项目分组
	    String projectGroup = (String) param.get("projectGroup");
	    if (!isNullString(projectGroup)) {
	    	hql.append(" and t.tprojectGroup.groupId = '" + projectGroup.trim() + "'");
	    }

	    return hql.toString();
	}
	
	/**
	 * @comments 取得项目申报信息
	 * @param ProjectId
	 * @return
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> getProjectInfo(String projectId){
		
		// 创建Finder查询对象
		String hql = this.createHql(projectId);
		
		// 取得数据
		Finder f = Finder.create(hql);
		
		return super.find(f);
	}
	
	/**
	 * @comments 生成hql
	 * @param projectId
	 * @return
	 * @Version 1.0
	 */
	private String createHql(String projectId){
		
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from TprojectApplication t, ");
		hql.append(" VprojectInfo v ");
		hql.append(" where t.projectId = v.projectId ");
		// 项目Id
		hql.append(" and t.projectId = '" + projectId +"'");
		// 删除flag
		hql.append(" and t.deleteFlag = '" + Constant.DELETE_STATE_FALSE+ "'");
		
		return hql.toString();
	}
	
	
	/**
	 * @comments 取得分计划选择项目
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getBatchProjectList(Map<String, Object> param, int pageNo, int pageSize){
		
		// 创建Finder查询对象
		
		String hql = this.createBatchProjectHql(param);
		
		Finder f = Finder.create(hql);
		
		Pager p = super.find(f, pageNo, pageSize);
		
		// 查询、返回
		return p;
	}
	
	/**
	 * @comments 生成取得分计划选择项目sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createBatchProjectHql(Map<String, Object> param){
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from TprojectApplication t, ");
		hql.append(" VprojectInfo v ");
		hql.append(" where t.projectId = v.projectId ");
		/*// 部门ID
	    String departmentId = (String) param.get("departmentId");
	    if (!isNullString(departmentId)) {
	    	hql.append(" and t.tprojectGroup.departmentId = '" + departmentId.trim() + "'");
	    }*/
	    
		// 项目名称
	    String projectName = (String) param.get("projectName");
	    if (!isNullString(projectName)) {
			hql.append(" and t.projectName like '%" + projectName.trim() + "%'");
		}
	    
	    // 申报单位
	    String applyCompany = (String) param.get("applyCompany");
	    if (!isNullString(applyCompany)) {
			hql.append(" and t.applicationUnit like '%" + applyCompany.trim() + "%'");
		}
	    
	    // 计划类别
	    String projectType1 = (String) param.get("projectType1");
	    if (!isNullString(projectType1)) {
	    	hql.append(" and t.planFlag = '" + projectType1.trim() + "'");
	    }
	    else{
	    	// 未选择计划类别时
	    	String projectTypeString = (String) param.get("projectTypeString");
		    if (!isNullString(projectTypeString)) {
		    	hql.append(" and t.tprojectType.typeId in ("+ projectTypeString +") ");
		    }
	    }
	    
	    // 计划类别
	    String projectType2 = (String) param.get("projectType2");
	    if (!isNullString(projectType2)) {
	    	hql.append(" and t.tprojectType.typeId = '" + projectType2.trim() + "'");
	    }
	    String plaId = (String) param.get("planId");
	    if(!isNullString(plaId)){
	    	hql.append(" and t.tplan.planId = '"+ plaId +"'");
	    }
	    else{
	    	hql.append(" and t.tplan.planId is null ");
	    }
	    
	    // 审核状态
	    hql.append(" and t.applyStatus = '" + Constants.PROJECT_REPORT_BEFOREREVIEW_PASS + "'");
	 
	    // 推荐意见
	    hql.append(" and t.expertAuditRecommend = '" + Constants.RECOMMENDATION_RECOMMEND + "'");
	    hql.append(" or t.expertAuditRecommend = '" + Constants.RECOMMENDATION_ALTERNATIVE + "'");
	    
	    // 局办公会意见
	    hql.append(" and t.expertAuditComposite = '" + Constants.OFFICE_PASS + "'");
	    
	    return hql.toString();
	}
	
	
	/**
	 * @comments 取得分计划选择的项目
	 * @param planId
	 * @return
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getPlanUpdateList(String planId){
		List<Object>  list = new ArrayList<Object>();
		
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from TprojectApplication t, ");
		hql.append(" VprojectInfo v, ");
		hql.append(" TcostEstimateB c, ");
		hql.append(" TeconomicIndicatorB e, ");
		hql.append(" TcompanyInfo o, ");
		hql.append(" VmainContent p ");
		hql.append(" where t.projectId = v.projectId ");
		hql.append(" and t.projectId = c.tprojectApplication.projectId ");
		hql.append(" and t.projectId = e.tprojectApplication.projectId ");
		hql.append(" and t.projectId = o.tprojectApplication.projectId ");
		hql.append(" and t.projectId = p.projectId ");
		hql.append(" and t.tplan.planId = '" + planId +"'");
		
		/*hql.append(" from TprojectApplication t ");
		//hql.append(" left join VprojectInfo v on t.projectId = v.projectId ");
		hql.append(" left join t.teconomicIndicatorBs e ");
		hql.append(" left join t.tcostEstimateBs c ");
		hql.append(" left join t.tcompanyInfos o ");
		hql.append(" left join t.tprojectOverviewAs p ");
		//hql.append(" where t.projectId = v.projectId ");
		hql.append(" where t.projectId = c.tprojectApplication.projectId ");
		hql.append(" and t.projectId = e.tprojectApplication.projectId ");
		hql.append(" and t.projectId = o.tprojectApplication.projectId ");
		hql.append(" and t.projectId = p.tprojectApplication.projectId ");*/
		//hql.append(" and t.tplan.planId = '" + planId +"'");
		
		Finder f = Finder.create(hql.toString());
		
		// 排序条件
		// f.append(" order by t.tprojectGroup.createTime desc");
		
		list = super.find(f);
		
		return list;
	}
	
	/**
	 * @comments 取得为选择的项目list
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getUnselectProjectList(Map<String, Object> param){
		
		List<Object>  list = new ArrayList<Object>();
		
		String sql = this.createBatchProjectHql(param);
		
		Finder f = Finder.create(sql);
		
		// 排序条件
		// f.append(" order by t.tprojectGroup.createTime desc");
		
		list = super.find(f);
		
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

	@Override
	public Pager getGroupProjectList(Map<String, Object> param, Integer pageNumber, Integer pageSize) {
		// 创建Finder查询对象

		String hql = this.createGroupProjectHql(param);

		Finder f = Finder.create(hql);

		// 排序条件
		f.append(" order by t.createTime desc");

		Pager p = super.find(f, pageNumber, pageSize);

		// 查询、返回
		return p;
	}
	
	/**
	 * @comments 生成查询分组所属项目hql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createGroupProjectHql(Map<String, Object> param){
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from TprojectApplication t, ");
		hql.append(" VprojectInfo v ");
		hql.append(" where t.projectId = v.projectId ");

	    // 项目分组
	    String groupId = (String) param.get("groupId");
	    if (!isNullString(groupId)) {
	    	hql.append(" and t.tprojectGroup.groupId = '" + groupId.trim() + "'");
	    }
	    return hql.toString();
	}

	@Override
	public Pager getGroupSelectProjectPager(Map<String, Object> param,Integer pageNumber, Integer pageSize) {

		String sql = this.createGroupSelectProjectHql(param);

		Finder f = Finder.create(sql);

		// 排序条件
		f.append(" order by t.createTime desc");

		Pager p = super.find(f, pageNumber, pageSize);

		return p;

	}
	
}

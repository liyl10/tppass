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
import com.hopsun.tppas.api.report.dao.ProjectApplicationProposalsDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TprojectApplication;

/**
 * @comments 联席会审核 
 * @author wanglw
 * @date 2013-9-16 @time 下午2:16:15
 * @Version 1.0
 */
@Repository
public class ProjectApplicationProposalsDaoImpl extends BaseDaoImpl<TprojectApplication, String> implements ProjectApplicationProposalsDao {

	/**
	 * @comments 取得联席会审核项目List
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getProposalsList(Map<String, Object> param, int pageNo, int pageSize){
		// 创建Finder查询对象
		
		String hql = this.createAuditExpertHql(param);
		
		Finder f = Finder.create(hql);
		
		// 排序条件
		f.append(" order by t.tprojectGroup.createTime desc, t.tprojectGroup.groupId desc, t.projectAverage desc, t.writeReportTime desc");
		
		Pager p = super.find(f, pageNo, pageSize);
		
		// 查询、返回
		return p;
	}
	
	/**
	 * @comments 生成联席会审核sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createAuditExpertHql(Map<String, Object> param){
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from TprojectApplication t, ");
		hql.append(" VprojectInfo v ");
		
		//专家评审时关联专家评审表
		String isAssociate = (String) param.get("isAssociate");
		if(!isNullString(isAssociate)){
			hql.append(", TexpertScore e ");
		}
		
		hql.append(" where t.projectId = v.projectId ");
		
		if(!isNullString(isAssociate)){
			hql.append(" and e.tprojectApplication.projectId = t.projectId");
		}
		
		// 分组选择专家锁定
		hql.append(" and t.tprojectGroup.clockFlag = 1 ");
		
		// 已分组的项目
		hql.append(" and t.tprojectGroup.groupId is not null ");
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
	    
//	    // 审核状态 TODO
//	    String auditStatus = (String) param.get("auditStatus");
//	    if (!isNullString(auditStatus)) {
//	    	hql.append(" and t.applyStatus = '" + auditStatus.trim() + "'");
//	    }
//	    else{
	    	hql.append(" and t.applyStatus = '" + Constants.PROJECT_REPORT_BEFOREREVIEW_PASS + "'");
//	    }
//	    
	    // 项目分组
	    String projectGroup = (String) param.get("projectGroup");
	    if (!isNullString(projectGroup)) {
	    	hql.append(" and t.tprojectGroup.groupId = '" + projectGroup.trim() + "'");
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
	
	//wangxd start
	/**
	 * 通过条件打印专家评审结果
	 * @comments 
	 * @param paramMap
	 * @return
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> printExpertScoreAll(Map<String,Object> paramMap){
		List<Object[]> all = new ArrayList<Object[]>();
		StringBuffer hql = new StringBuffer("select t.tprojectGroup.groupId,t.tprojectGroup.groupName,t.projectId,t.projectName,e.texpert.expertName,e.texpert.expertType,e.companyStatusScore," +
					"e.projectTechnologyScore,e.projectBaseScore,e.projectMarketScore,e.projectBenefitScore,e.complexScore," +
					"e.complexAverage,e.finalResult,e.texpert.expertId");
		hql.append(this.createAuditExpertHql(paramMap));
		hql.append(" order by t.tprojectGroup.groupId desc,t.projectId desc, e.texpert.expertId, e.texpert.expertType asc");
		Finder f = Finder.create(hql.toString());
		all = super.find(f);
		return all;
	}
	
	//wangxd end
}


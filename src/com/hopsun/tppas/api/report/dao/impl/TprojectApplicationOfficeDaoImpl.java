/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.report.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.report.dao.TprojectApplicationOfficeDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TprojectApplication;

/**
 * @comments 局办公会意见
 * @author wanglw
 * @date 2013-11-21 @time 下午8:31:24
 * @Version 1.0
 */
@Repository
public class TprojectApplicationOfficeDaoImpl extends BaseDaoImpl<TprojectApplication, String> implements TprojectApplicationOfficeDao{

	/**
	 * @comments 局办公会意见
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getOfficeAuditList(Map<String, Object> param, int pageNo, int pageSize){
		// 创建Finder查询对象
		
		String hql = this.createAuditExpertHql(param);
		
		Finder f = Finder.create(hql);
		
		// 排序条件
		f.append(" order by t.tprojectGroup.createTime desc, t.tprojectGroup.groupId desc, t.projectAverage desc, t.writeReportTime desc");
		
		Pager p = super.find(f, pageNo, pageSize);
		
		// 查询、返回
		return p;
	}
	
	private String createAuditExpertHql(Map<String, Object> param){
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from TprojectApplication t");
		
		// 分组选择专家锁定
		hql.append(" where t.tprojectGroup.clockFlag = 1 ");
		
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
	    
	    // 审核状态 
	    String auditStatus = (String) param.get("auditStatus");
	    if (!isNullString(auditStatus)) {
	    	hql.append(" and t.applyStatus = '" + auditStatus.trim() + "'");
	    }
	    else{
	    	hql.append(" and t.applyStatus = '" + Constants.PROJECT_REPORT_BEFOREREVIEW_PASS + "'");
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


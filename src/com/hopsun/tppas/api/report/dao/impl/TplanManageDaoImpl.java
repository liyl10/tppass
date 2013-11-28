package com.hopsun.tppas.api.report.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.report.dao.TplanManageDao;
import com.hopsun.tppas.entity.Tplan;
/**
 * @comments 分计划管理
 * @author wanglw
 * @date 2013-10-9 @time 上午9:26:26
 * @Version 1.0
 */
@Repository
public class TplanManageDaoImpl extends BaseDaoImpl<Tplan, String> implements TplanManageDao {
	
	
	/**
	 * @comments 取得分计划List
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getPlanList(Map<String, Object> param, int pageNo, int pageSize){
		// 创建Finder查询对象
		
		String hql = this.createGetPlanHql(param);
		
		Finder f = Finder.create(hql);
		
		Pager p = super.find(f, pageNo, pageSize);
		
		// 查询、返回
		return p;
	}
	
	/**
	 * @comments 生成取得分计划ListSQl 
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createGetPlanHql(Map<String, Object> param){
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from Tplan t where 1=1 ");
		/*// 部门ID
	    String departmentId = (String) param.get("departmentId");
	    if (!isNullString(departmentId)) {
	    	hql.append(" and t.tprojectType.departmentId = '" + departmentId.trim() + "'");
	    }*/
	    
		// 项目名称
	    String planName = (String) param.get("planName");
	    if (!isNullString(planName)) {
			hql.append(" and t.planName like '%" + planName.trim() + "%'");
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
	    String planBatch = (String) param.get("planBatch");
	    if (!isNullString(planBatch)) {
	    	hql.append(" and t.planBatch = '" + planBatch.trim() + "'");
	    }
	    
	    // 审核状态
	    String planYear = (String) param.get("planYear");
	    if (!isNullString(planYear)) {
	    	hql.append(" and t.planYear = '" + planYear.trim() + "'");
	    }
	    
	    // 审核状态
	    String planStatus = (String) param.get("planStatus");
	    if (!isNullString(planStatus)) {
	    	hql.append(" and t.planState = '" + planStatus.trim() + "'");
	    }
	    
	    
	    return hql.toString();
	}
	
	
	/**
	 * @comments 取得已选择的批次
	 * @param deptId
	 * @param planId
	 * @return
	 * @Version 1.0
	 */
	public List<Tplan> getSelectedBatch(String projectTypeString, String planId){
		
		StringBuffer hql = new StringBuffer();
		hql.append(" from Tplan t where 1=1 ");
		if(!isNullString(projectTypeString)){
			hql.append(" and t.tprojectType.typeId = '"+ projectTypeString +"' ");
		}
		if(!isNullString(planId)){
			hql.append(" and t.planId != '"+ planId +"' ");
		}
		
		return super.createQueryList(hql.toString(), new String []{});
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

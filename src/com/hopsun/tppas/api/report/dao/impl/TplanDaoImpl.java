package com.hopsun.tppas.api.report.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.report.dao.TplanDao;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.Tplan;
/**
 * @Comments:   后台Dao实现类-主要用来实现分计划操作的接口
 * @author  yk
 * @date 2013-08-01
 * @version 1.0
 *
 */
@Repository
public class TplanDaoImpl extends BaseDaoImpl<Tplan, String> implements TplanDao {
	@Override
	public List<Tplan> queryTPlanByPlanState(String planState) {
		String hql=" FROM  Tplan  tplan left join fetch tplan.tprojectApplications  where tplan.planState=?";
		return createQueryList(hql, new String[]{planState});
	}
	/***
	 * 
	 * @comments 分计划列表 
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	@Override
	public Pager getPlanList(Map<String, Object> param, int pageNo, int pageSize) {
		// 创建Finder查询对象
		
		String hql = this.createPlanHql(param);
		
		Finder f = Finder.create(hql);
		
		// 排序条件
		f.append(" order by t.createTime desc");
		
		Pager p = super.find(f, pageNo, pageSize);
		
		// 查询、返回
		return p;
	}
	/**
	 * @comments 生成分计划sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createPlanHql(Map<String, Object> param){
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from Tplan t where 1 = 1 ");
		// 分计划ID
	    String planId = (String) param.get("planId");
	    if (!isNullString(planId)) {
	    	hql.append(" and t.planId = '" + planId.trim() + "'");
	    }
	    
		// 分计划名称
	    String planName = (String) param.get("planName");
	    if (!isNullString(planName)) {
			hql.append(" and t.planName like '%" + planName.trim() + "%'");
		}
	    
	    // 计划年度
	    String planYear = (String) param.get("planYear");
	    if (!isNullString(planYear)) {
	    	hql.append(" and t.planYear like '%" + planYear.trim() + "%'");
	    }
	    
	    // 分计划状态
	    String planState = (String) param.get("planState");
	    if (!isNullString(planState)) {
	    	hql.append(" and t.planState = '" + planState.trim() + "'");
	    }
	    
	   /* // 项目类别
	    String projectType1 = (String) param.get("projectType1");
	    if (!isNullString(projectType1)) {
	    	hql.append(" and p.planFlag = '" + projectType1.trim() + "'");
	    }
	    
	    // 计划类别
	    String projectType2 = (String) param.get("projectType2");
	    if (!isNullString(projectType2)) {
	    	hql.append(" and p.tprojectType.typeId = '" + projectType2.trim() + "'");
	    }*/
	    
	    // 批次
	    String planBatch = (String) param.get("planBatch");
	    if (!isNullString(planBatch)) {
	    	hql.append(" and t.planBatch = '" + planBatch.trim() + "'");
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
	
	/**
	 * 查询分计划 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Tplan> getPlanList(Map<String, Object> param) {
		// 创建Finder查询对象

		String hql = this.createSelectPlanHql(param);

		Finder f = Finder.create(hql);

		// 排序条件
		f.append(" order by t.createTime desc");

		List<Tplan> p = new ArrayList<Tplan>();
		p = super.find(f);

		// 查询、返回
		return p;
	}
	
	/**
	 * @comments 生成分计划sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createSelectPlanHql(Map<String, Object> param){
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from Tplan t where 1 = 1 ");

		// 分计划名称
	    String planName = (String) param.get("planName");
	    if (!isNullString(planName)) {
			hql.append(" and t.planName like '%" + planName.trim() + "%'");
		}
	    
	    // 业务部门
	    String selectedDeptId = (String) param.get("selectedDeptId");
	    if (!isNullString(selectedDeptId)) {
	    	// 计划类别
		    String projectType1 = (String) param.get("projectType1");
		    if (!isNullString(projectType1)) {
		    	String projectType2 = param.get("projectType2").toString();
		    	if(!isNullString(projectType2)){
		    		hql.append(" and t.tprojectType.typeId = '" + projectType2.trim() + "'");
		    	}else{
		    		hql.append(" and t.planFlag = '" + projectType1.trim() + "'");
		    	}
		    }else{
		    	// 取得该业务部门下所有的分计划
		    	String  planFlagQueryStr = param.containsKey("typeInStr") ? param.get("typeInStr").toString():null;
		    	if (!isNullString(planFlagQueryStr)) {
		    		hql.append(" and t.planFlag in (" + planFlagQueryStr.trim() + ")");
		    	}else{
		    		hql.append(" and t.planFlag is null ");
		    	}
		    }
	    }
	    
	    // 批次
	    String planBatch = (String) param.get("planBatch");
	    if (!isNullString(planBatch)) {
	    	hql.append(" and t.planBatch = '" + planBatch.trim() + "'");
	    }

	    // 只查询没有被汇总的分计划
	    hql.append(" and t.tplanCollect.planCollectId is null");
	    
	    // 计划年度
	    String planYear = (String) param.get("planYear");
	    if (!isNullString(planYear)) {
	    	hql.append(" and t.planYear ='" + planYear.trim() + "'");
	    }
	    
	    // 分计划状态(只查询已提交的分计划)
	    String planState = Constants.PLAN_APPLIED;
	    if (!isNullString(planState)) {
	    	hql.append(" and t.planState = '" + planState.trim() + "'");
	    }
	    return hql.toString();
	}
	/**
	 * 取得该汇总计划下存在的不重复的计划类别
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getGroupInfoList(String planCollectId) {
		StringBuilder hql = new StringBuilder();
		hql.append("select distinct c.planFlag from Tplan c ");

		hql.append(" where 1=1 ");

		// 汇总计划id
		if (notIsNullString(planCollectId)) {
			hql.append(" and c.tplanCollect.planCollectId='");
			hql.append(planCollectId.trim());
			hql.append("'");
		}
		
		// 删除区分
		hql.append(" and c.deleteFlag='0'");

		// 创建Query 对象
		Query query = getSession().createQuery(hql.toString());

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
	private boolean notIsNullString(String valueStr) {
		return !this.isNullString(valueStr);
	}
	
	/**
	 * 查询分计划 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Tplan> getPlanListByPlanType(Map<String, Object> param) {
		// 创建Finder查询对象

		String hql = this.createSelectPlanHql2(param);

		Finder f = Finder.create(hql);

		// 排序条件
		f.append(" order by t.createTime desc");

		List<Tplan> p = new ArrayList<Tplan>();
		p = super.find(f);

		// 查询、返回
		return p;
	}
	
	/**
	 * @comments 生成分计划sql
	 * @param param
	 * @return
	 * @Version 1.0
	 */
	private String createSelectPlanHql2(Map<String, Object> param){
		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from Tplan t where 1 = 1 ");

		// 汇总计划ID
	    String planCollectId = (String) param.get("planCollectId");
	    if (!isNullString(planCollectId)) {
			hql.append(" and t.tplanCollect.planCollectId = '" + planCollectId.trim() + "'");
		}
	    
	    // 计划类别id
	    String planFlag = (String) param.get("planFlag");
	    if (!isNullString(planFlag)) {
	    	hql.append(" and t.planFlag = '" + planFlag.trim() + "'");
	    }
	    
	    // 删除区分
	    hql.append(" and t.deleteFlag='0'");


	    return hql.toString();
	}
	
	/**
	 * 查询分计划 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Tplan> getPlanListByCollectId(Map<String, Object> param) {
		// 创建Finder查询对象

		StringBuffer hql = new StringBuffer();
		
		// 生成hql
		hql.append(" from Tplan t where 1 = 1 ");

		// 汇总计划ID
	    String planCollectId = (String) param.get("planCollectId");
	    if (!isNullString(planCollectId)) {
			hql.append(" and t.tplanCollect.planCollectId = '" + planCollectId.trim() + "'");
		}

		Finder f = Finder.create(hql.toString());

		// 排序条件
		f.append(" order by t.createTime desc");

		List<Tplan> p = new ArrayList<Tplan>();
		p = super.find(f);

		// 查询、返回
		return p;
	}
}

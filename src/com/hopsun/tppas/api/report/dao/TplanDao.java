package com.hopsun.tppas.api.report.dao;

import java.util.List;
import java.util.Map;

import com.hopsun.tppas.entity.Tplan;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
/**
 * @Comments:   后台Dao接口-主要用来定义分计划操作的接口
 * @author  yk
 * @date 2013-08-01
 * @version 1.0
 *
 */
public interface TplanDao extends BaseDao<Tplan, String>{
	/**
	 * 获取带编制分计划   
	 * @param planState
	 * @return
	 */
	public List<Tplan>  queryTPlanByPlanState(String planState);
	/***
	 * 
	 * @comments 分计划列表        
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager getPlanList(Map<String, Object> param, int pageNo, int pageSize);

	/**
	 * 查询分计划 
	 * @comments 
	 * @param param
	 * @return
	 * @version 1.0
	 */
	public List<Tplan> getPlanList(Map<String, Object> param);
	
	/**
	 * 根据计划类别查询分计划 
	 * @comments 
	 * @param param
	 * @return
	 * @version 1.0
	 */
	public List<Tplan> getPlanListByPlanType(Map<String, Object> param);
	
	/**
	 * 
	 * @comments 取得该汇总计划下存在的不重复的计划类别
	 * @param planCollectId
	 * @return
	 * @version 1.0
	 */
	public List<String> getGroupInfoList(String planCollectId);
	
	/**
	 * 
	 * @comments 取得该汇总计划下所有的分计划
	 * @param param
	 * @return
	 * @version 1.0
	 */
	public List<Tplan> getPlanListByCollectId(Map<String, Object> param);
}

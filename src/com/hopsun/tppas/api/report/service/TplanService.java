package com.hopsun.tppas.api.report.service;

import java.util.List;
import java.util.Map;

import com.hopsun.tppas.entity.Tplan;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
/**
 * @Comments:   后台Service接口-主要用来定义分计划操作的接口
 * @author  yk
 * @date 2013-08-01
 * @version 1.0
 *
 */
public interface TplanService extends BaseService<Tplan, String> {
	/**
	 * 获取带编制的分计划
	 * @param planState
	 * @return
	 */
	public List<Tplan>  queryTPlanByPlanState(String planState);
	//weina start
	
	/**
	 * @comments 取得分计划数据
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getPlanList(Map<String, Object> param, int pageNo, int pageSize);
	/***
	 * 
	 * @comments 查看分计划 
	 * @param planId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager find(String planId, int pageNo, int pageSize);
	//weina end

	/**
	 * 
	 * @comments 取得分计划一览
	 * @param param
	 * @return
	 * @version 1.0
	 */
	public List<Tplan> getPlanList(Map<String, Object> param);

	/**
	 * 
	 * @comments 取得该汇总计划下存在的不重复的计划类别
	 * @param planCollectId
	 * @return
	 * @version 1.0
	 */
	public List<String> getGroupInfo(String planCollectId);

	/**
	 * 
	 * @comments 根据计划类别取得详细的分计划信息
	 * @param planCollectId
	 * @param groupInfo
	 * @return
	 * @version 1.0
	 */
	public List<Tplan> getListByGroupInfo(String planCollectId, List<String> groupInfo);

	/**
	 * 
	 * @comments 从汇总计划中将该分计划删除
	 * @param param
	 * @version 1.0
	 */
	public void deletePlanFromCollect(Map<String, Object> param);

	/**
	 * 
	 * @comments 从汇总计划中将该分计划删除
	 * @param param
	 * @version 1.0
	 */
	public void deletePlanFromCollectByType(Map<String, Object> param);
}

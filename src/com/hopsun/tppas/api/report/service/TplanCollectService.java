package com.hopsun.tppas.api.report.service;

import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.tppas.entity.TplanCollect;

public interface TplanCollectService extends BaseService<TplanCollect, String> {

	/**
	 * 
	 * @comments 取得计划汇总一览信息
	 * @param param
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	Pager getPlanList(Map<String, Object> param, Integer pageNumber,
			Integer pageSize);

	/**
	 * 
	 * @comments  删除计划汇总 
	 * @param param
	 * @version 1.0
	 */
	void deletePlanCollect(Map<String, Object> param);
	
	/**
	 * 
	 * @comments 选择分计划提交处理
	 * @param param
	 * @version 1.0
	 */
	void updateSelectedPlan(Map<String, Object> param);
	
}

package com.hopsun.tppas.api.report.dao;

import java.util.Map;

import com.hopsun.tppas.entity.TplanCollect;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;

public interface TplanCollectDao extends BaseDao<TplanCollect, String>{

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

}

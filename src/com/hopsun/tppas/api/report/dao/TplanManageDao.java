package com.hopsun.tppas.api.report.dao;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.tppas.entity.Tplan;
/**
 * @comments 分计划管理Dao
 * @author wanglw
 * @date 2013-10-9 @time 上午9:25:12
 * @Version 1.0
 */
public interface TplanManageDao extends BaseDao<Tplan, String>{

	/**
	 * @comments 取得分计划List
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager getPlanList(Map<String, Object> param, int pageNo, int pageSize);
	
	/**
	 * @comments 取得已选择的批次
	 * @param deptId
	 * @param planId
	 * @return
	 * @Version 1.0
	 */
	public List<Tplan> getSelectedBatch(String deptId, String planId);
}

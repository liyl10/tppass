package com.hopsun.tppas.api.acceptance.dao;

import java.util.List;

import com.hopsun.tppas.entity.TacceptanceCompleteA;
import com.hopsun.framework.base.dao.BaseDao;

public interface TacceptanceCompleteADao extends BaseDao<TacceptanceCompleteA, String>{
	/**
	 * 根据验收ID查询对照合同项目任务完成情况
	 *@param acceptanceId
	 *@return List
	 */
	public List<TacceptanceCompleteA> getTacceptanceCompleteAById(String acceptanceId);
}

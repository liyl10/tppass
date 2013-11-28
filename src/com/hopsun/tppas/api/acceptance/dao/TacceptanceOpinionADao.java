package com.hopsun.tppas.api.acceptance.dao;

import java.util.List;

import com.hopsun.tppas.entity.TacceptanceOpinionA;
import com.hopsun.framework.base.dao.BaseDao;

public interface TacceptanceOpinionADao extends BaseDao<TacceptanceOpinionA, String>{
	/**
	 * 根据验收ID查询验收阶段意见
	 *@param acceptanceId
	 *@return List
	 */
	public List<TacceptanceOpinionA> getTacceptanceOpinionAById(String acceptanceId);
}

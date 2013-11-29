package com.hopsun.tppas.api.acceptance.dao;

import java.util.List;

import com.hopsun.tppas.entity.TacceptanceFundsA;
import com.hopsun.framework.base.dao.BaseDao;

public interface TacceptanceFundsADao extends BaseDao<TacceptanceFundsA, String>{
	/**
	 * 根据验收ID查询企业获得资金支持情况
	 *@param acceptanceId
	 *@return List
	 */
	public List<TacceptanceFundsA> getTacceptanceFundsAById(String acceptanceId);
}

package com.hopsun.tppas.api.acceptance.dao;

import java.util.List;

import com.hopsun.tppas.entity.TacceptanceAccFundsA;
import com.hopsun.framework.base.dao.BaseDao;

public interface TacceptanceAccFundsADao extends BaseDao<TacceptanceAccFundsA, String>{
	/**
	 * 根据验收ID查询项目验收经费登记表
	 *@param acceptanceId
	 *@return List
	 */
	public List<TacceptanceAccFundsA> getTacceptanceAccFundsAById(String acceptanceId);
}

package com.hopsun.tppas.api.acceptance.dao;

import java.util.List;

import com.hopsun.tppas.entity.TacceptanceImplementationA;
import com.hopsun.framework.base.dao.BaseDao;

public interface TacceptanceImplementationADao extends BaseDao<TacceptanceImplementationA, String>{
	/**
	 * 根据验收ID查询项目经费落实和使用情况
	 *@param acceptanceId
	 *@return List
	 */
	public List<TacceptanceImplementationA> getTacceptanceImplementationAById(String acceptanceId);
}

package com.hopsun.tppas.api.acceptance.dao;

import java.util.List;

import com.hopsun.tppas.entity.TacceptanceDevelopingA;
import com.hopsun.framework.base.dao.BaseDao;

public interface TacceptanceDevelopingADao extends BaseDao<TacceptanceDevelopingA, String>{
	/**
	 * 根据验收ID查询企业发展情况
	 *@param acceptanceId
	 *@return List
	 */
	public List<TacceptanceDevelopingA> getTacceptanceDevelopingAById(String acceptanceId);
}

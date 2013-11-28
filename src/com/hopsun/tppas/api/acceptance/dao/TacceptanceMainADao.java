package com.hopsun.tppas.api.acceptance.dao;

import java.util.List;

import com.hopsun.tppas.entity.TacceptanceMainA;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;

public interface TacceptanceMainADao extends BaseDao<TacceptanceMainA, String>{
	/**
	 * 分页查询
	 *@param pageNumber pageSize acceptanceId
	 *@return Pager
	 */
	public Pager findByPager(Integer pageNumber, Integer pageSize, String acceptanceId);
	
	/**
	 * 根据验收ID查询项目主要参加人员信息
	 *@param acceptanceId
	 *@return List
	 */
	public List<TacceptanceMainA> getTacceptanceMainAById(String acceptanceId);
}

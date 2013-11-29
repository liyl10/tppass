package com.hopsun.tppas.api.acceptance.dao;

import java.util.List;

import com.hopsun.tppas.entity.TacceptanceAccA;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;

public interface TacceptanceAccADao extends BaseDao<TacceptanceAccA, String>{
	/**
	 * 分页查询
	 *@param pageNumber pageSize acceptanceId
	 *@return Pager
	 */
	public Pager findByPager(Integer pageNumber, Integer pageSize, String acceptanceId);
	
	/**
	 * 根据验收ID查询验收小组人员信息
	 *@param acceptanceId
	 *@return List
	 */
	public List<TacceptanceAccA> getTacceptanceAccAById(String acceptanceId);
}

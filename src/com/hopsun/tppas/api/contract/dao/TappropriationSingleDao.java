package com.hopsun.tppas.api.contract.dao;

import com.hopsun.tppas.entity.TappropriationSingle;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;

public interface TappropriationSingleDao extends BaseDao<TappropriationSingle, String>{
	
	/**
	 * 查询拨款单信息
	 * @comments 
	 * @param tcontractId
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @version 1.0
	 */
	public Pager find(String tcontractId,int pageNumber,int pageSize);
}

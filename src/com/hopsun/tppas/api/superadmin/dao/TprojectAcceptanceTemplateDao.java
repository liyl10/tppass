package com.hopsun.tppas.api.superadmin.dao;

import com.hopsun.tppas.entity.TprojectAcceptanceTemplate;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;

public interface TprojectAcceptanceTemplateDao extends BaseDao<TprojectAcceptanceTemplate, String>{
	
	/**
	 * 分页查询
	 *@param pageNumber pageSize 
	 *@return Pager
	 */
	Pager findByPager(String name,Integer pageNumber, Integer pageSize);
}

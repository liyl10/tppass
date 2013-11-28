/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.superadmin.dao;

import java.util.List;
import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.tppas.entity.Mtype;

/**
 * @comment 代码类型表DAO层接口
 * @author liush
 * @DATE: 2013-5-29 @TIME: 上午11:11:31
 * @Vsersion: 1.0
 */
public interface MtypeDao extends BaseDao<Mtype, String>{

	/**
	 * 分页查询
	 *@param param pageNumber pageSize 
	 *@return Pager
	 */
	public Pager find(Map<String, Object> param, Integer pageNumber, Integer pageSize);
	
	/**
	 * @Comments 取得有序的类型信息
	 * @return
	 * @Vsersion: 1.0
	 */
	public List<Mtype> getInfoList();
	
}

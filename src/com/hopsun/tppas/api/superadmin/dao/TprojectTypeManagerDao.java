/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.superadmin.dao;

import java.util.List;
import java.util.Map;

import com.hopsun.tppas.entity.TprojectTypeManager;
import com.hopsun.framework.base.dao.BaseDao;

/**
 * @comments 计划类别管理专员
 * @author wangxiaodong
 * @date 2013-10-23
 * @version 1.0
 */
public interface TprojectTypeManagerDao extends BaseDao<TprojectTypeManager, String>{
	
	/**
	 *通过条件查询计划类别管理专员
	 * @comments 
	 * @param valueMap
	 * @return
	 * @version 1.0
	 */
	public List<TprojectTypeManager> getTprojectTypeManager(Map<String,Object> valueMap);
	
}

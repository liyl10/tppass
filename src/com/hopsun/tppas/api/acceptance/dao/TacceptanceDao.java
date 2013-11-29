/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.api.acceptance.dao;

import java.util.List;
import java.util.Map;

import com.hopsun.tppas.entity.Tacceptance;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;

/**
 * 
 *@comments 验收管理Dao接口
 *@author liyilin
 *@date 2013-8-9
 *@version 1.0
 */
public interface TacceptanceDao extends BaseDao<Tacceptance, String>{

	/**
	 * @comments 项目验收分页查询
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	Pager find(Map<String, Object> param, Integer pageNumber, Integer pageSize);
	
	/**
	 * 查询待验收项目
	 * @param acceptanceStatus
	 * @return
	 */
	public List<Tacceptance> queryTacceptanceByState(String acceptanceStatus );
	
	/**
	 * 根据项目ID查询项目验收管理信息
	 *@param acceptanceId
	 *@return Tacceptance
	 */
	public Tacceptance getTacceptanceById(String acceptanceId);
	
}

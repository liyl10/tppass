/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.statistics.dao;

import java.util.List;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.tppas.entity.TappropriationSingle;

/**
 * 
 *@comments 项目结果汇总Dao接口
 *@author liyilin
 *@date 2013-8-22
 *@version 1.0
 */
public interface FundsDao extends BaseDao<TappropriationSingle, String> {

	/**
	 * @comments 分页查询
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Version 1.0
	 */
	public Pager find(String hql, int pageNo, int pageSize);
	
	/**
     * @comments 通过SQL语句查询信息
     * @param sql
     * @param params
     * @return
     * @Version 1.0
     */
    public List<Object> queryInfoBySql(Object[] params);
    
    /**
     * @comments 查询信息
     * @param hql
     * @return
     * @Version 1.0
     */
    public List<Object> queryListinfo(String hql);
    
}

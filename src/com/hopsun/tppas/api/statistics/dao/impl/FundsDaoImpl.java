/*************** 版权声明***************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ********************************************
 */
package com.hopsun.tppas.api.statistics.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.bean.Finder;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.statistics.dao.FundsDao;
import com.hopsun.tppas.entity.TappropriationSingle;

/**
 * 
 * @comments 项目结果汇总Dao实现类
 * @author liyilin
 * @date 2013-8-22
 * @version 1.0
 */
@Repository
public class FundsDaoImpl extends
		BaseDaoImpl<TappropriationSingle, String> implements
		FundsDao {

	/**
	 * @comments 分页查询
	 * @param sql
     * @param pageNo
     * @param pageSize
     * @return
	 * @Version 1.0
	 */
	public Pager find(String hql, int pageNo, int pageSize) {

		// 创建Finder查询对象
		Finder f = Finder.create(hql.toString());
		Pager p = super.find(f, pageNo, pageSize);
		
		return p;
	}

	/**
     * @comments 通过SQL语句查询信息
     * @param sql
     * @param params
     * @return
     * @Version 1.0
     */
	@SuppressWarnings("unchecked")
    public List<Object> queryInfoBySql(Object[] params){
		StringBuilder sql = new StringBuilder();
		sql.append(" select a.table_name,a.column_name,a.comments comments, b.column_id from user_col_comments a ,all_tab_columns b ");
		sql.append(" WHERE a.table_name = b.table_name and ");
		sql.append(" a.column_name = b.column_name and( ");
		if (params != null && params.length > 0) {
			sql.append("  a.table_name = '");
			sql.append(params[0] + "'");
			for (int i = 1; i < params.length; i++) {
				sql.append(" or a.table_name = '");
				sql.append(params[i] + "'");
			}
			sql.append(")");
		}
		sql.append("order by a.table_name asc, b.column_id asc");
		
    	// 创建Query 对象
		Query query = getSession().createSQLQuery(sql.toString());
		
		// 接收返回结果
		List<Object> list = query.list();

    	return list;
    }
    
    /**
     * @comments 查询信息
     * @param hql
     * @return List
     * @Version 1.0
     */
	@SuppressWarnings("unchecked")
    public List<Object> queryListinfo(String hql){
    	
    	// 创建Finder查询对象
    	Finder f = Finder.create(hql);
    	// 执行操作返回结果集
    	List<Object> list = super.find(f);
    	
    	return list;
    }

}

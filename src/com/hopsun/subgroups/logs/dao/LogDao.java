/**
 * @filename LogDao.java
 * @author zzze
 * @date Dec 25, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.logs.dao;

import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.dao.BaseDao;
import com.hopsun.subgroups.entity.UcLogs;
import com.hopsun.subgroups.logs.beans.UserTabComments;

/**
 * 
 * @Comments 日志Dao层接口
 * @author zzze
 * @date 2012-12-21 下午02:29:53
 * @version 1.0
 */
public interface LogDao extends BaseDao<UcLogs, String> {
	
	void add(UcLogs log);
	/**
	 * @comment 分页方法
	 * @param pager
	 * @param config
	 * @return
	 * @version: 1.0
	 */
	Pager list(Pager pager,UcLogs logs);
	
	/**
	 * @comment 获取表的属性
	 * @return
	 * @version: 1.0
	 */
	Map<String,UserTabComments> getUserTabComments();
}

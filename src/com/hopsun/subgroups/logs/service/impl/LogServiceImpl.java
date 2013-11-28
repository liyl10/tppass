/**
 * @filename LogServiceImpl.java
 * @author Administrator
 * @date Dec 25, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.logs.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.subgroups.entity.UcLogs;
import com.hopsun.subgroups.logs.beans.UserTabComments;
import com.hopsun.subgroups.logs.dao.LogDao;
import com.hopsun.subgroups.logs.service.LogService;
/**
 *@comment 日志记录业务层实现类 
 *@author zzze
 *@date Dec 26, 2012
 *@version 1.0
 */
@Service("logService")
public class LogServiceImpl extends BaseServiceImpl<UcLogs, String> implements LogService{
	@Resource
	public transient LogDao logDao;
	@Resource
	public void setBaseDao(final LogDao logDao) {
		super.setBaseDao(logDao);
	}
	
	/* (non-Javadoc)
	 * @see com.hopsun.framework.logs.service.impl.logs#add(com.hopsun.framework.logs.entity.Logs)
	 */
	public void add(final UcLogs log){
		logDao.add(log);
	}

	/**
	 * @comment 分页业务实现 
	 * @param pager
	 * @param config
	 * @return
	 * @version: 1.0
	 */
	public Pager list(final Pager pager,final UcLogs logs) {
		return logDao.list(pager,logs);
	}
	/**
	 * @comment 获取表属性
	 * @param pager
	 * @param config
	 * @return
	 * @version: 1.0
	 */
	public Map<String,UserTabComments> getUserTabComments() {
		return logDao.getUserTabComments();
	}

}

/**
 * @filename LogService.java
 * @author zzze
 * @date Dec 25, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.logs.service;


import java.util.Map;

import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.base.service.BaseService;
import com.hopsun.subgroups.entity.UcLogs;
import com.hopsun.subgroups.logs.beans.UserTabComments;

/**
 * @comment 日志操作业务层开放的服务
 * @author zzze
 * @date 2012-5-25
 * @version 1.0
 */
public interface LogService extends BaseService<UcLogs, String>{
	void add(UcLogs log);
	/**
	 * @comment 业务层分页方法 
	 * @param pager
	 * @param config
	 * @return
	 * @version: 1.0
	 */
	Pager list(Pager pager, UcLogs logs);
	
	/**
	 * @comment 获取表的属性
	 * @return
	 * @version: 1.0
	 */
	Map<String,UserTabComments> getUserTabComments();
}
/**
 * @filename LogUtil.java
 * @author zzze
 * @date Jan 9, 2013
 * @vsersion 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.logs.util;

import javax.servlet.ServletContext;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hopsun.framework.util.Util;
import com.hopsun.subgroups.logs.service.LogService;

/**
 *@comment 日志封装进ServletContext的工具类 
 *@author zzze
 *@date Jan 9, 2013
 *@version 1.0
 */
public final class LogUtil {
	private static LogUtil logUtilSingleton;
	
	private LogUtil(){}
	public static LogUtil getInstance(){
		if(Util.checkNull(logUtilSingleton)){
			logUtilSingleton = new LogUtil();
		}
		return logUtilSingleton;
	}

	/**
	 * @comment 加载表备注及列备注进ServletContext 
	 * @param context
	 * @version: 1.0
	 */
	public static void loadTabColsComments(final ServletContext context){
		final LogService logService = (LogService) WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean("logService");
		context.setAttribute("userTabComments", logService.getUserTabComments());
	}
}

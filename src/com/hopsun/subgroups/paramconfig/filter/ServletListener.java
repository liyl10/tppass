/**
 * @filename ServletListener.java
 * @author zzze
 * @date Dec 25, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.paramconfig.filter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.hopsun.subgroups.logs.util.LogUtil;
import com.hopsun.subgroups.paramconfig.util.ParamConfigUtil;
import com.hopsun.tppas.api.util.LoadCacheUtil;


/**
 *@comment 系统初始化 
 *@author zzze
 *@date Dec 28, 2012
 *@version 1.0
 */
public class ServletListener implements ServletContextListener {
	public void contextDestroyed(final ServletContextEvent arg0) {
		//上下文销毁
	}
	/**
	 * 初始化方法
	 */
	public void contextInitialized(final ServletContextEvent event) {
		final ServletContext context = event.getServletContext();
		ParamConfigUtil.setServletContext(event.getServletContext());//添加这一步的原因在于StrutsUtil无法在tomcat启动中获取ServletPath
		ParamConfigUtil.loadConfigs(context);//系统参数初始化
		ParamConfigUtil.loadProperties(context);//加载properties配置文件
		LogUtil.loadTabColsComments(context);//scheme中的comments获取初始化
		//LoadCacheUtil.loadMitemDatas(context);
		//LoadCacheUtil.loadMitemDatasByTypeId(context);
		//LoadCacheUtil.loadMitemDatasByPitemId(context);
		LoadCacheUtil.loadTprojectType(context);
	}
}

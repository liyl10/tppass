/**
 * @filename LogProxy.java
 * @author zzze
 * @date Dec 25, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.logs.aop;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Repository;

import com.hopsun.framework.util.StrutsUtil;
import com.hopsun.framework.util.Util;
import com.hopsun.subgroups.entity.UcLogs;
import com.hopsun.subgroups.logs.beans.UserTabComments;
import com.hopsun.subgroups.logs.service.LogService;
import com.hopsun.subgroups.logs.util.RequestUtil;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigDefaultBean;
import com.hopsun.subgroups.paramconfig.util.ParamConfigUtil;

/**
 * @comment SpringAOP进行项目日志模块的工作
 * @author zzze
 * @date Dec 26, 2012
 * @version 1.0
 */
@Aspect
@Repository
@SuppressWarnings("all")
public class LogProxy {
	public final static Logger LOGGER = Logger.getLogger(LogProxy.class.getName());
	@Resource
	public transient LogService logService;

	/**
	 * @comment 拦截删除方法
	 * @version: 1.0
	 */
	@Pointcut("execution(* com.hopsun.framework.base.dao.impl.BaseDaoImpl.delete(..))")
	private void ftrDelete() { // NOPMD by zzze on 1/15/13 3:53 PM
	}

	/**
	 * @comment 拦截添加方法
	 * @version: 1.0
	 */
	@Pointcut("execution(* com.hopsun.framework.base.dao.impl.BaseDaoImpl.save(..))")
	private void ftrInsert() { // NOPMD by zzze on 1/15/13 3:53 PM
	}

	/**
	 * @comment 拦截修改方法
	 * @version: 1.0
	 */
	@Pointcut("execution(* com.hopsun.framework.base.dao.impl.BaseDaoImpl.update(..))")
	private void ftrModify() { // NOPMD by zzze on 1/15/13 3:54 PM
	}

	/**
	 * @comment 方法执行完成后进行日志处理
	 * @param point
	 * @return
	 * @throws Throwable
	 * @version: 1.0
	 */
	@Around("ftrDelete()||ftrInsert()||ftrModify()")
	public Object invoke(final ProceedingJoinPoint point) throws Throwable {
		/**
		 * 执行方法
		 */
		final UcLogs logBean = new UcLogs();
		Object obj = null; // NOPMD by zzze on 1/15/13 6:08 PM
		try {
			obj = point.proceed();
		} catch (Exception e) {
			logBean.setOperaResult(ParamConfigUtil.getBeans("OPERA_RESULT", "failure").getDesc());
			LOGGER.error(e.fillInStackTrace());
		}
		/**
		 * 日志记录
		 */
		//获取建表加入的comments
		//获取全局的日志开关
		if(ParamConfigUtil.getDefaultBeans("LOG_SWITCH").getValue().equals("1")){
			/**
			 * 单个对象的开关,默认没有在系统参数中进行配置的类将记录日志
			 */
			//标记是否在系统参数中进行的日志开关的配置
			//默认操作是否记录日志
			getSwitchForClazz(point, logBean, point.getArgs()[0]);//记录没有配置在系统参数中的类
		}
		return obj;
	}

	/**
	 * @comment 单个对象是否记录日志 
	 * @param point
	 * @param logBean
	 * @param firstParams
	 * @param clazzName
	 * @param comments
	 * @return
	 * @version: 1.0
	 */
	private boolean getSwitchForClazz(final ProceedingJoinPoint point,
			final UcLogs logBean, final Object firstParams) {
		boolean defaultSwitch = Boolean.parseBoolean(ParamConfigUtil.getDefaultBeans("LOG_SWITCH_OTHERS").getValue());//对象默认开关 // NOPMD by zzze on 1/15/13 6:08 PM
		loop1:for(ParamConfigDefaultBean defaultBean :ParamConfigUtil.getBeans("LOG_SWITCH_AND_CH_DESC").getChildList()){
			if(firstParams.getClass().getName().equalsIgnoreCase(defaultBean.getCode())){//取出当前操作的类
				if(defaultBean.getValue().equalsIgnoreCase("on")){
					log(point, logBean,firstParams);
				}
				defaultSwitch = false;
				break loop1;
			}
		}
		if(defaultSwitch){
			log(point, logBean,firstParams);
		}
		return defaultSwitch;
	}

	/**
	 * @comment 日志添加操作
	 * @param point
	 * @param logBean
	 * @param firstParams
	 * @version: 1.0
	 * @param clazzName 
	 */
	private void log(final ProceedingJoinPoint point, final UcLogs logBean, final Object firstParams) {
		
		// 日志处理工作
		//用户名
		//操作类型中文名
		final String operaChName = ParamConfigUtil.getBeans("OPERATION_TYPE",point.getSignature().getName()).getDesc();
		//检索是否为持久化对象
		logBean.setCreateDate(new Date());// 添加时间
		//操作中文名
		logBean.setLogOpera(operaChName);// 操作名称
		logBean.setCreateUserName(getUserName());
		logBean.setOperaResult(ParamConfigUtil.getBeans("OPERA_RESULT","success").getDesc());
		logBean.setLogSource(ParamConfigUtil.getBeans("SOURCE","SCenter").getDesc());
		logBean.setLogIp(RequestUtil.getRequest().getRemoteAddr());
		
		//对象中文名
		logBean.setLogChDetail(getLogChDetail(logBean, firstParams, operaChName).toString());
		logService.add(logBean);
	}

	/**
	 * @comment 填充日志中文描述 
	 * @param logBean
	 * @param firstParams
	 * @param operaChName
	 * @return
	 * @version: 1.0
	 */
	private StringBuilder getLogChDetail(final UcLogs logBean,
			final Object firstParams, final String operaChName) {
		final String ObjChName = fillLogBean(logBean, firstParams, getLogObj(firstParams));
		final String temp  = getLogObj(getLogObj(firstParams), ObjChName);
		final StringBuilder builder = new StringBuilder();
		if(Util.checkNotNull(temp)){//如果系统参数中没有配置日志对象，则不记录中文描述
			builder.append(Util.checkNotNull(getUserName())?getUserName():"未知用户").append(Util.checkNotNull(operaChName)?operaChName:"未知操作").append("了").append(Util.checkNotNull(temp)?temp:"未知对象").toString();
		}
		return builder;
	}

	/**
	 * @comment 获取用户名
	 * @return
	 * @version: 1.0
	 */
	private String getUserName() {
		//从request中获取cas返回的用户名
		String userName = RequestUtil.getUserName(); // NOPMD by zzze on 1/15/13 6:08 PM
		//从request中获取不到的时候，从session中获取
//		if(Util.checkNull(userName)&&Util.checkNotNull(RequestUtil.getRequest())&&Util.checkNotNull(RequestUtil.getRequest().getSession())){
//			final Object frontUser = RequestUtil.getRequest().getSession().getAttribute("member");
////			final Object manageUser = RequestUtil.getRequest().getSession().getAttribute("userMap");
//			if(Util.checkNotNull(frontUser)){
//				//从前台用户中获取username放入
//				userName = ((UcActInfo)frontUser).getUserCode();
//			}/*else if(Util.checkNotNull(manageUser)){
//				//从管理中心用户中获取username放入
//			}*/
//		}
		return userName;
	}

	/**
	 * @comment 获取类名 
	 * @param firstParams
	 * @return
	 * @version: 1.0
	 */
	private String getLogObj(final Object firstParams) {
		String clazzName = firstParams.getClass().getName();//获取类名
		if(clazzName.contains("_")){//过滤代理类
			clazzName = firstParams.getClass().getSuperclass().getName();
		}
		return clazzName;
	}

	/**
	 * @comment 解析操作对象中文名
	 * @param logBean
	 * @param firstParams
	 * @param clazzName
	 * @return
	 * @version: 1.0
	 */
	private String fillLogBean(final UcLogs logBean,
			final Object firstParams, final String clazzName) {
		String temp  = null; // NOPMD by zzze on 1/15/13 6:08 PM
		final UserTabComments comments = ((Map<String, UserTabComments>) StrutsUtil.getApplication().getAttribute("userTabComments")).get(clazzName);
		if(Util.checkNotNull(comments)){
			temp = comments.getComments();//读取库里的comment
			logBean.setLogDetail(getLogDetail(firstParams.toString(),comments));// 日志信息
			//操作对象中文名
			if(Util.checkNotNull(comments.getComments())){
				logBean.setLogObj(comments.getComments());// 操作对象
			}else{
				logBean.setLogObj(getLogObj(firstParams.getClass().getName()));
			}
		}else{
			logBean.setLogDetail(firstParams.toString());// 日志信息
			logBean.setLogObj(firstParams.getClass().getName());// 操作对象
		}
		return temp;
	}
	/**
	 * @comment 解析操作对象中文 
	 * @param clazzName
	 * @param ObjChName
	 * @return
	 * @version: 1.0
	 */
	private String getLogObj(final String clazzName, final String ObjChName) {
		String temp = ObjChName; // NOPMD by zzze on 1/15/13 6:08 PM
		if(Util.checkNull(ObjChName)){//为空的时候读取系统参数配置
			final ParamConfigDefaultBean defaultBean =ParamConfigUtil.getBeans(ParamConfigUtil.getBeans("LOG_SWITCH_AND_CH_DESC").getChildList(), clazzName);
			if(Util.checkNotNull(defaultBean)){
				temp = defaultBean.getDesc();
			}
		}
		return temp;
	}
	/**
	 * @comment 解析日志明细，去除空格,并转换为中文
	 * @param target
	 * @return
	 * @version: 1.0
	 * @param comments 
	 */
	private String getLogDetail(final String target, final UserTabComments comments) {
		/**
		 * 去除空格及无意义的字符
		 */
		String temp = target;
		StringBuilder result = new StringBuilder();
		if(temp.indexOf('(')!=-1&&temp.lastIndexOf(')')!=-1){
			temp = temp.substring(temp.indexOf('(')+1,temp.lastIndexOf(')'));
		}
		if(temp.length()>0&& temp.contains("<!--ENTITY_SEPERATE-->")){
			final String[] firstArray = temp.split("<!--ENTITY_SEPERATE-->");
			for(String first : firstArray){
				getLogDetail(comments, result, first, first.split("="));//解析持久化对象，填充返回结果 
			}
			if(result.length()>0){
				result = result.deleteCharAt(result.toString().length()-1);
			}
		}else{
			result.append(temp);
		}
		return result.toString();
	}

	/**
	 * @comment 解析持久化对象，填充返回结果 
	 * @param comments
	 * @param result
	 * @param first
	 * @param secondArray
	 * @version: 1.0
	 */
	private void getLogDetail(final UserTabComments comments,
			final StringBuilder result, final String first, final String[] secondArray) {
		if(secondArray.length==2&&!"<>".equals(secondArray[1])&&!"[]".equals(secondArray[1])&&!"<null>".equals(secondArray[1])&&Util.checkNotNull(secondArray[1])&&Util.checkNotNull(secondArray[1].trim())){
			if(Util.checkNotNull(comments.getCols().get(secondArray[0].trim()))){
				if(Util.checkNotNull(comments.getCols().get(secondArray[0].trim()).getComments())){
					result.append(comments.getCols().get(secondArray[0].trim()).getComments()).append("=").append(secondArray[1].trim()).append(",");
				}else{
					result.append(secondArray[0]).append("=").append(secondArray[1].trim()).append(",");
				}
			}else{
				result.append(first).append(",");
			}
		}
	}
	/**
	 * @comment 处理操作对象 
	 * @param logObj
	 * @return
	 * @version: 1.0
	 */
	private String getLogObj(final String logObj){
		String result = logObj; // NOPMD by zzze on 1/15/13 6:08 PM
		//处理操作对象
		loop1:for(ParamConfigDefaultBean defaultBean : ParamConfigUtil.getBeans("LOG_SWITCH_AND_CH_DESC").getChildList()){
			if(defaultBean.getCode().equalsIgnoreCase(logObj)){
				result = defaultBean.getDesc();
				break loop1;
			}
		}
		return result;
	}
}

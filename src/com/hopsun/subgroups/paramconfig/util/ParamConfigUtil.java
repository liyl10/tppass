/**
 * @filename ParamConfigUtil.java
 * @author zzze
 * @date Dec 27, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.paramconfig.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hopsun.framework.util.Util;
import com.hopsun.subgroups.entity.UcParamConfig;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigBean;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigDefaultBean;
import com.hopsun.subgroups.paramconfig.service.ConfigService;


/**
 *@comment 加载系统参数配置文件 
 *@author zzze
 *@date Dec 28, 2012
 *@version 1.0
 */
public final class ParamConfigUtil {
	public final static Logger LOGGER = Logger.getLogger(ParamConfigUtil.class.getName());
	public Map<String,ParamConfigBean> mapping = new HashMap<String,ParamConfigBean>();
	private static ParamConfigUtil paramSingleton;
	private static ServletContext context;
	private ConfigService configService;

	
	public ConfigService getConfigService() {
		return configService;
	}
	public void setConfigService(final ConfigService configService) {
		this.configService = configService;
	}
	private ParamConfigUtil(){}
	public static ParamConfigUtil getInstance(){
		if(Util.checkNull(paramSingleton)){
			paramSingleton = new ParamConfigUtil();
		}
		return paramSingleton;
	}
	/**
	 * 加载type_config xml
	 * 
	 * @param xmlPath
	 * @throws IOException
	 * @throws JDOMException
	 */
	public void loadConfigXML(final String xmlPath){
		final SAXBuilder sax = new SAXBuilder();
		try {
			final Document document = sax.build(new File(xmlPath));
			if(Util.checkNotNull(document)){
				parseBeanXML(document);
			}
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.fillInStackTrace());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.fillInStackTrace());
		}
		// 解析xml

	}
	/**
	 * 解析属性Type配置XML
	 * @param document
	 */
	protected void parseBeanXML(final Document document){
		final Element root = document.getRootElement();
		final List<Element> classlist = root.getChildren("types");
		for(Element element : classlist){
			fillUcParamConfig(element);
		}
	}
	/**
	 * @comment 填充元素 
	 * @param element
	 * @version: 1.0
	 */
	private void fillUcParamConfig(final Element element) {
		final UcParamConfig ucParamConfig = new UcParamConfig();
		ucParamConfig.setCreateDate(new Date());
		ucParamConfig.setCreateUserName("admin");
		ucParamConfig.setModifyDate(new Date());
		ucParamConfig.setModifyUserName("admin");
		ucParamConfig.setParamName(element.getAttributeValue("desc"));
		ucParamConfig.setParamCode(element.getAttributeValue("name").toUpperCase());
		ucParamConfig.setParamSource(((ParamConfigBean)  ParamConfigUtil.getServletContext().getAttribute("SOURCE")).getBeansByCode("SCenter").getDesc());
		final StringBuilder builder = new StringBuilder();
		//获取各大类下的子类
		final List<Element> typeList = element.getChildren();
		// 遍历type集合
		for (Element typeElement : typeList) {
			builder.append(typeElement.getAttributeValue("code")+"-");
			builder.append(typeElement.getAttributeValue("name")+"-");
			builder.append(typeElement.getAttributeValue("desc")+"-");
			builder.delete(builder.toString().length()-1,builder.toString().length());
			builder.append(",");
		}
		ucParamConfig.setParamChoose(builder.substring(0,builder.length()-1));
		ucParamConfig.setParamUseage(typeList.get(0).getAttributeValue("code")+"-"+typeList.get(0).getAttributeValue("name")+"-"+typeList.get(0).getAttributeValue("desc"));
		configService.save(ucParamConfig);
	}
	
	/**
	 * @comment 系统参数初始化
	 * @param context
	 * @version: 1.0
	 */
	public static Map<String, ParamConfigBean> loadConfigs(final List<UcParamConfig> configList) {
		final Map<String, ParamConfigBean> configMap = new HashMap<String, ParamConfigBean>();
		for(UcParamConfig config :configList){//迭代系统参数
			//加载解析系统参数对象
			//封装ParamConfigBean
			fillUcParamConfig(configMap, config);
		}
		return configMap;
	}
	/**
	 * @comment 填充 UcParamConfig
	 * @param configMap
	 * @param config
	 * @version: 1.0
	 */
	private static void fillUcParamConfig(
			final Map<String, ParamConfigBean> configMap, final UcParamConfig config) {
		final ParamConfigBean typeBean = new ParamConfigBean();
		typeBean.setName(config.getParamCode());
		typeBean.setDesc(config.getParamName());
		//解析系统配置参数
		final List<ParamConfigDefaultBean> childList = new ArrayList<ParamConfigDefaultBean>();//将所有的可选项封装为list
		if(config.getParamChoose().contains(",")){
			final String[] firstLevel = config.getParamChoose().split(",");
			for(String first : firstLevel){
				childList.add(getDefaultBean(first));//解析可选项
			}
		}else{//单个子集的解析
			childList.add(getDefaultBean(config.getParamChoose()));//解析可选项
		}
		typeBean.setChildList(childList);//存入可选项
		typeBean.setConfigDefault(getDefaultBean(config.getParamUseage()));//存入默认选项
		//存入缓存
		configMap.put(config.getParamCode(), typeBean);
	}
	/**
	 * @comment 系统参数初始化
	 * @param context
	 * @version: 1.0
	 */
	public static void loadConfigs(final ServletContext context) {
		ConfigService configService = (ConfigService) WebApplicationContextUtils.getWebApplicationContext(context).getBean("configService");//获取系统参数service
		List<UcParamConfig> configList = configService.getAll();//获取所有的系统参数
		for(UcParamConfig config :configList){//迭代系统参数
			fillUcParamConfig(context, config);
		}
	}
	/**
	 * @comment 填充UcParamConfig 
	 * @param context
	 * @param config
	 * @version: 1.0
	 */
	private static void fillUcParamConfig(final ServletContext context,
			final UcParamConfig config) {
		//加载解析系统参数对象
		//封装ParamConfigBean
		final ParamConfigBean typeBean = new ParamConfigBean();
		typeBean.setName(config.getParamCode());
		typeBean.setDesc(config.getParamName());
		//解析可选配置参数
		final List<ParamConfigDefaultBean> childList = new ArrayList<ParamConfigDefaultBean>();//将所有的可选项封装为list
		if(config.getParamChoose().contains(",")){//多个子集的解析
			final String[] firstLevel = config.getParamChoose().split(",");
			for(String first : firstLevel){
				childList.add(getDefaultBean(first));//解析可选项
			}
		}else{//单个子集的解析
			childList.add(getDefaultBean(config.getParamChoose()));//解析可选项
		}
		typeBean.setChildList(childList);//存入可选项
		typeBean.setConfigDefault(getDefaultBean(config.getParamUseage()));//存入默认选项
		//存入缓存
		context.setAttribute(config.getParamCode(), typeBean);
	}
	/**
	 * @comment 根据分隔符"-"解析可选项或默认选择项 
	 * @param usage
	 * @return
	 * @version: 1.0
	 */
	private static ParamConfigDefaultBean getDefaultBean(final String usage) {
		final ParamConfigDefaultBean defaultConfig = new ParamConfigDefaultBean();//存放子元素
		if(usage.contains("-")){
			final String[] codes = usage.split("-");
			if(codes.length==3){
				defaultConfig.setValue(codes[0].replaceAll("\r\n",""));//存入值,去掉回车
				defaultConfig.setCode(codes[1]);//存入CODE
				defaultConfig.setDesc(codes[2]);//存入展示名称
			}
		}
		defaultConfig.setOriginally(usage);//存入未经处理的实际值
		return defaultConfig;
	}
	/**
	 * @comment 对外提供ServletContext中的defaultBean 
	 * @param code
	 * @return
	 * @version: 1.0
	 */
	public static ParamConfigDefaultBean getDefaultBeans(final String code){
		return ((ParamConfigBean)ParamConfigUtil.getServletContext().getAttribute(code)).getConfigDefault();
	}
	/**
	 * @comment 对外提供ServletContext中的defaultBean 
	 * @param code
	 * @return
	 * @version: 1.0
	 */
	public static ParamConfigBean getBeans(final String code){
		return (ParamConfigBean)ParamConfigUtil.getServletContext().getAttribute(code);
	}
	/**
	 * @comment 对外提供ServletContext中的defaultBean 
	 * @param code
	 * @return
	 * @version: 1.0
	 */
	public static ParamConfigDefaultBean getBeans(final String fCode,final String cCode){
		return ((ParamConfigBean)ParamConfigUtil.getServletContext().getAttribute(fCode)).getBeansByCode(cCode);
	}
	
	public static ParamConfigDefaultBean getBeans(final List<ParamConfigDefaultBean> childList,final String code){
		ParamConfigDefaultBean result = null; // NOPMD by Administrator on 1/15/13 6:09 PM
		if(Util.checkNull(code)){//为空的时候读取系统参数配置
			loop1:for(ParamConfigDefaultBean defaultBean : ParamConfigUtil.getBeans("LOG_SWITCH_AND_CH_DESC").getChildList()){
				if(code.equals(defaultBean.getCode())){//获取中文名称
					result = defaultBean;
					break loop1;
				}
			}
		}
		return result;
	}
	public static void setServletContext(final ServletContext context){
		ParamConfigUtil.context = context;
	}
	
	public static ServletContext getServletContext(){
		return ParamConfigUtil.context;
	}

	/**
	 * 加载properties配置文件
	 */
	public static void loadProperties(ServletContext context) {
		Properties prop = null;
		FileInputStream in = null;
		
		File file = new File(context.getRealPath("")+"/resource/properties/hcsp_resources.properties");//定位properties路径
		if (file.exists()) {
			try {
				prop = new Properties();
				in = new FileInputStream(file);
				prop.load(in);//加载properties
				//放置properties于servletContext中
				Iterator<Entry<Object,Object>> iter = prop.entrySet().iterator();
				while(iter.hasNext()){
					Entry<Object,Object> entry = iter.next();
					if(Util.checkNotNull(entry.getKey())&&Util.checkNotNull(entry.getValue())){
						context.setAttribute(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()));
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

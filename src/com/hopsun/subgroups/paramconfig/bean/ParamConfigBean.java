/**
 * @filename ParamConfigBean.java
 * @author zzze
 * @date Dec 27, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.paramconfig.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *@comment 解析系统参数所需的bean
 *@author zzze
 *@date Dec 28, 2012
 *@version 1.0
 */
@SuppressWarnings("unchecked")
public class ParamConfigBean {
	//参数名称
	private String name;
	//参数描述
	private String desc;
	//参数子集
	private List<ParamConfigDefaultBean> childList = new ArrayList<ParamConfigDefaultBean>();
	//默认
	private ParamConfigDefaultBean configDefault = new ParamConfigDefaultBean(); 
	public ParamConfigDefaultBean getConfigDefault() {
		return configDefault;
	}
	public void setConfigDefault(final ParamConfigDefaultBean configDefault) {
		this.configDefault = configDefault;
	}
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(final String desc) {
		this.desc = desc;
	}
	public List<ParamConfigDefaultBean> getChildList() {
		return childList;
	}
	public void setChildList(final List<ParamConfigDefaultBean> childList) {
		this.childList = childList;
	}
	/**
	 * @comment 根据code获取beans 
	 * @param code
	 * @return
	 * @version: 1.0
	 */
	public ParamConfigDefaultBean getBeansByCode(final String code){
		ParamConfigDefaultBean defaultBean = null; // NOPMD by zzze on 1/15/13 1:02 PM
		loop1:for(ParamConfigDefaultBean configBean :this.childList){
			if(configBean.getCode().equalsIgnoreCase(code)){
				defaultBean=configBean;
				break loop1;
			}
		}
		return defaultBean;
	}
	/**
	 * @comment 根据code获取value
	 * @param code
	 * @return
	 * @version: 1.0
	 */
	public String getValueByCode(final String code){
		String value=""; // NOPMD by zzze on 1/15/13 1:02 PM
		loop1:for(ParamConfigDefaultBean configBean :this.childList){
			if(configBean.getCode().equalsIgnoreCase(code)){
				value=configBean.getValue();
				break loop1;
			}
		}
		return value;
	}
}

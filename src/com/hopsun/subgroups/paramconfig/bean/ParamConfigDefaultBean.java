/**
 * @filename ParamConfigDefaultBean.java
 * @author zzze
 * @date Dec 27, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.paramconfig.bean;


/**
 *@comment 解析系统参数所需的bean
 *@author zzze
 *@date Dec 28, 2012
 *@version 1.0
 */
public class ParamConfigDefaultBean {
	//参数code
	private String code;
	//参数值
	private String value;
	//参数描述
	private String desc;
	//未解析的值
	private String originally;
	public String getOriginally() {
		return originally;
	}
	public void setOriginally(final String originally) {
		this.originally = originally;
	}
	public String getCode() {
		return code;
	}
	public void setCode(final String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(final String value) {
		this.value = value;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(final String desc) {
		this.desc = desc;
	}
	
}

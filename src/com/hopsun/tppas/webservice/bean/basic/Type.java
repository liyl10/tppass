/**
 * @filename Industry.java
 * @author wangxiaodong
 * @date 2013-9-27
 * @vsersion 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */
package com.hopsun.tppas.webservice.bean.basic;

/**
 * @comments 单位所属行业领域(industry)
 * @author wangxiaodong
 * @date 2013-9-27
 * @version 1.0
 */
public class Type {
	// 类型ID
	private String typeId;
	// 类型名称
	private String typeName;
	// 类型code
	private String typeCode;
	// 企业对应的值
	private String content;

	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Type(String typeId, String typeName, String typeCode, String content) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeCode = typeCode;
		this.content = content;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

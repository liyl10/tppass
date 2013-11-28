/**
 * @filename LogAction.java
 * @author zzze
 * @date Jan 5, 2013
 * @vsersion 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.logs.beans;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;


/**
 *@comment 表对应字段的属性及备注类 
 *@author zzze
 *@date Jan 15, 2013
 *@version 1.0
 */
public class UserTabComments implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tableName;
	private String tableType;
	private String comments;
	private Map<String,UserTabCols> cols;

	// Constructors


	public UserTabComments() {
		super();
	}

	/** minimal constructor */
	public UserTabComments(final String tableName) {
		this.tableName = tableName;
	}

	/** full constructor */
	public UserTabComments(final String tableName,final  String tableType,final  String comments) {
		this.tableName = tableName;
		this.tableType = tableType;
		this.comments = comments;
	}

	// Property accessors

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(final String tableName) {
		this.tableName = tableName;
	}

	public String getTableType() {
		return this.tableType;
	}

	public void setTableType(final String tableType) {
		this.tableType = tableType;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(final String comments) {
		this.comments = comments;
	}
	

	public Map<String, UserTabCols> getCols() {
		return cols;
	}

	public void setCols(final Map<String, UserTabCols> cols) {
		this.cols = cols;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("tableName", this.tableName)
				.append("comments", this.comments).append("cols", this.cols)
				.append("tableType", this.tableType).toString();
	}

	
	
}
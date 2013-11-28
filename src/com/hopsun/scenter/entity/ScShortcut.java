/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.scenter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *@comments 用户权限快捷方式实体类
 *@author dulei(dulei@hopsun.cn)
 *@date Jan 5, 2013 8:13:29 AM
 *@version 1.0
 */
@Entity
@Table(name = "SC_SHORTCUT",  uniqueConstraints = {})
public class ScShortcut implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1687734246681373383L;
	//快捷方式id
	private String shorId;
	//快捷方式所属用户
	private ScUsers scUsers;
	//快捷方式所属权限
	private ScAuth scAuth;
	//快捷方式排序
	private Long shorOrder;

	// Constructors

	/** default constructor */
	public ScShortcut() {
	}

	/** minimal constructor */
	public ScShortcut(String shorId) {
		this.shorId = shorId;
	}

	/** full constructor */
	public ScShortcut(String shorId, ScUsers scUsers, ScAuth scAuth, Long shorOrder) {
		this.shorId = shorId;
		this.scUsers = scUsers;
		this.scAuth = scAuth;
		this.shorOrder = shorOrder;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SHOR_ID",columnDefinition="NVARCHAR2(36)",  nullable = false, insertable = true, updatable = true)
	public String getShorId() {
		return this.shorId;
	}

	public void setShorId(String shorId) {
		this.shorId = shorId;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public ScUsers getScUsers() {
		return this.scUsers;
	}

	public void setScUsers(ScUsers scUsers) {
		this.scUsers = scUsers;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "AUTH_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public ScAuth getScAuth() {
		return this.scAuth;
	}

	public void setScAuth(ScAuth scAuth) {
		this.scAuth = scAuth;
	}

	@Column(name = "SHOR_ORDER", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)
	public Long getShorOrder() {
		return this.shorOrder;
	}

	public void setShorOrder(Long shorOrder) {
		this.shorOrder = shorOrder;
	}

	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */
	public String toString()
	{
	    final String TAB = "    ";
	    
	    String retValue = "";
	    
	    retValue = "ScShortcut ( "
	        + super.toString() + TAB
	        + "shorId = " + this.shorId + TAB
//	        + "scUsers = " + this.scUsers + TAB
//	        + "scAuth = " + this.scAuth + TAB
	        + "shorOrder = " + this.shorOrder + TAB
	        + " )";
	
	    return retValue;
	}

}
/**
 * @filename UcLogs.java
 * @author zzze
 * @date Dec 25, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.entity;
// default package

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


/**
 *@comment 日志持久层对象 
 *@author zzze
 *@date Dec 27, 2012
 *@version 1.0
 */
@Entity
@Table(name = "UC_LOGS", uniqueConstraints = {})
public class UcLogs implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String logId;
	private String logObj;
	private String logOpera;
	private String logDetail;
	private Date createDate;
	private String logSource;
	private String logChDetail;
	private String createUserName;
	private String operaResult;
	private String logIp;

	// Constructors

	/** default constructor */
	public UcLogs() {
		super();
	}

	/** minimal constructor */
	public UcLogs(final String logId) {
		this.logId = logId;
	}

	/** full constructor */
	public UcLogs(final String logId,final  String logObj,final  String logOpera,
			final String logDetail, final Date createDate, final String logSource,
			final String logChDetail, final String createUserName, final String operaResult) {
		this.logId = logId;
		this.logObj = logObj;
		this.logOpera = logOpera;
		this.logDetail = logDetail;
		this.createDate = createDate;
		this.logSource = logSource;
		this.logChDetail = logChDetail;
		this.createUserName = createUserName;
		this.operaResult = operaResult;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "LOG_ID", nullable = false, insertable = true, updatable = true,length=72)
	public String getLogId() {
		return this.logId;
	}

	public void setLogId(final String logId) {
		this.logId = logId;
	}

	@Column(name = "LOG_OBJ", unique = false, nullable = true, insertable = true, updatable = true,length=400)
	public String getLogObj() {
		return this.logObj;
	}

	public void setLogObj(final String logObj) {
		this.logObj = logObj;
	}

	@Column(name = "LOG_OPERA", unique = false, nullable = true, insertable = true, updatable = true,length=15)
	public String getLogOpera() {
		return this.logOpera;
	}

	public void setLogOpera(final String logOpera) {
		this.logOpera = logOpera;
	}
	@Lob  
    @Basic(fetch = FetchType.LAZY)
	@Column(name = "LOG_DETAIL", unique = false, nullable = true, insertable = true, updatable = true)
	public String getLogDetail() {
		return this.logDetail;
	}

	public void setLogDetail(final String logDetail) {
		this.logDetail = logDetail;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(final Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "LOG_SOURCE", unique = false, nullable = true, insertable = true, updatable = true,length=20)
	public String getLogSource() {
		return this.logSource;
	}

	public void setLogSource(final String logSource) {
		this.logSource = logSource;
	}
	@Lob  
    @Basic(fetch = FetchType.LAZY)
	@Column(name = "LOG_CH_DETAIL", unique = false, nullable = true, insertable = true, updatable = true)
	public String getLogChDetail() {
		return this.logChDetail;
	}

	public void setLogChDetail(final String logChDetail) {
		this.logChDetail = logChDetail;
	}

	@Column(name = "CREATE_USER_NAME", unique = false, nullable = true, insertable = true, updatable = true,length=36)
	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(final String createUserName) {
		this.createUserName = createUserName;
	}

	@Column(name = "OPERA_RESULT", unique = false, nullable = true, insertable = true, updatable = true,length=10)
	public String getOperaResult() {
		return this.operaResult;
	}

	public void setOperaResult(final String operaResult) {
		this.operaResult = operaResult;
	}
	@Column(name = "LOG_IP", unique = false, nullable = true, insertable = true, updatable = true,length=20)
	public String getLogIp() {
		return logIp;
	}

	public void setLogIp(final String logIp) {
		this.logIp = logIp;
	}

	
}
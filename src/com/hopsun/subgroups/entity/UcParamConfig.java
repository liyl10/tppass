package com.hopsun.subgroups.entity;

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
 *@comments 系统参数配置实体类
 *@author zzze(zhangzhenze@hopsun.cn)
 *@date Jan 5, 2013 8:13:29 AM
 *@version 1.0
 */
@Entity
@Table(name = "UC_PARAM_CONFIG",uniqueConstraints = {})
public class UcParamConfig implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7645495438845878687L;
	private String paramId;
	private String paramName;
	private String paramCode;
	private String paramChoose;
	private String paramUseage;
	private String description;
	private String paramSource;
	private String createUserName;
	private Date createDate;
	private String modifyUserName;
	private Date modifyDate;

	// Constructors

	/** default constructor */
	public UcParamConfig() {
	}

	/** minimal constructor */
	public UcParamConfig(String paramId) {
		this.paramId = paramId;
	}

	/** full constructor */
	public UcParamConfig(String paramId, String paramName, String paramCode,
			String paramChoose, String paramUseage, String description,
			String paramSource, String createUserName, Date createDate,
			String modifyUserName, Date modifyDate) {
		this.paramId = paramId;
		this.paramName = paramName;
		this.paramCode = paramCode;
		this.paramChoose = paramChoose;
		this.paramUseage = paramUseage;
		this.description = description;
		this.paramSource = paramSource;
		this.createUserName = createUserName;
		this.createDate = createDate;
		this.modifyUserName = modifyUserName;
		this.modifyDate = modifyDate;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PARAM_ID", nullable = false, insertable = true, updatable = true,length=72)
	public String getParamId() {
		return this.paramId;
	}

	public void setParamId(String paramId) {
		this.paramId = paramId;
	}

	@Column(name = "PARAM_NAME", unique = false, nullable = true, insertable = true, updatable = true,length=72)
	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	@Column(name = "PARAM_CODE", unique = false, nullable = true, insertable = true, updatable = true,length=400)
	public String getParamCode() {
		return this.paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}
	@Lob  
    @Basic(fetch = FetchType.LAZY)
	@Column(name = "PARAM_CHOOSE", unique = false, nullable = true, insertable = true, updatable = true)
	public String getParamChoose() {
		return this.paramChoose;
	}

	public void setParamChoose(String paramChoose) {
		this.paramChoose = paramChoose;
	}
	@Lob  
    @Basic(fetch = FetchType.LAZY)
	@Column(name = "PARAM_USEAGE", unique = false, nullable = true, insertable = true, updatable = true)
	public String getParamUseage() {
		return this.paramUseage;
	}

	public void setParamUseage(String paramUseage) {
		this.paramUseage = paramUseage;
	}
	@Lob  
    @Basic(fetch = FetchType.LAZY)
	@Column(name = "DESCRIPTION", unique = false, nullable = true, insertable = true, updatable = true)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "PARAM_SOURCE", unique = false, nullable = true, insertable = true, updatable = true,length=36)
	public String getParamSource() {
		return this.paramSource;
	}

	public void setParamSource(String paramSource) {
		this.paramSource = paramSource;
	}

	@Column(name = "CREATE_USER_NAME", unique = false, nullable = true, insertable = true, updatable = true,length=36)
	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "MODIFY_USER_NAME", unique = false, nullable = true, insertable = true, updatable = true,length=36)
	public String getModifyUserName() {
		return this.modifyUserName;
	}

	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFY_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
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
	    final String TAB = "<!--ENTITY_SEPERATE-->";
	    
	    String retValue = "";
	    
	    retValue = "UcParamConfig ( "
	        
	        + "paramId = " + this.paramId + TAB
	        + "paramName = " + this.paramName + TAB
	        + "paramCode = " + this.paramCode + TAB
	        + "paramChoose = " + this.paramChoose + TAB
	        + "paramUseage = " + this.paramUseage + TAB
	        + "description = " + this.description + TAB
	        + "paramSource = " + this.paramSource + TAB
	        + "createUserName = " + this.createUserName + TAB
	        + "createDate = " + this.createDate + TAB
	        + "modifyUserName = " + this.modifyUserName + TAB
	        + "modifyDate = " + this.modifyDate + TAB
	        + " )";
	
	    return retValue;
	}

}
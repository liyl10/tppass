package com.hopsun.tppas.entity;

import java.sql.Timestamp;

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
 * TcompanyFoundationB entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_COMPANY_FOUNDATION_B")
public class TcompanyFoundationB implements java.io.Serializable {
	
	private static final long serialVersionUID = 6615110995474154607L;

	// Fields
	private String companyFoundationId;
	private TprojectApplication tprojectApplication;
	private String companyFoundation;
	private String appendixFlag;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String remark;

	// Constructors

	/** default constructor */
	public TcompanyFoundationB() {
	}

	/** full constructor */
	public TcompanyFoundationB(TprojectApplication tprojectApplication,
			String companyFoundation, String appendixFlag, String deleteFlag,
			Timestamp createTime, String createUser, Timestamp updateTime,
			String updateUser, String remark) {
		this.tprojectApplication = tprojectApplication;
		this.companyFoundation = companyFoundation;
		this.appendixFlag = appendixFlag;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.remark = remark;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "COMPANY_FOUNDATION_ID", unique = true, nullable = false, length = 40)
	public String getCompanyFoundationId() {
		return this.companyFoundationId;
	}

	public void setCompanyFoundationId(String companyFoundationId) {
		this.companyFoundationId = companyFoundationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "COMPANY_FOUNDATION", length = 4000)
	public String getCompanyFoundation() {
		return this.companyFoundation;
	}

	public void setCompanyFoundation(String companyFoundation) {
		this.companyFoundation = companyFoundation;
	}

	@Column(name = "APPENDIX_FLAG", length = 1)
	public String getAppendixFlag() {
		return this.appendixFlag;
	}

	public void setAppendixFlag(String appendixFlag) {
		this.appendixFlag = appendixFlag;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "CREATE_TIME")
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "CREATE_USER", length = 50)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "UPDATE_TIME")
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "UPDATE_USER", length = 50)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
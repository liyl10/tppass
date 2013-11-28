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
 * TcompanyNeedB entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_COMPANY_NEED_B")
public class TcompanyNeedB implements java.io.Serializable {

	private static final long serialVersionUID = -1592741082919678283L;
	// Fields
	private String companyNeedId;
	private TprojectApplication tprojectApplication;
	private String companyNeed;
	private String appendixFlag;
	private String deleteFlag;
	private String remark;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;

	// Constructors

	/** default constructor */
	public TcompanyNeedB() {
	}

	/** full constructor */
	public TcompanyNeedB(TprojectApplication tprojectApplication,
			String companyNeed, String appendixFlag, String deleteFlag,
			String remark, Timestamp createTime, String createUser,
			Timestamp updateTime, String updateUser) {
		this.tprojectApplication = tprojectApplication;
		this.companyNeed = companyNeed;
		this.appendixFlag = appendixFlag;
		this.deleteFlag = deleteFlag;
		this.remark = remark;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "COMPANY_NEED_ID", unique = true, nullable = false, length = 40)
	public String getCompanyNeedId() {
		return this.companyNeedId;
	}

	public void setCompanyNeedId(String companyNeedId) {
		this.companyNeedId = companyNeedId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "COMPANY_NEED", length = 4000)
	public String getCompanyNeed() {
		return this.companyNeed;
	}

	public void setCompanyNeed(String companyNeed) {
		this.companyNeed = companyNeed;
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

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

}
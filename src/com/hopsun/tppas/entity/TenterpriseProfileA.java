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
 * TenterpriseProfileA entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ENTERPRISE_PROFILE_A")
public class TenterpriseProfileA implements java.io.Serializable {

	private static final long serialVersionUID = 8925208232724234172L;
	// Fields
	private String enterpriseProfileId;
	private TprojectApplication tprojectApplication;
	private String enterpriseProfileText;
	private String remark;
	private String deleteFlag;
	private String appendixFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;

	// Constructors

	/** default constructor */
	public TenterpriseProfileA() {
	}

	/** full constructor */
	public TenterpriseProfileA(TprojectApplication tprojectApplication,
			String enterpriseProfileText, String remark, String deleteFlag,
			String appendixFlag, Timestamp createTime, String createUser,
			Timestamp updateTime, String updateUser) {
		this.tprojectApplication = tprojectApplication;
		this.enterpriseProfileText = enterpriseProfileText;
		this.remark = remark;
		this.deleteFlag = deleteFlag;
		this.appendixFlag = appendixFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ENTERPRISE_PROFILE_ID", unique = true, nullable = false, length = 40)
	public String getEnterpriseProfileId() {
		return this.enterpriseProfileId;
	}

	public void setEnterpriseProfileId(String enterpriseProfileId) {
		this.enterpriseProfileId = enterpriseProfileId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "ENTERPRISE_PROFILE_TEXT", length = 4000)
	public String getEnterpriseProfileText() {
		return this.enterpriseProfileText;
	}

	public void setEnterpriseProfileText(String enterpriseProfileText) {
		this.enterpriseProfileText = enterpriseProfileText;
	}

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "APPENDIX_FLAG", length = 1)
	public String getAppendixFlag() {
		return this.appendixFlag;
	}

	public void setAppendixFlag(String appendixFlag) {
		this.appendixFlag = appendixFlag;
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
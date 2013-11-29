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
 * TtechnicalContentA entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_TECHNICAL_CONTENT_A")
public class TtechnicalContentA implements java.io.Serializable {

	private static final long serialVersionUID = 5485558285804270603L;
	// Fields

	private String technicalContentId;
	private TprojectApplication tprojectApplication;
	private String technicalContentText;
	private String appendixFlag;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String remark;

	// Constructors

	/** default constructor */
	public TtechnicalContentA() {
	}

	/** full constructor */
	public TtechnicalContentA(TprojectApplication tprojectApplication,
			String technicalContentText, String appendixFlag,
			String deleteFlag, Timestamp createTime, String createUser,
			Timestamp updateTime, String updateUser, String remark) {
		this.tprojectApplication = tprojectApplication;
		this.technicalContentText = technicalContentText;
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
	@Column(name = "TECHNICAL_CONTENT_ID", unique = true, nullable = false, length = 40)
	public String getTechnicalContentId() {
		return this.technicalContentId;
	}

	public void setTechnicalContentId(String technicalContentId) {
		this.technicalContentId = technicalContentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "TECHNICAL_CONTENT_TEXT", length = 4000)
	public String getTechnicalContentText() {
		return this.technicalContentText;
	}

	public void setTechnicalContentText(String technicalContentText) {
		this.technicalContentText = technicalContentText;
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
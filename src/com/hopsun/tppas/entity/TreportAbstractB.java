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
 * TreportAbstractB entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_REPORT_ABSTRACT_B")
public class TreportAbstractB implements java.io.Serializable {

	private static final long serialVersionUID = -1990300880064385297L;
	// Fields

	private String reportAbstractId;
	private TprojectApplication tprojectApplication;
	private String reportAbstract;
	private String appendixFlag;
	private String deleteFlag;
	private String remark;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;

	// Constructors

	/** default constructor */
	public TreportAbstractB() {
	}

	/** full constructor */
	public TreportAbstractB(TprojectApplication tprojectApplication,
			String reportAbstract, String appendixFlag, String deleteFlag,
			String remark, Timestamp createTime, String createUser,
			Timestamp updateTime, String updateUser) {
		this.tprojectApplication = tprojectApplication;
		this.reportAbstract = reportAbstract;
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
	@Column(name = "REPORT_ABSTRACT_ID", unique = true, nullable = false, length = 40)
	public String getReportAbstractId() {
		return this.reportAbstractId;
	}

	public void setReportAbstractId(String reportAbstractId) {
		this.reportAbstractId = reportAbstractId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "REPORT_ABSTRACT", length = 4000)
	public String getReportAbstract() {
		return this.reportAbstract;
	}

	public void setReportAbstract(String reportAbstract) {
		this.reportAbstract = reportAbstract;
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

	@Column(name = "REMARK", length = 2000)
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
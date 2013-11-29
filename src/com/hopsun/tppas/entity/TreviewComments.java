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
 * TreviewComments entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_REVIEW_COMMENTS")
public class TreviewComments implements java.io.Serializable {
	
	private static final long serialVersionUID = -3161163715213626852L;
	// Fields

	private String reviewCommentsId;
	private TprojectApplication tprojectApplication;
	private String reportingUnits;
	private String cooperativeUnits;
	private String centralizedUnits;
	private String scienceUnits;
	private String examineUnits;
	private String remark;
	private String deleteFlag;
	private String appendixFlag;
	private String submitFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;

	// Constructors

	/** default constructor */
	public TreviewComments() {
	}

	/** full constructor */
	public TreviewComments(TprojectApplication tprojectApplication,
			String reportingUnits, String cooperativeUnits,
			String centralizedUnits, String scienceUnits, String examineUnits,
			String remark, String deleteFlag, String appendixFlag,
			String submitFlag, Timestamp createTime, String createUser,
			Timestamp updateTime, String updateUser) {
		this.tprojectApplication = tprojectApplication;
		this.reportingUnits = reportingUnits;
		this.cooperativeUnits = cooperativeUnits;
		this.centralizedUnits = centralizedUnits;
		this.scienceUnits = scienceUnits;
		this.examineUnits = examineUnits;
		this.remark = remark;
		this.deleteFlag = deleteFlag;
		this.appendixFlag = appendixFlag;
		this.submitFlag = submitFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "REVIEW_COMMENTS_ID", unique = true, nullable = false, length = 40)
	public String getReviewCommentsId() {
		return this.reviewCommentsId;
	}

	public void setReviewCommentsId(String reviewCommentsId) {
		this.reviewCommentsId = reviewCommentsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "REPORTING_UNITS", length = 4000)
	public String getReportingUnits() {
		return this.reportingUnits;
	}

	public void setReportingUnits(String reportingUnits) {
		this.reportingUnits = reportingUnits;
	}

	@Column(name = "COOPERATIVE_UNITS", length = 4000)
	public String getCooperativeUnits() {
		return this.cooperativeUnits;
	}

	public void setCooperativeUnits(String cooperativeUnits) {
		this.cooperativeUnits = cooperativeUnits;
	}

	@Column(name = "CENTRALIZED_UNITS", length = 4000)
	public String getCentralizedUnits() {
		return this.centralizedUnits;
	}

	public void setCentralizedUnits(String centralizedUnits) {
		this.centralizedUnits = centralizedUnits;
	}

	@Column(name = "SCIENCE_UNITS", length = 4000)
	public String getScienceUnits() {
		return this.scienceUnits;
	}

	public void setScienceUnits(String scienceUnits) {
		this.scienceUnits = scienceUnits;
	}

	@Column(name = "EXAMINE_UNITS", length = 4000)
	public String getExamineUnits() {
		return this.examineUnits;
	}

	public void setExamineUnits(String examineUnits) {
		this.examineUnits = examineUnits;
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

	@Column(name = "SUBMIT_FLAG", length = 1)
	public String getSubmitFlag() {
		return this.submitFlag;
	}

	public void setSubmitFlag(String submitFlag) {
		this.submitFlag = submitFlag;
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
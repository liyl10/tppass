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
 * TprojectRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_PROJECT_RECORD")
public class TprojectRecord implements java.io.Serializable {

	private static final long serialVersionUID = -4694262855055339845L;
	// Fields

	private String recordId;
	private TprojectApplication tprojectApplication;
	private Integer optStepType;
	private String optType;
	private Timestamp optTime;
	private String optUser;
	private String optResult;
	private String optInfo1;
	private String optInfo2;
	private Integer optUserType;

	// Constructors

	/** default constructor */
	public TprojectRecord() {
	}

	/** full constructor */
	public TprojectRecord(TprojectApplication tprojectApplication,
			Integer optStepType, String optType, Timestamp optTime, String optUser,
			String optResult, String optInfo1, String optInfo2,Integer optUserType) {
		this.tprojectApplication = tprojectApplication;
		this.optStepType = optStepType;
		this.optType = optType;
		this.optTime = optTime;
		this.optUser = optUser;
		this.optResult = optResult;
		this.optInfo1 = optInfo1;
		this.optInfo2 = optInfo2;
		this.optUserType = optUserType;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "RECORD_ID", unique = true, nullable = false, length = 40)
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "OPT_STEP_TYPE")
	public Integer getOptStepType() {
		return this.optStepType;
	}

	public void setOptStepType(Integer optStepType) {
		this.optStepType = optStepType;
	}

	@Column(name = "OPT_TYPE", length = 100)
	public String getOptType() {
		return this.optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	@Column(name = "OPT_TIME")
	public Timestamp getOptTime() {
		return this.optTime;
	}

	public void setOptTime(Timestamp optTime) {
		this.optTime = optTime;
	}

	@Column(name = "OPT_USER", length = 50)
	public String getOptUser() {
		return this.optUser;
	}

	public void setOptUser(String optUser) {
		this.optUser = optUser;
	}

	@Column(name = "OPT_RESULT", length = 100)
	public String getOptResult() {
		return this.optResult;
	}

	public void setOptResult(String optResult) {
		this.optResult = optResult;
	}

	@Column(name = "OPT_INFO1", length = 4000)
	public String getOptInfo1() {
		return this.optInfo1;
	}

	public void setOptInfo1(String optInfo1) {
		this.optInfo1 = optInfo1;
	}

	@Column(name = "OPT_INFO2", length = 4000)
	public String getOptInfo2() {
		return this.optInfo2;
	}

	public void setOptInfo2(String optInfo2) {
		this.optInfo2 = optInfo2;
	}

	@Column(name = "OPT_USER_TYPE")
	public Integer getOptUserType() {
		return optUserType;
	}

	public void setOptUserType(Integer optUserType) {
		this.optUserType = optUserType;
	}
}
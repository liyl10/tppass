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
 * TarrangementB entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ARRANGEMENT_B")
public class TarrangementB implements java.io.Serializable {

	private static final long serialVersionUID = 3375448712078164699L;
	// Fields

	private String arrangementBId;
	private Tcontract tcontract;
	private Timestamp startTime;
	private Timestamp endTime;
	private String contentComplete;
	private String assessmentIndicators;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String remark;

	// Constructors

	/** default constructor */
	public TarrangementB() {
	}

	/** full constructor */
	public TarrangementB(Tcontract tcontract,
			Timestamp startTime, Timestamp endTime, String contentComplete,
			String assessmentIndicators, String deleteFlag, Timestamp createTime,
			String createUser, Timestamp updateTime, String updateUser,
			String remark) {
		this.tcontract = tcontract;
		this.startTime = startTime;
		this.endTime = endTime;
		this.contentComplete = contentComplete;
		this.assessmentIndicators = assessmentIndicators;
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
	@Column(name = "ARRANGEMENT_B_ID", unique = true, nullable = false, length = 40)
	public String getArrangementBId() {
		return this.arrangementBId;
	}

	public void setArrangementBId(String arrangementBId) {
		this.arrangementBId = arrangementBId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_CONTRACT_ID")
	public Tcontract getTcontract() {
		return this.tcontract;
	}

	public void setTcontract(Tcontract tcontract) {
		this.tcontract = tcontract;
	}

	@Column(name = "START_TIME")
	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	@Column(name = "END_TIME")
	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	@Column(name = "CONTENT_COMPLETE", length = 4000)
	public String getContentComplete() {
		return this.contentComplete;
	}

	public void setContentComplete(String contentComplete) {
		this.contentComplete = contentComplete;
	}

	@Column(name = "ASSESSMENT_INDICATORS", length = 4000)
	public String getAssessmentIndicators() {
		return this.assessmentIndicators;
	}

	public void setAssessmentIndicators(String assessmentIndicators) {
		this.assessmentIndicators = assessmentIndicators;
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
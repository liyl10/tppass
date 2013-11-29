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
 * TacceptanceExpertAudit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ACCEPTANCE_EXPERT_AUDIT")
public class TacceptanceExpertAudit implements java.io.Serializable {

	private static final long serialVersionUID = 2194207615370738795L;
	// Fields
	private String auditId;
	private Texpert texpert;
	private Tacceptance tacceptance;
	private String opinionSurvey;
	private String recommendType;
	private String complexSurvry;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;
	private String deleteFlag;
	private String remark;

	// Constructors

	/** default constructor */
	public TacceptanceExpertAudit() {
	}

	/** full constructor */
	public TacceptanceExpertAudit(Texpert texpert, Tacceptance tacceptance,
			String opinionSurvey, String recommendType, String complexSurvry,
			Timestamp createTime, String createUser, Timestamp updateDate,
			String updateUser, String deleteFlag, String remark) {
		this.texpert = texpert;
		this.tacceptance = tacceptance;
		this.opinionSurvey = opinionSurvey;
		this.recommendType = recommendType;
		this.complexSurvry = complexSurvry;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.deleteFlag = deleteFlag;
		this.remark = remark;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "AUDIT_ID", unique = true, nullable = false, length = 40)
	public String getAuditId() {
		return this.auditId;
	}

	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EXPERT_ID")
	public Texpert getTexpert() {
		return this.texpert;
	}

	public void setTexpert(Texpert texpert) {
		this.texpert = texpert;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCEPTANCE_ID")
	public Tacceptance getTacceptance() {
		return this.tacceptance;
	}

	public void setTacceptance(Tacceptance tacceptance) {
		this.tacceptance = tacceptance;
	}

	@Column(name = "OPINION_SURVEY", length = 4000)
	public String getOpinionSurvey() {
		return this.opinionSurvey;
	}

	public void setOpinionSurvey(String opinionSurvey) {
		this.opinionSurvey = opinionSurvey;
	}

	@Column(name = "RECOMMEND_TYPE", length = 40)
	public String getRecommendType() {
		return this.recommendType;
	}

	public void setRecommendType(String recommendType) {
		this.recommendType = recommendType;
	}

	@Column(name = "COMPLEX_SURVRY", length = 4000)
	public String getComplexSurvry() {
		return this.complexSurvry;
	}

	public void setComplexSurvry(String complexSurvry) {
		this.complexSurvry = complexSurvry;
	}

	@Column(name = "CREATE_TIME")
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "CREATE_USER", length = 40)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "UPDATE_DATE")
	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "UPDATE_USER", length = 40)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
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

}
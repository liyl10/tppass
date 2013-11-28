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
 * TacceptanceSummaryB entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ACCEPTANCE_SUMMARY_B")
public class TacceptanceSummaryB implements java.io.Serializable {

	private static final long serialVersionUID = 1018987729644572L;
	// Fields
	private String summaryId;
	private Tacceptance tacceptance;
	private String transformationCase;
	private String teamTrainingSituation;
	private String socialBenefitsDescription;
	private Timestamp stampTime;
	private String createUser;
	private Timestamp createTime;
	private String updateUser;
	private Timestamp updateTime;
	private String deleteFlag;

	// Constructors

	/** default constructor */
	public TacceptanceSummaryB() {
	}

	/** full constructor */
	public TacceptanceSummaryB(Tacceptance tacceptance,
			String transformationCase, String teamTrainingSituation,
			String socialBenefitsDescription, Timestamp stampTime,
			String createUser, Timestamp createTime, String updateUser,
			Timestamp updateTime, String deleteFlag) {
		this.tacceptance = tacceptance;
		this.transformationCase = transformationCase;
		this.teamTrainingSituation = teamTrainingSituation;
		this.socialBenefitsDescription = socialBenefitsDescription;
		this.stampTime = stampTime;
		this.createUser = createUser;
		this.createTime = createTime;
		this.updateUser = updateUser;
		this.updateTime = updateTime;
		this.deleteFlag = deleteFlag;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SUMMARY_ID", unique = true, nullable = false, length = 40)
	public String getSummaryId() {
		return this.summaryId;
	}

	public void setSummaryId(String summaryId) {
		this.summaryId = summaryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCEPTANCE_ID")
	public Tacceptance getTacceptance() {
		return this.tacceptance;
	}

	public void setTacceptance(Tacceptance tacceptance) {
		this.tacceptance = tacceptance;
	}

	@Column(name = "TRANSFORMATION_CASE", length = 4000)
	public String getTransformationCase() {
		return this.transformationCase;
	}

	public void setTransformationCase(String transformationCase) {
		this.transformationCase = transformationCase;
	}

	@Column(name = "TEAM_TRAINING_SITUATION", length = 4000)
	public String getTeamTrainingSituation() {
		return this.teamTrainingSituation;
	}

	public void setTeamTrainingSituation(String teamTrainingSituation) {
		this.teamTrainingSituation = teamTrainingSituation;
	}

	@Column(name = "SOCIAL_BENEFITS_DESCRIPTION", length = 4000)
	public String getSocialBenefitsDescription() {
		return this.socialBenefitsDescription;
	}

	public void setSocialBenefitsDescription(String socialBenefitsDescription) {
		this.socialBenefitsDescription = socialBenefitsDescription;
	}

	@Column(name = "STAMP_TIME")
	public Timestamp getStampTime() {
		return this.stampTime;
	}

	public void setStampTime(Timestamp stampTime) {
		this.stampTime = stampTime;
	}

	@Column(name = "CREATE_USER", length = 40)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "CREATE_TIME")
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "UPDATE_USER", length = 40)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Column(name = "UPDATE_TIME")
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
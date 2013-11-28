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
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * TexpertScore entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_EXPERT_SCORE")
public class TexpertScore implements java.io.Serializable {
	
	private static final long serialVersionUID = -3379907727556184519L;

	// Fields
	private String scoreId;
	private TprojectApplication tprojectApplication;
	private Texpert texpert;
	private String companyStatusStandard;
	private Double companyStatusScore;
	private String projectTechnologyStandard;
	private Double projectTechnologyScore;
	private String projectBaseStandard;
	private Double projectBaseScore;
	private String projectMarketStandard;
	private Double projectMarketScore;
	private String projectBenefitType;
	private String projectBenefitStandard;
	private Double projectBenefitScore;
	private Double complexScore;
	private String complexOpinion;
	private String explanationReason;
	private String scoreTime;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;
	private String remark;
	private String resultFlag;
	private String auditFlag;
	//2013-10-30追加属性
	/**平均分*/
	private double complexAverage;
	/**最终结果*/
	private String finalResult;
	/** 专家顺序 */
	private int index;
	// Constructors

	/** default constructor */
	public TexpertScore() {
	}

	/** full constructor */
	public TexpertScore(TprojectApplication tprojectApplication,
			Texpert texpert, String companyStatusStandard,
			Double companyStatusScore, String projectTechnologyStandard,
			Double projectTechnologyScore, String projectBaseStandard,
			Double projectBaseScore, String projectMarketStandard,
			Double projectMarketScore, String projectBenefitType,
			String projectBenefitStandard, Double projectBenefitScore,
			Double complexScore, String complexOpinion,
			String explanationReason, String scoreTime, String deleteFlag,
			Timestamp createTime, String createUser, Timestamp updateDate,
			String updateUser, String remark, String resultFlag, String auditFlag,double complexAverage,String finalResult,
			int index) {
		this.tprojectApplication = tprojectApplication;
		this.texpert = texpert;
		this.companyStatusStandard = companyStatusStandard;
		this.companyStatusScore = companyStatusScore;
		this.projectTechnologyStandard = projectTechnologyStandard;
		this.projectTechnologyScore = projectTechnologyScore;
		this.projectBaseStandard = projectBaseStandard;
		this.projectBaseScore = projectBaseScore;
		this.projectMarketStandard = projectMarketStandard;
		this.projectMarketScore = projectMarketScore;
		this.projectBenefitType = projectBenefitType;
		this.projectBenefitStandard = projectBenefitStandard;
		this.projectBenefitScore = projectBenefitScore;
		this.complexScore = complexScore;
		this.complexOpinion = complexOpinion;
		this.explanationReason = explanationReason;
		this.scoreTime = scoreTime;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.remark = remark;
		this.resultFlag = resultFlag;
		this.auditFlag = auditFlag;
		this.complexAverage = complexAverage;
		this.finalResult = finalResult;
		this.index = index;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SCORE_ID", unique = true, nullable = false, length = 40)
	public String getScoreId() {
		return this.scoreId;
	}

	public void setScoreId(String scoreId) {
		this.scoreId = scoreId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EXPERT_ID")
	public Texpert getTexpert() {
		return this.texpert;
	}

	public void setTexpert(Texpert texpert) {
		this.texpert = texpert;
	}

	@Column(name = "COMPANY_STATUS_STANDARD", length = 40)
	public String getCompanyStatusStandard() {
		return this.companyStatusStandard;
	}

	public void setCompanyStatusStandard(String companyStatusStandard) {
		this.companyStatusStandard = companyStatusStandard;
	}

	@Column(name = "COMPANY_STATUS_SCORE", precision = 6, scale = 2)
	public Double getCompanyStatusScore() {
		return this.companyStatusScore;
	}

	public void setCompanyStatusScore(Double companyStatusScore) {
		this.companyStatusScore = companyStatusScore;
	}

	@Column(name = "PROJECT_TECHNOLOGY_STANDARD", length = 40)
	public String getProjectTechnologyStandard() {
		return this.projectTechnologyStandard;
	}

	public void setProjectTechnologyStandard(String projectTechnologyStandard) {
		this.projectTechnologyStandard = projectTechnologyStandard;
	}

	@Column(name = "PROJECT_TECHNOLOGY_SCORE", precision = 6, scale = 2)
	public Double getProjectTechnologyScore() {
		return this.projectTechnologyScore;
	}

	public void setProjectTechnologyScore(Double projectTechnologyScore) {
		this.projectTechnologyScore = projectTechnologyScore;
	}

	@Column(name = "PROJECT_BASE_STANDARD", length = 40)
	public String getProjectBaseStandard() {
		return this.projectBaseStandard;
	}

	public void setProjectBaseStandard(String projectBaseStandard) {
		this.projectBaseStandard = projectBaseStandard;
	}

	@Column(name = "PROJECT_BASE_SCORE", precision = 6, scale = 2)
	public Double getProjectBaseScore() {
		return this.projectBaseScore;
	}

	public void setProjectBaseScore(Double projectBaseScore) {
		this.projectBaseScore = projectBaseScore;
	}

	@Column(name = "PROJECT_MARKET_STANDARD", length = 40)
	public String getProjectMarketStandard() {
		return this.projectMarketStandard;
	}

	public void setProjectMarketStandard(String projectMarketStandard) {
		this.projectMarketStandard = projectMarketStandard;
	}

	@Column(name = "PROJECT_MARKET_SCORE", precision = 6, scale = 2)
	public Double getProjectMarketScore() {
		return this.projectMarketScore;
	}

	public void setProjectMarketScore(Double projectMarketScore) {
		this.projectMarketScore = projectMarketScore;
	}

	@Column(name = "PROJECT_BENEFIT_TYPE", length = 40)
	public String getProjectBenefitType() {
		return this.projectBenefitType;
	}

	public void setProjectBenefitType(String projectBenefitType) {
		this.projectBenefitType = projectBenefitType;
	}

	@Column(name = "PROJECT_BENEFIT_STANDARD", length = 40)
	public String getProjectBenefitStandard() {
		return this.projectBenefitStandard;
	}

	public void setProjectBenefitStandard(String projectBenefitStandard) {
		this.projectBenefitStandard = projectBenefitStandard;
	}

	@Column(name = "PROJECT_BENEFIT_SCORE", precision = 6, scale = 2)
	public Double getProjectBenefitScore() {
		return this.projectBenefitScore;
	}

	public void setProjectBenefitScore(Double projectBenefitScore) {
		this.projectBenefitScore = projectBenefitScore;
	}

	@Column(name = "COMPLEX_SCORE", precision = 6, scale = 2)
	public Double getComplexScore() {
		return this.complexScore;
	}

	public void setComplexScore(Double complexScore) {
		this.complexScore = complexScore;
	}

	@Column(name = "COMPLEX_OPINION", length = 40)
	public String getComplexOpinion() {
		return this.complexOpinion;
	}

	public void setComplexOpinion(String complexOpinion) {
		this.complexOpinion = complexOpinion;
	}

	@Column(name = "EXPLANATION_REASON", length = 4000)
	public String getExplanationReason() {
		return this.explanationReason;
	}

	public void setExplanationReason(String explanationReason) {
		this.explanationReason = explanationReason;
	}

	@Column(name = "SCORE_TIME")
	public String getScoreTime() {
		return this.scoreTime;
	}

	public void setScoreTime(String scoreTime) {
		this.scoreTime = scoreTime;
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

	@Column(name = "UPDATE_DATE")
	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
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

	@Column(name = "RESULT_FLAG", length = 2)
	public String getResultFlag() {
		return resultFlag;
	}

	public void setResultFlag(String resultFlag) {
		this.resultFlag = resultFlag;
	}

	@Column(name = "AUDIT_FLAG", length = 2)
	public String getAuditFlag() {
		return auditFlag;
	}

	public void setAuditFlag(String auditFlag) {
		this.auditFlag = auditFlag;
	}

	@Column(name = "COMPLEX_AVERAGE", precision = 5, scale = 2)
	public double getComplexAverage() {
		return complexAverage;
	}

	public void setComplexAverage(double complexAverage) {
		this.complexAverage = complexAverage;
	}

	@Column(name = "FINAL_RESULT", length = 40)
	public String getFinalResult() {
		return finalResult;
	}

	public void setFinalResult(String finalResult) {
		this.finalResult = finalResult;
	}
	@Transient
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
}
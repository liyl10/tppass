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
 * TacceptanceFundsA entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ACCEPTANCE_FUNDS_A")
public class TacceptanceFundsA implements java.io.Serializable {

	private static final long serialVersionUID = -2863480905962895912L;
	// Fields
	private String fundsId;
	private Tacceptance tacceptance;
	private String fundsYear2;
	private String fundsYear1;
	private String fundsYear4;
	private String fundsYear3;
	private String fundsPlanname2;
	private String fundsPlanname1;
	private String fundsPlanname4;
	private String fundsPlanname3;
	private double fundsAmount2;
	private double fundsAmount1;
	private double fundsAmount4;
	private double fundsAmount3;
	private String transformationCase;
	private String teamTrainingSituation;
	private String socialBenefitsDescription;
	private String createUser;
	private Timestamp createTime;
	private String updateUser;
	private Timestamp updateTime;
	private String deleteFlag;

	// Constructors

	/** default constructor */
	public TacceptanceFundsA() {
	}

	/** full constructor */
	public TacceptanceFundsA(Tacceptance tacceptance, String fundsYear2,
			String fundsYear1, String fundsYear4, String fundsYear3,
			String fundsPlanname2, String fundsPlanname1,
			String fundsPlanname4, String fundsPlanname3, double fundsAmount2,
			double fundsAmount1, double fundsAmount4, double fundsAmount3,
			String transformationCase, String teamTrainingSituation,
			String socialBenefitsDescription, String createUser,
			Timestamp createTime, String updateUser, Timestamp updateTime,
			String deleteFlag) {
		this.tacceptance = tacceptance;
		this.fundsYear2 = fundsYear2;
		this.fundsYear1 = fundsYear1;
		this.fundsYear4 = fundsYear4;
		this.fundsYear3 = fundsYear3;
		this.fundsPlanname2 = fundsPlanname2;
		this.fundsPlanname1 = fundsPlanname1;
		this.fundsPlanname4 = fundsPlanname4;
		this.fundsPlanname3 = fundsPlanname3;
		this.fundsAmount2 = fundsAmount2;
		this.fundsAmount1 = fundsAmount1;
		this.fundsAmount4 = fundsAmount4;
		this.fundsAmount3 = fundsAmount3;
		this.transformationCase = transformationCase;
		this.teamTrainingSituation = teamTrainingSituation;
		this.socialBenefitsDescription = socialBenefitsDescription;
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
	@Column(name = "FUNDS_ID", unique = true, nullable = false, length = 40)
	public String getFundsId() {
		return this.fundsId;
	}

	public void setFundsId(String fundsId) {
		this.fundsId = fundsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCEPTANCE_ID")
	public Tacceptance getTacceptance() {
		return this.tacceptance;
	}

	public void setTacceptance(Tacceptance tacceptance) {
		this.tacceptance = tacceptance;
	}

	@Column(name = "FUNDS_YEAR_2", length = 10)
	public String getFundsYear2() {
		return this.fundsYear2;
	}

	public void setFundsYear2(String fundsYear2) {
		this.fundsYear2 = fundsYear2;
	}

	@Column(name = "FUNDS_YEAR_1", length = 10)
	public String getFundsYear1() {
		return this.fundsYear1;
	}

	public void setFundsYear1(String fundsYear1) {
		this.fundsYear1 = fundsYear1;
	}

	@Column(name = "FUNDS_YEAR_4", length = 10)
	public String getFundsYear4() {
		return this.fundsYear4;
	}

	public void setFundsYear4(String fundsYear4) {
		this.fundsYear4 = fundsYear4;
	}

	@Column(name = "FUNDS_YEAR_3", length = 10)
	public String getFundsYear3() {
		return this.fundsYear3;
	}

	public void setFundsYear3(String fundsYear3) {
		this.fundsYear3 = fundsYear3;
	}

	@Column(name = "FUNDS_PLANNAME_2", length = 100)
	public String getFundsPlanname2() {
		return this.fundsPlanname2;
	}

	public void setFundsPlanname2(String fundsPlanname2) {
		this.fundsPlanname2 = fundsPlanname2;
	}

	@Column(name = "FUNDS_PLANNAME_1", length = 100)
	public String getFundsPlanname1() {
		return this.fundsPlanname1;
	}

	public void setFundsPlanname1(String fundsPlanname1) {
		this.fundsPlanname1 = fundsPlanname1;
	}

	@Column(name = "FUNDS_PLANNAME_4", length = 100)
	public String getFundsPlanname4() {
		return this.fundsPlanname4;
	}

	public void setFundsPlanname4(String fundsPlanname4) {
		this.fundsPlanname4 = fundsPlanname4;
	}

	@Column(name = "FUNDS_PLANNAME_3", length = 100)
	public String getFundsPlanname3() {
		return this.fundsPlanname3;
	}

	public void setFundsPlanname3(String fundsPlanname3) {
		this.fundsPlanname3 = fundsPlanname3;
	}

	@Column(name = "FUNDS_AMOUNT_2", precision = 11, scale = 4)
	public double getFundsAmount2() {
		return this.fundsAmount2;
	}

	public void setFundsAmount2(double fundsAmount2) {
		this.fundsAmount2 = fundsAmount2;
	}

	@Column(name = "FUNDS_AMOUNT_1", precision = 11, scale = 4)
	public double getFundsAmount1() {
		return this.fundsAmount1;
	}

	public void setFundsAmount1(double fundsAmount1) {
		this.fundsAmount1 = fundsAmount1;
	}

	@Column(name = "FUNDS_AMOUNT_4", precision = 11, scale = 4)
	public double getFundsAmount4() {
		return this.fundsAmount4;
	}

	public void setFundsAmount4(double fundsAmount4) {
		this.fundsAmount4 = fundsAmount4;
	}

	@Column(name = "FUNDS_AMOUNT_3", precision = 11, scale = 4)
	public double getFundsAmount3() {
		return this.fundsAmount3;
	}

	public void setFundsAmount3(double fundsAmount3) {
		this.fundsAmount3 = fundsAmount3;
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
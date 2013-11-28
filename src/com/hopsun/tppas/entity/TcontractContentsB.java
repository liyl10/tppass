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
 * TcontractContentsB entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_CONTRACT_CONTENTS_B")
public class TcontractContentsB implements java.io.Serializable {

	private static final long serialVersionUID = 3656209955891715161L;
	
	// Fields
	private String contractContentsBId;
	private Tcontract tcontract;
	private String yearValue;
	private String planValue;
	private double researchFunding;
	private String collaborationUnit;
	private String research1;
	private String research2;
	private String research3;
	private String research4;
	private String technicalSpecifications1;
	private String technicalSpecifications2;
	private String technicalSpecifications3;
	private String technicalSpecifications4;
	private String social;
	private Integer certificateApplication;
	private Integer certificateAuthorize;
	private String prototype;
	private String thesis;
	private String certificateAuthenticity;
	private String resultsRegistration;
	private String other;
	private String bank;
	private String bankAccount;
	private Timestamp selectTime1;
	private Timestamp selectTime2;
	private Timestamp selectTime3;
	private String remark;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String deleteFlag;
	private String research;
	private String technicalSpecifications;
	private String arrangement;
	private String resultsForm;

	// Constructors

	/** default constructor */
	public TcontractContentsB() {
	}

	/** full constructor */
	public TcontractContentsB(Tcontract tcontract, String yearValue,
			String planValue, double researchFunding, String collaborationUnit,
			String research1, String research2, String research3,
			String research4, String technicalSpecifications1,
			String technicalSpecifications2, String technicalSpecifications3,
			String technicalSpecifications4, String social,
			Integer certificateApplication, Integer certificateAuthorize,
			String prototype, String thesis, String certificateAuthenticity,
			String resultsRegistration, String other, String bank,
			String bankAccount, Timestamp selectTime1, Timestamp selectTime2,
			Timestamp selectTime3, String remark, Timestamp createTime,
			String createUser, Timestamp updateTime, String updateUser,
			String deleteFlag,String research,String technicalSpecifications,
			String arrangement,String resultsForm) {
		this.tcontract = tcontract;
		this.yearValue = yearValue;
		this.planValue = planValue;
		this.researchFunding = researchFunding;
		this.collaborationUnit = collaborationUnit;
		this.research1 = research1;
		this.research2 = research2;
		this.research3 = research3;
		this.research4 = research4;
		this.technicalSpecifications1 = technicalSpecifications1;
		this.technicalSpecifications2 = technicalSpecifications2;
		this.technicalSpecifications3 = technicalSpecifications3;
		this.technicalSpecifications4 = technicalSpecifications4;
		this.social = social;
		this.certificateApplication = certificateApplication;
		this.certificateAuthorize = certificateAuthorize;
		this.prototype = prototype;
		this.thesis = thesis;
		this.certificateAuthenticity = certificateAuthenticity;
		this.resultsRegistration = resultsRegistration;
		this.other = other;
		this.bank = bank;
		this.bankAccount = bankAccount;
		this.selectTime1 = selectTime1;
		this.selectTime2 = selectTime2;
		this.selectTime3 = selectTime3;
		this.remark = remark;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.deleteFlag = deleteFlag;
		this.research = research;
		this.technicalSpecifications = technicalSpecifications;
		this.arrangement = arrangement;
		this.resultsForm = resultsForm;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CONTRACT_CONTENTS_B_ID", unique = true, nullable = false, length = 40)
	public String getContractContentsBId() {
		return this.contractContentsBId;
	}

	public void setContractContentsBId(String contractContentsBId) {
		this.contractContentsBId = contractContentsBId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_CONTRACT_ID")
	public Tcontract getTcontract() {
		return this.tcontract;
	}

	public void setTcontract(Tcontract tcontract) {
		this.tcontract = tcontract;
	}

	@Column(name = "YEAR_VALUE", length = 4)
	public String getYearValue() {
		return this.yearValue;
	}

	public void setYearValue(String yearValue) {
		this.yearValue = yearValue;
	}

	@Column(name = "PLAN_VALUE", length = 100)
	public String getPlanValue() {
		return this.planValue;
	}

	public void setPlanValue(String planValue) {
		this.planValue = planValue;
	}

	@Column(name = "RESEARCH_FUNDING", precision = 11, scale = 4)
	public double getResearchFunding() {
		return this.researchFunding;
	}

	public void setResearchFunding(double researchFunding) {
		this.researchFunding = researchFunding;
	}

	@Column(name = "COLLABORATION_UNIT", length = 100)
	public String getCollaborationUnit() {
		return this.collaborationUnit;
	}

	public void setCollaborationUnit(String collaborationUnit) {
		this.collaborationUnit = collaborationUnit;
	}

	@Column(name = "RESEARCH_1", length = 4000)
	public String getResearch1() {
		return this.research1;
	}

	public void setResearch1(String research1) {
		this.research1 = research1;
	}

	@Column(name = "RESEARCH_2", length = 4000)
	public String getResearch2() {
		return this.research2;
	}

	public void setResearch2(String research2) {
		this.research2 = research2;
	}

	@Column(name = "RESEARCH_3", length = 4000)
	public String getResearch3() {
		return this.research3;
	}

	public void setResearch3(String research3) {
		this.research3 = research3;
	}

	@Column(name = "RESEARCH_4", length = 4000)
	public String getResearch4() {
		return this.research4;
	}

	public void setResearch4(String research4) {
		this.research4 = research4;
	}

	@Column(name = "TECHNICAL_SPECIFICATIONS_1", length = 4000)
	public String getTechnicalSpecifications1() {
		return this.technicalSpecifications1;
	}

	public void setTechnicalSpecifications1(String technicalSpecifications1) {
		this.technicalSpecifications1 = technicalSpecifications1;
	}

	@Column(name = "TECHNICAL_SPECIFICATIONS_2", length = 4000)
	public String getTechnicalSpecifications2() {
		return this.technicalSpecifications2;
	}

	public void setTechnicalSpecifications2(String technicalSpecifications2) {
		this.technicalSpecifications2 = technicalSpecifications2;
	}

	@Column(name = "TECHNICAL_SPECIFICATIONS_3", length = 4000)
	public String getTechnicalSpecifications3() {
		return this.technicalSpecifications3;
	}

	public void setTechnicalSpecifications3(String technicalSpecifications3) {
		this.technicalSpecifications3 = technicalSpecifications3;
	}

	@Column(name = "TECHNICAL_SPECIFICATIONS_4", length = 4000)
	public String getTechnicalSpecifications4() {
		return this.technicalSpecifications4;
	}

	public void setTechnicalSpecifications4(String technicalSpecifications4) {
		this.technicalSpecifications4 = technicalSpecifications4;
	}

	@Column(name = "SOCIAL", length = 4000)
	public String getSocial() {
		return this.social;
	}

	public void setSocial(String social) {
		this.social = social;
	}

	@Column(name = "CERTIFICATE_APPLICATION", precision = 7, scale = 0)
	public Integer getCertificateApplication() {
		return this.certificateApplication;
	}

	public void setCertificateApplication(Integer certificateApplication) {
		this.certificateApplication = certificateApplication;
	}

	@Column(name = "CERTIFICATE_AUTHORIZE", precision = 7, scale = 0)
	public Integer getCertificateAuthorize() {
		return this.certificateAuthorize;
	}

	public void setCertificateAuthorize(Integer certificateAuthorize) {
		this.certificateAuthorize = certificateAuthorize;
	}

	@Column(name = "PROTOTYPE", length = 500)
	public String getPrototype() {
		return this.prototype;
	}

	public void setPrototype(String prototype) {
		this.prototype = prototype;
	}

	@Column(name = "THESIS", length = 500)
	public String getThesis() {
		return this.thesis;
	}

	public void setThesis(String thesis) {
		this.thesis = thesis;
	}

	@Column(name = "CERTIFICATE_AUTHENTICITY", length = 500)
	public String getCertificateAuthenticity() {
		return this.certificateAuthenticity;
	}

	public void setCertificateAuthenticity(String certificateAuthenticity) {
		this.certificateAuthenticity = certificateAuthenticity;
	}

	@Column(name = "RESULTS_REGISTRATION", length = 500)
	public String getResultsRegistration() {
		return this.resultsRegistration;
	}

	public void setResultsRegistration(String resultsRegistration) {
		this.resultsRegistration = resultsRegistration;
	}

	@Column(name = "OTHER", length = 500)
	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Column(name = "BANK", length = 200)
	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	@Column(name = "BANK_ACCOUNT", length = 50)
	public String getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Column(name = "SELECT_TIME_1")
	public Timestamp getSelectTime1() {
		return this.selectTime1;
	}

	public void setSelectTime1(Timestamp selectTime1) {
		this.selectTime1 = selectTime1;
	}

	@Column(name = "SELECT_TIME_2")
	public Timestamp getSelectTime2() {
		return this.selectTime2;
	}

	public void setSelectTime2(Timestamp selectTime2) {
		this.selectTime2 = selectTime2;
	}

	@Column(name = "SELECT_TIME_3")
	public Timestamp getSelectTime3() {
		return this.selectTime3;
	}

	public void setSelectTime3(Timestamp selectTime3) {
		this.selectTime3 = selectTime3;
	}

	@Column(name = "REMARK", length = 1000)
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

	@Column(name = "UPDATE_USER")
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Column(name = "DELETE_FLAG", length = 40)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "RESEARCH", length = 4000)
	public String getResearch() {
		return research;
	}

	public void setResearch(String research) {
		this.research = research;
	}

	@Column(name = "TECHNICAL_SPECIFICATIONS", length = 4000)
	public String getTechnicalSpecifications() {
		return technicalSpecifications;
	}

	public void setTechnicalSpecifications(String technicalSpecifications) {
		this.technicalSpecifications = technicalSpecifications;
	}

	@Column(name = "ARRANGEMENT", length = 4000)
	public String getArrangement() {
		return arrangement;
	}

	public void setArrangement(String arrangement) {
		this.arrangement = arrangement;
	}

	@Column(name = "RESULTS_FORM", length = 4000)
	public String getResultsForm() {
		return resultsForm;
	}

	public void setResultsForm(String resultsForm) {
		this.resultsForm = resultsForm;
	}
}
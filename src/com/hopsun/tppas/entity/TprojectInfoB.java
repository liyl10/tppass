package com.hopsun.tppas.entity;

import java.math.BigDecimal;
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
 * TprojectInfoB entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_PROJECT_INFO_B")
public class TprojectInfoB implements java.io.Serializable {

	private static final long serialVersionUID = 5583905455182614071L;
	// Fields

	private String projectInfoId;
	private TprojectApplication tprojectApplication;
	private String regionId1;
	private String regionId2;
	private String regionId3;
	private String unitAddress;
	private String zipcode;
	private String industries1;
	private String industries2;
	private String industries3;
	private String industries4;
	private String unitProperties;
	private String legalPerson;
	private String legalTel;
	private String legalEmail;
	private String projectPerson;
	private String personTel;
	private String personEmail;
	private String touchPerson;
	private String touchPhone;
	private String touchDepart;
	private String assistUnit;
	//2013-10-10项目所属技术领域变更为三级---wangxd
	/**项目所属技术领域1*/
	private String technicalFisld1;
	/**项目所属技术领域2*/
	private String technicalFisld2;
	/**项目所属技术领域3*/
	private String technicalFisld3;
	private BigDecimal circulatingFund;
	private BigDecimal fastenFund;
	private BigDecimal totalValue;
	private BigDecimal debtRatio;
	private BigDecimal grossIncome;
	private BigDecimal retainedProfits;
	private BigDecimal investmentTotal;
	private BigDecimal specialFunds;
	private BigDecimal annualIncome;
	private BigDecimal selfFinancing;
	private BigDecimal other;
	private BigDecimal credit;
	private String intellectualProperty;
	private String technologySource;
	private String remark;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	
	// 追加字段 2013-09-26 wanglw
	private String legalPhone;
	private String personPhone;
	private String touchTel;
	private String touchPerson1;
	private String touchPhone1;
	private String touchTel1;
	private String touchEmail;
	private String touchEmail1;
	private String accountBank;
	private String accountBankNo;
	private String accountName;
	private String bankNo;
	private String assistUnit1;

	// Constructors

	/** default constructor */
	public TprojectInfoB() {
	}

	/** full constructor */
	public TprojectInfoB(TprojectApplication tprojectApplication,
			String regionId1, String regionId2, String regionId3,
			String unitAddress, String zipcode, String industries1,
			String industries2, String industries3, String industries4,
			String unitProperties, String legalPerson, String legalTel,
			String legalEmail, String projectPerson, String personTel,
			String personEmail, String touchPerson, String touchPhone,
			String touchDepart, String assistUnit, String technicalFisld1,String technicalFisld2,String technicalFisld3,
			BigDecimal circulatingFund, BigDecimal fastenFund, BigDecimal totalValue,
			BigDecimal debtRatio, BigDecimal grossIncome, BigDecimal retainedProfits,
			BigDecimal investmentTotal, BigDecimal specialFunds, BigDecimal annualIncome,
			BigDecimal selfFinancing, BigDecimal other, BigDecimal credit,
			String intellectualProperty, String technologySource,
			String remark, String deleteFlag, Timestamp createTime,
			String createUser, Timestamp updateTime, String updateUser,
			String legalPhone, String personPhone, String touchTel, String touchPerson1,
			String touchPhone1, String touchTel1, String touchEmail,String touchEmail1,
			String accountBank, String accountBankNo, String accountName, String bankNo,
			String assistUnit1) {
		this.tprojectApplication = tprojectApplication;
		this.regionId1 = regionId1;
		this.regionId2 = regionId2;
		this.regionId3 = regionId3;
		this.unitAddress = unitAddress;
		this.zipcode = zipcode;
		this.industries1 = industries1;
		this.industries2 = industries2;
		this.industries3 = industries3;
		this.industries4 = industries4;
		this.unitProperties = unitProperties;
		this.legalPerson = legalPerson;
		this.legalTel = legalTel;
		this.legalEmail = legalEmail;
		this.projectPerson = projectPerson;
		this.personTel = personTel;
		this.personEmail = personEmail;
		this.touchPerson = touchPerson;
		this.touchPhone = touchPhone;
		this.touchDepart = touchDepart;
		this.assistUnit = assistUnit;
		this.technicalFisld1 = technicalFisld1;
		this.technicalFisld2 = technicalFisld2;
		this.technicalFisld3 = technicalFisld3;
		this.circulatingFund = circulatingFund;
		this.fastenFund = fastenFund;
		this.totalValue = totalValue;
		this.debtRatio = debtRatio;
		this.grossIncome = grossIncome;
		this.retainedProfits = retainedProfits;
		this.investmentTotal = investmentTotal;
		this.specialFunds = specialFunds;
		this.annualIncome = annualIncome;
		this.selfFinancing = selfFinancing;
		this.other = other;
		this.credit = credit;
		this.intellectualProperty = intellectualProperty;
		this.technologySource = technologySource;
		this.remark = remark;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		
		// 追加字段
		this.legalPhone = legalPhone;
		this.personPhone = personPhone;
		this.touchTel = touchTel;
		this.touchPerson1 = touchPerson1;
		this.touchTel1 = touchTel1;
		this.touchPhone1 = touchPhone1;
		this.touchEmail = touchEmail;
		this.touchEmail1 = touchEmail1;
		this.accountBank = accountBank;
		this.accountBankNo = accountBankNo;
		this.accountName = accountBank;
		this.bankNo = bankNo;
		this.assistUnit1 = assistUnit1;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PROJECT_INFO_ID", unique = true, nullable = false, length = 40)
	public String getProjectInfoId() {
		return this.projectInfoId;
	}

	public void setProjectInfoId(String projectInfoId) {
		this.projectInfoId = projectInfoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "REGION_ID_1", length = 40)
	public String getRegionId1() {
		return this.regionId1;
	}

	public void setRegionId1(String regionId1) {
		this.regionId1 = regionId1;
	}

	@Column(name = "REGION_ID_2", length = 40)
	public String getRegionId2() {
		return this.regionId2;
	}

	public void setRegionId2(String regionId2) {
		this.regionId2 = regionId2;
	}

	@Column(name = "REGION_ID_3", length = 40)
	public String getRegionId3() {
		return this.regionId3;
	}

	public void setRegionId3(String regionId3) {
		this.regionId3 = regionId3;
	}

	@Column(name = "UNIT_ADDRESS", length = 200)
	public String getUnitAddress() {
		return this.unitAddress;
	}

	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}

	@Column(name = "ZIPCODE", length = 10)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "INDUSTRIES_1", length = 40)
	public String getIndustries1() {
		return this.industries1;
	}

	public void setIndustries1(String industries1) {
		this.industries1 = industries1;
	}

	@Column(name = "INDUSTRIES_2", length = 40)
	public String getIndustries2() {
		return this.industries2;
	}

	public void setIndustries2(String industries2) {
		this.industries2 = industries2;
	}

	@Column(name = "INDUSTRIES_3", length = 40)
	public String getIndustries3() {
		return this.industries3;
	}

	public void setIndustries3(String industries3) {
		this.industries3 = industries3;
	}

	@Column(name = "INDUSTRIES_4", length = 40)
	public String getIndustries4() {
		return this.industries4;
	}

	public void setIndustries4(String industries4) {
		this.industries4 = industries4;
	}

	@Column(name = "UNIT_PROPERTIES", length = 100)
	public String getUnitProperties() {
		return this.unitProperties;
	}

	public void setUnitProperties(String unitProperties) {
		this.unitProperties = unitProperties;
	}

	@Column(name = "LEGAL_PERSON", length = 60)
	public String getLegalPerson() {
		return this.legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	@Column(name = "LEGAL_TEL", length = 15)
	public String getLegalTel() {
		return this.legalTel;
	}

	public void setLegalTel(String legalTel) {
		this.legalTel = legalTel;
	}

	@Column(name = "LEGAL_EMAIL", length = 15)
	public String getLegalEmail() {
		return this.legalEmail;
	}

	public void setLegalEmail(String legalEmail) {
		this.legalEmail = legalEmail;
	}

	@Column(name = "PROJECT_PERSON", length = 60)
	public String getProjectPerson() {
		return this.projectPerson;
	}

	public void setProjectPerson(String projectPerson) {
		this.projectPerson = projectPerson;
	}

	@Column(name = "PERSON_TEL", length = 15)
	public String getPersonTel() {
		return this.personTel;
	}

	public void setPersonTel(String personTel) {
		this.personTel = personTel;
	}

	@Column(name = "PERSON_EMAIL", length = 15)
	public String getPersonEmail() {
		return this.personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	@Column(name = "TOUCH_PERSON", length = 60)
	public String getTouchPerson() {
		return this.touchPerson;
	}

	public void setTouchPerson(String touchPerson) {
		this.touchPerson = touchPerson;
	}

	@Column(name = "TOUCH_PHONE", length = 15)
	public String getTouchPhone() {
		return this.touchPhone;
	}

	public void setTouchPhone(String touchPhone) {
		this.touchPhone = touchPhone;
	}

	@Column(name = "TOUCH_DEPART", length = 50)
	public String getTouchDepart() {
		return this.touchDepart;
	}

	public void setTouchDepart(String touchDepart) {
		this.touchDepart = touchDepart;
	}

	@Column(name = "ASSIST_UNIT", length = 60)
	public String getAssistUnit() {
		return this.assistUnit;
	}

	public void setAssistUnit(String assistUnit) {
		this.assistUnit = assistUnit;
	}

	@Column(name = "TECHNICAL_FISLD_1", length = 40)
	public String getTechnicalFisld1() {
		return this.technicalFisld1;
	}

	public void setTechnicalFisld1(String technicalFisld1) {
		this.technicalFisld1 = technicalFisld1;
	}
	
	@Column(name = "TECHNICAL_FISLD_2", length = 40)
	public String getTechnicalFisld2() {
		return this.technicalFisld2;
	}

	public void setTechnicalFisld2(String technicalFisld2) {
		this.technicalFisld2 = technicalFisld2;
	}
	
	@Column(name = "TECHNICAL_FISLD_3", length = 40)
	public String getTechnicalFisld3() {
		return this.technicalFisld3;
	}

	public void setTechnicalFisld3(String technicalFisld3) {
		this.technicalFisld3 = technicalFisld3;
	}

	@Column(name = "CIRCULATING_FUND", precision = 11, scale = 4)
	public BigDecimal getCirculatingFund() {
		return this.circulatingFund;
	}

	public void setCirculatingFund(BigDecimal circulatingFund) {
		this.circulatingFund = circulatingFund;
	}

	@Column(name = "FASTEN_FUND", precision = 11, scale = 4)
	public BigDecimal getFastenFund() {
		return this.fastenFund;
	}

	public void setFastenFund(BigDecimal fastenFund) {
		this.fastenFund = fastenFund;
	}

	@Column(name = "TOTAL_VALUE", precision = 11, scale = 4)
	public BigDecimal getTotalValue() {
		return this.totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	@Column(name = "DEBT_RATIO", precision = 11, scale = 4)
	public BigDecimal getDebtRatio() {
		return this.debtRatio;
	}

	public void setDebtRatio(BigDecimal debtRatio) {
		this.debtRatio = debtRatio;
	}

	@Column(name = "GROSS_INCOME", precision = 11, scale = 4)
	public BigDecimal getGrossIncome() {
		return this.grossIncome;
	}

	public void setGrossIncome(BigDecimal grossIncome) {
		this.grossIncome = grossIncome;
	}

	@Column(name = "RETAINED_PROFITS", precision = 11, scale = 4)
	public BigDecimal getRetainedProfits() {
		return this.retainedProfits;
	}

	public void setRetainedProfits(BigDecimal retainedProfits) {
		this.retainedProfits = retainedProfits;
	}

	@Column(name = "INVESTMENT_TOTAL", precision = 11, scale = 4)
	public BigDecimal getInvestmentTotal() {
		return this.investmentTotal;
	}

	public void setInvestmentTotal(BigDecimal investmentTotal) {
		this.investmentTotal = investmentTotal;
	}

	@Column(name = "SPECIAL_FUNDS", precision = 11, scale = 4)
	public BigDecimal getSpecialFunds() {
		return this.specialFunds;
	}

	public void setSpecialFunds(BigDecimal specialFunds) {
		this.specialFunds = specialFunds;
	}

	@Column(name = "ANNUAL_INCOME", precision = 11, scale = 4)
	public BigDecimal getAnnualIncome() {
		return this.annualIncome;
	}

	public void setAnnualIncome(BigDecimal annualIncome) {
		this.annualIncome = annualIncome;
	}

	@Column(name = "SELF_FINANCING", precision = 11, scale = 4)
	public BigDecimal getSelfFinancing() {
		return this.selfFinancing;
	}

	public void setSelfFinancing(BigDecimal selfFinancing) {
		this.selfFinancing = selfFinancing;
	}

	@Column(name = "OTHER", precision = 11, scale = 4)
	public BigDecimal getOther() {
		return this.other;
	}

	public void setOther(BigDecimal other) {
		this.other = other;
	}

	@Column(name = "CREDIT", precision = 11, scale = 4)
	public BigDecimal getCredit() {
		return this.credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

	@Column(name = "INTELLECTUAL_PROPERTY", length = 400)
	public String getIntellectualProperty() {
		return this.intellectualProperty;
	}

	public void setIntellectualProperty(String intellectualProperty) {
		this.intellectualProperty = intellectualProperty;
	}

	@Column(name = "TECHNOLOGY_SOURCE", length = 400)
	public String getTechnologySource() {
		return this.technologySource;
	}

	public void setTechnologySource(String technologySource) {
		this.technologySource = technologySource;
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

	@Column(name = "LEGAL_PHONE", length = 15)
	public String getLegalPhone() {
		return legalPhone;
	}

	public void setLegalPhone(String legalPhone) {
		this.legalPhone = legalPhone;
	}

	@Column(name = "PERSON_PHONE", length = 15)
	public String getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}

	@Column(name = "TOUCH_TEL", length = 15)
	public String getTouchTel() {
		return touchTel;
	}

	public void setTouchTel(String touchTel) {
		this.touchTel = touchTel;
	}

	@Column(name = "TOUCH_PERSON1", length = 15)
	public String getTouchPerson1() {
		return touchPerson1;
	}

	public void setTouchPerson1(String touchPerson1) {
		this.touchPerson1 = touchPerson1;
	}

	@Column(name = "TOUCH_PHONE1", length = 15)
	public String getTouchPhone1() {
		return touchPhone1;
	}

	public void setTouchPhone1(String touchPhone1) {
		this.touchPhone1 = touchPhone1;
	}

	@Column(name = "TOUCH_TEL1", length = 15)
	public String getTouchTel1() {
		return touchTel1;
	}

	public void setTouchTel1(String touchTel1) {
		this.touchTel1 = touchTel1;
	}

	@Column(name = "TOUCH_EMAIL", length = 30)
	public String getTouchEmail() {
		return touchEmail;
	}

	public void setTouchEmail(String touchEmail) {
		this.touchEmail = touchEmail;
	}

	@Column(name = "TOUCH_EMAIL1", length = 30)
	public String getTouchEmail1() {
		return touchEmail1;
	}

	public void setTouchEmail1(String touchEmail1) {
		this.touchEmail1 = touchEmail1;
	}

	@Column(name = "ACCOUNT_BANK", length = 30)
	public String getAccountBank() {
		return accountBank;
	}

	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}

	@Column(name = "ACCOUNT_BANK_NO", length = 30)
	public String getAccountBankNo() {
		return accountBankNo;
	}

	public void setAccountBankNo(String accountBankNo) {
		this.accountBankNo = accountBankNo;
	}

	@Column(name = "ACCOUNT_NAME", length = 30)
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Column(name = "BANK_NO", length = 30)
	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	
	@Column(name = "ASSIST_UNIT1", length = 60)
	public String getAssistUnit1() {
		return this.assistUnit1;
	}

	public void setAssistUnit1(String assistUnit1) {
		this.assistUnit1 = assistUnit1;
	}
}
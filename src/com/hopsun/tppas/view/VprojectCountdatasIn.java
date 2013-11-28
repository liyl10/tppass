/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @comments 产业处项目统计实体类
 * @author wanglw
 * @date 2013-11-14 @time 上午9:29:04
 * @Version 1.0
 */
@Entity
@Table(name = "V_PROJECT_COUNTDATAS_IN")
public class VprojectCountdatasIn implements java.io.Serializable{
	
	private static final long serialVersionUID = 4706448687199757994L;
	private String projectId;
	private String centralizedTypeCode;
	private String typeIdCode;
	private String planFlagCode;
	private String regionId1Code;
	private String regionId2Code;
	private String regionId3Code;
	private String industries1Code;
	private String industries2Code;
	private String industries3Code;
	private String industries4Code;
	private String unitPropertiesCode;
	private String technicalFisld1Code;
	private String technicalFisld2Code;
	private String technicalFisld3Code;
	private String intellectualPropertyCode;
	private String technologySourceCode;
	private String reportYear;
	private String projectName;
	private String projectType;
	private String supportFunction;
	private String supportFlag;
	private String applicationUnit;
	private String entrustUnit;
	private String projectPerson;
	private String personPhone;
	private String personTel;
	private String touchPerson;
	private String touchIdcard;
	private String touchPhone;
	private String centralizedType;
	private String startTime;
	private String endTime;
	private String writerepotTime;
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
	private String legalPhone;
	private String legalTel;
	private String assistUnit;
	private String assistUnit1;
	private String technicalFisld1;
	private String technicalFisld2;
	private String technicalFisld3;
	private String circulatingFund;
	private String fastenFund;
	private String totalValue;
	private String debtRatio;
	private String grossIncome;
	private String retainedProfitsB;
	private String scottare;
	private String investmentTotal;
	private String specialFunds;
	private String annualIncome;
	private String selfFinancing;
	private String other;
	private String credit;
	private String intellectualProperty;
	private String technologySource;
	private String enterpriseProfileText;
	private String projectOverviewText;
	private String technicalContentText;
	private String companyFoundation;
	private String schedulingText;
	private String production2;
	private String production1;
	private String production;
	private String payTaxes2;
	private String payTaxes1;
	private String payTaxes;
	private String retainedProfits2;
	private String retainedProfits1;
	private String retainedProfits;
	private String earnMoney2;
	private String earnMoney1;
	private String earnMoney;
	private String newInvest2;
	private String newInvest1;
	private String newInvest;
	private String payTaxes2I;
	private String payTaxes1I;
	private String payTaxesI;
	private String retainedProfits2I;
	private String retainedProfits1I;
	private String retainedProfitsI;
	private String assetSize2;
	private String assetSize1;
	private String assetSize;
	private String newEmployment2;
	private String newEmployment1;
	private String newEmployment;
	private String qualityCertificationSystem;
	private String relevantIndustryPermits;
	private String authorize;
	private String application;
	private String technologyProductCertificate;
	private String totalInvestment;
	private String applicationSpecial;
	private String selfRaisedFunds;
	private String totalBankersCredit;
	private String bankersCredit;
	private String supportFunds;
	private String otherFundsK;
	private String equipmentSpecial;
	private String equipmentSelf;
	private String equipmentSupport;
	private String equipmentTotal;
	private String purchaseComment;
	private String purchaseSpecial;
	private String purchaseSelf;
	private String purchaseSupport;
	private String purchaseTotal;
	private String trialComment;
	private String trialSpecial;
	private String trialSelf;
	private String trialSupport;
	private String trialTotal;
	private String renovationComment;
	private String renovationSpecial;
	private String renovationSelf;
	private String renovationSupport;
	private String renovationTotal;
	private String materialComment;
	private String materialSpecial;
	private String materialSelf;
	private String materialSupport;
	private String materialTotal;
	private String testComment;
	private String testSpecial;
	private String testSelf;
	private String testSupport;
	private String testTotal;
	private String meetComment;
	private String meetSpecial;
	private String meetSelf;
	private String meetSupport;
	private String meetTotal;
	private String cooperationComment;
	private String cooperationSpecial;
	private String cooperationSelf;
	private String cooperationSupport;
	private String cooperationTotal;
	private String publishComment;
	private String publishSpecial;
	private String publishSelf;
	private String publishSupport;
	private String publishTotal;
	private String expertComment;
	private String expertSpecial;
	private String expertSelf;
	private String expertSupport;
	private String expertTotal;
	private String specialTotal;
	private String selfTotal;
	private String supportTotal;
	private String total;
	private String paymentAmount;
	private String paymentAmount1;
	private String paymentAmount2;
	private String paymentAmountTotal;
	private String specialAmount;
	private String specialAmount1;
	private String specialAmount2;
	private String specialAmountTotal;
	private String otherFunds;
	private String otherFunds1;
	private String otherFunds2;
	private String otherFundsTotal;
	private String salesOperate1;
	private String salesOperate2;
	private String salesOperate3;
	private String profitOperate1;
	private String profitOperate2;
	private String profitOperate3;
	private String taxOperate1;
	private String taxOperate2;
	private String taxOperate3;
	private String investmentOperate1;
	private String investmentOperate2;
	private String investmentOperate3;
	private String interestRateOperate1;
	private String interestRateOperate2;
	private String interestRateOperate3;
	private String rdOperate1;
	private String rdOperate2;
	private String rdOperate3;
	private String expectedSales;
	private String expectedTax;
	private String expectedProfits;
	private String interestRateThreeYears;
	private String averageGrowthThreeYears;
	private String companyExpectedGrowth;
	private String salesBenefit1;
	private String salesBenefit2;
	private String salesBenefit3;
	private String profitBenefit1;
	private String profitBenefit2;
	private String profitBenefit3;
	private String taxBenefit1;
	private String taxBenefit2;
	private String taxBenefit3;
	private String projectExpectedGrowth;
	private String rdThreeYears;
	private String patentApplicationsNumber;
	private String inventionNumber;
	private String patentsNumber;
	private String inventionNumber1;
	private String institutesHighTalent;
	private String recommendation;
	private String averageInvestmentExperts;
	private String averageTechnicalExperts;
	private String investmentExperts;
	private String technicalExperts;
	private String reportingUnits;
	private String cooperativeUnits;
	private String contractStatus;
	private String acceptanceStatus;
	private String applyStatus;
	
	public VprojectCountdatasIn() {
		
	}

	public VprojectCountdatasIn(String projectId, String centralizedTypeCode,
			String typeIdCode, String planFlagCode, String regionId1Code,
			String regionId2Code, String regionId3Code, String industries1Code,
			String industries2Code, String industries3Code,
			String industries4Code, String unitPropertiesCode,
			String technicalFisld1Code, String technicalFisld2Code,
			String technicalFisld3Code, String intellectualPropertyCode,
			String technologySourceCode, String reportYear, String projectName,
			String projectType, String supportFunction, String supportFlag,
			String applicationUnit, String entrustUnit, String projectPerson,
			String personPhone, String personTel, String touchPerson,
			String touchIdcard, String touchPhone, String centralizedType,
			String startTime, String endTime, String writerepotTime,
			String regionId1, String regionId2, String regionId3,
			String unitAddress, String zipcode, String industries1,
			String industries2, String industries3, String industries4,
			String unitProperties, String legalPerson, String legalPhone,
			String legalTel, String assistUnit, String assistUnit1,
			String technicalFisld1, String technicalFisld2,
			String technicalFisld3, String circulatingFund, String fastenFund,
			String totalValue, String debtRatio, String grossIncome,
			String retainedProfitsB, String scottare, String investmentTotal,
			String specialFunds, String annualIncome, String selfFinancing,
			String other, String credit, String intellectualProperty,
			String technologySource, String enterpriseProfileText,
			String projectOverviewText, String technicalContentText,
			String companyFoundation, String schedulingText,
			String production2, String production1, String production,
			String payTaxes2, String payTaxes1, String payTaxes,
			String retainedProfits2, String retainedProfits1,
			String retainedProfits, String earnMoney2, String earnMoney1,
			String earnMoney, String newInvest2, String newInvest1,
			String newInvest, String payTaxes2I, String payTaxes1I,
			String payTaxesI, String retainedProfits2I,
			String retainedProfits1I, String retainedProfitsI,
			String assetSize2, String assetSize1, String assetSize,
			String newEmployment2, String newEmployment1, String newEmployment,
			String qualityCertificationSystem, String relevantIndustryPermits,
			String authorize, String application,
			String technologyProductCertificate, String totalInvestment,
			String applicationSpecial, String selfRaisedFunds,
			String totalBankersCredit, String bankersCredit,
			String supportFunds, String otherFundsK, String equipmentSpecial,
			String equipmentSelf, String equipmentSupport,
			String equipmentTotal, String purchaseComment,
			String purchaseSpecial, String purchaseSelf,
			String purchaseSupport, String purchaseTotal, String trialComment,
			String trialSpecial, String trialSelf, String trialSupport,
			String trialTotal, String renovationComment,
			String renovationSpecial, String renovationSelf,
			String renovationSupport, String renovationTotal,
			String materialComment, String materialSpecial,
			String materialSelf, String materialSupport, String materialTotal,
			String testComment, String testSpecial, String testSelf,
			String testSupport, String testTotal, String meetComment,
			String meetSpecial, String meetSelf, String meetSupport,
			String meetTotal, String cooperationComment,
			String cooperationSpecial, String cooperationSelf,
			String cooperationSupport, String cooperationTotal,
			String publishComment, String publishSpecial, String publishSelf,
			String publishSupport, String publishTotal, String expertComment,
			String expertSpecial, String expertSelf, String expertSupport,
			String expertTotal, String specialTotal, String selfTotal,
			String supportTotal, String total, String paymentAmount,
			String paymentAmount1, String paymentAmount2,
			String paymentAmountTotal, String specialAmount,
			String specialAmount1, String specialAmount2,
			String specialAmountTotal, String otherFunds, String otherFunds1,
			String otherFunds2, String otherFundsTotal, String salesOperate1,
			String salesOperate2, String salesOperate3, String profitOperate1,
			String profitOperate2, String profitOperate3, String taxOperate1,
			String taxOperate2, String taxOperate3, String investmentOperate1,
			String investmentOperate2, String investmentOperate3,
			String interestRateOperate1, String interestRateOperate2,
			String interestRateOperate3, String rdOperate1, String rdOperate2,
			String rdOperate3, String expectedSales, String expectedTax,
			String expectedProfits, String interestRateThreeYears,
			String averageGrowthThreeYears, String companyExpectedGrowth,
			String salesBenefit1, String salesBenefit2, String salesBenefit3,
			String profitBenefit1, String profitBenefit2,
			String profitBenefit3, String taxBenefit1, String taxBenefit2,
			String taxBenefit3, String projectExpectedGrowth,
			String rdThreeYears, String patentApplicationsNumber,
			String inventionNumber, String patentsNumber,
			String inventionNumber1, String institutesHighTalent,
			String recommendation, String averageInvestmentExperts,
			String averageTechnicalExperts, String investmentExperts,
			String technicalExperts, String reportingUnits,
			String cooperativeUnits, String contractStatus,
			String acceptanceStatus, String applyStatus) {
		super();
		this.projectId = projectId;
		this.centralizedTypeCode = centralizedTypeCode;
		this.typeIdCode = typeIdCode;
		this.planFlagCode = planFlagCode;
		this.regionId1Code = regionId1Code;
		this.regionId2Code = regionId2Code;
		this.regionId3Code = regionId3Code;
		this.industries1Code = industries1Code;
		this.industries2Code = industries2Code;
		this.industries3Code = industries3Code;
		this.industries4Code = industries4Code;
		this.unitPropertiesCode = unitPropertiesCode;
		this.technicalFisld1Code = technicalFisld1Code;
		this.technicalFisld2Code = technicalFisld2Code;
		this.technicalFisld3Code = technicalFisld3Code;
		this.intellectualPropertyCode = intellectualPropertyCode;
		this.technologySourceCode = technologySourceCode;
		this.reportYear = reportYear;
		this.projectName = projectName;
		this.projectType = projectType;
		this.supportFunction = supportFunction;
		this.supportFlag = supportFlag;
		this.applicationUnit = applicationUnit;
		this.entrustUnit = entrustUnit;
		this.projectPerson = projectPerson;
		this.personPhone = personPhone;
		this.personTel = personTel;
		this.touchPerson = touchPerson;
		this.touchIdcard = touchIdcard;
		this.touchPhone = touchPhone;
		this.centralizedType = centralizedType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.writerepotTime = writerepotTime;
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
		this.legalPhone = legalPhone;
		this.legalTel = legalTel;
		this.assistUnit = assistUnit;
		this.assistUnit1 = assistUnit1;
		this.technicalFisld1 = technicalFisld1;
		this.technicalFisld2 = technicalFisld2;
		this.technicalFisld3 = technicalFisld3;
		this.circulatingFund = circulatingFund;
		this.fastenFund = fastenFund;
		this.totalValue = totalValue;
		this.debtRatio = debtRatio;
		this.grossIncome = grossIncome;
		this.retainedProfitsB = retainedProfitsB;
		this.scottare = scottare;
		this.investmentTotal = investmentTotal;
		this.specialFunds = specialFunds;
		this.annualIncome = annualIncome;
		this.selfFinancing = selfFinancing;
		this.other = other;
		this.credit = credit;
		this.intellectualProperty = intellectualProperty;
		this.technologySource = technologySource;
		this.enterpriseProfileText = enterpriseProfileText;
		this.projectOverviewText = projectOverviewText;
		this.technicalContentText = technicalContentText;
		this.companyFoundation = companyFoundation;
		this.schedulingText = schedulingText;
		this.production2 = production2;
		this.production1 = production1;
		this.production = production;
		this.payTaxes2 = payTaxes2;
		this.payTaxes1 = payTaxes1;
		this.payTaxes = payTaxes;
		this.retainedProfits2 = retainedProfits2;
		this.retainedProfits1 = retainedProfits1;
		this.retainedProfits = retainedProfits;
		this.earnMoney2 = earnMoney2;
		this.earnMoney1 = earnMoney1;
		this.earnMoney = earnMoney;
		this.newInvest2 = newInvest2;
		this.newInvest1 = newInvest1;
		this.newInvest = newInvest;
		this.payTaxes2I = payTaxes2I;
		this.payTaxes1I = payTaxes1I;
		this.payTaxesI = payTaxesI;
		this.retainedProfits2I = retainedProfits2I;
		this.retainedProfits1I = retainedProfits1I;
		this.retainedProfitsI = retainedProfitsI;
		this.assetSize2 = assetSize2;
		this.assetSize1 = assetSize1;
		this.assetSize = assetSize;
		this.newEmployment2 = newEmployment2;
		this.newEmployment1 = newEmployment1;
		this.newEmployment = newEmployment;
		this.qualityCertificationSystem = qualityCertificationSystem;
		this.relevantIndustryPermits = relevantIndustryPermits;
		this.authorize = authorize;
		this.application = application;
		this.technologyProductCertificate = technologyProductCertificate;
		this.totalInvestment = totalInvestment;
		this.applicationSpecial = applicationSpecial;
		this.selfRaisedFunds = selfRaisedFunds;
		this.totalBankersCredit = totalBankersCredit;
		this.bankersCredit = bankersCredit;
		this.supportFunds = supportFunds;
		this.otherFundsK = otherFundsK;
		this.equipmentSpecial = equipmentSpecial;
		this.equipmentSelf = equipmentSelf;
		this.equipmentSupport = equipmentSupport;
		this.equipmentTotal = equipmentTotal;
		this.purchaseComment = purchaseComment;
		this.purchaseSpecial = purchaseSpecial;
		this.purchaseSelf = purchaseSelf;
		this.purchaseSupport = purchaseSupport;
		this.purchaseTotal = purchaseTotal;
		this.trialComment = trialComment;
		this.trialSpecial = trialSpecial;
		this.trialSelf = trialSelf;
		this.trialSupport = trialSupport;
		this.trialTotal = trialTotal;
		this.renovationComment = renovationComment;
		this.renovationSpecial = renovationSpecial;
		this.renovationSelf = renovationSelf;
		this.renovationSupport = renovationSupport;
		this.renovationTotal = renovationTotal;
		this.materialComment = materialComment;
		this.materialSpecial = materialSpecial;
		this.materialSelf = materialSelf;
		this.materialSupport = materialSupport;
		this.materialTotal = materialTotal;
		this.testComment = testComment;
		this.testSpecial = testSpecial;
		this.testSelf = testSelf;
		this.testSupport = testSupport;
		this.testTotal = testTotal;
		this.meetComment = meetComment;
		this.meetSpecial = meetSpecial;
		this.meetSelf = meetSelf;
		this.meetSupport = meetSupport;
		this.meetTotal = meetTotal;
		this.cooperationComment = cooperationComment;
		this.cooperationSpecial = cooperationSpecial;
		this.cooperationSelf = cooperationSelf;
		this.cooperationSupport = cooperationSupport;
		this.cooperationTotal = cooperationTotal;
		this.publishComment = publishComment;
		this.publishSpecial = publishSpecial;
		this.publishSelf = publishSelf;
		this.publishSupport = publishSupport;
		this.publishTotal = publishTotal;
		this.expertComment = expertComment;
		this.expertSpecial = expertSpecial;
		this.expertSelf = expertSelf;
		this.expertSupport = expertSupport;
		this.expertTotal = expertTotal;
		this.specialTotal = specialTotal;
		this.selfTotal = selfTotal;
		this.supportTotal = supportTotal;
		this.total = total;
		this.paymentAmount = paymentAmount;
		this.paymentAmount1 = paymentAmount1;
		this.paymentAmount2 = paymentAmount2;
		this.paymentAmountTotal = paymentAmountTotal;
		this.specialAmount = specialAmount;
		this.specialAmount1 = specialAmount1;
		this.specialAmount2 = specialAmount2;
		this.specialAmountTotal = specialAmountTotal;
		this.otherFunds = otherFunds;
		this.otherFunds1 = otherFunds1;
		this.otherFunds2 = otherFunds2;
		this.otherFundsTotal = otherFundsTotal;
		this.salesOperate1 = salesOperate1;
		this.salesOperate2 = salesOperate2;
		this.salesOperate3 = salesOperate3;
		this.profitOperate1 = profitOperate1;
		this.profitOperate2 = profitOperate2;
		this.profitOperate3 = profitOperate3;
		this.taxOperate1 = taxOperate1;
		this.taxOperate2 = taxOperate2;
		this.taxOperate3 = taxOperate3;
		this.investmentOperate1 = investmentOperate1;
		this.investmentOperate2 = investmentOperate2;
		this.investmentOperate3 = investmentOperate3;
		this.interestRateOperate1 = interestRateOperate1;
		this.interestRateOperate2 = interestRateOperate2;
		this.interestRateOperate3 = interestRateOperate3;
		this.rdOperate1 = rdOperate1;
		this.rdOperate2 = rdOperate2;
		this.rdOperate3 = rdOperate3;
		this.expectedSales = expectedSales;
		this.expectedTax = expectedTax;
		this.expectedProfits = expectedProfits;
		this.interestRateThreeYears = interestRateThreeYears;
		this.averageGrowthThreeYears = averageGrowthThreeYears;
		this.companyExpectedGrowth = companyExpectedGrowth;
		this.salesBenefit1 = salesBenefit1;
		this.salesBenefit2 = salesBenefit2;
		this.salesBenefit3 = salesBenefit3;
		this.profitBenefit1 = profitBenefit1;
		this.profitBenefit2 = profitBenefit2;
		this.profitBenefit3 = profitBenefit3;
		this.taxBenefit1 = taxBenefit1;
		this.taxBenefit2 = taxBenefit2;
		this.taxBenefit3 = taxBenefit3;
		this.projectExpectedGrowth = projectExpectedGrowth;
		this.rdThreeYears = rdThreeYears;
		this.patentApplicationsNumber = patentApplicationsNumber;
		this.inventionNumber = inventionNumber;
		this.patentsNumber = patentsNumber;
		this.inventionNumber1 = inventionNumber1;
		this.institutesHighTalent = institutesHighTalent;
		this.recommendation = recommendation;
		this.averageInvestmentExperts = averageInvestmentExperts;
		this.averageTechnicalExperts = averageTechnicalExperts;
		this.investmentExperts = investmentExperts;
		this.technicalExperts = technicalExperts;
		this.reportingUnits = reportingUnits;
		this.cooperativeUnits = cooperativeUnits;
		this.contractStatus = contractStatus;
		this.acceptanceStatus = acceptanceStatus;
		this.applyStatus = applyStatus;
	}

	@Id
	@Column(name = "PROJECT_ID", unique = true, nullable = false, length = 40)
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@Column(name = "CENTRALIZED_TYPE_CODE", length = 60)
	public String getCentralizedTypeCode() {
		return centralizedTypeCode;
	}

	public void setCentralizedTypeCode(String centralizedTypeCode) {
		this.centralizedTypeCode = centralizedTypeCode;
	}

	@Column(name = "TYPE_ID_CODE", length = 60)
	public String getTypeIdCode() {
		return typeIdCode;
	}

	public void setTypeIdCode(String typeIdCode) {
		this.typeIdCode = typeIdCode;
	}

	@Column(name = "PLAN_FLAG_CODE", length = 60)
	public String getPlanFlagCode() {
		return planFlagCode;
	}

	public void setPlanFlagCode(String planFlagCode) {
		this.planFlagCode = planFlagCode;
	}

	@Column(name = "REGION_ID_1_CODE", length = 60)
	public String getRegionId1Code() {
		return regionId1Code;
	}

	public void setRegionId1Code(String regionId1Code) {
		this.regionId1Code = regionId1Code;
	}

	@Column(name = "REGION_ID_2_CODE", length = 60)
	public String getRegionId2Code() {
		return regionId2Code;
	}

	public void setRegionId2Code(String regionId2Code) {
		this.regionId2Code = regionId2Code;
	}

	@Column(name = "REGION_ID_3_CODE", length = 60)
	public String getRegionId3Code() {
		return regionId3Code;
	}

	public void setRegionId3Code(String regionId3Code) {
		this.regionId3Code = regionId3Code;
	}

	@Column(name = "INDUSTRIES_1_CODE", length = 60)
	public String getIndustries1Code() {
		return industries1Code;
	}

	public void setIndustries1Code(String industries1Code) {
		this.industries1Code = industries1Code;
	}

	@Column(name = "INDUSTRIES_2_CODE", length = 60)
	public String getIndustries2Code() {
		return industries2Code;
	}

	public void setIndustries2Code(String industries2Code) {
		this.industries2Code = industries2Code;
	}

	@Column(name = "INDUSTRIES_3_CODE", length = 60)
	public String getIndustries3Code() {
		return industries3Code;
	}

	public void setIndustries3Code(String industries3Code) {
		this.industries3Code = industries3Code;
	}

	@Column(name = "INDUSTRIES_4_CODE", length = 60)
	public String getIndustries4Code() {
		return industries4Code;
	}

	public void setIndustries4Code(String industries4Code) {
		this.industries4Code = industries4Code;
	}

	@Column(name = "UNIT_PROPERTIES_CODE", length = 60)
	public String getUnitPropertiesCode() {
		return unitPropertiesCode;
	}

	public void setUnitPropertiesCode(String unitPropertiesCode) {
		this.unitPropertiesCode = unitPropertiesCode;
	}

	@Column(name = "TECHNICAL_FISLD_1_CODE", length = 60)
	public String getTechnicalFisld1Code() {
		return technicalFisld1Code;
	}

	public void setTechnicalFisld1Code(String technicalFisld1Code) {
		this.technicalFisld1Code = technicalFisld1Code;
	}

	@Column(name = "TECHNICAL_FISLD_2_CODE", length = 60)
	public String getTechnicalFisld2Code() {
		return technicalFisld2Code;
	}

	public void setTechnicalFisld2Code(String technicalFisld2Code) {
		this.technicalFisld2Code = technicalFisld2Code;
	}

	@Column(name = "TECHNICAL_FISLD_3_CODE", length = 60)
	public String getTechnicalFisld3Code() {
		return technicalFisld3Code;
	}

	public void setTechnicalFisld3Code(String technicalFisld3Code) {
		this.technicalFisld3Code = technicalFisld3Code;
	}

	@Column(name = "INTELLECTUAL_PROPERTY_CODE", length = 60)
	public String getIntellectualPropertyCode() {
		return intellectualPropertyCode;
	}

	public void setIntellectualPropertyCode(String intellectualPropertyCode) {
		this.intellectualPropertyCode = intellectualPropertyCode;
	}

	@Column(name = "TECHNOLOGY_SOURCE_CODE", length = 60)
	public String getTechnologySourceCode() {
		return technologySourceCode;
	}

	public void setTechnologySourceCode(String technologySourceCode) {
		this.technologySourceCode = technologySourceCode;
	}

	@Column(name = "REPORT_YEAR", length = 60)
	public String getReportYear() {
		return reportYear;
	}

	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}

	@Column(name = "PROJECT_NAME", length = 60)
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "PROJECT_TYPE", length = 60)
	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	@Column(name = "SUPPORT_FUNCTION", length = 60)
	public String getSupportFunction() {
		return supportFunction;
	}

	public void setSupportFunction(String supportFunction) {
		this.supportFunction = supportFunction;
	}

	@Column(name = "SUPPORT_FLAG", length = 60)
	public String getSupportFlag() {
		return supportFlag;
	}

	public void setSupportFlag(String supportFlag) {
		this.supportFlag = supportFlag;
	}

	@Column(name = "APPLICATION_UNIT", length = 60)
	public String getApplicationUnit() {
		return applicationUnit;
	}

	public void setApplicationUnit(String applicationUnit) {
		this.applicationUnit = applicationUnit;
	}

	@Column(name = "ENTRUST_UNIT", length = 60)
	public String getEntrustUnit() {
		return entrustUnit;
	}

	public void setEntrustUnit(String entrustUnit) {
		this.entrustUnit = entrustUnit;
	}

	@Column(name = "PROJECT_PERSON", length = 60)
	public String getProjectPerson() {
		return projectPerson;
	}

	public void setProjectPerson(String projectPerson) {
		this.projectPerson = projectPerson;
	}

	@Column(name = "PERSON_PHONE", length = 60)
	public String getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}

	@Column(name = "PERSON_TEL", length = 60)
	public String getPersonTel() {
		return personTel;
	}

	public void setPersonTel(String personTel) {
		this.personTel = personTel;
	}

	@Column(name = "TOUCH_PERSON", length = 60)
	public String getTouchPerson() {
		return touchPerson;
	}

	public void setTouchPerson(String touchPerson) {
		this.touchPerson = touchPerson;
	}

	@Column(name = "TOUCH_IDCARD", length = 60)
	public String getTouchIdcard() {
		return touchIdcard;
	}

	public void setTouchIdcard(String touchIdcard) {
		this.touchIdcard = touchIdcard;
	}

	@Column(name = "TOUCH_PHONE", length = 60)
	public String getTouchPhone() {
		return touchPhone;
	}

	public void setTouchPhone(String touchPhone) {
		this.touchPhone = touchPhone;
	}

	@Column(name = "CENTRALIZED_TYPE", length = 60)
	public String getCentralizedType() {
		return centralizedType;
	}

	public void setCentralizedType(String centralizedType) {
		this.centralizedType = centralizedType;
	}

	@Column(name = "START_TIME", length = 60)
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Column(name = "END_TIME", length = 60)
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Column(name = "WRITEREPOT_TIME", length = 60)
	public String getWriterepotTime() {
		return writerepotTime;
	}

	public void setWriterepotTime(String writerepotTime) {
		this.writerepotTime = writerepotTime;
	}

	@Column(name = "REGION_ID_1", length = 60)
	public String getRegionId1() {
		return regionId1;
	}

	public void setRegionId1(String regionId1) {
		this.regionId1 = regionId1;
	}

	@Column(name = "REGION_ID_2", length = 60)
	public String getRegionId2() {
		return regionId2;
	}

	public void setRegionId2(String regionId2) {
		this.regionId2 = regionId2;
	}

	@Column(name = "REGION_ID_3", length = 60)
	public String getRegionId3() {
		return regionId3;
	}

	public void setRegionId3(String regionId3) {
		this.regionId3 = regionId3;
	}

	@Column(name = "UNIT_ADDRESS", length = 60)
	public String getUnitAddress() {
		return unitAddress;
	}

	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}

	@Column(name = "ZIPCODE", length = 60)
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "INDUSTRIES_1", length = 60)
	public String getIndustries1() {
		return industries1;
	}

	public void setIndustries1(String industries1) {
		this.industries1 = industries1;
	}

	@Column(name = "INDUSTRIES_2", length = 60)
	public String getIndustries2() {
		return industries2;
	}

	public void setIndustries2(String industries2) {
		this.industries2 = industries2;
	}

	@Column(name = "INDUSTRIES_3", length = 60)
	public String getIndustries3() {
		return industries3;
	}

	public void setIndustries3(String industries3) {
		this.industries3 = industries3;
	}

	@Column(name = "INDUSTRIES_4", length = 60)
	public String getIndustries4() {
		return industries4;
	}

	public void setIndustries4(String industries4) {
		this.industries4 = industries4;
	}

	@Column(name = "UNIT_PROPERTIES", length = 60)
	public String getUnitProperties() {
		return unitProperties;
	}

	public void setUnitProperties(String unitProperties) {
		this.unitProperties = unitProperties;
	}

	@Column(name = "LEGAL_PERSON", length = 60)
	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	@Column(name = "LEGAL_PHONE", length = 60)
	public String getLegalPhone() {
		return legalPhone;
	}

	public void setLegalPhone(String legalPhone) {
		this.legalPhone = legalPhone;
	}

	@Column(name = "LEGAL_TEL", length = 60)
	public String getLegalTel() {
		return legalTel;
	}

	public void setLegalTel(String legalTel) {
		this.legalTel = legalTel;
	}

	@Column(name = "ASSIST_UNIT", length = 60)
	public String getAssistUnit() {
		return assistUnit;
	}

	public void setAssistUnit(String assistUnit) {
		this.assistUnit = assistUnit;
	}

	@Column(name = "ASSIST_UNIT1", length = 60)
	public String getAssistUnit1() {
		return assistUnit1;
	}

	public void setAssistUnit1(String assistUnit1) {
		this.assistUnit1 = assistUnit1;
	}

	@Column(name = "TECHNICAL_FISLD_1", length = 60)
	public String getTechnicalFisld1() {
		return technicalFisld1;
	}

	public void setTechnicalFisld1(String technicalFisld1) {
		this.technicalFisld1 = technicalFisld1;
	}

	@Column(name = "TECHNICAL_FISLD_2", length = 60)
	public String getTechnicalFisld2() {
		return technicalFisld2;
	}

	public void setTechnicalFisld2(String technicalFisld2) {
		this.technicalFisld2 = technicalFisld2;
	}

	@Column(name = "TECHNICAL_FISLD_3", length = 60)
	public String getTechnicalFisld3() {
		return technicalFisld3;
	}

	public void setTechnicalFisld3(String technicalFisld3) {
		this.technicalFisld3 = technicalFisld3;
	}

	@Column(name = "CIRCULATING_FUND", length = 60)
	public String getCirculatingFund() {
		return circulatingFund;
	}

	public void setCirculatingFund(String circulatingFund) {
		this.circulatingFund = circulatingFund;
	}

	@Column(name = "FASTEN_FUND", length = 60)
	public String getFastenFund() {
		return fastenFund;
	}

	public void setFastenFund(String fastenFund) {
		this.fastenFund = fastenFund;
	}

	@Column(name = "TOTAL_VALUE", length = 60)
	public String getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(String totalValue) {
		this.totalValue = totalValue;
	}

	@Column(name = "DEBT_RATIO", length = 60)
	public String getDebtRatio() {
		return debtRatio;
	}

	public void setDebtRatio(String debtRatio) {
		this.debtRatio = debtRatio;
	}

	@Column(name = "GROSS_INCOME", length = 60)
	public String getGrossIncome() {
		return grossIncome;
	}

	public void setGrossIncome(String grossIncome) {
		this.grossIncome = grossIncome;
	}

	@Column(name = "RETAINED_PROFITS_B", length = 60)
	public String getRetainedProfitsB() {
		return retainedProfitsB;
	}

	public void setRetainedProfitsB(String retainedProfitsB) {
		this.retainedProfitsB = retainedProfitsB;
	}

	@Column(name = "SCOTTARE", length = 60)
	public String getScottare() {
		return scottare;
	}

	public void setScottare(String scottare) {
		this.scottare = scottare;
	}

	@Column(name = "INVESTMENT_TOTAL", length = 60)
	public String getInvestmentTotal() {
		return investmentTotal;
	}

	public void setInvestmentTotal(String investmentTotal) {
		this.investmentTotal = investmentTotal;
	}

	@Column(name = "SPECIAL_FUNDS", length = 60)
	public String getSpecialFunds() {
		return specialFunds;
	}

	public void setSpecialFunds(String specialFunds) {
		this.specialFunds = specialFunds;
	}

	@Column(name = "ANNUAL_INCOME", length = 60)
	public String getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}

	@Column(name = "SELF_FINANCING", length = 60)
	public String getSelfFinancing() {
		return selfFinancing;
	}

	public void setSelfFinancing(String selfFinancing) {
		this.selfFinancing = selfFinancing;
	}

	@Column(name = "OTHER", length = 60)
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Column(name = "CREDIT", length = 60)
	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	@Column(name = "INTELLECTUAL_PROPERTY", length = 60)
	public String getIntellectualProperty() {
		return intellectualProperty;
	}

	public void setIntellectualProperty(String intellectualProperty) {
		this.intellectualProperty = intellectualProperty;
	}

	@Column(name = "TECHNOLOGY_SOURCE", length = 60)
	public String getTechnologySource() {
		return technologySource;
	}

	public void setTechnologySource(String technologySource) {
		this.technologySource = technologySource;
	}

	@Column(name = "ENTERPRISE_PROFILE_TEXT", length = 60)
	public String getEnterpriseProfileText() {
		return enterpriseProfileText;
	}

	public void setEnterpriseProfileText(String enterpriseProfileText) {
		this.enterpriseProfileText = enterpriseProfileText;
	}

	@Column(name = "PROJECT_OVERVIEW_TEXT", length = 60)
	public String getProjectOverviewText() {
		return projectOverviewText;
	}

	public void setProjectOverviewText(String projectOverviewText) {
		this.projectOverviewText = projectOverviewText;
	}

	@Column(name = "TECHNICAL_CONTENT_TEXT", length = 60)
	public String getTechnicalContentText() {
		return technicalContentText;
	}

	public void setTechnicalContentText(String technicalContentText) {
		this.technicalContentText = technicalContentText;
	}

	@Column(name = "COMPANY_FOUNDATION", length = 60)
	public String getCompanyFoundation() {
		return companyFoundation;
	}

	public void setCompanyFoundation(String companyFoundation) {
		this.companyFoundation = companyFoundation;
	}

	@Column(name = "SCHEDULING_TEXT", length = 60)
	public String getSchedulingText() {
		return schedulingText;
	}

	public void setSchedulingText(String schedulingText) {
		this.schedulingText = schedulingText;
	}

	@Column(name = "PRODUCTION2", length = 60)
	public String getProduction2() {
		return production2;
	}

	public void setProduction2(String production2) {
		this.production2 = production2;
	}

	@Column(name = "PRODUCTION1", length = 60)
	public String getProduction1() {
		return production1;
	}

	public void setProduction1(String production1) {
		this.production1 = production1;
	}

	@Column(name = "PRODUCTION", length = 60)
	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	@Column(name = "PAY_TAXES_2", length = 60)
	public String getPayTaxes2() {
		return payTaxes2;
	}

	public void setPayTaxes2(String payTaxes2) {
		this.payTaxes2 = payTaxes2;
	}

	@Column(name = "PAY_TAXES_1", length = 60)
	public String getPayTaxes1() {
		return payTaxes1;
	}

	public void setPayTaxes1(String payTaxes1) {
		this.payTaxes1 = payTaxes1;
	}

	@Column(name = "PAY_TAXES", length = 60)
	public String getPayTaxes() {
		return payTaxes;
	}

	public void setPayTaxes(String payTaxes) {
		this.payTaxes = payTaxes;
	}

	@Column(name = "RETAINED_PROFITS_2", length = 60)
	public String getRetainedProfits2() {
		return retainedProfits2;
	}

	public void setRetainedProfits2(String retainedProfits2) {
		this.retainedProfits2 = retainedProfits2;
	}

	@Column(name = "RETAINED_PROFITS_1", length = 60)
	public String getRetainedProfits1() {
		return retainedProfits1;
	}

	public void setRetainedProfits1(String retainedProfits1) {
		this.retainedProfits1 = retainedProfits1;
	}

	@Column(name = "RETAINED_PROFITS", length = 60)
	public String getRetainedProfits() {
		return retainedProfits;
	}

	public void setRetainedProfits(String retainedProfits) {
		this.retainedProfits = retainedProfits;
	}

	@Column(name = "EARN_MONEY_2", length = 60)
	public String getEarnMoney2() {
		return earnMoney2;
	}

	public void setEarnMoney2(String earnMoney2) {
		this.earnMoney2 = earnMoney2;
	}

	@Column(name = "EARN_MONEY_1", length = 60)
	public String getEarnMoney1() {
		return earnMoney1;
	}

	public void setEarnMoney1(String earnMoney1) {
		this.earnMoney1 = earnMoney1;
	}

	@Column(name = "EARN_MONEY", length = 60)
	public String getEarnMoney() {
		return earnMoney;
	}

	public void setEarnMoney(String earnMoney) {
		this.earnMoney = earnMoney;
	}

	@Column(name = "NEW_INVEST2", length = 60)
	public String getNewInvest2() {
		return newInvest2;
	}

	public void setNewInvest2(String newInvest2) {
		this.newInvest2 = newInvest2;
	}

	@Column(name = "NEW_INVEST1", length = 60)
	public String getNewInvest1() {
		return newInvest1;
	}

	public void setNewInvest1(String newInvest1) {
		this.newInvest1 = newInvest1;
	}

	@Column(name = "NEW_INVEST", length = 60)
	public String getNewInvest() {
		return newInvest;
	}

	public void setNewInvest(String newInvest) {
		this.newInvest = newInvest;
	}

	@Column(name = "PAY_TAXES_2_I", length = 60)
	public String getPayTaxes2I() {
		return payTaxes2I;
	}

	public void setPayTaxes2I(String payTaxes2I) {
		this.payTaxes2I = payTaxes2I;
	}

	@Column(name = "PAY_TAXES_1_I", length = 60)
	public String getPayTaxes1I() {
		return payTaxes1I;
	}

	public void setPayTaxes1I(String payTaxes1I) {
		this.payTaxes1I = payTaxes1I;
	}

	@Column(name = "PAY_TAXES_I", length = 60)
	public String getPayTaxesI() {
		return payTaxesI;
	}

	public void setPayTaxesI(String payTaxesI) {
		this.payTaxesI = payTaxesI;
	}

	@Column(name = "RETAINED_PROFITS_2_I", length = 60)
	public String getRetainedProfits2I() {
		return retainedProfits2I;
	}

	public void setRetainedProfits2I(String retainedProfits2I) {
		this.retainedProfits2I = retainedProfits2I;
	}

	@Column(name = "RETAINED_PROFITS_1_I", length = 60)
	public String getRetainedProfits1I() {
		return retainedProfits1I;
	}

	public void setRetainedProfits1I(String retainedProfits1I) {
		this.retainedProfits1I = retainedProfits1I;
	}

	@Column(name = "RETAINED_PROFITS_I", length = 60)
	public String getRetainedProfitsI() {
		return retainedProfitsI;
	}

	public void setRetainedProfitsI(String retainedProfitsI) {
		this.retainedProfitsI = retainedProfitsI;
	}

	@Column(name = "ASSET_SIZE2", length = 60)
	public String getAssetSize2() {
		return assetSize2;
	}

	public void setAssetSize2(String assetSize2) {
		this.assetSize2 = assetSize2;
	}

	@Column(name = "ASSET_SIZE1", length = 60)
	public String getAssetSize1() {
		return assetSize1;
	}

	public void setAssetSize1(String assetSize1) {
		this.assetSize1 = assetSize1;
	}

	@Column(name = "ASSET_SIZE", length = 60)
	public String getAssetSize() {
		return assetSize;
	}

	public void setAssetSize(String assetSize) {
		this.assetSize = assetSize;
	}

	@Column(name = "NEW_EMPLOYMENT2", length = 60)
	public String getNewEmployment2() {
		return newEmployment2;
	}

	public void setNewEmployment2(String newEmployment2) {
		this.newEmployment2 = newEmployment2;
	}

	@Column(name = "NEW_EMPLOYMENT1", length = 60)
	public String getNewEmployment1() {
		return newEmployment1;
	}

	public void setNewEmployment1(String newEmployment1) {
		this.newEmployment1 = newEmployment1;
	}

	@Column(name = "NEW_EMPLOYMENT", length = 60)
	public String getNewEmployment() {
		return newEmployment;
	}

	public void setNewEmployment(String newEmployment) {
		this.newEmployment = newEmployment;
	}

	@Column(name = "QUALITY_CERTIFICATION_SYSTEM", length = 60)
	public String getQualityCertificationSystem() {
		return qualityCertificationSystem;
	}

	public void setQualityCertificationSystem(String qualityCertificationSystem) {
		this.qualityCertificationSystem = qualityCertificationSystem;
	}

	@Column(name = "RELEVANT_INDUSTRY_PERMITS", length = 60)
	public String getRelevantIndustryPermits() {
		return relevantIndustryPermits;
	}

	public void setRelevantIndustryPermits(String relevantIndustryPermits) {
		this.relevantIndustryPermits = relevantIndustryPermits;
	}

	@Column(name = "AUTHORIZE", length = 60)
	public String getAuthorize() {
		return authorize;
	}

	public void setAuthorize(String authorize) {
		this.authorize = authorize;
	}

	@Column(name = "APPLICATION", length = 60)
	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	@Column(name = "TECHNOLOGY_PRODUCT_CERTIFICATE", length = 60)
	public String getTechnologyProductCertificate() {
		return technologyProductCertificate;
	}

	public void setTechnologyProductCertificate(
			String technologyProductCertificate) {
		this.technologyProductCertificate = technologyProductCertificate;
	}

	@Column(name = "TOTAL_INVESTMENT", length = 60)
	public String getTotalInvestment() {
		return totalInvestment;
	}

	public void setTotalInvestment(String totalInvestment) {
		this.totalInvestment = totalInvestment;
	}

	@Column(name = "APPLICATION_SPECIAL", length = 60)
	public String getApplicationSpecial() {
		return applicationSpecial;
	}

	public void setApplicationSpecial(String applicationSpecial) {
		this.applicationSpecial = applicationSpecial;
	}

	@Column(name = "SELF_RAISED_FUNDS", length = 60)
	public String getSelfRaisedFunds() {
		return selfRaisedFunds;
	}

	public void setSelfRaisedFunds(String selfRaisedFunds) {
		this.selfRaisedFunds = selfRaisedFunds;
	}

	@Column(name = "TOTAL_BANKERS_CREDIT", length = 60)
	public String getTotalBankersCredit() {
		return totalBankersCredit;
	}

	public void setTotalBankersCredit(String totalBankersCredit) {
		this.totalBankersCredit = totalBankersCredit;
	}

	@Column(name = "BANKERS_CREDIT", length = 60)
	public String getBankersCredit() {
		return bankersCredit;
	}

	public void setBankersCredit(String bankersCredit) {
		this.bankersCredit = bankersCredit;
	}

	@Column(name = "SUPPORT_FUNDS", length = 60)
	public String getSupportFunds() {
		return supportFunds;
	}

	public void setSupportFunds(String supportFunds) {
		this.supportFunds = supportFunds;
	}

	@Column(name = "OTHER_FUNDS_K", length = 60)
	public String getOtherFundsK() {
		return otherFundsK;
	}

	public void setOtherFundsK(String otherFundsK) {
		this.otherFundsK = otherFundsK;
	}

	@Column(name = "EQUIPMENT_SPECIAL", length = 60)
	public String getEquipmentSpecial() {
		return equipmentSpecial;
	}

	public void setEquipmentSpecial(String equipmentSpecial) {
		this.equipmentSpecial = equipmentSpecial;
	}

	@Column(name = "EQUIPMENT_SELF", length = 60)
	public String getEquipmentSelf() {
		return equipmentSelf;
	}

	public void setEquipmentSelf(String equipmentSelf) {
		this.equipmentSelf = equipmentSelf;
	}

	@Column(name = "EQUIPMENT_SUPPORT", length = 60)
	public String getEquipmentSupport() {
		return equipmentSupport;
	}

	public void setEquipmentSupport(String equipmentSupport) {
		this.equipmentSupport = equipmentSupport;
	}

	@Column(name = "EQUIPMENT_TOTAL", length = 60)
	public String getEquipmentTotal() {
		return equipmentTotal;
	}

	public void setEquipmentTotal(String equipmentTotal) {
		this.equipmentTotal = equipmentTotal;
	}

	@Column(name = "PURCHASE_COMMENT", length = 60)
	public String getPurchaseComment() {
		return purchaseComment;
	}

	public void setPurchaseComment(String purchaseComment) {
		this.purchaseComment = purchaseComment;
	}

	@Column(name = "PURCHASE_SPECIAL", length = 60)
	public String getPurchaseSpecial() {
		return purchaseSpecial;
	}

	public void setPurchaseSpecial(String purchaseSpecial) {
		this.purchaseSpecial = purchaseSpecial;
	}

	@Column(name = "PURCHASE_SELF", length = 60)
	public String getPurchaseSelf() {
		return purchaseSelf;
	}

	public void setPurchaseSelf(String purchaseSelf) {
		this.purchaseSelf = purchaseSelf;
	}

	@Column(name = "PURCHASE_SUPPORT", length = 60)
	public String getPurchaseSupport() {
		return purchaseSupport;
	}

	public void setPurchaseSupport(String purchaseSupport) {
		this.purchaseSupport = purchaseSupport;
	}

	@Column(name = "PURCHASE_TOTAL", length = 60)
	public String getPurchaseTotal() {
		return purchaseTotal;
	}

	public void setPurchaseTotal(String purchaseTotal) {
		this.purchaseTotal = purchaseTotal;
	}

	@Column(name = "TRIAL_COMMENT", length = 60)
	public String getTrialComment() {
		return trialComment;
	}

	public void setTrialComment(String trialComment) {
		this.trialComment = trialComment;
	}

	@Column(name = "TRIAL_SPECIAL", length = 60)
	public String getTrialSpecial() {
		return trialSpecial;
	}

	public void setTrialSpecial(String trialSpecial) {
		this.trialSpecial = trialSpecial;
	}

	@Column(name = "TRIAL_SELF", length = 60)
	public String getTrialSelf() {
		return trialSelf;
	}

	public void setTrialSelf(String trialSelf) {
		this.trialSelf = trialSelf;
	}

	@Column(name = "TRIAL_SUPPORT", length = 60)
	public String getTrialSupport() {
		return trialSupport;
	}

	public void setTrialSupport(String trialSupport) {
		this.trialSupport = trialSupport;
	}

	@Column(name = "TRIAL_TOTAL", length = 60)
	public String getTrialTotal() {
		return trialTotal;
	}

	public void setTrialTotal(String trialTotal) {
		this.trialTotal = trialTotal;
	}

	@Column(name = "RENOVATION_COMMENT", length = 60)
	public String getRenovationComment() {
		return renovationComment;
	}

	public void setRenovationComment(String renovationComment) {
		this.renovationComment = renovationComment;
	}

	@Column(name = "RENOVATION_SPECIAL", length = 60)
	public String getRenovationSpecial() {
		return renovationSpecial;
	}

	public void setRenovationSpecial(String renovationSpecial) {
		this.renovationSpecial = renovationSpecial;
	}

	@Column(name = "RENOVATION_SELF", length = 60)
	public String getRenovationSelf() {
		return renovationSelf;
	}

	public void setRenovationSelf(String renovationSelf) {
		this.renovationSelf = renovationSelf;
	}

	@Column(name = "RENOVATION_SUPPORT", length = 60)
	public String getRenovationSupport() {
		return renovationSupport;
	}

	public void setRenovationSupport(String renovationSupport) {
		this.renovationSupport = renovationSupport;
	}

	@Column(name = "RENOVATION_TOTAL", length = 60)
	public String getRenovationTotal() {
		return renovationTotal;
	}

	public void setRenovationTotal(String renovationTotal) {
		this.renovationTotal = renovationTotal;
	}

	@Column(name = "MATERIAL_COMMENT", length = 60)
	public String getMaterialComment() {
		return materialComment;
	}

	public void setMaterialComment(String materialComment) {
		this.materialComment = materialComment;
	}

	@Column(name = "MATERIAL_SPECIAL", length = 60)
	public String getMaterialSpecial() {
		return materialSpecial;
	}

	public void setMaterialSpecial(String materialSpecial) {
		this.materialSpecial = materialSpecial;
	}

	@Column(name = "MATERIAL_SELF", length = 60)
	public String getMaterialSelf() {
		return materialSelf;
	}

	public void setMaterialSelf(String materialSelf) {
		this.materialSelf = materialSelf;
	}

	@Column(name = "MATERIAL_SUPPORT", length = 60)
	public String getMaterialSupport() {
		return materialSupport;
	}

	public void setMaterialSupport(String materialSupport) {
		this.materialSupport = materialSupport;
	}

	@Column(name = "MATERIAL_TOTAL", length = 60)
	public String getMaterialTotal() {
		return materialTotal;
	}

	public void setMaterialTotal(String materialTotal) {
		this.materialTotal = materialTotal;
	}

	@Column(name = "TEST_COMMENT", length = 60)
	public String getTestComment() {
		return testComment;
	}

	public void setTestComment(String testComment) {
		this.testComment = testComment;
	}

	@Column(name = "TEST_SPECIAL", length = 60)
	public String getTestSpecial() {
		return testSpecial;
	}

	public void setTestSpecial(String testSpecial) {
		this.testSpecial = testSpecial;
	}

	@Column(name = "TEST_SELF", length = 60)
	public String getTestSelf() {
		return testSelf;
	}

	public void setTestSelf(String testSelf) {
		this.testSelf = testSelf;
	}

	@Column(name = "TEST_SUPPORT", length = 60)
	public String getTestSupport() {
		return testSupport;
	}

	public void setTestSupport(String testSupport) {
		this.testSupport = testSupport;
	}

	@Column(name = "TEST_TOTAL", length = 60)
	public String getTestTotal() {
		return testTotal;
	}

	public void setTestTotal(String testTotal) {
		this.testTotal = testTotal;
	}

	@Column(name = "MEET_COMMENT", length = 60)
	public String getMeetComment() {
		return meetComment;
	}

	public void setMeetComment(String meetComment) {
		this.meetComment = meetComment;
	}

	@Column(name = "MEET_SPECIAL", length = 60)
	public String getMeetSpecial() {
		return meetSpecial;
	}

	public void setMeetSpecial(String meetSpecial) {
		this.meetSpecial = meetSpecial;
	}

	@Column(name = "MEET_SELF", length = 60)
	public String getMeetSelf() {
		return meetSelf;
	}

	public void setMeetSelf(String meetSelf) {
		this.meetSelf = meetSelf;
	}

	@Column(name = "MEET_SUPPORT", length = 60)
	public String getMeetSupport() {
		return meetSupport;
	}

	public void setMeetSupport(String meetSupport) {
		this.meetSupport = meetSupport;
	}

	@Column(name = "MEET_TOTAL", length = 60)
	public String getMeetTotal() {
		return meetTotal;
	}

	public void setMeetTotal(String meetTotal) {
		this.meetTotal = meetTotal;
	}

	@Column(name = "COOPERATION_COMMENT", length = 60)
	public String getCooperationComment() {
		return cooperationComment;
	}

	public void setCooperationComment(String cooperationComment) {
		this.cooperationComment = cooperationComment;
	}

	@Column(name = "COOPERATION_SPECIAL", length = 60)
	public String getCooperationSpecial() {
		return cooperationSpecial;
	}

	public void setCooperationSpecial(String cooperationSpecial) {
		this.cooperationSpecial = cooperationSpecial;
	}

	@Column(name = "COOPERATION_SELF", length = 60)
	public String getCooperationSelf() {
		return cooperationSelf;
	}

	public void setCooperationSelf(String cooperationSelf) {
		this.cooperationSelf = cooperationSelf;
	}

	@Column(name = "COOPERATION_SUPPORT", length = 60)
	public String getCooperationSupport() {
		return cooperationSupport;
	}

	public void setCooperationSupport(String cooperationSupport) {
		this.cooperationSupport = cooperationSupport;
	}

	@Column(name = "COOPERATION_TOTAL", length = 60)
	public String getCooperationTotal() {
		return cooperationTotal;
	}

	public void setCooperationTotal(String cooperationTotal) {
		this.cooperationTotal = cooperationTotal;
	}

	@Column(name = "PUBLISH_COMMENT", length = 60)
	public String getPublishComment() {
		return publishComment;
	}

	public void setPublishComment(String publishComment) {
		this.publishComment = publishComment;
	}

	@Column(name = "PUBLISH_SPECIAL", length = 60)
	public String getPublishSpecial() {
		return publishSpecial;
	}

	public void setPublishSpecial(String publishSpecial) {
		this.publishSpecial = publishSpecial;
	}

	@Column(name = "PUBLISH_SELF", length = 60)
	public String getPublishSelf() {
		return publishSelf;
	}

	public void setPublishSelf(String publishSelf) {
		this.publishSelf = publishSelf;
	}

	@Column(name = "PUBLISH_SUPPORT", length = 60)
	public String getPublishSupport() {
		return publishSupport;
	}

	public void setPublishSupport(String publishSupport) {
		this.publishSupport = publishSupport;
	}

	@Column(name = "PUBLISH_TOTAL", length = 60)
	public String getPublishTotal() {
		return publishTotal;
	}

	public void setPublishTotal(String publishTotal) {
		this.publishTotal = publishTotal;
	}

	@Column(name = "EXPERT_COMMENT", length = 60)
	public String getExpertComment() {
		return expertComment;
	}

	public void setExpertComment(String expertComment) {
		this.expertComment = expertComment;
	}

	@Column(name = "EXPERT_SPECIAL", length = 60)
	public String getExpertSpecial() {
		return expertSpecial;
	}

	public void setExpertSpecial(String expertSpecial) {
		this.expertSpecial = expertSpecial;
	}

	@Column(name = "EXPERT_SELF", length = 60)
	public String getExpertSelf() {
		return expertSelf;
	}

	public void setExpertSelf(String expertSelf) {
		this.expertSelf = expertSelf;
	}

	@Column(name = "EXPERT_SUPPORT", length = 60)
	public String getExpertSupport() {
		return expertSupport;
	}

	public void setExpertSupport(String expertSupport) {
		this.expertSupport = expertSupport;
	}

	@Column(name = "EXPERT_TOTAL", length = 60)
	public String getExpertTotal() {
		return expertTotal;
	}

	public void setExpertTotal(String expertTotal) {
		this.expertTotal = expertTotal;
	}

	@Column(name = "SPECIAL_TOTAL", length = 60)
	public String getSpecialTotal() {
		return specialTotal;
	}

	public void setSpecialTotal(String specialTotal) {
		this.specialTotal = specialTotal;
	}

	@Column(name = "SELF_TOTAL", length = 60)
	public String getSelfTotal() {
		return selfTotal;
	}

	public void setSelfTotal(String selfTotal) {
		this.selfTotal = selfTotal;
	}

	@Column(name = "SUPPORT_TOTAL", length = 60)
	public String getSupportTotal() {
		return supportTotal;
	}

	public void setSupportTotal(String supportTotal) {
		this.supportTotal = supportTotal;
	}

	@Column(name = "TOTAL", length = 60)
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Column(name = "PAYMENT_AMOUNT", length = 60)
	public String getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	@Column(name = "PAYMENT_AMOUNT_1", length = 60)
	public String getPaymentAmount1() {
		return paymentAmount1;
	}

	public void setPaymentAmount1(String paymentAmount1) {
		this.paymentAmount1 = paymentAmount1;
	}

	@Column(name = "PAYMENT_AMOUNT_2", length = 60)
	public String getPaymentAmount2() {
		return paymentAmount2;
	}

	public void setPaymentAmount2(String paymentAmount2) {
		this.paymentAmount2 = paymentAmount2;
	}

	@Column(name = "PAYMENT_AMOUNT_TOTAL", length = 60)
	public String getPaymentAmountTotal() {
		return paymentAmountTotal;
	}

	public void setPaymentAmountTotal(String paymentAmountTotal) {
		this.paymentAmountTotal = paymentAmountTotal;
	}

	@Column(name = "SPECIAL_AMOUNT", length = 60)
	public String getSpecialAmount() {
		return specialAmount;
	}

	public void setSpecialAmount(String specialAmount) {
		this.specialAmount = specialAmount;
	}

	@Column(name = "SPECIAL_AMOUNT_1", length = 60)
	public String getSpecialAmount1() {
		return specialAmount1;
	}

	public void setSpecialAmount1(String specialAmount1) {
		this.specialAmount1 = specialAmount1;
	}

	@Column(name = "SPECIAL_AMOUNT_2", length = 60)
	public String getSpecialAmount2() {
		return specialAmount2;
	}

	public void setSpecialAmount2(String specialAmount2) {
		this.specialAmount2 = specialAmount2;
	}

	@Column(name = "SPECIAL_AMOUNT_TOTAL", length = 60)
	public String getSpecialAmountTotal() {
		return specialAmountTotal;
	}

	public void setSpecialAmountTotal(String specialAmountTotal) {
		this.specialAmountTotal = specialAmountTotal;
	}

	@Column(name = "OTHER_FUNDS", length = 60)
	public String getOtherFunds() {
		return otherFunds;
	}

	public void setOtherFunds(String otherFunds) {
		this.otherFunds = otherFunds;
	}

	@Column(name = "OTHER_FUNDS_1", length = 60)
	public String getOtherFunds1() {
		return otherFunds1;
	}

	public void setOtherFunds1(String otherFunds1) {
		this.otherFunds1 = otherFunds1;
	}

	@Column(name = "OTHER_FUNDS_2", length = 60)
	public String getOtherFunds2() {
		return otherFunds2;
	}

	public void setOtherFunds2(String otherFunds2) {
		this.otherFunds2 = otherFunds2;
	}

	@Column(name = "OTHER_FUNDS_TOTAL", length = 60)
	public String getOtherFundsTotal() {
		return otherFundsTotal;
	}

	public void setOtherFundsTotal(String otherFundsTotal) {
		this.otherFundsTotal = otherFundsTotal;
	}

	@Column(name = "SALES_OPERATE_1", length = 60)
	public String getSalesOperate1() {
		return salesOperate1;
	}

	public void setSalesOperate1(String salesOperate1) {
		this.salesOperate1 = salesOperate1;
	}

	@Column(name = "SALES_OPERATE_2", length = 60)
	public String getSalesOperate2() {
		return salesOperate2;
	}

	public void setSalesOperate2(String salesOperate2) {
		this.salesOperate2 = salesOperate2;
	}

	@Column(name = "SALES_OPERATE_3", length = 60)
	public String getSalesOperate3() {
		return salesOperate3;
	}

	public void setSalesOperate3(String salesOperate3) {
		this.salesOperate3 = salesOperate3;
	}

	@Column(name = "PROFIT_OPERATE_1", length = 60)
	public String getProfitOperate1() {
		return profitOperate1;
	}

	public void setProfitOperate1(String profitOperate1) {
		this.profitOperate1 = profitOperate1;
	}

	@Column(name = "PROFIT_OPERATE_2", length = 60)
	public String getProfitOperate2() {
		return profitOperate2;
	}

	public void setProfitOperate2(String profitOperate2) {
		this.profitOperate2 = profitOperate2;
	}

	@Column(name = "PROFIT_OPERATE_3", length = 60)
	public String getProfitOperate3() {
		return profitOperate3;
	}

	public void setProfitOperate3(String profitOperate3) {
		this.profitOperate3 = profitOperate3;
	}

	@Column(name = "TAX_OPERATE_1", length = 60)
	public String getTaxOperate1() {
		return taxOperate1;
	}

	public void setTaxOperate1(String taxOperate1) {
		this.taxOperate1 = taxOperate1;
	}

	@Column(name = "TAX_OPERATE_2", length = 60)
	public String getTaxOperate2() {
		return taxOperate2;
	}

	public void setTaxOperate2(String taxOperate2) {
		this.taxOperate2 = taxOperate2;
	}

	@Column(name = "TAX_OPERATE_3", length = 60)
	public String getTaxOperate3() {
		return taxOperate3;
	}

	public void setTaxOperate3(String taxOperate3) {
		this.taxOperate3 = taxOperate3;
	}

	@Column(name = "INVESTMENT_OPERATE_1", length = 60)
	public String getInvestmentOperate1() {
		return investmentOperate1;
	}

	public void setInvestmentOperate1(String investmentOperate1) {
		this.investmentOperate1 = investmentOperate1;
	}

	@Column(name = "INVESTMENT_OPERATE_2", length = 60)
	public String getInvestmentOperate2() {
		return investmentOperate2;
	}

	public void setInvestmentOperate2(String investmentOperate2) {
		this.investmentOperate2 = investmentOperate2;
	}

	@Column(name = "INVESTMENT_OPERATE_3", length = 60)
	public String getInvestmentOperate3() {
		return investmentOperate3;
	}

	public void setInvestmentOperate3(String investmentOperate3) {
		this.investmentOperate3 = investmentOperate3;
	}

	@Column(name = "INTEREST_RATE_OPERATE_1", length = 60)
	public String getInterestRateOperate1() {
		return interestRateOperate1;
	}

	public void setInterestRateOperate1(String interestRateOperate1) {
		this.interestRateOperate1 = interestRateOperate1;
	}

	@Column(name = "INTEREST_RATE_OPERATE_2", length = 60)
	public String getInterestRateOperate2() {
		return interestRateOperate2;
	}

	public void setInterestRateOperate2(String interestRateOperate2) {
		this.interestRateOperate2 = interestRateOperate2;
	}

	@Column(name = "INTEREST_RATE_OPERATE_3", length = 60)
	public String getInterestRateOperate3() {
		return interestRateOperate3;
	}

	public void setInterestRateOperate3(String interestRateOperate3) {
		this.interestRateOperate3 = interestRateOperate3;
	}

	@Column(name = "RD_OPERATE_1", length = 60)
	public String getRdOperate1() {
		return rdOperate1;
	}

	public void setRdOperate1(String rdOperate1) {
		this.rdOperate1 = rdOperate1;
	}

	@Column(name = "RD_OPERATE_2", length = 60)
	public String getRdOperate2() {
		return rdOperate2;
	}

	public void setRdOperate2(String rdOperate2) {
		this.rdOperate2 = rdOperate2;
	}

	@Column(name = "RD_OPERATE_3", length = 60)
	public String getRdOperate3() {
		return rdOperate3;
	}

	public void setRdOperate3(String rdOperate3) {
		this.rdOperate3 = rdOperate3;
	}

	@Column(name = "EXPECTED_SALES", length = 60)
	public String getExpectedSales() {
		return expectedSales;
	}

	public void setExpectedSales(String expectedSales) {
		this.expectedSales = expectedSales;
	}

	@Column(name = "EXPECTED_TAX", length = 60)
	public String getExpectedTax() {
		return expectedTax;
	}

	public void setExpectedTax(String expectedTax) {
		this.expectedTax = expectedTax;
	}

	@Column(name = "EXPECTED_PROFITS", length = 60)
	public String getExpectedProfits() {
		return expectedProfits;
	}

	public void setExpectedProfits(String expectedProfits) {
		this.expectedProfits = expectedProfits;
	}

	@Column(name = "INTEREST_RATE_THREE_YEARS", length = 60)
	public String getInterestRateThreeYears() {
		return interestRateThreeYears;
	}

	public void setInterestRateThreeYears(String interestRateThreeYears) {
		this.interestRateThreeYears = interestRateThreeYears;
	}

	@Column(name = "AVERAGE_GROWTH_THREE_YEARS", length = 60)
	public String getAverageGrowthThreeYears() {
		return averageGrowthThreeYears;
	}

	public void setAverageGrowthThreeYears(String averageGrowthThreeYears) {
		this.averageGrowthThreeYears = averageGrowthThreeYears;
	}

	@Column(name = "COMPANY_EXPECTED_GROWTH", length = 60)
	public String getCompanyExpectedGrowth() {
		return companyExpectedGrowth;
	}

	public void setCompanyExpectedGrowth(String companyExpectedGrowth) {
		this.companyExpectedGrowth = companyExpectedGrowth;
	}

	@Column(name = "SALES_BENEFIT_1", length = 60)
	public String getSalesBenefit1() {
		return salesBenefit1;
	}

	public void setSalesBenefit1(String salesBenefit1) {
		this.salesBenefit1 = salesBenefit1;
	}

	@Column(name = "SALES_BENEFIT_2", length = 60)
	public String getSalesBenefit2() {
		return salesBenefit2;
	}

	public void setSalesBenefit2(String salesBenefit2) {
		this.salesBenefit2 = salesBenefit2;
	}

	@Column(name = "SALES_BENEFIT_3", length = 60)
	public String getSalesBenefit3() {
		return salesBenefit3;
	}

	public void setSalesBenefit3(String salesBenefit3) {
		this.salesBenefit3 = salesBenefit3;
	}

	@Column(name = "PROFIT_BENEFIT_1", length = 60)
	public String getProfitBenefit1() {
		return profitBenefit1;
	}

	public void setProfitBenefit1(String profitBenefit1) {
		this.profitBenefit1 = profitBenefit1;
	}

	@Column(name = "PROFIT_BENEFIT_2", length = 60)
	public String getProfitBenefit2() {
		return profitBenefit2;
	}

	public void setProfitBenefit2(String profitBenefit2) {
		this.profitBenefit2 = profitBenefit2;
	}

	@Column(name = "PROFIT_BENEFIT_3", length = 60)
	public String getProfitBenefit3() {
		return profitBenefit3;
	}

	public void setProfitBenefit3(String profitBenefit3) {
		this.profitBenefit3 = profitBenefit3;
	}

	@Column(name = "TAX_BENEFIT_1", length = 60)
	public String getTaxBenefit1() {
		return taxBenefit1;
	}

	public void setTaxBenefit1(String taxBenefit1) {
		this.taxBenefit1 = taxBenefit1;
	}

	@Column(name = "TAX_BENEFIT_2", length = 60)
	public String getTaxBenefit2() {
		return taxBenefit2;
	}

	public void setTaxBenefit2(String taxBenefit2) {
		this.taxBenefit2 = taxBenefit2;
	}

	@Column(name = "TAX_BENEFIT_3", length = 60)
	public String getTaxBenefit3() {
		return taxBenefit3;
	}

	public void setTaxBenefit3(String taxBenefit3) {
		this.taxBenefit3 = taxBenefit3;
	}

	@Column(name = "PROJECT_EXPECTED_GROWTH", length = 60)
	public String getProjectExpectedGrowth() {
		return projectExpectedGrowth;
	}

	public void setProjectExpectedGrowth(String projectExpectedGrowth) {
		this.projectExpectedGrowth = projectExpectedGrowth;
	}

	@Column(name = "RD_THREE_YEARS", length = 60)
	public String getRdThreeYears() {
		return rdThreeYears;
	}

	public void setRdThreeYears(String rdThreeYears) {
		this.rdThreeYears = rdThreeYears;
	}

	@Column(name = "PATENT_APPLICATIONS_NUMBER", length = 60)
	public String getPatentApplicationsNumber() {
		return patentApplicationsNumber;
	}

	public void setPatentApplicationsNumber(String patentApplicationsNumber) {
		this.patentApplicationsNumber = patentApplicationsNumber;
	}

	@Column(name = "INVENTION_NUMBER", length = 60)
	public String getInventionNumber() {
		return inventionNumber;
	}

	public void setInventionNumber(String inventionNumber) {
		this.inventionNumber = inventionNumber;
	}

	@Column(name = "PATENTS_NUMBER", length = 60)
	public String getPatentsNumber() {
		return patentsNumber;
	}

	public void setPatentsNumber(String patentsNumber) {
		this.patentsNumber = patentsNumber;
	}

	@Column(name = "INVENTION_NUMBER1", length = 60)
	public String getInventionNumber1() {
		return inventionNumber1;
	}

	public void setInventionNumber1(String inventionNumber1) {
		this.inventionNumber1 = inventionNumber1;
	}

	@Column(name = "INSTITUTES_HIGH_TALENT", length = 60)
	public String getInstitutesHighTalent() {
		return institutesHighTalent;
	}

	public void setInstitutesHighTalent(String institutesHighTalent) {
		this.institutesHighTalent = institutesHighTalent;
	}

	@Column(name = "RECOMMENDATION", length = 60)
	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	@Column(name = "AVERAGE_INVESTMENT_EXPERTS", length = 60)
	public String getAverageInvestmentExperts() {
		return averageInvestmentExperts;
	}

	public void setAverageInvestmentExperts(String averageInvestmentExperts) {
		this.averageInvestmentExperts = averageInvestmentExperts;
	}

	@Column(name = "AVERAGE_TECHNICAL_EXPERTS", length = 60)
	public String getAverageTechnicalExperts() {
		return averageTechnicalExperts;
	}

	public void setAverageTechnicalExperts(String averageTechnicalExperts) {
		this.averageTechnicalExperts = averageTechnicalExperts;
	}

	@Column(name = "INVESTMENT_EXPERTS", length = 60)
	public String getInvestmentExperts() {
		return investmentExperts;
	}

	public void setInvestmentExperts(String investmentExperts) {
		this.investmentExperts = investmentExperts;
	}

	@Column(name = "TECHNICAL_EXPERTS", length = 60)
	public String getTechnicalExperts() {
		return technicalExperts;
	}

	public void setTechnicalExperts(String technicalExperts) {
		this.technicalExperts = technicalExperts;
	}

	@Column(name = "REPORTING_UNITS", length = 60)
	public String getReportingUnits() {
		return reportingUnits;
	}

	public void setReportingUnits(String reportingUnits) {
		this.reportingUnits = reportingUnits;
	}

	@Column(name = "COOPERATIVE_UNITS", length = 60)
	public String getCooperativeUnits() {
		return cooperativeUnits;
	}

	public void setCooperativeUnits(String cooperativeUnits) {
		this.cooperativeUnits = cooperativeUnits;
	}

	@Column(name = "CONTRACT_STATUS", length = 60)
	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	@Column(name = "ACCEPTANCE_STATUS", length = 60)
	public String getAcceptanceStatus() {
		return acceptanceStatus;
	}

	public void setAcceptanceStatus(String acceptanceStatus) {
		this.acceptanceStatus = acceptanceStatus;
	}

	@Column(name = "APPLY_STATUS", length = 60)
	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

}


package com.hopsun.tppas.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TcontractContentsA entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_CONTRACT_CONTENTS_A")
public class TcontractContentsA implements java.io.Serializable {

	private static final long serialVersionUID = -179918458238214320L;
	// Fields
	private String contractContentsId;
	private Tcontract tcontract;
	private String TContractName;
	private BigDecimal partySubsidizePartyb;
	private BigDecimal partybNewInvestments;
	private BigDecimal partycSubsidizePartyb;
	private BigDecimal fundingSchemesYear;
	private BigDecimal fundingSchemesMonth;
	private BigDecimal fundingSchemesYuan;
	private BigDecimal fundingSchemesQualified;
	private BigDecimal fundingSchemesBasic;
	private String implementationPlan;
	private BigDecimal totalInvestmentNewXm;
	private BigDecimal cumulativeSalesOverallXm;
	private BigDecimal accumulatedTaxOverallXm;
	private BigDecimal accumulatedProfitsOverallXm;
	private BigDecimal assetSizeOverallXm;
	private BigDecimal employmentNewOverallXm;
	private BigDecimal cumulativeSalesEconomy;
	private BigDecimal accumulatedTaxEconomy;
	private BigDecimal accumulatedProfitsEconomy;
	private String technicalSpecifications;
	private String subindex1;
	private String subindex2;
	private String subindex3;
	private String qualityCertificationSystem;
	private String relevantIndustryPermits;
	private String application;
	private String authorize;
	private String technologyProductCertificate;
	private Timestamp contractSelectDate1;
	private String bank;
	private String bankAccount;
	private Timestamp createTime;
	private Timestamp updateTime;
	private String deleteFlag;
	private BigDecimal totalInvestmentPt;
	private BigDecimal assetSizeOverallPt;
	private BigDecimal employmentNewOverallPt;
	private Timestamp contractSelectDate3;
	private Timestamp contractSelectDate2;
	private String createUser;
	private String updateUser;
	private String remark;
	private Set<TfundsPlanA> tfundsPlanAs = new HashSet<TfundsPlanA>(0);

	// Constructors

	/** default constructor */
	public TcontractContentsA() {
	}

	/** full constructor */
	public TcontractContentsA(Tcontract tcontract, String TContractName,
			BigDecimal partySubsidizePartyb, BigDecimal partybNewInvestments,
			BigDecimal partycSubsidizePartyb, BigDecimal fundingSchemesYear,
			BigDecimal fundingSchemesMonth, BigDecimal fundingSchemesYuan,
			BigDecimal fundingSchemesQualified, BigDecimal fundingSchemesBasic,
			String implementationPlan, BigDecimal totalInvestmentNewXm,
			BigDecimal cumulativeSalesOverallXm, BigDecimal accumulatedTaxOverallXm,
			BigDecimal accumulatedProfitsOverallXm, BigDecimal assetSizeOverallXm,
			BigDecimal employmentNewOverallXm, BigDecimal cumulativeSalesEconomy,
			BigDecimal accumulatedTaxEconomy, BigDecimal accumulatedProfitsEconomy,
			String technicalSpecifications, String subindex1, String subindex2,
			String subindex3, String qualityCertificationSystem,
			String relevantIndustryPermits, String application,
			String authorize, String technologyProductCertificate,
			Timestamp contractSelectDate1, String bank, String bankAccount,
			Timestamp createTime, Timestamp updateTime, String deleteFlag,
			BigDecimal totalInvestmentPt, BigDecimal assetSizeOverallPt,
			BigDecimal employmentNewOverallPt, Timestamp contractSelectDate3,
			Timestamp contractSelectDate2, String createUser, String updateUser,
			String remark, Set<TfundsPlanA> tfundsPlanAs) {
		this.tcontract = tcontract;
		this.TContractName = TContractName;
		this.partySubsidizePartyb = partySubsidizePartyb;
		this.partybNewInvestments = partybNewInvestments;
		this.partycSubsidizePartyb = partycSubsidizePartyb;
		this.fundingSchemesYear = fundingSchemesYear;
		this.fundingSchemesMonth = fundingSchemesMonth;
		this.fundingSchemesYuan = fundingSchemesYuan;
		this.fundingSchemesQualified = fundingSchemesQualified;
		this.fundingSchemesBasic = fundingSchemesBasic;
		this.implementationPlan = implementationPlan;
		this.totalInvestmentNewXm = totalInvestmentNewXm;
		this.cumulativeSalesOverallXm = cumulativeSalesOverallXm;
		this.accumulatedTaxOverallXm = accumulatedTaxOverallXm;
		this.accumulatedProfitsOverallXm = accumulatedProfitsOverallXm;
		this.assetSizeOverallXm = assetSizeOverallXm;
		this.employmentNewOverallXm = employmentNewOverallXm;
		this.cumulativeSalesEconomy = cumulativeSalesEconomy;
		this.accumulatedTaxEconomy = accumulatedTaxEconomy;
		this.accumulatedProfitsEconomy = accumulatedProfitsEconomy;
		this.technicalSpecifications = technicalSpecifications;
		this.subindex1 = subindex1;
		this.subindex2 = subindex2;
		this.subindex3 = subindex3;
		this.qualityCertificationSystem = qualityCertificationSystem;
		this.relevantIndustryPermits = relevantIndustryPermits;
		this.application = application;
		this.authorize = authorize;
		this.technologyProductCertificate = technologyProductCertificate;
		this.contractSelectDate1 = contractSelectDate1;
		this.bank = bank;
		this.bankAccount = bankAccount;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.deleteFlag = deleteFlag;
		this.totalInvestmentPt = totalInvestmentPt;
		this.assetSizeOverallPt = assetSizeOverallPt;
		this.employmentNewOverallPt = employmentNewOverallPt;
		this.contractSelectDate3 = contractSelectDate3;
		this.contractSelectDate2 = contractSelectDate2;
		this.createUser = createUser;
		this.updateUser = updateUser;
		this.remark = remark;
		this.tfundsPlanAs = tfundsPlanAs;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CONTRACT_CONTENTS_ID", unique = true, nullable = false, length = 40)
	public String getContractContentsId() {
		return this.contractContentsId;
	}

	public void setContractContentsId(String contractContentsId) {
		this.contractContentsId = contractContentsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_CONTRACT_ID")
	public Tcontract getTcontract() {
		return this.tcontract;
	}

	public void setTcontract(Tcontract tcontract) {
		this.tcontract = tcontract;
	}

	@Column(name = "T_CONTRACT_NAME", length = 100)
	public String getTContractName() {
		return this.TContractName;
	}

	public void setTContractName(String TContractName) {
		this.TContractName = TContractName;
	}

	@Column(name = "PARTY_SUBSIDIZE_PARTYB", precision = 11, scale = 4)
	public BigDecimal getPartySubsidizePartyb() {
		return this.partySubsidizePartyb;
	}

	public void setPartySubsidizePartyb(BigDecimal partySubsidizePartyb) {
		this.partySubsidizePartyb = partySubsidizePartyb;
	}

	@Column(name = "PARTYB_NEW_INVESTMENTS", precision = 11, scale = 4)
	public BigDecimal getPartybNewInvestments() {
		return this.partybNewInvestments;
	}

	public void setPartybNewInvestments(BigDecimal partybNewInvestments) {
		this.partybNewInvestments = partybNewInvestments;
	}

	@Column(name = "PARTYC_SUBSIDIZE_PARTYB", precision = 11, scale = 4)
	public BigDecimal getPartycSubsidizePartyb() {
		return this.partycSubsidizePartyb;
	}

	public void setPartycSubsidizePartyb(BigDecimal partycSubsidizePartyb) {
		this.partycSubsidizePartyb = partycSubsidizePartyb;
	}

	@Column(name = "FUNDING_SCHEMES_YEAR", precision = 4, scale = 0)
	public BigDecimal getFundingSchemesYear() {
		return this.fundingSchemesYear;
	}

	public void setFundingSchemesYear(BigDecimal fundingSchemesYear) {
		this.fundingSchemesYear = fundingSchemesYear;
	}

	@Column(name = "FUNDING_SCHEMES_MONTH", precision = 2, scale = 0)
	public BigDecimal getFundingSchemesMonth() {
		return this.fundingSchemesMonth;
	}

	public void setFundingSchemesMonth(BigDecimal fundingSchemesMonth) {
		this.fundingSchemesMonth = fundingSchemesMonth;
	}

	@Column(name = "FUNDING_SCHEMES_YUAN", precision = 11, scale = 4)
	public BigDecimal getFundingSchemesYuan() {
		return this.fundingSchemesYuan;
	}

	public void setFundingSchemesYuan(BigDecimal fundingSchemesYuan) {
		this.fundingSchemesYuan = fundingSchemesYuan;
	}

	@Column(name = "FUNDING_SCHEMES_QUALIFIED", precision = 11, scale = 4)
	public BigDecimal getFundingSchemesQualified() {
		return this.fundingSchemesQualified;
	}

	public void setFundingSchemesQualified(BigDecimal fundingSchemesQualified) {
		this.fundingSchemesQualified = fundingSchemesQualified;
	}

	@Column(name = "FUNDING_SCHEMES_BASIC", precision = 11, scale = 4)
	public BigDecimal getFundingSchemesBasic() {
		return this.fundingSchemesBasic;
	}

	public void setFundingSchemesBasic(BigDecimal fundingSchemesBasic) {
		this.fundingSchemesBasic = fundingSchemesBasic;
	}

	@Column(name = "IMPLEMENTATION_PLAN", length = 4000)
	public String getImplementationPlan() {
		return this.implementationPlan;
	}

	public void setImplementationPlan(String implementationPlan) {
		this.implementationPlan = implementationPlan;
	}

	@Column(name = "TOTAL_INVESTMENT_NEW_XM", precision = 11, scale = 4)
	public BigDecimal getTotalInvestmentNewXm() {
		return this.totalInvestmentNewXm;
	}

	public void setTotalInvestmentNewXm(BigDecimal totalInvestmentNewXm) {
		this.totalInvestmentNewXm = totalInvestmentNewXm;
	}

	@Column(name = "CUMULATIVE_SALES_OVERALL_XM", precision = 11, scale = 4)
	public BigDecimal getCumulativeSalesOverallXm() {
		return this.cumulativeSalesOverallXm;
	}

	public void setCumulativeSalesOverallXm(BigDecimal cumulativeSalesOverallXm) {
		this.cumulativeSalesOverallXm = cumulativeSalesOverallXm;
	}

	@Column(name = "ACCUMULATED_TAX_OVERALL_XM", precision = 11, scale = 4)
	public BigDecimal getAccumulatedTaxOverallXm() {
		return this.accumulatedTaxOverallXm;
	}

	public void setAccumulatedTaxOverallXm(BigDecimal accumulatedTaxOverallXm) {
		this.accumulatedTaxOverallXm = accumulatedTaxOverallXm;
	}

	@Column(name = "ACCUMULATED_PROFITS_OVERALL_XM", precision = 11, scale = 4)
	public BigDecimal getAccumulatedProfitsOverallXm() {
		return this.accumulatedProfitsOverallXm;
	}

	public void setAccumulatedProfitsOverallXm(
			BigDecimal accumulatedProfitsOverallXm) {
		this.accumulatedProfitsOverallXm = accumulatedProfitsOverallXm;
	}

	@Column(name = "ASSET_SIZE_OVERALL_XM", precision = 11, scale = 4)
	public BigDecimal getAssetSizeOverallXm() {
		return this.assetSizeOverallXm;
	}

	public void setAssetSizeOverallXm(BigDecimal assetSizeOverallXm) {
		this.assetSizeOverallXm = assetSizeOverallXm;
	}

	@Column(name = "EMPLOYMENT_NEW_OVERALL_XM", precision = 20, scale = 0)
	public BigDecimal getEmploymentNewOverallXm() {
		return this.employmentNewOverallXm;
	}

	public void setEmploymentNewOverallXm(BigDecimal employmentNewOverallXm) {
		this.employmentNewOverallXm = employmentNewOverallXm;
	}

	@Column(name = "CUMULATIVE_SALES_ECONOMY", precision = 11, scale = 4)
	public BigDecimal getCumulativeSalesEconomy() {
		return this.cumulativeSalesEconomy;
	}

	public void setCumulativeSalesEconomy(BigDecimal cumulativeSalesEconomy) {
		this.cumulativeSalesEconomy = cumulativeSalesEconomy;
	}

	@Column(name = "ACCUMULATED_TAX_ECONOMY", precision = 11, scale = 4)
	public BigDecimal getAccumulatedTaxEconomy() {
		return this.accumulatedTaxEconomy;
	}

	public void setAccumulatedTaxEconomy(BigDecimal accumulatedTaxEconomy) {
		this.accumulatedTaxEconomy = accumulatedTaxEconomy;
	}

	@Column(name = "ACCUMULATED_PROFITS_ECONOMY", precision = 11, scale = 4)
	public BigDecimal getAccumulatedProfitsEconomy() {
		return this.accumulatedProfitsEconomy;
	}

	public void setAccumulatedProfitsEconomy(BigDecimal accumulatedProfitsEconomy) {
		this.accumulatedProfitsEconomy = accumulatedProfitsEconomy;
	}

	@Column(name = "TECHNICAL_SPECIFICATIONS", length = 4000)
	public String getTechnicalSpecifications() {
		return this.technicalSpecifications;
	}

	public void setTechnicalSpecifications(String technicalSpecifications) {
		this.technicalSpecifications = technicalSpecifications;
	}

	@Column(name = "SUBINDEX_1", length = 4000)
	public String getSubindex1() {
		return this.subindex1;
	}

	public void setSubindex1(String subindex1) {
		this.subindex1 = subindex1;
	}

	@Column(name = "SUBINDEX_2", length = 4000)
	public String getSubindex2() {
		return this.subindex2;
	}

	public void setSubindex2(String subindex2) {
		this.subindex2 = subindex2;
	}

	@Column(name = "SUBINDEX_3", length = 4000)
	public String getSubindex3() {
		return this.subindex3;
	}

	public void setSubindex3(String subindex3) {
		this.subindex3 = subindex3;
	}

	@Column(name = "QUALITY_CERTIFICATION_SYSTEM", length = 120)
	public String getQualityCertificationSystem() {
		return this.qualityCertificationSystem;
	}

	public void setQualityCertificationSystem(String qualityCertificationSystem) {
		this.qualityCertificationSystem = qualityCertificationSystem;
	}

	@Column(name = "RELEVANT_INDUSTRY_PERMITS", length = 120)
	public String getRelevantIndustryPermits() {
		return this.relevantIndustryPermits;
	}

	public void setRelevantIndustryPermits(String relevantIndustryPermits) {
		this.relevantIndustryPermits = relevantIndustryPermits;
	}

	@Column(name = "APPLICATION", length = 20)
	public String getApplication() {
		return this.application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	@Column(name = "AUTHORIZE", length = 20)
	public String getAuthorize() {
		return this.authorize;
	}

	public void setAuthorize(String authorize) {
		this.authorize = authorize;
	}

	@Column(name = "TECHNOLOGY_PRODUCT_CERTIFICATE", length = 120)
	public String getTechnologyProductCertificate() {
		return this.technologyProductCertificate;
	}

	public void setTechnologyProductCertificate(
			String technologyProductCertificate) {
		this.technologyProductCertificate = technologyProductCertificate;
	}

	@Column(name = "CONTRACT_SELECT_DATE1")
	public Timestamp getContractSelectDate1() {
		return this.contractSelectDate1;
	}

	public void setContractSelectDate1(Timestamp contractSelectDate1) {
		this.contractSelectDate1 = contractSelectDate1;
	}

	@Column(name = "BANK", length = 200)
	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	@Column(name = "BANK_ACCOUNT", length = 30)
	public String getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Column(name = "CREATE_TIME")
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
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

	@Column(name = "TOTAL_INVESTMENT_PT", precision = 11, scale = 4)
	public BigDecimal getTotalInvestmentPt() {
		return this.totalInvestmentPt;
	}

	public void setTotalInvestmentPt(BigDecimal totalInvestmentPt) {
		this.totalInvestmentPt = totalInvestmentPt;
	}

	@Column(name = "ASSET_SIZE_OVERALL_PT", precision = 11, scale = 4)
	public BigDecimal getAssetSizeOverallPt() {
		return this.assetSizeOverallPt;
	}

	public void setAssetSizeOverallPt(BigDecimal assetSizeOverallPt) {
		this.assetSizeOverallPt = assetSizeOverallPt;
	}

	@Column(name = "EMPLOYMENT_NEW_OVERALL_PT", precision = 20, scale = 0)
	public BigDecimal getEmploymentNewOverallPt() {
		return this.employmentNewOverallPt;
	}

	public void setEmploymentNewOverallPt(BigDecimal employmentNewOverallPt) {
		this.employmentNewOverallPt = employmentNewOverallPt;
	}

	@Column(name = "CONTRACT_SELECT_DATE3")
	public Timestamp getContractSelectDate3() {
		return this.contractSelectDate3;
	}

	public void setContractSelectDate3(Timestamp contractSelectDate3) {
		this.contractSelectDate3 = contractSelectDate3;
	}

	@Column(name = "CONTRACT_SELECT_DATE2")
	public Timestamp getContractSelectDate2() {
		return this.contractSelectDate2;
	}

	public void setContractSelectDate2(Timestamp contractSelectDate2) {
		this.contractSelectDate2 = contractSelectDate2;
	}

	@Column(name = "CREATE_USER", length = 50)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tcontractContentsA")
	public Set<TfundsPlanA> getTfundsPlanAs() {
		return this.tfundsPlanAs;
	}

	public void setTfundsPlanAs(Set<TfundsPlanA> tfundsPlanAs) {
		this.tfundsPlanAs = tfundsPlanAs;
	}

}
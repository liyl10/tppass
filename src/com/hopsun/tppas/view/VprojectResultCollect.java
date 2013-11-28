package com.hopsun.tppas.view;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @comments 项目信息视图实体
 * @author liyilin
 * @date 2013-5-17 下午4:10:37
 * @version 1.0
 */
@Entity
@Table(name = "V_PROJECT_RESULT_COLLECT")
public class VprojectResultCollect implements java.io.Serializable {

	private static final long serialVersionUID = 4035906369857797336L;
	// Fields
	private String projectId;
	private String projectName;
	private String applicationUnit;
	private String reportYear;
	private String centralizedTypeId;
	private String centralizedTypeName;
	private String technicalFisld;
	private String technicalFisldName;
	private Double investmentTotal;
	private String typeId;
	private String typeShowName;
	private String parentTypeId;
	private String parentTypeName;
	private String departmentId;
	private Timestamp createTime;
	private Integer yearOperate1;
	private Integer yearOperate2;
	private Integer yearOperate3;
	private Double salesOperate1;
	private Double taxOperate1;
	private Double profitOperate1;
	private String interestRateOperate1;
	private Double rdOperate1;
	private Double investmentOperate1;
	private Double salesOperate2;
	private Double taxOperate2;
	private Double profitOperate2;
	private String interestRateOperate2;
	private Double rdOperate2;
	private Double investmentOperate2;
	private Double salesOperate3;
	private Double taxOperate3;
	private Double profitOperate3;
	private String interestRateOperate3;
	private Double rdOperate3;
	private Double investmentOperate3;
	private Double expectedSales;
	private Double expectedTax;
	private Double expectedProfits;
	private String interestRateThreeYears;
	private String averageGrowthThreeYears;
	private String companyExpectedGrowth;
	private Integer yearBenefit1;
	private Integer yearBenefit2;
	private Integer yearBenefit3;
	private Double salesBenefit1;
	private Double taxBenefit1;
	private Double profitBenefit1;
	private Double salesBenefit2;
	private Double taxBenefit2;
	private Double profitBenefit2;
	private Double salesBenefit3;
	private Double taxBenefit3;
	private Double profitBenefit3;
	private String projectExpectedGrowth;
	private Double rdThreeYears;
	private Integer patentApplicationsNumber;
	private Integer patentsNumber;
	private Integer inventionNumber;
	private String patent;
	private String institutesHighTalent;
	private String recommendation;
	private String averageInvestmentExperts;
	private String averageTechnicalExperts;
	private String investmentExperts;
	private String technicalExperts;

	// Constructors

	/** default constructor */
	public VprojectResultCollect() {
	}

	/** minimal constructor */
	public VprojectResultCollect(String projectId) {
		this.projectId = projectId;
	}

	/** full constructor */
	public VprojectResultCollect(String projectId, String projectName,
			String applicationUnit, String reportYear,
			String centralizedTypeId, String centralizedTypeName,
			String technicalFisld, String technicalFisldName,
			Double investmentTotal, String typeId, String typeShowName,
			String parentTypeId, String parentTypeName, String departmentId,
			Timestamp createTime, Integer yearOperate1, Integer yearOperate2,
			Integer yearOperate3, Double salesOperate1, Double taxOperate1,
			Double profitOperate1, String interestRateOperate1,
			Double rdOperate1, Double investmentOperate1, Double salesOperate2,
			Double taxOperate2, Double profitOperate2,
			String interestRateOperate2, Double rdOperate2,
			Double investmentOperate2, Double salesOperate3,
			Double taxOperate3, Double profitOperate3,
			String interestRateOperate3, Double rdOperate3,
			Double investmentOperate3, Double expectedSales,
			Double expectedTax, Double expectedProfits,
			String interestRateThreeYears, String averageGrowthThreeYears,
			String companyExpectedGrowth, Integer yearBenefit1,
			Integer yearBenefit2, Integer yearBenefit3, Double salesBenefit1,
			Double taxBenefit1, Double profitBenefit1, Double salesBenefit2,
			Double taxBenefit2, Double profitBenefit2, Double salesBenefit3,
			Double taxBenefit3, Double profitBenefit3,
			String projectExpectedGrowth, Double rdThreeYears,
			Integer patentApplicationsNumber, Integer patentsNumber,
			Integer inventionNumber, String patent,
			String institutesHighTalent, String recommendation,
			String averageInvestmentExperts, String averageTechnicalExperts,
			String investmentExperts, String technicalExperts) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.applicationUnit = applicationUnit;
		this.reportYear = reportYear;
		this.centralizedTypeId = centralizedTypeId;
		this.centralizedTypeName = centralizedTypeName;
		this.technicalFisld = technicalFisld;
		this.technicalFisldName = technicalFisldName;
		this.investmentTotal = investmentTotal;
		this.typeId = typeId;
		this.typeShowName = typeShowName;
		this.parentTypeId = parentTypeId;
		this.parentTypeName = parentTypeName;
		this.departmentId = departmentId;
		this.createTime = createTime;
		this.yearOperate1 = yearOperate1;
		this.yearOperate2 = yearOperate2;
		this.yearOperate3 = yearOperate3;
		this.salesOperate1 = salesOperate1;
		this.taxOperate1 = taxOperate1;
		this.profitOperate1 = profitOperate1;
		this.interestRateOperate1 = interestRateOperate1;
		this.rdOperate1 = rdOperate1;
		this.investmentOperate1 = investmentOperate1;
		this.salesOperate2 = salesOperate2;
		this.taxOperate2 = taxOperate2;
		this.profitOperate2 = profitOperate2;
		this.interestRateOperate2 = interestRateOperate2;
		this.rdOperate2 = rdOperate2;
		this.investmentOperate2 = investmentOperate2;
		this.salesOperate3 = salesOperate3;
		this.taxOperate3 = taxOperate3;
		this.profitOperate3 = profitOperate3;
		this.interestRateOperate3 = interestRateOperate3;
		this.rdOperate3 = rdOperate3;
		this.investmentOperate3 = investmentOperate3;
		this.expectedSales = expectedSales;
		this.expectedTax = expectedTax;
		this.expectedProfits = expectedProfits;
		this.interestRateThreeYears = interestRateThreeYears;
		this.averageGrowthThreeYears = averageGrowthThreeYears;
		this.companyExpectedGrowth = companyExpectedGrowth;
		this.yearBenefit1 = yearBenefit1;
		this.yearBenefit2 = yearBenefit2;
		this.yearBenefit3 = yearBenefit3;
		this.salesBenefit1 = salesBenefit1;
		this.taxBenefit1 = taxBenefit1;
		this.profitBenefit1 = profitBenefit1;
		this.salesBenefit2 = salesBenefit2;
		this.taxBenefit2 = taxBenefit2;
		this.profitBenefit2 = profitBenefit2;
		this.salesBenefit3 = salesBenefit3;
		this.taxBenefit3 = taxBenefit3;
		this.profitBenefit3 = profitBenefit3;
		this.projectExpectedGrowth = projectExpectedGrowth;
		this.rdThreeYears = rdThreeYears;
		this.patentApplicationsNumber = patentApplicationsNumber;
		this.patentsNumber = patentsNumber;
		this.inventionNumber = inventionNumber;
		this.patent = patent;
		this.institutesHighTalent = institutesHighTalent;
		this.recommendation = recommendation;
		this.averageInvestmentExperts = averageInvestmentExperts;
		this.averageTechnicalExperts = averageTechnicalExperts;
		this.investmentExperts = investmentExperts;
		this.technicalExperts = technicalExperts;
	}

	// Property accessors

	@Id
	@Column(name = "PROJECT_ID", nullable = false, length = 40)
	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@Column(name = "PROJECT_NAME", length = 100)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "APPLICATION_UNIT", length = 100)
	public String getApplicationUnit() {
		return this.applicationUnit;
	}

	public void setApplicationUnit(String applicationUnit) {
		this.applicationUnit = applicationUnit;
	}

	@Column(name = "REPORT_YEAR", length = 50)
	public String getReportYear() {
		return this.reportYear;
	}

	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}

	@Column(name = "CENTRALIZED_TYPE_ID", length = 40)
	public String getCentralizedTypeId() {
		return this.centralizedTypeId;
	}

	public void setCentralizedTypeId(String centralizedTypeId) {
		this.centralizedTypeId = centralizedTypeId;
	}

	@Column(name = "CENTRALIZED_TYPE_NAME", length = 100)
	public String getCentralizedTypeName() {
		return this.centralizedTypeName;
	}

	public void setCentralizedTypeName(String centralizedTypeName) {
		this.centralizedTypeName = centralizedTypeName;
	}

	@Column(name = "TECHNICAL_FISLD", length = 40)
	public String getTechnicalFisld() {
		return this.technicalFisld;
	}

	public void setTechnicalFisld(String technicalFisld) {
		this.technicalFisld = technicalFisld;
	}

	@Column(name = "TECHNICAL_FISLD_NAME", length = 100)
	public String getTechnicalFisldName() {
		return this.technicalFisldName;
	}

	public void setTechnicalFisldName(String technicalFisldName) {
		this.technicalFisldName = technicalFisldName;
	}

	@Column(name = "INVESTMENT_TOTAL", precision = 11, scale = 4)
	public Double getInvestmentTotal() {
		return this.investmentTotal;
	}

	public void setInvestmentTotal(Double investmentTotal) {
		this.investmentTotal = investmentTotal;
	}

	@Column(name = "TYPE_ID", length = 40)
	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	@Column(name = "TYPE_SHOW_NAME", length = 200)
	public String getTypeShowName() {
		return this.typeShowName;
	}

	public void setTypeShowName(String typeShowName) {
		this.typeShowName = typeShowName;
	}

	@Column(name = "PARENT_TYPE_ID", length = 40)
	public String getParentTypeId() {
		return this.parentTypeId;
	}

	public void setParentTypeId(String parentTypeId) {
		this.parentTypeId = parentTypeId;
	}

	@Column(name = "PARENT_TYPE_NAME", length = 200)
	public String getParentTypeName() {
		return this.parentTypeName;
	}

	public void setParentTypeName(String parentTypeName) {
		this.parentTypeName = parentTypeName;
	}

	@Column(name = "DEPARTMENT_ID", length = 40)
	public String getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	@Column(name = "CREATE_TIME")
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "YEAR_OPERATE_1", precision = 4, scale = 0)
	public Integer getYearOperate1() {
		return this.yearOperate1;
	}

	public void setYearOperate1(Integer yearOperate1) {
		this.yearOperate1 = yearOperate1;
	}

	@Column(name = "YEAR_OPERATE_2", precision = 4, scale = 0)
	public Integer getYearOperate2() {
		return this.yearOperate2;
	}

	public void setYearOperate2(Integer yearOperate2) {
		this.yearOperate2 = yearOperate2;
	}

	@Column(name = "YEAR_OPERATE_3", precision = 4, scale = 0)
	public Integer getYearOperate3() {
		return this.yearOperate3;
	}

	public void setYearOperate3(Integer yearOperate3) {
		this.yearOperate3 = yearOperate3;
	}

	@Column(name = "SALES_OPERATE_1", precision = 11, scale = 4)
	public Double getSalesOperate1() {
		return this.salesOperate1;
	}

	public void setSalesOperate1(Double salesOperate1) {
		this.salesOperate1 = salesOperate1;
	}

	@Column(name = "TAX_OPERATE_1", precision = 11, scale = 4)
	public Double getTaxOperate1() {
		return this.taxOperate1;
	}

	public void setTaxOperate1(Double taxOperate1) {
		this.taxOperate1 = taxOperate1;
	}

	@Column(name = "PROFIT_OPERATE_1", precision = 11, scale = 4)
	public Double getProfitOperate1() {
		return this.profitOperate1;
	}

	public void setProfitOperate1(Double profitOperate1) {
		this.profitOperate1 = profitOperate1;
	}

	@Column(name = "INTEREST_RATE_OPERATE_1", length = 10)
	public String getInterestRateOperate1() {
		return this.interestRateOperate1;
	}

	public void setInterestRateOperate1(String interestRateOperate1) {
		this.interestRateOperate1 = interestRateOperate1;
	}

	@Column(name = "RD_OPERATE_1", precision = 11, scale = 4)
	public Double getRdOperate1() {
		return this.rdOperate1;
	}

	public void setRdOperate1(Double rdOperate1) {
		this.rdOperate1 = rdOperate1;
	}

	@Column(name = "INVESTMENT_OPERATE_1", precision = 11, scale = 4)
	public Double getInvestmentOperate1() {
		return this.investmentOperate1;
	}

	public void setInvestmentOperate1(Double investmentOperate1) {
		this.investmentOperate1 = investmentOperate1;
	}

	@Column(name = "SALES_OPERATE_2", precision = 11, scale = 4)
	public Double getSalesOperate2() {
		return this.salesOperate2;
	}

	public void setSalesOperate2(Double salesOperate2) {
		this.salesOperate2 = salesOperate2;
	}

	@Column(name = "TAX_OPERATE_2", precision = 11, scale = 4)
	public Double getTaxOperate2() {
		return this.taxOperate2;
	}

	public void setTaxOperate2(Double taxOperate2) {
		this.taxOperate2 = taxOperate2;
	}

	@Column(name = "PROFIT_OPERATE_2", precision = 11, scale = 4)
	public Double getProfitOperate2() {
		return this.profitOperate2;
	}

	public void setProfitOperate2(Double profitOperate2) {
		this.profitOperate2 = profitOperate2;
	}

	@Column(name = "INTEREST_RATE_OPERATE_2", length = 10)
	public String getInterestRateOperate2() {
		return this.interestRateOperate2;
	}

	public void setInterestRateOperate2(String interestRateOperate2) {
		this.interestRateOperate2 = interestRateOperate2;
	}

	@Column(name = "RD_OPERATE_2", precision = 11, scale = 4)
	public Double getRdOperate2() {
		return this.rdOperate2;
	}

	public void setRdOperate2(Double rdOperate2) {
		this.rdOperate2 = rdOperate2;
	}

	@Column(name = "INVESTMENT_OPERATE_2", precision = 11, scale = 4)
	public Double getInvestmentOperate2() {
		return this.investmentOperate2;
	}

	public void setInvestmentOperate2(Double investmentOperate2) {
		this.investmentOperate2 = investmentOperate2;
	}

	@Column(name = "SALES_OPERATE_3", precision = 11, scale = 4)
	public Double getSalesOperate3() {
		return this.salesOperate3;
	}

	public void setSalesOperate3(Double salesOperate3) {
		this.salesOperate3 = salesOperate3;
	}

	@Column(name = "TAX_OPERATE_3", precision = 11, scale = 4)
	public Double getTaxOperate3() {
		return this.taxOperate3;
	}

	public void setTaxOperate3(Double taxOperate3) {
		this.taxOperate3 = taxOperate3;
	}

	@Column(name = "PROFIT_OPERATE_3", precision = 11, scale = 4)
	public Double getProfitOperate3() {
		return this.profitOperate3;
	}

	public void setProfitOperate3(Double profitOperate3) {
		this.profitOperate3 = profitOperate3;
	}

	@Column(name = "INTEREST_RATE_OPERATE_3", length = 10)
	public String getInterestRateOperate3() {
		return this.interestRateOperate3;
	}

	public void setInterestRateOperate3(String interestRateOperate3) {
		this.interestRateOperate3 = interestRateOperate3;
	}

	@Column(name = "RD_OPERATE_3", precision = 11, scale = 4)
	public Double getRdOperate3() {
		return this.rdOperate3;
	}

	public void setRdOperate3(Double rdOperate3) {
		this.rdOperate3 = rdOperate3;
	}

	@Column(name = "INVESTMENT_OPERATE_3", precision = 11, scale = 4)
	public Double getInvestmentOperate3() {
		return this.investmentOperate3;
	}

	public void setInvestmentOperate3(Double investmentOperate3) {
		this.investmentOperate3 = investmentOperate3;
	}

	@Column(name = "EXPECTED_SALES", precision = 11, scale = 4)
	public Double getExpectedSales() {
		return this.expectedSales;
	}

	public void setExpectedSales(Double expectedSales) {
		this.expectedSales = expectedSales;
	}

	@Column(name = "EXPECTED_TAX", precision = 11, scale = 4)
	public Double getExpectedTax() {
		return this.expectedTax;
	}

	public void setExpectedTax(Double expectedTax) {
		this.expectedTax = expectedTax;
	}

	@Column(name = "EXPECTED_PROFITS", precision = 11, scale = 4)
	public Double getExpectedProfits() {
		return this.expectedProfits;
	}

	public void setExpectedProfits(Double expectedProfits) {
		this.expectedProfits = expectedProfits;
	}

	@Column(name = "INTEREST_RATE_THREE_YEARS", length = 10)
	public String getInterestRateThreeYears() {
		return this.interestRateThreeYears;
	}

	public void setInterestRateThreeYears(String interestRateThreeYears) {
		this.interestRateThreeYears = interestRateThreeYears;
	}

	@Column(name = "AVERAGE_GROWTH_THREE_YEARS", length = 10)
	public String getAverageGrowthThreeYears() {
		return this.averageGrowthThreeYears;
	}

	public void setAverageGrowthThreeYears(String averageGrowthThreeYears) {
		this.averageGrowthThreeYears = averageGrowthThreeYears;
	}

	@Column(name = "COMPANY_EXPECTED_GROWTH", length = 10)
	public String getCompanyExpectedGrowth() {
		return this.companyExpectedGrowth;
	}

	public void setCompanyExpectedGrowth(String companyExpectedGrowth) {
		this.companyExpectedGrowth = companyExpectedGrowth;
	}

	@Column(name = "YEAR_BENEFIT_1", precision = 4, scale = 0)
	public Integer getYearBenefit1() {
		return this.yearBenefit1;
	}

	public void setYearBenefit1(Integer yearBenefit1) {
		this.yearBenefit1 = yearBenefit1;
	}

	@Column(name = "YEAR_BENEFIT_2", precision = 4, scale = 0)
	public Integer getYearBenefit2() {
		return this.yearBenefit2;
	}

	public void setYearBenefit2(Integer yearBenefit2) {
		this.yearBenefit2 = yearBenefit2;
	}

	@Column(name = "YEAR_BENEFIT_3", precision = 4, scale = 0)
	public Integer getYearBenefit3() {
		return this.yearBenefit3;
	}

	public void setYearBenefit3(Integer yearBenefit3) {
		this.yearBenefit3 = yearBenefit3;
	}

	@Column(name = "SALES_BENEFIT_1", precision = 11, scale = 4)
	public Double getSalesBenefit1() {
		return this.salesBenefit1;
	}

	public void setSalesBenefit1(Double salesBenefit1) {
		this.salesBenefit1 = salesBenefit1;
	}

	@Column(name = "TAX_BENEFIT_1", precision = 11, scale = 4)
	public Double getTaxBenefit1() {
		return this.taxBenefit1;
	}

	public void setTaxBenefit1(Double taxBenefit1) {
		this.taxBenefit1 = taxBenefit1;
	}

	@Column(name = "PROFIT_BENEFIT_1", precision = 11, scale = 4)
	public Double getProfitBenefit1() {
		return this.profitBenefit1;
	}

	public void setProfitBenefit1(Double profitBenefit1) {
		this.profitBenefit1 = profitBenefit1;
	}

	@Column(name = "SALES_BENEFIT_2", precision = 11, scale = 4)
	public Double getSalesBenefit2() {
		return this.salesBenefit2;
	}

	public void setSalesBenefit2(Double salesBenefit2) {
		this.salesBenefit2 = salesBenefit2;
	}

	@Column(name = "TAX_BENEFIT_2", precision = 11, scale = 4)
	public Double getTaxBenefit2() {
		return this.taxBenefit2;
	}

	public void setTaxBenefit2(Double taxBenefit2) {
		this.taxBenefit2 = taxBenefit2;
	}

	@Column(name = "PROFIT_BENEFIT_2", precision = 11, scale = 4)
	public Double getProfitBenefit2() {
		return this.profitBenefit2;
	}

	public void setProfitBenefit2(Double profitBenefit2) {
		this.profitBenefit2 = profitBenefit2;
	}

	@Column(name = "SALES_BENEFIT_3", precision = 11, scale = 4)
	public Double getSalesBenefit3() {
		return this.salesBenefit3;
	}

	public void setSalesBenefit3(Double salesBenefit3) {
		this.salesBenefit3 = salesBenefit3;
	}

	@Column(name = "TAX_BENEFIT_3", precision = 11, scale = 4)
	public Double getTaxBenefit3() {
		return this.taxBenefit3;
	}

	public void setTaxBenefit3(Double taxBenefit3) {
		this.taxBenefit3 = taxBenefit3;
	}

	@Column(name = "PROFIT_BENEFIT_3", precision = 11, scale = 4)
	public Double getProfitBenefit3() {
		return this.profitBenefit3;
	}

	public void setProfitBenefit3(Double profitBenefit3) {
		this.profitBenefit3 = profitBenefit3;
	}

	@Column(name = "PROJECT_EXPECTED_GROWTH", length = 10)
	public String getProjectExpectedGrowth() {
		return this.projectExpectedGrowth;
	}

	public void setProjectExpectedGrowth(String projectExpectedGrowth) {
		this.projectExpectedGrowth = projectExpectedGrowth;
	}

	@Column(name = "RD_THREE_YEARS", precision = 11, scale = 4)
	public Double getRdThreeYears() {
		return this.rdThreeYears;
	}

	public void setRdThreeYears(Double rdThreeYears) {
		this.rdThreeYears = rdThreeYears;
	}

	@Column(name = "PATENT_APPLICATIONS_NUMBER", precision = 7, scale = 0)
	public Integer getPatentApplicationsNumber() {
		return this.patentApplicationsNumber;
	}

	public void setPatentApplicationsNumber(Integer patentApplicationsNumber) {
		this.patentApplicationsNumber = patentApplicationsNumber;
	}

	@Column(name = "PATENTS_NUMBER", precision = 7, scale = 0)
	public Integer getPatentsNumber() {
		return this.patentsNumber;
	}

	public void setPatentsNumber(Integer patentsNumber) {
		this.patentsNumber = patentsNumber;
	}

	@Column(name = "INVENTION_NUMBER", precision = 7, scale = 0)
	public Integer getInventionNumber() {
		return this.inventionNumber;
	}

	public void setInventionNumber(Integer inventionNumber) {
		this.inventionNumber = inventionNumber;
	}

	@Column(name = "PATENT", length = 122)
	public String getPatent() {
		return this.patent;
	}

	public void setPatent(String patent) {
		this.patent = patent;
	}

	@Column(name = "INSTITUTES_HIGH_TALENT", length = 100)
	public String getInstitutesHighTalent() {
		return this.institutesHighTalent;
	}

	public void setInstitutesHighTalent(String institutesHighTalent) {
		this.institutesHighTalent = institutesHighTalent;
	}

	@Column(name = "RECOMMENDATION", length = 100)
	public String getRecommendation() {
		return this.recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	@Column(name = "AVERAGE_INVESTMENT_EXPERTS", length = 10)
	public String getAverageInvestmentExperts() {
		return this.averageInvestmentExperts;
	}

	public void setAverageInvestmentExperts(String averageInvestmentExperts) {
		this.averageInvestmentExperts = averageInvestmentExperts;
	}

	@Column(name = "AVERAGE_TECHNICAL_EXPERTS", length = 10)
	public String getAverageTechnicalExperts() {
		return this.averageTechnicalExperts;
	}

	public void setAverageTechnicalExperts(String averageTechnicalExperts) {
		this.averageTechnicalExperts = averageTechnicalExperts;
	}

	@Column(name = "INVESTMENT_EXPERTS", length = 100)
	public String getInvestmentExperts() {
		return this.investmentExperts;
	}

	public void setInvestmentExperts(String investmentExperts) {
		this.investmentExperts = investmentExperts;
	}

	@Column(name = "TECHNICAL_EXPERTS", length = 100)
	public String getTechnicalExperts() {
		return this.technicalExperts;
	}

	public void setTechnicalExperts(String technicalExperts) {
		this.technicalExperts = technicalExperts;
	}

	/*public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VprojectResultCollect))
			return false;
		VprojectResultCollect castOther = (VprojectResultCollect) other;

		return ((this.getProjectId() == castOther.getProjectId()) || (this
				.getProjectId() != null
				&& castOther.getProjectId() != null && this.getProjectId()
				.equals(castOther.getProjectId())))
				&& ((this.getProjectName() == castOther.getProjectName()) || (this
						.getProjectName() != null
						&& castOther.getProjectName() != null && this
						.getProjectName().equals(castOther.getProjectName())))
				&& ((this.getApplicationUnit() == castOther
						.getApplicationUnit()) || (this.getApplicationUnit() != null
						&& castOther.getApplicationUnit() != null && this
						.getApplicationUnit().equals(
								castOther.getApplicationUnit())))
				&& ((this.getReportYear() == castOther.getReportYear()) || (this
						.getReportYear() != null
						&& castOther.getReportYear() != null && this
						.getReportYear().equals(castOther.getReportYear())))
				&& ((this.getCentralizedTypeId() == castOther
						.getCentralizedTypeId()) || (this
						.getCentralizedTypeId() != null
						&& castOther.getCentralizedTypeId() != null && this
						.getCentralizedTypeId().equals(
								castOther.getCentralizedTypeId())))
				&& ((this.getCentralizedTypeName() == castOther
						.getCentralizedTypeName()) || (this
						.getCentralizedTypeName() != null
						&& castOther.getCentralizedTypeName() != null && this
						.getCentralizedTypeName().equals(
								castOther.getCentralizedTypeName())))
				&& ((this.getTechnicalFisld() == castOther.getTechnicalFisld()) || (this
						.getTechnicalFisld() != null
						&& castOther.getTechnicalFisld() != null && this
						.getTechnicalFisld().equals(
								castOther.getTechnicalFisld())))
				&& ((this.getTechnicalFisldName() == castOther
						.getTechnicalFisldName()) || (this
						.getTechnicalFisldName() != null
						&& castOther.getTechnicalFisldName() != null && this
						.getTechnicalFisldName().equals(
								castOther.getTechnicalFisldName())))
				&& ((this.getInvestmentTotal() == castOther
						.getInvestmentTotal()) || (this.getInvestmentTotal() != null
						&& castOther.getInvestmentTotal() != null && this
						.getInvestmentTotal().equals(
								castOther.getInvestmentTotal())))
				&& ((this.getTypeId() == castOther.getTypeId()) || (this
						.getTypeId() != null
						&& castOther.getTypeId() != null && this.getTypeId()
						.equals(castOther.getTypeId())))
				&& ((this.getTypeShowName() == castOther.getTypeShowName()) || (this
						.getTypeShowName() != null
						&& castOther.getTypeShowName() != null && this
						.getTypeShowName().equals(castOther.getTypeShowName())))
				&& ((this.getParentTypeId() == castOther.getParentTypeId()) || (this
						.getParentTypeId() != null
						&& castOther.getParentTypeId() != null && this
						.getParentTypeId().equals(castOther.getParentTypeId())))
				&& ((this.getParentTypeName() == castOther.getParentTypeName()) || (this
						.getParentTypeName() != null
						&& castOther.getParentTypeName() != null && this
						.getParentTypeName().equals(
								castOther.getParentTypeName())))
				&& ((this.getDepartmentId() == castOther.getDepartmentId()) || (this
						.getDepartmentId() != null
						&& castOther.getDepartmentId() != null && this
						.getDepartmentId().equals(castOther.getDepartmentId())))
				&& ((this.getCreateTime() == castOther.getCreateTime()) || (this
						.getCreateTime() != null
						&& castOther.getCreateTime() != null && this
						.getCreateTime().equals(castOther.getCreateTime())))
				&& ((this.getYearOperate1() == castOther.getYearOperate1()) || (this
						.getYearOperate1() != null
						&& castOther.getYearOperate1() != null && this
						.getYearOperate1().equals(castOther.getYearOperate1())))
				&& ((this.getYearOperate2() == castOther.getYearOperate2()) || (this
						.getYearOperate2() != null
						&& castOther.getYearOperate2() != null && this
						.getYearOperate2().equals(castOther.getYearOperate2())))
				&& ((this.getYearOperate3() == castOther.getYearOperate3()) || (this
						.getYearOperate3() != null
						&& castOther.getYearOperate3() != null && this
						.getYearOperate3().equals(castOther.getYearOperate3())))
				&& ((this.getSalesOperate1() == castOther.getSalesOperate1()) || (this
						.getSalesOperate1() != null
						&& castOther.getSalesOperate1() != null && this
						.getSalesOperate1()
						.equals(castOther.getSalesOperate1())))
				&& ((this.getTaxOperate1() == castOther.getTaxOperate1()) || (this
						.getTaxOperate1() != null
						&& castOther.getTaxOperate1() != null && this
						.getTaxOperate1().equals(castOther.getTaxOperate1())))
				&& ((this.getProfitOperate1() == castOther.getProfitOperate1()) || (this
						.getProfitOperate1() != null
						&& castOther.getProfitOperate1() != null && this
						.getProfitOperate1().equals(
								castOther.getProfitOperate1())))
				&& ((this.getInterestRateOperate1() == castOther
						.getInterestRateOperate1()) || (this
						.getInterestRateOperate1() != null
						&& castOther.getInterestRateOperate1() != null && this
						.getInterestRateOperate1().equals(
								castOther.getInterestRateOperate1())))
				&& ((this.getRdOperate1() == castOther.getRdOperate1()) || (this
						.getRdOperate1() != null
						&& castOther.getRdOperate1() != null && this
						.getRdOperate1().equals(castOther.getRdOperate1())))
				&& ((this.getInvestmentOperate1() == castOther
						.getInvestmentOperate1()) || (this
						.getInvestmentOperate1() != null
						&& castOther.getInvestmentOperate1() != null && this
						.getInvestmentOperate1().equals(
								castOther.getInvestmentOperate1())))
				&& ((this.getSalesOperate2() == castOther.getSalesOperate2()) || (this
						.getSalesOperate2() != null
						&& castOther.getSalesOperate2() != null && this
						.getSalesOperate2()
						.equals(castOther.getSalesOperate2())))
				&& ((this.getTaxOperate2() == castOther.getTaxOperate2()) || (this
						.getTaxOperate2() != null
						&& castOther.getTaxOperate2() != null && this
						.getTaxOperate2().equals(castOther.getTaxOperate2())))
				&& ((this.getProfitOperate2() == castOther.getProfitOperate2()) || (this
						.getProfitOperate2() != null
						&& castOther.getProfitOperate2() != null && this
						.getProfitOperate2().equals(
								castOther.getProfitOperate2())))
				&& ((this.getInterestRateOperate2() == castOther
						.getInterestRateOperate2()) || (this
						.getInterestRateOperate2() != null
						&& castOther.getInterestRateOperate2() != null && this
						.getInterestRateOperate2().equals(
								castOther.getInterestRateOperate2())))
				&& ((this.getRdOperate2() == castOther.getRdOperate2()) || (this
						.getRdOperate2() != null
						&& castOther.getRdOperate2() != null && this
						.getRdOperate2().equals(castOther.getRdOperate2())))
				&& ((this.getInvestmentOperate2() == castOther
						.getInvestmentOperate2()) || (this
						.getInvestmentOperate2() != null
						&& castOther.getInvestmentOperate2() != null && this
						.getInvestmentOperate2().equals(
								castOther.getInvestmentOperate2())))
				&& ((this.getSalesOperate3() == castOther.getSalesOperate3()) || (this
						.getSalesOperate3() != null
						&& castOther.getSalesOperate3() != null && this
						.getSalesOperate3()
						.equals(castOther.getSalesOperate3())))
				&& ((this.getTaxOperate3() == castOther.getTaxOperate3()) || (this
						.getTaxOperate3() != null
						&& castOther.getTaxOperate3() != null && this
						.getTaxOperate3().equals(castOther.getTaxOperate3())))
				&& ((this.getProfitOperate3() == castOther.getProfitOperate3()) || (this
						.getProfitOperate3() != null
						&& castOther.getProfitOperate3() != null && this
						.getProfitOperate3().equals(
								castOther.getProfitOperate3())))
				&& ((this.getInterestRateOperate3() == castOther
						.getInterestRateOperate3()) || (this
						.getInterestRateOperate3() != null
						&& castOther.getInterestRateOperate3() != null && this
						.getInterestRateOperate3().equals(
								castOther.getInterestRateOperate3())))
				&& ((this.getRdOperate3() == castOther.getRdOperate3()) || (this
						.getRdOperate3() != null
						&& castOther.getRdOperate3() != null && this
						.getRdOperate3().equals(castOther.getRdOperate3())))
				&& ((this.getInvestmentOperate3() == castOther
						.getInvestmentOperate3()) || (this
						.getInvestmentOperate3() != null
						&& castOther.getInvestmentOperate3() != null && this
						.getInvestmentOperate3().equals(
								castOther.getInvestmentOperate3())))
				&& ((this.getExpectedSales() == castOther.getExpectedSales()) || (this
						.getExpectedSales() != null
						&& castOther.getExpectedSales() != null && this
						.getExpectedSales()
						.equals(castOther.getExpectedSales())))
				&& ((this.getExpectedTax() == castOther.getExpectedTax()) || (this
						.getExpectedTax() != null
						&& castOther.getExpectedTax() != null && this
						.getExpectedTax().equals(castOther.getExpectedTax())))
				&& ((this.getExpectedProfits() == castOther
						.getExpectedProfits()) || (this.getExpectedProfits() != null
						&& castOther.getExpectedProfits() != null && this
						.getExpectedProfits().equals(
								castOther.getExpectedProfits())))
				&& ((this.getInterestRateThreeYears() == castOther
						.getInterestRateThreeYears()) || (this
						.getInterestRateThreeYears() != null
						&& castOther.getInterestRateThreeYears() != null && this
						.getInterestRateThreeYears().equals(
								castOther.getInterestRateThreeYears())))
				&& ((this.getAverageGrowthThreeYears() == castOther
						.getAverageGrowthThreeYears()) || (this
						.getAverageGrowthThreeYears() != null
						&& castOther.getAverageGrowthThreeYears() != null && this
						.getAverageGrowthThreeYears().equals(
								castOther.getAverageGrowthThreeYears())))
				&& ((this.getCompanyExpectedGrowth() == castOther
						.getCompanyExpectedGrowth()) || (this
						.getCompanyExpectedGrowth() != null
						&& castOther.getCompanyExpectedGrowth() != null && this
						.getCompanyExpectedGrowth().equals(
								castOther.getCompanyExpectedGrowth())))
				&& ((this.getYearBenefit1() == castOther.getYearBenefit1()) || (this
						.getYearBenefit1() != null
						&& castOther.getYearBenefit1() != null && this
						.getYearBenefit1().equals(castOther.getYearBenefit1())))
				&& ((this.getYearBenefit2() == castOther.getYearBenefit2()) || (this
						.getYearBenefit2() != null
						&& castOther.getYearBenefit2() != null && this
						.getYearBenefit2().equals(castOther.getYearBenefit2())))
				&& ((this.getYearBenefit3() == castOther.getYearBenefit3()) || (this
						.getYearBenefit3() != null
						&& castOther.getYearBenefit3() != null && this
						.getYearBenefit3().equals(castOther.getYearBenefit3())))
				&& ((this.getSalesBenefit1() == castOther.getSalesBenefit1()) || (this
						.getSalesBenefit1() != null
						&& castOther.getSalesBenefit1() != null && this
						.getSalesBenefit1()
						.equals(castOther.getSalesBenefit1())))
				&& ((this.getTaxBenefit1() == castOther.getTaxBenefit1()) || (this
						.getTaxBenefit1() != null
						&& castOther.getTaxBenefit1() != null && this
						.getTaxBenefit1().equals(castOther.getTaxBenefit1())))
				&& ((this.getProfitBenefit1() == castOther.getProfitBenefit1()) || (this
						.getProfitBenefit1() != null
						&& castOther.getProfitBenefit1() != null && this
						.getProfitBenefit1().equals(
								castOther.getProfitBenefit1())))
				&& ((this.getSalesBenefit2() == castOther.getSalesBenefit2()) || (this
						.getSalesBenefit2() != null
						&& castOther.getSalesBenefit2() != null && this
						.getSalesBenefit2()
						.equals(castOther.getSalesBenefit2())))
				&& ((this.getTaxBenefit2() == castOther.getTaxBenefit2()) || (this
						.getTaxBenefit2() != null
						&& castOther.getTaxBenefit2() != null && this
						.getTaxBenefit2().equals(castOther.getTaxBenefit2())))
				&& ((this.getProfitBenefit2() == castOther.getProfitBenefit2()) || (this
						.getProfitBenefit2() != null
						&& castOther.getProfitBenefit2() != null && this
						.getProfitBenefit2().equals(
								castOther.getProfitBenefit2())))
				&& ((this.getSalesBenefit3() == castOther.getSalesBenefit3()) || (this
						.getSalesBenefit3() != null
						&& castOther.getSalesBenefit3() != null && this
						.getSalesBenefit3()
						.equals(castOther.getSalesBenefit3())))
				&& ((this.getTaxBenefit3() == castOther.getTaxBenefit3()) || (this
						.getTaxBenefit3() != null
						&& castOther.getTaxBenefit3() != null && this
						.getTaxBenefit3().equals(castOther.getTaxBenefit3())))
				&& ((this.getProfitBenefit3() == castOther.getProfitBenefit3()) || (this
						.getProfitBenefit3() != null
						&& castOther.getProfitBenefit3() != null && this
						.getProfitBenefit3().equals(
								castOther.getProfitBenefit3())))
				&& ((this.getProjectExpectedGrowth() == castOther
						.getProjectExpectedGrowth()) || (this
						.getProjectExpectedGrowth() != null
						&& castOther.getProjectExpectedGrowth() != null && this
						.getProjectExpectedGrowth().equals(
								castOther.getProjectExpectedGrowth())))
				&& ((this.getRdThreeYears() == castOther.getRdThreeYears()) || (this
						.getRdThreeYears() != null
						&& castOther.getRdThreeYears() != null && this
						.getRdThreeYears().equals(castOther.getRdThreeYears())))
				&& ((this.getPatentApplicationsNumber() == castOther
						.getPatentApplicationsNumber()) || (this
						.getPatentApplicationsNumber() != null
						&& castOther.getPatentApplicationsNumber() != null && this
						.getPatentApplicationsNumber().equals(
								castOther.getPatentApplicationsNumber())))
				&& ((this.getPatentsNumber() == castOther.getPatentsNumber()) || (this
						.getPatentsNumber() != null
						&& castOther.getPatentsNumber() != null && this
						.getPatentsNumber()
						.equals(castOther.getPatentsNumber())))
				&& ((this.getInventionNumber() == castOther
						.getInventionNumber()) || (this.getInventionNumber() != null
						&& castOther.getInventionNumber() != null && this
						.getInventionNumber().equals(
								castOther.getInventionNumber())))
				&& ((this.getPatent() == castOther.getPatent()) || (this
						.getPatent() != null
						&& castOther.getPatent() != null && this.getPatent()
						.equals(castOther.getPatent())))
				&& ((this.getInstitutesHighTalent() == castOther
						.getInstitutesHighTalent()) || (this
						.getInstitutesHighTalent() != null
						&& castOther.getInstitutesHighTalent() != null && this
						.getInstitutesHighTalent().equals(
								castOther.getInstitutesHighTalent())))
				&& ((this.getRecommendation() == castOther.getRecommendation()) || (this
						.getRecommendation() != null
						&& castOther.getRecommendation() != null && this
						.getRecommendation().equals(
								castOther.getRecommendation())))
				&& ((this.getAverageInvestmentExperts() == castOther
						.getAverageInvestmentExperts()) || (this
						.getAverageInvestmentExperts() != null
						&& castOther.getAverageInvestmentExperts() != null && this
						.getAverageInvestmentExperts().equals(
								castOther.getAverageInvestmentExperts())))
				&& ((this.getAverageTechnicalExperts() == castOther
						.getAverageTechnicalExperts()) || (this
						.getAverageTechnicalExperts() != null
						&& castOther.getAverageTechnicalExperts() != null && this
						.getAverageTechnicalExperts().equals(
								castOther.getAverageTechnicalExperts())))
				&& ((this.getInvestmentExperts() == castOther
						.getInvestmentExperts()) || (this
						.getInvestmentExperts() != null
						&& castOther.getInvestmentExperts() != null && this
						.getInvestmentExperts().equals(
								castOther.getInvestmentExperts())))
				&& ((this.getTechnicalExperts() == castOther
						.getTechnicalExperts()) || (this.getTechnicalExperts() != null
						&& castOther.getTechnicalExperts() != null && this
						.getTechnicalExperts().equals(
								castOther.getTechnicalExperts())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getProjectId() == null ? 0 : this.getProjectId().hashCode());
		result = 37
				* result
				+ (getProjectName() == null ? 0 : this.getProjectName()
						.hashCode());
		result = 37
				* result
				+ (getApplicationUnit() == null ? 0 : this.getApplicationUnit()
						.hashCode());
		result = 37
				* result
				+ (getReportYear() == null ? 0 : this.getReportYear()
						.hashCode());
		result = 37
				* result
				+ (getCentralizedTypeId() == null ? 0 : this
						.getCentralizedTypeId().hashCode());
		result = 37
				* result
				+ (getCentralizedTypeName() == null ? 0 : this
						.getCentralizedTypeName().hashCode());
		result = 37
				* result
				+ (getTechnicalFisld() == null ? 0 : this.getTechnicalFisld()
						.hashCode());
		result = 37
				* result
				+ (getTechnicalFisldName() == null ? 0 : this
						.getTechnicalFisldName().hashCode());
		result = 37
				* result
				+ (getInvestmentTotal() == null ? 0 : this.getInvestmentTotal()
						.hashCode());
		result = 37 * result
				+ (getTypeId() == null ? 0 : this.getTypeId().hashCode());
		result = 37
				* result
				+ (getTypeShowName() == null ? 0 : this.getTypeShowName()
						.hashCode());
		result = 37
				* result
				+ (getParentTypeId() == null ? 0 : this.getParentTypeId()
						.hashCode());
		result = 37
				* result
				+ (getParentTypeName() == null ? 0 : this.getParentTypeName()
						.hashCode());
		result = 37
				* result
				+ (getDepartmentId() == null ? 0 : this.getDepartmentId()
						.hashCode());
		result = 37
				* result
				+ (getCreateTime() == null ? 0 : this.getCreateTime()
						.hashCode());
		result = 37
				* result
				+ (getYearOperate1() == null ? 0 : this.getYearOperate1()
						.hashCode());
		result = 37
				* result
				+ (getYearOperate2() == null ? 0 : this.getYearOperate2()
						.hashCode());
		result = 37
				* result
				+ (getYearOperate3() == null ? 0 : this.getYearOperate3()
						.hashCode());
		result = 37
				* result
				+ (getSalesOperate1() == null ? 0 : this.getSalesOperate1()
						.hashCode());
		result = 37
				* result
				+ (getTaxOperate1() == null ? 0 : this.getTaxOperate1()
						.hashCode());
		result = 37
				* result
				+ (getProfitOperate1() == null ? 0 : this.getProfitOperate1()
						.hashCode());
		result = 37
				* result
				+ (getInterestRateOperate1() == null ? 0 : this
						.getInterestRateOperate1().hashCode());
		result = 37
				* result
				+ (getRdOperate1() == null ? 0 : this.getRdOperate1()
						.hashCode());
		result = 37
				* result
				+ (getInvestmentOperate1() == null ? 0 : this
						.getInvestmentOperate1().hashCode());
		result = 37
				* result
				+ (getSalesOperate2() == null ? 0 : this.getSalesOperate2()
						.hashCode());
		result = 37
				* result
				+ (getTaxOperate2() == null ? 0 : this.getTaxOperate2()
						.hashCode());
		result = 37
				* result
				+ (getProfitOperate2() == null ? 0 : this.getProfitOperate2()
						.hashCode());
		result = 37
				* result
				+ (getInterestRateOperate2() == null ? 0 : this
						.getInterestRateOperate2().hashCode());
		result = 37
				* result
				+ (getRdOperate2() == null ? 0 : this.getRdOperate2()
						.hashCode());
		result = 37
				* result
				+ (getInvestmentOperate2() == null ? 0 : this
						.getInvestmentOperate2().hashCode());
		result = 37
				* result
				+ (getSalesOperate3() == null ? 0 : this.getSalesOperate3()
						.hashCode());
		result = 37
				* result
				+ (getTaxOperate3() == null ? 0 : this.getTaxOperate3()
						.hashCode());
		result = 37
				* result
				+ (getProfitOperate3() == null ? 0 : this.getProfitOperate3()
						.hashCode());
		result = 37
				* result
				+ (getInterestRateOperate3() == null ? 0 : this
						.getInterestRateOperate3().hashCode());
		result = 37
				* result
				+ (getRdOperate3() == null ? 0 : this.getRdOperate3()
						.hashCode());
		result = 37
				* result
				+ (getInvestmentOperate3() == null ? 0 : this
						.getInvestmentOperate3().hashCode());
		result = 37
				* result
				+ (getExpectedSales() == null ? 0 : this.getExpectedSales()
						.hashCode());
		result = 37
				* result
				+ (getExpectedTax() == null ? 0 : this.getExpectedTax()
						.hashCode());
		result = 37
				* result
				+ (getExpectedProfits() == null ? 0 : this.getExpectedProfits()
						.hashCode());
		result = 37
				* result
				+ (getInterestRateThreeYears() == null ? 0 : this
						.getInterestRateThreeYears().hashCode());
		result = 37
				* result
				+ (getAverageGrowthThreeYears() == null ? 0 : this
						.getAverageGrowthThreeYears().hashCode());
		result = 37
				* result
				+ (getCompanyExpectedGrowth() == null ? 0 : this
						.getCompanyExpectedGrowth().hashCode());
		result = 37
				* result
				+ (getYearBenefit1() == null ? 0 : this.getYearBenefit1()
						.hashCode());
		result = 37
				* result
				+ (getYearBenefit2() == null ? 0 : this.getYearBenefit2()
						.hashCode());
		result = 37
				* result
				+ (getYearBenefit3() == null ? 0 : this.getYearBenefit3()
						.hashCode());
		result = 37
				* result
				+ (getSalesBenefit1() == null ? 0 : this.getSalesBenefit1()
						.hashCode());
		result = 37
				* result
				+ (getTaxBenefit1() == null ? 0 : this.getTaxBenefit1()
						.hashCode());
		result = 37
				* result
				+ (getProfitBenefit1() == null ? 0 : this.getProfitBenefit1()
						.hashCode());
		result = 37
				* result
				+ (getSalesBenefit2() == null ? 0 : this.getSalesBenefit2()
						.hashCode());
		result = 37
				* result
				+ (getTaxBenefit2() == null ? 0 : this.getTaxBenefit2()
						.hashCode());
		result = 37
				* result
				+ (getProfitBenefit2() == null ? 0 : this.getProfitBenefit2()
						.hashCode());
		result = 37
				* result
				+ (getSalesBenefit3() == null ? 0 : this.getSalesBenefit3()
						.hashCode());
		result = 37
				* result
				+ (getTaxBenefit3() == null ? 0 : this.getTaxBenefit3()
						.hashCode());
		result = 37
				* result
				+ (getProfitBenefit3() == null ? 0 : this.getProfitBenefit3()
						.hashCode());
		result = 37
				* result
				+ (getProjectExpectedGrowth() == null ? 0 : this
						.getProjectExpectedGrowth().hashCode());
		result = 37
				* result
				+ (getRdThreeYears() == null ? 0 : this.getRdThreeYears()
						.hashCode());
		result = 37
				* result
				+ (getPatentApplicationsNumber() == null ? 0 : this
						.getPatentApplicationsNumber().hashCode());
		result = 37
				* result
				+ (getPatentsNumber() == null ? 0 : this.getPatentsNumber()
						.hashCode());
		result = 37
				* result
				+ (getInventionNumber() == null ? 0 : this.getInventionNumber()
						.hashCode());
		result = 37 * result
				+ (getPatent() == null ? 0 : this.getPatent().hashCode());
		result = 37
				* result
				+ (getInstitutesHighTalent() == null ? 0 : this
						.getInstitutesHighTalent().hashCode());
		result = 37
				* result
				+ (getRecommendation() == null ? 0 : this.getRecommendation()
						.hashCode());
		result = 37
				* result
				+ (getAverageInvestmentExperts() == null ? 0 : this
						.getAverageInvestmentExperts().hashCode());
		result = 37
				* result
				+ (getAverageTechnicalExperts() == null ? 0 : this
						.getAverageTechnicalExperts().hashCode());
		result = 37
				* result
				+ (getInvestmentExperts() == null ? 0 : this
						.getInvestmentExperts().hashCode());
		result = 37
				* result
				+ (getTechnicalExperts() == null ? 0 : this
						.getTechnicalExperts().hashCode());
		return result;
	}
*/

}
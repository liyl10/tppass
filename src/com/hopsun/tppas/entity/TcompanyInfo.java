package com.hopsun.tppas.entity;

import java.sql.Timestamp;

import com.hopsun.tppas.entity.TprojectApplication;
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
 * TcompanyInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_COMPANY_INFO")
public class TcompanyInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1425100351397443755L;
	
	// Fields
	private String companyInfoId;
	private TprojectApplication tprojectApplication;
	private Integer yearOperate1;
	private Integer yearOperate2;
	private Integer yearOperate3;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String remark;
	private double salesOperate1;
	private double salesOperate2;
	private double salesOperate3;
	private double profitOperate1;
	private double profitOperate2;
	private double profitOperate3;
	private double taxOperate1;
	private double taxOperate2;
	private double taxOperate3;
	private String interestRateOperate1;
	private String interestRateOperate2;
	private String interestRateOperate3;
	private double rdOperate1;
	private double rdOperate2;
	private double rdOperate3;
	private double expectedSales;
	private double expectedTax;
	private double expectedProfits;
	private String interestRateThreeYears;
	private String averageGrowthThreeYears;
	private String companyExpectedGrowth;
	private Integer yearBenefit1;
	private Integer yearBenefit2;
	private Integer yearBenefit3;
	private double salesBenefit1;
	private double salesBenefit2;
	private double salesBenefit3;
	private double profitBenefit1;
	private double profitBenefit2;
	private double profitBenefit3;
	private double taxBenefit1;
	private double taxBenefit2;
	private double taxBenefit3;
	private String projectExpectedGrowth;
	private String rdThreeYears;
	private Integer patentApplicationsNumber;
	private Integer patentsNumber;
	private Integer inventionNumber;
	private Integer inventionNumber1;
	private String institutesHighTalent;
	private String recommendation;
	private String averageInvestmentExperts;
	private String averageTechnicalExperts;
	private String investmentExperts;
	private String technicalExperts;
	private double investmentOperate1;
	private double investmentOperate2;
	private double investmentOperate3;
	// Constructors

	/** default constructor */
	public TcompanyInfo() {
	}

	/** full constructor */
	public TcompanyInfo(TprojectApplication tprojectApplication,
			Integer yearOperate1, Integer yearOperate2, Integer yearOperate3,
			String deleteFlag, Timestamp createTime, String createUser,
			Timestamp updateTime, String updateUser, String remark,
			double salesOperate1, double salesOperate2, double salesOperate3,
			double profitOperate1, double profitOperate2,
			double profitOperate3, double taxOperate1, double taxOperate2,
			double taxOperate3, String interestRateOperate1,
			String interestRateOperate2, String interestRateOperate3,
			double rdOperate1, double rdOperate2, double rdOperate3,
			double expectedSales, double expectedTax, double expectedProfits,
			String interestRateThreeYears, String averageGrowthThreeYears,
			String companyExpectedGrowth, Integer yearBenefit1,
			Integer yearBenefit2, Integer yearBenefit3, double salesBenefit1,
			double salesBenefit2, double salesBenefit3, double profitBenefit1,
			double profitBenefit2, double profitBenefit3, double taxBenefit1,
			double taxBenefit2, double taxBenefit3,
			String projectExpectedGrowth, String rdThreeYears,
			Integer patentApplicationsNumber, Integer patentsNumber,
			Integer inventionNumber,Integer inventionNumber1, String institutesHighTalent,
			String recommendation, String averageInvestmentExperts,
			String averageTechnicalExperts, String investmentExperts,
			String technicalExperts,double investmentOperate1,
			double investmentOperate2,double investmentOperate3) {
		this.tprojectApplication = tprojectApplication;
		this.yearOperate1 = yearOperate1;
		this.yearOperate2 = yearOperate2;
		this.yearOperate3 = yearOperate3;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.remark = remark;
		this.salesOperate1 = salesOperate1;
		this.salesOperate2 = salesOperate2;
		this.salesOperate3 = salesOperate3;
		this.profitOperate1 = profitOperate1;
		this.profitOperate2 = profitOperate2;
		this.profitOperate3 = profitOperate3;
		this.taxOperate1 = taxOperate1;
		this.taxOperate2 = taxOperate2;
		this.taxOperate3 = taxOperate3;
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
		this.yearBenefit1 = yearBenefit1;
		this.yearBenefit2 = yearBenefit2;
		this.yearBenefit3 = yearBenefit3;
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
		this.patentsNumber = patentsNumber;
		this.inventionNumber = inventionNumber;
		this.inventionNumber1 = inventionNumber1;
		this.institutesHighTalent = institutesHighTalent;
		this.recommendation = recommendation;
		this.averageInvestmentExperts = averageInvestmentExperts;
		this.averageTechnicalExperts = averageTechnicalExperts;
		this.investmentExperts = investmentExperts;
		this.technicalExperts = technicalExperts;
		this.investmentOperate1 = investmentOperate1;
		this.investmentOperate2 = investmentOperate2;
		this.investmentOperate3 = investmentOperate3;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "COMPANY_INFO_ID", unique = true, nullable = false, length = 40)
	public String getCompanyInfoId() {
		return this.companyInfoId;
	}

	public void setCompanyInfoId(String companyInfoId) {
		this.companyInfoId = companyInfoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "YEAR_OPERATE_1",  length = 4)
	public Integer getYearOperate1() {
		return this.yearOperate1;
	}

	public void setYearOperate1(Integer yearOperate1) {
		this.yearOperate1 = yearOperate1;
	}

	@Column(name = "YEAR_OPERATE_2",  length = 4)
	public Integer getYearOperate2() {
		return this.yearOperate2;
	}

	public void setYearOperate2(Integer yearOperate2) {
		this.yearOperate2 = yearOperate2;
	}

	@Column(name = "YEAR_OPERATE_3",  length = 4)
	public Integer getYearOperate3() {
		return this.yearOperate3;
	}

	public void setYearOperate3(Integer yearOperate3) {
		this.yearOperate3 = yearOperate3;
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

	@Column(name = "SALES_OPERATE_1", precision = 11, scale = 4)
	public double getSalesOperate1() {
		return this.salesOperate1;
	}

	public void setSalesOperate1(double salesOperate1) {
		this.salesOperate1 = salesOperate1;
	}

	@Column(name = "SALES_OPERATE_2", precision = 11, scale = 4)
	public double getSalesOperate2() {
		return this.salesOperate2;
	}

	public void setSalesOperate2(double salesOperate2) {
		this.salesOperate2 = salesOperate2;
	}

	@Column(name = "SALES_OPERATE_3", precision = 11, scale = 4)
	public double getSalesOperate3() {
		return this.salesOperate3;
	}

	public void setSalesOperate3(double salesOperate3) {
		this.salesOperate3 = salesOperate3;
	}

	@Column(name = "PROFIT_OPERATE_1", precision = 11, scale = 4)
	public double getProfitOperate1() {
		return this.profitOperate1;
	}

	public void setProfitOperate1(double profitOperate1) {
		this.profitOperate1 = profitOperate1;
	}

	@Column(name = "PROFIT_OPERATE_2", precision = 11, scale = 4)
	public double getProfitOperate2() {
		return this.profitOperate2;
	}

	public void setProfitOperate2(double profitOperate2) {
		this.profitOperate2 = profitOperate2;
	}

	@Column(name = "PROFIT_OPERATE_3", precision = 11, scale = 4)
	public double getProfitOperate3() {
		return this.profitOperate3;
	}

	public void setProfitOperate3(double profitOperate3) {
		this.profitOperate3 = profitOperate3;
	}

	@Column(name = "TAX_OPERATE_1", precision = 11, scale = 4)
	public double getTaxOperate1() {
		return this.taxOperate1;
	}

	public void setTaxOperate1(double taxOperate1) {
		this.taxOperate1 = taxOperate1;
	}

	@Column(name = "TAX_OPERATE_2", precision = 11, scale = 4)
	public double getTaxOperate2() {
		return this.taxOperate2;
	}

	public void setTaxOperate2(double taxOperate2) {
		this.taxOperate2 = taxOperate2;
	}

	@Column(name = "TAX_OPERATE_3", precision = 11, scale = 4)
	public double getTaxOperate3() {
		return this.taxOperate3;
	}

	public void setTaxOperate3(double taxOperate3) {
		this.taxOperate3 = taxOperate3;
	}

	@Column(name = "INTEREST_RATE_OPERATE_1", length = 10)
	public String getInterestRateOperate1() {
		return this.interestRateOperate1;
	}

	public void setInterestRateOperate1(String interestRateOperate1) {
		this.interestRateOperate1 = interestRateOperate1;
	}

	@Column(name = "INTEREST_RATE_OPERATE_2", length = 10)
	public String getInterestRateOperate2() {
		return this.interestRateOperate2;
	}

	public void setInterestRateOperate2(String interestRateOperate2) {
		this.interestRateOperate2 = interestRateOperate2;
	}

	@Column(name = "INTEREST_RATE_OPERATE_3", length = 10)
	public String getInterestRateOperate3() {
		return this.interestRateOperate3;
	}

	public void setInterestRateOperate3(String interestRateOperate3) {
		this.interestRateOperate3 = interestRateOperate3;
	}

	@Column(name = "RD_OPERATE_1", precision = 11, scale = 4)
	public double getRdOperate1() {
		return this.rdOperate1;
	}

	public void setRdOperate1(double rdOperate1) {
		this.rdOperate1 = rdOperate1;
	}

	@Column(name = "RD_OPERATE_2", precision = 11, scale = 4)
	public double getRdOperate2() {
		return this.rdOperate2;
	}

	public void setRdOperate2(double rdOperate2) {
		this.rdOperate2 = rdOperate2;
	}

	@Column(name = "RD_OPERATE_3", precision = 11, scale = 4)
	public double getRdOperate3() {
		return this.rdOperate3;
	}

	public void setRdOperate3(double rdOperate3) {
		this.rdOperate3 = rdOperate3;
	}

	@Column(name = "EXPECTED_SALES", precision = 11, scale = 4)
	public double getExpectedSales() {
		return this.expectedSales;
	}

	public void setExpectedSales(double expectedSales) {
		this.expectedSales = expectedSales;
	}

	@Column(name = "EXPECTED_TAX", precision = 11, scale = 4)
	public double getExpectedTax() {
		return this.expectedTax;
	}

	public void setExpectedTax(double expectedTax) {
		this.expectedTax = expectedTax;
	}

	@Column(name = "EXPECTED_PROFITS", precision = 11, scale = 4)
	public double getExpectedProfits() {
		return this.expectedProfits;
	}

	public void setExpectedProfits(double expectedProfits) {
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

	@Column(name = "YEAR_BENEFIT_1",  length = 4)
	public Integer getYearBenefit1() {
		return this.yearBenefit1;
	}

	public void setYearBenefit1(Integer yearBenefit1) {
		this.yearBenefit1 = yearBenefit1;
	}

	@Column(name = "YEAR_BENEFIT_2",  length = 4)
	public Integer getYearBenefit2() {
		return this.yearBenefit2;
	}

	public void setYearBenefit2(Integer yearBenefit2) {
		this.yearBenefit2 = yearBenefit2;
	}

	@Column(name = "YEAR_BENEFIT_3",  length = 4)
	public Integer getYearBenefit3() {
		return this.yearBenefit3;
	}

	public void setYearBenefit3(Integer yearBenefit3) {
		this.yearBenefit3 = yearBenefit3;
	}

	@Column(name = "SALES_BENEFIT_1", precision = 11, scale = 4)
	public double getSalesBenefit1() {
		return this.salesBenefit1;
	}

	public void setSalesBenefit1(double salesBenefit1) {
		this.salesBenefit1 = salesBenefit1;
	}

	@Column(name = "SALES_BENEFIT_2", precision = 11, scale = 4)
	public double getSalesBenefit2() {
		return this.salesBenefit2;
	}

	public void setSalesBenefit2(double salesBenefit2) {
		this.salesBenefit2 = salesBenefit2;
	}

	@Column(name = "SALES_BENEFIT_3", precision = 11, scale = 4)
	public double getSalesBenefit3() {
		return this.salesBenefit3;
	}

	public void setSalesBenefit3(double salesBenefit3) {
		this.salesBenefit3 = salesBenefit3;
	}

	@Column(name = "PROFIT_BENEFIT_1", precision = 11, scale = 4)
	public double getProfitBenefit1() {
		return this.profitBenefit1;
	}

	public void setProfitBenefit1(double profitBenefit1) {
		this.profitBenefit1 = profitBenefit1;
	}

	@Column(name = "PROFIT_BENEFIT_2", precision = 11, scale = 4)
	public double getProfitBenefit2() {
		return this.profitBenefit2;
	}

	public void setProfitBenefit2(double profitBenefit2) {
		this.profitBenefit2 = profitBenefit2;
	}

	@Column(name = "PROFIT_BENEFIT_3", precision = 11, scale = 4)
	public double getProfitBenefit3() {
		return this.profitBenefit3;
	}

	public void setProfitBenefit3(double profitBenefit3) {
		this.profitBenefit3 = profitBenefit3;
	}

	@Column(name = "TAX_BENEFIT_1", precision = 11, scale = 4)
	public double getTaxBenefit1() {
		return this.taxBenefit1;
	}

	public void setTaxBenefit1(double taxBenefit1) {
		this.taxBenefit1 = taxBenefit1;
	}

	@Column(name = "TAX_BENEFIT_2", precision = 11, scale = 4)
	public double getTaxBenefit2() {
		return this.taxBenefit2;
	}

	public void setTaxBenefit2(double taxBenefit2) {
		this.taxBenefit2 = taxBenefit2;
	}

	@Column(name = "TAX_BENEFIT_3", precision = 11, scale = 4)
	public double getTaxBenefit3() {
		return this.taxBenefit3;
	}

	public void setTaxBenefit3(double taxBenefit3) {
		this.taxBenefit3 = taxBenefit3;
	}

	@Column(name = "PROJECT_EXPECTED_GROWTH", length = 10)
	public String getProjectExpectedGrowth() {
		return this.projectExpectedGrowth;
	}

	public void setProjectExpectedGrowth(String projectExpectedGrowth) {
		this.projectExpectedGrowth = projectExpectedGrowth;
	}

	@Column(name = "RD_THREE_YEARS", length = 20)
	public String getRdThreeYears() {
		return this.rdThreeYears;
	}

	public void setRdThreeYears(String rdThreeYears) {
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
	
	@Column(name = "INVENTION_NUMBER1", precision = 7, scale = 0)
	public Integer getInventionNumber1() {
		return this.inventionNumber1;
	}

	public void setInventionNumber1(Integer inventionNumber1) {
		this.inventionNumber1 = inventionNumber1;
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

	@Column(name = "INVESTMENT_OPERATE_1", precision = 11, scale = 4)
	public double getInvestmentOperate1() {
		return investmentOperate1;
	}

	public void setInvestmentOperate1(double investmentOperate1) {
		this.investmentOperate1 = investmentOperate1;
	}

	@Column(name = "INVESTMENT_OPERATE_2", precision = 11, scale = 4)
	public double getInvestmentOperate2() {
		return investmentOperate2;
	}

	public void setInvestmentOperate2(double investmentOperate2) {
		this.investmentOperate2 = investmentOperate2;
	}

	@Column(name = "INVESTMENT_OPERATE_3", precision = 11, scale = 4)
	public double getInvestmentOperate3() {
		return investmentOperate3;
	}

	public void setInvestmentOperate3(double investmentOperate3) {
		this.investmentOperate3 = investmentOperate3;
	}

}
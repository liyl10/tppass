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
 * TacceptanceAchievementB entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ACCEPTANCE_ACHIEVEMENT_B")
public class TacceptanceAchievementB implements java.io.Serializable {

	private static final long serialVersionUID = -945855746469028457L;
	// Fields

	private String achievementId;
	private Tacceptance tacceptance;
	private Integer receivePatentNum;
	private Integer receiveUtilityNum;
	private Integer receiveDesignsNum;
	private Integer receiveCopyrightNum;
	private Integer receiveForeignNum;
	private Integer applyPatentNum;
	private Integer applyUtilityNum;
	private Integer applyDesignsNum;
	private Integer applyCopyrightNum;
	private Integer applyForeignNum;
	private String otherOutcomes;
	private String fundsYear1;
	private String fundsYear2;
	private String fundsPlanname1;
	private String fundsPlanname2;
	private double fundsAmount1;
	private double fundsAmount2;
	private String companyYear1;
	private String companyYear2;
	private String companyFinanciers1;
	private String companyFinanciers2;
	private double companyAmount1;
	private double companyAmount2;
	private double projectNet;
	private double projectBusinessNet;
	private double projectTotal;
	private double projectExport;
	private double projectSales;
	private double projectMainIncome;
	private double projectTaxableTotal;
	private double projectActualTaxTotal;
	private double projectRdInvestment;
	private double acceptanceTotal;
	private double acceptanceNet;
	private double acceptanceExport;
	private double acceptanceBusinessNet;
	private double acceptanceSales;
	private double acceptanceMainIncome;
	private double acceptanceTaxableTotal;
	private double acceptanceActualTaxTotal;
	private double acceptanceRdInvestment;
	private String createUser;
	private Timestamp createTime;
	private String updateUser;
	private Timestamp updateTime;
	private String deleteFlag;

	// Constructors

	/** default constructor */
	public TacceptanceAchievementB() {
	}

	/** full constructor */
	public TacceptanceAchievementB(Tacceptance tacceptance,
			Integer receivePatentNum, Integer receiveUtilityNum,
			Integer receiveDesignsNum, Integer receiveCopyrightNum,
			Integer receiveForeignNum, Integer applyPatentNum,
			Integer applyUtilityNum, Integer applyDesignsNum,
			Integer applyCopyrightNum, Integer applyForeignNum,
			String otherOutcomes, String fundsYear1, String fundsYear2,
			String fundsPlanname1, String fundsPlanname2, double fundsAmount1,
			double fundsAmount2, String companyYear1, String companyYear2,
			String companyFinanciers1, String companyFinanciers2,
			double companyAmount1, double companyAmount2, double projectNet,
			double projectBusinessNet, double projectTotal,
			double projectExport, double projectSales,
			double projectMainIncome, double projectTaxableTotal,
			double projectActualTaxTotal, double projectRdInvestment,
			double acceptanceTotal, double acceptanceNet,
			double acceptanceExport, double acceptanceBusinessNet,
			double acceptanceSales, double acceptanceMainIncome,
			double acceptanceTaxableTotal, double acceptanceActualTaxTotal,
			double acceptanceRdInvestment, String createUser,
			Timestamp createTime, String updateUser, Timestamp updateTime,
			String deleteFlag) {
		this.tacceptance = tacceptance;
		this.receivePatentNum = receivePatentNum;
		this.receiveUtilityNum = receiveUtilityNum;
		this.receiveDesignsNum = receiveDesignsNum;
		this.receiveCopyrightNum = receiveCopyrightNum;
		this.receiveForeignNum = receiveForeignNum;
		this.applyPatentNum = applyPatentNum;
		this.applyUtilityNum = applyUtilityNum;
		this.applyDesignsNum = applyDesignsNum;
		this.applyCopyrightNum = applyCopyrightNum;
		this.applyForeignNum = applyForeignNum;
		this.otherOutcomes = otherOutcomes;
		this.fundsYear1 = fundsYear1;
		this.fundsYear2 = fundsYear2;
		this.fundsPlanname1 = fundsPlanname1;
		this.fundsPlanname2 = fundsPlanname2;
		this.fundsAmount1 = fundsAmount1;
		this.fundsAmount2 = fundsAmount2;
		this.companyYear1 = companyYear1;
		this.companyYear2 = companyYear2;
		this.companyFinanciers1 = companyFinanciers1;
		this.companyFinanciers2 = companyFinanciers2;
		this.companyAmount1 = companyAmount1;
		this.companyAmount2 = companyAmount2;
		this.projectNet = projectNet;
		this.projectBusinessNet = projectBusinessNet;
		this.projectTotal = projectTotal;
		this.projectExport = projectExport;
		this.projectSales = projectSales;
		this.projectMainIncome = projectMainIncome;
		this.projectTaxableTotal = projectTaxableTotal;
		this.projectActualTaxTotal = projectActualTaxTotal;
		this.projectRdInvestment = projectRdInvestment;
		this.acceptanceTotal = acceptanceTotal;
		this.acceptanceNet = acceptanceNet;
		this.acceptanceExport = acceptanceExport;
		this.acceptanceBusinessNet = acceptanceBusinessNet;
		this.acceptanceSales = acceptanceSales;
		this.acceptanceMainIncome = acceptanceMainIncome;
		this.acceptanceTaxableTotal = acceptanceTaxableTotal;
		this.acceptanceActualTaxTotal = acceptanceActualTaxTotal;
		this.acceptanceRdInvestment = acceptanceRdInvestment;
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
	@Column(name = "ACHIEVEMENT_ID", unique = true, nullable = false, length = 40)
	public String getAchievementId() {
		return this.achievementId;
	}

	public void setAchievementId(String achievementId) {
		this.achievementId = achievementId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCEPTANCE_ID")
	public Tacceptance getTacceptance() {
		return this.tacceptance;
	}

	public void setTacceptance(Tacceptance tacceptance) {
		this.tacceptance = tacceptance;
	}

	@Column(name = "RECEIVE_PATENT_NUM", precision = 7, scale = 0)
	public Integer getReceivePatentNum() {
		return this.receivePatentNum;
	}

	public void setReceivePatentNum(Integer receivePatentNum) {
		this.receivePatentNum = receivePatentNum;
	}

	@Column(name = "RECEIVE_UTILITY_NUM", precision = 7, scale = 0)
	public Integer getReceiveUtilityNum() {
		return this.receiveUtilityNum;
	}

	public void setReceiveUtilityNum(Integer receiveUtilityNum) {
		this.receiveUtilityNum = receiveUtilityNum;
	}

	@Column(name = "RECEIVE_DESIGNS_NUM", precision = 7, scale = 0)
	public Integer getReceiveDesignsNum() {
		return this.receiveDesignsNum;
	}

	public void setReceiveDesignsNum(Integer receiveDesignsNum) {
		this.receiveDesignsNum = receiveDesignsNum;
	}

	@Column(name = "RECEIVE_COPYRIGHT_NUM", precision = 7, scale = 0)
	public Integer getReceiveCopyrightNum() {
		return this.receiveCopyrightNum;
	}

	public void setReceiveCopyrightNum(Integer receiveCopyrightNum) {
		this.receiveCopyrightNum = receiveCopyrightNum;
	}

	@Column(name = "RECEIVE_FOREIGN_NUM", precision = 7, scale = 0)
	public Integer getReceiveForeignNum() {
		return this.receiveForeignNum;
	}

	public void setReceiveForeignNum(Integer receiveForeignNum) {
		this.receiveForeignNum = receiveForeignNum;
	}

	@Column(name = "APPLY_PATENT_NUM", precision = 7, scale = 0)
	public Integer getApplyPatentNum() {
		return this.applyPatentNum;
	}

	public void setApplyPatentNum(Integer applyPatentNum) {
		this.applyPatentNum = applyPatentNum;
	}

	@Column(name = "APPLY_UTILITY_NUM", precision = 7, scale = 0)
	public Integer getApplyUtilityNum() {
		return this.applyUtilityNum;
	}

	public void setApplyUtilityNum(Integer applyUtilityNum) {
		this.applyUtilityNum = applyUtilityNum;
	}

	@Column(name = "APPLY_DESIGNS_NUM", precision = 7, scale = 0)
	public Integer getApplyDesignsNum() {
		return this.applyDesignsNum;
	}

	public void setApplyDesignsNum(Integer applyDesignsNum) {
		this.applyDesignsNum = applyDesignsNum;
	}

	@Column(name = "APPLY_COPYRIGHT_NUM", precision = 7, scale = 0)
	public Integer getApplyCopyrightNum() {
		return this.applyCopyrightNum;
	}

	public void setApplyCopyrightNum(Integer applyCopyrightNum) {
		this.applyCopyrightNum = applyCopyrightNum;
	}

	@Column(name = "APPLY_FOREIGN_NUM", precision = 7, scale = 0)
	public Integer getApplyForeignNum() {
		return this.applyForeignNum;
	}

	public void setApplyForeignNum(Integer applyForeignNum) {
		this.applyForeignNum = applyForeignNum;
	}

	@Column(name = "OTHER_OUTCOMES", length = 4000)
	public String getOtherOutcomes() {
		return this.otherOutcomes;
	}

	public void setOtherOutcomes(String otherOutcomes) {
		this.otherOutcomes = otherOutcomes;
	}

	@Column(name = "FUNDS_YEAR_1", length = 10)
	public String getFundsYear1() {
		return this.fundsYear1;
	}

	public void setFundsYear1(String fundsYear1) {
		this.fundsYear1 = fundsYear1;
	}

	@Column(name = "FUNDS_YEAR_2", length = 10)
	public String getFundsYear2() {
		return this.fundsYear2;
	}

	public void setFundsYear2(String fundsYear2) {
		this.fundsYear2 = fundsYear2;
	}

	@Column(name = "FUNDS_PLANNAME_1", length = 100)
	public String getFundsPlanname1() {
		return this.fundsPlanname1;
	}

	public void setFundsPlanname1(String fundsPlanname1) {
		this.fundsPlanname1 = fundsPlanname1;
	}

	@Column(name = "FUNDS_PLANNAME_2", length = 100)
	public String getFundsPlanname2() {
		return this.fundsPlanname2;
	}

	public void setFundsPlanname2(String fundsPlanname2) {
		this.fundsPlanname2 = fundsPlanname2;
	}

	@Column(name = "FUNDS_AMOUNT_1", precision = 11, scale = 4)
	public double getFundsAmount1() {
		return this.fundsAmount1;
	}

	public void setFundsAmount1(double fundsAmount1) {
		this.fundsAmount1 = fundsAmount1;
	}

	@Column(name = "FUNDS_AMOUNT_2", precision = 11, scale = 4)
	public double getFundsAmount2() {
		return this.fundsAmount2;
	}

	public void setFundsAmount2(double fundsAmount2) {
		this.fundsAmount2 = fundsAmount2;
	}

	@Column(name = "COMPANY_YEAR_1", length = 10)
	public String getCompanyYear1() {
		return this.companyYear1;
	}

	public void setCompanyYear1(String companyYear1) {
		this.companyYear1 = companyYear1;
	}

	@Column(name = "COMPANY_YEAR_2", length = 10)
	public String getCompanyYear2() {
		return this.companyYear2;
	}

	public void setCompanyYear2(String companyYear2) {
		this.companyYear2 = companyYear2;
	}

	@Column(name = "COMPANY_FINANCIERS_1", length = 100)
	public String getCompanyFinanciers1() {
		return this.companyFinanciers1;
	}

	public void setCompanyFinanciers1(String companyFinanciers1) {
		this.companyFinanciers1 = companyFinanciers1;
	}

	@Column(name = "COMPANY_FINANCIERS_2", length = 100)
	public String getCompanyFinanciers2() {
		return this.companyFinanciers2;
	}

	public void setCompanyFinanciers2(String companyFinanciers2) {
		this.companyFinanciers2 = companyFinanciers2;
	}

	@Column(name = "COMPANY_AMOUNT_1", precision = 11, scale = 4)
	public double getCompanyAmount1() {
		return this.companyAmount1;
	}

	public void setCompanyAmount1(double companyAmount1) {
		this.companyAmount1 = companyAmount1;
	}

	@Column(name = "COMPANY_AMOUNT_2", precision = 11, scale = 4)
	public double getCompanyAmount2() {
		return this.companyAmount2;
	}

	public void setCompanyAmount2(double companyAmount2) {
		this.companyAmount2 = companyAmount2;
	}

	@Column(name = "PROJECT_NET", precision = 11, scale = 4)
	public double getProjectNet() {
		return this.projectNet;
	}

	public void setProjectNet(double projectNet) {
		this.projectNet = projectNet;
	}

	@Column(name = "PROJECT_BUSINESS_NET", precision = 11, scale = 4)
	public double getProjectBusinessNet() {
		return this.projectBusinessNet;
	}

	public void setProjectBusinessNet(double projectBusinessNet) {
		this.projectBusinessNet = projectBusinessNet;
	}

	@Column(name = "PROJECT_TOTAL", precision = 11, scale = 4)
	public double getProjectTotal() {
		return this.projectTotal;
	}

	public void setProjectTotal(double projectTotal) {
		this.projectTotal = projectTotal;
	}

	@Column(name = "PROJECT_EXPORT", precision = 11, scale = 4)
	public double getProjectExport() {
		return this.projectExport;
	}

	public void setProjectExport(double projectExport) {
		this.projectExport = projectExport;
	}

	@Column(name = "PROJECT_SALES", precision = 11, scale = 4)
	public double getProjectSales() {
		return this.projectSales;
	}

	public void setProjectSales(double projectSales) {
		this.projectSales = projectSales;
	}

	@Column(name = "PROJECT_MAIN_INCOME", precision = 11, scale = 4)
	public double getProjectMainIncome() {
		return this.projectMainIncome;
	}

	public void setProjectMainIncome(double projectMainIncome) {
		this.projectMainIncome = projectMainIncome;
	}

	@Column(name = "PROJECT_TAXABLE_TOTAL", precision = 11, scale = 4)
	public double getProjectTaxableTotal() {
		return this.projectTaxableTotal;
	}

	public void setProjectTaxableTotal(double projectTaxableTotal) {
		this.projectTaxableTotal = projectTaxableTotal;
	}

	@Column(name = "PROJECT_ACTUAL_TAX_TOTAL", precision = 11, scale = 4)
	public double getProjectActualTaxTotal() {
		return this.projectActualTaxTotal;
	}

	public void setProjectActualTaxTotal(double projectActualTaxTotal) {
		this.projectActualTaxTotal = projectActualTaxTotal;
	}

	@Column(name = "PROJECT_RD_INVESTMENT", precision = 11, scale = 4)
	public double getProjectRdInvestment() {
		return this.projectRdInvestment;
	}

	public void setProjectRdInvestment(double projectRdInvestment) {
		this.projectRdInvestment = projectRdInvestment;
	}

	@Column(name = "ACCEPTANCE_TOTAL", precision = 11, scale = 4)
	public double getAcceptanceTotal() {
		return this.acceptanceTotal;
	}

	public void setAcceptanceTotal(double acceptanceTotal) {
		this.acceptanceTotal = acceptanceTotal;
	}

	@Column(name = "ACCEPTANCE_NET", precision = 11, scale = 4)
	public double getAcceptanceNet() {
		return this.acceptanceNet;
	}

	public void setAcceptanceNet(double acceptanceNet) {
		this.acceptanceNet = acceptanceNet;
	}

	@Column(name = "ACCEPTANCE_EXPORT", precision = 11, scale = 4)
	public double getAcceptanceExport() {
		return this.acceptanceExport;
	}

	public void setAcceptanceExport(double acceptanceExport) {
		this.acceptanceExport = acceptanceExport;
	}

	@Column(name = "ACCEPTANCE_BUSINESS_NET", precision = 11, scale = 4)
	public double getAcceptanceBusinessNet() {
		return this.acceptanceBusinessNet;
	}

	public void setAcceptanceBusinessNet(double acceptanceBusinessNet) {
		this.acceptanceBusinessNet = acceptanceBusinessNet;
	}

	@Column(name = "ACCEPTANCE_SALES", precision = 11, scale = 4)
	public double getAcceptanceSales() {
		return this.acceptanceSales;
	}

	public void setAcceptanceSales(double acceptanceSales) {
		this.acceptanceSales = acceptanceSales;
	}

	@Column(name = "ACCEPTANCE_MAIN_INCOME", precision = 11, scale = 4)
	public double getAcceptanceMainIncome() {
		return this.acceptanceMainIncome;
	}

	public void setAcceptanceMainIncome(double acceptanceMainIncome) {
		this.acceptanceMainIncome = acceptanceMainIncome;
	}

	@Column(name = "ACCEPTANCE_TAXABLE_TOTAL", precision = 11, scale = 4)
	public double getAcceptanceTaxableTotal() {
		return this.acceptanceTaxableTotal;
	}

	public void setAcceptanceTaxableTotal(double acceptanceTaxableTotal) {
		this.acceptanceTaxableTotal = acceptanceTaxableTotal;
	}

	@Column(name = "ACCEPTANCE_ACTUAL_TAX_TOTAL", precision = 11, scale = 4)
	public double getAcceptanceActualTaxTotal() {
		return this.acceptanceActualTaxTotal;
	}

	public void setAcceptanceActualTaxTotal(double acceptanceActualTaxTotal) {
		this.acceptanceActualTaxTotal = acceptanceActualTaxTotal;
	}

	@Column(name = "ACCEPTANCE_RD_INVESTMENT", precision = 11, scale = 4)
	public double getAcceptanceRdInvestment() {
		return this.acceptanceRdInvestment;
	}

	public void setAcceptanceRdInvestment(double acceptanceRdInvestment) {
		this.acceptanceRdInvestment = acceptanceRdInvestment;
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
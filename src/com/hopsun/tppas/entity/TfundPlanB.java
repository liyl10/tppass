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
 * TfundPlanB entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_FUND_PLAN_B")
public class TfundPlanB implements java.io.Serializable {

	private static final long serialVersionUID = -5075265224937052935L;
	// Fields

	private String fundPlanBId;
	private TprojectApplication tprojectApplication;
	private String year1;
	private String year2;
	private String year3;
	private double totalInvestment1;
	private double totalInvestment2;
	private double totalInvestment3;
	private double partyFunding1;
	private double partyFunding2;
	private double partyFunding3;
	private double unitRaised1;
	private double unitRaised2;
	private double unitRaised3;
	private double otherFunds1;
	private double otherFunds2;
	private double otherFunds3;
	private double bankLoans1;
	private double bankLoans2;
	private double bankLoans3;
	private double totalInvestmentTotal;
	private double partyFundingTotal;
	private double unitRaisedTotal;
	private double otherFundsTotal;
	private double bankLoansTotal;
	
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String remark;

	// Constructors

	/** default constructor */
	public TfundPlanB() {
	}

	/** full constructor */
	public TfundPlanB(TprojectApplication tprojectApplication, String year1,
			String year2, String year3, double totalInvestment1,
			double totalInvestment2, double totalInvestment3,
			double partyFunding1, double partyFunding2, double partyFunding3,
			double unitRaised1, double unitRaised2, double unitRaised3,
			double otherFunds1, double otherFunds2, double otherFunds3,
			double bankLoans1, double bankLoans2, double bankLoans3,
			double totalInvestmentTotal,double partyFundingTotal,double unitRaisedTotal,
			double otherFundsTotal,double bankLoansTotal,
			String deleteFlag, Timestamp createTime, String createUser,
			Timestamp updateTime, String updateUser, String remark) {
		this.tprojectApplication = tprojectApplication;
		this.year1 = year1;
		this.year2 = year2;
		this.year3 = year3;
		this.totalInvestment1 = totalInvestment1;
		this.totalInvestment2 = totalInvestment2;
		this.totalInvestment3 = totalInvestment3;
		this.partyFunding1 = partyFunding1;
		this.partyFunding2 = partyFunding2;
		this.partyFunding3 = partyFunding3;
		this.unitRaised1 = unitRaised1;
		this.unitRaised2 = unitRaised2;
		this.unitRaised3 = unitRaised3;
		this.otherFunds1 = otherFunds1;
		this.otherFunds2 = otherFunds2;
		this.otherFunds3 = otherFunds3;
		this.bankLoans1 = bankLoans1;
		this.bankLoans2 = bankLoans2;
		this.bankLoans3 = bankLoans3;
		this.totalInvestmentTotal = totalInvestmentTotal;
		this.partyFundingTotal = partyFundingTotal;
		this.unitRaisedTotal = unitRaisedTotal;
		this.otherFundsTotal = otherFundsTotal;
		this.bankLoansTotal = bankLoansTotal;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.remark = remark;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "FUND_PLAN_B_ID", unique = true, nullable = false, length = 40)
	public String getFundPlanBId() {
		return fundPlanBId;
	}
	
	public void setFundPlanBId(String fundPlanBId) {
		this.fundPlanBId = fundPlanBId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}
	

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "YEAR_1", length = 4)
	public String getYear1() {
		return year1;
	}

	public void setYear1(String year1) {
		this.year1 = year1;
	}
	@Column(name = "YEAR_2", length = 4)
	public String getYear2() {
		return year2;
	}

	public void setYear2(String year2) {
		this.year2 = year2;
	}
	@Column(name = "YEAR_3", length = 4)
	public String getYear3() {
		return year3;
	}

	public void setYear3(String year3) {
		this.year3 = year3;
	}

	@Column(name = "TOTAL_INVESTMENT_1", precision = 11, scale = 4)
	public double getTotalInvestment1() {
		return this.totalInvestment1;
	}

	
	public void setTotalInvestment1(double totalInvestment1) {
		this.totalInvestment1 = totalInvestment1;
	}

	@Column(name = "TOTAL_INVESTMENT_2", precision = 11, scale = 4)
	public double getTotalInvestment2() {
		return this.totalInvestment2;
	}

	public void setTotalInvestment2(double totalInvestment2) {
		this.totalInvestment2 = totalInvestment2;
	}

	@Column(name = "TOTAL_INVESTMENT_3", precision = 11, scale = 4)
	public double getTotalInvestment3() {
		return this.totalInvestment3;
	}

	public void setTotalInvestment3(double totalInvestment3) {
		this.totalInvestment3 = totalInvestment3;
	}
	
	@Column(name = "PARTY_FUNDING_1", precision = 11, scale = 4)
	public double getPartyFunding1() {
		return this.partyFunding1;
	}

	public void setPartyFunding1(double partyFunding1) {
		this.partyFunding1 = partyFunding1;
	}

	@Column(name = "PARTY_FUNDING_2", precision = 11, scale = 4)
	public double getPartyFunding2() {
		return this.partyFunding2;
	}

	public void setPartyFunding2(double partyFunding2) {
		this.partyFunding2 = partyFunding2;
	}

	@Column(name = "PARTY_FUNDING_3", precision = 11, scale = 4)
	public double getPartyFunding3() {
		return this.partyFunding3;
	}

	public void setPartyFunding3(double partyFunding3) {
		this.partyFunding3 = partyFunding3;
	}

	@Column(name = "UNIT_RAISED_1", precision = 11, scale = 4)
	public double getUnitRaised1() {
		return this.unitRaised1;
	}

	public void setUnitRaised1(double unitRaised1) {
		this.unitRaised1 = unitRaised1;
	}

	@Column(name = "UNIT_RAISED_2", precision = 11, scale = 4)
	public double getUnitRaised2() {
		return this.unitRaised2;
	}

	public void setUnitRaised2(double unitRaised2) {
		this.unitRaised2 = unitRaised2;
	}

	@Column(name = "UNIT_RAISED_3", precision = 11, scale = 4)
	public double getUnitRaised3() {
		return this.unitRaised3;
	}

	public void setUnitRaised3(double unitRaised3) {
		this.unitRaised3 = unitRaised3;
	}

	@Column(name = "OTHER_FUNDS_1", precision = 11, scale = 4)
	public double getOtherFunds1() {
		return this.otherFunds1;
	}

	public void setOtherFunds1(double otherFunds1) {
		this.otherFunds1 = otherFunds1;
	}

	@Column(name = "OTHER_FUNDS_2", precision = 11, scale = 4)
	public double getOtherFunds2() {
		return this.otherFunds2;
	}

	public void setOtherFunds2(double otherFunds2) {
		this.otherFunds2 = otherFunds2;
	}

	@Column(name = "OTHER_FUNDS_3", precision = 11, scale = 4)
	public double getOtherFunds3() {
		return this.otherFunds3;
	}

	public void setOtherFunds3(double otherFunds3) {
		this.otherFunds3 = otherFunds3;
	}

	@Column(name = "BANK_LOANS_1", precision = 11, scale = 4)
	public double getBankLoans1() {
		return this.bankLoans1;
	}

	public void setBankLoans1(double bankLoans1) {
		this.bankLoans1 = bankLoans1;
	}

	@Column(name = "BANK_LOANS_2", precision = 11, scale = 4)
	public double getBankLoans2() {
		return this.bankLoans2;
	}

	public void setBankLoans2(double bankLoans2) {
		this.bankLoans2 = bankLoans2;
	}

	@Column(name = "BANK_LOANS_3", precision = 11, scale = 4)
	public double getBankLoans3() {
		return this.bankLoans3;
	}

	public void setBankLoans3(double bankLoans3) {
		this.bankLoans3 = bankLoans3;
	}

	@Column(name = "TOTAL_INVESTMENT_TOTAL", precision = 12, scale = 4)
	public double getTotalInvestmentTotal() {
		return totalInvestmentTotal;
	}

	public void setTotalInvestmentTotal(double totalInvestmentTotal) {
		this.totalInvestmentTotal = totalInvestmentTotal;
	}
	@Column(name = "PARTY_FUNDING_TOTAL", precision = 12, scale = 4)
	public double getPartyFundingTotal() {
		return partyFundingTotal;
	}

	public void setPartyFundingTotal(double partyFundingTotal) {
		this.partyFundingTotal = partyFundingTotal;
	}
	@Column(name = "UNIT_RAISED_TOTAL", precision = 12, scale = 4)
	public double getUnitRaisedTotal() {
		return unitRaisedTotal;
	}

	public void setUnitRaisedTotal(double unitRaisedTotal) {
		this.unitRaisedTotal = unitRaisedTotal;
	}
	@Column(name = "OTHER_FUNDS_TOTAL", precision = 12, scale = 4)
	public double getOtherFundsTotal() {
		return otherFundsTotal;
	}

	public void setOtherFundsTotal(double otherFundsTotal) {
		this.otherFundsTotal = otherFundsTotal;
	}
	@Column(name = "BANK_LOANS_TOTAL", precision = 12, scale = 4)
	public double getBankLoansTotal() {
		return bankLoansTotal;
	}

	public void setBankLoansTotal(double bankLoansTotal) {
		this.bankLoansTotal = bankLoansTotal;
	}

	@Column(name = "DELETE_FLAG", length = 40)
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

}
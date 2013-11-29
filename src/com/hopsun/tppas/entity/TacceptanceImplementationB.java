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
 * TacceptanceImplementationB entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ACCEPTANCE_IMPLEMENTATION_B")
public class TacceptanceImplementationB implements java.io.Serializable {

	private static final long serialVersionUID = 8780529830592421403L;
	// Fields
	private String implementationId;
	private Tacceptance tacceptance;
	private double planFundsTotalNum;
	private double planFundsCityNum;
	private double planRaisedNum;
	private double planBankNum;
	private double planLoanInterestNum;
	private double planOtherNum;
	private double actualFundsTotalNum;
	private double actualFundsCityNum;
	private double actualRaisedNum;
	private double actualBankNum;
	private double actualLoanInterestNum;
	private double actualOtherNum;
	private double totalStaffCosts;
	private double totalDeviceCosts;
	private double totalEnergyCosts;
	private double totalExperimentCosts;
	private double totalResearchCosts;
	private double totalTravelCosts;
	private double totalMeetingCosts;
	private double totalManageCosts;
	private double totalOtherCosts;
	private double totalTotalCosts;
	private double cityTotalStaffCosts;
	private double cityDeviceCosts;
	private double cityEnergyCosts;
	private double cityExperimentCosts;
	private double cityResearchCosts;
	private double cityTravelCosts;
	private double cityMeetingCosts;
	private double cityManageCosts;
	private double cityOtherCosts;
	private double cityTotalCosts;
	private String contractRequire1;
	private String contractRequire2;
	private String contractRequire3;
	private String contractRequire4;
	private String actuallyAchieved1;
	private String actuallyAchieved2;
	private String actuallyAchieved3;
	private String actuallyAchieved4;
	private double conventionsSales;
	private double conventionsProfitTotal;
	private double conventionsTaxTotal;
	private double conventionsForeignExchange;
	private double completeSales;
	private double completeProfitTotal;
	private double completeTaxTotal;
	private double completeForeignExchange;
	private String createUser;
	private Timestamp createTime;
	private String updateUser;
	private Timestamp updateTime;
	private String deleteFlag;
	
	// Constructors

	/** default constructor */
	public TacceptanceImplementationB() {
	}

	/** full constructor */
	public TacceptanceImplementationB(Tacceptance tacceptance,
			double planFundsTotalNum, double planFundsCityNum,
			double planRaisedNum, double planBankNum,
			double planLoanInterestNum, double planOtherNum,
			double actualFundsTotalNum, double actualFundsCityNum,
			double actualRaisedNum, double actualBankNum,
			double actualLoanInterestNum, double actualOtherNum,
			double totalStaffCosts, double totalDeviceCosts,
			double totalEnergyCosts, double totalExperimentCosts,
			double totalResearchCosts, double totalTravelCosts,
			double totalMeetingCosts, double totalManageCosts,
			double totalOtherCosts, double totalTotalCosts,
			double cityTotalStaffCosts, double cityDeviceCosts,
			double cityEnergyCosts, double cityExperimentCosts,
			double cityResearchCosts, double cityTravelCosts,
			double cityMeetingCosts, double cityManageCosts,
			double cityOtherCosts, double cityTotalCosts,
			String contractRequire1, String contractRequire2,
			String contractRequire3, String contractRequire4,
			String actuallyAchieved1, String actuallyAchieved2,
			String actuallyAchieved3, String actuallyAchieved4,
			double conventionsSales, double conventionsProfitTotal,
			double conventionsTaxTotal, double conventionsForeignExchange,
			double completeSales, double completeProfitTotal,
			double completeTaxTotal, double completeForeignExchange,
			String createUser, Timestamp createTime, String updateUser,
			Timestamp updateTime, String deleteFlag) {
		this.tacceptance = tacceptance;
		this.planFundsTotalNum = planFundsTotalNum;
		this.planFundsCityNum = planFundsCityNum;
		this.planRaisedNum = planRaisedNum;
		this.planBankNum = planBankNum;
		this.planLoanInterestNum = planLoanInterestNum;
		this.planOtherNum = planOtherNum;
		this.actualFundsTotalNum = actualFundsTotalNum;
		this.actualFundsCityNum = actualFundsCityNum;
		this.actualRaisedNum = actualRaisedNum;
		this.actualBankNum = actualBankNum;
		this.actualLoanInterestNum = actualLoanInterestNum;
		this.actualOtherNum = actualOtherNum;
		this.totalStaffCosts = totalStaffCosts;
		this.totalDeviceCosts = totalDeviceCosts;
		this.totalEnergyCosts = totalEnergyCosts;
		this.totalExperimentCosts = totalExperimentCosts;
		this.totalResearchCosts = totalResearchCosts;
		this.totalTravelCosts = totalTravelCosts;
		this.totalMeetingCosts = totalMeetingCosts;
		this.totalManageCosts = totalManageCosts;
		this.totalOtherCosts = totalOtherCosts;
		this.totalTotalCosts = totalTotalCosts;
		this.cityTotalStaffCosts = cityTotalStaffCosts;
		this.cityDeviceCosts = cityDeviceCosts;
		this.cityEnergyCosts = cityEnergyCosts;
		this.cityExperimentCosts = cityExperimentCosts;
		this.cityResearchCosts = cityResearchCosts;
		this.cityTravelCosts = cityTravelCosts;
		this.cityMeetingCosts = cityMeetingCosts;
		this.cityManageCosts = cityManageCosts;
		this.cityOtherCosts = cityOtherCosts;
		this.cityTotalCosts = cityTotalCosts;
		this.contractRequire1 = contractRequire1;
		this.contractRequire2 = contractRequire2;
		this.contractRequire3 = contractRequire3;
		this.contractRequire4 = contractRequire4;
		this.actuallyAchieved1 = actuallyAchieved1;
		this.actuallyAchieved2 = actuallyAchieved2;
		this.actuallyAchieved3 = actuallyAchieved3;
		this.actuallyAchieved4 = actuallyAchieved4;
		this.conventionsSales = conventionsSales;
		this.conventionsProfitTotal = conventionsProfitTotal;
		this.conventionsTaxTotal = conventionsTaxTotal;
		this.conventionsForeignExchange = conventionsForeignExchange;
		this.completeSales = completeSales;
		this.completeProfitTotal = completeProfitTotal;
		this.completeTaxTotal = completeTaxTotal;
		this.completeForeignExchange = completeForeignExchange;
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
	@Column(name = "IMPLEMENTATION_ID", unique = true, nullable = false, length = 40)
	public String getImplementationId() {
		return this.implementationId;
	}

	public void setImplementationId(String implementationId) {
		this.implementationId = implementationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCEPTANCE_ID")
	public Tacceptance getTacceptance() {
		return this.tacceptance;
	}

	public void setTacceptance(Tacceptance tacceptance) {
		this.tacceptance = tacceptance;
	}

	@Column(name = "PLAN_FUNDS_TOTAL_NUM", precision = 13, scale = 4)
	public double getPlanFundsTotalNum() {
		return this.planFundsTotalNum;
	}

	public void setPlanFundsTotalNum(double planFundsTotalNum) {
		this.planFundsTotalNum = planFundsTotalNum;
	}

	@Column(name = "PLAN_FUNDS_CITY_NUM", precision = 13, scale = 4)
	public double getPlanFundsCityNum() {
		return this.planFundsCityNum;
	}

	public void setPlanFundsCityNum(double planFundsCityNum) {
		this.planFundsCityNum = planFundsCityNum;
	}

	@Column(name = "PLAN_RAISED_NUM", precision = 13, scale = 4)
	public double getPlanRaisedNum() {
		return this.planRaisedNum;
	}

	public void setPlanRaisedNum(double planRaisedNum) {
		this.planRaisedNum = planRaisedNum;
	}

	@Column(name = "PLAN_BANK_NUM", precision = 13, scale = 4)
	public double getPlanBankNum() {
		return this.planBankNum;
	}

	public void setPlanBankNum(double planBankNum) {
		this.planBankNum = planBankNum;
	}

	@Column(name = "PLAN_LOAN_INTEREST_NUM", precision = 13, scale = 4)
	public double getPlanLoanInterestNum() {
		return this.planLoanInterestNum;
	}

	public void setPlanLoanInterestNum(double planLoanInterestNum) {
		this.planLoanInterestNum = planLoanInterestNum;
	}

	@Column(name = "PLAN_OTHER_NUM", precision = 13, scale = 4)
	public double getPlanOtherNum() {
		return this.planOtherNum;
	}

	public void setPlanOtherNum(double planOtherNum) {
		this.planOtherNum = planOtherNum;
	}

	@Column(name = "ACTUAL_FUNDS_TOTAL_NUM", precision = 13, scale = 4)
	public double getActualFundsTotalNum() {
		return this.actualFundsTotalNum;
	}

	public void setActualFundsTotalNum(double actualFundsTotalNum) {
		this.actualFundsTotalNum = actualFundsTotalNum;
	}

	@Column(name = "ACTUAL_FUNDS_CITY_NUM", precision = 13, scale = 4)
	public double getActualFundsCityNum() {
		return this.actualFundsCityNum;
	}

	public void setActualFundsCityNum(double actualFundsCityNum) {
		this.actualFundsCityNum = actualFundsCityNum;
	}

	@Column(name = "ACTUAL_RAISED_NUM", precision = 13, scale = 4)
	public double getActualRaisedNum() {
		return this.actualRaisedNum;
	}

	public void setActualRaisedNum(double actualRaisedNum) {
		this.actualRaisedNum = actualRaisedNum;
	}

	@Column(name = "ACTUAL_BANK_NUM", precision = 13, scale = 4)
	public double getActualBankNum() {
		return this.actualBankNum;
	}

	public void setActualBankNum(double actualBankNum) {
		this.actualBankNum = actualBankNum;
	}

	@Column(name = "ACTUAL_LOAN_INTEREST_NUM", precision = 13, scale = 4)
	public double getActualLoanInterestNum() {
		return this.actualLoanInterestNum;
	}

	public void setActualLoanInterestNum(double actualLoanInterestNum) {
		this.actualLoanInterestNum = actualLoanInterestNum;
	}

	@Column(name = "ACTUAL_OTHER_NUM", precision = 13, scale = 4)
	public double getActualOtherNum() {
		return this.actualOtherNum;
	}

	public void setActualOtherNum(double actualOtherNum) {
		this.actualOtherNum = actualOtherNum;
	}

	@Column(name = "TOTAL_STAFF_COSTS", precision = 13, scale = 4)
	public double getTotalStaffCosts() {
		return this.totalStaffCosts;
	}

	public void setTotalStaffCosts(double totalStaffCosts) {
		this.totalStaffCosts = totalStaffCosts;
	}

	@Column(name = "TOTAL_DEVICE_COSTS", precision = 13, scale = 4)
	public double getTotalDeviceCosts() {
		return this.totalDeviceCosts;
	}

	public void setTotalDeviceCosts(double totalDeviceCosts) {
		this.totalDeviceCosts = totalDeviceCosts;
	}

	@Column(name = "TOTAL_ENERGY_COSTS", precision = 13, scale = 4)
	public double getTotalEnergyCosts() {
		return this.totalEnergyCosts;
	}

	public void setTotalEnergyCosts(double totalEnergyCosts) {
		this.totalEnergyCosts = totalEnergyCosts;
	}

	@Column(name = "TOTAL_EXPERIMENT_COSTS", precision = 13, scale = 4)
	public double getTotalExperimentCosts() {
		return this.totalExperimentCosts;
	}

	public void setTotalExperimentCosts(double totalExperimentCosts) {
		this.totalExperimentCosts = totalExperimentCosts;
	}

	@Column(name = "TOTAL_RESEARCH_COSTS", precision = 13, scale = 4)
	public double getTotalResearchCosts() {
		return this.totalResearchCosts;
	}

	public void setTotalResearchCosts(double totalResearchCosts) {
		this.totalResearchCosts = totalResearchCosts;
	}

	@Column(name = "TOTAL_TRAVEL_COSTS", precision = 13, scale = 4)
	public double getTotalTravelCosts() {
		return this.totalTravelCosts;
	}

	public void setTotalTravelCosts(double totalTravelCosts) {
		this.totalTravelCosts = totalTravelCosts;
	}

	@Column(name = "TOTAL_MEETING_COSTS", precision = 13, scale = 4)
	public double getTotalMeetingCosts() {
		return this.totalMeetingCosts;
	}

	public void setTotalMeetingCosts(double totalMeetingCosts) {
		this.totalMeetingCosts = totalMeetingCosts;
	}

	@Column(name = "TOTAL_MANAGE_COSTS", precision = 13, scale = 4)
	public double getTotalManageCosts() {
		return this.totalManageCosts;
	}

	public void setTotalManageCosts(double totalManageCosts) {
		this.totalManageCosts = totalManageCosts;
	}

	@Column(name = "TOTAL_OTHER_COSTS", precision = 13, scale = 4)
	public double getTotalOtherCosts() {
		return this.totalOtherCosts;
	}

	public void setTotalOtherCosts(double totalOtherCosts) {
		this.totalOtherCosts = totalOtherCosts;
	}

	@Column(name = "TOTAL_TOTAL_COSTS", precision = 15, scale = 4)
	public double getTotalTotalCosts() {
		return this.totalTotalCosts;
	}

	public void setTotalTotalCosts(double totalTotalCosts) {
		this.totalTotalCosts = totalTotalCosts;
	}

	@Column(name = "CITY_TOTAL_STAFF_COSTS", precision = 13, scale = 4)
	public double getCityTotalStaffCosts() {
		return this.cityTotalStaffCosts;
	}

	public void setCityTotalStaffCosts(double cityTotalStaffCosts) {
		this.cityTotalStaffCosts = cityTotalStaffCosts;
	}

	@Column(name = "CITY_DEVICE_COSTS", precision = 13, scale = 4)
	public double getCityDeviceCosts() {
		return this.cityDeviceCosts;
	}

	public void setCityDeviceCosts(double cityDeviceCosts) {
		this.cityDeviceCosts = cityDeviceCosts;
	}

	@Column(name = "CITY_ENERGY_COSTS", precision = 13, scale = 4)
	public double getCityEnergyCosts() {
		return this.cityEnergyCosts;
	}

	public void setCityEnergyCosts(double cityEnergyCosts) {
		this.cityEnergyCosts = cityEnergyCosts;
	}

	@Column(name = "CITY_EXPERIMENT_COSTS", precision = 13, scale = 4)
	public double getCityExperimentCosts() {
		return this.cityExperimentCosts;
	}

	public void setCityExperimentCosts(double cityExperimentCosts) {
		this.cityExperimentCosts = cityExperimentCosts;
	}

	@Column(name = "CITY_RESEARCH_COSTS", precision = 13, scale = 4)
	public double getCityResearchCosts() {
		return this.cityResearchCosts;
	}

	public void setCityResearchCosts(double cityResearchCosts) {
		this.cityResearchCosts = cityResearchCosts;
	}

	@Column(name = "CITY_TRAVEL_COSTS", precision = 13, scale = 4)
	public double getCityTravelCosts() {
		return this.cityTravelCosts;
	}

	public void setCityTravelCosts(double cityTravelCosts) {
		this.cityTravelCosts = cityTravelCosts;
	}

	@Column(name = "CITY_MEETING_COSTS", precision = 13, scale = 4)
	public double getCityMeetingCosts() {
		return this.cityMeetingCosts;
	}

	public void setCityMeetingCosts(double cityMeetingCosts) {
		this.cityMeetingCosts = cityMeetingCosts;
	}

	@Column(name = "CITY_MANAGE_COSTS", precision = 13, scale = 4)
	public double getCityManageCosts() {
		return this.cityManageCosts;
	}

	public void setCityManageCosts(double cityManageCosts) {
		this.cityManageCosts = cityManageCosts;
	}

	@Column(name = "CITY_OTHER_COSTS", precision = 13, scale = 4)
	public double getCityOtherCosts() {
		return this.cityOtherCosts;
	}

	public void setCityOtherCosts(double cityOtherCosts) {
		this.cityOtherCosts = cityOtherCosts;
	}

	@Column(name = "CITY_TOTAL_COSTS", precision = 15, scale = 4)
	public double getCityTotalCosts() {
		return this.cityTotalCosts;
	}

	public void setCityTotalCosts(double cityTotalCosts) {
		this.cityTotalCosts = cityTotalCosts;
	}

	@Column(name = "CONTRACT_REQUIRE_1", length = 200)
	public String getContractRequire1() {
		return this.contractRequire1;
	}

	public void setContractRequire1(String contractRequire1) {
		this.contractRequire1 = contractRequire1;
	}

	@Column(name = "CONTRACT_REQUIRE_2", length = 200)
	public String getContractRequire2() {
		return this.contractRequire2;
	}

	public void setContractRequire2(String contractRequire2) {
		this.contractRequire2 = contractRequire2;
	}

	@Column(name = "CONTRACT_REQUIRE_3", length = 200)
	public String getContractRequire3() {
		return this.contractRequire3;
	}

	public void setContractRequire3(String contractRequire3) {
		this.contractRequire3 = contractRequire3;
	}

	@Column(name = "CONTRACT_REQUIRE_4", length = 200)
	public String getContractRequire4() {
		return this.contractRequire4;
	}

	public void setContractRequire4(String contractRequire4) {
		this.contractRequire4 = contractRequire4;
	}

	@Column(name = "ACTUALLY_ACHIEVED_1", length = 200)
	public String getActuallyAchieved1() {
		return this.actuallyAchieved1;
	}

	public void setActuallyAchieved1(String actuallyAchieved1) {
		this.actuallyAchieved1 = actuallyAchieved1;
	}

	@Column(name = "ACTUALLY_ACHIEVED_2", length = 200)
	public String getActuallyAchieved2() {
		return this.actuallyAchieved2;
	}

	public void setActuallyAchieved2(String actuallyAchieved2) {
		this.actuallyAchieved2 = actuallyAchieved2;
	}

	@Column(name = "ACTUALLY_ACHIEVED_3", length = 200)
	public String getActuallyAchieved3() {
		return this.actuallyAchieved3;
	}

	public void setActuallyAchieved3(String actuallyAchieved3) {
		this.actuallyAchieved3 = actuallyAchieved3;
	}

	@Column(name = "ACTUALLY_ACHIEVED_4", length = 200)
	public String getActuallyAchieved4() {
		return this.actuallyAchieved4;
	}

	public void setActuallyAchieved4(String actuallyAchieved4) {
		this.actuallyAchieved4 = actuallyAchieved4;
	}

	@Column(name = "CONVENTIONS_SALES", precision = 13, scale = 4)
	public double getConventionsSales() {
		return this.conventionsSales;
	}

	public void setConventionsSales(double conventionsSales) {
		this.conventionsSales = conventionsSales;
	}

	@Column(name = "CONVENTIONS_PROFIT_TOTAL", precision = 13, scale = 4)
	public double getConventionsProfitTotal() {
		return this.conventionsProfitTotal;
	}

	public void setConventionsProfitTotal(double conventionsProfitTotal) {
		this.conventionsProfitTotal = conventionsProfitTotal;
	}

	@Column(name = "CONVENTIONS_TAX_TOTAL", precision = 13, scale = 4)
	public double getConventionsTaxTotal() {
		return this.conventionsTaxTotal;
	}

	public void setConventionsTaxTotal(double conventionsTaxTotal) {
		this.conventionsTaxTotal = conventionsTaxTotal;
	}

	@Column(name = "CONVENTIONS_FOREIGN_EXCHANGE", precision = 13, scale = 4)
	public double getConventionsForeignExchange() {
		return this.conventionsForeignExchange;
	}

	public void setConventionsForeignExchange(double conventionsForeignExchange) {
		this.conventionsForeignExchange = conventionsForeignExchange;
	}

	@Column(name = "COMPLETE_SALES", precision = 13, scale = 4)
	public double getCompleteSales() {
		return this.completeSales;
	}

	public void setCompleteSales(double completeSales) {
		this.completeSales = completeSales;
	}

	@Column(name = "COMPLETE_PROFIT_TOTAL", precision = 13, scale = 4)
	public double getCompleteProfitTotal() {
		return this.completeProfitTotal;
	}

	public void setCompleteProfitTotal(double completeProfitTotal) {
		this.completeProfitTotal = completeProfitTotal;
	}

	@Column(name = "COMPLETE_TAX_TOTAL", precision = 13, scale = 4)
	public double getCompleteTaxTotal() {
		return this.completeTaxTotal;
	}

	public void setCompleteTaxTotal(double completeTaxTotal) {
		this.completeTaxTotal = completeTaxTotal;
	}

	@Column(name = "COMPLETE_FOREIGN_EXCHANGE", precision = 13, scale = 4)
	public double getCompleteForeignExchange() {
		return this.completeForeignExchange;
	}

	public void setCompleteForeignExchange(double completeForeignExchange) {
		this.completeForeignExchange = completeForeignExchange;
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
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
 * TacceptanceImplementationA entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ACCEPTANCE_IMPLEMENTATION_A")
public class TacceptanceImplementationA implements java.io.Serializable {

	private static final long serialVersionUID = 1302060882953315204L;
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
	private double totalTotalCosts;
	private double totalStaffCosts;
	private double totalDeviceCosts;
	private double totalEnergyCosts;
	private double totalExperimentCosts;
	private double totalResearchCosts;
	private double totalTravelCosts;
	private double totalMeetingCosts;
	private double totalManageCosts;
	private double totalOtherCosts;
	private double totalRdCosts;
	private double cityTotalCosts;
	private double cityStaffCosts;
	private double cityDeviceCosts;
	private double cityEnergyCosts;
	private double cityExperimentCosts;
	private double cityResearchCosts;
	private double cityTravelCosts;
	private double cityMeetingCosts;
	private double cityManageCosts;
	private double cityOtherCosts;
	private double cityRdCosts;
	private String createUser;
	private Timestamp createTime;
	private String updateUser;
	private Timestamp updateTime;
	private String deleteFlag;

	// Constructors

	/** default constructor */
	public TacceptanceImplementationA() {
	}

	/** full constructor */
	public TacceptanceImplementationA(Tacceptance tacceptance,
			double planFundsTotalNum, double planFundsCityNum,
			double planRaisedNum, double planBankNum,
			double planLoanInterestNum, double planOtherNum,
			double actualFundsTotalNum, double actualFundsCityNum,
			double actualRaisedNum, double actualBankNum,
			double actualLoanInterestNum, double actualOtherNum,
			double totalTotalCosts, double totalStaffCosts,
			double totalDeviceCosts, double totalEnergyCosts,
			double totalExperimentCosts, double totalResearchCosts,
			double totalTravelCosts, double totalMeetingCosts,
			double totalManageCosts, double totalOtherCosts,
			double totalRdCosts, double cityTotalCosts, double cityStaffCosts,
			double cityDeviceCosts, double cityEnergyCosts,
			double cityExperimentCosts, double cityResearchCosts,
			double cityTravelCosts, double cityMeetingCosts,
			double cityManageCosts, double cityOtherCosts, double cityRdCosts,
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
		this.totalTotalCosts = totalTotalCosts;
		this.totalStaffCosts = totalStaffCosts;
		this.totalDeviceCosts = totalDeviceCosts;
		this.totalEnergyCosts = totalEnergyCosts;
		this.totalExperimentCosts = totalExperimentCosts;
		this.totalResearchCosts = totalResearchCosts;
		this.totalTravelCosts = totalTravelCosts;
		this.totalMeetingCosts = totalMeetingCosts;
		this.totalManageCosts = totalManageCosts;
		this.totalOtherCosts = totalOtherCosts;
		this.totalRdCosts = totalRdCosts;
		this.cityTotalCosts = cityTotalCosts;
		this.cityStaffCosts = cityStaffCosts;
		this.cityDeviceCosts = cityDeviceCosts;
		this.cityEnergyCosts = cityEnergyCosts;
		this.cityExperimentCosts = cityExperimentCosts;
		this.cityResearchCosts = cityResearchCosts;
		this.cityTravelCosts = cityTravelCosts;
		this.cityMeetingCosts = cityMeetingCosts;
		this.cityManageCosts = cityManageCosts;
		this.cityOtherCosts = cityOtherCosts;
		this.cityRdCosts = cityRdCosts;
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

	@Column(name = "PLAN_FUNDS_TOTAL_NUM", precision = 11, scale = 4)
	public double getPlanFundsTotalNum() {
		return this.planFundsTotalNum;
	}

	public void setPlanFundsTotalNum(double planFundsTotalNum) {
		this.planFundsTotalNum = planFundsTotalNum;
	}

	@Column(name = "PLAN_FUNDS_CITY_NUM", precision = 11, scale = 4)
	public double getPlanFundsCityNum() {
		return this.planFundsCityNum;
	}

	public void setPlanFundsCityNum(double planFundsCityNum) {
		this.planFundsCityNum = planFundsCityNum;
	}

	@Column(name = "PLAN_RAISED_NUM", precision = 11, scale = 4)
	public double getPlanRaisedNum() {
		return this.planRaisedNum;
	}

	public void setPlanRaisedNum(double planRaisedNum) {
		this.planRaisedNum = planRaisedNum;
	}

	@Column(name = "PLAN_BANK_NUM", precision = 11, scale = 4)
	public double getPlanBankNum() {
		return this.planBankNum;
	}

	public void setPlanBankNum(double planBankNum) {
		this.planBankNum = planBankNum;
	}

	@Column(name = "PLAN_LOAN_INTEREST_NUM", precision = 11, scale = 4)
	public double getPlanLoanInterestNum() {
		return this.planLoanInterestNum;
	}

	public void setPlanLoanInterestNum(double planLoanInterestNum) {
		this.planLoanInterestNum = planLoanInterestNum;
	}

	@Column(name = "PLAN_OTHER_NUM", precision = 11, scale = 4)
	public double getPlanOtherNum() {
		return this.planOtherNum;
	}

	public void setPlanOtherNum(double planOtherNum) {
		this.planOtherNum = planOtherNum;
	}

	@Column(name = "ACTUAL_FUNDS_TOTAL_NUM", precision = 11, scale = 4)
	public double getActualFundsTotalNum() {
		return this.actualFundsTotalNum;
	}

	public void setActualFundsTotalNum(double actualFundsTotalNum) {
		this.actualFundsTotalNum = actualFundsTotalNum;
	}

	@Column(name = "ACTUAL_FUNDS_CITY_NUM", precision = 11, scale = 4)
	public double getActualFundsCityNum() {
		return this.actualFundsCityNum;
	}

	public void setActualFundsCityNum(double actualFundsCityNum) {
		this.actualFundsCityNum = actualFundsCityNum;
	}

	@Column(name = "ACTUAL_RAISED_NUM", precision = 11, scale = 4)
	public double getActualRaisedNum() {
		return this.actualRaisedNum;
	}

	public void setActualRaisedNum(double actualRaisedNum) {
		this.actualRaisedNum = actualRaisedNum;
	}

	@Column(name = "ACTUAL_BANK_NUM", precision = 11, scale = 4)
	public double getActualBankNum() {
		return this.actualBankNum;
	}

	public void setActualBankNum(double actualBankNum) {
		this.actualBankNum = actualBankNum;
	}

	@Column(name = "ACTUAL_LOAN_INTEREST_NUM", precision = 11, scale = 4)
	public double getActualLoanInterestNum() {
		return this.actualLoanInterestNum;
	}

	public void setActualLoanInterestNum(double actualLoanInterestNum) {
		this.actualLoanInterestNum = actualLoanInterestNum;
	}

	@Column(name = "ACTUAL_OTHER_NUM", precision = 11, scale = 4)
	public double getActualOtherNum() {
		return this.actualOtherNum;
	}

	public void setActualOtherNum(double actualOtherNum) {
		this.actualOtherNum = actualOtherNum;
	}

	@Column(name = "TOTAL_TOTAL_COSTS", precision = 11, scale = 4)
	public double getTotalTotalCosts() {
		return this.totalTotalCosts;
	}

	public void setTotalTotalCosts(double totalTotalCosts) {
		this.totalTotalCosts = totalTotalCosts;
	}

	@Column(name = "TOTAL_STAFF_COSTS", precision = 11, scale = 4)
	public double getTotalStaffCosts() {
		return this.totalStaffCosts;
	}

	public void setTotalStaffCosts(double totalStaffCosts) {
		this.totalStaffCosts = totalStaffCosts;
	}

	@Column(name = "TOTAL_DEVICE_COSTS", precision = 11, scale = 4)
	public double getTotalDeviceCosts() {
		return this.totalDeviceCosts;
	}

	public void setTotalDeviceCosts(double totalDeviceCosts) {
		this.totalDeviceCosts = totalDeviceCosts;
	}

	@Column(name = "TOTAL_ENERGY_COSTS", precision = 11, scale = 4)
	public double getTotalEnergyCosts() {
		return this.totalEnergyCosts;
	}

	public void setTotalEnergyCosts(double totalEnergyCosts) {
		this.totalEnergyCosts = totalEnergyCosts;
	}

	@Column(name = "TOTAL_EXPERIMENT_COSTS", precision = 11, scale = 4)
	public double getTotalExperimentCosts() {
		return this.totalExperimentCosts;
	}

	public void setTotalExperimentCosts(double totalExperimentCosts) {
		this.totalExperimentCosts = totalExperimentCosts;
	}

	@Column(name = "TOTAL_RESEARCH_COSTS", precision = 11, scale = 4)
	public double getTotalResearchCosts() {
		return this.totalResearchCosts;
	}

	public void setTotalResearchCosts(double totalResearchCosts) {
		this.totalResearchCosts = totalResearchCosts;
	}

	@Column(name = "TOTAL_TRAVEL_COSTS", precision = 11, scale = 4)
	public double getTotalTravelCosts() {
		return this.totalTravelCosts;
	}

	public void setTotalTravelCosts(double totalTravelCosts) {
		this.totalTravelCosts = totalTravelCosts;
	}

	@Column(name = "TOTAL_MEETING_COSTS", precision = 11, scale = 4)
	public double getTotalMeetingCosts() {
		return this.totalMeetingCosts;
	}

	public void setTotalMeetingCosts(double totalMeetingCosts) {
		this.totalMeetingCosts = totalMeetingCosts;
	}

	@Column(name = "TOTAL_MANAGE_COSTS", precision = 11, scale = 4)
	public double getTotalManageCosts() {
		return this.totalManageCosts;
	}

	public void setTotalManageCosts(double totalManageCosts) {
		this.totalManageCosts = totalManageCosts;
	}

	@Column(name = "TOTAL_OTHER_COSTS", precision = 11, scale = 4)
	public double getTotalOtherCosts() {
		return this.totalOtherCosts;
	}

	public void setTotalOtherCosts(double totalOtherCosts) {
		this.totalOtherCosts = totalOtherCosts;
	}

	@Column(name = "TOTAL_RD_COSTS", precision = 12, scale = 4)
	public double getTotalRdCosts() {
		return this.totalRdCosts;
	}

	public void setTotalRdCosts(double totalRdCosts) {
		this.totalRdCosts = totalRdCosts;
	}

	@Column(name = "CITY_TOTAL_COSTS", precision = 11, scale = 4)
	public double getCityTotalCosts() {
		return this.cityTotalCosts;
	}

	public void setCityTotalCosts(double cityTotalCosts) {
		this.cityTotalCosts = cityTotalCosts;
	}

	@Column(name = "CITY_STAFF_COSTS", precision = 11, scale = 4)
	public double getCityStaffCosts() {
		return this.cityStaffCosts;
	}

	public void setCityStaffCosts(double cityStaffCosts) {
		this.cityStaffCosts = cityStaffCosts;
	}

	@Column(name = "CITY_DEVICE_COSTS", precision = 11, scale = 4)
	public double getCityDeviceCosts() {
		return this.cityDeviceCosts;
	}

	public void setCityDeviceCosts(double cityDeviceCosts) {
		this.cityDeviceCosts = cityDeviceCosts;
	}

	@Column(name = "CITY_ENERGY_COSTS", precision = 11, scale = 4)
	public double getCityEnergyCosts() {
		return this.cityEnergyCosts;
	}

	public void setCityEnergyCosts(double cityEnergyCosts) {
		this.cityEnergyCosts = cityEnergyCosts;
	}

	@Column(name = "CITY_EXPERIMENT_COSTS", precision = 11, scale = 4)
	public double getCityExperimentCosts() {
		return this.cityExperimentCosts;
	}

	public void setCityExperimentCosts(double cityExperimentCosts) {
		this.cityExperimentCosts = cityExperimentCosts;
	}

	@Column(name = "CITY_RESEARCH_COSTS", precision = 11, scale = 4)
	public double getCityResearchCosts() {
		return this.cityResearchCosts;
	}

	public void setCityResearchCosts(double cityResearchCosts) {
		this.cityResearchCosts = cityResearchCosts;
	}

	@Column(name = "CITY_TRAVEL_COSTS", precision = 11, scale = 4)
	public double getCityTravelCosts() {
		return this.cityTravelCosts;
	}

	public void setCityTravelCosts(double cityTravelCosts) {
		this.cityTravelCosts = cityTravelCosts;
	}

	@Column(name = "CITY_MEETING_COSTS", precision = 11, scale = 4)
	public double getCityMeetingCosts() {
		return this.cityMeetingCosts;
	}

	public void setCityMeetingCosts(double cityMeetingCosts) {
		this.cityMeetingCosts = cityMeetingCosts;
	}

	@Column(name = "CITY_MANAGE_COSTS", precision = 11, scale = 4)
	public double getCityManageCosts() {
		return this.cityManageCosts;
	}

	public void setCityManageCosts(double cityManageCosts) {
		this.cityManageCosts = cityManageCosts;
	}

	@Column(name = "CITY_OTHER_COSTS", precision = 11, scale = 4)
	public double getCityOtherCosts() {
		return this.cityOtherCosts;
	}

	public void setCityOtherCosts(double cityOtherCosts) {
		this.cityOtherCosts = cityOtherCosts;
	}

	@Column(name = "CITY_RD_COSTS", precision = 12, scale = 4)
	public double getCityRdCosts() {
		return this.cityRdCosts;
	}

	public void setCityRdCosts(double cityRdCosts) {
		this.cityRdCosts = cityRdCosts;
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
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
 * TacceptanceAccFundsA entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ACCEPTANCE_ACC_FUNDS_A")
public class TacceptanceAccFundsA implements java.io.Serializable {

	private static final long serialVersionUID = 6361582675196480713L;
	// Fields
	private String accFundsId;
	private Tacceptance tacceptance;
	private String remark1;
	private String remark2;
	private String remark3;
	private String remark4;
	private double gudgetTotalInvestment;
	private double accountsTotalInvestment;
	private double gudgetPartyFunding;
	private double accountsPartyFunding;
	private double gudgetOther;
	private double accountsOther;
	private double gudgetRaised;
	private double accountsRaised;
	private double gudgetBank;
	private double accountsBank;
	private String year1;
	private String year2;
	private String year3;
	private double staffCosts1;
	private double staffCosts2;
	private double staffCosts3;
	private double staffCostsTotal;
	private double deviceCosts1;
	private double deviceCosts2;
	private double deviceCosts3;
	private double deviceCostsTotal;
	private double energyCosts1;
	private double energyCosts2;
	private double energyCosts3;
	private double energyCostsTotal;
	private double experimentCosts1;
	private double experimentCosts2;
	private double experimentCosts3;
	private double experimentCostsTotal;
	private double researchCosts1;
	private double researchCosts2;
	private double researchCosts3;
	private double researchCostsTotal;
	private double travelCosts1;
	private double travelCosts2;
	private double travelCosts3;
	private double travelCostsTotal;
	private double meetingCosts1;
	private double meetingCosts2;
	private double meetingCosts3;
	private double meetingCostsTotal;
	private double manageCosts1;
	private double manageCosts2;
	private double manageCosts3;
	private double manageCostsTotal;
	private String projectManager;
	private String unitManager;
	private Timestamp acceptanceTime;
	private String acceptanceStyle;
	private String acceptanceResult;
	private String acceptanceDepartment;
	private String createUser;
	private Timestamp createTime;
	private String updateUser;
	private Timestamp updateTime;
	private String deleteFlag;

	// Constructors

	/** default constructor */
	public TacceptanceAccFundsA() {
	}

	/** full constructor */
	public TacceptanceAccFundsA(Tacceptance tacceptance, String remark1,
			String remark2, String remark3, String remark4,
			double gudgetTotalInvestment, double accountsTotalInvestment,
			double gudgetPartyFunding, double accountsPartyFunding,
			double gudgetOther, double accountsOther, double gudgetRaised,
			double accountsRaised, double gudgetBank, double accountsBank,
			String year1, String year2, String year3, double staffCosts1,
			double staffCosts2, double staffCosts3, double staffCostsTotal,
			double deviceCosts1, double deviceCosts2, double deviceCosts3,
			double deviceCostsTotal, double energyCosts1, double energyCosts2,
			double energyCosts3, double energyCostsTotal,
			double experimentCosts1, double experimentCosts2,
			double experimentCosts3, double experimentCostsTotal,
			double researchCosts1, double researchCosts2,
			double researchCosts3, double researchCostsTotal,
			double travelCosts1, double travelCosts2, double travelCosts3,
			double travelCostsTotal, double meetingCosts1,
			double meetingCosts2, double meetingCosts3,
			double meetingCostsTotal, double manageCosts1, double manageCosts2,
			double manageCosts3, double manageCostsTotal,
			String projectManager, String unitManager, Timestamp acceptanceTime,
			String acceptanceStyle, String acceptanceResult,
			String acceptanceDepartment, String createUser, Timestamp createTime,
			String updateUser, Timestamp updateTime, String deleteFlag) {
		this.tacceptance = tacceptance;
		this.remark1 = remark1;
		this.remark2 = remark2;
		this.remark3 = remark3;
		this.remark4 = remark4;
		this.gudgetTotalInvestment = gudgetTotalInvestment;
		this.accountsTotalInvestment = accountsTotalInvestment;
		this.gudgetPartyFunding = gudgetPartyFunding;
		this.accountsPartyFunding = accountsPartyFunding;
		this.gudgetOther = gudgetOther;
		this.accountsOther = accountsOther;
		this.gudgetRaised = gudgetRaised;
		this.accountsRaised = accountsRaised;
		this.gudgetBank = gudgetBank;
		this.accountsBank = accountsBank;
		this.year1 = year1;
		this.year2 = year2;
		this.year3 = year3;
		this.staffCosts1 = staffCosts1;
		this.staffCosts2 = staffCosts2;
		this.staffCosts3 = staffCosts3;
		this.staffCostsTotal = staffCostsTotal;
		this.deviceCosts1 = deviceCosts1;
		this.deviceCosts2 = deviceCosts2;
		this.deviceCosts3 = deviceCosts3;
		this.deviceCostsTotal = deviceCostsTotal;
		this.energyCosts1 = energyCosts1;
		this.energyCosts2 = energyCosts2;
		this.energyCosts3 = energyCosts3;
		this.energyCostsTotal = energyCostsTotal;
		this.experimentCosts1 = experimentCosts1;
		this.experimentCosts2 = experimentCosts2;
		this.experimentCosts3 = experimentCosts3;
		this.experimentCostsTotal = experimentCostsTotal;
		this.researchCosts1 = researchCosts1;
		this.researchCosts2 = researchCosts2;
		this.researchCosts3 = researchCosts3;
		this.researchCostsTotal = researchCostsTotal;
		this.travelCosts1 = travelCosts1;
		this.travelCosts2 = travelCosts2;
		this.travelCosts3 = travelCosts3;
		this.travelCostsTotal = travelCostsTotal;
		this.meetingCosts1 = meetingCosts1;
		this.meetingCosts2 = meetingCosts2;
		this.meetingCosts3 = meetingCosts3;
		this.meetingCostsTotal = meetingCostsTotal;
		this.manageCosts1 = manageCosts1;
		this.manageCosts2 = manageCosts2;
		this.manageCosts3 = manageCosts3;
		this.manageCostsTotal = manageCostsTotal;
		this.projectManager = projectManager;
		this.unitManager = unitManager;
		this.acceptanceTime = acceptanceTime;
		this.acceptanceStyle = acceptanceStyle;
		this.acceptanceResult = acceptanceResult;
		this.acceptanceDepartment = acceptanceDepartment;
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
	@Column(name = "ACC_FUNDS_ID", unique = true, nullable = false, length = 40)
	public String getAccFundsId() {
		return this.accFundsId;
	}

	public void setAccFundsId(String accFundsId) {
		this.accFundsId = accFundsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCEPTANCE_ID")
	public Tacceptance getTacceptance() {
		return this.tacceptance;
	}

	public void setTacceptance(Tacceptance tacceptance) {
		this.tacceptance = tacceptance;
	}

	@Column(name = "REMARK_1", length = 100)
	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	@Column(name = "REMARK_2", length = 100)
	public String getRemark2() {
		return this.remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	@Column(name = "REMARK_3", length = 100)
	public String getRemark3() {
		return this.remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	@Column(name = "REMARK_4", length = 100)
	public String getRemark4() {
		return this.remark4;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	@Column(name = "GUDGET_TOTAL_INVESTMENT", precision = 11, scale = 4)
	public double getGudgetTotalInvestment() {
		return this.gudgetTotalInvestment;
	}

	public void setGudgetTotalInvestment(double gudgetTotalInvestment) {
		this.gudgetTotalInvestment = gudgetTotalInvestment;
	}

	@Column(name = "ACCOUNTS_TOTAL_INVESTMENT", precision = 11, scale = 4)
	public double getAccountsTotalInvestment() {
		return this.accountsTotalInvestment;
	}

	public void setAccountsTotalInvestment(double accountsTotalInvestment) {
		this.accountsTotalInvestment = accountsTotalInvestment;
	}

	@Column(name = "GUDGET_PARTY_FUNDING", precision = 11, scale = 4)
	public double getGudgetPartyFunding() {
		return this.gudgetPartyFunding;
	}

	public void setGudgetPartyFunding(double gudgetPartyFunding) {
		this.gudgetPartyFunding = gudgetPartyFunding;
	}

	@Column(name = "ACCOUNTS_PARTY_FUNDING", precision = 11, scale = 4)
	public double getAccountsPartyFunding() {
		return this.accountsPartyFunding;
	}

	public void setAccountsPartyFunding(double accountsPartyFunding) {
		this.accountsPartyFunding = accountsPartyFunding;
	}

	@Column(name = "GUDGET_OTHER", precision = 11, scale = 4)
	public double getGudgetOther() {
		return this.gudgetOther;
	}

	public void setGudgetOther(double gudgetOther) {
		this.gudgetOther = gudgetOther;
	}

	@Column(name = "ACCOUNTS_OTHER", precision = 11, scale = 4)
	public double getAccountsOther() {
		return this.accountsOther;
	}

	public void setAccountsOther(double accountsOther) {
		this.accountsOther = accountsOther;
	}

	@Column(name = "GUDGET_RAISED", precision = 11, scale = 4)
	public double getGudgetRaised() {
		return this.gudgetRaised;
	}

	public void setGudgetRaised(double gudgetRaised) {
		this.gudgetRaised = gudgetRaised;
	}

	@Column(name = "ACCOUNTS_RAISED", precision = 11, scale = 4)
	public double getAccountsRaised() {
		return this.accountsRaised;
	}

	public void setAccountsRaised(double accountsRaised) {
		this.accountsRaised = accountsRaised;
	}

	@Column(name = "GUDGET_BANK", precision = 11, scale = 4)
	public double getGudgetBank() {
		return this.gudgetBank;
	}

	public void setGudgetBank(double gudgetBank) {
		this.gudgetBank = gudgetBank;
	}

	@Column(name = "ACCOUNTS_BANK", precision = 11, scale = 4)
	public double getAccountsBank() {
		return this.accountsBank;
	}

	public void setAccountsBank(double accountsBank) {
		this.accountsBank = accountsBank;
	}

	@Column(name = "YEAR_1", length = 10)
	public String getYear1() {
		return this.year1;
	}

	public void setYear1(String year1) {
		this.year1 = year1;
	}

	@Column(name = "YEAR_2", length = 10)
	public String getYear2() {
		return this.year2;
	}

	public void setYear2(String year2) {
		this.year2 = year2;
	}

	@Column(name = "YEAR_3", length = 10)
	public String getYear3() {
		return this.year3;
	}

	public void setYear3(String year3) {
		this.year3 = year3;
	}

	@Column(name = "STAFF_COSTS_1", precision = 11, scale = 4)
	public double getStaffCosts1() {
		return this.staffCosts1;
	}

	public void setStaffCosts1(double staffCosts1) {
		this.staffCosts1 = staffCosts1;
	}

	@Column(name = "STAFF_COSTS_2", precision = 11, scale = 4)
	public double getStaffCosts2() {
		return this.staffCosts2;
	}

	public void setStaffCosts2(double staffCosts2) {
		this.staffCosts2 = staffCosts2;
	}

	@Column(name = "STAFF_COSTS_3", precision = 11, scale = 4)
	public double getStaffCosts3() {
		return this.staffCosts3;
	}

	public void setStaffCosts3(double staffCosts3) {
		this.staffCosts3 = staffCosts3;
	}

	@Column(name = "STAFF_COSTS_TOTAL", precision = 12, scale = 4)
	public double getStaffCostsTotal() {
		return this.staffCostsTotal;
	}

	public void setStaffCostsTotal(double staffCostsTotal) {
		this.staffCostsTotal = staffCostsTotal;
	}

	@Column(name = "DEVICE_COSTS_1", precision = 11, scale = 4)
	public double getDeviceCosts1() {
		return this.deviceCosts1;
	}

	public void setDeviceCosts1(double deviceCosts1) {
		this.deviceCosts1 = deviceCosts1;
	}

	@Column(name = "DEVICE_COSTS_2", precision = 11, scale = 4)
	public double getDeviceCosts2() {
		return this.deviceCosts2;
	}

	public void setDeviceCosts2(double deviceCosts2) {
		this.deviceCosts2 = deviceCosts2;
	}

	@Column(name = "DEVICE_COSTS_3", precision = 11, scale = 4)
	public double getDeviceCosts3() {
		return this.deviceCosts3;
	}

	public void setDeviceCosts3(double deviceCosts3) {
		this.deviceCosts3 = deviceCosts3;
	}

	@Column(name = "DEVICE_COSTS_TOTAL", precision = 12, scale = 4)
	public double getDeviceCostsTotal() {
		return this.deviceCostsTotal;
	}

	public void setDeviceCostsTotal(double deviceCostsTotal) {
		this.deviceCostsTotal = deviceCostsTotal;
	}

	@Column(name = "ENERGY_COSTS_1", precision = 11, scale = 4)
	public double getEnergyCosts1() {
		return this.energyCosts1;
	}

	public void setEnergyCosts1(double energyCosts1) {
		this.energyCosts1 = energyCosts1;
	}

	@Column(name = "ENERGY_COSTS_2", precision = 11, scale = 4)
	public double getEnergyCosts2() {
		return this.energyCosts2;
	}

	public void setEnergyCosts2(double energyCosts2) {
		this.energyCosts2 = energyCosts2;
	}

	@Column(name = "ENERGY_COSTS_3", precision = 11, scale = 4)
	public double getEnergyCosts3() {
		return this.energyCosts3;
	}

	public void setEnergyCosts3(double energyCosts3) {
		this.energyCosts3 = energyCosts3;
	}

	@Column(name = "ENERGY_COSTS_TOTAL", precision = 12, scale = 4)
	public double getEnergyCostsTotal() {
		return this.energyCostsTotal;
	}

	public void setEnergyCostsTotal(double energyCostsTotal) {
		this.energyCostsTotal = energyCostsTotal;
	}

	@Column(name = "EXPERIMENT_COSTS_1", precision = 11, scale = 4)
	public double getExperimentCosts1() {
		return this.experimentCosts1;
	}

	public void setExperimentCosts1(double experimentCosts1) {
		this.experimentCosts1 = experimentCosts1;
	}

	@Column(name = "EXPERIMENT_COSTS_2", precision = 11, scale = 4)
	public double getExperimentCosts2() {
		return this.experimentCosts2;
	}

	public void setExperimentCosts2(double experimentCosts2) {
		this.experimentCosts2 = experimentCosts2;
	}

	@Column(name = "EXPERIMENT_COSTS_3", precision = 11, scale = 4)
	public double getExperimentCosts3() {
		return this.experimentCosts3;
	}

	public void setExperimentCosts3(double experimentCosts3) {
		this.experimentCosts3 = experimentCosts3;
	}

	@Column(name = "EXPERIMENT_COSTS_TOTAL", precision = 12, scale = 4)
	public double getExperimentCostsTotal() {
		return this.experimentCostsTotal;
	}

	public void setExperimentCostsTotal(double experimentCostsTotal) {
		this.experimentCostsTotal = experimentCostsTotal;
	}

	@Column(name = "RESEARCH_COSTS_1", precision = 11, scale = 4)
	public double getResearchCosts1() {
		return this.researchCosts1;
	}

	public void setResearchCosts1(double researchCosts1) {
		this.researchCosts1 = researchCosts1;
	}

	@Column(name = "RESEARCH_COSTS_2", precision = 11, scale = 4)
	public double getResearchCosts2() {
		return this.researchCosts2;
	}

	public void setResearchCosts2(double researchCosts2) {
		this.researchCosts2 = researchCosts2;
	}

	@Column(name = "RESEARCH_COSTS_3", precision = 11, scale = 4)
	public double getResearchCosts3() {
		return this.researchCosts3;
	}

	public void setResearchCosts3(double researchCosts3) {
		this.researchCosts3 = researchCosts3;
	}

	@Column(name = "RESEARCH_COSTS_TOTAL", precision = 12, scale = 4)
	public double getResearchCostsTotal() {
		return this.researchCostsTotal;
	}

	public void setResearchCostsTotal(double researchCostsTotal) {
		this.researchCostsTotal = researchCostsTotal;
	}

	@Column(name = "TRAVEL_COSTS_1", precision = 11, scale = 4)
	public double getTravelCosts1() {
		return this.travelCosts1;
	}

	public void setTravelCosts1(double travelCosts1) {
		this.travelCosts1 = travelCosts1;
	}

	@Column(name = "TRAVEL_COSTS_2", precision = 11, scale = 4)
	public double getTravelCosts2() {
		return this.travelCosts2;
	}

	public void setTravelCosts2(double travelCosts2) {
		this.travelCosts2 = travelCosts2;
	}

	@Column(name = "TRAVEL_COSTS_3", precision = 11, scale = 4)
	public double getTravelCosts3() {
		return this.travelCosts3;
	}

	public void setTravelCosts3(double travelCosts3) {
		this.travelCosts3 = travelCosts3;
	}

	@Column(name = "TRAVEL_COSTS_TOTAL", precision = 12, scale = 4)
	public double getTravelCostsTotal() {
		return this.travelCostsTotal;
	}

	public void setTravelCostsTotal(double travelCostsTotal) {
		this.travelCostsTotal = travelCostsTotal;
	}

	@Column(name = "MEETING_COSTS_1", precision = 11, scale = 4)
	public double getMeetingCosts1() {
		return this.meetingCosts1;
	}

	public void setMeetingCosts1(double meetingCosts1) {
		this.meetingCosts1 = meetingCosts1;
	}

	@Column(name = "MEETING_COSTS_2", precision = 11, scale = 4)
	public double getMeetingCosts2() {
		return this.meetingCosts2;
	}

	public void setMeetingCosts2(double meetingCosts2) {
		this.meetingCosts2 = meetingCosts2;
	}

	@Column(name = "MEETING_COSTS_3", precision = 11, scale = 4)
	public double getMeetingCosts3() {
		return this.meetingCosts3;
	}

	public void setMeetingCosts3(double meetingCosts3) {
		this.meetingCosts3 = meetingCosts3;
	}

	@Column(name = "MEETING_COSTS_TOTAL", precision = 12, scale = 4)
	public double getMeetingCostsTotal() {
		return this.meetingCostsTotal;
	}

	public void setMeetingCostsTotal(double meetingCostsTotal) {
		this.meetingCostsTotal = meetingCostsTotal;
	}

	@Column(name = "MANAGE_COSTS_1", precision = 11, scale = 4)
	public double getManageCosts1() {
		return this.manageCosts1;
	}

	public void setManageCosts1(double manageCosts1) {
		this.manageCosts1 = manageCosts1;
	}

	@Column(name = "MANAGE_COSTS_2", precision = 11, scale = 4)
	public double getManageCosts2() {
		return this.manageCosts2;
	}

	public void setManageCosts2(double manageCosts2) {
		this.manageCosts2 = manageCosts2;
	}

	@Column(name = "MANAGE_COSTS_3", precision = 11, scale = 4)
	public double getManageCosts3() {
		return this.manageCosts3;
	}

	public void setManageCosts3(double manageCosts3) {
		this.manageCosts3 = manageCosts3;
	}

	@Column(name = "MANAGE_COSTS_TOTAL", precision = 12, scale = 4)
	public double getManageCostsTotal() {
		return this.manageCostsTotal;
	}

	public void setManageCostsTotal(double manageCostsTotal) {
		this.manageCostsTotal = manageCostsTotal;
	}

	@Column(name = "PROJECT_MANAGER", length = 15)
	public String getProjectManager() {
		return this.projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	@Column(name = "UNIT_MANAGER", length = 15)
	public String getUnitManager() {
		return this.unitManager;
	}

	public void setUnitManager(String unitManager) {
		this.unitManager = unitManager;
	}

	@Column(name = "ACCEPTANCE_TIME")
	public Timestamp getAcceptanceTime() {
		return this.acceptanceTime;
	}

	public void setAcceptanceTime(Timestamp acceptanceTime) {
		this.acceptanceTime = acceptanceTime;
	}

	@Column(name = "ACCEPTANCE_STYLE", length = 60)
	public String getAcceptanceStyle() {
		return this.acceptanceStyle;
	}

	public void setAcceptanceStyle(String acceptanceStyle) {
		this.acceptanceStyle = acceptanceStyle;
	}

	@Column(name = "ACCEPTANCE_RESULT", length = 60)
	public String getAcceptanceResult() {
		return this.acceptanceResult;
	}

	public void setAcceptanceResult(String acceptanceResult) {
		this.acceptanceResult = acceptanceResult;
	}

	@Column(name = "ACCEPTANCE_DEPARTMENT", length = 60)
	public String getAcceptanceDepartment() {
		return this.acceptanceDepartment;
	}

	public void setAcceptanceDepartment(String acceptanceDepartment) {
		this.acceptanceDepartment = acceptanceDepartment;
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
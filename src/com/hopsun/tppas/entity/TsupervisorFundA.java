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
 * TsupervisorFundA entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_SUPERVISOR_FUND_A")
public class TsupervisorFundA implements java.io.Serializable {

	private static final long serialVersionUID = -1138405765983261992L;
	// Fields

	private String fundId;
	private Tsupervisor tsupervisor;
	private double contractIndex;
	private double realComplete;
	private double planInvestment;
	private double completeInvestment;
	private double contractSelf;
	private double realSelf;
	private double contractLoan;
	private double realLoan;
	private double realFinancial;
	private double contractFinancial;
	private double contractSupporting;
	private double realSupporting;
	private double contractOther;
	private double realOther;
	private double personnelCost;
	private double equipmentCost;
	private double energyCost;
	private double testCost;
	private double travelCost;
	private double meetingCost;
	private double managerCost;
	private double otherCost;
	private double totalCost;
	private String projectSituation;
	private Timestamp writeTime;
	private String deleteFlag;
	private String remark;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;

	// Constructors

	/** default constructor */
	public TsupervisorFundA() {
	}

	/** full constructor */
	public TsupervisorFundA(Tsupervisor tsupervisor, double contractIndex,
			double realComplete, double planInvestment,
			double completeInvestment, double contractSelf, double realSelf,
			double contractLoan, double realLoan, double realFinancial,
			double contractFinancial, double contractSupporting,
			double realSupporting, double contractOther, double realOther,
			double personnelCost, double equipmentCost, double energyCost,
			double testCost, double travelCost, double meetingCost,
			double managerCost, double otherCost, double totalCost,
			String projectSituation, Timestamp writeTime, String deleteFlag,
			String remark, Timestamp createTime, String createUser,
			Timestamp updateDate, String updateUser) {
		this.tsupervisor = tsupervisor;
		this.contractIndex = contractIndex;
		this.realComplete = realComplete;
		this.planInvestment = planInvestment;
		this.completeInvestment = completeInvestment;
		this.contractSelf = contractSelf;
		this.realSelf = realSelf;
		this.contractLoan = contractLoan;
		this.realLoan = realLoan;
		this.realFinancial = realFinancial;
		this.contractFinancial = contractFinancial;
		this.contractSupporting = contractSupporting;
		this.realSupporting = realSupporting;
		this.contractOther = contractOther;
		this.realOther = realOther;
		this.personnelCost = personnelCost;
		this.equipmentCost = equipmentCost;
		this.energyCost = energyCost;
		this.testCost = testCost;
		this.travelCost = travelCost;
		this.meetingCost = meetingCost;
		this.managerCost = managerCost;
		this.otherCost = otherCost;
		this.totalCost = totalCost;
		this.projectSituation = projectSituation;
		this.writeTime = writeTime;
		this.deleteFlag = deleteFlag;
		this.remark = remark;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "FUND_ID", unique = true, nullable = false, length = 40)
	public String getFundId() {
		return this.fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPERVISOR_ID")
	public Tsupervisor getTsupervisor() {
		return this.tsupervisor;
	}

	public void setTsupervisor(Tsupervisor tsupervisor) {
		this.tsupervisor = tsupervisor;
	}

	@Column(name = "CONTRACT_INDEX", precision = 11, scale = 4)
	public double getContractIndex() {
		return this.contractIndex;
	}

	public void setContractIndex(double contractIndex) {
		this.contractIndex = contractIndex;
	}

	@Column(name = "REAL_COMPLETE", precision = 11, scale = 4)
	public double getRealComplete() {
		return this.realComplete;
	}

	public void setRealComplete(double realComplete) {
		this.realComplete = realComplete;
	}

	@Column(name = "PLAN_INVESTMENT", precision = 11, scale = 4)
	public double getPlanInvestment() {
		return this.planInvestment;
	}

	public void setPlanInvestment(double planInvestment) {
		this.planInvestment = planInvestment;
	}

	@Column(name = "COMPLETE_INVESTMENT", precision = 11, scale = 4)
	public double getCompleteInvestment() {
		return this.completeInvestment;
	}

	public void setCompleteInvestment(double completeInvestment) {
		this.completeInvestment = completeInvestment;
	}

	@Column(name = "CONTRACT_SELF", precision = 11, scale = 4)
	public double getContractSelf() {
		return this.contractSelf;
	}

	public void setContractSelf(double contractSelf) {
		this.contractSelf = contractSelf;
	}

	@Column(name = "REAL_SELF", precision = 11, scale = 4)
	public double getRealSelf() {
		return this.realSelf;
	}

	public void setRealSelf(double realSelf) {
		this.realSelf = realSelf;
	}

	@Column(name = "CONTRACT_LOAN", precision = 11, scale = 4)
	public double getContractLoan() {
		return this.contractLoan;
	}

	public void setContractLoan(double contractLoan) {
		this.contractLoan = contractLoan;
	}

	@Column(name = "REAL_LOAN", precision = 11, scale = 4)
	public double getRealLoan() {
		return this.realLoan;
	}

	public void setRealLoan(double realLoan) {
		this.realLoan = realLoan;
	}

	@Column(name = "REAL_FINANCIAL", precision = 11, scale = 4)
	public double getRealFinancial() {
		return this.realFinancial;
	}

	public void setRealFinancial(double realFinancial) {
		this.realFinancial = realFinancial;
	}

	@Column(name = "CONTRACT_FINANCIAL", precision = 11, scale = 4)
	public double getContractFinancial() {
		return this.contractFinancial;
	}

	public void setContractFinancial(double contractFinancial) {
		this.contractFinancial = contractFinancial;
	}

	@Column(name = "CONTRACT_SUPPORTING", precision = 11, scale = 4)
	public double getContractSupporting() {
		return this.contractSupporting;
	}

	public void setContractSupporting(double contractSupporting) {
		this.contractSupporting = contractSupporting;
	}

	@Column(name = "REAL_SUPPORTING", precision = 11, scale = 4)
	public double getRealSupporting() {
		return this.realSupporting;
	}

	public void setRealSupporting(double realSupporting) {
		this.realSupporting = realSupporting;
	}

	@Column(name = "CONTRACT_OTHER", precision = 11, scale = 4)
	public double getContractOther() {
		return this.contractOther;
	}

	public void setContractOther(double contractOther) {
		this.contractOther = contractOther;
	}

	@Column(name = "REAL_OTHER", precision = 11, scale = 4)
	public double getRealOther() {
		return this.realOther;
	}

	public void setRealOther(double realOther) {
		this.realOther = realOther;
	}

	@Column(name = "PERSONNEL_COST", precision = 11, scale = 4)
	public double getPersonnelCost() {
		return this.personnelCost;
	}

	public void setPersonnelCost(double personnelCost) {
		this.personnelCost = personnelCost;
	}

	@Column(name = "EQUIPMENT_COST", precision = 11, scale = 4)
	public double getEquipmentCost() {
		return this.equipmentCost;
	}

	public void setEquipmentCost(double equipmentCost) {
		this.equipmentCost = equipmentCost;
	}

	@Column(name = "ENERGY_COST", precision = 11, scale = 4)
	public double getEnergyCost() {
		return this.energyCost;
	}

	public void setEnergyCost(double energyCost) {
		this.energyCost = energyCost;
	}

	@Column(name = "TEST_COST", precision = 11, scale = 4)
	public double getTestCost() {
		return this.testCost;
	}

	public void setTestCost(double testCost) {
		this.testCost = testCost;
	}

	@Column(name = "TRAVEL_COST", precision = 11, scale = 4)
	public double getTravelCost() {
		return this.travelCost;
	}

	public void setTravelCost(double travelCost) {
		this.travelCost = travelCost;
	}

	@Column(name = "MEETING_COST", precision = 11, scale = 4)
	public double getMeetingCost() {
		return this.meetingCost;
	}

	public void setMeetingCost(double meetingCost) {
		this.meetingCost = meetingCost;
	}

	@Column(name = "MANAGER_COST", precision = 11, scale = 4)
	public double getManagerCost() {
		return this.managerCost;
	}

	public void setManagerCost(double managerCost) {
		this.managerCost = managerCost;
	}

	@Column(name = "OTHER_COST", precision = 11, scale = 4)
	public double getOtherCost() {
		return this.otherCost;
	}

	public void setOtherCost(double otherCost) {
		this.otherCost = otherCost;
	}

	@Column(name = "TOTAL_COST", precision = 12, scale = 4)
	public double getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	@Column(name = "PROJECT_SITUATION", length = 4000)
	public String getProjectSituation() {
		return this.projectSituation;
	}

	public void setProjectSituation(String projectSituation) {
		this.projectSituation = projectSituation;
	}

	@Column(name = "WRITE_TIME")
	public Timestamp getWriteTime() {
		return this.writeTime;
	}

	public void setWriteTime(Timestamp writeTime) {
		this.writeTime = writeTime;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "REMARK", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	@Column(name = "UPDATE_DATE")
	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "UPDATE_USER", length = 50)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}
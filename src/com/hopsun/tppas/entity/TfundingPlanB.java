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
 * TfundingPlanB entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_FUNDING_PLAN_B")
public class TfundingPlanB implements java.io.Serializable {

	private static final long serialVersionUID = -6363078156711166549L;
	// Fields

	private String fundingPlanBId;
	private Tcontract tcontract;
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
	private double equipmentCost1;
	private double equipmentCost2;
	private double equipmentCost3;
	private double materialFee1;
	private double materialFee2;
	private double materialFee3;
	private double testFee1;
	private double testFee2;
	private double testFee3;
	private double fuel1;
	private double fuel2;
	private double fuel3;
	private double travel1;
	private double travel2;
	private double travel3;
	private double conferenceFees1;
	private double conferenceFees2;
	private double conferenceFees3;
	private double consultancyServices1;
	private double consultancyServices2;
	private double consultancyServices3;
	private double totalAssets;
	private double netAssets;
	private double businessNet;
	private double annualSalesRevenue;
	private double totalCorporateTax;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String remark;
	private String year;

	// Constructors

	/** default constructor */
	public TfundingPlanB() {
	}

	/** full constructor */
	public TfundingPlanB(Tcontract tcontract, double totalInvestment1,
			double totalInvestment2, double totalInvestment3,
			double partyFunding1, double partyFunding2, double partyFunding3,
			double unitRaised1, double unitRaised2, double unitRaised3,
			double otherFunds1, double otherFunds2, double otherFunds3,
			double bankLoans1, double bankLoans2, double bankLoans3,
			double equipmentCost1, double equipmentCost2,
			double equipmentCost3, double materialFee1, double materialFee2,
			double materialFee3, double testFee1, double testFee2,
			double testFee3, double fuel1, double fuel2, double fuel3,
			double travel1, double travel2, double travel3,
			double conferenceFees1, double conferenceFees2,
			double conferenceFees3, double consultancyServices1,
			double consultancyServices2, double consultancyServices3,
			double totalAssets, double netAssets, double businessNet,
			double annualSalesRevenue, double totalCorporateTax,
			String deleteFlag, Timestamp createTime, String createUser,
			Timestamp updateTime, String updateUser, String remark,
			String year) {
		this.tcontract = tcontract;
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
		this.equipmentCost1 = equipmentCost1;
		this.equipmentCost2 = equipmentCost2;
		this.equipmentCost3 = equipmentCost3;
		this.materialFee1 = materialFee1;
		this.materialFee2 = materialFee2;
		this.materialFee3 = materialFee3;
		this.testFee1 = testFee1;
		this.testFee2 = testFee2;
		this.testFee3 = testFee3;
		this.fuel1 = fuel1;
		this.fuel2 = fuel2;
		this.fuel3 = fuel3;
		this.travel1 = travel1;
		this.travel2 = travel2;
		this.travel3 = travel3;
		this.conferenceFees1 = conferenceFees1;
		this.conferenceFees2 = conferenceFees2;
		this.conferenceFees3 = conferenceFees3;
		this.consultancyServices1 = consultancyServices1;
		this.consultancyServices2 = consultancyServices2;
		this.consultancyServices3 = consultancyServices3;
		this.totalAssets = totalAssets;
		this.netAssets = netAssets;
		this.businessNet = businessNet;
		this.annualSalesRevenue = annualSalesRevenue;
		this.totalCorporateTax = totalCorporateTax;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.remark = remark;
		this.year = year;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "FUNDING_PLAN_B_ID", unique = true, nullable = false, length = 40)
	public String getFundingPlanBId() {
		return this.fundingPlanBId;
	}

	public void setFundingPlanBId(String fundingPlanBId) {
		this.fundingPlanBId = fundingPlanBId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_CONTRACT_ID")
	public Tcontract getTcontract() {
		return this.tcontract;
	}

	public void setTcontract(Tcontract tcontract) {
		this.tcontract = tcontract;
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

	@Column(name = "EQUIPMENT_COST_1", precision = 11, scale = 4)
	public double getEquipmentCost1() {
		return this.equipmentCost1;
	}

	public void setEquipmentCost1(double equipmentCost1) {
		this.equipmentCost1 = equipmentCost1;
	}

	@Column(name = "EQUIPMENT_COST_2", precision = 11, scale = 4)
	public double getEquipmentCost2() {
		return this.equipmentCost2;
	}

	public void setEquipmentCost2(double equipmentCost2) {
		this.equipmentCost2 = equipmentCost2;
	}

	@Column(name = "EQUIPMENT_COST_3", precision = 11, scale = 4)
	public double getEquipmentCost3() {
		return this.equipmentCost3;
	}

	public void setEquipmentCost3(double equipmentCost3) {
		this.equipmentCost3 = equipmentCost3;
	}

	@Column(name = "MATERIAL_FEE_1", precision = 11, scale = 4)
	public double getMaterialFee1() {
		return this.materialFee1;
	}

	public void setMaterialFee1(double materialFee1) {
		this.materialFee1 = materialFee1;
	}

	@Column(name = "MATERIAL_FEE_2", precision = 11, scale = 4)
	public double getMaterialFee2() {
		return this.materialFee2;
	}

	public void setMaterialFee2(double materialFee2) {
		this.materialFee2 = materialFee2;
	}

	@Column(name = "MATERIAL_FEE_3", precision = 11, scale = 4)
	public double getMaterialFee3() {
		return this.materialFee3;
	}

	public void setMaterialFee3(double materialFee3) {
		this.materialFee3 = materialFee3;
	}

	@Column(name = "TEST_FEE_1", precision = 11, scale = 4)
	public double getTestFee1() {
		return this.testFee1;
	}

	public void setTestFee1(double testFee1) {
		this.testFee1 = testFee1;
	}

	@Column(name = "TEST_FEE_2", precision = 11, scale = 4)
	public double getTestFee2() {
		return this.testFee2;
	}

	public void setTestFee2(double testFee2) {
		this.testFee2 = testFee2;
	}

	@Column(name = "TEST_FEE_3", precision = 11, scale = 4)
	public double getTestFee3() {
		return this.testFee3;
	}

	public void setTestFee3(double testFee3) {
		this.testFee3 = testFee3;
	}

	@Column(name = "FUEL_1", precision = 11, scale = 4)
	public double getFuel1() {
		return this.fuel1;
	}

	public void setFuel1(double fuel1) {
		this.fuel1 = fuel1;
	}

	@Column(name = "FUEL_2", precision = 11, scale = 4)
	public double getFuel2() {
		return this.fuel2;
	}

	public void setFuel2(double fuel2) {
		this.fuel2 = fuel2;
	}

	@Column(name = "FUEL_3", precision = 11, scale = 4)
	public double getFuel3() {
		return this.fuel3;
	}

	public void setFuel3(double fuel3) {
		this.fuel3 = fuel3;
	}

	@Column(name = "TRAVEL_1", precision = 11, scale = 4)
	public double getTravel1() {
		return this.travel1;
	}

	public void setTravel1(double travel1) {
		this.travel1 = travel1;
	}

	@Column(name = "TRAVEL_2", precision = 11, scale = 4)
	public double getTravel2() {
		return this.travel2;
	}

	public void setTravel2(double travel2) {
		this.travel2 = travel2;
	}

	@Column(name = "TRAVEL_3", precision = 11, scale = 4)
	public double getTravel3() {
		return this.travel3;
	}

	public void setTravel3(double travel3) {
		this.travel3 = travel3;
	}

	@Column(name = "CONFERENCE_FEES_1", precision = 11, scale = 4)
	public double getConferenceFees1() {
		return this.conferenceFees1;
	}

	public void setConferenceFees1(double conferenceFees1) {
		this.conferenceFees1 = conferenceFees1;
	}

	@Column(name = "CONFERENCE_FEES_2", precision = 11, scale = 4)
	public double getConferenceFees2() {
		return this.conferenceFees2;
	}

	public void setConferenceFees2(double conferenceFees2) {
		this.conferenceFees2 = conferenceFees2;
	}

	@Column(name = "CONFERENCE_FEES_3", precision = 11, scale = 4)
	public double getConferenceFees3() {
		return this.conferenceFees3;
	}

	public void setConferenceFees3(double conferenceFees3) {
		this.conferenceFees3 = conferenceFees3;
	}

	@Column(name = "CONSULTANCY_SERVICES_1", precision = 11, scale = 4)
	public double getConsultancyServices1() {
		return this.consultancyServices1;
	}

	public void setConsultancyServices1(double consultancyServices1) {
		this.consultancyServices1 = consultancyServices1;
	}

	@Column(name = "CONSULTANCY_SERVICES_2", precision = 11, scale = 4)
	public double getConsultancyServices2() {
		return this.consultancyServices2;
	}

	public void setConsultancyServices2(double consultancyServices2) {
		this.consultancyServices2 = consultancyServices2;
	}

	@Column(name = "CONSULTANCY_SERVICES_3", precision = 11, scale = 4)
	public double getConsultancyServices3() {
		return this.consultancyServices3;
	}

	public void setConsultancyServices3(double consultancyServices3) {
		this.consultancyServices3 = consultancyServices3;
	}

	@Column(name = "TOTAL_ASSETS", precision = 11, scale = 4)
	public double getTotalAssets() {
		return this.totalAssets;
	}

	public void setTotalAssets(double totalAssets) {
		this.totalAssets = totalAssets;
	}

	@Column(name = "NET_ASSETS", precision = 11, scale = 4)
	public double getNetAssets() {
		return this.netAssets;
	}

	public void setNetAssets(double netAssets) {
		this.netAssets = netAssets;
	}

	@Column(name = "BUSINESS_NET", precision = 11, scale = 4)
	public double getBusinessNet() {
		return this.businessNet;
	}

	public void setBusinessNet(double businessNet) {
		this.businessNet = businessNet;
	}

	@Column(name = "ANNUAL_SALES_REVENUE", precision = 11, scale = 4)
	public double getAnnualSalesRevenue() {
		return this.annualSalesRevenue;
	}

	public void setAnnualSalesRevenue(double annualSalesRevenue) {
		this.annualSalesRevenue = annualSalesRevenue;
	}

	@Column(name = "TOTAL_CORPORATE_TAX", precision = 11, scale = 4)
	public double getTotalCorporateTax() {
		return this.totalCorporateTax;
	}

	public void setTotalCorporateTax(double totalCorporateTax) {
		this.totalCorporateTax = totalCorporateTax;
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

	@Column(name = "YEAR", length = 4)
	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
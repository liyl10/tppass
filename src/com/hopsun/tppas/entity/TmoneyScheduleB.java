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
@Table(name = "T_MONEY_SCHEDULE_B")
public class TmoneyScheduleB implements java.io.Serializable {

	private static final long serialVersionUID = -6363078156711166549L;
	// Fields

	private String fundingPlanBId;
	private TprojectApplication tprojectApplication;
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
	private double equipmentCostTotal;
	private double materialFeeTotal;
	private double testFeeTotal;
	private double fuelTotal;
	private double travelTotal;
	private double conferenceFeesTotal;
	private double consultancyServicesTotal;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String remark;
	private String year;

	// Constructors

	/** default constructor */
	public TmoneyScheduleB() {
	}

	/** full constructor */
	public TmoneyScheduleB(TprojectApplication tprojectApplication,
			double equipmentCost1, double equipmentCost2,
			double equipmentCost3, double materialFee1, double materialFee2,
			double materialFee3, double testFee1, double testFee2,
			double testFee3, double fuel1, double fuel2, double fuel3,
			double travel1, double travel2, double travel3,
			double conferenceFees1, double conferenceFees2,
			double conferenceFees3, double consultancyServices1,
			double consultancyServices2, double consultancyServices3,
			double equipmentCostTotal,double materialFeeTotal,
			double testFeeTotal,double fuelTotal,
			double travelTotal,double conferenceFeesTotal,
			double consultancyServicesTotal,
			String deleteFlag, Timestamp createTime, String createUser,
			Timestamp updateTime, String updateUser, String remark,
			String year) {
		this.tprojectApplication = tprojectApplication;
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
		this.equipmentCostTotal = equipmentCostTotal;
		this.materialFeeTotal = materialFeeTotal;
		this.testFeeTotal = testFeeTotal;
		this.fuelTotal = fuelTotal;
		this.travelTotal = travelTotal;
		this.conferenceFeesTotal = conferenceFeesTotal;
		this.consultancyServicesTotal = consultancyServicesTotal;
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
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
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

	@Column(name = "EQUIPMENT_COST_TOTAL", precision = 12, scale = 4)
	public double getEquipmentCostTotal() {
		return equipmentCostTotal;
	}

	public void setEquipmentCostTotal(double equipmentCostTotal) {
		this.equipmentCostTotal = equipmentCostTotal;
	}

	@Column(name = "MATERIAL_FEE_TOTAL", precision = 12, scale = 4)
	public double getMaterialFeeTotal() {
		return materialFeeTotal;
	}

	public void setMaterialFeeTotal(double materialFeeTotal) {
		this.materialFeeTotal = materialFeeTotal;
	}

	@Column(name = "TEST_FEE_TOTAL", precision = 12, scale = 4)
	public double getTestFeeTotal() {
		return testFeeTotal;
	}

	public void setTestFeeTotal(double testFeeTotal) {
		this.testFeeTotal = testFeeTotal;
	}

	@Column(name = "FUEL_TOTAL", precision = 12, scale = 4)
	public double getFuelTotal() {
		return fuelTotal;
	}

	public void setFuelTotal(double fuelTotal) {
		this.fuelTotal = fuelTotal;
	}

	@Column(name = "TRAVEL_TOTAL", precision = 12, scale = 4)
	public double getTravelTotal() {
		return travelTotal;
	}

	public void setTravelTotal(double travelTotal) {
		this.travelTotal = travelTotal;
	}

	@Column(name = "CONFERENCE_FEES_TOTAL", precision = 12, scale = 4)
	public double getConferenceFeesTotal() {
		return conferenceFeesTotal;
	}

	public void setConferenceFeesTotal(double conferenceFeesTotal) {
		this.conferenceFeesTotal = conferenceFeesTotal;
	}

	@Column(name = "CONSULTANCY_SERVICES_TOTAL", precision = 12, scale = 4)
	public double getConsultancyServicesTotal() {
		return consultancyServicesTotal;
	}

	public void setConsultancyServicesTotal(double consultancyServicesTotal) {
		this.consultancyServicesTotal = consultancyServicesTotal;
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
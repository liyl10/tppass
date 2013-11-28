package com.hopsun.tppas.entity;

import java.math.BigDecimal;
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
 * TsupervisorFundB entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_SUPERVISOR_FUND_B")
public class TsupervisorFundB implements java.io.Serializable {

	private static final long serialVersionUID = 8919774225981040952L;
	// Fields

	private String fundBId;
	private Tsupervisor tsupervisor;
	private BigDecimal planTotal;
	private BigDecimal planCity;
	private BigDecimal planCompany;
	private BigDecimal planBank;
	private BigDecimal planOther;
	private BigDecimal realTotal;
	private BigDecimal realCity;
	private BigDecimal realCompany;
	private BigDecimal realBank;
	private BigDecimal realOther;
	private BigDecimal personnelTotalCost;
	private BigDecimal equipmentTotalCost;
	private BigDecimal energyTotalCost;
	private BigDecimal testTotalCost;
	private BigDecimal travelTotalCost;
	private BigDecimal surveyTotalCost;
	private BigDecimal meetingTotalCost;
	private BigDecimal managerTotalCost;
	private BigDecimal otherTotalCost;
	private BigDecimal personnelCityCost;
	private BigDecimal equipmentCityCost;
	private BigDecimal energyCityCost;
	private BigDecimal testCityCost;
	private BigDecimal travelCityCost;
	private BigDecimal surveyCityCost;
	private BigDecimal meetingCityCost;
	private BigDecimal managerCityCost;
	private BigDecimal otherCityCost;
	private String commentInfo;
	private String deleteFlag;
	private String remark;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;

	// Constructors

	/** default constructor */
	public TsupervisorFundB() {
	}

	/** full constructor */
	public TsupervisorFundB(Tsupervisor tsupervisor, BigDecimal planTotal,
			BigDecimal planCity, BigDecimal planCompany, BigDecimal planBank,
			BigDecimal planOther, BigDecimal realTotal, BigDecimal realCity,
			BigDecimal realCompany, BigDecimal realBank, BigDecimal realOther,
			BigDecimal personnelTotalCost, BigDecimal equipmentTotalCost,
			BigDecimal energyTotalCost, BigDecimal testTotalCost,
			BigDecimal travelTotalCost, BigDecimal surveyTotalCost,
			BigDecimal meetingTotalCost, BigDecimal managerTotalCost,
			BigDecimal otherTotalCost, BigDecimal personnelCityCost,
			BigDecimal equipmentCityCost, BigDecimal energyCityCost,
			BigDecimal testCityCost, BigDecimal travelCityCost, BigDecimal surveyCityCost,
			BigDecimal meetingCityCost, BigDecimal managerCityCost,
			BigDecimal otherCityCost, String commentInfo, String deleteFlag,
			String remark, Timestamp createTime, String createUser,
			Timestamp updateDate, String updateUser) {
		this.tsupervisor = tsupervisor;
		this.planTotal = planTotal;
		this.planCity = planCity;
		this.planCompany = planCompany;
		this.planBank = planBank;
		this.planOther = planOther;
		this.realTotal = realTotal;
		this.realCity = realCity;
		this.realCompany = realCompany;
		this.realBank = realBank;
		this.realOther = realOther;
		this.personnelTotalCost = personnelTotalCost;
		this.equipmentTotalCost = equipmentTotalCost;
		this.energyTotalCost = energyTotalCost;
		this.testTotalCost = testTotalCost;
		this.travelTotalCost = travelTotalCost;
		this.surveyTotalCost = surveyTotalCost;
		this.meetingTotalCost = meetingTotalCost;
		this.managerTotalCost = managerTotalCost;
		this.otherTotalCost = otherTotalCost;
		this.personnelCityCost = personnelCityCost;
		this.equipmentCityCost = equipmentCityCost;
		this.energyCityCost = energyCityCost;
		this.testCityCost = testCityCost;
		this.travelCityCost = travelCityCost;
		this.surveyCityCost = surveyCityCost;
		this.meetingCityCost = meetingCityCost;
		this.managerCityCost = managerCityCost;
		this.otherCityCost = otherCityCost;
		this.commentInfo = commentInfo;
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
	@Column(name = "FUND_B_ID", unique = true, nullable = false, length = 40)
	public String getFundBId() {
		return this.fundBId;
	}

	public void setFundBId(String fundBId) {
		this.fundBId = fundBId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPERVISOR_ID")
	public Tsupervisor getTsupervisor() {
		return this.tsupervisor;
	}

	public void setTsupervisor(Tsupervisor tsupervisor) {
		this.tsupervisor = tsupervisor;
	}

	@Column(name = "PLAN_TOTAL", precision = 11, scale = 4)
	public BigDecimal getPlanTotal() {
		return this.planTotal;
	}

	public void setPlanTotal(BigDecimal planTotal) {
		this.planTotal = planTotal;
	}

	@Column(name = "PLAN_CITY", precision = 11, scale = 4)
	public BigDecimal getPlanCity() {
		return this.planCity;
	}

	public void setPlanCity(BigDecimal planCity) {
		this.planCity = planCity;
	}

	@Column(name = "PLAN_COMPANY", precision = 11, scale = 4)
	public BigDecimal getPlanCompany() {
		return this.planCompany;
	}

	public void setPlanCompany(BigDecimal planCompany) {
		this.planCompany = planCompany;
	}

	@Column(name = "PLAN_BANK", precision = 11, scale = 4)
	public BigDecimal getPlanBank() {
		return this.planBank;
	}

	public void setPlanBank(BigDecimal planBank) {
		this.planBank = planBank;
	}

	@Column(name = "PLAN_OTHER", precision = 11, scale = 4)
	public BigDecimal getPlanOther() {
		return this.planOther;
	}

	public void setPlanOther(BigDecimal planOther) {
		this.planOther = planOther;
	}

	@Column(name = "REAL_TOTAL", precision = 11, scale = 4)
	public BigDecimal getRealTotal() {
		return this.realTotal;
	}

	public void setRealTotal(BigDecimal realTotal) {
		this.realTotal = realTotal;
	}

	@Column(name = "REAL_CITY", precision = 11, scale = 4)
	public BigDecimal getRealCity() {
		return this.realCity;
	}

	public void setRealCity(BigDecimal realCity) {
		this.realCity = realCity;
	}

	@Column(name = "REAL_COMPANY", precision = 11, scale = 4)
	public BigDecimal getRealCompany() {
		return this.realCompany;
	}

	public void setRealCompany(BigDecimal realCompany) {
		this.realCompany = realCompany;
	}

	@Column(name = "REAL_BANK", precision = 11, scale = 4)
	public BigDecimal getRealBank() {
		return this.realBank;
	}

	public void setRealBank(BigDecimal realBank) {
		this.realBank = realBank;
	}

	@Column(name = "REAL_OTHER", precision = 11, scale = 4)
	public BigDecimal getRealOther() {
		return this.realOther;
	}

	public void setRealOther(BigDecimal realOther) {
		this.realOther = realOther;
	}

	@Column(name = "PERSONNEL_TOTAL_COST", precision = 11, scale = 4)
	public BigDecimal getPersonnelTotalCost() {
		return this.personnelTotalCost;
	}

	public void setPersonnelTotalCost(BigDecimal personnelTotalCost) {
		this.personnelTotalCost = personnelTotalCost;
	}

	@Column(name = "EQUIPMENT_TOTAL_COST", precision = 11, scale = 4)
	public BigDecimal getEquipmentTotalCost() {
		return this.equipmentTotalCost;
	}

	public void setEquipmentTotalCost(BigDecimal equipmentTotalCost) {
		this.equipmentTotalCost = equipmentTotalCost;
	}

	@Column(name = "ENERGY_TOTAL_COST", precision = 11, scale = 4)
	public BigDecimal getEnergyTotalCost() {
		return this.energyTotalCost;
	}

	public void setEnergyTotalCost(BigDecimal energyTotalCost) {
		this.energyTotalCost = energyTotalCost;
	}

	@Column(name = "TEST_TOTAL_COST", precision = 11, scale = 4)
	public BigDecimal getTestTotalCost() {
		return this.testTotalCost;
	}

	public void setTestTotalCost(BigDecimal testTotalCost) {
		this.testTotalCost = testTotalCost;
	}

	@Column(name = "TRAVEL_TOTAL_COST", precision = 11, scale = 4)
	public BigDecimal getTravelTotalCost() {
		return this.travelTotalCost;
	}

	public void setTravelTotalCost(BigDecimal travelTotalCost) {
		this.travelTotalCost = travelTotalCost;
	}

	@Column(name = "SURVEY_TOTAL_COST", precision = 11, scale = 4)
	public BigDecimal getSurveyTotalCost() {
		return this.surveyTotalCost;
	}

	public void setSurveyTotalCost(BigDecimal surveyTotalCost) {
		this.surveyTotalCost = surveyTotalCost;
	}

	@Column(name = "MEETING_TOTAL_COST", precision = 11, scale = 4)
	public BigDecimal getMeetingTotalCost() {
		return this.meetingTotalCost;
	}

	public void setMeetingTotalCost(BigDecimal meetingTotalCost) {
		this.meetingTotalCost = meetingTotalCost;
	}

	@Column(name = "MANAGER_TOTAL_COST", precision = 11, scale = 4)
	public BigDecimal getManagerTotalCost() {
		return this.managerTotalCost;
	}

	public void setManagerTotalCost(BigDecimal managerTotalCost) {
		this.managerTotalCost = managerTotalCost;
	}

	@Column(name = "OTHER_TOTAL_COST", precision = 11, scale = 4)
	public BigDecimal getOtherTotalCost() {
		return this.otherTotalCost;
	}

	public void setOtherTotalCost(BigDecimal otherTotalCost) {
		this.otherTotalCost = otherTotalCost;
	}

	@Column(name = "PERSONNEL_CITY_COST", precision = 11, scale = 4)
	public BigDecimal getPersonnelCityCost() {
		return this.personnelCityCost;
	}

	public void setPersonnelCityCost(BigDecimal personnelCityCost) {
		this.personnelCityCost = personnelCityCost;
	}

	@Column(name = "EQUIPMENT_CITY_COST", precision = 11, scale = 4)
	public BigDecimal getEquipmentCityCost() {
		return this.equipmentCityCost;
	}

	public void setEquipmentCityCost(BigDecimal equipmentCityCost) {
		this.equipmentCityCost = equipmentCityCost;
	}

	@Column(name = "ENERGY_CITY_COST", precision = 11, scale = 4)
	public BigDecimal getEnergyCityCost() {
		return this.energyCityCost;
	}

	public void setEnergyCityCost(BigDecimal energyCityCost) {
		this.energyCityCost = energyCityCost;
	}

	@Column(name = "TEST_CITY_COST", precision = 11, scale = 4)
	public BigDecimal getTestCityCost() {
		return this.testCityCost;
	}

	public void setTestCityCost(BigDecimal testCityCost) {
		this.testCityCost = testCityCost;
	}

	@Column(name = "TRAVEL_CITY_COST", precision = 11, scale = 4)
	public BigDecimal getTravelCityCost() {
		return this.travelCityCost;
	}

	public void setTravelCityCost(BigDecimal travelCityCost) {
		this.travelCityCost = travelCityCost;
	}

	@Column(name = "SURVEY_CITY_COST", precision = 11, scale = 4)
	public BigDecimal getSurveyCityCost() {
		return this.surveyCityCost;
	}

	public void setSurveyCityCost(BigDecimal surveyCityCost) {
		this.surveyCityCost = surveyCityCost;
	}

	@Column(name = "MEETING_CITY_COST", precision = 11, scale = 4)
	public BigDecimal getMeetingCityCost() {
		return this.meetingCityCost;
	}

	public void setMeetingCityCost(BigDecimal meetingCityCost) {
		this.meetingCityCost = meetingCityCost;
	}

	@Column(name = "MANAGER_CITY_COST", precision = 11, scale = 4)
	public BigDecimal getManagerCityCost() {
		return this.managerCityCost;
	}

	public void setManagerCityCost(BigDecimal managerCityCost) {
		this.managerCityCost = managerCityCost;
	}

	@Column(name = "OTHER_CITY_COST", precision = 11, scale = 4)
	public BigDecimal getOtherCityCost() {
		return this.otherCityCost;
	}

	public void setOtherCityCost(BigDecimal otherCityCost) {
		this.otherCityCost = otherCityCost;
	}

	@Column(name = "COMMENT_INFO", length = 4000)
	public String getCommentInfo() {
		return this.commentInfo;
	}

	public void setCommentInfo(String commentInfo) {
		this.commentInfo = commentInfo;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "REMARK", length = 1000)
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
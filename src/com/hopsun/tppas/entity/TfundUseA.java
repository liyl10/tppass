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
 * TfundUseA entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_FUND_USE_A")
public class TfundUseA implements java.io.Serializable {
	
	private static final long serialVersionUID = 6400086023543525180L;

	// Fields
	private String fundUseId;
	private Tcontract tcontract;
	private BigDecimal equipmentSpecial;
	private BigDecimal equipmentSupport;
	private BigDecimal purchaseSpecial;
	private BigDecimal purchaseSupport;
	private BigDecimal trialSpecial;
	private BigDecimal trialSupport;
	private BigDecimal renovationSpecial;
	private BigDecimal renovationSupport;
	private BigDecimal materialSpecial;
	private BigDecimal materialSupport;
	private BigDecimal testSpecial;
	private BigDecimal testSupport;
	private BigDecimal meetSpecial;
	private BigDecimal meetSupport;
	private BigDecimal cooperationSpecial;
	private BigDecimal cooperationSupport;
	private BigDecimal publishSpecial;
	private BigDecimal publishSupport;
	private BigDecimal expertSpecial;
	private BigDecimal expertSupport;
	private BigDecimal otherSpecial;
	private BigDecimal otherSupport;
	private String accountName;
	private String account;
	private String bank;
	private Timestamp selectDate;
	private Timestamp createTime;
	private Timestamp updateTime;
	private String deleteFlag;
	private String createUser;
	private String updateUser;
	private String remark;

	// Constructors

	/** default constructor */
	public TfundUseA() {
	}

	/** full constructor */
	public TfundUseA(Tcontract tcontract, BigDecimal equipmentSpecial,
			BigDecimal equipmentSupport, BigDecimal purchaseSpecial,
			BigDecimal purchaseSupport, BigDecimal trialSpecial, BigDecimal trialSupport,
			BigDecimal renovationSpecial, BigDecimal renovationSupport,
			BigDecimal materialSpecial, BigDecimal materialSupport, BigDecimal testSpecial,
			BigDecimal testSupport, BigDecimal meetSpecial, BigDecimal meetSupport,
			BigDecimal cooperationSpecial, BigDecimal cooperationSupport,
			BigDecimal publishSpecial, BigDecimal publishSupport, BigDecimal expertSpecial,
			BigDecimal expertSupport, BigDecimal otherSpecial, BigDecimal otherSupport,
			String accountName, String account, String bank, Timestamp selectDate,
			Timestamp createTime, Timestamp updateTime, String deleteFlag,
			String createUser, String updateUser, String remark) {
		this.tcontract = tcontract;
		this.equipmentSpecial = equipmentSpecial;
		this.equipmentSupport = equipmentSupport;
		this.purchaseSpecial = purchaseSpecial;
		this.purchaseSupport = purchaseSupport;
		this.trialSpecial = trialSpecial;
		this.trialSupport = trialSupport;
		this.renovationSpecial = renovationSpecial;
		this.renovationSupport = renovationSupport;
		this.materialSpecial = materialSpecial;
		this.materialSupport = materialSupport;
		this.testSpecial = testSpecial;
		this.testSupport = testSupport;
		this.meetSpecial = meetSpecial;
		this.meetSupport = meetSupport;
		this.cooperationSpecial = cooperationSpecial;
		this.cooperationSupport = cooperationSupport;
		this.publishSpecial = publishSpecial;
		this.publishSupport = publishSupport;
		this.expertSpecial = expertSpecial;
		this.expertSupport = expertSupport;
		this.otherSpecial = otherSpecial;
		this.otherSupport = otherSupport;
		this.accountName = accountName;
		this.account = account;
		this.bank = bank;
		this.selectDate = selectDate;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.deleteFlag = deleteFlag;
		this.createUser = createUser;
		this.updateUser = updateUser;
		this.remark = remark;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "FUND_USE_ID", unique = true, nullable = false, length = 40)
	public String getFundUseId() {
		return this.fundUseId;
	}

	public void setFundUseId(String fundUseId) {
		this.fundUseId = fundUseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_CONTRACT_ID")
	public Tcontract getTcontract() {
		return this.tcontract;
	}

	public void setTcontract(Tcontract tcontract) {
		this.tcontract = tcontract;
	}

	@Column(name = "EQUIPMENT_SPECIAL", precision = 12, scale = 4)
	public BigDecimal getEquipmentSpecial() {
		return this.equipmentSpecial;
	}

	public void setEquipmentSpecial(BigDecimal equipmentSpecial) {
		this.equipmentSpecial = equipmentSpecial;
	}

	@Column(name = "EQUIPMENT_SUPPORT", precision = 12, scale = 4)
	public BigDecimal getEquipmentSupport() {
		return this.equipmentSupport;
	}

	public void setEquipmentSupport(BigDecimal equipmentSupport) {
		this.equipmentSupport = equipmentSupport;
	}

	@Column(name = "PURCHASE_SPECIAL", precision = 11, scale = 4)
	public BigDecimal getPurchaseSpecial() {
		return this.purchaseSpecial;
	}

	public void setPurchaseSpecial(BigDecimal purchaseSpecial) {
		this.purchaseSpecial = purchaseSpecial;
	}

	@Column(name = "PURCHASE_SUPPORT", precision = 11, scale = 4)
	public BigDecimal getPurchaseSupport() {
		return this.purchaseSupport;
	}

	public void setPurchaseSupport(BigDecimal purchaseSupport) {
		this.purchaseSupport = purchaseSupport;
	}

	@Column(name = "TRIAL_SPECIAL", precision = 11, scale = 4)
	public BigDecimal getTrialSpecial() {
		return this.trialSpecial;
	}

	public void setTrialSpecial(BigDecimal trialSpecial) {
		this.trialSpecial = trialSpecial;
	}

	@Column(name = "TRIAL_SUPPORT", precision = 11, scale = 4)
	public BigDecimal getTrialSupport() {
		return this.trialSupport;
	}

	public void setTrialSupport(BigDecimal trialSupport) {
		this.trialSupport = trialSupport;
	}

	@Column(name = "RENOVATION_SPECIAL", precision = 11, scale = 4)
	public BigDecimal getRenovationSpecial() {
		return this.renovationSpecial;
	}

	public void setRenovationSpecial(BigDecimal renovationSpecial) {
		this.renovationSpecial = renovationSpecial;
	}

	@Column(name = "RENOVATION_SUPPORT", precision = 11, scale = 4)
	public BigDecimal getRenovationSupport() {
		return this.renovationSupport;
	}

	public void setRenovationSupport(BigDecimal renovationSupport) {
		this.renovationSupport = renovationSupport;
	}

	@Column(name = "MATERIAL_SPECIAL", precision = 11, scale = 4)
	public BigDecimal getMaterialSpecial() {
		return this.materialSpecial;
	}

	public void setMaterialSpecial(BigDecimal materialSpecial) {
		this.materialSpecial = materialSpecial;
	}

	@Column(name = "MATERIAL_SUPPORT", precision = 11, scale = 4)
	public BigDecimal getMaterialSupport() {
		return this.materialSupport;
	}

	public void setMaterialSupport(BigDecimal materialSupport) {
		this.materialSupport = materialSupport;
	}

	@Column(name = "TEST_SPECIAL", precision = 11, scale = 4)
	public BigDecimal getTestSpecial() {
		return this.testSpecial;
	}

	public void setTestSpecial(BigDecimal testSpecial) {
		this.testSpecial = testSpecial;
	}

	@Column(name = "TEST_SUPPORT", precision = 11, scale = 4)
	public BigDecimal getTestSupport() {
		return this.testSupport;
	}

	public void setTestSupport(BigDecimal testSupport) {
		this.testSupport = testSupport;
	}

	@Column(name = "MEET_SPECIAL", precision = 11, scale = 4)
	public BigDecimal getMeetSpecial() {
		return this.meetSpecial;
	}

	public void setMeetSpecial(BigDecimal meetSpecial) {
		this.meetSpecial = meetSpecial;
	}

	@Column(name = "MEET_SUPPORT", precision = 11, scale = 4)
	public BigDecimal getMeetSupport() {
		return this.meetSupport;
	}

	public void setMeetSupport(BigDecimal meetSupport) {
		this.meetSupport = meetSupport;
	}

	@Column(name = "COOPERATION_SPECIAL", precision = 11, scale = 4)
	public BigDecimal getCooperationSpecial() {
		return this.cooperationSpecial;
	}

	public void setCooperationSpecial(BigDecimal cooperationSpecial) {
		this.cooperationSpecial = cooperationSpecial;
	}

	@Column(name = "COOPERATION_SUPPORT", precision = 11, scale = 4)
	public BigDecimal getCooperationSupport() {
		return this.cooperationSupport;
	}

	public void setCooperationSupport(BigDecimal cooperationSupport) {
		this.cooperationSupport = cooperationSupport;
	}

	@Column(name = "PUBLISH_SPECIAL", precision = 11, scale = 4)
	public BigDecimal getPublishSpecial() {
		return this.publishSpecial;
	}

	public void setPublishSpecial(BigDecimal publishSpecial) {
		this.publishSpecial = publishSpecial;
	}

	@Column(name = "PUBLISH_SUPPORT", precision = 11, scale = 4)
	public BigDecimal getPublishSupport() {
		return this.publishSupport;
	}

	public void setPublishSupport(BigDecimal publishSupport) {
		this.publishSupport = publishSupport;
	}

	@Column(name = "EXPERT_SPECIAL", precision = 11, scale = 4)
	public BigDecimal getExpertSpecial() {
		return this.expertSpecial;
	}

	public void setExpertSpecial(BigDecimal expertSpecial) {
		this.expertSpecial = expertSpecial;
	}

	@Column(name = "EXPERT_SUPPORT", precision = 11, scale = 4)
	public BigDecimal getExpertSupport() {
		return this.expertSupport;
	}

	public void setExpertSupport(BigDecimal expertSupport) {
		this.expertSupport = expertSupport;
	}

	@Column(name = "OTHER_SPECIAL", precision = 11, scale = 4)
	public BigDecimal getOtherSpecial() {
		return this.otherSpecial;
	}

	public void setOtherSpecial(BigDecimal otherSpecial) {
		this.otherSpecial = otherSpecial;
	}

	@Column(name = "OTHER_SUPPORT", precision = 11, scale = 4)
	public BigDecimal getOtherSupport() {
		return this.otherSupport;
	}

	public void setOtherSupport(BigDecimal otherSupport) {
		this.otherSupport = otherSupport;
	}

	@Column(name = "ACCOUNT_NAME", length = 200)
	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Column(name = "ACCOUNT", length = 30)
	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "BANK", length = 60)
	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	@Column(name = "SELECT_DATE")
	public Timestamp getSelectDate() {
		return this.selectDate;
	}

	public void setSelectDate(Timestamp selectDate) {
		this.selectDate = selectDate;
	}

	@Column(name = "CREATE_TIME")
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
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

	@Column(name = "CREATE_USER", length = 50)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
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
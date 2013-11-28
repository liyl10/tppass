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
 * TcontractCoverA entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_CONTRACT_COVER_A")
public class TcontractCoverA implements java.io.Serializable {

	private static final long serialVersionUID = 1355477964099144480L;
	// Fields
	private String contractCoverId;
	private Tcontract tcontract;
	private String authorized;
	private String commitmentUnit;
	private String centralizedManagement;
	private Timestamp startDate;
	private Timestamp endDate;
	private String address1;
	private String address2;
	private String address3;
	private String address;
	private String unitCharge;
	private String unitChargePhone1;
	private String unitChargePhone2;
	private String charge;
	private String chargePhone1;
	private String chargePhone2;
	private String contact;
	private String contactPhone1;
	private String contactPhone2;
	private Timestamp updateTime;
	private String deleteFlag;
	private Timestamp contractTime;
	private String contractComment;
	private Timestamp createTime;
	private String createUser;
	private String updateUser;
	private String topicTitle;

	// Constructors

	/** default constructor */
	public TcontractCoverA() {
	}

	/** full constructor */
	public TcontractCoverA(Tcontract tcontract, String authorized,
			String commitmentUnit, String centralizedManagement,
			Timestamp startDate, Timestamp endDate, String address1, String address2,
			String address3, String address, String unitCharge,
			String unitChargePhone1, String unitChargePhone2, String charge,
			String chargePhone1, String chargePhone2, String contact,
			String contactPhone1, String contactPhone2, Timestamp updateTime,
			String deleteFlag, Timestamp contractTime, String contractComment,
			Timestamp createTime, String createUser, String updateUser,
			String topicTitle) {
		this.tcontract = tcontract;
		this.authorized = authorized;
		this.commitmentUnit = commitmentUnit;
		this.centralizedManagement = centralizedManagement;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.address = address;
		this.unitCharge = unitCharge;
		this.unitChargePhone1 = unitChargePhone1;
		this.unitChargePhone2 = unitChargePhone2;
		this.charge = charge;
		this.chargePhone1 = chargePhone1;
		this.chargePhone2 = chargePhone2;
		this.contact = contact;
		this.contactPhone1 = contactPhone1;
		this.contactPhone2 = contactPhone2;
		this.updateTime = updateTime;
		this.deleteFlag = deleteFlag;
		this.contractTime = contractTime;
		this.contractComment = contractComment;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateUser = updateUser;
		this.topicTitle = topicTitle;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CONTRACT_COVER_ID", unique = true, nullable = false, length = 40)
	public String getContractCoverId() {
		return this.contractCoverId;
	}

	public void setContractCoverId(String contractCoverId) {
		this.contractCoverId = contractCoverId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_CONTRACT_ID")
	public Tcontract getTcontract() {
		return this.tcontract;
	}

	public void setTcontract(Tcontract tcontract) {
		this.tcontract = tcontract;
	}

	@Column(name = "AUTHORIZED", length = 100)
	public String getAuthorized() {
		return this.authorized;
	}

	public void setAuthorized(String authorized) {
		this.authorized = authorized;
	}

	@Column(name = "COMMITMENT_UNIT", length = 100)
	public String getCommitmentUnit() {
		return this.commitmentUnit;
	}

	public void setCommitmentUnit(String commitmentUnit) {
		this.commitmentUnit = commitmentUnit;
	}

	@Column(name = "CENTRALIZED_MANAGEMENT", length = 100)
	public String getCentralizedManagement() {
		return this.centralizedManagement;
	}

	public void setCentralizedManagement(String centralizedManagement) {
		this.centralizedManagement = centralizedManagement;
	}

	@Column(name = "START_DATE")
	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	@Column(name = "END_DATE")
	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	@Column(name = "ADDRESS_1", length = 10)
	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "ADDRESS_2", length = 10)
	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "ADDRESS_3", length = 10)
	public String getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	@Column(name = "ADDRESS", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "UNIT_CHARGE", length = 120)
	public String getUnitCharge() {
		return this.unitCharge;
	}

	public void setUnitCharge(String unitCharge) {
		this.unitCharge = unitCharge;
	}

	@Column(name = "UNIT_CHARGE_PHONE1", length = 20)
	public String getUnitChargePhone1() {
		return this.unitChargePhone1;
	}

	public void setUnitChargePhone1(String unitChargePhone1) {
		this.unitChargePhone1 = unitChargePhone1;
	}

	@Column(name = "UNIT_CHARGE_PHONE2", length = 15)
	public String getUnitChargePhone2() {
		return this.unitChargePhone2;
	}

	public void setUnitChargePhone2(String unitChargePhone2) {
		this.unitChargePhone2 = unitChargePhone2;
	}

	@Column(name = "CHARGE", length = 120)
	public String getCharge() {
		return this.charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	@Column(name = "CHARGE_PHONE1", length = 20)
	public String getChargePhone1() {
		return this.chargePhone1;
	}

	public void setChargePhone1(String chargePhone1) {
		this.chargePhone1 = chargePhone1;
	}

	@Column(name = "CHARGE_PHONE2", length = 15)
	public String getChargePhone2() {
		return this.chargePhone2;
	}

	public void setChargePhone2(String chargePhone2) {
		this.chargePhone2 = chargePhone2;
	}

	@Column(name = "CONTACT", length = 120)
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "CONTACT_PHONE1", length = 20)
	public String getContactPhone1() {
		return this.contactPhone1;
	}

	public void setContactPhone1(String contactPhone1) {
		this.contactPhone1 = contactPhone1;
	}

	@Column(name = "CONTACT_PHONE2", length = 15)
	public String getContactPhone2() {
		return this.contactPhone2;
	}

	public void setContactPhone2(String contactPhone2) {
		this.contactPhone2 = contactPhone2;
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

	@Column(name = "CONTRACT_TIME")
	public Timestamp getContractTime() {
		return this.contractTime;
	}

	public void setContractTime(Timestamp contractTime) {
		this.contractTime = contractTime;
	}

	@Column(name = "CONTRACT_COMMENT", length = 4000)
	public String getContractComment() {
		return this.contractComment;
	}

	public void setContractComment(String contractComment) {
		this.contractComment = contractComment;
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

	@Column(name = "UPDATE_USER", length = 50)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Column(name = "TOPIC_TITLE", length = 100)
	public String getTopicTitle() {
		return this.topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

}
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
 * TeconomicIndicatorsB entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ECONOMIC_INDICATORS_B")
public class TeconomicIndicatorsB implements java.io.Serializable {

	private static final long serialVersionUID = -6606923958024772346L;
	// Fields
	private String economicIndicatorsBId;
	private Tcontract tcontract;
	private double outputValue;
	private double payTaxes;
	private double retainedProfits;
	private double earnMoney;
	private double outputValue1;
	private double payTaxes1;
	private double retainedProfits1;
	private double earnMoney1;
	private double outputValue2;
	private double payTaxes2;
	private double retainedProfits2;
	private double earnMoney2;
	private double totalOutputValue;
	private double totalPayTaxes;
	private double totalRetainedProfits;
	private double totalEarnMoney;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String remark;

	// Constructors

	/** default constructor */
	public TeconomicIndicatorsB() {
	}

	/** full constructor */
	public TeconomicIndicatorsB(Tcontract tcontract,
			double outputValue, double payTaxes, double retainedProfits,
			double earnMoney, double outputValue1, double payTaxes1,
			double retainedProfits1, double earnMoney1, double outputValue2,
			double payTaxes2, double retainedProfits2, double earnMoney2,
			double totalOutputValue, double totalPayTaxes,
			double totalRetainedProfits, double totalEarnMoney,
			String deleteFlag, Timestamp createTime, String createUser,
			Timestamp updateTime, String updateUser, String remark) {
		this.tcontract = tcontract;
		this.outputValue = outputValue;
		this.payTaxes = payTaxes;
		this.retainedProfits = retainedProfits;
		this.earnMoney = earnMoney;
		this.outputValue1 = outputValue1;
		this.payTaxes1 = payTaxes1;
		this.retainedProfits1 = retainedProfits1;
		this.earnMoney1 = earnMoney1;
		this.outputValue2 = outputValue2;
		this.payTaxes2 = payTaxes2;
		this.retainedProfits2 = retainedProfits2;
		this.earnMoney2 = earnMoney2;
		this.totalOutputValue = totalOutputValue;
		this.totalPayTaxes = totalPayTaxes;
		this.totalRetainedProfits = totalRetainedProfits;
		this.totalEarnMoney = totalEarnMoney;
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
	@Column(name = "ECONOMIC_INDICATORS_B_ID", unique = true, nullable = false, length = 40)
	public String getEconomicIndicatorsBId() {
		return this.economicIndicatorsBId;
	}

	public void setEconomicIndicatorsBId(String economicIndicatorsBId) {
		this.economicIndicatorsBId = economicIndicatorsBId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_CONTRACT_ID")
	public Tcontract getTcontract() {
		return this.tcontract;
	}

	public void setTcontract(Tcontract tcontract) {
		this.tcontract = tcontract;
	}
	
	@Column(name = "OUTPUT_VALUE", precision = 11, scale = 4)
	public double getOutputValue() {
		return this.outputValue;
	}

	public void setOutputValue(double outputValue) {
		this.outputValue = outputValue;
	}

	@Column(name = "PAY_TAXES", precision = 11, scale = 4)
	public double getPayTaxes() {
		return this.payTaxes;
	}

	public void setPayTaxes(double payTaxes) {
		this.payTaxes = payTaxes;
	}

	@Column(name = "RETAINED_PROFITS", precision = 11, scale = 4)
	public double getRetainedProfits() {
		return this.retainedProfits;
	}

	public void setRetainedProfits(double retainedProfits) {
		this.retainedProfits = retainedProfits;
	}

	@Column(name = "EARN_MONEY", precision = 11, scale = 4)
	public double getEarnMoney() {
		return this.earnMoney;
	}

	public void setEarnMoney(double earnMoney) {
		this.earnMoney = earnMoney;
	}

	@Column(name = "OUTPUT_VALUE_1", precision = 11, scale = 4)
	public double getOutputValue1() {
		return this.outputValue1;
	}

	public void setOutputValue1(double outputValue1) {
		this.outputValue1 = outputValue1;
	}

	@Column(name = "PAY_TAXES_1", precision = 11, scale = 4)
	public double getPayTaxes1() {
		return this.payTaxes1;
	}

	public void setPayTaxes1(double payTaxes1) {
		this.payTaxes1 = payTaxes1;
	}

	@Column(name = "RETAINED_PROFITS_1", precision = 11, scale = 4)
	public double getRetainedProfits1() {
		return this.retainedProfits1;
	}

	public void setRetainedProfits1(double retainedProfits1) {
		this.retainedProfits1 = retainedProfits1;
	}

	@Column(name = "EARN_MONEY_1", precision = 11, scale = 4)
	public double getEarnMoney1() {
		return this.earnMoney1;
	}

	public void setEarnMoney1(double earnMoney1) {
		this.earnMoney1 = earnMoney1;
	}

	@Column(name = "OUTPUT_VALUE_2", precision = 11, scale = 4)
	public double getOutputValue2() {
		return this.outputValue2;
	}

	public void setOutputValue2(double outputValue2) {
		this.outputValue2 = outputValue2;
	}

	@Column(name = "PAY_TAXES_2", precision = 11, scale = 4)
	public double getPayTaxes2() {
		return this.payTaxes2;
	}

	public void setPayTaxes2(double payTaxes2) {
		this.payTaxes2 = payTaxes2;
	}

	@Column(name = "RETAINED_PROFITS_2", precision = 11, scale = 4)
	public double getRetainedProfits2() {
		return this.retainedProfits2;
	}

	public void setRetainedProfits2(double retainedProfits2) {
		this.retainedProfits2 = retainedProfits2;
	}

	@Column(name = "EARN_MONEY_2", precision = 11, scale = 4)
	public double getEarnMoney2() {
		return this.earnMoney2;
	}

	public void setEarnMoney2(double earnMoney2) {
		this.earnMoney2 = earnMoney2;
	}

	@Column(name = "TOTAL_OUTPUT_VALUE", precision = 11, scale = 4)
	public double getTotalOutputValue() {
		return this.totalOutputValue;
	}

	public void setTotalOutputValue(double totalOutputValue) {
		this.totalOutputValue = totalOutputValue;
	}

	@Column(name = "TOTAL_PAY_TAXES", precision = 11, scale = 4)
	public double getTotalPayTaxes() {
		return this.totalPayTaxes;
	}

	public void setTotalPayTaxes(double totalPayTaxes) {
		this.totalPayTaxes = totalPayTaxes;
	}

	@Column(name = "TOTAL_RETAINED_PROFITS", precision = 11, scale = 4)
	public double getTotalRetainedProfits() {
		return this.totalRetainedProfits;
	}

	public void setTotalRetainedProfits(double totalRetainedProfits) {
		this.totalRetainedProfits = totalRetainedProfits;
	}

	@Column(name = "TOTAL_EARN_MONEY", precision = 11, scale = 4)
	public double getTotalEarnMoney() {
		return this.totalEarnMoney;
	}

	public void setTotalEarnMoney(double totalEarnMoney) {
		this.totalEarnMoney = totalEarnMoney;
	}

	@Column(name = "DELETE_FLAG", length = 1)
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

	@Column(name = "CREATE_USER", length = 40)
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

	@Column(name = "UPDATE_USER", length = 40)
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
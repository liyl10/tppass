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
 * TeconomicIndicatorA entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ECONOMIC_INDICATOR_A")
public class TeconomicIndicatorA implements java.io.Serializable {

	private static final long serialVersionUID = 5061599414437674637L;
	// Fields
	private String economicIndicatorId;
	private TprojectApplication tprojectApplication;
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
	private String remark;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String year1;
	private String year2;
	private String year3;
	private double assetSize;
	private double assetSize1;
	private double assetSize2;
	private int newEmployment;
	private int newEmployment1;
	private int newEmployment2;
	private double newInvest;
	private double newInvest1;
	private double newInvest2;
	// Constructors

	/** default constructor */
	public TeconomicIndicatorA() {
	}

	/** full constructor */
	public TeconomicIndicatorA(TprojectApplication tprojectApplication,
			double outputValue, double payTaxes, double retainedProfits,
			double earnMoney, double outputValue1, double payTaxes1,
			double retainedProfits1, double earnMoney1, double outputValue2,
			double payTaxes2, double retainedProfits2, double earnMoney2,
			String remark, String deleteFlag, Timestamp createTime,
			String createUser, Timestamp updateTime, String updateUser,
			double newInvest2, double newInvest1, double newInvest,
			double assetSize2, double assetSize1, double assetSize,
			int newEmployment2, int newEmployment1, int newEmployment,
			String year1, String year2, String year3) {
		this.tprojectApplication = tprojectApplication;
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
		this.remark = remark;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.year1 = year1;
		this.year2 = year2;
		this.year3 = year3;
		this.assetSize = assetSize;
		this.assetSize1 = assetSize1;
		this.assetSize2 = assetSize2;
		this.newEmployment = newEmployment;
		this.newEmployment1 = newEmployment1;
		this.newEmployment2 = newEmployment2;
		this.newInvest = newInvest;
		this.newInvest1 = newInvest1;
		this.newInvest2 = newInvest2;
		
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ECONOMIC_INDICATOR_ID", unique = true, nullable = false, length = 40)
	public String getEconomicIndicatorId() {
		return this.economicIndicatorId;
	}

	public void setEconomicIndicatorId(String economicIndicatorId) {
		this.economicIndicatorId = economicIndicatorId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
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

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
	
	@Column(name = "YEAR1", length = 4)
	public String getYear1() {
		return year1;
	}

	public void setYear1(String year1) {
		this.year1 = year1;
	}

	@Column(name = "YEAR2", length = 4)
	public String getYear2() {
		return year2;
	}

	public void setYear2(String year2) {
		this.year2 = year2;
	}

	@Column(name = "YEAR3", length = 4)
	public String getYear3() {
		return year3;
	}

	public void setYear3(String year3) {
		this.year3 = year3;
	}
	
	@Column(name = "ASSET_SIZE", precision = 12, scale = 4)
	public double getAssetSize() {
		return assetSize;
	}

	public void setAssetSize(double assetSize) {
		this.assetSize = assetSize;
	}

	@Column(name = "ASSET_SIZE1", precision = 12, scale = 4)
	public double getAssetSize1() {
		return assetSize1;
	}

	public void setAssetSize1(double assetSize1) {
		this.assetSize1 = assetSize1;
	}

	@Column(name = "ASSET_SIZE2", precision = 12, scale = 4)
	public double getAssetSize2() {
		return assetSize2;
	}

	public void setAssetSize2(double assetSize2) {
		this.assetSize2 = assetSize2;
	}

	@Column(name = "NEW_EMPLOYMENT")
	public int getNewEmployment() {
		return newEmployment;
	}

	public void setNewEmployment(int newEmployment) {
		this.newEmployment = newEmployment;
	}

	@Column(name = "NEW_EMPLOYMENT1")
	public int getNewEmployment1() {
		return newEmployment1;
	}

	public void setNewEmployment1(int newEmployment1) {
		this.newEmployment1 = newEmployment1;
	}
	
	@Column(name = "NEW_EMPLOYMENT2")
	public int getNewEmployment2() {
		return newEmployment2;
	}

	public void setNewEmployment2(int newEmployment2) {
		this.newEmployment2 = newEmployment2;
	}

	@Column(name = "NEW_INVEST", precision = 12, scale = 4)
	public double getNewInvest() {
		return newInvest;
	}

	public void setNewInvest(double newInvest) {
		this.newInvest = newInvest;
	}

	@Column(name = "NEW_INVEST1", precision = 12, scale = 4)
	public double getNewInvest1() {
		return newInvest1;
	}

	public void setNewInvest1(double newInvest1) {
		this.newInvest1 = newInvest1;
	}

	@Column(name = "NEW_INVEST2", precision = 12, scale = 4)
	public double getNewInvest2() {
		return newInvest2;
	}
	
	public void setNewInvest2(double newInvest2) {
		this.newInvest2 = newInvest2;
	}

}
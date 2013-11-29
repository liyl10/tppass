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
 * TmoneyScheduleA entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_MONEY_SCHEDULE_A")
public class TmoneyScheduleA implements java.io.Serializable {

	private static final long serialVersionUID = -7643858287296519763L;
	// Fields
	
	private String moneyScheduleId;
	private TprojectApplication tprojectApplication;
	private double paymentAmount;
	private double specialAmount;
	private double otherFunds;
	private double paymentAmount1;
	private double specialAmount1;
	private double otherFunds1;
	private double paymentAmount2;
	private double specialAmount2;
	private double otherFunds2;
	private double paymentAmountTotal;
	private double specialAmountTotal;
	private double otherFundsTotal;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String remark;
	private String year1;
	private String year2;
	private String year3;

	// Constructors

	/** default constructor */
	public TmoneyScheduleA() {
	}

	/** full constructor */
	public TmoneyScheduleA(TprojectApplication tprojectApplication,
			double paymentAmount, double specialAmount, double otherFunds,
			double paymentAmount1, double specialAmount1, double otherFunds1,
			double paymentAmount2, double specialAmount2, double otherFunds2,
			double paymentAmountTotal, double specialAmountTotal,
			double otherFundsTotal, String deleteFlag, Timestamp createTime,
			String createUser, Timestamp updateTime, String updateUser,
			String remark, String year1, String year2, String year3) {
		this.tprojectApplication = tprojectApplication;
		this.paymentAmount = paymentAmount;
		this.specialAmount = specialAmount;
		this.otherFunds = otherFunds;
		this.paymentAmount1 = paymentAmount1;
		this.specialAmount1 = specialAmount1;
		this.otherFunds1 = otherFunds1;
		this.paymentAmount2 = paymentAmount2;
		this.specialAmount2 = specialAmount2;
		this.otherFunds2 = otherFunds2;
		this.paymentAmountTotal = paymentAmountTotal;
		this.specialAmountTotal = specialAmountTotal;
		this.otherFundsTotal = otherFundsTotal;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.remark = remark;
		this.year1 = year1;
		this.year2 = year2;
		this.year3 = year3;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "MONEY_SCHEDULE_ID", unique = true, nullable = false, length = 40)
	public String getMoneyScheduleId() {
		return this.moneyScheduleId;
	}

	public void setMoneyScheduleId(String moneyScheduleId) {
		this.moneyScheduleId = moneyScheduleId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "PAYMENT_AMOUNT", precision = 15, scale = 4)
	public double getPaymentAmount() {
		return this.paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	@Column(name = "SPECIAL_AMOUNT", precision = 15, scale = 4)
	public double getSpecialAmount() {
		return this.specialAmount;
	}

	public void setSpecialAmount(double specialAmount) {
		this.specialAmount = specialAmount;
	}

	@Column(name = "OTHER_FUNDS", precision = 15, scale = 4)
	public double getOtherFunds() {
		return this.otherFunds;
	}

	public void setOtherFunds(double otherFunds) {
		this.otherFunds = otherFunds;
	}

	@Column(name = "PAYMENT_AMOUNT_1", precision = 15, scale = 4)
	public double getPaymentAmount1() {
		return this.paymentAmount1;
	}

	public void setPaymentAmount1(double paymentAmount1) {
		this.paymentAmount1 = paymentAmount1;
	}

	@Column(name = "SPECIAL_AMOUNT_1", precision = 15, scale = 4)
	public double getSpecialAmount1() {
		return this.specialAmount1;
	}

	public void setSpecialAmount1(double specialAmount1) {
		this.specialAmount1 = specialAmount1;
	}

	@Column(name = "OTHER_FUNDS_1", precision = 15, scale = 4)
	public double getOtherFunds1() {
		return this.otherFunds1;
	}

	public void setOtherFunds1(double otherFunds1) {
		this.otherFunds1 = otherFunds1;
	}

	@Column(name = "PAYMENT_AMOUNT_2", precision = 15, scale = 4)
	public double getPaymentAmount2() {
		return this.paymentAmount2;
	}

	public void setPaymentAmount2(double paymentAmount2) {
		this.paymentAmount2 = paymentAmount2;
	}

	@Column(name = "SPECIAL_AMOUNT_2", precision = 15, scale = 4)
	public double getSpecialAmount2() {
		return this.specialAmount2;
	}

	public void setSpecialAmount2(double specialAmount2) {
		this.specialAmount2 = specialAmount2;
	}

	@Column(name = "OTHER_FUNDS_2", precision = 15, scale = 4)
	public double getOtherFunds2() {
		return this.otherFunds2;
	}

	public void setOtherFunds2(double otherFunds2) {
		this.otherFunds2 = otherFunds2;
	}

	@Column(name = "PAYMENT_AMOUNT_TOTAL", precision = 15, scale = 4)
	public double getPaymentAmountTotal() {
		return this.paymentAmountTotal;
	}

	public void setPaymentAmountTotal(double paymentAmountTotal) {
		this.paymentAmountTotal = paymentAmountTotal;
	}

	@Column(name = "SPECIAL_AMOUNT_TOTAL", precision = 15, scale = 4)
	public double getSpecialAmountTotal() {
		return this.specialAmountTotal;
	}

	public void setSpecialAmountTotal(double specialAmountTotal) {
		this.specialAmountTotal = specialAmountTotal;
	}

	@Column(name = "OTHER_FUNDS_TOTAL", precision = 15, scale = 4)
	public double getOtherFundsTotal() {
		return this.otherFundsTotal;
	}

	public void setOtherFundsTotal(double otherFundsTotal) {
		this.otherFundsTotal = otherFundsTotal;
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

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "YEAR_1", length = 10)
	public String getYear1() {
		return year1;
	}

	public void setYear1(String year1) {
		this.year1 = year1;
	}
	
	@Column(name = "YEAR_2", length = 10)
	public String getYear2() {
		return year2;
	}

	public void setYear2(String year2) {
		this.year2 = year2;
	}

	@Column(name = "YEAR_3", length = 10)
	public String getYear3() {
		return year3;
	}

	public void setYear3(String year3) {
		this.year3 = year3;
	}
}
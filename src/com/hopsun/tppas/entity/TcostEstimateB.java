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
 * TcostEstimateB entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_COST_ESTIMATE_B")
public class TcostEstimateB implements java.io.Serializable {

	private static final long serialVersionUID = -2488684784977535298L;
	// Fields
	private String costEstimateId;
	private TprojectApplication tprojectApplication;
	private double totalInvestment;
	private double applicationSpecial;
	private double selfRaisedFunds;
	private double bankersCredit;
	private double otherFunds;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String remark;
	private double totalBankersCredit;
	private double supportFunds;
	
	// Constructors

	/** default constructor */
	public TcostEstimateB() {
	}

	/** full constructor */
	public TcostEstimateB(TprojectApplication tprojectApplication,
			double totalInvestment, double applicationSpecial,
			double selfRaisedFunds, double bankersCredit, double otherFunds,
			String deleteFlag, Timestamp createTime, String createUser,
			Timestamp updateTime, String updateUser, String remark,
			double totalBankersCredit,double supportFunds) {
		this.tprojectApplication = tprojectApplication;
		this.totalInvestment = totalInvestment;
		this.applicationSpecial = applicationSpecial;
		this.selfRaisedFunds = selfRaisedFunds;
		this.bankersCredit = bankersCredit;
		this.otherFunds = otherFunds;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.remark = remark;
		this.totalBankersCredit = totalBankersCredit;
		this.supportFunds = supportFunds;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "COST_ESTIMATE_ID", unique = true, nullable = false, length = 40)
	public String getCostEstimateId() {
		return this.costEstimateId;
	}

	public void setCostEstimateId(String costEstimateId) {
		this.costEstimateId = costEstimateId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "TOTAL_INVESTMENT", precision = 11, scale = 4)
	public double getTotalInvestment() {
		return this.totalInvestment;
	}

	public void setTotalInvestment(double totalInvestment) {
		this.totalInvestment = totalInvestment;
	}

	@Column(name = "APPLICATION_SPECIAL", precision = 11, scale = 4)
	public double getApplicationSpecial() {
		return this.applicationSpecial;
	}

	public void setApplicationSpecial(double applicationSpecial) {
		this.applicationSpecial = applicationSpecial;
	}

	@Column(name = "SELF_RAISED_FUNDS", precision = 11, scale = 4)
	public double getSelfRaisedFunds() {
		return this.selfRaisedFunds;
	}

	public void setSelfRaisedFunds(double selfRaisedFunds) {
		this.selfRaisedFunds = selfRaisedFunds;
	}

	@Column(name = "BANKERS_CREDIT", precision = 11, scale = 4)
	public double getBankersCredit() {
		return this.bankersCredit;
	}

	public void setBankersCredit(double bankersCredit) {
		this.bankersCredit = bankersCredit;
	}

	@Column(name = "OTHER_FUNDS", precision = 11, scale = 4)
	public double getOtherFunds() {
		return this.otherFunds;
	}

	public void setOtherFunds(double otherFunds) {
		this.otherFunds = otherFunds;
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

	@Column(name = "TOTAL_BANKERS_CREDIT", precision = 11, scale = 4)
	public double getTotalBankersCredit() {
		return totalBankersCredit;
	}

	public void setTotalBankersCredit(double totalBankersCredit) {
		this.totalBankersCredit = totalBankersCredit;
	}
	
	@Column(name = "SUPPORT_FUNDS", precision = 11, scale = 4)
	public double getSupportFunds() {
		return supportFunds;
	}

	public void setSupportFunds(double supportFunds) {
		this.supportFunds = supportFunds;
	}
}
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
 * TfundsPlanB entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_FUNDS_PLAN_A")
public class TfundsPlanA implements java.io.Serializable {

	private static final long serialVersionUID = 3772069788048379022L;
	// Fields

	private String fundsPlanId;
	private TcontractContentsA tcontractContentsA;
	private BigDecimal fundsPlanYuan;
	private String deleteFlag;
	private String fundsPlanMonth;
	private String fundsPlanYear;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String remark;

	// Constructors

	/** default constructor */
	public TfundsPlanA() {
	}

	/** full constructor */
	public TfundsPlanA(TcontractContentsA tcontractContentsA,
			BigDecimal fundsPlanYuan, String deleteFlag, String fundsPlanMonth,
			String fundsPlanYear, Timestamp createTime, String createUser,
			Timestamp updateTime, String updateUser, String remark) {
		this.tcontractContentsA = tcontractContentsA;
		this.fundsPlanYuan = fundsPlanYuan;
		this.deleteFlag = deleteFlag;
		this.fundsPlanMonth = fundsPlanMonth;
		this.fundsPlanYear = fundsPlanYear;
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
	@Column(name = "FUNDS_PLAN_ID", unique = true, nullable = false, length = 40)
	public String getFundsPlanId() {
		return this.fundsPlanId;
	}

	public void setFundsPlanId(String fundsPlanId) {
		this.fundsPlanId = fundsPlanId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONTRACT_CONTENTS_ID")
	public TcontractContentsA getTcontractContentsA() {
		return this.tcontractContentsA;
	}

	public void setTcontractContentsA(TcontractContentsA tcontractContentsA) {
		this.tcontractContentsA = tcontractContentsA;
	}

	@Column(name = "FUNDS_PLAN_YUAN", precision = 11, scale = 4)
	public BigDecimal getFundsPlanYuan() {
		return this.fundsPlanYuan;
	}

	public void setFundsPlanYuan(BigDecimal fundsPlanYuan) {
		this.fundsPlanYuan = fundsPlanYuan;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "FUNDS_PLAN_MONTH", length = 2)
	public String getFundsPlanMonth() {
		return this.fundsPlanMonth;
	}

	public void setFundsPlanMonth(String fundsPlanMonth) {
		this.fundsPlanMonth = fundsPlanMonth;
	}

	@Column(name = "FUNDS_PLAN_YEAR", length = 4)
	public String getFundsPlanYear() {
		return this.fundsPlanYear;
	}

	public void setFundsPlanYear(String fundsPlanYear) {
		this.fundsPlanYear = fundsPlanYear;
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

}
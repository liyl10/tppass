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
 * TcompanyDevelopInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_COMPANY_DEVELOP_INFO")
public class TcompanyDevelopInfo implements java.io.Serializable {
	
	private static final long serialVersionUID = -8033793740319985001L;

	// Fields
	private String companyDevelopInfoId;
	private Tsupervisor tsupervisor;
	private BigDecimal companyOutput;
	private BigDecimal companySell;
	private BigDecimal companyProfit;
	private BigDecimal companyTax;
	private String companyDevelopComment;
	private String deleteFlag;
	private String remark;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;
	private BigDecimal companyExport;

	// Constructors

	/** default constructor */
	public TcompanyDevelopInfo() {
	}

	/** full constructor */
	public TcompanyDevelopInfo(Tsupervisor tsupervisor, BigDecimal companyOutput,
			BigDecimal companySell, BigDecimal companyProfit, BigDecimal companyTax,
			String companyDevelopComment, String deleteFlag, String remark,
			Timestamp createTime, String createUser, Timestamp updateDate,
			String updateUser,BigDecimal companyExport) {
		this.tsupervisor = tsupervisor;
		this.companyOutput = companyOutput;
		this.companySell = companySell;
		this.companyProfit = companyProfit;
		this.companyTax = companyTax;
		this.companyDevelopComment = companyDevelopComment;
		this.deleteFlag = deleteFlag;
		this.remark = remark;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.companyExport = companyExport;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "COMPANY_DEVELOP_INFO_ID", unique = true, nullable = false, length = 40)
	public String getCompanyDevelopInfoId() {
		return this.companyDevelopInfoId;
	}

	public void setCompanyDevelopInfoId(String companyDevelopInfoId) {
		this.companyDevelopInfoId = companyDevelopInfoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPERVISOR_ID")
	public Tsupervisor getTsupervisor() {
		return this.tsupervisor;
	}

	public void setTsupervisor(Tsupervisor tsupervisor) {
		this.tsupervisor = tsupervisor;
	}

	@Column(name = "COMPANY_OUTPUT", precision = 11, scale = 4)
	public BigDecimal getCompanyOutput() {
		return this.companyOutput;
	}

	public void setCompanyOutput(BigDecimal companyOutput) {
		this.companyOutput = companyOutput;
	}

	@Column(name = "COMPANY_SELL", precision = 11, scale = 4)
	public BigDecimal getCompanySell() {
		return this.companySell;
	}

	public void setCompanySell(BigDecimal companySell) {
		this.companySell = companySell;
	}

	@Column(name = "COMPANY_PROFIT", precision = 11, scale = 4)
	public BigDecimal getCompanyProfit() {
		return this.companyProfit;
	}

	public void setCompanyProfit(BigDecimal companyProfit) {
		this.companyProfit = companyProfit;
	}

	@Column(name = "COMPANY_TAX", precision = 11, scale = 4)
	public BigDecimal getCompanyTax() {
		return this.companyTax;
	}

	public void setCompanyTax(BigDecimal companyTax) {
		this.companyTax = companyTax;
	}

	@Column(name = "COMPANY_DEVELOP_COMMENT", length = 4000)
	public String getCompanyDevelopComment() {
		return this.companyDevelopComment;
	}

	public void setCompanyDevelopComment(String companyDevelopComment) {
		this.companyDevelopComment = companyDevelopComment;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "REMARK", length = 100)
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

	@Column(name = "COMPANY_EXPORT", precision = 11, scale = 4)
	public BigDecimal getCompanyExport() {
		return companyExport;
	}

	public void setCompanyExport(BigDecimal companyExport) {
		this.companyExport = companyExport;
	}

}
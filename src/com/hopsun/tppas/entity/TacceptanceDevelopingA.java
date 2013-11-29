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
 * TacceptanceDevelopingA entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ACCEPTANCE_DEVELOPING_A")
public class TacceptanceDevelopingA implements java.io.Serializable {

	private static final long serialVersionUID = -2878853772727146453L;
	// Fields

	private String developingId;
	private Tacceptance tacceptance;
	private double projectTotal;
	private double projectNet;
	private double projectExport;
	private double projectSales;
	private double projectTaxableTotal;
	private double projectRdInvestment;
	private double acceptanceTotal;
	private double acceptanceNet;
	private double acceptanceExport;
	private double acceptanceSales;
	private double acceptanceTaxableTotal;
	private double acceptanceRdInvestment;
	private Timestamp stampTime;
	private String createUser;
	private Timestamp createTime;
	private String updateUser;
	private Timestamp updateTime;
	private String deleteFlag;

	// Constructors

	/** default constructor */
	public TacceptanceDevelopingA() {
	}

	/** full constructor */
	public TacceptanceDevelopingA(Tacceptance tacceptance, double projectTotal,
			double projectNet, double projectExport, double projectSales,
			double projectTaxableTotal, double projectRdInvestment,
			double acceptanceTotal, double acceptanceNet,
			double acceptanceExport, double acceptanceSales,
			double acceptanceTaxableTotal, double acceptanceRdInvestment,
			Timestamp stampTime, String createUser, Timestamp createTime,
			String updateUser, Timestamp updateTime, String deleteFlag) {
		this.tacceptance = tacceptance;
		this.projectTotal = projectTotal;
		this.projectNet = projectNet;
		this.projectExport = projectExport;
		this.projectSales = projectSales;
		this.projectTaxableTotal = projectTaxableTotal;
		this.projectRdInvestment = projectRdInvestment;
		this.acceptanceTotal = acceptanceTotal;
		this.acceptanceNet = acceptanceNet;
		this.acceptanceExport = acceptanceExport;
		this.acceptanceSales = acceptanceSales;
		this.acceptanceTaxableTotal = acceptanceTaxableTotal;
		this.acceptanceRdInvestment = acceptanceRdInvestment;
		this.stampTime = stampTime;
		this.createUser = createUser;
		this.createTime = createTime;
		this.updateUser = updateUser;
		this.updateTime = updateTime;
		this.deleteFlag = deleteFlag;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "DEVELOPING_ID", unique = true, nullable = false, length = 40)
	public String getDevelopingId() {
		return this.developingId;
	}

	public void setDevelopingId(String developingId) {
		this.developingId = developingId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCEPTANCE_ID")
	public Tacceptance getTacceptance() {
		return this.tacceptance;
	}

	public void setTacceptance(Tacceptance tacceptance) {
		this.tacceptance = tacceptance;
	}

	@Column(name = "PROJECT_TOTAL", precision = 11, scale = 4)
	public double getProjectTotal() {
		return this.projectTotal;
	}

	public void setProjectTotal(double projectTotal) {
		this.projectTotal = projectTotal;
	}

	@Column(name = "PROJECT_NET", precision = 11, scale = 4)
	public double getProjectNet() {
		return this.projectNet;
	}

	public void setProjectNet(double projectNet) {
		this.projectNet = projectNet;
	}

	@Column(name = "PROJECT_EXPORT", precision = 11, scale = 4)
	public double getProjectExport() {
		return this.projectExport;
	}

	public void setProjectExport(double projectExport) {
		this.projectExport = projectExport;
	}

	@Column(name = "PROJECT_SALES", precision = 11, scale = 4)
	public double getProjectSales() {
		return this.projectSales;
	}

	public void setProjectSales(double projectSales) {
		this.projectSales = projectSales;
	}

	@Column(name = "PROJECT_TAXABLE_TOTAL", precision = 11, scale = 4)
	public double getProjectTaxableTotal() {
		return this.projectTaxableTotal;
	}

	public void setProjectTaxableTotal(double projectTaxableTotal) {
		this.projectTaxableTotal = projectTaxableTotal;
	}

	@Column(name = "PROJECT_RD_INVESTMENT", precision = 11, scale = 4)
	public double getProjectRdInvestment() {
		return this.projectRdInvestment;
	}

	public void setProjectRdInvestment(double projectRdInvestment) {
		this.projectRdInvestment = projectRdInvestment;
	}

	@Column(name = "ACCEPTANCE_TOTAL", precision = 11, scale = 4)
	public double getAcceptanceTotal() {
		return this.acceptanceTotal;
	}

	public void setAcceptanceTotal(double acceptanceTotal) {
		this.acceptanceTotal = acceptanceTotal;
	}

	@Column(name = "ACCEPTANCE_NET", precision = 11, scale = 4)
	public double getAcceptanceNet() {
		return this.acceptanceNet;
	}

	public void setAcceptanceNet(double acceptanceNet) {
		this.acceptanceNet = acceptanceNet;
	}

	@Column(name = "ACCEPTANCE_EXPORT", precision = 11, scale = 4)
	public double getAcceptanceExport() {
		return this.acceptanceExport;
	}

	public void setAcceptanceExport(double acceptanceExport) {
		this.acceptanceExport = acceptanceExport;
	}

	@Column(name = "ACCEPTANCE_SALES", precision = 11, scale = 4)
	public double getAcceptanceSales() {
		return this.acceptanceSales;
	}

	public void setAcceptanceSales(double acceptanceSales) {
		this.acceptanceSales = acceptanceSales;
	}

	@Column(name = "ACCEPTANCE_TAXABLE_TOTAL", precision = 11, scale = 4)
	public double getAcceptanceTaxableTotal() {
		return this.acceptanceTaxableTotal;
	}

	public void setAcceptanceTaxableTotal(double acceptanceTaxableTotal) {
		this.acceptanceTaxableTotal = acceptanceTaxableTotal;
	}

	@Column(name = "ACCEPTANCE_RD_INVESTMENT", precision = 11, scale = 4)
	public double getAcceptanceRdInvestment() {
		return this.acceptanceRdInvestment;
	}

	public void setAcceptanceRdInvestment(double acceptanceRdInvestment) {
		this.acceptanceRdInvestment = acceptanceRdInvestment;
	}

	@Column(name = "STAMP_TIME")
	public Timestamp getStampTime() {
		return this.stampTime;
	}

	public void setStampTime(Timestamp stampTime) {
		this.stampTime = stampTime;
	}

	@Column(name = "CREATE_USER", length = 40)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "CREATE_TIME")
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "UPDATE_USER", length = 40)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
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

}
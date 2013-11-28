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
 * TtechnicalCompleteInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_TECHNICAL_COMPLETE_INFO")
public class TtechnicalCompleteInfo implements java.io.Serializable {

	private static final long serialVersionUID = -7470992598671086775L;
	// Fields

	private String technicalCompleteInfo;
	private Tsupervisor tsupervisor;
	private String technicalContractRequire;
	private String realCompleteInfo;
	private String deleteFlag;
	private String remark;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;

	// Constructors

	/** default constructor */
	public TtechnicalCompleteInfo() {
	}

	/** full constructor */
	public TtechnicalCompleteInfo(Tsupervisor tsupervisor,
			String technicalContractRequire, String realCompleteInfo,
			String deleteFlag, String remark, Timestamp createTime,
			String createUser, Timestamp updateDate, String updateUser) {
		this.tsupervisor = tsupervisor;
		this.technicalContractRequire = technicalContractRequire;
		this.realCompleteInfo = realCompleteInfo;
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
	@Column(name = "TECHNICAL_COMPLETE_INFO", unique = true, nullable = false, length = 40)
	public String getTechnicalCompleteInfo() {
		return this.technicalCompleteInfo;
	}

	public void setTechnicalCompleteInfo(String technicalCompleteInfo) {
		this.technicalCompleteInfo = technicalCompleteInfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPERVISOR_ID")
	public Tsupervisor getTsupervisor() {
		return tsupervisor;
	}

	public void setTsupervisor(Tsupervisor tsupervisor) {
		this.tsupervisor = tsupervisor;
	}

	@Column(name = "TECHNICAL_CONTRACT_REQUIRE", length = 1000)
	public String getTechnicalContractRequire() {
		return this.technicalContractRequire;
	}

	public void setTechnicalContractRequire(String technicalContractRequire) {
		this.technicalContractRequire = technicalContractRequire;
	}

	@Column(name = "REAL_COMPLETE_INFO", length = 1000)
	public String getRealCompleteInfo() {
		return this.realCompleteInfo;
	}

	public void setRealCompleteInfo(String realCompleteInfo) {
		this.realCompleteInfo = realCompleteInfo;
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

}
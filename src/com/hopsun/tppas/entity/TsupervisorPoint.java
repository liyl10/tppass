package com.hopsun.tppas.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TsupervisorPoint entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_SUPERVISOR_POINT")
public class TsupervisorPoint implements java.io.Serializable {

	private static final long serialVersionUID = -5544266199894096654L;
	// Fields

	private String pointId;
	private Tsupervisor tsupervisor;
	private TsupervisorReport tsupervisorReport;
	private String pointContent;
	private Timestamp pointTime;
	private Timestamp writeTime;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;

	// Constructors

	/** default constructor */
	public TsupervisorPoint() {
	}

	/** full constructor */
	public TsupervisorPoint(Tsupervisor tsupervisor, TsupervisorReport tsupervisorReport,String pointContent,
			Timestamp pointTime, Timestamp writeTime, String deleteFlag,
			Timestamp createTime, String createUser, Timestamp updateDate,
			String updateUser) {
		this.tsupervisor = tsupervisor;
		this.tsupervisorReport= tsupervisorReport;
		this.pointContent = pointContent;
		this.pointTime = pointTime;
		this.writeTime = writeTime;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "POINT_ID", unique = true, nullable = false, length = 40)
	public String getPointId() {
		return this.pointId;
	}

	public void setPointId(String pointId) {
		this.pointId = pointId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPERVISOR_ID")
	public Tsupervisor getTsupervisor() {
		return this.tsupervisor;
	}

	public void setTsupervisor(Tsupervisor tsupervisor) {
		this.tsupervisor = tsupervisor;
	}

	@OneToOne(mappedBy="tsupervisorPoint")   
	public TsupervisorReport getTsupervisorReport() {
		return tsupervisorReport;
	}

	public void setTsupervisorReport(TsupervisorReport tsupervisorReport) {
		this.tsupervisorReport = tsupervisorReport;
	}

	@Column(name = "POINT_CONTENT", length = 4000)
	public String getPointContent() {
		return this.pointContent;
	}

	public void setPointContent(String pointContent) {
		this.pointContent = pointContent;
	}

	@Column(name = "POINT_TIME")
	public Timestamp getPointTime() {
		return this.pointTime;
	}

	public void setPointTime(Timestamp pointTime) {
		this.pointTime = pointTime;
	}

	@Column(name = "WRITE_TIME")
	public Timestamp getWriteTime() {
		return this.writeTime;
	}

	public void setWriteTime(Timestamp writeTime) {
		this.writeTime = writeTime;
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
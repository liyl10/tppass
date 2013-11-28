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
 * TprojectManagementInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_PROJECT_MANAGEMENT_INFO")
public class TprojectManagementInfo implements java.io.Serializable {

	private static final long serialVersionUID = 2662421544203072908L;
	// Fields

	private String projectManagementInfoId;
	private Tsupervisor tsupervisor;
	private String projectManagementComment;
	private String deleteFlag;
	private String remark;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;

	// Constructors

	/** default constructor */
	public TprojectManagementInfo() {
	}

	/** full constructor */
	public TprojectManagementInfo(Tsupervisor tsupervisor,
			String projectManagementComment, String deleteFlag, String remark,
			Timestamp createTime, String createUser, Timestamp updateDate,
			String updateUser) {
		this.tsupervisor = tsupervisor;
		this.projectManagementComment = projectManagementComment;
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
	@Column(name = "PROJECT_MANAGEMENT_INFO_ID", unique = true, nullable = false, length = 40)
	public String getProjectManagementInfoId() {
		return this.projectManagementInfoId;
	}

	public void setProjectManagementInfoId(String projectManagementInfoId) {
		this.projectManagementInfoId = projectManagementInfoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPERVISOR_ID")
	public Tsupervisor getTsupervisor() {
		return this.tsupervisor;
	}

	public void setTsupervisor(Tsupervisor tsupervisor) {
		this.tsupervisor = tsupervisor;
	}

	@Column(name = "PROJECT_MANAGEMENT_COMMENT", length = 4000)
	public String getProjectManagementComment() {
		return this.projectManagementComment;
	}

	public void setProjectManagementComment(String projectManagementComment) {
		this.projectManagementComment = projectManagementComment;
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
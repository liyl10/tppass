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
 * TprojectLeaderB entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_PROJECT_LEADER_A")
public class TprojectLeaderA implements java.io.Serializable {

	private static final long serialVersionUID = -8879569027074898228L;
	// Fields

	private String projectLeaderAId;
	private TprojectApplication tprojectApplication;
	private String name;
	private String sex;
	private String age;
	private String jobTitle;
	private String specialty;
	private String task;
	private String unit;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String remark;
	private int revealOrder;

	// Constructors

	/** default constructor */
	public TprojectLeaderA() {
	}

	/** full constructor */
	public TprojectLeaderA(TprojectApplication tprojectApplication, String name,
			String sex, String age, String jobTitle, String specialty,
			String task, String unit, String deleteFlag, Timestamp createTime,
			String createUser, Timestamp updateTime, String updateUser,
			String remark, int revealOrder) {
		this.tprojectApplication = tprojectApplication;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.jobTitle = jobTitle;
		this.specialty = specialty;
		this.task = task;
		this.unit = unit;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.remark = remark;
		this.revealOrder = revealOrder;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PROJECT_LEADER_A_ID", unique = true, nullable = false, length = 40)
	public String getProjectLeaderAId() {
		return this.projectLeaderAId;
	}

	public void setProjectLeaderAId(String projectLeaderAId) {
		this.projectLeaderAId = projectLeaderAId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_TPROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "NAME", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SEX", length = 40)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "AGE", length = 3)
	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Column(name = "JOB_TITLE", length = 100)
	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Column(name = "SPECIALTY", length = 100)
	public String getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	@Column(name = "TASK", length = 500)
	public String getTask() {
		return this.task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	@Column(name = "UNIT", length = 500)
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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
	
	@Column(name = "REVEAL_ORDER", length = 3)
	public int getRevealOrder() {
		return revealOrder;
	}

	public void setRevealOrder(int revealOrder) {
		this.revealOrder = revealOrder;
	}

}
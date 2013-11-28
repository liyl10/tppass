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
 * Tresearcher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RESEARCHER")
public class Tresearcher implements java.io.Serializable {

	private static final long serialVersionUID = -4656676465604618020L;
	// Fields

	private String researcherId;
	private TprojectApplication tprojectApplication;
	private String name;
	private String age;
	private String sexFlag;
	private String job;
	private String workUnit;
	private String department;
	private Integer revealOrder;
	private String remark;
	private String deleteFlag;
	private String phone;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String specialty;
	private String task;

	// Constructors

	/** default constructor */
	public Tresearcher() {
	}

	/** full constructor */
	public Tresearcher(TprojectApplication tprojectApplication, String name,
			String age, String sexFlag, String job, String workUnit,
			String department, Integer revealOrder, String remark,
			String deleteFlag, String phone, Timestamp createTime,
			String createUser, Timestamp updateTime, String updateUser,
			String specialty, String task) {
		this.tprojectApplication = tprojectApplication;
		this.name = name;
		this.age = age;
		this.sexFlag = sexFlag;
		this.job = job;
		this.workUnit = workUnit;
		this.department = department;
		this.revealOrder = revealOrder;
		this.remark = remark;
		this.deleteFlag = deleteFlag;
		this.phone = phone;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.specialty = specialty;
		this.task = task;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "RESEARCHER_ID", unique = true, nullable = false, length = 40)
	public String getResearcherId() {
		return this.researcherId;
	}

	public void setResearcherId(String researcherId) {
		this.researcherId = researcherId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "NAME", length = 120)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "AGE", length = 3)
	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Column(name = "SEX_FLAG", length = 3)
	public String getSexFlag() {
		return this.sexFlag;
	}

	public void setSexFlag(String sexFlag) {
		this.sexFlag = sexFlag;
	}

	@Column(name = "JOB", length = 200)
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name = "WORK_UNIT", length = 200)
	public String getWorkUnit() {
		return this.workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	@Column(name = "DEPARTMENT", length = 200)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "REVEAL_ORDER", precision = 5, scale = 0)
	public Integer getRevealOrder() {
		return this.revealOrder;
	}

	public void setRevealOrder(Integer revealOrder) {
		this.revealOrder = revealOrder;
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

	@Column(name = "PHONE", length = 15)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	@Column(name = "SPECIALTY", length = 100)
	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	@Column(name = "TASK", length = 500)
	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}
	
}
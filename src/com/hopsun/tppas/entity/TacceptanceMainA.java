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
 * TacceptanceMainA entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ACCEPTANCE_MAIN_A")
public class TacceptanceMainA implements java.io.Serializable {

	private static final long serialVersionUID = -8727416948866824469L;
	// Fields
	private String participateId;
	private Tacceptance tacceptance;
	private String name;
	private String sex;
	private Timestamp birthday;
	private String technicalTitles;
	private String educationLevel;
	private String workUnits;
	private String mainDuties;
	private String remark;
	private String createUser;
	private Timestamp createTime;
	private String updateUser;
	private Timestamp updateTime;
	private String deleteFlag;

	// Constructors

	/** default constructor */
	public TacceptanceMainA() {
	}

	/** full constructor */
	public TacceptanceMainA(Tacceptance tacceptance, String name, String sex,
			Timestamp birthday, String technicalTitles, String educationLevel,
			String workUnits, String mainDuties, String remark,
			String createUser, Timestamp createTime, String updateUser,
			Timestamp updateTime, String deleteFlag) {
		this.tacceptance = tacceptance;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.technicalTitles = technicalTitles;
		this.educationLevel = educationLevel;
		this.workUnits = workUnits;
		this.mainDuties = mainDuties;
		this.remark = remark;
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
	@Column(name = "PARTICIPATE_ID", unique = true, nullable = false, length = 40)
	public String getParticipateId() {
		return this.participateId;
	}

	public void setParticipateId(String participateId) {
		this.participateId = participateId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCEPTANCE_ID")
	public Tacceptance getTacceptance() {
		return this.tacceptance;
	}

	public void setTacceptance(Tacceptance tacceptance) {
		this.tacceptance = tacceptance;
	}

	@Column(name = "NAME", length = 15)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SEX", length = 1)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "BIRTHDAY")
	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	@Column(name = "TECHNICAL_TITLES", length = 40)
	public String getTechnicalTitles() {
		return this.technicalTitles;
	}

	public void setTechnicalTitles(String technicalTitles) {
		this.technicalTitles = technicalTitles;
	}

	@Column(name = "EDUCATION_LEVEL", length = 40)
	public String getEducationLevel() {
		return this.educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	@Column(name = "WORK_UNITS", length = 300)
	public String getWorkUnits() {
		return this.workUnits;
	}

	public void setWorkUnits(String workUnits) {
		this.workUnits = workUnits;
	}

	@Column(name = "MAIN_DUTIES", length = 300)
	public String getMainDuties() {
		return this.mainDuties;
	}

	public void setMainDuties(String mainDuties) {
		this.mainDuties = mainDuties;
	}

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
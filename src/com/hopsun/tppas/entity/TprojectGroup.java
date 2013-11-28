package com.hopsun.tppas.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * TprojectGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_PROJECT_GROUP")
public class TprojectGroup implements java.io.Serializable {

	private static final long serialVersionUID = 468798214693709166L;
	// Fields

	private String groupId;
	private String groupName;
	private Integer groupState;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String remark;
	private String departmentId;
	private String typeId;
	private String planFlag;
	private String clockFlag; // 锁定区分
	
	private List<TprojectApplication> tprojectApplications = new ArrayList<TprojectApplication>(0);
	private List<TgroupExpertRealtion> tgroupExpertRealtions = new ArrayList<TgroupExpertRealtion>(0);

	// Constructors

	/** default constructor */
	public TprojectGroup() {
	}

	/** full constructor */
	public TprojectGroup(String groupName, Integer groupState, String deleteFlag,
			Timestamp createTime, String createUser, Timestamp updateTime,
			String updateUser, String remark,String departmentId,String typeId,String planFlag,String clockFlag,
			List<TprojectApplication> tprojectApplications,List<TgroupExpertRealtion> tgroupExpertRealtions) {
		this.groupName = groupName;
		this.groupState = groupState;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.remark = remark;
		this.tprojectApplications = tprojectApplications;
		this.departmentId = departmentId;
		this.typeId = typeId;
		this.planFlag = planFlag;
		this.clockFlag = clockFlag;
		this.tgroupExpertRealtions = tgroupExpertRealtions;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "GROUP_ID", unique = true, nullable = false, length = 40)
	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Column(name = "GROUP_NAME", length = 200)
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column(name = "GROUP_STATE")
	public Integer getGroupState() {
		return this.groupState;
	}

	public void setGroupState(Integer groupState) {
		this.groupState = groupState;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "CREATE_TIME", length = 6)
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

	@Column(name = "UPDATE_TIME", length = 6)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tprojectGroup")
	public List<TprojectApplication> getTprojectApplications() {
		return this.tprojectApplications;
	}

	public void setTprojectApplications(List<TprojectApplication> tprojectApplications) {
		this.tprojectApplications = tprojectApplications;
	}

	@Column(name = "DEPARTMENT_ID", length = 40)
	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	@Column(name = "TYPE_ID", length = 40)
	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	@Column(name = "PLAN_FLAG", length = 40)
	public String getPlanFlag() {
		return planFlag;
	}

	public void setPlanFlag(String planFlag) {
		this.planFlag = planFlag;
	}

	@Column(name = "CLOCK_FLAG", length = 2)
	public String getClockFlag() {
		return clockFlag;
	}

	public void setClockFlag(String clockFlag) {
		this.clockFlag = clockFlag;
	}

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tprojectGroup")
	public List<TgroupExpertRealtion> getTgroupExpertRealtions() {
		return tgroupExpertRealtions;
	}

	public void setTgroupExpertRealtions(List<TgroupExpertRealtion> tgroupExpertRealtions) {
		this.tgroupExpertRealtions = tgroupExpertRealtions;
	}
	
	
}
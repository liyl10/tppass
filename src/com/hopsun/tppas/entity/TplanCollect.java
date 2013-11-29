package com.hopsun.tppas.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * TplanCollect entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_PLAN_COLLECT")
public class TplanCollect implements java.io.Serializable {

	private static final long serialVersionUID = -7628601121385479316L;
	// Fields

	private String planCollectId;
	private String planCollectName;
	private String planCollectYear;
	private String planCollectBatch;
	private String planCollectState;
	private String deleteFlag;
	private String createUser;
	private Timestamp createTime;
	private String updateUser;
	private Timestamp updateDate;
	private String remark;
	private List<Tplan> tplans = new ArrayList<Tplan>(0);

	// Constructors

	/** default constructor */
	public TplanCollect() {
	}

	/** full constructor */
	public TplanCollect(String planCollectName, String planCollectYear,
			String planCollectBatch, String planCollectState,
			String deleteFlag, String createUser, Timestamp createTime,
			String updateUser, Timestamp updateDate, String remark,
			List<Tplan> tplans) {
		this.planCollectName = planCollectName;
		this.planCollectYear = planCollectYear;
		this.planCollectBatch = planCollectBatch;
		this.planCollectState = planCollectState;
		this.deleteFlag = deleteFlag;
		this.createUser = createUser;
		this.createTime = createTime;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
		this.remark = remark;
		this.tplans = tplans;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PLAN_COLLECT_ID", unique = true, nullable = false, length = 40)
	public String getPlanCollectId() {
		return this.planCollectId;
	}

	public void setPlanCollectId(String planCollectId) {
		this.planCollectId = planCollectId;
	}

	@Column(name = "PLAN_COLLECT_NAME", length = 200)
	public String getPlanCollectName() {
		return this.planCollectName;
	}

	public void setPlanCollectName(String planCollectName) {
		this.planCollectName = planCollectName;
	}

	@Column(name = "PLAN_COLLECT_YEAR", length = 4)
	public String getPlanCollectYear() {
		return this.planCollectYear;
	}

	public void setPlanCollectYear(String planCollectYear) {
		this.planCollectYear = planCollectYear;
	}

	@Column(name = "PLAN_COLLECT_BATCH", length = 40)
	public String getPlanCollectBatch() {
		return this.planCollectBatch;
	}

	public void setPlanCollectBatch(String planCollectBatch) {
		this.planCollectBatch = planCollectBatch;
	}

	@Column(name = "PLAN_COLLECT_STATE", length = 40)
	public String getPlanCollectState() {
		return this.planCollectState;
	}

	public void setPlanCollectState(String planCollectState) {
		this.planCollectState = planCollectState;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
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

	@Column(name = "UPDATE_DATE")
	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tplanCollect")
	public List<Tplan> getTplans() {
		return this.tplans;
	}

	public void setTplans(List<Tplan> tplans) {
		this.tplans = tplans;
	}

}
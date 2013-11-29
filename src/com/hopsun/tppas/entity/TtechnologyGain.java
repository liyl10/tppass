package com.hopsun.tppas.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TtechnologyGain entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_TECHNOLOGY_GAIN")
public class TtechnologyGain implements java.io.Serializable {
	
	private static final long serialVersionUID = -6959499492570337679L;
	// Fields
	private String gainId;
	private String expertId;
	private String gainName;
	private String gainSource;
	private String gainFinish;
	private String gainCondition;
	private Timestamp createTime;
	private String deleteFlag;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;
	private String remark;

	// Constructors

	/** default constructor */
	public TtechnologyGain() {
	}

	/** full constructor */
	public TtechnologyGain(String expertId, String gainName, String gainSource,
			String gainFinish, String gainCondition, Timestamp createTime,
			String deleteFlag, String createUser, Timestamp updateDate,
			String updateUser, String remark) {
		this.expertId = expertId;
		this.gainName = gainName;
		this.gainSource = gainSource;
		this.gainFinish = gainFinish;
		this.gainCondition = gainCondition;
		this.createTime = createTime;
		this.deleteFlag = deleteFlag;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.remark = remark;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "GAIN_ID", unique = true, nullable = false, length = 40)
	public String getGainId() {
		return this.gainId;
	}

	public void setGainId(String gainId) {
		this.gainId = gainId;
	}

	@Column(name = "EXPERT_ID", length = 40)
	public String getExpertId() {
		return this.expertId;
	}

	public void setExpertId(String expertId) {
		this.expertId = expertId;
	}

	@Column(name = "GAIN_NAME", length = 50)
	public String getGainName() {
		return this.gainName;
	}

	public void setGainName(String gainName) {
		this.gainName = gainName;
	}

	@Column(name = "GAIN_SOURCE", length = 50)
	public String getGainSource() {
		return this.gainSource;
	}

	public void setGainSource(String gainSource) {
		this.gainSource = gainSource;
	}

	@Column(name = "GAIN_FINISH", length = 4000)
	public String getGainFinish() {
		return this.gainFinish;
	}

	public void setGainFinish(String gainFinish) {
		this.gainFinish = gainFinish;
	}

	@Column(name = "GAIN_CONDITION", length = 4000)
	public String getGainCondition() {
		return this.gainCondition;
	}

	public void setGainCondition(String gainCondition) {
		this.gainCondition = gainCondition;
	}

	@Column(name = "CREATE_TIME")
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
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

	@Column(name = "REMARK", length = 4000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
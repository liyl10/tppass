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
 * TprojectGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_GROUP_EXPERT_RELATION")
public class TgroupExpertRealtion implements java.io.Serializable {

	/** 序列化 */
	private static final long serialVersionUID = 6746163267159504982L;
	// Fields
	private String relationId;
	private TprojectGroup tprojectGroup;
	private Texpert texpert;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String remark;

	// Constructors

	/** default constructor */
	public TgroupExpertRealtion() {
	}

	/** full constructor */
	public TgroupExpertRealtion(TprojectGroup tprojectGroup, Texpert texpert, String deleteFlag,
			Timestamp createTime, String createUser, Timestamp updateTime,
			String updateUser, String remark) {
		this.tprojectGroup = tprojectGroup;
		this.texpert = texpert;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.remark = remark;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "RELATION_ID", unique = true, nullable = false, length = 40)
	public String getRelationId() {
		return this.relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GROUP_ID")
	public TprojectGroup  getTprojectGroup() {
		return this.tprojectGroup;
	}

	public void setTprojectGroup(TprojectGroup tprojectGroup) {
		this.tprojectGroup = tprojectGroup;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EXPERT_ID")
	public Texpert  getTexpert() {
		return this.texpert;
	}

	public void setTexpert(Texpert texpert) {
		this.texpert = texpert;
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
}
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
 * TmodelChoose entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_MODEL_CHOOSE")
public class TmodelChoose implements java.io.Serializable {

	private static final long serialVersionUID = 8780683238428176035L;
	// Fields

	private String modelChooseId;
	private TprojectType tprojectType;
	private String planId;
	private String modelChooseName;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;
	private String deleteFlag;
	private String remark;

	// Constructors

	/** default constructor */
	public TmodelChoose() {
	}

	/** full constructor */
	public TmodelChoose(TprojectType tprojectType, String planId,
			String modelChooseName, Timestamp createTime, String createUser,
			Timestamp updateDate, String updateUser, String deleteFlag,
			String remark) {
		this.tprojectType = tprojectType;
		this.planId = planId;
		this.modelChooseName = modelChooseName;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.deleteFlag = deleteFlag;
		this.remark = remark;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "MODEL_CHOOSE_ID", unique = true, nullable = false, length = 40)
	public String getModelChooseId() {
		return this.modelChooseId;
	}

	public void setModelChooseId(String modelChooseId) {
		this.modelChooseId = modelChooseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE_ID")
	public TprojectType getTprojectType() {
		return this.tprojectType;
	}

	public void setTprojectType(TprojectType tprojectType) {
		this.tprojectType = tprojectType;
	}

	@Column(name = "PLAN_ID", length = 40)
	public String getPlanId() {
		return this.planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	@Column(name = "MODEL_CHOOSE_NAME", length = 50)
	public String getModelChooseName() {
		return this.modelChooseName;
	}

	public void setModelChooseName(String modelChooseName) {
		this.modelChooseName = modelChooseName;
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

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
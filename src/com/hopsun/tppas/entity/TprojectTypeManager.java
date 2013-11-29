/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * @comments 计划类别管理专员
 * @author wangxiaodong
 * @date 2013-10-23
 * @version 1.0
 */
@Entity
@Table(name = "T_PROJECT_TYPE_MANAGER")
public class TprojectTypeManager implements java.io.Serializable {

	private static final long serialVersionUID = -2410014731028367707L;
	
	// Fields
	private String typeManagerId;
	private String typeId;
	private String userId;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;
	private String deleteFlag;
	private String remark;
	

	// Constructors

	/** default constructor */
	public TprojectTypeManager() {
	}

	/** full constructor */
	public TprojectTypeManager(String typeManagerId,String typeId, String userId, 
			Timestamp createTime, String createUser, Timestamp updateDate,
			String updateUser, String deleteFlag, String remark,Long isWrite) {
		this.typeManagerId = typeManagerId;
		this.typeId = typeId;
		this.userId = userId;
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
	@Column(name = "TYPE_MANAGER_ID", unique = true, nullable = false, length = 40)
	public String getTypeManagerId() {
		return typeManagerId;
	}

	public void setTypeManagerId(String typeManagerId) {
		this.typeManagerId = typeManagerId;
	}
	
	@Column(name = "TYPE_ID", length = 40)
	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}


	@Column(name = "USER_ID", length = 40)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "CREATE_TIME")
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "CREATE_USER", length = 40)
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

	@Column(name = "UPDATE_USER", length = 40)
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
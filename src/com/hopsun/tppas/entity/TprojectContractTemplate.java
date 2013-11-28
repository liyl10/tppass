package com.hopsun.tppas.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
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
 * TprojectContractTemplate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_PROJECT_CONTRACT_TEMPLATE")
public class TprojectContractTemplate implements java.io.Serializable {

	private static final long serialVersionUID = 6953719048961128125L;
	// Fields

	private String contractTemplateId;
	private String contractTemplateName;
	private String saveUrl;
	private String updateUrl;
	private String deleteUrl;
	private String viewUrl;
	private String auditUrl;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;
	private String deleteFlag;
	private String remark;
	private Set<TprojectType> tprojectTypes = new HashSet<TprojectType>(0);

	// Constructors

	/** default constructor */
	public TprojectContractTemplate() {
	}

	/** full constructor */
	public TprojectContractTemplate(String contractTemplateName,
			String saveUrl, String updateUrl, String deleteUrl, String viewUrl,
			String auditUrl, Timestamp createTime, String createUser,
			Timestamp updateDate, String updateUser, String deleteFlag,
			String remark, Set<TprojectType> tprojectTypes) {
		this.contractTemplateName = contractTemplateName;
		this.saveUrl = saveUrl;
		this.updateUrl = updateUrl;
		this.deleteUrl = deleteUrl;
		this.viewUrl = viewUrl;
		this.auditUrl = auditUrl;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.deleteFlag = deleteFlag;
		this.remark = remark;
		this.tprojectTypes = tprojectTypes;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CONTRACT_TEMPLATE_ID", unique = true, nullable = false, length = 40)
	public String getContractTemplateId() {
		return this.contractTemplateId;
	}

	public void setContractTemplateId(String contractTemplateId) {
		this.contractTemplateId = contractTemplateId;
	}

	@Column(name = "CONTRACT_TEMPLATE_NAME", length = 200)
	public String getContractTemplateName() {
		return this.contractTemplateName;
	}

	public void setContractTemplateName(String contractTemplateName) {
		this.contractTemplateName = contractTemplateName;
	}

	@Column(name = "SAVE_URL", length = 300)
	public String getSaveUrl() {
		return this.saveUrl;
	}

	public void setSaveUrl(String saveUrl) {
		this.saveUrl = saveUrl;
	}

	@Column(name = "UPDATE_URL", length = 300)
	public String getUpdateUrl() {
		return this.updateUrl;
	}

	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}

	@Column(name = "DELETE_URL", length = 300)
	public String getDeleteUrl() {
		return this.deleteUrl;
	}

	public void setDeleteUrl(String deleteUrl) {
		this.deleteUrl = deleteUrl;
	}

	@Column(name = "VIEW_URL", length = 300)
	public String getViewUrl() {
		return this.viewUrl;
	}

	public void setViewUrl(String viewUrl) {
		this.viewUrl = viewUrl;
	}

	@Column(name = "AUDIT_URL", length = 300)
	public String getAuditUrl() {
		return this.auditUrl;
	}

	public void setAuditUrl(String auditUrl) {
		this.auditUrl = auditUrl;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectContractTemplate")
	public Set<TprojectType> getTprojectTypes() {
		return this.tprojectTypes;
	}

	public void setTprojectTypes(Set<TprojectType> tprojectTypes) {
		this.tprojectTypes = tprojectTypes;
	}

}
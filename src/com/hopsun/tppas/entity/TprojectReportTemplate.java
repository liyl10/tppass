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
 * TprojectReportTemplate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_PROJECT_REPORT_TEMPLATE")
public class TprojectReportTemplate implements java.io.Serializable {

	private static final long serialVersionUID = 2158749999067397411L;
	// Fields

	private String reportTemplateId;
	private String reportTemplateName;
	private String saveUrl;
	private String updateUrl;
	private String viewUrl;
	private String deleteUrl;
	private String trialUrl;
	private String auditUrl;
	private String expertAuditUrl;
	private String expertProofUrl;
	private String leadershipAuditUrl;
	private String meetingAuditUrl;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;
	private String deleteFlag;
	private String remark;
	private Set<TprojectType> tprojectTypes = new HashSet<TprojectType>(0);

	// Constructors

	/** default constructor */
	public TprojectReportTemplate() {
	}

	/** full constructor */
	public TprojectReportTemplate(String reportTemplateName, String saveUrl,
			String updateUrl, String viewUrl, String deleteUrl,
			String trialUrl, String auditUrl, String expertAuditUrl,
			String expertProofUrl, String leadershipAuditUrl,
			String meetingAuditUrl, Timestamp createTime, String createUser,
			Timestamp updateDate, String updateUser, String deleteFlag,
			String remark, Set<TprojectType> tprojectTypes) {
		this.reportTemplateName = reportTemplateName;
		this.saveUrl = saveUrl;
		this.updateUrl = updateUrl;
		this.viewUrl = viewUrl;
		this.deleteUrl = deleteUrl;
		this.trialUrl = trialUrl;
		this.auditUrl = auditUrl;
		this.expertAuditUrl = expertAuditUrl;
		this.expertProofUrl = expertProofUrl;
		this.leadershipAuditUrl = leadershipAuditUrl;
		this.meetingAuditUrl = meetingAuditUrl;
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
	@Column(name = "REPORT_TEMPLATE_ID", unique = true, nullable = false, length = 40)
	public String getReportTemplateId() {
		return this.reportTemplateId;
	}

	public void setReportTemplateId(String reportTemplateId) {
		this.reportTemplateId = reportTemplateId;
	}

	@Column(name = "REPORT_TEMPLATE_NAME", length = 200)
	public String getReportTemplateName() {
		return this.reportTemplateName;
	}

	public void setReportTemplateName(String reportTemplateName) {
		this.reportTemplateName = reportTemplateName;
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

	@Column(name = "VIEW_URL", length = 300)
	public String getViewUrl() {
		return this.viewUrl;
	}

	public void setViewUrl(String viewUrl) {
		this.viewUrl = viewUrl;
	}

	@Column(name = "DELETE_URL", length = 300)
	public String getDeleteUrl() {
		return this.deleteUrl;
	}

	public void setDeleteUrl(String deleteUrl) {
		this.deleteUrl = deleteUrl;
	}

	@Column(name = "TRIAL_URL", length = 300)
	public String getTrialUrl() {
		return this.trialUrl;
	}

	public void setTrialUrl(String trialUrl) {
		this.trialUrl = trialUrl;
	}

	@Column(name = "AUDIT_URL", length = 300)
	public String getAuditUrl() {
		return this.auditUrl;
	}

	public void setAuditUrl(String auditUrl) {
		this.auditUrl = auditUrl;
	}

	@Column(name = "EXPERT_AUDIT_URL", length = 300)
	public String getExpertAuditUrl() {
		return this.expertAuditUrl;
	}

	public void setExpertAuditUrl(String expertAuditUrl) {
		this.expertAuditUrl = expertAuditUrl;
	}

	@Column(name = "EXPERT_PROOF_URL", length = 300)
	public String getExpertProofUrl() {
		return this.expertProofUrl;
	}

	public void setExpertProofUrl(String expertProofUrl) {
		this.expertProofUrl = expertProofUrl;
	}

	@Column(name = "LEADERSHIP_AUDIT_URL", length = 300)
	public String getLeadershipAuditUrl() {
		return this.leadershipAuditUrl;
	}

	public void setLeadershipAuditUrl(String leadershipAuditUrl) {
		this.leadershipAuditUrl = leadershipAuditUrl;
	}

	@Column(name = "MEETING_AUDIT_URL", length = 300)
	public String getMeetingAuditUrl() {
		return this.meetingAuditUrl;
	}

	public void setMeetingAuditUrl(String meetingAuditUrl) {
		this.meetingAuditUrl = meetingAuditUrl;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectReportTemplate")
	public Set<TprojectType> getTprojectTypes() {
		return this.tprojectTypes;
	}

	public void setTprojectTypes(Set<TprojectType> tprojectTypes) {
		this.tprojectTypes = tprojectTypes;
	}

}
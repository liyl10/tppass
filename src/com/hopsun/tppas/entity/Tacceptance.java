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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * Tacceptance entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ACCEPTANCE")
public class Tacceptance implements java.io.Serializable {

	private static final long serialVersionUID = 671461097688478788L;
	// Fields
	private String acceptanceId;
	private TprojectApplication tprojectApplication;
	private String acceptanceStatus;
	private String approvalOpinion;
	private Timestamp approvalTime;
	private String userId;
	private String pdfUrl;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;
	private Timestamp operateTime;
	private String operateUser;
	private String compilationDept;
	private Timestamp acceptanceDate;
	// 临时字段
	private String acceptanceStatusName;
	private String userName;
	
	private String funding;
	private Timestamp scheduledTime;
	private Timestamp actualTime;
	private String touchUnit;
	private String touchJob;
	private String responsibleUnit;
	private String responsibleJob;
	
	private Set<TacceptanceExpertAudit> tacceptanceExpertAudits = new HashSet<TacceptanceExpertAudit>(0);
	private Set<TacceptanceDevelopingA> tacceptanceDevelopingAs = new HashSet<TacceptanceDevelopingA>(0);
	private Set<TacceptanceAchievementB> tacceptanceAchievementBs = new HashSet<TacceptanceAchievementB>(0);
	private Set<TacceptanceImplementationB> tacceptanceImplementationBs = new HashSet<TacceptanceImplementationB>(0);
	private Set<TacceptanceImplementationA> tacceptanceImplementationAs = new HashSet<TacceptanceImplementationA>(0);
	private Set<TacceptanceOpinionA> tacceptanceOpinionAs = new HashSet<TacceptanceOpinionA>(0);
	private Set<TacceptanceMainA> tacceptanceMainAs = new HashSet<TacceptanceMainA>(0);
	private Set<TacceptanceFundsA> tacceptanceFundsAs = new HashSet<TacceptanceFundsA>(0);
	private Set<TacceptanceCompleteA> tacceptanceCompleteAs = new HashSet<TacceptanceCompleteA>(0);
	private Set<TacceptanceAccA> tacceptanceAccAs = new HashSet<TacceptanceAccA>(0);
	private Set<TacceptanceAccFundsA> tacceptanceAccFundsAs = new HashSet<TacceptanceAccFundsA>(0);
	private Set<TacceptanceSummaryB> tacceptanceSummaryBs = new HashSet<TacceptanceSummaryB>(0);

	// Constructors

	/** default constructor */
	public Tacceptance() {
	}

	/** full constructor */
	public Tacceptance(TprojectApplication tprojectApplication,
			String acceptanceStatus, String approvalOpinion,
			Timestamp approvalTime, String userId, String pdfUrl,
			String deleteFlag, Timestamp createTime, String createUser,
			Timestamp updateDate, String updateUser, Timestamp operateTime,
			String operateUser, String compilationDept,
			String funding,Timestamp scheduledTime,Timestamp actualTime,String touchUnit,String touchJob,
			String responsibleUnit,String responsibleJob,
			Set<TacceptanceExpertAudit> tacceptanceExpertAudits,
			Set<TacceptanceDevelopingA> tacceptanceDevelopingAs,
			Set<TacceptanceAchievementB> tacceptanceAchievementBs,
			Set<TacceptanceImplementationB> tacceptanceImplementationBs,
			Set<TacceptanceImplementationA> tacceptanceImplementationAs,
			Set<TacceptanceOpinionA> tacceptanceOpinionAs,
			Set<TacceptanceMainA> tacceptanceMainAs,
			Set<TacceptanceFundsA> tacceptanceFundsAs,
			Set<TacceptanceCompleteA> tacceptanceCompleteAs,
			Set<TacceptanceAccA> tacceptanceAccAs,
			Set<TacceptanceAccFundsA> tacceptanceAccFundsAs,
			Set<TacceptanceSummaryB> tacceptanceSummaryBs) {
		this.tprojectApplication = tprojectApplication;
		this.acceptanceStatus = acceptanceStatus;
		this.approvalOpinion = approvalOpinion;
		this.approvalTime = approvalTime;
		this.userId = userId;
		this.pdfUrl = pdfUrl;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.operateTime = operateTime;
		this.operateUser = operateUser;
		this.compilationDept = compilationDept;
		this.funding = funding;
		this.scheduledTime = scheduledTime;
		this.actualTime = actualTime;
		this.touchUnit = touchUnit;
		this.touchJob = touchJob;
		this.responsibleUnit = responsibleUnit;
		this.responsibleJob = responsibleJob;
		this.tacceptanceExpertAudits = tacceptanceExpertAudits;
		this.tacceptanceDevelopingAs = tacceptanceDevelopingAs;
		this.tacceptanceAchievementBs = tacceptanceAchievementBs;
		this.tacceptanceImplementationBs = tacceptanceImplementationBs;
		this.tacceptanceImplementationAs = tacceptanceImplementationAs;
		this.tacceptanceOpinionAs = tacceptanceOpinionAs;
		this.tacceptanceMainAs = tacceptanceMainAs;
		this.tacceptanceFundsAs = tacceptanceFundsAs;
		this.tacceptanceCompleteAs = tacceptanceCompleteAs;
		this.tacceptanceAccAs = tacceptanceAccAs;
		this.tacceptanceAccFundsAs = tacceptanceAccFundsAs;
		this.tacceptanceSummaryBs = tacceptanceSummaryBs;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ACCEPTANCE_ID", unique = true, nullable = false, length = 40)
	public String getAcceptanceId() {
		return this.acceptanceId;
	}

	public void setAcceptanceId(String acceptanceId) {
		this.acceptanceId = acceptanceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "ACCEPTANCE_STATUS", length = 10)
	public String getAcceptanceStatus() {
		return this.acceptanceStatus;
	}

	public void setAcceptanceStatus(String acceptanceStatus) {
		this.acceptanceStatus = acceptanceStatus;
	}

	@Column(name = "APPROVAL_OPINION", length = 500)
	public String getApprovalOpinion() {
		return this.approvalOpinion;
	}

	public void setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion = approvalOpinion;
	}

	@Column(name = "APPROVAL_TIME")
	public Timestamp getApprovalTime() {
		return this.approvalTime;
	}

	public void setApprovalTime(Timestamp approvalTime) {
		this.approvalTime = approvalTime;
	}

	@Column(name = "USER_ID", length = 40)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "PDF_URL", length = 300)
	public String getPdfUrl() {
		return this.pdfUrl;
	}

	public void setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
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

	@Column(name = "OPERATE_TIME")
	public Timestamp getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(Timestamp operateTime) {
		this.operateTime = operateTime;
	}

	@Column(name = "OPERATE_USER", length = 50)
	public String getOperateUser() {
		return this.operateUser;
	}

	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}

	@Column(name = "COMPILATION_DEPT", length = 200)
	public String getCompilationDept() {
		return this.compilationDept;
	}

	public void setCompilationDept(String compilationDept) {
		this.compilationDept = compilationDept;
	}
	@Column(name = "ACCEPTANCE_DATE")
	public Timestamp getAcceptanceDate() {
		return acceptanceDate;
	}

	public void setAcceptanceDate(Timestamp acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}
	@Column(name = "FUNDING", precision = 13, scale = 4)
	public String getFunding() {
		return funding;
	}

	public void setFunding(String funding) {
		this.funding = funding;
	}
	@Column(name = "SCHEDULED_TIME")
	public Timestamp getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(Timestamp scheduledTime) {
		this.scheduledTime = scheduledTime;
	}
	@Column(name = "ACTUAL_TIME")
	public Timestamp getActualTime() {
		return actualTime;
	}

	public void setActualTime(Timestamp actualTime) {
		this.actualTime = actualTime;
	}
	@Column(name = "TOUCH_UNIT",length = 100)
	public String getTouchUnit() {
		return touchUnit;
	}

	public void setTouchUnit(String touchUnit) {
		this.touchUnit = touchUnit;
	}
	@Column(name = "TOUCH_JOB",length = 200)
	public String getTouchJob() {
		return touchJob;
	}

	public void setTouchJob(String touchJob) {
		this.touchJob = touchJob;
	}
	@Column(name = "RESPONSIBLE_UNIT",length = 100)
	public String getResponsibleUnit() {
		return responsibleUnit;
	}

	public void setResponsibleUnit(String responsibleUnit) {
		this.responsibleUnit = responsibleUnit;
	}
	
	@Column(name = "RESPONSIBLE_JOB",length = 200)
	public String getResponsibleJob() {
		return responsibleJob;
	}

	public void setResponsibleJob(String responsibleJob) {
		this.responsibleJob = responsibleJob;
	}
	
	/**
	 * @return the acceptanceStatusName
	 */
	@Transient
	public String getAcceptanceStatusName() {
		return acceptanceStatusName;
	}

	/**
	 * @param acceptanceStatusName the acceptanceStatusName to set
	 */
	public void setAcceptanceStatusName(String acceptanceStatusName) {
		this.acceptanceStatusName = acceptanceStatusName;
	}

	@Transient
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tacceptance")
	public Set<TacceptanceExpertAudit> getTacceptanceExpertAudits() {
		return this.tacceptanceExpertAudits;
	}

	public void setTacceptanceExpertAudits(
			Set<TacceptanceExpertAudit> tacceptanceExpertAudits) {
		this.tacceptanceExpertAudits = tacceptanceExpertAudits;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tacceptance")
	public Set<TacceptanceDevelopingA> getTacceptanceDevelopingAs() {
		return this.tacceptanceDevelopingAs;
	}

	public void setTacceptanceDevelopingAs(
			Set<TacceptanceDevelopingA> tacceptanceDevelopingAs) {
		this.tacceptanceDevelopingAs = tacceptanceDevelopingAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tacceptance")
	public Set<TacceptanceAchievementB> getTacceptanceAchievementBs() {
		return this.tacceptanceAchievementBs;
	}

	public void setTacceptanceAchievementBs(
			Set<TacceptanceAchievementB> tacceptanceAchievementBs) {
		this.tacceptanceAchievementBs = tacceptanceAchievementBs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tacceptance")
	public Set<TacceptanceImplementationB> getTacceptanceImplementationBs() {
		return this.tacceptanceImplementationBs;
	}

	public void setTacceptanceImplementationBs(
			Set<TacceptanceImplementationB> tacceptanceImplementationBs) {
		this.tacceptanceImplementationBs = tacceptanceImplementationBs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tacceptance")
	public Set<TacceptanceImplementationA> getTacceptanceImplementationAs() {
		return this.tacceptanceImplementationAs;
	}

	public void setTacceptanceImplementationAs(
			Set<TacceptanceImplementationA> tacceptanceImplementationAs) {
		this.tacceptanceImplementationAs = tacceptanceImplementationAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tacceptance")
	public Set<TacceptanceOpinionA> getTacceptanceOpinionAs() {
		return this.tacceptanceOpinionAs;
	}

	public void setTacceptanceOpinionAs(
			Set<TacceptanceOpinionA> tacceptanceOpinionAs) {
		this.tacceptanceOpinionAs = tacceptanceOpinionAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tacceptance")
	public Set<TacceptanceMainA> getTacceptanceMainAs() {
		return this.tacceptanceMainAs;
	}

	public void setTacceptanceMainAs(Set<TacceptanceMainA> tacceptanceMainAs) {
		this.tacceptanceMainAs = tacceptanceMainAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tacceptance")
	public Set<TacceptanceFundsA> getTacceptanceFundsAs() {
		return this.tacceptanceFundsAs;
	}

	public void setTacceptanceFundsAs(Set<TacceptanceFundsA> tacceptanceFundsAs) {
		this.tacceptanceFundsAs = tacceptanceFundsAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tacceptance")
	public Set<TacceptanceCompleteA> getTacceptanceCompleteAs() {
		return this.tacceptanceCompleteAs;
	}

	public void setTacceptanceCompleteAs(
			Set<TacceptanceCompleteA> tacceptanceCompleteAs) {
		this.tacceptanceCompleteAs = tacceptanceCompleteAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tacceptance")
	public Set<TacceptanceAccA> getTacceptanceAccAs() {
		return this.tacceptanceAccAs;
	}

	public void setTacceptanceAccAs(Set<TacceptanceAccA> tacceptanceAccAs) {
		this.tacceptanceAccAs = tacceptanceAccAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tacceptance")
	public Set<TacceptanceAccFundsA> getTacceptanceAccFundsAs() {
		return this.tacceptanceAccFundsAs;
	}

	public void setTacceptanceAccFundsAs(
			Set<TacceptanceAccFundsA> tacceptanceAccFundsAs) {
		this.tacceptanceAccFundsAs = tacceptanceAccFundsAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tacceptance")
	public Set<TacceptanceSummaryB> getTacceptanceSummaryBs() {
		return this.tacceptanceSummaryBs;
	}

	public void setTacceptanceSummaryBs(
			Set<TacceptanceSummaryB> tacceptanceSummaryBs) {
		this.tacceptanceSummaryBs = tacceptanceSummaryBs;
	}

	
}
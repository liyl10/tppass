package com.hopsun.tppas.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TsupervisorReport entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_SUPERVISOR_REPORT")
public class TsupervisorReport implements java.io.Serializable {

	private static final long serialVersionUID = -314146702461010526L;
	// Fields

	private String reportId;
	private Tsupervisor tsupervisor;
	private TsupervisorPoint tsupervisorPoint;
	private String studyContent;
	private String everyIndex;
	private String knowledgeProperty;
	private String personalDevelop;
	private String fundCase;
	private String fundsCase;
	private String managerExperience;
	private String existQuestion;
	private String reportType;
	private Timestamp submitTime;
	private String checkInfo;
	private String checkState;
	private Timestamp checkTime;
	private Integer deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;
	private String remark;

	// Constructors

	/** default constructor */
	public TsupervisorReport() {
	}

	/** full constructor */
	public TsupervisorReport(Tsupervisor tsupervisor, TsupervisorPoint tsupervisorPoint,String studyContent,
			String everyIndex, String knowledgeProperty,
			String personalDevelop, String fundCase, String fundsCase,
			String managerExperience, String existQuestion, String reportType,
			Timestamp submitTime, String checkInfo, String checkState,
			Timestamp checkTime, Integer deleteFlag, Timestamp createTime,
			String createUser, Timestamp updateDate, String updateUser,
			String remark) {
		this.tsupervisor = tsupervisor;
		this.tsupervisorPoint = tsupervisorPoint;
		this.studyContent = studyContent;
		this.everyIndex = everyIndex;
		this.knowledgeProperty = knowledgeProperty;
		this.personalDevelop = personalDevelop;
		this.fundCase = fundCase;
		this.fundsCase = fundsCase;
		this.managerExperience = managerExperience;
		this.existQuestion = existQuestion;
		this.reportType = reportType;
		this.submitTime = submitTime;
		this.checkInfo = checkInfo;
		this.checkState = checkState;
		this.checkTime = checkTime;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.remark = remark;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "REPORT_ID", unique = true, nullable = false, length = 40)
	public String getReportId() {
		return this.reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPERVISOR_ID")
	public Tsupervisor getTsupervisor() {
		return this.tsupervisor;
	}

	public void setTsupervisor(Tsupervisor tsupervisor) {
		this.tsupervisor = tsupervisor;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="POINT_ID")   
	public TsupervisorPoint getTsupervisorPoint() {
		return tsupervisorPoint;
	}

	public void setTsupervisorPoint(TsupervisorPoint tsupervisorPoint) {
		this.tsupervisorPoint = tsupervisorPoint;
	}

	@Column(name = "STUDY_CONTENT", length = 4000)
	public String getStudyContent() {
		return this.studyContent;
	}

	public void setStudyContent(String studyContent) {
		this.studyContent = studyContent;
	}

	@Column(name = "EVERY_INDEX", length = 4000)
	public String getEveryIndex() {
		return this.everyIndex;
	}

	public void setEveryIndex(String everyIndex) {
		this.everyIndex = everyIndex;
	}

	@Column(name = "KNOWLEDGE_PROPERTY", length = 4000)
	public String getKnowledgeProperty() {
		return this.knowledgeProperty;
	}

	public void setKnowledgeProperty(String knowledgeProperty) {
		this.knowledgeProperty = knowledgeProperty;
	}

	@Column(name = "PERSONAL_DEVELOP", length = 4000)
	public String getPersonalDevelop() {
		return this.personalDevelop;
	}

	public void setPersonalDevelop(String personalDevelop) {
		this.personalDevelop = personalDevelop;
	}

	@Column(name = "FUND_CASE", length = 4000)
	public String getFundCase() {
		return this.fundCase;
	}

	public void setFundCase(String fundCase) {
		this.fundCase = fundCase;
	}

	@Column(name = "FUNDS_CASE", length = 4000)
	public String getFundsCase() {
		return this.fundsCase;
	}

	public void setFundsCase(String fundsCase) {
		this.fundsCase = fundsCase;
	}

	@Column(name = "MANAGER_EXPERIENCE", length = 4000)
	public String getManagerExperience() {
		return this.managerExperience;
	}

	public void setManagerExperience(String managerExperience) {
		this.managerExperience = managerExperience;
	}

	@Column(name = "EXIST_QUESTION", length = 4000)
	public String getExistQuestion() {
		return this.existQuestion;
	}

	public void setExistQuestion(String existQuestion) {
		this.existQuestion = existQuestion;
	}

	@Column(name = "REPORT_TYPE", length = 10)
	public String getReportType() {
		return this.reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	@Column(name = "SUBMIT_TIME")
	public Timestamp getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	@Column(name = "CHECK_INFO", length = 500)
	public String getCheckInfo() {
		return this.checkInfo;
	}

	public void setCheckInfo(String checkInfo) {
		this.checkInfo = checkInfo;
	}

	@Column(name = "CHECK_STATE", length = 10)
	public String getCheckState() {
		return this.checkState;
	}

	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}

	@Column(name = "CHECK_TIME")
	public Timestamp getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public Integer getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
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

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
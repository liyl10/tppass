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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * TprojectApplication entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_PROJECT_APPLICATION")
public class TprojectApplication implements java.io.Serializable {

	private static final long serialVersionUID = 7008960848599414035L;
	// Fields

	private String projectId;
	private TprojectType tprojectType;
	private TprojectGroup tprojectGroup;
	private Tplan tplan;
	private String userId;
	private String projectNumber;
	private String projectName;
	private String planNumber;
	private String applyStatus;
	private String flowStatus;
	private String applicationUnit;
	private String centralizedType;
	/** 归口管理部门名称 */
	private String centralizedTypeName;
	private String planFlag;
	private String supportFunction;
	private String supportFlag;
	/** 临时项目申报状态*/
	private String applyStatusString;
	/** 临时项目申报书备注*/
	private String projectReportText;
	/** 临时项目申报书时间*/
	private String projectReportTime;
	/** 临时项目编号*/
	private String projectNumberTemp;
	/** 临时单位性质*/
	private String unitProperties;
	/** 分类id*/
	private String typeId;
	
	private Timestamp startTime;
	private Timestamp endTime;
	private Timestamp handleTime;
	private String reportYear;
	private String compilationDept;
	private String compilationTime;
	private String pdfUrl;
	private String optUser;
	private String initialAuditOpinion;
	private String deployOpinion;
	private String expertAuditResearch;
	private String expertAuditComposite;
	private String expertAuditRecommend;
	private String expertProofResearch;
	private String expertProofComposite;
	private String expertProofRecommend;
	private String commissionerOpinion;
	private String meetingOpinion;
	private String isArchival;
	private String deleteFlag;
	private String createUser;
	private Timestamp createTime;
	private String updateUser;
	private Timestamp updateTime;
	private String remark;
	private Timestamp writeReportTime;
	private Timestamp archivalTime;
	private String firstSecond;
	// 显示项目分类用
	private String tprojectTypeName;
	/**项目分类名称*/
	private String typeName;
	/**计划类别名称*/
	private String planFlagName;
	// 临时字段-显示类型
	private String projectViewType;
	// 临时-项目评审通过率统计开始时间
	private String projectViewTypeStartTime;
	// 临时-项目评审通过率统计结束时间
	private String projectViewTypeEndTime;
	// 项目总数
	private String projectTotal;
	// 未初审项目数
	private String noViewProjectTotal;
	// 未通过项目数
	private String noPassProject;
	// 已通过初审未验收项目数
	private String noAcceptanceProject;
	// 已通过已验收项目数
	private String passAcceptanceProject;
	
	// 临时字段 Start
	// 总投入合计
	private double inputTotal;
	// 科研资金
	private double researchFunds;
	// 自筹
	private double selfFinancing;
	// 项目效益预测_产值
	private double projectExpectOutput;
	// 项目效益预测_利税
	private double projectExpectProfitTax;
	// 企业效益预测_产值
	private double companyExpectOutput;
	// 企业效益预测_利税
	private double companyExpectProfitTax;
	
	//  临时字段 End
	
	// 追加字段 2013-09-26 wanglw
	private String entrustUnit;
	/**预申报传入的项目ID*/
	private String tempProjectId;
	
	private String expertTecOpinion;
	private String expertTecRecommend;
	private String expertInvOpinion;
	private String expertInvRecommend;
	
	private String jointStatus;
	private String expertOpinionStatus;
	private String expertScoreStatus;
	//2013-11-22添加字段-wangxd
	/**技术专家平均分*/
	private double projectTechnologyAverage;
	/**投资专家平均分*/
	private double projectInvestmentAverage;
	/**项目总平均分*/
	private double projectAverage;
	/**技术专家评审结果*/
	private String projectTechnologyResult;
	/**投资专家评审结果*/
	private String	projectInvestmentResult;
	
	private List<TfinancingUse> tfinancingUses = new ArrayList<TfinancingUse>(0);
	private List<Tsupervisor> tsupervisors = new ArrayList<Tsupervisor>(0);
	private List<TcostEstimateB> tcostEstimateBs = new ArrayList<TcostEstimateB>(0);
	private List<TexpertScore> texpertScores = new ArrayList<TexpertScore>(0);
	private List<TreviewComments> treviewCommentses = new ArrayList<TreviewComments>(0);
	private List<TcompanyNeedB> tcompanyNeedBs = new ArrayList<TcompanyNeedB>(0);
	private List<Tcontract> tcontracts = new ArrayList<Tcontract>(0);
	private List<TreportAbstractB> treportAbstractBs = new ArrayList<TreportAbstractB>(0);
	private List<TprojectInfoA> tprojectInfoAs = new ArrayList<TprojectInfoA>(0);
	private List<TcompanyFoundationB> tcompanyFoundationBs = new ArrayList<TcompanyFoundationB>(0);
	private List<TeconomicIndicatorB> teconomicIndicatorBs = new ArrayList<TeconomicIndicatorB>(0);
	private List<TenterpriseProfileA> tenterpriseProfileAs = new ArrayList<TenterpriseProfileA>(0);
	private List<Tresearcher> tresearchers = new ArrayList<Tresearcher>(0);
	private List<TtechnicalContentA> ttechnicalContentAs = new ArrayList<TtechnicalContentA>(0);
	private List<TmoneyScheduleA> tmoneyScheduleAs = new ArrayList<TmoneyScheduleA>(0);
	private List<TprojectOverviewA> tprojectOverviewAs = new ArrayList<TprojectOverviewA>(0);
	private List<Tacceptance> tacceptances = new ArrayList<Tacceptance>(0);
	private List<TprojectInfoB> tprojectInfoBs = new ArrayList<TprojectInfoB>(0);
	private List<TprojectRecord> tprojectRecords = new ArrayList<TprojectRecord>(0);
	private List<TeconomicIndicatorA> teconomicIndicatorAs = new ArrayList<TeconomicIndicatorA>(0);
	private List<TschedulingA> tschedulingAs = new ArrayList<TschedulingA>(0);
	private List<TcompanyInfo> tcompanyInfos = new ArrayList<TcompanyInfo>(0);
	private List<TtechnicalIndexes> ttechnicalIndexes = new ArrayList<TtechnicalIndexes>(0);
	private List<TexpectedResults> texpectedResults = new ArrayList<TexpectedResults>(0);
	private List<TfundPlanB> tfundPlanB = new ArrayList<TfundPlanB>(0);
	private List<TreportObjectives> treportObjectives = new ArrayList<TreportObjectives>(0);
	private List<TfundingPlanReport> tfundingPlanReport = new ArrayList<TfundingPlanReport>(0);
	// Constructors

	/** default constructor */
	public TprojectApplication() {
	}

	/** full constructor */
	public TprojectApplication(TprojectType tprojectType,
			TprojectGroup tprojectGroup, Tplan tplan, String userId,
			String projectNumber, String projectName, String planNumber,
			String applyStatus, String flowStatus, String applicationUnit,
			String centralizedType, String centralizedTypeName, String planFlag, String supportFunction,
			String supportFlag, String applyStatusString,String projectReportText ,String projectReportTime,
			String projectNumberTemp,String unitProperties,String typeId,Timestamp startTime, Timestamp endTime,
			Timestamp handleTime, String reportYear, String compilationDept,
			String compilationTime, String pdfUrl, String optUser,
			String initialAuditOpinion, String deployOpinion,
			String expertAuditResearch, String expertAuditComposite,
			String expertAuditRecommend, String expertProofResearch,
			String expertProofComposite, String expertProofRecommend,
			String commissionerOpinion, String meetingOpinion, String isArchival,
			String deleteFlag, String createUser, Timestamp createTime,
			String updateUser, Timestamp updateTime, String remark, Timestamp writeReportTime,
			Timestamp archivalTime,String firstSecond,String typeName,String planFlagName,String projectViewType, 
			String projectViewTypeStartTime, String projectViewTypeEndTime,String projectTotal,String noViewProjectTotal,
			String noPassProject, String noAcceptanceProject, String passAcceptanceProject,String entrustUnit,
			double inputTotal, double researchFunds, double selfFinancing, double projectExpectOutput, 
			double projectExpectProfitTax, double companyExpectOutput, double companyExpectProfitTax,
			String expertTecOpinion, String expertTecRecommend, String expertInvOpinion, String expertInvRecommend,
			String jointStatus, String expertOpinionStatus, String expertScoreStatus,
			double projectTechnologyAverage, double projectInvestmentAverage, double projectAverage, 
			String projectTechnologyResult,String projectInvestmentResult,
			List<TfinancingUse> tfinancingUses, List<Tsupervisor> tsupervisors,
			List<TcostEstimateB> tcostEstimateBs,
			List<TexpertScore> texpertScores,
			List<TreviewComments> treviewCommentses,
			List<TcompanyNeedB> tcompanyNeedBs, List<Tcontract> tcontracts,
			List<TreportAbstractB> treportAbstractBs,
			List<TprojectInfoA> tprojectInfoAs,
			List<TcompanyFoundationB> tcompanyFoundationBs,
			List<TeconomicIndicatorB> teconomicIndicatorBs,
			List<TenterpriseProfileA> tenterpriseProfileAs,
			List<Tresearcher> tresearchers,
			List<TtechnicalContentA> ttechnicalContentAs,
			List<TmoneyScheduleA> tmoneyScheduleAs,
			List<TprojectOverviewA> tprojectOverviewAs,
			List<Tacceptance> tacceptances, List<TprojectInfoB> tprojectInfoBs,
			List<TprojectRecord> tprojectRecords,
			List<TeconomicIndicatorA> teconomicIndicatorAs,
			List<TschedulingA> tschedulingAs,
			List<TcompanyInfo> tcompanyInfos,
			List<TtechnicalIndexes> ttechnicalIndexes,
			List<TexpectedResults> texpectedResults,
			List<TfundPlanB> tfundPlanB,
			List<TreportObjectives> treportObjectives,
			List<TfundingPlanReport> tfundingPlanReport,
			String tempProjectId) {
		this.tprojectType = tprojectType;
		this.tprojectGroup = tprojectGroup;
		this.tplan = tplan;
		this.userId = userId;
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.planNumber = planNumber;
		this.applyStatus = applyStatus;
		this.flowStatus = flowStatus;
		this.applicationUnit = applicationUnit;
		this.centralizedType = centralizedType;
		this.centralizedTypeName = centralizedTypeName;
		this.planFlag = planFlag;
		this.supportFunction = supportFunction;
		this.supportFlag = supportFlag;
		this.applyStatusString = applyStatusString;
		this.projectReportText = projectReportText;
		this.projectReportTime = projectReportTime;
		this.projectNumberTemp = projectNumberTemp;
		this.unitProperties = unitProperties;
		this.typeId = typeId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.handleTime = handleTime;
		this.reportYear = reportYear;
		this.compilationDept = compilationDept;
		this.compilationTime = compilationTime;
		this.pdfUrl = pdfUrl;
		this.optUser = optUser;
		this.initialAuditOpinion = initialAuditOpinion;
		this.deployOpinion = deployOpinion;
		this.expertAuditResearch = expertAuditResearch;
		this.expertAuditComposite = expertAuditComposite;
		this.expertAuditRecommend = expertAuditRecommend;
		this.expertProofResearch = expertProofResearch;
		this.expertProofComposite = expertProofComposite;
		this.expertProofRecommend = expertProofRecommend;
		this.commissionerOpinion = commissionerOpinion;
		this.meetingOpinion = meetingOpinion;
		this.isArchival = isArchival;
		this.deleteFlag = deleteFlag;
		this.createUser = createUser;
		this.createTime = createTime;
		this.updateUser = updateUser;
		this.updateTime = updateTime;
		this.remark = remark;
		this.writeReportTime = writeReportTime;
		this.archivalTime = archivalTime;
		this.firstSecond = firstSecond;
		this.typeName = typeName;
		this.planFlagName = planFlagName;
		this.projectViewType = projectViewType;
		this.projectViewTypeStartTime = projectViewTypeStartTime;
		this.projectViewTypeEndTime = projectViewTypeEndTime;
		this.projectTotal = projectTotal;
		this.noViewProjectTotal = noViewProjectTotal;
		this.noPassProject = noPassProject;
		this.noAcceptanceProject = noAcceptanceProject;
		this.passAcceptanceProject = passAcceptanceProject;
		this.entrustUnit = entrustUnit;
		this.expertTecOpinion = expertTecOpinion;
		this.expertTecRecommend = expertTecRecommend;
		this.expertInvOpinion = expertInvOpinion;
		this.expertInvRecommend = expertInvRecommend;
		
		this.projectTechnologyAverage = projectTechnologyAverage;
		this.projectInvestmentAverage = projectInvestmentAverage;
		this.projectAverage = projectAverage;
		this.projectTechnologyResult = projectTechnologyResult;
		this.projectInvestmentResult = projectInvestmentResult;
		
		this.jointStatus = jointStatus;
		this.expertOpinionStatus = expertOpinionStatus;
		this.expertScoreStatus = expertScoreStatus;
		
		this.tfinancingUses = tfinancingUses;
		this.tsupervisors = tsupervisors;
		this.tcostEstimateBs = tcostEstimateBs;
		this.texpertScores = texpertScores;
		this.treviewCommentses = treviewCommentses;
		this.tcompanyNeedBs = tcompanyNeedBs;
		this.tcontracts = tcontracts;
		this.treportAbstractBs = treportAbstractBs;
		this.tprojectInfoAs = tprojectInfoAs;
		this.tcompanyFoundationBs = tcompanyFoundationBs;
		this.teconomicIndicatorBs = teconomicIndicatorBs;
		this.tenterpriseProfileAs = tenterpriseProfileAs;
		this.tresearchers = tresearchers;
		this.ttechnicalContentAs = ttechnicalContentAs;
		this.tmoneyScheduleAs = tmoneyScheduleAs;
		this.tprojectOverviewAs = tprojectOverviewAs;
		this.tacceptances = tacceptances;
		this.tprojectInfoBs = tprojectInfoBs;
		this.tprojectRecords = tprojectRecords;
		this.teconomicIndicatorAs = teconomicIndicatorAs;
		this.tschedulingAs = tschedulingAs;
		this.tcompanyInfos = tcompanyInfos;
		this.ttechnicalIndexes = ttechnicalIndexes;
		this.texpectedResults = texpectedResults;
		this.tfundPlanB = tfundPlanB;
		this.treportObjectives = treportObjectives;
		this.tempProjectId = tempProjectId;
		this.inputTotal =  inputTotal;
		this.researchFunds = researchFunds;
		this.selfFinancing = selfFinancing;
		this.projectExpectOutput = projectExpectOutput;
		this.projectExpectProfitTax = projectExpectProfitTax;
		this.companyExpectOutput = companyExpectOutput;
		this.companyExpectProfitTax = companyExpectProfitTax;
		this.tfundingPlanReport = tfundingPlanReport;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PROJECT_ID", unique = true, nullable = false, length = 40)
	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE_ID")
	public TprojectType getTprojectType() {
		return this.tprojectType;
	}

	public void setTprojectType(TprojectType tprojectType) {
		this.tprojectType = tprojectType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GROUP_ID")
	public TprojectGroup getTprojectGroup() {
		return this.tprojectGroup;
	}

	public void setTprojectGroup(TprojectGroup tprojectGroup) {
		this.tprojectGroup = tprojectGroup;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLAN_ID")
	public Tplan getTplan() {
		return this.tplan;
	}

	public void setTplan(Tplan tplan) {
		this.tplan = tplan;
	}

	@Column(name = "USER_ID", length = 40)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "PROJECT_NUMBER", length = 200)
	public String getProjectNumber() {
		return this.projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	@Column(name = "PROJECT_NAME", length = 100)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "PLAN_NUMBER", length = 200)
	public String getPlanNumber() {
		return this.planNumber;
	}

	public void setPlanNumber(String planNumber) {
		this.planNumber = planNumber;
	}

	@Column(name = "APPLY_STATUS", length = 40)
	public String getApplyStatus() {
		return this.applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	@Column(name = "FLOW_STATUS", length = 40)
	public String getFlowStatus() {
		return this.flowStatus;
	}

	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}

	@Column(name = "APPLICATION_UNIT", length = 100)
	public String getApplicationUnit() {
		return this.applicationUnit;
	}

	public void setApplicationUnit(String applicationUnit) {
		this.applicationUnit = applicationUnit;
	}

	@Column(name = "CENTRALIZED_TYPE", length = 40)
	public String getCentralizedType() {
		return this.centralizedType;
	}

	public void setCentralizedType(String centralizedType) {
		this.centralizedType = centralizedType;
	}

	/**
	 * @return the centralizedTypeName
	 */
	@Transient
	public String getCentralizedTypeName() {
		return centralizedTypeName;
	}

	/**
	 * @param centralizedTypeName the centralizedTypeName to set
	 */
	public void setCentralizedTypeName(String centralizedTypeName) {
		this.centralizedTypeName = centralizedTypeName;
	}

	@Column(name = "PLAN_FLAG", length = 40)
	public String getPlanFlag() {
		return this.planFlag;
	}

	public void setPlanFlag(String planFlag) {
		this.planFlag = planFlag;
	}

	@Column(name = "SUPPORT_FUNCTION", length = 40)
	public String getSupportFunction() {
		return this.supportFunction;
	}

	public void setSupportFunction(String supportFunction) {
		this.supportFunction = supportFunction;
	}

	@Column(name = "SUPPORT_FLAG", length = 40)
	public String getSupportFlag() {
		return this.supportFlag;
	}
	public void setSupportFlag(String supportFlag) {
		this.supportFlag = supportFlag;
	}
	@Transient
	public String getApplyStatusString() {
		return applyStatusString;
	}
	public void setApplyStatusString(String applyStatusString) {
		this.applyStatusString = applyStatusString;
	}
	
	@Transient
	public String getProjectReportText() {
		return projectReportText;
	}
	public void setProjectReportText(String projectReportText) {
		this.projectReportText = projectReportText;
	}	
	@Transient
	public String getProjectReportTime() {
		return projectReportTime;
	}

	public void setProjectReportTime(String projectReportTime) {
		this.projectReportTime = projectReportTime;
	}
	@Column(name = "PROJECT_NUMBER_TEMP", length = 200)
	public String getProjectNumberTemp() {
		return projectNumberTemp;
	}

	public void setProjectNumberTemp(String projectNumberTemp) {
		this.projectNumberTemp = projectNumberTemp;
	}

	@Column(name = "START_TIME")
	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	@Column(name = "END_TIME")
	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	@Column(name = "HANDLE_TIME")
	public Timestamp getHandleTime() {
		return this.handleTime;
	}

	public void setHandleTime(Timestamp handleTime) {
		this.handleTime = handleTime;
	}

	@Column(name = "REPORT_YEAR", length = 50)
	public String getReportYear() {
		return this.reportYear;
	}

	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}

	@Column(name = "COMPILATION_DEPT", length = 200)
	public String getCompilationDept() {
		return this.compilationDept;
	}

	public void setCompilationDept(String compilationDept) {
		this.compilationDept = compilationDept;
	}

	@Column(name = "COMPILATION_TIME", length = 50)
	public String getCompilationTime() {
		return this.compilationTime;
	}

	public void setCompilationTime(String compilationTime) {
		this.compilationTime = compilationTime;
	}

	@Column(name = "PDF_URL", length = 300)
	public String getPdfUrl() {
		return this.pdfUrl;
	}

	public void setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
	}

	@Column(name = "OPT_USER", length = 40)
	public String getOptUser() {
		return this.optUser;
	}

	public void setOptUser(String optUser) {
		this.optUser = optUser;
	}

	@Column(name = "INITIAL_AUDIT_OPINION", length = 4000)
	public String getInitialAuditOpinion() {
		return this.initialAuditOpinion;
	}

	public void setInitialAuditOpinion(String initialAuditOpinion) {
		this.initialAuditOpinion = initialAuditOpinion;
	}

	@Column(name = "DEPLOY_OPINION", length = 4000)
	public String getDeployOpinion() {
		return this.deployOpinion;
	}

	public void setDeployOpinion(String deployOpinion) {
		this.deployOpinion = deployOpinion;
	}

	@Column(name = "EXPERT_AUDIT_RESEARCH", length = 4000)
	public String getExpertAuditResearch() {
		return this.expertAuditResearch;
	}

	public void setExpertAuditResearch(String expertAuditResearch) {
		this.expertAuditResearch = expertAuditResearch;
	}

	@Column(name = "EXPERT_AUDIT_COMPOSITE", length = 4000)
	public String getExpertAuditComposite() {
		return this.expertAuditComposite;
	}

	public void setExpertAuditComposite(String expertAuditComposite) {
		this.expertAuditComposite = expertAuditComposite;
	}

	@Column(name = "EXPERT_AUDIT_RECOMMEND", length = 4000)
	public String getExpertAuditRecommend() {
		return this.expertAuditRecommend;
	}

	public void setExpertAuditRecommend(String expertAuditRecommend) {
		this.expertAuditRecommend = expertAuditRecommend;
	}

	@Column(name = "EXPERT_PROOF_RESEARCH", length = 4000)
	public String getExpertProofResearch() {
		return this.expertProofResearch;
	}

	public void setExpertProofResearch(String expertProofResearch) {
		this.expertProofResearch = expertProofResearch;
	}

	@Column(name = "EXPERT_PROOF_COMPOSITE", length = 4000)
	public String getExpertProofComposite() {
		return this.expertProofComposite;
	}

	public void setExpertProofComposite(String expertProofComposite) {
		this.expertProofComposite = expertProofComposite;
	}

	@Column(name = "EXPERT_PROOF_RECOMMEND", length = 4000)
	public String getExpertProofRecommend() {
		return this.expertProofRecommend;
	}

	public void setExpertProofRecommend(String expertProofRecommend) {
		this.expertProofRecommend = expertProofRecommend;
	}

	@Column(name = "COMMISSIONER_OPINION", length = 4000)
	public String getCommissionerOpinion() {
		return this.commissionerOpinion;
	}

	public void setCommissionerOpinion(String commissionerOpinion) {
		this.commissionerOpinion = commissionerOpinion;
	}

	@Column(name = "MEETING_OPINION", length = 4000)
	public String getMeetingOpinion() {
		return this.meetingOpinion;
	}

	public void setMeetingOpinion(String meetingOpinion) {
		this.meetingOpinion = meetingOpinion;
	}
	@Column(name = "IS_ARCHIVAL", length = 50)
	public String getIsArchival() {
		return this.isArchival;
	}

	public void setIsArchival(String isArchival) {
		this.isArchival = isArchival;
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

	@Column(name = "CREATE_TIME")
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "UPDATE_USER", length = 50)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Column(name = "UPDATE_TIME")
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name = "WRITEREPOT_TIME")
	public Timestamp getWriteReportTime() {
		return writeReportTime;
	}

	public void setWriteReportTime(Timestamp writeReportTime) {
		this.writeReportTime = writeReportTime;
	}
	@Column(name = "ARCHIVAL_TIME")
	public Timestamp getArchivalTime() {
		return archivalTime;
	}

	public void setArchivalTime(Timestamp archivalTime) {
		this.archivalTime = archivalTime;
	}

	@Column(name = "TYPE_NAME", length = 500)
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Column(name = "PLAN_FLAG_NAME", length = 500)
	public String getPlanFlagName() {
		return planFlagName;
	}

	public void setPlanFlagName(String planFlagName) {
		this.planFlagName = planFlagName;
	}
	@Transient
	public String getProjectViewType() {
		return projectViewType;
	}

	public void setProjectViewType(String projectViewType) {
		this.projectViewType = projectViewType;
	}

	@Column(name = "ENTRUST_UNIT", length = 100)
	public String getEntrustUnit() {
		return entrustUnit;
	}

	public void setEntrustUnit(String entrustUnit) {
		this.entrustUnit = entrustUnit;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TfinancingUse> getTfinancingUses() {
		return this.tfinancingUses;
	}

	public void setTfinancingUses(List<TfinancingUse> tfinancingUses) {
		this.tfinancingUses = tfinancingUses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<Tsupervisor> getTsupervisors() {
		return this.tsupervisors;
	}

	public void setTsupervisors(List<Tsupervisor> tsupervisors) {
		this.tsupervisors = tsupervisors;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TcostEstimateB> getTcostEstimateBs() {
		return this.tcostEstimateBs;
	}

	public void setTcostEstimateBs(List<TcostEstimateB> tcostEstimateBs) {
		this.tcostEstimateBs = tcostEstimateBs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TexpertScore> getTexpertScores() {
		return this.texpertScores;
	}

	public void setTexpertScores(List<TexpertScore> texpertScores) {
		this.texpertScores = texpertScores;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TreviewComments> getTreviewCommentses() {
		return this.treviewCommentses;
	}

	public void setTreviewCommentses(List<TreviewComments> treviewCommentses) {
		this.treviewCommentses = treviewCommentses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TcompanyNeedB> getTcompanyNeedBs() {
		return this.tcompanyNeedBs;
	}

	public void setTcompanyNeedBs(List<TcompanyNeedB> tcompanyNeedBs) {
		this.tcompanyNeedBs = tcompanyNeedBs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<Tcontract> getTcontracts() {
		return this.tcontracts;
	}

	public void setTcontracts(List<Tcontract> tcontracts) {
		this.tcontracts = tcontracts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TreportAbstractB> getTreportAbstractBs() {
		return this.treportAbstractBs;
	}

	public void setTreportAbstractBs(List<TreportAbstractB> treportAbstractBs) {
		this.treportAbstractBs = treportAbstractBs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TprojectInfoA> getTprojectInfoAs() {
		return this.tprojectInfoAs;
	}

	public void setTprojectInfoAs(List<TprojectInfoA> tprojectInfoAs) {
		this.tprojectInfoAs = tprojectInfoAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TcompanyFoundationB> getTcompanyFoundationBs() {
		return this.tcompanyFoundationBs;
	}

	public void setTcompanyFoundationBs(
			List<TcompanyFoundationB> tcompanyFoundationBs) {
		this.tcompanyFoundationBs = tcompanyFoundationBs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TeconomicIndicatorB> getTeconomicIndicatorBs() {
		return this.teconomicIndicatorBs;
	}

	public void setTeconomicIndicatorBs(
			List<TeconomicIndicatorB> teconomicIndicatorBs) {
		this.teconomicIndicatorBs = teconomicIndicatorBs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TenterpriseProfileA> getTenterpriseProfileAs() {
		return this.tenterpriseProfileAs;
	}

	public void setTenterpriseProfileAs(
			List<TenterpriseProfileA> tenterpriseProfileAs) {
		this.tenterpriseProfileAs = tenterpriseProfileAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<Tresearcher> getTresearchers() {
		return this.tresearchers;
	}

	public void setTresearchers(List<Tresearcher> tresearchers) {
		this.tresearchers = tresearchers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TtechnicalContentA> getTtechnicalContentAs() {
		return this.ttechnicalContentAs;
	}

	public void setTtechnicalContentAs(
			List<TtechnicalContentA> ttechnicalContentAs) {
		this.ttechnicalContentAs = ttechnicalContentAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TmoneyScheduleA> getTmoneyScheduleAs() {
		return this.tmoneyScheduleAs;
	}

	public void setTmoneyScheduleAs(List<TmoneyScheduleA> tmoneyScheduleAs) {
		this.tmoneyScheduleAs = tmoneyScheduleAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TprojectOverviewA> getTprojectOverviewAs() {
		return this.tprojectOverviewAs;
	}

	public void setTprojectOverviewAs(List<TprojectOverviewA> tprojectOverviewAs) {
		this.tprojectOverviewAs = tprojectOverviewAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<Tacceptance> getTacceptances() {
		return this.tacceptances;
	}

	public void setTacceptances(List<Tacceptance> tacceptances) {
		this.tacceptances = tacceptances;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TprojectInfoB> getTprojectInfoBs() {
		return this.tprojectInfoBs;
	}

	public void setTprojectInfoBs(List<TprojectInfoB> tprojectInfoBs) {
		this.tprojectInfoBs = tprojectInfoBs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TprojectRecord> getTprojectRecords() {
		return this.tprojectRecords;
	}

	public void setTprojectRecords(List<TprojectRecord> tprojectRecords) {
		this.tprojectRecords = tprojectRecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TeconomicIndicatorA> getTeconomicIndicatorAs() {
		return this.teconomicIndicatorAs;
	}

	public void setTeconomicIndicatorAs(
			List<TeconomicIndicatorA> teconomicIndicatorAs) {
		this.teconomicIndicatorAs = teconomicIndicatorAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TschedulingA> getTschedulingAs() {
		return tschedulingAs;
	}

	public void setTschedulingAs(List<TschedulingA> tschedulingAs) {
		this.tschedulingAs = tschedulingAs;
	}
	
	@Transient
	public String getTprojectTypeName() {
		return tprojectTypeName;
	}

	public void setTprojectTypeName(String tprojectTypeName) {
		this.tprojectTypeName = tprojectTypeName;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TcompanyInfo> getTcompanyInfos() {
		return tcompanyInfos;
	}

	public void setTcompanyInfos(List<TcompanyInfo> tcompanyInfos) {
		this.tcompanyInfos = tcompanyInfos;
	}
	@Transient
	public String getUnitProperties() {
		return unitProperties;
	}

	public void setUnitProperties(String unitProperties) {
		this.unitProperties = unitProperties;
	}
	@Transient
	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	@Transient
	public String getProjectViewTypeStartTime() {
		return projectViewTypeStartTime;
	}

	public void setProjectViewTypeStartTime(String projectViewTypeStartTime) {
		this.projectViewTypeStartTime = projectViewTypeStartTime;
	}
	@Transient
	public String getProjectViewTypeEndTime() {
		return projectViewTypeEndTime;
	}

	public void setProjectViewTypeEndTime(String projectViewTypeEndTime) {
		this.projectViewTypeEndTime = projectViewTypeEndTime;
	}
	@Transient
	public String getProjectTotal() {
		return projectTotal;
	}

	public void setProjectTotal(String projectTotal) {
		this.projectTotal = projectTotal;
	}
	@Transient
	public String getNoViewProjectTotal() {
		return noViewProjectTotal;
	}

	public void setNoViewProjectTotal(String noViewProjectTotal) {
		this.noViewProjectTotal = noViewProjectTotal;
	}

	@Transient
	public String getNoPassProject() {
		return noPassProject;
	}

	public void setNoPassProject(String noPassProject) {
		this.noPassProject = noPassProject;
	}
	@Transient
	public String getNoAcceptanceProject() {
		return noAcceptanceProject;
	}

	public void setNoAcceptanceProject(String noAcceptanceProject) {
		this.noAcceptanceProject = noAcceptanceProject;
	}
	@Transient
	public String getPassAcceptanceProject() {
		return passAcceptanceProject;
	}

	public void setPassAcceptanceProject(String passAcceptanceProject) {
		this.passAcceptanceProject = passAcceptanceProject;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TtechnicalIndexes> getTtechnicalIndexes() {
		return ttechnicalIndexes;
	}

	public void setTtechnicalIndexes(List<TtechnicalIndexes> ttechnicalIndexes) {
		this.ttechnicalIndexes = ttechnicalIndexes;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TexpectedResults> getTexpectedResults() {
		return texpectedResults;
	}

	public void setTexpectedResults(List<TexpectedResults> texpectedResults) {
		this.texpectedResults = texpectedResults;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TfundPlanB> getTfundPlanB() {
		return tfundPlanB;
	}

	public void setTfundPlanB(List<TfundPlanB> tfundPlanB) {
		this.tfundPlanB = tfundPlanB;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TreportObjectives> getTreportObjectives() {
		return treportObjectives;
	}

	public void setTreportObjectives(List<TreportObjectives> treportObjectives) {
		this.treportObjectives = treportObjectives;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectApplication")
	public List<TfundingPlanReport> getTfundingPlanReport() {
		return tfundingPlanReport;
	}

	public void setTfundingPlanReport(List<TfundingPlanReport> tfundingPlanReport) {
		this.tfundingPlanReport = tfundingPlanReport;
	}

	@Column(name = "TEMP_PROJECT_ID", length = 40)
	public String getTempProjectId() {
		return tempProjectId;
	}

	public void setTempProjectId(String tempProjectId) {
		this.tempProjectId = tempProjectId;
	}

	@Transient
	public double getInputTotal() {
		return inputTotal;
	}

	public void setInputTotal(double inputTotal) {
		this.inputTotal = inputTotal;
	}

	@Transient
	public double getResearchFunds() {
		return researchFunds;
	}

	public void setResearchFunds(double researchFunds) {
		this.researchFunds = researchFunds;
	}

	@Transient
	public double getSelfFinancing() {
		return selfFinancing;
	}

	public void setSelfFinancing(double selfFinancing) {
		this.selfFinancing = selfFinancing;
	}

	@Transient
	public double getProjectExpectOutput() {
		return projectExpectOutput;
	}

	public void setProjectExpectOutput(double projectExpectOutput) {
		this.projectExpectOutput = projectExpectOutput;
	}

	@Transient
	public double getProjectExpectProfitTax() {
		return projectExpectProfitTax;
	}

	public void setProjectExpectProfitTax(double projectExpectProfitTax) {
		this.projectExpectProfitTax = projectExpectProfitTax;
	}

	@Transient
	public double getCompanyExpectOutput() {
		return companyExpectOutput;
	}

	public void setCompanyExpectOutput(double companyExpectOutput) {
		this.companyExpectOutput = companyExpectOutput;
	}

	@Transient
	public double getCompanyExpectProfitTax() {
		return companyExpectProfitTax;
	}

	public void setCompanyExpectProfitTax(double companyExpectProfitTax) {
		this.companyExpectProfitTax = companyExpectProfitTax;
	}
	
	@Column(name = "FIRST_SECOND", length = 1)
	public String getFirstSecond() {
		return firstSecond;
	}

	public void setFirstSecond(String firstSecond) {
		this.firstSecond = firstSecond;
	}

	@Column(name = "EXPERT_TEC_OPINION", length = 2000)
	public String getExpertTecOpinion() {
		return expertTecOpinion;
	}

	public void setExpertTecOpinion(String expertTecOpinion) {
		this.expertTecOpinion = expertTecOpinion;
	}

	@Column(name = "EXPERT_TEC_RECOMMEND", length = 40)
	public String getExpertTecRecommend() {
		return expertTecRecommend;
	}

	public void setExpertTecRecommend(String expertTecRecommend) {
		this.expertTecRecommend = expertTecRecommend;
	}

	@Column(name = "EXPERT_INV_OPINION", length = 2000)
	public String getExpertInvOpinion() {
		return expertInvOpinion;
	}

	public void setExpertInvOpinion(String expertInvOpinion) {
		this.expertInvOpinion = expertInvOpinion;
	}

	@Column(name = "EXPERT_INV_RECOMMEND", length = 40)
	public String getExpertInvRecommend() {
		return expertInvRecommend;
	}

	public void setExpertInvRecommend(String expertInvRecommend) {
		this.expertInvRecommend = expertInvRecommend;
	}

	@Column(name = "JOINT_STATUS", length = 40)
	public String getJointStatus() {
		return jointStatus;
	}

	public void setJointStatus(String jointStatus) {
		this.jointStatus = jointStatus;
	}

	@Column(name = "EXPERT_OPINION_STATUS", length = 40)
	public String getExpertOpinionStatus() {
		return expertOpinionStatus;
	}

	public void setExpertOpinionStatus(String expertOpinionStatus) {
		this.expertOpinionStatus = expertOpinionStatus;
	}

	@Column(name = "EXPERT_SCORE_STATUS", length = 40)
	public String getExpertScoreStatus() {
		return expertScoreStatus;
	}

	public void setExpertScoreStatus(String expertScoreStatus) {
		this.expertScoreStatus = expertScoreStatus;
	}

	@Column(name = "PROJECT_TECHNOLOGY_AVERAGE", precision = 5, scale = 2)
	public double getProjectTechnologyAverage() {
		return projectTechnologyAverage;
	}

	public void setProjectTechnologyAverage(double projectTechnologyAverage) {
		this.projectTechnologyAverage = projectTechnologyAverage;
	}

	@Column(name = "PROJECT_INVESTMENT_AVERAGE" , precision = 5, scale = 2)
	public double getProjectInvestmentAverage() {
		return projectInvestmentAverage;
	}

	public void setProjectInvestmentAverage(double projectInvestmentAverage) {
		this.projectInvestmentAverage = projectInvestmentAverage;
	}

	@Column(name = "PROJECT_AVERAGE", precision = 5, scale = 2)
	public double getProjectAverage() {
		return projectAverage;
	}

	public void setProjectAverage(double projectAverage) {
		this.projectAverage = projectAverage;
	}

	@Column(name = "PROJECT_TECHNOLOGY_RESULT", length = 50)
	public String getProjectTechnologyResult() {
		return projectTechnologyResult;
	}

	public void setProjectTechnologyResult(String projectTechnologyResult) {
		this.projectTechnologyResult = projectTechnologyResult;
	}

	@Column(name = "PROJECT_INVESTMENT_RESULT", length = 50)
	public String getProjectInvestmentResult() {
		return projectInvestmentResult;
	}

	public void setProjectInvestmentResult(String projectInvestmentResult) {
		this.projectInvestmentResult = projectInvestmentResult;
	}

}
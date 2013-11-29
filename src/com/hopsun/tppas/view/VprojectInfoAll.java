package com.hopsun.tppas.view;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @comments 项目信息视图实体
 * @author liyl
 * @date 2013-5-17 下午4:10:37
 * @version 1.0
 */
@Entity
@Table(name = "V_PROJECT_INFO_ALL")
public class VprojectInfoAll implements java.io.Serializable {

	private static final long serialVersionUID = 4035906369857797336L;
	// Fields
	private String projectId;
	private String typeId;
	private String groupId;
	private String planId;
	private String deptId;
	private String typeRealName;
	private String typeShowName;
	private String userId;
	private String projectNumber;
	private String projectName;
	private String planNumber;
	private String applyStatus;
	private String applyStatusName;
	private String regionId1;
    private String regionId2;
    private String regionId3;
    private String regionIdName1;
    private String regionIdName2;
    private String regionIdName3;
    private String unitAddress;
    private String zipcode;
    private String industries1;
    private String industries2;
    private String industries3;
    private String industries4;
    private String industriesName1;
    private String industriesName2;
    private String industriesName3;
    private String industriesName4;
    // 单位性质
    private String unitProperties;
	private String unitPropertiesName;
    private String legalPerson;
    private String legalTel;
    private String projectPerson;
    private String personTel;
    private String touchPerson;
    private String touchPhone;
    private String assistUnit;
    // 技术类别
    private String technicalFisld;
    private String technicalFisld1;
    private String technicalFisld2;
    private String technicalFisld3;
 	private String technicalFisldName;
    private String intellectualProperty;
    private String technologySource;
	private String flowStatus;
	private String applicationUnit;
	private String centralizedType;
	private String centralizedTypeName;
	private String planFlag;
	private String typeName;
	private String planFlagName;
	private String supportFunction;
	private String supportFlag;
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

	/** 合同状态 临时 */
	private String contractStatus;
	
	// Constructors

	/** default constructor */
	public VprojectInfoAll() {
	}

	public VprojectInfoAll(String projectId, String typeId, String groupId,
			String planId, String deptId, String typeRealName, String typeShowName,
			String userId, String projectNumber, String projectName,
			String planNumber, String applyStatus, String applyStatusName, String regionId1,
			String regionId2, String regionId3, String regionIdName1,
			String regionIdName2, String regionIdName3, String unitAddress,
			String zipcode, String industries1, String industries2,
			String industries3, String industries4, String industriesName1,
			String industriesName2, String industriesName3,
			String industriesName4, String unitProperties,
			String unitPropertiesName, String legalPerson, String legalTel,
			String projectPerson, String personTel, String touchPerson,
			String touchPhone, String assistUnit, String technicalFisld,
			String technicalFisld1, String technicalFisld2, String technicalFisld3,
			String technicalFisldName, String intellectualProperty,
			String technologySource, String flowStatus, String applicationUnit,
			String centralizedType, String centralizedTypeName, String planFlag, String typeName, String planFlagName,
			String supportFunction, String supportFlag, Timestamp startTime,
			Timestamp endTime, Timestamp handleTime, String reportYear,
			String compilationDept, String compilationTime, String pdfUrl,
			String optUser, String initialAuditOpinion, String deployOpinion,
			String expertAuditResearch, String expertAuditComposite,
			String expertAuditRecommend, String expertProofResearch,
			String expertProofComposite, String expertProofRecommend,
			String commissionerOpinion, String meetingOpinion, String isArchival,
			String deleteFlag, String createUser, Timestamp createTime,
			String updateUser, Timestamp updateTime, String remark,String contractStatus) {
		super();
		this.projectId = projectId;
		this.typeId = typeId;
		this.groupId = groupId;
		this.planId = planId;
		this.deptId = deptId;
		this.typeRealName = typeRealName;
		this.typeShowName = typeShowName;
		this.userId = userId;
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.planNumber = planNumber;
		this.applyStatus = applyStatus;
		this.applyStatusName = applyStatusName;
		this.regionId1 = regionId1;
		this.regionId2 = regionId2;
		this.regionId3 = regionId3;
		this.regionIdName1 = regionIdName1;
		this.regionIdName2 = regionIdName2;
		this.regionIdName3 = regionIdName3;
		this.unitAddress = unitAddress;
		this.zipcode = zipcode;
		this.industries1 = industries1;
		this.industries2 = industries2;
		this.industries3 = industries3;
		this.industries4 = industries4;
		this.industriesName1 = industriesName1;
		this.industriesName2 = industriesName2;
		this.industriesName3 = industriesName3;
		this.industriesName4 = industriesName4;
		this.unitProperties = unitProperties;
		this.unitPropertiesName = unitPropertiesName;
		this.legalPerson = legalPerson;
		this.legalTel = legalTel;
		this.projectPerson = projectPerson;
		this.personTel = personTel;
		this.touchPerson = touchPerson;
		this.touchPhone = touchPhone;
		this.assistUnit = assistUnit;
		this.technicalFisld = technicalFisld;
		this.technicalFisld1 = technicalFisld1;
		this.technicalFisld2 = technicalFisld2;
		this.technicalFisld3 = technicalFisld3;
		this.technicalFisldName = technicalFisldName;
		this.intellectualProperty = intellectualProperty;
		this.technologySource = technologySource;
		this.flowStatus = flowStatus;
		this.applicationUnit = applicationUnit;
		this.centralizedType = centralizedType;
		this.centralizedTypeName = centralizedTypeName;
		this.planFlag = planFlag;
		this.typeName = typeName;
		this.planFlagName = planFlagName;
		this.supportFunction = supportFunction;
		this.supportFlag = supportFlag;
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
		this.contractStatus = contractStatus;
	}

	@Id
	@Column(name = "PROJECT_ID", unique = true, nullable = false, length = 40)
	public String getProjectId() {
		return projectId;
	}

	@Column(name = "TYPE_ID", length = 40)
	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	@Column(name = "GROUP_ID", length = 40)
	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Column(name = "PLAN_ID", length = 40)
	public String getPlanId() {
		return this.planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

 	/**
	 * @return the deptId
	 */
	@Column(name = "DEPARTMENT_ID", length = 40)
	public String getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return the typeRealName
	 */
	@Column(name = "TYPE_REAL_NAME", length = 200)
	public String getTypeRealName() {
		return typeRealName;
	}


	/**
	 * @param typeRealName the typeRealName to set
	 */
	public void setTypeRealName(String typeRealName) {
		this.typeRealName = typeRealName;
	}


	/**
	 * @return the typeShowName
	 */
	@Column(name = "TYPE_SHOW_NAME", length = 200)
	public String getTypeShowName() {
		return typeShowName;
	}


	/**
	 * @param typeShowName the typeShowName to set
	 */
	public void setTypeShowName(String typeShowName) {
		this.typeShowName = typeShowName;
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
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
	
	@Column(name = "APPLY_STATUS_NAME", length = 100)
	public String getApplyStatusName() {
		return this.applyStatusName;
	}

	public void setApplyStatusName(String applyStatusName) {
		this.applyStatusName = applyStatusName;
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
	 * @return the planFlag
	 */
	@Column(name = "PLAN_FLAG", length = 40)
	public String getPlanFlag() {
		return planFlag;
	}

	/**
	 * @param planFlag the planFlag to set
	 */
	public void setPlanFlag(String planFlag) {
		this.planFlag = planFlag;
	}

	/**
	 * @return the typeName
	 */
	@Column(name = "TYPE_NAME", length = 400)
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Column(name = "PLAN_FLAG_NAME", length = 400)
	public String getPlanFlagName() {
		return this.planFlagName;
	}

	public void setPlanFlagName(String planFlagName) {
		this.planFlagName = planFlagName;
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

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@Column(name = "UNIT_PROPERTIES_NAME", length = 40)
	public String getUnitPropertiesName() {
		return unitPropertiesName;
	}

	public void setUnitPropertiesName(String unitPropertiesName) {
		this.unitPropertiesName = unitPropertiesName;
	}

	@Column(name = "TECHNICAL_FISLD_NAME", length = 40)
	public String getTechnicalFisldName() {
		return technicalFisldName;
	}

	public void setTechnicalFisldName(String technicalFisldName) {
		this.technicalFisldName = technicalFisldName;
	}

	/**
	 * @return the regionId1
	 */
	@Column(name = "REGION_ID_1", length = 40)
	public String getRegionId1() {
		return regionId1;
	}

	/**
	 * @param regionId1 the regionId1 to set
	 */
	public void setRegionId1(String regionId1) {
		this.regionId1 = regionId1;
	}

	/**
	 * @return the regionId2
	 */
	@Column(name = "REGION_ID_2", length = 40)
	public String getRegionId2() {
		return regionId2;
	}

	/**
	 * @param regionId2 the regionId2 to set
	 */
	public void setRegionId2(String regionId2) {
		this.regionId2 = regionId2;
	}

	/**
	 * @return the regionId3
	 */
	@Column(name = "REGION_ID_3", length = 40)
	public String getRegionId3() {
		return regionId3;
	}

	/**
	 * @param regionId3 the regionId3 to set
	 */
	public void setRegionId3(String regionId3) {
		this.regionId3 = regionId3;
	}

	/**
	 * @return the unitAddress
	 */
	@Column(name = "UNIT_ADDRESS", length = 100)
	public String getUnitAddress() {
		return unitAddress;
	}

	/**
	 * @param unitAddress the unitAddress to set
	 */
	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}

	/**
	 * @return the zipcode
	 */
	@Column(name = "ZIPCODE", length = 10)
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the industries1
	 */
	@Column(name = "INDUSTRIES_1", length = 40)
	public String getIndustries1() {
		return industries1;
	}

	/**
	 * @param industries1 the industries1 to set
	 */
	public void setIndustries1(String industries1) {
		this.industries1 = industries1;
	}

	/**
	 * @return the industries2
	 */
	@Column(name = "INDUSTRIES_2", length = 40)
	public String getIndustries2() {
		return industries2;
	}

	/**
	 * @param industries2 the industries2 to set
	 */
	public void setIndustries2(String industries2) {
		this.industries2 = industries2;
	}

	/**
	 * @return the industries3
	 */
	@Column(name = "INDUSTRIES_3", length = 40)
	public String getIndustries3() {
		return industries3;
	}

	/**
	 * @param industries3 the industries3 to set
	 */
	public void setIndustries3(String industries3) {
		this.industries3 = industries3;
	}

	/**
	 * @return the industries4
	 */
	@Column(name = "INDUSTRIES_4", length = 40)
	public String getIndustries4() {
		return industries4;
	}

	/**
	 * @param industries4 the industries4 to set
	 */
	public void setIndustries4(String industries4) {
		this.industries4 = industries4;
	}

	/**
	 * @return the unitProperties
	 */
	@Column(name = "UNIT_PROPERTIES", length = 100)
	public String getUnitProperties() {
		return unitProperties;
	}

	/**
	 * @param unitProperties the unitProperties to set
	 */
	public void setUnitProperties(String unitProperties) {
		this.unitProperties = unitProperties;
	}

	/**
	 * @return the legalPerson
	 */
	@Column(name = "LEGAL_PERSON", length = 60)
	public String getLegalPerson() {
		return legalPerson;
	}

	/**
	 * @param legalPerson the legalPerson to set
	 */
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	/**
	 * @return the legalTel
	 */
	@Column(name = "LEGAL_TEL", length = 15)
	public String getLegalTel() {
		return legalTel;
	}

	/**
	 * @param legalTel the legalTel to set
	 */
	public void setLegalTel(String legalTel) {
		this.legalTel = legalTel;
	}

	/**
	 * @return the projectPerson
	 */
	@Column(name = "PROJECT_PERSON", length = 60)
	public String getProjectPerson() {
		return projectPerson;
	}

	/**
	 * @param projectPerson the projectPerson to set
	 */
	public void setProjectPerson(String projectPerson) {
		this.projectPerson = projectPerson;
	}

	/**
	 * @return the personTel
	 */
	@Column(name = "PERSON_TEL", length = 15)
	public String getPersonTel() {
		return personTel;
	}

	/**
	 * @param personTel the personTel to set
	 */
	public void setPersonTel(String personTel) {
		this.personTel = personTel;
	}

	/**
	 * @return the touchPerson
	 */
	@Column(name = "TOUCH_PERSON", length = 60)
	public String getTouchPerson() {
		return touchPerson;
	}

	/**
	 * @param touchPerson the touchPerson to set
	 */
	public void setTouchPerson(String touchPerson) {
		this.touchPerson = touchPerson;
	}

	/**
	 * @return the touchPhone
	 */
	@Column(name = "TOUCH_PHONE", length = 15)
	public String getTouchPhone() {
		return touchPhone;
	}

	/**
	 * @param touchPhone the touchPhone to set
	 */
	public void setTouchPhone(String touchPhone) {
		this.touchPhone = touchPhone;
	}

	/**
	 * @return the assistUnit
	 */
	@Column(name = "ASSIST_UNIT", length = 60)
	public String getAssistUnit() {
		return assistUnit;
	}

	/**
	 * @param assistUnit the assistUnit to set
	 */
	public void setAssistUnit(String assistUnit) {
		this.assistUnit = assistUnit;
	}

	/**
	 * @return the technicalFisld
	 */
	@Column(name = "TECHNICAL_FISLD", length = 40)
	public String getTechnicalFisld() {
		return technicalFisld;
	}

	/**
	 * @param technicalFisld the technicalFisld to set
	 */
	public void setTechnicalFisld(String technicalFisld) {
		this.technicalFisld = technicalFisld;
	}

	@Column(name = "TECHNICAL_FISLD_1", length = 40)
	public String getTechnicalFisld1() {
		return technicalFisld1;
	}

	public void setTechnicalFisld1(String technicalFisld1) {
		this.technicalFisld1 = technicalFisld1;
	}

	@Column(name = "TECHNICAL_FISLD_2", length = 40)
	public String getTechnicalFisld2() {
		return technicalFisld2;
	}

	public void setTechnicalFisld2(String technicalFisld2) {
		this.technicalFisld2 = technicalFisld2;
	}

	@Column(name = "TECHNICAL_FISLD_3", length = 40)
	public String getTechnicalFisld3() {
		return technicalFisld3;
	}

	public void setTechnicalFisld3(String technicalFisld3) {
		this.technicalFisld3 = technicalFisld3;
	}

	/**
	 * @return the intellectualProperty
	 */
	@Column(name = "INTELLECTUAL_PROPERTY", length = 400)
	public String getIntellectualProperty() {
		return intellectualProperty;
	}

	/**
	 * @param intellectualProperty the intellectualProperty to set
	 */
	public void setIntellectualProperty(String intellectualProperty) {
		this.intellectualProperty = intellectualProperty;
	}

	/**
	 * @return the technologySource
	 */
	@Column(name = "TECHNOLOGY_SOURCE", length = 400)
	public String getTechnologySource() {
		return technologySource;
	}

	/**
	 * @param technologySource the technologySource to set
	 */
	public void setTechnologySource(String technologySource) {
		this.technologySource = technologySource;
	}


	/**
	 * @return the regionIdName1
	 */
	@Transient
	public String getRegionIdName1() {
		return regionIdName1;
	}


	/**
	 * @param regionIdName1 the regionIdName1 to set
	 */
	public void setRegionIdName1(String regionIdName1) {
		this.regionIdName1 = regionIdName1;
	}


	/**
	 * @return the regionIdName2
	 */
	@Transient
	public String getRegionIdName2() {
		return regionIdName2;
	}


	/**
	 * @param regionIdName2 the regionIdName2 to set
	 */
	public void setRegionIdName2(String regionIdName2) {
		this.regionIdName2 = regionIdName2;
	}


	/**
	 * @return the regionIdName3
	 */
	@Transient
	public String getRegionIdName3() {
		return regionIdName3;
	}


	/**
	 * @param regionIdName3 the regionIdName3 to set
	 */
	public void setRegionIdName3(String regionIdName3) {
		this.regionIdName3 = regionIdName3;
	}


	/**
	 * @return the industriesName1
	 */
	@Transient
	public String getIndustriesName1() {
		return industriesName1;
	}


	/**
	 * @param industriesName1 the industriesName1 to set
	 */
	public void setIndustriesName1(String industriesName1) {
		this.industriesName1 = industriesName1;
	}


	/**
	 * @return the industriesName2
	 */
	@Transient
	public String getIndustriesName2() {
		return industriesName2;
	}


	/**
	 * @param industriesName2 the industriesName2 to set
	 */
	public void setIndustriesName2(String industriesName2) {
		this.industriesName2 = industriesName2;
	}


	/**
	 * @return the industriesName3
	 */
	@Transient
	public String getIndustriesName3() {
		return industriesName3;
	}


	/**
	 * @param industriesName3 the industriesName3 to set
	 */
	public void setIndustriesName3(String industriesName3) {
		this.industriesName3 = industriesName3;
	}


	/**
	 * @return the industriesName4
	 */
	@Transient
	public String getIndustriesName4() {
		return industriesName4;
	}


	/**
	 * @param industriesName4 the industriesName4 to set
	 */
	public void setIndustriesName4(String industriesName4) {
		this.industriesName4 = industriesName4;
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

	@Transient
	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
	
}
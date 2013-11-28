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
 * Tplan entity. @auence Tools
 */
@Entity
@Table(name = "T_PLAN")
public class Tplan implements java.io.Serializable {

	private static final long serialVersionUID = 5605860500465444069L;
	// Fields

	private String planId;
	private TplanCollect tplanCollect;
	private String planName;
	private String planYear;
	private String planBatch;
	private String planState;
	private String deleteFlag;
	private String createUser;
	private Timestamp createTime;
	private String updateUser;
	private Timestamp updateDate;
	private String remark;
	
	private TprojectType tprojectType;
	private String planFlag;
	// 项目分类名称
	private String typeName;
	// 计划类别名称
	private String planFlagName;
	// 项目数
	private Integer projectCount;
	
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
	
	private String planStatusString;
	
	/** 临时字段 start*/
	private String projectName;
	private String applicationUnit;
	private String projectTypeName;
	private String applyStatus;
	private String unitProperties;
	private String typeId;
	private String index;
	/** 临时字段end*/
	private Set<TprojectApplication> tprojectApplications = new HashSet<TprojectApplication>(0);

	// Constructors

	/** default constructor */
	public Tplan() {
	}

	/** full constructor */
	public Tplan(TplanCollect tplanCollect, String planName, String planYear,
			String planBatch, String planState, String deleteFlag,
			String createUser, Timestamp createTime, String updateUser,
			Timestamp updateDate, String remark,String projectName,String applicationUnit,
			String projectTypeName,String applyStatus,String unitProperties,String typeId,
			TprojectType tprojectType,String planFlag,String typeName,String planFlagName,
			Integer projectCount,double inputTotal,double researchFunds,double selfFinancing,
			double projectExpectOutput,double projectExpectProfitTax,
			double companyExpectOutput,	double companyExpectProfitTax,
			String planStatusString, String index,
			Set<TprojectApplication> tprojectApplications) {
		this.tplanCollect = tplanCollect;
		this.planName = planName;
		this.planYear = planYear;
		this.planBatch = planBatch;
		this.planState = planState;
		this.deleteFlag = deleteFlag;
		this.createUser = createUser;
		this.createTime = createTime;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
		this.remark = remark;
		this.projectName = projectName;
		this.applicationUnit = applicationUnit;
		this.projectTypeName = projectTypeName;
		this.applyStatus = applyStatus;
		this.unitProperties = unitProperties;
		this.typeId = typeId;
		this.tprojectApplications = tprojectApplications;
		this.tprojectType = tprojectType;
		this.planFlag = planFlag;
		this.typeName = typeName;
		this.planFlagName = planFlagName;
		this.projectCount = projectCount;
		this.inputTotal =  inputTotal;
		this.researchFunds = researchFunds;
		this.selfFinancing = selfFinancing;
		this.projectExpectOutput = projectExpectOutput;
		this.projectExpectProfitTax = projectExpectProfitTax;
		this.companyExpectOutput = companyExpectOutput;
		this.companyExpectProfitTax = companyExpectProfitTax;
		this.planStatusString = planStatusString;
		this.index = index;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PLAN_ID", unique = true, nullable = false, length = 40)
	public String getPlanId() {
		return this.planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLAN_COLLECT_ID")
	public TplanCollect getTplanCollect() {
		return this.tplanCollect;
	}

	public void setTplanCollect(TplanCollect tplanCollect) {
		this.tplanCollect = tplanCollect;
	}

	@Column(name = "PLAN_NAME", length = 200)
	public String getPlanName() {
		return this.planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	@Column(name = "PLAN_YEAR", length = 4)
	public String getPlanYear() {
		return this.planYear;
	}

	public void setPlanYear(String planYear) {
		this.planYear = planYear;
	}

	@Column(name = "PLAN_BATCH", length = 40)
	public String getPlanBatch() {
		return this.planBatch;
	}

	public void setPlanBatch(String planBatch) {
		this.planBatch = planBatch;
	}

	@Column(name = "PLAN_STATE", length = 40)
	public String getPlanState() {
		return this.planState;
	}

	public void setPlanState(String planState) {
		this.planState = planState;
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

	@Column(name = "UPDATE_DATE")
	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade ={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY, mappedBy = "tplan")
	public Set<TprojectApplication> getTprojectApplications() {
		return tprojectApplications;
	}

	public void setTprojectApplications(
			Set<TprojectApplication> tprojectApplications) {
		this.tprojectApplications = tprojectApplications;
	}

	@Transient
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	@Transient
	public String getApplicationUnit() {
		return applicationUnit;
	}

	public void setApplicationUnit(String applicationUnit) {
		this.applicationUnit = applicationUnit;
	}
	@Transient
	public String getProjectTypeName() {
		return projectTypeName;
	}

	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}
	@Transient
	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE_ID")
	public TprojectType getTprojectType() {
		return this.tprojectType;
	}

	public void setTprojectType(TprojectType tprojectType) {
		this.tprojectType = tprojectType;
	}
	
	@Column(name = "PLAN_FLAG", length = 40)
	public String getPlanFlag() {
		return this.planFlag;
	}

	public void setPlanFlag(String planFlag) {
		this.planFlag = planFlag;
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
	
	@Column(name = "PROJECT_COUNT", precision = 10, scale = 0)
	public Integer getProjectCount() {
		return projectCount;
	}

	public void setProjectCount(Integer projectCount) {
		this.projectCount = projectCount;
	}

	@Column(name = "INPUT_TOTAL", precision = 12, scale = 4)
	public double getInputTotal() {
		return inputTotal;
	}

	public void setInputTotal(double inputTotal) {
		this.inputTotal = inputTotal;
	}

	@Column(name = "RESEARCH_FUNDS", precision = 12, scale = 4)
	public double getResearchFunds() {
		return researchFunds;
	}

	public void setResearchFunds(double researchFunds) {
		this.researchFunds = researchFunds;
	}

	@Column(name = "SELF_FINANCING", precision = 12, scale = 4)
	public double getSelfFinancing() {
		return selfFinancing;
	}

	public void setSelfFinancing(double selfFinancing) {
		this.selfFinancing = selfFinancing;
	}

	@Column(name = "PROJECT_EXPECT_OUTPUT", precision = 12, scale = 4)
	public double getProjectExpectOutput() {
		return projectExpectOutput;
	}

	public void setProjectExpectOutput(double projectExpectOutput) {
		this.projectExpectOutput = projectExpectOutput;
	}

	@Column(name = "PROJECT_EXPECT_PROFIT_TAX", precision = 12, scale = 4)
	public double getProjectExpectProfitTax() {
		return projectExpectProfitTax;
	}

	public void setProjectExpectProfitTax(double projectExpectProfitTax) {
		this.projectExpectProfitTax = projectExpectProfitTax;
	}

	@Column(name = "COMPANY_EXPECT_OUTPUT", precision = 12, scale = 4)
	public double getCompanyExpectOutput() {
		return companyExpectOutput;
	}

	public void setCompanyExpectOutput(double companyExpectOutput) {
		this.companyExpectOutput = companyExpectOutput;
	}

	@Column(name = "COMPANY_EXPECT_PROFIT_TAX", precision = 12, scale = 4)
	public double getCompanyExpectProfitTax() {
		return companyExpectProfitTax;
	}

	public void setCompanyExpectProfitTax(double companyExpectProfitTax) {
		this.companyExpectProfitTax = companyExpectProfitTax;
	}

	@Transient
	public String getPlanStatusString() {
		return planStatusString;
	}

	public void setPlanStatusString(String planStatusString) {
		this.planStatusString = planStatusString;
	}

	@Transient
	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
}
package com.hopsun.tppas.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
 * TprojectType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_PROJECT_TYPE")
public class TprojectType implements java.io.Serializable {

	private static final long serialVersionUID = 962873751457622294L;
	// Fields

	private String typeId;
	private TprojectAcceptanceTemplate tprojectAcceptanceTemplate;
	private TprojectSupervisionTemplate tprojectSupervisionTemplate;
	private TprojectReportTemplate tprojectReportTemplate;
	private TprojectContractTemplate tprojectContractTemplate;
	private TprojectScoreTemplate tprojectScoreTemplate;
	private String typeRealName;
	private String typeShowName;
	private String departmentId;
	private String departmentName;
	private String parentTypeId;
	private String parentTypeName;
	private Long isShow;
	/** 是否显示临时字段*/
	private String isShowName;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;
	private String deleteFlag;
	private String remark;
	/**企业项目信息表是否填写*/
	private Long isWrite;
	// 执行期跨度
	private String timeArea;
	private Set<TprojectApplication> tprojectApplications = new HashSet<TprojectApplication>(0);
	private Set<TmodelChoose> tmodelChooses = new HashSet<TmodelChoose>(0);
	private List<TexpertReviewComments> texpertReviewComments = new ArrayList<TexpertReviewComments>(0);
	
	// Constructors

	/** default constructor */
	public TprojectType() {
	}

	/** full constructor */
	public TprojectType(TprojectAcceptanceTemplate tprojectAcceptanceTemplate,
			TprojectSupervisionTemplate tprojectSupervisionTemplate,
			TprojectReportTemplate tprojectReportTemplate,
			TprojectContractTemplate tprojectContractTemplate,
			TprojectScoreTemplate tprojectScoreTemplate, String typeRealName,
			String typeShowName, String departmentId, String parentTypeId,Long isShow,
			Timestamp createTime, String createUser, Timestamp updateDate,
			String updateUser, String deleteFlag, String remark,Long isWrite,
			Set<TprojectApplication> tprojectApplications,
			Set<TmodelChoose> tmodelChooses,List<TexpertReviewComments> texpertReviewComments, String timeArea) {
		this.tprojectAcceptanceTemplate = tprojectAcceptanceTemplate;
		this.tprojectSupervisionTemplate = tprojectSupervisionTemplate;
		this.tprojectReportTemplate = tprojectReportTemplate;
		this.tprojectContractTemplate = tprojectContractTemplate;
		this.tprojectScoreTemplate = tprojectScoreTemplate;
		this.typeRealName = typeRealName;
		this.typeShowName = typeShowName;
		this.departmentId = departmentId;
		this.parentTypeId = parentTypeId;
		this.isShow = isShow;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.deleteFlag = deleteFlag;
		this.remark = remark;
		this.isWrite = isWrite;
		this.timeArea = timeArea;
		this.tprojectApplications = tprojectApplications;
		this.tmodelChooses = tmodelChooses;
		this.texpertReviewComments = texpertReviewComments;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "TYPE_ID", unique = true, nullable = false, length = 40)
	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCEPTANCE_TEMPLATE_ID")
	public TprojectAcceptanceTemplate getTprojectAcceptanceTemplate() {
		return this.tprojectAcceptanceTemplate;
	}

	public void setTprojectAcceptanceTemplate(
			TprojectAcceptanceTemplate tprojectAcceptanceTemplate) {
		this.tprojectAcceptanceTemplate = tprojectAcceptanceTemplate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPERVISION_TEMPLATE_ID")
	public TprojectSupervisionTemplate getTprojectSupervisionTemplate() {
		return this.tprojectSupervisionTemplate;
	}

	public void setTprojectSupervisionTemplate(
			TprojectSupervisionTemplate tprojectSupervisionTemplate) {
		this.tprojectSupervisionTemplate = tprojectSupervisionTemplate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REPORT_TEMPLATE_ID")
	public TprojectReportTemplate getTprojectReportTemplate() {
		return this.tprojectReportTemplate;
	}

	public void setTprojectReportTemplate(
			TprojectReportTemplate tprojectReportTemplate) {
		this.tprojectReportTemplate = tprojectReportTemplate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONTRACT_TEMPLATE_ID")
	public TprojectContractTemplate getTprojectContractTemplate() {
		return this.tprojectContractTemplate;
	}

	public void setTprojectContractTemplate(
			TprojectContractTemplate tprojectContractTemplate) {
		this.tprojectContractTemplate = tprojectContractTemplate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCORE_TEMPLATE_ID")
	public TprojectScoreTemplate getTprojectScoreTemplate() {
		return this.tprojectScoreTemplate;
	}

	public void setTprojectScoreTemplate(
			TprojectScoreTemplate tprojectScoreTemplate) {
		this.tprojectScoreTemplate = tprojectScoreTemplate;
	}

	@Column(name = "TYPE_REAL_NAME", length = 200)
	public String getTypeRealName() {
		return this.typeRealName;
	}

	public void setTypeRealName(String typeRealName) {
		this.typeRealName = typeRealName;
	}

	@Column(name = "TYPE_SHOW_NAME", length = 200)
	public String getTypeShowName() {
		return this.typeShowName;
	}

	public void setTypeShowName(String typeShowName) {
		this.typeShowName = typeShowName;
	}

	@Column(name = "DEPARTMENT_ID", length = 40)
	public String getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	
	@Column(name = "PARENT_TYPE_ID", length = 40)
	public String getParentTypeId() {
		return parentTypeId;
	}

	public void setParentTypeId(String parentTypeId) {
		this.parentTypeId = parentTypeId;
	}

	@Column(name = "IS_SHOW", precision = 2, scale = 0)
	public Long getIsShow() {
		return this.isShow;
	}

	public void setIsShow(Long isShow) {
		this.isShow = isShow;
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
	@Column(name = "IS_WRITE", precision = 2, scale = 0)
	public Long getIsWrite() {
		return isWrite;
	}

	public void setIsWrite(Long isWrite) {
		this.isWrite = isWrite;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectType")
	public Set<TprojectApplication> getTprojectApplications() {
		return this.tprojectApplications;
	}

	

	public void setTprojectApplications(
			Set<TprojectApplication> tprojectApplications) {
		this.tprojectApplications = tprojectApplications;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectType")
	public Set<TmodelChoose> getTmodelChooses() {
		return this.tmodelChooses;
	}

	public void setTmodelChooses(Set<TmodelChoose> tmodelChooses) {
		this.tmodelChooses = tmodelChooses;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tprojectType")
	public List<TexpertReviewComments> getTexpertReviewComments() {
		return texpertReviewComments;
	}
	
	public void setTexpertReviewComments(
			List<TexpertReviewComments> texpertReviewComments) {
		this.texpertReviewComments = texpertReviewComments;
	}

	
	@Transient
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Transient
	public String getIsShowName() {
		return isShowName;
	}

	public void setIsShowName(String isShowName) {
		this.isShowName = isShowName;
	}
	@Transient
	public String getParentTypeName() {
		return parentTypeName;
	}

	public void setParentTypeName(String parentTypeName) {
		this.parentTypeName = parentTypeName;
	}

	@Column(name = "TIME_AREA", length = 40)
	public String getTimeArea() {
		return timeArea;
	}

	public void setTimeArea(String timeArea) {
		this.timeArea = timeArea;
	}

}
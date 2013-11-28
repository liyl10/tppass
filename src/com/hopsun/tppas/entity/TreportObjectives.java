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
 * TreportObjectives entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_REPORT_OBJECTIVES")
public class TreportObjectives implements java.io.Serializable {

	
	private static final long serialVersionUID = -5075265224937052935L;
	// Fields
	private String objectivesId;
	private TprojectApplication tprojectApplication;
	private String qualityCertificationSystem;
	private String relevantIndustryPermits;
	private String application;
	private String authorize;
	
	private String technologyProductCertificate;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String remark;

	// Constructors

	/** default constructor */
	public TreportObjectives() {
	}

	/** full constructor */
	public TreportObjectives(TprojectApplication tprojectApplication, String qualityCertificationSystem,
			String relevantIndustryPermits, String application, String authorize,String technologyProductCertificate,
			String deleteFlag, Timestamp createTime, String createUser,
			Timestamp updateTime, String updateUser, String remark) {
		this.tprojectApplication = tprojectApplication;
		this.qualityCertificationSystem = qualityCertificationSystem;
		this.relevantIndustryPermits = relevantIndustryPermits;
		this.application = application;
		this.authorize = authorize;
		this.technologyProductCertificate = technologyProductCertificate;
		
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.remark = remark;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "OBJECTIVES_ID", unique = true, nullable = false, length = 40)
	public String getObjectivesId() {
		return objectivesId;
	}
	
	public void setObjectivesId(String objectivesId) {
		this.objectivesId = objectivesId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "QUALITY_CERTIFICATION_SYSTEM", length = 120)
	public String getQualityCertificationSystem() {
		return qualityCertificationSystem;
	}
	
	public void setQualityCertificationSystem(String qualityCertificationSystem) {
		this.qualityCertificationSystem = qualityCertificationSystem;
	}
	@Column(name = "RELEVANT_INDUSTRY_PERMITS", length = 120)
	public String getRelevantIndustryPermits() {
		return relevantIndustryPermits;
	}
	
	public void setRelevantIndustryPermits(String relevantIndustryPermits) {
		this.relevantIndustryPermits = relevantIndustryPermits;
	}
	@Column(name = "APPLICATION", length = 120)
	public String getApplication() {
		return application;
	}
	
	public void setApplication(String application) {
		this.application = application;
	}
	@Column(name = "TECHNOLOGY_PRODUCT_CERTIFICATE", length = 120)
	public String getTechnologyProductCertificate() {
		return technologyProductCertificate;
	}
	
	public void setTechnologyProductCertificate(String technologyProductCertificate) {
		this.technologyProductCertificate = technologyProductCertificate;
	}
	
	@Column(name = "DELETE_FLAG", length = 40)
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

	@Column(name = "UPDATE_TIME")
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
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
	@Column(name = "AUTHORIZE", length = 120)
	public String getAuthorize() {
		return authorize;
	}

	public void setAuthorize(String authorize) {
		this.authorize = authorize;
	}

}
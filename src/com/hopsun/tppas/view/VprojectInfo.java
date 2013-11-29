package com.hopsun.tppas.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *@comments 项目信息视图实体
 *@author wanglw
 *@date 2013-5-17 下午4:10:37 
 *@version 1.0
 */
@Entity
@Table(name = "V_PROJECT_INFO")
public class VprojectInfo implements java.io.Serializable {

	private static final long serialVersionUID = 4035906369857797336L;
	// Fields
	private String projectId;
	private String projectPerson;
	private String unitProperties;
	private String technicalFisld;
	private String technicalFisld1;
	private String technicalFisld2;

	// Constructors

	/** default constructor */
	public VprojectInfo() {
	}

	/** full constructor */
	public VprojectInfo(String projectId, String projectPerson,
			String unitProperties, String technicalFisld,
			String technicalFisld1, String technicalFisld2) {
		this.projectId = projectId;
		this.projectPerson = projectPerson;
		this.unitProperties = unitProperties;
		this.technicalFisld = technicalFisld;
		this.technicalFisld1 = technicalFisld1;
		this.technicalFisld2 = technicalFisld2;
	}

	@Id
	@Column(name = "PROJECT_ID", unique = true, nullable = false, length = 40)
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	@Column(name = "PROJECT_PERSON", length = 60)
	public String getProjectPerson() {
		return projectPerson;
	}

	public void setProjectPerson(String projectPerson) {
		this.projectPerson = projectPerson;
	}

	@Column(name = "UNIT_PROPERTIES", length = 40)
	public String getUnitProperties() {
		return unitProperties;
	}

	public void setUnitProperties(String unitProperties) {
		this.unitProperties = unitProperties;
	}

	@Column(name = "TECHNICAL_FISLD", length = 40)
	public String getTechnicalFisld() {
		return technicalFisld;
	}

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
}
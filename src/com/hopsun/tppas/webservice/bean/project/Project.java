/**
 * @filename Project.java
 * @author wangxiaodong
 * @date 2013-9-27
 * @vsersion 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */
package com.hopsun.tppas.webservice.bean.project;

import java.util.Set;

import com.hopsun.tppas.webservice.bean.basic.Economy;
import com.hopsun.tppas.webservice.bean.company.Company;

/**
 * @comments 项目（project）
 * @author wangxiaodong
 * @date 2013-9-27
 * @version 1.0
 */
public class Project {
	// 基本信息(projectBasic)
	private ProjectBasic projectBasic;
	// 执行期内项目完成的经济指标(projectLastest)
	private Set<Economy> projectLastest;
	// 执行期内企业完成的经济指标
	private Set<Economy> companyLastest;
	// 用款计划表(pdMoneySchedule)
	private Set<Economy> pdMoneySchedule;
	// 项目对应的企业信息
	private Company company;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(ProjectBasic projectBasic, Set<Economy> projectLastest, Set<Economy> companyLastest, Set<Economy> pdMoneySchedule, Company company) {
		super();
		this.projectBasic = projectBasic;
		this.projectLastest = projectLastest;
		this.companyLastest = companyLastest;
		this.pdMoneySchedule = pdMoneySchedule;
		this.company = company;
	}

	public ProjectBasic getProjectBasic() {
		return projectBasic;
	}

	public void setProjectBasic(ProjectBasic projectBasic) {
		this.projectBasic = projectBasic;
	}

	public Set<Economy> getProjectLastest() {
		return projectLastest;
	}

	public void setProjectLastest(Set<Economy> projectLastest) {
		this.projectLastest = projectLastest;
	}

	public Set<Economy> getCompanyLastest() {
		return companyLastest;
	}

	public void setCompanyLastest(Set<Economy> companyLastest) {
		this.companyLastest = companyLastest;
	}

	public Set<Economy> getPdMoneySchedule() {
		return pdMoneySchedule;
	}

	public void setPdMoneySchedule(Set<Economy> pdMoneySchedule) {
		this.pdMoneySchedule = pdMoneySchedule;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
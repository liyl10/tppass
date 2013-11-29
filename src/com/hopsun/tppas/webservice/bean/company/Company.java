/**
 * @filename Company.java
 * @author wangxiaodong
 * @date 2013-9-27
 * @vsersion 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */
package com.hopsun.tppas.webservice.bean.company;

import java.util.Set;

/**
 * @comments 企业(company)
 * @author wangxiaodong
 * @date 2013-9-27
 * @version 1.0
 */
public class Company {
	// 近三年企业经营状况
	private Set<CompanyBusiness> companyBusiness;
	// 基本信息(companyBasic)
	private CompanyBasic companyBasic;

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(Set<CompanyBusiness> companyBusiness, CompanyBasic companyBasic) {
		super();
		this.companyBusiness = companyBusiness;
		this.companyBasic = companyBasic;
	}

	public Set<CompanyBusiness> getCompanyBusiness() {
		return companyBusiness;
	}

	public void setCompanyBusiness(Set<CompanyBusiness> companyBusiness) {
		this.companyBusiness = companyBusiness;
	}

	public CompanyBasic getCompanyBasic() {
		return companyBasic;
	}

	public void setCompanyBasic(CompanyBasic companyBasic) {
		this.companyBasic = companyBasic;
	}

}

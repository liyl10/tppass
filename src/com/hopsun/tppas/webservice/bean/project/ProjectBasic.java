/**
 * @filename ProjectBasic.java
 * @author wangxiaodong
 * @date 2013-9-27
 * @vsersion 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */
package com.hopsun.tppas.webservice.bean.project;


/**
 * @comments 基本信息(projectBasic)
 * @author wangxiaodong
 * @date 2013-9-27
 * @version 1.0
 */
public class ProjectBasic {
	// 项目名称
	private String projectName;
	// 归口管理部门
	private String centralizedType;
	// 知识产权状况
	private String intellectualProperty;
	// 技术来源
	private String technologySource;
	// 项目所属技术领域
	private String technologyName;
	// 项目负责人(teamLeader)
	private String projectPerson;
	private String personTel;
	private String personPhone;
	private String personEmail;
	private String personPost;
	private String personDept;
	// 项目联系人1(linkManOne)
	private String touchPerson;
	private String touchTel;
	private String touchPhone;
	private String touchEmail;
	private String touchPost;
	private String touchDept;
	// 项目联系人2(linkManTwo)
	private String touchPerson2;
	private String touchTel2;
	private String touchPhone2;
	private String touchEmail2;
	private String touchPost2;
	private String touchDept2;
	//总投入
	private String investmentTotal;
	//申请科技经费
	private String specialFunds;
	//自筹
	private String selfFinancing;
	//贷款
	private String credit;
	// 已落实的贷款
	private String implCredit;
	// 配套资金
	private String matchFunds;
	//其他
	private String other;
	
	private String projectReportbudgetId;
	private String codeNum;
	private String startTime;
	private String endTime;
	private String assistUnit;
	private String assistUnit2;
	private String technicalFisld;
	private String matchUnit;
	private String projectIntroduction;
	private String remark;
	private String deleteFlag;
	private String createTime;
	private String createUser;
	private String updateTime;
	private String updateUser;

	public ProjectBasic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectBasic(String projectName, String centralizedType, String intellectualProperty, String technologySource, String technologyName, String projectPerson, String personTel, String personPhone, String personEmail, String personPost, String personDept, String touchPerson, String touchTel, String touchPhone, String touchEmail, String touchPost, String touchDept, String touchPerson2, String touchTel2, String touchPhone2, String touchEmail2, String touchPost2, String touchDept2, String implCredit, String matchFunds, String projectReportbudgetId, String codeNum, String startTime, String endTime, String assistUnit, String assistUnit2, String technicalFisld, String investmentTotal, String specialFunds, String selfFinancing, String other, String credit, String matchUnit,
			String projectIntroduction, String remark, String deleteFlag, String createTime, String createUser, String updateTime, String updateUser) {
		super();
		this.projectName = projectName;
		this.centralizedType = centralizedType;
		this.intellectualProperty = intellectualProperty;
		this.technologySource = technologySource;
		this.technologyName = technologyName;
		this.projectPerson = projectPerson;
		this.personTel = personTel;
		this.personPhone = personPhone;
		this.personEmail = personEmail;
		this.personPost = personPost;
		this.personDept = personDept;
		this.touchPerson = touchPerson;
		this.touchTel = touchTel;
		this.touchPhone = touchPhone;
		this.touchEmail = touchEmail;
		this.touchPost = touchPost;
		this.touchDept = touchDept;
		this.touchPerson2 = touchPerson2;
		this.touchTel2 = touchTel2;
		this.touchPhone2 = touchPhone2;
		this.touchEmail2 = touchEmail2;
		this.touchPost2 = touchPost2;
		this.touchDept2 = touchDept2;
		this.implCredit = implCredit;
		this.matchFunds = matchFunds;
		this.projectReportbudgetId = projectReportbudgetId;
		this.codeNum = codeNum;
		this.startTime = startTime;
		this.endTime = endTime;
		this.assistUnit = assistUnit;
		this.assistUnit2 = assistUnit2;
		this.technicalFisld = technicalFisld;
		this.investmentTotal = investmentTotal;
		this.specialFunds = specialFunds;
		this.selfFinancing = selfFinancing;
		this.other = other;
		this.credit = credit;
		this.matchUnit = matchUnit;
		this.projectIntroduction = projectIntroduction;
		this.remark = remark;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCentralizedType() {
		return centralizedType;
	}

	public void setCentralizedType(String centralizedType) {
		this.centralizedType = centralizedType;
	}

	public String getIntellectualProperty() {
		return intellectualProperty;
	}

	public void setIntellectualProperty(String intellectualProperty) {
		this.intellectualProperty = intellectualProperty;
	}

	public String getTechnologySource() {
		return technologySource;
	}

	public void setTechnologySource(String technologySource) {
		this.technologySource = technologySource;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public String getProjectPerson() {
		return projectPerson;
	}

	public void setProjectPerson(String projectPerson) {
		this.projectPerson = projectPerson;
	}

	public String getPersonTel() {
		return personTel;
	}

	public void setPersonTel(String personTel) {
		this.personTel = personTel;
	}

	public String getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	public String getPersonPost() {
		return personPost;
	}

	public void setPersonPost(String personPost) {
		this.personPost = personPost;
	}

	public String getPersonDept() {
		return personDept;
	}

	public void setPersonDept(String personDept) {
		this.personDept = personDept;
	}

	public String getTouchPerson() {
		return touchPerson;
	}

	public void setTouchPerson(String touchPerson) {
		this.touchPerson = touchPerson;
	}

	public String getTouchTel() {
		return touchTel;
	}

	public void setTouchTel(String touchTel) {
		this.touchTel = touchTel;
	}

	public String getTouchPhone() {
		return touchPhone;
	}

	public void setTouchPhone(String touchPhone) {
		this.touchPhone = touchPhone;
	}

	public String getTouchEmail() {
		return touchEmail;
	}

	public void setTouchEmail(String touchEmail) {
		this.touchEmail = touchEmail;
	}

	public String getTouchPost() {
		return touchPost;
	}

	public void setTouchPost(String touchPost) {
		this.touchPost = touchPost;
	}

	public String getTouchDept() {
		return touchDept;
	}

	public void setTouchDept(String touchDept) {
		this.touchDept = touchDept;
	}

	public String getTouchPerson2() {
		return touchPerson2;
	}

	public void setTouchPerson2(String touchPerson2) {
		this.touchPerson2 = touchPerson2;
	}

	public String getTouchTel2() {
		return touchTel2;
	}

	public void setTouchTel2(String touchTel2) {
		this.touchTel2 = touchTel2;
	}

	public String getTouchPhone2() {
		return touchPhone2;
	}

	public void setTouchPhone2(String touchPhone2) {
		this.touchPhone2 = touchPhone2;
	}

	public String getTouchEmail2() {
		return touchEmail2;
	}

	public void setTouchEmail2(String touchEmail2) {
		this.touchEmail2 = touchEmail2;
	}

	public String getTouchPost2() {
		return touchPost2;
	}

	public void setTouchPost2(String touchPost2) {
		this.touchPost2 = touchPost2;
	}

	public String getTouchDept2() {
		return touchDept2;
	}

	public void setTouchDept2(String touchDept2) {
		this.touchDept2 = touchDept2;
	}

	public String getImplCredit() {
		return implCredit;
	}

	public void setImplCredit(String implCredit) {
		this.implCredit = implCredit;
	}

	public String getMatchFunds() {
		return matchFunds;
	}

	public void setMatchFunds(String matchFunds) {
		this.matchFunds = matchFunds;
	}

	public String getProjectReportbudgetId() {
		return projectReportbudgetId;
	}

	public void setProjectReportbudgetId(String projectReportbudgetId) {
		this.projectReportbudgetId = projectReportbudgetId;
	}

	public String getCodeNum() {
		return codeNum;
	}

	public void setCodeNum(String codeNum) {
		this.codeNum = codeNum;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getAssistUnit() {
		return assistUnit;
	}

	public void setAssistUnit(String assistUnit) {
		this.assistUnit = assistUnit;
	}

	public String getAssistUnit2() {
		return assistUnit2;
	}

	public void setAssistUnit2(String assistUnit2) {
		this.assistUnit2 = assistUnit2;
	}

	public String getTechnicalFisld() {
		return technicalFisld;
	}

	public void setTechnicalFisld(String technicalFisld) {
		this.technicalFisld = technicalFisld;
	}

	public String getInvestmentTotal() {
		return investmentTotal;
	}

	public void setInvestmentTotal(String investmentTotal) {
		this.investmentTotal = investmentTotal;
	}

	public String getSpecialFunds() {
		return specialFunds;
	}

	public void setSpecialFunds(String specialFunds) {
		this.specialFunds = specialFunds;
	}

	public String getSelfFinancing() {
		return selfFinancing;
	}

	public void setSelfFinancing(String selfFinancing) {
		this.selfFinancing = selfFinancing;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getMatchUnit() {
		return matchUnit;
	}

	public void setMatchUnit(String matchUnit) {
		this.matchUnit = matchUnit;
	}

	public String getProjectIntroduction() {
		return projectIntroduction;
	}

	public void setProjectIntroduction(String projectIntroduction) {
		this.projectIntroduction = projectIntroduction;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
}

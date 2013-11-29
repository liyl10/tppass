/**
 * @filename CompanyBasic.java
 * @author wangxiaodong
 * @date 2013-9-27
 * @vsersion 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */
package com.hopsun.tppas.webservice.bean.company;

import java.util.Set;

import com.hopsun.tppas.webservice.bean.basic.Type;



/**
 * @comments 企业基本信息(companyBasic)
 * @author wangxiaodong
 * @date 2013-9-27
 * @version 1.0
 */
public class CompanyBasic {
	// 申请单位
	private String uoiName;
	// 邮编
	private String postcode;
	// 单位性质，指GT个体户、QY企业、SY事业单位、ZF政府机构，XX学校、YY医院、SC商场、JD酒店、SS-4S店、JG军工
	private Set<Type> orgProperty;
	// 高新技术企业
	private Set<Type> hiTech;
	// 创新型企业
	private Set<Type> invocate;
	// 企业类型
	private Set<Type> orgType;
	// 主营产品（服务）所属技术领域
	private Set<Type> techArea;
	// 企业研发机构名称
	private Set<Type> orgName;
	// 开户银行
	private String depositBank;
	// 开户银行号
	private String bankNo;
	// 营业执照号
	private String codeNum;
	// 开户名称
	private String depositName;
	// 银行帐号
	private String bankAccount;
	// 公司地址(linkage)
	private Address linkage;
	// 单位所属行业领域(industry)
	private Set<Type> industry;
	// 法定代表人(corporation)

	private String corporation;
	private String corporationPhone;
	private String corporationMobile;
	private String corporationEmail;

	// 新增字段
	// 组织主键
	private String pkUoiId;
	// 类型名称
	private String typeName;
	// 营业执照号
	private String regNum;
	// 国税号
	private String centralTaxNum;
	// 组织简称
	private String shortname;
	// 注册日期
	private String regdate;
	// 注册资金
	private String regcap;
	// 注册地址
	private Address regAddress;
	// 注册登记类型
	private String busiType;
	// 营业时间
	private String businessDate;
	// 营业面积
	private String businessArea;
	// 营业额
	private String businessMoney;
	// 生产性质
	private String retyld;
	// 企业传真
	private String nbiFax;
	// 企业网址
	private String orgWeb;
	// 企业电话
	private String chargeTel;
	// 企业email
	private String orgEmail;
	// 企业负责人
	private String chargeName;
	private String chargePhone;
	private String chargeMobile;
	private String chargeJob;
	private String chargeEmail;
	// 企业联系人1
	private String linkMan;
	private String linkManJob;
	private String linkManPhone;
	private String linkManMobile;
	// 企业联系人2
	private String olinkMan;
	private String olinkManJob;
	private String olinkManPhone;
	private String olinkManMobile;
	private String olinkManEmail;
	// 配套信息
	private String formlnfo;
	// 企业经营范围
	private String conductScope;
	// 主要服务
	private String service;
	// 主要服务对象
	private String serviceobj;
	// 信息来源
	private String infoSource;
	// 审核状态
	private String verifyState;
	// 公开状态
	private String publicState;
	// 个人空间
	private String orgPersonalSpace;
	// 信息创建人
	private String createUserId;
	// 信息审核人
	private String verifyUserId;
	// 审核时间
	private String verifyDate;
	// 审核不通过原因
	private String refuseReason;
	// 删除状态
	private String isDelete;
	// 修改人
	private String modifyUser;
	// 修改时间
	private String modifyDate;
	// 添加人
	private String createUser;
	// 添加时间
	private String createDate;
	//企业股权信息
	private Set<Stock> stocks;

	public CompanyBasic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyBasic(String uoiName, String postcode, Set<Type> orgProperty, Set<Type> hiTech, Set<Type> invocate, Set<Type> orgType, Set<Type> techArea, Set<Type> orgName, String depositBank, String bankNo, String codeNum, String depositName, String bankAccount, Address linkage, Set<Type> industry, String corporation, String corporationPhone, String corporationMobile, String corporationEmail, String pkUoiId, String typeName, String regNum, String centralTaxNum, String shortname, String regdate, String regcap, Address regAddress, String busiType, String businessDate, String businessArea, String businessMoney, String retyld, String nbiFax, String orgWeb, String chargeTel, String orgEmail, String chargeName, String chargePhone, String chargeMobile, String chargeJob, String chargeEmail,
			String linkMan, String linkManJob, String linkManPhone, String linkManMobile, String olinkMan, String olinkManJob, String olinkManPhone, String olinkManMobile, String olinkManEmail, String formlnfo, String conductScope, String service, String serviceobj, String infoSource, String verifyState, String publicState, String orgPersonalSpace, String createUserId, String verifyUserId, String verifyDate, String refuseReason, String isDelete, String modifyUser, String modifyDate, String createUser, String createDate, Set<Stock> stocks) {
		super();
		this.uoiName = uoiName;
		this.postcode = postcode;
		this.orgProperty = orgProperty;
		this.hiTech = hiTech;
		this.invocate = invocate;
		this.orgType = orgType;
		this.techArea = techArea;
		this.orgName = orgName;
		this.depositBank = depositBank;
		this.bankNo = bankNo;
		this.codeNum = codeNum;
		this.depositName = depositName;
		this.bankAccount = bankAccount;
		this.linkage = linkage;
		this.industry = industry;
		this.corporation = corporation;
		this.corporationPhone = corporationPhone;
		this.corporationMobile = corporationMobile;
		this.corporationEmail = corporationEmail;
		this.pkUoiId = pkUoiId;
		this.typeName = typeName;
		this.regNum = regNum;
		this.centralTaxNum = centralTaxNum;
		this.shortname = shortname;
		this.regdate = regdate;
		this.regcap = regcap;
		this.regAddress = regAddress;
		this.busiType = busiType;
		this.businessDate = businessDate;
		this.businessArea = businessArea;
		this.businessMoney = businessMoney;
		this.retyld = retyld;
		this.nbiFax = nbiFax;
		this.orgWeb = orgWeb;
		this.chargeTel = chargeTel;
		this.orgEmail = orgEmail;
		this.chargeName = chargeName;
		this.chargePhone = chargePhone;
		this.chargeMobile = chargeMobile;
		this.chargeJob = chargeJob;
		this.chargeEmail = chargeEmail;
		this.linkMan = linkMan;
		this.linkManJob = linkManJob;
		this.linkManPhone = linkManPhone;
		this.linkManMobile = linkManMobile;
		this.olinkMan = olinkMan;
		this.olinkManJob = olinkManJob;
		this.olinkManPhone = olinkManPhone;
		this.olinkManMobile = olinkManMobile;
		this.olinkManEmail = olinkManEmail;
		this.formlnfo = formlnfo;
		this.conductScope = conductScope;
		this.service = service;
		this.serviceobj = serviceobj;
		this.infoSource = infoSource;
		this.verifyState = verifyState;
		this.publicState = publicState;
		this.orgPersonalSpace = orgPersonalSpace;
		this.createUserId = createUserId;
		this.verifyUserId = verifyUserId;
		this.verifyDate = verifyDate;
		this.refuseReason = refuseReason;
		this.isDelete = isDelete;
		this.modifyUser = modifyUser;
		this.modifyDate = modifyDate;
		this.createUser = createUser;
		this.createDate = createDate;
		this.stocks = stocks;
	}

	public String getUoiName() {
		return uoiName;
	}

	public void setUoiName(String uoiName) {
		this.uoiName = uoiName;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Set<Type> getOrgProperty() {
		return orgProperty;
	}

	public void setOrgProperty(Set<Type> orgProperty) {
		this.orgProperty = orgProperty;
	}

	public Set<Type> getHiTech() {
		return hiTech;
	}

	public void setHiTech(Set<Type> hiTech) {
		this.hiTech = hiTech;
	}

	public Set<Type> getInvocate() {
		return invocate;
	}

	public void setInvocate(Set<Type> invocate) {
		this.invocate = invocate;
	}

	public Set<Type> getOrgType() {
		return orgType;
	}

	public void setOrgType(Set<Type> orgType) {
		this.orgType = orgType;
	}

	public Set<Type> getTechArea() {
		return techArea;
	}

	public void setTechArea(Set<Type> techArea) {
		this.techArea = techArea;
	}

	public Set<Type> getOrgName() {
		return orgName;
	}

	public void setOrgName(Set<Type> orgName) {
		this.orgName = orgName;
	}

	public String getDepositBank() {
		return depositBank;
	}

	public void setDepositBank(String depositBank) {
		this.depositBank = depositBank;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getCodeNum() {
		return codeNum;
	}

	public void setCodeNum(String codeNum) {
		this.codeNum = codeNum;
	}

	public String getDepositName() {
		return depositName;
	}

	public void setDepositName(String depositName) {
		this.depositName = depositName;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Address getLinkage() {
		return linkage;
	}

	public void setLinkage(Address linkage) {
		this.linkage = linkage;
	}

	public Set<Type> getIndustry() {
		return industry;
	}

	public void setIndustry(Set<Type> industry) {
		this.industry = industry;
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public String getCorporationPhone() {
		return corporationPhone;
	}

	public void setCorporationPhone(String corporationPhone) {
		this.corporationPhone = corporationPhone;
	}

	public String getCorporationMobile() {
		return corporationMobile;
	}

	public void setCorporationMobile(String corporationMobile) {
		this.corporationMobile = corporationMobile;
	}

	public String getCorporationEmail() {
		return corporationEmail;
	}

	public void setCorporationEmail(String corporationEmail) {
		this.corporationEmail = corporationEmail;
	}

	public String getPkUoiId() {
		return pkUoiId;
	}

	public void setPkUoiId(String pkUoiId) {
		this.pkUoiId = pkUoiId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public String getCentralTaxNum() {
		return centralTaxNum;
	}

	public void setCentralTaxNum(String centralTaxNum) {
		this.centralTaxNum = centralTaxNum;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getRegcap() {
		return regcap;
	}

	public void setRegcap(String regcap) {
		this.regcap = regcap;
	}

	public Address getRegAddress() {
		return regAddress;
	}

	public void setRegAddress(Address regAddress) {
		this.regAddress = regAddress;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getBusinessDate() {
		return businessDate;
	}

	public void setBusinessDate(String businessDate) {
		this.businessDate = businessDate;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

	public String getBusinessMoney() {
		return businessMoney;
	}

	public void setBusinessMoney(String businessMoney) {
		this.businessMoney = businessMoney;
	}

	public String getRetyld() {
		return retyld;
	}

	public void setRetyld(String retyld) {
		this.retyld = retyld;
	}

	public String getNbiFax() {
		return nbiFax;
	}

	public void setNbiFax(String nbiFax) {
		this.nbiFax = nbiFax;
	}

	public String getOrgWeb() {
		return orgWeb;
	}

	public void setOrgWeb(String orgWeb) {
		this.orgWeb = orgWeb;
	}

	public String getChargeTel() {
		return chargeTel;
	}

	public void setChargeTel(String chargeTel) {
		this.chargeTel = chargeTel;
	}

	public String getOrgEmail() {
		return orgEmail;
	}

	public void setOrgEmail(String orgEmail) {
		this.orgEmail = orgEmail;
	}

	public String getChargeName() {
		return chargeName;
	}

	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}

	public String getChargePhone() {
		return chargePhone;
	}

	public void setChargePhone(String chargePhone) {
		this.chargePhone = chargePhone;
	}

	public String getChargeMobile() {
		return chargeMobile;
	}

	public void setChargeMobile(String chargeMobile) {
		this.chargeMobile = chargeMobile;
	}

	public String getChargeJob() {
		return chargeJob;
	}

	public void setChargeJob(String chargeJob) {
		this.chargeJob = chargeJob;
	}

	public String getChargeEmail() {
		return chargeEmail;
	}

	public void setChargeEmail(String chargeEmail) {
		this.chargeEmail = chargeEmail;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getLinkManJob() {
		return linkManJob;
	}

	public void setLinkManJob(String linkManJob) {
		this.linkManJob = linkManJob;
	}

	public String getLinkManPhone() {
		return linkManPhone;
	}

	public void setLinkManPhone(String linkManPhone) {
		this.linkManPhone = linkManPhone;
	}

	public String getLinkManMobile() {
		return linkManMobile;
	}

	public void setLinkManMobile(String linkManMobile) {
		this.linkManMobile = linkManMobile;
	}

	public String getOlinkMan() {
		return olinkMan;
	}

	public void setOlinkMan(String olinkMan) {
		this.olinkMan = olinkMan;
	}

	public String getOlinkManJob() {
		return olinkManJob;
	}

	public void setOlinkManJob(String olinkManJob) {
		this.olinkManJob = olinkManJob;
	}

	public String getOlinkManPhone() {
		return olinkManPhone;
	}

	public void setOlinkManPhone(String olinkManPhone) {
		this.olinkManPhone = olinkManPhone;
	}

	public String getOlinkManMobile() {
		return olinkManMobile;
	}

	public void setOlinkManMobile(String olinkManMobile) {
		this.olinkManMobile = olinkManMobile;
	}

	public String getOlinkManEmail() {
		return olinkManEmail;
	}

	public void setOlinkManEmail(String olinkManEmail) {
		this.olinkManEmail = olinkManEmail;
	}

	public String getFormlnfo() {
		return formlnfo;
	}

	public void setFormlnfo(String formlnfo) {
		this.formlnfo = formlnfo;
	}

	public String getConductScope() {
		return conductScope;
	}

	public void setConductScope(String conductScope) {
		this.conductScope = conductScope;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getServiceobj() {
		return serviceobj;
	}

	public void setServiceobj(String serviceobj) {
		this.serviceobj = serviceobj;
	}

	public String getInfoSource() {
		return infoSource;
	}

	public void setInfoSource(String infoSource) {
		this.infoSource = infoSource;
	}

	public String getVerifyState() {
		return verifyState;
	}

	public void setVerifyState(String verifyState) {
		this.verifyState = verifyState;
	}

	public String getPublicState() {
		return publicState;
	}

	public void setPublicState(String publicState) {
		this.publicState = publicState;
	}

	public String getOrgPersonalSpace() {
		return orgPersonalSpace;
	}

	public void setOrgPersonalSpace(String orgPersonalSpace) {
		this.orgPersonalSpace = orgPersonalSpace;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getVerifyUserId() {
		return verifyUserId;
	}

	public void setVerifyUserId(String verifyUserId) {
		this.verifyUserId = verifyUserId;
	}

	public String getVerifyDate() {
		return verifyDate;
	}

	public void setVerifyDate(String verifyDate) {
		this.verifyDate = verifyDate;
	}

	public String getRefuseReason() {
		return refuseReason;
	}

	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Set<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}
}
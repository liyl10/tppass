/**
 * @filename ProjectLastest.java
 * @author wangxiaodong
 * @date 2013-9-27
 * @vsersion 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */
package com.hopsun.tppas.webservice.bean.basic;

/**
 * @comments 执行期内项目完成的经济指标/执行期内企业完成的经济指标
 * @author wangxiaodong
 * @date 2013-9-27
 * @version 1.0
 */
public class Economy {
	// 年度（2014）
	private String year;
	// 新增销售收入
	private String outputValue;
	// 新增税金
	private String payTaxes;
	// 新增利润
	private String retainedProfits;
	// 创汇（万美元）
	private String earnMoney;
	// 产值
	private String assetTotal;
	// 新增就业人数
	private String newJobs;
	// 新增投资
	private String newInvestment;
	// 资产规模
	private String assetSize;
	private String economicIndicatorId;
	private String projectIndicatorId;
	private String remark;
	private String deleteFlag;
	private String createTime;
	private String createUser;
	private String updateTime;
	private String updateUser;
	
	private String moneyScheduleId;
	private Double investmentTotal;
	private Double specialFunds;
	private Double selfFinancing;
	private Double credit;
	private Double matchFunds;
	private Double other;

	public Economy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Economy(String year, String outputValue, String payTaxes, String retainedProfits, String earnMoney, String assetTotal, String newJobs, String newInvestment, String assetSize, String economicIndicatorId, String projectIndicatorId, String remark, String deleteFlag, String createTime, String createUser, String updateTime, String updateUser, String moneyScheduleId, Double investmentTotal, Double specialFunds, Double selfFinancing, Double credit, Double matchFunds, Double other) {
		super();
		this.year = year;
		this.outputValue = outputValue;
		this.payTaxes = payTaxes;
		this.retainedProfits = retainedProfits;
		this.earnMoney = earnMoney;
		this.assetTotal = assetTotal;
		this.newJobs = newJobs;
		this.newInvestment = newInvestment;
		this.assetSize = assetSize;
		this.economicIndicatorId = economicIndicatorId;
		this.projectIndicatorId = projectIndicatorId;
		this.remark = remark;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.moneyScheduleId = moneyScheduleId;
		this.investmentTotal = investmentTotal;
		this.specialFunds = specialFunds;
		this.selfFinancing = selfFinancing;
		this.credit = credit;
		this.matchFunds = matchFunds;
		this.other = other;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getOutputValue() {
		return outputValue;
	}

	public void setOutputValue(String outputValue) {
		this.outputValue = outputValue;
	}

	public String getPayTaxes() {
		return payTaxes;
	}

	public void setPayTaxes(String payTaxes) {
		this.payTaxes = payTaxes;
	}

	public String getRetainedProfits() {
		return retainedProfits;
	}

	public void setRetainedProfits(String retainedProfits) {
		this.retainedProfits = retainedProfits;
	}

	public String getEarnMoney() {
		return earnMoney;
	}

	public void setEarnMoney(String earnMoney) {
		this.earnMoney = earnMoney;
	}

	public String getAssetTotal() {
		return assetTotal;
	}

	public void setAssetTotal(String assetTotal) {
		this.assetTotal = assetTotal;
	}

	public String getNewJobs() {
		return newJobs;
	}

	public void setNewJobs(String newJobs) {
		this.newJobs = newJobs;
	}

	public String getNewInvestment() {
		return newInvestment;
	}

	public void setNewInvestment(String newInvestment) {
		this.newInvestment = newInvestment;
	}

	public String getAssetSize() {
		return assetSize;
	}

	public void setAssetSize(String assetSize) {
		this.assetSize = assetSize;
	}

	public String getEconomicIndicatorId() {
		return economicIndicatorId;
	}

	public void setEconomicIndicatorId(String economicIndicatorId) {
		this.economicIndicatorId = economicIndicatorId;
	}

	public String getProjectIndicatorId() {
		return projectIndicatorId;
	}

	public void setProjectIndicatorId(String projectIndicatorId) {
		this.projectIndicatorId = projectIndicatorId;
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

	public String getMoneyScheduleId() {
		return moneyScheduleId;
	}

	public void setMoneyScheduleId(String moneyScheduleId) {
		this.moneyScheduleId = moneyScheduleId;
	}

	public Double getInvestmentTotal() {
		return investmentTotal;
	}

	public void setInvestmentTotal(Double investmentTotal) {
		this.investmentTotal = investmentTotal;
	}

	public Double getSpecialFunds() {
		return specialFunds;
	}

	public void setSpecialFunds(Double specialFunds) {
		this.specialFunds = specialFunds;
	}

	public Double getSelfFinancing() {
		return selfFinancing;
	}

	public void setSelfFinancing(Double selfFinancing) {
		this.selfFinancing = selfFinancing;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public Double getMatchFunds() {
		return matchFunds;
	}

	public void setMatchFunds(Double matchFunds) {
		this.matchFunds = matchFunds;
	}

	public Double getOther() {
		return other;
	}

	public void setOther(Double other) {
		this.other = other;
	}

}

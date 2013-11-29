/**
 * @filename CompanyBusiness.java
 * @author wangxiaodong
 * @date 2013-9-27
 * @vsersion 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */
package com.hopsun.tppas.webservice.bean.company;

import java.util.Comparator;

/**
 * @comments 近三年企业经营状况
 * @author wangxiaodong
 * @date 2013-9-27
 * @version 1.0
 */
public class CompanyBusiness implements Comparator<CompanyBusiness> {
	// 年度(2010)
	private String assetYear;
	// 销售收入
	private String assetSales;
	// 利润
	private String assetProfit;
	// 缴税
	private String tollageTotal;
	// 研发投入
	private String deveCosts;
	// 利润率
	private String profitRot;
	// R&D
	private String rd;

	//新增字段
	//编号
	private String assetId;
	//总资产
	private String assetCount;
	//货币资金
	private String monetaryCapital;
	//总负债
	private String liabilitiesTotal;
	//流动资金
	private String assetFlow;
	//固定资产
	private String assetFixed;
	//长期资产
	private String assetLong;
	//无形资产
	private String assetInvisible;
	//递延资产
	private String assetContinue;
	//总产值
	private String assetTotal;
	//总收入
	private String assetIncome;
	//高新技术产品（服务）收入
	private String techSales;
	//高新技术产品（服务）利润
	private String techProfit;
	//资产负债率
	private String assetLiabilities;
	//添加时间
	private String createDate;
	//添加人
	private String createUser;
	//修改人
	private String modifyUser;
	//修改时间
	private String modifyDate;
	//排序
	private String orderBy;
	//短期负债
	private String currentLiability;
	//长期负债
	private String longLiability;
	//主营业务收入
	private String mainBusIncome;
	//利润总和
	private String totalProfits;
	//利税
	private String taxationProfit;
	//外汇
	private String forex;
	//所有者权益
	private String ownershipInterest;
	//净资产收益率
	private String returnEquity;

	public CompanyBusiness() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyBusiness(String assetYear, String assetSales, String assetProfit, String tollageTotal, String deveCosts, String profitRot, String rd, String assetId, String assetCount, String monetaryCapital, String liabilitiesTotal, String assetFlow, String assetFixed, String assetLong, String assetInvisible, String assetContinue, String assetTotal, String assetIncome, String techSales, String techProfit, String assetLiabilities, String createDate, String createUser, String modifyUser, String modifyDate, String orderBy, String currentLiability, String longLiability, String mainBusIncome, String totalProfits, String taxationProfit, String forex, String ownershipInterest, String returnEquity) {
		super();
		this.assetYear = assetYear;
		this.assetSales = assetSales;
		this.assetProfit = assetProfit;
		this.tollageTotal = tollageTotal;
		this.deveCosts = deveCosts;
		this.profitRot = profitRot;
		this.rd = rd;
		this.assetId = assetId;
		this.assetCount = assetCount;
		this.monetaryCapital = monetaryCapital;
		this.liabilitiesTotal = liabilitiesTotal;
		this.assetFlow = assetFlow;
		this.assetFixed = assetFixed;
		this.assetLong = assetLong;
		this.assetInvisible = assetInvisible;
		this.assetContinue = assetContinue;
		this.assetTotal = assetTotal;
		this.assetIncome = assetIncome;
		this.techSales = techSales;
		this.techProfit = techProfit;
		this.assetLiabilities = assetLiabilities;
		this.createDate = createDate;
		this.createUser = createUser;
		this.modifyUser = modifyUser;
		this.modifyDate = modifyDate;
		this.orderBy = orderBy;
		this.currentLiability = currentLiability;
		this.longLiability = longLiability;
		this.mainBusIncome = mainBusIncome;
		this.totalProfits = totalProfits;
		this.taxationProfit = taxationProfit;
		this.forex = forex;
		this.ownershipInterest = ownershipInterest;
		this.returnEquity = returnEquity;
	}

	public String getAssetYear() {
		return assetYear;
	}

	public void setAssetYear(String assetYear) {
		this.assetYear = assetYear;
	}

	public String getAssetSales() {
		return assetSales;
	}

	public void setAssetSales(String assetSales) {
		this.assetSales = assetSales;
	}

	public String getAssetProfit() {
		return assetProfit;
	}

	public void setAssetProfit(String assetProfit) {
		this.assetProfit = assetProfit;
	}

	public String getTollageTotal() {
		return tollageTotal;
	}

	public void setTollageTotal(String tollageTotal) {
		this.tollageTotal = tollageTotal;
	}

	public String getDeveCosts() {
		return deveCosts;
	}

	public void setDeveCosts(String deveCosts) {
		this.deveCosts = deveCosts;
	}

	public String getProfitRot() {
		return profitRot;
	}

	public void setProfitRot(String profitRot) {
		this.profitRot = profitRot;
	}

	public String getRd() {
		return rd;
	}

	public void setRd(String rd) {
		this.rd = rd;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getAssetCount() {
		return assetCount;
	}

	public void setAssetCount(String assetCount) {
		this.assetCount = assetCount;
	}

	public String getMonetaryCapital() {
		return monetaryCapital;
	}

	public void setMonetaryCapital(String monetaryCapital) {
		this.monetaryCapital = monetaryCapital;
	}

	public String getLiabilitiesTotal() {
		return liabilitiesTotal;
	}

	public void setLiabilitiesTotal(String liabilitiesTotal) {
		this.liabilitiesTotal = liabilitiesTotal;
	}

	public String getAssetFlow() {
		return assetFlow;
	}

	public void setAssetFlow(String assetFlow) {
		this.assetFlow = assetFlow;
	}

	public String getAssetFixed() {
		return assetFixed;
	}

	public void setAssetFixed(String assetFixed) {
		this.assetFixed = assetFixed;
	}

	public String getAssetLong() {
		return assetLong;
	}

	public void setAssetLong(String assetLong) {
		this.assetLong = assetLong;
	}

	public String getAssetInvisible() {
		return assetInvisible;
	}

	public void setAssetInvisible(String assetInvisible) {
		this.assetInvisible = assetInvisible;
	}

	public String getAssetContinue() {
		return assetContinue;
	}

	public void setAssetContinue(String assetContinue) {
		this.assetContinue = assetContinue;
	}

	public String getAssetTotal() {
		return assetTotal;
	}

	public void setAssetTotal(String assetTotal) {
		this.assetTotal = assetTotal;
	}

	public String getAssetIncome() {
		return assetIncome;
	}

	public void setAssetIncome(String assetIncome) {
		this.assetIncome = assetIncome;
	}

	public String getTechSales() {
		return techSales;
	}

	public void setTechSales(String techSales) {
		this.techSales = techSales;
	}

	public String getTechProfit() {
		return techProfit;
	}

	public void setTechProfit(String techProfit) {
		this.techProfit = techProfit;
	}

	public String getAssetLiabilities() {
		return assetLiabilities;
	}

	public void setAssetLiabilities(String assetLiabilities) {
		this.assetLiabilities = assetLiabilities;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
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

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getCurrentLiability() {
		return currentLiability;
	}

	public void setCurrentLiability(String currentLiability) {
		this.currentLiability = currentLiability;
	}

	public String getLongLiability() {
		return longLiability;
	}

	public void setLongLiability(String longLiability) {
		this.longLiability = longLiability;
	}

	public String getMainBusIncome() {
		return mainBusIncome;
	}

	public void setMainBusIncome(String mainBusIncome) {
		this.mainBusIncome = mainBusIncome;
	}

	public String getTotalProfits() {
		return totalProfits;
	}

	public void setTotalProfits(String totalProfits) {
		this.totalProfits = totalProfits;
	}

	public String getTaxationProfit() {
		return taxationProfit;
	}

	public void setTaxationProfit(String taxationProfit) {
		this.taxationProfit = taxationProfit;
	}

	public String getForex() {
		return forex;
	}

	public void setForex(String forex) {
		this.forex = forex;
	}

	public String getOwnershipInterest() {
		return ownershipInterest;
	}

	public void setOwnershipInterest(String ownershipInterest) {
		this.ownershipInterest = ownershipInterest;
	}

	public String getReturnEquity() {
		return returnEquity;
	}

	public void setReturnEquity(String returnEquity) {
		this.returnEquity = returnEquity;
	}

	public int compare(CompanyBusiness source, CompanyBusiness target) {
		return Integer.parseInt(source.getAssetYear()) - Integer.parseInt(target.getAssetYear());
	}

}

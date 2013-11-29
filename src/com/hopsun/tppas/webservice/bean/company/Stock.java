package com.hopsun.tppas.webservice.bean.company;

/**
 *@comments 企业股权信息
 *@author wangxiaodong
 *@date 2013-10-17
 *@version 1.0
 */
public class Stock{

	private static final long serialVersionUID = -4551882312487517887L;
	//编号
	private String stockId;
	//股东名称
	private String stockName;
	//股东类型
	private String stockType;
	//投资者经济形态
	private String stockInvestor;
	//法人代码或身份证
	private String idCard;
	//是否上市公司
	private String isSeason;
	//是否海外公司
	private String isOverseas;
	//所占股份比例
	private String stockScale;
	//投资方式
	private String stockMode;
	//添加人
	private String createUser;
	//添加时间
	private String createDate;
	//排序
	private String stockDesc;
	//修改人
	private String modifyUser;
	//修改时间
	private String modifyDate;
	//投入资金
	private String money;

	public Stock() {
	}

	public Stock(String stockId, String stockName, String stockType, String stockInvestor, String idCard, String isSeason, String isOverseas, String stockScale, String stockMode, String createUser, String createDate, String stockDesc, String modifyUser, String modifyDate, String money) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.stockType = stockType;
		this.stockInvestor = stockInvestor;
		this.idCard = idCard;
		this.isSeason = isSeason;
		this.isOverseas = isOverseas;
		this.stockScale = stockScale;
		this.stockMode = stockMode;
		this.createUser = createUser;
		this.createDate = createDate;
		this.stockDesc = stockDesc;
		this.modifyUser = modifyUser;
		this.modifyDate = modifyDate;
		this.money = money;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public String getStockInvestor() {
		return stockInvestor;
	}

	public void setStockInvestor(String stockInvestor) {
		this.stockInvestor = stockInvestor;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getIsSeason() {
		return isSeason;
	}

	public void setIsSeason(String isSeason) {
		this.isSeason = isSeason;
	}

	public String getIsOverseas() {
		return isOverseas;
	}

	public void setIsOverseas(String isOverseas) {
		this.isOverseas = isOverseas;
	}

	public String getStockScale() {
		return stockScale;
	}

	public void setStockScale(String stockScale) {
		this.stockScale = stockScale;
	}

	public String getStockMode() {
		return stockMode;
	}

	public void setStockMode(String stockMode) {
		this.stockMode = stockMode;
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

	public String getStockDesc() {
		return stockDesc;
	}

	public void setStockDesc(String stockDesc) {
		this.stockDesc = stockDesc;
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

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}


}
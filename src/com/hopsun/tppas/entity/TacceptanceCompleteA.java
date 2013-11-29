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
 * TacceptanceCompleteA entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ACCEPTANCE_COMPLETE_A")
public class TacceptanceCompleteA implements java.io.Serializable {
	
	private static final long serialVersionUID = -2091507811230226549L;

	// Fields
	private String completeId;
	private Tacceptance tacceptance;
	private String contractRequire1;
	private String contractRequire2;
	private String contractRequire3;
	private String contractRequire4;
	private String actuallyAchieved1;
	private String actuallyAchieved2;
	private String actuallyAchieved3;
	private String actuallyAchieved4;
	private double conventionsSales;
	private double conventionsProfitTotal;
	private double conventionsTaxTotal;
	private double conventionsForeignExchange;
	private double completeSales;
	private double completeProfitTotal;
	private double completeTaxTotal;
	private double completeForeignExchange;
	private Integer receivePatentNum;
	private Integer receiveUtilityNum;
	private Integer receiveDesignsNum;
	private Integer receiveCopyrightNum;
	private Integer receiveForeignNum;
	private Integer applyPatentNum;
	private Integer applyUtilityNum;
	private Integer applyDesignsNum;
	private Integer applyCopyrightNum;
	private Integer applyForeignNum;
	private String otherOutcomes;
	private String createUser;
	private Timestamp createTime;
	private String updateUser;
	private Timestamp updateTime;
	private String deleteFlag;

	// Constructors

	/** default constructor */
	public TacceptanceCompleteA() {
	}

	/** full constructor */
	public TacceptanceCompleteA(Tacceptance tacceptance,
			String contractRequire1, String contractRequire2,
			String contractRequire3, String contractRequire4,
			String actuallyAchieved1, String actuallyAchieved2,
			String actuallyAchieved3, String actuallyAchieved4,
			double conventionsSales, double conventionsProfitTotal,
			double conventionsTaxTotal, double conventionsForeignExchange,
			double completeSales, double completeProfitTotal,
			double completeTaxTotal, double completeForeignExchange,
			Integer receivePatentNum, Integer receiveUtilityNum,
			Integer receiveDesignsNum, Integer receiveCopyrightNum,
			Integer receiveForeignNum, Integer applyPatentNum,
			Integer applyUtilityNum, Integer applyDesignsNum,
			Integer applyCopyrightNum, Integer applyForeignNum,
			String otherOutcomes, String createUser, Timestamp createTime,
			String updateUser, Timestamp updateTime, String deleteFlag) {
		this.tacceptance = tacceptance;
		this.contractRequire1 = contractRequire1;
		this.contractRequire2 = contractRequire2;
		this.contractRequire3 = contractRequire3;
		this.contractRequire4 = contractRequire4;
		this.actuallyAchieved1 = actuallyAchieved1;
		this.actuallyAchieved2 = actuallyAchieved2;
		this.actuallyAchieved3 = actuallyAchieved3;
		this.actuallyAchieved4 = actuallyAchieved4;
		this.conventionsSales = conventionsSales;
		this.conventionsProfitTotal = conventionsProfitTotal;
		this.conventionsTaxTotal = conventionsTaxTotal;
		this.conventionsForeignExchange = conventionsForeignExchange;
		this.completeSales = completeSales;
		this.completeProfitTotal = completeProfitTotal;
		this.completeTaxTotal = completeTaxTotal;
		this.completeForeignExchange = completeForeignExchange;
		this.receivePatentNum = receivePatentNum;
		this.receiveUtilityNum = receiveUtilityNum;
		this.receiveDesignsNum = receiveDesignsNum;
		this.receiveCopyrightNum = receiveCopyrightNum;
		this.receiveForeignNum = receiveForeignNum;
		this.applyPatentNum = applyPatentNum;
		this.applyUtilityNum = applyUtilityNum;
		this.applyDesignsNum = applyDesignsNum;
		this.applyCopyrightNum = applyCopyrightNum;
		this.applyForeignNum = applyForeignNum;
		this.otherOutcomes = otherOutcomes;
		this.createUser = createUser;
		this.createTime = createTime;
		this.updateUser = updateUser;
		this.updateTime = updateTime;
		this.deleteFlag = deleteFlag;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "COMPLETE_ID", unique = true, nullable = false, length = 40)
	public String getCompleteId() {
		return this.completeId;
	}

	public void setCompleteId(String completeId) {
		this.completeId = completeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCEPTANCE_ID")
	public Tacceptance getTacceptance() {
		return this.tacceptance;
	}

	public void setTacceptance(Tacceptance tacceptance) {
		this.tacceptance = tacceptance;
	}

	@Column(name = "CONTRACT_REQUIRE_1", length = 100)
	public String getContractRequire1() {
		return this.contractRequire1;
	}

	public void setContractRequire1(String contractRequire1) {
		this.contractRequire1 = contractRequire1;
	}

	@Column(name = "CONTRACT_REQUIRE_2", length = 100)
	public String getContractRequire2() {
		return this.contractRequire2;
	}

	public void setContractRequire2(String contractRequire2) {
		this.contractRequire2 = contractRequire2;
	}

	@Column(name = "CONTRACT_REQUIRE_3", length = 100)
	public String getContractRequire3() {
		return this.contractRequire3;
	}

	public void setContractRequire3(String contractRequire3) {
		this.contractRequire3 = contractRequire3;
	}

	@Column(name = "CONTRACT_REQUIRE_4", length = 100)
	public String getContractRequire4() {
		return this.contractRequire4;
	}

	public void setContractRequire4(String contractRequire4) {
		this.contractRequire4 = contractRequire4;
	}

	@Column(name = "ACTUALLY_ACHIEVED_1", length = 100)
	public String getActuallyAchieved1() {
		return this.actuallyAchieved1;
	}

	public void setActuallyAchieved1(String actuallyAchieved1) {
		this.actuallyAchieved1 = actuallyAchieved1;
	}

	@Column(name = "ACTUALLY_ACHIEVED_2", length = 100)
	public String getActuallyAchieved2() {
		return this.actuallyAchieved2;
	}

	public void setActuallyAchieved2(String actuallyAchieved2) {
		this.actuallyAchieved2 = actuallyAchieved2;
	}

	@Column(name = "ACTUALLY_ACHIEVED_3", length = 100)
	public String getActuallyAchieved3() {
		return this.actuallyAchieved3;
	}

	public void setActuallyAchieved3(String actuallyAchieved3) {
		this.actuallyAchieved3 = actuallyAchieved3;
	}

	@Column(name = "ACTUALLY_ACHIEVED_4", length = 100)
	public String getActuallyAchieved4() {
		return this.actuallyAchieved4;
	}

	public void setActuallyAchieved4(String actuallyAchieved4) {
		this.actuallyAchieved4 = actuallyAchieved4;
	}

	@Column(name = "CONVENTIONS_SALES", precision = 11, scale = 4)
	public double getConventionsSales() {
		return this.conventionsSales;
	}

	public void setConventionsSales(double conventionsSales) {
		this.conventionsSales = conventionsSales;
	}

	@Column(name = "CONVENTIONS_PROFIT_TOTAL", precision = 11, scale = 4)
	public double getConventionsProfitTotal() {
		return this.conventionsProfitTotal;
	}

	public void setConventionsProfitTotal(double conventionsProfitTotal) {
		this.conventionsProfitTotal = conventionsProfitTotal;
	}

	@Column(name = "CONVENTIONS_TAX_TOTAL", precision = 11, scale = 4)
	public double getConventionsTaxTotal() {
		return this.conventionsTaxTotal;
	}

	public void setConventionsTaxTotal(double conventionsTaxTotal) {
		this.conventionsTaxTotal = conventionsTaxTotal;
	}

	@Column(name = "CONVENTIONS_FOREIGN_EXCHANGE", precision = 11, scale = 4)
	public double getConventionsForeignExchange() {
		return this.conventionsForeignExchange;
	}

	public void setConventionsForeignExchange(double conventionsForeignExchange) {
		this.conventionsForeignExchange = conventionsForeignExchange;
	}

	@Column(name = "COMPLETE_SALES", precision = 11, scale = 4)
	public double getCompleteSales() {
		return this.completeSales;
	}

	public void setCompleteSales(double completeSales) {
		this.completeSales = completeSales;
	}

	@Column(name = "COMPLETE_PROFIT_TOTAL", precision = 11, scale = 4)
	public double getCompleteProfitTotal() {
		return this.completeProfitTotal;
	}

	public void setCompleteProfitTotal(double completeProfitTotal) {
		this.completeProfitTotal = completeProfitTotal;
	}

	@Column(name = "COMPLETE_TAX_TOTAL", precision = 11, scale = 4)
	public double getCompleteTaxTotal() {
		return this.completeTaxTotal;
	}

	public void setCompleteTaxTotal(double completeTaxTotal) {
		this.completeTaxTotal = completeTaxTotal;
	}

	@Column(name = "COMPLETE_FOREIGN_EXCHANGE", precision = 11, scale = 4)
	public double getCompleteForeignExchange() {
		return this.completeForeignExchange;
	}

	public void setCompleteForeignExchange(double completeForeignExchange) {
		this.completeForeignExchange = completeForeignExchange;
	}

	@Column(name = "RECEIVE_PATENT_NUM", precision = 7, scale = 0)
	public Integer getReceivePatentNum() {
		return this.receivePatentNum;
	}

	public void setReceivePatentNum(Integer receivePatentNum) {
		this.receivePatentNum = receivePatentNum;
	}

	@Column(name = "RECEIVE_UTILITY_NUM", precision = 7, scale = 0)
	public Integer getReceiveUtilityNum() {
		return this.receiveUtilityNum;
	}

	public void setReceiveUtilityNum(Integer receiveUtilityNum) {
		this.receiveUtilityNum = receiveUtilityNum;
	}

	@Column(name = "RECEIVE_DESIGNS_NUM", precision = 7, scale = 0)
	public Integer getReceiveDesignsNum() {
		return this.receiveDesignsNum;
	}

	public void setReceiveDesignsNum(Integer receiveDesignsNum) {
		this.receiveDesignsNum = receiveDesignsNum;
	}

	@Column(name = "RECEIVE_COPYRIGHT_NUM", precision = 7, scale = 0)
	public Integer getReceiveCopyrightNum() {
		return this.receiveCopyrightNum;
	}

	public void setReceiveCopyrightNum(Integer receiveCopyrightNum) {
		this.receiveCopyrightNum = receiveCopyrightNum;
	}

	@Column(name = "RECEIVE_FOREIGN_NUM", precision = 7, scale = 0)
	public Integer getReceiveForeignNum() {
		return this.receiveForeignNum;
	}

	public void setReceiveForeignNum(Integer receiveForeignNum) {
		this.receiveForeignNum = receiveForeignNum;
	}

	@Column(name = "APPLY_PATENT_NUM", precision = 7, scale = 0)
	public Integer getApplyPatentNum() {
		return this.applyPatentNum;
	}

	public void setApplyPatentNum(Integer applyPatentNum) {
		this.applyPatentNum = applyPatentNum;
	}

	@Column(name = "APPLY_UTILITY_NUM", precision = 7, scale = 0)
	public Integer getApplyUtilityNum() {
		return this.applyUtilityNum;
	}

	public void setApplyUtilityNum(Integer applyUtilityNum) {
		this.applyUtilityNum = applyUtilityNum;
	}

	@Column(name = "APPLY_DESIGNS_NUM", precision = 7, scale = 0)
	public Integer getApplyDesignsNum() {
		return this.applyDesignsNum;
	}

	public void setApplyDesignsNum(Integer applyDesignsNum) {
		this.applyDesignsNum = applyDesignsNum;
	}

	@Column(name = "APPLY_COPYRIGHT_NUM", precision = 7, scale = 0)
	public Integer getApplyCopyrightNum() {
		return this.applyCopyrightNum;
	}

	public void setApplyCopyrightNum(Integer applyCopyrightNum) {
		this.applyCopyrightNum = applyCopyrightNum;
	}

	@Column(name = "APPLY_FOREIGN_NUM", precision = 7, scale = 0)
	public Integer getApplyForeignNum() {
		return this.applyForeignNum;
	}

	public void setApplyForeignNum(Integer applyForeignNum) {
		this.applyForeignNum = applyForeignNum;
	}

	@Column(name = "OTHER_OUTCOMES", length = 4000)
	public String getOtherOutcomes() {
		return this.otherOutcomes;
	}

	public void setOtherOutcomes(String otherOutcomes) {
		this.otherOutcomes = otherOutcomes;
	}

	@Column(name = "CREATE_USER", length = 40)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "CREATE_TIME")
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "UPDATE_USER", length = 40)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Column(name = "UPDATE_TIME")
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
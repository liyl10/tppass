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
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 *@comments 项目预申报实体类
 *@author weina
 *@date 2013-9-9 上午10:05:37 
 *@version 1.0
 */
@Entity
@Table(name = "T_REPORT_BUDGET")
public class TreportBudget implements java.io.Serializable {
	private static final long serialVersionUID = -7927084948260952847L;
	// Fields
	private String projectBudgetId;
	private TprojectApplication tprojectApplication;
	private String projectName;
	private String reportBrief;
	private String remark;
	/**临时的简介*/
	private String reportBriefString;
	/**临时的备注*/
	private String remarkString;
	private double salesBenefit1;
	private double salesBenefit2;
	private double salesBenefit3;
	private double profitBenefit1;
	private double profitBenefit2;
	private double profitBenefit3;
	private double taxBenefit1;
	private double taxBenefit2;
	private double taxBenefit3;
	private String userId;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	/** 关联项目的项目名称id*/
	private String projectBuname;
	// Constructors

	/** default constructor */
	public TreportBudget() {
	}

	/** full constructor */
	public TreportBudget(TprojectApplication tprojectApplication, String projectName, String reportBrief, String remark,
			String reportBriefString,String remarkString,
			double salesBenefit1, double salesBenefit2,double salesBenefit3,double profitBenefit1,double profitBenefit2,
			double profitBenefit3,double taxBenefit1,double taxBenefit2,double taxBenefit3,String userId,String deleteFlag,
			Timestamp createTime,String createUser,Timestamp updateTime,String updateUser,String projectBuname ) {
		this.tprojectApplication = tprojectApplication;
		this.projectName = projectName;
		this.reportBrief = reportBrief;
		this.remark = remark;
		this.reportBriefString = reportBriefString;
		this.remarkString = remarkString;
		this.salesBenefit1 = salesBenefit1;
		this.salesBenefit2 = salesBenefit2;
		this.salesBenefit3 = salesBenefit3;
		this.profitBenefit1 = profitBenefit1;
		this.profitBenefit2 = profitBenefit2;
		this.profitBenefit3 = profitBenefit3;
		this.taxBenefit1 = taxBenefit1;
		this.taxBenefit2 = taxBenefit2;
		this.taxBenefit3 = taxBenefit3;
		this.userId = userId;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.projectBuname = projectBuname;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PROJECT_BUDGET_ID", unique = true, nullable = false, length = 40)
	public String getProjectBudgetId() {
		return projectBudgetId;
	}

	public void setProjectBudgetId(String projectBudgetId) {
		this.projectBudgetId = projectBudgetId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return tprojectApplication;
	}

	

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}
	@Column(name = "PROJECT_NAME", length = 100)
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "REPORT_BRIEF", length = 1000)
	public String getReportBrief() {
		return reportBrief;
	}


	public void setReportBrief(String reportBrief) {
		this.reportBrief = reportBrief;
	}
	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Transient
	public String getReportBriefString() {
		return reportBriefString;
	}

	public void setReportBriefString(String reportBriefString) {
		this.reportBriefString = reportBriefString;
	}
	@Transient
	public String getRemarkString() {
		return remarkString;
	}

	public void setRemarkString(String remarkString) {
		this.remarkString = remarkString;
	}

	@Column(name = "SALES_BENEFIT_1", precision = 11, scale = 4)
	public double getSalesBenefit1() {
		return salesBenefit1;
	}

	public void setSalesBenefit1(double salesBenefit1) {
		this.salesBenefit1 = salesBenefit1;
	}
	@Column(name = "SALES_BENEFIT_2", precision = 11, scale = 4)
	public double getSalesBenefit2() {
		return salesBenefit2;
	}

	public void setSalesBenefit2(double salesBenefit2) {
		this.salesBenefit2 = salesBenefit2;
	}
	@Column(name = "SALES_BENEFIT_3", precision = 11, scale = 4)
	public double getSalesBenefit3() {
		return salesBenefit3;
	}
	
	public void setSalesBenefit3(double salesBenefit3) {
		this.salesBenefit3 = salesBenefit3;
	}
	@Column(name = "PROFIT_BENEFIT_1", precision = 11, scale = 4)
	public double getProfitBenefit1() {
		return profitBenefit1;
	}

	public void setProfitBenefit1(double profitBenefit1) {
		this.profitBenefit1 = profitBenefit1;
	}
	@Column(name = "PROFIT_BENEFIT_2", precision = 11, scale = 4)
	public double getProfitBenefit2() {
		return profitBenefit2;
	}

	public void setProfitBenefit2(double profitBenefit2) {
		this.profitBenefit2 = profitBenefit2;
	}
	@Column(name = "PROFIT_BENEFIT_3", precision = 11, scale = 4)
	public double getProfitBenefit3() {
		return profitBenefit3;
	}

	public void setProfitBenefit3(double profitBenefit3) {
		this.profitBenefit3 = profitBenefit3;
	}
	@Column(name = "TAX_BENEFIT_1", precision = 11, scale = 4)
	public double getTaxBenefit1() {
		return taxBenefit1;
	}

	public void setTaxBenefit1(double taxBenefit1) {
		this.taxBenefit1 = taxBenefit1;
	}
	@Column(name = "TAX_BENEFIT_2", precision = 11, scale = 4)
	public double getTaxBenefit2() {
		return taxBenefit2;
	}

	public void setTaxBenefit2(double taxBenefit2) {
		this.taxBenefit2 = taxBenefit2;
	}
	@Column(name = "TAX_BENEFIT_3", precision = 11, scale = 4)
	public double getTaxBenefit3() {
		return taxBenefit3;
	}

	public void setTaxBenefit3(double taxBenefit3) {
		this.taxBenefit3 = taxBenefit3;
	}
	
	@Column(name = "USER_ID", length = 40)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	@Column(name = "CREATE_TIME")
	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@Column(name = "CREATE_USER", length = 50)
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	@Column(name = "UPDATE_TIME")
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	@Column(name = "UPDATE_USER", length = 50)
	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	@Column(name = "PROJECT_BUNAME", length = 100)
	public String getProjectBuname() {
		return projectBuname;
	}

	public void setProjectBuname(String projectBuname) {
		this.projectBuname = projectBuname;
	}


}
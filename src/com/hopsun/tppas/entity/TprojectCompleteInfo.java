/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.entity;

import java.math.BigDecimal;
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
 * 
 * @comments 对照合同项目任务完成情况
 * @author wangxiaodong
 * @date 2013-8-12
 * @version 1.0
 */
@Entity
@Table(name = "T_PROJECT_COMPLETE_INFO")
public class TprojectCompleteInfo implements java.io.Serializable {
	
	private static final long serialVersionUID = -2436653960366111901L;
	// Fields

	private String projectCompleteInfoId;
	private Tsupervisor tsupervisor;
	private String projectSchedule;
	private String projectReason;
	private BigDecimal sellContract;
	private BigDecimal sellReal;
	private BigDecimal profitContract;
	private BigDecimal profitReal;
	private BigDecimal taxContract;
	private BigDecimal taxReal;
	private BigDecimal exportContract;
	private BigDecimal exportReal;
	private String commentInfo;
	private String deleteFlag;
	private String remark;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;

	// Constructors

	/** default constructor */
	public TprojectCompleteInfo() {
	}

	/** full constructor */
	public TprojectCompleteInfo(Tsupervisor tsupervisor, String projectSchedule,
			String projectReason, BigDecimal sellContract, BigDecimal sellReal,
			BigDecimal profitContract, BigDecimal profitReal, BigDecimal taxContract,
			BigDecimal taxReal, BigDecimal exportContract, BigDecimal exportReal,
			String commentInfo, String deleteFlag, String remark,
			Timestamp createTime, String createUser, Timestamp updateDate,
			String updateUser) {
		this.tsupervisor = tsupervisor;
		this.projectSchedule = projectSchedule;
		this.projectReason = projectReason;
		this.sellContract = sellContract;
		this.sellReal = sellReal;
		this.profitContract = profitContract;
		this.profitReal = profitReal;
		this.taxContract = taxContract;
		this.taxReal = taxReal;
		this.exportContract = exportContract;
		this.exportReal = exportReal;
		this.commentInfo = commentInfo;
		this.deleteFlag = deleteFlag;
		this.remark = remark;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PROJECT_COMPLETE_INFO_ID", unique = true, nullable = false, length = 40)
	public String getProjectCompleteInfoId() {
		return this.projectCompleteInfoId;
	}

	public void setProjectCompleteInfoId(String projectCompleteInfoId) {
		this.projectCompleteInfoId = projectCompleteInfoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPERVISOR_ID")
	public Tsupervisor getTsupervisor() {
		return tsupervisor;
	}

	public void setTsupervisor(Tsupervisor tsupervisor) {
		this.tsupervisor = tsupervisor;
	}

	@Column(name = "PROJECT_SCHEDULE", length = 40)
	public String getProjectSchedule() {
		return this.projectSchedule;
	}

	public void setProjectSchedule(String projectSchedule) {
		this.projectSchedule = projectSchedule;
	}

	@Column(name = "PROJECT_REASON", length = 200)
	public String getProjectReason() {
		return this.projectReason;
	}

	public void setProjectReason(String projectReason) {
		this.projectReason = projectReason;
	}

	@Column(name = "SELL_CONTRACT", precision = 11, scale = 4)
	public BigDecimal getSellContract() {
		return this.sellContract;
	}

	public void setSellContract(BigDecimal sellContract) {
		this.sellContract = sellContract;
	}

	@Column(name = "SELL_REAL", precision = 11, scale = 4)
	public BigDecimal getSellReal() {
		return this.sellReal;
	}

	public void setSellReal(BigDecimal sellReal) {
		this.sellReal = sellReal;
	}

	@Column(name = "PROFIT_CONTRACT", precision = 11, scale = 4)
	public BigDecimal getProfitContract() {
		return this.profitContract;
	}

	public void setProfitContract(BigDecimal profitContract) {
		this.profitContract = profitContract;
	}

	@Column(name = "PROFIT_REAL", precision = 11, scale = 4)
	public BigDecimal getProfitReal() {
		return this.profitReal;
	}

	public void setProfitReal(BigDecimal profitReal) {
		this.profitReal = profitReal;
	}

	@Column(name = "TAX_CONTRACT", precision = 11, scale = 4)
	public BigDecimal getTaxContract() {
		return this.taxContract;
	}

	public void setTaxContract(BigDecimal taxContract) {
		this.taxContract = taxContract;
	}

	@Column(name = "TAX_REAL", precision = 11, scale = 4)
	public BigDecimal getTaxReal() {
		return this.taxReal;
	}

	public void setTaxReal(BigDecimal taxReal) {
		this.taxReal = taxReal;
	}

	@Column(name = "EXPORT_CONTRACT", precision = 11, scale = 4)
	public BigDecimal getExportContract() {
		return this.exportContract;
	}

	public void setExportContract(BigDecimal exportContract) {
		this.exportContract = exportContract;
	}

	@Column(name = "EXPORT_REAL", precision = 11, scale = 4)
	public BigDecimal getExportReal() {
		return this.exportReal;
	}

	public void setExportReal(BigDecimal exportReal) {
		this.exportReal = exportReal;
	}

	@Column(name = "COMMENT_INFO", length = 4000)
	public String getCommentInfo() {
		return this.commentInfo;
	}

	public void setCommentInfo(String commentInfo) {
		this.commentInfo = commentInfo;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "REMARK", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "CREATE_TIME")
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "CREATE_USER", length = 50)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "UPDATE_DATE")
	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "UPDATE_USER", length = 50)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
}
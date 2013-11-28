package com.hopsun.tppas.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import java.sql.*;
/**
 * Tcontract entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_CONTRACT")
public class Tcontract implements java.io.Serializable {

	private static final long serialVersionUID = 1324401483214221164L;
	// Fields
	private String TContractId;
	private TprojectApplication tprojectApplication;
	private Timestamp contractDate;
	private String contractStatus;
	private String approvalOpinion;
	private Timestamp approvalTime;
	private String optUser;
	private String userId;
	private String pdfUrl;
	private Timestamp optTime;
	private String compilationDept;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String remark;
	private String contractType;
	private List<TcontractCoverA> tcontractCoverAs = new ArrayList<TcontractCoverA>(0);
	private List<TfundUseA> tfundUseAs = new ArrayList<TfundUseA>(0);
	private List<TcontractContentsB> tcontractContentsBs = new ArrayList<TcontractContentsB>(0);
	private List<TcontractContentsA> tcontractContentsAs = new ArrayList<TcontractContentsA>(0);
	private List<TfundingPlanB> tfundingPlanBs = new ArrayList<TfundingPlanB>(0);
	private List<TeconomicIndicatorsB> teconomicIndicatorsBs = new ArrayList<TeconomicIndicatorsB>(0);
	private List<TarrangementB> tarrangementBs = new ArrayList<TarrangementB>(0);
	private List<TprojectLeaderB> tprojectLeaderBs = new ArrayList<TprojectLeaderB>(0);
	private List<TappropriationSingle> tappropriationSingles = new ArrayList<TappropriationSingle>(0);
	// Constructors

	/** default constructor */
	public Tcontract() {
	}

	/** full constructor */
	public Tcontract(TprojectApplication tprojectApplication,
			Timestamp contractDate, String contractStatus, String approvalOpinion,
			Timestamp approvalTime, String optUser, String userId, String pdfUrl,
			Timestamp optTime, String compilationDept, String deleteFlag,
			Timestamp createTime, String createUser, Timestamp updateTime,
			String updateUser, String remark,String contractType,
			List<TcontractCoverA> tcontractCoverAs, List<TfundUseA> tfundUseAs,
			List<TcontractContentsB> tcontractContentsBs,
			List<TcontractContentsA> tcontractContentsAs,
			List<TfundingPlanB> tfundingPlanBs,
			List<TeconomicIndicatorsB> teconomicIndicatorsBs,
			List<TarrangementB> tarrangementBs,
			List<TprojectLeaderB> tprojectLeaderBs,
			List<TappropriationSingle> tappropriationSingles) {
		this.tprojectApplication = tprojectApplication;
		this.contractDate = contractDate;
		this.contractStatus = contractStatus;
		this.approvalOpinion = approvalOpinion;
		this.approvalTime = approvalTime;
		this.optUser = optUser;
		this.userId = userId;
		this.pdfUrl = pdfUrl;
		this.optTime = optTime;
		this.compilationDept = compilationDept;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.remark = remark;
		this.contractType = contractType;
		this.tcontractCoverAs = tcontractCoverAs;
		this.tfundUseAs = tfundUseAs;
		this.tcontractContentsBs = tcontractContentsBs;
		this.tcontractContentsAs = tcontractContentsAs;
		this.tfundingPlanBs = tfundingPlanBs;
		this.teconomicIndicatorsBs = teconomicIndicatorsBs;
		this.tarrangementBs = tarrangementBs;
		this.tprojectLeaderBs = tprojectLeaderBs;
		this.tappropriationSingles = tappropriationSingles;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "T_CONTRACT_ID", unique = true, nullable = false, length = 40)
	public String getTContractId() {
		return this.TContractId;
	}

	public void setTContractId(String TContractId) {
		this.TContractId = TContractId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "CONTRACT_DATE")
	public Timestamp getContractDate() {
		return this.contractDate;
	}

	public void setContractDate(Timestamp contractDate) {
		this.contractDate = contractDate;
	}

	@Column(name = "CONTRACT_STATUS", length = 40)
	public String getContractStatus() {
		return this.contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	@Column(name = "APPROVAL_OPINION", length = 4000)
	public String getApprovalOpinion() {
		return this.approvalOpinion;
	}

	public void setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion = approvalOpinion;
	}

	@Column(name = "APPROVAL_TIME")
	public Timestamp getApprovalTime() {
		return this.approvalTime;
	}

	public void setApprovalTime(Timestamp approvalTime) {
		this.approvalTime = approvalTime;
	}

	@Column(name = "OPT_USER", length = 40)
	public String getOptUser() {
		return this.optUser;
	}

	public void setOptUser(String optUser) {
		this.optUser = optUser;
	}

	@Column(name = "USER_ID", length = 40)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "PDF_URL", length = 300)
	public String getPdfUrl() {
		return this.pdfUrl;
	}

	public void setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
	}

	@Column(name = "OPT_TIME")
	public Timestamp getOptTime() {
		return this.optTime;
	}

	public void setOptTime(Timestamp optTime) {
		this.optTime = optTime;
	}

	@Column(name = "COMPILATION_DEPT", length = 200)
	public String getCompilationDept() {
		return this.compilationDept;
	}

	public void setCompilationDept(String compilationDept) {
		this.compilationDept = compilationDept;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
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

	@Column(name = "UPDATE_TIME")
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "UPDATE_USER", length = 50)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "CONTRACT_TYPE", length = 40)
	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tcontract")
	public List<TcontractCoverA> getTcontractCoverAs() {
		return this.tcontractCoverAs;
	}

	public void setTcontractCoverAs(List<TcontractCoverA> tcontractCoverAs) {
		this.tcontractCoverAs = tcontractCoverAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tcontract")
	public List<TfundUseA> getTfundUseAs() {
		return this.tfundUseAs;
	}

	public void setTfundUseAs(List<TfundUseA> tfundUseAs) {
		this.tfundUseAs = tfundUseAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tcontract")
	public List<TcontractContentsB> getTcontractContentsBs() {
		return this.tcontractContentsBs;
	}

	public void setTcontractContentsBs(
			List<TcontractContentsB> tcontractContentsBs) {
		this.tcontractContentsBs = tcontractContentsBs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tcontract")
	public List<TcontractContentsA> getTcontractContentsAs() {
		return this.tcontractContentsAs;
	}

	public void setTcontractContentsAs(
			List<TcontractContentsA> tcontractContentsAs) {
		this.tcontractContentsAs = tcontractContentsAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tcontract")
	public List<TfundingPlanB> getTfundingPlanBs() {
		return this.tfundingPlanBs;
	}

	public void setTfundingPlanBs(
			List<TfundingPlanB> tfundingPlanBs) {
		this.tfundingPlanBs = tfundingPlanBs;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tcontract")
	public List<TeconomicIndicatorsB> getTeconomicIndicatorsBs() {
		return this.teconomicIndicatorsBs;
	}

	public void setTeconomicIndicatorsBs(
			List<TeconomicIndicatorsB> teconomicIndicatorsBs) {
		this.teconomicIndicatorsBs = teconomicIndicatorsBs;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tcontract")
	public List<TarrangementB> getTarrangementBs() {
		return this.tarrangementBs;
	}

	public void setTarrangementBs(
			List<TarrangementB> tarrangementBs) {
		this.tarrangementBs = tarrangementBs;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tcontract")
	public List<TprojectLeaderB> getTprojectLeaderBs() {
		return this.tprojectLeaderBs;
	}

	public void setTprojectLeaderBs(
			List<TprojectLeaderB> tprojectLeaderBs) {
		this.tprojectLeaderBs = tprojectLeaderBs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tcontract")
	public List<TappropriationSingle> getTappropriationSingles() {
		return tappropriationSingles;
	}

	public void setTappropriationSingles(
			List<TappropriationSingle> tappropriationSingles) {
		this.tappropriationSingles = tappropriationSingles;
	}
	
}
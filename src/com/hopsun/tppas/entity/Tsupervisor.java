/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.tppas.entity;

import java.sql.Timestamp;
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
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @comments 项目监理
 * @author wangxiaodong
 * @date 2013-8-2
 * @version 1.0
 */
@Entity
@Table(name = "T_SUPERVISOR")
public class Tsupervisor implements java.io.Serializable {

	private static final long serialVersionUID = -7428673968362426052L;
	// Fields

	private String supervisorId;
	private TprojectApplication tprojectApplication;
	private Timestamp supervisorStarttime;
	private Timestamp supervisorEndtime;
	private String checkInfo;
	private Timestamp checkTime;
	private String isLastApply;
	private String supervisorState;
	private String userId;
	private String pdfUrl;
	private Timestamp operateTime;
	private String operateUser;
	private String compilationDept;
	private String deleteFlag;
	private String createUser;
	private Timestamp createTime;
	private String updateUser;
	private Timestamp updateTime;
	private String remark;
	private String modelType;
	private String writePerson;
	private String writeTel;
	private String writeMobile;
	private List<TsupervisorFundB> tsupervisorFundBs = new ArrayList<TsupervisorFundB>(0);
	private List<TprojectAchievementInfo> tprojectAchievementInfos = new ArrayList<TprojectAchievementInfo>(0);
	private List<TcompanyDevelopInfo> tcompanyDevelopInfos = new ArrayList<TcompanyDevelopInfo>(0);
	private List<TsupervisorReport> tsupervisorReports = new ArrayList<TsupervisorReport>(0);
	private List<TprojectManagementInfo> tprojectManagementInfos = new ArrayList<TprojectManagementInfo>(0);
	private List<TprojectIndustrialization> tprojectIndustrializations = new ArrayList<TprojectIndustrialization>(0);
	private List<TsupervisorPoint> tsupervisorPoints = new ArrayList<TsupervisorPoint>(0);
	private List<TsupervisorInfoA> tsupervisorInfoAs = new ArrayList<TsupervisorInfoA>(0);
	private List<TsupervisorFundA> tsupervisorFundAs = new ArrayList<TsupervisorFundA>(0);
	private List<TprojectCompleteInfo> tprojectCompleteInfos = new ArrayList<TprojectCompleteInfo>(0);
	private List<TtechnicalCompleteInfo> ttechnicalCompleteInfos = new ArrayList<TtechnicalCompleteInfo>(0);
	
	//临时属性
	/**是否可修改*/
	private String isEdit;
	
	/**监理状态的名称*/
	private String supervisorStateName;

	// Constructors

	/** default constructor */
	public Tsupervisor() {
	}

	/** full constructor */
	public Tsupervisor(TprojectApplication tprojectApplication,
			Timestamp supervisorStarttime, Timestamp supervisorEndtime,
			String checkInfo, Timestamp checkTime, String isLastApply,String supervisorState,
			String userId, String pdfUrl, Timestamp operateTime,
			String operateUser, String compilationDept, String deleteFlag,
			String createUser, Timestamp createTime, String updateUser,
			Timestamp updateTime, String remark,String modelType,
			String writePerson, String writeTel,String writeMobile,
			List<TsupervisorFundB> tsupervisorFundBs,
			List<TprojectAchievementInfo> tprojectAchievementInfos,
			List<TcompanyDevelopInfo> tcompanyDevelopInfos,
			List<TsupervisorReport> tsupervisorReports,
			List<TprojectManagementInfo> tprojectManagementInfos,
			List<TprojectIndustrialization> tprojectIndustrializations,
			List<TsupervisorPoint> tsupervisorPoints,
			List<TsupervisorInfoA> tsupervisorInfoAs,
			List<TsupervisorFundA> tsupervisorFundAs,List<TprojectCompleteInfo> tprojectCompleteInfos,
			List<TtechnicalCompleteInfo> ttechnicalCompleteInfos) {
		this.tprojectApplication = tprojectApplication;
		this.supervisorStarttime = supervisorStarttime;
		this.supervisorEndtime = supervisorEndtime;
		this.checkInfo = checkInfo;
		this.checkTime = checkTime;
		this.isLastApply = isLastApply;
		this.supervisorState = supervisorState;
		this.userId = userId;
		this.pdfUrl = pdfUrl;
		this.operateTime = operateTime;
		this.operateUser = operateUser;
		this.compilationDept = compilationDept;
		this.deleteFlag = deleteFlag;
		this.createUser = createUser;
		this.createTime = createTime;
		this.updateUser = updateUser;
		this.updateTime = updateTime;
		this.remark = remark;
		this.modelType = modelType;
		this.writePerson = writePerson;
		this.writeTel = writeTel;
		this.writeMobile = writeMobile;
		this.tsupervisorFundBs = tsupervisorFundBs;
		this.tprojectAchievementInfos = tprojectAchievementInfos;
		this.tcompanyDevelopInfos = tcompanyDevelopInfos;
		this.tsupervisorReports = tsupervisorReports;
		this.tprojectManagementInfos = tprojectManagementInfos;
		this.tprojectIndustrializations = tprojectIndustrializations;
		this.tsupervisorPoints = tsupervisorPoints;
		this.tsupervisorInfoAs = tsupervisorInfoAs;
		this.tsupervisorFundAs = tsupervisorFundAs;
		this.tprojectCompleteInfos = tprojectCompleteInfos;
		this.ttechnicalCompleteInfos = ttechnicalCompleteInfos;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SUPERVISOR_ID", unique = true, nullable = false, length = 40)
	public String getSupervisorId() {
		return this.supervisorId;
	}

	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "SUPERVISOR_STARTTIME")
	public Timestamp getSupervisorStarttime() {
		return this.supervisorStarttime;
	}

	public void setSupervisorStarttime(Timestamp supervisorStarttime) {
		this.supervisorStarttime = supervisorStarttime;
	}

	@Column(name = "SUPERVISOR_ENDTIME")
	public Timestamp getSupervisorEndtime() {
		return this.supervisorEndtime;
	}

	public void setSupervisorEndtime(Timestamp supervisorEndtime) {
		this.supervisorEndtime = supervisorEndtime;
	}

	@Column(name = "CHECK_INFO", length = 500)
	public String getCheckInfo() {
		return this.checkInfo;
	}

	public void setCheckInfo(String checkInfo) {
		this.checkInfo = checkInfo;
	}

	@Column(name = "CHECK_TIME")
	public Timestamp getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}

	@Column(name = "IS_LAST_APPLY", length = 1)
	public String getIsLastApply() {
		return this.isLastApply;
	}

	public void setIsLastApply(String isLastApply) {
		this.isLastApply = isLastApply;
	}
	
	@Column(name = "SUPERVISOR_STATE", length = 40)
	public String getSupervisorState() {
		return supervisorState;
	}

	public void setSupervisorState(String supervisorState) {
		this.supervisorState = supervisorState;
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

	@Column(name = "OPERATE_TIME")
	public Timestamp getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(Timestamp operateTime) {
		this.operateTime = operateTime;
	}

	@Column(name = "OPERATE_USER", length = 50)
	public String getOperateUser() {
		return this.operateUser;
	}

	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
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

	@Column(name = "CREATE_USER", length = 50)
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

	@Column(name = "UPDATE_USER", length = 50)
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

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "MODEL_TYPE", length = 1)
	public String getModelType() {
		return this.modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}
	
	@Column(name = "write_person", length = 50)
	public String getWritePerson() {
		return writePerson;
	}

	public void setWritePerson(String writePerson) {
		this.writePerson = writePerson;
	}

	@Column(name = "write_tel", length = 20)
	public String getWriteTel() {
		return writeTel;
	}

	public void setWriteTel(String writeTel) {
		this.writeTel = writeTel;
	}

	@Column(name = "write_mobile", length = 20)
	public String getWriteMobile() {
		return writeMobile;
	}

	public void setWriteMobile(String writeMobile) {
		this.writeMobile = writeMobile;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tsupervisor")
	public List<TsupervisorFundB> getTsupervisorFundBs() {
		return this.tsupervisorFundBs;
	}

	public void setTsupervisorFundBs(List<TsupervisorFundB> tsupervisorFundBs) {
		this.tsupervisorFundBs = tsupervisorFundBs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tsupervisor")
	public List<TprojectAchievementInfo> getTprojectAchievementInfos() {
		return this.tprojectAchievementInfos;
	}

	public void setTprojectAchievementInfos(
			List<TprojectAchievementInfo> tprojectAchievementInfos) {
		this.tprojectAchievementInfos = tprojectAchievementInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tsupervisor")
	public List<TcompanyDevelopInfo> getTcompanyDevelopInfos() {
		return this.tcompanyDevelopInfos;
	}

	public void setTcompanyDevelopInfos(
			List<TcompanyDevelopInfo> tcompanyDevelopInfos) {
		this.tcompanyDevelopInfos = tcompanyDevelopInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tsupervisor")
	public List<TsupervisorReport> getTsupervisorReports() {
		return this.tsupervisorReports;
	}

	public void setTsupervisorReports(List<TsupervisorReport> tsupervisorReports) {
		this.tsupervisorReports = tsupervisorReports;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tsupervisor")
	public List<TprojectManagementInfo> getTprojectManagementInfos() {
		return this.tprojectManagementInfos;
	}

	public void setTprojectManagementInfos(
			List<TprojectManagementInfo> tprojectManagementInfos) {
		this.tprojectManagementInfos = tprojectManagementInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tsupervisor")
	public List<TprojectIndustrialization> getTprojectIndustrializations() {
		return this.tprojectIndustrializations;
	}

	public void setTprojectIndustrializations(
			List<TprojectIndustrialization> tprojectIndustrializations) {
		this.tprojectIndustrializations = tprojectIndustrializations;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tsupervisor")
	public List<TsupervisorPoint> getTsupervisorPoints() {
		return this.tsupervisorPoints;
	}

	public void setTsupervisorPoints(List<TsupervisorPoint> tsupervisorPoints) {
		this.tsupervisorPoints = tsupervisorPoints;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tsupervisor")
	public List<TsupervisorInfoA> getTsupervisorInfoAs() {
		return this.tsupervisorInfoAs;
	}

	public void setTsupervisorInfoAs(List<TsupervisorInfoA> tsupervisorInfoAs) {
		this.tsupervisorInfoAs = tsupervisorInfoAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tsupervisor")
	public List<TsupervisorFundA> getTsupervisorFundAs() {
		return this.tsupervisorFundAs;
	}

	public void setTsupervisorFundAs(List<TsupervisorFundA> tsupervisorFundAs) {
		this.tsupervisorFundAs = tsupervisorFundAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tsupervisor")
	public List<TprojectCompleteInfo> getTprojectCompleteInfos() {
		return tprojectCompleteInfos;
	}

	public void setTprojectCompleteInfos(List<TprojectCompleteInfo> tprojectCompleteInfos) {
		this.tprojectCompleteInfos = tprojectCompleteInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tsupervisor")
	public List<TtechnicalCompleteInfo> getTtechnicalCompleteInfos() {
		return ttechnicalCompleteInfos;
	}

	public void setTtechnicalCompleteInfos(List<TtechnicalCompleteInfo> ttechnicalCompleteInfos) {
		this.ttechnicalCompleteInfos = ttechnicalCompleteInfos;
	}

	@Transient
	public String getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}

	@Transient
	public String getSupervisorStateName() {
		return supervisorStateName;
	}

	public void setSupervisorStateName(String supervisorStateName) {
		this.supervisorStateName = supervisorStateName;
	}
}
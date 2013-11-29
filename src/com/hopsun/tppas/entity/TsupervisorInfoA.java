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
 * TsupervisorInfoA entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_SUPERVISOR_INFO_A")
public class TsupervisorInfoA implements java.io.Serializable {

	private static final long serialVersionUID = 749984372776329495L;
	// Fields

	private String infoId;
	private Tsupervisor tsupervisor;
	private String projectNumber;
	private String bearUnit;
	private String field;
	private String projectPersonName;
	private String projectPersonEducation;
	private String projectPersonTitle;
	private String linkPersonName;
	private String linkPersonTel;
	private String linkPersonMobile;
	private String projectSchedule;
	private String projectReason;
	private double companyAssets;
	private double companyOutputThree;
	private double companyOutputTwo;
	private double companyOutputOne;
	private double projectOutputThree;
	private double projectOutputTwo;
	private double projectOutputOne;
	private double companySellThree;
	private double companySellTwo;
	private double companySellOne;
	private double projectSellThree;
	private double projectSellTwo;
	private double projectSellOne;
	private double companyProfitThree;
	private double companyProfitTwo;
	private double companyProfitOne;
	private double projectProfitThree;
	private double projectProfitTwo;
	private double projectProfitOne;
	private double companyTaxThree;
	private double companyTaxTwo;
	private double companyTaxOne;
	private double projectTaxTwo;
	private double projectTaxOne;
	private double projectTaxThree;
	private double companyExportThree;
	private double companyExportTwo;
	private double companyExportOne;
	private double projectExportThree;
	private double projectExportTwo;
	private double projectExportOne;
	private double hardwareArea;
	private double equipmentTotal;
	private long hardwareTotal;
	private long newHardwareTotal;
	private long staffTotal;
	private long undergraduateTotal;
	private long trainTotal;
	private long serviceTotal;
	private Timestamp writeTime;
	private String deleteFlag;
	private String remark;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;
	private String projectReasonCommand;
	private String otherField;

	// Constructors

	/** default constructor */
	public TsupervisorInfoA() {
	}

	/** full constructor */
	public TsupervisorInfoA(Tsupervisor tsupervisor, String projectNumber,
			String bearUnit, String field, String projectPersonName,
			String projectPersonEducation, String projectPersonTitle,
			String linkPersonName, String linkPersonTel,
			String linkPersonMobile, String projectSchedule,
			String projectReason, double companyAssets,
			double companyOutputThree, double companyOutputTwo,
			double companyOutputOne, double projectOutputThree,
			double projectOutputTwo, double projectOutputOne,
			double companySellThree, double companySellTwo,
			double companySellOne, double projectSellThree,
			double projectSellTwo, double projectSellOne,
			double companyProfitThree, double companyProfitTwo,
			double companyProfitOne, double projectProfitThree,
			double projectProfitTwo, double projectProfitOne,
			double companyTaxThree, double companyTaxTwo, double companyTaxOne,
			double projectTaxTwo, double projectTaxOne, double projectTaxThree,
			double companyExportThree, double companyExportTwo,
			double companyExportOne, double projectExportThree,
			double projectExportTwo, double projectExportOne,
			double hardwareArea, double equipmentTotal, long hardwareTotal,
			long newHardwareTotal, long staffTotal, long undergraduateTotal,
			long trainTotal, long serviceTotal, Timestamp writeTime,
			String deleteFlag, String remark, Timestamp createTime,
			String createUser, Timestamp updateDate, String updateUser,
			String projectReasonCommand,String otherField) {
		this.tsupervisor = tsupervisor;
		this.projectNumber = projectNumber;
		this.bearUnit = bearUnit;
		this.field = field;
		this.projectPersonName = projectPersonName;
		this.projectPersonEducation = projectPersonEducation;
		this.projectPersonTitle = projectPersonTitle;
		this.linkPersonName = linkPersonName;
		this.linkPersonTel = linkPersonTel;
		this.linkPersonMobile = linkPersonMobile;
		this.projectSchedule = projectSchedule;
		this.projectReason = projectReason;
		this.companyAssets = companyAssets;
		this.companyOutputThree = companyOutputThree;
		this.companyOutputTwo = companyOutputTwo;
		this.companyOutputOne = companyOutputOne;
		this.projectOutputThree = projectOutputThree;
		this.projectOutputTwo = projectOutputTwo;
		this.projectOutputOne = projectOutputOne;
		this.companySellThree = companySellThree;
		this.companySellTwo = companySellTwo;
		this.companySellOne = companySellOne;
		this.projectSellThree = projectSellThree;
		this.projectSellTwo = projectSellTwo;
		this.projectSellOne = projectSellOne;
		this.companyProfitThree = companyProfitThree;
		this.companyProfitTwo = companyProfitTwo;
		this.companyProfitOne = companyProfitOne;
		this.projectProfitThree = projectProfitThree;
		this.projectProfitTwo = projectProfitTwo;
		this.projectProfitOne = projectProfitOne;
		this.companyTaxThree = companyTaxThree;
		this.companyTaxTwo = companyTaxTwo;
		this.companyTaxOne = companyTaxOne;
		this.projectTaxTwo = projectTaxTwo;
		this.projectTaxOne = projectTaxOne;
		this.projectTaxThree = projectTaxThree;
		this.companyExportThree = companyExportThree;
		this.companyExportTwo = companyExportTwo;
		this.companyExportOne = companyExportOne;
		this.projectExportThree = projectExportThree;
		this.projectExportTwo = projectExportTwo;
		this.projectExportOne = projectExportOne;
		this.hardwareArea = hardwareArea;
		this.equipmentTotal = equipmentTotal;
		this.hardwareTotal = hardwareTotal;
		this.newHardwareTotal = newHardwareTotal;
		this.staffTotal = staffTotal;
		this.undergraduateTotal = undergraduateTotal;
		this.trainTotal = trainTotal;
		this.serviceTotal = serviceTotal;
		this.writeTime = writeTime;
		this.deleteFlag = deleteFlag;
		this.remark = remark;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.projectReasonCommand = projectReasonCommand;
		this.otherField = otherField;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "INFO_ID", unique = true, nullable = false, length = 40)
	public String getInfoId() {
		return this.infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPERVISOR_ID")
	public Tsupervisor getTsupervisor() {
		return this.tsupervisor;
	}

	public void setTsupervisor(Tsupervisor tsupervisor) {
		this.tsupervisor = tsupervisor;
	}

	@Column(name = "PROJECT_NUMBER", length = 20)
	public String getProjectNumber() {
		return this.projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	@Column(name = "BEAR_UNIT", length = 100)
	public String getBearUnit() {
		return this.bearUnit;
	}

	public void setBearUnit(String bearUnit) {
		this.bearUnit = bearUnit;
	}

	@Column(name = "FIELD", length = 50)
	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Column(name = "PROJECT_PERSON_NAME", length = 50)
	public String getProjectPersonName() {
		return this.projectPersonName;
	}

	public void setProjectPersonName(String projectPersonName) {
		this.projectPersonName = projectPersonName;
	}

	@Column(name = "PROJECT_PERSON_EDUCATION", length = 50)
	public String getProjectPersonEducation() {
		return this.projectPersonEducation;
	}

	public void setProjectPersonEducation(String projectPersonEducation) {
		this.projectPersonEducation = projectPersonEducation;
	}

	@Column(name = "PROJECT_PERSON_TITLE", length = 50)
	public String getProjectPersonTitle() {
		return this.projectPersonTitle;
	}

	public void setProjectPersonTitle(String projectPersonTitle) {
		this.projectPersonTitle = projectPersonTitle;
	}

	@Column(name = "LINK_PERSON_NAME", length = 50)
	public String getLinkPersonName() {
		return this.linkPersonName;
	}

	public void setLinkPersonName(String linkPersonName) {
		this.linkPersonName = linkPersonName;
	}

	@Column(name = "LINK_PERSON_TEL", length = 20)
	public String getLinkPersonTel() {
		return this.linkPersonTel;
	}

	public void setLinkPersonTel(String linkPersonTel) {
		this.linkPersonTel = linkPersonTel;
	}

	@Column(name = "LINK_PERSON_MOBILE", length = 20)
	public String getLinkPersonMobile() {
		return this.linkPersonMobile;
	}

	public void setLinkPersonMobile(String linkPersonMobile) {
		this.linkPersonMobile = linkPersonMobile;
	}

	@Column(name = "PROJECT_SCHEDULE", length = 50)
	public String getProjectSchedule() {
		return this.projectSchedule;
	}

	public void setProjectSchedule(String projectSchedule) {
		this.projectSchedule = projectSchedule;
	}

	@Column(name = "PROJECT_REASON", length = 150)
	public String getProjectReason() {
		return this.projectReason;
	}

	public void setProjectReason(String projectReason) {
		this.projectReason = projectReason;
	}

	@Column(name = "COMPANY_ASSETS", precision = 11, scale = 4)
	public double getCompanyAssets() {
		return this.companyAssets;
	}

	public void setCompanyAssets(double companyAssets) {
		this.companyAssets = companyAssets;
	}

	@Column(name = "COMPANY_OUTPUT_THREE", precision = 11, scale = 4)
	public double getCompanyOutputThree() {
		return this.companyOutputThree;
	}

	public void setCompanyOutputThree(double companyOutputThree) {
		this.companyOutputThree = companyOutputThree;
	}

	@Column(name = "COMPANY_OUTPUT_TWO", precision = 11, scale = 4)
	public double getCompanyOutputTwo() {
		return this.companyOutputTwo;
	}

	public void setCompanyOutputTwo(double companyOutputTwo) {
		this.companyOutputTwo = companyOutputTwo;
	}

	@Column(name = "COMPANY_OUTPUT_ONE", precision = 11, scale = 4)
	public double getCompanyOutputOne() {
		return this.companyOutputOne;
	}

	public void setCompanyOutputOne(double companyOutputOne) {
		this.companyOutputOne = companyOutputOne;
	}

	@Column(name = "PROJECT_OUTPUT_THREE", precision = 11, scale = 4)
	public double getProjectOutputThree() {
		return this.projectOutputThree;
	}

	public void setProjectOutputThree(double projectOutputThree) {
		this.projectOutputThree = projectOutputThree;
	}

	@Column(name = "PROJECT_OUTPUT_TWO", precision = 11, scale = 4)
	public double getProjectOutputTwo() {
		return this.projectOutputTwo;
	}

	public void setProjectOutputTwo(double projectOutputTwo) {
		this.projectOutputTwo = projectOutputTwo;
	}

	@Column(name = "PROJECT_OUTPUT_ONE", precision = 11, scale = 4)
	public double getProjectOutputOne() {
		return this.projectOutputOne;
	}

	public void setProjectOutputOne(double projectOutputOne) {
		this.projectOutputOne = projectOutputOne;
	}

	@Column(name = "COMPANY_SELL_THREE", precision = 11, scale = 4)
	public double getCompanySellThree() {
		return this.companySellThree;
	}

	public void setCompanySellThree(double companySellThree) {
		this.companySellThree = companySellThree;
	}

	@Column(name = "COMPANY_SELL_TWO", precision = 11, scale = 4)
	public double getCompanySellTwo() {
		return this.companySellTwo;
	}

	public void setCompanySellTwo(double companySellTwo) {
		this.companySellTwo = companySellTwo;
	}

	@Column(name = "COMPANY_SELL_ONE", precision = 11, scale = 4)
	public double getCompanySellOne() {
		return this.companySellOne;
	}

	public void setCompanySellOne(double companySellOne) {
		this.companySellOne = companySellOne;
	}

	@Column(name = "PROJECT_SELL_THREE", precision = 11, scale = 4)
	public double getProjectSellThree() {
		return this.projectSellThree;
	}

	public void setProjectSellThree(double projectSellThree) {
		this.projectSellThree = projectSellThree;
	}

	@Column(name = "PROJECT_SELL_TWO", precision = 11, scale = 4)
	public double getProjectSellTwo() {
		return this.projectSellTwo;
	}

	public void setProjectSellTwo(double projectSellTwo) {
		this.projectSellTwo = projectSellTwo;
	}

	@Column(name = "PROJECT_SELL_ONE", precision = 11, scale = 4)
	public double getProjectSellOne() {
		return this.projectSellOne;
	}

	public void setProjectSellOne(double projectSellOne) {
		this.projectSellOne = projectSellOne;
	}

	@Column(name = "COMPANY_PROFIT_THREE", precision = 11, scale = 4)
	public double getCompanyProfitThree() {
		return this.companyProfitThree;
	}

	public void setCompanyProfitThree(double companyProfitThree) {
		this.companyProfitThree = companyProfitThree;
	}

	@Column(name = "COMPANY_PROFIT_TWO", precision = 11, scale = 4)
	public double getCompanyProfitTwo() {
		return this.companyProfitTwo;
	}

	public void setCompanyProfitTwo(double companyProfitTwo) {
		this.companyProfitTwo = companyProfitTwo;
	}

	@Column(name = "COMPANY_PROFIT_ONE", precision = 11, scale = 4)
	public double getCompanyProfitOne() {
		return this.companyProfitOne;
	}

	public void setCompanyProfitOne(double companyProfitOne) {
		this.companyProfitOne = companyProfitOne;
	}

	@Column(name = "PROJECT_PROFIT_THREE", precision = 11, scale = 4)
	public double getProjectProfitThree() {
		return this.projectProfitThree;
	}

	public void setProjectProfitThree(double projectProfitThree) {
		this.projectProfitThree = projectProfitThree;
	}

	@Column(name = "PROJECT_PROFIT_TWO", precision = 11, scale = 4)
	public double getProjectProfitTwo() {
		return this.projectProfitTwo;
	}

	public void setProjectProfitTwo(double projectProfitTwo) {
		this.projectProfitTwo = projectProfitTwo;
	}

	@Column(name = "PROJECT_PROFIT_ONE", precision = 11, scale = 4)
	public double getProjectProfitOne() {
		return this.projectProfitOne;
	}

	public void setProjectProfitOne(double projectProfitOne) {
		this.projectProfitOne = projectProfitOne;
	}

	@Column(name = "COMPANY_TAX_THREE", precision = 11, scale = 4)
	public double getCompanyTaxThree() {
		return this.companyTaxThree;
	}

	public void setCompanyTaxThree(double companyTaxThree) {
		this.companyTaxThree = companyTaxThree;
	}

	@Column(name = "COMPANY_TAX_TWO", precision = 11, scale = 4)
	public double getCompanyTaxTwo() {
		return this.companyTaxTwo;
	}

	public void setCompanyTaxTwo(double companyTaxTwo) {
		this.companyTaxTwo = companyTaxTwo;
	}

	@Column(name = "COMPANY_TAX_ONE", precision = 11, scale = 4)
	public double getCompanyTaxOne() {
		return this.companyTaxOne;
	}

	public void setCompanyTaxOne(double companyTaxOne) {
		this.companyTaxOne = companyTaxOne;
	}

	@Column(name = "PROJECT_TAX_TWO", precision = 11, scale = 4)
	public double getProjectTaxTwo() {
		return this.projectTaxTwo;
	}

	public void setProjectTaxTwo(double projectTaxTwo) {
		this.projectTaxTwo = projectTaxTwo;
	}

	@Column(name = "PROJECT_TAX_ONE", precision = 11, scale = 4)
	public double getProjectTaxOne() {
		return this.projectTaxOne;
	}

	public void setProjectTaxOne(double projectTaxOne) {
		this.projectTaxOne = projectTaxOne;
	}

	@Column(name = "PROJECT_TAX_THREE", precision = 11, scale = 4)
	public double getProjectTaxThree() {
		return this.projectTaxThree;
	}

	public void setProjectTaxThree(double projectTaxThree) {
		this.projectTaxThree = projectTaxThree;
	}

	@Column(name = "COMPANY_EXPORT_THREE", precision = 11, scale = 4)
	public double getCompanyExportThree() {
		return this.companyExportThree;
	}

	public void setCompanyExportThree(double companyExportThree) {
		this.companyExportThree = companyExportThree;
	}

	@Column(name = "COMPANY_EXPORT_TWO", precision = 11, scale = 4)
	public double getCompanyExportTwo() {
		return this.companyExportTwo;
	}

	public void setCompanyExportTwo(double companyExportTwo) {
		this.companyExportTwo = companyExportTwo;
	}

	@Column(name = "COMPANY_EXPORT_ONE", precision = 11, scale = 4)
	public double getCompanyExportOne() {
		return this.companyExportOne;
	}

	public void setCompanyExportOne(double companyExportOne) {
		this.companyExportOne = companyExportOne;
	}

	@Column(name = "PROJECT_EXPORT_THREE", precision = 11, scale = 4)
	public double getProjectExportThree() {
		return this.projectExportThree;
	}

	public void setProjectExportThree(double projectExportThree) {
		this.projectExportThree = projectExportThree;
	}

	@Column(name = "PROJECT_EXPORT_TWO", precision = 11, scale = 4)
	public double getProjectExportTwo() {
		return this.projectExportTwo;
	}

	public void setProjectExportTwo(double projectExportTwo) {
		this.projectExportTwo = projectExportTwo;
	}

	@Column(name = "PROJECT_EXPORT_ONE", precision = 11, scale = 4)
	public double getProjectExportOne() {
		return this.projectExportOne;
	}

	public void setProjectExportOne(double projectExportOne) {
		this.projectExportOne = projectExportOne;
	}

	@Column(name = "HARDWARE_AREA", precision = 11, scale = 4)
	public double getHardwareArea() {
		return this.hardwareArea;
	}

	public void setHardwareArea(double hardwareArea) {
		this.hardwareArea = hardwareArea;
	}

	@Column(name = "EQUIPMENT_TOTAL", precision = 11, scale = 4)
	public double getEquipmentTotal() {
		return this.equipmentTotal;
	}

	public void setEquipmentTotal(double equipmentTotal) {
		this.equipmentTotal = equipmentTotal;
	}

	@Column(name = "HARDWARE_TOTAL", precision = 11, scale = 0)
	public long getHardwareTotal() {
		return this.hardwareTotal;
	}

	public void setHardwareTotal(long hardwareTotal) {
		this.hardwareTotal = hardwareTotal;
	}

	@Column(name = "NEW_HARDWARE_TOTAL", precision = 11, scale = 0)
	public long getNewHardwareTotal() {
		return this.newHardwareTotal;
	}

	public void setNewHardwareTotal(long newHardwareTotal) {
		this.newHardwareTotal = newHardwareTotal;
	}

	@Column(name = "STAFF_TOTAL", precision = 11, scale = 0)
	public long getStaffTotal() {
		return this.staffTotal;
	}

	public void setStaffTotal(long staffTotal) {
		this.staffTotal = staffTotal;
	}

	@Column(name = "UNDERGRADUATE_TOTAL", precision = 11, scale = 0)
	public long getUndergraduateTotal() {
		return this.undergraduateTotal;
	}

	public void setUndergraduateTotal(long undergraduateTotal) {
		this.undergraduateTotal = undergraduateTotal;
	}

	@Column(name = "TRAIN_TOTAL", precision = 11, scale = 0)
	public long getTrainTotal() {
		return this.trainTotal;
	}

	public void setTrainTotal(long trainTotal) {
		this.trainTotal = trainTotal;
	}

	@Column(name = "SERVICE_TOTAL", precision = 11, scale = 0)
	public long getServiceTotal() {
		return this.serviceTotal;
	}

	public void setServiceTotal(long serviceTotal) {
		this.serviceTotal = serviceTotal;
	}

	@Column(name = "WRITE_TIME")
	public Timestamp getWriteTime() {
		return this.writeTime;
	}

	public void setWriteTime(Timestamp writeTime) {
		this.writeTime = writeTime;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "REMARK", length = 1000)
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

	@Column(name = "PROJECT_REASON_COMMAND", length = 600)
	public String getProjectReasonCommand() {
		return projectReasonCommand;
	}

	public void setProjectReasonCommand(String projectReasonCommand) {
		this.projectReasonCommand = projectReasonCommand;
	}

	@Column(name = "OTHER_FIELD", length = 60)
	public String getOtherField() {
		return otherField;
	}

	public void setOtherField(String otherField) {
		this.otherField = otherField;
	}
}
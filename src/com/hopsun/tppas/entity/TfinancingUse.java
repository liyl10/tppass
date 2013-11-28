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
 * TfinancingUse entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_FINANCING_USE")
public class TfinancingUse implements java.io.Serializable {

	private static final long serialVersionUID = 2676598492962232643L;
	// Fields
	private String financingUseId;
	private TprojectApplication tprojectApplication;
	private String subject;
	private String applicationDescription;
	private double selfRaisedFunds;
	private double specialAmount;
	private String remark;
	private String deleteFlag;
	private double selfRaisedFundsList;
	private double specialAmountList;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateTime;
	private String updateUser;
	private String otherDescription;

	// 设备费
	private double equipmentSpecial;
	private double equipmentSupport;
	private double equipmentSelf;
	private double equipmentTotal;

	// 购置设备费
	private String purchaseComment;
	private double purchaseSpecial;
	private double purchaseSupport;
	private double purchaseSelf;
	private double purchaseTotal;
	
	// 试制设备费
	private String trialComment;
	private double trialSpecial;
	private double trialSupport;
	private double trialSelf;
	private double trialTotal;

	// 设备改造与租赁费
	private String renovationComment;
	private double renovationSpecial;
	private double renovationSupport;
	private double renovationSelf;
	private double renovationTotal;

	// 材料费
	private String materialComment;
	private double materialSpecial;
	private double materialSupport;
	private double materialSelf;
	private double materialTotal;

	// 测试化验加工费
	private String testComment;
	private double testSpecial;
	private double testSupport;
	private double testSelf;
	private double testTotal;

	// 会议费
	private String meetComment;
	private double meetSpecial;
	private double meetSupport;
	private double meetSelf;
	private double meetTotal;

	// 国际合作与交流费
	private String cooperationComment;
	private double cooperationSpecial;
	private double cooperationSupport;
	private double cooperationSelf;
	private double cooperationTotal;

	// 出版/文献/信息传播/知识产权事务费
	private String publishComment;
	private double publishSpecial;
	private double publishSupport;
	private double publishSelf;
	private double publishTotal;

	// 专家咨询费
	private String expertComment;
	private double expertSpecial;
	private double expertSupport;
	private double expertSelf;
	private double expertTotal;
	
	// 合计
	private double specialTotal;
	private double selfTotal;
	private double supportTotal;
	private double total;

	// Constructors

	/** default constructor */
	public TfinancingUse() {
	}

	/** full constructor */
	public TfinancingUse(TprojectApplication tprojectApplication,
			String subject, String applicationDescription,
			double selfRaisedFunds, double specialAmount, String remark,
			String deleteFlag, double selfRaisedFundsList,
			double specialAmountList, Timestamp createTime, String createUser,
			Timestamp updateTime, String updateUser, String otherDescription,
			double equipmentSpecial, double equipmentSupport, double equipmentSelf,
			double equipmentTotal,
			String purchaseComment, double purchaseSpecial, double purchaseSupport, double purchaseSelf,
			double purchaseTotal,
			String trialComment, double trialSpecial, double trialSupport, double trialSelf, double trialTotal,
			String renovationComment, double renovationSpecial, double renovationSupport, double renovationSelf,
			double renovationTotal,
			String materialComment, double materialSpecial, double materialSupport, double materialSelf,
			double materialTotal,
			String testComment, double testSpecial, double testSupport, double testSelf, double testTotal,
			String meetComment, double meetSpecial, double meetSupport, double meetSelf, double meetTotal,
			String cooperationComment, double cooperationSpecial, double cooperationSupport, double cooperationSelf,
			double cooperationTotal,
			String publishComment, double publishSpecial, double publishSupport, double publishSelf,
			double publishTotal,
			String expertComment, double expertSpecial, double expertSupport, double expertSelf, double expertTotal,
			double specialTotal,double selfTotal,double supportTotal,double total) {
		this.tprojectApplication = tprojectApplication;
		this.subject = subject;
		this.applicationDescription = applicationDescription;
		this.selfRaisedFunds = selfRaisedFunds;
		this.specialAmount = specialAmount;
		this.remark = remark;
		this.deleteFlag = deleteFlag;
		this.selfRaisedFundsList = selfRaisedFundsList;
		this.specialAmountList = specialAmountList;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.otherDescription = otherDescription;

		this.equipmentSpecial = equipmentSpecial;
		this.equipmentSupport = equipmentSupport;
		this.equipmentSelf = equipmentSelf;
		this.equipmentTotal = equipmentTotal;

		this.purchaseComment = purchaseComment;
		this.purchaseSpecial = purchaseSpecial;
		this.purchaseSupport = purchaseSupport;
		this.purchaseSelf = purchaseSelf;
		this.purchaseTotal = purchaseTotal;

		this.trialComment = trialComment;
		this.trialSpecial = trialSpecial;
		this.trialSupport = trialSupport;
		this.trialSelf = trialSelf;
		this.trialTotal = trialTotal;

		this.renovationComment = renovationComment;
		this.renovationSpecial = renovationSpecial;
		this.renovationSupport = renovationSupport;
		this.renovationSelf = renovationSelf;
		this.renovationTotal = renovationTotal;

		this.materialComment = materialComment;
		this.materialSpecial = materialSpecial;
		this.materialSupport = materialSupport;
		this.materialSelf = materialSelf;
		this.materialTotal = materialTotal;

		this.testComment = testComment;
		this.testSpecial = testSpecial;
		this.testSupport = testSupport;
		this.testSelf = testSelf;
		this.testTotal = testTotal;

		this.meetComment = meetComment;
		this.meetSpecial = meetSpecial;
		this.meetSupport = meetSupport;
		this.meetSelf = meetSelf;
		this.meetTotal = meetTotal;

		this.cooperationComment = cooperationComment;
		this.cooperationSpecial = cooperationSpecial;
		this.cooperationSupport = cooperationSupport;
		this.cooperationSelf = cooperationSelf;
		this.cooperationTotal = cooperationTotal;

		this.publishComment = publishComment;
		this.publishSpecial = publishSpecial;
		this.publishSupport = publishSupport;
		this.publishSelf = publishSelf;
		this.publishTotal = publishTotal;

		this.expertComment = expertComment;
		this.expertSpecial = expertSpecial;
		this.expertSupport = expertSupport;
		this.expertSelf = expertSelf;
		this.expertTotal = expertTotal;

		this.specialTotal = specialTotal;
		this.selfTotal = selfTotal;
		this.supportTotal = supportTotal;
		this.total = total;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "FINANCING_USE_ID", unique = true, nullable = false, length = 40)
	public String getFinancingUseId() {
		return this.financingUseId;
	}

	public void setFinancingUseId(String financingUseId) {
		this.financingUseId = financingUseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public TprojectApplication getTprojectApplication() {
		return this.tprojectApplication;
	}

	public void setTprojectApplication(TprojectApplication tprojectApplication) {
		this.tprojectApplication = tprojectApplication;
	}

	@Column(name = "SUBJECT", length = 400)
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "APPLICATION_DESCRIPTION", length = 400)
	public String getApplicationDescription() {
		return this.applicationDescription;
	}

	public void setApplicationDescription(String applicationDescription) {
		this.applicationDescription = applicationDescription;
	}

	@Column(name = "SELF_RAISED_FUNDS", precision = 11, scale = 4)
	public double getSelfRaisedFunds() {
		return this.selfRaisedFunds;
	}

	public void setSelfRaisedFunds(double selfRaisedFunds) {
		this.selfRaisedFunds = selfRaisedFunds;
	}

	@Column(name = "SPECIAL_AMOUNT", precision = 11, scale = 4)
	public double getSpecialAmount() {
		return this.specialAmount;
	}

	public void setSpecialAmount(double specialAmount) {
		this.specialAmount = specialAmount;
	}

	@Column(name = "REMARK", length = 4000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "SELF_RAISED_FUNDS_LIST", precision = 12, scale = 4)
	public double getSelfRaisedFundsList() {
		return this.selfRaisedFundsList;
	}

	public void setSelfRaisedFundsList(double selfRaisedFundsList) {
		this.selfRaisedFundsList = selfRaisedFundsList;
	}

	@Column(name = "SPECIAL_AMOUNT_LIST", precision = 12, scale = 4)
	public double getSpecialAmountList() {
		return this.specialAmountList;
	}

	public void setSpecialAmountList(double specialAmountList) {
		this.specialAmountList = specialAmountList;
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
	
	
	@Column(name = "OTHER_DESCRIPTION",  length = 400)
	public String getOtherDescription() {
		return otherDescription;
	}

	public void setOtherDescription(String otherDescription) {
		this.otherDescription = otherDescription;
	}
	
	@Column(name = "EQUIPMENT_SPECIAL", precision = 12, scale = 4)
	public double getEquipmentSpecial() {
		return equipmentSpecial;
	}

	public void setEquipmentSpecial(double equipmentSpecial) {
		this.equipmentSpecial = equipmentSpecial;
	}

	@Column(name = "EQUIPMENT_SUPPORT", precision = 12, scale = 4)
	public double getEquipmentSupport() {
		return equipmentSupport;
	}

	public void setEquipmentSupport(double equipmentSupport) {
		this.equipmentSupport = equipmentSupport;
	}

	@Column(name = "EQUIPMENT_SELF", precision = 12, scale = 4)
	public double getEquipmentSelf() {
		return equipmentSelf;
	}

	public void setEquipmentSelf(double equipmentSelf) {
		this.equipmentSelf = equipmentSelf;
	}

	@Column(name = "EQUIPMENT_TOTAL", precision = 12, scale = 4)
	public double getEquipmentTotal() {
		return equipmentTotal;
	}

	public void setEquipmentTotal(double equipmentTotal) {
		this.equipmentTotal = equipmentTotal;
	}

	@Column(name = "PURCHASE_COMMENT", length = 400)
	public String getPurchaseComment() {
		return purchaseComment;
	}

	public void setPurchaseComment(String purchaseComment) {
		this.purchaseComment = purchaseComment;
	}

	@Column(name = "PURCHASE_SPECIAL", precision = 11, scale = 4)
	public double getPurchaseSpecial() {
		return purchaseSpecial;
	}

	public void setPurchaseSpecial(double purchaseSpecial) {
		this.purchaseSpecial = purchaseSpecial;
	}

	@Column(name = "PURCHASE_SUPPORT", precision = 11, scale = 4)
	public double getPurchaseSupport() {
		return purchaseSupport;
	}

	public void setPurchaseSupport(double purchaseSupport) {
		this.purchaseSupport = purchaseSupport;
	}

	@Column(name = "PURCHASE_SELF", precision = 11, scale = 4)
	public double getPurchaseSelf() {
		return purchaseSelf;
	}

	public void setPurchaseSelf(double purchaseSelf) {
		this.purchaseSelf = purchaseSelf;
	}

	@Column(name = "PURCHASE_TOTAL", precision = 12, scale = 4)
	public double getPurchaseTotal() {
		return purchaseTotal;
	}

	public void setPurchaseTotal(double purchaseTotal) {
		this.purchaseTotal = purchaseTotal;
	}

	@Column(name = "TRIAL_COMMENT", length = 400)
	public String getTrialComment() {
		return trialComment;
	}

	public void setTrialComment(String trialComment) {
		this.trialComment = trialComment;
	}

	@Column(name = "TRIAL_SPECIAL", precision = 11, scale = 4)
	public double getTrialSpecial() {
		return trialSpecial;
	}

	public void setTrialSpecial(double trialSpecial) {
		this.trialSpecial = trialSpecial;
	}

	@Column(name = "TRIAL_SUPPORT", precision = 11, scale = 4)
	public double getTrialSupport() {
		return trialSupport;
	}

	public void setTrialSupport(double trialSupport) {
		this.trialSupport = trialSupport;
	}

	@Column(name = "TRIAL_SELF", precision = 11, scale = 4)
	public double getTrialSelf() {
		return trialSelf;
	}

	public void setTrialSelf(double trialSelf) {
		this.trialSelf = trialSelf;
	}

	@Column(name = "TRIAL_TOTAL", precision = 12, scale = 4)
	public double getTrialTotal() {
		return trialTotal;
	}

	public void setTrialTotal(double trialTotal) {
		this.trialTotal = trialTotal;
	}

	@Column(name = "RENOVATION_COMMENT", length = 400)
	public String getRenovationComment() {
		return renovationComment;
	}

	public void setRenovationComment(String renovationComment) {
		this.renovationComment = renovationComment;
	}

	@Column(name = "RENOVATION_SPECIAL", precision = 11, scale = 4)
	public double getRenovationSpecial() {
		return renovationSpecial;
	}

	public void setRenovationSpecial(double renovationSpecial) {
		this.renovationSpecial = renovationSpecial;
	}

	@Column(name = "RENOVATION_SUPPORT", precision = 11, scale = 4)
	public double getRenovationSupport() {
		return renovationSupport;
	}

	public void setRenovationSupport(double renovationSupport) {
		this.renovationSupport = renovationSupport;
	}

	@Column(name = "RENOVATION_SELF", precision = 11, scale = 4)
	public double getRenovationSelf() {
		return renovationSelf;
	}

	public void setRenovationSelf(double renovationSelf) {
		this.renovationSelf = renovationSelf;
	}

	@Column(name = "RENOVATION_TOTAL", precision = 12, scale = 4)
	public double getRenovationTotal() {
		return renovationTotal;
	}

	public void setRenovationTotal(double renovationTotal) {
		this.renovationTotal = renovationTotal;
	}

	@Column(name = "MATERIAL_COMMENT", length = 400)
	public String getMaterialComment() {
		return materialComment;
	}

	public void setMaterialComment(String materialComment) {
		this.materialComment = materialComment;
	}

	@Column(name = "MATERIAL_SPECIAL", precision = 11, scale = 4)
	public double getMaterialSpecial() {
		return materialSpecial;
	}

	public void setMaterialSpecial(double materialSpecial) {
		this.materialSpecial = materialSpecial;
	}

	@Column(name = "MATERIAL_SUPPORT", precision = 11, scale = 4)
	public double getMaterialSupport() {
		return materialSupport;
	}

	public void setMaterialSupport(double materialSupport) {
		this.materialSupport = materialSupport;
	}

	@Column(name = "MATERIAL_SELF", precision = 11, scale = 4)
	public double getMaterialSelf() {
		return materialSelf;
	}

	public void setMaterialSelf(double materialSelf) {
		this.materialSelf = materialSelf;
	}

	@Column(name = "MATERIAL_TOTAL", precision = 12, scale = 4)
	public double getMaterialTotal() {
		return materialTotal;
	}

	public void setMaterialTotal(double materialTotal) {
		this.materialTotal = materialTotal;
	}

	@Column(name = "TEST_COMMENT", length = 400)
	public String getTestComment() {
		return testComment;
	}

	public void setTestComment(String testComment) {
		this.testComment = testComment;
	}

	@Column(name = "TEST_SPECIAL", precision = 11, scale = 4)
	public double getTestSpecial() {
		return testSpecial;
	}

	public void setTestSpecial(double testSpecial) {
		this.testSpecial = testSpecial;
	}

	@Column(name = "TEST_SUPPORT", precision = 11, scale = 4)
	public double getTestSupport() {
		return testSupport;
	}

	public void setTestSupport(double testSupport) {
		this.testSupport = testSupport;
	}

	@Column(name = "TEST_SELF", precision = 11, scale = 4)
	public double getTestSelf() {
		return testSelf;
	}

	public void setTestSelf(double testSelf) {
		this.testSelf = testSelf;
	}

	@Column(name = "TEST_TOTAL", precision = 12, scale = 4)
	public double getTestTotal() {
		return testTotal;
	}

	public void setTestTotal(double testTotal) {
		this.testTotal = testTotal;
	}

	@Column(name = "MEET_COMMENT", length = 400)
	public String getMeetComment() {
		return meetComment;
	}

	public void setMeetComment(String meetComment) {
		this.meetComment = meetComment;
	}

	@Column(name = "MEET_SPECIAL", precision = 11, scale = 4)
	public double getMeetSpecial() {
		return meetSpecial;
	}

	public void setMeetSpecial(double meetSpecial) {
		this.meetSpecial = meetSpecial;
	}

	@Column(name = "MEET_SUPPORT", precision = 11, scale = 4)
	public double getMeetSupport() {
		return meetSupport;
	}

	public void setMeetSupport(double meetSupport) {
		this.meetSupport = meetSupport;
	}

	@Column(name = "MEET_SELF", precision = 11, scale = 4)
	public double getMeetSelf() {
		return meetSelf;
	}

	public void setMeetSelf(double meetSelf) {
		this.meetSelf = meetSelf;
	}

	@Column(name = "MEET_TOTAL", precision = 12, scale = 4)
	public double getMeetTotal() {
		return meetTotal;
	}

	public void setMeetTotal(double meetTotal) {
		this.meetTotal = meetTotal;
	}

	@Column(name = "COOPERATION_COMMENT", length = 400)
	public String getCooperationComment() {
		return cooperationComment;
	}

	public void setCooperationComment(String cooperationComment) {
		this.cooperationComment = cooperationComment;
	}

	@Column(name = "COOPERATION_SPECIAL", precision = 11, scale = 4)
	public double getCooperationSpecial() {
		return cooperationSpecial;
	}

	public void setCooperationSpecial(double cooperationSpecial) {
		this.cooperationSpecial = cooperationSpecial;
	}

	@Column(name = "COOPERATION_SUPPORT", precision = 11, scale = 4)
	public double getCooperationSupport() {
		return cooperationSupport;
	}

	public void setCooperationSupport(double cooperationSupport) {
		this.cooperationSupport = cooperationSupport;
	}

	@Column(name = "COOPERATION_SELF", precision = 11, scale = 4)
	public double getCooperationSelf() {
		return cooperationSelf;
	}

	public void setCooperationSelf(double cooperationSelf) {
		this.cooperationSelf = cooperationSelf;
	}

	@Column(name = "COOPERATION_TOTAL", precision = 12, scale = 4)
	public double getCooperationTotal() {
		return cooperationTotal;
	}

	public void setCooperationTotal(double cooperationTotal) {
		this.cooperationTotal = cooperationTotal;
	}

	@Column(name = "PUBLISH_COMMENT", length = 400)
	public String getPublishComment() {
		return publishComment;
	}

	public void setPublishComment(String publishComment) {
		this.publishComment = publishComment;
	}

	@Column(name = "PUBLISH_SPECIAL", precision = 11, scale = 4)
	public double getPublishSpecial() {
		return publishSpecial;
	}

	public void setPublishSpecial(double publishSpecial) {
		this.publishSpecial = publishSpecial;
	}

	@Column(name = "PUBLISH_SUPPORT", precision = 11, scale = 4)
	public double getPublishSupport() {
		return publishSupport;
	}

	public void setPublishSupport(double publishSupport) {
		this.publishSupport = publishSupport;
	}

	@Column(name = "PUBLISH_SELF", precision = 11, scale = 4)
	public double getPublishSelf() {
		return publishSelf;
	}

	public void setPublishSelf(double publishSelf) {
		this.publishSelf = publishSelf;
	}

	@Column(name = "PUBLISH_TOTAL", precision = 12, scale = 4)
	public double getPublishTotal() {
		return publishTotal;
	}

	public void setPublishTotal(double publishTotal) {
		this.publishTotal = publishTotal;
	}

	@Column(name = "EXPERT_COMMENT", length = 400)
	public String getExpertComment() {
		return expertComment;
	}

	public void setExpertComment(String expertComment) {
		this.expertComment = expertComment;
	}

	@Column(name = "EXPERT_SPECIAL", precision = 11, scale = 4)
	public double getExpertSpecial() {
		return expertSpecial;
	}

	public void setExpertSpecial(double expertSpecial) {
		this.expertSpecial = expertSpecial;
	}

	@Column(name = "EXPERT_SUPPORT", precision = 11, scale = 4)
	public double getExpertSupport() {
		return expertSupport;
	}

	public void setExpertSupport(double expertSupport) {
		this.expertSupport = expertSupport;
	}

	@Column(name = "EXPERT_SELF", precision = 11, scale = 4)
	public double getExpertSelf() {
		return expertSelf;
	}

	public void setExpertSelf(double expertSelf) {
		this.expertSelf = expertSelf;
	}

	@Column(name = "EXPERT_TOTAL", precision = 12, scale = 4)
	public double getExpertTotal() {
		return expertTotal;
	}

	public void setExpertTotal(double expertTotal) {
		this.expertTotal = expertTotal;
	}
	
	@Column(name = "SPECIAL_TOTAL", precision = 12, scale = 4)
	public double getSpecialTotal() {
		return specialTotal;
	}

	public void setSpecialTotal(double specialTotal) {
		this.specialTotal = specialTotal;
	}

	@Column(name = "SELF_TOTAL", precision = 12, scale = 4)
	public double getSelfTotal() {
		return selfTotal;
	}

	public void setSelfTotal(double selfTotal) {
		this.selfTotal = selfTotal;
	}

	@Column(name = "SUPPORT_TOTAL", precision = 12, scale = 4)
	public double getSupportTotal() {
		return supportTotal;
	}

	public void setSupportTotal(double supportTotal) {
		this.supportTotal = supportTotal;
	}

	@Column(name = "TOTAL", precision = 14, scale = 4)
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public Object clone() {
		try {
			super.clone();
			return super.clone();
		} catch (Exception e) {
			return null;
		}
	}
}
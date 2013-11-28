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
 * TacceptanceAccA entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_APPROPRIATION_SINGLE")
public class TappropriationSingle implements java.io.Serializable {

 private static final long serialVersionUID = -5644916623135344649L;
 // Fields
 private String appropriationSingleId;
 private Tcontract tcontract;
 private String tasksEntrusted;
 private String undertaker;
 private String bank;
 private String account;
 private double amountFunding;
 private double planFunding;
 private Timestamp appropriationTime;
 /** 临时字段 项目编号*/
 private String projectNumber;
 /** 临时字段 计划类别*/
 private String typeId1;
 private String remark;
 private String createUser;
 private Timestamp createTime;
 private String updateUser;
 private Timestamp updateTime;
 private String deleteFlag;
 /** 临时字段 */
 private String flag; 
 
 /** 临时字段 合计页面 标记 */
 private String sumFlag;
 

 // Constructors

 /** default constructor */
 public TappropriationSingle() {
 }

 /** full constructor */
 public TappropriationSingle(Tcontract tcontract, String tasksEntrusted, String undertaker,
   String bank, String account, double amountFunding,
   double planFunding, Timestamp appropriationTime, String projectNumber, String typeId1,
   String remark,String createUser, Timestamp createTime, String updateUser,
   Timestamp updateTime, String deleteFlag,String flag,String sumFlag) {
  this.tcontract = tcontract;
  this.tasksEntrusted = tasksEntrusted;
  this.undertaker = undertaker;
  this.bank = bank;
  this.account = account;
  this.amountFunding = amountFunding;
  this.planFunding = planFunding;
  this.appropriationTime = appropriationTime;
  this.projectNumber = projectNumber;
  this.typeId1 =  typeId1;
  this.remark = remark;
  this.createUser = createUser;
  this.createTime = createTime;
  this.updateUser = updateUser;
  this.updateTime = updateTime;
  this.deleteFlag = deleteFlag;
  this.flag = flag;
  this.sumFlag = sumFlag;
 }

 // Property accessors
 @GenericGenerator(name = "generator", strategy = "uuid")
 @Id
 @GeneratedValue(generator = "generator")
 @Column(name = "APPROPRIATION_SINGLE_ID", unique = true, nullable = false, length = 40)
 public String getAppropriationSingleId() {
  return this.appropriationSingleId;
 }

 public void setAppropriationSingleId(String appropriationSingleId) {
  this.appropriationSingleId = appropriationSingleId;
 }

 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "T_CONTRACT_ID")
 public Tcontract getTcontract() {
  return this.tcontract;
 }

 public void setTcontract(Tcontract tcontract) {
  this.tcontract = tcontract;
 }

 @Column(name = "TASKS_ENTRUSTED", length = 500)
 public String getTasksEntrusted() {
  return this.tasksEntrusted;
 }

 public void setTasksEntrusted(String tasksEntrusted) {
  this.tasksEntrusted = tasksEntrusted;
 }

 @Column(name = "UNDERTAKER", length = 500)
 public String getUndertaker() {
  return this.undertaker;
 }

 public void setUndertaker(String undertaker) {
  this.undertaker = undertaker;
 }

 @Column(name = "BANK", length = 500)
 public String getBank() {
  return this.bank;
 }

 public void setBank(String bank) {
  this.bank = bank;
 }

 @Column(name = "ACCOUNT", length = 500)
 public String getAccount() {
  return this.account;
 }

 public void setAccount(String account) {
  this.account = account;
 }

 @Column(name = "AMOUNT_FUNDING", precision = 11, scale = 4)
 public double getAmountFunding() {
  return this.amountFunding;
 }

 public void setAmountFunding(double amountFunding) {
  this.amountFunding = amountFunding;
 }

 @Column(name = "PLAN_FUNDING", precision = 11, scale = 4)
 public double getPlanFunding() {
  return this.planFunding;
 }

 public void setPlanFunding(double planFunding) {
  this.planFunding = planFunding;
 }

 @Column(name = "APPROPRIATION_TIME")
 public Timestamp getAppropriationTime() {
  return this.appropriationTime;
 }

 public void setAppropriationTime(Timestamp appropriationTime) {
  this.appropriationTime = appropriationTime;
 }

 @Transient
 public String getProjectNumber() {
	return projectNumber;
}

public void setProjectNumber(String projectNumber) {
	this.projectNumber = projectNumber;
}

@Transient
public String getTypeId1() {
	return typeId1;
}

public void setTypeId1(String typeId1) {
	this.typeId1 = typeId1;
}

@Column(name = "REMARK", length = 3000)
 public String getRemark() {
  return this.remark;
 }

 public void setRemark(String remark) {
  this.remark = remark;
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

 @Transient
public String getFlag() {
	return flag;
}

public void setFlag(String flag) {
	this.flag = flag;
}

@Transient
public String getSumFlag() {
	return sumFlag;
}

public void setSumFlag(String sumFlag) {
	this.sumFlag = sumFlag;
}


}
/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.scenter.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 *@comments 部门实体类
 *@author dulei(dulei@hopsun.cn)
 *@date Jan 5, 2013 8:13:29 AM
 *@version 1.0
 */
@Entity
@Table(name = "SC_DEPT",   uniqueConstraints = {})
public class ScDept implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -5686042166951882578L;
	//部门id
	private String deptId;
	//上级部门
	private ScDept scDept;
	//部门名称
	private String deptName;
	//部门code
	private String deptCode;
	//部门描述
	private String deptDesc;
	//部门领导
	private String deptLeader;
	//部门联系人
	private String deptLinkman;
	//部门地址
	private String deptAddress;
	//部门邮编
	private String deptPostcode;
	//部门电话
	private String deptPhone;
	//部门传真
	private String deptFax;
	//部门邮箱
	private String deptEmaill;
	//部门排序
	private Long deptOrder;
	//启用状态
	private String enableState;
	//审核状态
	private String verifyState;
	//审核备注
	private String verifyNote;
	//删除状态
	private String deleteState;
	//创建人
	private String createUserName;
	//创建时间
	private Date createDate;
	//修改人
	private String modifyUserName;
	//修改时间
	private Date modifyDate;
	//下级部门
	private Set<ScDept> scDepts = new HashSet<ScDept>(0);
	//部门下用户
	private Set<ScUsers> scUserses = new HashSet<ScUsers>(0);

	// Constructors

	/** default constructor */
	public ScDept() {
	}

	/** minimal constructor */
	public ScDept(String deptId, String verifyState, String createUserName, Date createDate) {
		this.deptId = deptId;
		this.verifyState = verifyState;
		this.createUserName = createUserName;
		this.createDate = createDate;
	}

	/** full constructor */
	public ScDept(String deptId, ScDept scDept, String deptName, String deptCode, String deptDesc, String deptLeader, String deptLinkman, String deptAddress, String deptPostcode, String deptPhone, String deptFax, String deptEmaill, Long deptOrder, String enableState, String verifyState,String verifyNote, String deleteState, String createUserName, Date createDate, String modifyUserName, Date modifyDate, Set<ScDept> scDepts, Set<ScUsers> scUserses) {
		this.deptId = deptId;
		this.scDept = scDept;
		this.deptName = deptName;
		this.deptCode = deptCode;
		this.deptDesc = deptDesc;
		this.deptLeader = deptLeader;
		this.deptLinkman = deptLinkman;
		this.deptAddress = deptAddress;
		this.deptPostcode = deptPostcode;
		this.deptPhone = deptPhone;
		this.deptFax = deptFax;
		this.deptEmaill = deptEmaill;
		this.deptOrder = deptOrder;
		this.enableState = enableState;
		this.verifyState = verifyState;
		this.verifyNote = verifyNote;
		this.deleteState = deleteState;
		this.createUserName = createUserName;
		this.createDate = createDate;
		this.modifyUserName = modifyUserName;
		this.modifyDate = modifyDate;
		this.scDepts = scDepts;
		this.scUserses = scUserses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "DEPT_ID", columnDefinition="NVARCHAR2(36)",  nullable = false, insertable = true, updatable = true)
	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPT_PARENT_ID", columnDefinition="NVARCHAR2(36)", unique = false, nullable = true, insertable = true, updatable = true)
	public ScDept getScDept() {
		return this.scDept;
	}

	public void setScDept(ScDept scDept) {
		this.scDept = scDept;
	}

	@Column(name = "DEPT_NAME", columnDefinition="NVARCHAR2(50)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "DEPT_CODE",columnDefinition="NVARCHAR2(50)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getDeptCode() {
		return this.deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	@Lob
	@Column(name = "DEPT_DESC",  nullable = true, insertable = true, updatable = true)
	public String getDeptDesc() {
		return this.deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	@Column(name = "DEPT_LEADER", columnDefinition="NVARCHAR2(50)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getDeptLeader() {
		return this.deptLeader;
	}

	public void setDeptLeader(String deptLeader) {
		this.deptLeader = deptLeader;
	}

	@Column(name = "DEPT_LINKMAN", columnDefinition="NVARCHAR2(50)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getDeptLinkman() {
		return this.deptLinkman;
	}

	public void setDeptLinkman(String deptLinkman) {
		this.deptLinkman = deptLinkman;
	}

	@Column(name = "DEPT_ADDRESS", columnDefinition="NVARCHAR2(150)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getDeptAddress() {
		return this.deptAddress;
	}

	public void setDeptAddress(String deptAddress) {
		this.deptAddress = deptAddress;
	}

	@Column(name = "DEPT_POSTCODE", columnDefinition="NVARCHAR2(6)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getDeptPostcode() {
		return this.deptPostcode;
	}

	public void setDeptPostcode(String deptPostcode) {
		this.deptPostcode = deptPostcode;
	}

	@Column(name = "DEPT_PHONE", columnDefinition="NVARCHAR2(50)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getDeptPhone() {
		return this.deptPhone;
	}

	public void setDeptPhone(String deptPhone) {
		this.deptPhone = deptPhone;
	}

	@Column(name = "DEPT_FAX", columnDefinition="NVARCHAR2(30)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getDeptFax() {
		return this.deptFax;
	}

	public void setDeptFax(String deptFax) {
		this.deptFax = deptFax;
	}

	@Column(name = "DEPT_EMAILL", columnDefinition="NVARCHAR2(100)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getDeptEmaill() {
		return this.deptEmaill;
	}

	public void setDeptEmaill(String deptEmaill) {
		this.deptEmaill = deptEmaill;
	}

	@Column(name = "DEPT_ORDER", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)
	public Long getDeptOrder() {
		return this.deptOrder;
	}

	public void setDeptOrder(Long deptOrder) {
		this.deptOrder = deptOrder;
	}

	@Column(name = "ENABLE_STATE", columnDefinition="NVARCHAR2(2)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getEnableState() {
		return this.enableState;
	}

	public void setEnableState(String enableState) {
		this.enableState = enableState;
	}

	@Column(name = "VERIFY_STATE",columnDefinition="NVARCHAR2(2)", unique = false, nullable = false, insertable = true, updatable = true)
	public String getVerifyState() {
		return this.verifyState;
	}

	public void setVerifyState(String verifyState) {
		this.verifyState = verifyState;
	}
	
	@Column(name = "VERIFY_NOTE", columnDefinition="NVARCHAR2(200)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getVerifyNote() {
		return this.verifyNote;
	}

	public void setVerifyNote(String verifyNote) {
		this.verifyNote = verifyNote;
	}

	@Column(name = "DELETE_STATE", columnDefinition="NVARCHAR2(2)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getDeleteState() {
		return this.deleteState;
	}

	public void setDeleteState(String deleteState) {
		this.deleteState = deleteState;
	}

	@Column(name = "CREATE_USER_NAME", columnDefinition="NVARCHAR2(40)", unique = false, nullable = false, insertable = true, updatable = true)
	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE", unique = false, nullable = false, insertable = true, updatable = true, length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "MODIFY_USER_NAME", columnDefinition="NVARCHAR2(40)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getModifyUserName() {
		return this.modifyUserName;
	}

	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFY_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "scDept")
	public Set<ScDept> getScDepts() {
		return this.scDepts;
	}

	public void setScDepts(Set<ScDept> scDepts) {
		this.scDepts = scDepts;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "scDept")
	public Set<ScUsers> getScUserses() {
		return this.scUserses;
	}

	public void setScUserses(Set<ScUsers> scUserses) {
		this.scUserses = scUserses;
	}

	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */
	public String toString()
	{
	    final String TAB = "    ";
	    
	    String retValue = "";
	    
	    retValue = "ScDept ( "
	        + super.toString() + TAB
	        + "deptId = " + this.deptId + TAB
	        //+ "scDept = " + this.scDept + TAB
	        + "deptName = " + this.deptName + TAB
	        + "deptCode = " + this.deptCode + TAB
	        + "deptDesc = " + this.deptDesc + TAB
	        + "deptLeader = " + this.deptLeader + TAB
	        + "deptLinkman = " + this.deptLinkman + TAB
	        + "deptAddress = " + this.deptAddress + TAB
	        + "deptPostcode = " + this.deptPostcode + TAB
	        + "deptPhone = " + this.deptPhone + TAB
	        + "deptFax = " + this.deptFax + TAB
	        + "deptEmaill = " + this.deptEmaill + TAB
	        + "deptOrder = " + this.deptOrder + TAB
	        + "enableState = " + this.enableState + TAB
	        + "verifyState = " + this.verifyState + TAB
	        + "verifyNote = " + this.verifyNote + TAB
	        + "deleteState = " + this.deleteState + TAB
	        + "createUserName = " + this.createUserName + TAB
	        + "createDate = " + this.createDate + TAB
	        + "modifyUserName = " + this.modifyUserName + TAB
	        + "modifyDate = " + this.modifyDate + TAB
	        //+ "scDepts = " + this.scDepts + TAB
	        //+ "scUserses = " + this.scUserses + TAB
	        + " )";
	
	    return retValue;
	}

}
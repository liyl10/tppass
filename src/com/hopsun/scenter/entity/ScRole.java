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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * ScRole entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SC_ROLE",  uniqueConstraints = {})
public class ScRole implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -6070149553425775897L;
	//角色编号
	private String roleId;
	//所属用户
	private ScUsers scUsers;
	//角色名称
	private String roleName;
	//角色描述
	private String roleDesc;
	//启用状态
	private String enableState;
	//审核状态
	private String verifyState;
	//审核备注
	private String verifyNote;
	//审核人
	private String verifyUserName;
	//审核时间
	private Date verifyDate;
	//删除状态
	private String deleteState;
	//角色排序
	private Long roleOrder;
	//添加人
	private String createUserName;
	//添加时间
	private Date createDate;
	//修改人
	private String modifyUserName;
	//修改时间
	private Date modifyDate;
	//角色用户
	private Set<ScUsers> scUserses = new HashSet<ScUsers>(0);
	//角色权限
	private Set<ScAuth> scAuths = new HashSet<ScAuth>(0);

	// Constructors

	/** default constructor */
	public ScRole() {
	}

	/** minimal constructor */
	public ScRole(String roleId, ScUsers scUsers, String roleName, String enableState, String verifyState,  String deleteState, String createUserName, Date createDate) {
		this.roleId = roleId;
		this.scUsers = scUsers;
		this.roleName = roleName;
		this.enableState = enableState;
		this.verifyState = verifyState;
	
		this.deleteState = deleteState;
		this.createUserName = createUserName;
		this.createDate = createDate;
		 
	}

	/** full constructor */
	public ScRole(String roleId, ScUsers scUsers, String roleName, String roleDesc, String enableState, String verifyState, String verifyNote, String verifyUserName, Date verifyDate, String deleteState, Long roleOrder, String createUserName, Date createDate, String modifyUserName, Date modifyDate,  Set<ScUsers> scUserses, Set<ScAuth> scAuths) {
		this.roleId = roleId;
		this.scUsers = scUsers;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.enableState = enableState;
		this.verifyState = verifyState;
		this.verifyNote = verifyNote;
		this.verifyUserName = verifyUserName;
		this.verifyDate = verifyDate;
		this.deleteState = deleteState;
		this.roleOrder = roleOrder;
		this.createUserName = createUserName;
		this.createDate = createDate;
		this.modifyUserName = modifyUserName;
		this.modifyDate = modifyDate;
	 
		this.scUserses = scUserses;
		this.scAuths = scAuths;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ROLE_ID", columnDefinition="NVARCHAR2(36)", nullable = false, insertable = true, updatable = true)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", columnDefinition="NVARCHAR2(36)", unique = false, nullable = false, insertable = true, updatable = true)
	public ScUsers getScUsers() {
		return this.scUsers;
	}

	public void setScUsers(ScUsers scUsers) {
		this.scUsers = scUsers;
	}

	@Column(name = "ROLE_NAME", columnDefinition="NVARCHAR2(50)", unique = false, nullable = false, insertable = true, updatable = true)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "ROLE_DESC", columnDefinition="NVARCHAR2(200)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Column(name = "ENABLE_STATE", columnDefinition="NVARCHAR2(2)", unique = false, nullable = false, insertable = true, updatable = true)
	public String getEnableState() {
		return this.enableState;
	}

	public void setEnableState(String enableState) {
		this.enableState = enableState;
	}

	@Column(name = "VERIFY_STATE", columnDefinition="NVARCHAR2(2)", unique = false, nullable = false, insertable = true, updatable = true)
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

	@Column(name = "VERIFY_USER_NAME", columnDefinition="NVARCHAR2(40)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getVerifyUserName() {
		return this.verifyUserName;
	}

	public void setVerifyUserName(String verifyUserName) {
		this.verifyUserName = verifyUserName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VERIFY_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getVerifyDate() {
		return this.verifyDate;
	}

	public void setVerifyDate(Date verifyDate) {
		this.verifyDate = verifyDate;
	}

	@Column(name = "DELETE_STATE", columnDefinition="NVARCHAR2(2)", unique = false, nullable = false, insertable = true, updatable = true)
	public String getDeleteState() {
		return this.deleteState;
	}

	public void setDeleteState(String deleteState) {
		this.deleteState = deleteState;
	}

	@Column(name = "ROLE_ORDER", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)
	public Long getRoleOrder() {
		return this.roleOrder;
	}

	public void setRoleOrder(Long roleOrder) {
		this.roleOrder = roleOrder;
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

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "scRoles")
	public Set<ScUsers> getScUserses() {
		return this.scUserses;
	}

	public void setScUserses(Set<ScUsers> scUserses) {
		this.scUserses = scUserses;
	}

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "SC_AUTHROLE", joinColumns = { @JoinColumn(name = "ROLE_ID", columnDefinition="NVARCHAR2(36)", unique = false, nullable = false, insertable = true, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "AUTH_ID", columnDefinition="NVARCHAR2(36)", unique = false, nullable = false, insertable = true, updatable = false) })
	public Set<ScAuth> getScAuths() {
		return this.scAuths;
	}

	public void setScAuths(Set<ScAuth> scAuths) {
		this.scAuths = scAuths;
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
	    
	    retValue = "ScRole ( "
	        + super.toString() + TAB
	        + "roleId = " + this.roleId + TAB
//	        + "scUsers = " + this.scUsers + TAB
	        + "roleName = " + this.roleName + TAB
	        + "roleDesc = " + this.roleDesc + TAB
	        + "enableState = " + this.enableState + TAB
	        + "verifyState = " + this.verifyState + TAB
	        + "verifyNote = " + this.verifyNote + TAB
	        + "verifyUserName = " + this.verifyUserName + TAB
	        + "verifyDate = " + this.verifyDate + TAB
	        + "deleteState = " + this.deleteState + TAB
	        + "roleOrder = " + this.roleOrder + TAB
	        + "createUserName = " + this.createUserName + TAB
	        + "createDate = " + this.createDate + TAB
	        + "modifyUserName = " + this.modifyUserName + TAB
	        + "modifyDate = " + this.modifyDate + TAB
//	        + "scUserses = " + this.scUserses + TAB
//	        + "scAuths = " + this.scAuths + TAB
	        + " )";
	
	    return retValue;
	}

}
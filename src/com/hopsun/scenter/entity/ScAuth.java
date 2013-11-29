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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 *@comments 权限实体类
 *@author yinxy
 *@date Jan 5, 2013 8:13:29 AM
 *@version 1.0
 */
@Entity
@Table(name = "SC_AUTH",  uniqueConstraints = {})
public class ScAuth implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields
	//权限id
	private String authId;
	//上级权限
	private ScAuth scAuth;
	//权限名称
	private String authName;
	//权限code
	private String authCode;
	//权限url
	private String authUrl;
	//权限type
	private String authType;
	//权限图标
	private String authIcon;
	//权限描述
	private String authDesc;
	//权限排序
	private Long authOrder;
	//是否根节点
	private String rootState;
	//可用状态
	private String enableState;
	//审核状态
	private String verifyState;
	//删除状态
	private String deleteState;
	//添加人用户名
	private String createUserName;
	//添加时间
	private Date createDate;
	//修改人用户名
	private String modifyUserName;
	//修改时间
	private Date modifyDate;
	//权限可用类型
	private String roleType;
	//权限打开方式
	private String opentypeState;
	//权限对应的角色
	private Set<ScRole> scRoles = new HashSet<ScRole>(0);
	//权限的下级权限
	private Set<ScAuth> scAuths = new HashSet<ScAuth>(0);
	//权限对应的快捷方式
	private Set<ScShortcut> scShortcuts = new HashSet<ScShortcut>(0);

	// Constructors

	/** default constructor */
	public ScAuth() {
	}

	/** minimal constructor */
	public ScAuth(String authId, String authName, String authCode, String authType, String verifyState, String createUserName, Date createDate,String opentypeState) {
		this.authId = authId;
		this.authName = authName;
		this.authCode = authCode;
		this.authType = authType;
		this.verifyState = verifyState;
		this.createUserName = createUserName;
		this.createDate = createDate;
		this.opentypeState=opentypeState;
	}

	/** full constructor */
	public ScAuth(String authId, ScAuth scAuth, String authName, String authCode, String authUrl, String authType, String authIcon, String authDesc, Long authOrder, String rootState, String enableState, String verifyState, String deleteState, String createUserName, Date createDate,String opentypeState, String modifyUserName, Date modifyDate, String roleType, Set<ScRole> scRoles, Set<ScAuth> scAuths, Set<ScShortcut> scShortcuts) {
		this.authId = authId;
		this.scAuth = scAuth;
		this.authName = authName;
		this.authCode = authCode;
		this.authUrl = authUrl;
		this.authType = authType;
		this.authIcon = authIcon;
		this.authDesc = authDesc;
		this.authOrder = authOrder;
		this.rootState = rootState;
		this.enableState = enableState;
		this.verifyState = verifyState;
		this.deleteState = deleteState;
		this.createUserName = createUserName;
		this.createDate = createDate;
		this.modifyUserName = modifyUserName;
		this.modifyDate = modifyDate;
		this.roleType = roleType;
		this.scRoles = scRoles;
		this.scAuths = scAuths;
		this.scShortcuts = scShortcuts;
		this.opentypeState=opentypeState;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "AUTH_ID", columnDefinition="NVARCHAR2(36)", nullable = false, insertable = true, updatable = true)
	public String getAuthId() {
		return this.authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "AUTH_PARENT_ID", columnDefinition="NVARCHAR2(36)", unique = false, nullable = true, insertable = true, updatable = true)
	public ScAuth getScAuth() {
		return this.scAuth;
	}

	public void setScAuth(ScAuth scAuth) {
		this.scAuth = scAuth;
	}

	@Column(name = "AUTH_NAME", columnDefinition="NVARCHAR2(36)", unique = false, nullable = false, insertable = true, updatable = true)
	public String getAuthName() {
		return this.authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	@Column(name = "AUTH_CODE", columnDefinition="NVARCHAR2(50)", unique = false, nullable = false, insertable = true, updatable = true)
	public String getAuthCode() {
		return this.authCode;
	}
	
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	
	@Column(name = "OPENTYPE_STATE", columnDefinition="NVARCHAR2(2)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getOpentypeState() {
		return this.opentypeState;
	}
	public void setOpentypeState(String opentypeState) {
		this.opentypeState = opentypeState;
	}

	@Column(name = "AUTH_URL", columnDefinition="NVARCHAR2(300)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getAuthUrl() {
		return this.authUrl;
	}

	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}

	@Column(name = "AUTH_TYPE", columnDefinition="NVARCHAR2(2)", unique = false, nullable = false, insertable = true, updatable = true)
	public String getAuthType() {
		return this.authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	@Column(name = "AUTH_ICON", columnDefinition="NVARCHAR2(150)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getAuthIcon() {
		return this.authIcon;
	}

	public void setAuthIcon(String authIcon) {
		this.authIcon = authIcon;
	}

	@Column(name = "AUTH_DESC", columnDefinition="NVARCHAR2(200)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getAuthDesc() {
		return this.authDesc;
	}

	public void setAuthDesc(String authDesc) {
		this.authDesc = authDesc;
	}

	@Column(name = "AUTH_ORDER", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)
	public Long getAuthOrder() {
		return this.authOrder;
	}

	public void setAuthOrder(Long authOrder) {
		this.authOrder = authOrder;
	}

	@Column(name = "ROOT_STATE", columnDefinition="NVARCHAR2(2)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getRootState() {
		return this.rootState;
	}

	public void setRootState(String rootState) {
		this.rootState = rootState;
	}

	@Column(name = "ENABLE_STATE", columnDefinition="NVARCHAR2(2)", unique = false, nullable = true, insertable = true, updatable = true)
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

	@Column(name = "ROLE_TYPE", columnDefinition="NVARCHAR2(2)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getRoleType() {
		return this.roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "scAuths")
	public Set<ScRole> getScRoles() {
		return this.scRoles;
	}

	public void setScRoles(Set<ScRole> scRoles) {
		this.scRoles = scRoles;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "scAuth")
	public Set<ScAuth> getScAuths() {
		return this.scAuths;
	}

	public void setScAuths(Set<ScAuth> scAuths) {
		this.scAuths = scAuths;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "scAuth")
	public Set<ScShortcut> getScShortcuts() {
		return this.scShortcuts;
	}

	public void setScShortcuts(Set<ScShortcut> scShortcuts) {
		this.scShortcuts = scShortcuts;
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
	    
	    retValue = "ScAuth ( "
	        + super.toString() + TAB
	        + "authId = " + this.authId + TAB
	        //+ "scAuth = " + this.scAuth + TAB
	        + "authName = " + this.authName + TAB
	        + "authCode = " + this.authCode + TAB
	        + "authUrl = " + this.authUrl + TAB
	        + "authType = " + this.authType + TAB
	        + "authIcon = " + this.authIcon + TAB
	        + "authDesc = " + this.authDesc + TAB
	        + "authOrder = " + this.authOrder + TAB
	        + "rootState = " + this.rootState + TAB
	        + "enableState = " + this.enableState + TAB
	        + "verifyState = " + this.verifyState + TAB
	        + "deleteState = " + this.deleteState + TAB
	        + "createUserName = " + this.createUserName + TAB
	        + "createDate = " + this.createDate + TAB
	        + "modifyUserName = " + this.modifyUserName + TAB
	        + "modifyDate = " + this.modifyDate + TAB
	        + "roleType = " + this.roleType + TAB
	        + "opentypeState = " + this.opentypeState + TAB
	        //+ "scRoles = " + this.scRoles + TAB
	        //+ "scAuths = " + this.scAuths + TAB
	        //+ "scShortcuts = " + this.scShortcuts + TAB
	        + " )";
	
	    return retValue;
	}

}
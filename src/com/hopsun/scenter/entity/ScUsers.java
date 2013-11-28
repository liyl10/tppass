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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * ScUsers entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SC_USERS", uniqueConstraints = {})
public class ScUsers implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 6390046265264005392L;
	
	//用户id
	private String userId;
	//用户部门
	private ScDept scDept;
	//用户名
	private String userName;
	//密码
	private String userPwd;
	//真实姓名
	private String userRealname;
	//昵称
	private String userNickname;
	//性别
	private String userAgent;
	//邮箱
	private String userEmail;
	//电话
	private String userPhone;
	//登录次数
	private Long loginTimes;
	//登陆时间
	private Date loginDate;
	//允许登陆ip
	private String allowLoginIp;
	//登陆ip
	private String lastLoginIp;
	//是否启用
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
	//添加人
	private String createUserName;
	//添加时间
	private Date createDate;
	//修改人
	private String modifyUserName;
	//修改时间
	private Date modifyDate;
	//用户快捷方式
	private Set<ScShortcut> scShortcuts = new HashSet<ScShortcut>(0);
	//用户角色
	private Set<ScRole> scRoles = new HashSet<ScRole>(0);
	//用户上级
	private Set<ScUsers> scUsersesForParentUserId = new HashSet<ScUsers>(0);
	//用户角色
	private Set<ScRole> scRoles_1 = new HashSet<ScRole>(0);
	//用户下级
	private Set<ScUsers> scUsersesForChildUserId = new HashSet<ScUsers>(0);
	//用户分类
	private String userType;

	// Constructors

	/** default constructor */
	public ScUsers() {
	}

	/** minimal constructor */
	public ScUsers(String userId, String userName, String userPwd, String createUserName, Date createDate) {
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.createUserName = createUserName;
		this.createDate = createDate;
	}

	/** full constructor */
	public ScUsers(String userId, ScDept scDept, String userName, String userPwd, String userRealname, String userNickname, String userAgent, String userEmail, String userPhone, Long loginTimes, Date loginDate, String allowLoginIp, String lastLoginIp, String enableState, String verifyState, String verifyNote, String verifyUserName, Date verifyDate, String deleteState, String createUserName, Date createDate, String modifyUserName, Date modifyDate, Set<ScShortcut> scShortcuts, Set<ScRole> scRoles, Set<ScUsers> scUsersesForParentUserId, Set<ScRole> scRoles_1, Set<ScUsers> scUsersesForChildUserId, String userType) {
		this.userId = userId;
		this.scDept = scDept;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userRealname = userRealname;
		this.userNickname = userNickname;
		this.userAgent = userAgent;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.loginTimes = loginTimes;
		this.loginDate = loginDate;
		this.allowLoginIp = allowLoginIp;
		this.lastLoginIp = lastLoginIp;
		this.enableState = enableState;
		this.verifyState = verifyState;
		this.verifyNote = verifyNote;
		this.verifyUserName = verifyUserName;
		this.verifyDate = verifyDate;
		this.deleteState = deleteState;
		this.createUserName = createUserName;
		this.createDate = createDate;
		this.modifyUserName = modifyUserName;
		this.modifyDate = modifyDate;
		this.scShortcuts = scShortcuts;
		this.scRoles = scRoles;
		this.scUsersesForParentUserId = scUsersesForParentUserId;
		this.scRoles_1 = scRoles_1;
		this.scUsersesForChildUserId = scUsersesForChildUserId;
		this.userType = userType;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "USER_ID", columnDefinition="NVARCHAR2(36)", nullable = false, insertable = true, updatable = true)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPT_ID", columnDefinition="NVARCHAR2(36)", unique = false, nullable = true, insertable = true, updatable = true)
	public ScDept getScDept() {
		return this.scDept;
	}

	public void setScDept(ScDept scDept) {
		this.scDept = scDept;
	}

	@Column(name = "USER_NAME", columnDefinition="NVARCHAR2(40)", unique = false, nullable = false, insertable = true, updatable = true)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "USER_PWD", columnDefinition="NVARCHAR2(40)", unique = false, nullable = false, insertable = true, updatable = true)
	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Column(name = "USER_REALNAME", columnDefinition="NVARCHAR2(20)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getUserRealname() {
		return this.userRealname;
	}

	public void setUserRealname(String userRealname) {
		this.userRealname = userRealname;
	}

	@Column(name = "USER_NICKNAME", columnDefinition="NVARCHAR2(20)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getUserNickname() {
		return this.userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	@Column(name = "USER_AGENT",columnDefinition="NVARCHAR2(2)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getUserAgent() {
		return this.userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	@Column(name = "USER_EMAIL", columnDefinition="NVARCHAR2(50)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "USER_PHONE", columnDefinition="NVARCHAR2(50)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Column(name = "LOGIN_TIMES", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)
	public Long getLoginTimes() {
		return this.loginTimes;
	}

	public void setLoginTimes(Long loginTimes) {
		this.loginTimes = loginTimes;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LOGIN_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getLoginDate() {
		return this.loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	@Column(name = "ALLOW_LOGIN_IP", columnDefinition="NVARCHAR2(150)",unique = false, nullable = true, insertable = true, updatable = true)
	public String getAllowLoginIp() {
		return this.allowLoginIp;
	}

	public void setAllowLoginIp(String allowLoginIp) {
		this.allowLoginIp = allowLoginIp;
	}

	@Column(name = "LAST_LOGIN_IP", columnDefinition="NVARCHAR2(20)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Column(name = "ENABLE_STATE", columnDefinition="NVARCHAR2(2)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getEnableState() {
		return this.enableState;
	}

	public void setEnableState(String enableState) {
		this.enableState = enableState;
	}

	@Column(name = "VERIFY_STATE", columnDefinition="NVARCHAR2(2)", unique = false, nullable = true, insertable = true, updatable = true)
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

	@Column(name = "MODIFY_USER_NAME", columnDefinition="NVARCHAR2(40)",unique = false, nullable = true, insertable = true, updatable = true)
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

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "scUsers")
	public Set<ScShortcut> getScShortcuts() {
		return this.scShortcuts;
	}

	public void setScShortcuts(Set<ScShortcut> scShortcuts) {
		this.scShortcuts = scShortcuts;
	}

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "SC_USERSROLE",   joinColumns = { @JoinColumn(name = "USER_ID", columnDefinition="NVARCHAR2(36)", unique = false, nullable = false, insertable = true, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", columnDefinition="NVARCHAR2(36)", unique = false, nullable = false, insertable = true, updatable = false) })
	public Set<ScRole> getScRoles() {
		return this.scRoles;
	}

	public void setScRoles(Set<ScRole> scRoles) {
		this.scRoles = scRoles;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "scUsers")
	public Set<ScRole> getScRoles_1() {
		return this.scRoles_1;
	}

	public void setScRoles_1(Set<ScRole> scRoles_1) {
		this.scRoles_1 = scRoles_1;
	}

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "scUsersesForParentUserId")
	public Set<ScUsers> getScUsersesForChildUserId() {
		return this.scUsersesForChildUserId;
	}

	public void setScUsersesForChildUserId(Set<ScUsers> scUsersesForChildUserId) {
		this.scUsersesForChildUserId = scUsersesForChildUserId;
	}
	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "SC_USER_LEVEL",   joinColumns = { @JoinColumn(name = "CHILD_USER_ID", columnDefinition="NVARCHAR2(36)", unique = false, nullable = false, insertable = true, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "PARENT_USER_ID", columnDefinition="NVARCHAR2(36)", unique = false, nullable = false, insertable = true, updatable = false) })
	public Set<ScUsers> getScUsersesForParentUserId() {
		return this.scUsersesForParentUserId;
	}
	
	public void setScUsersesForParentUserId(Set<ScUsers> scUsersesForParentUserId) {
		this.scUsersesForParentUserId = scUsersesForParentUserId;
	}
	
	@Column(name = "USER_TYPE",columnDefinition="NVARCHAR2(2)", unique = false, nullable = true, insertable = true, updatable = true)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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
	    
	    retValue = "ScUsers ( "
	        + super.toString() + TAB
	        + "userId = " + this.userId + TAB
//	        + "scDept = " + this.scDept + TAB
	        + "userName = " + this.userName + TAB
	        + "userPwd = " + this.userPwd + TAB
	        + "userRealname = " + this.userRealname + TAB
	        + "userNickname = " + this.userNickname + TAB
	        + "userAgent = " + this.userAgent + TAB
	        + "userEmail = " + this.userEmail + TAB
	        + "userPhone = " + this.userPhone + TAB
	        + "loginTimes = " + this.loginTimes + TAB
	        + "loginDate = " + this.loginDate + TAB
	        + "allowLoginIp = " + this.allowLoginIp + TAB
	        + "lastLoginIp = " + this.lastLoginIp + TAB
	        + "enableState = " + this.enableState + TAB
	        + "verifyState = " + this.verifyState + TAB
	        + "verifyNote = " + this.verifyNote + TAB
	        + "verifyUserName = " + this.verifyUserName + TAB
	        + "verifyDate = " + this.verifyDate + TAB
	        + "deleteState = " + this.deleteState + TAB
	        + "createUserName = " + this.createUserName + TAB
	        + "createDate = " + this.createDate + TAB
	        + "modifyUserName = " + this.modifyUserName + TAB
	        + "modifyDate = " + this.modifyDate + TAB
//	        + "scShortcuts = " + this.scShortcuts + TAB
//	        + "scRoles = " + this.scRoles + TAB
//	        + "scUsersesForParentUserId = " + this.scUsersesForParentUserId + TAB
//	        + "scRoles_1 = " + this.scRoles_1 + TAB
//	        + "scUsersesForChildUserId = " + this.scUsersesForChildUserId + TAB
	        + " )";
	
	    return retValue;
	}

}
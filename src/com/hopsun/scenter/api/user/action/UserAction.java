/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */

package com.hopsun.scenter.api.user.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.util.MD5;
import com.hopsun.framework.util.StrutsUtil;
import com.hopsun.scenter.api.dept.service.DeptService;
import com.hopsun.scenter.api.role.service.RoleService;
import com.hopsun.scenter.api.user.service.UserService;
import com.hopsun.scenter.entity.ScDept;
import com.hopsun.scenter.entity.ScRole;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.subgroups.logs.util.RequestUtil;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigBean;
import com.hopsun.subgroups.paramconfig.util.ParamConfigUtil;

/**
 * @Comments:   后台用户Action类 - 主要用来做用户信息管理
 * @author dulei(dulei@hopsun.cn)
 * @date 2012-12-24 上午08:42:32
 * @version 1.0
 *
 */
@SuppressWarnings("unchecked")
public class UserAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	//用户信息
	private ScUsers admin; 
	//旧密码
	private String oldPwd; 
	//上级部门集合
	private List<ScDept> list; 
	//用户集合
	private List<ScUsers> userlist; 
	//系统参数实体 - 是否启用
	private ParamConfigBean bean; 
	//系统参数实体 - 审核状态
	private ParamConfigBean verify; 
	//系统参数实体 - 性别
	private ParamConfigBean agent; 
	//系统参数实体 - 用户的权限范围
	private ParamConfigBean userOptType;
	//系统参数实体 - 用户分类
	private ParamConfigBean usertype;
	//加载可见的角色列表---yinxy
	public  List roleList;
	//加载可选的上级用户
	public  List supUserList;
	//加载可选的上级用户，返回json字符串
	public String supUserListJson;
	//加载部门，返回json字符串
	public String supDeptListJson;
	// 查询条件
	public Map<String, Object> condition; 
	//上级管理员id
	public String parentId;
	//是否来自部门管理
	public String com_from_dept;
	//是否来自上级用户
	public String com_from_puser;
	
	//操作的用户id
	public String optuserid;
	//返回结果
	public Map<String, Object> pro_result = new HashMap<String, Object>();
	//获取用户对应的角色
	private String[] scRoles;	
	//部门id
	private String deptid;	
	//用户名
	private String username;
	//角色服务类接口
	@Resource
	private RoleService roleService;
	//用户信息服务类接口
	@Resource
	private UserService userService;
	//部门信息服务类接口
	@Resource
	private DeptService deptService;
	
	/**
	 * 跳转到用户管理列表页面（当前管理员有权查看的用户，自己创建的与下级用户创建的，每次只查看一级）
	 * @return
	 * @version 1.0
	 */
	public String list(){
		//pager信息
		if(null == pager){
			setPager(new Pager());
		}
		
		//当前登录用户
		ScUsers user = (ScUsers)getSession().get("sysUser");
		//查询条件
		if(null == admin){
			admin = new ScUsers();
		}
		if(null != admin.getScDept() && null != admin.getScDept().getDeptId()){
			admin.setScDept(deptService.get(admin.getScDept().getDeptId()));
		}
		//admin.setUserId(user.getUserId());
		//不为超级管理员
		//		if(null != user.getScUsersesForParentUserId()&&user.getScUsersesForParentUserId().size()>0){
		//			admin.setScUsersesForParentUserId(user.getScUsersesForParentUserId());
		//		}
		condition = new HashMap<String, Object>(); // 页面查询条件，用于回显
		condition.put("verifyState", admin.getVerifyState());
		condition.put("enableState", admin.getEnableState());
		//condition.put("roleName", role_name);
		
		String verify_state=admin.getVerifyState();
		if (verify_state != null && !"".equals(verify_state)) {
			String verifyState = null;
			if ("1".equals(verify_state)) {
				verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifypass").getValue();// 审核通过
			} else if ("2".equals(verify_state)) {
				verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifyrefuse").getValue();// 审核不通过
			} else {
				verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("submit").getValue();// 提交审核
			}
			admin.setVerifyState(verifyState);
		}
		String enable_state=admin.getEnableState();
		if (enable_state != null && !"".equals(enable_state)) {
			String enableState = null;
			if ("1".equals(enable_state)) {
				enableState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("enable").getValue();// 启用
			} else {
				enableState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("disable").getValue();// 禁用

			}
			admin.setEnableState(enableState);
		}
		//查询用户id若为空，则查询当前登录用户
		if(optuserid==null||"".equals(optuserid)){
			optuserid=user.getUserId();
		}
		//分页查询用户信息
		pager = userService.find(admin,optuserid, pager.getPageNumber(), pager.getPageSize());
		
		//部门信息
		list = deptService.findDept(new ScDept());
		
		//是否启用
		bean = (ParamConfigBean)getApplication().getAttribute("CONFIG_STATE");
		
		//审核状态
		verify = (ParamConfigBean)getApplication().getAttribute("VERIFY_STATE");
		
		//加载用户部门树
		supDeptListJson=deptService.getDeptListJson(user,null);
		
		return "list";
	}
	
	/**
	 * 跳转到用户添加页面
	 * @return
	 * @version 1.0
	 */
	public String insert(){
		//当前登录用户
		ScUsers user = (ScUsers)getSession().get("sysUser");
		
		//部门信息
		list = deptService.findDept(new ScDept());
		//上级管理员
		//userlist = userService.findUser(new ScUsers());
		//是否启用
		bean = (ParamConfigBean)getApplication().getAttribute("CONFIG_STATE");
		//性别
		agent = (ParamConfigBean)getApplication().getAttribute("SEX");
		
		//加载可见的角色---yinxy
		roleList=userService.getRoleListByUserId(user.getUserId());
		//roleList=userService.getRoleListWithSelected(user.getUserId(),admin.getUserId());
		
		//加载可选的上级用户
		supUserListJson = userService.getSupUserListJsonByUserId(user.getUserId(),"");
		
		//加载用户部门树
		supDeptListJson=deptService.getDeptListJson(user,null);
		
		//用户分类
		usertype = (ParamConfigBean)getApplication().getAttribute("USERTYPE");
		
		return "insert";
	}
	
	/**
	 * 跳转到用户个人信息修改页面
	 * @return
	 * @version 1.0
	 */
	public String perfect(){
		
		return "perfect";
	}
	
	/**
	 * 
	 * @comments ajax 根据用户名查询用户信息，判断是否重名
	 * @version 1.0
	 */
	public void getUserByName(){
		//根据用户名查询用户信息
		ScUsers scuser = userService.getUserByUsername2(username);
		
		try {
			if(null != scuser){
				//用户名称已经存在
				String exsit = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.userName.exsit"));
				RequestUtil.getResponse().getWriter().write("{\"info\":\""+exsit+"\",\"status\":\"n\"}");
			}else{
				//用户名称不存在
				String notexsit = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.userName.notexsit"));
				RequestUtil.getResponse().getWriter().write("{\"info\":\""+notexsit+"\",\"status\":\"y\"}");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 添加用户信息
	 * @return
	 * @version 1.0
	 */
	public String insertUser(){
		//根据用户名查询用户信息
		ScUsers scuser = userService.getUserByUsername2(admin.getUserName());
		//判断用户是否存在
		if(null != scuser){
			//用户名称已经存在
			String exsit = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.userName.exsit"));
			addActionMessage(exsit);
			return ERROR;
		}else {
			//当前登录系统的管理员
			ScUsers user = (ScUsers)getSession().get("sysUser");
			//添加人
			admin.setCreateUserName(user.getUserName());
			//添加时间
			admin.setCreateDate(new Date());
			
			//用户密码、加密
			admin.setUserPwd(MD5.createPassword(admin.getUserPwd()));
			
			//默认审核状态
			admin.setVerifyState(((ParamConfigBean)getApplication().getAttribute("VERIFY_STATE")).getConfigDefault().getValue());
			//删除状态：未删除
			admin.setDeleteState(((ParamConfigBean)getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue());
			//登陆次数
			admin.setLoginTimes(Long.parseLong("0"));
			
			//保存角色信息
			//更新角色
			Set<ScRole> scRoleSet=roleService.getRoleSetById(scRoles);
			admin.setScRoles(scRoleSet);
			//userService.update(admin);
			
			//保存上级管理员
			Set<ScUsers> parentUser = new HashSet<ScUsers>();
			String[] parent = parentId.split(",");
			for(int i=0;i<parent.length;i++){
				String[] parent2 = parent[i].split("#");
				ScUsers pUser = userService.get(parent2[1]);
				if(null != pUser){
					if(!parentUser.contains(pUser)){
						parentUser.add(pUser);
					}
				}
			}
			
			if(parentUser.size()>0){
				admin.setScUsersesForParentUserId(parentUser);
			}
			
			userService.save(admin);
			
			return SUCCESS;
		}
		
	}
	
	/**
	 * ajax请求 根据部门id获取该部门下的用户信息
	 * 
	 * @param authList
	 * @param jsonAuthList
	 * @return
	 */
	@SuppressWarnings("unused")
	public void getUsersByDept() {
		
		ScUsers user = new ScUsers();
		user.setScDept(deptService.load(deptid));
		
		//上级管理员
		userlist = userService.findUser(user);
			
		// 存放已封装的权限
		JSONArray jsonArray = new JSONArray();
		// 循环父级目录
		for (ScUsers users : userlist) {
			
			JSONObject childnode = new JSONObject();
			
			// 树结构文件名称
			childnode.put("name", users.getUserName());
			// 树结构唯一标示
			childnode.put("realname", users.getUserRealname());
			// 树结构父级ID
			childnode.put("userid", users.getUserId());
			
			jsonArray.add(childnode);
		}
			
		this.ajax(jsonArray.toString(),"text/html");
		
	}
	
	/**
	 * 修改用户信息
	 * @return
	 * @version 1.0
	 */
	public String updateUser(){
		//当前登录用户
		ScUsers user = (ScUsers)getSession().get("sysUser");
		
		//更新角色
		Set<ScRole> scRoleSet=roleService.getRoleSetById(scRoles);
		admin.setScRoles(scRoleSet);
		
		//获取旧的用户信息
		userService.clear();
		ScUsers oldInfo=userService.get(admin.getUserId());
		
		//修改人
		admin.setModifyUserName(user.getUserName());
		//修改时间
		admin.setModifyDate(new Date());
		//判断用户是否修改密码
		userService.clear();
		if(null != admin.getUserPwd() && !("").equals(admin.getUserPwd())){
			//修改密码
			admin.setUserPwd(MD5.createPassword(admin.getUserPwd()));
		}else {
			//旧密码
			//String userPwd = userService.load(admin.getUserId()).getUserPwd();
			String userPwd = oldInfo.getUserPwd();
			admin.setUserPwd(userPwd);
		}
		 
		//保存上级管理员
		Set<ScUsers> parentUser = new HashSet<ScUsers>();
		String[] parent = parentId.split(",");
		for(int i=0;i<parent.length;i++){
			String[] parent2 = parent[i].split("#");
			userService.clear();
			ScUsers pUser = userService.get(parent2[1]);
			if(null != pUser){
				if(!parentUser.contains(pUser)){
					parentUser.add(pUser);
				}
			}
		}
		//判断是否为顶级管理员，若为顶级管理员，则置空上级id
		if("1".equals(admin.getUserId())){
			admin.setScUsersesForParentUserId(null);
		}else{
			if(parentUser.size()>0){
			 	admin.setScUsersesForParentUserId(parentUser);
			}
		}
		
		//更新用户信息
		pro_result=userService.updateUsers(admin);
		
		if (pro_result != null && "1".equals(pro_result.get("msg"))) {
			return SUCCESS;
		} else {
			//提示
			addActionMessage(pro_result.get("msg").toString());
			return ERROR;
		}
		
	}
	
	/**
	 * 跳转到用户信息修改页面
	 * @return
	 * @version 1.0
	 */
	public String modify(){
		
		//当前登录用户
		ScUsers user = (ScUsers)getSession().get("sysUser");
		
		//要修改的用户
		admin = userService.get(admin.getUserId());
		
		//部门信息
		list = deptService.findDept(new ScDept());
		
		//是否启用
		bean = (ParamConfigBean)getApplication().getAttribute("CONFIG_STATE");
		
		//性别
		agent = (ParamConfigBean)getApplication().getAttribute("SEX");
		
		//加载可见的角色---yinxy
		roleList=userService.getRoleListWithSelected(user.getUserId(),admin.getUserId());
		
		//加载可选的上级用户
		supUserListJson = userService.getSupUserListJsonByUserId(user.getUserId(),admin.getUserId());
		
		//加载用户部门树
		supDeptListJson=deptService.getDeptListJson(admin,null);
		
		//用户分类
		usertype = (ParamConfigBean)getApplication().getAttribute("USERTYPE");
		
		return "modify";
	}
	
	/**
	 * 跳转到用户信息审核页面
	 * @return
	 * @version 1.0
	 */
	public String verify(){
		//当前登录用户
		ScUsers user = (ScUsers)getSession().get("sysUser");
		//要审核的用户
		admin = userService.load(admin.getUserId());
		
		//部门信息
		list = deptService.findDept(new ScDept());
		//上级管理员
		userlist = userService.findUser(new ScUsers());
		//是否启用
		bean = (ParamConfigBean)getApplication().getAttribute("CONFIG_STATE");
		//性别
		agent = (ParamConfigBean)getApplication().getAttribute("SEX");
		//用户的权限范围
		//审核状态
		verify = (ParamConfigBean)getApplication().getAttribute("VERIFY_STATE");

		//加载可见的角色---yinxy
		 roleList=userService.getRoleListWithSelected(user.getUserId(),admin.getUserId());
		 
		//用户分类
		usertype = (ParamConfigBean)getApplication().getAttribute("USERTYPE");
		
		return "verify";
	}
	
	/**
	 * 用户信息审核
	 * @return
	 * @version 1.0
	 */
	public String verifyUser(){
		
		//要审核的用户
		ScUsers user = userService.load(admin.getUserId());
		//审核状态
		//user.setVerifyState(admin.getVerifyState());
		String verifyState = null;
		if ("1".equals(admin.getVerifyState())) {
			verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifypass").getValue();// 审核通过
		} else if ("2".equals(admin.getVerifyState())) {
			verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifyrefuse").getValue();// 审核不通过
		} else {
			verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("submit").getValue();// 提交审核
		}
		user.setVerifyState(verifyState);
		user.setVerifyNote(admin.getVerifyNote());
		//更新用户信息
		pro_result = userService.updateVerifyState(user);
		if (pro_result != null && "1".equals(pro_result.get("msg"))) {
			return SUCCESS;
		} else {
			//提示
			addActionMessage(pro_result.get("msg").toString());
			return ERROR;
		}
	}
	
	/**
	 * 跳转到用户信息详情页面
	 * @return
	 * @version 1.0
	 */
	public String details(){
		//当前登录用户
		ScUsers user = (ScUsers)getSession().get("sysUser");
		//要查看的用户
		admin = userService.load(admin.getUserId());
		//审核状态
		verify = (ParamConfigBean)getApplication().getAttribute("VERIFY_STATE");
		//部门信息
		list = deptService.findDept(new ScDept());
		//上级管理员
		userlist = userService.findUser(new ScUsers());
		//是否启用
		bean = (ParamConfigBean)getApplication().getAttribute("CONFIG_STATE");
		//性别
		agent = (ParamConfigBean)getApplication().getAttribute("SEX");
		//用户的权限范围
		userOptType = (ParamConfigBean)getApplication().getAttribute("USER_OPT_TYPE");
		
		//加载可见的角色---yinxy
		roleList=userService.getRoleListWithSelected(user.getUserId(),admin.getUserId());
		
		//用户分类
		usertype = (ParamConfigBean)getApplication().getAttribute("USERTYPE");
		
		return "details";
	}
	
	/**
	 * 删除用户信息
	 * @return
	 * @version 1.0
	 */
	public String deleteUser(){
		
		try {
			//判断是否提交数据
			if(null == ids){
				//提示信息
				//请选择要删除的数据
				String exsit = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.userName.nodeldata"));
				addActionMessage(exsit);
				
				return ERROR;
			}else {
				//逻辑删除
				int i = 0;
				int j = 0;
				String message = "";
				for(String userid : ids){
					if(!userid.equals("1")){
						pro_result = userService.deleteUser(userid);
						if (pro_result != null && "1".equals(pro_result.get("msg"))) {
							i++;
						} else {
							j++;
							message += pro_result.get("msg");
						}
					}
				}
				if (j != 0) {
					//不可被删除！
					String cannotdel = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.cannotdel"));
					addActionMessage(message + cannotdel);
					return ERROR;
				} else {
					//删除成功
					String success = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.delete.success"));
					addActionMessage(success);
					return SUCCESS;
				}
				
			}
		} catch (RuntimeException e) {
			//删除失败!
			String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.delete.error"));
			addActionMessage(error);
			return ERROR;
		}
	}
	
	/**
	 * 启用用户账号
	 * @return
	 * @version 1.0
	 */
	public String enableUser(){
		
		//启用状态值
		String state = ((ParamConfigBean)getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("enable").getValue();
		//判断是否有数据提交
		if(null == ids){
			//提示信息
			//请选择要启用的用户!
			String enable = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.enable"));
			addActionMessage(enable);
			return ERROR;
		}else {
			for(String id : ids){
				if(!id.equals("1")){
					//加载用信息
					ScUsers user = userService.load(id);
					//设置状态
					user.setEnableState(state);
					//更新用户信息
					userService.update(user);
				}
			}
			//提示信息
			//启用成功!
			String success = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.enable.success"));
			addActionMessage(success);
			return SUCCESS;
		}
	}
	
	/**
	 * 禁用用户账号
	 * @return
	 * @version 1.0
	 */
	public String disableUser(){
		
		//禁用状态值
		String state = ((ParamConfigBean)getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("disable").getValue();
		//判断是否有数据提交
		if(null == ids){
			//提示信息
			//请选择要禁用的用户!
			String disable = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.disable"));
			addActionMessage(disable);
			return ERROR;
		}else {
			int i = 0;
			int j = 0;
			String message = "";
			for(String userid : ids){
				if(!userid.equals("1")){
					//加载用信息
					ScUsers user = userService.load(userid);
					//设置状态
					user.setEnableState(state);
					//更新用户信息
					pro_result = userService.updateEnableState(user);
					if (pro_result != null && "1".equals(pro_result.get("msg"))) {
						i++;
					} else {
						j++;
						message += pro_result.get("msg");
					}
				}
			}
			if (j != 0) {
				//不能禁用。
				String cannot = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.disable.cannot"));
				addActionMessage(message+cannot);
				return ERROR;
			} else {
				return SUCCESS;
			}
			
		}
	}
	
	/**
	 * 账号密码重置
	 * @return String
	 * @version 1.0
	 */
	public String resetUserpwd(){
		//提示信息
		//this.redirectUrl="/api/user_list.action";
		//新密码
		String newpwd = ((ParamConfigBean)getApplication().getAttribute("PASSWORD")).getBeansByCode("password").getValue();
		//判断是否有数据提交
		if(null == ids){
			//提示信息
			//请选择要重置密码的用户!
			String resetpwd = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.disable.resetpwd"));
			addActionMessage(resetpwd);
			return ERROR;
		}else {
			for(String id : ids){
				if(!id.equals("1")){
					//加载用信息
					ScUsers user = userService.load(id);
					//设置状态
					user.setUserPwd(MD5.createPassword(newpwd));
					//更新用户信息
					userService.update(user);
				}
			}
			return SUCCESS;
		}
	}
	
	/**
	 * 
	 * @comments 用户个人信息修改方法
	 * @return string
	 * @version 1.0
	 */
	public String update(){
		//加载用信息
		ScUsers users = userService.load(admin.getUserId());
		
		//判断密码是否正确
		if(users.getUserPwd().equals(MD5.createPassword(oldPwd))){
			//修改用户信息
			users.setUserRealname(admin.getUserRealname());
			users.setUserEmail(admin.getUserEmail());
			users.setUserPhone(admin.getUserPhone());
			//设置新密码
			if(null != admin.getUserPwd() && !("").equals(admin.getUserPwd()) ){
				users.setUserPwd(MD5.createPassword(admin.getUserPwd()));
			}
			//session设置用户信息
			setSession("sysUser", users);
			//更新用户信息
			userService.update(users);
			
			return SUCCESS;
		}else {
			// 返回提示信息
			//原密码有误!
			String error = String.valueOf(ParamConfigUtil.getServletContext().getAttribute("validform.scenter.user.pwd.error"));
			addActionMessage(error);
			
			return ERROR;
		}
		
	}
	
	public ScUsers getAdmin() {
		return admin;
	}

	public void setAdmin(ScUsers admin) {
		this.admin = admin;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public List<ScDept> getList() {
		return list;
	}

	public ParamConfigBean getBean() {
		return bean;
	}

	public ParamConfigBean getVerify() {
		return verify;
	}

	public ParamConfigBean getAgent() {
		return agent;
	}

	public List<ScUsers> getUserlist() {
		return userlist;
	}

	public String[] getScRoles() {
		return scRoles;
	}

	public void setScRoles(String[] scRoles) {
		this.scRoles = scRoles;
	}

	public ParamConfigBean getUserOptType() {
		return userOptType;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCom_from_dept() {
		return com_from_dept;
	}

	public void setCom_from_dept(String com_from_dept) {
		this.com_from_dept = com_from_dept;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getOptuserid() {
		return optuserid;
	}

	public void setOptuserid(String optuserid) {
		this.optuserid = optuserid;
	}

	public String getCom_from_puser() {
		return com_from_puser;
	}

	public void setCom_from_puser(String com_from_puser) {
		this.com_from_puser = com_from_puser;
	}

	public ParamConfigBean getUsertype() {
		return usertype;
	}

}
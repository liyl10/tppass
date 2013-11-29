/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.scenter.api.login.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jasig.cas.client.authentication.AttributePrincipal;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.util.MD5;
import com.hopsun.framework.util.StrutsUtil;
import com.hopsun.framework.util.Util;
import com.hopsun.scenter.api.auth.service.AuthService;
import com.hopsun.scenter.api.user.service.UserService;
import com.hopsun.scenter.entity.ScAuth;
import com.hopsun.scenter.entity.ScDept;
import com.hopsun.scenter.entity.ScRole;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.subgroups.logs.util.RequestUtil;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigBean;
import com.hopsun.tppas.api.superadmin.service.TprojectTypeManagerService;
import com.hopsun.tppas.common.Constants;

/**
 * @Comments:   后台Action类 - 主要用来做用户登录相关工作
 * @author dulei(dulei@hopsun.cn)
 * @date 2012-12-24 上午08:55:32
 * @version 1.0
 *
 */
@SuppressWarnings("unchecked")
public class LoginAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	private ScUsers admin;//前台提交的用户信息
	private String number;//验证码
	private String userName;//用户名
	private String userPwd;//密码
	private String authId;//权限ID
	private List<ScAuth> rootAuthList;//一级权限
	private JSONArray authList;//权限信息（默认为快捷方式）
	private String back_url; //跳转返回路径
	private String authid; //权限code
	//用户服务接口类
	@Resource
	private UserService userService;
	//权限服务接口类
	@Resource
	private AuthService authService;	
	
	//项目分类管理
	@Resource
	private TprojectTypeManagerService tprojectTypeManagerService;
	
	//职位用户列表
	private List<ScUsers> userlist;
	
	public List<ScUsers> getUserlist0() {
		return userlist0;
	}

	public void setUserlist0(List<ScUsers> userlist0) {
		this.userlist0 = userlist0;
	}

	public List<ScUsers> getUserlist2() {
		return userlist2;
	}

	public void setUserlist2(List<ScUsers> userlist2) {
		this.userlist2 = userlist2;
	}

	public List<ScUsers> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<ScUsers> userlist) {
		this.userlist = userlist;
	}
	
	//部门列表0
	private List<ScDept> deptlist0;
	//部门列表1
	private List<ScDept> deptlist1;
	//部门列表2
	private List<ScDept> deptlist2;
	
	//职位列表0
	private List<ScUsers> userlist0;
	//部门列表2
	private List<ScUsers> userlist2;
	
	// 用户分类
	private String userType;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * 跳转到登陆页面
	 * @return
	 */
	public String tologin(){
		// 获得用户
		AttributePrincipal attributePrincipal = (AttributePrincipal) this.getRequest().getUserPrincipal();
		if(attributePrincipal!=null){
			Map<String, Object> valueMap = ((AttributePrincipal) this.getRequest().getUserPrincipal()).getAttributes();

			if (valueMap != null && valueMap.size() > 0) {
				HttpSession session = this.getRequest().getSession();
				ScUsers user = new ScUsers();
				user.setUserAgent(String.valueOf(valueMap.get("userAgent")));
				user.setUserPwd(String.valueOf(valueMap.get("userPwd")));
				user.setUserEmail(String.valueOf(valueMap.get("userEmail")));
				user.setUserNickname(String.valueOf(valueMap.get("userNickname")));
				user.setVerifyState(String.valueOf(valueMap.get("verifyState")));
				user.setUserRealname(String.valueOf(valueMap.get("userRealname")));
				user.setLastLoginIp(String.valueOf("lastLoginIp"));
				user.setCreateUserName(String.valueOf(valueMap.get("createUserName"))); 
				user.setUserId(String.valueOf(valueMap.get("userId")));
				user.setUserName(String.valueOf("userName"));
				//enableState=1, 
				//deleteState=0, 
				//loginTimes=3352,  
				//loginDate=2013-09-03 00:00:00.0, 
				//createDate=2013-01-25 00:00:00.0
				session.setAttribute("sysUser",user);
				
				/**权限测试*/
				// 用户拥有的权限
    			Set<ScAuth> userAuths = new HashSet<ScAuth>();
    			//获取用户的所有角色
    			Set<ScRole> userRoles = user.getScRoles();
    			String nodelete=((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue();
    			String enable=((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("enable").getValue();
    			String verifyState=((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifypass").getValue();
    			if (userRoles != null && userRoles.size() > 0) {
    				for (ScRole role : userRoles) {
    					//角色状态必须为正常可用的
    					if(nodelete.equals(role.getDeleteState())&& enable.equals(role.getEnableState())&& verifyState.equals(role.getVerifyState())){
    						Set<ScAuth> roleAuths =role.getScAuths();
	    					if (roleAuths != null) {
	    						for(ScAuth auth_a:roleAuths){
	    							if(!userAuths.contains(auth_a)){
	    								userAuths.add(auth_a);
	    							}
	    						}
	    					}
    					}
    				
    				}
    			}
    			setSession("userAuths", userAuths);
    		
    			// 系统配置的权限
    			Set<ScAuth> sysAuths = new HashSet<ScAuth>();
    			//AuthService authService=new AuthServiceImpl();
    			List<ScAuth> sysAuthsList=authService.getAuthListAllUsed();
    			if(sysAuthsList!=null&&sysAuthsList.size()>0){
    				for(ScAuth auth:sysAuthsList){
    					sysAuths.add(auth);
    				}
    			}
    			setSession("sysAuths", sysAuths);
    			// 若为超级管理员，则拥有所有权限。
    			// 若为超级管理员，则拥有所有权限。
				Set<ScUsers> parentUsers = user.getScUsersesForParentUserId();
				if (parentUsers == null || parentUsers.size() < 1) {
					setSession("userAuths", sysAuths);
				}
				
				return "ssoLogin";
			} 
		}
		
		getDeptList();
		
		return "tologin";
	}
	
	
	public void getDeptList(){
		deptlist0 = new ArrayList();
		deptlist1 = new ArrayList();
		deptlist2 = new ArrayList();
		userlist0 = new ArrayList();
		userlist2 = new ArrayList();
		
		userlist = userService.getList();
		if(userlist != null && userlist.size() > 0){
			for(int i = 0; i < userlist.size(); i++){
				if(userlist.get(i) != null){
					ScUsers user = userlist.get(i);
					if(user.getUserType() != null && !"".equals(user.getUserType())){
						if("0".equals(user.getUserType())){
							//deptlist0 = getList(deptlist0, user.getScDept());
							userlist0.add(user);
						}else if("1".equals(user.getUserType()) && user.getScDept() != null){
							deptlist1 = getList(deptlist1, user.getScDept());
						}else if("2".equals(user.getUserType())){
							//deptlist2 = getList(deptlist2, user.getScDept());
							userlist2.add(user);
						}
					}
				}
			}
		}
	}
	
	//去重复
	public List getList(List list, ScDept dept){
		if(list != null && dept != null){
			boolean flag = true;
			for(int i = 0; i < list.size(); i++){
				if(list.get(i) != null){
					ScDept temp = (ScDept) list.get(i);
					if(temp.getDeptId().equals(dept.getDeptId())){
						flag = false;
					}
				}
			}
			
			if(flag){
				list.add(dept);
			}
		}
		
		return list;
	}
	
	public String getPost() throws Exception{
		StringBuffer dataStr = new StringBuffer();
		dataStr.append("[");
		userlist = userService.getList();
		if(userlist != null && userlist.size() > 0){
			for(int i = 0; i < userlist.size(); i++){
				if(userlist.get(i) != null){
					ScUsers user = userlist.get(i);
					if(user.getUserType() != null && !"".equals(user.getUserType()) && user.getScDept() != null){
						if(user.getUserType().equals(userType) && user.getScDept().getDeptId().equals(id)){
							dataStr.append("{\"userName\":\"");
							dataStr.append(user.getUserName());
							dataStr.append("\",\"userNickname\":\"");
							dataStr.append(user.getUserNickname());
							dataStr.append("\"}");
							dataStr.append(",");
						}
					}
				}
			}
		}
		
		if(dataStr.lastIndexOf(",") != -1){
			dataStr.delete(dataStr.length() - 1, dataStr.length());
		}
		
		dataStr.append("]");
		RequestUtil.getWriter().write(dataStr.toString());
		return null;
	}
	
	/**
	 * 用户登陆
	 * @return
	 */
	public String login(){
		
	    
		//session中存储的验证码信息
	    String rand01 = getSession().get("rand01").toString();
	    
	    //判断验证码信息
	    if(null!=number && !("").equals(number) && number.equals(rand01)){
	    	//根据用户名查询用户信息
	    	ScUsers user = userService.getUserByUsername(admin.getUserName());
	    	//存在该用户明的用户
	    	if(null != user){
	    		//密码验证通过
	    		if(user.getUserPwd().equals(admin.getUserPwd())){
	    			setSession("sysUser", user);
	    			
	    			LinkedHashMap<String, HttpSession> onlineUserMap = (LinkedHashMap<String, HttpSession>) getApplication().getAttribute("OnlineUserMap");
	    			onlineUserMap.put(user.getUserId(), getRequest().getSession());
	    			getApplication().setAttribute("OnlineUserMap", onlineUserMap);
	    			
	    			this.addActionMessage("登陆成功");
					return "success";
				//密码验证不通过
	    		}else {
	    			this.redirectUrl="/api/login_tologin.action";
			    	this.addActionMessage("密码有误");
					return "error";
				}
    		//用户不存在
	    	}else {
	    		this.redirectUrl="/api/login_tologin.action";
		    	this.addActionMessage("用户名不存在");
				return "error";
			}
    	//验证码未填写或油污
	    }else {
	    	this.redirectUrl="/api/login_tologin.action";
	    	this.addActionMessage("验证码有误");
			return "error";
		}

	}
	
	/**
	 * ajax 登陆
	 */
	public void ajaxLogin(){
		
		//session中存储的验证码信息
		String rand01 = getSession().get("rand01").toString();
		
		//默认验证结果
		String result = "4"; 
	    
		//userService.save(new ScUsers("2"));E10ADC3949BA59ABBE56E057F20F883E
		
	    if(null!=number && !("").equals(number) && number.equals(rand01)){
	    	//判断验证码信息
	    	//AttributePrincipal principal = (AttributePrincipal)RequestUtil.getRequest().getUserPrincipal();   
	    	//String username = admin.getUserName();
	    	//根据用户名查询用户信息
	    	ScUsers user = userService.getUserByUsername(userName);
	    	//存在该用户明的用户
	    	if(null != user){
	    		//密码验证通过
	    		if(user.getUserPwd().equals(MD5.createPassword(userPwd))){
	    			
	    			//最后登录时间
	    			user.setLoginDate(new Date()); 
	    			if(null != user.getLoginTimes()){
	    				//登录次数加1
	    				user.setLoginTimes(user.getLoginTimes()+1);
	    			}else {
	    				//登录次数加1
	    				user.setLoginTimes(Long.parseLong("10"));
					}
	    			//最后登录IP
	    			user.setLastLoginIp(Util.getRemortIP(getRequest()));
	    			userService.update(user);
	    			
	    			/******************判断用户类型 0--局领导 1--管理员 2--各区县*****/
	    			String userType = user.getUserType();
	    			if(userType!=null&&userType.length()>0){
	    				if("0".equals(userType)){
	    					ScDept dept = new ScDept();
	    					dept.setDeptId(Constants.PLANNING_DEPARTMENT);
	    					user.setScDept(dept);
	    				}
	    			}
	    			//用户信息放到session中
	    			setSession("sysUser", user);
	    			//判断用户是项目分类专员还是部门管理员   true-部门管理员    false-项目分类专员
	    			setSession("projecTypeManager", tprojectTypeManagerService.getManagerPurview(user));
	    			
	    			//yinxy 添加权限验证  start
	    			// 用户拥有的权限
	    			Set<ScAuth> userAuths = new HashSet<ScAuth>();
	    			//获取用户的所有角色
	    			Set<ScRole> userRoles = user.getScRoles();
	    			String nodelete=((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue();
	    			String enable=((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("enable").getValue();
	    			String verifyState=((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifypass").getValue();
	    			if (userRoles != null && userRoles.size() > 0) {
	    				for (ScRole role : userRoles) {
	    					//角色状态必须为正常可用的
	    					if(nodelete.equals(role.getDeleteState())&& enable.equals(role.getEnableState())&& verifyState.equals(role.getVerifyState())){
	    						Set<ScAuth> roleAuths =role.getScAuths();
		    					if (roleAuths != null) {
		    						for(ScAuth auth_a:roleAuths){
		    							if(!userAuths.contains(auth_a)){
		    								userAuths.add(auth_a);
		    							}
		    						}
		    					}
	    					}
	    				
	    				}
	    			}
	    			setSession("userAuths", userAuths);
	    		
	    			// 系统配置的权限
	    			Set<ScAuth> sysAuths = new HashSet<ScAuth>();
	    			//AuthService authService=new AuthServiceImpl();
	    			List<ScAuth> sysAuthsList=authService.getAuthListAllUsed();
	    			if(sysAuthsList!=null&&sysAuthsList.size()>0){
	    				for(ScAuth auth:sysAuthsList){
	    					sysAuths.add(auth);
	    				}
	    			}
	    			setSession("sysAuths", sysAuths);
	    			// 若为超级管理员，则拥有所有权限。
	    			// 若为超级管理员，则拥有所有权限。
					Set<ScUsers> parentUsers = user.getScUsersesForParentUserId();
					if (parentUsers == null || parentUsers.size() < 1) {
						setSession("userAuths", sysAuths);
					}
	    			//yinxy 添加权限验证  end
	    			
	    			//登陆成功
	    			result = "1";
	    		}else {
	    			//密码有误
			    	result = "2";
				}
	    	}else {
	    		//用户不存在
		    	result = "3";
			}
	    }else {
	    	//验证码有误
	    	result = "4";
		}
	    
	    this.ajax(result,"text/html");
	    
	}
	
	/**
	 * 用户登录成功后查询用户对应的权限信息,导航
	 * @return
	 */
	public String index(){
		//判断session中是否有用户信息
		if(null == getSession().get("sysUser")){
			//未登录返回页面
			this.redirectUrl=RequestUtil.getRequest().getContextPath()+"/api/login_tologin.action";
			//提示信息
	    	this.addActionMessage("你还未登陆，请登录后操作！");
			return ERROR;
		}else {
			//返回到登陆页面
			return "index";
		}
		
	}
	
	/**
	 * 用户登录成功后查询用户对应的权限信息,导航
	 * @return
	 */
	public String top(){
		//当前系统登录用户
		ScUsers user = (ScUsers)getSession().get("sysUser");
		//查询一级权限信息，用于后台页面导航栏部分
		rootAuthList = (List<ScAuth>) authService.getAuthByUser(user);
		
		return "top";
	}
	
	/**
	 * 用户登录成功后查询用户对应的权限信息,左侧树,模块
	 * @return
	 */
	public String main(){
		//判断session中是否有用户信息
		if(null == getSession().get("sysUser")){
			//未登录返回页面
			this.redirectUrl="/api/login_tologin.action";
			//提示信息
			this.addActionMessage("你还未登陆，请登录后操作！");
			return ERROR;
		}else {
			ScUsers user = (ScUsers)getSession().get("sysUser");
			
			// 快捷方式/下级权限，默认的登录成功后右面现实的信息
			authList = this.getAllList(user,authService.getAuths(user,authId),authId);
			
			return "main";
		}
	}
	
	/**
	 * 用户注销
	 * @return
	 * @throws Exception 
	 */
	public String destory(){
		if(getRequest().getSession()!=null){
			getRequest().getSession().invalidate();
		}
		//未登录返回页面
		//this.redirectUrl=back_url; 
		//提示信息
		//this.addActionMessage("登录退出！");
		//return SUCCESS;
		return "logout";
	}
	
	/**
	 * 封装所有子权限
	 * 
	 * @param authList
	 * @param jsonAuthList
	 * @return
	 */
	private JSONArray getAllList(ScUsers user,List<ScAuth> authList,String authId) {
		//页面打开方式(新窗口打开)
		String blank = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("OPENTYPE_STATE")).getValueByCode("blank");
		// 存放已封装的权限
		JSONArray jsonArray = new JSONArray();
		// 循环父级目录
		for (ScAuth auth : authList) {
			
			JSONObject childnode = new JSONObject();
			auth = authService.load(auth.getAuthId());
			// 树结构文件名称
			childnode.put("name", auth.getAuthName());
			// 树结构唯一标示
			childnode.put("id", auth.getAuthId());
			// 树结构父级ID
			if(null != auth.getScAuth()){
				childnode.put("pid", auth.getScAuth().getAuthId());
			}
			// 树结构权限链接
			childnode.put("gourl", auth.getAuthUrl());
			//childnode.put("gourl", "");
			// 树结构权限是否为父节点
			List<ScAuth> list = authService.getAuths(user,auth.getAuthId());
			childnode.put("isParent", list.size()>0?true:false);
			// 页面打开方式
			childnode.put("openType", auth.getOpentypeState().equals(blank)?true:false);
			
			jsonArray.add(childnode);
		}
		
		if(null == authList || authList.size()==0){
			JSONObject childnode = new JSONObject();
			if(null != authId && !"".equals(authId)){
				// 树结构文件名称
				childnode.put("name", "功能正在开发，敬请期待");
				// 树结构唯一标示
				childnode.put("id", "");
				// 树结构父级ID
				childnode.put("pid", "");
				// 树结构权限链接
				childnode.put("gourl", "");
				//childnode.put("gourl", "");
				// 树结构权限是否为父节点
				childnode.put("isParent", false);
				// 页面打开方式
				childnode.put("openType", false);
				jsonArray.add(childnode);
			}else {
				// 树结构文件名称
				childnode.put("name", "无快捷方式");
				// 树结构唯一标示
				childnode.put("id", "");
				// 树结构父级ID
				childnode.put("pid", "");
				// 树结构权限链接
				childnode.put("gourl", "");
				//childnode.put("gourl", "");
				// 树结构权限是否为父节点
				childnode.put("isParent", false);
				// 页面打开方式
				childnode.put("openType", false);
				jsonArray.add(childnode);
			}
		}
		
		return jsonArray;
	}
	
	/**
	 * ajax请求 获取所有子权限
	 * 
	 * @param authList
	 * @param jsonAuthList
	 * @return
	 */
	@SuppressWarnings("unused")
	public void getChildList() {
		
		//当前用户
		ScUsers user = (ScUsers)getSession().get("sysUser");
		
		if(null == user){
			this.ajax("1","text/html");
		}else {
			
			//页面打开方式(新窗口打开)
			String blank = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("OPENTYPE_STATE")).getValueByCode("blank");
			
			List<ScAuth> authList = authService.getAuths(user,authId);
			
			// 存放已封装的权限
			JSONArray jsonArray = new JSONArray();
			// 循环父级目录
			for (ScAuth auth : authList) {
				JSONObject childnode = new JSONObject();
				
				// 树结构文件名称
				childnode.put("name", auth.getAuthName());
				// 树结构唯一标示
				childnode.put("id", auth.getAuthId());
				// 树结构父级ID
				childnode.put("pid", auth.getScAuth().getAuthId());
				// 树结构权限链接
				childnode.put("gourl", auth.getAuthUrl());
				//childnode.put("gourl", "");
				// 树结构权限是否为父节点
				List<ScAuth> list = authService.getAuths(user,auth.getAuthId());
				childnode.put("isParent", list.size()>0?true:false);
				// 页面打开方式
				String aString = auth.getOpentypeState();
				childnode.put("openType", auth.getOpentypeState().equals(blank)?true:false);
				
				jsonArray.add(childnode);
			}
			
			this.ajax(jsonArray.toString(),"text/html");
		}
		
	}
	
	/**
	 * ajax请求 获取所有子权限
	 * 
	 * @param authList
	 * @param jsonAuthList
	 * @return
	 */
	@SuppressWarnings("unused")
	public void getUrlByCodeAndUser() {
		
		//当前用户
		ScUsers user = (ScUsers)getSession().get("sysUser");
		
		if(null == user){
			this.ajax("0","text/html");
		}else {
			
			String url = authService.getUrlByCodeAndUser(user, authid);
			
			this.ajax(null!=url?url:"0","text/html");
		}
		
	}
	
	/**
	 * ajax请求 判断是否登录
	 * 
	 * @param authList
	 * @param jsonAuthList
	 * @return
	 */
	@SuppressWarnings("unused")
	public void isLogin() {
		
		//当前用户
		ScUsers user = (ScUsers)getSession().get("sysUser");
		
		if(null == user){
			this.ajax("1","text/html");
		}else {
			this.ajax("0","text/html");
		}
		
	}

	public ScUsers getAdmin() {
		return admin;
	}

	public void setAdmin(ScUsers admin) {
		this.admin = admin;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public JSONArray getAuthList() {
		return authList;
	}

	public List<ScAuth> getRootAuthList() {
		return rootAuthList;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getBack_url() {
		return back_url;
	}

	public void setBack_url(String back_url) {
		this.back_url = back_url;
	}

	public String getAuthid() {
		return authid;
	}

	public void setAuthid(String authid) {
		this.authid = authid;
	}

	public List<ScDept> getDeptlist0() {
		return deptlist0;
	}

	public void setDeptlist0(List<ScDept> deptlist0) {
		this.deptlist0 = deptlist0;
	}

	public List<ScDept> getDeptlist1() {
		return deptlist1;
	}

	public void setDeptlist1(List<ScDept> deptlist1) {
		this.deptlist1 = deptlist1;
	}

	public List<ScDept> getDeptlist2() {
		return deptlist2;
	}

	public void setDeptlist2(List<ScDept> deptlist2) {
		this.deptlist2 = deptlist2;
	}
}

/**
 * 权限过滤器
 * @filename AuthFilter.java
 * @author yinxy
 * @date Jan 7, 2013
 * @vsersion 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */

package com.hopsun.scenter.api.util;

import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.hopsun.scenter.api.auth.service.AuthService;
import com.hopsun.scenter.api.login.action.LoginAction;
import com.hopsun.scenter.api.user.service.UserService;
import com.hopsun.scenter.entity.ScAuth;
import com.hopsun.scenter.entity.ScUsers;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("unchecked")
public class AuthFilter extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;
	// 用户服务接口类
	@Resource
	private UserService userService;
	// 权限服务接口类
	@Resource
	private AuthService authService;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// System.out.println("权限验证开始！");

		// 对LoginAction不做该项拦截
		 Object action = actionInvocation.getAction();
		 if (action instanceof LoginAction) {
			 return actionInvocation.invoke();
		 }
		// HttpServletRequest request = (HttpServletRequest)
		// actionInvocation.getInvocationContext().getApplication();
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		ActionContext actionContext = actionInvocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
		// 确认Session中是否存在sysUser
		ScUsers user = (ScUsers) session.get("sysUser");
		if (user == null) {
//			 AttributePrincipal principal = (AttributePrincipal)RequestUtil.getRequest().getUserPrincipal();
//			 String username = RequestUtil.getUserName();
//			//String username = "admin";
//
//			// UserService userService =new UserServiceImpl();
//			 //屏蔽权限过滤
//			user = userService.getUserByUsername(username);
//			if (user != null) {
//				user.setLoginDate(new Date()); // 最后登录时间
//				if (null != user.getLoginTimes()) {
//					user.setLoginTimes(user.getLoginTimes() + 1);// 登录次数加1
//				} else {
//					user.setLoginTimes(Long.parseLong("1"));// 登录次数加1
//				}
//				user.setLastLoginIp(Util.getRemortIP(request));// 最后登录IP
//				userService.update(user);
//
//				session.put("sysUser", user);// 用户信息放到session中
//				// yinxy 添加权限验证 start
//				// 用户拥有的权限
//				Set<ScAuth> userAuths = new HashSet<ScAuth>();
//				// 获取用户的所有角色
//				Set<ScRole> userRoles = user.getScRoles();
//				String nodelete = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue();
//				String enable = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("enable").getValue();
//				String verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifypass").getValue();
//				if (userRoles != null && userRoles.size() > 0) {
//					for (ScRole role : userRoles) {
//						// 角色状态必须为正常可用的
//						if (nodelete.equals(role.getDeleteState()) && enable.equals(role.getEnableState()) && verifyState.equals(role.getVerifyState())) {
//							Set<ScAuth> roleAuths = role.getScAuths();
//							if (roleAuths != null) {
//								for (ScAuth auth_a : roleAuths) {
//									if (!userAuths.contains(auth_a)) {
//										userAuths.add(auth_a);
//									}
//								}
//							}
//						}
//					}
//				}
//				session.put("userAuths", userAuths);
//
//				// 系统配置的权限
//				Set<ScAuth> sysAuths = new HashSet<ScAuth>();
//				// AuthService authService=new AuthServiceImpl();
//				List<ScAuth> sysAuthsList = authService.getAuthListAllUsed();
//				if (sysAuthsList != null && sysAuthsList.size() > 0) {
//					for (ScAuth auth : sysAuthsList) {
//						sysAuths.add(auth);
//					}
//				}
//				session.put("sysAuths", sysAuths);
//				// 若为超级管理员，则拥有所有权限。
//				Set<ScUsers> parentUsers = user.getScUsersesForParentUserId();
//				if (parentUsers == null || parentUsers.size() < 1) {
//					session.put("userAuths", sysAuths);
//				}
//				// yinxy 添加权限验证 end
//			}
			return actionInvocation.invoke();
		}
		//
		/*String a_rul = "";
		a_rul = request.getRequestURI();
		if (a_rul == null || "".equals(a_rul)) {
			return actionInvocation.invoke();
		}
		//
		if (user != null) {
			// 存在的情况下进行后续操作。

			// 用户拥有的权限
			Set<ScAuth> userAuths = (Set<ScAuth>) session.get("userAuths");

			// 系统配置的权限
			Set<ScAuth> sysAuths = (Set<ScAuth>) session.get("sysAuths");

			// 权限限制标记
			boolean flag_needcheck = false;
			boolean flag_cando = true;
			// 遍历系统权限
			for (ScAuth perSysAuth : sysAuths) {
				if (a_rul.equals(perSysAuth.getAuthUrl())) {
					// 若请求action属于系统权限，则进行验证
					flag_needcheck = true;
					flag_cando = false;
					break;
				}
			}
			if (flag_needcheck) {
				// 遍历用户拥有的权限
				for (ScAuth perUserAuth : userAuths) {
					if (a_rul.equals(perUserAuth.getAuthUrl())) {
						// 若用户拥有改权限，则可执行
						flag_cando = true;
						break;
					}
				}
			}
			if (flag_cando) {
				// 执行action
				return actionInvocation.invoke();
			} else {
				return "auth_fail";

			}

		} else {
			// 否则终止后续操作，返回LOGIN
			// return actionInvocation.invoke();
			return "auth_fail";
		}*/
		return actionInvocation.invoke();
	}
}

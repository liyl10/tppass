package com.hopsun.scenter.api.util;

import java.util.Map;

import com.hopsun.scenter.api.login.action.LoginAction;
import com.hopsun.scenter.entity.ScUsers;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @Comments:   用户登录状态监听器
 * @author dulei(dulei@hopsun.cn)
 * @date 2012-12-27 9:40:32
 * @version 1.0
 *
 */
@SuppressWarnings("unchecked")
public class LoginStateFiter extends AbstractInterceptor {

	private static final long serialVersionUID = 228531082082870449L;

	public static final String LOGIN_KEY = "sysUser";

    public static final String LOGIN_PAGE = "tologin";

 
    @Override
     public String intercept(ActionInvocation actionInvocation) throws Exception {

        //System.out.println("begin check login interceptor!");

        // 对LoginAction不做该项拦截

        Object action = actionInvocation.getAction();

        if (action instanceof LoginAction) {

            //System.out.println("exit check login, because this is login action.");

            return actionInvocation.invoke();

        }

        // 确认Session中是否存在LOGIN
        Map session = actionInvocation.getInvocationContext().getSession();
        
        ScUsers user = (ScUsers) session.get(LOGIN_KEY);

        if (user != null) {

            // 存在的情况下进行后续操作。

            //System.out.println("already login!");

            return actionInvocation.invoke();

        } else {

            // 否则终止后续操作，返回LOGIN

            //System.out.println("no login, forward login page!");
        	
            return LOGIN_PAGE;

        }

     }

}
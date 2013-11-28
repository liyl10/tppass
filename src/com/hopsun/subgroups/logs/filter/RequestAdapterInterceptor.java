/**
 * @filename GetContent.java
 * @author zzze
 * @date Dec 25, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.logs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hopsun.subgroups.logs.util.RequestUtil;

/**
 *@comment 拦截器封装请求的Request和Response
 *@author zzze
 *@date Dec 26, 2012
 *@version 1.0
 */
public class RequestAdapterInterceptor implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(final ServletRequest request, final ServletResponse response,
			final FilterChain chain) throws IOException, ServletException {
		//封装Request
        RequestUtil.setRequest((HttpServletRequest) request);
        //封装Response
        RequestUtil.setResponse((HttpServletResponse) response);  
        
        chain.doFilter(request, response);  
		
	}

	public void init(final FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}  
}  

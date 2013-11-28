/**
 * @filename RequestUtil.java
 * @author zzze
 * @date Dec 25, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.logs.util;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hopsun.framework.util.Util;

/**
 * @comment SpringAOP中获取Request和Response的工具类
 * @author zzze
 * @date Dec 26, 2012
 * @version 1.0
 */
public final class RequestUtil {
	private static ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal<HttpServletRequest>();
	private static ThreadLocal<HttpServletResponse> responseLocal = new ThreadLocal<HttpServletResponse>();

	private static RequestUtil requestSingleton;

	private RequestUtil() {
	}

	public static RequestUtil getInstance() {
		if (Util.checkNull(requestSingleton)) {
			requestSingleton = new RequestUtil();
		}
		return requestSingleton;
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) requestLocal.get();
	}

	public static void setRequest(final HttpServletRequest request) {
		requestLocal.set(request);
	}

	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) responseLocal.get();
	}

	public static void setResponse(final HttpServletResponse response) {
		responseLocal.set(response);
	}

	public static HttpSession getSession() {
		return (HttpSession) ((HttpServletRequest) requestLocal.get())
				.getSession();
	}

	/**
	 * @comment 获取request中的用户名
	 * @param
	 * @param
	 * @Vsersion: 1.0
	 * @date Jan 17, 2013 8:47:00 AM
	 */
	public static String getUserName() {
		try
		{
			final HttpServletRequest httpRequest = ((HttpServletRequest) requestLocal
					.get());
			return Util.checkNotNull((Map<String, Object>) httpRequest.getSession()
					.getAttribute("userMap"))
					&& Util.checkNotNull(((Map<String, Object>) httpRequest
							.getSession().getAttribute("userMap")).get("userName")) ? ((Map<String, Object>) httpRequest
					.getSession().getAttribute("userMap")).get("userName")
					.toString() : null;
		}catch(Exception ex)
		{
			return "系统发送";
		}
		
	}

	/**
	 * 
	  * 方法描述：获取后台Session值
	  * @param map
	  * @param key
	  * @return
	  * @return: String
	  * @version: 1.0
	  * @author: 王涛
	 */
	public static String getValue(String map, String key) {
		final HttpServletRequest httpRequest = ((HttpServletRequest) requestLocal
				.get());
		return Util.checkNotNull((Map<String, Object>) httpRequest.getSession()
				.getAttribute(map))
				&& Util.checkNotNull(((Map<String, Object>) httpRequest
						.getSession().getAttribute(map)).get(key)) ? ((Map<String, Object>) httpRequest
				.getSession().getAttribute(map)).get(key)
				.toString() : null;
	}
	 public static Writer getWriter() throws IOException{
	    	HttpServletResponse response = (HttpServletResponse)responseLocal.get();
			response.setContentType("text/plain");
			return response.getWriter();
	    }
}
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	if(null == request.getAttribute("sysUser")){
		response.sendRedirect("${pageContext.request.contextPath}/api/login_index.action");
	}
%>
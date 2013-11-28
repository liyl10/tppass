<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 管理中心后台页面
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
 -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" />
		<title>管理中心系统</title>
	</head>
	<frameset rows="72,*" frameborder="0" border="0" framespacing="0">
		<frame src="${pageContext.request.contextPath}/api/login_top.action" name="topFrame" noresize="noresize" id="topFrame" scrolling="no">
		<frame src="${pageContext.request.contextPath}/api_scenter/login/main.jsp" name="mainFrame" id="mainFrame" />
	</frameset>
	<noframes><body></body></noframes>
</html>
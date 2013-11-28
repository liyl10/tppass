<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 管理中心下部页面
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
 -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>main 下部页面</title>
	</head>
	<frameset cols="227,8,*" frameborder="0" border="0" framespacing="0">
		<frame src="${pageContext.request.contextPath}/api/login_main.action" name="leftFrame" id="leftFrame" noresize="noresize"  />
		<frame src="${pageContext.request.contextPath}/api_scenter/login/arrow.jsp" name="arrowFrame" id="arrowFrame" noresize="noresize"  />
		<frame src="${pageContext.request.contextPath}/api_scenter/login/right.jsp" name="frame_content" id="frame_content"  />
	</frameset>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 管理中心登录页
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
 -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>管理中心登录页</title>
		<link href="${pageContext.request.contextPath}/api_scenter/css/style.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/api_scenter/js/jquery-1.4.4.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/public.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/login/js/login1.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="xdzinfo_login">
			<form name="loginForm" id="loginForm" method="post" action="" class="reg">
				<div class="add">
					<li><span>用户名</span>
						<input id="userName" name="admin.userName" type="text" class="input" value=""/>
					</li>
					<li><span>密　码</span>
						<input id="userPwd" name="admin.userPwd" type="password" class="input" value=""/>
					</li>
					 <li>
						验证码
						<input name="number" type="text" id="number" class="input" />
						<img id="vdimgck" src="${pageContext.request.contextPath}/api_scenter/login/image.jsp?d="+new Date()+"" alt="看不清？点击更换" style="cursor: pointer" onclick="this.src=this.src+'?'" class="img" />
					</li>
					<li style="text-align: center;">
						<input type="button" name="Submit" id="Submit" value="登 录" class="btn" style="cursor:pointer;" />
					</li>
				</div>
			</form>
		</div>
	</body>
</html>
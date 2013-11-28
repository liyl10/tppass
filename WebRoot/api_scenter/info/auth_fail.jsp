<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>提示信息 - framework </title>
<meta name="Author" content="framework" />
<meta name="Copyright" content="framework" />
<link href="${pageContext.request.contextPath}/api_scenter/css/base/css/base.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/api_scenter/js/jquery-1.4.4.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/api_scenter/css/base/js/base.js" type="text/javascript"></script>
<script type="text/javascript">
	function logout(){
			$("#form_top_a").attr("action","${pageContext.request.contextPath}/api/login_destory.action");
			$("#form_top_a").submit();
		}
$().ready( function() {
	var url = "${redirectUrl}";
	function redirectUrl() {
		//history.go(-1);
		if(window.parent.frame_content){
			window.parent.frame_content.history.back();
		}else{
		  window.location.href= "http://localhost:8080/admin/logout?service=http://localhost:8080/admin/login";
		  //logout();
		}
	}
	if(window.parent.frame_content){
		var content = "操作失败，登录失效，或权限不足!";
		}else{
		var content = "用户不可用或权限不足! 如果不能登录，请联系上级管理员！";
	}
	 
	$.dialog({type: "error", title: "操作提示", content: ""+content, ok: "确定", okCallback: redirectUrl, cancelCallback: redirectUrl, width: 380, modal: true});

});
</script>
</head>
<body class="error" >
	<form name="form_top_a" id="form_top_a" action="" >
	 	<input id="back_url" name="back_url" type="hidden" value="http://localhost:8080/admin/logout?service=http://localhost:8080/scenter" />
	</form>
</body>
</html>
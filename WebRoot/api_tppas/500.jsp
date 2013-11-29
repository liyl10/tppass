<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>500 Server Error
</title>
<link href="${pageContext.request.contextPath}/favicon.ico"  type="image/x-icon"  rel=icon></link>
<link href="${pageContext.request.contextPath}/favicon.ico"  type="image/x-icon"  rel="shortcut icon"></link>

<style type="text/css">
<!--
.t {
        font-family: Verdana, Arial, Helvetica, sans-serif;
        color: #CC0000;
}
.c {
        font-family: Verdana, Arial, Helvetica, sans-serif;
        font-size: 14px;
        font-weight: normal;
        color: #000000;
        line-height: 18px;
        text-align: center;
        border: 1px solid #CCCCCC;
        background-color: #FFFFEC;
        
}
body {
        background-color: #FFFFFF;
        margin-top: 100px;
}

-->
</style>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_xapdpms/css/btn.css" />
<script type="text/javascript">
	function login(){
		parent.parent.location.href="${pageContext.request.contextPath}/api/login_tologin.action";
	}
</script>
</head>
<body>
<div align="center">
  <h2><span class="t">500 Server Error</span></h2>
  <table border="0" cellpadding="8" cellspacing="0" width="460">
    <tbody>
      <tr>
        <td class="c"><br>服务器内部发生未知错误，<br><br>请稍后重试或者联络系统管理员！<br></td>
      </tr>
    </tbody>
  </table>
  <br><br>
  <div><a class="button" href="javascript: void(0);" onclick="login();">登录</a></div>
</div>
</body>
</html>
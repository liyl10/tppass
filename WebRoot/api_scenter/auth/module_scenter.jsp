<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 管理中心默认的右部页面
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
 -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>右边</title>
<link href="${pageContext.request.contextPath}/api_scenter/css/global.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- 面包屑 start -->
<div class="box-positon">
	<div class="rpos">
		当前位置&nbsp;>&nbsp;后台管理中心
	</div>
	<form class="ropt"></form>
	<div class="clear"></div>
</div>
<!-- 面包屑 end -->
<!-- 大市场管理中心 start -->
<table width="100%" border="0" cellspacing="1" cellpadding="0" class="show_table">
  <tr>
    <th>欢迎进入管理中心</th>
  </tr>
  <tr>
    <td class="tips">
		安全提示：<br />
		1、如果您尚未重新设置密码，强烈建议您在 用户管理 > 个人资料修改 下重新设置密码，充分保护您的信息安全。<br />
		2、建议您定期的修改自己的密码，密码最好方便您的记忆，字母和数字混合搭配安全性更高。<br />
		系统说明：<br />
		您当前使用的权限管理系统，程序版本为测试版，因为程序正在完善中，所以可能会有一些BUG，如果影响了您的正常使用，在此我们深表歉意，同时欢迎各位领导和朋友提出宝贵意见，我们一定完善。 
	</td>
  </tr>
</table>
<!-- 大市场管理中心 end -->
<!-- 个人信息 start -->
<table width="100%" border="0" cellspacing="1" cellpadding="0" class="show_table">
  <tr>
    <th colspan="2">个人信息</th>
  </tr>
  <tr>
  	<td class="left">用户名</td>
	<td>${sysUser.userName}</td>
  </tr>
  <tr>
  	<td class="left">级别</td>
	<td>创始人</td>
  </tr>
  <tr>  
  	<td class="left">上次登录时间</td>
	<td><fmt:formatDate value="${sysUser.loginDate}" type="both" pattern="yyyy-MM-dd " /></td>
  </tr>
  <tr>
  	<td class="left">上次登录IP</td>
	<td>${sysUser.lastLoginIp}</td>
  </tr>
</table>
<!-- 个人信息 end -->
</body>
</html>

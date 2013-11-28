<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 伸缩按钮页面
@author app_2006@163.com
@date 2013-01-10
@version 1.0
 -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>伸缩按钮页面</title>
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/api_scenter/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/api_scenter/js/jquery-1.4.4.min.js" type="text/javascript"></script>
		<script language="javascript" type="text/javascript">     
			$(document).ready(function(){
				 //jquery start	 
				  $("#button_arrow_left").toggle( 
						function () { 
						$(this).attr("class","button_arrow_left_go_right");
						$(window.parent.document).find("frameset").attr("cols","0,8,*");
						}, 
						function () { 
						$(this).attr("class","button_arrow_left_go_left");
						$(window.parent.document).find("frameset").attr("cols","227,8,*");
						}
				 );
				 //jquery end						   
		 	}); 
		</script>
		<style type="text/css">
			<!--
			body {
				margin-left: 0px;
				margin-top: 0px;
				bgcolor="#E0F7BB";
				 
			}
			.button_arrow_left_go_left{
	right:0px;
	top:auto;
	width:10px;
	height:100%;
	z-index:50;
	position:fixed;
	border:#B9D4E9 1px solid;
	background-attachment: fixed;
	background-image: url(${pageContext.request.contextPath}/api_scenter/login/images/ss_left_bg.jpg);
	background-repeat: no-repeat;
	background-position: center center;
				}
		.button_arrow_left_go_right{
	right:0px;
	top:auto;
	width:10px;
	height:100%;
	z-index:50;
	position:fixed;
	border:#B9D4E9 1px solid;
	background-attachment: fixed;
	background-image: url(${pageContext.request.contextPath}/api_scenter/login/images/ss_right_bg.jpg);
	background-repeat: no-repeat;
	background-position: center center;
				}	
			-->
		</style>
	</head>
	<body>
		<div id="button_arrow_left" class="button_arrow_left_go_left"></div> 
	</body>
</html>
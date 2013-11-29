<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title>操作提示信息</title>
	<script src="${pageContext.request.contextPath}/resource/js/jquery-1.4.4.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resource/js/boxy.js" type="text/javascript"></script>
	<style>
		.background {
				position: fixed;
				_position: absolute;
				z-index: 998;
				top: 0px;
				left: 0px;
				width: 100%;
				_width: expression(document . documentElement . clientWidth);
				height: 100%;
				_height: expression(document . documentElement . clientHeight);
				background: rgb(50, 50, 50);
				background: rgba(0, 0, 0, 0.5);
			}
			
			.webox {
				width: 400px;
				height:200px;
				position: fixed;
				_position: absolute;
				z-index: 999;
				border: solid 1px #ccc;
				font-size:12px; line-height: 24px;
			}
			
			.webox #inside {
				background-color: #FFFFFF;
				
			}
			
			.webox #inside h1 {
				border-bottom: solid 1px #e5e5e5;
				-moz-user-select: none;
				-webkit-user-select: none;
				position: relative;
				display: block;
				margin: 0;
				padding: 0;
				font-size: 14px;
				line-height: 30px;
				height: 30px;
				padding-left: 5px;
				font-family: Arial;
				background: #f7f7f7;
				font-weight: normal;
				cursor: move;
				font-weight:bold;
				color: #666;
			}
			
			.webox #inside h1 a {
				position: absolute;
				display: block;
				right: 6px;
				margin-top: 6px;
				top: 0px;
				font-size: 14px;
				background-image: url(${pageContext.request.contextPath}/resource/images/admin/close.png);
				background-repeat: no-repeat;
				background-position: center top;
				width: 17px;
				height: 17px;
				cursor: pointer;
				display: inline-block;
			}
			
			.webox #inside h1 a:hover {
				background-position: center bottom
			}
			.mainlist{ padding:10px 10px; font-size:12px; line-height: 24px; color: #666; text-align: center;}
			.mainlist a {color: #666;}
			.mainlist a:hover {color: #FF6600;}
			.mainlist .btn-box{ width:100%; text-align: center; margin-top: 5px;}
			.mainlist .btn-ececec{ background: #ececec; border: solid 1px #c3c3c3; padding:5px 5px; cursor: pointer; width:60px; height:25px;}
			.mainlist h2 {font-size:18px;color:#FF0000;height:20px;}
	</style>
	<script type="text/javascript">
		$(function(){
			
			var message = "${actionMessages}";
			message = message.substring(1,message.length-1);
			$("#message").html(message);
			//内嵌弹出层调用
			$.webox({
				height:200,
				width:400,
				bgvisibel:true,
				title:'信息提示',
				html:$("#box").html()
			});
			
		})
	</script>
	</head>
	<body>
		<div id="box" style="display: none;">
			<div class="mainlist">
			    <h2>操作失败</h2>
			    <div style="width:360px;height:70px;margin-left:auto;margin-right:auto;overflow:auto;text-align: left;line-height:18px;" id="message"></div>
				<div class="btn-box">
				<c:choose> 		
			<c:when test="${!empty (redirectUrl)}">
		 		<input type="button" value="返回"  onclick="window.location.href='${redirectUrl}';"  class="btn-ececec" />
			</c:when>	
			<c:otherwise>
				<input type="button" value="返回" onclick="javascript:history.go(-1);"  class="btn-ececec" />
			</c:otherwise> 
			</c:choose>
				</div>
			</div>
		</div>
	</body>
</html>
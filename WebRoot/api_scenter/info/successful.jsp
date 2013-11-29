<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta http-equiv="refresh" content="3; url=${redirectUrl}" />
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
			.mainlist{ padding:30px 20px; font-size:12px; line-height: 24px; color: #666; text-align: center;}
			.mainlist a {color: #666;}
			.mainlist a:hover {color: #FF6600;}
			.mainlist .btn-box{ width:100%; text-align: center; margin-top: 20px;}
			.mainlist .btn-ececec{ background: #ececec; border: solid 1px #c3c3c3; padding:3px 10px; cursor: pointer;}
			.mainlist h2 {font-size:18px;color:#FF0000;}
	</style>
	<script type="text/javascript">
		$(function(){
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
			    <h2>操作成功</h2>
				<a href="${redirectUrl}">3秒后自动跳转，如果您的浏览器没有跳转，请点击此链接！</a>
				<div class="btn-box"><input type="button" value="确定" onclick="window.location.href='${redirectUrl}';" class="btn-ececec" /></div>
			</div>
		</div>
	</body>
</html>
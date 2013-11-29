<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>科技计划项目申报系统</title>
<link href="${pageContext.request.contextPath}/favicon.ico"  type="image/x-icon"  rel=icon></link>
<link href="${pageContext.request.contextPath}/favicon.ico"  type="image/x-icon"  rel="shortcut icon"></link>
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/style.css">
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/install_upms.js?ver=1.0.0"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery.msgbox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/chosen.jquery.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/chosen.css" />
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/btn.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/highTech/js/report_menu.js"></script>
<script type="text/javascript">

javascript:window.history.forward(1); 
	function findDimensions(){
		var height = $(window).height() - 165;
		if (height >= 0) {
			$("#mainContent").css("height", height);
		}
	}
	window.onresize=findDimensions;
	
		$(function() {
			$(document).ready(function() {
				upms.installWebObj($("#mainContent"));
				//upms.WEBMAIN.initMenu(wardUrl);
				upms.installOverLay({// 安装ajax遮罩
					type : "font",
					opacity : 1.2,
					fontcss : {
						color : "blue"
					}
				});
								
				var height = $(window).height() - 165;
				if (height >= 0) {
					$("#mainContent").css("height", height);
				}
				
			});
		});	
</script>
</head>
<body>
	<!-- 项目根目录 -->
	<label id="path" style="display: none">${pageContext.request.contextPath}</label>
	<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
	<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
	<div id="container">
		<div class="header">
			<div class="topbg"></div>
			<div class="nav">
				<ul>
				</ul>
			</div>
		</div>
		<br class="clearfloat" />
		<div id="mainContent" style="background: none repeat scroll 0 0 #FFFFFF;">
			<div class="leftNav">
				<div id=accordion class="accordion">
					<dl class="acc_nav">
						<dt id="subleftmenu" class="jingyin mainNav">项目申报步骤</dt>
							<s:if test="menuList.size > 0">
								<s:iterator value="menuList" status="rowData">
									<dd class="subNav" id="subNav<s:property value='%{#rowData.count}' escape='true'/>">
										<a href="javascript: void(0);"
											onclick="showDetail('${projectId}','${applyStatus}','${itemDesc}')"><s:property value='%{itemName}' escape='true'/></a>
									</dd>
								</s:iterator>
							</s:if>
					</dl>
				</div>
			</div>
			<div id="content"></div>
		</div>
		<br class="clearfloat" />
		<div class="bottom">
			<p>© 西安市科技局</p>
		</div>
	</div>
</body>
</html>
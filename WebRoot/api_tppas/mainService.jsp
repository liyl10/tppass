<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/style.css">
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/install_upms.js?ver=1.0.0"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery.msgbox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/chosen.jquery.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/chosen.css" />
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/btn.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/artDialog/artDialog.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/artDialog/plugins/iframeTools.source.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/js/artDialog/skins/blue.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/server_tppas/js/jquery.watermark.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/highcharts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/comm.js"></script>
<script type="text/javascript">
  	function findDimensions(){
		var height = $(window).height()-5;
		if (height >= 0) {
			$("#mainContent").css("height", height);
		}
	}
 	window.onresize=findDimensions;
		$(function() {
	
			$(document).ready(function() {
				$(".nav li:first").addClass("active").siblings("li").removeClass("active");
	 			var x = $(".nav").find("li");
	
				x.bind("click", function() {
					if ($(this).hasClass("active")) {
						return;
					} else {
						$(this).addClass("active").siblings("li").removeClass("active");
					}
				}); 
				
				upms.installWebObj($("#mainContent"));
				//upms.WEBMAIN.initLayout();
				//upms.WEBLANG.initLang($(".language"));a action="${pageContext.request.contextPath}/api/superadmin/mitem!init.action"
				upms.WEBMAIN.initMenu("${pageContext.request.contextPath}" + '${actionName}');
				upms.installOverLay({// 安装ajax遮罩
					type : "font",
					opacity : 1.2,
					fontcss : {
						color : "blue"
					}
				});	

 				var height = $(window).height()-5;
 				if (height >= 0) {
					$("#mainContent").css("height", height);
				} 
				
				//用于循环调用服务器.aspx文件的JavaScript函数;
			    //keepSessionAlive();	
			});
		});
		
	   function keepSessionAlive()
		  {
		        //document.all["KeepSessionAliveScriptBlock"].src = "/BJAssess/YearAssessSubSystem/Resource/WebForm3.aspx?RandStr="+Math.random();
		        var actionUrl="<%=request.getContextPath()%>/service/login!testKeeplive.action?RandStr="+ Math.random();
			//这里的RandStr=Math.random只是为了让每次back.src的值不同，防止同一地址刷新无效的情况
			$.ajax({
				type : 'POST',
				url : actionUrl,
				data : null
			});
			window.setTimeout("keepSessionAlive()", 300000);
		}
</script>
</head>

<body>
<label id="path" style="display: none;">${pageContext.request.contextPath}</label>
<%-- 	<div id="container">
		<div class="header">
			<div class="topbg">
			</div>
			<div class="nav">
				<ul>
					<li id="mainlevel_01">
						<a action="report_company_list.html" href="javascript: void(0);">
							项目申报管理
						</a>
					</li>
					<li id="mainlevel_02">
						<a action="contract_Data.html" href="javascript: void(0);">
							合同签订管理
						</a>
						</li>
						<li id="mainlevel_03">
						<a action="supervisor_prolist.html" href="javascript: void(0);">
							项目监理管理
						</a>
					</li>
					<li id="mainlevel_04">
						<a action="supervisor_list.html" href="javascript: void(0);">
							监理管理
						</a>
					</li>
					<li id="mainlevel_05">
						<a action="acceptance_Data.html" href="javascript: void(0);">
							项目验收管理
						</a>
					</li>
<!-- 					<tag:auth code="ss.main.typeInit"> -->
					<li id="mainlevel_06">
						<a action="${pageContext.request.contextPath}/api/superadmin/mitem!init.action" href="javascript: void(0);">
							基础数据配置
						</a>
					</li>
<!-- 					</tag:auth> -->
					<li id="mainlevel_08">
						<a action="${pageContext.request.contextPath}/api/statistic/tprojectApplicationApi!init.action" href="javascript: void(0);">
							统计页面
						</a>
					</li>
					<li style="float:right; background:url('<%=request.getContextPath()%>/api_xapdpms/images/logout.png') no-repeat 2px 9px; width:80px; height:28px; line-height:28px;
					padding-top:3px; color: #ffffff; font-weight: bold;  ">
					    <a
						href="#">注销
						</a>
					</li>							
				</ul>
			</div>
		</div> --%>
		<div id="mainContent" style="background: none repeat scroll 0 0 #FFFFFF;"></div>
</body>
</html>
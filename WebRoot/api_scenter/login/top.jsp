<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/api_scenter/public/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 管理中心顶部页面
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
 -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Administrator's Control Panel</title>
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/api_scenter/login/css/index.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/api_scenter/js/jquery-1.4.4.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/RegExp.js" type="text/javascript"></script>
	</head>
<script language="javascript" type="text/javascript">
	
	function HoverLi(obj,id,r_url){
		$.get("${pageContext.request.contextPath}/api/login_isLogin.action",{ deptid: "" },
		 function(data){
			if(data == "0"){
				$('.current').removeClass('current').addClass('normal');
				$(obj).removeClass('normal').addClass('current');
				var url = "${pageContext.request.contextPath}/api/login_main.action?authId="+id;
				window.parent.mainFrame.leftFrame.location.href = url;
			}else{
				window.parent.parent.location.href = window.parent.parent.location.href;
			}
 		});
 		//加载右边页面
 		if(r_url!=''){
 			window.parent.mainFrame.frame_content.location.href = "${pageContext.request.contextPath}"+r_url;
 		}
	}
	
	function logout(){
		if (confirm("您确定退出吗？")) {
			$("#form_top_a").attr("action","${pageContext.request.contextPath}/api/login_destory.action");
			$("#form_top_a").attr("target","frame_content");
			$("#form_top_a").submit();
			 
		}
	}
</script>
	<body style="height:50px;">
		<div id="top">
			<div class="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="215">
							<div class="logo">
								<img src="${pageContext.request.contextPath}/api_scenter/login/images/logo.png" width="215" height="69" />
							</div>
						</td>
						<td valign="top">
							<div class="topbg">
								<div class="login-welcome">
									<form name="form_top_a" id="form_top_a" action="" >
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="420" height="38">
												<img src="${pageContext.request.contextPath}/api_scenter/login/images/welconlogin-icon.png" />
												<span id="welcome">您好, ${sysUser.userName }</span>
												<img src="${pageContext.request.contextPath}/api_scenter/login/images/loginout-icon.png" />
												<input id="back_url" name="back_url" type="hidden" value="${pageContext.request.contextPath}/api/login_tologin.action" />
												<a href="javascript:void(0);" target="_parent" id="logout" onclick="logout();">退出</a>
											</td>
										</tr>
									</table>
									</form>
								</div>
								<div class="nav">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td style="background-image: url('${pageContext.request.contextPath}/api_scenter/login/images/nav-left.png')" width="14" height="31"></td>
											<td>
												<ul class="nav-menu">
													<c:if test="${!empty (rootAuthList)}">
													<li class="current" id="tb_11" onclick="HoverLi(this,'','/api_scenter/login/right.jsp');">
														<a href="javascript:void(0);" target="leftFrame">快捷方式</a>
													</li>
													</c:if>
													<c:forEach items="${rootAuthList}" var="auth" varStatus="status">
														<li class="sep"></li>
														<li class="normal" id="tb_1${status.index+2}" onclick="HoverLi(this,'${auth.authId }','${auth.authUrl}');">
															<a href="javascript:void(0);" target="leftFrame">${auth.authName }</a>
														</li>
													</c:forEach>
												</ul>
											</td>
										</tr>
									</table>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="top-bottom"></div>
	</body>
</html>
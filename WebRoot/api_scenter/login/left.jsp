<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 左边菜单页面
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
 -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>left 左边菜单页面</title>
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/api_scenter/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/api_scenter/js/jquery-1.4.4.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/jquery.ztree.core-3.0.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/jquery.ztree.excheck-3.0.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript">     
	$(document).ready(function(){
		
		<c:if test="${!empty authList}"> 
		var zNodes = ${authList};
		</c:if>
		<c:if test="${empty authList}"> 
		var zNodes = [{id:"0",name:"无快捷方式"}];
		</c:if>
		 
		//初始化树
		$.fn.zTree.init($("#tree"), setting, zNodes);   
	});
</script>
	</head>
	<body class="lbody" style="overflow-x:hidden;overflow-y:auto">
		<div class="left">
			<div class="date">
				<span>现在时间： <script src="${pageContext.request.contextPath}/api_scenter/login/js/left.js" type="text/javascript"></script> </span>
			</div>
		</div>
		<ul id="tree" class="ztree"></ul>
		<input type="hidden" name="path" id="path" value="${pageContext.request.contextPath}" />
	</body>
</html>
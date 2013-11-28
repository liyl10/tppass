<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title></title>
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/api_scenter/js/jquery-1.4.4.min.js" type="text/javascript"></script>
		<script language="javascript" type="text/javascript">
		 $(document).ready(function(){
		 //jquery star
		 	window.parent.parent.location.href ="${back_url}";
		 //jquery end						   
 		});
		</script>
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 退出登录
			</div>
			 
			<div class="clear"></div>
		</div>
		<div class="body-box">
		</div>
	</body>
</html>
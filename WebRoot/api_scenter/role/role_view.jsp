<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title></title>
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/api_scenter/css/jquerythemes/ui-lightness/ui.all.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/api_scenter/js/jquery-1.4.4.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/api_scenter/js/RegExp.js" type="text/javascript" ></script>
	
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 角色信息 - 详情
			</div>
			 
			<div class="clear"></div>
		</div>
		<div class="body-box">
			<form method="post" action="" id="" name="">
				<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
					<tr>
						<td class="pn-flabel pn-flabel-h">角色名称:</td>
						<td class="pn-fcontent">
							${pro_result.objinfo.roleName}
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							角色描述:</td>
						<td class="pn-fcontent">
                            <s:property value="pro_result.objinfo.roleDesc" escape="true" />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h"> 是否启用:</td>
						<td class="pn-fcontent">
						 <c:forEach items="${enable_state_config.childList}" var="enable">
						 	${(enable.value ==pro_result.objinfo.enableState)?enable.desc:""} 
						 </c:forEach>
						 </td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h"> 排序:</td>
						<td class="pn-fcontent"> ${pro_result.objinfo.roleOrder} </td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">审核状态:</td>
						<td class="pn-fcontent">
						<c:choose> 		
						<c:when test="${pro_result.objinfo.verifyState == verifypass}">审核通过</c:when>	
						<c:when test="${pro_result.objinfo.verifyState == verifyrefuse}">审核不通过</c:when>	
						<c:otherwise>未审核</c:otherwise> 
						</c:choose>
						 </td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">审核备注:</td>
						<td class="pn-fcontent">
						<s:property value="pro_result.objinfo.verifyNote" escape="true" />
						</td>
					</tr>
					
					<tr>
						<td colspan="2" class="pn-fbutton">		 
							<input type="button" value="返回" onclick="javascript:history.go(-1)" class="reject" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="dialog">
			<div id="dialog_content"></div>
		</div>
	</body>
</html>
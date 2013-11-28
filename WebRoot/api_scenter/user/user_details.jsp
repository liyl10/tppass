<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 用户信息查看页面
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
 -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>用户信息 - 详情</title>
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/api_scenter/user/css/user.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/api_scenter/js/jquery-1.4.4.min.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 用户信息 - 详情
			</div>
			 
			<div class="clear"></div>
		</div>
		<div class="body-box">
			<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
				<tr>
					<td class="pn-flabel pn-flabel-h" >
						用户名:
					</td>
					<td class="pn-fcontent" >
						${admin.userName}
					</td>
					<td class="pn-flabel pn-flabel-h" >
						真实姓名:
					</td>
					<td class="pn-fcontent" >
						${admin.userRealname }
					</td>
				</tr>
				<tr>
					<td class="pn-flabel pn-flabel-h" >
						上级管理员:
					</td>
					<td class="pn-fcontent" >
						<c:if test="${!empty (admin.scUsersesForParentUserId)}">
							<c:forEach items="${admin.scUsersesForParentUserId}" var="parent">
							${parent.userName }
							</c:forEach>
						</c:if>
					</td>
					<td class="pn-flabel pn-flabel-h" >
						所属部门:
					</td>
					<td class="pn-fcontent" >
						${admin.scDept.deptName }
					</td>
				</tr>
				<tr>
					<td class="pn-flabel pn-flabel-h">
						角色:
					</td>
					<td class="pn-fcontent">
						${admin.userNickname }
					</td>
					<td class="pn-flabel pn-flabel-h">性别:
				  </td>
					<td class="pn-fcontent">
						 <c:forEach items="${agent.childList }" var="sex">
						<c:if test="${sex.value == admin.userAgent}">${sex.desc }</c:if>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td class="pn-flabel pn-flabel-h">
						联系电话:
					</td>
					<td class="pn-fcontent">
						${admin.userPhone }
					</td>
					<td class="pn-flabel pn-flabel-h">
						电子邮箱:
					</td>
					<td class="pn-fcontent">
						${admin.userEmail }
					</td>
				</tr>
				<tr>
					<td class="pn-flabel pn-flabel-h">
						启用状态:
					</td>
					<td class="pn-fcontent" colspan="3" >
						<c:forEach items="${bean.childList }" var="state">
						<c:if test="${state.value == admin.enableState}">${state.desc }</c:if>
						</c:forEach>
					</td>					 					 
				</tr>
				<tr>
					<td class="pn-flabel pn-flabel-h" >
						用户角色:
					</td>
					<td class="pn-fcontent" colspan="3" >
						 <div class="sel_role">
						<c:forEach items="${roleList}" var="role">
						<c:if test="${role.selected=='true'}">
							<div class='per_role_view'>${role.role.roleName}</div>
						</c:if>
						</c:forEach>
						</div>
					</td>
				</tr>
				<tr>
					<td class="pn-flabel pn-flabel-h">
						用户分类:
					</td>
					<td class="pn-fcontent" colspan="3">
					 	<c:forEach items="${usertype.childList}" var="usertype">
					 		<c:if test="${usertype.value == admin.userType}">${usertype.desc }</c:if>
					 	</c:forEach>
					</td>
				</tr>
				<tr>
					<td class="pn-flabel pn-flabel-h">
						审核状态:
					</td>
					<td class="pn-fcontent" colspan="3">
						<c:forEach items="${verify.childList }" var="verify">
						<c:if test="${verify.value == admin.verifyState}"><label>${verify.desc}</label></c:if>
						</c:forEach>
					</td>
				</tr>
				<tr id="verifyarea">
					<td class="pn-flabel pn-flabel-h">
						审核备注:
					</td>
					<td class="pn-fcontent" colspan="3">
						<s:property value="admin.verifyNote" escape="true" />
					</td>
				</tr>
				<tr>
					<td colspan="4" class="pn-fbutton">
						<input type="button" name="" value="返回" class="reject" onclick="javascript:history.go(-1)" />
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 部门信息 - 详情页面
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
 -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>部门信息 - 详情</title>
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 部门信息 - 详情
			</div>
			<form class="ropt">
			</form>
			<div class="clear"></div>
		</div>
		<div class="body-box">
			<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
				<tr>
					<td class="pn-flabel pn-flabel-h">
						上级部门:
					</td>
					<td class="pn-fcontent">
						<c:if test="${dept.scDept != null}">
						<c:if test="${dept.scDept.deleteState == '0' && dept.scDept.enableState == '1' && dept.scDept.verifyState == '3'}">
						${dept.scDept.deptName }
						</c:if>
						<c:if test="${dept.scDept.deleteState != '0' || dept.scDept.enableState != '1' || dept.scDept.verifyState != '3'}">
						无
						</c:if>
						</c:if>
						<c:if test="${dept.scDept == null}">无</c:if>
					</td>
					<td class="pn-flabel pn-flabel-h">
						是否启用:
					</td>
					<td class="pn-fcontent">
						<c:forEach items="${bean.childList }" var="state">
						<c:if test="${state.value == dept.enableState}">${state.desc }</c:if>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td class="pn-flabel pn-flabel-h">
						部门名称:
					</td>
					<td class="pn-fcontent">
						${dept.deptName}
					</td>
					<td class="pn-flabel pn-flabel-h">
						部门代码:
					</td>
					<td class="pn-fcontent">
						${dept.deptCode}
					</td>
				</tr>
				<tr>
					<td class="pn-flabel pn-flabel-h">
						部门领导:
					</td>
					<td class="pn-fcontent">
						${dept.deptLeader}
					</td>
					<td class="pn-flabel pn-flabel-h">
						部门联系人:
					</td>
					<td class="pn-fcontent">
						${dept.deptLinkman}
					</td>
				</tr>
				<tr>
					<td class="pn-flabel pn-flabel-h">
						办公地址:
					</td>
					<td class="pn-fcontent">
						${dept.deptAddress}
					</td>
					<td class="pn-flabel pn-flabel-h">
						邮编:
					</td>
					<td class="pn-fcontent">
						${dept.deptPostcode}
					</td>
				</tr>
				<tr>
					<td class="pn-flabel pn-flabel-h">
						联系电话:
					</td>
					<td class="pn-fcontent">
						${dept.deptPhone}
					</td>
					<td class="pn-flabel pn-flabel-h">
						传真:
					</td>
					<td class="pn-fcontent">
						${dept.deptFax}
					</td>
				</tr>
				<tr>
					<td class="pn-flabel pn-flabel-h">
						电子邮件:
					</td>
					<td class="pn-fcontent"  colspan="3">
						${dept.deptEmaill}
					</td>
					
				</tr>
				<tr>
					<td class="pn-flabel pn-flabel-h">
						部门介绍:
					</td>
					<td class="pn-fcontent" colspan="3">
						<s:property value="dept.deptDesc" escape="true" />
					</td>
				</tr>
				<tr>
					<td class="pn-flabel pn-flabel-h">
						审核状态:
					</td>
					<td class="pn-fcontent" colspan="3">
						<c:forEach items="${verify.childList}" var="verify">
						<c:if test="${verify.value == dept.verifyState}"><label>${verify.desc}</label></c:if>
						</c:forEach>
					</td>
				</tr>
				<tr id="verifyarea">
					<td class="pn-flabel pn-flabel-h">
						审核备注:
					</td>
					<td class="pn-fcontent" colspan="3">
						<s:property value="dept.verifyNote" escape="true" />
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
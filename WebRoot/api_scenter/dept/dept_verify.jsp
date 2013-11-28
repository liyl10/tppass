<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 部门管理 - 审核页面
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
 -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>部门管理 - 审核</title>
		<link href="${pageContext.request.contextPath}/resource/css/yz.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		 
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/validate.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/hcsp_resources.js"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/RegExp.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/dept/js/dept_validator_verify.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(document).ready(function () {
				//
				//初始化选择框的选中状态
				 if($("input[name='dept.verifyState']:checked").length<1){
					$("input[name='dept.verifyState']:eq(0)").attr("checked","checked");
				 }
				//
			});
		</script>
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 部门管理 - 审核
			</div>
		 
			<div class="clear"></div>
		</div>
		<div class="body-box">
			<form method="post" action="${pageContext.request.contextPath}/api/dept_verifyDept.action" id="jvForm">
				<input type="hidden" id="pageContext" name="pageContext" value="${pageContext.request.contextPath}" />
				<input type="hidden" name="redirectUrl" value="${redirectUrl}" />
				<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
					<tr>
						<td class="pn-flabel pn-flabel-h"  >
							上级部门:
						</td>
						<td class="pn-fcontent" >
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
						<td class="pn-flabel pn-flabel-h" >
							部门名称:
						</td>
						<td class="pn-fcontent" >
							${dept.deptName}
						</td>
						<td class="pn-flabel pn-flabel-h" >
							部门代码:
						</td>
						<td class="pn-fcontent" >
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
							<span class="pn-frequired">*</span>审核:
						</td>
						<td class="pn-fcontent" colspan="3">
							<label><input type="radio" name="dept.verifyState" value="1" ${dept.verifyState == '3'?"checked='checked'":""} />审核通过</label>	 
							<label><input type="radio" name="dept.verifyState" value="2" ${dept.verifyState == '4'?"checked='checked'":""} />审核不通过</label>
						</td>
					</tr>
					<tr id="verifyarea">
						<td class="pn-flabel pn-flabel-h">
							审核备注:
						</td>
						<td class="pn-fcontent" colspan="3">
							<textarea rows="3" cols="100" id="verifyNote" name="dept.verifyNote" class="textarea_box" >${dept.verifyNote}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="4" class="pn-fbutton">
							<input type="hidden" value="${dept.deptId}" name="dept.deptId" id="deptId" />
							<tag:auth code="sc.dept.verifydept">
							<input type="submit" name="btn_check" value="审核" class="check" />
							</tag:auth>
							&nbsp;
							<input type="button" name="" value="返回" class="reject" onclick="javascript:history.go(-1)" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
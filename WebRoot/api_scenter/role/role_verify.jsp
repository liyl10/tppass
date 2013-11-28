<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title></title>
		<link href="${pageContext.request.contextPath}/resource/css/yz.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/validate.js"></script>   
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/RegExp.js"></script>    
        <script type="text/javascript" >
			var url_cur="${pageContext.request.contextPath}";
		</script>
        <script src="${pageContext.request.contextPath}/api_scenter/role/js/role_validator_verify.js" type="text/javascript"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/hcsp_resources.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/role/js/role_verify.js"></script>
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 角色管理 - 审核
			</div>
			 
			<div class="clear"></div>
		</div>
		<div class="body-box">
			<form method="post" action="${pageContext.request.contextPath}/api/role/role_verifysave.action" id="role_verify_form" name="role_verify_form">
				<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
					<tr>
						<td class="pn-flabel pn-flabel-h">角色名称:</td>
						<td class="pn-fcontent">
							<input name="role_id" type="hidden" id="role_id" value="${pro_result.objinfo.roleId}" />
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
						<td class="pn-fcontent">
							${pro_result.objinfo.roleOrder}
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h"><span class="pn-frequired">*</span>审核状态:</td>
						<td class="pn-fcontent">
							<label><input type="radio" name="verify_state" value="1" ${(pro_result.objinfo.verifyState == verifypass)?"checked='checked'":""} />审核通过</label>
							<label><input type="radio" name="verify_state" value="2" ${(pro_result.objinfo.verifyState == verifyrefuse)?"checked='checked'":""} />审核不通过</label>
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">审核备注:</td>
						<td class="pn-fcontent">
							<textarea rows="4" cols="100" name="verify_note" class="textarea_box" id="verify_note" >${pro_result.objinfo.verifyNote}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="pn-fbutton">
							<input type="hidden" name="redirectUrl" value="${redirectUrl}"/>		
						    <input type="submit" name="btn_submit" value="审核" class="check" /> 
							&nbsp;
							<input class="reject" onclick="javascript:history.go(-1)" type="button" value="返回"/>
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
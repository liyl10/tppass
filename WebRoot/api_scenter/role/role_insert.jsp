<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <script src="${pageContext.request.contextPath}/api_scenter/role/js/role_validator_new.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/api_scenter/role/js/role_insert.js" type="text/javascript"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/hcsp_resources.js"></script>
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 角色管理 - 添加
			</div>
			 
			<div class="clear"></div>
		</div>
		<div class="body-box">
			<form method="post" action="${pageContext.request.contextPath}/api/role/role_insert.action" id="role_insert_form" name="role_insert_form">
				<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
					<tr>
						<td class="pn-flabel pn-flabel-h"><span class="pn-frequired">*</span>角色名称:</td>
						<td class="pn-fcontent">
							<input type="text" class="text_box" maxlength="40" name="role_name" id="role_name" /> 
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							角色描述:</td>
						<td class="pn-fcontent"> 
                            <textarea rows="6" cols="100" name="role_desc" class="textarea_box" id="role_desc" ></textarea>
						</td>
					</tr>
					 
					<tr>
						<td class="pn-flabel pn-flabel-h"><span class="pn-frequired">*</span>是否启用:</td>
						<td class="pn-fcontent">
 						 <c:forEach items="${enable_state_config.childList}" var="enable">
						 	<label><input type="radio" name="enable_state" value="${enable.value}" ${(enable.value ==pro_result.objinfo.enableState)?"checked='checked'":""} />${enable.desc}</label>&nbsp;&nbsp; 
						 </c:forEach>	
						 </td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h"><span class="pn-frequired">*</span>排序:</td>
						<td class="pn-fcontent">
							<input type="text" class="text_box" maxlength="10" value="1" name="role_order" id="role_order" />
						</td>
					</tr>
					<tr>
						<td colspan="2" class="pn-fbutton">		 
						<input type="hidden" name="redirectUrl" value="${redirectUrl}"/>
							<input type="submit" name="btn_submit" value="提交" class="submit" />
							&nbsp;
							<input type="button" name="btn_reject" value="返回" class="reject" onclick="javascript:history.go(-1)" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="dialog" title="Download complete">
			<div id="dialog_content"></div>
		</div>
	</body>
</html>
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
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/hcsp_resources.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/hopsun.util.js"></script>
        <script type="text/javascript" >
			var url_cur="${pageContext.request.contextPath}";
			$(document).ready(function(){
			//提交时进行验证处理空格
		 	 $("#role_modify_form").submit(function(e){
		 	 $("input").each(function(i){
   						 $(this).attr("value",trim_val($(this).val()));   //去除首尾空格
 					});
		 	 	 return true;
		 	 })	
			//
			//重置，清空提示层
						$("input[name='btn_reset']").click(function(){
							hopsun_util.remove_tips();
							});
			//	ready end
				});				
		</script>
        <script src="${pageContext.request.contextPath}/api_scenter/role/js/role_validator_modify.js" type="text/javascript"></script>
		
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 角色管理 - 修改
			</div>
			 
			<div class="clear"></div>
		</div>
		<div class="body-box">
			<form method="post" action="${pageContext.request.contextPath}/api/role/role_save.action" id="role_modify_form" name="role_modify_form">
				<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
					<tr>
						<td class="pn-flabel pn-flabel-h"><span class="pn-frequired">*</span>角色名称:</td>
						<td class="pn-fcontent">
						    <input name="role_id" type="hidden" id="role_id" value="${pro_result.objinfo.roleId}"  />
							<input name="role_name" type="text" class="text_box" id="role_name" value="${pro_result.objinfo.roleName}" maxlength="40" />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							角色描述:</td>
						<td class="pn-fcontent"> 
                            <textarea rows="6" cols="100" name="role_desc" class="textarea_box" id="role_desc" >${pro_result.objinfo.roleDesc}</textarea>
                            
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
							<input type="text" class="text_box" maxlength="10" value="${pro_result.objinfo.roleOrder}" name="role_order" id="role_order" />
						</td>
					</tr>
					<tr>
						<td colspan="2" class="pn-fbutton">		
							<input type="hidden" name="redirectUrl" value="${redirectUrl}"/>
							<input type="submit" name="btn_submit" value="保存" class="submit" /> 
							&nbsp; 
							<input type="reset" value="重置" name="btn_reset" class="reset" />
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
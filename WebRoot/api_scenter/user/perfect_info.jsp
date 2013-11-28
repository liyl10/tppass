<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 个人信息修改页面
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
 -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>个人资料 - 修改</title>
		<link href="${pageContext.request.contextPath}/resource/css/yz.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/validate.js"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/RegExp.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/user/js/perfcet.js" type="text/javascript"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/hcsp_resources.js"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/pop_box.js" type="text/javascript"></script>

	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 个人资料 - 修改
			</div>
			<form class="ropt">
			</form>
			<div class="clear"></div>
		</div>
		<div class="body-box">
			<form method="post" action="${pageContext.request.contextPath}/api/user_update.action" id="myform">
				<input type="hidden" id="pageContext" name="pageContext" value="${pageContext.request.contextPath}" />
				<input type="hidden" name="redirectUrl" value="${pageContext.request.contextPath}/api_scenter/user/perfect_info.jsp" />
				<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
					<tr>
						<td class="pn-flabel pn-flabel-h">
							用户名:
						</td>
						<td class="pn-fcontent">
							${sysUser.userName}
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							<span class="pn-frequired">*</span>原密码:
						</td>
						<td class="pn-fcontent">
							<input type="password" autocomplete="off" maxlength="20" name="oldPwd" id="oldPwd" onkeyup="this.value=this.value.replace(/\s+/g, '')" onafterpaste="this.value=this.value.replace(/\s+/g, '')" />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							<span class="pn-frequired">*</span>新密码:
						</td>
						<td class="pn-fcontent">
							<input type="password" autocomplete="off" name="admin.userPwd" maxlength="20" id="userPwd" onkeyup="this.value=this.value.replace(/\s+/g, '')" onafterpaste="this.value=this.value.replace(/\s+/g, '')" />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							<span class="pn-frequired">*</span>确认密码:
						</td>
						<td class="pn-fcontent">
							<input type="password" autocomplete="off" maxlength="20" id="userPwd2" onkeyup="this.value=this.value.replace(/\s+/g, '')" onafterpaste="this.value=this.value.replace(/\s+/g, '')" />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							真实姓名:
						</td>
						<td class="pn-fcontent">
							<input type="text" maxlength="20" value="${sysUser.userRealname}" name="admin.userRealname" id="userRealname" />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							联系电话:
						</td>
						<td class="pn-fcontent">
							<input type="text" maxlength="20" value="${sysUser.userPhone}" name="admin.userPhone" id="userPhone" />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							电子邮箱:
						</td>
						<td class="pn-fcontent">
							<input type="text" maxlength="50" value="${sysUser.userEmail}" name="admin.userEmail" id="userEmail" />
						</td>
					</tr>
					<tr>
						<td colspan="2" class="pn-fbutton">
							<input type="hidden" value="${sysUser.userId}" name="admin.userId" />
							<tag:auth code="sc.user.update">
							<input type="submit" name="btn_submit" value="提交" class="submit" />
							</tag:auth>
							&nbsp;
							<input type="reset" name="btn_reset" value="重置" class="reset" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
<!-- 
@comment 系统参数修改页面
@author zzze
@date Dec 27, 2012
@version 1.0
 -->
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http：//www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http：//www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>系统参数管理 - 修改</title>
		<link href="${pageContext.request.contextPath}/resource/css/yz.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/subgroups/config/js/config_validate.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/validate.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/hcsp_resources.js"></script>
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置： 系统参数管理 - 修改
			</div>
			<form class="ropt" action="">
				<input type="button" name="" value="返回列表" class="return-button" />
			</form>
			<div class="clear"></div>
		</div>
		<div class="right_boxtable">
			<form method="post" action="${pageContext.request.contextPath}/api/config/config_modify.action" id="myform">
				<input type="hidden" name="config.paramId" value="${config.paramId}" />
				<input type="hidden" name="config.createUserName" value="${config.createUserName}" />
				<input type="hidden" name="config.createDate" value="${config.createDate}" />
				<input type="hidden" name="paramUseage" value="${config.paramUseage}" />
				<input type="hidden" name="config.paramSource" value="${config.paramSource}" />
				<input type="hidden" name="pageContext" value="${pageContext.request.contextPath}" />
				<input type="hidden" name="config.paramCode" value="${config.paramCode}" />
				<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
					<tr>
						<td class="pn-flabel">
							<span class="pn-frequired">*</span>参数名称：
						</td>
						<td class="pn-fcontent">
							<input type="text" name="config.paramName" id="paramName" value="${config.paramName }" class="text_box" />
						</td>
						<td class="pn-flabel">
							<span class="pn-frequired">*</span>参数代码：
						</td>
						<td class="pn-fcontent">
							${config.paramCode }
						</td>
					</tr>
					<tr>
						<td class="pn-flabel">
							<span class="pn-frequired">*</span>可供选择的值：
						</td>
						<td class="pn-fcontent" colspan="3">
							<textarea name="config.paramChoose" id="paramChoose" style="width:100%;height:300px">${config.paramChoose }</textarea><br/><span class="pn-frequired">说明："值-code-说明"为单元，单元的属性以“-”分隔，多个单元以“,”分隔。如：0-male-男,1-female-女</span>
						</td>
					</tr>
					<tr>
						<td class="pn-flabel">
							<span class="pn-frequired">*</span>默认值：
						</td>
						<td class="pn-fcontent" colspan="3" id="paramUseageDiv"></td>
					</tr>
					<tr>
						<td class="pn-flabel">
							<span class="pn-frequired">*</span>配置介绍：
						</td>
						<td class="pn-fcontent" colspan="3">
							<textarea name="config.description" id="description" style="width:100%;height:120px">${config.description}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="4" class="pn-fbutton">
							<input type="submit" name="btn_submit" value="提交" class="submit" />
							&nbsp;
							<input type="reset" name="btn_reset" value="重置" class="reset" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
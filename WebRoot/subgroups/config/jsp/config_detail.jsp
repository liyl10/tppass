<!-- 
@comment 系统参数查看页面
@author zzze
@date Dec 27, 2012
@version 1.0
 -->
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http：//www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http：//www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>系统参数管理 - 查看</title>
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/subgroups/config/js/config_validate.js"></script>
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置： 系统参数管理 - 查看
			</div>
			<form class="ropt" action="">
				<input type="button" name="" value="返回列表" class="return-button" />
			</form>
			<div class="clear"></div>
		</div>
		<div class="right_boxtable">
			<form method="post" action="" id="myform">
				<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
					<tr>
						<td class="pn-flabel">
							<span class="pn-frequired">*</span>参数名称：
						</td>
						<td class="pn-fcontent">
							${config.paramName }
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
						<td class="pn-fcontent" colspan="3" style="word-wrap: break-word; word-break: normal;">
							<textarea readonly="readonly" style="width:100%;height:300px">${config.paramChoose }</textarea>
						</td>
					</tr>
					<tr>
						<td class="pn-flabel">
							<span class="pn-frequired">*</span>默认值：
						</td>
						<td class="pn-fcontent" colspan="3">
							${config.paramUseage }
						</td>

					</tr>
					<tr>
						<td class="pn-flabel">
							<span class="pn-frequired">*</span>配置介绍：
						</td>
						<td class="pn-fcontent" colspan="3">
							<textarea readonly="readonly" style="width:100%;height:300px">${config.description}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="4" class="pn-fbutton">
							<input type="button" name="" value="返回" class="return-button" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
<!-- 
@comment 日志查看页面
@author zzze
@date Dec 27, 2012
@version 1.0
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http：//www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http：//www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>日志管理 - 查看</title>
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/subgroups/log/js/log.js"></script>
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置： 日志管理 - 查看
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
							<span class="pn-frequired">*</span>操作人：
						</td>
						<td class="pn-fcontent">
							${ucLogs.createUserName }
						</td>
						<td class="pn-flabel">
							<span class="pn-frequired">*</span>操作时间：
						</td>
						<td class="pn-fcontent">
							${fn:substring(ucLogs.createDate,0,19)}
						</td>
					</tr>
					<tr>
						<td class="pn-flabel">
							<span class="pn-frequired">*</span>操作地点：
						</td>
						<td class="pn-fcontent">
							${ucLogs.logIp}
						</td>
						<td class="pn-flabel">
							<span class="pn-frequired">*</span>操作平台：
						</td>
						<td class="pn-fcontent">
							${ucLogs.logSource}
						</td>
					</tr>
					<tr>
						<td class="pn-flabel">
							<span class="pn-frequired">*</span>操作模块：
						</td>
						<td class="pn-fcontent">
							${ucLogs.logObj }
						</td>
						<td class="pn-flabel">
							<span class="pn-frequired">*</span>操作类型：
						</td>
						<td class="pn-fcontent">
							${ucLogs.logOpera}
						</td>
					</tr>
					<tr>
						<td class="pn-flabel">
							<span class="pn-frequired">*</span>操作结果：
						</td>
						<td class="pn-fcontent" colspan="3">
							${ucLogs.operaResult }
						</td>

					</tr>
					<tr>
						<td class="pn-flabel">
							<span class="pn-frequired">*</span>日志明细：
						</td>
						<td class="pn-fcontent" colspan="3" style="word-wrap: break-word; word-break: normal;">
							<textarea readonly="readonly" style="width:100%;height:300px">${ucLogs.logDetail }</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="4" class="pn-fbutton">
							<input type="button" value="返 &nbsp; 回" class="return-button" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
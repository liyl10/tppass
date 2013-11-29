<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 快捷方式添加、删除页面
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
 -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>快捷方式管理页面</title>
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/api_scenter/css/zTreeStyle/zTreeStyle.css" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/jquery.ztree.core-3.0.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/jquery.ztree.excheck-3.0.js"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/shortcut/js/shortcut_insert.js" type="text/javascript"></script>
	<SCRIPT type="text/javascript">
	<!--
	$(document).ready(function(){
		$("#myform").bind("submit",function(){});
		var zNodes = ${authList};
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		setCheck();
	});
	//-->
	</SCRIPT>
	</head>

	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 快捷方式管理 - 添加
			</div>
			<form class="ropt">
			</form>
			<div class="clear"></div>
		</div>
		<div class="right_boxtable">
		<div class="body-box">
			<form id="myform" name="form" method="post" action="${redirectUrl}">
				<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
					<tr>
						<td class="pn-fcontent" style="height:430px;" valign="top">
							<ul id="treeDemo" class="ztree"></ul>
						</td>
					</tr>
					<tr>
						<td class="pn-fcontent">
							<input type="submit" name="" value="保存" class="add" />
							<input type="button" name="" value="返回" class="reject" onclick="javascript:history.go(-1)" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		</div>
	</body>
</html>

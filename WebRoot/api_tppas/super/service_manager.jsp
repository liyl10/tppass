<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<html>
<head>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/super/js/service_manager.js"></script>
<script type="text/javascript">
$(function() {
    $(document).ready(function () {
		upms.showOverLay();// 打开遮罩

		var $newPgDiv = $("#mainContent");
	    var tempValue = ${subPage};
	    actionUrl = "";
	    if (tempValue == 1) {
	    	actionUrl = "${pageContext.request.contextPath}/api/superadmin/mtype!initTypeSetting.action";
	    } else if (tempValue == 2) {
	    	actionUrl = "${pageContext.request.contextPath}/api/superadmin/mtype!initOtherSetting.action";
	    } else if (tempValue == 3) {
	    	actionUrl = "${pageContext.request.contextPath}/api/superadmin/mitem!initContractSetting.action";
	    }
		$newPgDiv.load(actionUrl+"?now=" + new Date().getTime(), null, function() {
			upms.hideOverLay();});
		
	});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<style>
#mainContent {
	background: #fef;
}
</style>
<label id="path" style="display: none">${pageContext.request.contextPath}</label>
<%-- <div class="leftNav">
	<div id=accordion class="accordion">
		<dl class="acc_nav">
			<dt id="subleftmenu" class="jingyin mainNav">基础数据配置</dt>
					<dd id='subNav1' class="subNav1">
					<tag:auth code="ss.service_manager.type">
						<a typeKey="10"
							action="${pageContext.request.contextPath}/api/superadmin/mtype!initTypeSetting.action"
							href="javascript: void(0);" >代码类型配置管理</a>
					</tag:auth>
					</dd>
					<dd id='subNav2' class="subNav2">
					<tag:auth code="ss.service_manager.item">
						<a typeKey="10"
							action="${pageContext.request.contextPath}/api/superadmin/mtype!initOtherSetting.action" href="javascript: void(0);" >代码值配置管理</a>
					</tag:auth>
					<dd id='subNav3' class="subNav3">
					<tag:auth code="ss.service_manager.other">
						<a typeKey="10"
							action="${pageContext.request.contextPath}/api/superadmin/mitem!initContractSetting.action" href="javascript: void(0);" >系统信息管理</a>
					</tag:auth>
					</dd>
		</dl>
	</div>
</div> --%>
<div id="mainContent"></div>
</body>
</html>
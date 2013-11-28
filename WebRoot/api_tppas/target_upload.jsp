<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link href="${pageContext.request.contextPath}/favicon.ico"  type="image/x-icon"  rel=icon></link>
<link href="${pageContext.request.contextPath}/favicon.ico"  type="image/x-icon"  rel="shortcut icon"></link>
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/style.css">
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/install_upms.js?ver=1.0.0"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery.msgbox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/chosen.jquery.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/chosen.css" />
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/btn.css" />
                                                                                            
	
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
				<div class="c">
				<input class="txt" id="retMsg" name="retMsg" type="text" 
				value="<s:property value='%{retMsg}' escape='true'/>">
				</div>
				<div class="c">
				<input class="txt" id="retUrl" name="retUrl" type="text" 
				value="<s:property value='%{retUrl}' escape='true'/>">
				</div>
            
	</div>
</div>

<script type="text/javascript">
$(function() {
	$(document).ready(function() {
		//alert($("#retUrlTo").val());
		var actionUrl = $("#retUrl").val()+"now="+new Date().getTime()+"&retMsg="+encodeURIComponent($("#retMsg").val());
	 	var $newPgDiv = $(window.parent.document).find("#content");
	 	//$newPgDiv.html("");
	 	//alert(actionUrl);
		$newPgDiv.load(actionUrl,"", function() {
			}); 
	});
});

</script>

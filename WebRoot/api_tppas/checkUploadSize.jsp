<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_xapdpms/js/jquery/jquery-1.8.3.js"></script>

<script type="text/javascript">
function load()
{
	if($("#orderFlag").val()=="true"){
		$(window.parent.document).find("#errororder").remove();
		var span = $("<em id='errororder'><span style='color:red;font-style: normal;'>附件顺序已存在，请重新输入附件顺序再继续上传！</span></em>");
		$(window.parent.document).find("#sequence").parent().append(span);
	}
	if($("#sizeFlag").val()=="true"){
		$(window.parent.document).find("#errorSize").remove();
		var span = $("<em id='errorSize'><span style='color:red;font-style: normal;'>选择的附件大小超过限制，请重新调整附件大小后再继续上传！</span></em>");
		$(window.parent.document).find("#uploadfile").parent().append(span);
	}
	$(window.parent.document).find("#saveFile").removeAttr("disabled");
}
</script>

<body onload="load()">
<input type="hidden" value="<s:property value='%{retMsg}' escape='true'/>" id="retChkMsg" name="retChkMsg">
<input type="hidden" value="<s:property value='%{orderFlag}' escape='true'/>" id="orderFlag" name="orderFlag">
<input type="hidden" value="<s:property value='%{sizeFlag}' escape='true'/>" id="sizeFlag" name="sizeFlag">
</body>

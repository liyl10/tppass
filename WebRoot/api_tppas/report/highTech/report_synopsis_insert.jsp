<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/highTech/js/report_synopsis_insert.js"></script>

<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
<div class="Servicel04">
<div class="abuot02">
<div class="abuot07">企业简介和发展前景</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm">
	<tr>
		<td width="12%" align="right"><FONT color=red>*</FONT>企业简介和发展前景（1000字以内）</td>
		<td width="88%" align="left" colspan="5">
			<textarea id="enterpriseProfileText" name="tenterpriseProfilea.enterpriseProfileText" class="inputA" style="width:98%;height:300px;resize:none;"><s:property value='%{tenterpriseProfilea.enterpriseProfileText}' escape='true'/></textarea>
		</td>
	</tr>
	<tr align="center">
		<td colspan="6">
			<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
			<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
			<s:hidden id="enterpriseProfileId" name="tenterpriseProfilea.enterpriseProfileId" value="%{tenterpriseProfilea.enterpriseProfileId}"></s:hidden>
			<input class="button" id="nextBtn" name="button" type="button" value="下一步"/>
		</td>
	</tr>
</table>
</div>
</div>
</div>
</div>
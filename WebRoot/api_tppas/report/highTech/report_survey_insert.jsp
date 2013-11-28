<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/highTech/js/report_survey_insert.js"></script>

<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
<div class="Servicel04">
<div class="abuot02">
<div class="abuot07">项目概况和市场分析</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	class="t-entRegFrm">
	<tr>
		<td width="12%" align="right"><FONT color=red>*</FONT>项目概况和市场分析（1000字以内）</td>
		
		<td width="88%" align="left" colspan="5">
			<textarea id="projectOverviewText" name="tprojectOverviewa.projectOverviewText" class="inputA" style="width:98%;height:300px;resize:none;"><s:property value='%{tprojectOverviewa.projectOverviewText}' escape='true'/></textarea>
		</td>
	</tr>
	<tr align="center">
		<td colspan="6">
			<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
			<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
			<s:hidden id="projectOverviewpId" name="tprojectOverviewa.projectOverviewpId" value="%{tprojectOverviewa.projectOverviewpId}"></s:hidden>
			<input class="button" id="nextBtn" name="button" type="button" value="下一步"/>
		</td>
	</tr>
	
</table>
</div>
</div>
</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/other/js/report_scheduling_insert.js"></script>
<!-- 项目ID -->
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<s:hidden id="schedulingId" name="tschedulinga.schedulingId" value="%{tschedulinga.schedulingId}"></s:hidden>
<s:hidden id="reportApplicactionId" name="tschedulinga.tprojectApplication.projectId" value="%{projectId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目进度计划</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm">
				<tr>
					<td width="12%" align="right" rowspan="2">
					<FONT color=red>*</FONT>项目进度计划 <br />
					（1000字以内） <br />
					</td>
					<td><FONT color=red>每半年的进度、研究任务</FONT></td>
				</tr>
				<tr>
					<td width="88%" align="left">
						<textarea id="schedulingText"  name="tschedulinga.schedulingText"  style="width:700px; height:150px" 
						onblur="upms.upmsUtils.blurTextCheck(this,'项目进度计划',1,8,1000)"
						onfocus="upms.upmsUtils.textFocus(this)"
						onkeyup="this.value = upms.upmsUtils.checkTextareaLength(this.value, 1000);"
						><s:property value='%{tschedulinga.schedulingText}' escape='true'/></textarea>
						<s:hidden id="hiddenschedulingText" name="hidden" value="项目进度计划,1,8,1000"></s:hidden>
					</td>
				</tr>
				</table>
				<div align="center" style="width: 100%">
					<br> <br>
					<input id="nextBtn1" type="button" class="button save"  value="下一步"/>
				</div>
			</div>
		</div>
	</div>
</div>
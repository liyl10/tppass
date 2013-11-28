<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/other/js/report_abstract_insert.js"></script>

<!-- 项目ID -->
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<s:hidden id="reportAbstractId" name="treportAbstractB.reportAbstractId" value="%{treportAbstractB.reportAbstractId}"></s:hidden>
<s:hidden id="reportApplicactionId" name="treportAbstractB.tprojectApplication.projectId" value="%{projectId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目主要研究内容</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm">
				<tr>
					<td width="12%" align="right" >
						项目摘要：
					</td>
					<td>
						<s:property value='%{treportAbstractB.reportAbstract}' escape='true'/>
					</td>
				</tr>
				<tr>
					<td width="12%" align="right" >
						<font color=red>*</font>项目主要研究内容<br />（500字以内）
					</td>
					<td width="88%" align="left">
						<textarea id="remark" name="treportAbstractB.remark" style="width:700px; height:150px" ><s:property value='%{treportAbstractB.remark}' escape='true'/></textarea>
					</td>
					<s:hidden id="hiddenremark" name="hidden" value="项目主要研究内容,1,8,500"></s:hidden>
				</tr>
				
				</table>
				<div align="center" style="width: 100%">
						<br> <br>
						<input id="nextBtn" type="button" class="button save" href="javascript: void(0);" value="下一步"/>
				</div>
			</div>
		</div>
	</div>
</div>
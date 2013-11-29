<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/other/js/report_foundation_insert.js"></script>

<!-- 项目ID -->
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<s:hidden id="companyFoundationId" name="tcompanyFoundation.companyFoundationId" value="%{tcompanyFoundation.companyFoundationId}"></s:hidden>
<s:hidden id="reportApplicactionId" name="tcompanyFoundation.tprojectApplication.projectId" value="%{projectId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">前期研究基础（可附相关证明）及现有条件（含设备手段等）和优势</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm">
				<tr>
					<td width="12%" align="right">
					<FONT color=red>*</FONT>前期研究基础（可附相关证明）及现有条件（含设备手段等）和优势  <br />
					（1000字以内） <br />
					</td>
					<td width="88%" align="left">
						<textarea id="companyFoundation"  name="tcompanyFoundation.companyFoundation"  style="width:700px; height:150px" 
						><s:property value='%{tcompanyFoundation.companyFoundation}' escape='true'/></textarea>
						<s:hidden id="hiddencompanyFoundation" name="hidden" value="前期基础及现有条件和优势,1,8,1000"></s:hidden>
					</td>
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
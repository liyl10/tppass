<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/other/js/report_technical_insert.js"></script>

<!-- 项目ID -->
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<s:hidden id="technicalContentId"
	name="technicalContenta.technicalContentId"
	value="%{technicalContenta.technicalContentId}"></s:hidden>
<s:hidden id="reportApplicactionId"
	name="technicalContenta.tprojectApplication.projectId"
	value="%{projectId}"></s:hidden>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">主要技术创新点</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="t-entRegFrm">
					<tr>
						<td width="12%" align="right" rowspan="2"><FONT color=red>*</FONT>主要技术创新点
							<br /> （500字以内） <br /></td>
						<td width="88%" align="left">
						<FONT color=red>此处只需简要说明项目的技术创新点即可，具体详细描述由可行性方案来阐述，且可行性方案附在申报书打印版后。</FONT>
					</td>
					</tr>
					<tr>
						<td width="88%" align="left"><textarea
								id="technicalContentText"
								name="technicalContenta.technicalContentText"
								style="width: 700px; height: 150px"><s:property value='%{technicalContenta.technicalContentText}' escape='true' /></textarea> <s:hidden id="hiddentechnicalContentText" name="hidden"
								value="主要研究内容与技术创新点,1,8,500"></s:hidden></td>
					</tr>
				</table>
				<div align="center" style="width: 100%">
					<br> <br> <input id="nextBtn1" type="button"
						class="button save" value="下一步" />
				</div>
			</div>
		</div>
	</div>
</div>
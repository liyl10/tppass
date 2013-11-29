<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/highTech/js/report_technique_insert.js"></script>

<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">主要技术内容与技术创新点</div>
				<iframe id="download" name="download" width=0 height=0 src=""
					style="display: none;"></iframe>
				<form method="post" enctype="multipart/form-data" id="uploadForm"
					target="download">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						class="t-entRegFrm">
						<tr>
							<td width="12%" align="right" rowspan="2"><FONT color=red>*</FONT>主要技术内容与技术创新点（500字以内）</td>
							<td width="88%" align="left"><FONT color=red>此处只需简要说明项目的技术创新点即可，具体详细描述由可行性方案来阐述，且可行性方案附在申报书打印版后。</FONT>
							</td>
						</tr>
						<tr>
							<td width="88%" align="left"><textarea
									id="technicalContentText"
									name="technicalContenta.technicalContentText" class="inputA"
									style="width: 98%; height: 300px; resize: none;"><s:property value='%{technicalContenta.technicalContentText}'
										escape='true' /></textarea></td>
						</tr>
						<tr align="center">
							<td colspan="6"><s:hidden id="projectId" name="projectId"
									value="%{projectId}"></s:hidden> <s:hidden id="applyStatus"
									name="applyStatus" value="%{applyStatus}"></s:hidden> <s:hidden
									id="technicalContentId"
									name="technicalContenta.technicalContentId"
									value="%{technicalContenta.technicalContentId}"></s:hidden> <input
								class="button" id="nextBtn" name="button" type="button"
								value="下一步" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
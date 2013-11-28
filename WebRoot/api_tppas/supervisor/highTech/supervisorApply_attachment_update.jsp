<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/highTech/js/supervisorApply_attachment_update.js"></script>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">附件修改</div>
				<iframe id="download" name="download" width=0 height=0 src=""
					style="display: none;"></iframe>
				<form method="post" enctype="multipart/form-data" id="uploadForm"
					target="download">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						class="t-entRegFrm">
						<tr>
							<td width="20%" align="right"><FONT color=red>*</FONT>附件名称</td>
							<td width="80%"><INPUT class="inputA" type="text"
								id="attachmentName" name="attachmentName" style="width: 16em;"
								maxlength="15"
								value="<s:property value='%{tattachment.attachmentName}' escape='true'/>"
								onblur="blurText(this,'附件名称',1,0);" onfocus="focusText(this);"
								disabled="disabled"></td>
							<s:hidden id="hiddenattachmentName" name="hidden"
								value="附件名称,1,0"></s:hidden>
						</tr>
						<tr>
							<td width="20%" align="right"><FONT color=red>*</FONT>排序</td>
							<td width="80%"><INPUT class="inputA" type="text"
								id="sequence" name="sequence" style="width: 10.2em;"
								maxlength="3" onblur="blurText(this,'排序',1,2);"
								onfocus="focusText(this);"
								onkeypress="return IsFloatNum(event,this)"
								style="ime-mode: disabled;"
								value="<s:property value='%{tattachment.sequence}' escape='true'/>"></td>
							<s:hidden id="hiddensequence" name="hidden" value="排序,1,2"></s:hidden>
						</tr>
						<tr align="center">
							<td colspan="2"><s:hidden id="tableName" name="tableName"
									value="%{tableName}"></s:hidden> <s:hidden id="dataId"
									name="dataId" value="%{supervisorId}"></s:hidden> <s:hidden
									id="upLoadfileName" name="upLoadfileName"></s:hidden> <s:hidden
									id="fileType" name="fileType" value="%{fileType}"></s:hidden> <s:hidden
									id="retUrl" name="retUrl"></s:hidden> <s:hidden
									id="attachmentId" name="attachmentId"
									value="%{tattachment.attachmentId}"></s:hidden> <s:hidden
									id="onlysequence" name="onlysequence" value="false"></s:hidden>
								<input class="button" id="saveFile" name="button" type="button"
								value="保存" /> <input class="button" id="retBack" name="button"
								type="button" value="返回" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/other/js/report_objection_insert.js"></script>

<s:hidden id="isWriteFlag" name="isWriteFlag" value="%{isWriteFlag}"></s:hidden>
<s:hidden id="highTechFlg" name="highTechFlg" value="%{highTechFlg}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
<div class="Servicel04">
<div class="abuot02">
<div class="abuot07">审查意见</div>
<iframe id="download" name="download" width=0 height=0 src="" style="display: none;"></iframe> 
<form  method="post" enctype="multipart/form-data" id="uploadForm" target="download">	
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	class="t-entRegFrm">
	<tr>
		<td width="12%" align="right">
			<FONT color=red>*</FONT>申报单位意见（200字以内）
		</td>
		<td width="88%" align="left" colspan="5">
			<textarea id="comment1" name="comment1" class="inputA" 
				style="width:99%; height:200px;resize:none;"><s:property value='%{treviewComments.reportingUnits}' escape='true'/></textarea>
		</td>
	</tr>
	<tr>
		<td width="12%" align="right">协作单位审查意见 （200字以内）</td>
		<td width="88%" align="left" colspan="5">
			<textarea id="comment2" name="comment2" class="inputA" 
			style="width:99%; height:200px;resize:none;"><s:property value='%{treviewComments.cooperativeUnits}' escape='true'/></textarea>
		</td>
	</tr>
	<%-- <tr>
	<s:if test="%{fileFlag==1}">
		<td width="12%" align="right">附件上传</td>
		<td height="90%"  width="38%" colspan="3" align="left">
    		<input type="file" class="inputA" id="uploadfile" name="uploadfile"
    		onblur="blurText(this,'附件上传路径',0,1);" onfocus="focusText(this);"
    		/>
		</td>
		<s:hidden id="hiddenuploadfile" name="hidden" value="附件上传路径,0,1"></s:hidden>
		<td width="12%" align="right">附件</td>
		<td width="38%" align="left">
			<a class="uline single" href="javascript: void(0);" onclick="downfile('${attachmentId}');">审查意见${namesuffix}</a>
		</td>
	</s:if>
	<s:else>
		<td width="12%" align="right">附件上传</td>
		<td height="90%"  width="38%" colspan="5" align="left">
    		<input type="file" class="inputA"id="uploadfile" name="uploadfile"
    		onblur="blurText(this,'附件上传路径',0,1);" onfocus="focusText(this);"
    		/>
		</td>
		<s:hidden id="hiddenuploadfile" name="hidden" value="附件上传路径,0,1"></s:hidden>
	</s:else>
	</tr> --%>
	<tr align="center">
		<td colspan="7">
			<s:hidden id="tableName" name="tableName" value="T_REVIEW_COMMENTS"></s:hidden>
			<s:hidden id="dataId" name="dataId" value="%{projectId}"></s:hidden>
			<s:hidden id="projectTableName" name="projectTableName" value="T_PROJECT_APPLICATION"></s:hidden>
			<s:hidden id="attachmentName" name="attachmentName" value="审查意见"></s:hidden>
			<s:hidden id="retUrlTemp" name="retUrlTemp"></s:hidden>
			<s:hidden id="retUrlTo" name="retUrlTo"></s:hidden>
			<s:hidden id="upLoadfileName" name="upLoadfileName"></s:hidden>
			<s:hidden id="fileType" name="fileType" value="%{fileType}"></s:hidden>
			<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
			<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
			<%-- <s:hidden id="reviewCommentsId" name="treviewComments.reviewCommentsId" value="%{treviewComments.reviewCommentsId}"></s:hidden> --%>
			<%-- <s:if test="%{highTechFlg != 1}"> --%>
			<input class="button" id="nextBtn" name="button" type="button" value="下一步"/>
			<%-- </s:if> --%>
		</td>
	</tr>
</table>
</form>
</div>
</div>
</div>
</div>
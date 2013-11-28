<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/other/js/report_technical_indexes.js"></script>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<!-- 下一步按钮提示信息 -->
<label id="comfirmSaveNext" style="display: none"><s:text name="confirm_save_and_next_info"/></label>

<!-- 项目ID -->
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<s:hidden id="technicalIndexesId" name="ttechnicalIndexes.technicalIndexesId" value="%{ttechnicalIndexes.technicalIndexesId}"></s:hidden>
<s:hidden id="reportApplicactionId" name="ttechnicalIndexes.tprojectApplication.projectId" value="%{projectId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目达到的主要技术指标</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm">
				<tr>
					<td width="12%" align="right" rowspan="2">
					<FONT color=red>*</FONT>项目达到的主要技术指标<br />（200字以内）
					</td>
					<td width="88%" align="left">
						<textarea id="technicalIndexes" name="ttechnicalIndexes.technicalIndexes"
						onblur="upms.upmsUtils.blurTextCheck(this,'项目达到的主要技术指标',1,8,200)"
						onfocus="upms.upmsUtils.textFocus(this)" style="width:700px;height:150px;resize:none;"
						onkeyup="upms.upmsUtils.checkTextareaLength(this, 200);"
						><s:property value='%{ttechnicalIndexes.technicalIndexes}' escape='true'/></textarea>
					</td>
					<s:hidden id="hiddentechnicalIndexes" name="hidden" value="项目达到的主要技术指标,1,8,200"></s:hidden>
				</tr>
				
				</table>
				<div align="center" style="width: 100%">
						<br> <br>
						<s:if test="%{applyStatus == 1}">
						<input id="okBtn" type="button" class="button save" href="javascript: void(0);" value="保存"/>
						<input id="nextBtn" type="button" class="button save" href="javascript: void(0);" value="下一步"/>
					</s:if>
					<s:else>
						<input id="nextBtn1" type="button" class="button save" href="javascript: void(0);" value="下一步"/>
					</s:else>
				</div>
			</div>
		</div>
	</div>
</div>
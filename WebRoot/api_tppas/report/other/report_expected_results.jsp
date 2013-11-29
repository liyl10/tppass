<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/other/js/report_expected_results.js"></script>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<!-- 下一步按钮提示信息 -->
<label id="comfirmSaveNext" style="display: none"><s:text name="confirm_save_and_next_info"/></label>

<!-- 项目ID -->
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<s:hidden id="expectedResultsId" name="texpectedResults.expectedResultsId" value="%{texpectedResults.expectedResultsId}"></s:hidden>
<s:hidden id="reportApplicactionId" name="texpectedResults.tprojectApplication.projectId" value="%{projectId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">预期成果（包括样机、专利申请、授权数量、质量认证体系证书、科技成果登记等）</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm">
				<tr>
					<td width="12%" align="right" rowspan="2">
					<FONT color=red>*</FONT>预期成果<br />（包括样机、专利申请、授权数量、质量认证体系证书、科技成果登记等）<br/>（1000字以内）
					</td>
					<td width="88%" align="left">
						<textarea id="expectedResults" name="texpectedResults.expectedResults"
						onblur="upms.upmsUtils.blurTextCheck(this,'预期成果',1,8,1000)"
						onfocus="upms.upmsUtils.textFocus(this)" style="width:700px;height:150px;resize:none;"
						onkeyup="upms.upmsUtils.checkTextareaLength(this, 1000);"
						><s:property value='%{texpectedResults.expectedResults}' escape='true'/></textarea>
					</td>
					<s:hidden id="hiddentexpectedResults" name="hidden" value="预期成果,1,8,1000"></s:hidden>
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
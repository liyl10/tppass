<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/server_tppas/supervisor/js/supervisorReport_insert.js"></script>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目工作报告</div>
				<s:hidden id="supervisorId" name="supervisorId" value="%{supervisorId}"></s:hidden>
				<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
				<table style="width:100%;" cellspacing="0" cellpadding="0" class="t-entRegFrm">
					<tr>
						<td style="width: 20%; text-align: right;">研究内容和执行情况（1000字以内）</td>
						<td><div><textarea class="inputA" name="研究内容和执行情况" id="studyContent" style="width:90%; height:150px;resize:none;" onblur="upms.upmsUtils.blurTextCheck(this,'研究内容和执行情况', 0, 8, 1000);" onfocus="upms.upmsUtils.textFocus(this);" onkeyup="upms.upmsUtils.blurTextCheck(this,'研究内容和执行情况', 0, 8, 1000);"><s:property value="supervisorReport.studyContent"/></textarea></div></td>
					</tr>
					<tr>
						<td style="width: 20%; text-align: right;">各项指标完成情况（1000字以内）</td>
						<td><div><textarea class="inputA" name="各项指标完成情况" id="everyIndex" style="width:90%; height:150px;resize:none;" onblur="blurText(this)" onfocus="focusText(this);" onKeyUp="this.value = checkTextareaLength(this.value,1000)"><s:property value="supervisorReport.everyIndex"/></textarea></div></td>
					</tr>
					<tr>
						<td style="width: 20%; text-align: right;">知识产权情况（1000字以内）</td>
						<td><div><textarea class="inputA" name="知识产权情况" id="knowledgeProperty" style="width:90%; height:150px;resize:none;" onblur="blurText(this)" onfocus="focusText(this);" onKeyUp="this.value = checkTextareaLength(this.value,1000)"><s:property value="supervisorReport.knowledgeProperty"/></textarea></div></td>
					</tr>
					<tr>
						<td style="width: 20%; text-align: right;">个人培养与队伍建设（1000字以内）</td>
						<td><div><textarea class="inputA" name="个人培养与队伍建设" id="personalDevelop" style="width:90%; height:150px;resize:none;" onblur="blurText(this)" onfocus="focusText(this);" onKeyUp="this.value = checkTextareaLength(this.value,1000)"><s:property value="supervisorReport.personalDevelop"/></textarea></div></td>
					</tr>
					<tr>
						<td style="width: 20%; text-align: right;">资金到位情况（1000字以内）</td>
						<td><div><textarea class="inputA" name="资金到位情况" id="fundCase" style="width:90%; height:150px;resize:none;" onblur="blurText(this)" onfocus="focusText(this);" onKeyUp="this.value = checkTextareaLength(this.value,1000)"><s:property value="supervisorReport.fundCase"/></textarea></div></td>
					</tr>
					<tr>
						<td style="width: 20%; text-align: right;">经费使用情况（1000字以内）</td>
						<td><div><textarea class="inputA" name="经费使用情况" id="fundsCase" style="width:90%; height:150px;resize:none;" onblur="blurText(this)" onfocus="focusText(this);" onKeyUp="this.value = checkTextareaLength(this.value,1000)"><s:property value="supervisorReport.fundsCase"/></textarea></div></td>
					</tr>
					<tr>
						<td style="width: 20%; text-align: right;">实施及其管理经验（1000字以内）</td>
						<td><div><textarea class="inputA" name="实施及其管理经验" id="managerExperience" style="width:90%; height:150px;resize:none;" onblur="blurText(this)" onfocus="focusText(this);" onKeyUp="this.value = checkTextareaLength(this.value,1000)"><s:property value="supervisorReport.managerExperience"/></textarea></div></td>
					</tr>
					<tr>
						<td style="width: 20%; text-align: right;">存在问题（1000字以内）</td>
						<td><div><textarea class="inputA" name="存在问题" id="existQuestion" style="width:90%; height:150px;resize:none;" onblur="blurText(this)" onfocus="focusText(this);" onKeyUp="this.value = checkTextareaLength(this.value,1000)"><s:property value="supervisorReport.existQuestion"/></textarea></div></td>
					</tr>
				</table>
			</div>
			<div align="center" style="width: 95%">
				<input class="button save" id="saveBtn" type="button" value="保存"/>
				<input class="button save" id="backBtn" type="button" value="返回"/>
			</div>
		</div>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/js/supervisorReport_audit.js"></script>
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<label id="comfirmSubmit" style="display: none"><s:text name="confirm_submit_info"/></label>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目工作报告</div>
				<s:hidden id="supervisorId" name="supervisorId" value="%{supervisorId}"></s:hidden>
				<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
				<s:hidden id="reportId" name="reportId" value="%{supervisorReport.reportId}"></s:hidden>
				<table style="width:100%;" cellspacing="0" cellpadding="0" class="t-entRegFrm">
					<tr>
						<td style="width: 23%; text-align: right;">研究内容和执行情况（1000字以内）</td>
						<td><s:property value='%{supervisorReport.studyContent}'/></td>
					</tr>
					<tr>
						<td style="width: 23%; text-align: right;">各项指标完成情况（1000字以内）</td>
						<td><s:property value='%{supervisorReport.everyIndex}'/></td>
					</tr>
					<tr>
						<td style="width: 23%; text-align: right;">知识产权情况（1000字以内）</td>
						<td><s:property value='%{supervisorReport.knowledgeProperty}'/></td>
					</tr>
					<tr>
						<td style="width: 23%; text-align: right;">个人培养与队伍建设（1000字以内）</td>
						<td><s:property value='%{supervisorReport.personalDevelop}'/></td>
					</tr>
					<tr>
						<td style="width: 23%; text-align: right;">资金到位情况（1000字以内）</td>
						<td><s:property value='%{supervisorReport.fundCase}'/></td>
					</tr>
					<tr>
						<td style="width: 23%; text-align: right;">经费使用情况（1000字以内）</td>
						<td><s:property value='%{supervisorReport.fundsCase}'/></td>
					</tr>
					<tr>
						<td style="width: 23%; text-align: right;">实施及其管理经验（1000字以内）</td>
						<td><s:property value='%{supervisorReport.managerExperience}'/></td>
					</tr>
					<tr>
						<td style="width: 23%; text-align: right;">存在问题（1000字以内）</td>
						<td><s:property value='%{supervisorReport.existQuestion}'/></td>
					</tr>
					<tr>
						<td style="width: 23%; text-align: right;">监理机构意见</td>
						<td><textarea id="checkInfo" name="checkInfo" class="inputA" style="width:99%; height:100px;resize:none;" onblur="upms.upmsUtils.blurTextCheck(this,'监理机构意见', 0, 8, 1000);" onfocus="upms.upmsUtils.textFocus(this);" onkeyup="upms.upmsUtils.checkTextareaLength(this, 1000);"><s:property value='%{supervisorReport.checkInfo}'/></textarea></td>
						<s:hidden id="hiddencheckInfo" name="hidden" value="监理机构意见,0,8,1000"></s:hidden>
					</tr>
				</table>
			</div>
			<div align="center" style="width: 95%">
				<input class="button save" id="saveBtn" name="saveBtn" type="button" value="保存"/>
				<input class="button save" id="submitBtn" name="submitBtn" type="button" value="提交"/>
				<input class="button save" id="backBtn" name="backBtn" type="button" value="返回"/>
			</div>
		</div>
	</div>
</div>
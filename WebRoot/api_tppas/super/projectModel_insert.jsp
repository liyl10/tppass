<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/super/js/projectModel_insert.js"></script>
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
 			<s:if  test="%{reportTemplateId == '' || reportTemplateId == null}">
				<div class="abuot07">项目申报模板_新增</div>
			</s:if>
			<s:else>
				<div class="abuot07">项目申报模板_修改</div>
			</s:else>
				<div class="abuot03">
					<input type="hidden" id="reportTemplateId" name="reportTemplateId" value="<s:property value='%{reportTemplateId}' escape='true'/>" />
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="40%" style="padding: 4px 8px; text-align: right">
								申报模板名称
							</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input id="tprojectReportTemplate.reportTemplateName" value="<s:property value='%{tprojectReportTemplate.reportTemplateName}' escape='true'/>"  name="tprojectReportTemplate.reportTemplateName" type="text" style="width: 23em; height:1.6em;" class="inputA"/>
							</td>
						</tr>	
						<tr>
							<td width="40%" style="padding: 4px 8px; text-align: right">
								保存地址
							</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input id="tprojectReportTemplate.saveUrl" value="<s:property value='%{tprojectReportTemplate.saveUrl}' escape='true'/>" name="tprojectReportTemplate.saveUrl" type="text" style="width: 23em; height:1.6em;" class="inputA"/>
							</td>
						</tr>
						<tr>
							<td width="40%" style="padding: 4px 8px; text-align: right">
								修改地址
							</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input id="tprojectReportTemplate.updateUrl" value="<s:property value='%{tprojectReportTemplate.updateUrl}' escape='true'/>" name="tprojectReportTemplate.updateUrl" type="text" style="width: 23em; height:1.6em;" class="inputA"/>
							</td>
						</tr>
						<tr>
							<td width="40%" style="padding: 4px 8px; text-align: right">
								查看地址
							</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input id="tprojectReportTemplate.viewUrl" value="<s:property value='%{tprojectReportTemplate.viewUrl}' escape='true'/>" name="tprojectReportTemplate.viewUrl" type="text" style="width: 23em; height:1.6em;" class="inputA"/>
							</td>
						</tr>
						<tr>
							<td width="40%" style="padding: 4px 8px; text-align: right">
								删除地址
							</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input id="tprojectReportTemplate.deleteUrl" value="<s:property value='%{tprojectReportTemplate.deleteUrl}' escape='true'/>" name="tprojectReportTemplate.deleteUrl" type="text" style="width: 23em; height:1.6em;" class="inputA"/>
							</td>
						</tr>
						<tr>
							<td width="40%" style="padding: 4px 8px; text-align: right">
								初审地址
							</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input id="tprojectReportTemplate.trialUrl" value="<s:property value='%{tprojectReportTemplate.trialUrl}' escape='true'/>" name="tprojectReportTemplate.trialUrl" type="text" style="width: 23em; height:1.6em;" class="inputA"/>
							</td>
						</tr>
						<tr>
							<td width="40%" style="padding: 4px 8px; text-align: right">
								审核地址
							</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input id="tprojectReportTemplate.auditUrl" value="<s:property value='%{tprojectReportTemplate.auditUrl}' escape='true'/>" name="tprojectReportTemplate.auditUrl" type="text" style="width: 23em; height:1.6em;" class="inputA"/>
							</td>
						</tr>
						<tr>
							<td width="40%" style="padding: 4px 8px; text-align: right">
								专家评审地址
							</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input id="tprojectReportTemplate.expertAuditUrl" value="<s:property value='%{tprojectReportTemplate.expertAuditUrl}' escape='true'/>" name="tprojectReportTemplate.expertAuditUrl" type="text" style="width: 23em; height:1.6em;" class="inputA"/>
							</td>
						</tr>
						<tr>
							<td width="40%" style="padding: 4px 8px; text-align: right">
								专家论证地址
							</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input id="tprojectReportTemplate.expertProofUrl" value="<s:property value='%{tprojectReportTemplate.expertProofUrl}' escape='true'/>" name="tprojectReportTemplate.expertProofUrl" type="text" style="width: 23em; height:1.6em;" class="inputA"/>
							</td>
						</tr>
						<tr>
							<td width="40%" style="padding: 4px 8px; text-align: right">
								处长审核地址
							</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input id="tprojectReportTemplate.leadershipAuditUrl" value="<s:property value='%{tprojectReportTemplate.leadershipAuditUrl}' escape='true'/>" name="tprojectReportTemplate.leadershipAuditUrl" type="text" style="width: 23em; height:1.6em;" class="inputA"/>
							</td>
						</tr>
						<tr>
							<td width="40%" style="padding: 4px 8px; text-align: right">
								联席会审核地址
							</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input id="tprojectReportTemplate.meetingAuditUrl" value="<s:property value='%{tprojectReportTemplate.meetingAuditUrl}' escape='true'/>" name="tprojectReportTemplate.meetingAuditUrl" type="text" style="width: 23em; height:1.6em;" class="inputA"/>
							</td>
						</tr>
					<div style="display: block; text-align: center; margin-top: 12px">
<%-- 					<tag:auth code="ss.projectModel_insert.save"> --%>
							<a class="button save" name="btnSave"
							id="btnSave"  >保存</a>
<%-- 					</tag:auth> --%>
<%-- 					<tag:auth code="ss.projectModel_insert.return"> --%>
							<a class="button back" name="reBtn"
							id="reBtn"  >返回</a>	
<%-- 					</tag:auth> --%>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>

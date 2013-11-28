<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/super/js/typeModel_insert.js"></script>
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<s:hidden id="hiddendepartmentId1" name="hiddendepartmentId1" value="%{tprojectType.departmentId}"></s:hidden>
<s:hidden id="hiddenisShow1" name="hiddenisShow1" value="%{tprojectType.isShow}"></s:hidden>
<s:hidden id="hiddenisWrite1" name="hiddenisWrite1" value="%{tprojectType.isWrite}"></s:hidden>
<s:hidden id="hiddentimeArea1" name="hiddentimeArea1" value="%{tprojectType.timeArea}"></s:hidden>
<s:hidden id="hiddenparentTypeId1" name="hiddenparentTypeId1" value="%{tprojectType.parentTypeId}"></s:hidden>
<s:hidden id="hiddenreportTemplateId1" name="hiddenreportTemplateId1" value="%{tprojectType.tprojectReportTemplate.reportTemplateId}"></s:hidden>
<s:hidden id="hiddencontractTemplateId1" name="hiddencontractTemplateId1" value="%{tprojectType.tprojectContractTemplate.contractTemplateId}"></s:hidden>
<s:hidden id="hiddensupervisionTemplateId1" name="hiddensupervisionTemplateId1" value="%{tprojectType.tprojectSupervisionTemplate.supervisionTemplateId}"></s:hidden>
<s:hidden id="hiddenacceptanceTemplateId1" name="hiddenacceptanceTemplateId1" value="%{tprojectType.tprojectAcceptanceTemplate.acceptanceTemplateId}"></s:hidden>

<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
 			<s:if  test="%{typeId == '' || typeId == null}">
				<div class="abuot07">项目分类_新增</div>
			</s:if>
			<s:else>
				<div class="abuot07">项目分类_修改</div>
			</s:else>
				<div class="abuot03">
					<input type="hidden" id="typeId" name="typeId" value="<s:property value='%{typeId}' escape='true'/>" />
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td style="padding: 4px 8px; text-align: right">
								真实名称
							</td>
							<td style="padding: 4px 8px; text-align: left" width="60%" >
								<input id="typeRealName" value="<s:property value='%{tprojectType.typeRealName}' escape='true'/>"  name="tprojectType.typeRealName" type="text" style="width: 23em; height:1.6em;" class="inputA"
								onfocus="upms.upmsUtils.textFocus(this);" 
								onblur="upms.upmsUtils.blurTextCheck(this,'真实名称',1,-1)" />
								<s:hidden id="hiddentypeRealName"  value="真实名称"></s:hidden>
							</td>
						</tr>	
						<tr>
							<td style="padding: 4px 8px; text-align: right">
								显示名称
							</td>
							<td style="padding: 4px 8px; text-align: left" width="60%" >
								<input id="typeShowName" value="<s:property value='%{tprojectType.typeShowName}' escape='true'/>" name="tprojectType.typeShowName" type="text" style="width: 23em; height:1.6em;" class="inputA"
								onfocus="upms.upmsUtils.textFocus(this);" 
								onblur="upms.upmsUtils.blurTextCheck(this,'显示名称',1,-1)" />
								<s:hidden id="hiddentypeShowName"  value="显示名称"></s:hidden>
							</td>
						</tr>
						<tr>
							<td style="padding: 4px 8px; text-align: right">
								所属部门
							</td>
							<td style="padding: 4px 8px; text-align: left" width="60%"><div><s:select
										list="type1List" listKey="deptId"
										style="width:15em" listValue="deptName" id="typeId1"
										name="tprojectType.departmentId" value="%{tprojectType.departmentId}"></s:select>
								<s:hidden id="hiddentypeId1"  value="所属部门"></s:hidden>
								</div>
							</td>

						</tr>
						<tr>
							<td style="padding: 4px 8px; text-align: right">
								上级分类
							</td>
							<td style="padding: 4px 8px; text-align: left" width="60%"><s:select
										list="type2List" listKey="typeId"
										style="width:15em" listValue="typeShowName" id="typeId2"
										name="parentTypeId" value="%{tprojectType.parentTypeId}"></s:select>
							</td>
						</tr>
						<tr >
							<td style="padding: 4px 8px; text-align: right">
								是否显示
							</td>
							<td style="padding: 4px 8px; text-align: left" width="60%">
							<div>
								<select	style="width:15em" id="isShow"	name="tprojectType.isShow" value="%{tprojectType.isShow}">
								        <option value="0" ${tprojectType.isShow==0?'selected':''}>是</option>
									    <option value="1" ${tprojectType.isShow==1?'selected':''}>否</option>
								</select>
							</div>
								<s:hidden id="hiddenisShow"  value="是否显示"></s:hidden>
								
							</td>
						</tr>
							<tr id="reportTemplateDiv">
								<td style="padding: 4px 8px; text-align: right">
									申报模板
								</td>
								<td style="padding: 4px 8px; text-align: left" width="60%"><s:select
											list="reportList" listKey="reportTemplateId"
											style="width:15em" listValue="reportTemplateName" id="reportTemplateId"
											name="tprojectType.tprojectReportTemplate.reportTemplateId" value="%{tprojectType.tprojectReportTemplate.reportTemplateId}"></s:select>
								</td>
							</tr>
						<tr id="contractTemplateDiv">
							<td style="padding: 4px 8px; text-align: right" >
								合同模板
							</td>
							<td style="padding: 4px 8px; text-align: left" width="60%"><s:select
										list="contractList" listKey="contractTemplateId"
										style="width:15em" listValue="contractTemplateName" id="contractTemplateId"
										name="tprojectType.tprojectContractTemplate.contractTemplateId" value="%{tprojectType.tprojectContractTemplate.contractTemplateId}"></s:select>
							</td>
						</tr>
						<tr id="supervisionTemplateDiv">
							<td style="padding: 4px 8px; text-align: right">
								监理模板
							</td>
							<td style="padding: 4px 8px; text-align: left" width="60%"><s:select
										list="supervisionList" listKey="supervisionTemplateId"
										style="width:15em" listValue="supervisionTemplateName" id="supervisionTemplateId"
										name="tprojectType.tprojectSupervisionTemplate.supervisionTemplateId" value="%{tprojectType.tprojectSupervisionTemplate.supervisionTemplateId}"></s:select>
							</td>
						</tr>
						<tr id="acceptanceTemplateDiv">
							<td style="padding: 4px 8px; text-align: right">
								验收模板
							</td>
							<td style="padding: 4px 8px; text-align: left" width="60%"><s:select
										list="acceptanceList" listKey="acceptanceTemplateId"
										style="width:15em" listValue="acceptanceTemplateName" id="acceptanceTemplateId"
										name="tprojectType.tprojectAcceptanceTemplate.acceptanceTemplateId" value="%{tprojectType.tprojectAcceptanceTemplate.acceptanceTemplateId}"></s:select>
							</td>
						</tr>
						 <tr id="isWriteDiv">
							<td style="padding: 4px 8px; text-align: right">
								企业项目信息表是否填写
							</td>
							<td style="padding: 4px 8px; text-align: left" width="60%">
							<div>
								<select	style="width:15em" id="isWrite"	name="tprojectType.isWrite" value="%{tprojectType.isShowName}">
								        <option value="0" ${tprojectType.isWrite==0?'selected':''}>是</option>
									    <option value="1" ${tprojectType.isWrite==1?'selected':''}>否</option>
								</select>
							</div>
								<s:hidden id="hiddenisWrite"  value="企业项目信息表是否填写"></s:hidden>
								
							</td>
						</tr>
						<tr id="timeListDiv">
							<td style="padding: 4px 8px; text-align: right">
								执行期跨度
							</td>
							<div>
							<td style="padding: 4px 8px; text-align: left" width="60%"><s:select
										list="timeList" listKey="itemId"
										style="width:15em" listValue="itemName" id="timeArea"
										name="tprojectType.timeArea" value="%{tprojectType.timeArea}"></s:select>
							</td>
							</div>
							<s:hidden id="hiddentimeArea"  value="执行期跨度"></s:hidden>
						</tr>
						<tr id="remarkDiv">
							<td style="padding: 4px 8px; text-align: right">
								备注
							</td>
							<td style="padding: 4px 8px; text-align: left" width="60%">
								<textarea id="remark" name="tprojectType.remark" class="inputA" style="width:500px;height:100px" onblur="upms.upmsUtils.blurTextCheck(this,'备注',0,8,1000);"onfocus="upms.upmsUtils.textFocus(this);"onfocus="upms.upmsUtils.textFocus(this);"onKeyUp="this.value = upms.upmsUtils.checkTextareaLength(this.value, 1000);"><s:property value='%{tprojectType.remark}' escape='true'/></textarea>	
							</td><s:hidden id="hiddenremark" name="hidden" value="备注,0,8,1000"></s:hidden>
						</tr>
					</table>
					<div style="display: block; text-align: center; margin-top: 12px">
<%-- 					<tag:auth code="ss.contractModel_insert.save"> --%>
							<a class="button save" name="btnSave"
							id="btnSave"  >保存</a>
<%-- 					</tag:auth> --%>
<%-- 					<tag:auth code="ss.contractModel_insert.return"> --%>
							<a class="button back" name="reBtn"
							id="reBtn"  >返回</a>	
<%-- 					</tag:auth> --%>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

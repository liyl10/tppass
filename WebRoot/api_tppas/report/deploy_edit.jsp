<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/js/deploy_edit.js"></script>
<div align="center" style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目调配修改</div>
				<div>
					<table
						style="width: 100%; border: 1px; margin: 0px; padding: 0px; border-collapse: collapse;"
						class="t-entRegFrm">
						<tr>
							<td align="right" style="width: 30%">项目名称</td>
							<td style="width: 60%"><s:property
									value="%{project.projectName}" escape="true" />
									<s:hidden id="projectId" value="%{project.projectId}"/></td>
						</tr>
						<tr>
							<td align="right">申报单位</td>
							<td><s:property value="%{project.applicationUnit}"
									escape="true" /></td>
						</tr>
						<tr>
							<td align="right">项目分类</td>
							<td><s:property value="%{project.planFlagName + '-' + project.typeName}" escape="true" />
								<s:hidden id="beforeTypeId" value="%{project.typeId}"/>
								<s:hidden id="beforeDeptId" value="%{project.deptId}"/>
								<s:hidden id="highTechDeptId" value="%{@com.hopsun.tppas.common.Constants@HIGHTECH_DEPARTMENT}"/>
							</td>
						</tr>
						<tr>
							<td align="right">项目所属领域</td>
							<td><s:property value="%{project.technicalFisldName}"
									escape="true" /></td>
						</tr>
						<tr>
							<td align="right">申报年度</td>
							<td><s:property value="%{project.reportYear}" escape="true" /></td>
						</tr>
						<tr>
							<td align="right"><FONT color=red>*</FONT>重新选择项目分类</td>
							<td><s:select list="deptList" style="width:200px"
									listKey="deptId" listValue="deptName" id="selectedProject1"
									name="selectedDeptId"></s:select> 
								<s:select list="projectTypeFirstList" style="width:200px"
									listKey="typeId" listValue="typeShowName" id="selectedProject2"
									name="selectedProjectTypeFirst"></s:select> 
								<s:select list="projectTypeSecondList" style="width:200px"
									listKey="typeId" listValue="typeShowName" id="selectedProject3"
									name="selectedProjectTypeSecond"></s:select> <s:hidden
									id="hiddenselectedProject3" name="hidden" value="项目分类,1,-1"></s:hidden>
							</td>
						</tr>
						<tr>
							<td align="right">调配意见</td>
							<td><s:textarea id="deployComment" value="%{deployComment}"
									cssStyle="width: 60%; height: 100px;resize: none;"
									onblur="upms.upmsUtils.blurTextCheck(this,'调配意见',0,8,1000)"
									onfocus="upms.upmsUtils.textFocus(this)"
									onKeyUp="upms.upmsUtils.checkTextareaLength(this, 1000);"></s:textarea>
								<s:hidden id="hiddendeployComment" name="hidden"
									value="调配意见,0,8,1000"></s:hidden>
						</tr>
						<tr>
							<td align="center" colspan="2"><input class="button"
								type="button" id="comitBtn" value="提交" /> <input class="button"
								type="button" onClick="backbt();" value="返回" /></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
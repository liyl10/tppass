<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/plan/planManage/js/unselect_project_list.js"></script>
<label id="comfirmCancel" style="display: none"><s:text name="confirm_cancel_info"/></label>
<div style="border-bottom: 1px dashed #C9DEEE;"></div>
	<s:hidden id="selectedId" name="selectedId"></s:hidden>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
		<tr align="center">
			<th width="5%">
				<s:checkbox name="" id="selectAll" onclick="selectAll();" expertFlag=""></s:checkbox>
			</th>
			<th width="10%">项目编号</th>
		    <th width="15%">项目名称</th>
		    <th width="15%">申报单位</th>
		    <th width="30%">技术领域</th>
		    <th width="25%">项目分类</th>
		</tr>
		<s:if test="unselectProList.size > 0">
			<s:iterator value="unselectProList" status="rowData">
				<tr>
					<td align="center">
						<input type="checkbox" value="${projectId}" onclick="saveOrDelSelect(this);"/>
					</td>
					<td>
						<s:property value="%{projectNumber}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{projectName}" escape="true"/>
					</td>
					<td>
						<s:property value="%{applicationUnit}" escape="true"/>
					</td>
					<td>
						<s:property value="%{technicalFisld}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{projectTypeName}" escape="true"/>&nbsp;
					</td>
				</tr>
			</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<td colspan="6">
					没有查到任何记录!&nbsp;
				</td>
			</tr>
		</s:else>
	</table>
	
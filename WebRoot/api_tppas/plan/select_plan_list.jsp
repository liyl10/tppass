<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/api_tppas/plan/js/select_plan_list.js"></script>
<label id="path" style="display: none;">${pageContext.request.contextPath}</label>
<s:hidden id="selectedId" name="selectedId"></s:hidden>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	class="t-list">
	<tr align="center">
		<th width="5%"><input type="checkbox" name="allSelect" id="allSelect"/></th>
		<th width="15%">分计划名称</th>
		<th width="25%">项目分类</th>
		<th width="10%">计划年度</th>
		<th width="10%">计划批次</th>
		<th width="15%">分计划状态</th>
	</tr>
	<s:if test="selectPlanList.size > 0">
		<s:iterator value="selectPlanList" status="rowData">
			<tr>
				<td align="center"><input type="checkbox" name="planList"
									value=<s:property value="%{planId}"/>></td>
				<td><%-- <a href="javascript: void(0);" class="uline single"
					onClick="showPlanDetail('${planId}');">  --%><s:property value="%{planName}" escape="true" />
				<!-- </a> --></td>
				<td>
					<s:property value="%{projectTypeName}" escape="true"/>
				</td>
				<td align="center"><s:property value="%{planYear}" escape="true" /></td>
				<td align="center"><s:property value="%{planBatch}" escape="true" /></td>
				<td><s:property value="%{planState}" escape="true" /></td>
			</tr>
		</s:iterator>
	</s:if>
	<s:else>
		<tr>
			<td colspan="7">没有查到任何记录!&nbsp;</td>
		</tr>
	</s:else>
</table>
<div style="text-align: center">
	<input class="button" type="button" id="commitBtn" value="提交" />
	<input class="button" type="button" id="backBtn" value="返回" />
</div>
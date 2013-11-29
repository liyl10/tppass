﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/statistics/industry/js/project_export.js"></script>

<!-- 导出页面S-->
<div id="exportDiv">
	<!-- <h3 class="ui-widget-header">统计页面</h3> -->
	<div id="dcAllBut" align="right">
			<input type="button" class="button" name="allSelect" id="allSelect1" value="全选" onclick="checkAll();"/>
			<input type="button" class="button" name="allNoSelect" id="allNoSelect1" value="全不选" onclick="noCheckAll();"/>
			<input type="button" class="button" name="exportBtn" id="exportBtn1" value="导出" onclick="exportDatas();"/>
	</div>
	<form id="exportForm" name="exportForm" method="post">
		<table class="t-form">
			<tr>
			<s:iterator id="subList" status="st" value="columnList">
				<s:if test="%{(#st.count)%4 == 0}">
						<td width="25%" class="lbl">
						<s:checkbox type="checkbox" id="%{columnId}" name="columnName1" value="true" temp="checkFlag"></s:checkbox><s:property value="%{columnName}" escape="true"/>
						</td>
					</tr>
					<tr>
				</s:if>
				<s:else>
					<td width="25%" class="lbl">
						<s:checkbox type="checkbox" id="%{columnId}" name="columnName1" value="true" temp="checkFlag"></s:checkbox><s:property value="%{columnName}" escape="true"/>
					</td>
				</s:else>
			</s:iterator>
		</table>
	</form>
	<div id="dcAllBut" align="right">
			<input type="button" class="button" name="allSelect" id="allSelect" value="全选" onclick="checkAll();"/>
			<input type="button" class="button" name="allNoSelect" id="allNoSelect" value="全不选" onclick="noCheckAll();"/>
			<input type="button" class="button" name="exportBtn" id="exportBtn" value="导出" onclick="exportDatas();"/>
	</div>				
</div>
<!-- 导出页面E-->

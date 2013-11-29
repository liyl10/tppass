﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/statistics/js/statistics_project_export.js"></script>

<!-- 导出页面S-->
<div id="exportDiv">
	<h3 class="ui-widget-header">统计页面</h3>
	<form id="exportForm" name="exportForm" method="post">
		<table class="t-form">
			<s:set name="snum" value="1"/>
			<s:iterator id="subList" status="st" value="subPageList">
				<s:iterator value="subList">
				<s:if test="%{#snum == 1}">
					<tr>
				</s:if>
				<td width=3% align="center">
					<div align="center">
						<input type="checkbox" name="mapList" id="mapList" checked=checked
							value="<s:property value='key' escape='true'/>" />
					</div>
				</td>
				<td width=22% class="lbl"><s:property value="value"/></td>

				<s:if test="%{#snum == 4}">
					</tr>
					<s:set name="snum" value="0"/>
				</s:if>
				<s:set name="snum" value="#snum+1"/>
				</s:iterator>
			</s:iterator>
		</table>
	</form>
	<div id="dcAllBut" align="right">
		<tag:auth code="ss.countdatas.allSelect">
			<input type="button" class="button" name="allSelect" id="allSelect" value="全选" onclick="checkAll();"/>
		</tag:auth>
		<tag:auth code="ss.countdatas.allNoSelect">
			<input type="button" class="button" name="allNoSelect" id="allNoSelect" value="全不选" onclick="noCheckAll();"/>
		</tag:auth>
		<tag:auth code="ss.countdatas.export">
			<input type="button" class="button" name="exportBtn" id="exportBtn" value="导出" onclick="exportDatas();"/>
		</tag:auth>
	</div>				
</div>
<!-- 导出页面E-->

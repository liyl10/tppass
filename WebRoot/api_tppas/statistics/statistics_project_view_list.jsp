<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/statistics/js/statistics_project_view_list.js"></script>
<s:hidden id="yearEquals" name="yearEquals" value="%{yearEquals}"></s:hidden>
<div style="border-bottom: 1px dashed #C9DEEE;"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
		<tr align="center">
		    <th width="13%">年度</th>
		    <th width="17%">项目总数</th>
		    <th width="17%">未初审项目数</th>
		    <th width="17%">未通过项目数</th>
		    <th width="17%">已通过初审未验收项目数</th>
		    <th width="17%">已通过已验收项目数</th>
		</tr>
	<s:if test="projectList.size > 0">
			<s:iterator value="projectList" status="rowData">
				<tr align=middle>
					<td><div align="left">
							<s:property value='%{reportYear}' escape='true' />
							<s:hidden id="reportYear%{#rowData.count}" value="%{reportYear}"></s:hidden>
						</div></td>
					<td><div align="left">
							<s:property value='%{projectTotal}' escape='true' />
							<s:hidden id="projectTotal%{#rowData.count}" value="%{projectTotal}"></s:hidden>
						</div></td>
					<td><div align="left">
							<s:property value='%{noViewProjectTotal}' escape='true' />
							<s:hidden id="noViewProjectTotal%{#rowData.count}" value="%{noViewProjectTotal}"></s:hidden>
						</div></td>
					<td><div align="left">
							<s:property value='%{noPassProject}' escape='true' />
							<s:hidden id="noPassProject%{#rowData.count}" value="%{noPassProject}"></s:hidden>
						</div></td>
					<td><div align="left">
						<s:property value='%{noAcceptanceProject}' escape='true' />
						<s:hidden id="noAcceptanceProject%{#rowData.count}" value="%{noAcceptanceProject}"></s:hidden>
					</div></td>
					<td><div align="left">
						<s:property value='%{passAcceptanceProject}' escape='true' />
						<s:hidden id="passAcceptanceProject%{#rowData.count}" value="%{passAcceptanceProject}"></s:hidden>
					</div></td>
					
				</tr>
			</s:iterator>
		</s:if>
		<s:else>
			<TR>
				<td colspan="12" align="left">没有查到任何记录!</td>
			</TR>
		</s:else>
	</table>
	<%--<s:if test="%{projectViewType =='' && projectViewType == @com.hopsun.tppas.common.Constants@PROJECT_ZVIEW_TYPE_STATE}">--%> 
	<s:if test="projectList.size > 0">
		<s:if test="%{yearEquals == 1}">
			<div id="containerPie" style="min-width: 100px; height: 200px; margin: 0 auto"></div>
		</s:if>
		<s:else> 
			<div id="containerColumn" style="min-width: 100px; height: 200px; margin: 0 auto"></div>
	    </s:else> 
	</s:if>
<%-- <s:if test="pager.list.size > 0">
	<div class="page">
		<div class="pgtotal">
			共<em>${pager.totalCount}</em>条记录;
		</div>
		<div class="pgtotal">
			总共<em>${pager.pageCount}</em>页
		</div>
		<span> 跳转至第 <input type="text" id="goPageNo" name="goPageNo"
			style="width: 30px; height: 16px;"
			onkeyup='this.value=this.value.replace(/[^0-9]\D*$/,"")'
			autocomplete="off" /> 页 <input type="button" class="button"
			style="margin: -0.2em" value="确定" id="goBtn" name="goBtn" />
		</span> <span id="pgbtn"></span>
		<div class="clear"></div>
		<input type="hidden" id="pageNo" name="pager.pageNumber"
			value="${pager.pageNumber}" /> <input type="hidden"
			id="totalRecords" name="pager.totalCount" value="${pager.totalCount}" />
		<input type="hidden" id="totalPages" name="pager.pageCount"
			value="${pager.pageCount}" />
	</div>
</s:if> --%>
<!-- 查询结果列表E -->
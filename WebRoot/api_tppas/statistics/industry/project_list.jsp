﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/statistics/industry/js/project_list.js"></script>

<!-- 查询结果列表S -->
  <s:hidden id="count" name="hidden" value="%{pager.pageCount}"></s:hidden>
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
    <tr align="center">
      <th>序号</th>
      <th>项目名称</th>
      <th>承担单位</th>
      <th>归口管理部门</th>
      <th>项目年度</th>
      <th>项目分类</th>
      <th>申报状态</th>
      <th>合同状态</th>
      <th>验收状态</th>
 <%--    <th>操作</th>--%>  
    </tr>
    <s:if test="pager.list.size > 0">
	<s:iterator value="pager.list" status="rowData">
	<tr>
		<td>${(pager.pageNumber-1)*pager.pageSize+rowData.count}</td>
		<td>
			<a href="javascript: void(0);" onclick="viewProjectReportInfo('${projectId}','<s:property value="#application[typeIdCode+'-sb-edit']"/>');">
				<s:property value='%{projectName}' escape='true'/>
			</a>
		</td>
		<td>
			<a href="javascript: void(0);" onclick="viewCompanyInfo('${projectId}');">
				<s:property value='%{applicationUnit}' escape='true'/>
			</a>
		</td>
		<td>
			<s:property value='%{centralizedType}' escape='true'/>
		</td>
		<td>
			<s:property value='%{startTime}' escape='true'/>/
			<s:property value='%{endTime}' escape='true'/>
		</td>
		<td>
			<s:property value='%{projectType}' escape='true'/>
		</td>
		<td>
			<s:property value='%{applyStatus}' escape='true'/>
		</td>
		<td>
			<s:property value='%{contractStatus}' escape='true'/>
		</td>
		<td>
			<s:property value='%{acceptanceStatus}' escape='true'/>
		</td>
	</tr>
	</s:iterator>
	</s:if>
	<s:else>
	<tr>
		<td colspan="12">没有查到任何记录!&nbsp;</td>
	</tr>
	</s:else>
  </table>
  <s:if test="pager.list.size > 0">
	<div class="page">
		<div class="pgtotal">
			共<em>${pager.totalCount}</em>条记录;
		</div>
		<div class="pgtotal">
			总共<em>${pager.pageCount}</em>页
		</div>
		<span> 跳转至第 <input type="text" id="goPageNo"
				name="goPageNo" style="width: 30px; height: 16px;"
				onkeyup='this.value=this.value.replace(/[^0-9]\D*$/,"")'
				autocomplete="off" /> 页
			<input type="button" class="button" style="margin:-0.2em" value="确定" id="goBtn" name="goBtn" />
		</span>
		<span id="pgbtn"></span>
		<div class="clear"></div>
		<input type="hidden" id="pageNo" name="pager.pageNumber" value="${pager.pageNumber}" />
			<input type="hidden" id="totalRecords" name="pager.totalCount"
			value="${pager.totalCount}" /> <input type="hidden" id="totalPages"
			name="pager.pageCount" value="${pager.pageCount}" />
	</div>
</s:if>

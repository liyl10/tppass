<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/query/js/project_list.js"></script>
<!-- 查询结果列表S -->
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
    <tr align="center">
      <th>序号</th>
      <th>项目名称</th>
      <th>承担单位</th>
      <th>归口管理部门</th>
      <th>项目年度</th>
      <th>项目分类</th>
      <th>是否立项</th>
      <th>验收状态</th>
    </tr>
    <s:if test="pager.list.size > 0">
	<s:iterator value="pager.list" status="rowData">
	<tr>
		<td>${(pager.pageNumber-1)*pager.pageSize+rowData.count}</td>
		<td><a href="javascript: void(0);" onclick="viewProjectReportInfo('${projectId}','<s:property value="#application[typeId+'-sb-edit']"/>');"><s:property value='%{projectName}' escape='true'/></a></td>
		<td><a href="javascript: void(0);" onclick="companyInfoReview('${projectId}')"><s:property value='%{applicationUnit}' escape='true'/></a></td>
		<td><s:property value='%{centralizedTypeName}' escape='true'/></td>
		<td><s:date name="%{startTime}" format="yyyy年MM月"/>&nbsp;～&nbsp;<s:date name="%{endTime}" format="yyyy年MM月"/></td>
		<td><s:property value='%{planFlagName}' escape='true'/><s:property value='@com.hopsun.tppas.common.Constants@STRING_LINK' escape='true'/><s:property value='%{typeName}' escape='true'/></td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
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

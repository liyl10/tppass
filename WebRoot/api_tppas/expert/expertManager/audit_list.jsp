<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/expert/expertManager/js/audit_list.js"></script>
<table id='testtab' border=0 cellSpacing=0 cellPadding=0 width="100%" class="t-list" >
	<tr>
	  <th width="5%">序号</th>
      <th width="17%">项目名称</th>
	  <th width="10%">申报单位</th>
	  <th width="10%">单位性质</th>
	  <th width="10%">当前阶段</th>
	  <th width="20%">项目分类</th>
      <th width="10%">技术领域</th>
	  <th width="10%">状态</th>
	  <th width="8%">操作</th>
	</tr>
    <s:if test="pager.list.size > 0">
    	<s:iterator value="pager.list" status="rowData">
      		<tr align="middle">
      			<td align="left">${(pager.pageNumber-1)*pager.pageSize+rowData.count}</td>
				<td align="left">
					<a href="javascript: void(0);" onclick="viewProjectReportInfo('${projectId}','<s:property value="#application[projectTypeId+'-sb-edit']"/>');"> 
						<s:property value="%{projectName}" escape="true" />&nbsp; 
					</a>
				</td>
				<td align="left"><s:property value="%{applicationUnit}" escape="true"/>&nbsp;</td>
				<td align="left"><s:property value="%{unitProperties}" escape="true"/>&nbsp;</td>
				<td align="left"><s:property value="%{flowStatus}" escape="true"/>&nbsp;</td>
				<td align="left"><s:property value="%{projectTypeName}" escape="true"/>&nbsp;</td>
				<td align="left"><s:property value="%{technicalFisld}" escape="true"/>&nbsp;</td>
				<td align="left"><s:property value="%{applyStatus}" escape="true"/>&nbsp;</td>
				<td align="center">
					<a href="javascript: void(0);" onClick="auditProject('${scoreId}','${projectId}','<s:property value="#application[projectTypeId+'-sb-expert-audit']"/>');">审核</a>&nbsp;
					<!--<a href="javascript: void(0);" onClick="showExpert('${scoreId}','${projectId}')">查看</a>&nbsp;
				--></td>
      		</tr>
		</s:iterator>
    </s:if>
    <s:else>
		<tr>
			<td colspan="9">
				没有查到任何记录!&nbsp;
			</td>
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
			autocomplete="off" /> 页 <input type="button" class="button"
			style="margin: -0.2em" value="确定" id="goBtn" name="goBtn" />
		</span> <span id="pgbtn"></span>
	<div class="clear"></div>
	<input type="hidden" id="pageNo" name="pager.pageNumber" value="${pager.pageNumber}" />
	<input type="hidden" id="totalRecords" name="pager.totalCount" value="${pager.totalCount}" />
	<input type="hidden" id="totalPages" name="pager.pageCount" value="${pager.pageCount}" />
</div>
</s:if>
			
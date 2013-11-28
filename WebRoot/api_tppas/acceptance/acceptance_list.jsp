<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/js/acceptance_list.js"></script>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
	<tr align="center">
		<th width="6%">序号</th>
	    <th width="18%">项目名称</th>
	    <th width="15%">申报单位</th>
	    <th width="8%">填表日期</th>
	    <th width="25%">项目分类</th>
	    <th width="8%">验收状态</th>
	    <th width="20%">操作</th>
	</tr>
	<s:if test="pager.list.size > 0">
		<s:iterator value="pager.list" status="rowData">
			<tr>
				<td>${(pager.pageNumber-1)*pager.pageSize+rowData.count}</td>
				<td><a href="javascript: void(0);" onclick="viewProjectReportInfo('${tprojectApplication.projectId}','<s:property value="#application[tprojectApplication.tprojectType.typeId+'-sb-edit']"/>');"><s:property value="%{tprojectApplication.projectName}" escape="true"/></a></td>
				<td><s:property value="%{tprojectApplication.applicationUnit}" escape="true"/></td>
				<td><s:property value="%{getText('{0,date,yyyy年MM月dd日}',{applicationDate})}" escape="true"/></td>
				<td><s:property value='%{tprojectApplication.planFlagName}' escape='true'/><s:property value='@com.hopsun.tppas.common.Constants@STRING_LINK' escape='true'/><s:property value='%{tprojectApplication.typeName}' escape='true'/></td>
				<td><s:property value="%{acceptanceStatusName}" escape="true"/></td>
				<td align="center">
					<s:if test="%{acceptanceStatus != @com.hopsun.tppas.common.Constants@ACCEPTANCE_PASS && acceptanceStatus != @com.hopsun.tppas.common.Constants@ACCEPTANCE_BASIC_PASS
					 && acceptanceStatus != @com.hopsun.tppas.common.Constants@ACCEPTANCE_NOPASS && acceptanceStatus != @com.hopsun.tppas.common.Constants@ACCEPTANCE_END}">
						<a href="javascript: void(0);" class="uline single" onclick="showSelectExpert('<s:property value='%{acceptanceId}' escape='true'/>');">选择验收专家</a>
						<a href="javascript: void(0);" class="uline single" onclick="showAcceptanceDetail('${acceptanceId}','<s:property value="#application[tprojectApplication.tprojectType.typeId+'-ys-edit']"/>');">验收</a>
					</s:if>
					<a href="javascript: void(0);" onclick="printPDF('${acceptanceId}','<s:property value="#application[tprojectApplication.tprojectType.typeId+'-ys-view']"/>')">打印</a>
				</td>
			</tr>
		</s:iterator>
	</s:if>
	<s:else>
		<tr>
			<td colspan="9">没有查到任何记录!&nbsp;</td>
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
		<input type="hidden" id="totalRecords" name="pager.totalCount"
			value="${pager.totalCount}" /> <input type="hidden" id="totalPages"
			name="pager.pageCount" value="${pager.pageCount}" />
	</div>
</s:if>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/plan/js/plan_list.js"></script>
<s:hidden id="selectedId" name="selectedId"></s:hidden>
<s:hidden id="planId" name="planId" value="%{planId}"></s:hidden>
<div style="border-bottom: 1px dashed #C9DEEE;"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
		<tr align="center">
		    <th width="15%">序号</th>
	        <th width="25%">分计划名称</th>
	        <th width="15%">计划年度</th>
	        <th width="15%">计划批次</th>
	        <th width="15%">分计划状态</th>
			<th width="15%">操作</th>
		</tr>
		<s:if test="pager.list.size > 0">
			<s:iterator value="pager.list" status="rowData">
				<tr>
					<td align="center">
        				${(pager.pageNumber-1)*pager.pageSize+rowData.count}
					</td>
					<td>
					    <a href="javascript: void(0);" class="uline single" onClick="showPlanDetail('${planId}');">
					  		<s:property value="%{planName}" escape="true"/>
					    </a>
					</td>
					<%-- <td>
						<s:property value="%{projectTypeName}" escape="true"/>
					</td> --%>
					<td>
						<%-- <s:property value="%{getText('{0,date,yyyy}',{planYear})}" escape="true"/> --%>
						 <s:property value="%{planYear}" escape="true"/> 
					</td>
					<td>
						<s:property value="%{planBatch}" escape="true"/>
					</td>
					<td>
						<s:property value="%{planState}" escape="true"/>
					</td>
					<td align="center">
						<a href="javascript: void(0);" class="uline single" onclick="showPlanDetail('${planId}');">查看</a>
					</td>
				</tr>
				
			</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<td colspan="7">
					没有查到任何记录!&nbsp;
				</td>
			</tr>
		</s:else>
	</table>
	<s:hidden id="pageCount" name="pageCount" value="%{pager.pageCount}"></s:hidden>
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
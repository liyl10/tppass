<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/archival/js/archival_list.js"></script>
<s:hidden id="selectedId" name="selectedId"></s:hidden>
<s:hidden id="planId" name="planId" value="%{planId}"></s:hidden>
<s:hidden id="typeId" name="typeId" value="%{typeId}"></s:hidden>
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<div style="border-bottom: 1px dashed #C9DEEE;"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
		<tr align="center">
			<th width="3%"><s:checkbox name="" id="selectAll" onclick="selectAll();"></s:checkbox></th>
		    <th width="8%">项目编号</th>
	        <th width="12%">项目名称</th>
	        <th width="12%">申报单位</th>
	        <th width="22%">项目分类</th>
	        <th width="15%">技术领域</th>
	        <th width="7%">申报日期</th>
	        <th width="7%">归档日期</th>
	        <th width="7%">归档状态</th>
	        <th width="7%">项目状态</th>
		</tr>
		<s:if test="pager.list.size > 0">
			<s:iterator value="pager.list" status="rowData">
				<tr>
					<td align="center">
						<input type="checkbox" id="${projectId}" value="${projectId}"/>
					</td>
					<td>
						<s:property value="%{projectNumber}" escape="true"/>
					</td> 
					<td>
						<a href="javascript: void(0);" onClick="viewProjectReportInfo('${projectId}','<s:property value="#application[typeId+'-sb-edit']"/>');">
					
					  		<s:property value="%{projectName}" escape="true"/>
					    </a>
					</td>
					<td>
					    <a href="javascript: void(0);" class="uline single" onClick="showApplicationUnit('${projectId}');">
					  		<s:property value="%{applicationUnit}" escape="true"/>
					    </a>
					</td>
					<td>
						<s:property value="%{tprojectTypeName}" escape="true"/>
					</td>
					<td>
						 <s:property value="%{technicalFisld}" escape="true"/> 
					</td>

					<td>
						<s:property value='%{getText("{0,date,yyyy-MM-dd}",{startTime})}' escape='true'/>
					</td>
					<td>
						<s:property value='%{getText("{0,date,yyyy-MM-dd}",{archivalTime})}' escape='true'/>
					</td>
					<td>
						 <s:property value="%{isArchival}" escape="true"/> 
					</td>
				    <td>
						 <s:property value="%{applyStatus}" escape="true"/> 
					</td>
				</tr>
				
			</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<td colspan="10">
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
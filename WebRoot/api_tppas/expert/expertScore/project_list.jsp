<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/expert/expertScore/js/project_list.js"></script>
<div style="border-bottom: 1px dashed #C9DEEE;"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
		<tr align="center">
		    <th width="25%">项目名称</th>
		    <th width="20%">申报单位</th>
		    <th width="25%">项目分类</th>
		    <th width="10%">项目负责人</th>
		    <th width="10%">填写状态</th>
		    <th width="10%">操作</th>
		</tr>
		<s:if test="pager.list.size > 0">
			<s:iterator value="pager.list" status="rowData">
				<tr>
					<td>
						<a href="javascript: void(0);" class="uline single" onclick="viewProjectReportInfo('${projectId}','<s:property value="#application[typeId+'-sb-edit']"/>');">
							<s:property value="%{projectName}" escape="true"/>
						</a>
					</td>
					<td>
						<a href="javascript: void(0);" class="uline single" onclick="viewCompanyInfo('${projectId}');">
							<s:property value="%{applicationUnit}" escape="true"/>
						</a>
					</td>
					<td>
						<s:property value="%{projectTypeName}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{projectPerson}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:if test="%{isWrite==1}">
							已填写
						</s:if>
						<s:else>
							未填写
						</s:else>
					</td>
					<td align="center">
						<a href="javascript: void(0);" class="uline single" onclick="opinionWrite('${groupId}','${projectId}',${(pager.pageNumber-1)*pager.pageSize+rowData.count-1});">录入评审分数</a>
					</td>
				</tr>
			</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<td colspan="6">
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
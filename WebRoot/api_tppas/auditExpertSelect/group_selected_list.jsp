<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/auditExpertSelect/js/group_selected_list.js"></script>
<label id="comfirmCancel" style="display: none"><s:text name="confirm_cancel_info"/></label>
<div style="border-bottom: 1px dashed #C9DEEE;"></div>
	<s:hidden id="groupId1" name="groupId" value="%{groupId}"></s:hidden>
	<s:hidden id="selectedId" name="selectedId"></s:hidden>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
		<tr align="center">
			<th width="5%">
				<s:checkbox name="" id="selectAll" onclick="selectAll();" expertFlag=""></s:checkbox>
			</th>
		    <th width="15%">项目名称</th>
		    <th width="15%">申报单位</th>
		    <th width="10%">单位性质</th>
		    <th width="29%">项目分类</th>
		    <th width="10%">技术领域</th>
		    <th width="8%">审核状态</th>	
		    <th width="8%">操作</th>
		</tr>
		<s:if test="pager.list.size > 0">
			<s:iterator value="pager.list" status="rowData">
				<tr>
					<td align="center">
						<input type="checkbox" value="${projectId}" onclick="saveOrDelSelect(this);"/>
					</td>
					<td>
						<s:property value="%{projectName}" escape="true"/>
					</td>
					<td>
						<s:property value="%{applicationUnit}" escape="true"/>
					</td>
					<td>
						<s:property value="%{unitProperties}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{projectTypeName}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{technicalFisld}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{applyStatus}" escape="true"/>
					</td>
					<td align="center">
						<a href="javascript: void(0);" class="uline single" 
							onclick="cancelGroupSelect('${projectId}');">取消</a>
					</td>
				</tr>
			</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<td colspan="8">
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

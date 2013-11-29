<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<div style="border-bottom: 1px dashed #C9DEEE;"></div>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/super/js/typeModel_list.js"></script>
<label id="comfirmDelete" style="display: none"><s:text name="confirm_del_info"/></label>
<s:hidden id="expertReviewCommentsId" name="expertReviewCommentsId" value="%{expertReviewCommentsId}"></s:hidden>

<div style="float: right;padding-right:5px;border-bottom: 1px dashed #C9DEEE;">
<tag:auth code="ss.otherItemList.add">
<a class="button add" name="addNewItemBtn" id="addNewItemBtn">新增</a>
</tag:auth>
</div>

<table width="100%" border="0" cellspacing="0" cellpadding="0"	class="t-list">
	<tr>
		<th style="text-align:center;white-space:nowrap">真实名称</th>
		<th style="text-align:center;white-space:nowrap">显示名称</th>
		<th style="text-align:center;white-space:nowrap">所属部门</th>
		<th style="text-align:center;white-space:nowrap">上级分类</th>
		<th style="text-align:center;white-space:nowrap">申报模板</th>
		<th style="text-align:center;white-space:nowrap">合同模板</th>
		<th style="text-align:center;white-space:nowrap">监理模板</th>
		<th style="text-align:center;white-space:nowrap">验收模板</th>		
		<th style="text-align:center;white-space:nowrap">是否显示</th>	
		<th style="text-align:center;white-space:nowrap">操作</th>
	</tr>
	<s:if test="pager.list.size  > 0">
		<s:iterator value="pager.list" status="rowData">
			<tr>
				<td><s:property value='%{typeRealName}' escape='true' /></td>
				<td><s:property value='%{typeShowName}' escape='true' /></td>
				<td><s:property value='%{departmentName}' escape='true' /></td>
				<td><s:property value='%{parentTypeName}' escape='true' /></td>
				<td><s:property value='%{tprojectReportTemplate.reportTemplateName}' escape='true' />&nbsp;</td>
				<td><s:property value='%{tprojectContractTemplate.contractTemplateName}' escape='true' />&nbsp;</td>
				<td><s:property value='%{tprojectSupervisionTemplate.supervisionTemplateName}' escape='true' />&nbsp;</td>
				<td><s:property value='%{tprojectAcceptanceTemplate.acceptanceTemplateName}' escape='true' />&nbsp;</td>
				<td><s:property value='%{isShowName}' escape='true' />&nbsp;</td>
				<td style="text-align: center; white-space: nowrap">
<%-- 				<tag:auth code="ss.contractModel_list.update"> --%>
					<a href="javascript: void(0);" name="detailBtn" onclick="doUpdate('<s:property value='%{typeId}' escape='true'/>');">修改</a>
<%-- 				</tag:auth> --%>
<%-- 				<tag:auth code="ss.contractModel_list.delete"> --%>
					<a href="javascript: void(0);" name="delBtn" onclick="doDel('<s:property value='%{typeId}' escape='true'/>');">删除</a>
<%-- 				</tag:auth> --%>
					<s:if test="%{parentTypeId!=null && parentTypeId!=''}">
						<a href="javascript: void(0);" name="addExperBtn" onclick="doAddExper('<s:property value='%{typeId}' escape='true'/>','<s:property value='%{parentTypeId}' escape='true'/>');">专家评估模板</a>
						<a href="javascript: void(0);" name="assignBtn" onclick="assignUser('<s:property value='%{typeId}' escape='true'/>');">分配专员</a>
					</s:if>
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
<s:if test="pager.list.size  > 0">
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
			autocomplete="off" /> 页 <input type="button" class="button" style="margin:-0.2em" value="确定" id="goBtn" name="goBtn"/>
		</span> <span id="pgbtn"></span>
		<div class="clear"></div>
		<input type="hidden" id="pageNo" name="pager.pageNumber" value="${pager.pageNumber}" />
			<input type="hidden" id="totalRecords" name="pager.totalCount"
			value="${pager.totalCount}" /> <input type="hidden" id="totalPages"
			name="pager.pageCount" value="${pager.pageCount}" />
	</div>
</s:if>
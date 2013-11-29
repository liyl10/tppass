<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/super/js/type_list.js"></script>
<label id="comfirmDelete" style="display: none"><s:text name="confirm_del_info"/></label>
<div style="float: right;padding-right:5px;border-bottom: 1px dashed #C9DEEE;">
	<tag:auth code="ss.typeList.add">
	<a class="button add" name="addNewItemBtn" id="addNewItemBtn">新 增</a>
	</tag:auth>
</div>

<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
	<tr>
		<th style="text-align:center">类型编号</th>
		<th style="text-align:center">类型名称</th>
		<th style="text-align:center">类型描述</th>
		<th style="text-align:center">父类型名称</th>
		<th  style="text-align:center;white-space:nowrap">操作</th>
	</tr>
	<s:if test="pager.list.size > 0">
		<s:iterator value="pager.list" status="rowData">
			<tr>
				<td><s:property value='%{typeId}' escape='true'/>&nbsp;</td>
				<td><s:property value='%{typeName}' escape='true'/>&nbsp;</td>
				<td><s:property value='%{typeDsc}' escape='true'/>&nbsp;</td>
				<td><s:property value='%{ptypeName}' escape='true'/>&nbsp;</td>
				<td style="text-align:center;white-space:nowrap"><span  style="white-space:nowrap">
				<tag:auth code="ss.typeList.updata">
					<a href="javascript: void(0);" name="detailBtn" onclick="doUpdate('<s:property value='%{typeId}' escape='true'/>');">修 改</a>
				</tag:auth>
				<tag:auth code="ss.typeList.delete">
					<a href="javascript: void(0);" name="delBtn" onclick="doDel('<s:property value='%{typeId}' escape='true'/>');" >删 除</a>
				</tag:auth></span>
				</td>
			</tr>
		</s:iterator>
	</s:if>
	<s:else>
		<tr>
			<td colspan="8">没有查到任何记录!&nbsp;</td>
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
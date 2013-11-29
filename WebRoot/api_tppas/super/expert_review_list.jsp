<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/super/js/expert_review_list.js"></script>
<div align="center" style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
<s:hidden id="typeId" name="typeId" value="%{typeId}"></s:hidden>
<s:hidden id="planFlagId" name="planFlagId" value="%{planFlagId}"></s:hidden>
<s:hidden id="expertReviewCommentsId" name="expertReviewCommentsId" value="%{expertReviewCommentsId}"></s:hidden>
<s:hidden id="typeShowName1" name="typeShowName1" value="%{typeShowName1}"></s:hidden>
<s:hidden id="addbtnFlaf" name="addbtnFlaf" value="%{addbtnFlaf}"></s:hidden>
<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">专家评估模板</div>
				<div>

<div style="float: right;padding-right:5px;border-bottom: 1px dashed #C9DEEE;">
	<a class="button add" name="copyExpertBtn" id="copyExpertBtn">复用</a>
<tag:auth code="ss.expertreviewlist.addExpertBtn"> 
	<a class="button add" name="addExpertBtn" id="addExpertBtn">新增</a>
</tag:auth>
</div>			
<label id="comfirmDelete" style="display: none"><s:text name="confirm_del_info"/></label>
<table width="100%" class="t-list">
	 <tr>
          <th width="20%">专家评估模板</th>
		  <th width="40%">项目分类</th>
		  <th width="20%">新增日期</th>
		  <th width="20%">操作</th>
     </tr>
	<s:if test="pager.list.size  > 0">
		<s:iterator value="pager.list" status="rowData">
			<tr>
				<td><s:property value='%{expertReviewCommentsName}' escape='true' /></td>
				<td><s:property value='%{typeShowName1}' escape='true' /></td>
				<td><s:property value="%{getText('{0,date,yyyy-MM-dd}',{createTime})}" escape="true"/></td>
				<td style="text-align: center; white-space: nowrap">
<%-- 				<tag:auth code="ss.contractModel_list.update"> --%>
					<a href="javascript: void(0);" name="detailBtn" onclick="doUpdate('<s:property value='%{expertReviewCommentsId}' escape='true'/>','<s:property value='%{typeId}' escape='true'/>','<s:property value='%{planFlagId}' escape='true'/>');">修改</a>
<%-- 				</tag:auth> --%>
<%-- 				<tag:auth code="ss.contractModel_list.delete"> --%>
					<a href="javascript: void(0);" name="delBtn" onclick="doDel('<s:property value='%{expertReviewCommentsId}' escape='true'/>','<s:property value='%{typeId}' escape='true'/>','<s:property value='%{planFlagId}' escape='true'/>');">删除</a>
<%-- 				</tag:auth> --%>
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
</div>
</div>
</div>
</div>

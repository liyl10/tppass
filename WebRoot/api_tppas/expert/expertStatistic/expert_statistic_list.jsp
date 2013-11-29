<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/expert/expertStatistic/js/expert_statistic_list.js"></script>
<label id="comfirmDelete" style="display: none"><s:text name="confirm_del_info"/></label>
<div style="border-bottom: 1px dashed #C9DEEE;"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
		<tr align="center">
			<th width="10%">序号</th>
		    <th width="15%">专家姓名</th>
		    <th width="20%">参与项目数量</th>
		    <th width="20%">参加评审数量</th>
		    <th width="20%">参加验收数量</th>
		    <th width="15%">信誉度</th>	
		</tr>
		<s:if test="pager.list.size > 0">
			<s:iterator value="pager.list" status="rowData">
				<tr>
					<td align="left">
						${(pager.pageNumber-1)*pager.pageSize+rowData.count}
					</td>
					<td>
						<s:property value="%{expertName}" escape="true"/>
					</td>
					<td>
						<s:property value="%{expertMajor1}" escape="true"/>
					</td>
					<td>
						<s:property value="%{expertMajor2}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{expertMajor3}" escape="true"/>&nbsp;
					</td>
					<td align="center">
						<s:property value="%{expertPrestige}" escape="true"/>
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
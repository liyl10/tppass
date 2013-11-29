<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/reportingunit/js/reportingUnit_list.js"></script>
<table id='testtab' border=0 cellSpacing=0 cellPadding=0 width="100%"
	class="t-list">
	<tr>
		<th width="10%">序号</th>
		<th width="15%">单位名称</th>
		<th width="15%">单位性质</th>
		<th width="8%">所属技术领域</th>
		<th width="8%">注册类型</th>
		<th width="9%">注册地址</th>
		<th width="10%">注册日期</th>
		<th width="8%">信誉等级</th>
		<th width="35%">操作</th>
	</tr>
	<s:if test="pager.list.size > 0">
		<s:iterator value="pager.list" status="rowData">
			<tr align=middle>
				<td align="left">001</td>
				<td align="left"><a href="javascript: void(0);"
					onClick="showUnitDetai1('')">单位名称111</a></td>
				<td align="left">xxx</td>
				<td align="left">XXX</td>
				<td align="left">XXX</td>
				<td align="left">XXX</td>
				<td align="left">2012-5-10</td>
				<td align="left">良</td>
				<td align="center"><a href="javascript: void(0);"
					onClick="showCreidtDetai1('')">设置信誉度</a> <a href="javascript: void(0);"
					onClick="">打印</a>&nbsp;</td>
			</tr>
			<tr align=middle>
				<td align="left">002</td>
				<td align="left"><a href="javascript: void(0);"
					onClick="showUnitDetai1('')">单位名称222</a></td>
				<td align="left">xxx</td>
				<td align="left">XXX</td>
				<td align="left">XXX</td>
				<td align="left">XXX</td>
				<td align="left">2011-4-16</td>
				<td align="left">优</td>
				<td align="center"><a href="javascript: void(0);"
					onClick="showCreidtDetai1('')">设置信誉度</a> <a href="javascript: void(0);"
					onClick="">打印</a>&nbsp;</td>
			</tr>
			<tr align=middle>
				<td align="left">003</td>
				<td align="left"><a href="javascript: void(0);"
					onClick="showUnitDetai1('')">单位名称333</a></td>
				<td align="left">xxx</td>
				<td align="left">XXX</td>
				<td align="left">XXX</td>
				<td align="left">XXX</td>
				<td align="left">2012-5-10</td>
				<td align="left">良</td>
				<td align="center"><a href="javascript: void(0);"
					onClick="showCreidtDetai1('')">设置信誉度</a> <a href="javascript: void(0);"
					onClick="">打印</a>&nbsp;</td>
			</tr>
		</s:iterator>
	</s:if>
	<s:else>
		<TR>
			<td colspan="12" align="left">没有查到任何记录!</td>
		</TR>
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
		<span> 跳转至第 <input type="text" id="goPageNo" name="goPageNo"
			style="width: 30px; height: 16px;"
			onkeyup='this.value=this.value.replace(/[^0-9]\D*$/,"")'
			autocomplete="off" /> 页 <input type="button" class="button"
			style="margin: -0.2em" value="确定" id="goBtn" name="goBtn" />
		</span> <span id="pgbtn"></span>
		<div class="clear"></div>
		<input type="hidden" id="pageNo" name="pager.pageNumber"
			value="${pager.pageNumber}" /> <input type="hidden"
			id="totalRecords" name="pager.totalCount" value="${pager.totalCount}" />
		<input type="hidden" id="totalPages" name="pager.pageCount"
			value="${pager.pageCount}" />
	</div>
</s:if>
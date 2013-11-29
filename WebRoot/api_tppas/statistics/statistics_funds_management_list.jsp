<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/statistics/js/statistics_funds_management_list.js"></script>
<div style="border-bottom: 1px dashed #C9DEEE;"></div>
<s:hidden id="printEnableFlag" value="%{printEnableFlag}"></s:hidden>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
		<tr align="center">
		    <th width="10%">序号</th>
		    <th width="20%">委托任务（项目名称）</th>
		    <th width="15%">项目承担（单位全称）</th>
		    <th width="25%">开户银行及行号</th>
		    <th width="10%">帐号</th>
		    <th width="10%">本次拨款金额</th>
		    <th width="10%">项目计划拨款金额</th>
		    <th width="10%">拨款日期</th>
		    <th width="10%">备注</th>
		</tr>
	<s:if test="pager.list.size > 0">
			<s:iterator value="pager.list" status="rowData">
				<tr align=middle>
					<td height=25 align="center">
						${(pager.pageNumber-1)*pager.pageSize+rowData.count}
					</td>
					<td><div align="left">
							<s:property value='%{projectName}' escape='true' />
						</div></td>
					<td><div align="left">
							<s:property value='%{applicationUnit}' escape='true' />
						</div></td>
					<td><div align="left">
							<s:property value='%{bank}' escape='true' />
						</div></td>
					<td><div align="left">
						<s:property value='%{bankAccount}' escape='true' />
					</div></td>
					<td><div align="left">
						<s:property value='%{amountFunding}' escape='true' />
					</div></td>
					<td><div align="left">
						<s:property value='%{planFunding}' escape='true' />
					</div></td>
					<td><div align="left">
							<s:property value='%{getText("{0,date,yyyy-MM-dd}",{appropriationTime})}' />
						</div></td>
					<td><div align="left">
						<s:property value='%{remark}' escape='true' />
					</div></td>
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
<!-- 查询结果列表E -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/reportingunit/js/project_details.js"></script>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">专家库管理</div>
				<div>
					<div class=requirecolor id="errInfo"></div>
				</div>
				<div id="resultDiv">
				<table id='testtab' border=0 cellSpacing=0 cellPadding=0
					width="100%" class="t-list">
					<tr>
						<th width="20%">编号</th>
						<th width="20%">专家姓名</th>
						<th width="20%">学位</th>
						<th width="20%">专家信誉等级</th>
						<th width="20%">项目得分</th>
					</tr>
					<s:if test="pager.list.size > 0">
						<s:iterator value="pager.list" status="rowData">
							<tr align=middle>
								<td align="left">001</td>
								<td align="left">李芳</td>
								<td align="left">博士后</td>
								<td align="left">优</td>
								<td align="left">70</td>
							</tr>
							<tr align=middle>
								<td align="left">002</td>
								<td align="left">王辉</td>
								<td align="left">博士</td>
								<td align="left">优</td>
								<td align="left">90</td>
							</tr>
							<tr align=middle>
								<td align="left">003</td>
								<td align="left">刘华芳</td>
								<td align="left">博士</td>
								<td align="left">良</td>
								<td align="left">80</td>
							</tr>
							<tr align=middle>
								<td align="left">004</td>
								<td align="left">李芳</td>
								<td align="left">硕士</td>
								<td align="left">优</td>
								<td align="left">85</td>
							</tr>
							<tr align=middle>
								<td align="left">005</td>
								<td align="left">那芳</td>
								<td align="left">博士</td>
								<td align="left">良</td>
								<td align="left">90</td>
							</tr>
						</s:iterator>
					</s:if>
					<s:else>
						<TR>
							<td colspan="12" align="left">没有查到任何记录!</td>
						</TR>
					</s:else>
					<tr>
						<td colspan="5" align="center"><input class="button"
							id="button" type="button" href="javascript: void(0);"
							onClick="goBack();" value="返回" /></td>
					</tr>
				</table>
				</div>
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
						<input type="hidden" id="pageNo" name="pager.pageNumber"
							value="${pager.pageNumber}" /> <input type="hidden"
							id="totalRecords" name="pager.totalCount"
							value="${pager.totalCount}" /> <input type="hidden"
							id="totalPages" name="pager.pageCount" value="${pager.pageCount}" />
					</div>
				</s:if>
			</div>
		</div>
	</div>
</div>
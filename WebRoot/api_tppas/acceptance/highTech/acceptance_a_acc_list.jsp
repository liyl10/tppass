<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/highTech/js/acceptance_a_acc_list.js"></script>

<form id="searchForm"></form>
<div id="resultDiv">
<s:hidden id="acceptanceId" name="acceptanceId" value="%{acceptanceId}"></s:hidden>
<s:hidden id="acceptanceStatus" name="acceptanceStatus" value="%{acceptanceStatus}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">验收小组名单</div>
					<div style="border-bottom: 1px dashed #C9DEEE;"></div>
						<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
							<tr align="center">
								<th>序号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>出生年月</th>
								<th>技术职称</th>
								<th>文化程度</th>
								<th>工作单位</th>
								<th>在项目中完成的主要工作</th>
								<s:if test="%{acceptanceStatus ==1}">
								<th>操作</th>
								</s:if>
							</tr>
							<s:if test="pager.list.size > 0">
							<s:iterator value="pager.list" status="rowData">
							<tr>
								<td>${(pager.pageNumber-1)*pager.pageSize+rowData.count}</td>
								<td><s:property value='%{name}' escape='true'/></td>
								<td><s:if test='%{sex=="1"}'>男</s:if><s:elseif test='%{sex=="2"}'>女</s:elseif><s:else></s:else></td>
								<td><s:date name="%{birthday}" format="yyyy-MM"/></td>
								<td><s:property value='%{technicalTitles}' escape='true'/></td>
								<td><s:property value='%{educationLevel}' escape='true'/></td>
								<td><s:property value='%{workUnits}' escape='true'/></td>
								<td><s:property value='%{mainDuties}' escape='true'/></td>
								<td><div align="center"> 
									<a href="javascript: void(0);" onclick="modifyAcc('${accId}');">查看</a>
								</div></td>
							</tr>
							</s:iterator>
							</s:if>
							<s:else>
							<tr>
								<td colspan="9">没有查到任何记录!&nbsp;</td>
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
				</div>
			</div>
		</div>
		<div align="center">
			<input class="button save" name="nextBtn" id="nextBtn" type="button" href="javascript: void(0);" value="下一步"/>
		</div>
	</div>
</div>

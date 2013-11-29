<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/statistics/js/statistics_project_result_list.js"></script>
<s:hidden id="printEnableFlag" value="%{printEnableFlag}"></s:hidden>
<!-- 查询结果列表S -->
<table class="t-list">
	<tr align="center">
		<th>序号</th>
		<th>项目名称</th>
		<th>申报单位</th>
		<th>项目分类</th>
		<th>申报年度</th>
		<th>所属园区</th>
	</tr>
	<s:if test="pager.list.size > 0">
		<s:iterator value="pager.list" status="rowData">
			<tr>
				<td align="center">${(pager.pageNumber-1)*pager.pageSize+rowData.count}</td>
				<td>
					<a href="javascript: void(0);" onclick="viewProjectReportInfo('${projectId}','<s:property value="#application[typeId+'-sb-edit']"/>');">
						<s:property value='%{projectName}' />
					</a>
				</td>
				<td>
				<a href="javascript: void(0);" class="uline single" onclick="viewCompanyInfo('${projectId}')">
				<s:property value='%{applicationUnit}' />
				</a>
				</td>
				<td><s:property value="%{parentTypeName + '-' + typeShowName}" /></td>
				<td align="center"><s:property value="%{reportYear}"></s:property></td>
				<td align="center"><s:property value='%{centralizedTypeName}' /></td>
			</tr>
		</s:iterator>
	</s:if>
	<s:else>
		<tr>
			<td colspan="6" align="left">没有查到任何记录!&nbsp;</td>
		</tr>
	</s:else>
</table>
<!-- 分页显示 -->
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
<!-- <div id="resultDiv">
	<div align="center"
		style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
		<div style="text-align: left;">
			<div class="Servicel04">
				<div class="abuot02">
					<div class="abuot07">项目结果汇总</div>
					<div>&nbsp;</div>
					<div>
			          <div class=requirecolor id="errInfo"></div>
			          <form id="searchForm">
			            <table style="width:100%">
			              <tr>
			                <td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%"> 项目年度
			                  &nbsp;</td>
			                <td style="white-space:nowrap;width:20%;padding:2px">&nbsp;从
			                  <select style="width:30%">
			                    <option value="2">2013</option>
			                    <option value="1">2014</option>
			                    <option value="0">2015</option>
			                  </select> 到
			                  <select style="width:30%">
			                    <option value="2">2013</option>
			                    <option value="1">2014</option>
			                    <option value="0">2015</option>
			                  </select>
			                </td>
			              </tr>
			              <tr>
			              <td align="right">
			              		<input class="button" type="button" id="queryBtn" value="统计" />
			                  <input class="button" type="button" id="queryBtn" value="打印" /></td>
			              </tr>
			            </table>
			          </form>
			        </div>
					<div align="right">
						&nbsp; <input class="button" type="button" id="queryBtn"
							value="打印" />
					</div>
					
				</div>
			</div>
		</div>
	</div>
</div> -->


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/highTech/js/report_researcher_list.js"></script>

<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<form id="frmA" ></form>
<div id="resultDiv">
<div align="center" style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
		<div style="text-align: left;">
			<div class="Servicel04">
				<div class="abuot02">
					<div class="abuot07">项目负责人及主要人员</div>
					<div style="border-bottom: 1px dashed #C9DEEE;"></div>

<table  border=0 cellSpacing=0 cellPadding=0 width="100%" align=center>
<tr>
  <td align="left" valign="top">
	<table id='testtab' border=0 cellSpacing=0 cellPadding=0 width="100%" align=center class="t-list">
        <tr>
		  <th width="5%">序号</th>
		  <th width="10%">姓名</th>
		  <th width="5%">年龄</th>
		  <th width="10%">性别</th>
		  <th width="10%">技术职称</th>
		  <th width="10%">工作单位</th>
		  <th width="10%">部门及职务</th>
		  <th width="10%">从事专业</th>
		  <th width="10%">承担任务</th>
		  <th width="5%">显示顺序</th>
		  <th width="15%">操作</th>
		</tr>
	<s:if test="pager.list.size > 0">
  		<s:iterator value="pager.list" status="rowData">
        <tr align=middle>
        	<td height=25 align="center">${(pager.pageNumber-1)*pager.pageSize+rowData.count}</td>
        	<s:hidden id="researcherId" name="researcherId" value="%{researcherId}"></s:hidden>
			<td><div align="left"><s:property value='%{name}' escape='true'/></div></td>
			<td><div align="left"><s:property value='%{age}' escape='true'/></div></td>
			<td><div align="left"><s:property value='%{sexFlag}' escape='true'/></div></td> 
			<td><div align="left"><s:property value='%{job}' escape='true'/></div></td>
			<td><div align="left"><s:property value='%{workUnit}' escape='true'/></div></td>
			<td><div align="left"><s:property value='%{department}' escape='true'/></div></td> 
			<td><div align="left"><s:property value='%{specialty}' escape='true'/></div></td> 
			<td><div align="left"><s:property value='%{task}' escape='true'/></div></td> 
			<td><div align="left"><s:property value='%{revealOrder}' escape='true'/></div></td>
          	<td><div align="center">
          	<a href="javascript: void(0);" onclick="showDetai('${projectId }','${researcherId}','${applyStatus}');">详细</a>
          	</div></td>
        </tr>
        </s:iterator>
	</s:if>
	<s:else>
		<tr>
		   <td colspan="17" align="left">没有查到任何记录!</td>
		</tr>
	</s:else>
 </table>
</td>
</tr>
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
						autocomplete="off" /> 页 <input type="button" class="button"
						style="margin: -0.2em" value="确定" id="goBtn" name="goBtn" />
					</span> <span id="pgbtn"></span>
				<div class="clear"></div>
				<input type="hidden" id="pageNo" name="pager.pageNumber" value="${pager.pageNumber}" />
				<input type="hidden" id="totalRecords" name="pager.totalCount" value="${pager.totalCount}" /> 
				<input type="hidden" id="totalPages" name="pager.pageCount" value="${pager.pageCount}" />
	</div>
</s:if>
<div align="center" style="width: 100%">
	<br> <br>
	<input class="button save" id="nextBtn" name="button" type="button" href="javascript: void(0);" onclick="nextBtn();" value="下一步"/>
</div>
</div>
</div>
</div>
</div>
</div>

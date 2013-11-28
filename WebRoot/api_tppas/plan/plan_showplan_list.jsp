<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/plan/js/plan_showplan_list.js"></script>
<s:hidden id="selectedId" name="selectedId"></s:hidden>
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="typeId" name="typeId" value="%{typeId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
<div class="Servicel04">
<div class="abuot02">
<div class="abuot07">查看分计划</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
		<tr align="center">
		    <th  width="10%">序号</th>
			<th  width="15%">项目名称</th>	
			<th  width="20%">申报单位</th>
			<th  width="25%">项目分类</th>
			<th  width="15%">单位性质</th>	
			<th  width="15%">当前阶段</th>	        
		</tr>
		<s:if test="pager.list.size > 0">
			<s:iterator value="pager.list" status="rowData">
				<tr>
					<td align="center">
        				${(pager.pageNumber-1)*pager.pageSize+rowData.count}
					</td>
					<!--项目名称  -->
					<td>
						<a href="javascript: void(0);" class="uline single" onclick="viewProjectReportInfo('${projectId}','<s:property value="#application[typeId+'-sb-edit']"/>');">
							<s:property value="%{projectName}" escape="true"/>
						</a>
					</td>
					<!--申报单位  -->
					<td>
						<a href="javascript: void(0);" class="uline single" onclick="viewCompanyInfo('${projectId}');">
							<s:property value="%{applicationUnit}" escape="true"/>
						</a>
					</td>
					<!--项目分类  -->
					<td>
						<s:property value="%{tprojectTypeName}" escape="true"/>
					</td>
					<!--单位性质  -->
					<td>
						 <s:property value="%{unitProperties}" escape="true"/> 
					</td>
					<!--当前阶段  -->
					<td>
						 <s:property value="%{applyStatusString}" escape="true"/> 
					</td>
				</tr>
				
			</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<td colspan="7">
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
		<div align="center" style="width: 100%;float:right;">
		<input type="button" id="reBtn" class="button back" href="javascript: void(0);"  value="返回">
	</div>
	</div>
	</div>
	</div>
	</div>

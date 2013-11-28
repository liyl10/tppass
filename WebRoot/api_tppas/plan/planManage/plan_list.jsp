<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/plan/planManage/js/plan_list.js"></script>
<s:hidden id="selectedId" name="selectedId"></s:hidden>
<label id="comfirmCancel" style="display: none"><s:text name="confirm_cancel_info1"/></label>
<div style="border-bottom: 1px dashed #C9DEEE;"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
		<tr align="center">
			<th width="5%">
				序号
			</th>
		    <th width="12%">分计划名称</th>
		    <th width="12%">计划年度</th>
		    <th width="12%">计划批次</th>
		    <th width="23%">项目分类</th>
		    <th width="11%">计划状态</th>
		    <th width="5%">包含项目数</th>	
		    <th width="20%">操作</th>
		</tr>
		<s:if test="pager.list.size > 0">
			<s:iterator value="pager.list" status="rowData">
				<tr>
					<td align="left">
						${(pager.pageNumber-1)*pager.pageSize+rowData.count}
					</td>
					<td>
						<s:property value="%{planName}" escape="true"/>&nbsp;
					</td>
					<td align="center">
						<s:property value="%{planYear}" escape="true"/>&nbsp;
					</td>
					<td align="center">
						<s:property value="%{planBatch}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{planFlagName}" escape="true"/>
					</td>
					<td align="center">
						<s:property value="%{planStatusString}" escape="true"/>&nbsp;
					</td>
					<td align="center">
						<s:property value="%{projectCount}" escape="true"/>&nbsp;
					</td>
					<td align="center">
						<a href="javascript: void(0);" class="uline single" 
							onclick="showDetail('${planId}');">详细</a>
						<s:if test="%{planState == 0}">
							<a href="javascript: void(0);" class="uline single" 
								onclick="updatePlan('${planId}');">修改</a>
							<a href="javascript: void(0);" class="uline single" 
								onclick="deletePlan('${planId}');">删除</a>
						</s:if>
						<%-- <s:if test="%{planState == 1}">
							<a href="javascript: void(0);" class="uline single" 
							onclick="issuedContract('${planId}')">下发合同</a>
						</s:if> --%>
					</td>
				</tr>
			</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<td colspan="8">
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
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/contract/other/js/contract_index_list.js"></script>
<form id="frmA"></form>
<div id="resultDiv">
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
<div class="Servicel04">
<div class="abuot02">
<div class="abuot07">附件清单</div>
	<div style="border-bottom: 1px dashed #C9DEEE;"></div>
		<div id="dddd" style="float: left; font-size: 140%; padding-left: 20px"></div>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
				<tr>
					<th width="10%">序号</th>
					<th width="25%">附件名称</th>
					<th width="10%">排序</th>
					<th width="30%">说明</th>
					<th width="25%">操作</th>
				</tr>
				<s:hidden id="tcontractId" name="tcontractId" value="%{tcontractId}"></s:hidden>
				<s:hidden id="Flag" name="Flag" value="%{Flag}"></s:hidden>
				<s:hidden id="contractStatus" name="contractStatus" value="%{contractStatus}"></s:hidden>
				<s:hidden id="modelType" name="modelType" value="%{modelType}"></s:hidden>
				<s:hidden id="tableName" name="tableName" value="%{tableName}"></s:hidden>
				<s:hidden id="retUrl" name="retUrl"></s:hidden>
				<label id="comfirmDelete" style="display: none"><s:text name="confirm_del_info"/></label>
				<s:if test="pager.list.size > 0">
					<s:iterator value="pager.list" status="rowData">
						<tr>
							<td>
								${(pager.pageNumber-1)*pager.pageSize+rowData.count}
							</td>
							<td>
								<s:property value='%{attachmentName}' escape='true'/>
							</td>
							<td>
								<s:property value='%{sequence}' escape='true'/>
							</td>
							<td>
								<s:property value='%{explanation}' escape='true'/>
							</td>
							<td align="center">
								<a class="uline single" href="javascript: void(0);" onclick="downfile('${attachmentId}');">下载</a>								
							</td>
						</tr>
					</s:iterator>
				</s:if>
				<s:else>
					<tr>
						<td colspan="5" align="left">没有查到任何记录!&nbsp;</td>
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
</div>
</div>
</div>
</div>
<div align="center">
		<input  type="button" id="nextBtn" class="button next" href="javascript: void(0);" value="下一步">
</div>
</div>
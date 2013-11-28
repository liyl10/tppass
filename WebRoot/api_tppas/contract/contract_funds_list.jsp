<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/contract/js/contract_funds_list.js"></script>
<form id="testId"></form>
<div id="resultDiv">
	<div align="center"
		style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
		<div style="text-align: left;">
			<div class="Servicel04">
				<div class="abuot02">
					<div class="abuot07">拨款单管理</div>
					<div style="border-bottom: 1px dashed #C9DEEE;">
					</div>
<s:hidden id="tcontractId" name="tcontractId" value="%{tcontractId}"></s:hidden>
<s:hidden id="mainFlag" name="mainFlag" value="%{mainFlag}"></s:hidden>
<s:hidden id="highOrOtherFlag" name="highOrOtherFlag" value="%{highOrOtherFlag}"></s:hidden>

<!-- 保存按钮提示信息 -->
<label id="comfirmDelete" style="display: none"><s:text name="confirm_del_info"/></label>
<div
	style="float: right; padding-right: 20px; border-bottom: 1px dashed #C9DEEE;">
	<input type="button" class="button add" href="javascript: void(0);" onclick="insert();" value="新增拨款单">
</div>
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						class="t-list">
						<tr>
							<th align="center" width="5%">
								序号
							</th>
							<th align="center" width="15%">
								委托任务
							</th>
							<th align="center" width="15%">
								项目承担（单位全称）
							</th>
							<th align="center" width="15%">
								开户银行及行号
							</th>
							<th align="center" width="10%">
								帐号
							</th>
							<th align="center" width="8%">
								本次拨款金额 <br/>
								（万元）
							</th>
							<th align="center" width="8%">
								项目计划拨款<br/>
								金额（万元）
							</th>
							<th align="center" width="10%">
								拨款日期
							</th>
							<th align="center" width="20%">
								操作
							</th>
						</tr>
			         <s:if test="pager.list.size > 0">
		  				<s:iterator value="pager.list" status="rowData">
							<tr align=middle>
							<td align="left">
								${(pager.pageNumber-1)*pager.pageSize+rowData.count}
								<input type="hidden" id="appropriationSingleId" value="${appropriationSingleId}">
							</td>
							<td align="left">
								<s:property value='%{TasksEntrusted}' escape='true'/>&nbsp;
							</td>
							<td align="left">
								<s:property value='%{Undertaker}' />&nbsp;
							</td>
							<td align="left">
								<s:property value='%{bank}' />
							</td>
							<td align="left">
								<s:property value='%{account}' />
							</td>
							<td align="left">
								<s:property value='%{AmountFunding}' />
							</td>
							<td align="left">
								<s:property value='%{planFunding}' />
							</td>
							<td align="left">
								<s:property value='%{getText("{0,date,yyyy-MM-dd}",{AppropriationTime})}' />
							</td>
							<td align="center">
								<a href="javascript: void(0);" onclick="showUpdate('${appropriationSingleId}')">
									修改
								</a>		
								<a href="javascript: void(0);" onclick="showDelete('${appropriationSingleId}')">
									删除
								</a>		
							</td>
					</tr>
		        </s:iterator>
		     </s:if>
		     <s:else>
		     	<TR>
		     		<td colspan="9" align="left">没有查到任何记录!</td>
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
<%-- 	<div align="center">
		<s:if test="%{mainFlag != 1}">
			<input  type="button" id="nextBtn" class="button next" href="javascript: void(0);" value="下一步">	
		</s:if>
	</div>--%>
	</div>
</div>

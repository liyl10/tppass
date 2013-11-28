<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/contract/js/contract_management_list.js"></script>
<s:hidden id="userFlag" name="userFlag" value="%{userFlag}"></s:hidden>
<!-- 下发合同按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="comfirm_contract_xfht"/></label>
<label id="comfirmChoose" style="display: none"><s:text name="comfirm_contract_choose"/></label>
<label id="comfirmType" style="display: none"><s:text name="comfirm_contract_type"/></label>
<div style="border-bottom: 1px dashed #C9DEEE;"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
		<tr align="center">
		    <th width="5%">项目编号</th>
		    <th width="20%">项目名称</th>
		    <th width="15%">申报单位</th>
		    <th width="23%">项目分类</th>
		    <th width="7%">合同下发日期</th>
		    <th width="5%">合同状态</th>
		    <th width="25%">操作</th>
		</tr>
	<s:if test="pager.list.size > 0">
			<s:iterator value="pager.list" status="rowData">
				<tr align=middle>
					<td height=25 align="center"><div align="left">
							<s:property value='%{projectNumber}' escape='true' />
						</div></td>
					<td><div align="left">
							<s:property value='%{projectName}' escape='true' />
						</div></td>
					<td><div align="left">
							<s:property value='%{applicationUnit}' escape='true' />
						</div></td>
					<td><div align="left">
							<s:property value='%{tprojectTypeName}' escape='true' />
						</div></td>
					<td><div align="left">
							<s:property value='%{getText("{0,date,yyyy-MM-dd}",{contractDate})}' />
						</div></td>
					<td><div align="left">
							<s:property value='%{contractStatus}' escape='true' />
						</div></td>
					<td><div align="left">
					<s:if test="%{userFlag == 0 && contractStatus1==@com.hopsun.tppas.common.Constants@CONTRACT_STATE_NOISSUED}">
						<a href="javascript: void(0);" onclick="issuedContract('${tcontractId}','${type}')">下发合同</a>
					</s:if>
					<s:if test="%{userFlag == 0 && contractStatus1==@com.hopsun.tppas.common.Constants@CONTRACT_STATE_ISSUED}">
						<a href="javascript: void(0);" onclick="showDetail('${tcontractId}','<s:property value="#application[typeId+'-ht-audit']"/>')">修改</a>
						<s:if test="type == 1">
							<a href="javascript: void(0);" onclick="typeBg('${tcontractId}')">合同类型变更</a>
						</s:if>
					</s:if>
					<s:if test="%{userFlag == 1 && contractStatus1==@com.hopsun.tppas.common.Constants@CONTRACT_STATE_ISSUED}">
						<a href="javascript: void(0);" onclick="showDetail('${tcontractId}','<s:property value="#application[typeId+'-ht-audit']"/>')">详细</a>
					</s:if>
					<s:if test="%{userFlag == 0}">
						<a href="javascript: void(0);" onclick="showBkd('${tcontractId}')">拨款单管理</a>
					</s:if>
					
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
				id="totalRecords" name="pager.totalCount"
				value="${pager.totalCount}" /> <input type="hidden" id="totalPages"
				name="pager.pageCount" value="${pager.pageCount}" />
		</div>
	</s:if>
<!-- 查询结果列表E -->
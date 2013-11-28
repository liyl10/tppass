<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/audit/js/expert_list.js"></script>
<label id="comfirmDelete" style="display: none"><s:text name="confirm_del_info"/></label>
<s:hidden id="selectedId" name="selectedId"></s:hidden>
<div style=" margin-bottom: 0px;">
	<div align="left">
		<input class="button" type="button" id="insertBtn" value="继续添加" onclick="addExpert('${projectId}');"/>
		&nbsp;
		<input class="button" type="button" id="delsExpertBtn" value="删除专家" onclick="deleteBatchExpert();"/>
		&nbsp;
	</div>
	<!-- <div style="float: right;">
		<input class="button" type="button" id="signInBtn" value="专家签到表"/>
		&nbsp;
		<input class="button" type="button" id="costBtn" value="费用领取表"/>
		&nbsp;
		<input class="button" type="button" id="reviewBtn" value="评审意见表" onclick="downLoadExpertScore();"/>
		&nbsp;
	</div> -->
</div>
<div style="border-bottom: 1px dashed #C9DEEE;"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
		<tr align="center">
			<th width="5%"><s:checkbox name="" id="selectAll" onclick="selectAll();"></s:checkbox></th>
		    <th width="10%">专家姓名</th>
		    <th width="16%">擅长专业1</th>
		    <th width="16%">擅长专业2</th>
		    <th width="16%">擅长专业3</th>
		    <th width="16%">工作单位</th>
		    <th width="8%">注册时间</th>
		    <th width="5%">信誉度</th>	
		    <th width="8%">操作</th>
		</tr>
		<s:if test="pager.list.size > 0">
			<s:iterator value="pager.list" status="rowData">
				<tr>
					<td align="center">
						<input type="checkbox" value="${texpert.expertId}" onclick="saveOrDelSelect(this);"/>
					</td>
					<td>
						<s:property value="%{texpert.expertName}" escape="true"/>
					</td>
					<td>
						<s:property value="%{texpert.expertMajor1}" escape="true"/>
					</td>
					<td>
						<s:property value="%{texpert.expertMajor2}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{texpert.expertMajor3}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{texpert.expertWork}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{getText('{0,date,yyyy-MM-dd}',{texpert.registerTime})}" escape="true"/>&nbsp;
					</td>
					<td align="center">
						<s:property value="%{texpert.expertPrestige}" escape="true"/>
					</td>
					<td align="center">
						<a href="javascript: void(0);" class="uline single" onclick="deleteExpert('<s:property value='%{texpert.expertId}' escape='true'/>');">删除</a>
					</td>
				</tr>
			</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<td colspan="9">
					没有查到任何记录!&nbsp;
				</td>
			</tr>
		</s:else>
	</table>
<%-- 	<s:hidden id="pageCount" name="pageCount" value="%{pager.pageCount}"></s:hidden>
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
	</s:if> --%>
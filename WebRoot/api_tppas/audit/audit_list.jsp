<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/audit/js/audit_list.js"></script>
<s:hidden id="selectedId" name="selectedId"></s:hidden>
<div style="border-bottom: 1px dashed #C9DEEE;"></div>
	<div style=" margin-bottom: 40px;">
		<div style="float: right;">
			<input class="button" type="button" id="signInBtn" value="专家签到表"/>
			&nbsp;
			<input class="button" type="button" id="costBtn" value="费用领取表"/>
			&nbsp;
			<input class="button" type="button" id="reviewBtn" value="评审意见表" onclick="downLoadExpertScore();"/>
			&nbsp;
		</div>
	</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
		<tr align="center">
			<%-- <th width="5%">
				<s:checkbox name="" id="selectAll" onclick="selectAll();" expertFlag=""></s:checkbox>
			</th> --%>
		    <th width="12%">项目名称</th>
		    <th width="12%">申报单位</th>
		    <th width="8%">单位性质</th>
		   <!--  <th width="6%">当前阶段</th> -->
		    <th width="8%">计划类别</th>
		    <th width="10%">技术领域</th>
		    <th width="8%">状态</th>	
		    <th width="19%">操作</th>
		</tr>
		<s:if test="pager.list.size > 0">
			<s:iterator value="pager.list" status="rowData">
				<s:if test="%{projectId == ''}">
					<tr>
						<td colspan="7" bgcolor="#D6E6F5">
							<%-- <input type="checkbox" onclick="selectGroup(this)" 
							name="<s:property value='%{groupName}' escape='true'/>" 
							expertFlag=""/> --%>
							<s:property value="%{groupShowName}" escape="true"/>
						</td> 
					</tr>
				</s:if>
				<s:else>
				<tr>
					<%-- <td align="center">
						<input type="checkbox" name="<s:property value='%{groupName}' escape='true'/>" 
						expertFlag="<s:property value='%{selectedExpertFlag}' escape='true'/>"
						value="<s:property value='%{projectId}' escape='true'/>"
						onclick="selectCheckbox(this);"/>
					</td> --%>
					<td>
						<a href="javascript: void(0);" class="uline single" onclick="showDetail('${projectId}');">
							<s:property value="%{projectName}" escape="true"/>
						</a>
					</td>
					<td>
						<a href="javascript: void(0);" class="uline single" onclick="">
							<s:property value="%{applicationUnit}" escape="true"/>
						</a>
					</td>
					<td>
						<s:property value="%{unitProperties}" escape="true"/>&nbsp;
					</td>
					<%-- <td>
						<s:property value="%{flowStatus}" escape="true"/>&nbsp;
					</td> --%>
					<td>
						<s:property value="%{projectTypeName}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{technicalFisld}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{applyStatus}" escape="true"/>
					</td>
					<td align="center">
						<a href="javascript: void(0);" class="uline single" onclick="showAuditPropress('${projectId}');">查看评审进度</a>
						<a href="javascript: void(0);" class="uline single" onclick="showFillOpinions('${projectId}');">填写意见</a>
					</td>
				</tr>
				</s:else>
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
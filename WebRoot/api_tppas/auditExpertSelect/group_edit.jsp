<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/api_tppas/auditExpertSelect/js/group_edit.js"></script>
<s:hidden id="groupDateFlag" name="groupDateFlag"
	value="%{groupDateFlag}"></s:hidden>

<s:hidden id="selectedId" name="selectedId"></s:hidden>
<s:hidden id="totalCount" name="totalCount" value="%{pager.totalCount}"></s:hidden>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">编辑分组</div>
				<div>
					<form id="searchForm">
						<s:hidden id="groupId" name="groupId" value="%{groupId}"></s:hidden>
						<table class="t-entRegFrm"
							style="width: 100%; border-collapse: collapse">
							<tr>
								<td
									style="white-space: nowrap; width: 8%; text-align: right; padding: 2 2 10 10; font-size: 105%">
									<FONT color=red>*</FONT>分组名称&nbsp;
								</td>
								<td style="white-space: nowrap; width: 25%; padding: 2px"><input
									type="text" id="groupName" name="groupName" class="inputA"
									autocomplete="off" maxlength="20" style="width: 15em;"
									onblur="upms.upmsUtils.blurTextCheck(this,'分组名称',1,-1)"
									onfocus="upms.upmsUtils.textFocus(this);"
									value="<s:property value='%{groupName}'/>" /> &nbsp;</td>
								<s:hidden id="hiddengroupName" name="hidden" value="分组名称,1,-1"></s:hidden>
							</tr>
							<tr>
								<td
									style="white-space: nowrap; width: 8%; text-align: right; padding: 2 2 10 10; font-size: 105%">
									<FONT color=red>*</FONT>项目分类&nbsp;
								</td>
								<td style="white-space: nowrap; width: 26%; padding: 2px"><s:property
										value="%{projectType}" /></td>
							</tr>
						</table>
					</form>
				</div>
				<div style="margin-bottom: 22px; width: 100%">
					<div style="float: left;">
						<input style="align: left" class="button" type="button"
							id="canelBtn" value="删除" onclick="deleteGroupSelect();" />&nbsp;
					</div>
					<div style="float: right;">
						<input style="align: right" class="button" type="button"
							id="createGroupBtn" value="选择项目" onclick="selectProject();" />&nbsp;
					</div>
				</div>
				<div>&nbsp;</div>
				<!-- 查询结果列表S -->
				<!-- <div id="resultDiv"> -->
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="t-list">
					<tr align="center">
						<th width="5%"><s:checkbox name="" id="selectAll"
								onclick="selectAll();"></s:checkbox></th>
						<th width="12%">项目名称</th>
						<th width="12%">申报单位</th>
						<th width="8%">单位性质</th>
						<th width="20%">项目分类</th>
						<th width="18%">技术领域</th>
						<th width="8%">操作</th>
					</tr>
					<s:if test="pager.list.size > 0">
						<s:iterator value="pager.list" status="rowData">
							<tr>
								<td align="center"><input type="checkbox"
									value="${projectId}" onclick="saveOrDelSelect(this);" /></td>
								<td><s:property value="%{projectName}" escape="true" /></td>
								<td><s:property value="%{applicationUnit}" escape="true" />
								</td>
								<td><s:property value="%{unitProperties}" escape="true" />&nbsp;
								</td>
								<td><s:property value="%{projectTypeName}" escape="true" />&nbsp;
								</td>
								<td><s:property value="%{technicalFisld}" escape="true" />&nbsp;
								</td>
								<td align="center"><a href="javascript: void(0);"
									class="uline single"
									onclick="deleteFromGroup('${projectId}','${groupId}');">删除</a>
								</td>
							</tr>
						</s:iterator>
					</s:if>
					<s:else>
						<tr>
							<td colspan="8">没有查到任何记录!&nbsp;</td>
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
						<input type="hidden" id="pageNo" name="pager.pageNumber"
							value="${pager.pageNumber}" /> <input type="hidden"
							id="totalRecords" name="pager.totalCount"
							value="${pager.totalCount}" /> <input type="hidden"
							id="totalPages" name="pager.pageCount" value="${pager.pageCount}" />
					</div>
				</s:if>
				<!-- </div> -->
				<!-- 查询结果列表E -->
				<div>&nbsp;</div>
				<div align="center">
					<input class="button" type="button" id="saveGroupBtn" value="提交"
						onclick="saveGroup();" />&nbsp; <input class="button"
						type="button" id="backBtn" value="返回" />&nbsp;
				</div>
			</div>

		</div>

	</div>
</div>
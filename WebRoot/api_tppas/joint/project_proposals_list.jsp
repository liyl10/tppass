<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/joint/js/project_proposals_list.js"></script>
<s:hidden id="selectedId" name="selectedId"></s:hidden>
<s:hidden id="listFlag" name="listFlag" value="%{listFlag}"></s:hidden>
<div style="border-bottom: 1px dashed #C9DEEE;"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
		<tr align="center">
			<th rowspan="2"  width="3%">
				<s:checkbox name="" id="selectAll" onclick="selectAll();" expertFlag=""></s:checkbox>
			</th>
		    <th rowspan="2" width="12%">项目名称</th>
		    <th rowspan="2" width="12%">申报单位</th>
		    <th rowspan="2" width="18%">项目分类</th>
		    <th rowspan="2" width="10%">推荐意见</th>
		    <th rowspan="2" width="10%">意见状态</th>
		    <th colspan="2" width="10%">技术专家</th>
		    <th colspan="2" width="10%">投资专家</th>
		    <th rowspan="2" width="10%">操作</th>
		</tr>
		<tr align="center">
			<th>平均分</th>
			<th>推荐意见</th>
			<th>平均分</th>
			<th>推荐意见</th>
		</tr>
		<s:if test="pager.list.size > 0">
			<s:iterator value="pager.list" status="rowData">
				<s:if test="%{projectId == ''}">
					<tr align="center">
						<td  bgcolor="#D6E6F5">
							<input type="checkbox" onclick="selectGroup(this)" 
							name="<s:property value='%{groupName}' escape='true'/>" 
							expertFlag="" value=""/>
						</td>
						<td colspan="9" bgcolor="#D6E6F5" align="left">
							<strong><s:property value="%{groupShowName}" escape="true"/></strong>
						</td>
						<td bgcolor="#D6E6F5">
						<%--  weina start 组有专家 专家评估表 按钮可用，没有则不可用
							<s:if test="%{expertBygroup == true}">
								<a href="javascript: void(0);" class="uline single" 
								onclick="downloadExpertScoreByGroup('${groupId}');">打印评分表</a>
							</s:if>
							<s:else>
								<a href="javascript: void(0);" class="uline single" 
								onclick="downloadExpertScoreByGroup('${groupId}');" disabled="disabled">打印评分表</a>
							</s:else>--%>
							 <a href="javascript: void(0);" class="uline single" 
							onclick="printAuditResultByGroup('${groupId}');">打印评审结果</a>
							<%-- <a href="javascript: void(0);" class="uline single" 
							onclick="showSendMessage('${groupId}');">发送通知</a>
							<a href="javascript: void(0);" class="uline single" 
							onclick="showFillOpinions('${groupId}');">项目评分</a>
							<a href="javascript: void(0);" class="uline single" 
							onclick="printExpertOpinions('${groupId}');">专家意见汇总</a>--%>
						</td>
					</tr>
				</s:if>
				<s:else>
				<tr>
					<td align="center">
						<input type="checkbox" name="<s:property value='%{groupName}' escape='true'/>" 
						expertFlag="<s:property value='%{selectedExpertFlag}' escape='true'/>"
						value="<s:property value='%{projectId}' escape='true'/>"
						onclick="selectCheckbox(this);"/>
					</td>
					<td>
						<a href="javascript: void(0);" class="uline single" onclick="viewProjectReportInfo('${projectId}','<s:property value="#application[typeId+'-sb-edit']"/>');">
							<s:property value="%{projectName}" escape="true"/>
						</a>
					</td>
					<td>
						<a href="javascript: void(0);" class="uline single" onclick="viewCompanyInfo('${projectId}');">
							<s:property value="%{applicationUnit}" escape="true"/>
						</a>
					</td>
					<td>
						<s:property value="%{projectTypeName}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{expertAuditRecommend}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{opinionStates}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{projectTechnologyAverage}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{projectTechnologyResult}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{projectInvestmentAverage}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{projectInvestmentResult}" escape="true"/>&nbsp;
					</td>
					<td align="center">
						<a href="javascript: void(0);" class="uline single" 
							onclick="otherComments('${projectId}');">其他意见</a>
					</td>
				</tr>
				</s:else>
			</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<td colspan="11">
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
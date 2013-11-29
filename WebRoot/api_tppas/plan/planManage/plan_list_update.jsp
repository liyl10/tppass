<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/plan/planManage/js/plan_list_update.js"></script>
<s:hidden id="selectedId" name="selectedId"></s:hidden>
<s:hidden id="projectCount" name="tplan.projectCount" value="%{proAppListCount}"></s:hidden>
<s:hidden id="proAppListCount" name="proAppListCount" value="%{proAppListCount}"></s:hidden>
<label id="comfirmCancel" style="display: none"><s:text name="confirm_cancel_info1"/></label>
<div style="border-bottom: 1px dashed #C9DEEE;"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
		<tr align="center">
			<th width="3%" rowspan="2">
				<s:checkbox name="" id="selectAll" onclick="selectAll();"></s:checkbox>
			</th>
			<th width="12%" rowspan="2">项目名称</th>
			<th width="14%" rowspan="2">申报单位</th>
			<th width="10%" rowspan="2">起止时间</th>
			<th colspan="3">总投入（万元）</th>
			<th colspan="2">经济效益预测<br />
		    		（万元）
		    </th>
			<th width="8%" rowspan="2">归口管理单位</th>
			<th width="15%" rowspan="2">选择状态</th>
			<th width="8%" rowspan="2">操作</th>
		</tr>
		<tr align="center">
		  <th width="5%">合计</th>
		  <th width="5%">科研资金</th>
		  <th width="7%">自筹</th>
		  <th width="5%">销售收入</th>
		  <th width="7%">利税</th>
		</tr>
		<s:if test="proAppList.size > 0">
			<s:iterator value="proAppList" status="rowData">
				<s:if test="%{projectId == ''}">
					<tr>
						<td align="center" colspan="4">
							合计
						</td>
						<td>
							<s:property value="%{inputTotal}" escape="true"/>&nbsp; 
							<s:hidden id="inputTotal" name="tplan.inputTotal" value="%{inputTotal}"></s:hidden>
						</td>
						<td>
							<s:property value="%{researchFunds}" escape="true"/>&nbsp; 
							<s:hidden id="researchFunds" name="tplan.researchFunds" value="%{researchFunds}"></s:hidden>
						</td>
						<td>
							<s:property value="%{selfFinancing}" escape="true"/>&nbsp; 
							<s:hidden id="selfFinancing" name="tplan.selfFinancing" value="%{selfFinancing}"></s:hidden>
						</td>
						<td>
							<s:property value="%{projectExpectOutput}" escape="true"/>&nbsp; 
							<s:hidden id="projectExpectOutput" name="tplan.projectExpectOutput" value="%{projectExpectOutput}"></s:hidden>
						</td>
						<td>
							<s:property value="%{projectExpectProfitTax}" escape="true"/>&nbsp; 
							<s:hidden id="projectExpectProfitTax" name="tplan.projectExpectProfitTax" value="%{projectExpectProfitTax}"></s:hidden>
						</td>
							<s:hidden id="companyExpectOutput" name="tplan.companyExpectOutput" value="%{companyExpectOutput}"></s:hidden>
							<s:hidden id="companyExpectProfitTax" name="tplan.companyExpectProfitTax" value="%{companyExpectProfitTax}"></s:hidden>
							
						<td colspan="3">
							&nbsp;
						</td>
					</tr>
				</s:if>
				<s:else>
					<tr>
						<s:hidden id="projectId%{#rowData.count}" name="proAppList[%{#rowData.count}].projectId" value="%{projectId}"></s:hidden>
						<td align="center">
							<input type="checkbox" value="${projectId}" onclick="saveOrDelSelect(this);"/>
						</td>
						<td>
							<a href="javascript: void(0);" class="uline single" 
								onclick="viewProjectReportInfo('${projectId}','<s:property value="#application[tprojectType.typeId+'-sb-edit']"/>');">
								<s:property value="%{projectName}" escape="true"/>
							</a>
						</td>
						<td>
							<a href="javascript: void(0);" class="uline single" onclick="viewCompanyInfo('${projectId}');">
								<s:property value="%{applicationUnit}" escape="true"/>
							</a>
						</td>
						<td>
							<s:property value="%{getText('{0,date,yyyy/MM}',{startTime})}" escape="true"/>
							-
							<s:property value="%{getText('{0,date,yyyy/MM}',{endTime})}" escape="true"/>
						</td>
						<td>
							<s:property value="%{inputTotal}" escape="true"/>&nbsp; 
						</td>
						<td>
							<s:property value="%{researchFunds}" escape="true"/>&nbsp; 
						</td>
						<td>
							<s:property value="%{selfFinancing}" escape="true"/>&nbsp; 
						</td>
						<td>
							<s:property value="%{projectExpectOutput}" escape="true"/>&nbsp; 
						</td>
						<td>
							<s:property value="%{projectExpectProfitTax}" escape="true"/>&nbsp; 
						</td>
						<td>
							<s:property value="%{centralizedTypeName}" escape="true"/>&nbsp;
						</td>
						<td>
							<s:radio 
								id="expertProofResearch%{#rowData.count}"
								name="proAppList[%{#rowData.count}].expertProofResearch" 
								list="%{proSelectStatusList}" 
								listKey="itemId" 
								listValue="itemName" 
								value="%{expertProofResearch}"
								onchange="upms.upmsUtils.radioChange(this);"
								>
							</s:radio>
						</td>
						<td align="center">
							<a href="javascript: void(0);" class="uline single" 
								onclick="deleteProject('${projectId}');">删除</a>
						</td>
					</tr>
				</s:else>
			</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<td colspan="12">
					没有查到任何记录!&nbsp;
				</td>
			</tr>
		</s:else>
	</table>
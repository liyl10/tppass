<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/api_tppas/plan/js/plan_collection_edit.js"></script>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">修改计划汇总</div>
				<div>&nbsp;</div>
				<label id="path" style="display: none;">${pageContext.request.contextPath}</label>
				<div>
					<form id="searchForm">
						<table class="t-entRegFrm" style="width: 100%;border-collapse: collapse">
							<tr>
								<td align="right">计划汇总名称&nbsp;</td>
								<td><input type="text" id="planCollectName"
									name="planCollectName" class="inputA" autocomplete="off"
									style="width: 15em;" maxlength="40"
									value="<s:property value="%{tplanCollect.planCollectName}" escape="true"/>"
									onblur="upms.upmsUtils.blurTextCheck(this,'计划汇总名称',1,-1)"
									onfocus="upms.upmsUtils.textFocus(this);" /> 
									<s:hidden id="hiddenplanCollectName" name="hidden" value="计划汇总名称,1,-1"></s:hidden>
								</td>

							</tr>
							<tr>
								<td align="right">计划年度&nbsp;</td>
								<td><input class="txt w184p Wdate" type="text"
									name="planYear" id="planYear"
									onclick="WdatePicker({dateFmt:'yyyy'})" readonly="readonly"
									value="<s:property value="%{tplanCollect.planCollectYear}" escape="true"/>"
									onblur="upms.upmsUtils.blurTextCheck(this,'计划年度',1,-1);"
									onfocus="upms.upmsUtils.textFocus(this);" /> <s:hidden
										id="hiddenplanYear" name="hidden" value="计划年度,1,-1"></s:hidden>
								</td>
							</tr>
							<tr>
								<td align="right">计划批次&nbsp;</td>
								<td><s:select list="planBatchList" listKey="itemId"
										label="abc" listValue="itemName" id="planBatch"
										name="planBatch" style="width:15.5em;"
										value="%{tplanCollect.planCollectBatch}"
										onblur="upms.upmsUtils.blurTextCheck(this,'计划批次');"
										onfocus="upms.upmsUtils.textFocus(this);"></s:select> <s:hidden
										id="hiddenplanBatch" name="hidden" value="计划批次"></s:hidden>
									<s:hidden id="selectedPlanCollectBatch" value="%{tplanCollect.planCollectBatch}"/>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div align="right"><input class="button" type="button" id="selectBtn" onclick="toSelectPlanPage('${tplanCollect.planCollectId}');" value="选择分计划" /></div>
				<div>
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						class="t-list">
						<tr align="center">
							<th width="5%">序号</th>
							<th width="15%">计划项目名称</th>
							<th width="5%">项目数</th>
							<th width="11%">科研资金</th>
							<th width="11%">总投入</th>
							<th width="11%">项目预计产值</th>
							<th width="11%">项目预计利税</th>
							<th width="11%">企业预计产值</th>
							<th width="11%">企业预计利税</th>
							<th width="12%">操作</th>
						</tr>
						<s:if test="selectPlanList.size > 0">
							<s:iterator value="selectPlanList" status="rowData">
								<s:if test="%{planId == ''}">
									<tr bgcolor="#D6E6F5">
								</s:if>
								<s:else>
									<tr>
								</s:else>
								<td align="center"><s:property value="%{index}" escape="true" /></td>
									<td><s:property value="%{planName}" escape="true" /></td>
									<td><s:property value="%{projectCount}" escape="true" /></td>
									<td><s:property value="%{getText('format.money',{researchFunds})}" escape="true" /></td>
									<td><s:property value="%{getText('format.money',{inputTotal})}" escape="true" /></td>
									<td><s:property value="%{getText('format.money',{projectExpectOutput})}" escape="true" /></td>
									<td><s:property value="%{getText('format.money',{projectExpectProfitTax})}" escape="true" /></td>
									<td><s:property value="%{getText('format.money',{companyExpectOutput})}" escape="true" /></td>
									<td><s:property value="%{getText('format.money',{companyExpectProfitTax})}" escape="true" /></td>
									<td align="center">
									<s:if test="%{planId == ''}">
										<s:if test="%{tplanCollect == null}">
										</s:if>
										<s:else>
											<a href="javascript: void(0);" class="uline single" onclick="deletePlanByType('${planFlag}','${tplanCollect.planCollectId}');">删除</a>
										</s:else>
									</s:if>
									<s:else>
										<a href="javascript: void(0);" class="uline single" onclick="deletePlan('${planId}','${tplanCollect.planCollectId}');">删除</a>
									</s:else></td>
								</tr>
							</s:iterator>
						</s:if>
						<s:else>
							<tr>
								<td colspan="10">没有查到任何记录!&nbsp;</td>
							</tr>
						</s:else>
					</table>
				</div>
				<div style="text-align: center">
					<input class="button" type="button" id="editBtn" onclick="updatePlanDetail('${tplanCollect.planCollectId}');" value="提交" />
					<input class="button" type="button" id="backBtn" value="返回" />
				</div>
			</div>
		</div>
	</div>
</div>
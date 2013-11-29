<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/api_tppas/plan/js/plan_collection_detail.js"></script>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">查看计划汇总</div>
				<div>&nbsp;</div>
				<label id="path" style="display: none;">${pageContext.request.contextPath}</label>
				<div>
					<form id="searchForm">
						<table class="t-entRegFrm"
							style="width: 100%; border-collapse: collapse">
							<tr>
								<td style="width:40%" align="right">计划汇总名称&nbsp;</td>
								<td><s:property value="%{tplanCollect.planCollectName}" /></td>
							</tr>
							<tr>
								<td style="width:40%" align="right">计划年度&nbsp;</td>
								<td><s:property value="%{tplanCollect.planCollectYear}" /></td>
							</tr>
							<tr>
								<td style="width:40%" align="right">计划批次&nbsp;</td>
								<td><s:property value="%{planBatch}" /></td>
							</tr>
						</table>
					</form>
				</div>
				<div>&nbsp;</div>
				<div align="left"><label>该计划中包含的分计划列表</label></div>
				<div>
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						class="t-list">
						<tr align="center">
							<th width="5%">序号</th>
							<th width="15%">计划项目名称</th>
							<th width="5%">项目数</th>
							<th width="12%">科研资金</th>
							<th width="12%">总投入</th>
							<th width="12%">项目预计产值</th>
							<th width="12%">项目预计利税</th>
							<th width="12%">企业预计产值</th>
							<th width="12%">企业预计利税</th>
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
								</tr>
							</s:iterator>
						</s:if>
						<s:else>
							<tr>
								<td colspan="9">没有查到任何记录!&nbsp;</td>
							</tr>
						</s:else>
					</table>
				</div>
				<div style="text-align: center">
					<input class="button" type="button" id="printBtn" onclick="printPlanDetail('${tplanCollect.planCollectId}');" value="打印" />
					<input class="button" type="button" id="editBtn" onclick="editPlanDetail('${tplanCollect.planCollectId}');" value="修改" />
					<input class="button" type="button" id="backBtn" value="返回" />
				</div>
			</div>
		</div>
	</div>
</div>
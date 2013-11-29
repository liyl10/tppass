<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/plan/planManage/js/plan_detail.js"></script>
<s:hidden id="planId" name="tplan.planId" value="%{tplan.planId}"></s:hidden>
<s:hidden id="proAppListCount" name="proAppListCount" value="%{proAppListCount}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">分计划编制</div>
						
				<!-- 项目根目录 -->
				<div class=requirecolor id="errInfo"></div>
				<table width="100%" class="t-entRegFrm" cellspacing="0" cellpadding="0">
					<tr>
						<td width="40%" style="padding: 4px 8px; text-align: right">
							计划项目类别
						</td>
						<td width="60%" style="padding: 4px 8px; text-align: left">
							<s:property value='%{tplan.planFlagName}' escape='true'/>
						</td>
					</tr>
					<tr>
						<td width="40%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>分计划名称
						</td>
						<td width="60%" style="padding: 4px 8px; text-align: left">
							<s:property value='%{tplan.planName}' escape='true'/>
						</td>
					</tr>
					<tr>
						<td width="40%" style="padding: 4px 8px; text-align: right">
							计划年度
						</td>
						<td width="60%" style="padding: 4px 8px; text-align: left">
							<s:property value='%{tplan.planYear}' escape='true'/>
						</td>
					</tr>
					<tr>
						<td width="40%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>计划批次
						</td>
						<td width="60%" style="padding: 4px 8px; text-align: left">
							<s:property value='%{tplan.planBatch}' escape='true'/>
						</td>
						<s:hidden id="planBatchValue" name="hidden" value="%{tplan.planBatch}"></s:hidden>
						<s:hidden id="hiddenplanBatch" name="hidden" value="计划批次"></s:hidden>
					</tr>
				</table>
				<div>&nbsp;</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
					<tr align="center">
						<th width="14%" rowspan="2">项目名称</th>
						<th width="14%" rowspan="2">申报单位</th>
						<th width="10%" rowspan="2">起止时间</th>
						<th colspan="3">总投入（万元）</th>
						<th colspan="2">经济效益预测<br />
					    		（万元）
					    </th>
						<th width="8%" rowspan="2">归口管理单位</th>
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
									<td align="center" colspan="3">
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
									<td>
										&nbsp;
									</td>
								</tr>
							</s:if>
							<s:else>
								<tr>
									<td>
										<a href="javascript: void(0);" class="uline single" 
											onclick="viewProjectReportInfo('${projectId}','<s:property value="#application[tprojectType.typeId+'-sb-edit']"/>');">
											<s:property value="%{projectName}" escape="true"/>
										</a>
									</td>
									<td>
										<a href="javascript: void(0);" class="uline single">
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
								</tr>
							</s:else>
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
				 <br>
				 <br>
				 <br>
				<div style="width:100%;text-align: center;">
					<input class="button" type="button" id="printBtn" value="打印" id="printBtn" onclick="print();"/>&nbsp;
					<input class="button" type="button" id="backBtn" value="返回" id="backBtn" onclick="back();"/>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/other/js/report_financing_use.js"></script>

<!-- 项目ID -->
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<s:hidden id="financingUseId" name="tfinancingUse.financingUseId" value="%{tfinancingUse.financingUseId}"></s:hidden>
<s:hidden id="reportApplicactionId" name="tfinancingUse.tprojectApplication.projectId" value="%{projectId}"></s:hidden>
<s:hidden id="moneyScheduleId" name="tmoneyScheduleA.moneyScheduleId" value="%{tmoneyScheduleA.moneyScheduleId}"></s:hidden>
<s:hidden id="tmoneyScheduleAApplicactionId" name="tmoneyScheduleA.tprojectApplication.projectId" value="%{projectId}"></s:hidden>

<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">资金主要用途及用款计划</div>	
				<div align="right" style="width:95%">
				（单位：万元）
				</div>
				<div style="border-bottom: 1px dashed #C9DEEE;"></div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm">
				<tr align="center">
					<td width="25%">科目</td>
					<td width="50%" colspan="3">用途摘要说明</td>
					<td width="25%">金额</td>
				</tr>
				<tr>
					<td width="25%" align="right">
						<FONT color=red>*</FONT>研究、试验费
					</td>
					<td width="50%"colspan="3">
						<input id="subject" name="tfinancingUse.subject" 
							type="text" class="inputA" style=" width:480px;ime-mode: disabled;"
							value="<s:property value='%{tfinancingUse.subject}' escape='true'/>"
							maxlength="100" onblur="upms.upmsUtils.blurTextCheck(this,'用途摘要说明',1,-1);" 
							onfocus="upms.upmsUtils.textFocus(this);"
							/>
						<s:hidden id="hiddensubject" name="hidden" value="用途摘要说明,1,-1"></s:hidden>
					</td>
					<td width="25%">
						<input id="selfRaisedFunds" name="tfinancingUse.selfRaisedFunds" 
							type="text" class="inputA" style=" width:150px;ime-mode: disabled; " moneyFlag="money"
							value="<s:property value='%{tfinancingUse.selfRaisedFunds}' escape='true'/>"
							maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'金额',1,2);" 
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
							autoSum="1"
							/>
						<s:hidden id="hiddenselfRaisedFunds" name="hidden" value="金额,1,2"></s:hidden>
					</td>
				</tr>
				<tr>
					<td width="25%" align="right">
						<FONT color=red>*</FONT>材料、设备和仪器费
					</td>
					<td width="50%"colspan="3">
						<input id="applicationDescription" name="tfinancingUse.applicationDescription" 
							type="text" class="inputA" style=" width:480px;ime-mode: disabled; "
							value="<s:property value='%{tfinancingUse.applicationDescription}' escape='true'/>"
							maxlength="100" onblur="upms.upmsUtils.blurTextCheck(this,'用途摘要说明',1,-1);" 
							onfocus="upms.upmsUtils.textFocus(this);"
							/>
						<s:hidden id="hiddenapplicationDescription" name="hidden" value="用途摘要说明,1,-1"></s:hidden>
					</td>
					<td width="25%">
						<input id="specialAmount0" name="tfinancingUse.specialAmount" 
							type="text" class="inputA" style=" width:150px;ime-mode: disabled; " moneyFlag="money"
							value="<s:property value='%{tfinancingUse.specialAmount}' escape='true'/>"
							maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'金额',1,2);" 
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
							autoSum="1"
						/>
						<s:hidden id="hidden0specialAmount" name="hidden" value="金额,1,2"></s:hidden>
					</td>
				</tr>
				<tr>
					<td width="25%" align="right">
						<FONT color=red>*</FONT>其他
					</td>
					<td width="50%" colspan="3">
						<input id="otherDescription" name="tfinancingUse.otherDescription" 
							type="text" class="inputA" style=" width:480px;ime-mode: disabled; "
							value="<s:property value='%{tfinancingUse.otherDescription}' escape='true'/>"
							maxlength="100" onblur="upms.upmsUtils.blurTextCheck(this,'用途摘要说明',1,-1);" 
							onfocus="upms.upmsUtils.textFocus(this);"
							/>
						<s:hidden id="hiddenotherDescription" name="hidden" value="用途摘要说明,1,-1"></s:hidden>
					</td>
					<td width="25%">
						<input id="selfRaisedFundsList" name="tfinancingUse.selfRaisedFundsList" 
							type="text" class="inputA" style=" width:150px;ime-mode: disabled; " moneyFlag="money"
							value="<s:property value='%{tfinancingUse.selfRaisedFundsList}' escape='true'/>"
							maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'金额',1,2);" 
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
							autoSum="1"
						/>
						<s:hidden id="hiddenselfRaisedFundsList" name="hidden" value="金额,1,2"></s:hidden>
					</td>
				</tr>
				<tr>
					<td colspan="4"width="25%" align="right" colspan="2">合计</td>
					<td>
						<input id="specialAmountList" name="tfinancingUse.specialAmountList" 
							type="text" class="inputA" style=" width:150px " readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td colspan="5">用款计划</td>
				</tr>
				<tr align="center">
					<td>年度</td>
					<s:if test="yearList.size > 0">
						<s:iterator value="yearList" status="rowData">
							<td align="left">
								<%-- <input class="txt w184p Wdate" type="text" name="year" id="year<s:property value='%{#rowData.count}' escape='true'/>"
								 onblur="upms.upmsUtils.blurTextCheck(this,'年度',1,10);"
								 onfocus="upms.upmsUtils.textFocus(this);" style="width: 8em;"
								 onclick="WdatePicker({dateFmt:'yyyy'})" readonly="readonly"
								 value="<s:property value='%{year}' escape='true'/>"/>年 --%>
								 <s:property value='%{year}' escape='true'/>年
							</td>
							<s:hidden id="hiddenyear%{#rowData.count}" name="hidden" value="年度,1,10"></s:hidden>
						</s:iterator>
					</s:if>
					<td>合计</td>	
				</tr>
				<tr>
					<td align="right">
						<FONT color=red>*</FONT>用款金额
					</td>
					<td>
						<input id="paymentAmount" name="tmoneyScheduleA.paymentAmount" 
						type="text" class="inputA" style=" width:150px;ime-mode: disabled; " moneyFlag="money"
						value="<s:property value='%{tmoneyScheduleA.paymentAmount}' escape='true'/>"
						maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'用款金额',1,2);" 
						onfocus="upms.upmsUtils.textFocus(this);"
						onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
						autoSum="2"
						/>
						<s:hidden id="hiddenpaymentAmount" name="hidden" value="用款金额,1,2"></s:hidden>
					</td>
					<td>
						<input id="paymentAmount1" name="tmoneyScheduleA.paymentAmount1" 
						type="text" class="inputA" style=" width:150px;ime-mode: disabled; " moneyFlag="money"
						value="<s:property value='%{tmoneyScheduleA.paymentAmount1}' escape='true'/>"
						maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'用款金额',1,2);" 
						onfocus="upms.upmsUtils.textFocus(this);"
						onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
						autoSum="2"
						/>
						<s:hidden id="hiddenpaymentAmount1" name="hidden" value="用款金额,1,2"></s:hidden>
					</td>
					<td>
						<s:if test="%{year3Flag == 0}">
							<input id="paymentAmount2" name="tmoneyScheduleA.paymentAmount2" 
							type="text" class="inputA" style=" width:150px;ime-mode: disabled; " moneyFlag="money"
							value="<s:property value='%{tmoneyScheduleA.paymentAmount2}' escape='true'/>"
							maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'用款金额',1,2);" 
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
							autoSum="2"
							/>
							<s:hidden id="hiddenpaymentAmount2" name="hidden" value="用款金额,1,2"></s:hidden>
						</s:if>
						<s:else>
							<input id="paymentAmount2" name="tmoneyScheduleA.paymentAmount2" 
							type="text" class="inputA" style=" width:150px;ime-mode: disabled; " moneyFlag="money"
							value="<s:property value='%{tmoneyScheduleA.paymentAmount2}' escape='true'/>"
							maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'用款金额',0,2);" 
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
							autoSum="2"
							/>
							<s:hidden id="hiddenpaymentAmount2" name="hidden" value="用款金额,0,2"></s:hidden>
						</s:else>
					</td>
					<td>
						<input id="paymentAmountTotal" name="tmoneyScheduleA.paymentAmountTotal" 
						type="text" class="inputA" style=" width:150px;ime-mode: disabled; " readonly="readonly"
						value="<s:property value='%{tmoneyScheduleA.paymentAmountTotal}' escape='true'/>"
						/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<FONT color=red>*</FONT>其中：科技经费
					</td>
					<td>
						<input id="specialAmount" name="tmoneyScheduleA.specialAmount" 
						type="text" class="inputA" style=" width:150px;ime-mode: disabled; " moneyFlag="money"
						value="<s:property value='%{tmoneyScheduleA.specialAmount}' escape='true'/>"
						maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'专项经费',1,2);" 
						onfocus="upms.upmsUtils.textFocus(this);"
						onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
						autoSum="3"
						/>
						<s:hidden id="hiddenspecialAmount" name="hidden" value="专项经费,1,2"></s:hidden>
					</td>
					<td>
						<input id="specialAmount1" name="tmoneyScheduleA.specialAmount1" 
						type="text" class="inputA" style=" width:150px;ime-mode: disabled; " moneyFlag="money"
						value="<s:property value='%{tmoneyScheduleA.specialAmount1}' escape='true'/>"
						maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'专项经费',1,2);" 
						onfocus="upms.upmsUtils.textFocus(this);"
						onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
						autoSum="3"
						/>
						<s:hidden id="hiddenspecialAmount1" name="hidden" value="专项经费,1,2"></s:hidden>
					</td>
					<td>
						<s:if test="%{year3Flag == 0}">
							<input id="specialAmount2" name="tmoneyScheduleA.specialAmount2" 
							type="text" class="inputA" style=" width:150px;ime-mode: disabled; " moneyFlag="money"
							value="<s:property value='%{tmoneyScheduleA.specialAmount2}' escape='true'/>"
							maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'专项经费',1,2);" 
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
							autoSum="3"
							/>
							<s:hidden id="hiddenspecialAmount2" name="hidden" value="专项经费,1,2"></s:hidden>
						</s:if>
						<s:else>
							<input id="specialAmount2" name="tmoneyScheduleA.specialAmount2" 
							type="text" class="inputA" style=" width:150px;ime-mode: disabled; " moneyFlag="money"
							value="<s:property value='%{tmoneyScheduleA.specialAmount2}' escape='true'/>"
							maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'专项经费',0,2);" 
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
							autoSum="3"
							/>
							<s:hidden id="hiddenspecialAmount2" name="hidden" value="专项经费,0,2"></s:hidden>
						</s:else>
					</td>
					<td>
						<input id="specialAmountTotal" name="tmoneyScheduleA.specialAmountTotal" 
						type="text" class="inputA" style=" width:150px " 
						value="<s:property value='%{tmoneyScheduleA.specialAmountTotal}' escape='true'/>" 
						readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td align="right"><FONT color=red>*</FONT>自筹及其他资金</td>
					<td>
						<input id="otherFunds" name="tmoneyScheduleA.otherFunds" 
						type="text" class="inputA" style=" width:150px;ime-mode: disabled; " moneyFlag="money"
						value="<s:property value='%{tmoneyScheduleA.otherFunds}' escape='true'/>"
						maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'自筹及其他资金',1,2);" 
						onfocus="upms.upmsUtils.textFocus(this);"
						onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
						autoSum="4"
						/>
						<s:hidden id="hiddenotherFunds" name="hidden" value="自筹及其他资金,1,2"></s:hidden>
					</td>
					<td>
						<input id="otherFunds1" name="tmoneyScheduleA.otherFunds1" 
						type="text" class="inputA" style=" width:150px;ime-mode: disabled; " moneyFlag="money"
						value="<s:property value='%{tmoneyScheduleA.otherFunds1}' escape='true'/>"
						maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'自筹及其他资金',1,2);" 
						onfocus="upms.upmsUtils.textFocus(this);"
						onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
						autoSum="4"
						/>
						<s:hidden id="hiddenotherFunds1" name="hidden" value="自筹及其他资金,1,2"></s:hidden>
					</td>
					<td>
						<s:if test="%{year3Flag == 0}">
							<input id="otherFunds2" name="tmoneyScheduleA.otherFunds2" 
							type="text" class="inputA" style=" width:150px;ime-mode: disabled; " moneyFlag="money"
							value="<s:property value='%{tmoneyScheduleA.otherFunds2}' escape='true'/>"
							maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'自筹及其他资金',1,2);" 
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
							autoSum="4"
							/>
						<s:hidden id="hiddenotherFunds2" name="hidden" value="自筹及其他资金,1,2"></s:hidden>
						</s:if>
						<s:else>
							<input id="otherFunds2" name="tmoneyScheduleA.otherFunds2" 
							type="text" class="inputA" style=" width:150px;ime-mode: disabled; " moneyFlag="money"
							value="<s:property value='%{tmoneyScheduleA.otherFunds2}' escape='true'/>"
							maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'自筹及其他资金',0,2);" 
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
							autoSum="4"
							/>
							<s:hidden id="hiddenotherFunds2" name="hidden" value="自筹及其他资金,0,2"></s:hidden>
						</s:else>
					</td>
					<td>
						<input id="otherFundsTotal" name="tmoneyScheduleA.otherFundsTotal" 
						type="text" class="inputA" style=" width:150px " 
						value="<s:property value='%{tmoneyScheduleA.otherFundsTotal}' escape='true'/>" 
						readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td colspan='5'>
						<FONT color=red>*</FONT>
						用款金额指的是总经费
						&nbsp;&nbsp;&nbsp;
						<FONT color=red>*</FONT>
						科技经费指的是拟申请的经费
					</td>
				</tr>
				</table>
				<div align="center" style="width:95%">
						<input id="nextBtn" class="button save" name="button" type="button" href="javascript: void(0);"  value="下一步"/>
				</div>
			</div>
		</div>
	</div>
</div>
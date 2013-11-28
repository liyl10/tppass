<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/highTech/js/supervisorApply_fund.js"></script>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">
					项目资金情况
					<s:if test="%{supportFlag==1}">（项目类）</s:if>
					<s:else>
						<span>（平台类）</span>
					</s:else>
				</div>
				<form id="addform" action="depart.html">
					<table style="width: 100%;" cellspacing="0" cellpadding="0" class="t-entRegFrm">
						<tr>
							<td width="44%" align="center" colspan="2">合同指标（万元）</td>
							<td width="44%" align="center" colspan="2">实际完成（万元）</td>
						</tr>
						<tr>
							<td align="right"><FONT color=red>*</FONT>计划投资总额</td>
							<td><s:textfield cssClass="inputA"
									cssStyle="width:120px;ime-mode: disabled;"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" 
									id="planInvestment"
									name="tsupervisorFund.planInvestment"
									value="%{tsupervisorFund.planInvestment}"
									onblur="blurText(this,'计划投资总额',1,3);"
									onfocus="focusText(this);" disabled="%{isLastApply}"
									maxlength="10" /> <s:hidden id="hiddenplanInvestment"
									name="hidden" value="计划投资总额,1,3"></s:hidden></td>
							<td align="right"><FONT color=red>*</FONT>目前已完成投资</td>
							<td><s:textfield cssClass="inputA"
									cssStyle="width:120px;ime-mode: disabled;"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
									id="completeInvestment"
									name="tsupervisorFund.completeInvestment"
									value="%{tsupervisorFund.completeInvestment}"
									onblur="blurText(this,'目前已完成投资',1,3);"
									onfocus="focusText(this);" disabled="%{isLastApply}"
									maxlength="10" /> <s:hidden id="hiddencompleteInvestment"
									name="hidden" value="目前已完成投资,1,3"></s:hidden></td>
						</tr>
						<tr>
							<td align="right"><FONT color=red>*</FONT>其中:企业自筹</td>
							<td><s:textfield cssClass="inputA"
									cssStyle="width:120px;ime-mode: disabled;"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" id="contractSelf"
									name="tsupervisorFund.contractSelf"
									value="%{tsupervisorFund.contractSelf}"
									onblur="blurText(this,'企业自筹',1,3);" onfocus="focusText(this);"
									disabled="%{isLastApply}" maxlength="10" /> <s:hidden
									id="hiddencontractSelf" name="hidden" value="企业自筹,1,3"></s:hidden>
							</td>
							<td align="right"><FONT color=red>*</FONT>其中:企业自筹</td>
							<td><s:textfield cssClass="inputA"
									cssStyle="width:120px;ime-mode: disabled;"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" id="realSelf"
									name="tsupervisorFund.realSelf"
									value="%{tsupervisorFund.realSelf}"
									onblur="blurText(this,'企业自筹',1,3);" onfocus="focusText(this);"
									disabled="%{isLastApply}" maxlength="10" /> <s:hidden
									id="hiddenrealSelf" name="hidden" value="企业自筹,1,3"></s:hidden>
							</td>
						</tr>
						<tr>
							<td align="right"><FONT color=red>*</FONT>贷款</td>
							<td><s:textfield cssClass="inputA"
									cssStyle="width:120px;ime-mode: disabled;"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" id="contractLoan"
									name="tsupervisorFund.contractLoan"
									value="%{tsupervisorFund.contractLoan}"
									onblur="blurText(this,'贷款',1,3);" onfocus="focusText(this);"
									disabled="%{isLastApply}" maxlength="10" /> <s:hidden
									id="hiddencontractLoan" name="hidden" value="贷款,1,3"></s:hidden>
							</td>
							<td align="right"><FONT color=red>*</FONT>贷款</td>
							<td><s:textfield cssClass="inputA"
									cssStyle="width:120px;ime-mode: disabled;"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" id="realLoan"
									name="tsupervisorFund.realLoan"
									value="%{tsupervisorFund.realLoan}"
									onblur="blurText(this,'贷款',1,3);" onfocus="focusText(this);"
									disabled="%{isLastApply}" maxlength="10" /> <s:hidden
									id="hiddenrealLoan" name="hidden" value="贷款,1,3"></s:hidden></td>
						</tr>
						<tr>
							<td align="right"><FONT color=red>*</FONT>财政资金</td>
							<td><s:textfield cssClass="inputA"
									cssStyle="width:120px;ime-mode: disabled;"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
									id="contractFinancial" name="tsupervisorFund.contractFinancial"
									value="%{tsupervisorFund.contractFinancial}"
									onblur="blurText(this,'财政资金',1,3);" onfocus="focusText(this);"
									disabled="%{isLastApply}" maxlength="10" /> <s:hidden
									id="hiddencontractFinancial" name="hidden" value="财政资金,1,3"></s:hidden>
							</td>
							<td align="right"><FONT color=red>*</FONT>财政资金</td>
							<td><s:textfield cssClass="inputA"
									cssStyle="width:120px;ime-mode: disabled;"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" id="realFinancial"
									name="tsupervisorFund.realFinancial"
									value="%{tsupervisorFund.realFinancial}"
									onblur="blurText(this,'财政资金',1,3);" onfocus="focusText(this);"
									disabled="%{isLastApply}" maxlength="10" /> <s:hidden
									id="hiddenrealFinancial" name="hidden" value="财政资金,1,3"></s:hidden>
							</td>
						</tr>
						<tr>
							<td align="right"><FONT color=red>*</FONT>配套资金</td>
							<td><s:textfield cssClass="inputA"
									cssStyle="width:120px;ime-mode: disabled;"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
									id="contractSupporting"
									name="tsupervisorFund.contractSupporting"
									value="%{tsupervisorFund.contractSupporting}"
									onblur="blurText(this,'配套资金',1,3);" onfocus="focusText(this);"
									disabled="%{isLastApply}" maxlength="10" /> <s:hidden
									id="hiddencontractSupporting" name="hidden" value="配套资金,1,3"></s:hidden>
							</td>
							<td align="right"><FONT color=red>*</FONT>配套资金</td>
							<td><s:textfield cssClass="inputA"
									cssStyle="width:120px;ime-mode: disabled;"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" id="realSupporting"
									name="tsupervisorFund.realSupporting"
									value="%{tsupervisorFund.realSupporting}"
									onblur="blurText(this,'配套资金',1,3);" onfocus="focusText(this);"
									disabled="%{isLastApply}" maxlength="10" /> <s:hidden
									id="hiddenrealSupporting" name="hidden" value="配套资金,1,3"></s:hidden>
							</td>
						</tr>
						<s:if test="%{supportFlag==1}">
							<tr>
								<td align="right"><FONT color=red>*</FONT>其它（注明来源）</td>
								<td><s:textfield cssClass="inputA"
										cssStyle="width:120px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)" id="contractOther"
										name="tsupervisorFund.contractOther"
										value="%{tsupervisorFund.contractOther}"
										onblur="blurText(this,'其它',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddencontractOther" name="hidden" value="其它,1,3"></s:hidden>
								</td>
								<td align="right"><FONT color=red>*</FONT>其它（注明来源）</td>
								<td><s:textfield cssClass="inputA"
										cssStyle="width:120px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)" id="realOther"
										name="tsupervisorFund.realOther"
										value="%{tsupervisorFund.realOther}"
										onblur="blurText(this,'其它',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddenrealOther" name="hidden" value="其它,1,3"></s:hidden>
								</td>
							</tr>
						</s:if>
						<tr>
							<td colspan="4" align="center">资金支出情况：（财政资金）（万元）（可另附表格说明）</td>
						</tr>
						<tr>
							<td align="right"><FONT color=red>*</FONT>人员费</td>
							<td colspan="3"><s:textfield cssClass="inputA"
									cssStyle="width:120px;ime-mode: disabled;"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" id="personnelCost"
									name="tsupervisorFund.personnelCost"
									value="%{tsupervisorFund.personnelCost}"
									onblur="blurText(this,'人员费',1,3);" onfocus="focusText(this);"
									onKeyUp="sumFunds();" disabled="%{isLastApply}" maxlength="10" />
								<s:hidden id="hiddenpersonnelCost" name="hidden" value="人员费,1,3"></s:hidden>
							</td>
						</tr>
						<tr>
							<td align="right"><FONT color=red>*</FONT>设备费</td>
							<td colspan="3"><s:textfield cssClass="inputA"
									cssStyle="width:120px;ime-mode: disabled;"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" id="equipmentCost"
									name="tsupervisorFund.equipmentCost"
									value="%{tsupervisorFund.equipmentCost}"
									onblur="blurText(this,'设备费',1,3);" onfocus="focusText(this);"
									onKeyUp="sumFunds();" disabled="%{isLastApply}" maxlength="10" />
								<s:hidden id="hiddenequipmentCost" name="hidden" value="设备费,1,3"></s:hidden>
							</td>
						</tr>
						<tr>
							<td align="right"><FONT color=red>*</FONT>能源材料费</td>
							<td colspan="3"><s:textfield cssClass="inputA"
									cssStyle="width:120px;ime-mode: disabled;"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" id="energyCost"
									name="tsupervisorFund.energyCost"
									value="%{tsupervisorFund.energyCost}"
									onblur="blurText(this,'能源材料费',1,3);" onfocus="focusText(this);"
									onKeyUp="sumFunds();" disabled="%{isLastApply}" maxlength="10" />
								<s:hidden id="hiddenenergyCost" name="hidden" value="能源材料费,1,3"></s:hidden>
							</td>
						</tr>
						<tr>
							<td align="right"><FONT color=red>*</FONT>试验及外协费</td>
							<td colspan="3"><s:textfield cssClass="inputA"
									cssStyle="width:120px;ime-mode: disabled;"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" id="testCost"
									name="tsupervisorFund.testCost"
									value="%{tsupervisorFund.testCost}"
									onblur="blurText(this,'试验及外协费',1,3);"
									onfocus="focusText(this);" onKeyUp="sumFunds();"
									disabled="%{isLastApply}" maxlength="10" /> <s:hidden
									id="hiddentestCost" name="hidden" value="试验及外协费,1,3"></s:hidden>
							</td>
						</tr>
						<tr>
							<td align="right"><FONT color=red>*</FONT>差旅费</td>
							<td colspan="3"><s:textfield cssClass="inputA"
									cssStyle="width:120px;ime-mode: disabled;"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" id="travelCost"
									name="tsupervisorFund.travelCost"
									value="%{tsupervisorFund.travelCost}"
									onblur="blurText(this,'差旅费',1,3);" onfocus="focusText(this);"
									onKeyUp="sumFunds();" disabled="%{isLastApply}" maxlength="10" />
								<s:hidden id="hiddentravelCost" name="hidden" value="差旅费,1,3"></s:hidden>
							</td>
						</tr>
						<tr>
							<td align="right"><FONT color=red>*</FONT>会议费</td>
							<td colspan="3"><s:textfield cssClass="inputA"
									cssStyle="width:120px;ime-mode: disabled;"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" id="meetingCost"
									name="tsupervisorFund.meetingCost"
									value="%{tsupervisorFund.meetingCost}"
									onblur="blurText(this,'会议费',1,3);" onfocus="focusText(this);"
									onKeyUp="sumFunds();" disabled="%{isLastApply}" maxlength="10" />
								<s:hidden id="hiddenmeetingCost" name="hidden" value="会议费,1,3"></s:hidden>
							</td>
						</tr>
						<tr>
							<td align="right"><FONT color=red>*</FONT>管理费</td>
							<td colspan="3"><s:textfield cssClass="inputA"
									cssStyle="width:120px;ime-mode: disabled;"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" id="managerCost"
									name="tsupervisorFund.managerCost"
									value="%{tsupervisorFund.managerCost}"
									onblur="blurText(this,'管理费',1,3);" onfocus="focusText(this);"
									onKeyUp="sumFunds();" disabled="%{isLastApply}" maxlength="10" />
								<s:hidden id="hiddenmanagerCost" name="hidden" value="管理费,1,3"></s:hidden>
							</td>
						</tr>
						<tr>
							<td align="right"><FONT color=red>*</FONT>其它费用</td>
							<td colspan="3"><s:textfield cssClass="inputA"
									cssStyle="width:120px;ime-mode: disabled;"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" id="otherCost"
									name="tsupervisorFund.otherCost"
									value="%{tsupervisorFund.otherCost}"
									onblur="blurText(this,'其它费用',1,3);" onfocus="focusText(this);"
									onKeyUp="sumFunds();" disabled="%{isLastApply}" maxlength="10" />
								<s:hidden id="hiddenotherCost" name="hidden" value="其它费用,1,3"></s:hidden>
							</td>
						</tr>
						<tr>
							<td align="right">合计</td>
							<td colspan="3"><s:textfield cssClass="inputA"
									cssStyle="width:120px" id="totalCost"
									name="tsupervisorFund.totalCost"
									value="%{getText('format.money',{tsupervisorFund.totalCost})}"
									disabled="true" /></td>
						</tr>
						<tr>
							<td align="right"><s:if test="%{supportFlag==1}">项目及企业情况（1000字以内）</s:if>
								<s:else>项目实施进度情况（1000字以内）</s:else></td>
							<td height="66" colspan="3" align="center"><s:if
									test="%{isLastApply=='false'}">
									<s:textarea id="projectSituation" cssClass="inputA"
										style="width:90%; height:80px;resize:none;"
										value="%{tsupervisorFund.projectSituation}"
										onKeyUp="this.value = upms.upmsUtils.checkTextareaLength(this.value, 1000);"></s:textarea>
								</s:if> <s:else>
									<s:textarea id="projectSituation" cssClass="inputA"
										style="width:90%; height:80px;resize:none;background-color:#F0F0F0"
										readonly="true" value="%{tsupervisorFund.projectSituation}"></s:textarea>
								</s:else>
								<div id="errorMsg1" align="left"></div></td>
						</tr>
					</table>
				</form>
			</div>
			<div align="center" style="width: 95%">
				<s:if test="%{isLastApply=='false'}">
					<input class="button save" id="saveBtn" type="button" value="保存" />
					<input type="button" id="nextBtn" class="button save" value="下一步">
				</s:if>
				<s:else>
					<input type="button" id="nextBtn2" class="button save" value="下一步">
				</s:else>
			</div>
		</div>
	</div>
</div>

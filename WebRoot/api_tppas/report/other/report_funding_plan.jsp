<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/other/js/report_funding_plan.js"></script>
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<s:hidden id="isWriteFlag" name="isWriteFlag" value="%{isWriteFlag}"></s:hidden>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">申请经费(财政研发资金)分年度用款计划</div>
				<div class="abuot03">
					<s:hidden id="fundingPlanReportId" name="tfundingPlanReport.fundingPlanReportId"
						value="%{tfundingPlanReport.fundingPlanReportId}"></s:hidden>
					<!-- 保存按钮提示信息 -->
					<label id="comfirmSave" style="display: none"><s:text
							name="confirm_save_info" /></label>
					<!-- 下一步按钮提示信息 -->
					<label id="comfirmSaveNext" style="display: none"><s:text
							name="confirm_save_and_next_info" /></label>
					<table width="100%" border="0" class="t-entRegFrm" cellspacing="0"
						cellpadding="0">
						<tr>
							<td width="15%" align="center">年度</td>
							<td width="20%" >
								<div align="center">
									<FONT color=red>*</FONT>${year1}年
								</div>
							</td>
							<td width="20%">
								<div align="center">
									<FONT color=red>*</FONT>${year2}年
								</div>
							</td>
							<s:if test="%{yearFlag == 0}">
								<td width="20%">
									<div align="center">${year3}年
									</div>
								</td>
							</s:if>
							<s:else>
								<td width="20%">
									<div align="center"><FONT color=red>*</FONT>${year3}
									</div>
								</td>
							</s:else>
							<td width="20%" align="center">合计</td>
						</tr>
						<tr>
							<td>
								<div align="right">设备费</div>
							</td>
							<td><input type="text" id="equipmentCost3"
								name="tfundingPlanReport.equipmentCost3"
								value="<s:property value='%{tfundingPlanReport.equipmentCost3}' escape='true'/>"
								style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
								onblur="upms.upmsUtils.blurTextCheck(this,'设备费',1,2);"
								onfocus="upms.upmsUtils.textFocus(this)"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
									id="hiddenequipmentCost3" name="hidden" value="设备费,1,2"></s:hidden>
							</td>
							<td><input type="text" id="equipmentCost2"
								name="tfundingPlanReport.equipmentCost2"
								value="<s:property value='%{tfundingPlanReport.equipmentCost2}' escape='true'/>"
								style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
								onblur="upms.upmsUtils.blurTextCheck(this,'设备费',1,2);"
								onfocus="upms.upmsUtils.textFocus(this)"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
									id="hiddenequipmentCost2" name="hidden" value="设备费,1,2"></s:hidden>
							</td>
							<s:if test="%{yearFlag == 0}">
								<td><input type="text" id="equipmentCost1"
									name="tfundingPlanReport.equipmentCost1"
									value="<s:property value='%{tfundingPlanReport.equipmentCost1}' escape='true'/>"
									style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'设备费',0,2);"
									onfocus="upms.upmsUtils.textFocus(this)"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
										id="hiddenequipmentCost1" name="hidden" value="设备费,0,2"></s:hidden>
								</td>
							</s:if>
							<s:else>
								<td><input type="text" id="equipmentCost1"
									name="tfundingPlanReport.equipmentCost1"
									value="<s:property value='%{tfundingPlanReport.equipmentCost1}' escape='true'/>"
									style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'设备费',1,2);"
									onfocus="upms.upmsUtils.textFocus(this)"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
										id="hiddenequipmentCost1" name="hidden" value="设备费,1,2"></s:hidden>
								</td>
							</s:else>
							<td><input type="text" id="TotalequipmentCost"
								name="TotalequipmentCost" style="width: 100px" class="inputA"
								disabled="disabled" /></td>
						</tr>
						<tr>
							<td>
								<div align="right">材料费</div>
							</td>
							<td><input type="text" id="materialFee3"
								name="tfundingPlanReport.materialFee3"
								value="<s:property value='%{tfundingPlanReport.materialFee3}' escape='true'/>"
								style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
								onblur="upms.upmsUtils.blurTextCheck(this,'材料费',1,2);"
								onfocus="upms.upmsUtils.textFocus(this)"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
									id="hiddenmaterialFee3" name="hidden" value="材料费,1,2"></s:hidden>
							</td>
							<td><input type="text" id="materialFee2"
								name="tfundingPlanReport.materialFee2"
								value="<s:property value='%{tfundingPlanReport.materialFee2}' escape='true'/>"
								style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
								onblur="upms.upmsUtils.blurTextCheck(this,'材料费',1,2);"
								onfocus="upms.upmsUtils.textFocus(this)"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
									id="hiddenmaterialFee2" name="hidden" value="材料费,1,2"></s:hidden>
							</td>
							<s:if test="%{yearFlag == 0}">
								<td><input type="text" id="materialFee1"
									name="tfundingPlanReport.materialFee1"
									value="<s:property value='%{tfundingPlanReport.materialFee1}' escape='true'/>"
									style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'材料费',0,2);"
									onfocus="upms.upmsUtils.textFocus(this)"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
										id="hiddenmaterialFee1" name="hidden" value="材料费,0,2"></s:hidden>
								</td>
							</s:if>
							<s:else>
								<td><input type="text" id="materialFee1"
									name="tfundingPlanReport.materialFee1"
									value="<s:property value='%{tfundingPlanReport.materialFee1}' escape='true'/>"
									style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'材料费',1,2);"
									onfocus="upms.upmsUtils.textFocus(this)"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
										id="hiddenmaterialFee1" name="hidden" value="材料费,1,2"></s:hidden>
								</td>
							</s:else>
							<td><input type="text" id="TotalmaterialFee"
								name="TotalmaterialFee" style="width: 100px" class="inputA"
								disabled="disabled" /></td>
						</tr>
						<tr>
							<td>
								<div align="right">测试化验加工费</div>
							</td>
							<td><input type="text" id="testFee3"
								name="tfundingPlanReport.testFee3"
								value="<s:property value='%{tfundingPlanReport.testFee3}' escape='true'/>"
								style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
								onblur="upms.upmsUtils.blurTextCheck(this,'测试化验加工费',1,2);"
								onfocus="upms.upmsUtils.textFocus(this)"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
									id="hiddentestFee3" name="hidden" value="测试化验加工费,1,2"></s:hidden>
							</td>
							<td><input type="text" id="testFee2"
								name="tfundingPlanReport.testFee2"
								value="<s:property value='%{tfundingPlanReport.testFee2}' escape='true'/>"
								style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
								onblur="upms.upmsUtils.blurTextCheck(this,'测试化验加工费',1,2);"
								onfocus="upms.upmsUtils.textFocus(this)"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
									id="hiddentestFee2" name="hidden" value="测试化验加工费,1,2"></s:hidden>
							</td>
							<s:if test="%{yearFlag == 0}">
								<td><input type="text" id="testFee1"
									name="tfundingPlanReport.testFee1"
									value="<s:property value='%{tfundingPlanReport.testFee1}' escape='true'/>"
									style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'测试化验加工费',0,2);"
									onfocus="upms.upmsUtils.textFocus(this)"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
										id="hiddentestFee1" name="hidden" value="测试化验加工费,0,2"></s:hidden>
								</td>
							</s:if>
							<s:else>
								<td><input type="text" id="testFee1"
									name="tfundingPlanReport.testFee1"
									value="<s:property value='%{tfundingPlanReport.testFee1}' escape='true'/>"
									style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'测试化验加工费',1,2);"
									onfocus="upms.upmsUtils.textFocus(this)"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
										id="hiddentestFee1" name="hidden" value="测试化验加工费,1,2"></s:hidden>
								</td>
							</s:else>
							<td><input type="text" id="TotaltestFee"
								name="TotaltestFee" style="width: 100px" class="inputA"
								disabled="disabled" /></td>
						</tr>
						<tr>
							<td>
								<div align="right">燃料动力费</div>
							</td>
							<td><input type="text" id="fuel3" name="tfundingPlanReport.fuel3"
								value="<s:property value='%{tfundingPlanReport.fuel3}' escape='true'/>"
								style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
								onblur="upms.upmsUtils.blurTextCheck(this,'燃料动力费',1,2);"
								onfocus="upms.upmsUtils.textFocus(this)"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
									id="hiddenfuel3" name="hidden" value="燃料动力费,1,2"></s:hidden></td>
							<td><input type="text" id="fuel2" name="tfundingPlanReport.fuel2"
								value="<s:property value='%{tfundingPlanReport.fuel2}' escape='true'/>"
								style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
								onblur="upms.upmsUtils.blurTextCheck(this,'燃料动力费',1,2);"
								onfocus="upms.upmsUtils.textFocus(this)"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
									id="hiddenfuel2" name="hidden" value="燃料动力费,1,2"></s:hidden></td>
							<s:if test="%{yearFlag == 0}">
								<td><input type="text" id="fuel1"
									name="tfundingPlanReport.fuel1"
									value="<s:property value='%{tfundingPlanReport.fuel1}' escape='true'/>"
									style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'燃料动力费',0,2);"
									onfocus="upms.upmsUtils.textFocus(this)"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
										id="hiddenfuel1" name="hidden" value="燃料动力费,0,2"></s:hidden></td>
							</s:if>
							<s:else>
								<td><input type="text" id="fuel1"
									name="tfundingPlanReport.fuel1"
									value="<s:property value='%{tfundingPlanReport.fuel1}' escape='true'/>"
									style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'燃料动力费',1,2);"
									onfocus="upms.upmsUtils.textFocus(this)"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
										id="hiddenfuel1" name="hidden" value="燃料动力费,1,2"></s:hidden></td>
							</s:else>
							<td><input type="text" id="Totalfuel"
								name="Totalfuel" style="width: 100px" class="inputA"
								disabled="disabled" /></td>
						</tr>
						<tr>
							<td>
								<div align="right">差旅调研费</div>
							</td>
							<td><input type="text" id="travel3"
								name="tfundingPlanReport.travel3"
								value="<s:property value='%{tfundingPlanReport.travel3}' escape='true'/>"
								style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
								onblur="upms.upmsUtils.blurTextCheck(this,'差旅调研费',1,2);"
								onfocus="upms.upmsUtils.textFocus(this)"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
									id="hiddentravel3" name="hidden" value="差旅调研费,1,2"></s:hidden>
							</td>
							<td><input type="text" id="travel2"
								name="tfundingPlanReport.travel2"
								value="<s:property value='%{tfundingPlanReport.travel2}' escape='true'/>"
								style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
								onblur="upms.upmsUtils.blurTextCheck(this,'差旅调研费',1,2);"
								onfocus="upms.upmsUtils.textFocus(this)"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
									id="hiddentravel2" name="hidden" value="差旅调研费,1,2"></s:hidden>
							</td>
							<s:if test="%{yearFlag == 0}">
								<td><input type="text" id="travel1"
									name="tfundingPlanReport.travel1"
									value="<s:property value='%{tfundingPlanReport.travel1}' escape='true'/>"
									style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'差旅调研费',0,2);"
									onfocus="upms.upmsUtils.textFocus(this)"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
										id="hiddentravel1" name="hidden" value="差旅调研费,0,2"></s:hidden>
								</td>
							</s:if>
							<s:else>
								<td><input type="text" id="travel1"
									name="tfundingPlanReport.travel1"
									value="<s:property value='%{tfundingPlanReport.travel1}' escape='true'/>"
									style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'差旅调研费',1,2);"
									onfocus="upms.upmsUtils.textFocus(this)"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
										id="hiddentravel1" name="hidden" value="差旅调研费,1,2"></s:hidden>
								</td>
							</s:else>
							<td><input type="text" id="Totaltravel"
								name="Totaltravel" style="width: 100px" class="inputA"
								disabled="disabled" /></td>
						</tr>
						<tr>
							<td>
								<div align="right">会议交流费</div>
							</td>
							<td><input type="text" id="conferenceFees3"
								name="tfundingPlanReport.conferenceFees3"
								value="<s:property value='%{tfundingPlanReport.conferenceFees3}' escape='true'/>"
								style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
								onblur="upms.upmsUtils.blurTextCheck(this,'会议交流费',1,2);"
								onfocus="upms.upmsUtils.textFocus(this)"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
									id="hiddenconferenceFees3" name="hidden" value="会议交流费,1,2"></s:hidden>
							</td>
							<td><input type="text" id="conferenceFees2"
								name="tfundingPlanReport.conferenceFees2"
								value="<s:property value='%{tfundingPlanReport.conferenceFees2}' escape='true'/>"
								style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
								onblur="upms.upmsUtils.blurTextCheck(this,'会议交流费',1,2);"
								onfocus="upms.upmsUtils.textFocus(this)"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
									id="hiddenconferenceFees2" name="hidden" value="会议交流费,1,2"></s:hidden>
							</td>
							<s:if test="%{yearFlag == 0}">
								<td><input type="text" id="conferenceFees1"
									name="tfundingPlanReport.conferenceFees1"
									value="<s:property value='%{tfundingPlanReport.conferenceFees1}' escape='true'/>"
									style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'会议交流费',0,2);"
									onfocus="upms.upmsUtils.textFocus(this)"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
										id="hiddenconferenceFees1" name="hidden" value="会议交流费,0,2"></s:hidden>
								</td>
							</s:if>
							<s:else>
								<td><input type="text" id="conferenceFees1"
									name="tfundingPlanReport.conferenceFees1"
									value="<s:property value='%{tfundingPlanReport.conferenceFees1}' escape='true'/>"
									style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'会议交流费',1,2);"
									onfocus="upms.upmsUtils.textFocus(this)"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
										id="hiddenconferenceFees1" name="hidden" value="会议交流费,1,2"></s:hidden>
								</td>
							</s:else>
							<td><input type="text" id="TotalconferenceFees"
								name="TotalconferenceFees" style="width: 100px" class="inputA"
								disabled="disabled" /></td>
						</tr>
						<tr>
							<td>
								<div align="right">劳务咨询费</div>
							</td>
							<td><input type="text" id="consultancyServices3"
								name="tfundingPlanReport.consultancyServices3"
								value="<s:property value='%{tfundingPlanReport.consultancyServices3}' escape='true'/>"
								style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
								onblur="upms.upmsUtils.blurTextCheck(this,'劳务咨询费',1,2);"
								onfocus="upms.upmsUtils.textFocus(this)"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
									id="hiddenconsultancyServices3" name="hidden" value="劳务咨询费,1,2"></s:hidden>
							</td>
							<td><input type="text" id="consultancyServices2"
								name="tfundingPlanReport.consultancyServices2"
								value="<s:property value='%{tfundingPlanReport.consultancyServices2}' escape='true'/>"
								style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
								onblur="upms.upmsUtils.blurTextCheck(this,'劳务咨询费',1,2);"
								onfocus="upms.upmsUtils.textFocus(this)"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
									id="hiddenconsultancyServices2" name="hidden" value="劳务咨询费,1,2"></s:hidden>
							</td>
							<s:if test="%{yearFlag == 0}">
								<td><input type="text" id="consultancyServices1"
									name="tfundingPlanReport.consultancyServices1"
									value="<s:property value='%{tfundingPlanReport.consultancyServices1}' escape='true'/>"
									style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'劳务咨询费',0,2);"
									onfocus="upms.upmsUtils.textFocus(this)"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
										id="hiddenconsultancyServices1" name="hidden"
										value="劳务咨询费,0,2"></s:hidden></td>
							</s:if>
							<s:else>
								<td><input type="text" id="consultancyServices1"
									name="tfundingPlanReport.consultancyServices1"
									value="<s:property value='%{tfundingPlanReport.consultancyServices1}' escape='true'/>"
									style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'劳务咨询费',1,2);"
									onfocus="upms.upmsUtils.textFocus(this)"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
										id="hiddenconsultancyServices1" name="hidden"
										value="劳务咨询费,1,2"></s:hidden></td>
							</s:else>
							<td><input type="text"
								id="TotalconsultancyServices" name="TotalconsultancyServices"
								style="width: 100px" class="inputA" disabled="disabled" /></td>
						</tr>
						<tr>
							<td>
								<div align="right">其他</div>
							</td>
							<td><input type="text" id="otherFunds3"
								name="tfundingPlanReport.otherFunds3"
								value="<s:property value='%{tfundingPlanReport.otherFunds3}' escape='true'/>"
								style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
								onblur="upms.upmsUtils.blurTextCheck(this,'其他',1,2);"
								onfocus="upms.upmsUtils.textFocus(this)"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
									id="hiddenotherFunds3" name="hidden" value="其他,1,2"></s:hidden>
							</td>
							<td><input type="text" id="otherFunds2"
								name="tfundingPlanReport.otherFunds2"
								value="<s:property value='%{tfundingPlanReport.otherFunds2}' escape='true'/>"
								style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
								onblur="upms.upmsUtils.blurTextCheck(this,'其他',1,2);"
								onfocus="upms.upmsUtils.textFocus(this)"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
									id="hiddenotherFunds2" name="hidden" value="其他,1,2"></s:hidden>
							</td>
							<s:if test="%{yearFlag == 0}">
								<td><input type="text" id="otherFunds1"
									name="tfundingPlanReport.otherFunds1"
									value="<s:property value='%{tfundingPlanReport.otherFunds1}' escape='true'/>"
									style="width: 100px" class="inputA" maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'其他',0,2);"
									onfocus="upms.upmsUtils.textFocus(this)"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
										id="hiddenotherFunds1" name="hidden" value="其他,0,2"></s:hidden>
								</td>
							</s:if>
							<s:else>
								<td><input type="text" id="otherFunds1"
									name="tfundingPlanReport.otherFunds1"
									value="<s:property value='%{tfundingPlanReport.otherFunds1}' escape='true'/>"
									style="width: 100px;ime-mode: disabled;" class="inputA" maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'其他',1,2);"
									onfocus="upms.upmsUtils.textFocus(this)"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
										id="hiddenotherFunds1" name="hidden" value="其他,1,2"></s:hidden>
								</td>
							</s:else>
							<td><input type="text" id="TotalotherFunds"
								name="TotalotherFunds" style="width: 100px" class="inputA"
								disabled="disabled" /></td>
						</tr>
						<tr>
							<td>
								<div align="right">合计</div>
							</td>
							<td>
								<input type="text" id="Total3"
								name="tfundingPlanReport.total3" style="width: 100px" class="inputA"
								disabled="disabled" />
							</td>
							<td>
								<input type="text" id="Total2"
								name="tfundingPlanReport.total2" style="width: 100px" class="inputA"
								disabled="disabled" />
							</td>
							<td>
								<input type="text" id="Total1"
								name="tfundingPlanReport.total1" style="width: 100px" class="inputA"
								disabled="disabled" />
							</td>
							<td>
								<input type="text" id="TotalAll"
								name="TotalAll" style="width: 100px" class="inputA"
								disabled="disabled" />
							</td>
						</tr>
					</table>
					<div align="center">
						<s:if test="%{applyStatus == 1}">
							<input type="button" id="okBtn" class="button add" value="保存">&nbsp;
							<input type="button" id="nextBtn" class="button next" value="下一步">
						</s:if>
						<s:else>
							<input type="button" id="nextBtn1" class="button next" value="下一步">
						</s:else>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

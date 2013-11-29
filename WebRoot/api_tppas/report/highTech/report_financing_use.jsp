<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/highTech/js/report_financing_use.js"></script>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info" /></label>
<!-- 下一步按钮提示信息 -->
<label id="comfirmSaveNext" style="display: none"><s:text name="confirm_save_and_next_info" /></label>
<!-- 删除按钮提示信息 -->
<label id="comfirmDelete" style="display: none"><s:text name="confirm_del_info" /></label>
<!-- 项目ID -->
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<s:hidden id="isWriteFlag" name="isWriteFlag" value="%{isWriteFlag}"></s:hidden>
<s:hidden id="financingUseId" name="tfinancingUse.financingUseId" value="%{tfinancingUse.financingUseId}"></s:hidden>
<s:hidden id="financingUseIdApplicactionId"
	name="tfinancingUse.tprojectApplication.projectId"
	value="%{projectId}"></s:hidden>
<s:hidden id="moneyScheduleId" name="tmoneyScheduleA.moneyScheduleId"
	value="%{tmoneyScheduleA.moneyScheduleId}"></s:hidden>
<s:hidden id="tmoneyScheduleAApplicactionId"
	name="tmoneyScheduleA.tprojectApplication.projectId"
	value="%{projectId}"></s:hidden>

<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">资金主要用途及用款计划</div>
				<div>&nbsp;</div>
				<table style="width: 100%; padding-top: 10px; padding-bottom: 10px;">
					<tr>
						<td>&nbsp;&nbsp;资金来源：总投资:<span style="text-decoration: underline;padding-left:5px;padding-right:5px;"><s:property
									value="%{tcostEstimateB.totalInvestment}" /></span>万元，甲方拨款（申请财政资金）:&nbsp;<span
							style="text-decoration: underline;padding-left:5px;padding-right:5px;"><s:property
									value="%{tcostEstimateB.applicationSpecial}" /></span>万元，银行贷款:&nbsp;<span
							style="text-decoration: underline;padding-left:5px;padding-right:5px;"><s:property
									value="%{tcostEstimateB.totalBankersCredit}" /></span>万元，自筹:&nbsp;<span
							style="text-decoration: underline;padding-left:5px;padding-right:5px;"><s:property
									value="%{tcostEstimateB.selfRaisedFunds}" /></span>万元，配套资金（丙方）:&nbsp;<span
							style="text-decoration: underline;padding-left:5px;padding-right:5px;"><s:property
									value="%{tcostEstimateB.supportFunds}" /></span>万元
						</td>
					</tr>
				</table>
				<div>&nbsp;</div>
				<div align="right" style="width: 95%">（单位：万元）</div>
				<table id="capitalList" class="t-entRegFrm" border=0 cellSpacing=0
					cellPadding=0 width="100%">
					<tr>
						<td width="16%">
							<div align="center">科目</div>
						</td>
						<td width="24%">
							<div align="center">用途摘要说明</div>
						</td>
						<td width="15%">
							<div align="center">专项资金</div>
						</td>
						<td width="15%">
							<div align="center">自筹资金</div>
						</td>
						<td width="15%">
							<div align="center">配套资金</div>
						</td>
						<td width="15%">
							<div align="center">合计</div>
						</td>
					</tr>
					<tr>
						<td>
							<div align="left">1．设备费</div>
						</td>
						<td align="left"></td>
						<td align="left"><input type="text" class="inputA"
							id="equipmentSpecial" name="equipmentSpecial"
							style="width: 8em;"
							value="<s:property value='%{tfinancingUse.equipmentSpecial}' escape='true'/>"
							style="ime-mode: disabled;" readonly="readonly" /></td>
						<td align="left"><input type="text" class="inputA"
							id="equipmentSelf" name="tfinancingUse.equipmentSelf"
							style="width: 8em;"
							value="<s:property value='%{tfinancingUse.equipmentSelf}' escape='true'/>"
							style="ime-mode: disabled;" readonly="readonly" /></td>
						<td align="left"><input type="text" class="inputA"
							id="equipmentSupport" name="tfinancingUse.equipmentSupport"
							style="width: 8em;"
							value="<s:property value='%{tfinancingUse.equipmentSupport}' escape='true'/>"
							style="ime-mode: disabled;" readonly="readonly" /></td>
						<td align="left"><input type="text" class="inputA"
							id="equipmentTotal" name="tfinancingUse.equipmentTotal"
							style="width: 8em;"
							value="<s:property value='%{tfinancingUse.equipmentTotal}' escape='true'/>"
							style="ime-mode: disabled;" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>
							<div style="text-indent:1em;text-align: left"><FONT color=red>*</FONT>（1）购置设备费</div>
						</td>
						<td align="left"><input type="text" class="inputA"
							style="width: 15em;align:left;" id="purchaseComment"
							name="tfinancingUse.purchaseComment"
							value="<s:property value='%{tfinancingUse.purchaseComment}' escape='true'/>"
							onblur="upms.upmsUtils.autoInsertblurTextCheck(this,'购置设备费（用途摘要说明）',1,-1);"
							onfocus="upms.upmsUtils.textFocus(this);" maxlength="100"
							aoutInsert="1"> <s:hidden id="hiddenpurchaseComment"
								name="hidden" value="购置设备费（用途摘要说明）,1,-1"></s:hidden></td>
						<td align="left"><input id="purchaseSpecial"
							name="tfinancingUse.purchaseSpecial" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.purchaseSpecial}' escape='true'/>"
							maxlength="12" autoSum="5"
							onblur="upms.upmsUtils.blurTextCheck(this,'购置设备费（专项资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddenpurchaseSpecial" name="hidden" value="购置设备费（专项资金）,1,2"></s:hidden>
						</td>
						<td align="left"><input id="purchaseSelf"
							name="tfinancingUse.purchaseSelf" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.purchaseSelf}' escape='true'/>"
							maxlength="12" autoSum="1"
							onblur="upms.upmsUtils.blurTextCheck(this,'购置设备费（自筹资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddenpurchaseSelf" name="hidden" value="购置设备费（自筹资金）,1,2"></s:hidden>
						</td>
						<td align="left"><input id="purchaseSupport"
							name="tfinancingUse.purchaseSupport" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.purchaseSupport}' escape='true'/>"
							maxlength="12" autoSum="6"
							onblur="upms.upmsUtils.blurTextCheck(this,'购置设备费（配套资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddenpurchaseSupport" name="hidden" value="购置设备费（配套资金）,1,2"></s:hidden>
						</td>
						<td align="left"><input type="text" class="inputA"
							id="purchaseTotal" name="tfinancingUse.purchaseTotal"
							style="width: 8em;"
							value="<s:property value='%{tfinancingUse.purchaseTotal}' escape='true'/>"
							style="ime-mode: disabled;" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>
							<div style="text-indent:1em;text-align: left"><FONT color=red>*</FONT>（2）试制设备费</div>
						</td>
						<td align="left"><input type="text" class="inputA"
							align="left" style="width: 15em;" id="trialComment"
							name="tfinancingUse.trialComment"
							value="<s:property value='%{tfinancingUse.trialComment}' escape='true'/>"
							onblur="upms.upmsUtils.autoInsertblurTextCheck(this,'试制设备费（用途摘要说明）',1,-1);"
							onfocus="upms.upmsUtils.textFocus(this);" maxlength="100"
							aoutInsert="1"> <s:hidden id="hiddentrialComment"
								name="hidden" value="试制设备费（用途摘要说明）,1,-1"></s:hidden></td>
						<td align="left"><input id="trialSpecial"
							name="tfinancingUse.trialSpecial" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.trialSpecial}' escape='true'/>"
							maxlength="12" autoSum="5"
							onblur="upms.upmsUtils.blurTextCheck(this,'试制设备费（专项资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddentrialSpecial" name="hidden" value="试制设备费（专项资金）,1,2"></s:hidden>
						</td>
						<td align="left"><input id="trialSelf"
							name="tfinancingUse.trialSelf" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.trialSelf}' escape='true'/>"
							maxlength="12" autoSum="1"
							onblur="upms.upmsUtils.blurTextCheck(this,'试制设备费（自筹资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddentrialSelf" name="hidden" value="试制设备费（自筹资金）,1,2"></s:hidden>
						</td>
						<td align="left"><input id="trialSupport"
							name="tfinancingUse.trialSupport" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.trialSupport}' escape='true'/>"
							maxlength="12" autoSum="6"
							onblur="upms.upmsUtils.blurTextCheck(this,'试制设备费（配套资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddentrialSupport" name="hidden" value="试制设备费（配套资金）,1,2"></s:hidden>
						</td>
						<td align="left"><input type="text" class="inputA"
							id="trialTotal" name="tfinancingUse.trialTotal"
							style="width: 8em;"
							value="<s:property value='%{tfinancingUse.trialTotal}' escape='true'/>"
							style="ime-mode: disabled;" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>
							<div style="text-indent:1em;text-align: left"><FONT color=red>*</FONT>（3）设备改造与租赁费</div>
						</td>
						<td align="left"><input type="text" class="inputA"
							align="left" style="width: 15em;" id="renovationComment"
							name="tfinancingUse.renovationComment"
							value="<s:property value='%{tfinancingUse.renovationComment}' escape='true'/>"
							onblur="upms.upmsUtils.autoInsertblurTextCheck(this,'设备改造与租赁费（用途摘要说明）',1,-1);"
							onfocus="upms.upmsUtils.textFocus(this);" maxlength="100"
							aoutInsert="1"> <s:hidden id="hiddenrenovationComment"
								name="hidden" value="设备改造与租赁费（用途摘要说明）,1,-1"></s:hidden></td>
						<td align="left"><input id="renovationSpecial"
							name="tfinancingUse.renovationSpecial" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.renovationSpecial}' escape='true'/>"
							maxlength="12" autoSum="5"
							onblur="upms.upmsUtils.blurTextCheck(this,'设备改造与租赁费（专项资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddenrenovationSpecial" name="hidden"
								value="设备改造与租赁费（专项资金）,1,2"></s:hidden></td>
						<td align="left"><input id="renovationSelf"
							name="tfinancingUse.renovationSelf" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.renovationSelf}' escape='true'/>"
							maxlength="12" autoSum="1"
							onblur="upms.upmsUtils.blurTextCheck(this,'设备改造与租赁费（自筹资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddenrenovationSelf" name="hidden"
								value="设备改造与租赁费（自筹资金）,1,2"></s:hidden></td>
						<td align="left"><input id="renovationSupport"
							name="tfinancingUse.renovationSupport" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.renovationSupport}' escape='true'/>"
							maxlength="12" autoSum="6"
							onblur="upms.upmsUtils.blurTextCheck(this,'设备改造与租赁费（配套资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddenrenovationSupport" name="hidden"
								value="设备改造与租赁费（配套资金）,1,2"></s:hidden></td>
						<td align="left"><input type="text" class="inputA"
							id="renovationTotal" name="tfinancingUse.renovationTotal"
							style="width: 8em;"
							value="<s:property value='%{tfinancingUse.renovationTotal}' escape='true'/>"
							style="ime-mode: disabled;" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>
							<div align="left"><FONT color=red>*</FONT>2．材料费</div>
						</td>
						<td align="left"><input type="text" class="inputA"
							align="left" style="width: 15em;" id="materialComment"
							name="tfinancingUse.materialComment"
							value="<s:property value='%{tfinancingUse.materialComment}' escape='true'/>"
							onblur="upms.upmsUtils.autoInsertblurTextCheck(this,'材料费（用途摘要说明）',1,-1);"
							onfocus="upms.upmsUtils.textFocus(this);" maxlength="100"
							aoutInsert="1"> <s:hidden id="hiddenmaterialComment"
								name="hidden" value="材料费（用途摘要说明）,1,-1"></s:hidden></td>
						<td align="left"><input id="materialSpecial"
							name="tfinancingUse.materialSpecial" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.materialSpecial}' escape='true'/>"
							maxlength="12" autoSum="5"
							onblur="upms.upmsUtils.blurTextCheck(this,'材料费（专项资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddenmaterialSpecial" name="hidden" value="材料费（专项资金）,1,2"></s:hidden>
						</td>
						<td align="left"><input id="materialSelf"
							name="tfinancingUse.materialSelf" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.materialSelf}' escape='true'/>"
							maxlength="12" autoSum="1"
							onblur="upms.upmsUtils.blurTextCheck(this,'材料费（自筹资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddenmaterialSelf" name="hidden" value="材料费（自筹资金）,1,2"></s:hidden>
						</td>
						<td align="left"><input id="materialSupport"
							name="tfinancingUse.materialSupport" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.materialSupport}' escape='true'/>"
							maxlength="12" autoSum="6"
							onblur="upms.upmsUtils.blurTextCheck(this,'材料费（配套资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddenmaterialSupport" name="hidden" value="材料费（配套资金）,1,2"></s:hidden>
						</td>
						<td align="left"><input type="text" class="inputA"
							id="materialTotal" name="tfinancingUse.materialTotal"
							style="width: 8em;"
							value="<s:property value='%{tfinancingUse.materialTotal}' escape='true'/>"
							style="ime-mode: disabled;" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>
							<div align="left"><FONT color=red>*</FONT>3．测试化验加工费</div>
						</td>
						<td align="left"><input type="text" class="inputA"
							align="left" style="width: 15em;" id="testComment"
							name="tfinancingUse.testComment"
							value="<s:property value='%{tfinancingUse.testComment}' escape='true'/>"
							onblur="upms.upmsUtils.autoInsertblurTextCheck(this,'测试化验加工费（用途摘要说明）',1,-1);"
							onfocus="upms.upmsUtils.textFocus(this);" maxlength="100"
							aoutInsert="1"> <s:hidden id="hiddentestComment"
								name="hidden" value="测试化验加工费（用途摘要说明）,1,-1"></s:hidden></td>
						<td align="left"><input id="testSpecial"
							name="tfinancingUse.testSpecial" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.testSpecial}' escape='true'/>"
							maxlength="12" autoSum="5"
							onblur="upms.upmsUtils.blurTextCheck(this,'测试化验加工费（专项资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddentestSpecial" name="hidden" value="测试化验加工费（专项资金）,1,2"></s:hidden>
						</td>
						<td align="left"><input id="testSelf"
							name="tfinancingUse.testSelf" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.testSelf}' escape='true'/>"
							maxlength="12" autoSum="1"
							onblur="upms.upmsUtils.blurTextCheck(this,'测试化验加工费（自筹资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddentestSelf" name="hidden" value="测试化验加工费（自筹资金）,1,2"></s:hidden>
						</td>
						<td align="left"><input id="testSupport"
							name="tfinancingUse.testSupport" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.testSupport}' escape='true'/>"
							maxlength="12" autoSum="6"
							onblur="upms.upmsUtils.blurTextCheck(this,'测试化验加工费（配套资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddentestSupport" name="hidden" value="测试化验加工费（配套资金）,1,2"></s:hidden>
						</td>
						<td align="left"><input type="text" class="inputA"
							id="testTotal" name="tfinancingUse.testTotal"
							style="width: 8em;"
							value="<s:property value='%{tfinancingUse.testTotal}' escape='true'/>"
							style="ime-mode: disabled;" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>
							<div align="left"><FONT color=red>*</FONT>4．会议费</div>
						</td>
						<td align="left"><input type="text" class="inputA"
							align="left" style="width: 15em;" id="meetComment"
							name="tfinancingUse.meetComment"
							value="<s:property value='%{tfinancingUse.meetComment}' escape='true'/>"
							onblur="upms.upmsUtils.autoInsertblurTextCheck(this,'会议费（用途摘要说明）',1,-1);"
							onfocus="upms.upmsUtils.textFocus(this);" maxlength="100"
							aoutInsert="1"> <s:hidden id="hiddenmeetComment"
								name="hidden" value="会议费（用途摘要说明）,1,-1"></s:hidden></td>
						<td align="left"><input id="meetSpecial"
							name="tfinancingUse.meetSpecial" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.meetSpecial}' escape='true'/>"
							maxlength="12" autoSum="5"
							onblur="upms.upmsUtils.blurTextCheck(this,'会议费（专项资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddenmeetSpecial" name="hidden" value="会议费（专项资金）,1,2"></s:hidden>
						</td>
						<td align="left"><input id="meetSelf"
							name="tfinancingUse.meetSelf" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.meetSelf}' escape='true'/>"
							maxlength="12" autoSum="1"
							onblur="upms.upmsUtils.blurTextCheck(this,'会议费（自筹资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddenmeetSelf" name="hidden" value="会议费（自筹资金）,1,2"></s:hidden>
						</td>
						<td align="left"><input id="meetSupport"
							name="tfinancingUse.meetSupport" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.meetSupport}' escape='true'/>"
							maxlength="12" autoSum="6"
							onblur="upms.upmsUtils.blurTextCheck(this,'会议费（配套资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddenmeetSupport" name="hidden" value="会议费（配套资金）,1,2"></s:hidden>
						</td>
						<td align="left"><input type="text" class="inputA"
							id="meetTotal" name="tfinancingUse.meetTotal"
							style="width: 8em;"
							value="<s:property value='%{tfinancingUse.meetTotal}' escape='true'/>"
							style="ime-mode: disabled;" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>
							<div align="left"><FONT color=red>*</FONT>5．国际合作与交流费</div>
						</td>
						<td align="left"><input type="text" class="inputA"
							align="left" style="width: 15em;" id="cooperationComment"
							name="tfinancingUse.cooperationComment"
							value="<s:property value='%{tfinancingUse.cooperationComment}' escape='true'/>"
							onblur="upms.upmsUtils.autoInsertblurTextCheck(this,'国际合作与交流费（用途摘要说明）',1,-1);"
							onfocus="upms.upmsUtils.textFocus(this);" maxlength="100"
							aoutInsert="1"> <s:hidden id="hiddencooperationComment"
								name="hidden" value="国际合作与交流费（用途摘要说明）,1,-1"></s:hidden></td>
						<td align="left"><input id="cooperationSpecial"
							name="tfinancingUse.cooperationSpecial" type="text"
							class="inputA" style="width: 8em; ime-mode: disabled;"
							moneyFlag="money"
							value="<s:property value='%{tfinancingUse.cooperationSpecial}' escape='true'/>"
							maxlength="12" autoSum="5"
							onblur="upms.upmsUtils.blurTextCheck(this,'国际合作与交流费（专项资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddencooperationSpecial" name="hidden"
								value="国际合作与交流费（专项资金）,1,2"></s:hidden></td>
						<td align="left"><input id="cooperationSelf"
							name="tfinancingUse.cooperationSelf" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.cooperationSelf}' escape='true'/>"
							maxlength="12" autoSum="1"
							onblur="upms.upmsUtils.blurTextCheck(this,'国际合作与交流费（自筹资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddencooperationSelf" name="hidden"
								value="国际合作与交流费（自筹资金）,1,2"></s:hidden></td>
						<td align="left"><input id="cooperationSupport"
							name="tfinancingUse.cooperationSupport" type="text"
							class="inputA" style="width: 8em; ime-mode: disabled;"
							moneyFlag="money"
							value="<s:property value='%{tfinancingUse.cooperationSupport}' escape='true'/>"
							maxlength="12" autoSum="6"
							onblur="upms.upmsUtils.blurTextCheck(this,'国际合作与交流费（配套资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddencooperationSupport" name="hidden"
								value="国际合作与交流费（配套资金）,1,2"></s:hidden></td>
						<td align="left"><input type="text" class="inputA"
							id="cooperationTotal" name="tfinancingUse.cooperationTotal"
							style="width: 8em;"
							value="<s:property value='%{tfinancingUse.cooperationTotal}' escape='true'/>"
							style="ime-mode: disabled;" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>
							<div align="left"><FONT color=red>*</FONT>6．出版/文献/信息传播/知识产权事务费</div>
						</td>
						<td align="left"><input type="text" class="inputA"
							align="left" style="width: 15em;" id="publishComment"
							name="tfinancingUse.publishComment"
							value="<s:property value='%{tfinancingUse.publishComment}' escape='true'/>"
							onblur="upms.upmsUtils.autoInsertblurTextCheck(this,'出版/文献/信息传播/知识产权事务费（用途摘要说明）',1,-1);"
							onfocus="upms.upmsUtils.textFocus(this);" maxlength="100"
							aoutInsert="1"> <s:hidden id="hiddenpublishComment"
								name="hidden" value="出版/文献/信息传播/知识产权事务费（用途摘要说明）,1,-1"></s:hidden>
						</td>
						<td align="left"><input id="publishSpecial"
							name="tfinancingUse.publishSpecial" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.publishSpecial}' escape='true'/>"
							maxlength="12" autoSum="5"
							onblur="upms.upmsUtils.blurTextCheck(this,'出版/文献/信息传播/知识产权事务费（专项资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddenpublishSpecial" name="hidden"
								value="出版/文献/信息传播/知识产权事务费（专项资金）,1,2"></s:hidden></td>
						<td align="left"><input id="publishSelf"
							name="tfinancingUse.publishSelf" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.publishSelf}' escape='true'/>"
							maxlength="12" autoSum="1"
							onblur="upms.upmsUtils.blurTextCheck(this,'出版/文献/信息传播/知识产权事务费（自筹资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddenpublishSelf" name="hidden"
								value="出版/文献/信息传播/知识产权事务费（自筹资金）,1,2"></s:hidden></td>
						<td align="left"><input id="publishSupport"
							name="tfinancingUse.publishSupport" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.publishSupport}' escape='true'/>"
							maxlength="12" autoSum="6"
							onblur="upms.upmsUtils.blurTextCheck(this,'出版/文献/信息传播/知识产权事务费（配套资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddenpublishSupport" name="hidden"
								value="出版/文献/信息传播/知识产权事务费（配套资金）,1,2"></s:hidden></td>
						<td align="left"><input type="text" class="inputA"
							id="publishTotal" name="tfinancingUse.publishTotal"
							style="width: 8em;"
							value="<s:property value='%{tfinancingUse.publishTotal}' escape='true'/>"
							style="ime-mode: disabled;" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>
							<div align="left"><FONT color=red>*</FONT>7．专家咨询费</div>
						</td>
						<td align="left"><input type="text" class="inputA"
							align="left" style="width: 15em;" id="expertComment"
							name="tfinancingUse.expertComment"
							value="<s:property value='%{tfinancingUse.expertComment}' escape='true'/>"
							onblur="upms.upmsUtils.autoInsertblurTextCheck(this,'专家咨询费（用途摘要说明）',1,-1);"
							onfocus="upms.upmsUtils.textFocus(this);" maxlength="100"
							aoutInsert="1"> <s:hidden id="hiddenexpertComment"
								name="hidden" value="专家咨询费（用途摘要说明）,1,-1"></s:hidden></td>
						<td align="left"><input id="expertSpecial"
							name="tfinancingUse.expertSpecial" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.expertSpecial}' escape='true'/>"
							maxlength="12" autoSum="5"
							onblur="upms.upmsUtils.blurTextCheck(this,'专家咨询费（专项资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddenexpertSpecial" name="hidden" value="专家咨询费（专项资金）,1,2"></s:hidden>
						</td>
						<td align="left"><input id="expertSelf"
							name="tfinancingUse.expertSelf" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.expertSelf}' escape='true'/>"
							maxlength="12" autoSum="1"
							onblur="upms.upmsUtils.blurTextCheck(this,'专家咨询费（自筹资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddenexpertSelf" name="hidden" value="专家咨询费（自筹资金）,1,2"></s:hidden>
						</td>
						<td align="left"><input id="expertSupport"
							name="tfinancingUse.expertSupport" type="text" class="inputA"
							style="width: 8em; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tfinancingUse.expertSupport}' escape='true'/>"
							maxlength="12" autoSum="6"
							onblur="upms.upmsUtils.blurTextCheck(this,'专家咨询费（配套资金）',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)" /> <s:hidden
								id="hiddenexpertSupport" name="hidden" value="专家咨询费（配套资金）,1,2"></s:hidden>
						</td>
						<td align="left"><input type="text" class="inputA"
							id="expertTotal" name="tfinancingUse.expertTotal"
							style="width: 8em;"
							value="<s:property value='%{tfinancingUse.expertTotal}' escape='true'/>"
							style="ime-mode: disabled;" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>
							<div align="center">合计</div>
						</td>
						<td align="left"></td>
						<td align="left"><input type="text" class="inputA"
							id="specialTotal" name="tfinancingUse.specialTotal" style="width: 8em;"
							style="ime-mode: disabled;" readonly="readonly" /></td>
						<td align="left"><input type="text" class="inputA"
							id="selfTotal" name="tfinancingUse.selfTotal" style="width: 8em;"
							style="ime-mode: disabled;" readonly="readonly" /></td>
						<td align="left"><input type="text" class="inputA"
							id="supportTotal" name="tfinancingUse.supportTotal" style="width: 8em;"
							style="ime-mode: disabled;" readonly="readonly" /></td>
						<td align="left"><input type="text" class="inputA"
							id="total" name="tfinancingUse.total" style="width: 8em;"
							style="ime-mode: disabled;" readonly="readonly" /></td>
					</tr>
				</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="t-entRegFrm">
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
								 value="<s:property value='%{year}' escape='true'/>"/>年 --%> <s:property
										value='%{year}' escape='true' />年
								</td>
								<s:hidden id="hiddenyear%{#rowData.count}" name="hidden"
									value="年度,1,10"></s:hidden>
							</s:iterator>
						</s:if>
						<td>合计</td>
					</tr>
					<tr>
						<td align="right"><FONT color=red>*</FONT>用款金额</td>
						<td><input id="paymentAmount"
							name="tmoneyScheduleA.paymentAmount" type="text" class="inputA"
							style="width: 150px; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tmoneyScheduleA.paymentAmount}' escape='true'/>"
							maxlength="12"
							onblur="upms.upmsUtils.blurTextCheck(this,'用款金额',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
							autoSum="2" /> <s:hidden id="hiddenpaymentAmount"
								name="hidden" value="用款金额,1,2"></s:hidden></td>
						<td><input id="paymentAmounta"
							name="tmoneyScheduleA.paymentAmount1" type="text" class="inputA"
							style="width: 150px; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tmoneyScheduleA.paymentAmount1}' escape='true'/>"
							maxlength="12"
							onblur="upms.upmsUtils.blurTextCheck(this,'用款金额',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
							autoSum="2" /> <s:hidden id="hiddenpaymentAmounta"
								name="hidden" value="用款金额,1,2"></s:hidden></td>
						<td><s:if test="%{year3Flag == 0}">
								<input id="paymentAmountb" name="tmoneyScheduleA.paymentAmount2"
									type="text" class="inputA"
									style="width: 150px; ime-mode: disabled;" moneyFlag="money"
									value="<s:property value='%{tmoneyScheduleA.paymentAmount2}' escape='true'/>"
									maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'用款金额',1,2);"
									onfocus="upms.upmsUtils.textFocus(this);"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
									autoSum="2" />
								<s:hidden id="hiddenpaymentAmountb" name="hidden"
									value="用款金额,1,2"></s:hidden>
							</s:if> <s:else>
								<input id="paymentAmountb" name="tmoneyScheduleA.paymentAmount2"
									type="text" class="inputA"
									style="width: 150px; ime-mode: disabled;" moneyFlag="money"
									value="<s:property value='%{tmoneyScheduleA.paymentAmount2}' escape='true'/>"
									maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'用款金额',0,2);"
									onfocus="upms.upmsUtils.textFocus(this);"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
									autoSum="2" />
								<s:hidden id="hiddenpaymentAmountb" name="hidden"
									value="用款金额,0,2"></s:hidden>
							</s:else></td>
						<td><input id="paymentAmountTotal"
							name="tmoneyScheduleA.paymentAmountTotal" type="text"
							class="inputA" style="width: 150px; ime-mode: disabled;"
							readonly="readonly"
							value="<s:property value='%{tmoneyScheduleA.paymentAmountTotal}' escape='true'/>" />
						</td>
					</tr>
					<tr>
						<td align="right"><FONT color=red>*</FONT>其中：专项经费</td>
						<td><input id="specialAmount"
							name="tmoneyScheduleA.specialAmount" type="text" class="inputA"
							style="width: 150px; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tmoneyScheduleA.specialAmount}' escape='true'/>"
							maxlength="12"
							onblur="upms.upmsUtils.blurTextCheck(this,'专项经费',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
							autoSum="3" /> <s:hidden id="hiddenspecialAmount"
								name="hidden" value="专项经费,1,2"></s:hidden></td>
						<td><input id="specialAmount1"
							name="tmoneyScheduleA.specialAmount1" type="text" class="inputA"
							style="width: 150px; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tmoneyScheduleA.specialAmount1}' escape='true'/>"
							maxlength="12"
							onblur="upms.upmsUtils.blurTextCheck(this,'专项经费',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
							autoSum="3" /> <s:hidden id="hiddenspecialAmount1"
								name="hidden" value="专项经费,1,2"></s:hidden></td>
						<td><s:if test="%{year3Flag == 0}">
								<input id="specialAmount2" name="tmoneyScheduleA.specialAmount2"
									type="text" class="inputA"
									style="width: 150px; ime-mode: disabled;" moneyFlag="money"
									value="<s:property value='%{tmoneyScheduleA.specialAmount2}' escape='true'/>"
									maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'专项经费',1,2);"
									onfocus="upms.upmsUtils.textFocus(this);"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
									autoSum="3" />
								<s:hidden id="hiddenspecialAmount2" name="hidden"
									value="专项经费,1,2"></s:hidden>
							</s:if> <s:else>
								<input id="specialAmount2" name="tmoneyScheduleA.specialAmount2"
									type="text" class="inputA"
									style="width: 150px; ime-mode: disabled;" moneyFlag="money"
									value="<s:property value='%{tmoneyScheduleA.specialAmount2}' escape='true'/>"
									maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'专项经费',0,2);"
									onfocus="upms.upmsUtils.textFocus(this);"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
									autoSum="3" />
								<s:hidden id="hiddenspecialAmount2" name="hidden"
									value="专项经费,0,2"></s:hidden>
							</s:else></td>
						<td><input id="specialAmountTotal"
							name="tmoneyScheduleA.specialAmountTotal" type="text"
							class="inputA" style="width: 150px"
							value="<s:property value='%{tmoneyScheduleA.specialAmountTotal}' escape='true'/>"
							readonly="readonly" /></td>
					</tr>
					<tr>
						<td align="right"><FONT color=red>*</FONT>自筹及其他资金</td>
						<td><input id="otherFunds" name="tmoneyScheduleA.otherFunds"
							type="text" class="inputA"
							style="width: 150px; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tmoneyScheduleA.otherFunds}' escape='true'/>"
							maxlength="12"
							onblur="upms.upmsUtils.blurTextCheck(this,'自筹及其他资金',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
							autoSum="4" /> <s:hidden id="hiddenotherFunds"
								name="hidden" value="自筹及其他资金,1,2"></s:hidden></td>
						<td><input id="otherFunds1"
							name="tmoneyScheduleA.otherFunds1" type="text" class="inputA"
							style="width: 150px; ime-mode: disabled;" moneyFlag="money"
							value="<s:property value='%{tmoneyScheduleA.otherFunds1}' escape='true'/>"
							maxlength="12"
							onblur="upms.upmsUtils.blurTextCheck(this,'自筹及其他资金',1,2);"
							onfocus="upms.upmsUtils.textFocus(this);"
							onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
							autoSum="4" /> <s:hidden id="hiddenotherFunds1"
								name="hidden" value="自筹及其他资金,1,2"></s:hidden></td>
						<td><s:if test="%{year3Flag == 0}">
								<input id="otherFunds2" name="tmoneyScheduleA.otherFunds2"
									type="text" class="inputA"
									style="width: 150px; ime-mode: disabled;" moneyFlag="money"
									value="<s:property value='%{tmoneyScheduleA.otherFunds2}' escape='true'/>"
									maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'自筹及其他资金',1,2);"
									onfocus="upms.upmsUtils.textFocus(this);"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
									autoSum="4" />
								<s:hidden id="hiddenotherFunds2" name="hidden"
									value="自筹及其他资金,1,2"></s:hidden>
							</s:if> <s:else>
								<input id="otherFunds2" name="tmoneyScheduleA.otherFunds2"
									type="text" class="inputA"
									style="width: 150px; ime-mode: disabled;" moneyFlag="money"
									value="<s:property value='%{tmoneyScheduleA.otherFunds2}' escape='true'/>"
									maxlength="12"
									onblur="upms.upmsUtils.blurTextCheck(this,'自筹及其他资金',0,2);"
									onfocus="upms.upmsUtils.textFocus(this);"
									onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
									autoSum="4" />
								<s:hidden id="hiddenotherFunds2" name="hidden"
									value="自筹及其他资金,0,2"></s:hidden>
							</s:else></td>
						<td><input id="otherFundsTotal"
							name="tmoneyScheduleA.otherFundsTotal" type="text" class="inputA"
							style="width: 150px"
							value="<s:property value='%{tmoneyScheduleA.otherFundsTotal}' escape='true'/>"
							readonly="readonly" /></td>
					</tr>
					<!--<tr>
					<td colspan='5'>
						<FONT color=red>*</FONT>
						用款金额指的是总经费
						&nbsp;&nbsp;&nbsp;
						<FONT color=red>*</FONT>
						专项经费指的是拟申请的经费
					</td>
				</tr> -->
				</table>
				<div align="center" style="width: 95%">
					<s:if test="%{applyStatus == 1}">
						<input id="okBtn" class="button save" type="button" name="button"
							href="javascript: void(0);" value="保存">
						<input id="nextBtn" class="button save" name="button"
							type="button"  value="下一步" />
					</s:if>
					<s:else>
						<input id="nextBtn1" class="button save" name="button"
							type="button"  value="下一步" />
					</s:else>
				</div>
			</div>
		</div>
	</div>
</div>
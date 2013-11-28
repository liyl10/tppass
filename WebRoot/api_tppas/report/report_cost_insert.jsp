<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/js/report_cost_insert.js"></script>

<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
<div class="Servicel04">
<s:hidden id="costEstimateId" name="tcostEstimateB.costEstimateId" value="%{tcostEstimateB.costEstimateId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<s:hidden id="tempFlg" name="tempFlg" value="%{tempFlg}"></s:hidden>
<div class="abuot02">
<div class="abuot07">经费概算及投入进度</div>
<div align="right" style="width:95%">
 （单位：万元）
</div>	
<s:hidden id="costEstimateId" name="tcostEstimateB.costEstimateId" value="%{tcostEstimateB.costEstimateId}"></s:hidden>
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<div class=requirecolor id="errInfo"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm">
<tr>
		<td width="20%" style="padding: 4px 3px; text-align: right">
			<FONT color=red>*</FONT>总投入
		</td>
		<td width="30%" style="padding: 4px 3px; text-align: left">
			<input id="totalInvestment" name="tcostEstimateB.totalInvestment" 
			value="<s:property value='%{tcostEstimateB.totalInvestment}' escape='true'/>"
			type="text" style="width: 17em; height:1.6em;ime-mode: disabled;" class="inputA" 
			onblur="upms.upmsUtils.blurTextCheck(this,'总投入',0,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="13"
			onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
		</td><s:hidden id="hiddentotalInvestment" name="hidden" value="总投入,0,2"></s:hidden>
		<td width="25%" style="padding: 4px 3px; text-align: right">
			<FONT color=red>*</FONT>其中：1、申请专项经费
		</td>
		<td width="25%" style="padding: 4px 3px; text-align: left" colspan="2">
			<input id="applicationSpecial" name="tcostEstimateB.applicationSpecial" 
			value="<s:property value='%{tcostEstimateB.applicationSpecial}' escape='true'/>"
			type="text" style="width: 17em; height:1.6em;ime-mode: disabled;" class="inputA"
			onblur="upms.upmsUtils.blurTextCheck(this,'申请专项经费',0,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="13"
			onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
		</td><s:hidden id="hiddenapplicationSpecial" name="hidden" value="申请专项经费,0,2"></s:hidden>
</tr>
<tr>
		<td></td>
		<td></td>
		<td width="25%" style="padding: 4px 3px; text-align: right">
			<FONT color=red>*</FONT>2、自筹资金金额
		</td>
		<td width="25%" style="padding: 4px 3px; text-align: left" colspan="2">
			<input id="selfRaisedFunds" name="tcostEstimateB.selfRaisedFunds" 
			value="<s:property value='%{tcostEstimateB.selfRaisedFunds}' escape='true'/>"
			type="text" style="width: 17em; height:1.6em;ime-mode: disabled;" class="inputA"
			onblur="upms.upmsUtils.blurTextCheck(this,'自筹资金金额',0,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="10"
			onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
		</td><s:hidden id="hiddenselfRaisedFunds" name="hidden" value="自筹资金金额,0,2"></s:hidden>
</tr>
<tr>
		<td></td>
		<td></td>
		<td width="25%" style="padding: 4px 3px; text-align: right">
			<FONT color=red>*</FONT>3、银行贷款总额
		</td>
		<td width="25%" style="padding: 4px 3px; text-align: left" colspan="2">
			<input id="totalBankersCredit" name="tcostEstimateB.totalBankersCredit" 
			value="<s:property value='%{tcostEstimateB.totalBankersCredit}' escape='true'/>"
			type="text" style="width: 17em; height:1.6em;ime-mode: disabled;" class="inputA"
			onblur="upms.upmsUtils.blurTextCheck(this,'银行贷款总额',0,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="10"
			onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
		</td><s:hidden id="hiddentotalBankersCredit" name="hidden" value="银行贷款总额,0,2"></s:hidden>
</tr>
<tr>
		<td></td>
		<td></td>
		<td width="30%" style="padding: 4px 3px; text-align: right">
			<FONT color=red>*</FONT>已落实银行贷款
		</td>
		<td width="30%" style="padding: 4px 3px; text-align: left" colspan="2">
			<input id="bankersCredit" name="tcostEstimateB.bankersCredit" 
			value="<s:property value='%{tcostEstimateB.bankersCredit}' escape='true'/>"
			type="text" style="width: 17em; height:1.6em;ime-mode: disabled;" class="inputA"
			onblur="upms.upmsUtils.blurTextCheck(this,'已落实银行贷款',0,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
			onkeypress="return upms.upmsUtils.isFloatNum(event,this)" readonly="readonly" readFlag="1"/>
		</td><s:hidden id="hiddenbankersCredit" name="hidden" value="已落实银行贷款,0,2"></s:hidden>
</tr>
<!-- 产业处 -->
<s:if test="%{tempFlg == 1}">
<tr>
	<td></td>
	<td></td>
	<td width="30%" style="padding: 4px 3px; text-align: right">
		<FONT color=red>*</FONT>4、配套资金金额
	</td>
	<td width="30%" style="padding: 4px 3px; text-align: left" colspan="2">
		<input id="supportFunds" name="tcostEstimateB.supportFunds" 
		value="<s:property value='%{tcostEstimateB.supportFunds}' escape='true'/>"
		type="text" style="width: 17em; height:1.6em;ime-mode: disabled;" class="inputA"
		onblur="upms.upmsUtils.blurTextCheck(this,'配套资金金额',0,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
		onkeypress="return upms.upmsUtils.isFloatNum(event,this)" readonly="readonly" readFlag="1" autoSum="1"/>
	</td><s:hidden id="hiddensupportFunds" name="hidden" value="配套资金金额,0,2"></s:hidden>
</tr>
<tr>
	<td></td>
	<td></td>
	<td width="30%" style="padding: 4px 3px; text-align: right">
		<FONT color=red>*</FONT>5、其他资金金额
	</td>
	<td width="30%" style="padding: 4px 3px; text-align: left" colspan="2">
		<input id="otherFunds" name="tcostEstimateB.otherFunds" 
		value="<s:property value='%{tcostEstimateB.otherFunds}' escape='true'/>"
		type="text" style="width: 17em; height:1.6em;ime-mode: disabled;" class="inputA"
		onblur="upms.upmsUtils.blurTextCheck(this,'其他资金金额',0,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
		onkeypress="return upms.upmsUtils.isFloatNum(event,this)" readonly="readonly" readFlag="1" autoSum="1"/>
	</td><s:hidden id="hiddenotherFunds" name="hidden" value="其他资金金额,0,2"></s:hidden>
</tr>
</s:if>
<!-- 非产业处 -->
<s:else>
<tr>
	<td></td>
	<td></td>
	<td width="30%" style="padding: 4px 3px; text-align: right">
		<FONT color=red>*</FONT>4、其他资金金额
	</td>
	<td width="30%" style="padding: 4px 3px; text-align: left" colspan="2">
		<input id="otherFunds" name="tcostEstimateB.otherFunds" 
		value="<s:property value='%{tcostEstimateB.otherFunds}' escape='true'/>"
		type="text" style="width: 17em; height:1.6em;ime-mode: disabled;" class="inputA"
		onblur="upms.upmsUtils.blurTextCheck(this,'其他资金金额',0,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
		onkeypress="return upms.upmsUtils.isFloatNum(event,this)" readonly="readonly" readFlag="1" autoSum="1"/>
	</td><s:hidden id="hiddenotherFunds" name="hidden" value="其他资金金额,0,2"></s:hidden>
</tr>
</s:else>
<tr><td colspan="5">
<s:if test="%{tempFlg == 1}">
注：总投入为从${year}年1月起，在执行期内企业完成合同规定的技术、经济指标而投入的资金。
</s:if>
</td></tr>
</table>
<br><br>
<div align="center" style="width: 100%">
	<input class="button save" id="nextBtn" name="button" type="button" href="javascript: void(0);" onclick="nextBtn('${tempFlg}');" value="下一步"/>
</div>
</div>
</div>
</div>
</div>
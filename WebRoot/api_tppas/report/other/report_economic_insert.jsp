<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/other/js/report_economic_insert.js"></script>
<s:hidden id="economicIndicatorId" name="teconomicIndicator.economicIndicatorId" value="%{teconomicIndicator.economicIndicatorId}"></s:hidden>
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<form id="frmA" ></form>
<div id="resultDiv">
<div align="center" style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
		<div style="text-align: left;">
			<div class="Servicel04">
				<div class="abuot02">
					<div class="abuot07">执行期内企业完成的经济指标</div>
					<div align="right" style="width:95%">
 					（单位：万元）
					</div>
					<div style="border-bottom: 1px dashed #C9DEEE;"></div>
					<div id="dddd" style="float: left; font-size: 140%; padding-left: 20px"></div>
	<br>
	<TABLE id='testtab' border=0 cellSpacing=0 cellPadding=0 width=95% align=center class="t-list">
        <TR>
		  <Th width="16%">年度</Th>
		  <Th width="20%">销售收入</Th>
		  <Th width="20%">所交税金</Th>
		  <Th width="20%">净利润</Th>
		  <Th width="20%">创汇(万美元)</Th>
		</TR>
        <TR align="right">
        	<TD>
				<FONT color=red>*</FONT>${year1}
		   </TD>
			<TD align="left">
			<input class="inputA" id="outputValue2" name="teconomicIndicator.outputValue2" type="text" style="width: 10.5em;ime-mode: disabled;" 
			value="<s:property value='%{teconomicIndicator.outputValue2}' escape='true'/>"
			onblur="upms.upmsUtils.blurTextCheck(this,'销售收入',1,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
			onkeypress="return upms.upmsUtils.isFloatNum(event,this)" />
			</TD><s:hidden id="hiddenoutputValue2" name="hidden" value="销售收入,1,2"></s:hidden>
			<TD align="left">
			<input class="inputA" id="payTaxes2" name="teconomicIndicator.payTaxes2" type="text" style="width: 10.5em;ime-mode: disabled;" 
			value="<s:property value='%{teconomicIndicator.payTaxes2}' escape='true'/>"
			onblur="upms.upmsUtils.blurTextCheck(this,'所交缴税',1,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
			onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
			</TD><s:hidden id="hiddenpayTaxes2" name="hidden" value="所交缴税,1,2"></s:hidden>
			<TD align="left">
			<input class="inputA" id="retainedProfits2" name="teconomicIndicator.retainedProfits2" type="text" style="width: 10.5em;ime-mode: disabled;" 
			value="<s:property value='%{teconomicIndicator.retainedProfits2}' escape='true'/>"
			onblur="upms.upmsUtils.blurTextCheck(this,'净利润',1,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
			onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
			</TD><s:hidden id="hiddenretainedProfits2" name="hidden" value="净利润,1,2"></s:hidden>
			<TD align="left">
			<input class="inputA" id="earnMoney2" name="teconomicIndicator.earnMoney2" type="text" style="width: 10.5em;ime-mode: disabled;" 
			value="<s:property value='%{teconomicIndicator.earnMoney2}' escape='true'/>"
			onblur="upms.upmsUtils.blurTextCheck(this,'创汇',1,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
			onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
			</TD><s:hidden id="hiddenearnMoney2" name="hidden" value="创汇,1,2"></s:hidden>
        </TR>
          <TR align="right">
        	<TD>
				<FONT color=red>*</FONT>${year2}
			</TD>
			<TD align="left">
			<input class="inputA" id="outputValue1" name="teconomicIndicator.outputValue1" type="text" style="width: 10.5em;ime-mode: disabled;" 
			value="<s:property value='%{teconomicIndicator.outputValue1}' escape='true'/>"
			onblur="upms.upmsUtils.blurTextCheck(this,'销售收入',1,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
			onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
			</TD><s:hidden id="hiddenoutputValue1" name="hidden" value="销售收入,1,2"></s:hidden>
			<TD align="left">
			<input class="inputA" id="payTaxes1" name="teconomicIndicator.payTaxes1" type="text" style="width: 10.5em;ime-mode: disabled;" 
			value="<s:property value='%{teconomicIndicator.payTaxes1}' escape='true'/>"
			onblur="upms.upmsUtils.blurTextCheck(this,'所交缴税',1,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
			onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
			</TD><s:hidden id="hiddenpayTaxes1" name="hidden" value="所交缴税,1,2"></s:hidden>
			<TD align="left">
			<input class="inputA" id="retainedProfits1" name="teconomicIndicator.retainedProfits1" type="text" style="width: 10.5em;ime-mode: disabled;" 
			value="<s:property value='%{teconomicIndicator.retainedProfits1}' escape='true'/>"
			onblur="upms.upmsUtils.blurTextCheck(this,'净利润',1,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
			onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
			</TD><s:hidden id="hiddenretainedProfits1" name="hidden" value="净利润,1,2"></s:hidden>
			<TD align="left">
			<input class="inputA" id="earnMoney1" name="teconomicIndicator.earnMoney1" type="text" style="width: 10.5em;ime-mode: disabled;" 
			value="<s:property value='%{teconomicIndicator.earnMoney1}' escape='true'/>"
			onblur="upms.upmsUtils.blurTextCheck(this,'创汇',1,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
			onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
			</TD><s:hidden id="hiddenearnMoney1" name="hidden" value="创汇,1,2"></s:hidden>
        </TR>        
        <TR align="right">
        	<s:if test="%{year3=='' || year3==null}">
	        	 <TD>
					${year2+1}
				</TD>
	        	<TD align="left">
				<input class="inputA" id="outputValue" name="teconomicIndicator.outputValue" type="text" style="width: 10.5em;ime-mode: disabled;" 
				value="<s:property value='%{teconomicIndicator.outputValue}' escape='true'/>"
				 onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
				onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
				</TD><s:hidden id="hiddenoutputValue" name="hidden" value="销售收入,0,2"></s:hidden>
				<TD align="left">
				<input class="inputA" id="payTaxes" name="teconomicIndicator.payTaxes" type="text" style="width: 10.5em;ime-mode: disabled;" 
				value="<s:property value='%{teconomicIndicator.payTaxes}' escape='true'/>"
				onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
				onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
				</TD><s:hidden id="hiddenpayTaxes" name="hidden" value="所交缴税,0,2"></s:hidden>
				<TD align="left">
				<input class="inputA" id="retainedProfits" name="teconomicIndicator.retainedProfits" type="text" style="width: 10.5em;ime-mode: disabled;" 
				value="<s:property value='%{teconomicIndicator.retainedProfits}' escape='true'/>"
				onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
				onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
				</TD><s:hidden id="hiddenretainedProfits" name="hidden" value="净利润,0,2"></s:hidden>
				<TD align="left">
				<input class="inputA" id="earnMoney" name="teconomicIndicator.earnMoney" type="text" style="width: 10.5em;ime-mode: disabled;" 
				value="<s:property value='%{teconomicIndicator.earnMoney}' escape='true'/>"
				onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
				onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
				</TD><s:hidden id="hiddenearnMoney" name="hidden" value="创汇,0,2"></s:hidden>
        	</s:if>
        	<s:else>
        	    <TD>
					<FONT color=red>*</FONT>${year3}
				</TD>
	        	<TD align="left">
				<input class="inputA" id="outputValue" name="teconomicIndicator.outputValue" type="text" style="width: 10.5em;ime-mode: disabled;" 
				value="<s:property value='%{teconomicIndicator.outputValue}' escape='true'/>"
				onblur="upms.upmsUtils.blurTextCheck(this,'销售收入',1,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
				onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
				</TD><s:hidden id="hiddenoutputValue" name="hidden" value="销售收入,1,2"></s:hidden>
				<TD align="left">
				<input class="inputA" id="payTaxes" name="teconomicIndicator.payTaxes" type="text" style="width: 10.5em;ime-mode: disabled;" 
				value="<s:property value='%{teconomicIndicator.payTaxes}' escape='true'/>"
				onblur="upms.upmsUtils.blurTextCheck(this,'所交缴税',1,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
				onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
				</TD><s:hidden id="hiddenpayTaxes" name="hidden" value="所交缴税,1,2"></s:hidden>
				<TD align="left">
				<input class="inputA" id="retainedProfits" name="teconomicIndicator.retainedProfits" type="text" style="width: 10.5em;ime-mode: disabled;" 
				value="<s:property value='%{teconomicIndicator.retainedProfits}' escape='true'/>"
				onblur="upms.upmsUtils.blurTextCheck(this,'净利润',1,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
				onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
				</TD><s:hidden id="hiddenretainedProfits" name="hidden" value="净利润,1,2"></s:hidden>
				<TD align="left">
				<input class="inputA" id="earnMoney" name="teconomicIndicator.earnMoney" type="text" style="width: 10.5em;ime-mode: disabled;" 
				value="<s:property value='%{teconomicIndicator.earnMoney}' escape='true'/>"
				onblur="upms.upmsUtils.blurTextCheck(this,'创汇',1,2);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="12"
				onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
				</TD><s:hidden id="hiddenearnMoney" name="hidden" value="创汇,1,2"></s:hidden>
        	</s:else>
        </TR>
        <TR align="right">
        	<TD>累计</TD>
			<TD align="left">
			<input type="hidden" class="inputA" id="outputValueList" name="outputValueList" style="width: 10.5em;" 
			value="<s:property value='%{outputValueList}' escape='true'/>"
			style="ime-mode: disabled;" onkeypress="return upms.upmsUtils.isFloatNum(event,this)"  
			onafterpaste="onlyFloatInput(this)" readonly="readonly">
			<input type=text class="inputA" id="summ4" name="summ4" value="${outputValueList}" style="width: 10.5em;" 
			style="ime-mode: disabled;" onkeypress="return upms.upmsUtils.isFloatNum(event,this)" 
			onafterpaste="onlyFloatInput(this)" disabled="disabled">
			</TD>
			<TD align="left">
			<input type="hidden" class="inputA" id="payTaxesList" name="payTaxesList" style="width: 10.5em;" 
			value="<s:property value='%{payTaxesList}' escape='true'/>"
			style="ime-mode: disabled;" onkeypress="return upms.upmsUtils.isFloatNum(event,this)"  
			onafterpaste="onlyFloatInput(this)" readonly="readonly">
			<input type=text class="inputA" id="summ3" name="summ3" value="${payTaxesList}" style="width: 10.5em;" 
			style="ime-mode: disabled;" onkeypress="return upms.upmsUtils.isFloatNum(event,this)" 
			onafterpaste="onlyFloatInput(this)" disabled="disabled">
			</TD>
			<TD align="left">
			<input type="hidden" class="inputA" id="petainedList" name="petainedList" style="width: 10.5em;" 
			value="<s:property value='%{petainedList}' escape='true'/>"
			style="ime-mode: disabled;" onkeypress="return upms.upmsUtils.isFloatNum(event,this)"  
			onafterpaste="onlyFloatInput(this)" readonly="readonly">
			<input type=text class="inputA" id="summ2" name="summ2" value="${petainedList}" style="width: 10.5em;" 
			style="ime-mode: disabled;" onkeypress="return upms.upmsUtils.isFloatNum(event,this)" 
			onafterpaste="onlyFloatInput(this)" disabled="disabled">
			</TD>
			<TD align="left">
			<input type="hidden" class="inputA" id="earnMoneyList" name="earnMoneyList" style="width: 10.5em;" 
			value="<s:property value='%{earnMoneyList}' escape='true'/>"
			style="ime-mode: disabled;" onkeypress="return upms.upmsUtils.isFloatNum(event,this)"  
			onafterpaste="onlyFloatInput(this)" readonly="readonly">
			<input type=text class="inputA" id="summ1" name="summ1" value="${earnMoneyList}" style="width: 10.5em;" 
			style="ime-mode: disabled;" onkeypress="return upms.upmsUtils.isFloatNum(event,this)" 
			onafterpaste="onlyFloatInput(this)" disabled="disabled">
			</TD>
        </TR>
 </TABLE>
 <br><br>
<div align="center" style="width: 100%">
	<input type="button" id="nextBtn" class="button save" href="javascript: void(0);" value="下一步">
</div>
</div>
</div>
</div>
</div>
</div>

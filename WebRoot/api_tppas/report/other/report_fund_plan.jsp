<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/other/js/report_fund_plan.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
	<div class="Servicel04">
		<div class="abuot02">
			<div class="abuot07">项目投资计划</div>
			<div class="abuot03">
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<s:hidden id="fundPlanBId" name="tfundPlanB.fundPlanBId" value="%{tfundPlanB.fundPlanBId}"></s:hidden>
<s:hidden id="year1" name="tfundPlanB.year1" value="%{year1}"/>
<s:hidden id="year2" name="tfundPlanB.year2" value="%{year2}"/>
<s:hidden id="year3" name="tfundPlanB.year3" value="%{year3}"/>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<!-- 下一步按钮提示信息 -->
<label id="comfirmSaveNext" style="display: none"><s:text name="confirm_save_and_next_info"/></label>
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
<div align="right">单位：万元</div>
  <tr>
    <td width="15%" height="61"><div align="center">年度分配</div></td>
    <td width="17%">
    	<div align="center">总投资</div>
    </td>
    <td width="17%">
    	<div align="center">甲方拨款</div>
    </td>
    <td width="17%">
    	<div align="center">单位自筹</div>
    </td>
    <td width="17%">
    	<div align="center">其他经费</div>
    </td>
    <td width="17%">
   	 <div align="center">银行贷款</div>
    </td>
  </tr>
  <tr>
    <td>
    	<div align="right">
    		<s:property value='%{tfundPlanB.year1}' escape='true'/>年度
    	</div>
    </td>
  	
    <td>
    	<input type="text" id="totalInvestment1" name="tfundPlanB.totalInvestment1" 
	    value="<s:property value='%{tfundPlanB.totalInvestment1}' escape='true'/>"
	    style="width:160px" class="inputA" maxlength="12" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'总投资',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" onkeypress="return upms.upmsUtils.isFloatNum(event,this)" />
        <s:hidden id="hiddentotalInvestment1" name="hidden" value="总投资,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="partyFunding1" name="tfundPlanB.partyFunding1" 
	    value="<s:property value='%{tfundPlanB.partyFunding1}' escape='true'/>"
	    style="width:160px" class="inputA" maxlength="12" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'甲方拨款',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
        <s:hidden id="hiddenpartyFunding1" name="hidden" value="甲方拨款,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="unitRaised1" name="tfundPlanB.unitRaised1" 
	    value="<s:property value='%{tfundPlanB.unitRaised1}' escape='true'/>"
	    style="width:160px" class="inputA" maxlength="12" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'单位自筹',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
        <s:hidden id="hiddenunitRaised1" name="hidden" value="单位自筹,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="otherFunds1" name="tfundPlanB.otherFunds1" 
	    value="<s:property value='%{tfundPlanB.otherFunds1}' escape='true'/>"
	    style="width:160px" class="inputA" maxlength="12" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'其他经费',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" onkeypress="return upms.upmsUtils.isFloatNum(event,this)" />
        <s:hidden id="hiddenotherFunds1" name="hidden" value="其他经费,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="bankLoans1" name="tfundPlanB.bankLoans1" 
	    value="<s:property value='%{tfundPlanB.bankLoans1}' escape='true'/>"
	    style="width:160px" class="inputA" maxlength="12" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'银行贷款',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
        <s:hidden id="hiddenbankLoans1" name="hidden" value="银行贷款,1,2"></s:hidden>
    </td>
  </tr>
  <tr>
    <td>
    	<div align="right">
    		<s:property value='%{tfundPlanB.year2}' escape='true'/>年度
    	</div>
    </td>
    <td >
    	<input type="text" id="totalInvestment2" name="tfundPlanB.totalInvestment2" 
	    value="<s:property value='%{tfundPlanB.totalInvestment2}' escape='true'/>"
	    style="width:160px" class="inputA" maxlength="12" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'总投资',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" onkeypress="return upms.upmsUtils.isFloatNum(event,this)" />
        <s:hidden id="hiddentotalInvestment2" name="hidden" value="总投资,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="partyFunding2" name="tfundPlanB.partyFunding2" 
	    value="<s:property value='%{tfundPlanB.partyFunding2}' escape='true'/>"
	    style="width:160px" class="inputA" maxlength="12" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'甲方拨款',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
        <s:hidden id="hiddenpartyFunding2" name="hidden" value="甲方拨款,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="unitRaised2" name="tfundPlanB.unitRaised2" 
	    value="<s:property value='%{tfundPlanB.unitRaised2}' escape='true'/>"
	    style="width:160px" class="inputA" maxlength="12" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'单位自筹',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
        <s:hidden id="hiddenunitRaised2" name="hidden" value="单位自筹,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="otherFunds2" name="tfundPlanB.otherFunds2" 
	    value="<s:property value='%{tfundPlanB.otherFunds2}' escape='true'/>"
	    style="width:160px" class="inputA" maxlength="12" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'其他经费',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
        <s:hidden id="hiddenotherFunds2" name="hidden" value="其他经费,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="bankLoans2" name="tfundPlanB.bankLoans2" 
	    value="<s:property value='%{tfundPlanB.bankLoans2}' escape='true'/>"
	    style="width:160px" class="inputA" maxlength="12" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'银行贷款',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
        <s:hidden id="hiddenbankLoans2" name="hidden" value="银行贷款,1,2"></s:hidden>
    </td>
  </tr>
  <tr>
  
        <td>
	    	<div align="right">
	    	<s:if test="%{year3=='' || year3==null}">
				${year2+1}年度
				</s:if>
				<s:else>
					<s:property value='%{tfundPlanB.year3}' escape='true'/>年度
				</s:else>
	    		</div>
	    	</td>
	    <td>
	    	<input type="text" id="totalInvestment3" name="tfundPlanB.totalInvestment3" 
		    value="<s:property value='%{tfundPlanB.totalInvestment3}' escape='true'/>"
		    style="width:160px" class="inputA" maxlength="12" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'总投资',1,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" onkeypress="return upms.upmsUtils.isFloatNum(event,this)" />
	        <s:hidden id="hiddentotalInvestment3" name="hidden" value="总投资,1,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="partyFunding3" name="tfundPlanB.partyFunding3" 
		    value="<s:property value='%{tfundPlanB.partyFunding3}' escape='true'/>"
		    style="width:160px" class="inputA" maxlength="12" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'甲方拨款',1,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
	        <s:hidden id="hiddenpartyFunding3" name="hidden" value="甲方拨款,1,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="unitRaised3" name="tfundPlanB.unitRaised3" 
		    value="<s:property value='%{tfundPlanB.unitRaised3}' escape='true'/>"
		    style="width:160px" class="inputA" maxlength="12" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'单位自筹',1,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
	        <s:hidden id="hiddenunitRaised3" name="hidden" value="单位自筹,1,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="otherFunds3" name="tfundPlanB.otherFunds3" 
		    value="<s:property value='%{tfundPlanB.otherFunds3}' escape='true'/>"
		    style="width:160px" class="inputA" maxlength="12" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'其他经费',1,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
	        <s:hidden id="hiddenotherFunds3" name="hidden" value="其他经费,1,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="bankLoans3" name="tfundPlanB.bankLoans3" 
		    value="<s:property value='%{tfundPlanB.bankLoans3}' escape='true'/>"
		    style="width:160px" class="inputA" maxlength="12" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'银行贷款',1,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" onkeypress="return upms.upmsUtils.isFloatNum(event,this)"/>
	        <s:hidden id="hiddenbankLoans3" name="hidden" value="银行贷款,1,2"></s:hidden>
	    </td>
  </tr>
  <tr>
    <td>
    <div align="right">合计</div>
    </td>
    <td>
		<input id="totalInvestmentTotal" name="tfundPlanB.totalInvestmentTotal" 
		type="text" class="inputA" style=" width:160px " 
		value="<s:property value='%{tfundPlanB.totalInvestmentTotal}' escape='true'/>" 
		readonly="readonly"/>
	</td>
    <td>
    	<input id="partyFundingTotal" name="tfundPlanB.partyFundingTotal" 
		type="text" class="inputA" style=" width:160px " 
		value="<s:property value='%{tfundPlanB.partyFundingTotal}' escape='true'/>" 
		readonly="readonly"/>
    </td>
    <td>
    	<input id="unitRaisedTotal" name="tfundPlanB.unitRaisedTotal" 
		type="text" class="inputA" style=" width:160px " 
		value="<s:property value='%{tfundPlanB.unitRaisedTotal}' escape='true'/>" 
		readonly="readonly"/>
    </td>
    <td>
    	<input id="otherFundsTotal" name="tfundPlanB.otherFundsTotal" 
		type="text" class="inputA" style=" width:160px " 
		value="<s:property value='%{tfundPlanB.otherFundsTotal}' escape='true'/>" 
		readonly="readonly"/>
    </td>
    <td>
    	<input id="bankLoansTotal" name="tfundPlanB.bankLoansTotal" 
		type="text" class="inputA" style=" width:160px " 
		value="<s:property value='%{tfundPlanB.bankLoansTotal}' escape='true'/>" 
		readonly="readonly"/>
    </td>
  </tr>
 </table>
 
<div align="center">
	<%-- <s:if test="%{applyStatus == 1}">
		<input  type="button" id="okBtn" class="button add" href="javascript: void(0);" value="保存">
		&nbsp;
		<input  type="button" id="nextBtn" class="button next" href="javascript: void(0);" value="下一步">
	</s:if>
	<s:else> --%>
		<input  type="button" id="nextBtn1" class="button next" href="javascript: void(0);" value="下一步">
	<%-- </s:else> --%>
</div>
</div>
</div>
</div>
</div>
</div>

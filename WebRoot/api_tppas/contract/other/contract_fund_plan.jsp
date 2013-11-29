<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/contract/other/js/contract_fund_plan.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
	<div class="Servicel04">
		<div class="abuot02">
			<div class="abuot07">二、项目经费计划</div>
			<div class="abuot03">
<s:hidden id="tcontractId" name="tcontractId" value="%{tcontractId}"></s:hidden>
<s:hidden id="Flag" name="Flag" value="%{Flag}"></s:hidden>
<s:hidden id="contractStatus" name="contractStatus" value="%{contractStatus}"></s:hidden>
<s:hidden id="fundingPlanBId" name="tfundingPlanB.fundingPlanBId" value="%{tfundingPlanB.fundingPlanBId}"></s:hidden>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<!-- 下一步按钮提示信息 -->
<label id="comfirmSaveNext" style="display: none"><s:text name="confirm_save_and_next_info"/></label>
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td height="33" colspan="3" style=" padding-left:50px"> 
    1.项目投资计划
    </td>
    <td height="33" colspan="3">
    	<div align="right">单位：万元</div>
    </td>
  </tr>
  <tr>
    <td width="13%" height="61"><div align="center"></div></td>
    <td width="19%">
    	<div align="center">总投资</div>
    </td>
    <td width="17%">
    	<div align="center">甲方拨款</div>
    </td>
    <td width="15%">
    	<div align="center">单位自筹</div>
    </td>
    <td width="15%">
    	<div align="center">其他经费</div>
    </td>
    <td width="21%">
   	 <div align="center">银行贷款</div>
    </td>
  </tr>
  <tr>
    <td>
    	<div align="right">
    		<FONT color=red>*</FONT>${year1}
    	</div>
    </td>
    <td>
    	<input type="text" id="totalInvestment3" name="tfundingPlanB.totalInvestment3" 
	    value="<s:property value='%{tfundingPlanB.totalInvestment3}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'总投资',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)"  />
        <s:hidden id="hiddentotalInvestment3" name="hidden" value="总投资,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="partyFunding3" name="tfundingPlanB.partyFunding3" 
	    value="<s:property value='%{tfundingPlanB.partyFunding3}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'甲方拨款',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenpartyFunding3" name="hidden" value="甲方拨款,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="unitRaised3" name="tfundingPlanB.unitRaised3" 
	    value="<s:property value='%{tfundingPlanB.unitRaised3}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'单位自筹',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenunitRaised3" name="hidden" value="单位自筹,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="otherFunds3" name="tfundingPlanB.otherFunds3" 
	    value="<s:property value='%{tfundingPlanB.otherFunds3}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'其他经费',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)"  />
        <s:hidden id="hiddenotherFunds3" name="hidden" value="其他经费,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="bankLoans3" name="tfundingPlanB.bankLoans3" 
	    value="<s:property value='%{tfundingPlanB.bankLoans3}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'银行贷款',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenbankLoans3" name="hidden" value="银行贷款,1,2"></s:hidden>
    </td>
  </tr>
  <tr>
    <td>
    	<div align="right">
    		<FONT color=red>*</FONT>${year2}
    	</div>
    </td>
    <td >
    	<input type="text" id="totalInvestment2" name="tfundingPlanB.totalInvestment2" 
	    value="<s:property value='%{tfundingPlanB.totalInvestment2}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'总投资',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)"  />
        <s:hidden id="hiddentotalInvestment2" name="hidden" value="总投资,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="partyFunding2" name="tfundingPlanB.partyFunding2" 
	    value="<s:property value='%{tfundingPlanB.partyFunding2}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'甲方拨款',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenpartyFunding2" name="hidden" value="甲方拨款,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="unitRaised2" name="tfundingPlanB.unitRaised2" 
	    value="<s:property value='%{tfundingPlanB.unitRaised2}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'单位自筹',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenunitRaised2" name="hidden" value="单位自筹,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="otherFunds2" name="tfundingPlanB.otherFunds2" 
	    value="<s:property value='%{tfundingPlanB.otherFunds2}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'其他经费',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenotherFunds2" name="hidden" value="其他经费,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="bankLoans2" name="tfundingPlanB.bankLoans2" 
	    value="<s:property value='%{tfundingPlanB.bankLoans2}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'银行贷款',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenbankLoans2" name="hidden" value="银行贷款,1,2"></s:hidden>
    </td>
  </tr>
  <tr>
  	<s:if test="%{yearFlag == 0}">  
		<td>
	    	<div align="right">${year3}</div>
	    </td>
	    <td>
	    	<input type="text" id="totalInvestment1" name="tfundingPlanB.totalInvestment1" 
		    value="<s:property value='%{tfundingPlanB.totalInvestment1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'总投资',0,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)"  />
	        <s:hidden id="hiddentotalInvestment1" name="hidden" value="总投资,0,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="partyFunding1" name="tfundingPlanB.partyFunding1" 
		    value="<s:property value='%{tfundingPlanB.partyFunding1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'甲方拨款',0,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddenpartyFunding1" name="hidden" value="甲方拨款,0,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="unitRaised1" name="tfundingPlanB.unitRaised1" 
		    value="<s:property value='%{tfundingPlanB.unitRaised1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'单位自筹',0,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddenunitRaised1" name="hidden" value="单位自筹,0,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="otherFunds1" name="tfundingPlanB.otherFunds1" 
		    value="<s:property value='%{tfundingPlanB.otherFunds1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'其他经费',0,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddenotherFunds1" name="hidden" value="其他经费,0,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="bankLoans1" name="tfundingPlanB.bankLoans1" 
		    value="<s:property value='%{tfundingPlanB.bankLoans1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'银行贷款',0,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddenbankLoans1" name="hidden" value="银行贷款,0,2"></s:hidden>
	    </td>
    </s:if>
    <s:else>
        <td>
	    	<div align="right">
	    		<FONT color=red>*</FONT>${year3}</div>
	    	</td>
	    <td>
	    	<input type="text" id="totalInvestment1" name="tfundingPlanB.totalInvestment1" 
		    value="<s:property value='%{tfundingPlanB.totalInvestment1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'总投资',1,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)"  />
	        <s:hidden id="hiddentotalInvestment1" name="hidden" value="总投资,1,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="partyFunding1" name="tfundingPlanB.partyFunding1" 
		    value="<s:property value='%{tfundingPlanB.partyFunding1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'甲方拨款',1,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddenpartyFunding1" name="hidden" value="甲方拨款,1,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="unitRaised1" name="tfundingPlanB.unitRaised1" 
		    value="<s:property value='%{tfundingPlanB.unitRaised1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'单位自筹',1,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddenunitRaised1" name="hidden" value="单位自筹,1,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="otherFunds1" name="tfundingPlanB.otherFunds1" 
		    value="<s:property value='%{tfundingPlanB.otherFunds1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'其他经费',1,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddenotherFunds1" name="hidden" value="其他经费,1,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="bankLoans1" name="tfundingPlanB.bankLoans1" 
		    value="<s:property value='%{tfundingPlanB.bankLoans1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'银行贷款',1,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddenbankLoans1" name="hidden" value="银行贷款,1,2"></s:hidden>
	    </td>
    </s:else>
  </tr>
  <tr>
    <td>
    <div align="right">合计</div>
    </td>
    <td>
    	<input type="text" id="TotaltotalInvestment" name="TotaltotalInvestment" 
	    style="width:100px" class="inputA" disabled="disabled"/>
    </td>
    <td>
    	<input type="text" id="TotalpartyFunding" name="TotalpartyFunding" 
	    style="width:100px" class="inputA" disabled="disabled"/>
    </td>
    <td>
    	<input type="text" id="TotalunitRaised" name="TotalunitRaised" 
	    style="width:100px" class="inputA" disabled="disabled"/>
    </td>
    <td>
    	<input type="text" id="TotalotherFunds" name="TotalotherFunds" 
	    style="width:100px" class="inputA" disabled="disabled"/>
    </td>
    <td>
    	<input type="text" id="TotalbankLoans" name="TotalbankLoans" 
	    style="width:100px" class="inputA" disabled="disabled"/>
    </td>
  </tr>
 </table>
 <table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td colspan="3" style=" padding-left:50px">
    	2.经费支出预算（指甲方拨款数）
    </td>
    <td colspan="5">
    	<p align="right">单位：万元 </p>
    </td>
    </tr>
  <tr>
    <td width="13%">&nbsp;</td>
    <td width="13%">
    	<div align="center">设备费</div>
    </td>
    <td width="12%">
    	<div align="center">材料费</div>
    </td>
    <td width="13%">
    	<div align="center">测试化验加工费</div>
    </td>
    <td width="12%">
    	<div align="center">燃料动力费</div>
    </td>
    <td width="12%">
    	<div align="center">差旅调研费</div>
    </td>
    <td width="12%">
    	<div align="center">会议交流费</div>
    </td>
    <td width="13%">
    	<div align="center">劳务咨询费</div>
    </td>
  </tr>
  <tr>
    <td>
    	<div align="right">
    		<FONT color=red>*</FONT>${year1}
    	</div>
    </td>
    <td>
    	<input type="text" id="equipmentCost3" name="tfundingPlanB.equipmentCost3" 
	    value="<s:property value='%{tfundingPlanB.equipmentCost3}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'设备费',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenequipmentCost3" name="hidden" value="设备费,1,2"></s:hidden>
    </td>
    <td>
   		<input type="text" id="materialFee3" name="tfundingPlanB.materialFee3" 
	    value="<s:property value='%{tfundingPlanB.materialFee3}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'材料费',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenmaterialFee3" name="hidden" value="材料费,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="testFee3" name="tfundingPlanB.testFee3" 
	    value="<s:property value='%{tfundingPlanB.testFee3}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'测试化验加工费',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddentestFee3" name="hidden" value="测试化验加工费,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="fuel3" name="tfundingPlanB.fuel3" 
	    value="<s:property value='%{tfundingPlanB.fuel3}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'燃料动力费',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenfuel3" name="hidden" value="燃料动力费,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="travel3" name="tfundingPlanB.travel3" 
	    value="<s:property value='%{tfundingPlanB.travel3}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'差旅调研费',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddentravel3" name="hidden" value="差旅调研费,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="conferenceFees3" name="tfundingPlanB.conferenceFees3" 
	    value="<s:property value='%{tfundingPlanB.conferenceFees3}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'会议交流费',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenconferenceFees3" name="hidden" value="会议交流费,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="consultancyServices3" name="tfundingPlanB.consultancyServices3" 
	    value="<s:property value='%{tfundingPlanB.consultancyServices3}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'劳务咨询费',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenconsultancyServices3" name="hidden" value="劳务咨询费,1,2"></s:hidden>
    </td>
  </tr>
  <tr>
    <td>
    	<div align="right">
    		<FONT color=red>*</FONT>${year2}
    	</div>
    </td>
    <td>
    	<input type="text" id="equipmentCost2" name="tfundingPlanB.equipmentCost2" 
	    value="<s:property value='%{tfundingPlanB.equipmentCost2}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'设备费',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenequipmentCost2" name="hidden" value="设备费,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="materialFee2" name="tfundingPlanB.materialFee2" 
	    value="<s:property value='%{tfundingPlanB.materialFee2}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'材料费',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenmaterialFee2" name="hidden" value="材料费,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="testFee2" name="tfundingPlanB.testFee2" 
	    value="<s:property value='%{tfundingPlanB.testFee2}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'测试化验加工费',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddentestFee2" name="hidden" value="测试化验加工费,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="fuel2" name="tfundingPlanB.fuel2" 
	    value="<s:property value='%{tfundingPlanB.fuel2}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'燃料动力费',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenfuel2" name="hidden" value="燃料动力费,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="travel2" name="tfundingPlanB.travel2" 
	    value="<s:property value='%{tfundingPlanB.travel2}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'差旅调研费',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddentravel2" name="hidden" value="差旅调研费,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="conferenceFees2" name="tfundingPlanB.conferenceFees2" 
	    value="<s:property value='%{tfundingPlanB.conferenceFees2}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'会议交流费',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenconferenceFees2" name="hidden" value="会议交流费,1,2"></s:hidden>
    </td>
    <td>
    	<input type="text" id="consultancyServices2" name="tfundingPlanB.consultancyServices2" 
	    value="<s:property value='%{tfundingPlanB.consultancyServices2}' escape='true'/>"
	    style="width:100px" class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'劳务咨询费',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenconsultancyServices2" name="hidden" value="劳务咨询费,1,2"></s:hidden>
    </td>
  </tr>
  <tr>
	<s:if test="%{yearFlag == 0}">  
		 <td>
	    	<div align="right">
	    		<FONT color=red>*</FONT>${year3}
	    	</div>
	    </td>
	    <td>
	    	<input type="text" id="equipmentCost1" name="tfundingPlanB.equipmentCost1" 
		    value="<s:property value='%{tfundingPlanB.equipmentCost1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'设备费',0,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddenequipmentCost1" name="hidden" value="设备费,0,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="materialFee1" name="tfundingPlanB.materialFee1" 
		    value="<s:property value='%{tfundingPlanB.materialFee1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'材料费',0,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddenmaterialFee1" name="hidden" value="材料费,0,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="testFee1" name="tfundingPlanB.testFee1" 
		    value="<s:property value='%{tfundingPlanB.testFee1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'测试化验加工费',0,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddentestFee1" name="hidden" value="测试化验加工费,0,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="fuel1" name="tfundingPlanB.fuel1" 
		    value="<s:property value='%{tfundingPlanB.fuel1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'燃料动力费',0,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddenfuel1" name="hidden" value="燃料动力费,0,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="travel1" name="tfundingPlanB.travel1" 
		    value="<s:property value='%{tfundingPlanB.travel1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'差旅调研费',0,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddentravel1" name="hidden" value="差旅调研费,0,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="conferenceFees1" name="tfundingPlanB.conferenceFees1" 
		    value="<s:property value='%{tfundingPlanB.conferenceFees1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'会议交流费',0,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddenconferenceFees1" name="hidden" value="会议交流费,0,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="consultancyServices1" name="tfundingPlanB.consultancyServices1" 
		    value="<s:property value='%{tfundingPlanB.consultancyServices1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'劳务咨询费',0,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddenconsultancyServices1" name="hidden" value="劳务咨询费,0,2"></s:hidden>
	    </td>
	</s:if>
	<s:else>
	    <td>
	    	<div align="right">
	    		<FONT color=red>*</FONT>${year3}
	    	</div>
	    </td>
	    <td>
	    	<input type="text" id="equipmentCost1" name="tfundingPlanB.equipmentCost1" 
		    value="<s:property value='%{tfundingPlanB.equipmentCost1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'设备费',1,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddenequipmentCost1" name="hidden" value="设备费,1,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="materialFee1" name="tfundingPlanB.materialFee1" 
		    value="<s:property value='%{tfundingPlanB.materialFee1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'材料费',1,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddenmaterialFee1" name="hidden" value="材料费,1,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="testFee1" name="tfundingPlanB.testFee1" 
		    value="<s:property value='%{tfundingPlanB.testFee1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'测试化验加工费',1,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddentestFee1" name="hidden" value="测试化验加工费,1,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="fuel1" name="tfundingPlanB.fuel1" 
		    value="<s:property value='%{tfundingPlanB.fuel1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'燃料动力费',1,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddenfuel1" name="hidden" value="燃料动力费,1,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="travel1" name="tfundingPlanB.travel1" 
		    value="<s:property value='%{tfundingPlanB.travel1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'差旅调研费',1,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddentravel1" name="hidden" value="差旅调研费,1,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="conferenceFees1" name="tfundingPlanB.conferenceFees1" 
		    value="<s:property value='%{tfundingPlanB.conferenceFees1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'会议交流费',1,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddenconferenceFees1" name="hidden" value="会议交流费,1,2"></s:hidden>
	    </td>
	    <td>
	    	<input type="text" id="consultancyServices1" name="tfundingPlanB.consultancyServices1" 
		    value="<s:property value='%{tfundingPlanB.consultancyServices1}' escape='true'/>"
		    style="width:100px" class="inputA" maxlength="13" 
		    onblur="upms.upmsUtils.blurTextCheck(this,'劳务咨询费',1,2);" 
	        onfocus="upms.upmsUtils.textFocus(this)" />
	        <s:hidden id="hiddenconsultancyServices1" name="hidden" value="劳务咨询费,1,2"></s:hidden>
	    </td>
	</s:else>
  </tr>
  <tr>
    <td>
    	<div align="right">合计</div>
    </td>
        <td>
    	<input type="text" id="TotalequipmentCost" name="TotalequipmentCost" 
	    style="width:100px" class="inputA"  disabled="disabled"/>
    </td>
    <td>
    	<input type="text" id="TotalmaterialFee" name="TotalmaterialFee" 
	    style="width:100px" class="inputA" disabled="disabled"/>
    </td>
    <td>
    	<input type="text" id="TotaltestFee" name="TotaltestFee" 
	    style="width:100px" class="inputA" disabled="disabled"/>
    </td>
    <td>
    	<input type="text" id="Totalfuel" name="Totalfuel" 
	    style="width:100px" class="inputA" disabled="disabled"/>
    </td>
    <td>
    	<input type="text" id="Totaltravel" name="Totaltravel" 
	    style="width:100px" class="inputA" disabled="disabled"/>
    </td>
    <td>
    	<input type="text" id="TotalconferenceFees" name="TotalconferenceFees" 
	    style="width:100px" class="inputA" disabled="disabled"/>
    </td>
    <td>
    	<input type="text" id="TotalconsultancyServices" name="TotalconsultancyServices" 
	    style="width:100px" class="inputA" disabled="disabled"/>
    </td>
  </tr>
  <tr>
    <td colspan="8">
    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	注：1.预算安排是项目检查、验收以及节点制拨款的依据； </p>
                 &nbsp;2.${year1}年度甲方拨款为预算数的70%。${year2}年度及以后甲方拨款先作出预算，由项目单位垫支，待项目验收通过后拨付。
     </td>
  </tr>
  <%-- 
  <tr>
    <td colspan="3" style=" padding-left:50px">
    	<strong>附：立项时企业基本情况 </strong>
    </td>
    <td colspan="5" style=" padding-left:50px">
    	<div align="right">单位：万元</div>
    </td>
    </tr>
  <tr>
    <td colspan="3">
    	<div align="right">
    		<FONT color=red>*</FONT>总资产
    	</div>
    </td>
    <td colspan="5">
    	<input type="text" id="totalAssets" name="tfundingPlanB.totalAssets" 
	    value="<s:property value='%{tfundingPlanB.totalAssets}' escape='true'/>"
	    class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'总资产',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddentotalAssets" name="hidden" value="总资产,1,2"></s:hidden>
    </td>
    </tr>
  <tr>
    <td colspan="3">
    	<div align="right">
    		<FONT color=red>*</FONT>净资产
    	</div>
    </td>
    <td colspan="5">
    	<input type="text" id="netAssets" name="tfundingPlanB.netAssets" 
	    value="<s:property value='%{tfundingPlanB.netAssets}' escape='true'/>"
	    class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'净资产',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddennetAssets" name="hidden" value="净资产,1,2"></s:hidden>
    </td>
  </tr>
  <tr>
    <td colspan="3">
    	<div align="right">
    		<FONT color=red>*</FONT>企业净利润
    	</div>
    </td>
    <td colspan="5">
    	<input type="text" id="businessNet" name="tfundingPlanB.businessNet" 
	    value="<s:property value='%{tfundingPlanB.businessNet}' escape='true'/>"
	    class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'企业净利润',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenbusinessNet" name="hidden" value="企业净利润,1,2"></s:hidden>
    </td>
  </tr>
  <tr>
    <td colspan="3">
    	<div align="right">
    		<FONT color=red>*</FONT>企业年销售收入
    	</div>
    </td>
    <td colspan="5">
    	<input type="text" id="annualSalesRevenue" name="tfundingPlanB.annualSalesRevenue" 
	    value="<s:property value='%{tfundingPlanB.annualSalesRevenue}' escape='true'/>"
	    class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'企业年销售收入',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddenannualSalesRevenue" name="hidden" value="企业年销售收入,1,2"></s:hidden>
    </td>
  </tr>
  <tr>
    <td colspan="3">
    	<div align="right">
    		<FONT color=red>*</FONT>企业纳税总额
    	</div>
    </td>
    <td colspan="5">
    	<input type="text" id="totalCorporateTax" name="tfundingPlanB.totalCorporateTax" 
	    value="<s:property value='%{tfundingPlanB.totalCorporateTax}' escape='true'/>"
	    class="inputA" maxlength="13" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'企业纳税总额',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" />
        <s:hidden id="hiddentotalCorporateTax" name="hidden" value="企业纳税总额,1,2"></s:hidden>
    </td>
  </tr>
  --%>
</table>
<div align="center">
	<s:if test="%{Flag==0}">
		<input  type="button" id="okBtn" class="button add" href="javascript: void(0);" value="保存">
		&nbsp;
		<input  type="button" id="nextBtn" class="button next" href="javascript: void(0);" value="下一步">
	</s:if>
	<s:else>
		<input  type="button" id="nextBtn1" class="button next" href="javascript: void(0);" value="下一步">
	</s:else>
</div>
</div>
</div>
</div>
</div>
</div>

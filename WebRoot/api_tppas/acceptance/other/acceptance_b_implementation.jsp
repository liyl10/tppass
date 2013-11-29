<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/other/js/acceptance_b_implementation.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07"> 项目经费落实和使用情况 
				</div>
				<div align="right">单位：万元</div>
				<div class="abuot03">
				<br>
<s:hidden id="acceptanceId" name="acceptanceId" value="%{acceptanceId}"></s:hidden>
<s:hidden id="acceptanceStatus" name="acceptanceStatus" value="%{acceptanceStatus}"></s:hidden>
<s:hidden id="implementationId" name="tacceptanceImplementationB.implementationId" value="%{tacceptanceImplementationB.implementationId}"></s:hidden>
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td colspan="3" style=" text-align: right"><div align="center"><strong>资金到位情况</strong></div></td>
   	<td colspan="3"><div align="center"><strong>资金使用情况</strong></div></td>
    </tr>
  <tr>
    <td style=" text-align: right;width:10%"><div align="center">资金来源</div></td>
    <td style="width:20%"><div align="center">计划数</div></td>
    <td style="width:20%"><div align="center">实际数</div></td>
    <td style="width:10%"><div align="center">支出项目</div></td>
    <td style="width:20%"><div align="center">总经费使用情况</div></td>
    <td style="width:20%"><div align="center">市拨经费使用情况</div></td>
  </tr>
  <tr>
    <td align="right"><FONT color=red>*</FONT>项目总经费</td>
    <td><input id="planFundsTotalNum" name="tacceptanceImplementationB.planFundsTotalNum" 
	    value="<s:property value='%{tacceptanceImplementationB.planFundsTotalNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;" 
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'项目总经费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddenplanFundsTotalNum" name="hidden" value="项目总经费,1,2"></s:hidden>	
    <td>
	    <input id="actualFundsTotalNum" name="tacceptanceImplementationB.actualFundsTotalNum" 
	    value="<s:property value='%{tacceptanceImplementationB.actualFundsTotalNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'项目总经费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddenactualFundsTotalNum" name="hidden" value="项目总经费,1,2"></s:hidden>
    <td align="right"><FONT color=red>*</FONT>人员费</td>
    <td><input id="totalStaffCosts" name="tacceptanceImplementationB.totalStaffCosts" 
	    value="<s:property value='%{tacceptanceImplementationB.totalStaffCosts}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'人员费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddentotalStaffCosts" name="hidden" value="人员费,1,2"></s:hidden>
    
    <td><input id="cityTotalStaffCosts" name="tacceptanceImplementationB.cityTotalStaffCosts" 
	    value="<s:property value='%{tacceptanceImplementationB.cityTotalStaffCosts}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'人员费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddencityTotalStaffCosts" name="hidden" value="人员费,1,2"></s:hidden>
  </tr>
  <tr>
    <td align="right"><FONT color=red>*</FONT>市拨经费</td>
    <td><input id="planFundsCityNum" name="tacceptanceImplementationB.planFundsCityNum" 
	    value="<s:property value='%{tacceptanceImplementationB.planFundsCityNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'市拨经费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddenplanFundsCityNum" name="hidden" value="市拨经费,1,2"></s:hidden>
    
    <td><input id="actualFundsCityNum" name="tacceptanceImplementationB.actualFundsCityNum" 
	    value="<s:property value='%{tacceptanceImplementationB.actualFundsCityNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'市拨经费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddenactualFundsCityNum" name="hidden" value="市拨经费,1,2"></s:hidden>
    
    <td align="right"><FONT color=red>*</FONT>设备费</td>
    <td><input id="totalDeviceCosts" name="tacceptanceImplementationB.totalDeviceCosts" 
	    value="<s:property value='%{tacceptanceImplementationB.totalDeviceCosts}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'设备费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddentotalDeviceCosts" name="hidden" value="设备费,1,2"></s:hidden>
    
    <td><input id="cityDeviceCosts" name="tacceptanceImplementationB.cityDeviceCosts" 
	    value="<s:property value='%{tacceptanceImplementationB.cityDeviceCosts}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'设备费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddencityDeviceCosts" name="hidden" value="设备费,1,2"></s:hidden>
  </tr>
  <tr>
    <td align="right"><FONT color=red>*</FONT>企业自筹</td>
    <td><input id="planRaisedNum" name="tacceptanceImplementationB.planRaisedNum" 
	    value="<s:property value='%{tacceptanceImplementationB.planRaisedNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'企业自筹',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddenplanRaisedNum" name="hidden" value="企业自筹,1,2"></s:hidden>
    
    <td><input id="actualRaisedNum" name="tacceptanceImplementationB.actualRaisedNum" 
	    value="<s:property value='%{tacceptanceImplementationB.actualRaisedNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'企业自筹',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddenactualRaisedNum" name="hidden" value="企业自筹,1,2"></s:hidden>
    
    <td align="right"><FONT color=red>*</FONT>能源材料费</td>
    <td><input id="totalEnergyCosts" name="tacceptanceImplementationB.totalEnergyCosts" 
	    value="<s:property value='%{tacceptanceImplementationB.totalEnergyCosts}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'能源材料费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddentotalEnergyCosts" name="hidden" value="能源材料费,1,2"></s:hidden>
    
    <td><input id="cityEnergyCosts" name="tacceptanceImplementationB.cityEnergyCosts" 
	    value="<s:property value='%{tacceptanceImplementationB.cityEnergyCosts}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'能源材料费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddencityEnergyCosts" name="hidden" value="能源材料费,1,2"></s:hidden>
  </tr>
  <tr>
    <td align="right"><FONT color=red>*</FONT>银行贷款</td>
    <td><input id="planBankNum" name="tacceptanceImplementationB.planBankNum" 
	    value="<s:property value='%{tacceptanceImplementationB.planBankNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'银行贷款',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddenplanBankNum" name="hidden" value="银行贷款,1,2"></s:hidden>
    
    <td><input id="actualBankNum" name="tacceptanceImplementationB.actualBankNum" 
	    value="<s:property value='%{tacceptanceImplementationB.actualBankNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'银行贷款',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddenactualBankNum" name="hidden" value="银行贷款,1,2"></s:hidden>
    
    <td align="right"><FONT color=red>*</FONT>试验外协费</td>
    <td><input id="totalExperimentCosts" name="tacceptanceImplementationB.totalExperimentCosts" 
	    value="<s:property value='%{tacceptanceImplementationB.totalExperimentCosts}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'试验外协费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddentotalExperimentCosts" name="hidden" value="试验外协费,1,2"></s:hidden>
    
    <td><input id="cityExperimentCosts" name="tacceptanceImplementationB.cityExperimentCosts" 
	    value="<s:property value='%{tacceptanceImplementationB.cityExperimentCosts}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'试验外协费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddencityExperimentCosts" name="hidden" value="试验外协费,1,2"></s:hidden>
    
  </tr>
  <tr>
    <td align="right"><FONT color=red>*</FONT>贷款贴息</td>
    <td><input id="planLoanInterestNum" name="tacceptanceImplementationB.planLoanInterestNum" 
	    value="<s:property value='%{tacceptanceImplementationB.planLoanInterestNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'贷款贴息',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddenplanLoanInterestNum" name="hidden" value="贷款贴息,1,2"></s:hidden>
    
    <td><input id="actualLoanInterestNum" name="tacceptanceImplementationB.actualLoanInterestNum" 
	    value="<s:property value='%{tacceptanceImplementationB.actualLoanInterestNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'贷款贴息',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddenactualLoanInterestNum" name="hidden" value="贷款贴息,1,2"></s:hidden>
    
    <td align="right"><FONT color=red>*</FONT>调研费</td>
    <td><input id="totalResearchCosts" name="tacceptanceImplementationB.totalResearchCosts" 
	    value="<s:property value='%{tacceptanceImplementationB.totalResearchCosts}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'调研费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddentotalResearchCosts" name="hidden" value="调研费,1,2"></s:hidden>
    
    <td><input id="cityResearchCosts" name="tacceptanceImplementationB.cityResearchCosts" 
	    value="<s:property value='%{tacceptanceImplementationB.cityResearchCosts}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'调研费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddencityResearchCosts" name="hidden" value="调研费,1,2"></s:hidden>
    
  </tr>
  <tr>
    <td align="right"><FONT color=red>*</FONT>其他拨款</td>
    <td><input id="planOtherNum" name="tacceptanceImplementationB.planOtherNum" 
	    value="<s:property value='%{tacceptanceImplementationB.planOtherNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'其他拨款',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddenplanOtherNum" name="hidden" value="其他拨款,1,2"></s:hidden>
    
    <td><input id="actualOtherNum" name="tacceptanceImplementationB.actualOtherNum" 
	    value="<s:property value='%{tacceptanceImplementationB.actualOtherNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
		maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'其他拨款',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddenactualOtherNum" name="hidden" value="其他拨款,1,2"></s:hidden>

    <td align="right"><FONT color=red>*</FONT>差旅费</td>
    <td><input id="totalTravelCosts" name="tacceptanceImplementationB.totalTravelCosts" 
	    value="<s:property value='%{tacceptanceImplementationB.totalTravelCosts}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'差旅费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddentotalTravelCosts" name="hidden" value="差旅费,1,2"></s:hidden>
    
    <td><input id="cityTravelCosts" name="tacceptanceImplementationB.cityTravelCosts" 
	    value="<s:property value='%{tacceptanceImplementationB.cityTravelCosts}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'差旅费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddencityTravelCosts" name="hidden" value="差旅费,1,2"></s:hidden>
    
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td align="right"><FONT color=red>*</FONT>会议费</td>
    <td><input id="totalMeetingCosts" name="tacceptanceImplementationB.totalMeetingCosts" 
	    value="<s:property value='%{tacceptanceImplementationB.totalMeetingCosts}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'会议费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddentotalMeetingCosts" name="hidden" value="会议费,1,2"></s:hidden>
    
    <td><input id="cityMeetingCosts" name="tacceptanceImplementationB.cityMeetingCosts" 
	    value="<s:property value='%{tacceptanceImplementationB.cityMeetingCosts}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'会议费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddencityMeetingCosts" name="hidden" value="会议费,1,2"></s:hidden>
    
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td align="right"><FONT color=red>*</FONT>管理费</td>
    <td><input id="totalManageCosts" name="tacceptanceImplementationB.totalManageCosts" 
	    value="<s:property value='%{tacceptanceImplementationB.totalManageCosts}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'管理费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddentotalManageCosts" name="hidden" value="管理费,1,2"></s:hidden>
    
    <td><input id="cityManageCosts" name="tacceptanceImplementationB.cityManageCosts" 
	    value="<s:property value='%{tacceptanceImplementationB.cityManageCosts}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'管理费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddencityManageCosts" name="hidden" value="管理费,1,2"></s:hidden>
    
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td align="right"><FONT color=red>*</FONT>其它</td>
    <td><input id="totalOtherCosts" name="tacceptanceImplementationB.totalOtherCosts" 
	    value="<s:property value='%{tacceptanceImplementationB.totalOtherCosts}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'其它',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddentotalOtherCosts" name="hidden" value="其它,1,2"></s:hidden>
    
    <td><input id="cityOtherCosts" name="tacceptanceImplementationB.cityOtherCosts" 
	    value="<s:property value='%{tacceptanceImplementationB.cityOtherCosts}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'其它',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddencityOtherCosts" name="hidden" value="其它,1,2"></s:hidden>
    
  </tr>
  <tr>
    <td width="14%">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td align="right">合计</td>
    <td>
	    <input type="hidden" class="inputA" id="totalTotalCosts" name="tacceptanceImplementationB.totalTotalCosts" style="width:80%"
		value="<s:property value='%{tacceptanceImplementationB.totalTotalCosts}' escape='true'/>"
		onafterpaste="onlyFloatInput(this)" readonly="readonly">
		<input type=text class="inputA" id="summ1" name="summ1" value="<s:property value='%{tacceptanceImplementationB.totalTotalCosts}' escape='true'/>" style="width:80%"
		style="ime-mode: disabled;"onafterpaste="onlyFloatInput(this)" disabled="disabled">
    </td>
    <td>
    	<input type="hidden" class="inputA" id="cityTotalCosts" name="tacceptanceImplementationB.cityTotalCosts" style="width:80%"
		value="<s:property value='%{tacceptanceImplementationB.cityTotalCosts}' escape='true'/>"
		onafterpaste="onlyFloatInput(this)" readonly="readonly">
		<input type=text class="inputA" id="summ2" name="summ2" value="<s:property value='%{tacceptanceImplementationB.cityTotalCosts}' escape='true'/>" style="width:80%"
		style="ime-mode: disabled;"onafterpaste="onlyFloatInput(this)" disabled="disabled">
    </td>
  </tr>
  <tr>
  	<td colspan="6" align="center" style="font-size:14px"><strong>对照合同项目任务完成情况</strong></td>
  </tr>
  <tr>
    <td width="14%" rowspan="6" align="right">主要技术指标完成情况</td>
    <td colspan="2" align="center"><strong><FONT color=red>*</FONT>合同要求</strong></td>
    <td colspan="3" align="center"><strong><FONT color=red>*</FONT>实际达到情况</strong></td>
    </tr>
  <tr>
    <td colspan="2" align="left">
		<input id="contractRequire1" name="tacceptanceImplementationB.contractRequire1" 
    	value="<s:property value='%{tacceptanceImplementationB.contractRequire1}' escape='true'/>" 
    	type="text" class="inputA" style="width:80%"
    	maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'合同要求',1,-1);"onfocus="upms.upmsUtils.textFocus(this);"/>	
    </td><s:hidden id="hiddencontractRequire1" name="hidden" value="合同要求,1,-1"></s:hidden>	
    
    <td colspan="3" align="left">
		<input id="actuallyAchieved1" name="tacceptanceImplementationB.actuallyAchieved1" 
    	value="<s:property value='%{tacceptanceImplementationB.actuallyAchieved1}' escape='true'/>" 
    	type="text" class="inputA" style="width:80%"
    	maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'实际达到情况',1,-1);"onfocus="upms.upmsUtils.textFocus(this);"/>	
    </td><s:hidden id="hiddenactuallyAchieved1" name="hidden" value="实际达到情况,1,-1"></s:hidden>	
    
  </tr>
  <tr>
    <td colspan="2" align="left">
		<input id="contractRequire2" name="tacceptanceImplementationB.contractRequire2" 
    	value="<s:property value='%{tacceptanceImplementationB.contractRequire2}' escape='true'/>" 
    	type="text" class="inputA" style="width:80%"
    	maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'合同要求',1,-1);"onfocus="upms.upmsUtils.textFocus(this);"/>	
    </td><s:hidden id="hiddencontractRequire2" name="hidden" value="合同要求,1,-1"></s:hidden>	
    
    <td colspan="3" align="left">
		<input id="actuallyAchieved2" name="tacceptanceImplementationB.actuallyAchieved2" 
    	value="<s:property value='%{tacceptanceImplementationB.actuallyAchieved2}' escape='true'/>" 
    	type="text" class="inputA" style="width:80%"
    	maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'实际达到情况',1,-1);"onfocus="upms.upmsUtils.textFocus(this);"/>	
    </td><s:hidden id="hiddenactuallyAchieved2" name="hidden" value="实际达到情况,1,-1"></s:hidden>	
    
   </tr>
  <tr>
    <td colspan="2" align="left">
		<input id="contractRequire3" name="tacceptanceImplementationB.contractRequire3" 
    	value="<s:property value='%{tacceptanceImplementationB.contractRequire3}' escape='true'/>" 
    	type="text" class="inputA" style="width:80%"
    	maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'合同要求',1,-1);"onfocus="upms.upmsUtils.textFocus(this);"/>	
    </td><s:hidden id="hiddencontractRequire3" name="hidden" value="合同要求,1,-1"></s:hidden>	
    
    <td colspan="3" align="left">
		<input id="actuallyAchieved3" name="tacceptanceImplementationB.actuallyAchieved3" 
    	value="<s:property value='%{tacceptanceImplementationB.actuallyAchieved3}' escape='true'/>" 
    	type="text" class="inputA" style="width:80%"
    	maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'实际达到情况',1,-1);"onfocus="upms.upmsUtils.textFocus(this);"/>	
    </td><s:hidden id="hiddenactuallyAchieved3" name="hidden" value="实际达到情况,1,-1"></s:hidden>	
    
  </tr>
  <tr>
    <td colspan="2" align="left">
		<input id="contractRequire4" name="tacceptanceImplementationB.contractRequire4" 
    	value="<s:property value='%{tacceptanceImplementationB.contractRequire4}' escape='true'/>" 
    	type="text" class="inputA" style="width:80%"
    	maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'合同要求',1,-1);"onfocus="upms.upmsUtils.textFocus(this);"/>	
    </td><s:hidden id="hiddencontractRequire4" name="hidden" value="合同要求,1,-1"></s:hidden>	
    
    <td colspan="3" align="left">
		<input id="actuallyAchieved4" name="tacceptanceImplementationB.actuallyAchieved4" 
    	value="<s:property value='%{tacceptanceImplementationB.actuallyAchieved4}' escape='true'/>" 
    	type="text" class="inputA" style="width:80%"
    	maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'实际达到情况',1,-1);"onfocus="upms.upmsUtils.textFocus(this);"/>	
    </td><s:hidden id="hiddenactuallyAchieved4" name="hidden" value="实际达到情况,1,-1"></s:hidden>	
    
  </tr>
  <tr>
    <td colspan="5">备注：须提供检测或检验报告</td>
  </tr>
  <tr>
    <td width="14%" rowspan="5" align="right">经济指标完成情况</td>
    <td align="center"><strong>效益类别</strong></td>
    <td colspan="2" align="center"><strong>合同约定额度</strong></td>
    <td colspan="2" align="center"><strong>实际完成额度</strong></td>
    </tr>
  <tr>
    <td align="right"><FONT color=red>*</FONT>销售收入（万元）</td>
    <td colspan="2" align="left">
		<input id="conventionsSales" name="tacceptanceImplementationB.conventionsSales" 
    	value="<s:property value='%{tacceptanceImplementationB.conventionsSales}' escape='true'/>" 
    	type="text" class="inputA" style="width:80%;ime-mode: disabled;"
		maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'销售收入',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddenconventionsSales" name="hidden" value="销售收入,1,2"></s:hidden>
    
    <td colspan="2" align="left">
		<input id="completeSales" name="tacceptanceImplementationB.completeSales" 
	    value="<s:property value='%{tacceptanceImplementationB.completeSales}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'销售收入',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddencompleteSales" name="hidden" value="销售收入,1,2"></s:hidden>
	
  </tr>
  <tr>
    <td align="right"><FONT color=red>*</FONT>利润总额（万元）</td>
    <td colspan="2" align="left">
		<input id="conventionsProfitTotal" name="tacceptanceImplementationB.conventionsProfitTotal" 
	    value="<s:property value='%{tacceptanceImplementationB.conventionsProfitTotal}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'利润总额',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddenconventionsProfitTotal" name="hidden" value="利润总额,1,2"></s:hidden>

    <td colspan="2" align="left">
		<input id="completeProfitTotal" name="tacceptanceImplementationB.completeProfitTotal" 
	    value="<s:property value='%{tacceptanceImplementationB.completeProfitTotal}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'利润总额',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddencompleteProfitTotal" name="hidden" value="利润总额,1,2"></s:hidden>

  </tr>
  <tr>
    <td align="right"><FONT color=red>*</FONT>税收总额（万元）</td>
    <td colspan="2" align="left">
		<input id="conventionsTaxTotal" name="tacceptanceImplementationB.conventionsTaxTotal" 
	    value="<s:property value='%{tacceptanceImplementationB.conventionsTaxTotal}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'税收总额',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddenconventionsTaxTotal" name="hidden" value="税收总额,1,2"></s:hidden>

    <td colspan="2" align="left">
		<input id="completeTaxTotal" name="tacceptanceImplementationB.completeTaxTotal" 
	    value="<s:property value='%{tacceptanceImplementationB.completeTaxTotal}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'税收总额',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddencompleteTaxTotal" name="hidden" value="税收总额,1,2"></s:hidden>
  </tr>
  <tr>
    <td align="right"><FONT color=red>*</FONT>创汇（万美元）</td>
    <td colspan="2" align="left">
		<input id="conventionsForeignExchange" name="tacceptanceImplementationB.conventionsForeignExchange" 
	    value="<s:property value='%{tacceptanceImplementationB.conventionsForeignExchange}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'创汇',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddenconventionsForeignExchange" name="hidden" value="创汇,1,2"></s:hidden>
    
    <td colspan="2" align="left">
		<input id="completeForeignExchange" name="tacceptanceImplementationB.completeForeignExchange" 
	    value="<s:property value='%{tacceptanceImplementationB.completeForeignExchange}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'创汇',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddencompleteForeignExchange" name="hidden" value="创汇,1,2"></s:hidden>
    
  </tr>
</table>
<br/>
<div align="center">
	<input class="button save" id="nextBtn" name="button" type="button" href="javascript: void(0);" value="下一步"/>
</div>
	 </div>
 	 </div>
   </div>
  </div>
</div>
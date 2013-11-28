<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/highTech/js/acceptance_a_acc_funds.js"></script>

<s:hidden id="acceptanceId" name="acceptanceId" value="%{acceptanceId}"></s:hidden>
<s:hidden id="acceptanceStatus" name="acceptanceStatus" value="%{acceptanceStatus}"></s:hidden>
<s:hidden id="accFundsId" name="tacceptanceAccFundsA.accFundsId" value="%{tacceptanceAccFundsA.accFundsId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
	<div class="Servicel04">
		<div class="abuot02">
		<div class="abuot07">西安市科技计划项目验收经费登记表</div>
		<div class="abuot03">
		<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td colspan="2"><div align="right">项目名称</div></td>
    <td colspan="7" ><div align="left"><s:property value='%{tacceptance.tprojectApplication.projectName}' escape='true'/></div></td>
    <td ><div align="center">备注</div></td>
  </tr>
  <tr>
    <td colspan="2"><div align="right">项目编号</div></td>
    <td colspan="3"><div align="left"><s:property value='%{tacceptance.tprojectApplication.projectNumber}' escape='true'/></div></td>
    <td><div align="right">完成年限</div></td>
    <td colspan="3"><div align="left"><INPUT type="text"  class="inputA" style="width:18em;"/></div></td>
    <td><div align="left"><INPUT type="text" class="inputA" style="width:6em;" id="remark1" name="tacceptanceAccFundsA.remark1" value="<s:property value='%{tacceptanceAccFundsA.remark1}' escape='true'/>"
    maxlength="50" onblur="upms.upmsUtils.blurTextCheck(this,'备注',0,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddenremark1" name="hidden" value="备注,0,-1"/></div></td>
  </tr>
  <tr>
    <td colspan="2"><div align="right">承担单位地址
</div></td>
    <td colspan="7"><div align="left"><s:property value='%{tprojectInfoA.unitAddress}' escape='true'/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="remark2" name="tacceptanceAccFundsA.remark2" value="<s:property value='%{tacceptanceAccFundsA.remark2}' escape='true'/>"
    maxlength="50" onblur="upms.upmsUtils.blurTextCheck(this,'备注',0,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddenremark2" name="hidden" value="备注,0,-1"/></div></td>
  </tr>
  <tr>
    <td colspan="2"><div align="right">单位负责人</div></td>
    <td><div align="left"><s:property value='%{tprojectInfoA.legalPerson}' escape='true'/></div></td>
    <td><div align="right">办公电话</div></td>
    <td colspan="2"><div align="left"><s:property value='%{tprojectInfoA.legalTel}' escape='true'/></div></td>
    <td><div align="right">手机</div></td>
    <td colspan="2"><div align="left"><s:property value='%{tprojectInfoA.legalPhone}' escape='true'/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="remark3" name="tacceptanceAccFundsA.remark3" value="<s:property value='%{tacceptanceAccFundsA.remark3}' escape='true'/>"
    maxlength="50" onblur="upms.upmsUtils.blurTextCheck(this,'备注',0,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddenremark3" name="hidden" value="备注,0,-1"/></div></td>
  </tr>
  <tr>
    <td colspan="2"><div align="right">项目负责人</div></td>
    <td><div align="left"><s:property value='%{tprojectInfoA.projectPerson}' escape='true'/></div></td>
    <td><div align="right">办公电话</div></td>
    <td colspan="2"><div align="left"><s:property value='%{tprojectInfoA.personTel}' escape='true'/></div></td>
    <td><div align="right">手机</div></td>
    <td colspan="2"><div align="left"><s:property value='%{tprojectInfoA.personPhone}' escape='true'/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="remark4" name="tacceptanceAccFundsA.remark4" value="<s:property value='%{tacceptanceAccFundsA.remark4}' escape='true'/>"
    maxlength="50" onblur="upms.upmsUtils.blurTextCheck(this,'备注',0,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddenremark4" name="hidden" value="备注,0,-1"/></div></td>
  </tr>
  <tr>
    <td colspan="10"><div align="center" style="margin-top:5px; margin-bottom:5px;"><strong>项目经费预算及决算&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（单位：万元）</strong></div></td>
    </tr>
  <tr>
    <td colspan="2"><div align="center"><FONT color=red>*</FONT>项目总投资</div></td>
    <td colspan="2"><div align="center"><FONT color=red>*</FONT>甲方拨款</div></td>
    <td colspan="2"><div align="center"><FONT color=red>*</FONT>其他经费</div></td>
    <td colspan="2"><div align="center"><FONT color=red>*</FONT>单位自筹</div></td>
    <td colspan="2"><div align="center"><FONT color=red>*</FONT>银行贷款</div></td>
    </tr>
  <tr>
    <td><div align="center">预算</div></td>
    <td><div align="center">决算</div></td>
    <td><div align="center">预算</div></td>
    <td><div align="center">决算</div></td>
    <td><div align="center">预算</div></td>
    <td><div align="center">决算</div></td>
    <td><div align="center">预算</div></td>
    <td><div align="center">决算</div></td>
    <td><div align="center">预算</div></td>
    <td><div align="center">决算</div></td>
  </tr>
  <tr>
    <td width="10%"><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="gudgetTotalInvestment" name="tacceptanceAccFundsA.gudgetTotalInvestment" value="<s:property value='%{tacceptanceAccFundsA.gudgetTotalInvestment}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'预算',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddengudgetTotalInvestment" name="hidden" value="预算,1,2"/></div></td>
    <td width="10%"><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="accountsTotalInvestment" name="tacceptanceAccFundsA.accountsTotalInvestment" value="<s:property value='%{tacceptanceAccFundsA.accountsTotalInvestment}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'决算',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenaccountsTotalInvestment" name="hidden" value="决算,1,2"/></div></td>
    <td width="10%"><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="gudgetPartyFunding" name="tacceptanceAccFundsA.gudgetPartyFunding" value="<s:property value='%{tacceptanceAccFundsA.gudgetPartyFunding}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'预算',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddengudgetPartyFunding" name="hidden" value="预算,1,2"/></div></td>
    <td width="10%"><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="accountsPartyFunding" name="tacceptanceAccFundsA.accountsPartyFunding" value="<s:property value='%{tacceptanceAccFundsA.accountsPartyFunding}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'决算',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenaccountsPartyFunding" name="hidden" value="决算,1,2"/></div></td>
    <td width="10%"><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="gudgetOther" name="tacceptanceAccFundsA.gudgetOther" value="<s:property value='%{tacceptanceAccFundsA.gudgetOther}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'预算',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddengudgetOther" name="hidden" value="预算,1,2"/></div></td>
    <td width="10%"><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="accountsOther" name="tacceptanceAccFundsA.accountsOther" value="<s:property value='%{tacceptanceAccFundsA.accountsOther}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'决算',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenaccountsOther" name="hidden" value="决算,1,2"/></div></td>
    <td width="10%"><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="gudgetRaised" name="tacceptanceAccFundsA.gudgetRaised" value="<s:property value='%{tacceptanceAccFundsA.gudgetRaised}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'预算',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddengudgetRaised" name="hidden" value="预算,1,2"/></div></td>
    <td width="10%"><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="accountsRaised" name="tacceptanceAccFundsA.accountsRaised" value="<s:property value='%{tacceptanceAccFundsA.accountsRaised}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'决算',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenaccountsRaised" name="hidden" value="决算,1,2"/></div></td>
    <td width="10%"><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="gudgetBank" name="tacceptanceAccFundsA.gudgetBank" value="<s:property value='%{tacceptanceAccFundsA.gudgetBank}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'预算',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddengudgetBank" name="hidden" value="预算,1,2"/></div></td>
    <td width="10%"><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="accountsBank" name="tacceptanceAccFundsA.accountsBank" value="<s:property value='%{tacceptanceAccFundsA.accountsBank}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'决算',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenaccountsBank" name="hidden" value="决算,1,2"/></div></td>
  </tr>
  <tr>
    <td colspan="10"><div align="center" style="margin-top:5px; margin-bottom:5px;"><strong>经费支出决算（指甲方拨款）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（单位：万元）</strong></div></td>
    </tr>
  <tr>
    <td><div align="center"><FONT color=red>*</FONT>年度/分类</div></td>
    <td><div align="center"><FONT color=red>*</FONT>人员费（&le;30%）</div></td>
    <td><div align="center"><FONT color=red>*</FONT>设备费</div></td>
    <td><div align="center"><FONT color=red>*</FONT>能源材料费</div></td>
    <td><div align="center"><FONT color=red>*</FONT>试验外协费</div></td>
    <td><div align="center"><FONT color=red>*</FONT>调研费</div></td>
    <td><div align="center"><FONT color=red>*</FONT>差旅费</div></td>
    <td><div align="center"><FONT color=red>*</FONT>会议费</div></td>
    <td colspan="2"><div align="center"><FONT color=red>*</FONT>管理费（&le;50%）</div></td>
    </tr>
  <tr>
    <td><div align="left"><input class="txt w184p Wdate" type="text" id="year1" name="tacceptanceAccFundsA.year1" value="<s:property value='%{tacceptanceAccFundsA.year1}' escape='true'/>" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy'})" onblur="upms.upmsUtils.blurTextCheck(this,'年度',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>
    <s:hidden id="hiddenyear1" name="hidden" value="年度,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="staffCosts1" name="tacceptanceAccFundsA.staffCosts1" value="<s:property value='%{tacceptanceAccFundsA.staffCosts1}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'人员费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenstaffCosts1" name="hidden" value="人员费,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="deviceCosts1" name="tacceptanceAccFundsA.deviceCosts1" value="<s:property value='%{tacceptanceAccFundsA.deviceCosts1}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'设备费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddendeviceCosts1" name="hidden" value="设备费,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="energyCosts1" name="tacceptanceAccFundsA.energyCosts1" value="<s:property value='%{tacceptanceAccFundsA.energyCosts1}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'能源材料费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenenergyCosts1" name="hidden" value="能源材料费,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="experimentCosts1" name="tacceptanceAccFundsA.experimentCosts1" value="<s:property value='%{tacceptanceAccFundsA.experimentCosts1}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'试验外协费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenexperimentCosts1" name="hidden" value="试验外协费,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="researchCosts1" name="tacceptanceAccFundsA.researchCosts1" value="<s:property value='%{tacceptanceAccFundsA.researchCosts1}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'调研费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenresearchCosts1" name="hidden" value="调研费,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="travelCosts1" name="tacceptanceAccFundsA.travelCosts1" value="<s:property value='%{tacceptanceAccFundsA.travelCosts1}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'差旅费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddentravelCosts1" name="hidden" value="差旅费,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="meetingCosts1" name="tacceptanceAccFundsA.meetingCosts1" value="<s:property value='%{tacceptanceAccFundsA.meetingCosts1}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'会议费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenmeetingCosts1" name="hidden" value="会议费,1,2"/></div></td>
    <td colspan="2"><div align="left"><INPUT type="text"  class="inputA" style="width:12em;" id="manageCosts1" name="tacceptanceAccFundsA.manageCosts1" value="<s:property value='%{tacceptanceAccFundsA.manageCosts1}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'管理费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenmanageCosts1" name="hidden" value="管理费,1,2"/></div></td>
    </tr>
  <tr>
    <td><div align="left"><input class="txt w184p Wdate" type="text" id="year2" name="tacceptanceAccFundsA.year2" value="<s:property value='%{tacceptanceAccFundsA.year2}' escape='true'/>" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy'})" onblur="upms.upmsUtils.blurTextCheck(this,'年度',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>
    <s:hidden id="hiddenyear2" name="hidden" value="年度,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="staffCosts2" name="tacceptanceAccFundsA.staffCosts2" value="<s:property value='%{tacceptanceAccFundsA.staffCosts2}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'人员费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenstaffCosts2" name="hidden" value="人员费,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="deviceCosts2" name="tacceptanceAccFundsA.deviceCosts2" value="<s:property value='%{tacceptanceAccFundsA.deviceCosts2}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'设备费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddendeviceCosts2" name="hidden" value="设备费,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="energyCosts2" name="tacceptanceAccFundsA.energyCosts2" value="<s:property value='%{tacceptanceAccFundsA.energyCosts2}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'能源材料费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenenergyCosts2" name="hidden" value="能源材料费,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="experimentCosts2" name="tacceptanceAccFundsA.experimentCosts2" value="<s:property value='%{tacceptanceAccFundsA.experimentCosts2}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'试验外协费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenexperimentCosts2" name="hidden" value="试验外协费,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="researchCosts2" name="tacceptanceAccFundsA.researchCosts2" value="<s:property value='%{tacceptanceAccFundsA.researchCosts2}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'调研费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenresearchCosts2" name="hidden" value="调研费,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="travelCosts2" name="tacceptanceAccFundsA.travelCosts2" value="<s:property value='%{tacceptanceAccFundsA.travelCosts2}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'差旅费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddentravelCosts2" name="hidden" value="差旅费,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="meetingCosts2" name="tacceptanceAccFundsA.meetingCosts2" value="<s:property value='%{tacceptanceAccFundsA.meetingCosts2}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'会议费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenmeetingCosts2" name="hidden" value="会议费,1,2"/></div></td>
    <td colspan="2"><div align="left"><INPUT type="text"  class="inputA" style="width:12em;" id="manageCosts2" name="tacceptanceAccFundsA.manageCosts2" value="<s:property value='%{tacceptanceAccFundsA.manageCosts2}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'管理费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenmanageCosts2" name="hidden" value="管理费,1,2"/></div></td>
    </tr>
  <tr>
    <td><div align="left"><input class="txt w184p Wdate" type="text" id="year3" name="tacceptanceAccFundsA.year3" value="<s:property value='%{tacceptanceAccFundsA.year3}' escape='true'/>" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy'})" onblur="upms.upmsUtils.blurTextCheck(this,'年度',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>
    <s:hidden id="hiddenyear3" name="hidden" value="年度,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="staffCosts3" name="tacceptanceAccFundsA.staffCosts3" value="<s:property value='%{tacceptanceAccFundsA.staffCosts3}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'人员费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenstaffCosts3" name="hidden" value="人员费,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="deviceCosts3" name="tacceptanceAccFundsA.deviceCosts3" value="<s:property value='%{tacceptanceAccFundsA.deviceCosts3}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'设备费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddendeviceCosts3" name="hidden" value="设备费,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="energyCosts3" name="tacceptanceAccFundsA.energyCosts3" value="<s:property value='%{tacceptanceAccFundsA.energyCosts3}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'能源材料费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenenergyCosts3" name="hidden" value="能源材料费,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="experimentCosts3" name="tacceptanceAccFundsA.experimentCosts3" value="<s:property value='%{tacceptanceAccFundsA.experimentCosts3}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'试验外协费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenexperimentCosts3" name="hidden" value="试验外协费,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="researchCosts3" name="tacceptanceAccFundsA.researchCosts3" value="<s:property value='%{tacceptanceAccFundsA.researchCosts3}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'调研费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenresearchCosts3" name="hidden" value="调研费,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="travelCosts3" name="tacceptanceAccFundsA.travelCosts3" value="<s:property value='%{tacceptanceAccFundsA.travelCosts3}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'差旅费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddentravelCosts3" name="hidden" value="差旅费,1,2"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" id="meetingCosts3" name="tacceptanceAccFundsA.meetingCosts3" value="<s:property value='%{tacceptanceAccFundsA.meetingCosts3}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'会议费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenmeetingCosts3" name="hidden" value="会议费,1,2"/></div></td>
    <td colspan="2"><div align="left"><INPUT type="text"  class="inputA" style="width:12em;" id="manageCosts3" name="tacceptanceAccFundsA.manageCosts3" value="<s:property value='%{tacceptanceAccFundsA.manageCosts3}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'管理费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenmanageCosts3" name="hidden" value="管理费,1,2"/></div></td>
    </tr>
  <tr>
    <td><div align="right">合计</div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" disabled="disabled" id="staffCostsTotal1" name="tacceptanceAccFundsA.staffCostsTotal1" value="<s:property value='%{tacceptanceAccFundsA.staffCostsTotal}' escape='true'/>"/>
    <s:hidden id="staffCostsTotal" name="tacceptanceAccFundsA.staffCostsTotal" value="<s:property value='%{tacceptanceAccFundsA.staffCostsTotal}' escape='true'"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" disabled="disabled" id="deviceCostsTotal1" name="tacceptanceAccFundsA.deviceCostsTotal1" value="<s:property value='%{tacceptanceAccFundsA.deviceCostsTotal}' escape='true'/>"/>
    <s:hidden id="deviceCostsTotal" name="tacceptanceAccFundsA.deviceCostsTotal" value="<s:property value='%{tacceptanceAccFundsA.deviceCostsTotal}' escape='true'"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" disabled="disabled" id="energyCostsTotal1" name="tacceptanceAccFundsA.energyCostsTotal1" value="<s:property value='%{tacceptanceAccFundsA.energyCostsTotal}' escape='true'/>"/>
    <s:hidden id="energyCostsTotal" name="tacceptanceAccFundsA.energyCostsTotal" value="<s:property value='%{tacceptanceAccFundsA.energyCostsTotal}' escape='true'"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" disabled="disabled" id="experimentCostsTotal1" name="tacceptanceAccFundsA.experimentCostsTotal1" value="<s:property value='%{tacceptanceAccFundsA.experimentCostsTotal}' escape='true'/>"/>
    <s:hidden id="experimentCostsTotal" name="tacceptanceAccFundsA.experimentCostsTotal" value="<s:property value='%{tacceptanceAccFundsA.experimentCostsTotal}' escape='true'"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" disabled="disabled" id="researchCostsTotal1" name="tacceptanceAccFundsA.researchCostsTotal1" value="<s:property value='%{tacceptanceAccFundsA.researchCostsTotal}' escape='true'/>"/>
    <s:hidden id="researchCostsTotal" name="tacceptanceAccFundsA.researchCostsTotal" value="<s:property value='%{tacceptanceAccFundsA.researchCostsTotal}' escape='true'"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" disabled="disabled" id="travelCostsTotal1" name="tacceptanceAccFundsA.travelCostsTotal1" value="<s:property value='%{tacceptanceAccFundsA.travelCostsTotal}' escape='true'/>"/>
    <s:hidden id="travelCostsTotal" name="tacceptanceAccFundsA.travelCostsTotal" value="<s:property value='%{tacceptanceAccFundsA.travelCostsTotal}' escape='true'"/></div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:6em;" disabled="disabled" id="meetingCostsTotal" name="tacceptanceAccFundsA.meetingCostsTotal" value="<s:property value='%{tacceptanceAccFundsA.meetingCostsTotal}' escape='true'/>"/>
    <s:hidden id="meetingCostsTotal" name="tacceptanceAccFundsA.meetingCostsTotal" value="<s:property value='%{tacceptanceAccFundsA.meetingCostsTotal}' escape='true'"/></div></td>
    <td colspan="2"><div align="left"><INPUT type="text"  class="inputA" style="width:12em;" disabled="disabled" id="manageCostsTotal1" name="tacceptanceAccFundsA.manageCostsTotal1" value="<s:property value='%{tacceptanceAccFundsA.manageCostsTotal}' escape='true'/>"/>
    <s:hidden id="manageCostsTotal" name="tacceptanceAccFundsA.manageCostsTotal" value="<s:property value='%{tacceptanceAccFundsA.manageCostsTotal}' escape='true'"/></div></td>
    </tr>
  <tr>
    <td colspan="2"><div align="right"><FONT color=red>*</FONT>项目负责人签字</div></td>
    <td colspan="5"><div align="left"><INPUT type="text"  class="inputA" style="width:12em;" id="projectManager" name="tacceptanceAccFundsA.projectManager" value="<s:property value='%{tacceptanceAccFundsA.projectManager}' escape='true'/>"
    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'项目负责人签字',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddenprojectManager" name="hidden" value="项目负责人签字,1,-1"/></div></td>
    <td rowspan="2"><div align="right">项目单位盖章</div></td>
    <td colspan="2" rowspan="2">&nbsp;</td>
    </tr>
  <tr>
    <td colspan="2"><div align="right"><FONT color=red>*</FONT>项目单位负责人签字</div></td>
    <td colspan="5"><div align="left"><INPUT type="text"  class="inputA" style="width:12em;" id="unitManager" name="tacceptanceAccFundsA.unitManager" value="<s:property value='%{tacceptanceAccFundsA.unitManager}' escape='true'/>"
    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'项目单位负责人签字',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddenunitManager" name="hidden" value="项目单位负责人签字,1,-1"/></div></td>
    </tr>
  <tr>
     <td colspan="10"><div align="center" style="margin-top:5px; margin-bottom:5px;"><strong>经费支出决算（指甲方拨款）</strong></div></td>
    </tr>
  <tr>
    <td colspan="2"><div align="right"><FONT color=red>*</FONT>项目验收时间</div></td>
    <td colspan="2"><div align="left"><input class="txt w184p Wdate" type="text" id="acceptanceTime" name="tacceptanceAccFundsA.acceptanceTime" value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tacceptanceAccFundsA.acceptanceTime})}' />" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
    onblur="upms.upmsUtils.blurTextCheck(this,'项目验收时间',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>
    <s:hidden id="hiddenacceptanceTime" name="hidden" value="项目验收时间,1,-1"/></div></td>
    <td><div align="right"><FONT color=red>*</FONT>验收形式</div></td>
    <td colspan="2"><div align="left"><INPUT type="text"  class="inputA" style="width:12em;" id="acceptanceStyle" name="tacceptanceAccFundsA.acceptanceStyle" value="<s:property value='%{tacceptanceAccFundsA.acceptanceStyle}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'验收形式',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddenacceptanceStyle" name="hidden" value="验收形式,1,-1"/></div></td>
    <td><div align="right"><FONT color=red>*</FONT>验收结果</div></td>
    <td colspan="2"><div align="left"><INPUT type="text"  class="inputA" style="width:12em;" id="acceptanceResult" name="tacceptanceAccFundsA.acceptanceResult" value="<s:property value='%{tacceptanceAccFundsA.acceptanceResult}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'验收结果',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddenacceptanceResult" name="hidden" value="验收结果,1,-1"/></div></td>
    </tr>
  <tr>
    <td colspan="2"><div align="right"><FONT color=red>*</FONT>项目验收部门签字</div></td>
    <td colspan="8"><div align="left"><INPUT type="text"  class="inputA" style="width:12em;" id="acceptanceDepartment" name="tacceptanceAccFundsA.acceptanceDepartment" value="<s:property value='%{tacceptanceAccFundsA.acceptanceDepartment}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'项目验收部门签字',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddenacceptanceDepartment" name="hidden" value="项目验收部门签字,1,-1"/></div></td>
    </tr>
</table>
	<br/>
	<br/>
<div align="center">
	<input class="button save" name="nextBtn" id="nextBtn" type="button" href="javascript: void(0);" value="下一步"/>
</div>
</div>
</div>
</div>
</div>
</div>

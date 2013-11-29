<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/highTech/js/acceptance_a_info.js"></script>

<s:hidden id="acceptanceId" name="acceptanceId" value="%{acceptanceId}"></s:hidden>
<s:hidden id="acceptanceStatus" name="acceptanceStatus" value="%{acceptanceStatus}"></s:hidden>
<s:hidden id="implementationId" name="tacceptanceImplementationA.implementationId" value="%{tacceptanceImplementationA.implementationId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
	<div class="Servicel04">
		<div class="abuot02">
		<div class="abuot07">项目基本情况</div>
		<div class="abuot03">
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td  colspan="2" style="text-align:right">项目名称</td>
    <td  colspan="3"><s:property value='%{tacceptance.tprojectApplication.projectName}' escape='true'/></td>
  </tr>
  <tr>
    <td colspan="2" style="text-align:right">项目编号</td>
    <td width="304"><s:property value='%{tacceptance.tprojectApplication.projectNumber}' escape='true'/></td>
	<td width="177"  style="text-align:right">计划类别</td>
    <td width="292"><s:property value='%{tacceptance.tprojectApplication.planFlagName}' escape='true'/></td>
  </tr>
  <tr>
    <td colspan="2" style="text-align:right">项目负责人 </td>
    <td ><s:property value='%{tprojectInfoA.projectPerson}' escape='true'/></td>
	<td style="text-align:right">联系电话</td>
    <td><s:property value='%{tprojectInfoA.personTel}' escape='true'/></td>
  </tr>
  <tr>
    <td colspan="2" style="text-align:right">项目起始时间</td>
    <td ><s:date name="%{tacceptance.tprojectApplication.startTime}" format="yyyy年MM月dd日"/></td>
	<td style="text-align:right">完成时间</td>
    <td><s:date name="%{tacceptance.tprojectApplication.endTime}" format="yyyy年MM月dd日"/></td>
  </tr>
  <tr>
    <td width="104"  rowspan="4" style="text-align:right">项目<br>承担<br>单位</td>
    <td width="109" style="text-align:right">单位名称</td>
    <td colspan="3"><s:property value='%{tacceptance.tprojectApplication.applicationUnit}' escape='true'/></td>
  </tr>
  <tr>
    <td style="text-align:right">单位性质</td>
    <td><s:property value='%{tprojectInfoA.unitPropertiesName}' escape='true'/></td>
	<td style="text-align:right">隶属关系</td>
    <td><s:property value='%{tacceptance.tprojectApplication.centralizedTypeName}' escape='true'/></td>
  </tr>
    <tr>
    <td style="text-align:right">单位地址</td>
    <td colspan="3"><s:property value='%{tprojectInfoA.unitAddress}' escape='true'/></td>
  </tr>
  <tr>
    <td style="text-align:right">联系电话</td>
    <td><s:property value='%{tprojectInfoA.legalTel}' escape='true'/></td>
	<td style="text-align:right">邮政编码</td>
    <td><s:property value='%{tprojectInfoA.zipcode}' escape='true'/></td>
  </tr>
</table>
</div>
<br>
<br>
<div class="abuot07">项目经费落实和使用情况</div>
<div class="abuot03">
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td colspan="6" style="vertical-align:middle; height:40px;">
		<div>
			<div style="float:left; width:85%; text-align:center;"></div>
			<div style="float:right; width:15%;">单位：万元</div>
		</div>
    </td>
  </tr>
  <tr>
    <td colspan="3" align="center">项目经费到位情况</td>
    <td colspan="3" align="center">项目经费到位情况</td>
  </tr>
  <tr>
    <td width="12%"><div align="center">资金来源</div></td>
    <td width="14%"><div align="center">计划数</div></td>
    <td width="14%"><div align="center">实际数</div></td>
    <td width="21%"><div align="center">支出项目</div></td>
    <td width="21%"><div align="center">总经费使用情况</div></td>
    <td width="18%"><div align="center">市拨经费使用情况</div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>项目总经费</div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:8em;" id="planFundsTotalNum" name="tacceptanceImplementationA.planFundsTotalNum" value="<s:property value='%{tacceptanceImplementationA.planFundsTotalNum}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'项目总经费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenplanFundsTotalNum" name="hidden" value="项目总经费,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:8em;" id="actualFundsTotalNum" name="tacceptanceImplementationA.actualFundsTotalNum" value="<s:property value='%{tacceptanceImplementationA.actualFundsTotalNum}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'项目总经费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenactualFundsTotalNum" name="hidden" value="项目总经费,1,2"/></div></td>
    <td><div align="right"><FONT color=red>*</FONT>使用总额</div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:8em;" id="totalTotalCosts" name="tacceptanceImplementationA.totalTotalCosts" value="<s:property value='%{tacceptanceImplementationA.totalTotalCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'使用总额',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddentotalTotalCosts" name="hidden" value="使用总额,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:8em;" id="cityTotalCosts" name="tacceptanceImplementationA.cityTotalCosts" value="<s:property value='%{tacceptanceImplementationA.cityTotalCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'使用总额',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddencityTotalCosts" name="hidden" value="使用总额,1,2"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>市拨经费</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="planFundsCityNum" name="tacceptanceImplementationA.planFundsCityNum" value="<s:property value='%{tacceptanceImplementationA.planFundsCityNum}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'市拨经费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenplanFundsCityNum" name="hidden" value="市拨经费,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="actualFundsCityNum" name="tacceptanceImplementationA.actualFundsCityNum" value="<s:property value='%{tacceptanceImplementationA.actualFundsCityNum}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'市拨经费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenactualFundsCityNum" name="hidden" value="市拨经费,1,2"/></div></td>
    <td><div align="right"><FONT color=red>*</FONT>人员费</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="totalStaffCosts" name="tacceptanceImplementationA.totalStaffCosts" value="<s:property value='%{tacceptanceImplementationA.totalStaffCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'人员费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddentotalStaffCosts" name="hidden" value="人员费,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="cityStaffCosts" name="tacceptanceImplementationA.cityStaffCosts" value="<s:property value='%{tacceptanceImplementationA.cityStaffCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'人员费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddencityStaffCosts" name="hidden" value="人员费,1,2"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>企业自筹</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="planRaisedNum" name="tacceptanceImplementationA.planRaisedNum" value="<s:property value='%{tacceptanceImplementationA.planRaisedNum}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'企业自筹',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenplanRaisedNum" name="hidden" value="企业自筹,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="actualRaisedNum" name="tacceptanceImplementationA.actualRaisedNum" value="<s:property value='%{tacceptanceImplementationA.actualRaisedNum}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'企业自筹',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenactualRaisedNum" name="hidden" value="企业自筹,1,2"/></div></td>
    <td><div align="right"><FONT color=red>*</FONT>设备费</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="totalDeviceCosts" name="tacceptanceImplementationA.totalDeviceCosts" value="<s:property value='%{tacceptanceImplementationA.totalDeviceCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'设备费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddentotalDeviceCosts" name="hidden" value="设备费,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="cityDeviceCosts" name="tacceptanceImplementationA.cityDeviceCosts" value="<s:property value='%{tacceptanceImplementationA.cityDeviceCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'设备费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddencityDeviceCosts" name="hidden" value="设备费,1,2"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>银行贷款</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="planBankNum" name="tacceptanceImplementationA.planBankNum" value="<s:property value='%{tacceptanceImplementationA.planBankNum}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'银行贷款',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenplanBankNum" name="hidden" value="银行贷款,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="actualBankNum" name="tacceptanceImplementationA.actualBankNum" value="<s:property value='%{tacceptanceImplementationA.actualBankNum}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'银行贷款',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenactualBankNum" name="hidden" value="银行贷款,1,2"/></div></td>
    <td><div align="right"><FONT color=red>*</FONT>能源材料费</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="totalEnergyCosts" name="tacceptanceImplementationA.totalEnergyCosts" value="<s:property value='%{tacceptanceImplementationA.totalEnergyCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'能源材料费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddentotalEnergyCosts" name="hidden" value="能源材料费,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="cityEnergyCosts" name="tacceptanceImplementationA.cityEnergyCosts" value="<s:property value='%{tacceptanceImplementationA.cityEnergyCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'能源材料费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddencityEnergyCosts" name="hidden" value="能源材料费,1,2"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>贷款贴息</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="planLoanInterestNum" name="tacceptanceImplementationA.planLoanInterestNum" value="<s:property value='%{tacceptanceImplementationA.planLoanInterestNum}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'贷款贴息',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenplanLoanInterestNum" name="hidden" value="贷款贴息,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="actualLoanInterestNum" name="tacceptanceImplementationA.actualLoanInterestNum" value="<s:property value='%{tacceptanceImplementationA.actualLoanInterestNum}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'贷款贴息',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenactualLoanInterestNum" name="hidden" value="贷款贴息,1,2"/></div></td>
    <td><div align="right"><FONT color=red>*</FONT>试验外协费</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="totalExperimentCosts" name="tacceptanceImplementationA.totalExperimentCosts" value="<s:property value='%{tacceptanceImplementationA.totalExperimentCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'试验外协费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddentotalExperimentCosts" name="hidden" value="试验外协费,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="cityExperimentCosts" name="tacceptanceImplementationA.cityExperimentCosts" value="<s:property value='%{tacceptanceImplementationA.cityExperimentCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'试验外协费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddencityExperimentCosts" name="hidden" value="试验外协费,1,2"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>其他拨款</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="planOtherNum" name="tacceptanceImplementationA.planOtherNum" value="<s:property value='%{tacceptanceImplementationA.planOtherNum}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'其他拨款',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenplanOtherNum" name="hidden" value="其他拨款,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="actualOtherNum" name="tacceptanceImplementationA.actualOtherNum" value="<s:property value='%{tacceptanceImplementationA.actualOtherNum}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'其他拨款',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenactualOtherNum" name="hidden" value="其他拨款,1,2"/></div></td>
    <td><div align="right"><FONT color=red>*</FONT>调研费</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="totalResearchCosts" name="tacceptanceImplementationA.totalResearchCosts" value="<s:property value='%{tacceptanceImplementationA.totalResearchCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'调研费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddentotalResearchCosts" name="hidden" value="调研费,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="cityResearchCosts" name="tacceptanceImplementationA.cityResearchCosts" value="<s:property value='%{tacceptanceImplementationA.cityResearchCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'调研费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddencityResearchCosts" name="hidden" value="调研费,1,2"/></div></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><div align="right"><FONT color=red>*</FONT>差旅费</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="totalTravelCosts" name="tacceptanceImplementationA.totalTravelCosts" value="<s:property value='%{tacceptanceImplementationA.totalTravelCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'差旅费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddentotalTravelCosts" name="hidden" value="差旅费,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="cityTravelCosts" name="tacceptanceImplementationA.cityTravelCosts" value="<s:property value='%{tacceptanceImplementationA.cityTravelCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'差旅费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddencityTravelCosts" name="hidden" value="差旅费,1,2"/></div></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><div align="right"><FONT color=red>*</FONT>会议费</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="totalMeetingCosts" name="tacceptanceImplementationA.totalMeetingCosts" value="<s:property value='%{tacceptanceImplementationA.totalMeetingCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'会议费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddentotalMeetingCosts" name="hidden" value="会议费,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="cityMeetingCosts" name="tacceptanceImplementationA.cityMeetingCosts" value="<s:property value='%{tacceptanceImplementationA.cityMeetingCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'会议费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddencityMeetingCosts" name="hidden" value="会议费,1,2"/></div></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><div align="right"><FONT color=red>*</FONT>管理费</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="totalManageCosts" name="tacceptanceImplementationA.totalManageCosts" value="<s:property value='%{tacceptanceImplementationA.totalManageCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'管理费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddentotalManageCosts" name="hidden" value="管理费,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="cityManageCosts" name="tacceptanceImplementationA.cityManageCosts" value="<s:property value='%{tacceptanceImplementationA.cityManageCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'管理费',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddencityManageCosts" name="hidden" value="管理费,1,2"/></div></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><div align="right"><FONT color=red>*</FONT>其它</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="totalOtherCosts" name="tacceptanceImplementationA.totalOtherCosts" value="<s:property value='%{tacceptanceImplementationA.totalOtherCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'其它',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddentotalOtherCosts" name="hidden" value="其它,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="cityOtherCosts" name="tacceptanceImplementationA.cityOtherCosts" value="<s:property value='%{tacceptanceImplementationA.cityOtherCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'其它',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddencityOtherCosts" name="hidden" value="其它,1,2"/></div></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><div align="right"><FONT color=red>*</FONT>其中研发经费支出</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="totalRdCosts" name="tacceptanceImplementationA.totalRdCosts" value="<s:property value='%{tacceptanceImplementationA.totalRdCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'其中研发经费支出',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddentotalRdCosts" name="hidden" value="其中研发经费支出,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:8em;" id="cityRdCosts" name="tacceptanceImplementationA.cityRdCosts" value="<s:property value='%{tacceptanceImplementationA.cityRdCosts}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'其中研发经费支出',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddencityRdCosts" name="hidden" value="其中研发经费支出,1,2"/></div></td>
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

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/highTech/js/acceptance_a_funds.js"></script>

<s:hidden id="acceptanceId" name="acceptanceId" value="%{acceptanceId}"></s:hidden>
<s:hidden id="acceptanceStatus" name="acceptanceStatus" value="%{acceptanceStatus}"></s:hidden>
<s:hidden id="fundsId" name="tacceptanceFundsA.fundsId" value="%{tacceptanceFundsA.fundsId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
	<div class="Servicel04">
		<div class="abuot02">
		<div class="abuot07">企业获得国家或省市其他资金支持情况</div>
		<div class="abuot03">
	<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td width="19%"><div align="center"><FONT color=red>*</FONT>年度</div></td>
    <td width="51%"><div align="center"><FONT color=red>*</FONT>计划或专项名称</div></td>
    <td width="30%"><div align="center"><FONT color=red>*</FONT>资金额度（万元）</div></td>
  </tr>
  <tr>
    <td><div align="left"><input class="txt w184p Wdate" type="text" id="fundsYear1" name="tacceptanceFundsA.fundsYear1" value="<s:property value='%{tacceptanceFundsA.fundsYear1}' escape='true'/>" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy'})" onblur="upms.upmsUtils.blurTextCheck(this,'年度',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>
    <s:hidden id="hiddenfundsYear1" name="hidden" value="年度,1,-1"/></div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:25em;" id="fundsPlanname1" name="tacceptanceFundsA.fundsPlanname1" value="<s:property value='%{tacceptanceFundsA.fundsPlanname1}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'计划或专项名称',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>
    <s:hidden id="hiddenfundsPlanname1" name="hidden" value="计划或专项名称,1,-1"/></div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:10em;" id="fundsAmount1" name="tacceptanceFundsA.fundsAmount1" value="<s:property value='%{tacceptanceFundsA.fundsAmount1}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'资金额度',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenfundsAmount1" name="hidden" value="资金额度,1,2"/></div></td>
  </tr>
  <tr>
    <td><div align="left"><input class="txt w184p Wdate" type="text" id="fundsYear2" name="tacceptanceFundsA.fundsYear2" value="<s:property value='%{tacceptanceFundsA.fundsYear2}' escape='true'/>" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy'})" onblur="upms.upmsUtils.blurTextCheck(this,'年度',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>
    <s:hidden id="hiddenfundsYear2" name="hidden" value="年度,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:25em;" id="fundsPlanname2" name="tacceptanceFundsA.fundsPlanname2" value="<s:property value='%{tacceptanceFundsA.fundsPlanname2}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'计划或专项名称',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>
    <s:hidden id="hiddenfundsPlanname2" name="hidden" value="计划或专项名称,1,-1"/></div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:10em;" id="fundsAmount2" name="tacceptanceFundsA.fundsAmount2" value="<s:property value='%{tacceptanceFundsA.fundsAmount2}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'资金额度',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenfundsAmount2" name="hidden" value="资金额度,1,2"/></div></td>
  </tr>
  <tr>
    <td><div align="left"><input class="txt w184p Wdate" type="text" id="fundsYear3" name="tacceptanceFundsA.fundsYear3" value="<s:property value='%{tacceptanceFundsA.fundsYear3}' escape='true'/>" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy'})" onblur="upms.upmsUtils.blurTextCheck(this,'年度',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>
    <s:hidden id="hiddenfundsYear3" name="hidden" value="年度,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:25em;" id="fundsPlanname3" name="tacceptanceFundsA.fundsPlanname3" value="<s:property value='%{tacceptanceFundsA.fundsPlanname3}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'计划或专项名称',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>
    <s:hidden id="hiddenfundsPlanname3" name="hidden" value="计划或专项名称,1,-1"/></div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:10em;" id="fundsAmount3" name="tacceptanceFundsA.fundsAmount3" value="<s:property value='%{tacceptanceFundsA.fundsAmount3}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'资金额度',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenfundsAmount3" name="hidden" value="资金额度,1,2"/></div></td>
  </tr>
  <tr>
    <td><div align="left"><input class="txt w184p Wdate" type="text" id="fundsYear4" name="tacceptanceFundsA.fundsYear4" value="<s:property value='%{tacceptanceFundsA.fundsYear4}' escape='true'/>" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy'})" onblur="upms.upmsUtils.blurTextCheck(this,'年度',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>
    <s:hidden id="hiddenfundsYear4" name="hidden" value="年度,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:25em;" id="fundsPlanname4" name="tacceptanceFundsA.fundsPlanname4" value="<s:property value='%{tacceptanceFundsA.fundsPlanname4}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'计划或专项名称',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddenfundsPlanname4" name="hidden" value="计划或专项名称,1,-1"/></div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:10em;" id="fundsAmount4" name="tacceptanceFundsA.fundsAmount4" value="<s:property value='%{tacceptanceFundsA.fundsAmount4}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'资金额度',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenfundsAmount4" name="hidden" value="资金额度,1,2"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>项目产业化进展情况<br>（包括新建厂房，新建生产线、<br>新增研发设备、示范推广、<br>产学研合作等情况）</div></td>
    <td colspan="2"><div align="left"><textarea id="transformationCase" name="tacceptanceFundsA.transformationCase" cols="100" rows="8" class="inputA" style="height:100px; width:630px;"><s:property value='%{tacceptanceFundsA.transformationCase}' escape='true'/></textarea></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>项目实施管理、团队培养情况<br>（包括项目管理机构、机制建立、<br>检查督促等情况，<br>国内外高层次人才引进、<br>员工培养情况）</div></td>
    <td colspan="2"><div align="left"><textarea id="teamTrainingSituation" name="tacceptanceFundsA.teamTrainingSituation" cols="100" rows="8" class="inputA" style="height:100px; width:630px;"><s:property value='%{tacceptanceFundsA.teamTrainingSituation}' escape='true'/></textarea></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>项目社会效益说明<br>（包括新增就业人数以及<br>项目实施对于企业发展、<br>产业创新和社会进步<br>等方面的贡献）</div></td>
    <td colspan="2"><div align="left"><textarea id="socialBenefitsDescription" name="tacceptanceFundsA.socialBenefitsDescription" cols="100" rows="8" class="inputA" style="height:100px; width:630px;"><s:property value='%{tacceptanceFundsA.socialBenefitsDescription}' escape='true'/></textarea></div></td>
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

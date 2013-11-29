<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/highTech/js/acceptance_a_main_modify.js"></script>

<!-- 保存按钮提示信息 -->
<s:hidden id="acceptanceId" name="acceptanceId" value="%{acceptanceId}"></s:hidden>
<s:hidden id="acceptanceStatus" name="acceptanceStatus" value="%{acceptanceStatus}"></s:hidden>
<s:hidden id="participateId" name="tacceptanceMainA.participateId" value="%{tacceptanceMainA.participateId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: center;">
	<div class="Servicel04">
		<div class="abuot02">
		<div class="abuot07">项目主要参加人员_查看</div>
		<div class="abuot03">
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>姓名</div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:10em;" id="name" name="tacceptanceMainA.name" value="<s:property value='%{tacceptanceMainA.name}' escape='true'/>"
    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'姓名',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddenname" name="hidden" value="姓名,1,-1"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>性别</div></td>
    <td><div align="left">
	<select id="sex" name="tacceptanceMainA.sex" style="width:10.5em;">
		<option value="1">男</option>
		<option value="2">女</option>
	</select>
	<s:hidden id="sexValue" name="sexValue" value="%{tacceptanceMainA.sex}"/><s:hidden id="hiddensex" name="hidden" value="性别"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>出生年月</div></td>
    <td><div align="left"><input class="txt w184p Wdate" type="text" id="birthday1" name="tacceptanceMainA.birthday1" value="<s:property value='%{getText("{0,date,yyyy-MM}",{tacceptanceMainA.birthday})}' />" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy-MM'})" onblur="upms.upmsUtils.blurTextCheck(this,'出生年月',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>
    <s:hidden id="birthday" name="tacceptanceMainA.birthday"/><s:hidden id="hiddenbirthday1" name="hidden" value="出生年月,1,-1"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>技术职称</div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:10em;" id="technicalTitles" name="tacceptanceMainA.technicalTitles" value="<s:property value='%{tacceptanceMainA.technicalTitles}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'技术职称',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddentechnicalTitles" name="hidden" value="技术职称,1,-1"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>文化程度</div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:10em;" id="educationLevel" name="tacceptanceMainA.educationLevel" value="<s:property value='%{tacceptanceMainA.educationLevel}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'文化程度',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddeneducationLevel" name="hidden" value="文化程度,1,-1"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>工作单位</div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:10em;" id="workUnits" name="tacceptanceMainA.workUnits" value="<s:property value='%{tacceptanceMainA.workUnits}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'工作单位',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddenworkUnits" name="hidden" value="工作单位,1,-1"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>在项目中完成的主要工作</div></td>
    <td><div align="left"><INPUT type="text"  class="inputA" style="width:10em;" id="mainDuties" name="tacceptanceMainA.mainDuties" value="<s:property value='%{tacceptanceMainA.mainDuties}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'在项目中完成的主要工作',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddenmainDuties" name="hidden" value="在项目中完成的主要工作,1,-1"/></div></td>
  </tr>
</table>
	<br/>
<div align="center">
	<input class="button save" name="backBtn" id="backBtn" type="button" href="javascript: void(0);" value="返回"/>
</div>
</div>
</div>
</div>
</div>
</div>

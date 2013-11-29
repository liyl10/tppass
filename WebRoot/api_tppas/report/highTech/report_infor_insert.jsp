<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/highTech/js/report_infor_insert.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
<div class="Servicel04">
<div class="abuot02">
<div class="abuot07">项目基本信息</div>
<s:hidden id="projectInfoId" name="tprojectInfoa.projectInfoId" value="%{tprojectInfoa.projectInfoId}"></s:hidden>
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<div class=requirecolor id="errInfo"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm">
<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right">项目名称</td>
	<td style="padding: 4px 8px; text-align: left" colspan="5">
	<input class="inputA" type="text" style="width: 14.5em;" 
		value="<s:property value='%{tprojectApplication.projectName}' escape='true'/>" readonly="readonly"/>
	</td>

</tr>
<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right">承担单位</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2">
	<input class="inputA" type="text" style="width: 14.5em;" 
		value="<s:property value='%{tprojectApplication.applicationUnit}' escape='true'/>" readonly="readonly"/>
	</td>
	<td width="11%" style="padding: 4px 3px; text-align:right">归口管理部门</td>
	 <td style="padding: 4px 8px; text-align: left" colspan="2">
 	 	<input class="inputA" id="centralizedType" name="tprojectInfoa.centralizedType" type="text" style="width: 10em;" 
		value="<s:property value='%{centralizedType}' escape='true'/>" readonly="readonly"/>
	</td>
</tr>
<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>所在区域</td>
	<td colspan="5" style="padding: 4px 8px; text-align: left">
		<div><s:select style="width:12em;" list="regionId1List" label="abc" listKey="itemId"
		listValue="itemName" id="regionId1" name="tprojectInfoa.regionId1" 
		value="%{tprojectInfoa.regionId1}"></s:select>
		<s:select style="width:12em;" list="regionId2List" label="abc" listKey="itemId"
		listValue="itemName" id="regionId2" name="tprojectInfoa.regionId2" value="%{tprojectInfoa.regionId2}"></s:select>
		<s:select style="width:12em;" list="regionId3List" label="abc" listKey="itemId"
		listValue="itemName" id="regionId3" name="tprojectInfoa.regionId3" value="%{tprojectInfoa.regionId3}"></s:select>
		</div>
		<s:hidden id="hiddenregionId3" name="hidden" value="所在区域级联"></s:hidden>	 
		<s:hidden id="regionId1Value" name="regionId1" value="%{tprojectInfoa.regionId1}"></s:hidden>
		<s:hidden id="regionId2Value" name="regionId2" value="%{tprojectInfoa.regionId2}"></s:hidden>
		<s:hidden id="regionId3Value" name="regionId3" value="%{tprojectInfoa.regionId3}"></s:hidden>
	</td>
	</tr>
	<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>单位地址</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2">
		<input  class="inputA" id="unitAddress" name="tprojectInfoa.unitAddress" type="text" style="width: 24em;" 
		value="<s:property value='%{unitAddress}' escape='true'/>" 
		 maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'单位地址',1,-1)"
		onfocus="upms.upmsUtils.textFocus(this);"/>
	</td><s:hidden id="hiddenunitAddress" name="hidden" value="单位地址,1,-1"></s:hidden>	 
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>邮编</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2">
		<input  class="inputA" id="zipcode" name="tprojectInfoa.zipcode" type="text" style="width: 8.5em;" 
		value="<s:property value='%{zipcode}' escape='true'/>"
		maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'邮编',1,6)"
		onfocus="upms.upmsUtils.textFocus(this);"/>
	</td><s:hidden id="hiddenzipcode" name="hidden" value="邮编,1,6"></s:hidden>	
	</tr>
	<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>单位所属行业领域</td>
	<td colspan="5" style="padding: 4px 8px; text-align: left">
		<div><s:select style="width:12em;" list="industries1List" label="abc" listKey="itemId"
		listValue="itemName" id="industries1" name="tprojectInfoa.industries1" 
		value="%{tprojectInfoa.industries1}"></s:select>
		<s:select style="width:12em;" list="industries2List" label="abc" listKey="itemId"
		listValue="itemName" id="industries2" name="tprojectInfoa.industries2" value="%{tprojectInfoa.industries2}"></s:select>
		<s:select style="width:12em;" list="industries3List" label="abc" listKey="itemId"
		listValue="itemName" id="industries3" name="tprojectInfoa.industries3" value="%{tprojectInfoa.industries3}"></s:select>
		<s:select style="width:12em;" list="industries4List" label="abc" listKey="itemId"
		listValue="itemName" id="industries4" name="tprojectInfoa.industries4" value="%{tprojectInfoa.industries4}"></s:select>
		</div>
		<s:hidden id="hiddenindustries4" name="hidden" value="国民经济行业分类级联"></s:hidden>	 
		<s:hidden id="industries1Value" name="industries1" value="%{tprojectInfoa.industries1}"></s:hidden>		
		<s:hidden id="industries2Value" name="industries2" value="%{tprojectInfoa.industries2}"></s:hidden>		
		<s:hidden id="industries3Value" name="industries3" value="%{tprojectInfoa.industries3}"></s:hidden>		
		<s:hidden id="industries4Value" name="industries4" value="%{tprojectInfoa.industries4}"></s:hidden>		
	</td>
</tr>
<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>单位性质</td>
	<td style="padding: 4px 8px; text-align: left" colspan="5">
		<s:select style="width:12em;" list="unitPropertiesList" label="abc" listKey="itemId"
			listValue="itemName" id="unitProperties" name="tprojectInfoa.unitProperties" 
			value="%{tprojectInfoa.unitProperties}" onblur="upms.upmsUtils.blurTextCheck(this,'单位性质');" onfocus="upms.upmsUtils.textFocus(this);"></s:select>
			<s:hidden id="unitPropertiesValue" value="%{tprojectInfoa.unitProperties}"></s:hidden>
	</td><s:hidden id="hiddenunitProperties" name="hidden" value="单位性质"></s:hidden>	
</tr>
<!-- start liyl -->
<!-- <tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>法定代表人</td>
	<td style="padding: 4px 8px; text-align: left">
		<input class="inputA" id="legalPerson" name="tprojectInfoa.legalPerson" type="text" style="width: 12em;"
		value="<s:property value='%{legalPerson}' escape='true'/>"
		maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'法定代表人',1,-1)"
		onfocus="upms.upmsUtils.textFocus(this);"/>
	</td><s:hidden id="hiddenlegalPerson" name="hidden" value="法定代表人,1,-1"></s:hidden>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>联系电话</td>
	<td style="padding: 4px 8px; text-align: left">
		<input class="inputA" id="legalTel" name="tprojectInfoa.legalTel" type="text" style="width: 10em;"
		value="<s:property value='%{tprojectInfoa.legalTel}' escape='true'/>" 
		maxlength="13" onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',1,1)"
		onfocus="upms.upmsUtils.textFocus(this);"/></td>
		<s:hidden id="hiddenlegalTel" name="hidden" value="联系电话,1,1"></s:hidden>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>手机</td>
	<td style="padding: 4px 8px; text-align: left">
		<input class="inputA" id="legalPhone" name="tprojectInfoa.legalPhone" type="text" style="width: 10em;"
		value="<s:property value='%{tprojectInfoa.legalPhone}' escape='true'/>"
		maxlength="11" onblur="upms.upmsUtils.blurTextCheck(this,'手机',1,0)"
		onfocus="upms.upmsUtils.textFocus(this);"/></td>
		<s:hidden id="hiddenlegalPhone" name="hidden" value="手机,1,0"></s:hidden>
</tr>
<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>项目负责人</td>
	<td style="padding: 4px 8px; text-align: left">
		<input class="inputA" id="projectPerson" name="tprojectInfoa.projectPerson" type="text" style="width: 12em;"
		value="<s:property value='%{tprojectInfoa.projectPerson}' escape='true'/>"
		maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'项目负责人',1,-1)"
		onfocus="upms.upmsUtils.textFocus(this);"/>
	</td><s:hidden id="hiddenprojectPerson" name="hidden" value="项目负责人,1,-1"></s:hidden>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>联系电话</td>
	<td style="padding: 4px 8px; text-align: left">
		<input class="inputA" id="personTel" name="tprojectInfoa.personTel" type="text" style="width: 10em;"
		value="<s:property value='%{tprojectInfoa.personTel}' escape='true'/>"
		maxlength="13" onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',1,1)"
		onfocus="upms.upmsUtils.textFocus(this);"/>
	</td><s:hidden id="hiddenpersonTel" name="hidden" value="联系电话,1,1"></s:hidden>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>手机</td>
	<td style="padding: 4px 8px; text-align: left">
		<input class="inputA" id="personPhone" name="tprojectInfoa.personPhone" type="text" style="width: 10em;"
		value="<s:property value='%{tprojectInfoa.personPhone}' escape='true'/>"
		maxlength="11" onblur="upms.upmsUtils.blurTextCheck(this,'手机',1,0)"
		onfocus="upms.upmsUtils.textFocus(this);"/>
	</td><s:hidden id="hiddenpersonPhone" name="hidden" value="手机,1,0"></s:hidden>
</tr>
<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>项目联系人</td>
	<td style="padding: 4px 8px; text-align: left">
		<input class="inputA" id="touchPerson" name="tprojectInfoa.touchPerson" type="text" style="width: 12em;"
		value="<s:property value='%{tprojectInfoa.touchPerson}' escape='true'/>"
		maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'项目联系人',1,-1)"
		onfocus="upms.upmsUtils.textFocus(this);"/>
	</td><s:hidden id="hiddentouchPerson" name="hidden" value="项目联系人,1,-1"></s:hidden>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>联系电话</td>
	<td style="padding: 4px 8px; text-align: left">
		<input class="inputA" id="touchPhone" name="tprojectInfoa.touchPhone" type="text" style="width: 10em;"
		value="<s:property value='%{tprojectInfoa.touchPhone}' escape='true'/>"
		maxlength="13" onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',1,1)"
		onfocus="upms.upmsUtils.textFocus(this);"/>
	</td><s:hidden id="hiddentouchPhone" name="hidden" value="联系电话,1,1"></s:hidden>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>手机</td>
	<td style="padding: 4px 8px; text-align: left">
		<input class="inputA" id="touchIdcard" name="tprojectInfoa.touchIdcard" type="text" style="width: 10em;"
		value="<s:property value='%{tprojectInfoa.touchIdcard}' escape='true'/>"
		maxlength="11" onblur="upms.upmsUtils.blurTextCheck(this,'手机',1,0)"
		onfocus="upms.upmsUtils.textFocus(this);"/>
	</td><s:hidden id="hiddentouchIdcard" name="hidden" value="手机,1,0"></s:hidden>
</tr>
 -->
 <tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>法定代表人</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2">
		<input class="inputA" id="legalPerson" name="tprojectInfoa.legalPerson" type="text" style="width: 12em;"
		value="<s:property value='%{legalPerson}' escape='true'/>"
		maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'法定代表人',0,-1)"
		onfocus="upms.upmsUtils.textFocus(this);" readFlag="1"/>
	</td><s:hidden id="hiddenlegalPerson" name="hidden" value="法定代表人,0,-1"></s:hidden>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>电话</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2">
		<input class="inputA" id="legalTel" name="tprojectInfoa.legalTel" type="text" style="width: 12em;"
		value="<s:property value='%{tprojectInfoa.legalTel}' escape='true'/>" 
		maxlength="13" onblur="upms.upmsUtils.blurTextCheck(this,'电话',0,-1)"
		onfocus="upms.upmsUtils.textFocus(this);" readFlag="1"/></td>
		<s:hidden id="hiddenlegalTel" name="hidden" value="电话,0,-1"></s:hidden>
	
</tr>
<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>手机</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2" width="35%">
		<input class="inputA" id="legalPhone" name="tprojectInfoa.legalPhone" type="text" style="width: 12em;"
		value="<s:property value='%{tprojectInfoa.legalPhone}' escape='true'/>"
		maxlength="11" onblur="upms.upmsUtils.blurTextCheck(this,'手机',0,-1)"
		onfocus="upms.upmsUtils.textFocus(this);" readFlag="1"/></td>
		<s:hidden id="hiddenlegalPhone" name="hidden" value="手机,0,-1"></s:hidden>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>E-mail</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2" width="33%">
		<input class="inputA" id="legalEmail" name="tprojectInfoa.legalEmail" type="text" style="width: 12em;"
		value="<s:property value='%{tprojectInfoa.legalEmail}' escape='true'/>"
		maxlength="11" onblur="upms.upmsUtils.blurTextCheck(this,'E-mail',0,-1)"
		onfocus="upms.upmsUtils.textFocus(this);"  readFlag="1"/></td>
		<s:hidden id="hiddenlegalEmail" name="hidden" value="E-mail,0,-1"></s:hidden>
</tr>
<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>项目负责人</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2">
		<input class="inputA" id="projectPerson" name="tprojectInfoa.projectPerson" type="text" style="width: 12em;"
		value="<s:property value='%{tprojectInfoa.projectPerson}' escape='true'/>"
		maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'项目负责人',0,-1)"
		onfocus="upms.upmsUtils.textFocus(this);"  readFlag="1"/>
	</td><s:hidden id="hiddenprojectPerson" name="hidden" value="项目负责人,0,-1"></s:hidden>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>电话</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2">
		<input class="inputA" id="personTel" name="tprojectInfoa.personTel" type="text" style="width: 12em;"
		value="<s:property value='%{tprojectInfoa.personTel}' escape='true'/>"
		maxlength="13" onblur="upms.upmsUtils.blurTextCheck(this,'电话',0,-1)"
		onfocus="upms.upmsUtils.textFocus(this);"  readFlag="1"/>
	</td><s:hidden id="hiddenpersonTel" name="hidden" value="电话,0,-1"></s:hidden>
	
</tr>
<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>手机</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2">
		<input class="inputA" id="personPhone" name="tprojectInfoa.personPhone" type="text" style="width: 12em;"
		value="<s:property value='%{tprojectInfoa.personPhone}' escape='true'/>"
		maxlength="11" onblur="upms.upmsUtils.blurTextCheck(this,'手机',0,-1)"
		onfocus="upms.upmsUtils.textFocus(this);"  readFlag="1"/>
	</td><s:hidden id="hiddenpersonPhone" name="hidden" value="手机,0,-1"></s:hidden>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>E-mail</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2">
		<input class="inputA" id="personEmail" name="tprojectInfoa.personEmail" type="text" style="width: 12em;"
		value="<s:property value='%{tprojectInfoa.personEmail}' escape='true'/>"
		maxlength="11" onblur="upms.upmsUtils.blurTextCheck(this,'E-mail',0,-1)"
		onfocus="upms.upmsUtils.textFocus(this);"  readFlag="1"/>
	</td><s:hidden id="hiddenpersonEmail" name="hidden" value="E-mail,0,-1"></s:hidden>
</tr>
<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>项目联系人</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2">
		<input class="inputA" id="touchPerson" name="tprojectInfoa.touchPerson" type="text" style="width: 12em;"
		value="<s:property value='%{tprojectInfoa.touchPerson}' escape='true'/>"
		maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'项目联系人',0,-1)"
		onfocus="upms.upmsUtils.textFocus(this);" readFlag="1"/>
	</td><s:hidden id="hiddentouchPerson" name="hidden" value="项目联系人,0,-1"></s:hidden>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>电话</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2">
		<input class="inputA" id="touchPhone" name="tprojectInfoa.touchPhone" type="text" style="width: 12em;"
		value="<s:property value='%{tprojectInfoa.touchPhone}' escape='true'/>"
		maxlength="13" onblur="upms.upmsUtils.blurTextCheck(this,'电话',0,-1)"
		onfocus="upms.upmsUtils.textFocus(this);" readFlag="1"/>
	</td><s:hidden id="hiddentouchPhone" name="hidden" value="电话,0,-1"></s:hidden>

</tr>
<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>手机</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2">
		<input class="inputA" id="touchIdcard" name="tprojectInfoa.touchIdcard" type="text" style="width: 12em;"
		value="<s:property value='%{tprojectInfoa.touchIdcard}' escape='true'/>"
		maxlength="11" onblur="upms.upmsUtils.blurTextCheck(this,'手机',0,-1)"
		onfocus="upms.upmsUtils.textFocus(this);" readFlag="1"/>
	</td><s:hidden id="hiddentouchIdcard" name="hidden" value="手机,0,-1"></s:hidden>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>E-mail</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2">
		<input class="inputA" id="touchEmail" name="tprojectInfoa.touchEmail" type="text" style="width: 12em;"
		value="<s:property value='%{tprojectInfoa.touchEmail}' escape='true'/>"
		maxlength="11" onblur="upms.upmsUtils.blurTextCheck(this,'E-mail',0,-1)"
		onfocus="upms.upmsUtils.textFocus(this);" readFlag="1"/>
	</td><s:hidden id="hiddentouchEmail" name="hidden" value="E-mail,0,-1"></s:hidden>
</tr>
<!-- end liyl -->
<tr>
	<!-- Start 2013/10/06 业务变更 wanglw -->
	<%-- <td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>项目主要协作单位</td>
	<td colspan="5" style="padding: 4px 8px; text-align: left">
		<input class="inputA" id="assistUnit" name="tprojectInfoa.assistUnit" type="text" style="width: 24em;"
		value="<s:property value='%{tprojectInfoa.assistUnit}' escape='true'/>"
		maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'项目主要协作单位',1,-1)"
		onfocus="upms.upmsUtils.textFocus(this);"/>
	</td><s:hidden id="hiddenassistUnit" name="hidden" value="项目主要协作单位,1,-1"></s:hidden> --%>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>项目主要协作单位1</td>
	<td colspan="2" style="padding: 4px 8px; text-align: left">
		<input class="inputA" id="assistUnit" name="tprojectInfoa.assistUnit" type="text" style="width: 24em;"
		value="<s:property value='%{tprojectInfoa.assistUnit}' escape='true'/>"
		maxlength="20" 
		/>
	</td>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>项目主要协作单位2</td>
	<td colspan="2" style="padding: 4px 8px; text-align: left">
		<input class="inputA" id="assistUnit1" name="tprojectInfoa.assistUnit1" type="text" style="width: 24em;"
		value="<s:property value='%{tprojectInfoa.assistUnit1}' escape='true'/>"
		maxlength="20" 
		/>
	<!-- End 2013/10/06 业务变更 wanglw -->
</tr>
<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><font color=red>*</font>项目所属技术领域</td>
	<td colspan="5" style="padding: 4px 8px; text-align: left">
		<div>
			<s:select style="width:12em;" list="technicalFisldList1" label="abc" listKey="itemId" listValue="itemName" id="technicalFisld1" name="tprojectInfoa.technicalFisld1" value="%{tprojectInfoa.technicalFisld1}"></s:select>
			<s:select style="width:12em;" list="technicalFisldList2" label="abc" listKey="itemId" listValue="itemName" id="technicalFisld2" name="tprojectInfoa.technicalFisld2" value="%{tprojectInfoa.technicalFisld2}"></s:select>
			<s:select style="width:12em;" list="technicalFisldList3" label="abc" listKey="itemId" listValue="itemName" id="technicalFisld3" name="tprojectInfoa.technicalFisld3" value="%{tprojectInfoa.technicalFisld3}"></s:select>
		</div>
		<s:hidden id="hiddentechnicalFisld3" name="hidden" value="项目所属技术领域"></s:hidden>	 
		<s:hidden id="technicalFisld1Value" name="technicalFisld1" value="%{tprojectInfoa.technicalFisld1}"></s:hidden>		
		<s:hidden id="technicalFisld2Value" name="technicalFisld2" value="%{tprojectInfoa.technicalFisld2}"></s:hidden>		
		<s:hidden id="technicalFisld3Value" name="technicalFisld3" value="%{tprojectInfoa.technicalFisld3}"></s:hidden>	
	</td>
	
</tr>
<tr>
	<td rowspan="4"  width="11%" style="padding: 4px 3px; text-align:right">企业资产与<br />经营状况<br />（万元）<br />（${zcjyYear }年度）</td>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>流动资金</td>
	<td style="padding: 4px 8px; text-align: left">
		<input class="inputA" id="circulatingFund" name="tprojectInfoa.circulatingFund" type="text" style="width: 10em;ime-mode: disabled;"
		value="<s:property value='%{tprojectInfoa.circulatingFund}' escape='true'/>"
		maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'流动资金',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
	</td><s:hidden id="hiddencirculatingFund" name="hidden" value="流动资金,1,2"></s:hidden>
	
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>固定资产</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2">
		<input class="inputA" id="fastenFund" name="tprojectInfoa.fastenFund" type="text" style="width: 10em;ime-mode: disabled;"
		value="<s:property value='%{tprojectInfoa.fastenFund}' escape='true'/>"
		maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'固定资产',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
	</td><s:hidden id="hiddenfastenFund" name="hidden" value="固定资产,1,2"></s:hidden>
	
</tr>
<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>总销售收入</td>
	<td style="padding: 4px 8px; text-align: left">
		<input class="inputA" id="totalValue" name="tprojectInfoa.totalValue" type="text" style="width: 10em;ime-mode: disabled;"
		value="<s:property value='%{tprojectInfoa.totalValue}' escape='true'/>"
		maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'总销售收入',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
	</td><s:hidden id="hiddentotalValue" name="hidden" value="总销售收入,1,2"></s:hidden>
	
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>资产负债率%</td>
	<td  style="padding: 4px 8px; text-align: left" colspan="2">
		<input class="inputA" id="debtRatio" name="tprojectInfoa.debtRatio" type="text" style="width: 10em;ime-mode: disabled;"
		value="<s:property value='%{tprojectInfoa.debtRatio}' escape='true'/>"
		maxlength="5" onblur="upms.upmsUtils.blurTextCheck(this,'资产负债率',1,5);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
	</td><s:hidden id="hiddendebtRatio" name="hidden" value="资产负债率,1,5"></s:hidden>
</tr>
<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>总收入</td>
	<td style="padding: 4px 8px; text-align: left"> 
		<input class="inputA" id="grossIncome" name="tprojectInfoa.grossIncome" type="text" style="width: 10em;ime-mode: disabled;"
		value="<s:property value='%{tprojectInfoa.grossIncome}' escape='true'/>"
		maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'总收入',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"
		onkeypress="return IsFloatNum(event,this)"/>
	</td><s:hidden id="hiddengrossIncome" name="hidden" value="总收入,1,2"></s:hidden>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>净利润</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2">
		<input class="inputA" id="retainedProfits" name="tprojectInfoa.retainedProfits" type="text" style="width: 10em;ime-mode: disabled;"
		value="<s:property value='%{tprojectInfoa.retainedProfits}' escape='true'/>"
		maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'净利润',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
	</td><s:hidden id="hiddenretainedProfits" name="hidden" value="净利润,1,2"></s:hidden>
</tr>
<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>缴税</td>
	<td style="padding: 4px 8px; text-align: left" colspan="4">
		<input class="inputA" id="scottare" name="tprojectInfoa.scottare" type="text" style="width: 10em;ime-mode: disabled;"
		value="<s:property value='%{tprojectInfoa.scottare}' escape='true'/>"
		maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'缴税',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
	</td><s:hidden id="hiddenscottare" name="hidden" value="缴税,1,2"></s:hidden>
</tr>
<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right" rowspan="3">资金投入情况<br />（万元）</td>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>总投入</td>
	<td style="padding: 4px 8px; text-align: left">
		<input class="inputA" id="investmentTotal" name="tprojectInfoa.investmentTotal" type="text" style="width: 10em;ime-mode: disabled;"
		value="<s:property value='%{tprojectInfoa.investmentTotal}' escape='true'/>"
		maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'总投入',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
	</td><s:hidden id="hiddeninvestmentTotal" name="hidden" value="总投入,1,2"></s:hidden>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>申请专项经费</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2">
		<input class="inputA" id="specialFunds" name="tprojectInfoa.specialFunds" type="text" style="width: 10em;ime-mode: disabled;"
		value="<s:property value='%{tprojectInfoa.specialFunds}' escape='true'/>"
		maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'申请专项经费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
	</td><s:hidden id="hiddenspecialFunds" name="hidden" value="申请专项经费,1,2"></s:hidden>
</tr>
<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>自筹</td>
	<td style="padding: 4px 8px; text-align: left">
		<input class="inputA" id="selfFinancing" name="tprojectInfoa.selfFinancing" type="text" style="width: 10em;ime-mode: disabled;"
		value="<s:property value='%{tprojectInfoa.selfFinancing}' escape='true'/>"
		maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'自筹',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
	</td><s:hidden id="hiddenselfFinancing" name="hidden" value="自筹,1,2"></s:hidden>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>其他</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2">
		<input class="inputA" id="other" name="tprojectInfoa.other" type="text" style="width: 10em;ime-mode: disabled;"
		value="<s:property value='%{tprojectInfoa.other}' escape='true'/>"
		maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'其他',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
	</td><s:hidden id="hiddenother" name="hidden" value="其他,1,2"></s:hidden>
</tr>
<tr>
	<!-- Start 2013/10/06 业务变更 wanglw -->
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>贷款</td>
	<td style="padding: 4px 8px; text-align: left">
		<input class="inputA" id="credit" name="tprojectInfoa.credit" type="text" style="width: 10em;ime-mode: disabled;"
		value="<s:property value='%{tprojectInfoa.credit}' escape='true'/>"
		maxlength="12" />
	</td>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>配套</td>
	<td style="padding: 4px 8px; text-align: left" colspan="2">
		<input class="inputA" id="supporting" name="tprojectInfoa.supporting" type="text" style="width: 10em;ime-mode: disabled;"
		value="<s:property value='%{tprojectInfoa.supporting}' escape='true'/>"
		maxlength="12" />
	</td>
	<!-- End 2013/10/06 业务变更 wanglw -->
</tr>
<tr>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>知识产权状况</td>
	<td style="padding: 4px 8px; text-align: left">
		<s:select style="width:12em;" list="intellectualPropertyList" label="abc" listKey="itemId"
			listValue="itemName" id="intellectualProperty" name="tprojectInfoa.intellectualProperty" 
			value="%{tprojectInfoa.intellectualProperty}" onblur="upms.upmsUtils.blurTextCheck(this,'知识产权状况');" onfocus="upms.upmsUtils.textFocus(this);"></s:select>
			<s:hidden id="intellectualPropertyValue" value="%{tprojectInfoa.intellectualProperty}"></s:hidden>
	</td><s:hidden id="hiddenintellectualProperty" name="hidden" value="知识产权状况"></s:hidden>
	<td width="11%" style="padding: 4px 3px; text-align:right"><FONT color=red>*</FONT>技术来源</td>
	<td style="padding: 4px 8px; text-align: left" colspan="3">
		<s:select style="width:12em;" list="technologySourceList" label="abc" listKey="itemId"
			listValue="itemName" id="technologySource" name="tprojectInfoa.technologySource" 
			value="%{tprojectInfoa.technologySource}" onblur="upms.upmsUtils.blurTextCheck(this,'技术来源');" onfocus="upms.upmsUtils.textFocus(this);"></s:select>
			<s:hidden id="technologySourceValue" value="%{tprojectInfoa.technologySource}"></s:hidden>
	</td><s:hidden id="hiddentechnologySource" name="hidden" value="技术来源"></s:hidden>
</tr>
	<tr><td colspan="6">注：总投入为从${newYear}年1月起，在执行期内企业完成合同规定的技术、经济指标而投入的资金。</td></tr>
</table>
<div align="center" style="width: 100%">
	<input class="button save" id="nextBtn" name="button" type="button" href="javascript: void(0);" onclick="nextBtn();" value="下一步"/>
</div>
</div>
</div>
</div>
</div>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/highTech/js/report_cover_update.js"></script>

<s:hidden id="planFlag" name="tprojectApplication.planFlag" value="%{tprojectApplication.projectPaTypeId}"></s:hidden>
<s:hidden id="tprojectType" name="tprojectApplication.tprojectType.typeId" value="%{projectTypeId}"></s:hidden> 
<s:hidden id="projectId" name="tprojectApplication.projectId" value="%{tprojectApplication.projectId}"></s:hidden>
<s:hidden id="typeName" name="tprojectApplication.typeName" value="%{tprojectApplication.typeName}"></s:hidden>
<s:hidden id="planFlagName" name="tprojectApplication.planFlagName" value="%{tprojectApplication.planFlagName}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
<div class="Servicel04">
<div class="abuot02">
<table width="100%">
<tr>
	<td width="20%" align="right"><FONT color=red>*</FONT>计划类别:&nbsp;</td>
	<td width="30%">
		<s:property value='%{projectPaTypeName}' escape='true'/>
	</td>
	<td width="20%" align="right"><FONT color=red>*</FONT>支持方式&nbsp;</td>
	<td width="30%">
		<s:radio onchange="upms.upmsUtils.radioChange(this);" name="tprojectApplication.supportFunction" 
			list="%{supportfunctionList}" 
			listKey="itemId" 
			listValue="itemName" 
			value="%{tprojectApplication.supportFunction}"
			>
		</s:radio>
	</td><s:hidden id="hiddensupportFunction" name="hidden" value="支持方式"></s:hidden>
</tr>
</table>
<div class="abuot07">西安市科技计划<br>项目申报书<br>（科技企业发展类）</div>

<div class=requirecolor id="errInfo"></div>
<table width="100%">
<tr>
		<td width="30%" style="padding: 4px 8px; text-align: right">
			<FONT color=red>*</FONT>项目名称
		</td>
		<td width="70%" style="padding: 4px 8px; text-align: left" colspan="5">
			<input id="projectName" name="tprojectApplication.projectName" 
			value="<s:property value='%{tprojectApplication.projectName}' escape='true'/>"
			type="text" style="width: 23em; height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'项目名称',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);"
			/>
		</td><s:hidden id="hiddenprojectName" name="hidden" value="项目名称,1,-1"></s:hidden>
</tr>
<tr>
	<td width="30%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>项目分类
	</td>
	<td colspan="5" style="padding: 4px 8px; text-align: left">
		<input id="projectTypeTemp" name="projectTypeTemp" type="text" style="width: 20em; height:1.6em;" class="inputA" readFlag="1" value="<s:property value='%{projectTypeName}' escape='true'/>"/>
			<%-- value="<s:property value='%{projectPaTypeName}' escape='true'/><s:property value='@com.hopsun.tppas.common.Constants@STRING_LINK' escape='true'/><s:property value='%{projectTypeName}' escape='true'/>" readonly="readonly"/> --%>
	</td>
	<%-- <s:property value='%{projectPaTypeName}' escape='true'/>
			<s:property value='@com.hopsun.tppas.common.Constants@STRING_LINK' escape='true'/> --%>
</tr>

<tr>
	<td width="30%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>支持类别
	</td>
	<td width="70%" style="padding: 4px 8px; text-align: left" colspan="5">
		<s:radio onchange="upms.upmsUtils.radioChange(this);" name="tprojectApplication.supportFlag" 
			list="%{supportFlagList}" 
			listKey="itemId" 
			listValue="itemName" 
			value="%{tprojectApplication.supportFlag}">
		</s:radio>
	</td><s:hidden id="hiddensupportFlag" name="hidden" value="支持类别"></s:hidden>
</tr>
<tr>
	<td width="30%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>申请单位
	</td>
	<td width="70%" style="padding: 4px 8px; text-align: left" colspan="5">
		<input id="applicationUnit" name="tprojectApplication.applicationUnit" 
		value="<s:property value='%{tprojectApplication.applicationUnit}' escape='true'/>"
		type="text" style="width: 23em; height:1.6em;" maxlength="25" class="inputA"
		readonly="readonly"/>
	</td>
</tr>
<tr>
	<td width="30%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>委托单位
	</td>
	<td style="padding: 4px 8px; text-align: left" colspan="5">
		<input id="entrustUnit" name="tprojectApplication.entrustUnit" 
		value="<s:property value='%{tprojectApplication.entrustUnit}' escape='true'/>"
		type="text" style="width: 23em; height:1.6em;" class="inputA" maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'项目分类',1,-1)"
		onfocus="upms.upmsUtils.textFocus(this);" 
		/>
	</td><s:hidden id="hiddenentrustUnit" name="hidden" value="委托单位,1,-1"></s:hidden>
</tr>
<tr>
	<td width="30%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>项目负责人
	</td>
	<td width="10%" style="padding: 4px 8px; text-align: left">
		<input id="projectPerson" name="tprojectInfoA.projectPerson" type="text" 
		style="width: 10em; height:1.6em;" class="inputA" 
		onblur="upms.upmsUtils.blurTextCheck(this,'项目负责人',0,-1)"
		onfocus="upms.upmsUtils.textFocus(this);" maxlength="5"
		value="<s:property value='%{tprojectInfoA.projectPerson}' escape='true'/>"
		readonly="readonly"
		readFlag="1"/>
		<s:hidden id="hiddenprojectPerson" name="hidden" value="项目负责人,0,-1"></s:hidden>
	</td>
	<td width="10%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>手机  
	</td>
	<td width="10%" style="padding: 4px 8px; text-align: left">
		<input id="personPhone" name="tprojectInfoA.personPhone" type="text" 
		style="width: 10em; height:1.6em;" class="inputA"
		onblur="upms.upmsUtils.blurTextCheck(this,'手机 ',0,12)"
		onfocus="upms.upmsUtils.textFocus(this);" maxlength="13"
		value="<s:property value='%{tprojectInfoA.personPhone}' escape='true'/>"
		readonly="readonly"
		readFlag="1"/>
		<s:hidden id="hiddenpersonPhone" name="hidden" value="手机 ,0,12"></s:hidden>
	</td>
	<td width="10%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>电话
	</td>
	<td width="20%" style="padding: 4px 8px; text-align: left">
		<input id="personTel" name="tprojectInfoA.personTel" type="text" 
		style="width: 10em; height:1.6em;" class="inputA"
		onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',0,12)"
		onfocus="upms.upmsUtils.textFocus(this);" maxlength="13"
		value="<s:property value='%{tprojectInfoA.personTel}' escape='true'/>"
		readonly="readonly"
		readFlag="1"/>
		<s:hidden id="hiddenpersonTel" name="hidden" value="联系电话,0,12"></s:hidden>
	</td>
</tr>
<tr>
	<td width="30%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>项目联系人
	<td width="10%" style="padding: 4px 8px; text-align: left">
		<input id="touchPerson" name="tprojectInfoA.touchPerson" type="text" 
		style="width: 10em; height:1.6em;" class="inputA" 
		onblur="upms.upmsUtils.blurTextCheck(this,'项目负责人',0,-1)"
		onfocus="upms.upmsUtils.textFocus(this);" maxlength="5"
		value="<s:property value='%{tprojectInfoA.touchPerson}' escape='true'/>"
		readonly="readonly"
		readFlag="1"/>
		<s:hidden id="hiddentouchPerson" name="hidden" value="项目负责人,0,-1"></s:hidden>
	</td>
	<td width="10%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>手机
	</td>
	<td width="10%" style="padding: 4px 8px; text-align: left">
		<input id="touchIdcard" name="tprojectInfoA.touchIdcard" type="text" 
		style="width: 10em; height:1.6em;" class="inputA"
		onblur="upms.upmsUtils.blurTextCheck(this,'手机 ',0,12)"
		onfocus="upms.upmsUtils.textFocus(this);" maxlength="13"
		value="<s:property value='%{tprojectInfoA.touchIdcard}' escape='true'/>"
		readonly="readonly"
		readFlag="1"/>
		<s:hidden id="hiddentouchIdcard" name="hidden" value="手机 ,0,12"></s:hidden>
	</td>
	<td width="10%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>电话
	</td>
	<td width="20%" style="padding: 4px 8px; text-align: left">
		<input id="touchPhone" name="tprojectInfoA.touchPhone" type="text" 
		style="width: 10em; height:1.6em;" class="inputA"
		onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',0,12)"
		onfocus="upms.upmsUtils.textFocus(this);" maxlength="13"
		value="<s:property value='%{tprojectInfoA.touchPhone}' escape='true'/>"
		readonly="readonly"
		readFlag="1"/>
		<s:hidden id="hiddentouchPhone" name="hidden" value="联系电话,0,12"></s:hidden>
	</td>
</tr>
<tr>
	<td width="30%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>归口管理部门
	</td>
	<td width="70%" style="padding: 4px 8px; text-align: left" colspan="5">
		<s:select style="width:11em;" list="centralizedBranchList" label="abc" listKey="itemId"
		listValue="itemName" id="centralizedType" name="tprojectApplication.centralizedType" 
		value="%{tprojectApplication.centralizedType}" onblur="upms.upmsUtils.blurTextCheck(this,'归口管理部门');" onfocus="upms.upmsUtils.textFocus(this);">
		</s:select>	<s:hidden id="centralizedTypeValue" value="%{tprojectApplication.centralizedType}"></s:hidden>	
	</td><s:hidden id="hiddencentralizedType" name="hidden" value="归口管理部门"></s:hidden>
</tr>
<tr>
	<td width="30%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>起止年限
	</td>
	<td width="80%" style="padding: 4px 8px; text-align: left" colspan="5">
		<INPUT class="txt w184p Wdate" type="text" name="startTime" id="startId" value="<s:property value='%{getText("{0,date,yyyy-MM}",{tprojectApplication.startTime})}' />" 
		onblur="upms.upmsUtils.checkStartAndEndDate('startId','endId',1,'起止年限',this,3);"
		onfocus="upms.upmsUtils.textFocus(this);" 
		onclick="WdatePicker({dateFmt:'yyyy-MM'})" readonly="readonly"/> 
		<s:hidden id="hiddenstartId" name="hidden" value="开始年限,1,-1"></s:hidden>
		<s:hidden id="reportYear" name="hidden" value="%{tprojectApplication.reportYear}"></s:hidden>
		至
		<INPUT class="txt w184p Wdate" type="text" name="endTime" id="endId" value="<s:property value='%{getText("{0,date,yyyy-MM}",{tprojectApplication.endTime})}' />" 
		onblur="upms.upmsUtils.checkStartAndEndDate('startId','endId',1,'起止年限',this,3);"
		onfocus="upms.upmsUtils.textFocus(this);"
		onclick="WdatePicker({dateFmt:'yyyy-MM'})" readonly="readonly"/>
		<font color=red>*</font>当年申报年度为<s:property value='%{tprojectApplication.reportYear}' escape='true'/>年，起始年份必须为<s:property value='%{tprojectApplication.reportYear}' escape='true'/>年
		<s:hidden id="hiddenendId" name="hidden" value="结束年限,1,-1"></s:hidden>
		<s:hidden id="startTime" name="tprojectApplication.startTime"></s:hidden>
	    <s:hidden id="endTime" name="tprojectApplication.endTime"></s:hidden>
	</td>
		
</tr>
<tr>
	<td width="30%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>填报时间
	</td>
	<td width="70%" style="padding: 4px 8px; text-align: left" colspan="5">
		<INPUT class="txt w184p Wdate" type="text" name="tprojectApplication.writeReportTime" id="writeReportTime" value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tprojectApplication.writeReportTime})}'/>" 
		readonly="readonly" onclick="WdatePicker()"
		onblur="upms.upmsUtils.blurTextCheck(this,'填报时间',1,11);"onfocus="upms.upmsUtils.textFocus(this);"/>
	</td><s:hidden id="hiddenwriteReportTime" name="hidden" value="填报时间,1,11"></s:hidden>
</tr>
</table>
		<div align="center" style="width: 100%">
		<br> <br>
		<s:property value='%{tprojectApplication.compilationDept}' escape='true'/><br />
		<s:property value='%{tprojectApplication.compilationTime}' escape='true'/>
		<br> <br>
			<input type="button" id="nextBtn" class="button add" href="javascript: void(0);"  value="下一步">
		</div>
</div>
</div>
</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/highTech/js/report_researcher_insert.js"></script>

<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
<div class="Servicel04">
<div class="abuot02">
	<div class="abuot07">项目负责人及主要人员_查看</div>
<s:hidden id="researcherId" name="tresearcher" value="%{tresearcher.researcherId}"></s:hidden>
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="jumpFlg" name="jumpFlg" value="1"></s:hidden>
<s:hidden id="status" name="status" value="%{applyStatus}"></s:hidden>

<div class=requirecolor id="errInfo"></div>
<table width="100%">
<tr>
	<td width="40%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>姓名
	</td>
	<td width="60%" style="padding: 4px 8px; text-align: left">
		<input id="name" name="tresearcher.name" 
		value="<s:property value='%{tresearcher.name}' escape='true'/>"
		type="text" style="width: 14.5em; height:1.6em;" class="inputA"
		maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'姓名',1,-1)"/>
	</td>
	<s:hidden id="hiddenname" name="hidden" value="姓名,1,-1"></s:hidden>
</tr>
<tr>
	<td width="40%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>年龄
	</td>
	<td width="60%" style="padding: 4px 8px; text-align: left">
		<input id="age" name="tresearcher.age" 
		value="<s:property value='%{tresearcher.age}' escape='true'/>"
		type="text" style="width: 14.5em; height:1.6em;ime-mode: disabled;" class="inputA"
		maxlength="3"  onkeypress="return upms.upmsUtils.isNum(event,this)"
	    onkeypress="return upms.upmsUtils.isNum(event,this)"
	    onblur="upms.upmsUtils.blurTextCheck(this,'年龄',1,9)"
		/>
	</td>
	<s:hidden id="hiddenage" name="hidden" value="年龄,1,9"></s:hidden>
</tr>

<tr>
	<td width="40%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>性别
	</td>
	<td width="60%" style="padding: 4px 8px; text-align: left">
		<s:select style="width:200px" list="sexFlagList" label="abc" 
		id="sexFlag" name="tresearcher.sexFlag" value="%{tresearcher.sexFlag}" >
		</s:select>	
		<s:hidden id="hiddensexFlag1" name="sex" value="%{tresearcher.sexFlag}"></s:hidden>	
	</td><s:hidden id="hiddensexFlag" name="hidden" value="性别"></s:hidden>
</tr>
<tr>
	<td width="40%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>职务职称
	</td>
	<td width="60%" style="padding: 4px 8px; text-align: left">
	<input id="job" name="tresearcher.job" 
		value="<s:property value='%{tresearcher.job}' escape='true'/>"
		type="text" style="width: 14.5em; height:1.6em;" class="inputA"
		maxlength="50" onblur="upms.upmsUtils.blurTextCheck(this,'职务职称',1,-1)"/>
	</td><s:hidden id="hiddenjob" name="hidden" value="职务职称,1,-1"></s:hidden>
</tr>
<tr>
	<td width="40%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>工作单位
	</td>
	<td width="60%" style="padding: 4px 8px; text-align: left">
		<input id="workUnit" name="tresearcher.workUnit" 
		value="<s:property value='%{tresearcher.workUnit}' escape='true'/>"
		type="text" style="width: 14.5em; height:1.6em;" class="inputA"
		maxlength="50" onblur="upms.upmsUtils.blurTextCheck(this,'工作单位',1,-1)"/>
	</td><s:hidden id="hiddenworkUnit" name="hidden" value="工作单位,1,-1"></s:hidden>
</tr>
<tr>
	<td width="40%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>部门
	</td>
	<td width="60%" style="padding: 4px 8px; text-align: left">
		<input id="department" name="tresearcher.department" 
		value="<s:property value='%{tresearcher.department}' escape='true'/>"
		type="text" style="width: 14.5em; height:1.6em;" class="inputA"
		maxlength="50"
		onblur="upms.upmsUtils.blurTextCheck(this,'部门',1,-1)"
		/>
	</td><s:hidden id="hiddendepartment" name="hidden" value="部门,1,-1"></s:hidden>
</tr>
<tr>
	<td width="40%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>联系电话
	</td>
	<td width="60%" style="padding: 4px 8px; text-align: left">
		<input id="phone" name="tresearcher.phone" 
		value="<s:property value='%{tresearcher.phone}' escape='true'/>"
		type="text" style="width: 14.5em; height:1.6em;" class="inputA"
		maxlength="13" 
		onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',1,12)"
		/>
	</td><s:hidden id="hiddenphone" name="hidden" value="联系电话,1,12"></s:hidden>
</tr>
<tr>
	<td width="40%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>从事专业
	</td>
	<td width="60%" style="padding: 4px 8px; text-align: left">
		<input id="specialty" name="tresearcher.specialty" 
		value="<s:property value='%{tresearcher.specialty}' escape='true'/>"
		type="text" style="width: 14.5em; height:1.6em;" class="inputA"
		maxlength="13" 
		onblur="upms.upmsUtils.blurTextCheck(this,'从事专业',1,-1)"
		/>
	</td><s:hidden id="hiddenspecialty" name="hidden" value="从事专业,1,-1"></s:hidden>
</tr>
<tr>
	<td width="40%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>承担任务
	</td>
	<td width="60%" style="padding: 4px 8px; text-align: left">
		<input id="task" name="tresearcher.task" 
		value="<s:property value='%{tresearcher.task}' escape='true'/>"
		type="text" style="width: 14.5em; height:1.6em;" class="inputA"
		maxlength="13" 
		onblur="upms.upmsUtils.blurTextCheck(this,'承担任务',1,-1)"
		/>
	</td><s:hidden id="hiddentask" name="hidden" value="承担任务,1,-1"></s:hidden>
</tr>
<tr>
	<td width="40%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>显示顺序
	</td>
	<td width="60%" style="padding: 4px 8px; text-align: left">
		<input id="revealOrder" name="tresearcher.revealOrder" 
		value="<s:property value='%{tresearcher.revealOrder}' escape='true'/>"
		type="text" style="width: 14.5em; height:1.6em;" class="inputA"
		maxlength="3" onkeypress="return upms.upmsUtils.isNum(event,this)"
		onblur="upms.upmsUtils.blurTextCheck(this,'显示顺序',1,9)"/>
		<!-- <em class=requirecolor id="errrevealOrder" name="errrevealOrder"></em> -->
	</td><s:hidden id="hiddenrevealOrder" name="hidden" value="显示顺序,1,9"></s:hidden>
</tr>
</table>
<div align="center" style="width: 100%;float: left;">
		<input type="button" id="reBtn" class="button back" href="javascript: void(0);"  value="返回">
</div>
</div>
</div>
</div>
</div>
<input type="hidden" id="chkFlg" value="true"/>
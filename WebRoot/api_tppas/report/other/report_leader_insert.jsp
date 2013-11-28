<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/other/js/report_leader_insert.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
<div class="Servicel04">
<div class="abuot02">
<div class="abuot07">项目负责人及参加人员_详细</div>
<s:hidden id="projectLeaderAId" name="tprojectLeaderA" value="%{tprojectLeaderA.projectLeaderAId}"></s:hidden>
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="jumpFlg" name="jumpFlg" value="2"></s:hidden>
<s:hidden id="status" name="status" value="%{applyStatus}"></s:hidden>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<div class=requirecolor id="errInfo"></div>
<table width="100%">
<tr>
	<td width="40%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>姓名
	</td>
	<td width="60%" style="padding: 4px 8px; text-align: left">
		<input id="name" name="tprojectLeaderA.name" 
		value="<s:property value='%{tprojectLeaderA.name}' escape='true'/>"
		type="text" style="width: 14.5em; height:1.6em;" class="inputA"
		maxlength="8" onblur="upms.upmsUtils.blurTextCheck(this,'姓名',1,-1)"
		onfocus="upms.upmsUtils.textFocus(this)"/>
	</td>
	<s:hidden id="hiddenname" name="hidden" value="姓名,1,-1"></s:hidden>
</tr>
<tr>
	<td width="40%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>性别
	</td>
	<td width="60%" style="padding: 4px 8px; text-align: left">
		<s:select style="width:200px" list="sexFlagList" label="abc" 
		id="sex" name="tprojectLeaderA.sex" value="%{tprojectLeaderA.sex}" >
		</s:select>	
		<s:hidden id="hiddensex1" name="sex" value="%{tprojectLeaderA.sex}"></s:hidden>	
	</td><s:hidden id="hiddensex" name="hidden" value="性别"></s:hidden>
</tr>
<tr>
	<td width="40%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>年龄
	</td>
	<td width="60%" style="padding: 4px 8px; text-align: left">
		<input id="age" name="tprojectLeaderA.age" 
		value="<s:property value='%{tprojectLeaderA.age}' escape='true'/>"
		type="text" style="width: 14.5em; height:1.6em;ime-mode: disabled;" class="inputA"
		maxlength="3"  onkeypress="return upms.upmsUtils.isNum(event,this)"
	    onkeypress="return upms.upmsUtils.isNum(event,this)"
	    onblur="upms.upmsUtils.blurTextCheck(this,'年龄',1,9)"
	    	onfocus="upms.upmsUtils.textFocus(this)"
		/>
	</td>
	<s:hidden id="hiddenage" name="hidden" value="年龄,1,9"></s:hidden>
</tr>
<tr>
	<td width="40%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>职务职称
	</td>
	<td width="60%" style="padding: 4px 8px; text-align: left">
	<input id="jobTitle" name="tprojectLeaderA.jobTitle" 
		value="<s:property value='%{tprojectLeaderA.jobTitle}' escape='true'/>"
		type="text" style="width: 14.5em; height:1.6em;" class="inputA"
		maxlength="15" onblur="upms.upmsUtils.blurTextCheck(this,'职务职称',1,-1)"
		onfocus="upms.upmsUtils.textFocus(this)"/>
	</td><s:hidden id="hiddenjobTitle" name="hidden" value="职务职称,1,-1"></s:hidden>
</tr>
<tr>
	<td width="40%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>从事专业
	</td>
	<td width="60%" style="padding: 4px 8px; text-align: left">
		<input id="specialty" name="tprojectLeaderA.specialty" 
		value="<s:property value='%{tprojectLeaderA.specialty}' escape='true'/>"
		type="text" style="width: 14.5em; height:1.6em;" class="inputA"
		maxlength="30" onblur="upms.upmsUtils.blurTextCheck(this,'从事专业',1,-1)"
		onfocus="upms.upmsUtils.textFocus(this)"/>
	</td><s:hidden id="hiddenspecialty" name="hidden" value="从事专业,1,-1"></s:hidden>
</tr>
<tr>
	<td width="40%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>承担任务
	</td>
	<td width="60%" style="padding: 4px 8px; text-align: left">
		<input id="task" name="tprojectLeaderA.task" 
		value="<s:property value='%{tprojectLeaderA.task}' escape='true'/>"
		type="text" style="width: 14.5em; height:1.6em;" class="inputA"
		maxlength="15"
		onblur="upms.upmsUtils.blurTextCheck(this,'承担任务',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this)"
		/>
	</td><s:hidden id="hiddentask" name="hidden" value="承担任务,1,-1"></s:hidden>
</tr>
<tr>
	<td width="40%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>所在单位
	</td>
	<td width="60%" style="padding: 4px 8px; text-align: left">
		<input id="unit" name="tprojectLeaderA.unit" 
		value="<s:property value='%{tprojectLeaderA.unit}' escape='true'/>"
		type="text" style="width: 14.5em; height:1.6em;" class="inputA"
		maxlength="13" 
		onblur="upms.upmsUtils.blurTextCheck(this,'所在单位',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this)"
		/>
	</td><s:hidden id="hiddenunit" name="hidden" value="所在单位,1,-1"></s:hidden>
</tr>
<tr>
	<td width="40%" style="padding: 4px 8px; text-align: right">
		<FONT color=red>*</FONT>显示顺序
	</td>
	<td width="60%" style="padding: 4px 8px; text-align: left">
		<input id="revealOrder" name="tprojectLeaderA.revealOrder" 
		value="<s:property value='%{tprojectLeaderA.revealOrder}' escape='true'/>"
		type="text" style="width: 14.5em; height:1.6em;" class="inputA"
		maxlength="3" onkeypress="return upms.upmsUtils.isNum(event,this)"
		onblur="upms.upmsUtils.blurTextCheck(this,'显示顺序',1,9)"
		onfocus="upms.upmsUtils.textFocus(this)"/>&nbsp;&nbsp;数字越大，顺序越靠前 	
		<!-- <em class=requirecolor id="errrevealOrder" name="errrevealOrder"></em> -->
	</td><s:hidden id="hiddenrevealOrder" name="hidden" value="显示顺序,1,9"></s:hidden>
</tr>
</table>
<div align="center">
		<input type="button" id="reBtn" class="button back" href="javascript: void(0);"  value="返回">
</div>
</div>
</div>
</div>
</div>
<input type="hidden" id = "chkFlg" value="true"/>
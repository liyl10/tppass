<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/highTech/js/acceptance_a_dept_opinion.js"></script>

<s:hidden id="acceptanceId" name="acceptanceId" value="%{acceptanceId}"></s:hidden>
<s:hidden id="acceptanceStatus" name="acceptanceStatus" value="%{acceptanceStatus}"></s:hidden>
<s:hidden id="opinionId" name="tacceptanceOpinionA.opinionId" value="%{tacceptanceOpinionA.opinionId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
	<div class="Servicel04">
		<div class="abuot02">
		<div class="abuot07">单位意见</div>
		<div class="abuot03">
	<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
	<tr>
		<td align="center">主持验收单位意见</td>
	</tr>
  <tr>
    <td><div align="left">
		<div align="right" style="margin:20px 50px 20px 50px;"><textarea id="presideOpinion" name="tacceptanceOpinionA.presideOpinion" cols="100" rows="11" class="inputA" style="height:200px; width:850px;"><s:property value='%{tacceptanceOpinionA.presideOpinion}' escape='true'/></textarea></div>
		<div align="right" style="margin:20px 50px 5px 20px;"><FONT color=red>*</FONT>主管领导签字：<INPUT TYPE="text" class="inputA" style="width:8em;" id="presideLeader" name="tacceptanceOpinionA.presideLeader" value="<s:property value='%{tacceptanceOpinionA.presideLeader}' escape='true'/>"
		maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'主管领导签字',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
		<s:hidden id="hiddenpresideLeader" name="hidden" value="主管领导签字,1,-1"/>（盖章）</div>
		<div align="right" style="margin:20px 50px 5px 20px;"><input class="txt w184p Wdate" type="text" id="presideTime" name="tacceptanceOpinionA.presideTime" value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tacceptanceOpinionA.presideTime})}' />" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/></div>
		</div>
	</td>
  </tr>
  <tr>
		<td align="center">组织单位验收意见</td>
  </tr>
  <tr>
    <td><div align="left">
		<div align="right" style="margin:20px 50px 20px 50px;"><textarea id="organizeOpinion" name="tacceptanceOpinionA.organizeOpinion" cols="140" rows="11" class="inputA" style="height:200px; width:850px;"><s:property value='%{tacceptanceOpinionA.organizeOpinion}' escape='true'/></textarea></div>
		<div align="right" style="margin:20px 50px 5px 20px;"><FONT color=red>*</FONT>主管领导签字：<INPUT TYPE="text" class="inputA" style="width:8em;" id="organizeLeader" name="tacceptanceOpinionA.organizeLeader" value="<s:property value='%{tacceptanceOpinionA.organizeLeader}' escape='true'/>"
		maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'主管领导签字',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
		<s:hidden id="hiddenpresideLeader" name="hidden" value="主管领导签字,1,-1"/>（盖章）</div>
		<div align="right" style="margin:20px 50px 5px 20px;"><input class="txt w184p Wdate" type="text" id="organizeTime" name="tacceptanceOpinionA.organizeTime" value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tacceptanceOpinionA.organizeTime})}' />" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/></div>
		</div>
	</td>
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

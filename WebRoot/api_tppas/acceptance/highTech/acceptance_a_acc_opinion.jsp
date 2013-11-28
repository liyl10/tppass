<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/highTech/js/acceptance_a_acc_opinion.js"></script>

<s:hidden id="acceptanceId" name="acceptanceId" value="%{acceptanceId}"></s:hidden>
<s:hidden id="acceptanceStatus" name="acceptanceStatus" value="%{acceptanceStatus}"></s:hidden>
<s:hidden id="opinionId" name="tacceptanceOpinionA.opinionId" value="%{tacceptanceOpinionA.opinionId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
	<div class="Servicel04">
		<div class="abuot02">
		<div class="abuot07">验收意见</div>
		<div class="abuot03">
	<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td><div align="left">
		<div align="right" style="margin:20px 50px 20px 50px;"><textarea id="acceptanceOpinion" name="tacceptanceOpinionA.acceptanceOpinion" cols="140" rows="20" class="inputA" style="height:360px; width:850px;"><s:property value='%{tacceptanceOpinionA.acceptanceOpinion}' escape='true'/></textarea></div>
		<div align="right" style="margin:20px 20px 5px 20px;"><FONT color=red>*</FONT>验收小组组长：<INPUT TYPE="text" class="inputA" style="width:8em;" id="acceptanceLeader" name="tacceptanceOpinionA.acceptanceLeader" value="<s:property value='%{tacceptanceOpinionA.acceptanceLeader}' escape='true'/>"
		maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'验收小组组长',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
		<s:hidden id="hiddenacceptanceLeader" name="hidden" value="验收小组组长,1,-1"/>&nbsp;&nbsp;
		副组长：<INPUT TYPE="text" class="inputA" style="width:8em;" id="acceptanceDeputyLeader1" name="tacceptanceOpinionA.acceptanceDeputyLeader1" value="<s:property value='%{tacceptanceOpinionA.acceptanceDeputyLeader1}' escape='true'/>"
		maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'副组长',0,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
		<s:hidden id="hiddenacceptanceDeputyLeader1" name="hidden" value="副组长,0,-1"/> 、 
		<INPUT TYPE="text" class="inputA" style="width:8em;" id="acceptanceDeputyLeader2" name="tacceptanceOpinionA.acceptanceDeputyLeader2" value="<s:property value='%{tacceptanceOpinionA.acceptanceDeputyLeader2}' escape='true'/>"
		maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'副组长',0,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
		<s:hidden id="hiddenacceptanceDeputyLeader2" name="hidden" value="副组长,0,-1"/></div>
		<div align="right" style="margin:20px 20px 5px 20px;"><input class="txt w184p Wdate" type="text" id="acceptanceTime" name="tacceptanceOpinionA.acceptanceTime" value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tacceptanceOpinionA.acceptanceTime})}' />" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/></div>
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

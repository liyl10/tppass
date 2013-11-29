<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/highTech/js/report_objectives.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
<div class="Servicel04">
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<div class="abuot02">
<div class="abuot07">项目实施目标</div>
<s:hidden id="objectivesId" name="treportObjectives.objectivesId" value="%{treportObjectives.objectivesId}"></s:hidden>
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<div class=requirecolor id="errInfo"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm">
<tr>
		<td width="30%" style="padding: 4px 3px; text-align: right">
			<FONT color=red>*</FONT>企业新获得质量认证体系证书
		</td>
		<td width="30%" style="padding: 4px 3px; text-align: left" colspan="2">
			<input id="qualityCertificationSystem" name="treportObjectives.qualityCertificationSystem" 
			value="<s:property value='%{treportObjectives.qualityCertificationSystem}' escape='true'/>"
			type="text" style="width: 17em; height:1.6em;ime-mode: disabled;" class="inputA"
			onblur="upms.upmsUtils.blurTextCheck(this,'企业新获得质量认证体系证书',1,4);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="7"
			onkeypress="return upms.upmsUtils.isNum(event,this)"/>
		</td><s:hidden id="hiddenqualityCertificationSystem" name="hidden" value="企业新获得质量认证体系证书,1,4"></s:hidden>
</tr>
<tr>
		<td width="30%" style="padding: 4px 3px; text-align: right">
			<FONT color=red>*</FONT>项目新获得国家相关行业许可证
		</td>
		<td width="30%" style="padding: 4px 3px; text-align: left" colspan="2">
			<input id="relevantIndustryPermits" name="treportObjectives.relevantIndustryPermits" 
			value="<s:property value='%{treportObjectives.relevantIndustryPermits}' escape='true'/>"
			type="text" style="width: 17em; height:1.6em;ime-mode: disabled;" class="inputA"
			onblur="upms.upmsUtils.blurTextCheck(this,'项目新获得国家相关行业许可证',1,4);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="7"
			onkeypress="return upms.upmsUtils.isNum(event,this)"/>
		</td><s:hidden id="hiddenrelevantIndustryPermits" name="hidden" value="项目新获得国家相关行业许可证,1,4"></s:hidden>
</tr>
<tr>
		
		<td rowspan="2" width="30%" style="padding: 4px 3px; text-align: right">
			<FONT color=red>*</FONT>项目新申请及授权专利（或著作权）证书
		</td>
</tr>
<tr>
	<td width="30%" style="padding: 4px 3px; text-align: left">申请
		<input id="authorize" name="treportObjectives.authorize" 
		value="<s:property value='%{treportObjectives.authorize}' escape='true'/>"
		type="text" style="width: 17em; height:1.6em;ime-mode: disabled;" class="inputA"
		onblur="upms.upmsUtils.blurTextCheck(this,'申请项',1,4);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="7"
		onkeypress="return upms.upmsUtils.isNum(event,this)"/>项
	</td><s:hidden id="hiddenauthorize" name="hidden" value="申请项,1,4"></s:hidden>
	<td align="left">授权		
		<input id="application" name="treportObjectives.application" 
		value="<s:property value='%{treportObjectives.application}' escape='true'/>"
		type="text" style="width: 17em; height:1.6em;ime-mode: disabled;" class="inputA"
		onblur="upms.upmsUtils.blurTextCheck(this,'授权项',1,4);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="7"
		onkeypress="return upms.upmsUtils.isNum(event,this)"/>项
	</td><s:hidden id="hiddenapplication" name="hidden" value="授权项,1,4"></s:hidden>
</tr>
<tr>
		<td width="30%" style="padding: 4px 3px; text-align: right">
			<FONT color=red>*</FONT>项目新获得技术、产品鉴定证书
		</td>
		<td width="30%" style="padding: 4px 3px; text-align: left" colspan="2">
			<input id="technologyProductCertificate" name="treportObjectives.technologyProductCertificate" 
			value="<s:property value='%{treportObjectives.technologyProductCertificate}' escape='true'/>"
			type="text" style="width: 17em; height:1.6em;ime-mode: disabled;" class="inputA"
			onblur="upms.upmsUtils.blurTextCheck(this,'项目新获得技术、产品鉴定证书',1,4);" onfocus="upms.upmsUtils.textFocus(this);" maxlength="7"
			onkeypress="return upms.upmsUtils.isNum(event,this)"/>
		</td><s:hidden id="hiddentechnologyProductCertificate" name="hidden" value="项目新获得技术、产品鉴定证书,1,4"></s:hidden>
</tr>
</table>
<br><br>
<div align="center" style="width: 100%">
	<input class="button" id="nextBtn" name="button" type="button" value="下一步"/>
</div>
</div>
</div>
</div>
</div>

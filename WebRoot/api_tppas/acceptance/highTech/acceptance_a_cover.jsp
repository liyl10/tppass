<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/highTech/js/acceptance_a_cover.js"></script>

<s:hidden id="acceptanceId" name="acceptanceId" value="%{acceptanceId}"></s:hidden>
<s:hidden id="acceptanceStatus" name="acceptanceStatus" value="%{acceptanceStatus}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
	<div class="Servicel04">
		<div class="abuot02">
		<div class="abuot07">西安市科技计划重大（重点）项目<br/>
								 &nbsp;<font size="+3">项目验收证书</font><br/>
								 &nbsp;&nbsp;&nbsp;市科验[&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]第　 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号
		</div>
		<div class="abuot03">
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td width="312" style="text-align:right">项目编号</td>
    <td colspan="3"><s:property value='%{tacceptance.tprojectApplication.projectNumber}' escape='true'/></td>
  </tr>
  <tr>
    <td style="text-align:right">计划类别</td>
    <td colspan="3"><s:property value='%{tacceptance.tprojectApplication.planFlagName}' escape='true'/></td>
  </tr>
  <tr>
    <td style="text-align:right">项目名称 </td>
    <td colspan="3"><s:property value='%{tacceptance.tprojectApplication.projectName}' escape='true'/></td>
    </tr>
	<tr>
    <td style="text-align:right">项目承担单位</td>
    <td colspan="3"><s:property value='%{tacceptance.tprojectApplication.applicationUnit}' escape='true'/></td>
  </tr>
  <tr>
    <td style="text-align:right">项目协作单位</td>
    <td colspan="3"><s:property value='%{tprojectInfoA.assistUnit}' escape='true'/></td>
  </tr>
  <tr>
    <td style="text-align:right">项目负责人</td>
    <td width="180"><s:property value='%{tprojectInfoA.projectPerson}' escape='true'/></td>
    <td width="168" style="text-align:right">电话</td>
    <td><s:property value='%{tprojectInfoA.personTel}' escape='true'/></td>
  </tr>
  <tr>
    <td style="text-align:right">项目联系人</td>
    <td><s:property value='%{tprojectInfoA.touchPerson}' escape='true'/></td>
    <td style="text-align:right">电话</td>
    <td><s:property value='%{tprojectInfoA.touchPhone}' escape='true'/></td>
  </tr>
  <tr>
    <td style="text-align:right">验收日期</td>
    <td colspan="3"></td>
  </tr>
  <tr>
    <td align="right">验收批准日期</td>
	<td colspan="3"></td>
  </tr>
  <tr>
    <td align="right">经办人（签字）</td>
	<td colspan="3"></td>
  </tr>
</table>
	<br/>
	<br/>
	<br/>
	<div align="center">西安市科学技术局印</div>
	<br/>
<div align="center">
	<input class="button save" name="nextBtn" id="nextBtn" type="button" href="javascript: void(0);" value="下一步"/>
</div>
</div>
</div>
</div>
</div>
</div>


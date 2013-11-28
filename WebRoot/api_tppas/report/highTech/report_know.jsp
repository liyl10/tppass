<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/highTech/js/report_know.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
<div class="Servicel04">
<div class="abuot02">
<div class="abuot07">申报须知</div>
<div class=requirecolor id="errInfo"></div>
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<table style="width:100%">
<tr><td>1、	所有栏目请如实填写，务必控制在要求字数内，语句简练，表达清晰。</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>2、	申报书、商业计划书及相关附件以A4格式打印，统一简装。</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>3、	电子版与纸质文件（一式五份）同时报送，方为有效申报。</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>4、	申报书中内容尽量简明扼要，具体项目内容可在可行性报告中填写体现。</td></tr>
</table>

<div align="center" style="width: 100%">
	<input type="button" id="nextBtn" class="button add"  value="下一步">
</div>
</div>
</div>
</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/other/js/report_know_detail.js"></script>
<!-- 项目ID -->
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">申报须知</div>
				<table width="100%">
				<tr><td>1、	填写“项目基本信息”栏时，所有选项均为单选，所有下拉菜单必须选择。</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>2、	填写其他栏目时，务必控制在要求字数内，语句简练，表达清晰。</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>3、	可行性报告（商业计划书）及附件只是与纸质材料一起装订即可。</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>4、	申报书、可行性研究报告及相关附件以A4格式打印，统一简装。</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>5、	纸质文件（一式五份）。</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>6、	项目编码由科技局填写。</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>7、	申报书中内容尽量简明扼要，具体项目内容可在可行性报告中填写体现。</td></tr>
				</table>
				<div align="center" style="width: 100%">
					<br> <br>
					<input id="nextBtn" class="button save" name="button" type="button" href="javascript: void(0);" value="下一步"/>
				</div>
			</div>
		</div>
	</div>
</div>
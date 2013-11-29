<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/highTech/js/supervisorApply_firstPage.js"></script>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">
					<span>西安市高新技术产业发展专项项目</span><br /> <span>执行情况监理表</span><br />
					<s:if test="%{supportFlag==1}">
						<span>（项目类）</span>
					</s:if>
					<s:else>
						<span>（平台类）</span>
					</s:else>
				</div>
				<table style="width: 100%;" cellspacing="0" cellpadding="0"
					class="t-entRegFrm">
					<tr>
						<td style="width: 40%; text-align: right;">项目名称</td>
						<td><s:property value="%{projectName}" /></td>
					</tr>
					<tr>
						<td style="width: 40%; text-align: right;">承担单位</td>
						<td><s:property value="%{applicationUnit}" />（盖章）</td>
					</tr>
					<tr>
						<td style="width: 40%; text-align: right;">归口管理单位</td>
						<td><s:property value="%{centralizedBranch}" />（盖章）</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><s:property
								value="%{supervisorComment}" /></td>
					</tr>
				</table>
			</div>
			<div align="center" style="width: 95%">
				<a class="button" id="submit" onclick="next();">下一步</a>
			</div>
		</div>
	</div>
</div>


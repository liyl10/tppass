<!DOCTYPE HTML>
<html >
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<!-- Struts Tag宣言 -->
<%@ taglib prefix="s" uri="/struts-tags" %> 
<title></title>
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/layout.css">
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/install_upms.js?ver=1.0.0"></script>

<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/chosen.jquery.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/chosen.css" />
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/btn.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/joint/js/other_comments.js"></script>
</head>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04" style="min-height: 350px;">
			<div class="abuot02">
				<div class="abuot07">其他意见</div>
					<label id="path" style="display: none;">${pageContext.request.contextPath}</label>
					<div>
						<table width="100%">
							<tr>
								<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
									其他意见&nbsp;
								</td>
								<td style="white-space:nowrap;width:26%;padding:2px">
									 <textarea id="otherComments" name="otherComments" 
class="inputA" style="width:300px;height:100px" 
onKeyUp="upms.upmsUtils.checkTextareaLength(this, 1000);"
onblur="upms.upmsUtils.blurTextCheck(this,'其他意见',0,8,1000)"
onfocus="upms.upmsUtils.textFocus(this)" >
<s:property value='%{otherComments}' escape='true'/></textarea>
									<s:hidden id="hiddenresearch1" name="hidden" value="其他意见,0,8,1000"></s:hidden>
								</td>
								<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
							</tr>
						</table>
					</div>
			</div>
		</div>
	</div>
</div>
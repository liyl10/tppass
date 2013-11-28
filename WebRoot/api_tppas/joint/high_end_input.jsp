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

</head>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04" style="min-height: 150px;">
			<div class="abuot02">
				<div class="abuot07">院所/高端人才录入</div>
					<label id="path" style="display: none;">${pageContext.request.contextPath}</label>
					<div>
						<table width="100%">
							<tr>
								<td style="white-space:nowrap;width:12%;text-align:right;padding:2 2 10 10;font-size:105%">
									院所/高端人才&nbsp;
								</td>
								<td style="white-space:nowrap;width:88%;padding:2px">
									<input type="text" id="highEnd" name="highEnd" class="inputA" 
									value="<s:property value='%{highEnd}' escape='true' />"
									maxlength="100" style="width:20em;"/>
								</td>
							</tr>
						</table>
					</div>
			</div>
		</div>
	</div>
</div>
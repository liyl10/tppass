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

<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/office/js/office_detail.js"></script>
</head>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04" style="min-height: 350px;">
			<div class="abuot02">
				<div class="abuot07">处室意见</div>
					<label id="path" style="display: none;">${pageContext.request.contextPath}</label>
					<div>
						<table width="100%">
							<tr>
								<td style="white-space:nowrap;width:12%;text-align:right;padding:2 2 10 10;font-size:105%">
									处室意见&nbsp;
								</td>
								<td style="white-space:nowrap;width:88%;padding:2px">
									<textarea id="comment2" name="comment2" class="inputA" 
										style="width:95%; height:180px;resize:none;" 
										><s:property value='%{tprojectApplication.expertProofComposite}' escape='true'/></textarea>
								</td>
							</tr>
						</table>
					</div>
			</div>
		</div>
	</div>
</div>
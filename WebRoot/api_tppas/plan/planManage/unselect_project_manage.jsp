<!DOCTYPE HTML>
<html >
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<title></title>
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/layout.css">
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/style.css">
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/btn.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/install_upms.js?ver=1.0.0"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/plan/planManage/js/unselect_project_manage.js"></script>
<s:hidden id="planId" name="planId" value="%{planId}"></s:hidden>
<label id="path" style="display: none">${pageContext.request.contextPath}</label>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目选择</div>
					<div>
						<form id="searchForm">
							<table width="100%">
								<tr>
									<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
							  			项目名称&nbsp;
							  		</td>
									<td style="white-space:nowrap;width:25%;padding:2px">	
							  	 		<input type="text" id="projectName" name="projectName" class="inputA" 
							  	 		autocomplete="off" maxlength="20" style="width:15em;"/>
							 		 &nbsp;
							 		</td>	
									<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
										申报单位&nbsp;
									</td>
									<td style="white-space:nowrap;width:25%;padding:2px">		
										<input type="text" id="applyCompany" name="applyCompany" class="inputA" 
							  	 		autocomplete="off" maxlength="20" style="width:15em;"/>
									</td>
									<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
										<input class="button" type="button" id="queryBtn" value="查询" onclick="queryData();"/>
									&nbsp;
									</td>
								</tr>
							</table>
						</form>
					</div>
					<div>&nbsp;</div>
					<!-- 查询结果列表S -->
					<div id="resultDiv"></div>
			</div>
		</div>
	</div>
</div>
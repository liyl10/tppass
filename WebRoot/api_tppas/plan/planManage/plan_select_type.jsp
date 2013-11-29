<!DOCTYPE HTML>
<html >
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<!-- Struts Tag宣言 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title></title>
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/layout.css">
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/install_upms.js?ver=1.0.0"></script>

<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/chosen.jquery.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/chosen.css" />
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/btn.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/plan/planManage/js/plan_select_type.js"></script>
</head>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04" style="min-height: 250px;">
			<div class="abuot02">
				<div class="abuot07">计划项目类别选择</div>
					<br>
					<br>
					<label id="path" style="display: none">${pageContext.request.contextPath}</label>
					<div>
						<table width="100%">
							<tr>
								<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
									计划项目类别&nbsp;
								</td>
								
								<td style="white-space:nowrap;width:26%;padding:2px">
									<c:if test="${projecTypeManager==true}">
										<s:select list="projectTypeList1" listKey="typeId" label="abc" listValue="typeShowName"
												id="projectType1" name="projectType1" style="width:15.5em;"></s:select>
										<s:select list="projectTypeList2" listKey="typeId" label="abc" listValue="typeShowName"
												id="projectType2" name="projectType2" style="width:15.5em;"></s:select>
									</c:if>
									<c:if test="${projecTypeManager==false}">
										<s:select list="projectTypeList2" listKey="typeId" label="abc" listValue="typeShowName"
												id="projectType2" name="projectType2" style="width:15.5em;"></s:select>
									</c:if>
								</td>
								
								
								<s:hidden id="hiddenprojectType2" name="hidden" value="计划项目类别"></s:hidden>
							</tr>
						</table>
					</div>
			</div>
		</div>
	</div>
</div>
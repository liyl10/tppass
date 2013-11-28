<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/super/js/projectModelSearch.js"></script>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目申报模板</div>
				<div>
					<form id="searchForm">
						<br>
						<table style="width:100%">
							<tr>
								<td
									style="width: 1%; text-align: right; padding: 2 2 10 10; font-size: 105%; word-break: keep-all; white-space: nowrap;">
								</td>
								<td width="1%" style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
									申报模板名称
								&nbsp;</td>
								<td width="1%" style="white-space:nowrap;width:20%;padding:2px;">		
									<input type="text" id="modelName" name="modelName" class="inputA"/>
								&nbsp;</td>
								<td style="width: 30%; text-align: right; padding: 2px">
								<input class="button" type="button" id="querybtn" value="查询" />
<%-- 								<tag:auth code="ss.projectModelSearch.search">

								</tag:auth> --%>
								</td>
							</tr>
						</table>

					</form>
				</div>
				<!-- 查询结果列表S -->
				<div id="resultDiv" style="padding-top: 10px;"></div>
				<!-- 查询结果列表E -->
			</div>
		</div>
	</div>
</div>

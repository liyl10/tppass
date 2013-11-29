<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/reportingunit/js/reportingUnit_condition.js"></script>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">申报单位管理</div>
				<div>
					<div class=requirecolor id="errInfo"></div>
					<form id="searchForm">
						<table width="100%">
							<tr>
								<td style="white-space: nowrap; width: 10%; text-align: right; padding: 2 2 10 10; font-size: 105%">
									单位名称 &nbsp;</td>
								<td style="white-space: nowrap; width: 20%; padding: 2px;">
									<input type="text" id="unitName" name="unitName" class="inputA" />
									&nbsp;
								</td>
								<td style="white-space: nowrap; width: 10%; text-align: right; padding: 2 2 10 10; font-size: 105%">
									单位性质 &nbsp;</td>
								<td style="white-space: nowrap; width: 20%; padding: 2px;">
									<s:select list="unitNatureList" listKey="itemId"
										style="width:15.2em;" listValue="itemName" id="unitNature"
										name="unitNature"></s:select>&nbsp;
								</td>
								<td align="right"><input class="button" type="button"
									id="queryBtn" value="查询" /></td>
							</tr>
						</table>
						<!-- 查询结果列表S -->
						<div id="resultDiv"></div>
						<!-- 查询结果列表E -->
					</form>
				</div>
			</div>
		</div>
	</div>
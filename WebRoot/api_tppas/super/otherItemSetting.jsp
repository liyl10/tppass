<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/super/js/otherItemSetting.js"></script>
<s:hidden id="masterTypeName" name="masterTypeName" value="%{masterTypeName}"></s:hidden>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">代码值配置管理</div>
				<div>
					<form id="searchForm">
						<br>
						<table style="width:100%">
							<tr>
								<td
									style="width: 10%; text-align: right; padding: 2 2 10 10; font-size: 105%; word-break: keep-all; white-space: nowrap;">代码类型
								</td>
								<td style="width: 20%; padding: 2px"><s:select
										list="typeLst" label="代码类型" listKey="typeId"
										style="width:15em" listValue="typeName" id="masterType"
										name="masterType" value="%{masterType}"></s:select></td>
								<td>&nbsp;</td>
								<td style="width: 15%; text-align: right; padding: 2px">
								<tag:auth code="ss.otherItemSetting.search">
								<input class="button" type="button" id="querybtn" value="查询" />
								</tag:auth>
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

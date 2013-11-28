<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/expert/expertDatabase/js/expert_manage.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">专家库管理</div>
					<div>
						<form id="searchForm">
							<table width="100%">
								<tr>			
									<td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
										专家姓名
									</td>
									<td style="white-space:nowrap;width:20%;padding:2px;">		
										<input type="text" id="expertName" name="expertName" class="inputA" style="width:90%;"/>
									</td>
									<td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
										擅长专业
									</td>
									<td style="white-space:nowrap;width:20%;padding:2px;">		
										<s:select list="expertMajorList" listKey="itemId" listValue="itemName" id="expertMajor1" name="expertMajor1" style="width:98%;"></s:select>
									</td>
									<td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
										信誉等级
									</td>
									<td style="white-space:nowrap;width:20%;padding:2px;">		
										<s:select list="expertPrestigeList" listKey="itemId" listValue="itemName" id="expertPrestige" name="expertPrestige" style="width:90%;"></s:select>
									</td>
									<td style="text-align:right;padding:2px;width:10%">
										<input class="button" type="button" id="queryBtn" value="查询"/>
									</td>
								</tr>
							</table>
						</form>
					</div>
					<div>&nbsp;</div>
					<!-- 查询结果列表S -->
					<div id="resultDiv"></div>
					<!-- 查询结果列表E -->
			</div>
		</div>
	</div>
</div>
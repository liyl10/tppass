<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/expert/expertStatistic/js/expert_statistic_manage.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">专家评审统计</div>
					<label id="path" style="display: none;">${pageContext.request.contextPath}</label>
					<div>
						<form id="searchForm">
								<table width="100%">
									<tr>
										<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
								  			专家名称&nbsp;
								  		</td>
										<td style="white-space:nowrap;width:25%;padding:2px" colspan="3">	
								  	 		<input type="text" id="expertName" name="expertName" class="inputA" 
								  	 		autocomplete="off" maxlength="20" style="width:15em;"/>
								 		 &nbsp;
								 		</td>
									</tr>
									<tr>
										<td>&nbsp;
										</td>
										<td>&nbsp;
										</td>
										<td>&nbsp;
										</td>
										<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
											<input class="button" type="button" id="queryBtn" value="查询"/>
											&nbsp;
											<input class="button" type="button" id="printBtn" value="打印" onclick="printExcel();"/>
											&nbsp;
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
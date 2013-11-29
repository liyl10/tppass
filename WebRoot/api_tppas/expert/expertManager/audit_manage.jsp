<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/expert/expertManager/js/audit_manage.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">专家评审管理</div>
					<div>
						<form id="searchForm">
							<table width="100%">
								<tr>			
									<td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
										项目名称
									</td>
									<td style="white-space:nowrap;width:20%;padding:2px;">		
										<input type="text" id="projectName" name="projectName" class="inputA" style="width:90%;"/>
									</td>
									<td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
										申报单位
									</td>
									<td style="white-space:nowrap;width:20%;padding:2px;">	
										<input type="text" id="applicationUnit" name="applicationUnit" class="inputA" style="width:90%;"/>
									</td>
									<td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
										&nbsp;
									</td>
									<td style="white-space:nowrap;width:20%;padding:2px;">	
										&nbsp;	
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
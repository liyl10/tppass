<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/expert/expertScore/js/project_manage.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目列表</div>
					<div>
						<form id="searchForm">
								<table width="100%">
									<tr>
										<s:hidden id="groupId" name="groupId" value="%{groupId}"></s:hidden>
										<td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
											填写状态&nbsp;
										</td>
										<td style="white-space:nowrap;width:30%;padding:2px" colspan="2">		
											<select id="isWrite" name="isWrite" style="width:70%;">
												<option value="0" ${isWrite=='0'?'selected':''}>未填写</option>
												<option value="1" ${isWrite=='1'?'selected':''}>已填写</option>
											</select>
										</td>
										<td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
								  			项目名称&nbsp;
								  		</td>
										<td style="white-space:nowrap;width:30%;padding:2px">	
								  	 		<input type="text" id="projectName" name="projectName" class="inputA" 
								  	 		autocomplete="off" maxlength="20" style="width:15em;"/>
								 		</td>
								 		<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%" colspan="6">
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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/js/supervisor_manager.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目监理</div>
					<div>
						<form id="searchForm">
							<table width="100%">
								<tr>			
									<td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
										项目名称
									</td>
									<td style="white-space:nowrap;width:30%;padding:2px;">		
										<input type="text" id="projectName" name="projectName" class="inputA" style="width:15em;"/>
									</td>
									<td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
										申报单位
									</td>
									<td style="white-space:nowrap;width:40%;padding:2px;">	
										<input type="text" id="applicationUnit" name="applicationUnit" class="inputA" style="width:15em;"/>
									</td>
									<td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
										&nbsp;
									</td>
								</tr>
								<tr>
									<td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
										监理状态
									</td>
									<td style="white-space:nowrap;width:30%;padding:2px;">	
										<s:select list="supervisorStateList" listKey="itemId" listValue="itemName" id="supervisorState" name="supervisorState" style="width:15.5em;"></s:select>
									</td>
									<c:if test="${projecTypeManager==true}">
										<td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
											项目分类
										</td>
										<td style="white-space:nowrap;width:40%;padding:2px;">		
											<s:select list="projectTypeFirstList" listKey="typeId" listValue="typeRealName" id="planFlag" name="planFlag" style="width:15.5em;"></s:select>
											<s:select list="projectTypeSecondList" listKey="typeId" listValue="typeRealName" id="typeId" name="typeId" style="width:15.5em;"></s:select>
										</td>
									</c:if>
									<c:if test="${projecTypeManager==false}">
										<td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
											&nbsp;
										</td>
										<td style="white-space:nowrap;width:40%;padding:2px;">		
											&nbsp;
										</td>
									</c:if>
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
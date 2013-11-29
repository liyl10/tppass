<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/plan/planManage/js/plan_manage.js"></script>

<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">分计划管理</div>
					<div>
						<form id="searchForm">
								<table width="100%">
									<tr>
										<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
								  			分计划名称&nbsp;
								  		</td>
										<td style="white-space:nowrap;width:25%;padding:2px">	
								  	 		<input type="text" id="planName" name="planName" class="inputA" 
								  	 		autocomplete="off" maxlength="20" style="width:15em;"/>
								 		 &nbsp;
								 		</td>	
										<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
											计划年度&nbsp;
										</td>
										<td style="white-space:nowrap;width:26%;padding:2px" colspan="2">
											<s:select list="planYearList" listKey="itemId" label="abc" listValue="itemName"
											id="planYear" name="planYear" style="width:15.5em;"></s:select>
										</td>
									</tr>
									<tr>
										<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
											计划状态&nbsp;
										</td>
										<td style="white-space:nowrap;width:26%;padding:2px" >
											<s:select list="planStatusList" listKey="itemId" label="abc" listValue="itemName"
											id="planStatus" name="planStatus" style="width:15.5em;"></s:select>
										</td>
										<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
											计划批次&nbsp;
										</td>
										<td style="white-space:nowrap;width:26%;padding:2px" colspan="2">
											<s:select list="planBatchList" listKey="itemId" label="abc" listValue="itemName"
											id="planBatch" name="planBatch" style="width:15.5em;"></s:select>
										</td>
									</tr>
									<tr>
										<c:if test="${projecTypeManager==true}">
											<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
												项目分类&nbsp;
											</td>
											<td style="white-space:nowrap;width:26%;padding:2px" colspan="3">
												<s:select list="projectTypeList1" listKey="typeId" label="abc" listValue="typeShowName"
												id="projectType1" name="projectType1" style="width:15.5em;"></s:select>
												<s:select list="projectTypeList2" listKey="typeId" label="abc" listValue="typeShowName"
												id="projectType2" name="projectType2" style="width:15.5em;"></s:select>
											</td>
										</c:if>
										<c:if test="${projecTypeManager==false}">
											<td colspan="4">
												&nbsp;
											</td>
										</c:if>
										<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
											<input class="button" type="button" id="queryBtn" value="查询"/>
										&nbsp;
										</td>
									</tr>
								</table>
						</form>
					</div>
					<div style=" margin-bottom: 22px;">
						
						<div style="float: right;">
							<input class="button" type="button" id="createPlanBtn" value="编制分计划" onclick="createPlan();"/>
							&nbsp;
						</div>
					</div>
					<div>&nbsp;</div>
					<!-- 查询结果列表S -->
					<div id="resultDiv"></div>
					<!-- 查询结果列表E -->
					<s:hidden id="hiddenprojectType2" name="hidden" value="计划项目类别"></s:hidden>
			</div>
		</div>
	</div>
</div>
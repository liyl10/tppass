<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/plan/js/plan_management.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">分计划查看</div>
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
								 		</td>	
										<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
											计划年度&nbsp;
										</td>
										<td style="white-space:nowrap;width:25%;padding:2px">		
											<input class="txt w184p Wdate" type="text" name="planYear" id="planYear"
											onclick="WdatePicker({dateFmt:'yyyy'})" readonly="readonly"/>
										</td>
										<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
											分计划状态&nbsp;
										</td>
										<td style="white-space:nowrap;width:25%;padding:2px">
											<s:select list="planStateList" listKey="itemId" label="abc" listValue="itemName"
											id="planState" name="planState" style="width:15.5em;"></s:select>
										</td>
									</tr>
									<tr>
										<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
											计划批次&nbsp;
										</td>
										<td colspan="4" style="white-space:nowrap;width:26%;padding:2px">
											<s:select list="planBatchList" listKey="itemId" label="abc" listValue="itemName"
											id="planBatch" name="planBatch" style="width:15.5em;"></s:select>
										</td>
										<%-- <td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
											项目分类&nbsp;
										</td>
										<td colspan="3" style="white-space:nowrap;width:30%;padding:2px">
											<s:select list="projectTypeList1" style="width:200px" listKey="typeId" listValue="typeShowName"
												id="projectType1" name="projectType1"> </s:select>
											<s:select list="projectTypeList2" style="width:200px" listKey="typeId" listValue="typeShowName"
												id="projectType2" name="projectType2"></s:select>
										</td> --%>
										<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
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
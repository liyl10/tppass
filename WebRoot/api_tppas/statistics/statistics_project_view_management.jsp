<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/statistics/js/statistics_project_view_management.js"></script>
<form id="testId"></form>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
			<div class="abuot07">项目评审通过率统计</div>
			<div>
			<form id="searchForm" name="searchForm">
			<table width="100%">
			<tr>
			  
		  		<td width="30%" style="padding: 4px 3px; text-align:right">
		   	  		项目年度
		   	  	</td>
			 	<td width="70%" style="padding: 4px 8px; text-align: left">
		  	 		&nbsp;从&nbsp;<input type="text" id="projectViewTypeStartTime" 
		  	 		name="projectViewTypeStartTime" 
		  	 		class="txt w184p Wdate" onclick="WdatePicker({dateFmt:'yyyy'})"
		  	 		style="width:150px;" />
		  	 		&nbsp;到&nbsp;
		  	 		<input type="text" id="projectViewTypeEndTime" 
		  	 		name="projectViewTypeEndTime" 
		  	 		class="txt w184p Wdate" onclick="WdatePicker({dateFmt:'yyyy'})"
		  	 		style="width:150px;" />
		  		</td>	
		  		<%-- <td width="10%" align="right">显示类型 &nbsp;</td>
				<td width="35%" align="left">
					<s:select style="width:12em;" list="projectViewTypeList" label="abc" listKey="itemId"
					listValue="itemName" id="projectViewType" name="projectViewType"></s:select>
				</td> --%>
			</tr>
			
			<tr>
				<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%" colspan="6">
					<tag:auth code="ss.contractdata.countBtn">
					<input type="button" class="button" name="queryBtn" id="countBtn" value="统计">
					&nbsp;
					<input type="button" class="button" name="printBtn" id="printBtn" value="打印">
					</tag:auth>
				&nbsp;</td>
			</tr>
	</table>
</form>
<div>&nbsp;</div>
<!-- 查询结果列表S -->
<div id="resultDiv"></div>
</div>
</div>
</div>
</div>
</div>
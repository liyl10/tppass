<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/contract/js/contract_management.js"></script>
<form id="testId"></form>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
			<div class="abuot07">合同签订管理</div>
			<div>
			<form id="searchForm" name="searchForm">
			<table width="100%">
			<tr>
				<td width="11%" style="padding: 4px 3px; text-align:right">
		  			项目名称
		  		</td>
		 		<td style="padding: 4px 8px; text-align: left">
		  	 		<input type="text" id="projectName" name="projectName" class="inputA" 
		  	 		autocomplete="off" maxlength="50" style="width:14.8em;"/>
		  		</td>	
		  		<td width="11%" style="padding: 4px 3px; text-align:right">
		  			申报单位
		  		</td>
		 		<td style="padding: 4px 8px; text-align: left">
		  	 		<input type="text" id="applicationUnit" name="applicationUnit" class="inputA" 
		  	 		autocomplete="off" maxlength="50" style="width:15.1em;"/>
		  		</td>	
		  	</tr>
		  	<tr>
		  		<c:if test="${projecTypeManager==true}">
		            <td width="11%" style="padding: 4px 3px; text-align:right">
			   	  	   	项目分类
			   	     </td>
				  	<td style="padding: 4px 8px; text-align: left">
				  		<div>
						<s:select style="width:12em;" list="typeId1List" label="abc" listKey="typeId"
						listValue="typeShowName" id="typeId1" name="typeId1" value="%{typeId1}"></s:select>
						<s:select style="width:12em;" list="typeId2List" label="abc" listKey="typeId"
						listValue="typeShowName" id="typeId2" name="typeId2" value="%{typeId2}"></s:select>
						</div>
						<s:hidden id="hiddentypeId2" name="hidden" value="项目分类级联"></s:hidden>
						<s:hidden id="typeId1Value" name="typeId1Value" value="%{typeId1}"></s:hidden>
						<s:hidden id="typeId2Value" name="typeId2Value" value="%{typeId2}"></s:hidden>
				   </td>	
				   	
			   </c:if>
			   <td width="11%" style="padding: 4px 3px; text-align:right">
		   	  		合同状态
		   	  	</td>
			 	<td style="padding: 4px 8px; text-align: left" colspan="3">
		  	 		<s:select list="contractStatusList" listKey="itemId" style="width:15.2em;"
						listValue="itemName" id="contractStatus" name="contractStatus">
					</s:select>
		  		</td>	
			</tr>
		<tr>
			<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%" colspan="6">
				<tag:auth code="ss.contractdata.queryBtn">
				<input type="button" class="button" name="queryBtn" id="queryBtn" value="查询">
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
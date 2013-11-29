<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/statistics/js/statistics_funds_management.js"></script>
<form id="testId"></form>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
			<div class="abuot07">拨款单统计</div>
			<div>
			<form id="searchForm" name="searchForm">
			<label id="path" style="display: none">${pageContext.request.contextPath}</label>
			<s:hidden id="isPlanningDept" name="isPlanningDept" value="%{isPlanningDept}"></s:hidden>
			<s:hidden id="projecTypeManager" name="projecTypeManager" value="%{#session.projecTypeManager}"></s:hidden>
			<table width="100%">
			<tr>
				<td width="15%" style="padding: 4px 3px; text-align:right">
		  			委托任务（项目名称）
		  		</td>
		 		<td width="35%" style="padding: 4px 8px; text-align: left" >
		  	 		<input type="text" id="projectName" name="projectName" class="inputA" 
		  	 		style="width:14.8em;"/>
		  		</td>	
		  		 <td width="15%" style="padding: 4px 3px; text-align:right">
		   	  		项目承担（单位全称）
		   	  	</td>
			 	<td width="35%" style="padding: 4px 8px; text-align: left">
		  	 		<input type="text" id="applicationUnit" name="applicationUnit" class="inputA" 
		  	 		style="width:14.8em;"/>
		  		</td>	
		  	</tr>
		  	<tr>
			  	
		  		<td width="10%" style="padding: 4px 3px; text-align:right">
		   	  		开户银行及行号
		   	  	</td>
			 	<td  width="40%" style="padding: 4px 8px; text-align: left">
		  	 		<input type="text" id="bank" name="bank" class="inputA" 
		  	 		style="width:14.8em;"/>
		  		</td>	
		  		<td width="10%" style="padding: 4px 3px; text-align:right">
		   	  		账号
		   	  	</td>
			 	<td width="40%" style="padding: 4px 8px; text-align: left">
		  	 		<input type="text" id="bankAccount" name="bankAccount" class="inputA" 
		  	 		style="width:14.8em;"/>
		  		</td>
			</tr>
			<tr>
			  	<td width="15%" style="padding: 4px 3px; text-align:right">
		   	  		本次拨款金额
		   	  	</td>
			 	<td width="35%" style="padding: 4px 8px; text-align: left">
		  	 		<input type="text" id="amountFundingStart" 
		  	 		name="amountFundingStart" class="inputA" 
		  	 		style="width:100px;" 
		  	 		onblur="upms.upmsUtils.blurTextCheck(this,'本次拨款金额（开始时间）',0,2);" 
        			onfocus="upms.upmsUtils.textFocus(this)" />
		  	 		&nbsp;-&nbsp;
		  	 		<input type="text" id="amountFundingEnd" 
		  	 		name="amountFundingEnd" class="inputA" 
		  	 		style="width:100px;" 
		  	 		onblur="upms.upmsUtils.blurTextCheck(this,'本次拨款金额（结束时间）',0,2);" 
        			onfocus="upms.upmsUtils.textFocus(this)"/>
        			<s:hidden id="hiddenamountFundingStart" name="hidden" value="本次拨款金额（开始时间）,0,2"></s:hidden>
        			<s:hidden id="hiddenamountFundingEnd" name="hidden" value="本次拨款金额（结束时间）,0,2"></s:hidden>
		  		</td>	
		  			<td width="15%" style="padding: 4px 3px; text-align:right">
		   	  		项目计划拨款金额
		   	  	</td>
			 	<td  width="35%" style="padding: 4px 8px; text-align: left">
		  	 		<input type="text" id="planFundingStart" 
		  	 		name="planFundingStart" class="inputA" 
		  	 		style="width:100px;"
		  	 		onblur="upms.upmsUtils.blurTextCheck(this,'项目计划拨款金额（开始时间）',0,2);" 
        			onfocus="upms.upmsUtils.textFocus(this)"/>
		  	 		&nbsp;-&nbsp;
		  	 		<input type="text" id="planFundingEnd" 
		  	 		name="planFundingEnd" class="inputA" 
		  	 		style="width:100px;" 
		  	 		onblur="upms.upmsUtils.blurTextCheck(this,'项目计划拨款金额（结束时间）',0,2);" 
        			onfocus="upms.upmsUtils.textFocus(this)"/>
        			<s:hidden id="hiddenplanFundingStart" name="hidden" value="项目计划拨款金额（开始时间）,0,2"></s:hidden>
        			<s:hidden id="hiddenplanFundingEnd" name="hidden" value="项目计划拨款金额（结束时间）,0,2"></s:hidden>
		  		</td>	
			</tr>
			<tr>
			  	
		  		<td width="10%" style="padding: 4px 3px; text-align:right">
		   	  		拨款日期
		   	  	</td>
			 	<td  width="40%"  style="padding: 4px 8px; text-align: left">
		  	 		<input type="text" id="appropriationTimeStart" 
		  	 		name="appropriationTimeStart" 
		  	 		class="txt w184p Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
		  	 		style="width:100px;" />
		  	 		&nbsp;-&nbsp;
		  	 		<input type="text" id="appropriationTimeEnd" 
		  	 		name="appropriationTimeEnd" 
		  	 		class="txt w184p Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
		  	 		style="width:100px;" />
		  		</td>	
		  		<td width="15%" style="padding: 4px 3px; text-align:right">
		   	  		备注
		   	  	</td>
			 	<td width="35%" style="padding: 4px 8px; text-align: left">
		  	 		<input type="text" id="remark" name="remark" class="inputA" 
		  	 		style="width:14.8em;"/>
		  		</td>	
			</tr>
			<c:if test="${projecTypeManager==true}">
			<tr>
		  		<td width="10%" style="padding: 4px 3px; text-align:right">
		   	  	   	项目分类
		   	     </td>
			  	<td colspan="3" width="40%"  style="padding: 4px 8px; text-align: left">
			  		<div>
					<s:if test="%{isPlanningDept == true}">
					<s:select style="width:12em;" list="deptList" 
						label="abc" listKey="deptId"
						listValue="deptName" id="typeId1" 
						name="selectedDept" value="%{selectedDept}">
					</s:select>
					</s:if> 
					<s:select style="width:12em;" list="typeId1List" 
						label="abc" listKey="typeId"
						listValue="typeShowName" id="typeId2" 
						name="typeId1" value="%{typeId1}">
					</s:select>
					<s:select style="width:12em;" list="typeId2List" 
						label="abc" listKey="typeId"
						listValue="typeShowName" id="typeId3" 
						name="typeId2" value="%{typeId2}">
					</s:select>
					</div>
			   </td>	
			</tr>
		</c:if>
		<tr>
			<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%" colspan="6">
		
				<tag:auth code="ss.contractdata.queryBtn">
				<input type="button" class="button" name="queryBtn" id="queryBtn" value="查询">
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
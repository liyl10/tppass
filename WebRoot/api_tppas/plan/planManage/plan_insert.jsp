<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/plan/planManage/js/plan_insert.js"></script>
<s:hidden id="typeId" name="tplan.tprojectType.typeId" value="%{projectType2}"></s:hidden>
<s:hidden id="planFlag" name="tplan.planFlag" value="%{projectType1}"></s:hidden>
<s:hidden id="typeName" name="tplan.typeName" value="%{projectType2Name}"></s:hidden>
<s:hidden id="planFlagName" name="tplan.planFlagName" value="%{projectType1Name}"></s:hidden>
<s:hidden id="planYear" name="tplan.planYear" value="%{planYear}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">分计划编制</div>
						
				<!-- 保存按钮提示信息 -->
				<label id="comfirmNext" style="display: none"><s:text name="comfirmSaveNext"/></label>
				<!-- 项目根目录 -->
				<div class=requirecolor id="errInfo"></div>
				<table width="100%" class="t-entRegFrm" cellspacing="0" cellpadding="0">
					<tr>
						<td width="40%" style="padding: 4px 8px; text-align: right">
							计划项目类别
						</td>
						<td width="60%" style="padding: 4px 8px; text-align: left">
							<s:property value='%{projectType1Name}' escape='true'/>
						</td>
					</tr>
					<tr>
						<td width="40%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>分计划名称
						</td>
						<td width="60%" style="padding: 4px 8px; text-align: left">
							<input id="planName" name="tplan.planName" 
							value="<s:property value='%{projectType2Name}' escape='true'/>"
							type="text" style="width: 14em; height:1.6em;" class="inputA"
							maxlength="15" onblur="upms.upmsUtils.blurTextCheck(this,'分计划名称',1,-1)"
							onfocus="upms.upmsUtils.textFocus(this)"/>
							<s:hidden id="hiddenplanName" name="hidden" value="分计划名称,1,-1"></s:hidden>
						</td>
					</tr>
					<tr>
						<td width="40%" style="padding: 4px 8px; text-align: right">
							计划年度
						</td>
						<td width="60%" style="padding: 4px 8px; text-align: left">
							<s:property value='%{planYear}' escape='true'/>
						</td>
					</tr>
					<tr>
						<td width="40%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>计划批次
						</td>
						<td width="60%" style="padding: 4px 8px; text-align: left">
							<s:select style="width:15.5em;" list="planBatchList" 
							listKey="itemId" label="abc" listValue="itemName"
							id="planBatch" name="tplan.planBatch">
							</s:select>
						</td><s:hidden id="hiddenplanBatch" name="hidden" value="计划批次"></s:hidden>
					</tr>
				</table>
				<div align="center" >
					<input type="button" id="okBtn" class="button add" href="javascript: void(0);" onclick="next();" value="下一步">
				</div>
			</div>
		</div>
	</div>
</div>

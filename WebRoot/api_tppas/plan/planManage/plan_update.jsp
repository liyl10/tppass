<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/plan/planManage/js/plan_update.js"></script>
<s:hidden id="planId" name="tplan.planId" value="%{tplan.planId}"></s:hidden>
<s:hidden id="typeId" name="tplan.tprojectType.typeId" value="%{tplan.tprojectType.typeId}"></s:hidden>
<s:hidden id="planFlag" name="tplan.planFlag" value="%{tplan.planFlag}"></s:hidden>
<s:hidden id="typeName" name="tplan.typeName" value="%{tplan.typeName}"></s:hidden>
<s:hidden id="planFlagName" name="tplan.planFlagName" value="%{tplan.planFlagName}"></s:hidden>
<s:hidden id="planYear" name="tplan.planYear" value="%{tplan.planYear}"></s:hidden>
<s:hidden id="planApplyStatus" name="planApplyStatus" value="%{planApplyStatus}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">分计划修改</div>
						
				<!-- 保存按钮提示信息 -->
				<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
				<!-- 项目根目录 -->
				<div class=requirecolor id="errInfo"></div>
				<table width="100%" class="t-entRegFrm" cellspacing="0" cellpadding="0">
					<tr>
						<td width="40%" style="padding: 4px 8px; text-align: right">
							计划项目类别
						</td>
						<td width="60%" style="padding: 4px 8px; text-align: left">
							<s:property value='%{tplan.planFlagName}' escape='true'/>
						</td>
					</tr>
					<tr>
						<td width="40%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>分计划名称
						</td>
						<td width="60%" style="padding: 4px 8px; text-align: left">
							<input id="planName" name="tplan.planName" 
							value="<s:property value='%{tplan.planName}' escape='true'/>"
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
							<s:property value='%{tplan.planYear}' escape='true'/>
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
						</td>
						<s:hidden id="planBatchValue" name="hidden" value="%{tplan.planBatch}"></s:hidden>
						<s:hidden id="hiddenplanBatch" name="hidden" value="计划批次"></s:hidden>
					</tr>
				</table>
				<s:if test="%{planApplyStatus==1 }">
				<div style=" margin-bottom: 22px;">
					<div style="float: left;">
						<input class="button" type="button" id="deleteBatchBtn" value="删除" onclick="deleteBatchProject();"/>&nbsp;
					</div>
					<div style="float: right;">
						<input class="button" type="button" id="selectProjectBtn" value="选择项目" onclick="selectProject();"/>&nbsp;
						&nbsp;
					</div>
				</div>
				</s:if>
				<div>&nbsp;</div>
				<!-- 查询结果列表S -->
				<div id="resultDiv"></div>
				<!-- 查询结果列表E -->
				<div style="width:100%;text-align: center;">
					<s:if test="%{planApplyStatus==1 }">
						<input class="button" type="button" id="savePlanBtn" value="提交" onclick="savePlan();"/>
					</s:if>
					<input class="button" type="button" id="backPlanBtn" value="返回" onclick="backPlan();"/>
				</div>
			</div>
		</div>
	</div>
</div>

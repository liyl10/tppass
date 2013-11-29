<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/other/js/supervisor_contractinfo.js"></script>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<!-- 修改按钮提示信息 -->
<label id="comfirmUpdate" style="display: none"><s:text name="confirm_update_info"/></label>
<!-- 下一步按钮提示信息 -->
<label id="comfirmNext" style="display: none"><s:text name="confirm_save_and_next_info"/></label>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">对照合同项目任务完成情况</div>
				<div class="abuot03">
					<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
					 	<tr>
						    <td align="right" width="15%">项目进展情况</td>
						    <td colspan="4">
						    	<s:radio name="tprojectCompleteInfo.projectSchedule" value="%{tprojectCompleteInfo.projectSchedule}" 
								list="%{projectProgress}" listKey="itemId" listValue="itemName" onchange="upms.upmsUtils.radioChange(this)"></s:radio>
						    </td>
					    </tr>
  						<tr>
    						<td align="right" width="15%">影响项目进展原因</td>
						    <td colspan="4">
						    	<s:checkboxlist name="selectedProjectStopReason" list="%{projectStopReason}"  
									listKey="itemId" listValue="itemName" onclick="checkFocus('selectedProjectStopReason');">
								</s:checkboxlist>
								<s:hidden id="hiddenselectedProjectStopReason" name="hidden" value="影响项目进展原因"></s:hidden>
						    </td>
						</tr>
						<tr>
							<td rowspan="5" align="right" width="15%">技术指标完成情况</td>
							<td align="center" width="29%">合同要求</td>
							<td align="center" width="29%">实际完成情况</td>
						</tr>
						<s:iterator value="technicalList" status="rowData">
							<tr id="capitalTr%{#rowData.count}">
								<s:hidden id="technicalCompleteInfo%{#rowData.count}" name="technicalList[%{#rowData.count}].technicalCompleteInfo" value="%{technicalCompleteInfo}"></s:hidden>
								<s:hidden id="deleteFlag%{#rowData.count}" name="technicalList[%{#rowData.count}].deleteFlag" value="%{deleteFlag}"></s:hidden>
								<td width="29%">
									<input type="text" class="inputA" id="technicalContractRequire<s:property value='%{#rowData.count}' escape='true'/>" name="technicalList[<s:property value='%{#rowData.count}' escape='true'/>].technicalContractRequire" value="<s:property value='%{technicalContractRequire}' escape='true'/>" maxlength=300 style="width:85%;ime-mode:disabled;"/>
								</td>
								<td width="29%">
									<input type="text" class="inputA" id="realCompleteInfo<s:property value='%{#rowData.count}' escape='true'/>" name="technicalList[<s:property value='%{#rowData.count}' escape='true'/>].realCompleteInfo" value="<s:property value='%{realCompleteInfo}' escape='true'/>" maxlength=300 style="width:85%;ime-mode:disabled;"/>
								</td>
							</tr>
						</s:iterator>
						<tr>
							<td rowspan="5" align="right">经济指标完成情况</td>
							<td>
								<div align="center">
									<strong>效益类别</strong>
								</div>
							</td>
							<td align="center">
								<strong>合同约定额度</strong>
							</td>
							<td colspan="2" align="center">
								<strong>实际完成额度</strong>
							</td>
						</tr>
						<tr>
							<td align="right">销售收入</td>
							<td>
								<input type="text" class="inputA" id="sellContract" name="tprojectCompleteInfo.sellContract" value="<s:property value='%{tprojectCompleteInfo.sellContract}' escape='true'/>" style="width:78%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'合同约定额度销售收入',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>万元
								<s:hidden id="hiddensellContract" name="hidden" value="合同约定额度销售收入,1,2"></s:hidden>
							</td>
							<td>
								<input type="text" class="inputA" id="sellReal" name="tprojectCompleteInfo.sellReal" value="<s:property value='%{tprojectCompleteInfo.sellReal}' escape='true'/>" style="width:75%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'实际完成额度销售收入',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>万元
								<s:hidden id="hiddensellReal" name="hidden" value="实际完成额度销售收入,1,2"></s:hidden>
							</td>
						</tr>
						<tr>
							<td align="right">利润总额</td>
							<td>
								<input type="text" class="inputA" id="profitContract" name="tprojectCompleteInfo.profitContract" value="<s:property value='%{tprojectCompleteInfo.profitContract}' escape='true'/>" style="width:78%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'合同约定额度利润总额',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>万元
								<s:hidden id="hiddenprofitContract" name="hidden" value="合同约定额度利润总额,1,2"></s:hidden>
							</td>
							<td>
							 	<input type="text" class="inputA" id="profitReal" name="tprojectCompleteInfo.profitReal" value="<s:property value='%{tprojectCompleteInfo.profitReal}' escape='true'/>" style="width:75%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'实际完成额度利润总额',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>万元
								<s:hidden id="hiddenprofitReal" name="hidden" value="实际完成额度利润总额,1,2"></s:hidden>
							</td>
						</tr>
						<tr>
							<td align="right">税收总额</td>
							<td>
								<input type="text" class="inputA" id="taxContract" name="tprojectCompleteInfo.taxContract" value="<s:property value='%{tprojectCompleteInfo.taxContract}' escape='true'/>" style="width:78%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'合同约定额度税收总额',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>万元
								<s:hidden id="hiddentaxContract" name="hidden" value="合同约定额度税收总额,1,2"></s:hidden>
							</td>
							<td>
								<input type="text" class="inputA" id="taxReal" name="tprojectCompleteInfo.taxReal" value="<s:property value='%{tprojectCompleteInfo.taxReal}' escape='true'/>" style="width:75%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'实际完成额度税收总额',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>万元
								<s:hidden id="hiddentaxReal" name="hidden" value="实际完成额度税收总额,1,2"></s:hidden>
							</td>
						</tr>
						<tr>
							<td align="right">创汇</td>
							<td>
								<input type="text" class="inputA" id="exportContract" name="tprojectCompleteInfo.exportContract" value="<s:property value='%{tprojectCompleteInfo.exportContract}' escape='true'/>" style="width:78%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'合同约定额度创汇',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>万美元
								<s:hidden id="hiddenexportContract" name="hidden" value="合同约定额度创汇,1,2"></s:hidden>
							</td>
							<td>
								<input type="text" class="inputA" id="exportReal" name="tprojectCompleteInfo.exportReal" value="<s:property value='%{tprojectCompleteInfo.exportReal}' escape='true'/>" style="width:75%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'实际完成额度创汇',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>万美元
								<s:hidden id="hiddenexportReal" name="hidden" value="实际完成额度创汇,1,2"></s:hidden>
							</td>
						</tr>
						<tr>
							<td align="right">说    明</td>
							<td colspan="4">
								<p>（技术指标、经济指标与预期差距较大需分析原因，解决措施；）</p>
								<textarea class="inputA" id="commentInfo" name="tprojectCompleteInfo.commentInfo" style="width:98%;height:150px" onblur="upms.upmsUtils.blurTextCheck(this,'说明',1,8,1000)" onfocus="upms.upmsUtils.textFocus(this)" onkeyup="upms.upmsUtils.checkTextareaLength(this, 1000);"><s:property value="%{tprojectCompleteInfo.commentInfo}" escape="true"/></textarea>
								<s:hidden id="hiddencommentInfo" name="hidden" value="说明,1,8,1000"></s:hidden>
							</td>
						</tr>
					</table>
					<br/>
					<s:hidden id="isEdit" name="isEdit" value="%{isEdit}"></s:hidden>
					<s:hidden id="supervisorId" name="supervisorId" value="%{supervisorId}"></s:hidden>
					<s:hidden id="projectCompleteInfoId" name="tprojectCompleteInfo.projectCompleteInfoId" value="%{tprojectCompleteInfo.projectCompleteInfoId}"></s:hidden>
					<s:hidden id="deleteFlag" name="tprojectCompleteInfo.deleteFlag" value="%{tprojectCompleteInfo.deleteFlag}"></s:hidden>
					<s:hidden id="remark" name="tprojectCompleteInfo.remark" value="%{tprojectCompleteInfo.remark}"></s:hidden>
					<s:if test="%{tprojectCompleteInfo.projectCompleteInfoId!=null&&tprojectCompleteInfo.projectCompleteInfoId!=''}">
						<s:hidden id="createTime" name="tprojectCompleteInfo.createTime" value="%{tprojectCompleteInfo.createTime}"></s:hidden>
					</s:if>
					<s:hidden id="createUser" name="tprojectCompleteInfo.createUser" value="%{tprojectCompleteInfo.createUser}"></s:hidden>
					<s:hidden id="updateUser" name="tprojectCompleteInfo.updateUser" value="%{tprojectCompleteInfo.updateUser}"></s:hidden>
					<div align="center">
						<s:if test="%{isEdit==1}">
							<input type="button" class="button add" id="saveBut" name="saveBtu" value="保存">
							&nbsp;
							<input type="button" class="button save" id="nextBut" name="nextBtu" value="下一步"/>
						</s:if>
						<s:else>
							<input type="button" class="button save" id="nextStep" name="nextStep" href="javascript: void(0);" value="下一步"/>
						</s:else>
					</div>
	 			</div>
 	 		</div>
   		</div>
  	</div>
</div>

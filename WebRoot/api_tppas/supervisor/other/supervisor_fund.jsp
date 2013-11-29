<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/other/js/supervisor_fund.js"></script>
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
			<div class="abuot07">资金到位/使用情况 </div>
			<div class="abuot03">
				<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
				  <tr>
				    <td colspan="6" style="padding: 4px 8px; text-align: right"><div align="center"><strong>资金到位情况</strong><div align="right"><strong>单位：万元</strong></div></div></td>
				   	</tr>
				  <tr>
				    <td></td>
				    <td align="center">项目总经费</td>
				    <td align="center">市拨经费</td>
				    <td align="center">企业自筹</td>
				    <td align="center">银行贷款</td>
				    <td align="center">其他</td>
				  </tr>
				  <tr>
				    <td align="right">计划数</td>
				    <td>
				    	<input type="text" class="inputA" id="planTotal" name="tsupervisorFundB.planTotal"  value="<s:property value='%{tsupervisorFundB.planTotal}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'项目总经费计划数',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenplanTotal" name="hidden" value="项目总经费计划数,1,2"></s:hidden>
				    </td>
				    <td>
				    	<input type="text" class="inputA" id="planCity" name="tsupervisorFundB.planCity"  value="<s:property value='%{tsupervisorFundB.planCity}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'市拨经费计划数',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenplanCity" name="hidden" value="市拨经费计划数,1,2"></s:hidden>
				    </td>
				    <td>
				    	<input type="text" class="inputA" id="planCompany" name="tsupervisorFundB.planCompany"  value="<s:property value='%{tsupervisorFundB.planCompany}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'企业自筹计划数',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenplanCompany" name="hidden" value="企业自筹计划数,1,2"></s:hidden>
				    </td>
				    <td>
				    	<input type="text" class="inputA" id="planBank" name="tsupervisorFundB.planBank"  value="<s:property value='%{tsupervisorFundB.planBank}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'银行贷款计划数',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenplanBank" name="hidden" value="银行贷款计划数,1,2"></s:hidden>
				    </td>
				    <td>
				    	<input type="text" class="inputA" id="planOther" name="tsupervisorFundB.planOther"  value="<s:property value='%{tsupervisorFundB.planOther}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'其他计划数',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenplanOther" name="hidden" value="其他计划数,1,2"></s:hidden>
				    </td>
				  </tr>
				  <tr>
				    <td align="right">实际数</td>
				    <td>
				    	<input type="text" class="inputA" id="realTotal" name="tsupervisorFundB.realTotal"  value="<s:property value='%{tsupervisorFundB.realTotal}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'项目总经费实际数',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"moneyFlag="money"/>
				    	<s:hidden id="hiddenrealTotal" name="hidden" value="项目总经费实际数,1,2"></s:hidden>
				    </td>
				    <td>
				    	<input type="text" class="inputA" id="realCity" name="tsupervisorFundB.realCity"  value="<s:property value='%{tsupervisorFundB.realCity}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'市拨经费实际数',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenrealCity" name="hidden" value="市拨经费实际数,1,2"></s:hidden>
				    </td>
				    <td>
				    	<input type="text" class="inputA" id="realCompany" name="tsupervisorFundB.realCompany"  value="<s:property value='%{tsupervisorFundB.realCompany}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'企业自筹实际数',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenrealCompany" name="hidden" value="企业自筹实际数,1,2"></s:hidden>
				    </td>
				    <td>
				    	<input type="text" class="inputA" id="realBank" name="tsupervisorFundB.realBank"  value="<s:property value='%{tsupervisorFundB.realBank}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'银行贷款实际数',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenrealBank" name="hidden" value="银行贷款实际数,1,2"></s:hidden>
				    </td>
				    <td>
				    	<input type="text" class="inputA" id="realOther" name="tsupervisorFundB.realOther"  value="<s:property value='%{tsupervisorFundB.realOther}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'其他实际数',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenrealOther" name="hidden" value="其他实际数,1,2"></s:hidden>
				    </td>
				  </tr>
				  <tr>
				    <td colspan="6" align="right">
					    <div align="center">
					    	<strong>资金使用情况</strong>
					    	<div align="right">
					    		<strong>单位：万元</strong>
					    	</div>
					    </div>
				    </td>
				    </tr>
				  <tr>
				    <td align="center">支出项目</td>
				    <td align="center">总经费使用情况</td>
				    <td align="center">市拨经费使用情况</td>
				    <td align="center">支出项目</td>
				    <td align="center">总经费使用情况</td>
				    <td align="center">市拨经费使用情况</td>
				  </tr>
				  <tr>
				    <td align="right">人员费</td>
				    <td>
				    	<input type="text" class="inputA" id="personnelTotalCost" name="tsupervisorFundB.personnelTotalCost"  value="<s:property value='%{tsupervisorFundB.personnelTotalCost}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'总经费使用情况人员费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money" />
				    	<s:hidden id="hiddenpersonnelTotalCost" name="hidden" value="总经费使用情况人员费,1,2"></s:hidden>
				    </td>
				    <td>
				   		<input type="text" class="inputA" id="personnelCityCost" name="tsupervisorFundB.personnelCityCost"  value="<s:property value='%{tsupervisorFundB.personnelCityCost}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'市拨经费使用情况人员费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenpersonnelCityCost" name="hidden" value="市拨经费使用情况人员费,1,2"></s:hidden>
				    </td>
				    <td align="right">调研费</td>
				    <td>
				    	<input type="text" class="inputA" id="surveyTotalCost" name="tsupervisorFundB.surveyTotalCost"  value="<s:property value='%{tsupervisorFundB.surveyTotalCost}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'总经费使用情况调研费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddensurveyTotalCost" name="hidden" value="总经费使用情况调研费,1,2"></s:hidden>
				    </td>
				    <td>
				    	<input type="text" class="inputA" id="surveyCityCost" name="tsupervisorFundB.surveyCityCost"  value="<s:property value='%{tsupervisorFundB.surveyCityCost}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'市拨经费使用情况调研费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddensurveyCityCost" name="hidden" value="市拨经费使用情况调研费,1,2"></s:hidden>
				    </td>
				  </tr>
				  <tr>
				    <td align="right">设备费</td>
				    <td>
				    	<input type="text" class="inputA" id="equipmentTotalCost" name="tsupervisorFundB.equipmentTotalCost"  value="<s:property value='%{tsupervisorFundB.equipmentTotalCost}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'总经费使用情况设备费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenequipmentTotalCost" name="hidden" value="总经费使用情况设备费,1,2"></s:hidden>
				    </td>
				    <td>
				    	<input type="text" class="inputA" id="equipmentCityCost" name="tsupervisorFundB.equipmentCityCost"  value="<s:property value='%{tsupervisorFundB.equipmentCityCost}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'市拨经费使用情况设备费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenequipmentCityCost" name="hidden" value="市拨经费使用情况设备费,1,2"></s:hidden>
				    </td>
				    <td align="right">差旅费</td>
				    <td>
				    	<input type="text" class="inputA" id="travelTotalCost" name="tsupervisorFundB.travelTotalCost"  value="<s:property value='%{tsupervisorFundB.travelTotalCost}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'总经费使用情况差旅费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddentravelTotalCost" name="hidden" value="总经费使用情况差旅费,1,2"></s:hidden>
				    </td>
				    <td>
				    	<input type="text" class="inputA" id="travelCityCost" name="tsupervisorFundB.travelCityCost"  value="<s:property value='%{tsupervisorFundB.travelCityCost}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'市拨经费使用情况差旅费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddentravelCityCost" name="hidden" value="市拨经费使用情况差旅费,1,2"></s:hidden>
				    </td>
				  </tr>
				  <tr>
				    <td align="right">能源材料费</td>
				    <td>
				    	<input type="text" class="inputA" id="energyTotalCost" name="tsupervisorFundB.energyTotalCost"  value="<s:property value='%{tsupervisorFundB.energyTotalCost}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'总经费使用情况能源材料费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenenergyTotalCost" name="hidden" value="总经费使用情况能源材料费,1,2"></s:hidden>
				    </td>
				    <td>
				    	<input type="text" class="inputA" id="energyCityCost" name="tsupervisorFundB.energyCityCost"  value="<s:property value='%{tsupervisorFundB.energyCityCost}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'市拨经费使用情况能源材料费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenenergyCityCost" name="hidden" value="市拨经费使用情况能源材料费,1,2"></s:hidden>
				    </td>
				    <td align="right">会议费</td>
				    <td>
				    	<input type="text" class="inputA" id="meetingTotalCost" name="tsupervisorFundB.meetingTotalCost"  value="<s:property value='%{tsupervisorFundB.meetingTotalCost}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'总经费使用情况会议费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenmeetingTotalCost" name="hidden" value="总经费使用情况会议费,1,2"></s:hidden>
				    </td>
				    <td>
				    	<input type="text" class="inputA" id="meetingCityCost" name="tsupervisorFundB.meetingCityCost"  value="<s:property value='%{tsupervisorFundB.meetingCityCost}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'市拨经费使用情况会议费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenmeetingCityCost" name="hidden" value="市拨经费使用情况会议费,1,2"></s:hidden>
				    </td>
				  </tr>
				  <tr>
				    <td align="right">试验外协费</td>
				    <td>
				    	<input type="text" class="inputA" id="testTotalCost" name="tsupervisorFundB.testTotalCost"  value="<s:property value='%{tsupervisorFundB.testTotalCost}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'总经费使用情况试验外协费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddentestTotalCost" name="hidden" value="总经费使用情况试验外协费,1,2"></s:hidden>
				    </td>
				    <td>
				    	<input type="text" class="inputA" id="testCityCost" name="tsupervisorFundB.testCityCost"  value="<s:property value='%{tsupervisorFundB.testCityCost}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'市拨经费使用情况试验外协费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddentestCityCost" name="hidden" value="市拨经费使用情况试验外协费,1,2"></s:hidden>
				    </td>
				    <td align="right">管理费</td>
				    <td>
				    	<input type="text" class="inputA" id="managerTotalCost" name="tsupervisorFundB.managerTotalCost"  value="<s:property value='%{tsupervisorFundB.managerTotalCost}' escape='true'/>" style="width:95%;ime-mode:disabled;"  maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'总经费使用情况管理费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenmanagerTotalCost" name="hidden" value="总经费使用情况管理费,1,2"></s:hidden>
				    </td>
				    <td>
				    	<input type="text" class="inputA" id="managerCityCost" name="tsupervisorFundB.managerCityCost"  value="<s:property value='%{tsupervisorFundB.managerCityCost}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'市拨经费使用情况管理费',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenmanagerCityCost" name="hidden" value="市拨经费使用情况管理费,1,2"></s:hidden>
				    </td>
				  </tr>
				  <tr>
				    <td width="18%" align="right">其他</td>
				    <td width="15%">
				    	<input type="text" class="inputA" id="otherTotalCost" name="tsupervisorFundB.otherTotalCost"  value="<s:property value='%{tsupervisorFundB.otherTotalCost}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'总经费使用情况其他',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenotherTotalCost" name="hidden" value="总经费使用情况其他,1,2"></s:hidden>
				    </td>
				    <td width="17%">
				    	<input type="text" class="inputA" id="otherCityCost" name="tsupervisorFundB.otherCityCost"  value="<s:property value='%{tsupervisorFundB.otherCityCost}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'市拨经费使用情况其他',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
				    	<s:hidden id="hiddenotherCityCost" name="hidden" value="市拨经费使用情况其他,1,2"></s:hidden>
				    </td>
				    <td width="15%" align="right">&nbsp;</td>
				    <td width="16%">&nbsp;</td>
				    <td width="19%">&nbsp;</td>
				  </tr>
				  <tr>
				    <td align="right">说    明</td>
				    <td colspan="5"><p>（包括资金落实情况、使用及存在的问题）</p>
				        <textarea id="commentInfo" name="tsupervisorFundB.commentInfo" class="inputA" style="width:700px;height:150px" onblur="upms.upmsUtils.blurTextCheck(this,'说明',1,8,1000)" onfocus="upms.upmsUtils.textFocus(this)" onkeyup="upms.upmsUtils.checkTextareaLength(this, 1000);"><s:property value="%{tsupervisorFundB.commentInfo}" escape="true"/></textarea>
				    	<s:hidden id="hiddencommentInfo" name="hidden" value="说明,1,8,1000"></s:hidden>
				    </td>
				  </tr>
				</table>
				<br/>
				<s:hidden id="isEdit" name="isEdit" value="%{isEdit}"></s:hidden>
				<s:hidden id="supervisorId" name="supervisorId" value="%{supervisorId}"></s:hidden>
				<s:hidden id="fundBId" name="tsupervisorFundB.fundBId" value="%{tsupervisorFundB.fundBId}"></s:hidden>
				<s:hidden id="deleteFlag" name="tsupervisorFundB.deleteFlag" value="%{tsupervisorFundB.deleteFlag}"></s:hidden>
				<s:hidden id="remark" name="tsupervisorFundB.remark" value="%{tsupervisorFundB.remark}"></s:hidden>
				<s:if test="%{tsupervisorFundB.fundBId!=null&&tsupervisorFundB.fundBId!=''}">
					<s:hidden id="createTime" name="tsupervisorFundB.createTime" value="%{tsupervisorFundB.createTime}"></s:hidden>
				</s:if>
				<s:hidden id="createUser" name="tsupervisorFundB.createUser" value="%{tsupervisorFundB.createUser}"></s:hidden>
				<s:hidden id="updateUser" name="tsupervisorFundB.updateUser" value="%{tsupervisorFundB.updateUser}"></s:hidden>
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

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/other/js/supervisor_companyinfo.js"></script>
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
				<div class="abuot07">企业发展情况</div>
				<div class="abuot03">
					<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
						<tr>
					    	<td colspan="5" align="right">单位：万元</td>
					    </tr>
						<tr>
						  	<td width="20%" align="center">产值</td>
						    <td width="20%" align="center">销售收入</td>
						    <td width="20%" align="center">净利润总额</td>
						    <td width="20%" align="center">企业缴税总额</td>
						    <td width="20%" align="center">创汇（万美元）</td>
					    </tr>
					    <tr>
						    <td>
						    	<input type="text" class="inputA" id="companyOutput" name="tcompanyDevelopInfo.companyOutput" value="<s:property value='%{tcompanyDevelopInfo.companyOutput}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'产值',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
						    	<s:hidden id="hiddencompanyOutput" name="hidden" value="产值,1,2"></s:hidden>
						    </td>
						    <td>
						    	<input type="text" class="inputA" id="companySell" name="tcompanyDevelopInfo.companySell" value="<s:property value='%{tcompanyDevelopInfo.companySell}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'销售收入',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
						    	<s:hidden id="hiddencompanySell" name="hidden" value="销售收入,1,2"></s:hidden>
						    </td>
						    <td>
						    	<input type="text" class="inputA" id="companyProfit" name="tcompanyDevelopInfo.companyProfit" value="<s:property value='%{tcompanyDevelopInfo.companyProfit}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'净利润总额',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
						    	<s:hidden id="hiddencompanyProfit" name="hidden" value="净利润总额,1,2"></s:hidden>
						    </td>
						    <td>
						    	<input type="text" class="inputA" id="companyTax" name="tcompanyDevelopInfo.companyTax" value="<s:property value='%{tcompanyDevelopInfo.companyTax}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'企业缴税总额',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
						    	<s:hidden id="hiddencompanyTax" name="hidden" value="企业缴税总额,1,2"></s:hidden>
						    </td>
						    <td>
						    	<input type="text" class="inputA" id="companyExport" name="tcompanyDevelopInfo.companyExport" value="<s:property value='%{tcompanyDevelopInfo.companyExport}' escape='true'/>" style="width:95%;ime-mode:disabled;" maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'创汇',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);" moneyFlag="money"/>
						    	<s:hidden id="hiddencompanyExport" name="hidden" value="创汇,1,2"></s:hidden>
						    </td>
					    </tr>
					    <tr>
					    	<td align="right" width="20%" >其他成果类别</td>
					    	<td colspan="4">
					        	<textarea class="inputA" id="companyDevelopComment" name="tcompanyDevelopInfo.companyDevelopComment" style="width:95%;height:150px" onblur="upms.upmsUtils.blurTextCheck(this,'其他成果类别',1,8,1000)" onfocus="upms.upmsUtils.textFocus(this)" onkeyup="upms.upmsUtils.checkTextareaLength(this, 1000);"><s:property value="%{tcompanyDevelopInfo.companyDevelopComment}" escape="true"/></textarea>
					        	<s:hidden id="hiddencompanyDevelopComment" name="hidden" value="其他成果类别,1,8,1000"></s:hidden>
					        </td>
					    </tr>
					</table>
					<br/>
					<s:hidden id="isEdit" name="isEdit" value="%{isEdit}"></s:hidden>
					<s:hidden id="supervisorId" name="supervisorId" value="%{supervisorId}"></s:hidden>
					<s:hidden id="companyDevelopInfoId" name="tcompanyDevelopInfo.companyDevelopInfoId" value="%{tcompanyDevelopInfo.companyDevelopInfoId}"></s:hidden>
					<s:hidden id="deleteFlag" name="tcompanyDevelopInfo.deleteFlag" value="%{tcompanyDevelopInfo.deleteFlag}"></s:hidden>
					<s:hidden id="remark" name="tcompanyDevelopInfo.remark" value="%{tcompanyDevelopInfo.remark}"></s:hidden>
					<s:if test="%{tcompanyDevelopInfo.companyDevelopInfoId!=null&&tcompanyDevelopInfo.companyDevelopInfoId!=''}">
						<s:hidden id="createTime" name="tcompanyDevelopInfo.createTime" value="%{tcompanyDevelopInfo.createTime}"></s:hidden>
					</s:if>
					<s:hidden id="createUser" name="tcompanyDevelopInfo.createUser" value="%{tcompanyDevelopInfo.createUser}"></s:hidden>
					<s:hidden id="updateUser" name="tcompanyDevelopInfo.updateUser" value="%{tcompanyDevelopInfo.updateUser}"></s:hidden>
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

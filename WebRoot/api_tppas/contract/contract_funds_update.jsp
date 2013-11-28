<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/contract/js/contract_funds_update.js"></script>
<form id="CoverForm">
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
	<div class="Servicel04">
		<div class="abuot02">
			<div class="abuot07">
			<s:if test="%{insertOrUpdateFlag == 1}">
				新增拨款单
			</s:if>
			<s:else>
				修改拨款单
			</s:else>
			</div>
			<div class="abuot03">
<s:hidden id="tcontractId" name="tcontractId" value="%{tcontractId}"></s:hidden>
<s:hidden id="appropriationSingleId" name="tappropriationSingle.appropriationSingleId" value="%{tappropriationSingle.appropriationSingleId}"></s:hidden>
<s:hidden id="mainFlag" name="mainFlag" value="%{mainFlag}"></s:hidden>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td width="15%" style="text-align:right">
    	委托任务
    </td>
    <td >
    	<s:property value='%{tappropriationSingle.tasksEntrusted}' escape='true'/>
    </td>
    <td width="15%" style="text-align:right">
    	项目承担（单位全称）
    </td>
    <td >
    	<s:property value='%{tappropriationSingle.undertaker}' escape='true'/>
    </td>
  </tr>
    <tr>
    <td width="15%" style="text-align:right">
    	开户银行及行号
    </td>
    <td >
    	<input type="text" class="inputA" maxlength="50" 
        onblur="upms.upmsUtils.blurTextCheck(this,'开户银行及行号',1,-1);" 
        onfocus="upms.upmsUtils.textFocus(this)" id="bank" 
        name="tappropriationSingle.bank" 
        value="<s:property value='%{tappropriationSingle.bank}' escape='true'/>"/>   
        <s:hidden id="hiddenbank" name="hidden" value="开户银行及行号,1,-1"></s:hidden>
    </td>
    <td width="15%" style="text-align:right">
    	帐号
    </td>
    <td >
    	<input type="text" class="inputA" maxlength="20" 
        onblur="upms.upmsUtils.blurTextCheck(this,'账号',1,9);" 
        onfocus="upms.upmsUtils.textFocus(this)" id="account" 
        name="tappropriationSingle.account" 
        value="<s:property value='%{tappropriationSingle.account}' escape='true'/>"/>   
        <s:hidden id="hiddenaccount" name="hidden" value="账号,1,9"></s:hidden>
    </td>
  </tr>
    <tr>
    <td width="15%" style="text-align:right">
    	本次拨款金额 （万元）
    </td>
    <td >
    	<input type="text" class="inputA" maxlength="13" 
        onblur="upms.upmsUtils.blurTextCheck(this,'本次拨款金额',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" id="amountFunding" 
        name="tappropriationSingle.amountFunding" 
        value="<s:property value='%{tappropriationSingle.amountFunding}' escape='true'/>"/>   
        <s:hidden id="hiddenamountFunding" name="hidden" value="本次拨款金额,1,2"></s:hidden>
    </td>
    <td width="15%" style="text-align:right">
    	项目计划拨款金额（万元）
    </td>
    <td >
    	<input type="text" class="inputA" maxlength="13" 
        onblur="upms.upmsUtils.blurTextCheck(this,'项目计划拨款金额',1,2);" 
        onfocus="upms.upmsUtils.textFocus(this)" id="planFunding" 
        name="tappropriationSingle.planFunding" 
        value="<s:property value='%{tappropriationSingle.planFunding}' escape='true'/>"/>   
        <s:hidden id="hiddenplanFunding" name="hidden" value="项目计划拨款金额,1,2"></s:hidden>
    </td>
  </tr>
  <tr>
  	<td width="15%" style="text-align:right">
    	拨款时间
    </td>
    <td colspan="3">
    	<INPUT class="txt w184p Wdate" type="text" name="tappropriationSingle.appropriationTime" 
		id="appropriationTime" value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tappropriationSingle.appropriationTime})}' />" 
	    readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" 
	    onblur="upms.upmsUtils.blurTextCheck(this,'拨款时间',1,-1);"  
	    onfocus="upms.upmsUtils.textFocus(this)"/>
	    <s:hidden id="hiddenappropriationTime" name="hidden" value="拨款时间,1,-1"></s:hidden>
    </td>
  </tr>
      <tr>
    <td width="15%" style="text-align:right">
    	备注
    </td>
    <td colspan="3">
   	<textarea id="remark" name="tappropriationSingle.remark" 
class="inputA" style="width:600px;height:80px" 
onKeyUp="upms.upmsUtils.checkTextareaLength(this, 1000);"
onblur="upms.upmsUtils.blurTextCheck(this,'备注',1,8,1000)"
onfocus="upms.upmsUtils.textFocus(this)">
<s:property value='%{tappropriationSingle.remark}' escape='true'/></textarea>
<s:hidden id="hiddenremark" name="hidden" value="备注,1,8,1000"></s:hidden>
    </td>
  </tr>
</table>
<br/>
<br/>
<br/>
<div align="center">
<s:if test="%{insertOrUpdateFlag == 1}">
		<input  type="button" id="okBtn" class="button add" href="javascript: void(0);" value="保存">
</s:if>
<s:else>
		<input  type="button" id="okBtn1" class="button add" href="javascript: void(0);" value="保存">
</s:else>
		&nbsp;
		<input  type="button" id="backBtn" class="button next" href="javascript: void(0);" value="返回">
</div>
</div>
</div>
</div>
</div>
</form>
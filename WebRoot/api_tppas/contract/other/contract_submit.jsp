<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/contract/other/js/contract_submit.js"></script>
<form id="CoverForm">
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
	<div class="Servicel04">
		<div class="abuot02">
			<div class="abuot07">
				合同审核
			</div>
			<div class="abuot03">
<s:hidden id="tcontractId" name="tcontractId" value="%{tcontractId}"></s:hidden>
<s:hidden id="contractFlag" name="contractFlag" value="%{contractFlag}"></s:hidden>
<s:hidden id="contractStatus" name="contractStatus" value="%{contractStatus}"></s:hidden>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<label id="comfirmcontractpass" style="display: none"><s:text name="comfirm_contract_pass"/></label>
<label id="comfirmcontractnopass" style="display: none"><s:text name="comfirm_contract_nopass"/></label>
<label id="comfirmcontractnopassnochange" style="display: none"><s:text name="comfirm_contract_nopass_nochange"/></label>
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td width="15%" style="text-align:right">
    	处理意见
    </td>
    <td  colspan="3">
  	<textarea id="approvalOpinion" name="approvalOpinion" 
class="inputA" style="width:600px;height:150px"
onKeyUp="upms.upmsUtils.checkTextareaLength(this, 1000);"
onblur="upms.upmsUtils.blurTextCheck(this,'处理意见',0,8,1000)"
onfocus="upms.upmsUtils.textFocus(this)">
<s:property value='%{approvalOpinion}' escape='true'/></textarea>				
		<s:hidden id="hiddenapprovalOpinion" name="hidden" value="处理意见,0,8,1000"></s:hidden>
    </td>
  </tr>
</table>
<br/>
<br/>
<br/>
<div align="center">
		<input  type="button" id="saveBtn" class="button add" href="javascript: void(0);" value="保存">
		&nbsp;
		<input  type="button" id="okBtn" class="button next" href="javascript: void(0);" value="通过">
		&nbsp;
		<input  type="button" id="noBtnModify" class="button next" href="javascript: void(0);" value="不通过（可修改）">
		&nbsp;
		<input  type="button" id="noBtnModifyNo" class="button next" href="javascript: void(0);" value="不通过（不可修改）">
</div>
</div>
</div>
</div>
</div>
</form>
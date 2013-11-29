<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/contract/highTech/js/highTech_contract_cover_credit.js"></script>
<form id="CoverForm">
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
	<div class="Servicel04">
		<div class="abuot02">
		<div align="right"> 项目编号:<s:property value='%{tcontract.tprojectApplication.projectNumber}' escape='true'/> </div>
			<div class="abuot07">西安市高新技术产业发展专项<br/>
									 &nbsp;	
							贷款贴息项目合同书	
			<br/>
									 </div>
			<div class="abuot03">	
<s:hidden id="tcontractId" name="tcontractId" value="%{tcontractId}"></s:hidden>
<s:hidden id="Flag" name="Flag" value="%{Flag}"></s:hidden>
<s:hidden id="contractStatus" name="contractStatus" value="%{contractStatus}"></s:hidden>
<s:hidden id="contractCoverId" name="tcontractCover.contractCoverId" value="%{tcontractCover.contractCoverId}"></s:hidden>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<!-- 下一步按钮提示信息 -->
<label id="comfirmSaveNext" style="display: none"><s:text name="confirm_save_and_next_info"/></label>
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td width="15%" style="text-align:right">项目名称</td>
    <td  colspan="3">
    	<s:property value='%{tcontract.tprojectApplication.projectName}' escape='true'/>
    </td>
  </tr>
  <tr>
    <td style="text-align:right">委 托 单 位 （甲方）</td>
    <td colspan="3">
    	<s:property value='%{entrustmentCompany}' escape='true'/>
    </td>
  </tr>
   <tr>
    <td style="text-align:right">承 担 单 位 （乙方）</td>
    <td colspan="3">
    	<s:property value='%{tcontract.tprojectApplication.applicationUnit}' escape='true'/>
    </td>
  </tr>
    <tr>
    <td style="text-align:right">归口管理单位（丙方）</td>
    <td colspan="3">
    	<s:property value='%{centralizedManagement}' escape='true'/>
    </td>
  </tr>
  <tr>
    <td style="text-align:right">完   成   年   限 </td>
    <td colspan="3">
    	<s:property value='%{getText("{0,date,yyyy年MM月}",{tcontract.tprojectApplication.startTime})}' />
    	&nbsp; - &nbsp;
    	<s:property value='%{getText("{0,date,yyyy年MM月}",{tcontract.tprojectApplication.endTime})}' />
    </td>
    </tr>
   <tr>
    <td style="text-align:right"><FONT color=red>*</FONT>承 担 单 位 地 址</td>
    <td colspan="3">
      <div
		align="left" style="vertical-align: middle;float:left;">
		<s:select style="width:14em;" list="address1List" label="abc" 
		     listKey="itemId"
		     listValue="itemName" id="address1" 
		     name="tcontractCover.address1" >
		   </s:select>
		   <s:hidden id="address1Value" name="address1Value" 
		    value="%{tcontractCover.address1}"></s:hidden>
		   <s:select style="width:14em;" list="address2List" label="abc" 
		     listKey="itemId"
		     listValue="itemName" id="address2" 
		     name="tcontractCover.address2" >
		   </s:select>
		   <s:hidden id="address2Value" name="address2Value" 
		    value="%{tcontractCover.address2}"></s:hidden>
		   <s:select style="width:14em;" list="address3List" label="abc" 
		     listKey="itemId"
		     listValue="itemName" id="address3" 
		     name="tcontractCover.address3" >
		   </s:select>
		   <s:hidden id="address3Value" name="address3Value" 
		    value="%{tcontractCover.address3}"></s:hidden>
  <s:hidden id="hiddenaddress3" name="hidden" value="通讯地址级联"></s:hidden> 
	</div>
	<div div style="float:left;width:4px;margin-top:0px;">&nbsp;</div>
	  <div style="float:left;width:250px;margin-top:0px;">
		<input type="text" class="inputA" id="address" name="tcontractCover.address" 
		value="<s:property value='%{tcontractCover.address}' escape='true'/>"
		onblur="blurText(this,'承担单位地址',1,0);" onfocus="focusText(this);" maxlength="20"
		/>
		<s:hidden id="hiddenaddress" name="hidden" value="承担单位地址,1,0"></s:hidden>
	  </div>
	</td>
  </tr>
  <tr>
    <td style="text-align:right"><FONT color=red>*</FONT>项目单位负责人</td>
    <td width="25%">
	    <input type="text" class="inputA" maxlength="10" onblur="blurText(this,'项目单位负责人',1,0);" 
	    onfocus="focusText(this);" id="unitCharge" name="tcontractCover.unitCharge" 
	    value="<s:property value='%{tcontractCover.unitCharge}' escape='true'/>"/>    
	    <s:hidden id="hiddenunitCharge" name="hidden" value="项目单位负责人,1,0"></s:hidden>
	</td>
    <td width="30%" >
    	&nbsp;&nbsp;<FONT color=red>*</FONT>办公电话
	    <input type="text" class="inputA" maxlength="13" onblur="blurText(this,'办公电话',1,2);" 
	    onfocus="focusText(this);" id="unitChargePhone1" name="tcontractCover.unitChargePhone1" 
	    value="<s:property value='%{tcontractCover.unitChargePhone1}' escape='true'/>"/>
	    <s:hidden id="hiddenunitChargePhone1" name="hidden" value="办公电话,1,2"></s:hidden>
	</td>
	<td width="30%" >
		&nbsp;&nbsp;<FONT color=red>*</FONT>手机
	    <input type="text" class="inputA" maxlength="11" onblur="blurText(this,'手机',1,1);" 
	    onfocus="focusText(this);" id="unitChargePhone2" name="tcontractCover.unitChargePhone2" 
	    value="<s:property value='%{tcontractCover.unitChargePhone2}' escape='true'/>"/>
	    <s:hidden id="hiddenunitChargePhone2" name="hidden" value="手机,1,1"></s:hidden>
	</td>
  </tr>
  <tr>
    <td style="text-align:right"><FONT color=red>*</FONT>项目负责人</td>
    <td width="25%">
        <input type="text" class="inputA" maxlength="10" onblur="blurText(this,'项目负责人',1,0);" 
        onfocus="focusText(this);" id="charge" name="tcontractCover.charge" 
        value="<s:property value='%{tcontractCover.charge}' escape='true'/>"/>    
        <s:hidden id="hiddencharge" name="hidden" value="项目负责人,1,0"></s:hidden>
    </td>
    <td width="30%" >
    	&nbsp;&nbsp;<FONT color=red>*</FONT>办公电话
	    <input type="text" class="inputA" maxlength="13" onblur="blurText(this,'办公电话',1,2);" 
	    onfocus="focusText(this);" id="chargePhone1" name="tcontractCover.chargePhone1" 
	    value="<s:property value='%{tcontractCover.chargePhone1}' escape='true'/>"/>
	    <s:hidden id="hiddenchargePhone1" name="hidden" value="办公电话,1,2"></s:hidden>
	</td>
	<td width="30%" >
		&nbsp;&nbsp;<FONT color=red>*</FONT>手机
	    <input type="text" class="inputA"  maxlength="11" onblur="blurText(this,'手机',1,1);" 
	    onfocus="focusText(this);" id="chargePhone2" name="tcontractCover.chargePhone2" 
	    value="<s:property value='%{tcontractCover.chargePhone2}' escape='true'/>"/>
	    <s:hidden id="hiddenchargePhone2" name="hidden" value="手机,1,1"></s:hidden>
	</td>
  </tr>
  <tr>
    <td style="text-align:right"><FONT color=red>*</FONT>项目联系人</td>
    <td width="25%">
        <input type="text" class="inputA" maxlength="10" onblur="blurText(this,'项目联系人',1,0);" 
        onfocus="focusText(this);" id="contact" name="tcontractCover.contact" 
        value="<s:property value='%{tcontractCover.contact}' escape='true'/>"/>    
        <s:hidden id="hiddencontact" name="hidden" value="项目联系人,1,0"></s:hidden>
    </td>
    <td width="30%" >
    	&nbsp;&nbsp;<FONT color=red>*</FONT>办公电话
	    <input type="text" class="inputA" maxlength="13" onblur="blurText(this,'办公电话',1,2);" 
	    onfocus="focusText(this);" id="contactPhone1" name="tcontractCover.contactPhone1" 
	    value="<s:property value='%{tcontractCover.contactPhone1}' escape='true'/>"/>
	    <s:hidden id="hiddencontactPhone1" name="hidden" value="办公电话,1,2"></s:hidden>
	</td>
	<td width="30%" >
		&nbsp;&nbsp;<FONT color=red>*</FONT>手机
	    <input type="text" class="inputA"  maxlength="11" onblur="blurText(this,'手机',1,1);" 
	    onfocus="focusText(this);" id="contactPhone2" name="tcontractCover.contactPhone2" 
	    value="<s:property value='%{tcontractCover.contactPhone2}' escape='true'/>"/>
	    <s:hidden id="hiddencontactPhone2" name="hidden" value="手机,1,1"></s:hidden>
    </td>
  </tr>
</table>
	<br/>
	<br/>
	<br/>
	<div align="center"><s:property value='%{contractComment}'/></div>
	<br/>
	<div align="center">
	<s:if test="%{Flag==0}">
		<FONT color=red>*</FONT>
		<INPUT class="txt w184p Wdate" type="text" name="tcontractCover.contractTime" 
			id="contractTime" value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tcontractCover.contractTime})}' />" 
		    readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" onblur="blurText(this,'日期',1,0);"  
		    onfocus="focusText(this);"/>
		<s:hidden id="hiddencontractTime" name="hidden" value="日期,1,0"></s:hidden>
	</s:if>
	<s:else>
		<s:property value='%{getText("{0,date,yyyy年MM月dd日}",{tcontractCover.contractTime})}' />
	</s:else>
	</div>
	<br/>
<div align="center">
	<s:if test="%{Flag==0}">
		<input  type="button" id="okBtn" class="button add" href="javascript: void(0);" value="保存">
		&nbsp;
		<input  type="button" id="nextBtn" class="button next" href="javascript: void(0);" value="下一步">
	</s:if>
	<s:else>
		<input  type="button" id="nextBtn1" class="button next" href="javascript: void(0);" value="下一步">
	</s:else>
</div>
</div>
</div>
</div>
</div>
</form>
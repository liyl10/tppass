<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/contract/highTech/js/highTech_contract_funduse.js"></script>
<form id="FunduseForm">
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
	<div class="Servicel04">
		<div class="abuot02">
			<div class="abuot07">项目经费使用表</div>
			<div class="abuot03">
<s:hidden id="tcontractId" name="tcontractId" value="%{tcontractId}"></s:hidden>
<s:hidden id="Flag" name="Flag" value="%{Flag}"></s:hidden>
<s:hidden id="contractStatus" name="contractStatus" value="%{contractStatus}"></s:hidden>
<s:hidden id="modelType" name="modelType" value="%{modelType}"></s:hidden>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<!-- 下一步按钮提示信息 -->
<label id="comfirmSaveNext" style="display: none"><s:text name="confirm_save_and_next_info"/></label>
<div align="right" style="width:100%">单位：万元（保留两位小数）</div>
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td width="10%"><div align="center">序号</div></td>
    <s:hidden id="fundUseId" name="tfunduse.fundUseId" value="%{tfunduse.fundUseId}"></s:hidden>
    <td width="20%"><div align="center">预算科目名称</div></td>
    <td width="16%"><div align="center">合计</div></td>
    <td width="25%"><div align="center">专项经费</div></td>
    <td width="29%"><div align="center">配套经费</div></td>
  </tr>
  <tr>
    <td>1</td>
    <td><FONT color=red>*</FONT>1．设备费</td>
    <td>
    	<input type="text" class="inputA" id="equipment" disabled="disabled"/>
    </td>
    <td>
    	<input type="text" disabled="disabled" class="inputA" id="equipmentSpecial" 
    	name="tfunduse.equipmentSpecial"  value="<s:property value='%{tfunduse.equipmentSpecial}' escape='true'/>" />
    </td>
    <td>
    	<input type="text" disabled="disabled" class="inputA" id="equipmentSupport" 
    	name="tfunduse.equipmentSupport"  value="<s:property value='%{tfunduse.equipmentSupport}' escape='true'/>" />
    </td>
  </tr>
  <tr>
    <td>2</td>
    <td align="center"><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;<FONT color=red>*</FONT>（1）购置设备费</div></td>
    <td>
    <input type="text" class="inputA" id="purchase" disabled="disabled" /></td>
    <td>
	    <input type="text" class="inputA" id="purchaseSpecial" name="tfunduse.purchaseSpecial"   
	    value="<s:property value='%{tfunduse.purchaseSpecial}' escape='true'/>" 
    	maxlength="13" onblur="blurText(this,'购置设备费（专项经费）',1,5);" onfocus="focusText(this);"   
    	
    	style="ime-mode: disabled;" onKeyUp="sumRow(this.id);sumtotal();sumequipment();" 
    	onpropertychange="sumRow(this.id);sumtotal();sumequipment();"/>
    	<s:hidden id="hiddenpurchaseSpecial" name="hidden" value="购置设备费（专项经费）,1,5"></s:hidden>
    </td>
    <td>
	    <input type="text" class="inputA" id="purchaseSupport" name="tfunduse.purchaseSupport"   
	    value="<s:property value='%{tfunduse.purchaseSupport}' escape='true'/>" 
    	maxlength="13" onblur="blurText(this,'购置设备费（配套经费）',1,5);" onfocus="focusText(this);"   
    	
    	style="ime-mode: disabled;" onKeyUp="sumRow(this.id);sumtotal();sumequipment();"
    	onpropertychange="sumRow(this.id);sumtotal();sumequipment();"/>
    	<s:hidden id="hiddenpurchaseSupport" name="hidden" value="购置设备费（配套经费）,1,5"></s:hidden>
    </td>
  </tr>
  <tr>
    <td>3</td>
    <td align="center"><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;<FONT color=red>*</FONT>（2）试制设备费</div></td>
    <td>
    <input type="text" class="inputA" id="trial" disabled="disabled" /></td>
    <td>
	    <input type="text" class="inputA" id="trialSpecial" name="tfunduse.trialSpecial"   
	    value="<s:property value='%{tfunduse.trialSpecial}' escape='true'/>"
	    maxlength="13" onblur="blurText(this,'试制设备费（专项经费）',1,5);" onfocus="focusText(this);"   
	    
	    style="ime-mode: disabled;" onKeyUp="sumRow(this.id);sumtotal();sumequipment();" 
	    onpropertychange="sumRow(this.id);sumtotal();sumequipment();"/>
	    <s:hidden id="hiddentrialSpecial" name="hidden" value="试制设备费（专项经费）,1,5"></s:hidden>
    </td>
    <td>
	    <input type="text" class="inputA" id="trialSupport" name="tfunduse.trialSupport"   
	    value="<s:property value='%{tfunduse.trialSupport}' escape='true'/>"
	    maxlength="13" onblur="blurText(this,'试制设备费（配套经费）',1,5);" onfocus="focusText(this);"   
	    
	    style="ime-mode: disabled;" onKeyUp="sumRow(this.id);sumtotal();sumequipment();" 
	    onpropertychange="sumRow(this.id);sumtotal();sumequipment();"/>
	    <s:hidden id="hiddentrialSupport" name="hidden" value="试制设备费（配套经费）,1,5"></s:hidden>
    </td>
  </tr>
  <tr>
    <td>4</td>
    <td align="center"><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;<FONT color=red>*</FONT>（3）设备改造与租赁费</div></td>
    <td><input type="text" class="inputA" id="renovation" disabled="disabled" /></td>
	<td>
		<input type="text" class="inputA" id="renovationSpecial" name="tfunduse.renovationSpecial"   
		value="<s:property value='%{tfunduse.renovationSpecial}' escape='true'/>"
	    maxlength="13" onblur="blurText(this,'设备改造与租赁费（专项经费）',1,5);" onfocus="focusText(this);"   
	    
	    style="ime-mode: disabled;" onKeyUp="sumRow(this.id);sumtotal();sumequipment();" onpropertychange="sumRow(this.id);sumtotal();sumequipment();"/>
	    <s:hidden id="hiddenrenovationSpecial" name="hidden" value="设备改造与租赁费（专项经费）,1,5"></s:hidden>
    </td>
    <td>
	    <input type="text" class="inputA" id="renovationSupport" name="tfunduse.renovationSupport"   
	    value="<s:property value='%{tfunduse.renovationSupport}' escape='true'/>"
	    maxlength="13" onblur="blurText(this,'设备改造与租赁费（配套经费）',1,5);" onfocus="focusText(this);"   
	    
	    style="ime-mode: disabled;" onKeyUp="sumRow(this.id);sumtotal();sumequipment();"
	    onpropertychange="sumRow(this.id);sumtotal();sumequipment();"/>
	    <s:hidden id="hiddenrenovationSupport" name="hidden" value="设备改造与租赁费（配套经费）,1,5"></s:hidden>
    </td>
  </tr>
  <tr>
    <td>5</td>
    <td><FONT color=red>*</FONT>2．材料费</td>
    <td><input type="text" class="inputA" id="material" disabled="disabled" /></td>
    <td>
	    <input type="text" class="inputA" id="materialSpecial" name="tfunduse.materialSpecial"   
	    value="<s:property value='%{tfunduse.materialSpecial}' escape='true'/>"
	    maxlength="13" onblur="blurText(this,'材料费（专项经费）',1,5);" onfocus="focusText(this);"   
	    
	    style="ime-mode: disabled;" onKeyUp="sumRow(this.id);sumtotal();" 
	    onpropertychange="sumRow(this.id);sumtotal();"/>
	    <s:hidden id="hiddenmaterialSpecial" name="hidden" value="材料费（专项经费）,1,5"></s:hidden>
    </td>
    <td>
	    <input type="text" class="inputA" id="materialSupport" name="tfunduse.materialSupport"   
	    value="<s:property value='%{tfunduse.materialSupport}' escape='true'/>"
	    maxlength="13" onblur="blurText(this,'材料费（配套经费）',1,5);" onfocus="focusText(this);"   
	    
	    style="ime-mode: disabled;" onKeyUp="sumRow(this.id);sumtotal();" 
	    onpropertychange="sumRow(this.id);sumtotal();"/>
	    <s:hidden id="hiddenmaterialSupport" name="hidden" value="材料费（配套经费）,1,5"></s:hidden>
    </td>
  </tr>
  <tr>
    <td>6</td>
    <td><FONT color=red>*</FONT>3．测试化验加工费</td>
    <td><input type="text" class="inputA" id="test" disabled="disabled" /></td>
    <td>
	    <input type="text" class="inputA" id="testSpecial" name="tfunduse.testSpecial"   
	    value="<s:property value='%{tfunduse.testSpecial}' escape='true'/>"
	    maxlength="13" onblur="blurText(this,'测试化验加工费（专项经费）',1,5);" onfocus="focusText(this);"   
	    
	    style="ime-mode: disabled;" onKeyUp="sumRow(this.id);sumtotal();" 
	    onpropertychange="sumRow(this.id);sumtotal();"/>
	    <s:hidden id="hiddentestSpecial" name="hidden" value="测试化验加工费（专项经费）,1,5"></s:hidden>
    </td>
    <td>
	    <input type="text" class="inputA" id="testSupport" name="tfunduse.testSupport"   
	    value="<s:property value='%{tfunduse.testSupport}' escape='true'/>"
	    maxlength="13" onblur="blurText(this,'测试化验加工费（配套经费）',1,5);" onfocus="focusText(this);"   
	    
	    style="ime-mode: disabled;" onKeyUp="sumRow(this.id);sumtotal();" 
	    onpropertychange="sumRow(this.id);sumtotal();"/>
	    <s:hidden id="hiddentestSupport" name="hidden" value="测试化验加工费（配套经费）,1,5"></s:hidden>
    </td>
  </tr>
  <tr>
    <td>7</td>
    <td><FONT color=red>*</FONT>4．会议费</td>
    <td><input type="text" class="inputA" id="meet" disabled="disabled" /></td>
    <td>
	    <input type="text" class="inputA" id="meetSpecial" name="tfunduse.meetSpecial"   
	    value="<s:property value='%{tfunduse.meetSpecial}' escape='true'/>"
	    maxlength="13" onblur="blurText(this,'会议费（专项经费）',1,5);" onfocus="focusText(this);"   
	    
	    style="ime-mode: disabled;" onKeyUp="sumRow(this.id);sumtotal();" 
	    onpropertychange="sumRow(this.id);sumtotal();"/>
	    <s:hidden id="hiddenmeetSpecial" name="hidden" value="会议费（专项经费）,1,5"></s:hidden>
    </td>
    <td>
	    <input type="text" class="inputA" id="meetSupport" name="tfunduse.meetSupport"   
	    value="<s:property value='%{tfunduse.meetSupport}' escape='true'/>"
	    maxlength="13" onblur="blurText(this,'会议费（配套经费）',1,5);" onfocus="focusText(this);"   
	    
	    style="ime-mode: disabled;" onKeyUp="sumRow(this.id);sumtotal();" 
	    onpropertychange="sumRow(this.id);sumtotal();"/>
	    <s:hidden id="hiddenmeetSupport" name="hidden" value="会议费（配套经费）,1,5"></s:hidden>
    </td>
  </tr>
  <tr>
    <td>8</td>
    <td><FONT color=red>*</FONT>5．国际合作与交流费</td>
    <td><input type="text" class="inputA" id="cooperation" disabled="disabled"/></td>
    <td>
	    <input type="text" class="inputA" id="cooperationSpecial" name="tfunduse.cooperationSpecial"   
	    value="<s:property value='%{tfunduse.cooperationSpecial}' escape='true'/>"
	    maxlength="13" onblur="blurText(this,'国际合作与交流费（专项经费）',1,5);" onfocus="focusText(this);"   
	    
	    style="ime-mode: disabled;" onKeyUp="sumRow(this.id);sumtotal();" 
	    onpropertychange="sumRow(this.id);sumtotal();"/>
	    <s:hidden id="hiddencooperationSpecial" name="hidden" value="国际合作与交流费（专项经费）,1,5"></s:hidden>
    </td>
    <td>
	    <input type="text" class="inputA" id="cooperationSupport" name="tfunduse.cooperationSupport"   
	    value="<s:property value='%{tfunduse.cooperationSupport}' escape='true'/>"
	    maxlength="13" onblur="blurText(this,'国际合作与交流费（配套经费）',1,5);" onfocus="focusText(this);"   
	    
	    style="ime-mode: disabled;" onKeyUp="sumRow(this.id);sumtotal();" 
	    onpropertychange="sumRow(this.id);sumtotal();"/>
	    <s:hidden id="hiddencooperationSupport" name="hidden" value="国际合作与交流费（配套经费）,1,5"></s:hidden>
    </td>
  </tr>
  <tr>
    <td>9</td>
    <td><FONT color=red>*</FONT>6．出版/文献/信息传播/知识产权事务费</td>
    <td><input type="text" class="inputA" id="publish" disabled="disabled" /></td>
    <td>
	    <input type="text" class="inputA" id="publishSpecial" name="tfunduse.publishSpecial"   
	    value="<s:property value='%{tfunduse.publishSpecial}' escape='true'/>"
	    maxlength="13" onblur="blurText(this,'出版/文献/信息传播/知识产权事务费（专项经费）',1,5);" 
	    onfocus="focusText(this);"   style="ime-mode: disabled;" 
	    onKeyUp="sumRow(this.id);sumtotal();" onpropertychange="sumRow(this.id);sumtotal();"/>
	    <s:hidden id="hiddenpublishSpecial" name="hidden" value="出版/文献/信息传播/知识产权事务费（专项经费）,1,5"></s:hidden>
    </td>
    <td>
	    <input type="text" class="inputA" id="publishSupport" name="tfunduse.publishSupport"   
	    value="<s:property value='%{tfunduse.publishSupport}' escape='true'/>"
	    maxlength="13" onblur="blurText(this,'出版/文献/信息传播/知识产权事务费（配套经费）',1,5);" 
	    onfocus="focusText(this);"   style="ime-mode: disabled;" 
	    onKeyUp="sumRow(this.id);sumtotal();" onpropertychange="sumRow(this.id);sumtotal();"/>
	    <s:hidden id="hiddenpublishSupport" name="hidden" value="出版/文献/信息传播/知识产权事务费（配套经费）,1,5"></s:hidden>
    </td>
  </tr>
  <tr>
    <td>10</td>
    <td><FONT color=red>*</FONT>7．专家咨询费</td>
    <td><input type="text" class="inputA" id="expert" disabled="disabled" /></td>
    <td>
	    <input type="text" class="inputA" id="expertSpecial" name="tfunduse.expertSpecial"   
	    value="<s:property value='%{tfunduse.expertSpecial}' escape='true'/>"
	    maxlength="13" onblur="blurText(this,'专家咨询费（专项经费）',1,5);" onfocus="focusText(this);"   
	    
	    style="ime-mode: disabled;" onKeyUp="sumRow(this.id);sumtotal();" 
	    onpropertychange="sumRow(this.id);sumtotal();"/>
	    <s:hidden id="hiddenexpertSpecial" name="hidden" value="专家咨询费（专项经费）,1,5"></s:hidden>
    </td>
    <td>
	    <input type="text" class="inputA" id="expertSupport" name="tfunduse.expertSupport"   
	    value="<s:property value='%{tfunduse.expertSupport}' escape='true'/>"
	    maxlength="13" onblur="blurText(this,'专家咨询费（配套经费）',1,5);" onfocus="focusText(this);"   
	    
	    style="ime-mode: disabled;" onKeyUp="sumRow(this.id);sumtotal();" 
	    onpropertychange="sumRow(this.id);sumtotal();"/>
	    <s:hidden id="hiddenexpertSupport" name="hidden" value="专家咨询费（配套经费）,1,5"></s:hidden>
    </td>
  </tr>
  <tr>
    <td>11</td>
    <td><FONT color=red>*</FONT>合计</td>
    <td><input type="text" class="inputA" id="total" disabled="disabled" /></td>
    <td><input type="text" class="inputA" id="totalSpecial" disabled="disabled" /></td>
    <td><input type="text" class="inputA" id="totalSupport" disabled="disabled" /></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="50%" height="50px">财务部门负责人（签字）：</td>
		<td width="50%"></td>
	</tr>
	<tr>
		<td width="50%" height="50px"><FONT color=red>*</FONT>开户名称：
			<input type="text" class="inputA" id="accountName" name="tfunduse.accountName"  
			value="<s:property value='%{tfunduse.accountName}' escape='true'/>" maxlength="20" 
			onblur="blurText(this,'开户名称',1,1);" onfocus="focusText(this);"/>
			<em class=requirecolor id="erraccountName" ></em>
		</td>
		<s:hidden id="hiddenaccountName" name="hidden" value="开户名称,1,1"></s:hidden>
		<td width="50%"><FONT color=red>*</FONT>开户银行：
			<input type="text" class="inputA" id="bank" name="tfunduse.bank"  
			value="<s:property value='%{tfunduse.bank}' escape='true'/>" 
			maxlength="20" onblur="blurText(this,'开户银行',1,1);" 
			onfocus="focusText(this);"/>
			<em class=requirecolor id="errbank" ></em>
		</td>
		<s:hidden id="hiddenbank" name="hidden" value="开户银行,1,1"></s:hidden>
	</tr>
	<tr>
		<td width="50%" height="50px"><FONT color=red>*</FONT>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：      
			<input type="text" class="inputA" id="account" name="tfunduse.account"  
			value="<s:property value='%{tfunduse.account}' escape='true'/>" 
			maxlength="20" onblur="blurText(this,'账号',1,6);" 
			onfocus="focusText(this);" onkeypress="return upms.upmsUtils.isNum(event,this)"/>
			<em class=requirecolor id="erraccount" ></em>
		</td>
		<s:hidden id="hiddenaccount" name="hidden" value="账号,1,6"></s:hidden>
		<td width="50%">单位财务专用章：</td>
	</tr>
	<tr>
		<td width="50%" height="50px"></td>
		<td width="50%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<FONT color=red>*</FONT>
			<INPUT type="text" class="txt w184p Wdate"  name="tfunduse.selectDate" id="selectDate" 
			value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tfunduse.selectDate})}' />" readonly="readonly" 
			onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" onblur="blurText(this,'日期',1,1);" onfocus="focusText(this);"/>
			<em class=requirecolor id="errselectDate" ></em>
		</td>
		<s:hidden id="hiddenselectDate" name="hidden" value="日期,1,1"></s:hidden>
	</tr>	
</table>
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
</div>
</form>
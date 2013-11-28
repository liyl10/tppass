<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/other/js/acceptance_b_achievement.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目取得成果情况
				</div>
				<div class="abuot03">
<s:hidden id="acceptanceId" name="acceptanceId" value="%{acceptanceId}"></s:hidden>
<s:hidden id="acceptanceStatus" name="acceptanceStatus" value="%{acceptanceStatus}"></s:hidden>
<s:hidden id="achievementId" name="tacceptanceAchievementB.achievementId" value="%{tacceptanceAchievementB.achievementId}"></s:hidden>	
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td rowspan="6" style="text-align: right;width:10%">项目取得的知识产权情况</td>
    <td width="12%" style="text-align: right;width:15%">已获得知识产权数量</td>
    <td width="27%" style="text-align: left;width:30%">总数：
    <input type="hidden" class="inputA" id="havaNumList" name="havaNumList" style="width:60%" 
			value="<s:property value='%{havaNumList}' escape='true'/>"
			style="ime-mode: disabled;" readonly="readonly">
			<input type=text class="inputA" id="summ1" name="summ1" value="${havaNumList}" style="width:10em;" 
			style="ime-mode: disabled;" disabled="disabled">	
    </td>
    <td style="text-align: right;width:15%">已申请知识产权数量</td>
    <td width="26%" colspan="2" style="text-align: left;width:30%">总数：
     <input type="hidden" class="inputA" id="reportNumList" name="reportNumList" style="width:60%" 
			value="<s:property value='%{reportNumList}' escape='true'/>"
			style="ime-mode: disabled;" readonly="readonly">
			<input type=text class="inputA" id="summ2" name="summ2" value="${reportNumList}" style="width:10em;" 
			style="ime-mode: disabled;" disabled="disabled">
    </td>
  </tr>
  <tr>
    <td style="text-align: right"><FONT color=red>*</FONT>发明专利数</td>
    <td style="text-align: left">
		<input id="receivePatentNum" name="tacceptanceAchievementB.receivePatentNum" 
	    value="<s:property value='%{tacceptanceAchievementB.receivePatentNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;" 
	    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'发明专利数',1,4);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    </td><s:hidden id="hiddenreceivePatentNum" name="hidden" value="发明专利数,1,4"></s:hidden>	
    <td style="text-align: right"><FONT color=red>*</FONT>发明专利数</td>
    <td colspan="2" style="text-align: left">
	    <input id="applyPatentNum" name="tacceptanceAchievementB.applyPatentNum" 
	    value="<s:property value='%{tacceptanceAchievementB.applyPatentNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'发明专利数',1,4);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    </td><s:hidden id="hiddenapplyPatentNum" name="hidden" value="发明专利数,1,4"></s:hidden>	
  </tr>
  <tr>
    <td style="text-align: right"><FONT color=red>*</FONT>实用新型数</td>
    <td style="text-align: left">
		<input id="receiveUtilityNum" name="tacceptanceAchievementB.receiveUtilityNum" 
	    value="<s:property value='%{tacceptanceAchievementB.receiveUtilityNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'实用新型数',1,4);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    </td><s:hidden id="hiddenreceiveUtilityNum" name="hidden" value="实用新型数,1,4"></s:hidden>	
    <td style="text-align: right"><FONT color=red>*</FONT>实用新型数</td>
    <td colspan="2" style="text-align: left">
	    <input id="applyUtilityNum" name="tacceptanceAchievementB.applyUtilityNum" 
	    value="<s:property value='%{tacceptanceAchievementB.applyUtilityNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'实用新型数',1,4);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    </td><s:hidden id="hiddenapplyUtilityNum" name="hidden" value="实用新型数,1,4"></s:hidden>	
  </tr>
  <tr>
    <td style="text-align: right"><FONT color=red>*</FONT>外观设计数 </td>
    <td style="text-align: left">
		<input id="receiveDesignsNum" name="tacceptanceAchievementB.receiveDesignsNum" 
	    value="<s:property value='%{tacceptanceAchievementB.receiveDesignsNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'外观设计数',1,4);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    </td><s:hidden id="hiddenreceiveDesignsNum" name="hidden" value="外观设计数,1,4"></s:hidden>	
    <td style="text-align: right"><FONT color=red>*</FONT>外观设计数 </td>
    <td colspan="2" style="text-align: left">
     	<input id="applyDesignsNum" name="tacceptanceAchievementB.applyDesignsNum" 
	    value="<s:property value='%{tacceptanceAchievementB.applyDesignsNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'外观设计数',1,4);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    </td><s:hidden id="hiddenapplyDesignsNum" name="hidden" value="外观设计数,1,4"></s:hidden>	
  </tr>
  <tr>
    <td style="text-align: right"><FONT color=red>*</FONT>软件著作权数</td>
    <td style="text-align: left">
		<input id="receiveCopyrightNum" name="tacceptanceAchievementB.receiveCopyrightNum" 
	    value="<s:property value='%{tacceptanceAchievementB.receiveCopyrightNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'软件著作权数',1,4);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    </td><s:hidden id="hiddenreceiveCopyrightNum" name="hidden" value="软件著作权数,1,4"></s:hidden>	
    <td style="text-align: right"><FONT color=red>*</FONT>软件著作权数</td>
    <td colspan="2" style="text-align: left">
      	<input id="applyCopyrightNum" name="tacceptanceAchievementB.applyCopyrightNum" 
	    value="<s:property value='%{tacceptanceAchievementB.applyCopyrightNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	 	maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'软件著作权数',1,4);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    </td><s:hidden id="hiddenapplyCopyrightNum" name="hidden" value="软件著作权数,1,4"></s:hidden>	
  </tr>
  <tr>
    <td style="text-align: right"><FONT color=red>*</FONT>国外专利数</td>
    <td style="text-align: left">
		<input id="receiveForeignNum" name="tacceptanceAchievementB.receiveForeignNum" 
	    value="<s:property value='%{tacceptanceAchievementB.receiveForeignNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	 	maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'国外专利数',1,4);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    </td><s:hidden id="hiddenreceiveForeignNum" name="hidden" value="国外专利数,1,4"></s:hidden>	
    <td style="text-align: right"><FONT color=red>*</FONT>国外专利数</td>
    <td colspan="2" style="text-align: left">
		<input id="applyForeignNum" name="tacceptanceAchievementB.applyForeignNum" 
	    value="<s:property value='%{tacceptanceAchievementB.applyForeignNum}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	 	maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'国外专利数',1,4);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    </td><s:hidden id="hiddenapplyForeignNum" name="hidden" value="国外专利数,1,4"></s:hidden>	
  </tr>
  <tr>
    <td width="17%" style="text-align: right"><FONT color=red>*</FONT>其他成果</td>
    <td colspan="5" style="text-align: left">
		<textarea id="otherOutcomes" name="tacceptanceAchievementB.otherOutcomes" class="inputA" style="width:700px;height:100px"><s:property value='%{tacceptanceAchievementB.otherOutcomes}' escape='true'/></textarea>	
	</td>
  </tr>
  <tr>
    <td colspan="6" style="text-align: center;font-size: 14px;"><strong>企业获得国家或省市其他资金支持情况</strong></td>
  </tr>
  <tr>
    <td style="text-align:center"><FONT color=red>*</FONT>年度</td>
    <td colspan="2" style="text-align:center"><FONT color=red>*</FONT>计划或专项名称</td>
    <td colspan="3" style="text-align:center"><FONT color=red>*</FONT>资金额度（万元）</td>
  </tr>
  <tr>
    <td style="text-align: left">
   		<input class="txt w184p Wdate" type="text" name="fundsYear1" id="fundsYear1" value="<s:property value='%{tacceptanceAchievementB.fundsYear1}' />" 
		readonly="readonly" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy'})" onblur="upms.upmsUtils.blurTextCheck(this,'年度',1,10);" onfocus="upms.upmsUtils.textFocus(this);"/>
    </td><s:hidden id="hiddenfundsYear1" name="hidden" value="年度,1,10"></s:hidden>	
    <td colspan="2" style="text-align: left">
		<input id="fundsPlanname1" name="tacceptanceAchievementB.fundsPlanname1" 
	    value="<s:property value='%{tacceptanceAchievementB.fundsPlanname1}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%"
	    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'计划或专项名称',1,-1);"onfocus="upms.upmsUtils.textFocus(this);"/>	
    </td><s:hidden id="hiddenfundsPlanname1" name="hidden" value="计划或专项名称,1,-1"></s:hidden>	
    <td colspan="3" style="text-align: left">
		<input id="fundsAmount1" name="tacceptanceAchievementB.fundsAmount1" 
	    value="<s:property value='%{tacceptanceAchievementB.fundsAmount1}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'资金额度',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
     </td><s:hidden id="hiddenfundsPlanname1" name="hidden" value="资金额度,1,2"></s:hidden>	
  </tr>
  <tr>
    <td style="text-align: left">
    	<input class="txt w184p Wdate" type="text" name="fundsYear2" id="fundsYear2" value="<s:property value='%{tacceptanceAchievementB.fundsYear2}' />" 
		readonly="readonly" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy'})" onblur="upms.upmsUtils.blurTextCheck(this,'年度',1,10);" onfocus="upms.upmsUtils.textFocus(this);"/>
    </td><s:hidden id="hiddenfundsYear2" name="hidden" value="年度,1,10"></s:hidden>	
    <td colspan="2" style="text-align: left">
		<input id="fundsPlanname2" name="tacceptanceAchievementB.fundsPlanname2" 
    	value="<s:property value='%{tacceptanceAchievementB.fundsPlanname2}' escape='true'/>" 
    	type="text" class="inputA" style="width:80%"
    	maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'计划或专项名称',1,-1);"onfocus="upms.upmsUtils.textFocus(this);"/>	
    </td><s:hidden id="hiddenfundsPlanname2" name="hidden" value="计划或专项名称,1,-1"></s:hidden>	
    <td colspan="3" style="text-align: left">
		<input id="fundsAmount2" name="tacceptanceAchievementB.fundsAmount2" 
    	value="<s:property value='%{tacceptanceAchievementB.fundsAmount2}' escape='true'/>" 
    	type="text" class="inputA" style="width:80%;ime-mode: disabled;"
    	maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'资金额度',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
     </td><s:hidden id="hiddenfundsAmount2" name="hidden" value="资金额度,1,2"></s:hidden>	
  </tr>
  <tr>
    <td colspan="6" style="text-align: center;font-size: 14px;"><strong>企业融资情况</strong></td>
  </tr>
  <tr>
    <td style="text-align:center"><FONT color=red>*</FONT>年度</td>
    <td colspan="2" style="text-align:center"><FONT color=red>*</FONT>融资方</td>
    <td colspan="3" style="text-align:center"><FONT color=red>*</FONT>资金额度（万元）</td>
  </tr>
  <tr>
    <td style="text-align: left">
        <input class="txt w184p Wdate" type="text" name="companyYear1" id="companyYear1" value="<s:property value='%{tacceptanceAchievementB.companyYear1}' />" 
		readonly="readonly" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy'})" onblur="upms.upmsUtils.blurTextCheck(this,'年度',1,10);" onfocus="upms.upmsUtils.textFocus(this);"/>
    </td><s:hidden id="hiddencompanyYear1" name="hidden" value="年度,1,10"></s:hidden>	
    <td colspan="2" style="text-align: left">
		<input id="companyFinanciers1" name="tacceptanceAchievementB.companyFinanciers1" 
	    value="<s:property value='%{tacceptanceAchievementB.companyFinanciers1}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%"
	    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'融资方',1,-1);"onfocus="upms.upmsUtils.textFocus(this);"/>
    	</td><s:hidden id="hiddencompanyFinanciers1" name="hidden" value="融资方,1,-1"></s:hidden>	
    <td colspan="3" style="text-align: left">
		<input id="companyAmount1" name="tacceptanceAchievementB.companyAmount1" 
	    value="<s:property value='%{tacceptanceAchievementB.companyAmount1}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'资金额度',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
     </td><s:hidden id="hiddencompanyAmount1" name="hidden" value="资金额度,1,2"></s:hidden>
  </tr>
  <tr>
    <td style="text-align: left">
    	<input class="txt w184p Wdate" type="text" name="companyYear2" id="companyYear2" value="<s:property value='%{tacceptanceAchievementB.companyYear2}' />" 
		readonly="readonly" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy'})" onblur="upms.upmsUtils.blurTextCheck(this,'年度',1,10);" onfocus="upms.upmsUtils.textFocus(this);"/>
    </td><s:hidden id="hiddencompanyYear2" name="hidden" value="年度,1,10"></s:hidden>	
    <td colspan="2" style="text-align: left">
		<input id="companyFinanciers2" name="tacceptanceAchievementB.companyFinanciers2" 
	    value="<s:property value='%{tacceptanceAchievementB.companyFinanciers2}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%"
	    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'融资方',1,-1);"onfocus="upms.upmsUtils.textFocus(this);"/>
    	</td><s:hidden id="hiddencompanyFinanciers2" name="hidden" value="融资方,1,-1"></s:hidden>	
    <td colspan="3" style="text-align: left">
		<input id="companyAmount2" name="tacceptanceAchievementB.companyAmount2" 
	    value="<s:property value='%{tacceptanceAchievementB.companyAmount2}' escape='true'/>" 
	    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
	    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'资金额度',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    </td><s:hidden id="hiddencompanyAmount2" name="hidden" value="资金额度,1,2"></s:hidden>
  </tr>
  <tr>
    <td colspan="6" style="text-align:center;font-size: 14px;"><strong>企业发展情况</strong>
		<span style="text-align:right;font-size: 12px;">单位：万元</span>
	</td>
  </tr>
  <tr>
	<td colspan="6">
		<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0" style="border: 0px;">
  <tr>
    	<td style="text-align:center;width:10%"><strong>经济指标状况</strong></td>
    	<td style="text-align:center;width:20%"><strong>立项时</strong></td>
    	<td style="text-align:center;width:20%"><strong>验收时</strong></td>
    	<td style="text-align:center;width:12%"><strong>经济指标状况</strong></td>
    	<td style="text-align:center;width:20%"><strong>立项时</strong></td>
    	<td style="text-align:center;width:18%"><strong>验收时</strong></td>
	</tr>
	<tr>
    	<td style="text-align:right"><FONT color=red>*</FONT>总资产</td>
    	<td style="text-align:left">
			<input id="projectTotal" name="tacceptanceAchievementB.projectTotal" 
		    value="<s:property value='%{tacceptanceAchievementB.projectTotal}' escape='true'/>" 
		    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
		    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'总资产',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
		</td><s:hidden id="hiddenprojectTotal" name="hidden" value="总资产,1,2"></s:hidden>
    	<td style="text-align:left">
			<input id="acceptanceTotal" name="tacceptanceAchievementB.acceptanceTotal" 
		    value="<s:property value='%{tacceptanceAchievementB.acceptanceTotal}' escape='true'/>" 
		    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
		    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'总资产',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
		</td><s:hidden id="hiddenacceptanceTotal" name="hidden" value="总资产,1,2"></s:hidden>
    	<td style="text-align:right"><FONT color=red>*</FONT>企业年销售收入</td>
    	<td style="text-align:left">
			<input id="projectSales" name="tacceptanceAchievementB.projectSales" 
		    value="<s:property value='%{tacceptanceAchievementB.projectSales}' escape='true'/>" 
		    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
		    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'企业年销售收入',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
		</td><s:hidden id="hiddenprojectSales" name="hidden" value="企业年销售收入,1,2"></s:hidden>
    	<td style="text-align:left">
			<input id="acceptanceSales" name="tacceptanceAchievementB.acceptanceSales" 
		    value="<s:property value='%{tacceptanceAchievementB.acceptanceSales}' escape='true'/>" 
		    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
		    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'企业年销售收入',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
		</td><s:hidden id="hiddenacceptanceSales" name="hidden" value="企业年销售收入,1,2"></s:hidden>
	</tr>
	<tr>
    	<td style="text-align:right"><FONT color=red>*</FONT>净资产</td>
    	<td style="text-align:left">
			<input id="projectNet" name="tacceptanceAchievementB.projectNet" 
		    value="<s:property value='%{tacceptanceAchievementB.projectNet}' escape='true'/>" 
		    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
		    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'净资产',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
		</td><s:hidden id="hiddenprojectNet" name="hidden" value="净资产,1,2"></s:hidden>
    	<td style="text-align:left">
			<input id="acceptanceNet" name="tacceptanceAchievementB.acceptanceNet" 
		    value="<s:property value='%{tacceptanceAchievementB.acceptanceNet}' escape='true'/>" 
		    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
		    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'净资产',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
		</td><s:hidden id="hiddenacceptanceNet" name="hidden" value="净资产,1,2"></s:hidden>
    	<td style="text-align:right"><FONT color=red>*</FONT>企业年主营收入</td>
    	<td style="text-align:left">
			<input id="projectMainIncome" name="tacceptanceAchievementB.projectMainIncome" 
		    value="<s:property value='%{tacceptanceAchievementB.projectMainIncome}' escape='true'/>" 
		    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
		    maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'企业年主营收入',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
		</td><s:hidden id="hiddenprojectMainIncome" name="hidden" value="企业年主营收入,1,2"></s:hidden>
    	<td style="text-align:left">
			<input id="acceptanceMainIncome" name="tacceptanceAchievementB.acceptanceMainIncome" 
		    value="<s:property value='%{tacceptanceAchievementB.acceptanceMainIncome}' escape='true'/>" 
		    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
			maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'企业年主营收入',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
		</td><s:hidden id="hiddenacceptanceMainIncome" name="hidden" value="企业年主营收入,1,2"></s:hidden>
	</tr>
	<tr>
    	<td style="text-align:right"><FONT color=red>*</FONT>企业净利润</td>
    	<td style="text-align:left">
			<input id="projectBusinessNet" name="tacceptanceAchievementB.projectBusinessNet" 
		    value="<s:property value='%{tacceptanceAchievementB.projectBusinessNet}' escape='true'/>" 
		    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
			maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'企业净利润',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
		</td><s:hidden id="hiddenprojectBusinessNet" name="hidden" value="企业净利润,1,2"></s:hidden>
    	<td style="text-align:left">
			<input id="acceptanceBusinessNet" name="tacceptanceAchievementB.acceptanceBusinessNet" 
		    value="<s:property value='%{tacceptanceAchievementB.acceptanceBusinessNet}' escape='true'/>" 
		    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
			maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'企业净利润',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
		</td><s:hidden id="hiddenacceptanceBusinessNet" name="hidden" value="企业净利润,1,2"></s:hidden>
    	<td style="text-align:right"><FONT color=red>*</FONT>企业应纳税总额</td>
    	<td style="text-align:left">
			<input id="projectTaxableTotal" name="tacceptanceAchievementB.projectTaxableTotal" 
		    value="<s:property value='%{tacceptanceAchievementB.projectTaxableTotal}' escape='true'/>" 
		    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
			maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'企业应纳税总额',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
		</td><s:hidden id="hiddenprojectTaxableTotal" name="hidden" value="企业应纳税总额,1,2"></s:hidden>
    	<td style="text-align:left">
			<input id="acceptanceTaxableTotal" name="tacceptanceAchievementB.acceptanceTaxableTotal" 
		    value="<s:property value='%{tacceptanceAchievementB.acceptanceTaxableTotal}' escape='true'/>" 
		    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
			maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'企业应纳税总额',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
		</td><s:hidden id="hiddenacceptanceTaxableTotal" name="hidden" value="企业应纳税总额,1,2"></s:hidden>
	</tr>
	<tr>
    	<td style="text-align:right"><FONT color=red>*</FONT>其中出口创汇（万美元）
		</td>
    	<td style="text-align:left">
			<input id="projectExport" name="tacceptanceAchievementB.projectExport" 
		    value="<s:property value='%{tacceptanceAchievementB.projectExport}' escape='true'/>" 
		    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
			maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'其中出口创汇',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
		</td><s:hidden id="hiddenprojectExport" name="hidden" value="其中出口创汇,1,2"></s:hidden>
    	<td style="text-align:left">
			<input id="acceptanceExport" name="tacceptanceAchievementB.acceptanceExport" 
		    value="<s:property value='%{tacceptanceAchievementB.acceptanceExport}' escape='true'/>" 
		    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
			maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'其中出口创汇',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
		</td><s:hidden id="hiddenacceptanceExport" name="hidden" value="其中出口创汇,1,2"></s:hidden>
    	<td style="text-align:right"><FONT color=red>*</FONT>企业实际纳税总额</td>
    	<td style="text-align:left">
			<input id="projectActualTaxTotal" name="tacceptanceAchievementB.projectActualTaxTotal" 
		    value="<s:property value='%{tacceptanceAchievementB.projectActualTaxTotal}' escape='true'/>" 
		    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
			maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'企业实际纳税总额',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
		</td><s:hidden id="hiddenprojectActualTaxTotal" name="hidden" value="企业实际纳税总额,1,2"></s:hidden>
    	<td style="text-align:left">
			<input id="acceptanceActualTaxTotal" name="tacceptanceAchievementB.acceptanceActualTaxTotal" 
		    value="<s:property value='%{tacceptanceAchievementB.acceptanceActualTaxTotal}' escape='true'/>" 
		    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
			maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'企业实际纳税总额',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
		</td><s:hidden id="hiddenacceptanceActualTaxTotal" name="hidden" value="企业实际纳税总额,1,2"></s:hidden>
	</tr>
	<tr>
    	<td style="text-align:right">&nbsp;</td>
    	<td style="text-align:center">
			&nbsp;
		</td>
    	<td style="text-align:center">
			&nbsp;
		</td>
    	<td style="text-align:right"><FONT color=red>*</FONT>企业年度研发投入</td>
    	<td style="text-align:left">
			<input id="projectRdInvestment" name="tacceptanceAchievementB.projectRdInvestment" 
		    value="<s:property value='%{tacceptanceAchievementB.projectRdInvestment}' escape='true'/>" 
		    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
			maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'企业年度研发投入',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
		</td><s:hidden id="hiddenprojectRdInvestment" name="hidden" value="企业年度研发投入,1,2"></s:hidden>
    	<td style="text-align:left">
			<input id="acceptanceRdInvestment" name="tacceptanceAchievementB.acceptanceRdInvestment" 
		    value="<s:property value='%{tacceptanceAchievementB.acceptanceRdInvestment}' escape='true'/>" 
		    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
			maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'企业年度研发投入',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
		</td><s:hidden id="hiddenacceptanceRdInvestment" name="hidden" value="企业年度研发投入,1,2"></s:hidden>
	</tr>
	</table>
	</td>
	</tr>
	</table>
<br/>
<div align="center">
	<input class="button save" id="nextBtn" name="button" type="button" href="javascript: void(0);" value="下一步"/>
</div>
	 </div>
 	 </div>
   </div>
  </div>
</div>
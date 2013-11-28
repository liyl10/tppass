<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/highTech/js/acceptance_a_complete.js"></script>

<s:hidden id="acceptanceId" name="acceptanceId" value="%{acceptanceId}"></s:hidden>
<s:hidden id="acceptanceStatus" name="acceptanceStatus" value="%{acceptanceStatus}"></s:hidden>
<s:hidden id="completeId" name="tacceptanceCompleteA.completeId" value="%{tacceptanceCompleteA.completeId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
	<div class="Servicel04">
		<div class="abuot02">
		<div class="abuot07">对照合同项目任务完成情况</div>
		<div class="abuot03">
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td rowspan="5" width="20%"><div align="right">技术指标完成情况</div></td>
    <td colspan="2" width="20%"><div align="center"><FONT color=red>*</FONT>合同要求</div></td>
    <td colspan="2" width="20%"><div align="center"><FONT color=red>*</FONT>实际达到情况</div></td>
    </tr>
  <tr>
    <td colspan="2"><div align="left"><INPUT TYPE="text" class="inputA" style="width:18em;" id="contractRequire1" name="tacceptanceCompleteA.contractRequire1" value="<s:property value='%{tacceptanceCompleteA.contractRequire1}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'合同要求',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddencontractRequire1" name="hidden" value="合同要求,1,-1"/></div></td>
    <td colspan="2"><div align="left"><INPUT TYPE="text" class="inputA" style="width:18em;" id="actuallyAchieved1" name="tacceptanceCompleteA.actuallyAchieved1" value="<s:property value='%{tacceptanceCompleteA.actuallyAchieved1}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'实际达到情况',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddenactuallyAchieved1" name="hidden" value="实际达到情况,1,-1"/></div></td>
  </tr>
  <tr>
    <td colspan="2"><div align="left"><INPUT TYPE="text" class="inputA" style="width:18em;" id="contractRequire2" name="tacceptanceCompleteA.contractRequire2" value="<s:property value='%{tacceptanceCompleteA.contractRequire2}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'合同要求',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddencontractRequire2" name="hidden" value="合同要求,1,-1"/></div></td>
    <td colspan="2"><div align="left"><INPUT TYPE="text" class="inputA" style="width:18em;" id="actuallyAchieved2" name="tacceptanceCompleteA.actuallyAchieved2" value="<s:property value='%{tacceptanceCompleteA.actuallyAchieved2}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'实际达到情况',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddenactuallyAchieved2" name="hidden" value="实际达到情况,1,-1"/></div></td>
  </tr>
  <tr>
    <td colspan="2"><div align="left"><INPUT TYPE="text" class="inputA" style="width:18em;" id="contractRequire3" name="tacceptanceCompleteA.contractRequire3" value="<s:property value='%{tacceptanceCompleteA.contractRequire3}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'合同要求',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddencontractRequire3" name="hidden" value="合同要求,1,-1"/></div></td>
    <td colspan="2"><div align="left"><INPUT TYPE="text" class="inputA" style="width:18em;" id="actuallyAchieved3" name="tacceptanceCompleteA.actuallyAchieved3" value="<s:property value='%{tacceptanceCompleteA.actuallyAchieved3}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'实际达到情况',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddenactuallyAchieved3" name="hidden" value="实际达到情况,1,-1"/></div></td>
  </tr>
  <tr>
    <td colspan="2"><div align="left"><INPUT TYPE="text" class="inputA" style="width:18em;" id="contractRequire4" name="tacceptanceCompleteA.contractRequire4" value="<s:property value='%{tacceptanceCompleteA.contractRequire4}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'合同要求',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddencontractRequire4" name="hidden" value="合同要求,1,-1"/></div></td>
    <td colspan="2"><div align="left"><INPUT TYPE="text" class="inputA" style="width:18em;" id="actuallyAchieved4" name="tacceptanceCompleteA.actuallyAchieved4" value="<s:property value='%{tacceptanceCompleteA.actuallyAchieved4}' escape='true'/>"
    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'实际达到情况',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    <s:hidden id="hiddenactuallyAchieved4" name="hidden" value="实际达到情况,1,-1"/></div></td>
  </tr>
  <tr>
    <td rowspan="5"><div align="right">经济指标完成情况</div></td>
    <td width="20%"><div align="center">效益类别</div></td>
    <td colspan="2" width="15%"><div align="center">合同约定额度</div></td>
    <td width="30%"><div align="center">实际完成额度</div></td>
  </tr>
  <tr>
    <td ><div align="right"><FONT color=red>*</FONT>销售收入（万元）</div></td>
    <td colspan="2"><div align="left"><INPUT TYPE="text" class="inputA" style="width:18em;" id="conventionsSales" name="tacceptanceCompleteA.conventionsSales" value="<s:property value='%{tacceptanceCompleteA.conventionsSales}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'销售收入',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenconventionsSales" name="hidden" value="销售收入,1,2"/></div></td>
    <td ><div align="left"><INPUT TYPE="text" class="inputA" style="width:18em;" id="completeSales" name="tacceptanceCompleteA.completeSales" value="<s:property value='%{tacceptanceCompleteA.completeSales}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'销售收入',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddencompleteSales" name="hidden" value="销售收入,1,2"/></div></td>
  </tr>
  <tr>
    <td ><div align="right"><FONT color=red>*</FONT>利润总额（万元）</div></td>
    <td colspan="2"><div align="left"><INPUT TYPE="text" class="inputA" style="width:18em;" id="conventionsProfitTotal" name="tacceptanceCompleteA.conventionsProfitTotal" value="<s:property value='%{tacceptanceCompleteA.conventionsProfitTotal}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'利润总额',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenconventionsProfitTotal" name="hidden" value="利润总额,1,2"/></div></td>
    <td ><div align="left"><INPUT TYPE="text" class="inputA" style="width:18em;" id="completeProfitTotal" name="tacceptanceCompleteA.completeProfitTotal" value="<s:property value='%{tacceptanceCompleteA.completeProfitTotal}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'利润总额',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddencompleteProfitTotal" name="hidden" value="利润总额,1,2"/></div></td>
  </tr>
  <tr>
    <td ><div align="right"><FONT color=red>*</FONT>税收总额（万元）</div></td>
    <td colspan="2"><div align="left"><INPUT TYPE="text" class="inputA" style="width:18em;" id="conventionsTaxTotal" name="tacceptanceCompleteA.conventionsTaxTotal" value="<s:property value='%{tacceptanceCompleteA.conventionsTaxTotal}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'税收总额',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenconventionsTaxTotal" name="hidden" value="税收总额,1,2"/></div></td>
    <td ><div align="left"><INPUT TYPE="text" class="inputA" style="width:18em;" id="completeTaxTotal" name="tacceptanceCompleteA.completeTaxTotal" value="<s:property value='%{tacceptanceCompleteA.completeTaxTotal}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'税收总额',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddencompleteTaxTotal" name="hidden" value="税收总额,1,2"/></div></td>
    </tr>
  <tr>
    <td ><div align="right"><FONT color=red>*</FONT>创汇（万美元）</div></td>
    <td colspan="2" ><div align="left"><INPUT TYPE="text" class="inputA" style="width:18em;" id="conventionsForeignExchange" name="tacceptanceCompleteA.conventionsForeignExchange" value="<s:property value='%{tacceptanceCompleteA.conventionsForeignExchange}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'创汇',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenconventionsForeignExchange" name="hidden" value="创汇,1,2"/></div></td>
    <td ><div align="left"><INPUT TYPE="text" class="inputA" style="width:18em;" id="completeForeignExchange" name="tacceptanceCompleteA.completeForeignExchange" value="<s:property value='%{tacceptanceCompleteA.completeForeignExchange}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'创汇',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddencompleteForeignExchange" name="hidden" value="创汇,1,2"/></div></td>
  </tr>
</table>
  </div>
  <br>
  <br>
  <div class="abuot07">项目取得成果情况</div>
  <div class="abuot03">
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td rowspan="6"><div align="right">项目取得的知识产权情况</div></td>
    <td><div align="center">已获得知识产权数量</div></td>
    <td width="25%"><div align="center">总数</div></td>
    <td width="15%"><div align="center">已申请知识产权数量</div></td>
    <td><div align="center">总数</div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>发明专利数</div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:12em;" id="receivePatentNum" name="tacceptanceCompleteA.receivePatentNum" value="<s:property value='%{tacceptanceCompleteA.receivePatentNum}' escape='true'/>"
    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'发明专利数',1,4);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    <s:hidden id="hiddenreceivePatentNum" name="hidden" value="发明专利数,1,4"/></div></td>
    <td><div align="right"><FONT color=red>*</FONT>发明专利数</div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:12em;" id="applyPatentNum" name="tacceptanceCompleteA.applyPatentNum" value="<s:property value='%{tacceptanceCompleteA.applyPatentNum}' escape='true'/>"
    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'发明专利数',1,4);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    <s:hidden id="hiddenapplyPatentNum" name="hidden" value="发明专利数,1,4"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>实用新型数</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:12em;" id="receiveUtilityNum" name="tacceptanceCompleteA.receiveUtilityNum" value="<s:property value='%{tacceptanceCompleteA.receiveUtilityNum}' escape='true'/>"
    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'实用新型数',1,4);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    <s:hidden id="hiddenreceiveUtilityNum" name="hidden" value="实用新型数,1,4"/></div></td>
    <td><div align="right"><FONT color=red>*</FONT>实用新型数</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:12em;" id="applyUtilityNum" name="tacceptanceCompleteA.applyUtilityNum" value="<s:property value='%{tacceptanceCompleteA.applyUtilityNum}' escape='true'/>"
    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'实用新型数',1,4);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    <s:hidden id="hiddenapplyUtilityNum" name="hidden" value="实用新型数,1,4"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>外观设计数</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:12em;" id="receiveDesignsNum" name="tacceptanceCompleteA.receiveDesignsNum" value="<s:property value='%{tacceptanceCompleteA.receiveDesignsNum}' escape='true'/>"
    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'外观设计数',1,4);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    <s:hidden id="hiddenreceiveDesignsNum" name="hidden" value="外观设计数,1,4"/></div></td>
    <td><div align="right"><FONT color=red>*</FONT>外观设计数</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:12em;" id="applyDesignsNum" name="tacceptanceCompleteA.applyDesignsNum" value="<s:property value='%{tacceptanceCompleteA.applyDesignsNum}' escape='true'/>"
    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'外观设计数',1,4);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    <s:hidden id="hiddenapplyDesignsNum" name="hidden" value="外观设计数,1,4"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>国外专利数</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:12em;" id="receiveForeignNum" name="tacceptanceCompleteA.receiveForeignNum" value="<s:property value='%{tacceptanceCompleteA.receiveForeignNum}' escape='true'/>"
    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'国外专利数',1,4);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    <s:hidden id="hiddenreceiveForeignNum" name="hidden" value="国外专利数,1,4"/></div></td>
    <td><div align="right"><FONT color=red>*</FONT>国外专利数</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:12em;" id="applyForeignNum" name="tacceptanceCompleteA.applyForeignNum" value="<s:property value='%{tacceptanceCompleteA.applyForeignNum}' escape='true'/>"
    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'国外专利数',1,4);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    <s:hidden id="hiddenapplyForeignNum" name="hidden" value="国外专利数,1,4"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>软件著作权数</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:12em;" id="receiveCopyrightNum" name="tacceptanceCompleteA.receiveCopyrightNum" value="<s:property value='%{tacceptanceCompleteA.receiveCopyrightNum}' escape='true'/>"
    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'软件著作权数',1,4);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    <s:hidden id="hiddenreceiveCopyrightNum" name="hidden" value="软件著作权数,1,4"/></div></td>
    <td><div align="right"><FONT color=red>*</FONT>软件著作权数</div></td>
    <td><div align="left"><INPUT TYPE="text"  class="inputA" style="width:12em;" id="applyCopyrightNum" name="tacceptanceCompleteA.applyCopyrightNum" value="<s:property value='%{tacceptanceCompleteA.applyCopyrightNum}' escape='true'/>"
    maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'软件著作权数',1,4);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isNum(event,this);"/>	
    <s:hidden id="hiddenapplyCopyrightNum" name="hidden" value="软件著作权数,1,4"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>其他成果<br>（制订技术标准件、<br>成果鉴定、检测报告等）</div></td>
    <td colspan="4"><div align="left"><textarea id="otherOutcomes" name="tacceptanceCompleteA.otherOutcomes" cols="100" rows="8" class="inputA" style="height:100px; width:700px;" onblur="upms.upmsUtils.blurTextCheck(this,'其他成果',1,8,1000);" onfocus="upms.upmsUtils.textFocus(this);" onKeyUp="upms.upmsUtils.checkTextareaLength(this, 1000);"><s:property value='%{tacceptanceCompleteA.otherOutcomes}' escape='true'/></textarea>
    <s:hidden id="hiddenotherOutcomes" name="hidden" value="其他成果,1,8,1000"/></div></td>
  </tr>
</table>
	<br/>
	<br/>
<div align="center">
	<input class="button save" name="nextBtn" id="nextBtn" type="button" href="javascript: void(0);" value="下一步"/>
</div>
</div>
</div>
</div>
</div>
</div>

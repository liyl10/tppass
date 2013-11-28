<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/highTech/js/acceptance_a_developing.js"></script>

<s:hidden id="acceptanceId" name="acceptanceId" value="%{acceptanceId}"></s:hidden>
<s:hidden id="acceptanceStatus" name="acceptanceStatus" value="%{acceptanceStatus}"></s:hidden>
<s:hidden id="developingId" name="tacceptanceDevelopingA.developingId" value="%{tacceptanceDevelopingA.developingId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
	<div class="Servicel04">
		<div class="abuot02">
		<div class="abuot07">企业发展情况</div>
		<div class="abuot03">
	<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td colspan="6"><div align="right">单位：万元</div></td>
  </tr>
  <tr>
    <td width="12%"><div align="center">经济指标状况</div></td>
    <td width="18%"><div align="center">立项时</div></td>
    <td width="19%"><div align="center">验收时</div></td>
    <td width="15%"><div align="center">经济指标状况</div></td>
    <td width="18%"><div align="center">立项时</div></td>
    <td width="18%"><div align="center">验收时</div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>总资产</div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:10em;" id="projectTotal" name="tacceptanceDevelopingA.projectTotal" value="<s:property value='%{tacceptanceDevelopingA.projectTotal}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'总资产',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenprojectTotal" name="hidden" value="总资产,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:10em;" id="acceptanceTotal" name="tacceptanceDevelopingA.acceptanceTotal" value="<s:property value='%{tacceptanceDevelopingA.acceptanceTotal}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'总资产',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenacceptanceTotal" name="hidden" value="总资产,1,2"/></div></td>
    <td><div align="right"><FONT color=red>*</FONT>企业年总收入</div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:10em;" id="projectSales" name="tacceptanceDevelopingA.projectSales" value="<s:property value='%{tacceptanceDevelopingA.projectSales}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'企业年总收入',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenprojectSales" name="hidden" value="企业年总收入,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:10em;" id="acceptanceSales" name="tacceptanceDevelopingA.acceptanceSales" value="<s:property value='%{tacceptanceDevelopingA.acceptanceSales}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'企业年总收入',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenacceptanceSales" name="hidden" value="企业年总收入,1,2"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>企业净利润</div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:10em;" id="projectNet" name="tacceptanceDevelopingA.projectNet" value="<s:property value='%{tacceptanceDevelopingA.projectNet}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'企业净利润',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenprojectNet" name="hidden" value="企业净利润,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:10em;" id="acceptanceNet" name="tacceptanceDevelopingA.acceptanceNet" value="<s:property value='%{tacceptanceDevelopingA.acceptanceNet}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'企业净利润',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenacceptanceNet" name="hidden" value="企业净利润,1,2"/></div></td>
    <td><div align="right"><FONT color=red>*</FONT>企业缴税额</div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:10em;" id="projectTaxableTotal" name="tacceptanceDevelopingA.projectTaxableTotal" value="<s:property value='%{tacceptanceDevelopingA.projectTaxableTotal}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'企业缴税额',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenacceptanceNet" name="hidden" value="企业缴税额,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:10em;" id="acceptanceTaxableTotal" name="tacceptanceDevelopingA.acceptanceTaxableTotal" value="<s:property value='%{tacceptanceDevelopingA.acceptanceTaxableTotal}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'企业缴税额',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenacceptanceTaxableTotal" name="hidden" value="企业缴税额,1,2"/></div></td>
  </tr>
  <tr>
    <td><div align="right"><FONT color=red>*</FONT>其中出口创汇<br>（万美元）</div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:10em;" id="projectExport" name="tacceptanceDevelopingA.projectExport" value="<s:property value='%{tacceptanceDevelopingA.projectExport}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'其中出口创汇',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenprojectExport" name="hidden" value="其中出口创汇,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:10em;" id="acceptanceExport" name="tacceptanceDevelopingA.acceptanceExport" value="<s:property value='%{tacceptanceDevelopingA.acceptanceExport}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'其中出口创汇',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenacceptanceExport" name="hidden" value="其中出口创汇,1,2"/></div></td>
    <td><div align="right"><FONT color=red>*</FONT>企业年度研发投入</div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:10em;" id="projectRdInvestment" name="tacceptanceDevelopingA.projectRdInvestment" value="<s:property value='%{tacceptanceDevelopingA.projectRdInvestment}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'企业年度研发投入',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenprojectRdInvestment" name="hidden" value="企业年度研发投入,1,2"/></div></td>
    <td><div align="left"><INPUT TYPE="text" class="inputA" style="width:10em;" id="acceptanceRdInvestment" name="tacceptanceDevelopingA.acceptanceRdInvestment" value="<s:property value='%{tacceptanceDevelopingA.acceptanceRdInvestment}' escape='true'/>"
    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'企业年度研发投入',1,2);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>
    <s:hidden id="hiddenacceptanceRdInvestment" name="hidden" value="企业年度研发投入,1,2"/></div></td>
  </tr>
  <tr>
    <td colspan="6" style="height:25px;"><div align="center"><strong>项目承担单位真实性承诺</strong></div></td>
  </tr>
  <tr>
    <td colspan="6"><div align="left" style="margin-top:10px; margin-bottom:20px; margin-left:15%;">本单位保证上述填报内容及所提供的附件材料真实可靠。</div>
	<div align="left" style=" margin-top:20px; margin-bottom:20px; margin-left:15%; margin-right:15%">
		<div style="float:left">单位负责人（签章）：</div>
		<div style="float:right; margin-right:15px;">填报单位公章：</div>
	</div>
	<br>
	<div align="right" style=" margin-top:20px; margin-bottom:20px; margin-left:15%; margin-right:15%">
		<input class="txt w184p Wdate" type="text" id="stampTime" name="tacceptanceDevelopingA.stampTime" value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tacceptanceDevelopingA.stampTime})}' />" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
	</div>
    </td>
  </tr>
  <tr>
    <td><div align="right">填表说明</div></td>
    <td colspan="5"><div align="left" style=" margin-top:20px; margin-bottom:20px; margin-left:5%; margin-right:5%">
      <p>1、计算机录入、打印，数据、单位、符号准确。所列栏目文字叙述和数据都应确切可靠，表内栏目不得空缺，无内容时填写“无”，数据有小数时，按四舍五入精确到小数点后两位填写。</p>
      <p>2、随表应附材料包括：
	  		<div style=" margin-left:20px;">
	  		<p>1）最近一个月的财务报表（现金流量、损益和资产负债表）；</p>
			<p>2）项目支出明细清单（参照合同的支出预算分类列出主要支出范围与资金）；</p>
			<p>3）报告期内购买固定资产的清单和发票复印件；产品销售证明（合同、发票）；</p>
			<p>4）项目产品取得的专利、报告和证书等的复印件；</p>
			</div>
	  </p>
      <p style="margin-top:-5px;;">3、表格及附件材料均须盖单位公章（复印件除外）.</p>
    </div></td>
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

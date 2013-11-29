<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/other/js/acceptance_b_summary.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目总结说明</div>
				<div class="abuot03">
<s:hidden id="acceptanceId" name="acceptanceId" value="%{acceptanceId}"></s:hidden>
<s:hidden id="acceptanceStatus" name="acceptanceStatus" value="%{acceptanceStatus}"></s:hidden>
<s:hidden id="summaryId" name="tacceptanceSummaryB.summaryId" value="%{tacceptanceSummaryB.summaryId}"></s:hidden>
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td colspan="2" style="font-size:14px"><div align="center"><strong>产业化、成果转化情况（如有）</strong></div></td>
   	</tr>
  <tr>
    <td style="padding: 4px 3px; text-align: right;width:10%"><FONT color=red>*</FONT>说  明</td>
    <td style="padding: 4px 8px; text-align: left">
      <p>（包括新建厂房，新建生产线、新增研发设备、示范推广、产学研合作等情况） </p>
      <p>
      <textarea id="transformationCase" name="tacceptanceSummaryB.transformationCase" class="inputA" style="width:700px;height:100px"><s:property value='%{tacceptanceSummaryB.transformationCase}' escape='true'/></textarea>	
      </p>
   </td>
  </tr>
  <tr>
    <td colspan="2" style="font-size:14px"><div align="center"><strong>项目实施管理、团队培养情况</strong></div></td>
    </tr>
  <tr>
    <td style="padding: 4px 3px; text-align: right"><FONT color=red>*</FONT>说  明</td>
    <td style="padding: 4px 8px; text-align: left"><p>（包括项目管理机构、机制建立、检查督促等情况，国内外高层次人才引进情况）
      </p>
      <p>
         <textarea id="teamTrainingSituation" name="tacceptanceSummaryB.teamTrainingSituation" class="inputA" style="width:700px;height:100px"><s:property value='%{tacceptanceSummaryB.teamTrainingSituation}' escape='true'/></textarea>	
      </p>
   </td>
  </tr>
  <tr>
    <td colspan="2" style="font-size:14px"><div align="center"><strong>项目社会效益说明</strong></div></td>
    </tr>
  <tr>
    <td style="padding: 4px 3px; text-align: right"><FONT color=red>*</FONT>说  明</td>
    <td style="padding: 4px 8px; text-align: left"><p>（包括新增就业人数以及项目实施对于企业发展、产业创新等方面的贡献）
      </p>
      <p>
        <textarea id="socialBenefitsDescription" name="tacceptanceSummaryB.socialBenefitsDescription" class="inputA" style="width:700px;height:100px"><s:property value='%{tacceptanceSummaryB.socialBenefitsDescription}' escape='true'/></textarea>	
      </p>
   </td>
  </tr>
  <tr>
    <td colspan="2" style="font-size:14px"><div align="center"><strong>项目承担单位真实性承诺</strong></div></td>
    </tr>
  <tr>
    <td colspan="2" style="padding: 4px 8px; text-align: ">
		<div align="left" style="margin-top:10px; margin-bottom:20px; margin-left:15%;">本单位保证上述填报内容及所提供的附件材料真实可靠。</div>
	<div align="left" style=" margin-top:20px; margin-bottom:20px; margin-left:15%; margin-right:15%">
		<div style="float:left">单位负责人（签章）：</div>
		<div style="float:right; margin-right:15px;">填报单位公章：</div>
	</div>
	<br>
	<div align="right" style=" margin-top:20px; margin-bottom:20px; margin-left:15%; margin-right:15%">
	<FONT color=red>*</FONT><input class="txt w184p Wdate" type="text" name="tacceptanceSummaryB.stampTime" id="stampTime" value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tacceptanceSummaryB.stampTime})}' />" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
	onblur="upms.upmsUtils.blurTextCheck(this,'填报时间',1,11);"onfocus="upms.upmsUtils.textFocus(this);"/>	
	</div>
    </td><s:hidden id="hiddenstampTime" name="hidden" value="填报时间,1,11"></s:hidden>
 </tr>
  
  <tr>
    <td style="padding: 4px 8px; text-align: right">填表说明</td>
    <td style="padding: 4px 8px; text-align: right">
		<div align="left" style=" margin-top:20px; margin-bottom:20px; margin-left:5%; margin-right:5%">
      <p>1、计算机录入、打印，数据、单位、符号准确。所列栏目文字叙述和数据都应确切可靠，表内栏目不得空缺，无内容时填写“无”，数据有小数时，按四舍五入精确到小数点后两位填写。</p>
      <p>2、随表应附材料包括：
	  		<div style=" margin-left:20px;">
	  		<p>1）最近一个月的财务报表（现金流量、损益和资产负债表）；</p>
			<p>2）项目支出明细清单（参照合同的支出预算分类列出主要支出范围与资金）；</p>
			<p>3）报告期内购买固定资产的清单和发票复印件；产品销售证明（合同、发票）；</p>
			<p>4）项目产品取得的专利、报告和证书等的复印件；</p>
			</div>
	  </p>
    </div>
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
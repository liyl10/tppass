<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/contract/other/js/contract_overall_content.js"></script>
<div align="center">
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;width:1200px;">
<div style="text-align: center;" >
	<div class="Servicel04">
		<div class="abuot02">
			<div class="abuot07">一、项目总体情况及主要内容</div>
			<div class="abuot03">
<div align="left" >
<s:hidden id="tcontractId" name="tcontractId" value="%{tcontractId}"></s:hidden>
<s:hidden id="Flag" name="Flag" value="%{Flag}"></s:hidden>
<s:hidden id="contractStatus" name="contractStatus" value="%{contractStatus}"></s:hidden>
<s:hidden id="contractContentsBId" name="tcontractContentsB.contractContentsBId" value="%{tcontractContentsB.contractContentsBId}"></s:hidden>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<!-- 下一步按钮提示信息 -->
<label id="comfirmSaveNext" style="display: none"><s:text name="confirm_save_and_next_info"/></label>	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
根据《中华人民共和国合同法》、《西安市科技计划项目管理办法》和《西安市科学研究与发展资金管理暂行办法》规定，
西安市科学技术局（以下简称甲方）与项目承担单位（以下简称乙方）以及项目归口管理单位（以下简称丙方）
为顺利完成本项目的研究开发任务，经协商一致，订立本合同。
<br/>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<strong>一、项目总体情况及主要内容</strong>
<br/>
<div>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
1.经过甲方审定，
 <input type="text" 
	    id="projectName" name="projectName" 
	    value="<s:property value='%{projectName}' escape='true'/>"  
	    disabled="disabled" class="inputA" 
		style="width:200px; margin-bottom:5px"> 
被列入
 <input type="text" 
	    id="yearValue" name="tcontractContentsB.yearValue" 
	    value="<s:property value='%{tcontractContentsB.yearValue}' escape='true'/>"  
	    class="inputA" maxlength="4"
		style="width:60px;" 
		onblur="blurText(this,'年度',0,23);" 
	    onfocus="upms.upmsUtils.textFocus(this)" 
	    disabled="disabled">
	    <s:hidden id="hiddenyearValue" name="hidden" value="年度,0,23"></s:hidden>
年度
<input type="text" id="planValue" maxlength="100"
	name="tcontractContentsB.planValue" class="inputA"
	value="<s:property value='%{tcontractContentsB.planValue}' escape='true'/>"  
	onblur="blurText(this,'计划',0,21);" 
    onfocus="upms.upmsUtils.textFocus(this)" 
    disabled="disabled">
    <s:hidden id="hiddenplanValue" name="hidden" value="计划,0,21"></s:hidden>
计划，并以无偿资助方式支持科研经费
<input type="text" id="researchFunding" 
	name="tcontractContentsB.researchFunding" class="inputA"
	value="<s:property value='%{tcontractContentsB.researchFunding}' escape='true'/>" 
    style="width:100px;margin-bottom:5px" maxlength="13"
	onblur="blurText(this,'科研经费',0,22);" 
	onfocus="upms.upmsUtils.textFocus(this)" >
    <s:hidden id="hiddenresearchFunding" name="hidden" value="科研经费,0,22"></s:hidden>
 万元；
</div>
<div id="message" style="margin-bottom: -8px;margin-left: 30px;" >
</div>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
2.项目承担单位：<s:property value='%{tcontract.TprojectApplication.applicationUnit}' escape='true'/>
<br/>
<div style="margin-top: 9px;margin-bottom: -5px">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
主要协作单位：
<s:property value='%{tprojectInfoB.assistUnit}' escape='true'/>
</div>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
3.项目负责人及主要人员：
<br/>
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td width="155">
    	<div align="center">姓名</div>
    </td>
    <td width="155">
    	<div align="center">性别</div>
    </td>
    <td width="113">
    	<div align="center">年龄</div>
    </td>
    <td width="162">
    	<div align="center">职务职称 </div>
    </td>
    <td width="193">
    	<div align="center">从事专业</div>
    </td>
    <td width="196">
    	<div align="center">承担任务</div>
    </td>
    <td width="206">
    	<div align="center">所在单位</div>
    </td>
    </tr>
    <s:if test="%{tprojectLeaderBList.size > 0}">
	<s:iterator value="tprojectLeaderBList" status="rowData">
	<TR height="40px">
		<s:hidden id="tprojectLeader%{#rowData.count}" name="tprojectLeaderBList[%{#rowData.count-1}].projectLeaderBId" value="%{projectLeaderBId}"></s:hidden>
		<td align="left">
		<input type="text" class="inputA" style="width:100px" maxlength="10"
			id="name<s:property value='%{#rowData.count}' escape='true'/>" 
			name="tprojectLeaderBList[<s:property value='%{#rowData.count-1}' escape='true'/>].name" 
			value="<s:property value='%{name}' escape='true'/>" 
			onblur="upms.upmsUtils.blurTextCheck(this,'姓名',1,-1);" 
			onfocus="focusText(this);" onkeypress="return upms.upmsUtils.isNum(event,this)"  
			style="ime-mode: disabled;"/>
		</td>
		<td align="left">
		<input type="text" class="inputA" style="width:50px" maxlength="1"
			id="sex<s:property value='%{#rowData.count}' escape='true'/>" 
			name="tprojectLeaderBList[<s:property value='%{#rowData.count-1}' escape='true'/>].sex" 
			value="<s:property value='%{sex}' escape='true'/>" 
			onblur="upms.upmsUtils.blurTextCheck(this,'性别',1,-1);" 
			onfocus="focusText(this);" 
			style="ime-mode: disabled;"/>	
		</td>
		<td align="left">
		<input type="text" class="inputA" style="width:50px" maxlength="3"
			id="age<s:property value='%{#rowData.count}' escape='true'/>" 
			name="tprojectLeaderBList[<s:property value='%{#rowData.count-1}' escape='true'/>].age" 
			value="<s:property value='%{age}' escape='true'/>"
			onblur="upms.upmsUtils.blurTextCheck(this,'年龄',1,9);" 
			onfocus="focusText(this);"  
			style="ime-mode: disabled;"/>	
		</td>
		<td align="left">
		<input type="text" class="inputA" style="width:130px" maxlength="30"
			id="jobTitle<s:property value='%{#rowData.count}' escape='true'/>" 
			name="tprojectLeaderBList[<s:property value='%{#rowData.count-1}' escape='true'/>].jobTitle" 
			value="<s:property value='%{jobTitle}' escape='true'/>" 
			onblur="upms.upmsUtils.blurTextCheck(this,'职务职称',1,-1);" 
			onfocus="focusText(this);" 
			style="ime-mode: disabled;"/>
		</td>
		<td align="left">
		<input type="text" class="inputA" style="width:130px" maxlength="30"
			id="specialty<s:property value='%{#rowData.count}' escape='true'/>" 
			name="tprojectLeaderBList[<s:property value='%{#rowData.count-1}' escape='true'/>].specialty" 
			value="<s:property value='%{specialty}' escape='true'/>" 
			onblur="upms.upmsUtils.blurTextCheck(this,'从事专业',1,-1);" 
			onfocus="focusText(this);"  
			style="ime-mode: disabled;"/>
		</td>
		<td align="left">
		<input type="text" class="inputA" style="width:130px" maxlength="30"
			id="task<s:property value='%{#rowData.count}' escape='true'/>" 
			name="tprojectLeaderBList[<s:property value='%{#rowData.count-1}' escape='true'/>].task" 
			value="<s:property value='%{task}' escape='true'/>" 
			onblur="upms.upmsUtils.blurTextCheck(this,'承担任务',1,-1);" 
			onfocus="focusText(this);" 
			style="ime-mode: disabled;"/>
		</td>
		<td align="left">
		<input type="text" class="inputA" style="width:150px" maxlength="30"
			id="unit<s:property value='%{#rowData.count}' escape='true'/>" 
			name="tprojectLeaderBList[<s:property value='%{#rowData.count-1}' escape='true'/>].unit" 
			value="<s:property value='%{unit}' escape='true'/>" 
			onblur="upms.upmsUtils.blurTextCheck(this,'所在单位',1,-1);" 
			onfocus="focusText(this);"   
			style="ime-mode: disabled;"/>
		</td>
		<div>
		<em class=requirecolor id="errname<s:property value='%{#rowData.count}' escape='true'/>" ></em>
		<em class=requirecolor id="errsex<s:property value='%{#rowData.count}' escape='true'/>" ></em>
		<em class=requirecolor id="errage<s:property value='%{#rowData.count}' escape='true'/>" ></em>
		<em class=requirecolor id="errfundsPlanYuan<s:property value='%{#rowData.count}' escape='true'/>" ></em>
		</div>
		<s:hidden id="hiddenname%{#rowData.count}" name="hidden" value="姓名,1,-1"></s:hidden>
		<s:hidden id="hiddensex%{#rowData.count}" name="hidden" value="性别,1,-1"></s:hidden>
		<s:hidden id="hiddenage%{#rowData.count}" name="hidden" value="年龄,1,9"></s:hidden>
		<s:hidden id="hiddenjobTitle%{#rowData.count}" name="hidden" value="职务职称,1,-1"></s:hidden>
		<s:hidden id="hiddenspecialty%{#rowData.count}" name="hidden" value="从事专业,1,-1"></s:hidden>
		<s:hidden id="hiddentask%{#rowData.count}" name="hidden" value="承担任务,1,-1"></s:hidden>
		<s:hidden id="hiddenunit%{#rowData.count}" name="hidden" value="所在单位,1,-1"></s:hidden>
		</TD>
	</TR>
	</s:iterator>
</s:if>

</table>
<br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  4.项目主要内容，拟达到的技术、经济指标或社会效益（包括销售收入、利润、税收等）。 
<br/>
<br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  研究内容： 
 <br/>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <div style="padding-left:28px;margin-bottom: -30px;margin-top: -15px">
 <textarea id="research" name="tcontractContentsB.research" 
 class="inputA" style="width:600px;height:50px" 
onKeyUp="upms.upmsUtils.checkTextareaLength(this, 1000);"
onblur="upms.upmsUtils.blurTextCheck(this,'研究内容',1,8,1000)"
onfocus="upms.upmsUtils.textFocus(this)" >
<s:property value='%{tcontractContentsB.research}' escape='true'/></textarea>
<s:hidden id="hiddenresearch1" name="hidden" value="研究内容,1,8,1000"></s:hidden>
</div>
<br/>
<br/>
<br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  拟达到的技术指标： 
 <br/>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <div style="padding-left:28px;margin-bottom: -30px;margin-top: -15px;">
 <textarea id="technicalSpecifications" name="tcontractContentsB.technicalSpecifications" 
class="inputA" style="width:600px;height:50px"
 onKeyUp="upms.upmsUtils.checkTextareaLength(this, 1000);"
onblur="upms.upmsUtils.blurTextCheck(this,'拟达到的技术指标',1,8,1000)"
onfocus="upms.upmsUtils.textFocus(this)">
<s:property value='%{tcontractContentsB.technicalSpecifications}' escape='true'/></textarea>
<s:hidden id="hiddentechnicalSpecifications1" name="hidden" value="技术指标,1,8,1000"></s:hidden>
</div>
 <br/>
 <br/>
 <br/>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 拟达到的经济指标：
 <br/>
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td width="100">
    	<div align="center">预期经济效益</div>
    </td>
    <td width="195">
    	<div align="center">新增销售收入</div>
    </td>
    <td width="201">
    	<div align="center">新增税金</div>
    </td>
    <td width="198">
    	<div align="center">新增利润</div>
    </td>
    <td width="190">
    	<div align="center">创汇 (万美元)</div>
    </td>
   <!-- <td width="201"  align="center"><input name="button2" type="button" class="button" onclick="" value="新增"/></td> -->
  </tr>
  <tr>
    <td>
    	${year1}年
	    <s:hidden id="economicIndicatorsBId" name="teconomicIndicatorsB.economicIndicatorsBId" 
	    	value="%{teconomicIndicatorsB.economicIndicatorsBId}"></s:hidden>
    </td>
    <td>
    	<input id="outputValue" 
    	name="teconomicIndicatorsB.outputValue" 
	    value="<s:property value='%{teconomicIndicatorsB.outputValue}' escape='true'/>" 
	    type="text" class="inputA" style="width:100px" maxlength="13"
		onblur="upms.upmsUtils.blurTextCheck(this,'新增产值',1,2);" 
	    onfocus="upms.upmsUtils.textFocus(this)" >
	    <s:hidden id="hiddenoutputValue" name="hidden" value="新增产值,1,2"></s:hidden>
    </td>
    <td>
    	<input id="payTaxes" 
    	name="teconomicIndicatorsB.payTaxes" 
	    value="<s:property value='%{teconomicIndicatorsB.payTaxes}' escape='true'/>" 
	    type="text" class="inputA" style="width:100px" maxlength="13"
		onblur="upms.upmsUtils.blurTextCheck(this,'新增税金',1,2);" 
	    onfocus="upms.upmsUtils.textFocus(this)" >
	    <s:hidden id="hiddenpayTaxes" name="hidden" value="新增税金,1,2"></s:hidden>
    </td>
    <td>
    	<input id="retainedProfits" 
    	name="teconomicIndicatorsB.retainedProfits" 
	    value="<s:property value='%{teconomicIndicatorsB.retainedProfits}' escape='true'/>" 
	    type="text" class="inputA" style="width:100px" maxlength="13"
		onblur="upms.upmsUtils.blurTextCheck(this,'新增利润',1,2);" 
	    onfocus="upms.upmsUtils.textFocus(this)" >
	    <s:hidden id="hiddenretainedProfits" name="hidden" value="新增利润,1,2"></s:hidden>
    </td>
    <td>
    	<input id="earnMoney" 
    	name="teconomicIndicatorsB.earnMoney" 
	    value="<s:property value='%{teconomicIndicatorsB.earnMoney}' escape='true'/>" 
	    type="text" class="inputA" style="width:100px" maxlength="13"
		onblur="upms.upmsUtils.blurTextCheck(this,'创汇',1,2);" 
	    onfocus="upms.upmsUtils.textFocus(this)" >
	    <s:hidden id="hiddenearnMoney" name="hidden" value="创汇,1,2"></s:hidden>
    </td>
    <!--<td style="width:100px" align="center" class='t-list'><a href="javascript: void(0);"  class="line single" onclick="">删除</a></td> -->
  </tr>
  <tr>
    <td>
    	${year2}年
    </td>
    <td>
    	<input id="outputValue1" 
    	name="teconomicIndicatorsB.outputValue1" 
	    value="<s:property value='%{teconomicIndicatorsB.outputValue1}' escape='true'/>" 
	    type="text" class="inputA" style="width:100px" maxlength="13"
		onblur="upms.upmsUtils.blurTextCheck(this,'新增产值',1,2);" 
	    onfocus="upms.upmsUtils.textFocus(this)" >
	    <s:hidden id="hiddenoutputValue1" name="hidden" value="新增产值,1,2"></s:hidden>
    </td>
    <td>
    	<input id="payTaxes1" 
    	name="teconomicIndicatorsB.payTaxes1" 
	    value="<s:property value='%{teconomicIndicatorsB.payTaxes1}' escape='true'/>" 
	    type="text" class="inputA" style="width:100px" maxlength="13"
		onblur="upms.upmsUtils.blurTextCheck(this,'新增税金',1,2);" 
	    onfocus="upms.upmsUtils.textFocus(this)" >
	    <s:hidden id="hiddenpayTaxes1" name="hidden" value="新增税金,1,2"></s:hidden>
    </td>
    <td>
    	<input id="retainedProfits1" 
    	name="teconomicIndicatorsB.retainedProfits1" 
	    value="<s:property value='%{teconomicIndicatorsB.retainedProfits1}' escape='true'/>" 
	    type="text" class="inputA" style="width:100px" maxlength="13"
		onblur="upms.upmsUtils.blurTextCheck(this,'新增利润',1,2);" 
	    onfocus="upms.upmsUtils.textFocus(this)" >
	    <s:hidden id="hiddenretainedProfits1" name="hidden" value="新增利润,1,2"></s:hidden>
    </td>
    <td>
    	<input id="earnMoney1" 
    	name="teconomicIndicatorsB.earnMoney1" 
	    value="<s:property value='%{teconomicIndicatorsB.earnMoney1}' escape='true'/>" 
	    type="text" class="inputA" style="width:100px" maxlength="13"
		onblur="upms.upmsUtils.blurTextCheck(this,'创汇',1,2);" 
	    onfocus="upms.upmsUtils.textFocus(this)" >
	    <s:hidden id="hiddenearnMoney1" name="hidden" value="创汇,1,2"></s:hidden>
    </td>
    <!--<td style="width:100px" align="center" class='t-list'><a href="javascript: void(0);"  class="line single" onclick="">删除</a></td> -->
  </tr>
    <tr>
    <td>
    	${year3}年
    </td>
    <td>
    	<input id="outputValue2" 
    	name="teconomicIndicatorsB.outputValue2" 
	    value="<s:property value='%{teconomicIndicatorsB.outputValue2}' escape='true'/>" 
	    type="text" class="inputA" style="width:100px" maxlength="13"
		onblur="upms.upmsUtils.blurTextCheck(this,'新增产值',1,2);" 
	    onfocus="upms.upmsUtils.textFocus(this)" >
	    <s:hidden id="hiddenoutputValue2" name="hidden" value="新增产值,1,2"></s:hidden>
    </td>
    <td>
    	<input id="payTaxes2" 
    	name="teconomicIndicatorsB.payTaxes2" 
	    value="<s:property value='%{teconomicIndicatorsB.payTaxes2}' escape='true'/>" 
	    type="text" class="inputA" style="width:100px" maxlength="13"
		onblur="upms.upmsUtils.blurTextCheck(this,'新增税金',1,2);" 
	    onfocus="upms.upmsUtils.textFocus(this)" >
	    <s:hidden id="hiddenpayTaxes2" name="hidden" value="新增税金,1,2"></s:hidden>
    </td>
    <td>
    	<input id="retainedProfits2" 
    	name="teconomicIndicatorsB.retainedProfits2" 
	    value="<s:property value='%{teconomicIndicatorsB.retainedProfits2}' escape='true'/>" 
	    type="text" class="inputA" style="width:100px" maxlength="13"
		onblur="upms.upmsUtils.blurTextCheck(this,'新增利润',1,2);" 
	    onfocus="upms.upmsUtils.textFocus(this)" >
	    <s:hidden id="hiddenretainedProfits2" name="hidden" value="新增利润,1,2"></s:hidden>
    </td>
    <td>
    	<input id="earnMoney2" 
    	name="teconomicIndicatorsB.earnMoney2" 
	    value="<s:property value='%{teconomicIndicatorsB.earnMoney2}' escape='true'/>" 
	    type="text" class="inputA" style="width:100px" maxlength="13"
		onblur="upms.upmsUtils.blurTextCheck(this,'创汇',1,2);" 
	    onfocus="upms.upmsUtils.textFocus(this)" >
	    <s:hidden id="hiddenearnMoney2" name="hidden" value="创汇,1,2"></s:hidden>
    </td>
    <!--<td style="width:100px" align="center" class='t-list'><a href="javascript: void(0);"  class="line single" onclick="">删除</a></td> -->
  </tr>
  <tr>
    <td align="center">合计</td>
    <td>
    	<input id="totalOutputValue" 
    	name="teconomicIndicatorsB.totalOutputValue" 
	    value="<s:property value='%{teconomicIndicatorsB.totalOutputValue}' escape='true'/>" 
	    type="text" class="inputA" style="width:100px" maxlength="13"
	    disabled="disabled">
    </td>
    <td>
    	<input id="totalPayTaxes" 
    	name="teconomicIndicatorsB.totalPayTaxes" 
	    value="<s:property value='%{teconomicIndicatorsB.totalPayTaxes}' escape='true'/>" 
	    type="text" class="inputA" style="width:100px" maxlength="13"
	    disabled="disabled">
    </td>
    <td>
    	<input id="totalRetainedProfits" 
    	name="teconomicIndicatorsB.totalRetainedProfits" 
	    value="<s:property value='%{teconomicIndicatorsB.totalRetainedProfits}' escape='true'/>" 
	    type="text" class="inputA" style="width:100px" maxlength="13"
	    disabled="disabled">
    </td>
    <td>
    	<input id="totalEarnMoney" 
    	name="teconomicIndicatorsB.totalEarnMoney" 
	    value="<s:property value='%{teconomicIndicatorsB.totalEarnMoney}' escape='true'/>" 
	    type="text" class="inputA" style="width:100px" maxlength="13"
	    disabled="disabled">
    </td>
    <!--<td style="width:100px" align="center" class='t-list'>&nbsp;</td> -->
  </tr>
</table>
<br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  5.项目实施阶段安排
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <div style="padding-left:28px;margin-bottom: -30px;margin-top: -15px">
<textarea id="arrangement" name="tcontractContentsB.arrangement" 
class="inputA" style="width:600px;height:50px" 
onKeyUp="upms.upmsUtils.checkTextareaLength(this, 1000);"
onblur="upms.upmsUtils.blurTextCheck(this,'项目实施阶段安排',1,8,1000)"
onfocus="upms.upmsUtils.textFocus(this)">
<s:property value='%{tcontractContentsB.arrangement}' escape='true'/></textarea>
<s:hidden id="hiddensocial" name="hidden" value="项目实施阶段安排,1,8,1000"></s:hidden>
 </div>
<br/>
<br/>
<br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  6.项目预期成果形态（包括专利申请、授权数量、科技成果登记等）
 <br/>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <div style="padding-left:28px;margin-bottom: -30px;margin-top: -15px">
<textarea id="resultsForm" name="tcontractContentsB.resultsForm" 
class="inputA" style="width:600px;height:50px" 
onKeyUp="upms.upmsUtils.checkTextareaLength(this, 1000);"
onblur="upms.upmsUtils.blurTextCheck(this,'项目预期成果形态',1,8,1000)"
onfocus="upms.upmsUtils.textFocus(this)">
<s:property value='%{tcontractContentsB.resultsForm}' escape='true'/></textarea>
<s:hidden id="hiddensocial" name="hidden" value="项目预期成果形态,1,8,1000"></s:hidden>
</div>
 <br/>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
</div>
</div>
<script type="text/javascript">

</script>
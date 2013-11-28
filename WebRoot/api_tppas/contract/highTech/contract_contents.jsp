<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/contract/highTech/js/highTech_contract_contents.js"></script>
<form id="ContentsForm">
<div align="center">
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;width:800px;">
<div style="text-align: center;" >
	<div class="Servicel04">
		<div class="abuot02">
			<div class="abuot07">合同内容</div>
			<div class="abuot03">
<div align="left" >
<s:hidden id="tcontractId" name="tcontractId" value="%{tcontractId}"></s:hidden>
<s:hidden id="modelType" name="modelType" value="%{modelType}"></s:hidden>
<s:hidden id="contractStatus" name="contractStatus" value="%{contractStatus}"></s:hidden>
<s:hidden id="Flag" name="Flag" value="%{Flag}"></s:hidden>
<s:hidden id="contractContentsId" name="tcontractContentsA.contractContentsId" value="%{tcontractContentsA.contractContentsId}"></s:hidden>
<s:hidden id="deleteFlag" name="tcontractContentsA.deleteFlag" value="%{tcontractContentsA.deleteFlag}"></s:hidden>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<!-- 下一步按钮提示信息 -->
<label id="comfirmSaveNext" style="display: none"><s:text name="confirm_save_and_next_info"/></label>
合同各方：<br/><br/>
甲方：<s:property value='%{entrustmentCompany}' escape='true'/><br/><br/>
乙方：<s:property value='%{tcontract.TprojectApplication.applicationUnit}' escape='true'/><br/><br/>
丙方：<s:property value='%{centralizedManagement}' escape='true'/><br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<strong>第一条</strong>   甲、乙、丙三方根据有关法律、法规和《西安市高新技术产业发展专项资金管理暂行办法》，为顺利完成西安市高新技术产业发展专项资金无偿资助项目
	<input type="text" class="inputA" id="projectName" disabled="disabled" name="tcontract.tprojectApplication.projectName" 
	value="<s:property value='tcontract.tprojectApplication.projectName' escape='true'/>"/> 
	（以下简称本项目），特订立本合同。
<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<strong>第二条</strong>   甲、乙、丙三方确认，本项目的执行期为
	<s:property value='%{startYear}' escape='true'/>年
	<s:property value='%{startMonth}' escape='true'/>月至
	<s:property value='%{endYear}' escape='true'/>年
	<s:property value='%{endMonth}' escape='true'/>月。
<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<strong>第三条</strong>   在本项目的执行期内，甲方计划资助乙方
	<input type="text" style="width:100px" class="inputA" id="partySubsidizePartyb" 
	name="tcontractContentsA.partySubsidizePartyb" 
	value="<s:property value='tcontractContentsA.partySubsidizePartyb'  escape='true'/>" 
	maxlength="13" onblur="blurText(this,'甲方计划资助乙方',1,5);" onfocus="focusText(this);"  
	 style="ime-mode: disabled;"/>万元，
乙方新增投资
	<input type="text" style="width:100px" class="inputA" id="partybNewInvestments" 
	name="tcontractContentsA.partybNewInvestments" 
	value="<s:property value='tcontractContentsA.partybNewInvestments'  escape='true'/>" 
	maxlength="13" onblur="blurText(this,'乙方新增投资',1,5);" onfocus="focusText(this);"   
	 style="ime-mode: disabled;"/>万元，
丙方予以配套资助乙方
	<input type="text" style="width:100px" class="inputA" id="partycSubsidizePartyb" 
	name="tcontractContentsA.partycSubsidizePartyb" 
	value="<s:property value='tcontractContentsA.partycSubsidizePartyb'  escape='true'/>" 
	maxlength="13" onblur="blurText(this,'丙方予以配套资助乙方',1,5);" onfocus="focusText(this);"   
	 style="ime-mode: disabled;"/>万元。
<br/>
<em class=requirecolor id="errpartySubsidizePartyb" ></em>
<em class=requirecolor id="errpartybNewInvestments" ></em>
<em class=requirecolor id="errpartycSubsidizePartyb" ></em>
<s:hidden id="hiddenpartySubsidizePartyb" name="hidden" value="甲方计划资助乙方,1,5"></s:hidden>
<s:hidden id="hiddenpartybNewInvestments" name="hidden" value="乙方新增投资,1,5"></s:hidden>
<s:hidden id="hiddenpartycSubsidizePartyb" name="hidden" value="丙方予以配套资助乙方,1,5"></s:hidden>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<strong>第四条</strong>   甲、乙、丙三方确认，各方资金到位计划如下：
<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
1．甲方将分两次向乙方拨付资金。在本合同生效后首次拨付70％资金；第二次拨付在本项目验收后进行，验收合格的，全额拨付资金余额；验收基本合格的拨付资金余额的60％；验收不合格的停拨资金余额。
<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
2．乙方依据本合同约定在项目执行期内完成新增投资，资金到位计划如下：
<br/><br/>
<s:if test="%{fundsplanAList.size > 0}">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<s:iterator value="fundsplanAList" status="rowData">
	<TR height="40px">
		<s:hidden id="fundsplan%{#rowData.count}" name="fundsplanAList[%{#rowData.count-1}].fundsPlanId" value="%{fundsPlanId}"></s:hidden>
		<TD align="left">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value='%{#rowData.count}' escape='true'/>）
		<input type="text" class="inputA" style="width:100px" maxlength="4" 
			id="fundsPlanYear<s:property value='%{#rowData.count}' escape='true'/>" 
			name="fundsplanAList[<s:property value='%{#rowData.count-1}' escape='true'/>].fundsPlanYear" 
			value="<s:property value='%{fundsPlanYear}' escape='true'/>" onblur="blurText(this,'资金到位计划的年份',1,9);" 
			onfocus="focusText(this);" onkeypress="return upms.upmsUtils.isNum(event,this)"  style="ime-mode: disabled;"/>年
		<input type="text" class="inputA" style="width:100px" maxlength="2" 
			id="fundsPlanMonth<s:property value='%{#rowData.count}' escape='true'/>" 
			name="fundsplanAList[<s:property value='%{#rowData.count-1}' escape='true'/>].fundsPlanMonth" 
			value="<s:property value='%{fundsPlanMonth}' escape='true'/>" onblur="blurText(this,'资金到位计划的月份',1,8);" 
			onfocus="focusText(this);"   style="ime-mode: disabled;"/>月
		<input type="text" class="inputA"  style="width:100px" maxlength="13" 
			id="fundsPlanYuan<s:property value='%{#rowData.count}' escape='true'/>" 
			name="fundsplanAList[<s:property value='%{#rowData.count-1}' escape='true'/>].fundsPlanYuan" 
			value="<s:property value='%{fundsPlanYuan}' escape='true'/>" onblur="blurText(this,'资金到位计划的金额',1,5);" 
			onfocus="focusText(this);"  style="ime-mode: disabled;"/>万元
		<div>
		<em class=requirecolor id="errfundsPlanYear<s:property value='%{#rowData.count}' escape='true'/>" ></em>
		<em class=requirecolor id="errfundsPlanMonth<s:property value='%{#rowData.count}' escape='true'/>" ></em>
		<em class=requirecolor id="errfundsPlanYuan<s:property value='%{#rowData.count}' escape='true'/>" ></em>
		</div>
		<s:hidden id="hiddenfundsPlanYear%{#rowData.count}" name="hidden" value="资金到位计划的年份,1,9"></s:hidden>
		<s:hidden id="hiddenfundsPlanMonth%{#rowData.count}" name="hidden" value="资金到位计划的月份,1,8"></s:hidden>
		<s:hidden id="hiddenfundsPlanYuan%{#rowData.count}" name="hidden" value="资金到位计划的金额,1,5"></s:hidden>
		</TD>
	</TR>
	</s:iterator>
</table>
</s:if>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;
3．丙方在本合同生效后两个月内向乙方拨付配套资助资金，拨款计划如下：
<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
1）
	<input type="text" style="width:100px" class="inputA" id="fundingSchemesYear" 
		name="tcontractContentsA.fundingSchemesYear" 
		value="<s:property value='%{tcontractContentsA.fundingSchemesYear}' escape='true'/>" 
		onkeyup='this.value=this.value.replace(/[^0-9]\D*$/,"")' maxlength="4" 
		onblur="blurText(this,'拨款计划的年份',1,9);" onfocus="focusText(this);"/>年
		&nbsp;&nbsp;
	<input type="text" style="width:100px" class="inputA" id="fundingSchemesMonth" 
		name="tcontractContentsA.fundingSchemesMonth" 
		value="<s:property value='%{tcontractContentsA.fundingSchemesMonth}' escape='true'/>" 
		onkeyup='this.value=this.value.replace(/[^0-9]\D*$/,"")' maxlength="2" 
		onblur="blurText(this,'拨款计划的月份',1,8);" onfocus="focusText(this);"/>月
		&nbsp;&nbsp;
	<input type="text" style="width:100px" class="inputA" id="fundingSchemesYuan" 
		name="tcontractContentsA.fundingSchemesYuan" 
		value="<s:property value='%{tcontractContentsA.fundingSchemesYuan}'  escape='true'/>" 
		maxlength="13" onblur="blurText(this,'拨款计划的金额',1,5);" onfocus="focusText(this);"   
		 style="ime-mode: disabled;"/>万元
<s:hidden id="hiddenfundingSchemesYear" name="hidden" value="拨款计划的年份,1,9"></s:hidden>
<s:hidden id="hiddenfundingSchemesMonth" name="hidden" value="拨款计划的月份,1,8"></s:hidden>
<s:hidden id="hiddenfundingSchemesYuan" value="拨款计划的金额,1,5"></s:hidden>
<br/>
<em class=requirecolor id="errfundingSchemesYear" ></em>
<em class=requirecolor id="errfundingSchemesMonth" ></em>
<em class=requirecolor id="errfundingSchemesYuan" ></em><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
2）验收合格后两个月内&nbsp; &nbsp; 
	<input type="text" style="width:100px" class="inputA" id="fundingSchemesQualified" 
		name="tcontractContentsA.fundingSchemesQualified" 
		value="<s:property value='%{tcontractContentsA.fundingSchemesQualified}'  escape='true'/>" 
		maxlength="13" onblur="blurText(this,'验收合格后两个月内的拨款计划',1,5);" onfocus="focusText(this);"   
		 style="ime-mode: disabled;"/>万元；
<s:hidden id="hiddenfundingSchemesQualified" value="验收合格后两个月内的拨款计划,1,5"></s:hidden>
<br/>
<em class=requirecolor id="errfundingSchemesQualified" ></em>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
验收基本合格后两个月内
	<input type="text" style="width:100px" class="inputA" id="fundingSchemesBasic" 
		name="tcontractContentsA.fundingSchemesBasic" 
		value="<s:property value='%{tcontractContentsA.fundingSchemesBasic}'  escape='true'/>" 
		maxlength="13" onblur="blurText(this,'验收基本合格后两个月内的拨款计划',1,5);" onfocus="focusText(this);"   
		 style="ime-mode: disabled;"/>万元。
<s:hidden id="hiddenfundingSchemesBasic" value="验收基本合格后两个月内的拨款计划,1,5"></s:hidden>
<br/>
<em class=requirecolor id="errfundingSchemesBasic" ></em><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<strong>第五条</strong>   乙方须对本项目资金进行单独核算。乙方收到甲方、丙方拨付的资金作为专项应付款处理，其中：消耗部分予以核销，形成资产部分转入资本公积。资金主要用于项目产业化过程中所发生的相关费用的必要补助，乙方应根据投资预算明确资金用途，填写项目经费支出表（见附件1）。
<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<strong>第六条</strong>   本项目实施的阶段目标为乙方在项目申请材料的“产品化实施计划”中所表述的内容。
<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<textarea class="inputA" id="implementationPlan" style="width: 600px;height: 60px;resize:none;" 
name="tcontractContentsA.implementationPlan" 
onKeyUp="upms.upmsUtils.checkTextareaLength(this, 1000);"
onblur="blurText(this,'产品化实施计划',1,7,1000);" onfocus="focusText(this);" >
<s:property value='%{tcontractContentsA.implementationPlan}' escape='true'/></textarea>
<s:hidden id="hiddenimplementationPlan" value="产品化实施计划,1,7,1000"></s:hidden>
<br/>
<em class=requirecolor id="errimplementationPlan" ></em>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<strong>第七条</strong>   验收考核指标是：<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
1．企业指标：承担单位在合同到期时，在合同执行期内完成新增总投资
	<input type="text" style="width:100px" class="inputA" id="totalInvestmentNewXm" 
		name="tcontractContentsA.totalInvestmentNewXm" 
		value="<s:property value='%{tcontractContentsA.totalInvestmentNewXm}'  escape='true'/>" 
		maxlength="13" onblur="blurText(this,'新增总投资',1,5);" onfocus="focusText(this);"   
		 style="ime-mode: disabled;"/>万元，
累计完成销售收入
	<input type="text" style="width:100px;" class="inputA" id="cumulativeSalesOverallXm" 
		name="tcontractContentsA.cumulativeSalesOverallXm" 
		value="<s:property value='%{tcontractContentsA.cumulativeSalesOverallXm}'  escape='true'/>" 
		maxlength="13" onblur="blurText(this,'累计完成销售收入',1,5);" onfocus="focusText(this);"   
		 style="ime-mode: disabled;"/>万元，
累计缴税
	<input type="text" style="width:100px" class="inputA" id="accumulatedTaxOverallXm" 
		name="tcontractContentsA.accumulatedTaxOverallXm" 
		value="<s:property value='%{tcontractContentsA.accumulatedTaxOverallXm}'  escape='true'/>" 
		maxlength="13" onblur="blurText(this,'累计缴税',1,5);" onfocus="focusText(this);"   
		 style="ime-mode: disabled;"/>万元，
累计净利润
	<input type="text" style="width:100px;margin-top:3px" class="inputA" id="accumulatedProfitsOverallXm" 
		name="tcontractContentsA.accumulatedProfitsOverallXm" 
		value="<s:property value='%{tcontractContentsA.accumulatedProfitsOverallXm}'  escape='true'/>" 
		maxlength="13" onblur="blurText(this,'累计净利润',1,5);" onfocus="focusText(this);"   
		 style="ime-mode: disabled;"/>万元；
企业资产规模达到
	<input type="text" style="width:100px" class="inputA" id="assetSizeOverallXm" 
		name="tcontractContentsA.assetSizeOverallXm" 
		value="<s:property value='%{tcontractContentsA.assetSizeOverallXm}'  escape='true'/>" 
		maxlength="13" onblur="blurText(this,'企业资产规模达到',1,5);" onfocus="focusText(this);"   
		 style="ime-mode: disabled;"/>万元，
新增就业人数达
<input type="text" style="width:100px;margin-top:3px" class="inputA" id="employmentNewOverallXm" 
	name="tcontractContentsA.employmentNewOverallXm" 
	value="<s:property value='%{tcontractContentsA.employmentNewOverallXm}' escape='true'/>" 
	maxlength="7" onblur="blurText(this,'新增就业人数',1,6);" onfocus="focusText(this);" 
	onkeypress="return upms.upmsUtils.isNum(event,this)"  style="ime-mode: disabled;"/>人。
<br/>
<s:hidden id="hiddentotalInvestmentNewXm" value="新增总投资,1,5"></s:hidden>
<s:hidden id="hiddencumulativeSalesOverallXm" value="累计完成销售收入,1,5"></s:hidden>
<s:hidden id="hiddenaccumulatedTaxOverallXm" value="累计缴税,1,5"></s:hidden>
<s:hidden id="hiddenaccumulatedProfitsOverallXm" value="累计净利润,1,5"></s:hidden>
<s:hidden id="hiddenassetSizeOverallXm" value="企业资产规模达到,1,5"></s:hidden>
<s:hidden id="hiddenemploymentNewOverallXm" value="新增就业人数,1,6"></s:hidden>
<em class=requirecolor id="errtotalInvestmentNewXm" ></em>
<em class=requirecolor id="errcumulativeSalesOverallXm" ></em>
<em class=requirecolor id="erraccumulatedTaxOverallXm" ></em>
<em class=requirecolor id="erraccumulatedProfitsOverallXm" ></em>
<em class=requirecolor id="errassetSizeOverallXm" ></em>
<em class=requirecolor id="erremploymentNewOverallXm" ></em>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;
2．项目指标：在本合同第二条规定的项目执行期内，本项目累计实现销售收入
	<input type="text" style="width:100px" class="inputA" id="cumulativeSalesEconomy" 
		name="tcontractContentsA.cumulativeSalesEconomy" 
		value="<s:property value='%{tcontractContentsA.cumulativeSalesEconomy}'  escape='true'/>" 
		maxlength="13" onblur="blurText(this,'本项目累计实现销售收入',1,5);" onfocus="focusText(this);"   
		 style="ime-mode: disabled;"/>万元，
累计缴税
	<input type="text" style="width:100px" class="inputA" id="accumulatedTaxEconomy" 
		name="tcontractContentsA.accumulatedTaxEconomy" 
		value="<s:property value='%{tcontractContentsA.accumulatedTaxEconomy}'  escape='true'/>" 
		maxlength="13" onblur="blurText(this,'累计缴税',1,5);" onfocus="focusText(this);"  
		 style="ime-mode: disabled;"/>万元，
累计净利润
	<input type="text" style="width:100px" class="inputA" id="accumulatedProfitsEconomy" 
		name="tcontractContentsA.accumulatedProfitsEconomy" 
		value="<s:property value='%{tcontractContentsA.accumulatedProfitsEconomy}'  escape='true'/>" 
		maxlength="13" onblur="blurText(this,'累计净利润',1,5);" onfocus="focusText(this);"   
		 style="ime-mode: disabled;"/>万元。
<br/>
<s:hidden id="hiddencumulativeSalesEconomy" value="本项目累计实现销售收入,1,5"></s:hidden>
<s:hidden id="hiddenaccumulatedTaxEconomy" value="累计缴税,1,5"></s:hidden>
<s:hidden id="hiddenaccumulatedProfitsEconomy" value="累计净利润,1,5"></s:hidden>
<em class=requirecolor id="errcumulativeSalesEconomy" ></em>
<em class=requirecolor id="erraccumulatedTaxEconomy" ></em>
<em class=requirecolor id="erraccumulatedProfitsEconomy" ></em>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;
3．技术指标：本项目所采用的主要（关键）技术及应达到的技术性能指标为乙方在项目申请材料的“项目技术与产品实现”中表述的内容。主要包括：
<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
<textarea class="inputA" id="technicalSpecifications" style="width: 600px;height: 60px;resize:none;"  
name="tcontractContentsA.technicalSpecifications" 
onKeyUp="upms.upmsUtils.checkTextareaLength(this, 1000);"
onblur="blurText(this,'技术指标',1,7,1000);" onfocus="focusText(this);" >
<s:property value='%{tcontractContentsA.technicalSpecifications}' escape='true'/></textarea>
<s:hidden id="hiddentechnicalSpecifications" value="技术指标,1,7,1000"></s:hidden>
<br/>
<em class=requirecolor id="errtechnicalSpecifications" ></em>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;
4．项目实施目标：本项目在合同到期时，项目产品形态为工业产品；项目所处阶段达到批量生产阶段，项目产品销售达到批量阶段，产品化拟执行的质量标准类型为国家标准，获得证书情况为： <br/><br/>
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
	<td width="204">企业新获得质量认证体系证书</td>
	<td width="402">
		<input type="text" class="inputA" maxlength="20" id="qualityCertificationSystem" 
		name="tcontractContentsA.qualityCertificationSystem" 
		value="<s:property value='%{tcontractContentsA.qualityCertificationSystem}' escape='true'/>" 
		onblur="blurText(this,'企业新获得质量认证体系证书',1,1);" onfocus="focusText(this);"/>
		<s:hidden id="hiddenqualityCertificationSystem" value="企业新获得质量认证体系证书,1,1"></s:hidden>
		<div>
		<em class=requirecolor id="errqualityCertificationSystem" ></em>
		</div>
  	</td>
  </tr>
  <tr>
	<td>项目新获得国家相关行业许可证</td>
	<td>
		<input type="text" class="inputA" maxlength="20" id="relevantIndustryPermits" 
		name="tcontractContentsA.relevantIndustryPermits" 
		value="<s:property value='%{tcontractContentsA.relevantIndustryPermits}' escape='true'/>" 
		onblur="blurText(this,'项目新获得国家相关行业许可证',1,1);" onfocus="focusText(this);"/>
		<s:hidden id="hiddenrelevantIndustryPermits" value="项目新获得国家相关行业许可证,1,1"></s:hidden>
		<div>
		<em class=requirecolor id="errrelevantIndustryPermits" ></em>
		</div>
	</td>
  </tr>
  <tr>
	<td>项目新申请及授权专利（或著作权）证书</td>
	<td>申请
		<input type="text" class="inputA" maxlength="7" style="width:50px" id="application" 
		name="tcontractContentsA.application" value="<s:property value='%{tcontractContentsA.application}' escape='true'/>" 
		onblur="blurText(this,'申请项数',1,6);" onfocus="focusText(this);" onkeypress="return upms.upmsUtils.isNum(event,this)"  
		style="ime-mode: disabled;"/>
	  项，授权
		<input type="text" class="inputA" maxlength="7" style="width:50px" id="authorize" 
		name="tcontractContentsA.authorize" 
		value="<s:property value='%{tcontractContentsA.authorize}' escape='true'/>" onblur="blurText(this,'授权项数',1,6);" 
		onfocus="focusText(this);" onkeypress="return upms.upmsUtils.isNum(event,this)"  style="ime-mode: disabled;"/>
	  项
	  <s:hidden id="hiddenapplication" value="申请项数,1,6"></s:hidden>
	  <s:hidden id="hiddenauthorize" value="授权项数,1,6"></s:hidden>
	  <div>
	  <em class=requirecolor id="errapplication" ></em>
	  <em class=requirecolor id="errauthorize" ></em>
	  </div>
	</td>
  </tr>
  <tr>
	<td>
		项目新获得技术、产品鉴定证书
	</td>
	<td>
		<input type="text" class="inputA" maxlength="20"  id="technologyProductCertificate" 
		name="tcontractContentsA.technologyProductCertificate" 
		value="<s:property value='%{tcontractContentsA.technologyProductCertificate}' escape='true'/>" 
		onblur="blurText(this,'项目新获得技术、产品鉴定证书',1,1);" onfocus="focusText(this);"/>
		<s:hidden id="hiddentechnologyProductCertificate" value="项目新获得技术、产品鉴定证书,1,1"></s:hidden>
		<div>
		<em class=requirecolor id="errtechnologyProductCertificate" ></em>
		</div>
	</td>
  </tr>
</table><br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<strong>第八条</strong>   在本合同签字生效后，乙方应该按照合同目标组织实施项目，在项目实施过程中接受甲方及其委托的监理单位的监督、检查，按照规定填报《高新技术产业发展专项项目监理信息调查表》半年报和年报，在本合同到期后按时进行项目验收，并对所提供的监理、验收信息的真实性负责。 <br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<strong>第九条</strong>   丙方有责任协助甲方对本项目的实施过程进行跟踪、检查和提供相关信息，并对所提供信息的客观真实性负责。<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<strong>第十条</strong>   在本合同生效后5年内，甲方有权因非商业目的（如：在政府性会议、报告、文件、统计资料等）使用乙方企业、项目信息；乙方有义务在本项目产品包装以及产品宣传上说明本产品为西安市高新技术产业发展专项资金资助产品。<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<strong>第十一条</strong>   本合同的修改与解除。<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
1．任何一方提出变更合同或解除合同的要求，需与其他方协商，签订变更条款或协议，作为本合同的正式附件，方可执行。<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
2．当事人一方逾期半年不履行合同规定的义务，对方有权解除合同，并追究违约责任。<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
3. 乙方在本项目执行过程中如有违法或重大违约行为，甲方有权终止合同并采取通报、停止拨款、追回资助资金等相应处理措施，并在三年内不再接受该单位专项资金计划项目的申报。<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
4．变更或解除合同造成的损失由双方协商或按责任原则分别承担。<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<strong>第十二条</strong>   本合同未尽事宜，参照《西安市高新技术产业发展专项资金管理暂行办法》、《西安市科技计划项目管理暂行办法》及相关管理规定执行。<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<strong>第十三条</strong>   本合同的甲方由西安市科学技术局、西安市财政局共同组成，由西安市科学技术局代表甲方签约。<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<strong>第十四条</strong>   本合同经签约各方签字盖章后生效，合同文本一式五份，甲方存三份，乙方存一份，丙方存一份。合同电子版软盘一份。<br/><br/>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr height="30px">
	<td align="left">
		&nbsp;&nbsp;甲方（委托单位）：<s:property value='%{entrustmentCompany}' escape='true'/>
	</td>
  </tr>
  <tr height="30px">
	<td align="left">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;项 目 负 责 人（签名）：
	</td>
  </tr>
  <tr height="30px">
	<td align="left">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;项 目 负 责 人（签名）：
	</td>
  </tr>
  <tr height="30px">
	<td align="right">
		（公 章）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
  </tr>
  <tr height="40px">
  	<td align="right">
	  	<INPUT class="txt w184p Wdate" type="text" name="tcontractContentsA.contractSelectDate1" 
	  	id="contractSelectDate1" value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tcontractContentsA.contractSelectDate1})}' />" 
	  	readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" onblur="blurText(this,'甲方（委托单位）的日期',1,1);" 
	  	onfocus="focusText(this);"/>
	  	<s:hidden id="hiddencontractSelectDate1" value="甲方（委托单位）的日期,1,1"></s:hidden>
	  	<div>
		<em class=requirecolor id="errcontractSelectDate1" ></em>
		</div>
  	</td>
  </tr>
  <tr height="30px">
	<td align="left">
		&nbsp;&nbsp;乙方（承担单位）：<s:property value='%{tcontract.TprojectApplication.applicationUnit}' escape='true'/> 
	</td>
  </tr>
  <tr height="30px">
	<td align="left">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;法人代表  （签名）：
	</td>
  </tr>
 <tr height="30px">
	<td align="left">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;项目负责人（签名）：
	</td>
	</tr>
  <tr height="30px">
	<td align="left">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开户银行与行号：
		<input type="text" class="inputA" id="bank" maxlength="50" name="tcontractContentsA.bank" 
		value="<s:property value='%{tcontractContentsA.bank}' escape='true'/>" onblur="blurText(this,'开户银行与行号',1,1);" 
		onfocus="focusText(this);"/>
		<s:hidden id="hiddenbank" value="开户银行与行号,1,1"></s:hidden>
		<div>
		<em class=requirecolor id="errbank" ></em>
		</div>
	</td>
  </tr>
  <tr height="30px">
	<td align="left">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;银行帐号：
		<input type="text" class="inputA" maxlength="20" id="bankAccount" name="tcontractContentsA.bankAccount" 
		value="<s:property value='%{tcontractContentsA.bankAccount}' escape='true'/>" onblur="blurText(this,'银行账号',1,6);" 
		onfocus="focusText(this);" onkeypress="return upms.upmsUtils.isNum(event,this)"  style="ime-mode: disabled;"/>
		<s:hidden id="hiddenbankAccount" value="银行账号,1,6"></s:hidden>
		<div>
		<em class=requirecolor id="errbankAccount" ></em>
		</div>
	</td>
  </tr>
  <tr height="30px">
	<td align="right">
		（公 章）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
  </tr>
  <tr height="40px">
  	<td align="right">
	  	<INPUT type="text"  class="txt w184p Wdate" name="tcontractContentsA.contractSelectDate2" 
	  	id="contractSelectDate2" value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tcontractContentsA.contractSelectDate2})}' />" 
	  	readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" onblur="blurText(this,'乙方（承担单位）的日期',1,1);" 
	  	onfocus="focusText(this);"/>
	  	<s:hidden id="hiddencontractSelectDate2" value="乙方（承担单位）的日期,1,1"></s:hidden>
		<div>
		<em class=requirecolor id="errcontractSelectDate2" ></em>
		</div>
  	</td>
  </tr>
  <tr height="30px">
	<td align="left">
		&nbsp;&nbsp;丙方（归口管理单位）：<s:property value='%{centralizedManagement}' escape='true'/>
	</td>
  </tr>
  <tr height="30px">
	<td align="left">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;单位负责人（签名）：
	</td>
  </tr>
  <tr height="30px">
	<td align="left">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;经  办  人（签名）：
	</td>
  </tr>
  <tr height="30px">
	<td align="right">
		（公 章）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
  </tr>
  <tr height="30px">
  	<td align="right">
	  	<INPUT class="txt w184p Wdate" type="text" name="tcontractContentsA.contractSelectDate3" 
	  	id="contractSelectDate3" value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tcontractContentsA.contractSelectDate3})}' />" 
	  	readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" onblur="blurText(this,'丙方（归口管理单位）的日期',1,1);" 
	  	onfocus="focusText(this);"/>
	  	<s:hidden id="hiddencontractSelectDate3" value="丙方（归口管理单位）的日期,1,1"></s:hidden>
		<div>
		<em class=requirecolor id="errcontractSelectDate3" ></em>
		</div>
  	</td>
  </tr>
</table>
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
</div>
</div>
</div>
</form>
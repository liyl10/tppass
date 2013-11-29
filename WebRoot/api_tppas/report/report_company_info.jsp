<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/js/report_company_info.js"></script>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<!-- 下一步按钮提示信息 -->
<label id="comfirmSaveNext" style="display: none"><s:text name="comfirmSaveNext"/></label>
<!-- 计划类别 -->
<s:hidden id="tprojectType" name="tprojectApplication.tprojectType.typeId" value="%{projectTypeId}"></s:hidden>
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<s:hidden id="companyInfoId" name="tcompanyInfo.companyInfoId" value="%{tcompanyInfo.companyInfoId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">${title}</div>
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm">
					  <tr>
						<td width="15%" align="right">
							项目单位
						</td>
						<td colspan="11" align="left">
							<input class="inputA" type="text" style=" width: 25em;" 
							id="applicationUnit" name="tprojectApplication.applicationUnit" 
					    	value="<s:property value='%{tprojectApplication.applicationUnit}' escape='true'/>" 
					    	disabled="disabled"/>
						</td>
					    </tr>
					  <tr>
					    <td align="right">
					    	项目名称
					    </td>
					    <td colspan="11" align="left">
					    	<input class="inputA" type="text" style=" width: 25em;" 
							id="projectName" name="tprojectApplication.projectName" 
					    	value="<s:property value='%{tprojectApplication.projectName}' escape='true'/>" 
					    	disabled="disabled"/>
					    </td>
					    </tr>
					  <tr>
					    <td rowspan="4"  width="10%"align="right">近三年企业经营状况</td>
					    <td align="center">
					   		 年度
					    </td>
					    <td align="center">
					    	销售收入
					    </td>
					    <td align="center">
					    	利润
					    </td>
						<td align="center">
							缴税
						</td>
					    <td align="center">
					   		 研发投入
					    </td>
					    <td align="center">
					    	利税率
					    </td>
					    <td align="center">
					    	R&amp;D
					    </td>
					    </tr>
					  <tr>
					    <td align="left"><FONT color=red>*</FONT>
					    	<input class="inputA" type="text" style=" width: 6.5em;" 
					    	id="yearOperate3" name="yearOperate3" 
					    	value="<s:property value='%{yearOperate3}' escape='true'/>"
					    	disabled="disabled"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="salesOperate3" name="tcompanyInfo.salesOperate3" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.salesOperate3})}" escape='true'/>"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="profitOperate3" name="tcompanyInfo.profitOperate3" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.profitOperate3})}" escape='true'/>"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="taxOperate3" name="tcompanyInfo.taxOperate3" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.taxOperate3})}" escape='true'/>"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="investmentOperate3" name="tcompanyInfo.investmentOperate3" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.investmentOperate3})}" escape='true'/>"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="interestRateOperate3" name="tcompanyInfo.interestRateOperate3" 
					    	value="<s:property value='%{tcompanyInfo.interestRateOperate3}' escape='true'/>" 
					    	disabled="disabled"/>&nbsp;%
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="rdOperate3" name="tcompanyInfo.rdOperate3" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.rdOperate3})}" escape='true'/>"
					    	/>&nbsp;%
					    </td>
					    </tr>
					  <tr>
					    <td align="left"><FONT color=red>*</FONT>
					    	<input class="inputA" type="text" style=" width: 6.5em;" 
					    	id="yearOperate2" name="yearOperate2" 
					    	value="<s:property value='%{yearOperate2}' escape='true'/>"
					    	disabled="disabled"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="salesOperate2" name="tcompanyInfo.salesOperate2" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.salesOperate2})}" escape='true'/>"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="profitOperate2" name="tcompanyInfo.profitOperate2" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.profitOperate2})}" escape='true'/>"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="taxOperate2" name="tcompanyInfo.taxOperate2" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.taxOperate2})}" escape='true'/>"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="investmentOperate2" name="tcompanyInfo.investmentOperate2" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.investmentOperate2})}" escape='true'/>"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="interestRateOperate2" name="tcompanyInfo.interestRateOperate2" 
					    	value="<s:property value='%{tcompanyInfo.interestRateOperate2}' escape='true'/>" 
					    	disabled="disabled"/>&nbsp;%
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="rdOperate2" name="tcompanyInfo.rdOperate2" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.rdOperate2})}" escape='true'/>"
					    	/>&nbsp;%
					    </td>
					    </tr>
					  <tr>
					    <td align="left"><FONT color=red>*</FONT>
					    	<input class="inputA" type="text" style=" width: 6.5em;" 
					    	id="yearOperate1" name="yearOperate1" 
					    	value="<s:property value='%{yearOperate1}' escape='true'/>"
					    	disabled="disabled"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="salesOperate1" name="tcompanyInfo.salesOperate1" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.salesOperate1})}" escape='true'/>"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="profitOperate1" name="tcompanyInfo.profitOperate1" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.profitOperate1})}" escape='true'/>"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="taxOperate1" name="tcompanyInfo.taxOperate1" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.taxOperate1})}" escape='true'/>"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="investmentOperate1" name="tcompanyInfo.investmentOperate1" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.investmentOperate1})}" escape='true'/>"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="interestRateOperate1" name="tcompanyInfo.interestRateOperate1" 
					    	value="<s:property value='%{tcompanyInfo.interestRateOperate1}' escape='true'/>" 
					    	disabled="disabled"/>&nbsp;%
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="rdOperate1" name="tcompanyInfo.rdOperate1" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.rdOperate1})}" escape='true'/>"
					    	/>&nbsp;%
					    </td>
					  </tr>
					  <tr>
					    <td align="right">
					    	<FONT color=red>*</FONT>${yearValue}年企业预期销售收入
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="expectedSales" name="tcompanyInfo.expectedSales" 
					    	value="<s:property value='%{tcompanyInfo.expectedSales}' escape='true'/>"/>
					    </td>
					    <td align="right">
					    	<FONT color=red>*</FONT>${yearValue}年企业预期税收
					    </td>
						<td align="left">
							<input class="inputA" type="text" style=" width: 6.5em;"
							id="expectedTax" name="tcompanyInfo.expectedTax" 
					    	value="<s:property value='%{tcompanyInfo.expectedTax}' escape='true'/>"/>
						</td>
					    <td align="right">
					    	<FONT color=red>*</FONT>${yearValue}年企业预期利润
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="expectedProfits" name="tcompanyInfo.expectedProfits" 
					    	value="<s:property value='%{tcompanyInfo.expectedProfits}' escape='true'/>"/>
					    </td>
					    <td align="left" colspan="2">
					    	注：项目执行期最后一年
					    </td>
					    </tr>
						
					  <tr>
					    <td align="right">
					    	<FONT color=red>*</FONT>近三年利税率
					    </td>
					    <td>
					    	<input class="inputA" type="text" style=" width: 6.5em;"
					    	id="interestRateThreeYears" name="tcompanyInfo.interestRateThreeYears" 
					    	value="<s:property value='%{tcompanyInfo.interestRateThreeYears}' escape='true'/>" 
					    	disabled="disabled"/>&nbsp;%
					    </td>
					    <td align="right">
					    	<FONT color=red>*</FONT>近三年平均增速
					    </td>
					    <td>
					    	<input class="inputA" type="text" style=" width: 6.5em;"
					    	id="averageGrowthThreeYears" name="tcompanyInfo.averageGrowthThreeYears" 
					    	value="<s:property value='%{tcompanyInfo.averageGrowthThreeYears}' escape='true'/>" 
					    	disabled="disabled"/>&nbsp;%
					    </td>
					    <td align="right">
					    	<FONT color=red>*</FONT>企业预期增速
					    </td>
					    <td>
					    	<input class="inputA" type="text" style=" width: 6.5em;"
					    	id="companyExpectedGrowth" name="tcompanyInfo.companyExpectedGrowth" 
					    	value="<s:property value='%{tcompanyInfo.companyExpectedGrowth}' escape='true'/>" 
					    	disabled="disabled"/>&nbsp;%
					    </td>
					    <td>
					    	&nbsp;
					    </td>
						 <td></td>
					    </tr>
					  <tr>
					    <td rowspan="4" align="right">
					    	近三年项目预期效益
					    </td>
					    <td align="center">
					    	年度
					    </td>
					    <td align="center">
					    	累计销售收入
					    </td>
						<td align="center">
							累计利润
						</td>
					    <td align="center">
					    	累计税收
					    </td>
						<td></td>
						<td></td>
						<td></td>
					    </tr>
					  <tr>
					    <td align="left"><FONT color=red>*</FONT>
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="yearBenefit3" name="yearBenefit3" 
					    	value="<s:property value='%{yearBenefit3}' escape='true'/>"
					    	disabled="disabled"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="salesBenefit1" name="tcompanyInfo.salesBenefit1" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.salesBenefit1})}" escape='true'/>"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="profitBenefit1" name="tcompanyInfo.profitBenefit1" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.profitBenefit1})}" escape='true'/>"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="taxBenefit1" name="tcompanyInfo.taxBenefit1" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.taxBenefit1})}" escape='true'/>"/>
					    </td>
						<td></td>
						<td></td>
						<td></td>
					    </tr>
					  <tr>
					    <td align="left"><FONT color=red>*</FONT>
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="yearBenefit2" name="yearBenefit2" 
					    	value="<s:property value='%{yearBenefit2}' escape='true'/>"
					    	disabled="disabled"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="salesBenefit2" name="tcompanyInfo.salesBenefit2" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.salesBenefit2})}" escape='true'/>"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="profitBenefit2" name="tcompanyInfo.profitBenefit2" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.profitBenefit2})}" escape='true'/>"/>
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="taxBenefit2" name="tcompanyInfo.taxBenefit2" 
					    	value="<s:property value="%{getText('format.money',{tcompanyInfo.taxBenefit2})}" escape='true'/>"/>
					    </td>
						<td></td>
						<td></td>
						<td></td>
					    </tr>
					  <tr>
					  <s:if test="%{year1Flag == 1}">
						    <td align="left"><FONT color=red>*</FONT>
						    	<input class="inputA" type="text" style=" width: 6.5em;"
								id="yearBenefit1" name="yearBenefit1" 
						    	value="<s:property value='%{yearBenefit1}' escape='true'/>"
						    	disabled="disabled"/>
						    </td>
						    <td align="left">
						    	<input class="inputA" type="text" style=" width: 6.5em;"
								id="salesBenefit3" name="tcompanyInfo.salesBenefit3" 
						    	value="<s:property value="%{getText('format.money',{tcompanyInfo.salesBenefit3})}" escape='true'/>"/>
						    </td>
						    <td align="left">
						    	<input class="inputA" type="text" style=" width: 6.5em;"
								id="profitBenefit3" name="tcompanyInfo.profitBenefit3" 
						    	value="<s:property value="%{getText('format.money',{tcompanyInfo.profitBenefit3})}" escape="true" />"
						    	/>
						    </td>
						    <td align="left">
						    	<input class="inputA" type="text" style=" width: 6.5em;"
								id="taxBenefit3" name="tcompanyInfo.taxBenefit3" 
						    	value="<s:property value="%{getText('format.money',{tcompanyInfo.taxBenefit3})}" escape='true'/>"/>
						    </td>
					    </s:if>
					    <s:else>
					    	<td align="left">
						    	<input class="inputA" type="text" style=" width: 6.5em;margin-left: 11px"
								id="yearBenefit1" name="yearBenefit1" 
						    	value="<s:property value='%{yearBenefit1}' escape='true'/>"
						    	disabled="disabled"/>
						    </td>
						    <td align="left">
						    	<input class="inputA" type="text" style=" width: 6.5em;"
								id="salesBenefit3" name="tcompanyInfo.salesBenefit3" 
						    	value="<s:property value="%{getText('format.money',{tcompanyInfo.salesBenefit3})}" escape='true'/>"/>
						    </td>
						    <td align="left">
						    	<input class="inputA" type="text" style=" width: 6.5em;"
								id="profitBenefit3" name="tcompanyInfo.profitBenefit3" 
						    	value="<s:property value="%{getText('format.money',{tcompanyInfo.profitBenefit3})}" escape='true'/>"/>
						    </td>
						    <td align="left">
						    	<input class="inputA" type="text" style=" width: 6.5em;"
								id="taxBenefit3" name="tcompanyInfo.taxBenefit3" 
						    	value="<s:property value="%{getText('format.money',{tcompanyInfo.taxBenefit3})}" escape='true'/>"/>
						    </td>
					    </s:else>
						<td></td>
						<td></td>
						<td></td>
					    </tr>
					  <tr>
					    <td rowspan="3" align="right">
					   		 <FONT color=red>*</FONT>项目预期增速
					    </td>
					    <td rowspan="3" align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
					    	id="projectExpectedGrowth" name="tcompanyInfo.projectExpectedGrowth" 
					    	value="<s:property value='%{tcompanyInfo.projectExpectedGrowth}' escape='true'/>" 
					    	disabled="disabled"/>&nbsp;%
					    </td>
					    <td rowspan="3" align="right">
					    	<FONT color=red>*</FONT>近三年平均R&amp;D	
					    </td>
					    <td rowspan="3" align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
					    	id="rdThreeYears" name="tcompanyInfo.rdThreeYears" 
					    	value="<s:property value='%{tcompanyInfo.rdThreeYears}' escape='true'/>" 
					    	disabled="disabled" />&nbsp;%
					    </td>
					   </tr>
					   <tr>
						<td align="right">
							<FONT color=red>*</FONT>申请专利数
						</td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="patentApplicationsNumber" name="tcompanyInfo.patentApplicationsNumber" 
					    	value="<s:property value='%{tcompanyInfo.patentApplicationsNumber}' escape='true'/>"/>
					    </td>
					     <td align="left">
					    	<FONT color=red>*</FONT>其中：发明项数
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 8em;"
							id="inventionNumber" name="tcompanyInfo.inventionNumber" 
					    	value="<s:property value='%{tcompanyInfo.inventionNumber}' escape='true'/>" 
					    	onblur="upms.upmsUtils.blurTextCheck(this,'发明项数',1,9);" 
					    	onfocus="upms.upmsUtils.textFocus(this)" maxlength="7" />
					    	<s:hidden id="hiddeninventionNumber" name="hidden" value="发明项数,1,9"></s:hidden>
					    </td>
					  </tr>
					  <tr>
						<td align="right">
							<FONT color=red>*</FONT>授权专利数
						</td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
							id="patentsNumber" name="tcompanyInfo.patentsNumber" 
					    	value="<s:property value='%{tcompanyInfo.patentsNumber}' escape='true'/>"/>
					    </td>
					     <td align="left">
					    	<FONT color=red>*</FONT>其中：发明项数
					    </td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 8em;"
							id="inventionNumber1" name="tcompanyInfo.inventionNumber1" 
					    	value="<s:property value='%{tcompanyInfo.inventionNumber1}' escape='true'/>" 
					    	onblur="upms.upmsUtils.blurTextCheck(this,'发明项数',1,9);" 
					    	onfocus="upms.upmsUtils.textFocus(this)" maxlength="7" />
					    	<s:hidden id="hiddeninventionNumber1" name="hidden" value="发明项数,1,9"></s:hidden>
					    </td>
					  </tr>
<%-- 				  <tr>
					    <td align="right">院所/高端人才</td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
					    	id="institutesHighTalent" name="tcompanyInfo.institutesHighTalent" 
					    	value="<s:property value='%{tcompanyInfo.institutesHighTalent}' escape='true'/>"
							maxlength="100" onblur="upms.upmsUtils.blurTextCheck(this,'院所/高端人才',0,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    						<s:hidden id="hiddeninstitutesHighTalent" name="hidden" value="院所/高端人才,0,-1"/>
					    </td>
					    <td align="right">推荐意见</td>
					    <td align="left">
    						<s:select list="recommendationList" listKey="itemId" label="abc" listValue="itemName"
							id="recommendation" name="tcompanyInfo.recommendation" style="width:9em;"></s:select>
							<s:hidden id="recommendationValue" name="recommendationValue" value="%{tcompanyInfo.recommendation}"/>
    						<s:hidden id="hiddenrecommendation" name="hidden" value="推荐意见"/>
					    </td>
					    <td align="right">投资专家平均分</td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
					    	id="averageInvestmentExperts" name="tcompanyInfo.averageInvestmentExperts" 
					    	value="<s:property value='%{tcompanyInfo.averageInvestmentExperts}' escape='true'/>"
							maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'投资专家平均分',0,12);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    						<s:hidden id="hiddenaverageInvestmentExperts" name="hidden" value="投资专家平均分,0,12"/>
					    </td>
					    <td align="left">
					    	&nbsp;
					    </td>
					    <td></td>
					   </tr>
					  <tr>
					    <td align="right">技术专家平均分</td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
					    	id="averageTechnicalExperts" name="tcompanyInfo.averageTechnicalExperts" 
					    	value="<s:property value='%{tcompanyInfo.averageTechnicalExperts}' escape='true'/>"
					    	maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'技术专家平均分',0,12);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
    						<s:hidden id="hiddenaverageTechnicalExperts" name="hidden" value="技术专家平均分,0,12"/>
					    </td>
					    <td align="right">投资专家</td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
					    	id="investmentExperts" name="tcompanyInfo.investmentExperts" 
					    	value="<s:property value='%{tcompanyInfo.investmentExperts}' escape='true'/>"
							maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'投资专家',0,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    						<s:hidden id="hiddeninvestmentExperts" name="hidden" value="投资专家,0,-1"/>
					    </td>
					    <td align="right">技术专家</td>
					    <td align="left">
					    	<input class="inputA" type="text" style=" width: 6.5em;"
					    	id="technicalExperts" name="tcompanyInfo.technicalExperts" 
					    	value="<s:property value='%{tcompanyInfo.technicalExperts}' escape='true'/>"
							maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'技术专家',0,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>	
    						<s:hidden id="hiddentechnicalExperts" name="hidden" value="技术专家,0,-1"/>
					    </td>
					    <td align="left">
					    	&nbsp;
					    </td>
					    <td></td>
					   </tr>
					   --%>	
					</table>
				<div align="center" style="width: 100%">
					<br> <br>
					<%-- <tag:auth code="tppass.report.company.save">
					<input id="okBtn" type="button" class="button save" href="javascript: void(0);" value="保存"/>
					</tag:auth>
					&nbsp;--%>
					<tag:auth code="tppass.report.company.next">
					<input id="nextBtn" type="button" class="button save" href="javascript: void(0);" value="下一步"/>
					</tag:auth>
				</div>
			</div>
		</div>
	</div>
</div>
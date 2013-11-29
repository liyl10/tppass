<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/highTech/js/supervisorApply_info.js"></script>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<s:hidden id="supprotFlag" value="%{supportFlag}"></s:hidden>
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">
					项目执行情况监理表
					<s:if test="%{supportFlag==1}">（项目类）</s:if>
					<s:else>（平台类）</s:else>
				</div>
				<form id="addform" action="depart.html">
					<table style="width: 100%;" cellspacing="0" cellpadding="0" class="t-entRegFrm">
						<tr>
							<td align="right" style="width:30%;">项目名称</td>
							<td colspan="3">
								<s:label id="projectName" value="%{projectName}" />
							</td>
							<td align="right">项目编号</td>
							<td colspan="3">
								<s:label id="projectNumber" value="%{projectNumber}" />
							</td>
						</tr>
						<tr>
							<td align="right">承担单位</td>
							<td colspan="7">
								<s:label id="applicationUnit" value="%{applicationUnit}" />（章）
							</td>
						</tr>
						<tr>
							<td align="right"><FONT color=red>*</FONT>项目所属领域</td>
							<td colspan="7">
								<s:radio name="tsupervisorInfo.field" list="%{projectField}" listKey="itemId" listValue="itemName" value="%{tsupervisorInfo.field}" disabled="%{isLastApply}"></s:radio>
								<s:hidden id="hiddenOtherField" value="%{@com.hopsun.tppas.common.Constants@PROJECT_FIELD_7}" />
								<s:textfield cssClass="inputA" cssStyle="width:200px" id="otherField" maxlength="20" 
								name="tsupervisorInfo.otherField" value="%{tsupervisorInfo.otherField}" disabled="%{isLastApply}">
								</s:textfield>
								<div id="otherFieldMsg"></div></td>
						</tr>
						<s:if test="%{supportFlag==1}">
							<tr>
								<td  rowspan="2" align="right">项目负责人</td>
								<td align="right"><FONT color=red>*</FONT>姓名</td>
								<td colspan="2"><s:textfield cssClass="inputA"
										cssStyle="width:103px" id="projectPersonName"
										name="tsupervisorInfo.projectPersonName"
										value="%{tsupervisorInfo.projectPersonName}" maxlength="15"
										onblur="blurText(this,'姓名',1,0);" onfocus="focusText(this);"
										disabled="%{isLastApply}" /> <s:hidden
										id="hiddenprojectPersonName" name="hidden" value="姓名,1,0"></s:hidden>
								</td>
								<td align="right"><FONT color=red>*</FONT>学历</td>
								<td colspan="3"><s:radio
										name="tsupervisorInfo.projectPersonEducation"
										list="%{eduBackground}" listKey="itemId" listValue="itemName"
										value="%{tsupervisorInfo.projectPersonEducation}"
										disabled="%{isLastApply}"></s:radio></td>
							</tr>
							<tr>
								<td align="right"><FONT color=red>*</FONT>职称</td>
								<td colspan="6" align="left"><s:radio
										name="tsupervisorInfo.projectPersonTitle"
										value="%{tsupervisorInfo.projectPersonTitle}"
										list="%{personTitle}" listKey="itemId" listValue="itemName"
										disabled="%{isLastApply}">
									</s:radio></td>
							</tr>
							<tr>
								<td align="right" style="width: 70px"><FONT
									color=red>*</FONT>项目联系人</td>
								<td style="width: 10%"><s:textfield cssClass="inputA"
										cssStyle="width:103px" id="linkPersonName"
										name="tsupervisorInfo.linkPersonName"
										value="%{tsupervisorInfo.linkPersonName}" maxlength="15"
										onblur="blurText(this,'项目联系人',1,0);"
										onfocus="focusText(this);" disabled="%{isLastApply}" /> <s:hidden
										id="hiddenlinkPersonName" name="hidden" value="项目联系人,1,0"></s:hidden>
								</td>
								<td align="right"><FONT color=red>*</FONT>电话</td>
								<td><s:textfield cssClass="inputA" id="linkPersonTel"
										name="tsupervisorInfo.linkPersonTel"
										value="%{tsupervisorInfo.linkPersonTel}"
										onblur="blurText(this,'电话号码',1,6);" onfocus="focusText(this);"
										style="width: 100px" disabled="%{isLastApply}" maxlength="13" />
									<s:hidden id="hiddenlinkPersonTel" name="hidden"
										value="电话号码,1,6"></s:hidden></td>
								<td align="right"><FONT color=red>*</FONT>手机</td>
								<td colspan="2"><s:textfield cssClass="inputA"
										cssStyle="width:100px" id="linkPersonMobile"
										name="tsupervisorInfo.linkPersonMobile"
										value="%{tsupervisorInfo.linkPersonMobile}" maxlength="11"
										onblur="blurText(this,'手机号码',1,5);" onfocus="focusText(this);"
										disabled="%{isLastApply}" /> <s:hidden
										id="hiddenlinkPersonMobile" name="hidden" value="手机号码,1,5"></s:hidden>
								</td>
							</tr>
						</s:if>
						<s:else>
							<tr>
								<td align="right"><FONT
									color=red>*</FONT>项目负责人</td>
								<td style="width: 10%"><s:textfield cssClass="inputA"
										cssStyle="width:103px" id="projectPersonName"
										name="tsupervisorInfo.projectPersonName"
										value="%{tsupervisorInfo.projectPersonName}" maxlength="15"
										onblur="blurText(this,'姓名',1,0);" onfocus="focusText(this);"
										disabled="%{isLastApply}" /> <s:hidden
										id="hiddenprojectPersonName" name="hidden" value="姓名,1,0"></s:hidden>
								</td>
								<td align="right"><FONT color=red>*</FONT>电话</td>
								<td><s:textfield cssClass="inputA" id="linkPersonTel"
										name="tsupervisorInfo.linkPersonTel"
										value="%{tsupervisorInfo.linkPersonTel}"
										onblur="blurText(this,'电话号码',1,6);" onfocus="focusText(this);"
										style="width: 100px" disabled="%{isLastApply}" maxlength="13" />
									<s:hidden id="hiddenlinkPersonTel" name="hidden"
										value="电话号码,1,6"></s:hidden></td>
								<td align="right"><FONT color=red>*</FONT>手机</td>
								<td colspan="2"><s:textfield cssClass="inputA"
										cssStyle="width:100px" id="linkPersonMobile"
										name="tsupervisorInfo.linkPersonMobile"
										value="%{tsupervisorInfo.linkPersonMobile}" maxlength="11"
										onblur="blurText(this,'手机号码',1,5);" onfocus="focusText(this);"
										disabled="%{isLastApply}" /> <s:hidden
										id="hiddenlinkPersonMobile" name="hidden" value="手机号码,1,5"></s:hidden>
								</td>
							</tr>
						</s:else>
						<tr>
							<td align="right"><FONT color=red>*</FONT>项目实施进展情况</td>
							<td colspan="7"><s:radio
									name="tsupervisorInfo.projectSchedule"
									value="%{tsupervisorInfo.projectSchedule}"
									list="%{projectProgress}" listKey="itemId" listValue="itemName"
									disabled="%{isLastApply}"></s:radio></td>
						</tr>
						<tr>
							<td colspan="8">项目未按计划进行的原因（最多选三项）<br /> <s:checkboxlist
									name="selectedProjectStopReason" list="%{projectStopReason}"
									listKey="itemId" listValue="itemName" disabled="%{isLastApply}">
								</s:checkboxlist> <s:hidden id="otherReason"
									value="%{@com.hopsun.tppas.common.Constants@PROJECT_STOP_REASON_8}" />
								<div id="reason">
									<s:if test="%{isLastApply=='false'}">
										<s:textarea cssClass="inputA" id="reasonCommand"
											style="width:80%; height:50px;resize:none;"
											value="%{tsupervisorInfo.projectReasonCommand}"
											onKeyUp="this.value = upms.upmsUtils.checkTextareaLength(this.value, 200);"></s:textarea>
									</s:if>
									<s:else>
										<s:textarea cssClass="inputA" id="reasonCommand"
											style="width:80%; height:50px;resize:none;background-color:#F0F0F0"
											value="%{tsupervisorInfo.projectReasonCommand}"
											readonly="true"></s:textarea>
									</s:else>
									<div id="reasonCommandMsg"></div>
								</div>
							</td>
						</tr>
						<s:if test="%{supportFlag==1}">
							<tr>
								<td align="right"><FONT color=red>*</FONT>目前公司资产</td>
								<td colspan="7"><s:textfield cssClass="inputA"
										cssStyle="width:120px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										id="companyAssets"
										name="tsupervisorInfo.companyAssets"
										value="%{tsupervisorInfo.companyAssets}"
										onblur="blurText(this,'目前公司资产',1,3);"
										onfocus="focusText(this);" disabled="%{isLastApply}"
										maxlength="10" />（万元） <s:hidden id="hiddencompanyAssets"
										name="hidden" value="目前公司资产,1,3"></s:hidden></td>
							</tr>
							<tr>
								<td rowspan="8" align="right">经济效益</td>
								<td rowspan="2" align="right">单 位:（万元）</td>
								<td colspan="3" align="center">企业情况</td>
								<td colspan="3" align="center">项目情况</td>
							</tr>
							<tr>
								<td align="center"><s:property value="%{lastThreeYear}" />年</td>
								<td align="center"><s:property value="%{lastTwoYear}" />年</td>
								<td align="center"><s:property value="%{lastOneYear}" />上半年</td>
								<td align="center"><s:property value="%{lastThreeYear}" />年</td>
								<td align="center"><s:property value="%{lastTwoYear}" />年</td>
								<td align="center"><s:property value="%{lastOneYear}" />上半年</td>
							</tr>
							<tr>
								<td align="right"><FONT color=red>*</FONT>产值</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="companyOutputThree"
										name="tsupervisorInfo.companyOutputThree"
										value="%{tsupervisorInfo.companyOutputThree}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'产值',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddencompanyOutputThree" name="hidden" value="产值,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="companyOutputTwo" name="tsupervisorInfo.companyOutputTwo"
										value="%{tsupervisorInfo.companyOutputTwo}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'产值',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddencompanyOutputTwo" name="hidden" value="产值,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="companyOutputOne" name="tsupervisorInfo.companyOutputOne"
										value="%{tsupervisorInfo.companyOutputOne}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'产值',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddencompanyOutputOne" name="hidden" value="产值,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="projectOutputThree"
										name="tsupervisorInfo.projectOutputThree"
										value="%{tsupervisorInfo.projectOutputThree}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'产值',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddenprojectOutputThree" name="hidden" value="产值,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="projectOutputTwo" name="tsupervisorInfo.projectOutputTwo"
										value="%{tsupervisorInfo.projectOutputTwo}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'产值',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddenprojectOutputTwo" name="hidden" value="产值,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="projectOutputOne" name="tsupervisorInfo.projectOutputOne"
										value="%{tsupervisorInfo.projectOutputOne}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'产值',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddenprojectOutputOne" name="hidden" value="产值,1,3"></s:hidden>
								</td>
							</tr>
							<tr>
								<td align="right"><FONT color=red>*</FONT>销售收入</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="companySellThree" name="tsupervisorInfo.companySellThree"
										value="%{tsupervisorInfo.companySellThree}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'销售收入',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddencompanySellThree" name="hidden" value="销售收入,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="companySellTwo" name="tsupervisorInfo.companySellTwo"
										value="%{tsupervisorInfo.companySellTwo}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'销售收入',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddencompanySellTwo" name="hidden" value="销售收入,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="companySellOne" name="tsupervisorInfo.companySellOne"
										value="%{tsupervisorInfo.companySellOne}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'销售收入',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddencompanySellOne" name="hidden" value="销售收入,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="projectSellThree" name="tsupervisorInfo.projectSellThree"
										value="%{tsupervisorInfo.projectSellThree}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'销售收入',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddenprojectSellThree" name="hidden" value="销售收入,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="projectSellTwo" name="tsupervisorInfo.projectSellTwo"
										value="%{tsupervisorInfo.projectSellTwo}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'销售收入',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddenprojectSellTwo" name="hidden" value="销售收入,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="projectSellOne" name="tsupervisorInfo.projectSellOne"
										value="%{tsupervisorInfo.projectSellOne}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'销售收入',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddenprojectSellOne" name="hidden" value="销售收入,1,3"></s:hidden>
								</td>
							</tr>
							<tr>
								<td align="right"><FONT color=red>*</FONT>净利润总额</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="companyProfitThree"
										name="tsupervisorInfo.companyProfitThree"
										value="%{tsupervisorInfo.companyProfitThree}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'净利润总额',1,3);"
										onfocus="focusText(this);" disabled="%{isLastApply}"
										maxlength="10" /> <s:hidden id="hiddencompanyProfitThree"
										name="hidden" value="净利润总额,1,3"></s:hidden></td>
								<td align="left"><s:textfield cssClass="inputA"
										id="companyProfitTwo" name="tsupervisorInfo.companyProfitTwo"
										value="%{tsupervisorInfo.companyProfitTwo}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'净利润总额',1,3);"
										onfocus="focusText(this);" disabled="%{isLastApply}"
										maxlength="10" /> <s:hidden id="hiddencompanyProfitTwo"
										name="hidden" value="净利润总额,1,3"></s:hidden></td>
								<td align="left"><s:textfield cssClass="inputA"
										id="companyProfitOne" name="tsupervisorInfo.companyProfitOne"
										value="%{tsupervisorInfo.companyProfitOne}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'净利润总额',1,3);"
										onfocus="focusText(this);" disabled="%{isLastApply}"
										maxlength="10" /> <s:hidden id="hiddencompanyProfitOne"
										name="hidden" value="净利润总额,1,3"></s:hidden></td>
								<td align="left"><s:textfield cssClass="inputA"
										id="projectProfitThree"
										name="tsupervisorInfo.projectProfitThree"
										value="%{tsupervisorInfo.projectProfitThree}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'净利润总额',1,3);"
										onfocus="focusText(this);" disabled="%{isLastApply}"
										maxlength="10" /> <s:hidden id="hiddenprojectProfitThree"
										name="hidden" value="净利润总额,1,3"></s:hidden></td>
								<td align="left"><s:textfield cssClass="inputA"
										id="projectProfitTwo" name="tsupervisorInfo.projectProfitTwo"
										value="%{tsupervisorInfo.projectProfitTwo}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'净利润总额',1,3);"
										onfocus="focusText(this);" disabled="%{isLastApply}"
										maxlength="10" /> <s:hidden id="hiddenprojectProfitTwo"
										name="hidden" value="净利润总额,1,3"></s:hidden></td>
								<td align="left"><s:textfield cssClass="inputA"
										id="projectProfitOne" name="tsupervisorInfo.projectProfitOne"
										value="%{tsupervisorInfo.projectProfitOne}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'净利润总额',1,3);"
										onfocus="focusText(this);" disabled="%{isLastApply}"
										maxlength="10" /> <s:hidden id="hiddenprojectProfitOne"
										name="hidden" value="净利润总额,1,3"></s:hidden></td>
							</tr>
							<tr>
								<td align="right"><FONT color=red>*</FONT>交税总额</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="companyTaxThree" name="tsupervisorInfo.companyTaxThree"
										value="%{tsupervisorInfo.companyTaxThree}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'交税总额',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddencompanyTaxThree" name="hidden" value="交税总额,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="companyTaxTwo" name="tsupervisorInfo.companyTaxTwo"
										value="%{tsupervisorInfo.companyTaxTwo}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'交税总额',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddencompanyTaxTwo" name="hidden" value="交税总额,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="companyTaxOne" name="tsupervisorInfo.companyTaxOne"
										value="%{tsupervisorInfo.companyTaxOne}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'交税总额',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddencompanyTaxOne" name="hidden" value="交税总额,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="projectTaxThree" name="tsupervisorInfo.projectTaxThree"
										value="%{tsupervisorInfo.projectTaxThree}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'交税总额',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddenprojectTaxThree" name="hidden" value="交税总额,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="projectTaxTwo" name="tsupervisorInfo.projectTaxTwo"
										value="%{tsupervisorInfo.projectTaxTwo}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'交税总额',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddenprojectTaxTwo" name="hidden" value="交税总额,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="projectTaxOne" name="tsupervisorInfo.projectTaxOne"
										value="%{tsupervisorInfo.projectTaxOne}"
										style="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'交税总额',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddenprojectTaxOne" name="hidden" value="交税总额,1,3"></s:hidden>
								</td>
							</tr>
							<tr>
								<td align="right"><FONT color=red>*</FONT>出口创汇<br />（万美元）</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="companyExportThree"
										name="tsupervisorInfo.companyExportThree"
										value="%{tsupervisorInfo.companyExportThree}"
										cssStyle="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'出口创汇',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddencompanyExportThree" name="hidden" value="出口创汇,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="companyExportTwo" name="tsupervisorInfo.companyExportTwo"
										value="%{tsupervisorInfo.companyExportTwo}"
										cssStyle="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'出口创汇',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddencompanyExportTwo" name="hidden" value="出口创汇,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="companyExportOne" name="tsupervisorInfo.companyExportOne"
										value="%{tsupervisorInfo.companyExportOne}"
										cssStyle="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'出口创汇',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddencompanyExportOne" name="hidden" value="出口创汇,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="projectExportThree"
										name="tsupervisorInfo.projectExportThree"
										value="%{tsupervisorInfo.projectExportThree}"
										cssStyle="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'出口创汇',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddenprojectExportThree" name="hidden" value="出口创汇,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="projectExportTwo" name="tsupervisorInfo.projectExportTwo"
										value="%{tsupervisorInfo.projectExportTwo}"
										cssStyle="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'出口创汇',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddenprojectExportTwo" name="hidden" value="出口创汇,1,3"></s:hidden>
								</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="projectExportOne" name="tsupervisorInfo.projectExportOne"
										value="%{tsupervisorInfo.projectExportOne}"
										cssStyle="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'出口创汇',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddenprojectExportOne" name="hidden" value="出口创汇,1,3"></s:hidden>
								</td>
							</tr>
						</s:if>
						<s:else>
							<tr>
								<td colspan="2" rowspan="4" align="right">硬件设施</td>
								<td colspan="2" align="right"><FONT color=red>*</FONT>硬件设施面积（平方米）</td>
								<td colspan="4" align="left"><s:textfield cssClass="inputA"
										id="hardwareArea" name="tsupervisorInfo.hardwareArea"
										value="%{tsupervisorInfo.hardwareArea}"
										cssStyle="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'硬件设施面积',1,2);"
										onfocus="focusText(this);" disabled="%{isLastApply}"
										maxlength="10" /> <s:hidden id="hiddenhardwareArea"
										name="hidden" value="硬件设施面积,1,2"></s:hidden></td>
							</tr>
							<tr>
								<td colspan="2" align="right"><FONT color=red>*</FONT>设备总值（万元）</td>
								<td colspan="4" align="left"><s:textfield cssClass="inputA"
										id="equipmentTotal" name="tsupervisorInfo.equipmentTotal"
										value="%{tsupervisorInfo.equipmentTotal}"
										cssStyle="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
										onblur="blurText(this,'设备总值',1,3);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="10" /> <s:hidden
										id="hiddenequipmentTotal" name="hidden" value="设备总值,1,3"></s:hidden>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="right"><FONT color=red>*</FONT>硬件设备总数（提供清单）</td>
								<td colspan="4" align="left"><s:textfield cssClass="inputA"
										id="hardwareTotal" name="tsupervisorInfo.hardwareTotal"
										value="%{tsupervisorInfo.hardwareTotal}"
										cssStyle="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isNum(event,this)"
										onblur="blurText(this,'硬件设备总数',1,4);"
										onfocus="focusText(this);" disabled="%{isLastApply}"
										maxlength="11" /> <s:hidden id="hiddenhardwareTotal"
										name="hidden" value="硬件设备总数,1,4"></s:hidden></td>
							</tr>
							<tr>
								<td colspan="2" align="right"><FONT color=red>*</FONT>新增加设备数（提供清单）</td>
								<td colspan="4" align="left"><s:textfield cssClass="inputA"
										id="newHardwareTotal" name="tsupervisorInfo.newHardwareTotal"
										value="%{tsupervisorInfo.newHardwareTotal}"
										cssStyle="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isNum(event,this)"
										onblur="blurText(this,'新增加设备数',1,4);"
										onfocus="focusText(this);" disabled="%{isLastApply}"
										maxlength="11" /> <s:hidden id="hiddennewHardwareTotal"
										name="hidden" value="新增加设备数,1,4"></s:hidden></td>
							</tr>
							<tr>
								<td colspan="2" align="right">人员情况</td>
								<td align="right"><FONT color=red>*</FONT>员工总数</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="staffTotal" name="tsupervisorInfo.staffTotal"
										value="%{tsupervisorInfo.staffTotal}"
										cssStyle="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isNum(event,this)"
										onblur="blurText(this,'员工总数',1,4);" onfocus="focusText(this);"
										disabled="%{isLastApply}" maxlength="11" /> <s:hidden
										id="hiddenstaffTotal" name="hidden" value="员工总数,1,4"></s:hidden>人</td>
								<td align="right"><FONT color=red>*</FONT>本科以上</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="undergraduateTotal"
										name="tsupervisorInfo.undergraduateTotal"
										value="%{tsupervisorInfo.undergraduateTotal}"
										cssStyle="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isNum(event,this)"
										onblur="blurText(this,'本科以上人数',1,4);"
										onfocus="focusText(this);" disabled="%{isLastApply}"
										maxlength="11" /> <s:hidden id="hiddenundergraduateTotal"
										name="hidden" value="本科以上人数,1,4"></s:hidden>人
									<div id="compareErrMsg"></div></td>
								<td></td>
							</tr>
							<tr>
								<td colspan="2" align="right">提供服务情况</td>
								<td align="right"><FONT color=red>*</FONT>为企业培训人数</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="trainTotal" name="tsupervisorInfo.trainTotal"
										value="%{tsupervisorInfo.trainTotal}"
										cssStyle="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isNum(event,this)"
										onblur="blurText(this,'为企业培训人数',1,4);"
										onfocus="focusText(this);" disabled="%{isLastApply}"
										maxlength="11" /> <s:hidden id="hiddentrainTotal"
										name="hidden" value="为企业培训人数,1,4"></s:hidden>人</td>
								<td align="right"><FONT color=red>*</FONT>技术服务的企业数（提供企业名单）</td>
								<td align="left"><s:textfield cssClass="inputA"
										id="serviceTotal" name="tsupervisorInfo.serviceTotal"
										value="%{tsupervisorInfo.serviceTotal}"
										cssStyle="width: 100px;ime-mode: disabled;"
										onkeypress="return upms.upmsUtils.isNum(event,this)"
										onblur="blurText(this,'技术服务的企业数',1,4);"
										onfocus="focusText(this);" disabled="%{isLastApply}"
										maxlength="11" /> <s:hidden id="hiddenserviceTotal"
										name="hidden" value="技术服务的企业数,1,4"></s:hidden>个</td>
								<td></td>
							</tr>
						</s:else>
					</table>
				</form>
			</div>
			<div align="center" style="width: 95%">
				<s:if test="%{isLastApply=='false'}">
					<input class="button save" id="saveBtn" type="button" value="保存" />
					<input class="button save" id="nextBtn" type="button" value="下一步">
				</s:if>
				<s:else>
					<input class="button save" id="nextBtn2" type="button" value="下一步">
				</s:else>
			</div>
		</div>
	</div>
</div>
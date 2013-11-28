<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/expert/expertScore/js/expert_score_form.js"></script>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<!-- 下一个消息提示 -->
<label id="comfirmNext" style="display: none"><s:text name="confirm_project_save_and_next_info"/></label>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">录入评审分数</div>
					<div id="resultDiv">
						<div class="abuot03" align="center" id="dataForm">
							<s:hidden id="groupId" name="groupId" value="%{groupId}"></s:hidden>
							<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
							<s:hidden id="projectIndex" name="projectIndex" value="%{projectIndex}"></s:hidden>
							<label id="technologyList" style="display: none"><s:property value="%{technologyList.size}" escape="true"/></label>
							<label id="investmentList" style="display: none"><s:property value="%{investmentList.size}" escape="true"/></label>	
							<div align="left">
								</br></br></br>
								<font size="2px"><strong>&nbsp;&nbsp;&nbsp;技术专家：</strong></font>
							</div>
							<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm" align="left">
								<s:if test="technologyReviewComments!=null">
									<tr align="center">
										<td width="10%">专家姓名</td>
										<td width="10%"><s:property value="%{technologyReviewComments.evaluationIndex1}" escape="true"/></td>
										<td width="10%"><s:property value="%{technologyReviewComments.evaluationIndex2}" escape="true"/></td>
										<td width="10%"><s:property value="%{technologyReviewComments.evaluationIndex3}" escape="true"/></td>
										<td width="10%"><s:property value="%{technologyReviewComments.evaluationIndex4}" escape="true"/></td>
										<td width="10%"><s:property value="%{technologyReviewComments.evaluationIndex5}" escape="true"/></td>
										<!-- <td width="10%">平均分</td> -->
										<td width="10%">总分</td>
										<td width="20%">推荐等级</td>
									</tr>
								</s:if>
								<s:if test="technologyList.size > 0">
									<input type="hidden" id="technologyListSize" name="technologyListSize" value="${fn:length(technologyList)}"/>
									<s:iterator value="technologyList" status="rowData">
										<tr align="center">
											<s:hidden id="scoreId%{#rowData.count}" name="technologyList[%{#rowData.count}].scoreId" value="%{scoreId}"></s:hidden>
											<s:hidden id="texpert%{#rowData.count}" name="technologyList[%{#rowData.count}].texpert.expertId" value="%{texpert.expertId}"></s:hidden>
											<td><s:property value="%{texpert.expertName}" escape="true"/></td>
											<td>
												<input type="text" id="companyStatusScore<s:property value='%{#rowData.count}' escape='true'/>" name="technologyList[<s:property value='%{#rowData.count}' escape='true'/>].companyStatusScore" value="<s:property value='%{companyStatusScore}' escape='true'/>" class="inputA" style="width:5em;" 
													maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'',1,12);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this)" onchange="countComplexScore(<s:property value='%{#rowData.count}' escape='true'/>,0);" moneyFlag="money"/>
												 <s:hidden id="hiddencompanyStatusScore%{#rowData.count}" name="hidden" value=",1,12"></s:hidden>
											</td>
											<td>
												<input type="text" id="projectTechnologyScore<s:property value='%{#rowData.count}' escape='true'/>" name="technologyList[<s:property value='%{#rowData.count}' escape='true'/>].projectTechnologyScore" value="<s:property value='%{projectTechnologyScore}' escape='true'/>" class="inputA" style="width:5em;"
													maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'',1,12);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this)" onchange="countComplexScore(<s:property value='%{#rowData.count}' escape='true'/>,0);" moneyFlag="money"/>
												<s:hidden id="hiddenprojectTechnologyScore%{#rowData.count}" name="hidden" value=",1,12"></s:hidden>
											</td>
											<td>
												<input type="text" id="projectBaseScore<s:property value='%{#rowData.count}' escape='true'/>" name="technologyList[<s:property value='%{#rowData.count}' escape='true'/>].projectBaseScore" value="<s:property value='%{projectBaseScore}' escape='true'/>" class="inputA" style="width:5em;"
													maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'',1,12);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this)" onchange="countComplexScore(<s:property value='%{#rowData.count}' escape='true'/>,0);" moneyFlag="money"/>
												<s:hidden id="hiddenprojectBaseScore%{#rowData.count}" name="hidden" value=",1,12"></s:hidden>
											</td>
											<td>
												<input type="text" id="projectMarketScore<s:property value='%{#rowData.count}' escape='true'/>" name="technologyList[<s:property value='%{#rowData.count}' escape='true'/>].projectMarketScore" value="<s:property value='%{projectMarketScore}' escape='true'/>" class="inputA" style="width:5em;"
													maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'',1,12);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this)" onchange="countComplexScore(<s:property value='%{#rowData.count}' escape='true'/>,0);" moneyFlag="money"/>
												<s:hidden id="hiddenprojectMarketScore%{#rowData.count}" name="hidden" value=",1,12"></s:hidden>
											</td>
											<td>
												<input type="text" id="projectBenefitScore<s:property value='%{#rowData.count}' escape='true'/>" name="technologyList[<s:property value='%{#rowData.count}' escape='true'/>].projectBenefitScore" value="<s:property value='%{projectBenefitScore}' escape='true'/>" class="inputA" style="width:5em;"
													maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'',1,12);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this)" onchange="countComplexScore(<s:property value='%{#rowData.count}' escape='true'/>,0);" moneyFlag="money"/>
												<s:hidden id="hiddenprojectBenefitScore%{#rowData.count}" name="hidden" value=",1,12"></s:hidden>
											</td>
											<!-- 
											<td>
												<input type="text" id="complexAverage<s:property value='%{#rowData.count}' escape='true'/>" name="technologyList[<s:property value='%{#rowData.count}' escape='true'/>].complexAverage" value="<s:property value='%{complexAverage}' escape='true'/>" class="inputA" style="width:5em;" disabled="disabled"/>
											</td>
											-->
											<td>
												<input type="text" id="complexScore<s:property value='%{#rowData.count}' escape='true'/>" name="technologyList[<s:property value='%{#rowData.count}' escape='true'/>].complexScore" value="<s:property value='%{complexScore}' escape='true'/>" class="inputA" style="width:5em;" disabled="disabled"/>
											</td>
											<td>
												
												<input type="radio" name="technologyList[<s:property value='%{#rowData.count}' escape='true'/>].finalResult" value="A" ${finalResult=='A'?'checked':''} onchange="upms.upmsUtils.radioChange(this,1);"/>重点推荐
												<input type="radio" name="technologyList[<s:property value='%{#rowData.count}' escape='true'/>].finalResult" value="B" ${finalResult=='B'?'checked':''} onchange="upms.upmsUtils.radioChange(this,1);"/>推荐
												<input type="radio" name="technologyList[<s:property value='%{#rowData.count}' escape='true'/>].finalResult" value="C" ${finalResult=='C'?'checked':''} onchange="upms.upmsUtils.radioChange(this,1);"/>备选
												<input type="radio" name="technologyList[<s:property value='%{#rowData.count}' escape='true'/>].finalResult" value="D" ${finalResult=='D'?'checked':''} onchange="upms.upmsUtils.radioChange(this,1);"/>落选
												<s:hidden id="hiddentechnologyList%{#rowData.count}" name="hidden" value=""></s:hidden>
											</td>
										</tr>
										<s:hidden id="companyStatusStandard%{#rowData.count}" name="technologyList[%{#rowData.count}].companyStatusStandard" value="%{companyStatusStandard}"></s:hidden>
										<s:hidden id="projectTechnologyStandard%{#rowData.count}" name="technologyList[%{#rowData.count}].projectTechnologyStandard" value="%{projectTechnologyStandard}"></s:hidden>
										<s:hidden id="projectBaseStandard%{#rowData.count}" name="technologyList[%{#rowData.count}].projectBaseStandard" value="%{projectBaseStandard}"></s:hidden>
										<s:hidden id="projectMarketStandard%{#rowData.count}" name="technologyList[%{#rowData.count}].projectMarketStandard" value="%{projectMarketStandard}"></s:hidden>
										<s:hidden id="projectBenefitType%{#rowData.count}" name="technologyList[%{#rowData.count}].projectBenefitType" value="%{projectBenefitType}"></s:hidden>
										<s:hidden id="projectBenefitStandard%{#rowData.count}" name="technologyList[%{#rowData.count}].projectBenefitStandard" value="%{projectBenefitStandard}"></s:hidden>
										<s:hidden id="complexOpinion%{#rowData.count}" name="technologyList[%{#rowData.count}].complexOpinion" value="%{complexOpinion}"></s:hidden>
										<s:hidden id="explanationReason%{#rowData.count}" name="technologyList[%{#rowData.count}].explanationReason" value="%{explanationReason}"></s:hidden>
										<s:hidden id="resultFlag%{#rowData.count}" name="technologyList[%{#rowData.count}].resultFlag" value="%{resultFlag}"></s:hidden>
										<s:hidden id="auditFlag%{#rowData.count}" name="technologyList[%{#rowData.count}].auditFlag" value="%{auditFlag}"></s:hidden>
										
										<s:hidden id="deleteFlag%{#rowData.count}" name="technologyList[%{#rowData.count}].deleteFlag" value="%{deleteFlag}"></s:hidden>
										<s:if test="%{scoreId!=null&&scoreId!=''}">
											<s:hidden id="createTime%{#rowData.count}" name="technologyList[%{#rowData.count}].createTime" value="%{createTime}"></s:hidden>
											<s:hidden id="scoreTime%{#rowData.count}" name="technologyList[%{#rowData.count}].scoreTime" value="%{scoreTime}"></s:hidden>
										</s:if>
										<s:hidden id="createUser%{#rowData.count}" name="technologyList[%{#rowData.count}].createUser" value="%{createUser}"></s:hidden>
										<s:hidden id="updateUser%{#rowData.count}" name="technologyList[%{#rowData.count}].updateUser" value="%{updateUser}"></s:hidden>
										<s:hidden id="remark%{#rowData.count}" name="technologyList[%{#rowData.count}].remark" value="%{remark}"></s:hidden>
									</s:iterator>
									<tr>
										<td><font size="2px"><strong>技术专家平均分</strong></font></td>
										<td colspan="7" align="left">
											<input id="projectTechnologyAverage" name="projectTechnologyAverage" class="inputA" style="width:10%;" value="<s:property value='%{tprojectApplication.projectTechnologyAverage}' escape='true'/>" disabled="disabled"/>
										</td>
									</tr>
								</s:if>
							</table>
							
							<div style="border-bottom: 1px dashed #C9DEEE;"></div>
							<div align="left">
								&nbsp;&nbsp;&nbsp;</br></br></br>
								<font size="2px"><strong>&nbsp;&nbsp;&nbsp;投资专家：</strong></font>
							</div>
							<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm" align="left">
								<s:if test="investmentReviewComments!=null">
									<tr align="center">
										<td width="10%">专家姓名</td>
										<td width="10%"><s:property value="%{investmentReviewComments.evaluationIndex1}" escape="true"/></td>
										<td width="10%"><s:property value="%{investmentReviewComments.evaluationIndex2}" escape="true"/></td>
										<td width="10%"><s:property value="%{investmentReviewComments.evaluationIndex3}" escape="true"/></td>
										<td width="10%"><s:property value="%{investmentReviewComments.evaluationIndex4}" escape="true"/></td>
										<td width="10%"><s:property value="%{investmentReviewComments.evaluationIndex5}" escape="true"/></td>
										<!-- <td width="10%">平均分</td>-->
										<td width="10%">总分</td>
										<td width="20%">推荐等级</td>
									</tr>
								</s:if>
								<s:if test="investmentList.size > 0">
									<input type="hidden" id="investmentListSize" name="investmentListSize" value="${fn:length(investmentList)}"/>
									<s:iterator value="investmentList" status="rowData">
										<tr align="center">
											<s:hidden id="scoreId%{#rowData.count+technologyList.size}" name="investmentList[%{#rowData.count}].scoreId" value="%{scoreId}"></s:hidden>
											<s:hidden id="texpert%{#rowData.count+technologyList.size}" name="investmentList[%{#rowData.count}].texpert.expertId" value="%{texpert.expertId}"></s:hidden>
											<td><s:property value="%{texpert.expertName}" escape="true"/></td>
											<td>
												<input type="text" id="companyStatusScore<s:property value='%{#rowData.count+technologyList.size}' escape='true'/>" name="investmentList[<s:property value='%{#rowData.count}' escape='true'/>].companyStatusScore" value="<s:property value='%{companyStatusScore}' escape='true'/>" class="inputA" style="width:5em;" 
													maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'',1,12);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this)" onchange="countComplexScore(<s:property value='%{#rowData.count+technologyList.size}' escape='true'/>,1);" moneyFlag="money"/>
												 <s:hidden id="hiddencompanyStatusScore%{#rowData.count+technologyList.size}" name="hidden" value=",1,12"></s:hidden>
											</td>
											<td>
												<input type="text" id="projectTechnologyScore<s:property value='%{#rowData.count+technologyList.size}' escape='true'/>" name="investmentList[<s:property value='%{#rowData.count}' escape='true'/>].projectTechnologyScore" value="<s:property value='%{projectTechnologyScore}' escape='true'/>" class="inputA" style="width:5em;"
													maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'',1,12);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this)" onchange="countComplexScore(<s:property value='%{#rowData.count+technologyList.size}' escape='true'/>,1);" moneyFlag="money"/>
												<s:hidden id="hiddenprojectTechnologyScore%{#rowData.count+technologyList.size}" name="hidden" value=",1,12"></s:hidden>
											</td>
											<td>
												<input type="text" id="projectBaseScore<s:property value='%{#rowData.count+technologyList.size}' escape='true'/>" name="investmentList[<s:property value='%{#rowData.count}' escape='true'/>].projectBaseScore" value="<s:property value='%{projectBaseScore}' escape='true'/>" class="inputA" style="width:5em;"
													maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'',1,12);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this)" onchange="countComplexScore(<s:property value='%{#rowData.count+technologyList.size}' escape='true'/>,1);" moneyFlag="money"/>
												<s:hidden id="hiddenprojectBaseScore%{#rowData.count+technologyList.size}" name="hidden" value=",1,12"></s:hidden>
											</td>
											<td>
												<input type="text" id="projectMarketScore<s:property value='%{#rowData.count+technologyList.size}' escape='true'/>" name="investmentList[<s:property value='%{#rowData.count}' escape='true'/>].projectMarketScore" value="<s:property value='%{projectMarketScore}' escape='true'/>" class="inputA" style="width:5em;"
													maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'',1,12);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this)" onchange="countComplexScore(<s:property value='%{#rowData.count+technologyList.size}' escape='true'/>,1);" moneyFlag="money"/>
												<s:hidden id="hiddenprojectMarketScore%{#rowData.count+technologyList.size}" name="hidden" value=",1,12"></s:hidden>
											</td>
											<td>
												<input type="text" id="projectBenefitScore<s:property value='%{#rowData.count+technologyList.size}' escape='true'/>" name="investmentList[<s:property value='%{#rowData.count}' escape='true'/>].projectBenefitScore" value="<s:property value='%{projectBenefitScore}' escape='true'/>" class="inputA" style="width:5em;"
													maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'',1,12);" onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isFloatNum(event,this)" onchange="countComplexScore(<s:property value='%{#rowData.count+technologyList.size}' escape='true'/>,1);" moneyFlag="money"/>
												<s:hidden id="hiddenprojectBenefitScore%{#rowData.count+technologyList.size}" name="hidden" value=",1,12"></s:hidden>
											</td>
											<!-- 
											<td>
												<input type="text" id="complexAverage<s:property value='%{#rowData.count+technologyList.size}' escape='true'/>" name="investmentList[<s:property value='%{#rowData.count}' escape='true'/>].complexAverage" value="<s:property value='%{complexAverage}' escape='true'/>" class="inputA" style="width:5em;" disabled="disabled"/>
											</td>
											-->
											<td>
												<input type="text" id="complexScore<s:property value='%{#rowData.count+technologyList.size}' escape='true'/>" name="investmentList[<s:property value='%{#rowData.count}' escape='true'/>].complexScore" value="<s:property value='%{complexScore}' escape='true'/>" class="inputA" style="width:5em;" disabled="disabled"/>
											</td>
											<td>
												<input type="radio" name="investmentList[<s:property value='%{#rowData.count}' escape='true'/>].finalResult" value="A" ${finalResult=='A'?'checked':''} onchange="upms.upmsUtils.radioChange(this,1);"/>重点推荐
												<input type="radio" name="investmentList[<s:property value='%{#rowData.count}' escape='true'/>].finalResult" value="B" ${finalResult=='B'?'checked':''} onchange="upms.upmsUtils.radioChange(this,1);"/>推荐
												<input type="radio" name="investmentList[<s:property value='%{#rowData.count}' escape='true'/>].finalResult" value="C" ${finalResult=='C'?'checked':''} onchange="upms.upmsUtils.radioChange(this,1);"/>备选
												<input type="radio" name="investmentList[<s:property value='%{#rowData.count}' escape='true'/>].finalResult" value="D" ${finalResult=='D'?'checked':''} onchange="upms.upmsUtils.radioChange(this,1);"/>落选
												<s:hidden id="hiddeninvestmentList%{#rowData.count}" name="hidden" value=""></s:hidden>
											 </td>
										</tr>
										<s:hidden id="companyStatusStandard%{#rowData.count+technologyList.size}" name="investmentList[%{#rowData.count}].companyStatusStandard" value="%{companyStatusStandard}"></s:hidden>
										<s:hidden id="projectTechnologyStandard%{#rowData.count+technologyList.size}" name="investmentList[%{#rowData.count}].projectTechnologyStandard" value="%{projectTechnologyStandard}"></s:hidden>
										<s:hidden id="projectBaseStandard%{#rowData.count+technologyList.size}" name="investmentList[%{#rowData.count}].projectBaseStandard" value="%{projectBaseStandard}"></s:hidden>
										<s:hidden id="projectMarketStandard%{#rowData.count+technologyList.size}" name="investmentList[%{#rowData.count}].projectMarketStandard" value="%{projectMarketStandard}"></s:hidden>
										<s:hidden id="projectBenefitType%{#rowData.count+technologyList.size}" name="investmentList[%{#rowData.count}].projectBenefitType" value="%{projectBenefitType}"></s:hidden>
										<s:hidden id="projectBenefitStandard%{#rowData.count+technologyList.size}" name="investmentList[%{#rowData.count}].projectBenefitStandard" value="%{projectBenefitStandard}"></s:hidden>
										<s:hidden id="complexOpinion%{#rowData.count+technologyList.size}" name="investmentList[%{#rowData.count}].complexOpinion" value="%{complexOpinion}"></s:hidden>
										<s:hidden id="explanationReason%{#rowData.count+technologyList.size}" name="investmentList[%{#rowData.count}].explanationReason" value="%{explanationReason}"></s:hidden>
										<s:hidden id="resultFlag%{#rowData.count+technologyList.size}" name="investmentList[%{#rowData.count}].resultFlag" value="%{resultFlag}"></s:hidden>
										<s:hidden id="auditFlag%{#rowData.count+technologyList.size}" name="investmentList[%{#rowData.count}].auditFlag" value="%{auditFlag}"></s:hidden>
									
										<s:hidden id="deleteFlag%{#rowData.count+technologyList.size}" name="investmentList[%{#rowData.count}].deleteFlag" value="%{deleteFlag}"></s:hidden>
										<s:if test="%{scoreId!=null&&scoreId!=''}">
											<s:hidden id="createTime%{#rowData.count+technologyList.size}" name="investmentList[%{#rowData.count}].createTime" value="%{createTime}"></s:hidden>
											<s:hidden id="scoreTime%{#rowData.count+technologyList.size}" name="investmentList[%{#rowData.count}].scoreTime" value="%{scoreTime}"></s:hidden>
										</s:if>
										<s:hidden id="createUser%{#rowData.count+technologyList.size}" name="investmentList[%{#rowData.count}].createUser" value="%{createUser}"></s:hidden>
										<s:hidden id="updateUser%{#rowData.count+technologyList.size}" name="investmentList[%{#rowData.count}].updateUser" value="%{updateUser}"></s:hidden>
										<s:hidden id="remark%{#rowData.count+technologyList.size}" name="investmentList[%{#rowData.count}].remark" value="%{remark}"></s:hidden>
									</s:iterator>
									<tr>
										<td><font size="2px"><strong>投资专家平均分</strong></font></td>
										<td colspan="7" align="left">
											<input id="projectInvestmentAverage" name="projectInvestmentAverage" class="inputA" style="width:10%;" value="<s:property value='%{tprojectApplication.projectInvestmentAverage}' escape='true'/>" disabled="disabled"/>
										</td>
									</tr>
								</s:if>
							</table>
							</br>
							</br>
							</br>
							</br>
							<div><font color="red">${retMsg}</font></div>
						    <div align="center">
								<input class="button save" id="saveBut" name="saveBut" type="button" href="javascript: void(0);" onclick="submitData('0');" value="保存"/>
								<s:if test="%{retMsg==null || retMsg==''}">
									<input class="button save" id="saveBut" name="saveBut" type="button" href="javascript: void(0);" onclick="submitData('1');" value="下一个"/>
								</s:if>
								<s:else>
									<input class="button save" id="saveBut" name="saveBut" type="button" href="javascript: void(0);" onclick="submitData('1');" value="下一个" disabled="disabled"/>
								</s:else>
								<input class="button save" id="backBut" name="backBut" type="button" href="javascript: void(0);" value="返回"/>
							</div>
						</div>
					</div>
					<!-- 查询结果列表E -->
			</div>
		</div>
	</div>
</div>

			
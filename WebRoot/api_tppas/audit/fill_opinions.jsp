<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/audit/js/fill_opinions.js"></script>
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<label id="comfirmSubmit" style="display: none"><s:text name="confirm_submit_info1"/></label>
<s:hidden id="projectId" name="tprojectApplication.projectId" value="%{tprojectApplication.projectId}"></s:hidden>
<s:hidden id="expertOpinionFlag" name="hidden" value="%{expertOpinionFlag}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">录入专家意见</div>
				<div class="abuot03">
					<s:if test="texpertScoreList.size > 0">
						<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list" id="expert">
							<tr align="left">
								<th width="10%">序号</th>
								<th width="10%">专家姓名</th>
								<th width="10%">信誉度</th>
								<th width="15%">专家类型</th>
								<th width="15%">项目合计得分</th>
								<th width="40%">评审意见</th>
							</tr>
							<s:iterator value="texpertScoreList" status="rowData">
								<tr>
									<td>
										${rowData.count}
										<s:hidden id="scoreId%{#rowData.count}" 
										name="texpertScoreList[%{#rowData.count}].scoreId" 
										value="%{scoreId}"></s:hidden>
										<s:hidden id="expertId%{#rowData.count}" 
										name="texpertScoreList[%{#rowData.count}].texpert.expertId" 
										value="%{texpert.expertId}"></s:hidden>
										<s:hidden id="projectId%{#rowData.count}" 
										name="texpertScoreList[%{#rowData.count}].tprojectApplication.projectId" 
										value="%{tprojectApplication.projectId}"></s:hidden>
										<s:hidden id="count%{#rowData.count}" name="hidden" value="%{index}"></s:hidden>
									</td>
									<td>
										<s:property value="%{texpert.expertName}" escape="true"/>
										<s:hidden id="expertName%{#rowData.count}" name="hidden" value="%{texpert.expertName}"></s:hidden>
									</td>
									<td align="center">
										<s:property value="%{texpert.expertPrestige}" escape="true"/>
									</td>
									<td align="center">
										<s:property value="%{texpert.expertType}" escape="true"/>
									</td>
									<%-- <s:if test="%{resultFlag == 1}"> --%>
										<td>
											<input type="text" class="inputA" 
												name="texpertScoreList[<s:property value='%{#rowData.count}' escape='true'/>].complexScore" 
												id="complexScore<s:property value='%{#rowData.count}' escape='true'/>" 
												value="<s:property value='%{complexScore}' escape='true'/>" 
												maxlength="5" style="width:5em;ime-mode: disabled;"
												disabled="disabled"
											/>
										</td>
										<td>
											<input type="text" class="inputA" 
												name="texpertScoreList[<s:property value='%{#rowData.count}' escape='true'/>].complexOpinion"
												id="complexOpinion<s:property value='%{#rowData.count}' escape='true'/>" 
												value="<s:property value='%{complexOpinion}' escape='true'/>" 
												style="width: 28em;" maxlength="200" 
												onblur="upms.upmsUtils.blurTextCheck(this,'评审意见',0,-1);" 
												onfocus="upms.upmsUtils.textFocus(this);"
												autoFlag="1" expertType="<s:property value='%{resultFlag}' escape='true'/>"
											/>
											<s:hidden id="hiddencomplexOpinion%{#rowData.count}" 
												name="hidden" value="评审意见,0,-1"></s:hidden>
										</td>
										<%--<td align="center">
											<a class="uline single" href="javascript: void(0);" onClick="showDetail4('<s:property value="%{scoreId}" escape="true"/>')">下载</a>
										</td>
									</s:if>
									 <s:else>
										<td>
											<!-- <input type="text" class="inputA" 
												style="width:5em;ime-mode: disabled;"
												disabled="disabled"
											/> -->
											&nbsp;
										</td>
										<td>
											<!-- <input type="text" class="inputA" 
												style="width: 28em;" maxlength="30" 
												disabled="disabled"
											/> -->
											&nbsp;
										</td>
										<td align="center">
											&nbsp;
										</td>
									</s:else> --%>
								</tr>
							</s:iterator>
						</table>
						<br>
						<br>
					</s:if>
					<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
					  <tr>
						<td width="19%">
							<div align="right">项目名称</div>
						</td>
						<td colspan="3">
							<div align="left">
								<s:property value="%{tprojectApplication.projectName}" escape="true"/>
							</div>
						</td>
					  </tr>
					  <tr>
						<td>
							<div align="right">所属计划类别</div>
						</td>
						<td width="33%">
							<div align="left">
								<s:property value='%{tprojectApplication.planFlagName}' escape='true'/><s:property value='@com.hopsun.tppas.common.Constants@STRING_LINK' escape='true'/><s:property value='%{tprojectApplication.typeName}' escape='true'/>
							</div>
						</td>
						<td width="19%">
							<div align="right">所属技术领域</div>
						</td>
						<td width="29%">
							<div align="left">
								<s:property value="%{tprojectApplication.deployOpinion}" escape="true"/>
							</div>
						</td>
					  </tr>
					  <tr>
						<td>
							<div align="right">申报单位</div>
						</td>
						<td>
							<div align="left">
								<s:property value="%{tprojectApplication.applicationUnit}" escape="true"/>
							</div>
						</td>
						<td>
							<div align="right">项目负责人（单位方）</div>
						</td>
						<td>
							<div align="left">
								<s:property value="%{tprojectApplication.initialAuditOpinion}" escape="true"/>
							</div>
						</td>
					  </tr>
					  <tr>
						<td>
							<div align="right">
								<font color="red">*</font>技术专家意见
							</div>
						</td>
						<td colspan="3">
							<div align="left">
								<textarea id="expertTecOpinion" 
								 name="tprojectApplication.expertTecOpinion" 
								 cols="100" rows="8"
								 onblur="upms.upmsUtils.blurTextCheck(this,'技术专家意见',0,8,1000);" 
								 onKeyUp="upms.upmsUtils.checkTextareaLength(this,1000)" 
								 onfocus="upms.upmsUtils.textFocus(this);"><s:property value="%{tprojectApplication.expertTecOpinion}" escape="true"/></textarea>
							</div>
							<s:hidden id="hiddenexpertTecOpinion" name="hidden" value="技术专家意见,0,8,1000"></s:hidden>
						</td>
					  </tr>
					 <%--  <tr>
						<td>
							<div align="right">
								<font color="red">*</font>技术专家推荐意见
							</div>
						</td>
						<td colspan="3">
							<div align="left">
								 <s:radio list="%{recommendList}" 
										listKey="itemId" 
										listValue="itemName" 
								 		id="expertTecRecommend" 
										name="tprojectApplication.expertTecRecommend"
										value="%{tprojectApplication.expertTecRecommend}" 
										disabled="false"
										onchange="upms.upmsUtils.radioChange(this);">
								 </s:radio>
								 <s:hidden id="hiddenexpertTecRecommend" name="hidden" value="技术专家推荐意见"></s:hidden>
							</div>
						</td> --%>
					  </tr>
					  <tr>
						<td>
							<div align="right">
								<font color="red">*</font>投资专家意见
							</div>
						</td>
						<td colspan="3">
							<div align="left">
								<textarea id="expertInvOpinion" 
								 name="tprojectApplication.expertInvOpinion" 
								 cols="100" rows="8"
								 onblur="upms.upmsUtils.blurTextCheck(this,'投资专家意见',0,8,1000);" 
								 onKeyUp="upms.upmsUtils.checkTextareaLength(this,1000)" 
								 onfocus="upms.upmsUtils.textFocus(this);"><s:property value="%{tprojectApplication.expertInvOpinion}" escape="true"/></textarea>
							</div>
							<s:hidden id="hiddenexpertInvOpinion" name="hidden" value="投资专家意见,0,8,1000"></s:hidden>
						</td>
					  </tr>
					  <%-- <tr>
						<td>
							<div align="right">
								<font color="red">*</font>投资专家推荐意见
							</div>
						</td>
						<td colspan="3">
							<div align="left">
								 <s:radio list="%{recommendList}" 
										listKey="itemId" 
										listValue="itemName" 
								 		id="expertInvRecommend" 
										name="tprojectApplication.expertInvRecommend"
										value="%{tprojectApplication.expertInvRecommend}" 
										disabled="false"
										onchange="upms.upmsUtils.radioChange(this);">
								 </s:radio>
								 <s:hidden id="hiddenexpertInvRecommend" name="hidden" value="投资专家推荐意见"></s:hidden>
							</div>
						</td>
					  </tr>
					  <tr>
						<td>
							<div align="right">
								<font color="red">*</font>业务处室综合意见
							</div>
						</td>
						<td colspan="3">
							<div align="left">
								<textarea id="expertAuditComposite" 
									name="tprojectApplication.expertAuditComposite" 
									cols="100" rows="8"
									onblur="upms.upmsUtils.blurTextCheck(this,'业务处室综合意见',1,8,1000);" 
								 	onKeyUp="upms.upmsUtils.checkTextareaLength(this,1000)" 
								 	onfocus="upms.upmsUtils.textFocus(this);"><s:property value="%{tprojectApplication.expertAuditComposite}" escape="true"/></textarea>
							</div>
							<s:hidden id="hiddenexpertAuditComposite" name="hidden" value="业务处室综合意见,1,8,1000"></s:hidden>
						</td>
					  </tr>
					   <tr>
						<td>
							<div align="right">
								<font color="red">*</font>业务处室推荐意见
							</div>
						</td>
						<td colspan="3">
							<div align="left">
								 <s:radio list="%{recommendList}" 
										listKey="itemId" 
										listValue="itemName" 
								 		id="expertAuditRecommend" 
										name="tprojectApplication.expertAuditRecommend"
										value="%{tprojectApplication.expertAuditRecommend}" 
										disabled="false"
										onchange="upms.upmsUtils.radioChange(this);">
								 </s:radio>
								 <s:hidden id="hiddenexpertAuditRecommend" name="hidden" value="业务处室推荐意见"></s:hidden>
							</div>
						</td>
					  </tr> --%>
					</table>
					</br>
	                </br>
	                <div align="center">
						<input class="button save" id="saveBtn" name="button" type="button" 
						href="javascript: void(0);" value="保存" onclick="saveBtn();"/>
						<input class="button save" id="submitBtn" name="button" type="button" 
						href="javascript: void(0);" value="提交" onclick="submitBtn();"/>
						<input class="button save" id="backBtn" name="button" type="button" 
						href="javascript: void(0);" value="返回" onclick="backBtn();"/>
					</div>
	 			</div>
 	 		   </div>
		</div>
	</div>
</div>
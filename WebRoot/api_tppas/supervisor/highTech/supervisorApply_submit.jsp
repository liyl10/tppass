<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/highTech/js/supervisorApply_submit.js"></script>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">监理审核</div>
				<div class=requirecolor id="errInfo"></div>
				<s:hidden id="fundExistFlag" value="%{fundExistFlag}"></s:hidden>
				<s:hidden id="infoExistFlag" value="%{infoExistFlag}"></s:hidden>
				<table style="width:100%;cellspacing:0;cellpadding:0" class="t-list">
					<tr>
						<th align="center" width="10%">序号</th>
						<th align="center">材料类型</th>
						<th align="center">数据是否存在</th>
					</tr>
					<tr>
						<td align="left">1</td>
						<td align="left">监理封面</td>
						<td align="left">是</td>
					</tr>
					<tr>
						<td align="left">2</td>
						<td align="left">填表说明</td>
						<td align="left">是</td>
					</tr>
					<tr>
						<td align="left">3</td>
						<td align="left">基本信息</td>
						<td align="left">
						<s:if test="%{infoExistFlag==1}">是</s:if>
						<s:else>否</s:else></td>
					</tr>
					<tr>
						<td align="left">4</td>
						<td align="left">项目资金情况</td>
						<td align="left"><s:if test="%{fundExistFlag==1}">是</s:if>
						<s:else>否</s:else></td>
					</tr>
					<%-- <tr>
						<td align="left">5</td>
						<td align="left">附件清单</td>
						<td align="left"><s:if test="%{attachExistFlag==1}">是</s:if>
						<s:else>否</s:else></td>
					</tr> --%>
				</table>
				<div>&nbsp;</div>
				<s:if test="%{tsupervisor.supervisorState==@com.hopsun.tppas.common.Constants@SUPERVISOR_STATE_APPLY}">
					<table style="width:100%;cellspacing:0;cellpadding:0" class="t-list">
							<tr>
								<td  align="right" width="10%">
									<FONT color=red>*</FONT>监理机构意见（1000字以内）
								</td>
								<td>
									<textarea id="checkInfo"  name="checkInfo" Class="inputA" style="width:95%; height:180px;resize:none;" onblur="upms.upmsUtils.blurTextCheck(this,'监理机构意见',1,8,1000)" onfocus="upms.upmsUtils.textFocus(this)" onkeyup="upms.upmsUtils.checkTextareaLength(this, 1000);"><s:property value="%{tsupervisor.checkInfo}" escape="true"/></textarea>
								</td>
								<s:hidden id="hiddencheckInfo" name="hidden" value="监理机构意见,1,8,1000"></s:hidden>
							</tr>
					</table>
				</s:if>
				<div align="center">
					<input type="hidden" id="supervisorId" name="supervisorId" value="<s:property value='%{supervisorId}' escape='true'/>"/>
					<!-- 提交状态 -->
					<s:if test="%{tsupervisor.supervisorState==@com.hopsun.tppas.common.Constants@SUPERVISOR_STATE_APPLY}">
						<input type="button" class="button" value="保存"  id="saveBut"  onclick="supervisorAudit('','<s:text name='confirm_save_info'/>');"/>
						<input type="button" class="button" value="监理不通过可修改"  id="updateBut"  onclick="supervisorAudit('<s:property value='@com.hopsun.tppas.common.Constants@SUPERVISOR_STATE_NOTPASS_EDIT' />','<s:text name='comfirm_supervisor_update'/>');"/>
						<input type="button" class="button" value="监理不通过不可修改"  id="noUpdateBut"  onclick="supervisorAudit('<s:property value='@com.hopsun.tppas.common.Constants@SUPERVISOR_STATE_NOTPASS_NOEDIT' />','<s:text name='comfirm_supervisor_noupdate'/>');"/>
						<input type="button" class="button" value="监理通过"  id="passBut"  onclick="supervisorAudit('<s:property value='@com.hopsun.tppas.common.Constants@SUPERVISOR_STATE_PASS' />','<s:text name='comfirm_supervisor_pass'/>');"/>	
					</s:if>
				</div>
			</div>
		</div>
	</div>
</div>

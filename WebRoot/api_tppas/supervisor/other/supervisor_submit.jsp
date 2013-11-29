<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/other/js/supervisor_submit.js"></script>
<!-- 提交前错误提示信息 -->
<label id="projectErr" style="display: none"><s:text name="project_err"/></label>
<!-- 提交时确认信息 -->
<label id="comfirmSubmit" style="display: none"><s:text name="confirm_submit_info"/></label>
<div align="center" style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">监理评审</div>
				<table width="100%" border="1" cellspacing="0" cellpadding="0" class="t-list">
					<tr>
						<th align="center" width="10%">序号</th>
						<th align="center">材料类型</th>
						<th align="center">数据是否存在</th>
					</tr>
					<s:iterator value="submitList" status="rowData">
						<tr>
							<td align="left">${rowData.index+1}</td>
							<td align="left"><s:property value='%{name}' escape='true'/></td>
							<td align="left"><s:property value='%{isExist}' escape='true'/></td>
						</tr>
					</s:iterator>
				</table>
				<div>&nbsp;</div>
				<s:if test="%{tsupervisor.supervisorState==@com.hopsun.tppas.common.Constants@SUPERVISOR_STATE_APPLY}">
					<table style="width:100%;cellspacing:0;cellpadding:0" class="t-list">
							<tr>
								<td  align="right" width="10%">
									<FONT color=red>*</FONT>监理机构意见（1000字以内）
								</td>
								<td>
									<textarea id="tsupervisorInfo"  name="tsupervisorInfo" Class="inputA" style="width:95%; height:180px;resize:none;" onblur="upms.upmsUtils.blurTextCheck(this,'监理机构意见',1,8,1000)" onfocus="upms.upmsUtils.textFocus(this)" onkeyup="upms.upmsUtils.checkTextareaLength(this, 1000);"><s:property value="%{tsupervisor.checkInfo}" escape="true"/></textarea>
								</td>
								<s:hidden id="hiddentsupervisorInfo" name="hidden" value="监理机构意见,1,8,1000"></s:hidden>
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
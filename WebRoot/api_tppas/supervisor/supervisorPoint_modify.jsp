<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/js/supervisorPoint_modify.js"></script>
<!-- 保存按钮提示信息 -->
<label id="comfirmUpdate" style="display: none"><s:text name="confirm_update_info"/></label>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">修改监理点</div>
				<s:hidden id="supervisorId" name="supervisorId" value="%{supervisorId}"></s:hidden>
				<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
				<table style="width:100%;" cellspacing="0" cellpadding="0" class="t-entRegFrm">
					<tr>
						<td style="width: 20%; text-align: right;">计划监理内容</td>
						<td><textarea class="inputA" id="pointContent"  name="supervisorPoint.pointContent" style="width:90%; height:150px;resize:none;" onblur="upms.upmsUtils.blurTextCheck(this,'计划监理内容', 1, 8, 1000);" onfocus="upms.upmsUtils.textFocus(this);" onkeyup="upms.upmsUtils.checkTextareaLength(this, 1000);"><s:property value="%{supervisorPoint.pointContent}" escape="true"/></textarea></td>
						<s:hidden id="hiddenpointContent" name="hidden" value="计划监理内容,1,8,1000"></s:hidden>
					</tr>
					<tr>
						<td style="width: 20%; text-align: right;">计划监理日期</td>
						<td>
							<input type="text" id="pointTime"  name="supervisorPoint.pointTime" value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{supervisorPoint.pointTime})}' escape='true'/>" class="txt w184p Wdate" readonly="readonly" onClick="WdatePicker()"onblur="upms.upmsUtils.blurTextCheck(this,'计划监理日期',1,-1)" onfocus="upms.upmsUtils.textFocus(this);"/>
							<s:hidden id="hiddenpointTime" name="hidden" value="计划监理日期"></s:hidden>
						</td>
					</tr>
				</table>
			</div>
			<s:hidden id="pointId" name="supervisorPoint.pointId" value="%{supervisorPoint.pointId}"></s:hidden>
			<s:hidden id="writeTime" name="supervisorPoint.writeTime" value="%{supervisorPoint.writeTime}"></s:hidden>
			<s:hidden id="deleteFlag" name="supervisorPoint.deleteFlag" value="%{supervisorPoint.deleteFlag}"></s:hidden>
			<s:hidden id="createTime" name="supervisorPoint.createTime" value="%{supervisorPoint.createTime}"></s:hidden>
			<s:hidden id="createUser" name="supervisorPoint.createUser" value="%{supervisorPoint.createUser}"></s:hidden>
			<div align="center" style="width: 95%">
				<input class="button save" id="saveBtn" type="button" value="保存"/>
				<input class="button save" id="backBtn" type="button" value="返回"/>
			</div>
		</div>
	</div>
</div>
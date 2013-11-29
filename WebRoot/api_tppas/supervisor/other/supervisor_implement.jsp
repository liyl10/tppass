<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/other/js/supervisor_implement.js"></script>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<!-- 修改按钮提示信息 -->
<label id="comfirmUpdate" style="display: none"><s:text name="confirm_update_info"/></label>
<!-- 下一步按钮提示信息 -->
<label id="comfirmNext" style="display: none"><s:text name="confirm_save_and_next_info"/></label>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目实施管理情况</div>
				<div class="abuot03">
					<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
					    <tr>
						    <td align="right">说  明</td>
						    <td>
						    	<p>（包括项目管理机构、管理工作机制建立、检查督促等情况）</p>
						        <textarea class="inputA" id="projectManagementComment" name="tprojectManagementInfo.projectManagementComment" style="width:700px;height:150px" onblur="upms.upmsUtils.blurTextCheck(this,'说明',1,8,1000)" onfocus="upms.upmsUtils.textFocus(this)" onkeyup="upms.upmsUtils.checkTextareaLength(this, 1000);"><s:property value="%{tprojectManagementInfo.projectManagementComment}" escape="true"/></textarea>
						     	<s:hidden id="hiddenprojectManagementComment" name="hidden" value="说明,1,8,1000"></s:hidden>
						     </td>
					    </tr>
					</table>
					<br/>
					<s:hidden id="isEdit" name="isEdit" value="%{isEdit}"></s:hidden>
					<s:hidden id="supervisorId" name="supervisorId" value="%{supervisorId}"></s:hidden>
					<s:hidden id="projectManagementInfoId" name="tprojectManagementInfo.projectManagementInfoId" value="%{tprojectManagementInfo.projectManagementInfoId}"></s:hidden>
					<s:hidden id="deleteFlag" name="tprojectManagementInfo.deleteFlag" value="%{tprojectManagementInfo.deleteFlag}"></s:hidden>
					<s:hidden id="remark" name="tprojectManagementInfo.remark" value="%{tprojectManagementInfo.remark}"></s:hidden>
					<s:if test="%{tprojectManagementInfo.projectManagementInfoId!=null&&tprojectManagementInfo.projectManagementInfoId!=''}">
						<s:hidden id="createTime" name="tprojectManagementInfo.createTime" value="%{tprojectManagementInfo.createTime}"></s:hidden>
					</s:if>
					<s:hidden id="createUser" name="tprojectManagementInfo.createUser" value="%{tprojectManagementInfo.createUser}"></s:hidden>
					<s:hidden id="updateUser" name="tprojectManagementInfo.updateUser" value="%{tprojectManagementInfo.updateUser}"></s:hidden>
					<div align="center">
						<s:if test="%{isEdit==1}">
							<input type="button" class="button add" id="saveBut" name="saveBtu" value="保存">
							&nbsp;
						<input type="button" class="button save" id="nextBut" name="nextBtu" value="下一步"/>
						</s:if>
						<s:else>
							<input type="button" class="button save" id="nextStep" name="nextStep" href="javascript: void(0);" value="下一步"/>
						</s:else>
					</div>
	 			</div>
 	 		</div>
   		</div>
  	</div>
</div>

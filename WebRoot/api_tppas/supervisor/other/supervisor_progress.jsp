<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/other/js/supervisor_progress.js"></script>
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
				<div class="abuot07">项目产业化进展情况</div>
				<div class="abuot03">
					<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
						<tr>
					    	<td align="right">说  明</td>
					    	<td>
					    		<p>（包括新建厂房，新建生产线、新增研发设备、示范推广等情况）</p>
					        	<textarea id="industrializationComment" name="tprojectIndustrialization.industrializationComment" class="inputA" style="width:700px;height:150px" onblur="upms.upmsUtils.blurTextCheck(this,'说明',1,8,1000)" onfocus="upms.upmsUtils.textFocus(this)" onkeyup="upms.upmsUtils.checkTextareaLength(this, 1000);"><s:property value="%{tprojectIndustrialization.industrializationComment}" escape="true"/></textarea>
					    		<s:hidden id="hiddenindustrializationComment" name="hidden" value="说明,1,8,1000"></s:hidden>
					    	</td>
					    </tr>
					</table>
					<br/>
					<s:hidden id="isEdit" name="isEdit" value="%{isEdit}"></s:hidden>
					<s:hidden id="supervisorId" name="supervisorId" value="%{supervisorId}"></s:hidden>
					<s:hidden id="projectIndustrializationId" name="tprojectIndustrialization.projectIndustrializationId" value="%{tprojectIndustrialization.projectIndustrializationId}"></s:hidden>
					<s:hidden id="deleteFlag" name="tprojectIndustrialization.deleteFlag" value="%{tprojectIndustrialization.deleteFlag}"></s:hidden>
					<s:hidden id="remark" name="tprojectIndustrialization.remark" value="%{tprojectIndustrialization.remark}"></s:hidden>
					<s:if test="%{tprojectIndustrialization.projectIndustrializationId!=null&&tprojectIndustrialization.projectIndustrializationId!=''}">
						<s:hidden id="createTime" name="tprojectIndustrialization.createTime" value="%{tprojectIndustrialization.createTime}"></s:hidden>
					</s:if>
					<s:hidden id="createUser" name="tprojectIndustrialization.createUser" value="%{tprojectIndustrialization.createUser}"></s:hidden>
					<s:hidden id="updateUser" name="tprojectIndustrialization.updateUser" value="%{tprojectIndustrialization.updateUser}"></s:hidden>
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

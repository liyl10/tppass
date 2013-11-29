<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/other/js/supervisor_achievement.js"></script>
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
				<div class="abuot07">项目取得成果情况</div>
				<div class="abuot03">
					<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
						<tr>
							<td align="right" style="20%">已获得知识产权数量</td>
							<td>
								<input type="text" class="inputA" id="awardedIntellectualCount" name="tprojectAchievementInfo.awardedIntellectualCount" value="<s:property value='%{tprojectAchievementInfo.awardedIntellectualCount}' escape='true'/>" style="ime-mode:disabled;" maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'已获得知识产权数量',1,4);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isNum(event,this);"/>
								<s:hidden id="hiddenawardedIntellectualCount" name="hidden" value="已获得知识产权数量,1,4"></s:hidden>
							</td>
							<td style="20%">已申请知识产权数量</td>
							<td>
								<input type="text" class="inputA" id="appliedIntellectualCount" name="tprojectAchievementInfo.appliedIntellectualCount" value="<s:property value='%{tprojectAchievementInfo.appliedIntellectualCount}' escape='true'/>" style="ime-mode:disabled;" maxlength="7" onblur="upms.upmsUtils.blurTextCheck(this,'已申请知识产权数量',1,4);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isNum(event,this);"/>
								<s:hidden id="hiddenappliedIntellectualCount" name="hidden" value="已申请知识产权数量,1,4"></s:hidden>
							</td>
						</tr>
						<tr>
							<td align="right" style="20%">其他成果类别</td>
							<td colspan="4">
								<textarea class="inputA" id="companyDevelopComment" name="tprojectAchievementInfo.companyDevelopComment" style="width:98%;height:150px" onblur="upms.upmsUtils.blurTextCheck(this,'其他成果类别',1,8,1000)" onfocus="upms.upmsUtils.textFocus(this)" onkeyup="upms.upmsUtils.checkTextareaLength(this, 1000);"><s:property value="%{tprojectAchievementInfo.companyDevelopComment}" escape="true"/></textarea>
								<s:hidden id="hiddencompanyDevelopComment" name="hidden" value="其他成果类别,1,8,1000"></s:hidden>
							</td>
						</tr>
					</table>
					<br/>
					<s:hidden id="isEdit" name="isEdit" value="%{isEdit}"></s:hidden>
					<s:hidden id="supervisorId" name="supervisorId" value="%{supervisorId}"></s:hidden>
					<s:hidden id="projectAchievementInfoId" name="tprojectAchievementInfo.projectAchievementInfoId" value="%{tprojectAchievementInfo.projectAchievementInfoId}"></s:hidden>
					<s:hidden id="deleteFlag" name="tprojectAchievementInfo.deleteFlag" value="%{tprojectAchievementInfo.deleteFlag}"></s:hidden>
					<s:hidden id="remark" name="tprojectAchievementInfo.remark" value="%{tprojectAchievementInfo.remark}"></s:hidden>
					<s:if test="%{tprojectAchievementInfo.projectAchievementInfoId!=null&&tprojectAchievementInfo.projectAchievementInfoId!=''}">
						<s:hidden id="createTime" name="tprojectAchievementInfo.createTime" value="%{tprojectAchievementInfo.createTime}"></s:hidden>
					</s:if>
					<s:hidden id="createUser" name="tprojectAchievementInfo.createUser" value="%{tprojectAchievementInfo.createUser}"></s:hidden>
					<s:hidden id="updateUser" name="tprojectAchievementInfo.updateUser" value="%{tprojectAchievementInfo.updateUser}"></s:hidden>
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

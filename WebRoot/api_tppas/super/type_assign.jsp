<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/super/js/type_assign.js"></script>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<!-- 修改按钮提示信息 -->
<label id="comfirmUpdate" style="display: none"><s:text name="confirm_update_info"/></label>
<div align="center" style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">分配管理专员</div>
				<div class="abuot03">
					<table width="100%" border=0 cellSpacing=0 cellPadding=0 align=center class="t-entRegFrm">
					<tr height="35px">
						<td width="40%" align="right">计划类别</td>
						<td width="60%" >
							<s:property value='%{tprojectType.typeShowName}' escape='true'/>
						</td>
					</tr>
					<tr height="35px">
						<td width="40%" align="right">管理专员</td>
						<td width="60%" style="padding: 4px 8px; text-align: left">
							<s:select list="userList" listKey="userId" listValue="userRealname" label="abc" id="userId" name="tprojectTypeManager.userId" style="width:45%;"></s:select>
						</td>
					</tr>
					</table>
					<s:hidden id="typeManagerId" name="tprojectTypeManager.typeManagerId" value="%{tprojectTypeManager.typeManagerId}"/>
					<s:hidden id="typeId" name="tprojectTypeManager.typeId" value="%{typeId}"/>
					<s:hidden id="userValue" name="userValue" value="%{tprojectTypeManager.userId}"/>
					<s:if test="%{tprojectTypeManager.typeManagerId!=null&&tprojectTypeManager.typeManagerId!=''}">
						<s:hidden id="createTime" name="tprojectTypeManager.createTime" value="%{tprojectTypeManager.createTime}"></s:hidden>
					</s:if>
					<s:hidden id="createUser" name="tprojectTypeManager.createUser" value="%{tprojectTypeManager.createUser}"></s:hidden>
					<s:hidden id="updateUser" name="tprojectTypeManager.updateUser" value="%{tprojectTypeManager.updateUser}"></s:hidden>
					<s:hidden id="deleteFlag" name="tprojectTypeManager.deleteFlag" value="%{tprojectTypeManager.deleteFlag}"></s:hidden>
					<div style="display: block; text-align: center; margin-top: 12px">
						<input type="button" class="button add" id="saveBut" name="saveBut" value="保存"/>
						<input type="button" class="button add" id="reBtn" name="reBtn" value="返回"/>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
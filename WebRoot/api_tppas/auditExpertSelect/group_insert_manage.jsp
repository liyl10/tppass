<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/auditExpertSelect/js/group_insert_manage.js"></script>
<s:hidden id="groupDateFlag" name="groupDateFlag" value="%{groupDateFlag}"></s:hidden>
<s:hidden id="groupId" name="groupId" value="%{groupId}"></s:hidden>
<s:hidden id="projecTypeManager" name="projecTypeManager" value="%{#session.projecTypeManager}"></s:hidden>
<c:if test="${projecTypeManager==false}">
<s:hidden id="projectType1" name="projectType1" value="%{projectType1}"></s:hidden>
<s:hidden id="projectType2" name="projectType2" value="%{projectType2}"></s:hidden>
</c:if>

<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">创建新分组</div>
					<div>
						<form id="searchForm"></form>
						<table width="100%">
							<tr>
								<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
						  			<FONT color=red>*</FONT>分组名称&nbsp;
						  		</td>
								<td style="white-space:nowrap;width:25%;padding:2px">	
						  	 		<input type="text" id="groupName" name="groupName" class="inputA" 
						  	 		autocomplete="off" maxlength="20" style="width:15em;"
						  	 		onblur="upms.upmsUtils.blurTextCheck(this,'分组名称',1,-1)"
									onfocus="upms.upmsUtils.textFocus(this);"/>
						 		 &nbsp;
						 		</td>
						 		<s:hidden id="hiddengroupName" name="hidden" value="分组名称,1,-1"></s:hidden>
							</tr>
							<tr>
							<td style="white-space: nowrap; width: 8%; text-align: right; padding: 2 2 10 10; font-size: 105%">
								<FONT color=red>*</FONT>项目分类&nbsp;</td>
								<c:if test="${projecTypeManager==true}">
								<td style="white-space: nowrap; width: 26%; padding: 2px"><s:select
										list="projectTypeList1" listKey="typeId" label="abc"
										listValue="typeShowName" id="projectType1" name="projectType1"
										style="width:15.5em;"></s:select> <s:select
										list="projectTypeList2" listKey="typeId" label="abc"
										listValue="typeShowName" id="projectType2" name="projectType2"
										style="width:15.5em;"></s:select>
										<s:hidden id="hiddenprojectType2" name="hidden" value="项目分类"></s:hidden>
								</td>
								</c:if>
								<c:if test="${projecTypeManager==false}">
									<td style="white-space: nowrap; width: 26%; padding: 2px">
										<s:label class="inputA"><s:property value="%{projectType}"/></s:label>
									</td>
								</c:if>
						</tr>
						</table>
					</div>
				<!-- <div style=" margin-bottom: 22px;">
						<div id="cancelDiv" style="float: left; display: none;">
							<input class="button" type="button" id="canelBtn" value="取消" onclick="cancelBatchGroupSelect();"/>&nbsp;
						</div>
						<div style="float: right;">
							<input class="button" type="button" id="createGroupBtn" value="选择项目" onclick="selectProject();"/>&nbsp;
						</div>
					</div> -->
				<div>&nbsp;</div>
					<!-- 查询结果列表S -->
					<div id="resultDiv"></div>
					<!-- 查询结果列表E -->
					<br/>
					<br/>
					<div align="center">
						<input class="button" type="button" id="saveGroupBtn" value="提交" onclick="saveGroup();"/>&nbsp;
						<input class="button" type="button" id="backBtn" value="返回"/>&nbsp;
					</div>
			</div>
		</div>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/api_tppas/audit/js/select_expert_manage.js"></script>
<s:hidden id="groupId" name="groupId" value="%{groupId}"></s:hidden>
<s:hidden id="selectedId" name="selectedId"></s:hidden>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">选择专家</div>
				<div>&nbsp;</div>
				<div style="margin-bottom: 0px;">
					<div align="left">
						<s:if test="%{clockFlag == 0}">
							<input class="button" type="button" id="insertBtn" value="继续添加"
								onclick="addExpert('${groupId}');" /> &nbsp; <input
								class="button" type="button" id="delsExpertBtn" value="删除专家"
								onclick="deleteBatchExpert();" /> &nbsp;
						</s:if>
						<s:else>
							<s:label>该分组的专家已经被锁定，不能修改！</s:label>	
						</s:else>
					</div>
					<!-- <div style="float: right;">
		<input class="button" type="button" id="signInBtn" value="专家签到表"/>
		&nbsp;
		<input class="button" type="button" id="costBtn" value="费用领取表"/>
		&nbsp;
		<input class="button" type="button" id="reviewBtn" value="评审意见表" onclick="downLoadExpertScore();"/>
		&nbsp;
	</div> -->
				</div>
				<div style="border-bottom: 1px dashed #C9DEEE;"></div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="t-list">
					<tr align="center">
						<s:if test="%{clockFlag == 0}">
							<th width="5%"><s:checkbox name="" id="selectAll"
									onclick="selectAll();"></s:checkbox></th>
						</s:if>
						<th width="5%">序号</th>
						<th width="8%">专家姓名</th>
						<th width="13%">擅长专业1</th>
						<th width="13%">擅长专业2</th>
						<th width="13%">擅长专业3</th>
						<th width="12%">工作单位</th>
						<th width="8%">专家类型</th>
						<th width="10%">联系电话</th>
						<th width="5%">信誉度</th>
						<s:if test="%{clockFlag == 0}">
						<th width="12%">操作</th>
						</s:if>
					</tr>
					<s:if test="selectedExpertList.size > 0">
						<s:iterator value="selectedExpertList" status="rowData">
							<tr>
								<s:if test="%{clockFlag == 0}">
								<td align="center"><input type="checkbox"
									value="${relationId}" onclick="saveOrDelSelect(this);" />
								</td>
								</s:if>
								<td align="center"><s:property value="#rowData.count" escape="true" />
								<td><s:property value="%{expertName}" escape="true" />
								</td>
								<td><s:property value="%{expertMajor1}"
										escape="true" /></td>
								<td><s:property value="%{expertMajor2}"
										escape="true" />&nbsp;</td>
								<td><s:property value="%{expertMajor3}"
										escape="true" />&nbsp;</td>
								<td><s:property value="%{expertWork}" escape="true" />&nbsp;
								</td>
								<td><s:property
										value="%{expertType}" escape="true" />&nbsp;</td>
								<td><s:property
										value="%{phone}" escape="true" />&nbsp;</td>
								<td align="center"><s:property
										value="%{expertPrestige}" escape="true" /></td>
								<s:if test="%{clockFlag == 0}">
								<td align="center"><a href="javascript: void(0);"
									class="uline single"
									onclick="deleteExpert('<s:property value='%{relationId}' escape='true'/>');">删除</a>
								</td>
								</s:if>
							</tr>
						</s:iterator>
					</s:if>
					<s:else>
						<tr>
							<td colspan="11">没有查到任何记录!&nbsp;</td>
						</tr>
					</s:else>
				</table>
				<div align="center">
					<s:if test="%{clockFlag == 0}">
					<input class="button" type="button" id="saveGroupBtn" value="锁定分组"
						onclick="clockExpert();" />&nbsp;
					</s:if>
					<input class="button" type="button" id="sendMessage" value="发送通知"
						onclick="showSendMessage('${groupId}');"/>
					<input class="button" type="button" id="saveGroupBtn" value="返回"
						onclick="back();" />
				</div>
			</div>
		</div>
	</div>
</div>
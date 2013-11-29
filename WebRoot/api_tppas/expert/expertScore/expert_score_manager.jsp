<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/expert/expertScore/js/expert_score_manager.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">专家意见填写</div>
					<div>
						<form id="searchForm">
							<s:hidden id="groupId" name="groupId" value="%{groupId}"/>
							<s:hidden id="projectIdValue" name="projectIdValue" value="%{projectId}"/>
							<table width="100%">
								 <tr>
				                 	<td align="right" width="8%">填写状态&nbsp;</td>
				                 	<td  width="20%">
								 		<select id="isWrite" name="isWrite" style="width:90%;" onchange="isWriteOnchange('isWrite');">
											<option value="0" ${isWrite==0?'selected':''}>未填写</option>
											<option value="1" ${isWrite==1?'selected':''}>已填写</option>
										</select>
				                  	</td>
									<td align="right"  width="8%">项目名称</td>
									<td  width="25%">		
										<s:select list="projectList" listKey="projectId" listValue="projectName" id="projectId" name="projectId" style="width:98%;" onchange="projectOnchange();" value="%{projectId}"></s:select>
									</td>
				                 	<td><font color="red">*选择项目时，请先保存已填写的数据，以免数据丢失。</fonr></td>
				                </tr>
							</table>
						</form>
					</div>
					<div>&nbsp;</div>
					<!-- 查询结果列表S -->
					<div id="resultDiv"></div>
					<!-- 查询结果列表E -->
			</div>
		</div>
	</div>
</div>
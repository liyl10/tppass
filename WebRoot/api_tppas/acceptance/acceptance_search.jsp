<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/js/acceptance_search.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目验收</div>
					<label id="path" style="display: none;">${pageContext.request.contextPath}</label>
					<div>
						<form id="searchForm">
								<table  style="width:100%;padding-top:5px">
									<tr>
										<td align="right">项目名称&nbsp;</td>
										<td>
								  	 		<input class="inputA" type="text" style="width: 14.5em;" id="projectName" name="tprojectApplication.projectName" value="<s:property value='%{tprojectApplication.projectName}' escape='true'/>"
	              								maxlength="20" onfocus="upms.upmsUtils.textFocus(this);" />
										</td>
										<td align="right">申报单位&nbsp;</td>
										<td>
											<input class="inputA" type="text" style="width: 14.5em;" id="applicationUnit" name="tprojectApplication.applicationUnit" value="<s:property value='%{tprojectApplication.applicationUnit}' escape='true'/>"
	              								maxlength="20" onfocus="upms.upmsUtils.textFocus(this);" />
	              						</td>
										<td></td>
									</tr>
									<tr>
										<td align="right">项目分类&nbsp;</td>
										<td>
											<s:select style="width:12em;" list="typeId2List" label="abc" listKey="typeId"
											listValue="typeShowName" id="typeId2" name="typeId2" value="%{typeId2}"></s:select>
											<s:select style="width:12em;" list="typeId3List" label="abc" listKey="typeId"
											listValue="typeShowName" id="typeId3" name="typeId3" value="%{typeId3}"></s:select>
											<s:hidden id="hiddentypeId3" name="hidden" value="项目分类级联"></s:hidden>
											<s:hidden id="typeId2Value" name="typeId2Value" value="%{typeId2}"></s:hidden>
											<s:hidden id="typeId3Value" name="typeId3Value" value="%{typeId3}"></s:hidden>
										</td>
										<td align="right">验收状态&nbsp;</td>
										<td>		
											<s:select list="acceptanceStatusList" listKey="itemId" label="abc" listValue="itemName"
											id="acceptanceStatus" name="acceptanceStatus" style="width:15.5em;"></s:select>
										</td>
										<td align="right">
											<%-- <tag:auth code="ss.acceptanceManage.okBtn"> --%>
											<input class="button" type="button" id="queryBtn" value="查询"/>
											<%-- </tag:auth> --%>
										&nbsp;</td>
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
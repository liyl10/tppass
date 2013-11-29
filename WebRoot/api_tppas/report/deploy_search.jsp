<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/js/deploy_search.js"></script>
<div align="center" style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目调配</div>
				<div>
					<form id="searchForm">
						<table style="width: 100%; padding-top: 5px; padding-left: 50px;">
							<tr>
								<td align="right">项目名称&nbsp;</td>
								<td><input type="text" id="projectName" name="projectName"
									class="inputA" style="width: 190px" /></td>
								<td align=right>单位性质&nbsp;</td>
								<td align="left"><s:select list="companyTypeList"
										listKey="itemId" listValue="itemName" id="companyType"
										name="companyType" style="width:200px"></s:select></td>
								<td align="left" style="width:15.5%">&nbsp;</td>
							</tr>
							<tr>
								<td align="right">项目分类&nbsp;</td>
								<td colspan="3">
									<%-- <s:select list="projectTypeList" listKey="itemName"
										label="abc" listValue="itemName" id="projectType"
										name="projectType" style="width:15.5em;"></s:select> --%> 
									<s:select list="deptList"
										style="width:200px" listKey="deptId" listValue="deptName"
										id="selectedProject1" name="selectedDeptId"></s:select>
									<s:select list="projectTypeFirstList" style="width:200px"
										listKey="typeId" listValue="typeShowName"
										id="selectedProject2" name="selectedProjectTypeFirst"></s:select>
									<s:select list="projectTypeSecondList" style="width:200px"
										listKey="typeId" listValue="typeShowName"
										id="selectedProject3"
										name="selectedProjectTypeSecond"></s:select>
								</td>
								<td align="left"><input class="button" type="button" id="queryBtn"
									value="查询" /> &nbsp;</td>
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
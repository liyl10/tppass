<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/js/before_review_search.js"></script>
<div align="center" style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目初审</div>
				<div>
					<form id="searchForm">
						<table style="width: 100%; padding-top: 5px; padding-left: 50px;">
							<tr>
								<td align="right">项目名称&nbsp;</td>
								<td><input type="text" id="projectName" name="projectName"
									class="inputA" style="width: 190px" /></td>
								<td align="left">申报单位&nbsp;</td>
								<td align="left"><input type="text" id="applicationUnit" name="applicationUnit"
									class="inputA" style="width: 190px" /></td>
							</tr>
							<tr>
								<td align="right">单位性质&nbsp;</td>
								<td><s:select list="companyTypeList"
										listKey="itemId" listValue="itemName" id="companyType"
										name="companyType" style="width:200px"></s:select></td>
								<c:if test="${projecTypeManager==true}">
								<td align="left">项目分类&nbsp;</td>
								<td align="left"><s:select
										list="projectTypeFirstList" style="width:200px"
										listKey="typeId" listValue="typeShowName"
										id="selectedProjectTypeFirst" name="selectedProjectTypeFirst"></s:select>
									<s:select list="projectTypeSecondList" style="width:200px"
										listKey="typeId" listValue="typeShowName"
										id="selectedProjectTypeSecond"
										name="selectedProjectTypeSecond"></s:select>
								</td>
								</c:if>
								<c:if test="${projecTypeManager==false}">
								<td colspan="2"></td>
								</c:if>
								<td><input class="button" type="button" id="queryBtn"
									value="查询" /> &nbsp;</td>
							</tr>
						</table>
					</form>
				</div>
				<div style="align: left;">
					<input class="button" type="button" id="auditBtn"
						onclick="beforeReviewByList();" value="审核" />
				</div>
				<!-- 查询结果列表S -->
				<div id="resultDiv"></div>
				<!-- 查询结果列表E -->
			</div>
		</div>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/statistics/js/statistics_project_result_search.js"></script>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目企业汇总表统计</div>
				<div>&nbsp;</div>
				<div>
					<div class=requirecolor id="errInfo"></div>
					<s:hidden id="isPlanningDept" name="isPlanningDept" value="%{isPlanningDept}"></s:hidden>
					<form id="searchForm">
						<table style="width: 100%; padding-top: 10px">
							<tr>
								<td align="right" >申报年度 &nbsp;</td>
								<td align="left"><s:select list="reportYearList"
										style="width:80px" id="selectedReportYear"
										name="selectedReportYear"></s:select> <s:hidden
										id="defaultSelectedReportYear" value="%{selectedReportYear}"></s:hidden>
								</td>
								<td align="right" >申报单位 &nbsp;</td>
								<td align="left">
									<input class="inputA" type="text" style="width:190px" id="applicationUnit" name="applicationUnit"/>
								</td>
								<td align="right">所属园区&nbsp;</td>
								<td align="left"><s:select style="width:200px" list="centralizedTypeList" label="abc" listKey="itemId"
						listValue="itemName" id="centralizedType" name="centralizedType"></s:select>
								</td>
							</tr>
							<tr>
								<td align="right" style="padding-top: 10px">项目名称 &nbsp;</td>
								<td align="left" style="padding-top: 10px">
									<input class="inputA" type="text" style="width:190px" id="projectName" name="projectName"/>
								</td>
								<s:if test="%{isPlanningDept == true}">
									<%-- <td align="right" style="padding-top: 10px">业务处室 &nbsp;</td>
									<td align="left" style="padding-top: 10px"><s:select list="deptList"
											style="width:200px" listKey="deptId" listValue="deptName"
											id="selectedDept" name="selectedDept"></s:select></td>
									<td align="right" style="padding-top: 10px">计划类别 &nbsp;</td>
									<td align="left" style="padding-top: 10px"><s:select list="projectTypeFirstList"
											style="width:200px" listKey="typeId" listValue="typeShowName"
											id="selectedProjectTypeFirst" name="selectedProjectTypeFirst"></s:select>
									</td> --%>
									 <td align="right" style="padding-top: 10px">项目分类 &nbsp;</td>
									<td align="left" colspan="3" style="padding-top: 10px"><s:select list="deptList"
											style="width:200px" listKey="deptId" listValue="deptName"
											id="selectedProjectType0" name="selectedDept"></s:select><s:select list="projectTypeFirstList"
											style="width:200px" listKey="typeId" listValue="typeShowName"
											id="selectedProjectType1" name="selectedProjectTypeFirst"></s:select>
											<s:select list="projectTypeSecondList" style="width:200px"
											listKey="typeId" listValue="typeShowName"
											id="selectedProjectType2"
											name="selectedProjectTypeSecond"></s:select>
									</td>
								</s:if>
								<s:else>
									<c:if test="${projecTypeManager==true}">
									<td align="right" style="padding-top:10px">项目分类 &nbsp;</td>
									<td align="left" colspan="3" style="padding-top: 10px"><s:select list="projectTypeFirstList"
											style="width:200px" listKey="typeId" listValue="typeShowName"
											id="selectedProjectType1" name="selectedProjectTypeFirst"></s:select>
										<s:select list="projectTypeSecondList" style="width:200px"
											listKey="typeId" listValue="typeShowName"
											id="selectedProjectType2"
											name="selectedProjectTypeSecond"></s:select></td>
									</c:if>
									<c:if test="${projecTypeManager==false}">
										<td colspan="2"></td>
									</c:if>
								</s:else>
							</tr>
							<tr>
								<td align="right" colspan="6" style="padding-top: 5px"><tag:auth
										code="tppass.dataCount.search">
										<input class="button" type="button" id="queryBtn" value="查询" />
									</tag:auth> <s:property value="%{printEnableFlag}" /> <tag:auth
										code="tppass.dataCount.print">
										<input class="button" type="button" id="exportBtn" value="打印" />
									</tag:auth></td>
							</tr>
						</table>
					</form>
				</div>
				<!-- <div align="right">
						&nbsp; <input class="button" type="button" id="queryBtn"
							value="打印" />
					</div> -->
				<div>&nbsp;</div>
				<!-- 查询结果列表S -->
				<div id="resultDiv"></div>
				<!-- 查询结果列表E -->
			</div>
		</div>
	</div>
</div>
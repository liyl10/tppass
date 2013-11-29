<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/joint/js/project_proposals_manage.js"></script>
<label id="comfirmTj" style="display: none"><s:text name="comfirm_proposals_tj_pass"/></label>
<label id="comfirmBx" style="display: none"><s:text name="comfirm_proposals_bx_pass"/></label>
<label id="comfirmLx" style="display: none"><s:text name="comfirm_proposals_lx_pass"/></label>
<s:hidden id="projectInfoBtnFlag" name="projectInfoBtnFlag" value="%{projectInfoBtnFlag}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">立项建议</div>
					<div>
						<form id="searchForm">
								<table width="100%">
									<tr>
										<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
								  			项目名称&nbsp;
								  		</td>
										<td style="white-space:nowrap;width:25%;padding:2px" colspan="2">	
								  	 		<input type="text" id="projectName" name="projectName" class="inputA" 
								  	 		autocomplete="off" maxlength="20" style="width:15em;"/>
								 		 &nbsp;
								 		</td>	
										<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
											申报单位&nbsp;
										</td>
										<td style="white-space:nowrap;width:25%;padding:2px" colspan="2">		
											<input type="text" id="applyCompany" name="applyCompany" class="inputA" 
								  	 		autocomplete="off" maxlength="20" style="width:15em;"/>
										</td>
									</tr>
									<tr>
										<c:if test="${projecTypeManager==true}">
											<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
												项目分类&nbsp;
											</td>
											<td style="white-space:nowrap;width:26%;padding:2px" colspan="5">
												<s:select list="projectTypeList1" listKey="typeId" label="abc" listValue="typeShowName"
												id="projectType1" name="projectType1" style="width:15.5em;"></s:select>
												<s:select list="projectTypeList2" listKey="typeId" label="abc" listValue="typeShowName"
												id="projectType2" name="projectType2" style="width:15.5em;"></s:select>
											</td>
										</c:if>
										<%-- <c:if test="${projecTypeManager==false}">
											<td colspan="6">
												&nbsp;
											</td>
										</c:if>--%>
									</tr>
									<tr>
										<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%" colspan="6">
											<input class="button" type="button" id="queryBtn" value="查询"/>
										&nbsp;
										</td>
									</tr>
								</table>
						</form>
					</div>
					<div style=" margin-bottom: 22px;">
						<div style="float: right;">
							<input class="button" type="button" id="recommendBtn" value="批量推荐" onclick="recommendBtn();"/>&nbsp;
							<input class="button" type="button" id="alternativeBtn" value="批量备选" onclick="alternativeBtn();"/>&nbsp;
							<input class="button" type="button" id="unsuccessfulBtn" value="批量落选" onclick="unsuccessfulBtn();"/>&nbsp;
							<input class="button" type="button" id="resultsBtn" value="打印评审结果" onclick="printExpertScoreAll();"/>&nbsp;
							<input class="button" type="button" id="projectCompanyBtn" value="打印项目企业信息表" onclick="printProjectResult();"/>&nbsp;
						</div>
					</div>
					<div>&nbsp;</div>
					<!-- 查询结果列表S -->
					<div id="resultDiv"></div>
					<!-- 查询结果列表E -->
			</div>
		</div>
	</div>
</div>
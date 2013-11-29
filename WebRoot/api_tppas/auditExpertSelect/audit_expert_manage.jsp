<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/auditExpertSelect/js/audit_expert_manage.js"></script>

<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">评审专家选择</div>
					<div>
						<form id="searchForm">
								<table style="width:100%">
									<tr>
										<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
								  			项目名称&nbsp;
								  		</td>
										<td style="white-space:nowrap;width:20%;padding:2px">	
								  	 		<input type="text" id="projectName" name="projectName" class="inputA" 
								  	 		autocomplete="off" maxlength="20" style="width:15em;"/>
								 		 &nbsp;
								 		</td>	
										<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
											申报单位&nbsp;
										</td>
										<td align="left" style="white-space:nowrap;width:25%;padding:2px;">		
											<input type="text" id="applyCompany" name="applyCompany" class="inputA" 
								  	 		autocomplete="off" maxlength="20" style="width:15em;"/>
										</td>
										<td style="width:8%;">&nbsp;</td>
									</tr>
									<tr>
										<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
											项目分组&nbsp;
										</td>
										<td style="white-space:nowrap;width:20%;padding:2px" >
											<s:select list="projectGroupList" listKey="groupId" label="abc" listValue="groupName"
											id="projectGroup" name="projectGroup" style="width:15.5em;"></s:select>
										</td>
										<c:if test="${projecTypeManager==true}">
											<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
												项目分类&nbsp;
											</td>
											<td align="left" style="white-space:nowrap;width:26%;padding:2px;">
												<s:select list="projectTypeList1" listKey="typeId" label="abc" listValue="typeShowName"
												id="projectType1" name="projectType1" style="width:15.5em;"></s:select>
												<s:select list="projectTypeList2" listKey="typeId" label="abc" listValue="typeShowName"
												id="projectType2" name="projectType2" style="width:15.5em;"></s:select>
											</td>
										</c:if>
										<c:if test="${projecTypeManager==false}">
										<td style="white-space:nowrap;width:35%;text-align:right;padding:2 2 10 10;font-size:105%" colspan="2">
										</td>
										</c:if>
										<td style="width:8%;">&nbsp;</td>
									</tr>
									<tr>
										<td colspan="5" style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
											<input class="button" type="button" id="queryBtn" value="查询"/>
										</td>
									</tr>
								</table>
						</form>
					</div>
					<div style=" margin-bottom: 22px;">
						<!-- <div style="float: left;">
							<input class="button" type="button" id="selectExpertBtn" value="选择评审专家" onclick="batchSelectExpert();"/>&nbsp;
						</div> -->
						<div style="float: right;">
							<!--<input class="button" type="button" id="signInBtn" value="专家签到表"/>
							&nbsp;
							<input class="button" type="button" id="costBtn" value="费用领取表"/>
							&nbsp;
							 <input class="button" type="button" id="reviewBtn" value="评审意见表" onclick="downLoadExpertScore();"/>
							&nbsp; -->
							<input class="button" type="button" id="createGroupBtn" value="创建新分组" onclick="createGroup();"/>
							&nbsp;
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
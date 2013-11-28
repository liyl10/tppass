<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/joint/js/audit_joint_manage.js"></script>

<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目评审</div>
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
									<c:if test="${projecTypeManager==true}">
									<tr>
										<%-- <td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
											项目分组&nbsp;
										</td>
										<td style="white-space:nowrap;width:26%;padding:2px">
											<s:select list="projectGroupList" listKey="groupId" label="abc" listValue="groupName"
											id="projectGroup" name="projectGroup" style="width:15.5em;"></s:select>
										</td> --%>
										<%-- <td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
											审核状态&nbsp;
										</td>
										<td style="white-space:nowrap;width:26%;padding:2px" colspan="2">
											<s:select list="auditStatusList" listKey="itemId" label="abc" listValue="itemName"
											id="auditStatus" name="auditStatus" style="width:15.5em;"></s:select>
										</td> --%>
										
											<td style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
												项目分类&nbsp;
											</td>
											<td style="white-space:nowrap;width:26%;padding:2px" colspan="5">
												<s:select list="projectTypeList1" listKey="typeId" label="abc" listValue="typeShowName"
												id="projectType1" name="projectType1" style="width:15.5em;"></s:select>
												<s:select list="projectTypeList2" listKey="typeId" label="abc" listValue="typeShowName"
												id="projectType2" name="projectType2" style="width:15.5em;"></s:select>
											</td>
										
										<%-- <c:if test="${projecTypeManager==false}">
											<td colspan="3">
												&nbsp;
											</td>
										</c:if> --%>
									</tr>
									</c:if>
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
						<!-- <div style="float: left;">
							<input class="button" type="button" id="selectExpertBtn" value="联席会意见" onclick="batchJointAudit();"/>&nbsp;
						</div> -->
						<div style="float: right;">
							<!-- <input class="button" type="button" id="printauditResultBtn" value="打印评审结果" onclick="printExpertScoreAll();"/>&nbsp; -->
								<tag:auth code="ss.audit_joint_manage.down1">
								<input class="button" type="button" id="downExpertScoreAndFeeCollection" value="下载专家签到表/费用领取表" onclick="downExpertScoreAndFeeCollection();"/>&nbsp;
								</tag:auth>
								<input class="button" type="button" id="downExpertScoreBtn" value="下载空白专家评估模板" onclick="downExpertScoreBtn();"/>&nbsp;
							<c:if test="${projecTypeManager==false}">
								<input class="button" type="button" id="operateExpertScoreBtn" value="专家评估表" onclick="operateExpertScoreByGroup();"/>&nbsp;
							</c:if>
							<c:if test="${projecTypeManager==true}">
								<input class="button" type="button" id="operateExpertScoreBtn" value="专家评估表" onclick="operateExpertScoreByGroup();" disabled="disabled"/>&nbsp;
							</c:if>
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
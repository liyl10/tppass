<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/audit/js/audit_progress_manage.js"></script>
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">评审进度</div>
					<div>
						<form id="searchForm">
								<table width="100%">
									<tr>
										<td style="white-space:nowrap;width:20%;text-align:right;padding:2 2 10 10;font-size:105%">
								  			专家姓名
								  		&nbsp;
								  		</td>
										<td style="white-space:nowrap;width:25%;padding:2px">	
								  	 		<input type="text" id="expertName" name="expertName" class="inputA" 
								  	 		autocomplete="off" maxlength="20" style="width:15em;"/>
								 		 &nbsp;
								 		</td>	
										<td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
											擅长专业
										&nbsp;
										</td>
										<td style="white-space:nowrap;width:40%;padding:2px">		
											<s:select list="goodProfessList" listKey="itemId" label="abc" listValue="itemName"
											id="goodProfess" name="goodProfess" style="width:15.5em;"></s:select>
										</td>
									</tr>
									<tr>
										<td style="white-space:nowrap;width:20%;text-align:right;padding:2 2 10 10;font-size:105%">
											信誉度等级
											&nbsp;
										</td>
										<td style="white-space:nowrap;width:25%;padding:2px" colspan="2">
											<s:select list="credibyLevelList" listKey="itemId" label="abc" listValue="itemName"
											id="credibyLevel" name="credibyLevel" style="width:15.5em;"></s:select>
										</td>
										<td colspan="1" style="white-space:nowrap;width:8%;text-align:right;padding:2 2 10 10;font-size:105%">
											<input class="button" type="button" id="queryBtn" value="查询"/>
										&nbsp;
										</td>
									</tr>
								</table>
						</form>
					</div>
					<div>&nbsp;</div>
					<!-- 查询结果列表S -->
					<div id="resultDiv"></div>
					<!-- 查询结果列表E -->
					<br/>
					<br/>
					<div align="center">
						<input class="button" type="button" id="saveGroupBtn" value="返回" onclick="back();"/>&nbsp;
					</div>
			</div>
		</div>
	</div>
</div>
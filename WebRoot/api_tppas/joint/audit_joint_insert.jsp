<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/joint/js/audit_joint_insert.js"></script>
<s:hidden id="projectId" name="tprojectApplication.projectId" value="%{projectId}"></s:hidden>
<s:hidden id="jointEditFlag" name="jointEditFlag" value="%{jointEditFlag}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">联席会审核</div>
					<div>
						<table width="100%" border=0 cellSpacing=0 cellPadding=0 class="t-list">
							<tr height="50px">
								<td align="right" width="40%">
						  			联席会意见&nbsp;
						  		</td>
								<td align="left" width="60%">
									<s:radio 
										id="jointStatus"
										name="jointStatus" 
										list="%{jointStatusList}" 
										listKey="itemId" 
										listValue="itemName" 
										onchange="upms.upmsUtils.radioChange(this);"
										value="%{tprojectApplication.jointStatus}"
									></s:radio>
						  	 		<%-- <textarea id="meetingOpinion" name="tprojectApplication.meetingOpinion"
										onblur="upms.upmsUtils.blurTextCheck(this,'联席会意见',1,8,1000)"
										onfocus="upms.upmsUtils.textFocus(this)" style="width:800px;height:150px;resize:none;"
										onkeyup="upms.upmsUtils.checkTextareaLength(this, 1000);"
										></textarea>
									</td> --%>
									<s:hidden id="hiddenjointStatus" name="hidden" value="联席会意见"></s:hidden>
							</tr>
							<%-- <tr>
								<td align="right" width="15%">
									处长意见&nbsp;
								</td>
								<td align="left" width="85%">
									<textarea id="commissionerOpinion" name="tprojectApplication.commissionerOpinion"
										onblur="upms.upmsUtils.blurTextCheck(this,'处长意见',1,8,1000)"
										onfocus="upms.upmsUtils.textFocus(this)" style="width:800px;height:150px;resize:none;"
										onkeyup="upms.upmsUtils.checkTextareaLength(this, 1000);"
										></textarea>
								</td>
								<s:hidden id="hiddencommissionerOpinion" name="hidden" value="处长意见,1,8,1000"></s:hidden>
							</tr> --%>
						</table>
					</div>
					<br>
					<br>
					<div align="center">
						<input class="button" type="button" id="submitBtn" value="提交" onclick="submitJointAudit('<s:text name='comfirm_joint_audit'/>');"/>&nbsp;
						<input class="button" type="button" id="backBtn" value="返回" onclick="back();"/>&nbsp;
					</div>
			</div>
		</div>
	</div>
</div>
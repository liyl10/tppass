<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/office/js/batch_office_insert.js"></script>
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<label id="comfirm" style="display: none;"><s:text name='comfirm_office_audit'/></label>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">局办公会意见批量审核</div>
					<div>
						<table width="100%" border=0 cellSpacing=0 cellPadding=0 class="t-list">
							<tr height="50px">
								<td align="right" width="40%">
						  			局办公会意见&nbsp;&nbsp;&nbsp;&nbsp;
						  		</td>
								<td align="left">	
									&nbsp;&nbsp;&nbsp;&nbsp;
									<s:radio
										id="officeStatus"
										name="officeStatus" 
										list="%{officeStatusList}" 
										listKey="itemId" 
										listValue="itemName" 
										onchange="upms.upmsUtils.radioChange(this);"
										value="%{tprojectApplication.expertAuditComposite}"
									></s:radio>
								</td>
								<s:hidden id="hiddenofficeStatus" name="hidden" value="局办公会意见"></s:hidden>
							</tr>
							
						</table>
					</div>
					<br>
					<br>
					<div align="center">
						<input class="button" type="button" id="submitBtn" value="提交" onclick="submitJointAudit();"/>&nbsp;
						<input class="button" type="button" id="backBtn" value="返回" onclick="back();"/>&nbsp;
					</div>
			</div>
		</div>
	</div>
</div>
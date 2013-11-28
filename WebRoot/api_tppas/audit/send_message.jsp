<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/audit/js/send_message.js"></script>
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="epxertId" name="epxertId" value="%{epxertId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">发送通知1</div>
					<div style="width: 100%;" align="center" >
						<table width="60%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
							<tr>
								<td align="right" width="20%">
						  			<FONT color=red>*</FONT>起止日期&nbsp;
						  		</td>
								<td align="left" width="80%" colspan="3">	
						  	 		<INPUT class="txt w184p Wdate" type="text" name="startTime" id="startId"
										 onblur="upms.upmsUtils.checkStartAndEndDate('startId','endId',1,'发送通知的',this);"
										 onfocus="upms.upmsUtils.textFocus(this);" 
										 onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly"/> 
										 <s:hidden id="hiddenstartId" name="hidden" value="开始日期,1,-1"></s:hidden>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									至
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<INPUT class="txt w184p Wdate" type="text" name="endTime" id="endId"
										 onblur="upms.upmsUtils.checkStartAndEndDate('startId','endId',1,'发送通知的',this);"
										 onfocus="upms.upmsUtils.textFocus(this);"
										 onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly"/>
										 <s:hidden id="hiddenendId" name="hidden" value="结束日期,1,-1"></s:hidden>
										 <s:hidden id="startTime" name="startTime"></s:hidden>
										 <s:hidden id="endTime" name="endTime"></s:hidden>
								</td>
								<!-- <td align="right" width="20%">
						  			<FONT color=red>*</FONT>结束日期&nbsp;
						  		</td>
								<td align="left" width="30%">	
						  	 		
								</td> -->
							</tr>
							<tr>
								<td align="right">
									<FONT color=red>*</FONT>催办内容&nbsp;
								</td>
								<td colspan="3" align="left">
									<textarea id="message" 
										 name="message" 
										 cols="65" rows="8"
										 onblur="upms.upmsUtils.blurTextCheck(this,'催办内容',1,8,1000);" 
										 onKeyUp="upms.upmsUtils.checkTextareaLength(this,1000)" 
										 onfocus="upms.upmsUtils.textFocus(this);"></textarea>
									<s:hidden id="hiddenmessage" name="hidden" value="催办内容 ,1,8,1000"></s:hidden>
								</td>
							</tr>
						</table>
					</div>
					<br>
					<br>
					<div align="center">
						<input class="button" type="button" id="agreeBtn" value="发送短信" 
							onclick="sendMessage('<s:property value='@com.hopsun.tppas.common.Constants@PROJECT_REPORT_JOINT_PASS' />','<s:text name='comfirm_joint_audit_agree'/>');"/>&nbsp;
						<input class="button" type="button" id="disagreetBtn" value="发送E-mail" 
							onclick="sendEmail('<s:property value='@com.hopsun.tppas.common.Constants@PROJECT_REPORT_JOINT_NOPASS' />','<s:text name='comfirm_joint_audit_disagree'/>');"/>&nbsp;
						<input class="button" type="button" id="backBtn" value="返回" onclick="back();"/>&nbsp;
					</div>
			</div>
		</div>
	</div>
</div>
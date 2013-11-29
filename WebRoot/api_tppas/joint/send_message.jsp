<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/joint/js/send_message.js"></script>
<s:hidden id="groupId" name="groupId" value="%{groupId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">发送通知</div>
					<div style="width: 100%;" align="center" >
						<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
						<s:hidden id="selectExpertId" name="selectExpertId"></s:hidden>
							<tr>
								<td align="right" width="15%">
						  			<font color=red>*</font>专家选择&nbsp;
						  		</td>
								<td align="left" width="35%">	
						  	 		<s:select list="texpertList" listKey="expertId" label="abc" listValue="expertName"
											id="expertId" name="expertId" style="width:16em;"></s:select>
									<s:hidden id="hiddenexpertId" name="hidden" value="专家"></s:hidden>
								</td>
								<td align="right" width="15%">
						  			<font color=red>*</font>评审日期&nbsp;
						  		</td>
								<td align="left" width="35%">	
						  	 		<input class="txt w184p Wdate" type="text" id="sendTime" name="sendTime" 
									onblur="upms.upmsUtils.blurTextCheck(this,'评审日期',1,-1);" onfocus="upms.upmsUtils.textFocus(this);"
								    onclick="WdatePicker({dateFmt:'yyyy年MM月dd日'})" readonly="readonly"/> 
									<s:hidden id="hiddensendTime" name="hidden" value="评审日期,1,-1"></s:hidden>
								</td>
							</tr>
							<tr>
								<td align="right" width="15%">
						  			评审地址&nbsp;
						  		</td>
								<td align="left" width="35%">	
						  	 		<input class="inputA"  type="text" id="sendAddress" name="sendAddress" style="width:15.5em;"/>
								</td>
								<td align="right" width="15%">
						  			评审会议室&nbsp;
						  		</td>
								<td align="left" width="35%">	
						  	 		<input class="inputA"  type="text" id="sendMeeting" name="sendMeeting" style="width:15.5em;"/>
								</td>
							</tr>
							<tr>
								<td align="right" width="15%">
						  			评审会期 &nbsp;
						  		</td>
								<td align="left" width="35%">	
						  	 		<input class="inputA"  type="text" id="sendDay" name="sendDay" style="width:15.5em;"/>
								</td>
								<td align="right" width="15%">
						  			&nbsp;
						  		</td>
								<td align="left" width="35%">	
						  	 		&nbsp;
								</td>
							</tr>
							<tr id="infoContentTr" style="display:none;">
								<td align="right" width="15%">
						  			通知内容 &nbsp;
						  		</td>
								<td align="left" colspan="3">	
						  	 		<textarea class="inputA" id="infoContent" name="infoContent" style="width:99%; height:100px;resize:none;"></textarea>
								</td>
							</tr>
						</table>
					</div>
					<br>
					<br>
					<div align="center">
						<input class="button" type="button" id="sendEnd" value="完成"  onclick="sendEnd();"/>&nbsp;
						<input class="button" type="button" id="sendMsg" value="发送短信"  onclick="sendMessage('<s:text name='comfirm_send_message'/>');"/>&nbsp;
						<input class="button" type="button" id="sendEmail" value="发送E-mail" onclick="sendEmail('<s:text name='comfirm_send_email'/>');"/>&nbsp;
						<input class="button" type="button" id="backBtn" value="返回" onclick="back();"/>&nbsp;
					</div>
					<br>
					<div align="center"><font color="red">请输入完后先点击完成按钮，查看发送通知内容，确认发送内容无误后请发送通知！！</font></div>
			</div>
		</div>
	</div>
</div>
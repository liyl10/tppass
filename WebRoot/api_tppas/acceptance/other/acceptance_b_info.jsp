<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/other/js/acceptance_b_info.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">西安市科技计划重大（重点）项目验收申请表</div>
				<div class="abuot03">
				<br>
				<s:hidden id="acceptanceId" name="tacceptance.acceptanceId" value="%{tacceptance.acceptanceId}"></s:hidden>
				<s:hidden id="acceptanceStatus" name="tacceptance.acceptanceStatus" value="%{tacceptance.acceptanceStatus}"></s:hidden>	
					<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
					  <tr>
						<td width="17%" style="text-align: right">项目名称</td>
						<td colspan="4" style="text-align: left">
						<s:property value='%{tacceptance.tprojectApplication.projectName}' escape='true'/>
					    </td>
					  </tr>
					  <tr>
						<td width="17%" style="text-align: right">项目编号</td>
						<td colspan="2" style="text-align: left">
						<s:property value='%{tacceptance.tprojectApplication.projectNumber}' escape='true'/>
						</td>
						<td width="17%" style="text-align: right"><FONT color=red>*</FONT>资助金额</td>
						<td style="text-align: left">
						<input id="funding" name="tacceptance.funding" 
					    value="<s:property value='%{tacceptance.funding}' escape='true'/>" 
					    type="text" class="inputA" style="width:80%;ime-mode: disabled;"
					    maxlength="10" onblur="upms.upmsUtils.blurTextCheck(this,'资助金额',1,2);"onfocus="upms.upmsUtils.textFocus(this);"onkeypress="return upms.upmsUtils.isFloatNum(event,this);"/>	
				     	</td><s:hidden id="hiddenfunding" name="hidden" value="资助金额,1,2"></s:hidden>
					  </tr>
					  <tr>
						<td width="17%" style="text-align: right">计划类别</td>
						<td colspan="4" style="text-align: left">
						<s:property value='%{tacceptance.tprojectApplication.planFlagName}' escape='true'/>
						</td>
					  </tr>
					  <tr>
						<td width="17%" style="text-align: right">项目承担单位</td>
						<td colspan="2" style="text-align: left">
						<s:property value='%{tacceptance.tprojectApplication.applicationUnit}' escape='true'/>
						</td>
						<td style="text-align: right;width:20%">协作单位</td>
						<td style="text-align: left">
						<s:property value='%{tprojectInfoB.assistUnit}' escape='true'/>
						</td>
					  </tr>
					  <tr>
						<td width="17%" style="text-align: right">归口管理单位</td>
						<td colspan="2" style="text-align: left">
						<s:property value='%{tacceptance.tcentralizedType}' escape='true'/>
						</td>
						<td style="text-align: right;width:20%">项目起始时间</td>
						<td style="text-align: left">
							<input name="text" type="text" class="txt w150p Wdate" value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tacceptance.tprojectApplication.startTime})}' />" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  readonly="readonly" />
						</td>
					  </tr>
					  <tr>
						<td width="17%" style="text-align: right"><FONT color=red>*</FONT>原定完成时间</td>
						<td colspan="2" style="text-align: left">
							<input class="txt w184p Wdate" type="text" name="tacceptance.scheduledTime" id="scheduledTime" value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tacceptance.scheduledTime})}' />" readonly="readonly" onclick="WdatePicker()"
							onblur="upms.upmsUtils.blurTextCheck(this,'原定完成时间',1,11);"onfocus="upms.upmsUtils.textFocus(this);"/>
						</td><s:hidden id="hiddenscheduledTime" name="hidden" value="原定完成时间,1,11"></s:hidden>
						</td>
						<td style="text-align: right;width:20%"><FONT color=red>*</FONT>实际完成时间</td>
						<td style="text-align: left">
							<input class="txt w184p Wdate" type="text" name="tacceptance.actualTime" id="actualTime" value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tacceptance.actualTime})}' />" readonly="readonly" onclick="WdatePicker()"
							onblur="upms.upmsUtils.blurTextCheck(this,'实际完成时间',1,11);"onfocus="upms.upmsUtils.textFocus(this);"/>
						</td><s:hidden id="hiddenactualTime" name="hidden" value="实际完成时间,1,11"></s:hidden>
						</td>
					  </tr>
					  <tr>
						<td width="17%" rowspan="2" style="text-align: right">项目负责人</td>
						<td style="text-align: left;width:20%"><div align="center">姓名</div></td>
						<td style="text-align: left;width:20%"><div align="center"><FONT color=red>*</FONT>单位</div></td>
						<td style="text-align: left;width:20%"><div align="center"><FONT color=red>*</FONT>职称/职务</div></td>
						<td style="text-align: left;width:20%"><div align="center">电话</div></td>
					  </tr>
					  <tr>
						<td style="text-align: left;width:20%">
							<s:property value='%{tprojectInfoB.projectPerson}' escape='true'/>
						</td>
						<td style="text-align: left;width:20%">
							<input id="responsibleUnit" name="tacceptance.responsibleUnit" 
						    value="<s:property value='%{tacceptance.responsibleUnit}' escape='true'/>" 
						    type="text" class="inputA" style="width:80%"
						    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'单位',1,-1);"onfocus="upms.upmsUtils.textFocus(this);"/>
					    </td><s:hidden id="hiddenresponsibleUnit" name="hidden" value="单位,1,-1"></s:hidden>	
						<td style="text-align: left;width:20%">
							<input id="responsibleJob" name="tacceptance.responsibleJob" 
							    value="<s:property value='%{tacceptance.responsibleJob}' escape='true'/>" 
							    type="text" class="inputA" style="width:80%"
							    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'职称/职务',1,-1);"onfocus="upms.upmsUtils.textFocus(this);"/>
					   </td><s:hidden id="hiddenresponsibleJob" name="hidden" value="职称/职务,1,-1"></s:hidden>	
						<td style="text-align: left;width:20%">
							<s:property value='%{tprojectInfoB.personTel}' escape='true'/>
						</td>
					  </tr>
					  <tr>
						<td rowspan="2" width="17%" style="text-align: right">项目联系人</td>
						<td style="text-align: left;width:20%"><div align="center">姓名</div></td>
						<td style="text-align: left;width:20%"><div align="center"><FONT color=red>*</FONT>单位</div></td>
						<td style="text-align: left;width:20%"><div align="center"><FONT color=red>*</FONT>职称/职务</div></td>
						<td style="text-align: left;width:20%"><div align="center">电话</div></td>
					  </tr>
					  <tr>
						<td style="text-align: left;width:20%">
							<s:property value='%{tprojectInfoB.touchPerson}' escape='true'/>
						</td>
						<td style="text-align: left;width:20%">
							<input id="touchUnit" name="tacceptance.touchUnit" 
						    value="<s:property value='%{tacceptance.touchUnit}' escape='true'/>" 
						    type="text" class="inputA" style="width:80%"
						    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'单位',1,-1);"onfocus="upms.upmsUtils.textFocus(this);"/>
					    </td><s:hidden id="hiddentouchUnit" name="hidden" value="单位,1,-1"></s:hidden>	
						<td style="text-align: left;width:20%">
						<input id="touchJob" name="tacceptance.touchJob" 
							    value="<s:property value='%{tacceptance.touchJob}' escape='true'/>" 
							    type="text" class="inputA" style="width:80%"
							    maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'职称/职务',1,-1);"onfocus="upms.upmsUtils.textFocus(this);"/>
					   </td><s:hidden id="hiddentouchJob" name="hidden" value="职称/职务,1,-1"></s:hidden>	
						<td style="text-align: left;width:20%">
							<s:property value='%{tprojectInfoB.touchPhone}' escape='true'/>
						</td>
					</tr>
					  <tr>
						<td style="text-align: right;width:17%">项目承担单位意见</td>
						<td colspan="2" style="text-align: left;">
							<textarea class="inputA" style="width:300px;height:80px"><s:property value='%{treviewComments.reportingUnits}' escape='true'/></textarea>	
						</td>
						<td style="text-align: left;width:17%"><div align="right">协作单位意见</div></td>
						<td style="text-align: left">
							<textarea class="inputA" style="width:300px;height:80px"><s:property value='%{treviewComments.cooperativeUnits}' escape='true'/></textarea>	
						</td>
					  </tr>
					  <tr>
						<td style="text-align: right;width:17%">项目归口管理部门意见</td>
						<td colspan="4" style="text-align: left">
							<textarea class="inputA" style="width:700px;height:100px"><s:property value='%{treviewComments.centralizedUnits}' escape='true'/></textarea>	
						</td>
					  </tr>
					  <tr>
						<td style="text-align: right;width:17%">市科技局项目主管处室意见
						  </td>
						<td colspan="4" style="text-align: left">
							<textarea class="inputA" style="width:700px;height:100px"><s:property value='%{treviewComments.scienceUnits}' escape='true'/></textarea>	
						</td>
					  </tr>
					</table>
					<br/>
					<div align="center">
						<input class="button save" id="nextBtn" name="button" type="button" href="javascript: void(0);" value="下一步"/>
					</div>
				</div>
 			 </div>
		 </div>
	</div>
</div>
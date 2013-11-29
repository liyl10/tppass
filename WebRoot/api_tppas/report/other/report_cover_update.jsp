<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/other/js/report_cover_update.js"></script>
<!-- 项目ID -->
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<!-- 计划类别 -->
<s:hidden id="planFlag" name="tprojectApplication.planFlag" value="%{tprojectApplication.projectPaTypeId}"></s:hidden>
<s:hidden id="tprojectType" name="tprojectApplication.tprojectType.typeId" value="%{tprojectApplication.projectTypeId}"></s:hidden>
<s:hidden id="projectId1" name="tprojectApplication.projectId" value="%{tprojectApplication.projectId}"></s:hidden>
<s:hidden id="projectInfoId" name="tprojectInfoB.projectInfoId" value="%{tprojectInfoB.projectInfoId }"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div>
					<s:label><FONT color=red>*</FONT>计划类别:&nbsp;<s:property value='%{projectPaTypeName}' escape='true'/></s:label>
				</div>
				<div class="abuot07">西安市科技计划<br />项目申报书</div>
				<table width="100%">
					<tr>
						<td width="30%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>项目名称
						</td>
						<td colspan="5" width="60%" style="padding: 4px 8px; text-align: left">
							<input id="projectName" name="tprojectApplication.projectName" type="text" style="width: 20em; 
							height:1.6em;" class="inputA"  value="<s:property value='%{tprojectApplication.projectName}' escape='true'/>"
							/>
							<s:hidden id="hiddenprojectName" name="hidden" value="项目名称,1,-1"></s:hidden>
						</td>
					</tr>
					<tr>
						<td width="30%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>项目分类
						</td>
						<td colspan="5" width="60%" style="padding: 4px 8px; text-align: left">
							<input id="projectTypeTemp" name="projectTypeTemp" type="text" style="width: 20em; height:1.6em;" 
								class="inputA"
								value="<s:property value='%{tprojectApplication.planFlagName}' escape='true'/>-<s:property value='%{tprojectApplication.typeName}' escape='true'/>" readonly="readonly"/>						</td>
					</tr>
					<tr>
						<td width="30%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>申请单位
						</td>
						<td colspan="5" width="60%" style="padding: 4px 8px; text-align: left">
							<input id="applicationUnit" name="tprojectApplication.applicationUnit" type="text" 
							style="width: 20em; height:1.6em;" class="inputA"
							readonly="readonly"
							maxlenth="20" value="<s:property value='%{tprojectApplication.applicationUnit}' escape='true'/>"/>
						</td>
					</tr>
					<!-- Start 2013/09/29 业务变更 wanglw -->
					<tr>
						<td width="20%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>委托单位
						</td>
						<td colspan="5" width="80%" style="padding: 4px 8px; text-align: left">
							<input id="entrustUnit" name="tprojectApplication.entrustUnit" type="text" 
							style="width: 20em; height:1.6em;" class="inputA"
							maxlenth="20" value="<s:property value='%{tprojectApplication.entrustUnit}' escape='true'/>"/>
						</td>
						<s:hidden id="hiddenentrustUnit" name="hidden" value="委托单位,1,-1"></s:hidden>
					</tr>
					<%-- <tr>
						<td width="10%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>项目负责人
						</td>
						<td width="10%" style="padding: 4px 8px; text-align: left">
							<input id="projectPerson" name="tprojectInfoB.projectPerson" type="text" 
							style="width: 20em; height:1.6em;" class="inputA" 
							value="<s:property value='%{tprojectInfoB.projectPerson}' escape='true'/>"/>
							<s:hidden id="hiddenprojectPerson" name="hidden" value="项目负责人,1,-1"></s:hidden>
						</td>
						<td width="20%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>联系电话
						</td>
						<td width="60%" style="padding: 4px 8px; text-align: left">
							<input id="personTel" name="tprojectInfoB.personTel" type="text" 
							style="width: 20em; height:1.6em;" class="inputA"
							onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',1,12)"
							onfocus="upms.upmsUtils.textFocus(this);" maxlength="13"
							value="<s:property value='%{tprojectInfoB.personTel}' escape='true'/>"/>
							<s:hidden id="hiddenpersonTel" name="hidden" value="联系电话,1,12"></s:hidden>
						</td>
					</tr> --%>
					<tr>
						<td width="20%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>项目负责人
						</td>
						<td width="20%" style="padding: 4px 8px; text-align: left">
							<input id="projectPerson" name="tprojectInfoB.projectPerson" type="text" 
							style="width: 10em; height:1.6em;" class="inputA" 
							onblur="upms.upmsUtils.blurTextCheck(this,'项目负责人',0,-1)"
							onfocus="upms.upmsUtils.textFocus(this);" maxlength="5"
							value="<s:property value='%{tprojectInfoB.projectPerson}' escape='true'/>"
							readonly="readonly"
							readFlag="1"/>
							<s:hidden id="hiddenprojectPerson" name="hidden" value="项目负责人,0,-1"></s:hidden>
						</td>
						<td width="10%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>手机
						</td>
						<td width="20%" style="padding: 4px 8px; text-align: left">
							<input id="personPhone" name="tprojectInfoB.personPhone" type="text" 
							style="width: 10em; height:1.6em;" class="inputA"
							onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',0,12)"
							onfocus="upms.upmsUtils.textFocus(this);" maxlength="13"
							value="<s:property value='%{tprojectInfoB.personPhone}' escape='true'/>"
							readonly="readonly"
							readFlag="1"/>
							<s:hidden id="hiddenpersonPhone" name="hidden" value="联系电话,0,12"></s:hidden>
						</td>
						<td width="10%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>电话
						</td>
						<td width="20%" style="padding: 4px 8px; text-align: left">
							<input id="personTel" name="tprojectInfoB.personTel" type="text" 
							style="width: 10em; height:1.6em;" class="inputA"
							onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',0,12)"
							onfocus="upms.upmsUtils.textFocus(this);" maxlength="13"
							value="<s:property value='%{tprojectInfoB.personTel}' escape='true'/>"
							readonly="readonly"
							readFlag="1"/>
							<s:hidden id="hiddenpersonTel" name="hidden" value="联系电话,0,12"></s:hidden>
						</td>
					</tr>
					<tr>
						<td width="20%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>项目联系人
						<td width="20%" style="padding: 4px 8px; text-align: left">
							<input id="touchPerson" name="tprojectInfoB.touchPerson" type="text" 
							style="width: 10em; height:1.6em;" class="inputA" 
							onblur="upms.upmsUtils.blurTextCheck(this,'项目负责人',0,-1)"
							onfocus="upms.upmsUtils.textFocus(this);" maxlength="5"
							value="<s:property value='%{tprojectInfoB.touchPerson}' escape='true'/>"
							readonly="readonly"
							readFlag="1"/>
							<s:hidden id="hiddentouchPerson" name="hidden" value="项目负责人,0,-1"></s:hidden>
						</td>
						<td width="10%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>手机
						</td>
						<td width="20%" style="padding: 4px 8px; text-align: left">
							<input id="touchPhone" name="tprojectInfoB.touchPhone" type="text" 
							style="width: 10em; height:1.6em;" class="inputA"
							onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',0,12)"
							onfocus="upms.upmsUtils.textFocus(this);" maxlength="13"
							value="<s:property value='%{tprojectInfoB.touchPhone}' escape='true'/>"
							readonly="readonly"
							readFlag="1"/>
							<s:hidden id="hiddentouchPhone" name="hidden" value="联系电话,0,12"></s:hidden>
						</td>
						<td width="10%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>电话
						</td>
						<td width="20%" style="padding: 4px 8px; text-align: left">
							<input id="personTel" name="tprojectInfoB.personTel" type="text" 
							style="width: 10em; height:1.6em;" class="inputA"
							onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',0,12)"
							onfocus="upms.upmsUtils.textFocus(this);" maxlength="13"
							value="<s:property value='%{tprojectInfoB.touchTel}' escape='true'/>"
							readonly="readonly"
							readFlag="1"/>
							<s:hidden id="hiddenpersonTel" name="hidden" value="联系电话,0,12"></s:hidden>
						</td>
					</tr>
					<!-- End 2013/09/29 业务变更 wanglw -->
					<tr>
						<td width="30%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>归口管理部门
						</td>
						<td colspan="5" width="60%" style="padding: 4px 8px; text-align: left">
							<s:select style="width:14em;" list="centralizedBranchList" label="abc" 
									listKey="itemId"
									listValue="itemName" id="centralizedType" 
									name="tprojectApplication.centralizedType" 
									>
							</s:select>
							<s:hidden id="centralizedTypeValue" name="centralizedTypeValue" value="%{tprojectApplication.centralizedType}"></s:hidden>
							<s:hidden id="hiddencentralizedType" name="hidden" value="归口管理部门"></s:hidden>
						</td>
					</tr>
					<tr>
						<td width="30%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>起止年限
						</td>
						<td colspan="5" width="60%" style="padding: 4px 8px; text-align: left">
							 <INPUT class="txt w184p Wdate" type="text" name="startTime" id="startId"
							 onblur="upms.upmsUtils.checkStartAndEndDate('startId','endId',1,'起止年限',this,3);"
							 onfocus="upms.upmsUtils.textFocus(this);" 
							 onclick="WdatePicker({dateFmt:'yyyy-MM'})" readonly="readonly"
							 value="<s:property value='%{getText("{0,date,yyyy-MM}",{tprojectApplication.startTime})}' escape='true'/>"/> 
							 <s:hidden id="hiddenstartId" name="hidden" value="起止年限开始时间,1,-1"></s:hidden>
								至
							 <INPUT class="txt w184p Wdate" type="text" name="endTime" id="endId"
							 onblur="upms.upmsUtils.checkStartAndEndDate('startId','endId',1,'起止年限',this,3);"
							 onfocus="upms.upmsUtils.textFocus(this);"
							 onclick="WdatePicker({dateFmt:'yyyy-MM'})" readonly="readonly"
							 value="<s:property value='%{getText("{0,date,yyyy-MM}",{tprojectApplication.endTime})}' escape='true'/>"/>
							 <s:hidden id="hiddenendId" name="hidden" value="起止年限结束时间,1,-1"></s:hidden>
							 <s:hidden id="startTime" name="tprojectApplication.startTime"></s:hidden>
							 <s:hidden id="endTime" name="tprojectApplication.endTime"></s:hidden>
						</td>
					</tr>
					<tr>
						<td width="30%" style="padding: 4px 8px; text-align: right">
							<FONT color=red>*</FONT>填报时间
						</td>
						<td colspan="5" width="60%" style="padding: 4px 8px; text-align: left">
							<INPUT class="txt w184p Wdate" type="text" id="writeReportTime" 
							name="tprojectApplication.writeReportTime" onclick="WdatePicker()" 
							readonly="readonly" onfocus="upms.upmsUtils.textFocus(this);"
							onblur="upms.upmsUtils.blurTextCheck(this,'填报时间',1,-1)"
							value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tprojectApplication.writeReportTime})}' escape='true'/>"/>
							<s:hidden id="hiddenwriteReportTime" name="hidden" value="填报时间,1,-1"></s:hidden>
						</td>
					</tr>
				</table>
				<div align="center" style="width: 100%">
					<br> <br>
					<s:property value='%{tprojectApplication.compilationDept}' escape='true'/><br />
					<s:property value='%{tprojectApplication.compilationTime}' escape='true'/>
					<s:hidden id="compilationDept" name="tprojectApplication.compilationDept" value="%{tprojectApplication.compilationDept}"></s:hidden>
					<s:hidden id="compilationTime" name="tprojectApplication.compilationTime" value="%{tprojectApplication.compilationTime}"></s:hidden>
					<br> <br>
						<input id="nextBtn" type="button" class="button save" href="javascript: void(0);" value="下一步"/>
				</div>
			</div>
		</div>
	</div>
</div>
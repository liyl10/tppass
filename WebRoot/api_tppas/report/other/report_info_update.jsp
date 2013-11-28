<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/other/js/report_info_update.js"></script>
<!-- 项目ID -->
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>

<s:hidden id="tprojectInfoBProjectId" name="tprojectInfoB.tprojectApplication.projectId" value="%{tprojectInfoB.tprojectApplication.projectId}"></s:hidden>
<s:hidden id="projectInfoId" name="tprojectInfoB.projectInfoId" value="%{tprojectInfoB.projectInfoId}"></s:hidden>
<s:hidden id="projectIdTemp" name="tprojectApplication.projectId" value="%{tprojectApplication.projectId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目基本信息</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm">
					<tr>
						<td width="15%" align="right">项目名称</td>
						<td colspan="5">
							<input class="inputA" id="projectName" name="projectName" 
								type="text" disabled="disabled"
								value="<s:property value='%{tprojectApplication.projectName}' escape='true'/>"/>
						</td>
					</tr>
					<tr>
						<td align="right">承担单位</td>
						<td colspan="2">
							<input class="inputA" name="text" type="text" disabled="disabled"
								value="<s:property value='%{tprojectApplication.applicationUnit}' escape='true'/>"/>
						</td>
						<td align="right">归口管理部门</td>
						<td colspan="2">
						<s:property value='%{tprojectApplication.centralizedTypeName}' escape='true'/>
<%-- 							<s:select style="width:14em;" list="centralizedBranchList" label="abc" 
									listKey="itemId"
									listValue="itemName" id="centralizedType" 
									name="tprojectApplication.centralizedType"
									>
							</s:select>
							<s:hidden id="centralizedTypeValue" name="centralizedTypeValue" value="%{tprojectApplication.centralizedType}"></s:hidden>
							<s:hidden id="hiddencentralizedType" name="hidden" value="归口管理部门"></s:hidden>
						</td --%>
					</tr>
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>单位地址
						</td>
						<td colspan="3">
							<input class="inputA" id="unitAddress" name="tprojectInfoB.unitAddress" type="text"
								value="<s:property value='%{tprojectInfoB.unitAddress}' escape='true'/>"
								maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'单位地址',1,-1);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddenunitAddress" name="hidden" value="归口管理部,1,-1"></s:hidden>
						</td>
						<td align="right">
							<FONT color=red>*</FONT>邮编
						</td>
						<td colspan="1">
							<input class="inputA" id="zipcode" name="tprojectInfoB.zipcode" type="text"
								value="<s:property value='%{tprojectInfoB.zipcode}' escape='true'/>"
								maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'邮编',1,6);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddenzipcode" name="hidden" value="归口管理部,1,6"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>所在区域
						</td>
						<td colspan="5">
							<div>
								<s:select style="width:14em;" list="regionIdList1" label="abc" 
										listKey="itemId"
										listValue="itemName" id="regionId1" 
										name="tprojectInfoB.regionId1" 
										>
								</s:select>
								<s:hidden id="regionId1Value" name="regionId1Value" 
									value="%{tprojectInfoB.regionId1}"></s:hidden>
								<s:select style="width:14em;" list="regionIdList2" label="abc" 
										listKey="itemId"
										listValue="itemName" id="regionId2" 
										name="tprojectInfoB.regionId2" 
										>
								</s:select>
								<s:hidden id="regionId2Value" name="regionId2Value" 
									value="%{tprojectInfoB.regionId2}"></s:hidden>
								<s:select style="width:14em;" list="regionIdList3" label="abc" 
										listKey="itemId"
										listValue="itemName" id="regionId3" 
										name="tprojectInfoB.regionId3" 
										>
								</s:select>
								<s:hidden id="regionId3Value" name="regionId3Value" 
									value="%{tprojectInfoB.regionId3}"></s:hidden>
							</div>
							<s:hidden id="hiddenregionId3" name="hidden" value="所在区域"></s:hidden>
						</td>
					</tr>
					<!-- Start 2013/09/26  业务变更  wanglw -->
					<%-- <tr>
						<td align="right">
							<FONT color=red>*</FONT>国民经济行业分类
						</td>
						<td colspan="5">
							<div>
								<s:select style="width:14em;" list="industriesList1" label="abc" 
										listKey="itemId"
										listValue="itemName" id="industries1" 
										name="tprojectInfoB.industries1" 
										>
								</s:select>
								<s:hidden id="industries1Value" name="industries1Value" 
									value="%{tprojectInfoB.industries1}"></s:hidden>
								<s:select style="width:14em;" list="industriesList2" label="abc" 
										listKey="itemId"
										listValue="itemName" id="industries2" 
										name="tprojectInfoB.industries2" 
										>
								</s:select>
								<s:hidden id="industries2Value" name="industries2Value" 
									value="%{tprojectInfoB.industries2}"></s:hidden>
								<s:select style="width:14em;" list="industriesList3" label="abc" 
										listKey="itemId"
										listValue="itemName" id="industries3" 
										name="tprojectInfoB.industries3" 
										>
								</s:select>
								<s:hidden id="industries3Value" name="industries3Value" 
									value="%{tprojectInfoB.industries3}"></s:hidden>
								<s:select style="width:14em;" list="industriesList4" label="abc" 
										listKey="itemId"
										listValue="itemName" id="industries4" 
										name="tprojectInfoB.industries4" 
										>
								</s:select>
								<s:hidden id="industries4Value" name="industries4Value" 
									value="%{tprojectInfoB.industries4}"></s:hidden>
							</div>
							<s:hidden id="hiddenindustries4" name="hidden" value="国民经济行业分类"></s:hidden>
						</td>
					</tr> --%>
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>单位所属行业领域
						</td>
						<td colspan="5">
							<div>
								<s:select style="width:14em;" list="industriesList1" label="abc" 
										listKey="itemId"
										listValue="itemName" id="industries1" 
										name="tprojectInfoB.industries1" 
										>
								</s:select>
								<s:hidden id="industries1Value" name="industries1Value" 
									value="%{tprojectInfoB.industries1}"></s:hidden>
								<s:select style="width:14em;" list="industriesList2" label="abc" 
										listKey="itemId"
										listValue="itemName" id="industries2" 
										name="tprojectInfoB.industries2" 
										>
								</s:select>
								<s:hidden id="industries2Value" name="industries2Value" 
									value="%{tprojectInfoB.industries2}"></s:hidden>
								<s:select style="width:14em;" list="industriesList3" label="abc" 
										listKey="itemId"
										listValue="itemName" id="industries3" 
										name="tprojectInfoB.industries3" 
										>
								</s:select>
								<s:hidden id="industries3Value" name="industries3Value" 
									value="%{tprojectInfoB.industries3}"></s:hidden>
								<s:select style="width:14em;" list="industriesList4" label="abc" 
										listKey="itemId"
										listValue="itemName" id="industries4" 
										name="tprojectInfoB.industries4" 
										>
								</s:select>
								<s:hidden id="industries4Value" name="industries4Value" 
									value="%{tprojectInfoB.industries4}"></s:hidden>
							</div>
							<s:hidden id="hiddenindustries4" name="hidden" value="单位所属行业领域"></s:hidden>
						</td>
					</tr>
					<!-- End 2013/09/26  业务变更  wanglw -->
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>单位性质
						</td>
						<td colspan="5">
							<s:select style="width:14em;" list="unitPropertiesList" label="abc" 
								listKey="itemId"
								listValue="itemName" id="unitProperties" 
								name="tprojectInfoB.unitProperties" 
								>
							</s:select>
							<s:hidden id="unitPropertiesValue" name="unitPropertiesValue" 
									value="%{tprojectInfoB.unitProperties}"></s:hidden>
							<s:hidden id="hiddenunitProperties" name="hidden" value="单位性质"></s:hidden>
						</td>
					</tr>
					<!-- Start 2013/09/29 业务变更 wanglw -->
					<%-- <tr>
						<td width="15%" align="right">法定代表人</td>
						<td width="20%">
							<input class="inputA" id="legalPerson" name="tprojectInfoB.legalPerson" type="text"
								style="width:10em;"
								value="<s:property value='%{tprojectInfoB.legalPerson}' escape='true'/>"
								maxlength="5" onblur="upms.upmsUtils.blurTextCheck(this,'法定代表人',0,-1);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddenlegalPerson" name="hidden" value="法定代表人,0,-1"></s:hidden>
						</td>
						<td width="15%" align="right">联系电话</td>
						<td width="17%">
							<input class="inputA" id="legalTel" name="tprojectInfoB.legalTel" type="text"
								style="width:10em;"
								value="<s:property value='%{tprojectInfoB.legalTel}' escape='true'/>"
								maxlength="13" onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',0,12);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddenlegalTel" name="hidden" value="联系电话,0,12"></s:hidden>
						</td>
						<td width="15%" align="right">E-mail</td>
						<td width="18%">
							<input class="inputA" id="legalEmail" name="tprojectInfoB.legalEmail" type="text"
								value="<s:property value='%{tprojectInfoB.legalEmail}' escape='true'/>"
								maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'E-mail',0,7);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								style="ime-mode: disabled;width:10em;"
								/>
							<s:hidden id="hiddenlegalEmail" name="hidden" value="E-mail,0,7"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right">项目负责人</td>
						<td>
							<input class="inputA" id="projectPerson" name="tprojectInfoB.projectPerson" type="text"
								style="width:10em;"
								value="<s:property value='%{tprojectInfoB.projectPerson}' escape='true'/>"
								maxlength="5" onblur="upms.upmsUtils.blurTextCheck(this,'项目负责人',0,-1);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddenprojectPerson" name="hidden" value="项目负责人,0,-1"></s:hidden>
						</td align="right">
						<td align="right">联系电话</td>
						<td>
							<input class="inputA" id="personTel" name="tprojectInfoB.personTel" type="text"
								style="width:10em;"
								value="<s:property value='%{tprojectInfoB.personTel}' escape='true'/>"
								maxlength="13" onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',0,12);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddenpersonTel" name="hidden" value="联系电话,0,12"></s:hidden>
						</td>
						<td align="right">E-mail</td>
						<td>
							<input class="inputA" id="personEmail" name="tprojectInfoB.personEmail" type="text"
								value="<s:property value='%{tprojectInfoB.personEmail}' escape='true'/>"
								maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'E-mail',0,7);" 
								onfocus="upms.upmsUtils.textFocus(this);" style="ime-mode: disabled;width:10em;"
								/>
							<s:hidden id="hiddenpersonEmail" name="hidden" value="E-mail,0,7"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right">项目联系人</td>
						<td>
							<input class="inputA" id="touchPerson" name="tprojectInfoB.touchPerson" type="text"
								style="width:10em;"
								value="<s:property value='%{tprojectInfoB.touchPerson}' escape='true'/>"
								maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'项目联系人',0,-1);" 
								onfocus="upms.upmsUtils.textFocus(this);" 
								/>
							<s:hidden id="hiddentouchPerson" name="hidden" value="项目联系人,0,-1"></s:hidden>
						</td>
						<td align="right">联系电话</td>
						<td>
							<input class="inputA" id="touchPhone" name="tprojectInfoB.touchPhone" type="text"
								style="width:10em;"
								value="<s:property value='%{tprojectInfoB.touchPhone}' escape='true'/>"
								maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',0,12);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddentouchPhone" name="hidden" value="联系电话,0,12"></s:hidden>
						</td>
						<td align="right">工作部门</td>
						<td>
							<input class="inputA" id="touchDepart" name="tprojectInfoB.touchDepart" type="text"
								style="width:10em;"
								value="<s:property value='%{tprojectInfoB.touchDepart}' escape='true'/>"
								maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'工作部门',0,-1);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddentouchDepart" name="hidden" value="工作部门,0,-1"></s:hidden>
						</td>
					</tr> --%>
					<tr>
						<td width="15%" align="right">
							<FONT color=red>*</FONT>法定代表人
						</td>
						<td width="36%" colspan="2">
							<input class="inputA" id="legalPerson" name="tprojectInfoB.legalPerson" type="text"
								style="width:16.5em;"
								value="<s:property value='%{tprojectInfoB.legalPerson}' escape='true'/>"
								maxlength="5" onblur="upms.upmsUtils.blurTextCheck(this,'法定代表人',0,-1);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddenlegalPerson" name="hidden" value="法定代表人,0,-1"></s:hidden>
						</td>
						<td width="15%" align="right">
							<FONT color=red>*</FONT>手机
						</td>
						<td width="34%" colspan="2">
							<input class="inputA" id="legalPhone" name="tprojectInfoB.legalPhone" type="text"
								style="width:16.5em;"
								value="<s:property value='%{tprojectInfoB.legalPhone}' escape='true'/>"
								maxlength="13" onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',0,12);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddenlegalPhone" name="hidden" value="联系电话,0,12"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>电话
						</td>
						<td colspan="2">
							<input class="inputA" id="legalTel" name="tprojectInfoB.legalTel" type="text"
								style="width:16.5em;"
								value="<s:property value='%{tprojectInfoB.legalTel}' escape='true'/>"
								maxlength="13" onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',0,12);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddenlegalTel" name="hidden" value="联系电话,0,12"></s:hidden>
						</td>
						<td align="right">
							<FONT color=red>*</FONT>E-mail
						</td>
						<td colspan="2">
							<input class="inputA" id="legalEmail" name="tprojectInfoB.legalEmail" type="text"
								value="<s:property value='%{tprojectInfoB.legalEmail}' escape='true'/>"
								maxlength="15" onblur="upms.upmsUtils.blurTextCheck(this,'E-mail',0,7);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								style="ime-mode: disabled;width:16.5em;"
								/>
							<s:hidden id="hiddenlegalEmail" name="hidden" value="E-mail,0,7"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>项目负责人
						</td>
						<td colspan="2">
							<input class="inputA" id="projectPerson" name="tprojectInfoB.projectPerson" type="text"
								style="width:16.5em;"
								value="<s:property value='%{tprojectInfoB.projectPerson}' escape='true'/>"
								maxlength="5" onblur="upms.upmsUtils.blurTextCheck(this,'项目负责人',0,-1);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddenprojectPerson" name="hidden" value="项目负责人,0,-1"></s:hidden>
						</td align="right">
						<td align="right">
							<FONT color=red>*</FONT>手机
						</td>
						<td colspan="2">
							<input class="inputA" id="personPhone" name="tprojectInfoB.personPhone" type="text"
								style="width:16.5em;"
								value="<s:property value='%{tprojectInfoB.personPhone}' escape='true'/>"
								maxlength="13" onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',0,12);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddenpersonPhone" name="hidden" value="联系电话,0,12"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>电话
						</td>
						<td colspan="2">
							<input class="inputA" id="personTel" name="tprojectInfoB.personTel" type="text"
								style="width:16.5em;"
								value="<s:property value='%{tprojectInfoB.personTel}' escape='true'/>"
								maxlength="13" onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',0,12);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddenpersonTel" name="hidden" value="联系电话,0,12"></s:hidden>
						</td>
						<td align="right">
							<FONT color=red>*</FONT>E-mail
						</td>
						<td colspan="2">
							<input class="inputA" id="personEmail" name="tprojectInfoB.personEmail" type="text"
								value="<s:property value='%{tprojectInfoB.personEmail}' escape='true'/>"
								maxlength="15" onblur="upms.upmsUtils.blurTextCheck(this,'E-mail',0,7);" 
								onfocus="upms.upmsUtils.textFocus(this);" style="ime-mode: disabled;width:16.5em;"
								/>
							<s:hidden id="hiddenpersonEmail" name="hidden" value="E-mail,0,7"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>项目联系人1
						</td>
						<td colspan="2">
							<input class="inputA" id="touchPerson" name="tprojectInfoB.touchPerson" type="text"
								style="width:16.5em;"
								value="<s:property value='%{tprojectInfoB.touchPerson}' escape='true'/>"
								maxlength="5" onblur="upms.upmsUtils.blurTextCheck(this,'项目联系人',0,-1);" 
								onfocus="upms.upmsUtils.textFocus(this);" 
								/>
							<s:hidden id="hiddentouchPerson" name="hidden" value="项目联系人,0,-1"></s:hidden>
						</td>
						<td align="right">
							<FONT color=red>*</FONT>手机
						</td>
						<td colspan="2">
							<input class="inputA" id="touchPhone" name="tprojectInfoB.touchPhone" type="text"
								style="width:16.5em;"
								value="<s:property value='%{tprojectInfoB.touchPhone}' escape='true'/>"
								maxlength="13" onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',0,12);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddentouchPhone" name="hidden" value="联系电话,0,12"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>电话
						</td>
						<td colspan="2">
							<input class="inputA" id="touchTel" name="tprojectInfoB.touchTel" type="text"
								style="width:16.5em;"
								value="<s:property value='%{tprojectInfoB.touchTel}' escape='true'/>"
								maxlength="13" onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',0,12);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddentouchTel" name="hidden" value="联系电话,0,12"></s:hidden>
						</td>
						<td align="right">
							<FONT color=red>*</FONT>E-mail
						</td>
						<td colspan="2">
							<input class="inputA" id="touchEmail" name="tprojectInfoB.touchEmail" type="text"
								value="<s:property value='%{tprojectInfoB.touchEmail}' escape='true'/>"
								maxlength="15" onblur="upms.upmsUtils.blurTextCheck(this,'E-mail',0,7);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								style="ime-mode: disabled;width:16.5em;"
								/>
							<s:hidden id="hiddentouchEmail" name="hidden" value="E-mail,0,7"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>项目联系人2
						</td>
						<td colspan="2">
							<input class="inputA" id="touchPerson1" name="tprojectInfoB.touchPerson1" type="text"
								style="width:16.5em;"
								value="<s:property value='%{tprojectInfoB.touchPerson1}' escape='true'/>"
								maxlength="5" onblur="upms.upmsUtils.blurTextCheck(this,'项目联系人',0,-1);" 
								onfocus="upms.upmsUtils.textFocus(this);" 
								/>
							<s:hidden id="hiddentouchPerson1" name="hidden" value="项目联系人,0,-1"></s:hidden>
						</td>
						<td align="right">
							<FONT color=red>*</FONT>手机
						</td>
						<td colspan="2">
							<input class="inputA" id="touchPhone1" name="tprojectInfoB.touchPhone1" type="text"
								style="width:16.5em;"
								value="<s:property value='%{tprojectInfoB.touchPhone1}' escape='true'/>"
								maxlength="13" onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',0,12);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddentouchPhone1" name="hidden" value="联系电话,0,12"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>电话
						</td>
						<td colspan="2">
							<input class="inputA" id="touchTel1" name="tprojectInfoB.touchTel1" type="text"
								style="width:16.5em;"
								value="<s:property value='%{tprojectInfoB.touchTel1}' escape='true'/>"
								maxlength="13" onblur="upms.upmsUtils.blurTextCheck(this,'联系电话',0,12);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddentouchTel1" name="hidden" value="联系电话,0,12"></s:hidden>
						</td>
						<td align="right">
							<FONT color=red>*</FONT>E-mail
						</td>
						<td colspan="2">
							<input class="inputA" id="touchEmail1" name="tprojectInfoB.touchEmail1" type="text"
								value="<s:property value='%{tprojectInfoB.touchEmail1}' escape='true'/>"
								maxlength="15" onblur="upms.upmsUtils.blurTextCheck(this,'E-mail',0,7);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								style="ime-mode: disabled;width:16.5em;"
								/>
							<s:hidden id="hiddentouchEmail1" name="hidden" value="E-mail,0,7"></s:hidden>
						</td>
					</tr>
					<!-- End 2013/09/29 业务变更 wanglw -->
					<!-- Start 2013/10/06 业务变更 wanglw -->
					<%-- <tr>
						<td rowspan="2" align="right">项目主要协作单位</td>
						<td rowspan="2" colspan="2">
							<input class="inputA" id="assistUnit" name="tprojectInfoB.assistUnit" type="text"
							 	value="<s:property value='%{tprojectInfoB.assistUnit}' escape='true'/>"
							 	maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'项目主要协作单位',0,-1);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddenassistUnit" name="hidden" value="项目主要协作单位,0,-1"></s:hidden>
						</td>
						<td colspan="3" align="center">
							<FONT color=red>*</FONT>项目起止时间
						</td>
					</tr> --%>
					<tr>
						<td  align="right">项目主要协作单位1</td>
						<td  colspan="2">
							<input class="inputA" id="assistUnit" name="tprojectInfoB.assistUnit" type="text"
							 	value="<s:property value='%{tprojectInfoB.assistUnit}' escape='true'/>"
							 	maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'项目主要协作单位',0,-1);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddenassistUnit" name="hidden" value="项目主要协作单位,0,-1"></s:hidden>
						</td>
						<td colspan="3" align="center">
							<FONT color=red>*</FONT>项目起止时间
						</td>
						
					</tr>
					<!-- End 2013/10/06 业务变更 wanglw -->
					<tr>
						<td align="right">项目主要协作单位2</td>
						<td colspan="2">
							<input class="inputA" id="assistUnit1" name="tprojectInfoB.assistUnit1" type="text"
							 	value="<s:property value='%{tprojectInfoB.assistUnit1}' escape='true'/>"
							 	maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'项目主要协作单位',0,-1);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddenassistUnit" name="hidden" value="项目主要协作单位,0,-1"></s:hidden>
						</td>
						<td colspan="3" align="center">
							<INPUT class="txt w184p Wdate" type="text" id="startId"  name="startTime" 
								style="width:10em;"
								onClick="WdatePicker({dateFmt:'yyyy-MM'})" readonly="readonly"
								value="<s:property value='%{getText("{0,date,yyyy-MM}",{tprojectApplication.startTime})}' escape='true'/>"
								onblur="upms.upmsUtils.checkStartAndEndDate('startId','endId',1,'起止年限',this,3);"
								onfocus="upms.upmsUtils.textFocus(this);"
								/> 
							<s:hidden id="hiddenstartId" name="hidden" value="起止年限开始时间,1,-1"></s:hidden>
							至 
							<INPUT class="txt w184p Wdate" type="text" id="endId"  name="endTime"
								style="width:10em;"
								onClick="WdatePicker({dateFmt:'yyyy-MM'})" readonly="readonly"
								value="<s:property value='%{getText("{0,date,yyyy-MM}",{tprojectApplication.endTime})}' escape='true'/>"
								onblur="upms.upmsUtils.checkStartAndEndDate('startId','endId',1,'起止年限',this,3);"
								onfocus="upms.upmsUtils.textFocus(this);"
								/>
							<s:hidden id="hiddenstartId" name="hidden" value="起止年限开始时间,1,-1"></s:hidden>
						    <s:hidden id="startTime" name="tprojectApplication.startTime"></s:hidden>
						    <s:hidden id="endTime" name="tprojectApplication.endTime"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>项目分类
						</td>
						<td colspan="5">
							<input class="inputA" id="projectTypeName" name="projectTypeName" type="text"
								value="<s:property value='%{tprojectApplication.planFlagName}' escape='true'/>-<s:property value='%{tprojectApplication.typeName}' escape='true'/>"
								disabled="disabled"
								/>
						</td>
					</tr>
					<!-- Start 2013/09/29 业务变更 wanglw -->
					<%-- <tr>
						<td align="right">
							<FONT color=red>*</FONT>单位所属行业领域
						</td>
						<td colspan="5">
							<s:select style="width:14em;" list="technicalFisldList" label="abc" 
									listKey="itemId"
									listValue="itemName" id="technicalFisld" 
									name="tprojectInfoB.technicalFisld"
									>
							</s:select>
							<s:hidden id="technicalFisldValue" name="technicalFisldValue" 
									value="%{tprojectInfoB.technicalFisld}"></s:hidden>
							<s:hidden id="hiddentechnicalFisld" name="hidden" value="单位所属行业领域"></s:hidden>
						</td>
					</tr> --%>
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>项目所属技术领域
						</td>
						<td colspan="5">
							<div>
								<s:select style="width:12em;" list="technicalFisldList1" label="abc" listKey="itemId" listValue="itemName" id="technicalFisld1" name="tprojectInfoB.technicalFisld1" value="%{tprojectInfoB.technicalFisld1}"></s:select>
								<s:select style="width:12em;" list="technicalFisldList2" label="abc" listKey="itemId" listValue="itemName" id="technicalFisld2" name="tprojectInfoB.technicalFisld2" value="%{tprojectInfoB.technicalFisld2}"></s:select>
								<s:select style="width:12em;" list="technicalFisldList3" label="abc" listKey="itemId" listValue="itemName" id="technicalFisld3" name="tprojectInfoB.technicalFisld3" value="%{tprojectInfoB.technicalFisld3}"></s:select>
							</div>
							<s:hidden id="hiddentechnicalFisld3" name="hidden" value="项目所属技术领域"></s:hidden>	 
							<s:hidden id="technicalFisld1Value" name="technicalFisld1" value="%{tprojectInfoB.technicalFisld1}"></s:hidden>		
							<s:hidden id="technicalFisld2Value" name="technicalFisld2" value="%{tprojectInfoB.technicalFisld2}"></s:hidden>		
							<s:hidden id="technicalFisld3Value" name="technicalFisld3" value="%{tprojectInfoB.technicalFisld3}"></s:hidden>		
					</tr>
					<!-- End 2013/09/29 业务变更 wanglw -->
					<tr>
						<td rowspan="3" align="right">
							企业资产与<br />
							经营状况<br />
							（万元）
						</td>
						<td align="right">
							<FONT color=red>*</FONT>流动资金
						</td>
						<td>
							<input class="inputA" id="circulatingFund" name="tprojectInfoB.circulatingFund" type="text"
								style="width:10em;"
								value="<s:property value='%{tprojectInfoB.circulatingFund}' escape='true'/>"
								maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'流动资金',1,2);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
								/>
							<s:hidden id="hiddencirculatingFund" name="hidden" value="流动资金,1,2"></s:hidden>
						</td>
						<td align="right">
							<FONT color=red>*</FONT>固定资产
						</td>
						<td colspan="2">
							<input class="inputA" id="fastenFund" name="tprojectInfoB.fastenFund" type="text"
								style="width:10em;"
								value="<s:property value='%{tprojectInfoB.fastenFund}' escape='true'/>"
								maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'固定资产',1,2);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
								/>
							<s:hidden id="hiddenfastenFund" name="hidden" value="固定资产,1,2"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>总销售收入/上年度
						</td>
						<td>
							<input class="inputA" id="totalValue" name="tprojectInfoB.totalValue" type="text"
								style="width:10em;"
								value="<s:property value='%{tprojectInfoB.totalValue}' escape='true'/>"
								maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'总销售收入/上年度',1,-1);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
								/>
							<s:hidden id="hiddentotalValue" name="hidden" value="总销售收入/上年度,1,2"></s:hidden>
						</td>
						<td align="right">
							<FONT color=red>*</FONT>上年度资产负债率%
						</td>
						<td colspan="2">
							<input class="inputA" id="debtRatio" name="tprojectInfoB.debtRatio" type="text"
								style="width:10em;"
								value="<s:property value='%{tprojectInfoB.debtRatio}' escape='true'/>"
								maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'上年度资产负债率',1,5);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
								/>
							<s:hidden id="hiddendebtRatio" name="hidden" value="上年度资产负债率,1,5"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>总收入/上年度
						</td>
						<td> 
							<input class="inputA" id="grossIncome" name="tprojectInfoB.grossIncome" type="text"
								style="width:10em;"
								value="<s:property value='%{tprojectInfoB.grossIncome}' escape='true'/>"
								maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'总收入/上年度',1,2);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
								/>
							<s:hidden id="hiddengrossIncome" name="hidden" value="总收入/上年度,1,2"></s:hidden>
						</td>
						<td align="right">
							<FONT color=red>*</FONT>利税/上年度
						</td>
						<td colspan="2">
							<input class="inputA" id="retainedProfits" name="tprojectInfoB.retainedProfits" type="text"
								style="width:10em;"
								value="<s:property value='%{tprojectInfoB.retainedProfits}' escape='true'/>"
								maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'利税/上年度',1,2);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
								/>
							<s:hidden id="hiddenretainedProfits" name="hidden" value="利税/上年度,1,2"></s:hidden>
						</td>
					</tr>
					<tr>
						<td rowspan="3" align="right">资金投入情况<br />（万元）</td>
						<td align="right">
							<FONT color=red>*</FONT>总投入
						</td>
						<td>
							<input class="inputA" id="investmentTotal" name="tprojectInfoB.investmentTotal" type="text"
								style="width:10em;"
								value="<s:property value='%{tprojectInfoB.investmentTotal}' escape='true'/>"
								maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'总投入',1,2);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
								/>
							<s:hidden id="hiddeninvestmentTotal" name="hidden" value="总投入,1,2"></s:hidden>
						</td>
						<td align="right">
							<FONT color=red>*</FONT>申请科技经费
						</td>
						<td colspan="2">
							<input class="inputA" id="specialFunds" name="tprojectInfoB.specialFunds" type="text"
								style="width:10em;"
								value="<s:property value='%{tprojectInfoB.specialFunds}' escape='true'/>"
								maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'申请科技经费',1,2);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
								/>
							<s:hidden id="hiddenspecialFunds" name="hidden" value="申请科技经费,1,2"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>自筹
						</td>
						<td>
							<input class="inputA" id="selfFinancing" name="tprojectInfoB.selfFinancing" type="text"
								style="width:10em;"
								value="<s:property value='%{tprojectInfoB.selfFinancing}' escape='true'/>"
								maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'自筹',1,2);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
								/>
							<s:hidden id="hiddenselfFinancing" name="hidden" value="自筹,1,2"></s:hidden>
						</td>
						<td align="right">
							<FONT color=red>*</FONT>其他</td>
						<td colspan="2">
							<input class="inputA" id="other" name="tprojectInfoB.other" type="text"
								style="width:10em;"
								value="<s:property value='%{tprojectInfoB.other}' escape='true'/>"
								maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'其他',1,2);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
								/>
							<s:hidden id="hiddenother" name="hidden" value="其他,1,2"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>贷款
						</td>
						<td colspan="4">
							<input class="inputA" id="credit" name="tprojectInfoB.credit" type="text"
								style="width:10em;"
								value="<s:property value='%{tprojectInfoB.credit}' escape='true'/>"
								maxlength="6" onblur="upms.upmsUtils.blurTextCheck(this,'贷款',1,2);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
								/>
						</td>
						<s:hidden id="hiddencredit" name="hidden" value="贷款,1,2"></s:hidden>
					</tr>
					<!-- Start 2013/09/29  业务变更 wanglw -->
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>开户银行
						</td>
						<td colspan="2"> 
							<input class="inputA" id="accountBank" name="tprojectInfoB.accountBank" type="text"
								style="width:16.5em;"
								value="<s:property value='%{tprojectInfoB.accountBank}' escape='true'/>"
								maxlength="12" onblur="upms.upmsUtils.blurTextCheck(this,'开户银行',0,-1);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								readFlag="1"/>
							<s:hidden id="hiddenaccountBank" name="hidden" value="开户银行,0,-1"></s:hidden>
						</td>
						<td align="right">
							<FONT color=red>*</FONT>开户银行号
						</td>
						<td colspan="2">
							<input class="inputA" id="accountBankNo" name="tprojectInfoB.accountBankNo" type="text"
								style="width:16.5em;"
								value="<s:property value='%{tprojectInfoB.accountBankNo}' escape='true'/>"
								maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'开户银行号',0,-1);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								onkeypress="return upms.upmsUtils.isNum(event,this)"
								readFlag="1"/>
							<s:hidden id="hiddenaccountBankNo" name="hidden" value="开户银行号,0,-1"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>开户名称
						</td>
						<td colspan="2"> 
							<input class="inputA" id="accountName" name="tprojectInfoB.accountName" type="text"
								style="width:16.5em;"
								value="<s:property value='%{tprojectInfoB.accountName}' escape='true'/>"
								maxlength="5" onblur="upms.upmsUtils.blurTextCheck(this,'开户名称',0,-1);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
								readFlag="1"/>
							<s:hidden id="hiddenaccountName" name="hidden" value="开户名称,0,-1"></s:hidden>
						</td>
						<td align="right">
							<FONT color=red>*</FONT>银行账号
						</td>
						<td colspan="2">
							<input class="inputA" id="bankNo" name="tprojectInfoB.bankNo" type="text"
								style="width:16.5em;"
								value="<s:property value='%{tprojectInfoB.bankNo}' escape='true'/>"
								maxlength="20" onblur="upms.upmsUtils.blurTextCheck(this,'银行账号',0,-1);" 
								onfocus="upms.upmsUtils.textFocus(this);"
								onkeypress="return upms.upmsUtils.isFloatNum(event,this)"
								readFlag="1"/>
							<s:hidden id="hiddenbankNo" name="hidden" value="银行账号,0,-1"></s:hidden>
						</td>
					</tr>
					<!-- End 2013/09/29  业务变更 wanglw -->
					<tr>
						<td align="right">
							<FONT color=red>*</FONT>知识产权状况
						</td>
						<td colspan="2">
							<s:select style="width:17em;" list="intellectualPropertyList" label="abc" 
									listKey="itemId"
									listValue="itemName" id="intellectualProperty" 
									name="tprojectInfoB.intellectualProperty"
									>
							</s:select>
							<s:hidden id="intellectualPropertyValue" name="intellectualPropertyValue" 
									value="%{tprojectInfoB.intellectualProperty}"></s:hidden>
							<s:hidden id="hiddenintellectualProperty" name="hidden" value="知识产权状况"></s:hidden>
						</td>
						<td align="right">
							<FONT color=red>*</FONT>技术来源
						</td>
						<td colspan="2">
							<s:select style="width:17em;" list="technologySourceList" label="abc" 
									listKey="itemId"
									listValue="itemName" id="technologySource" 
									name="tprojectInfoB.technologySource"
									>
							</s:select>
							<s:hidden id="technologySourceValue" name="technologySourceValue" 
									value="%{tprojectInfoB.technologySource}"></s:hidden>
							<s:hidden id="hiddentechnologySource" name="hidden" value="技术来源"></s:hidden>
						</td>
					</tr>
				
				</table>
				<div align="center" style="width: 100%">
						<br> <br>
						<input id="nextBtn" type="button" class="button save" href="javascript: void(0);" value="下一步"/>
				</div>
			</div>
		</div>	
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/query/js/project_search.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
  <div style="text-align: left;">
    <div class="Servicel04">
      <div class="abuot02">
        <div class="abuot07">项目查询</div>
        <div>
          <form id="searchForm">
            <table style="width:100%">
              <tr>
                <td width="11%" style="padding: 4px 3px; text-align:right">项目名称</td>
				<td colspan="5" style="padding: 4px 8px; text-align: left">
					<input class="inputA" type="text" style="width: 14.5em;" id="projectName" name="tprojectApplication.projectName" value="<s:property value='%{tprojectApplication.projectName}' escape='true'/>"
	              	maxlength="20" onfocus="upms.upmsUtils.textFocus(this);" />
				</td>
              </tr>
              <tr>
              	<td width="11%" style="padding: 4px 3px; text-align:right">承担单位</td>
				<td style="padding: 4px 8px; text-align: left">
				<input class="inputA" type="text" style="width: 14.5em;" id="applicationUnit" name="tprojectApplication.applicationUnit" value="<s:property value='%{tprojectApplication.applicationUnit}' escape='true'/>"
	              	maxlength="20" onfocus="upms.upmsUtils.textFocus(this);" />
				</td>
              	<td width="11%" style="padding: 4px 3px; text-align:right">单位地址</td>
				<td style="padding: 4px 8px; text-align: left">
					<input class="inputA" type="text" style="width: 14.5em;" id="unitAddress" name="tprojectInfoa.unitAddress" value="<s:property value='%{tprojectInfoa.unitAddress}' escape='true'/>"
	              	maxlength="20" onfocus="upms.upmsUtils.textFocus(this);" />
				</td>
			  </tr>
              <tr>
              	<td width="11%" style="padding: 4px 3px; text-align:right">申报年度</td>
				<td style="padding: 4px 8px; text-align: left">
					<input class="txt w184p Wdate" type="text" id="reportYear" name="tprojectApplication.reportYear" value="<s:property value='%{getText("{0,date,yyyy}",{tprojectApplication.reportYear})}' />" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy'})"
				    onblur="upms.upmsUtils.blurTextCheck(this,'申报年度',0,-1);" onfocus="upms.upmsUtils.textFocus(this);"/>
				</td>
				<td width="11%" style="padding: 4px 3px; text-align:right">项目主要协作单位</td>
	            <td colspan="3" style="padding: 4px 8px; text-align: left">
	              	<input class="inputA" id="assistUnit" name="tprojectInfoa.assistUnit" type="text" style="width: 14.5em;"
	              	value="<s:property value='%{tprojectInfoa.assistUnit}' escape='true'/>"
	              	maxlength="20" onfocus="upms.upmsUtils.textFocus(this);"/>
	            </td>
			  </tr>
			  <tr>
				<td width="11%" style="padding: 4px 3px; text-align:right">归口管理部门</td>
				<td style="padding: 4px 8px; text-align: left">
			 		<s:select style="width:12em;" list="centralizedTypeList" label="abc" listKey="itemId"
						listValue="itemName" id="centralizedType" name="tprojectApplication.centralizedType" 
						value="%{tprojectApplication.centralizedType}" onblur="upms.upmsUtils.blurTextCheck(this,'归口管理部门');" onfocus="upms.upmsUtils.textFocus(this);"></s:select>
						<s:hidden id="centralizedTypeValue" value="%{tprojectApplication.centralizedType}"></s:hidden>
				</td><s:hidden id="hiddencentralizedType" name="hidden" value="归口管理部门"></s:hidden>
				<td width="11%" style="padding: 4px 3px; text-align:right">单位性质</td>
				<td colspan="3" style="padding: 4px 8px; text-align: left">
					<s:select style="width:12em;" list="unitPropertiesList" label="abc" listKey="itemId"
						listValue="itemName" id="unitProperties" name="tprojectInfoa.unitProperties" 
						value="%{tprojectInfoa.unitProperties}" onblur="upms.upmsUtils.blurTextCheck(this,'单位性质');" onfocus="upms.upmsUtils.textFocus(this);"></s:select>
						<s:hidden id="unitPropertiesValue" value="%{tprojectInfoa.unitProperties}"></s:hidden>
				</td><s:hidden id="hiddenunitProperties" name="hidden" value="单位性质"></s:hidden>
			  </tr>
			  <tr>
                <td width="11%" style="padding: 4px 3px; text-align:right">单位所属行业领域</td>
				<td style="padding: 4px 8px; text-align: left">
					<s:select style="width:12em;" list="technicalFisldList" label="abc" listKey="itemId"
						listValue="itemName" id="technicalFisld" name="tprojectInfoa.technicalFisld3" 
						value="%{tprojectInfoa.technicalFisld3}" onblur="upms.upmsUtils.blurTextCheck(this,'单位所属行业领域');" onfocus="upms.upmsUtils.textFocus(this);"></s:select>
						<s:hidden id="technicalFisldValue" value="%{tprojectInfoa.technicalFisld3}"></s:hidden>
				</td><s:hidden id="hiddentechnicalFisld" name="hidden" value="单位所属行业领域"></s:hidden>
                <td width="11%" style="padding: 4px 3px; text-align:right"> 知识产权状况&nbsp;</td>
                <td colspan="3" style="padding: 4px 8px; text-align:left">
                	<s:select style="width:12em;" list="intellectualPropertyList" label="abc" listKey="itemId"
						listValue="itemName" id="intellectualProperty" name="tprojectInfoa.intellectualProperty" 
						value="%{tprojectInfoa.intellectualProperty}" onblur="upms.upmsUtils.blurTextCheck(this,'知识产权状况');" onfocus="upms.upmsUtils.textFocus(this);"></s:select>
						<s:hidden id="intellectualPropertyValue" value="%{tprojectInfoa.intellectualProperty}"></s:hidden>
				</td><s:hidden id="hiddenintellectualProperty" name="hidden" value="知识产权状况"></s:hidden>
              </tr>
              <tr>
              	<td width="11%" style="padding: 4px 3px; text-align:right">项目分类</td>
				<td style="padding: 4px 8px; text-align: left">
					<div>
					<s:if test="%{planningFlag == 1}">
					<s:select style="width:12em;" list="typeId1List" label="abc" listKey="deptId"
					listValue="deptName" id="typeId1" name="typeId1" value="%{typeId1}"></s:select>
					</s:if>
					<s:select style="width:12em;" list="typeId2List" label="abc" listKey="typeId"
					listValue="typeShowName" id="typeId2" name="typeId2" value="%{typeId2}"></s:select>
					<s:select style="width:12em;" list="typeId3List" label="abc" listKey="typeId"
					listValue="typeShowName" id="typeId3" name="typeId3" value="%{typeId3}"></s:select>
					</div>
					<s:hidden id="hiddentypeId3" name="hidden" value="项目分类级联"></s:hidden>
					<s:hidden id="planningFlag" name="planningFlag" value="%{planningFlag}"></s:hidden>
					<s:hidden id="typeId1Value" name="typeId1Value" value="%{typeId1}"></s:hidden>
					<s:hidden id="typeId2Value" name="typeId2Value" value="%{typeId2}"></s:hidden>
					<s:hidden id="typeId3Value" name="typeId3Value" value="%{typeId3}"></s:hidden>
				</td>
				<td width="11%" style="padding: 4px 3px; text-align:right"> 技术来源&nbsp;</td>
                <td colspan="3" style="padding: 4px 8px; text-align:left">
					<s:select style="width:12em;" list="technologySourceList" label="abc" listKey="itemId"
						listValue="itemName" id="technologySource" name="tprojectInfoa.technologySource" 
						value="%{tprojectInfoa.technologySource}" onblur="upms.upmsUtils.blurTextCheck(this,'技术来源');" onfocus="upms.upmsUtils.textFocus(this);"></s:select>
						<s:hidden id="technologySourceValue" value="%{tprojectInfoa.technologySource}"></s:hidden>
				</td><s:hidden id="hiddentechnologySource" name="hidden" value="技术来源"></s:hidden>
			  </tr>
              <tr>
              	<td width="11%" style="padding: 4px 3px; text-align:right">所在区域</td>
				<td colspan="5" style="padding: 4px 8px; text-align: left">
					<div><s:select style="width:12em;" list="regionId1List" label="abc" listKey="itemId"
					listValue="itemName" id="regionId1" name="tprojectInfoa.regionId1" 
					value="%{tprojectInfoa.regionId1}"></s:select>
					<s:select style="width:12em;" list="regionId2List" label="abc" listKey="itemId"
					listValue="itemName" id="regionId2" name="tprojectInfoa.regionId2" value="%{tprojectInfoa.regionId2}"></s:select>
					<s:select style="width:12em;" list="regionId3List" label="abc" listKey="itemId"
					listValue="itemName" id="regionId3" name="tprojectInfoa.regionId3" value="%{tprojectInfoa.regionId3}"></s:select>
					</div>
					<s:hidden id="hiddenregionId3" name="hidden" value="所在区域级联"></s:hidden>	 
					<s:hidden id="regionId1Value" name="regionId1" value="%{tprojectInfoa.regionId1}"></s:hidden>
					<s:hidden id="regionId2Value" name="regionId2" value="%{tprojectInfoa.regionId2}"></s:hidden>
					<s:hidden id="regionId3Value" name="regionId3" value="%{tprojectInfoa.regionId3}"></s:hidden>
				</td>
			  </tr>
              <tr>
                <td width="11%" style="padding: 4px 3px; text-align:right">国民经济行业分类</td>
				<td colspan="5" style="padding: 4px 8px; text-align: left">
					<div><s:select style="width:12em;" list="industries1List" label="abc" listKey="itemId"
					listValue="itemName" id="industries1" name="tprojectInfoa.industries1" 
					value="%{tprojectInfoa.industries1}"></s:select>
					<s:select style="width:12em;" list="industries2List" label="abc" listKey="itemId"
					listValue="itemName" id="industries2" name="tprojectInfoa.industries2" value="%{tprojectInfoa.industries2}"></s:select>
					<s:select style="width:12em;" list="industries3List" label="abc" listKey="itemId"
					listValue="itemName" id="industries3" name="tprojectInfoa.industries3" value="%{tprojectInfoa.industries3}"></s:select>
					<s:select style="width:12em;" list="industries4List" label="abc" listKey="itemId"
					listValue="itemName" id="industries4" name="tprojectInfoa.industries4" value="%{tprojectInfoa.industries4}"></s:select>
					</div>
					<s:hidden id="hiddenindustries4" name="hidden" value="国民经济行业分类级联"></s:hidden>	 
					<s:hidden id="industries1Value" name="industries1" value="%{tprojectInfoa.industries1}"></s:hidden>
					<s:hidden id="industries2Value" name="industries2" value="%{tprojectInfoa.industries2}"></s:hidden>
					<s:hidden id="industries3Value" name="industries3" value="%{tprojectInfoa.industries3}"></s:hidden>
					<s:hidden id="industries4Value" name="industries4" value="%{tprojectInfoa.industries4}"></s:hidden>
				</td>
              </tr>
              <tr>
	              <td align="right" colspan="6" style="text-align:right;padding:2px;width:10%">
	              <tag:auth code="tppass.query.projectSearch">
	                  <input class="button" type="button" id="queryBtn" name="queryBtn" href="javascript: void(0);" value="查询" />
	              </tag:auth>
	              </td>
              </tr>
            </table>
          </form>
        </div>
        <div>&nbsp; </div>
    <!-- 查询结果列表S -->
        <div id="resultDiv"></div>
	<!-- 查询结果列表E -->
      </div>
    </div>
  </div>
</div>

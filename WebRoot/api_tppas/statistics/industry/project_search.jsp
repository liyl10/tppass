<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/statistics/industry/js/project_search.js"></script>
<s:hidden id="planningFlag" name="planningFlag" value="%{planningFlag}"></s:hidden>
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
                <td style="padding: 4px 8px; text-align: left">
				<input class="inputA" type="text" style="width: 14.5em;" id="projectName" name="projectName"
	              	maxlength="20"/>
				</td>
				<td width="11%" style="padding: 4px 3px; text-align:right">单位地址</td>
				<td style="padding: 4px 8px; text-align: left" colspan="3">
					<input class="inputA" type="text" style="width: 14.5em;" id="unitAddress" name="unitAddress"
	              	maxlength="20"/>
				</td>
              </tr>
              <tr>
              	<td width="11%" style="padding: 4px 3px; text-align:right">承担单位</td>
				<td style="padding: 4px 8px; text-align: left">
				<input class="inputA" type="text" style="width: 14.5em;" id="applicationUnit" name="applicationUnit"
	              	maxlength="20" />
				</td>
              	<td width="11%" style="padding: 4px 3px; text-align:right">项目主要协作单位</td>
	            <td colspan="3" style="padding: 4px 8px; text-align: left">
	              	<input class="inputA" id="assistUnit" name="assistUnit" type="text" style="width: 14.5em;"
	              	maxlength="20"/>
	            </td>
			  </tr>
              <tr>
              	<td width="11%" style="padding: 4px 3px; text-align:right">申报年度</td>
				<td style="padding: 4px 8px; text-align: left">
					<input class="txt w184p Wdate" type="text" id="reportYear" name="reportYear" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy'})"
				    />
				</td>
				<td width="11%" style="padding: 4px 3px; text-align:right">单位性质</td>
				<td colspan="3" style="padding: 4px 8px; text-align: left">
					<s:select style="width:12em;" list="unitPropertiesList" label="abc" listKey="itemId"
						listValue="itemName" id="unitProperties" name="unitProperties"></s:select>
				</td>
			  </tr>
			  <tr>	
				<td width="11%" style="padding: 4px 3px; text-align:right">归口管理部门</td>
				<td style="padding: 4px 8px; text-align: left">
			 		<s:select style="width:12em;" list="centralizedTypeList" label="abc" listKey="itemId"
						listValue="itemName" id="centralizedType" name="centralizedType" ></s:select>
				</td>
				<td width="11%" style="padding: 4px 3px; text-align:right"> 知识产权状况&nbsp;</td>
                <td colspan="3" style="padding: 4px 8px; text-align:left">
                	<s:select style="width:12em;" list="intellectualPropertyList" label="abc" listKey="itemId"
						listValue="itemName" id="intellectualProperty" name="intellectualProperty" 
						></s:select>
				</td>
			  </tr>
			  <tr>
			  	<td width="11%" style="padding: 4px 3px; text-align:right">所在区域</td>
				<td style="padding: 4px 8px; text-align: left">
					<div><s:select style="width:12em;" list="regionId1List" label="abc" listKey="itemId"
					listValue="itemName" id="regionId1" name="regionId1"></s:select>
					<s:select style="width:12em;" list="regionId2List" label="abc" listKey="itemId"
					listValue="itemName" id="regionId2" name="regionId2"></s:select>
					<s:select style="width:12em;" list="regionId3List" label="abc" listKey="itemId"
					listValue="itemName" id="regionId3" name="regionId3"></s:select>
					</div>
					<s:hidden id="regionId1Value" name="hidden" value="%{regionId1}"></s:hidden>
					<s:hidden id="regionId2Value" name="hidden" value="%{regionId2}"></s:hidden>
				</td>
                
                <td width="11%" style="padding: 4px 3px; text-align:right"> 技术来源&nbsp;</td>
                <td colspan="3" style="padding: 4px 8px; text-align:left">
					<s:select style="width:12em;" list="technologySourceList" label="abc" listKey="itemId"
						listValue="itemName" id="technologySource" name="technologySource" 
						></s:select>
				</td>
              </tr>
              <tr>
              	<td width="11%" style="padding: 4px 3px; text-align:right">项目所属技术领域</td>
				<td style="padding: 4px 8px; text-align: left" colspan="5">
					<s:select style="width:12em;" list="technicalFisldList1" label="abc" listKey="itemId"
						listValue="itemName" id="technicalFisld1" name="technicalFisld1" 
						></s:select>
					<s:select style="width:12em;" list="technicalFisldList2" label="abc" listKey="itemId"
						listValue="itemName" id="technicalFisld2" name="technicalFisld2" 
						></s:select>
					<s:select style="width:12em;" list="technicalFisldList3" label="abc" listKey="itemId"
						listValue="itemName" id="technicalFisld3" name="technicalFisld3" 
						></s:select>
				</td>
			  </tr>
              <tr>
                <td width="11%" style="padding: 4px 3px; text-align:right">单位所属行业领域</td>
				<td colspan="5" style="padding: 4px 8px; text-align: left">
					<div><s:select style="width:12em;" list="industries1List" label="abc" listKey="itemId"
					listValue="itemName" id="industries1" name="industries1"></s:select>
					<s:select style="width:12em;" list="industries2List" label="abc" listKey="itemId"
					listValue="itemName" id="industries2" name="industries2"></s:select>
					<s:select style="width:12em;" list="industries3List" label="abc" listKey="itemId"
					listValue="itemName" id="industries3" name="industries3"></s:select>
					<s:select style="width:12em;" list="industries4List" label="abc" listKey="itemId"
					listValue="itemName" id="industries4" name="industries4"></s:select>
					</div>
				</td>
              </tr>
              <c:if test="${projecTypeManager==true}">
               <tr>
              	<td width="11%" style="padding: 4px 3px; text-align:right">项目分类</td>
				<td style="padding: 4px 8px; text-align: left" colspan="5">
					<div>
					<%-- <s:select style="width:12em;" list="typeId1List" label="abc" listKey="deptId"
					listValue="deptName" id="typeId1" name="typeId1"></s:select> --%>
					<s:select style="width:12em;" list="typeId2List" label="abc" listKey="typeId"
					listValue="typeShowName" id="typeId2" name="typeId2"></s:select>
					<s:select style="width:12em;" list="typeId3List" label="abc" listKey="typeId"
					listValue="typeShowName" id="typeId3" name="typeId3"></s:select>
					</div>
				</td>
			  </tr>
			  </c:if>
              <tr>
	              <td align="right" colspan="6" style="text-align:right;padding:2px;width:10%">
	              	  <input class="button" type="button" id="exportBtn" name="queryBtn" href="javascript: void(0);" value="导出" disabled="disabled"/>
	                  <input class="button" type="button" id="queryBtn" name="queryBtn" href="javascript: void(0);" value="查询" />
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

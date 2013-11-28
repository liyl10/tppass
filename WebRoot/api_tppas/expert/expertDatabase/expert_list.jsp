<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/expert/expertDatabase/js/expert_list.js"></script>
<!-- 删除按钮提示信息 -->
<label id="comfirmDel" style="display: none"><s:text name="confirm_del_info"/></label>	
<!--<div style="float: left;">
	<input class="button" type="button" id="queryBtn" href="javascript: void(0);" onclick="showDetail7();" value="发送账号和密码"/>
</div>
-->
<div style="margin-bottom:0px;text-align:right;">
<tag:auth code="ss.expert.add">
	<input type="button" class="button" onclick="saveExpert();" value="新增"/>&nbsp;
</tag:auth>
</div>
<table border=0 cellSpacing=0 cellPadding=0 width="100%" class="t-list" >
	<tr>
	  <!--<th width="5%"><s:checkbox name="" id="selectAll" onclick="selectAll();"></s:checkbox></th>-->
      <th width="10%">专家姓名</th>
	  <th width="13%">工作单位</th>
	  <th width="10%">擅长专业1</th>
	  <th width="10%">擅长专业2</th>
	  <th width="10%">擅长专业3</th>
	  <th width="10%">职务</th>
	  <th width="10%">学位</th>
      <th width="5%">是否在职</th>
	  <th width="5%">信誉等级</th>
	  <th width="17%">操作</th>
	</tr>
    <s:if test="pager.list.size > 0">
    	<s:iterator value="pager.list" id="expertor">
      		<tr align="middle">
      			<!--<td align="center"><input type="checkbox" id="${expertId}" value="${expertId}"/></td> -->
				<td align="left"><s:property value="%{expertName}" escape="true"/>&nbsp;</td>
				<td align="left"><s:property value="%{expertWork}" escape="true"/>&nbsp;</td>
				<td align="left"><s:property value="%{expertMajor1}" escape="true"/>&nbsp;</td>
				<td align="left"><s:property value="%{expertMajor2}" escape="true"/>&nbsp;</td>
				<td align="left"><s:property value="%{expertMajor3}" escape="true"/>&nbsp;</td>
				<td align="left"><s:property value="%{expertJob}" escape="true"/>&nbsp;</td>
				<td align="left"><s:property value="%{expertDegree}" escape="true"/>&nbsp;</td>
				<td align="left"><s:property value="%{expertIncumbency}" escape="true"/>&nbsp;</td>
				<td align="left"><s:property value="%{expertPrestige}" escape="true"/>&nbsp;</td>
				<td align="center">
					<!--<a href="javascript: void(0);" onClick="showDetai116()">查看账号和密码</a>&nbsp;  -->
					<tag:auth code="ss.expert.edit">
						<a href="javascript: void(0);" onClick="editExpert('${expertId}','1')">编辑</a>&nbsp;
					</tag:auth>
					<a href="javascript: void(0);" onClick="showExpert('${expertId}','0')">查看</a>&nbsp;
					<!--<a href="javascript: void(0);" onClick="showDetail2()">打分</a>&nbsp;-->
					<tag:auth code="ss.expert.delete">
						<a href="javascript: void(0);" onClick="delExpert('${expertId}')">删除</a>
					</tag:auth>
				</td>
      		</tr>
		</s:iterator>
    </s:if>
    <s:else>
		<tr>
			<td colspan="9">
				没有查到任何记录!&nbsp;
			</td>
		</tr>
	</s:else>
</table>
<s:if test="pager.list.size > 0">
<div class="page">
	<div class="pgtotal">
		共<em>${pager.totalCount}</em>条记录;
	</div>
	<div class="pgtotal">
		总共<em>${pager.pageCount}</em>页
	</div>
	<span> 跳转至第 <input type="text" id="goPageNo"
			name="goPageNo" style="width: 30px; height: 16px;"
			onkeyup='this.value=this.value.replace(/[^0-9]\D*$/,"")'
			autocomplete="off" /> 页 <input type="button" class="button"
			style="margin: -0.2em" value="确定" id="goBtn" name="goBtn" />
		</span> <span id="pgbtn"></span>
	<div class="clear"></div>
	<input type="hidden" id="pageNo" name="pager.pageNumber" value="${pager.pageNumber}" />
	<input type="hidden" id="totalRecords" name="pager.totalCount" value="${pager.totalCount}" />
	<input type="hidden" id="totalPages" name="pager.pageCount" value="${pager.pageCount}" />
</div>
</s:if>
			
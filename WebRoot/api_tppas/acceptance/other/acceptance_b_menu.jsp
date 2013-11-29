<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/other/js/acceptance_b_menu.js"></script>
<style>
.background{
	background-image:  url("${pageContext.request.contextPath}/server_tppas/images/bg_sub_list.gif") no-repeat 10px center;
	background-color: #e2f3fb;
}
</style>
<s:hidden id="acceptanceId" name="acceptanceId" value="%{acceptanceId}"></s:hidden>
<s:hidden id="acceptanceStatus" name="acceptanceStatus" value="%{acceptanceStatus}"></s:hidden>
<div class="leftNav">
	<div id=accordion class="accordion">
		<dl class="acc_nav">
			<dt id="subleftmenu" class="jingyin mainNav">项目验收管理</dt>
					<s:if test="menuList.size > 0">
						<s:iterator value="menuList" status="rowData">
							<dd class="subNav" id="subNav<s:property value='%{#rowData.count}' escape='true'/>">
								<a href="javascript: void(0);"
									onclick="showDetail('${acceptanceId}','${acceptanceStatus}','${itemDesc}')"><s:property value='%{itemName}' escape='true'/></a>
							</dd>
						</s:iterator>
					</s:if>	
	<%-- 			<dd class="subNav" id="subNav1">
						<a href="javascript: void(0);" onclick="showDetai1('${acceptanceId}','${acceptanceStatus }');">
						项目验收基本信息</a>
				</dd>
				<dd class="subNav" id="subNav2">
						<a href="javascript: void(0);" onclick="showDetai2('${acceptanceId}','${acceptanceStatus }');">
						项目经费落实和使用情况</a>
				</dd>
				<dd class="subNav" id="subNav3">
						<a href="javascript: void(0);" onclick="showDetai3('${acceptanceId}','${acceptanceStatus }');">
						项目取得成果情况</a>
				</dd>
				<dd class="subNav" id="subNav4">
						<a href="javascript: void(0);" onclick="showDetai4('${acceptanceId}','${acceptanceStatus }');">
						项目总结说明</a>
				</dd>
				<dd class="subNav" id="subNav5">
						<a href="javascript: void(0);" onclick="showDetai5('${acceptanceId}','${acceptanceStatus }');">
						附件清单</a>
				</dd>
				<dd class="subNav" id="subNav6">
						<a href="javascript: void(0);" onclick="showDetai6('${acceptanceId}','${acceptanceStatus }');">
						验收提交</a>
				</dd> --%>
		</dl>
	</div>
</div>
<s:hidden id="acceptanceId" name="acceptanceId" value="%{acceptanceId}"></s:hidden>
<s:hidden id="acceptanceStatus" name="acceptanceStatus" value="%{acceptanceStatus}"></s:hidden>
<!-- 项目根目录 -->
<label id="path" style="display: none">${pageContext.request.contextPath}</label>
<div id="content"></div>

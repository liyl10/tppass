<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/statistics/js/statistics_menu.js"></script>
<div class="leftNav">
	<div id=accordion class="accordion">
		<dl class="acc_nav">
			<dt id="subleftmenu" class="jingyin mainNav">统计管理</dt>
			<s:if test="menuList.size > 0">
				<s:iterator value="menuList" status="rowData">
					<dd class="subNav"
						id="subNav<s:property value='%{#rowData.count}' escape='true'/>">
						<a href="javascript: void(0);" onclick="showDetail('${itemDesc}')">
						<s:property value='%{itemName}' escape='true' /></a>
					</dd>
				</s:iterator>
			</s:if>
		</dl>
	</div>
</div>
<div id="content"></div>



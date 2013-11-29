<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/other/js/report_management_menu.js"></script>
<s:hidden id="projectIdTemp" name="projectIdTemp" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatusTemp" name="applyStatusTemp" value="%{applyStatus}"></s:hidden>
<div class="leftNav">
	<div id=accordion class="accordion">
		<dl class="acc_nav">
			<dt id="subleftmenu" class="jingyin mainNav">项目申报材料</dt>
			<s:if test="reportNonTechMenuList.size > 0">
				<s:iterator value="reportNonTechMenuList" status="rowData">
					<dd class="subNav" id="subNav<s:property value='%{#rowData.count}' escape='true'/>">
						<a href="javascript: void(0);"
							onclick="showDetail('${itemDesc}')"><s:property value='%{itemName}' escape='true'/></a>
					</dd>
				</s:iterator>
			</s:if>
		</dl>
	</div>
</div>
<div id="content"></div>
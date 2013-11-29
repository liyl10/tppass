<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/expert/expertManager/js/audit_other_menu.js"></script>
<div class="leftNav">
	<div id=accordion class="accordion">
		<dl class="acc_nav">
			<dt id="subleftmenu" class="jingyin mainNav">项目申报步骤</dt>
			<s:if test="menuList.size > 0">
				<s:iterator value="menuList" status="rowData">
					<dd class="subNav" id="subNav<s:property value='%{#rowData.count}' escape='true'/>">
						<a href="javascript: void(0);"
							onclick="showDetail('${projectId}','${applyStatus}','${itemDesc}')"><s:property value='%{itemName}' escape='true'/></a>
					</dd>
				</s:iterator>
				<dd class="subNav" id="subNav<s:property value='%{menuList.size()+1}'/>">
					<a href="javascript: void(0);" onclick="expertAudit('${projectId}','${applyStatus}');">
						专家评审
					</a>
				</dd>
			</s:if>
		</dl>
	</div>
</div>
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<s:hidden id="scoreId" name="scoreId" value="%{scoreId}"></s:hidden>
<div id="content"></div>
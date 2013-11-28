<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/contract/highTech/js/highTech_contract_menu.js"></script>
<s:hidden id="Flag" name="Flag" value="%{Flag}"></s:hidden>
<s:hidden id="tcontractId" name="tcontractId" value="%{tcontractId}"></s:hidden>
<s:hidden id="contractStatus" name="contractStatus" value="%{contractStatus}"></s:hidden>
<s:hidden id="modelType" name="modelType" value="%{modelType}"></s:hidden>
<div class="leftNav">
	<div id=accordion class="accordion">
		<dl class="acc_nav">
			<dt id="subleftmenu" class="jingyin mainNav">合同填报步骤</dt>
					<s:if test="menuList.size > 0">
						<s:iterator value="menuList" status="rowData">
							<dd class="subNav" id="subNav<s:property value='%{#rowData.count}' escape='true'/>">
								<a href="javascript: void(0);"
									onclick="showDetail('${Flag}','${tcontractId}','${itemDesc}')"><s:property value='%{itemName}' escape='true'/></a>
							</dd>
						</s:iterator>
					</s:if>
		</dl>
	</div>
</div>
<div id="content"></div>
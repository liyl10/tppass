<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/highTech/js/acceptance_a_menu.js"></script>
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
			<dt id="subleftmenu" class="jingyin mainNav">项目验收申请表填写</dt>
				<s:if test="menuList.size > 0">
					<s:iterator value="menuList" status="rowData">
						<dd class="subNav" id="subNav<s:property value='%{#rowData.count}' escape='true'/>">
							<a href="javascript: void(0);"
								onclick="showDetail('${acceptanceId}','${acceptanceStatus}','${itemDesc}')"><s:property value='%{itemName}' escape='true'/></a>
						</dd>
					</s:iterator>
				</s:if>
				<!--
					<dd class="subNav" id="subNav1">
						<a href="javascript: void(0);" onclick="showDetail1()">项目验收申请表封皮</a>
					</dd>
					<dd class="subNav" id="subNav2">
						<a href="javascript: void(0);" onclick="showDetail2()">项目经费落实和使用情况</a>
					</dd>
					<dd class="subNav" id="subNav3">
						<a href="javascript: void(0);" onclick="showDetail3()">对照合同项目任务完成情况</a>
					</dd>
					<dd class="subNav" id="subNav4">
						<a href="javascript: void(0);" onclick="showDetail4()">企业获得资金支持情况</a>
					</dd>
					<dd class="subNav" id="subNav5">
						<a href="javascript: void(0);" onclick="showDetail5()">企业发展情况</a>
					</dd>
					<dd class="subNav" id="subNav6">
						<a href="javascript: void(0);" onclick="showDetail6()">验收意见</a>
					</dd>
					<dd class="subNav" id="subNav7">
						<a href="javascript: void(0);" onclick="showDetail7()">单位意见</a>
					</dd>
					<dd class="subNav" id="subNav8">
						<a href="javascript: void(0);" onclick="showDetail8()">项目主要参加人员名单</a>
					</dd>
					<dd class="subNav" id="subNav9">
						<a href="javascript: void(0);" onclick="showDetail9()">验收小组名单</a>
					</dd>
					<dd class="subNav" id="subNav10">
						<a href="javascript: void(0);" onclick="showDetail10()">项目验收经费登记表</a>
					</dd>
					<dd class="subNav" id="subNav11">
						<a href="javascript: void(0);" onclick="showDetail11()">附件清单</a>
					</dd>
					<dd class="subNav" id="subNav12">
						<a href="javascript: void(0);" onclick="showDetail12()">项目验收提交</a>
					</dd>
				-->
		</dl>
	</div>
</div>
<div id="content"></div>

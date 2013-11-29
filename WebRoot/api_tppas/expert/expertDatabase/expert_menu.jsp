<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/expert/expertDatabase/js/expert_menu.js"></script>
<s:hidden id="expertId" name="expertId" value="%{expertId}"></s:hidden>
<s:hidden id="isEdit" name="isEdit" value="%{isEdit}"></s:hidden>
<div class="leftNav">
	<div id=accordion class="accordion">
		<dl class="acc_nav">
			<dt id="subleftmenu" class="jingyin mainNav">专家管理</dt>
				<dd class="subNav"  id="subNav1">
					<a href="javascript: void(0);" onclick="showInfo('${expertId}','${isEdit}')">基本信息</a>
				</dd>
				<dd class="subNav"  id="subNav2">
					<a href="javascript: void(0);" onclick="showJsyjcg('${expertId}','${isEdit}')">专业技术研究成果</a>
				</dd>
		</dl>
	</div>
</div>
<div id="content"></div>
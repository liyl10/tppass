<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>

<s:if test="key==1">
	<link rel=stylesheet type=text/css href="http://xmkadmin1.xatrm.com/api_tppas/css/style.css">
	<link rel=stylesheet type=text/css href="http://xmkadmin1.xatrm.com/api_tppas/css/layout.css">
	<link rel="stylesheet" type="text/css" media="all" href="http://xmkadmin1.xatrm.com/api_tppas/css/chosen.css" />
	<link rel="stylesheet" type="text/css" media="all" href="http://xmkadmin1.xatrm.com/api_tppas/css/btn.css" />
</s:if>
<s:else>
	<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/style.css">
	<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/layout.css">
	<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/chosen.css" />
	<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/btn.css" />
</s:else>

<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/install_upms.js?ver=1.0.0"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/chosen.jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/audit/js/select_audit_expert_list.js"></script>
<s:hidden id="selectedId" name="selectedId"></s:hidden>
<div style="border-bottom: 1px dashed #C9DEEE;"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
		<tr align="center">
			<th width="5%"><s:checkbox name="" id="selectAll" onclick="selectAll();"></s:checkbox></th>
		    <th width="15%">专家姓名</th>
		    <th width="16%">擅长专业1</th>
		    <th width="16%">擅长专业2</th>
		    <th width="16%">擅长专业3</th>
		    <th width="19%">工作单位</th>
		    <th width="8%">专家类型</th>
		    <th width="5%">信誉度</th>	
		</tr>
		<s:if test="exList.size > 0">
			<s:iterator value="exList" status="rowData">
				<tr>
					<td align="center" style="height: 30px;">
						<s:if test="key==1">
							<input type="checkbox" value='{"expertId":"${expertId}","expertName":"${expertName}"}' onclick="saveOrDelSelect(this);"/>
						</s:if>
						<s:else>
							<input type="checkbox" value="${expertId}" onclick="saveOrDelSelect(this);"/>
						</s:else>
					</td>
					<td>
						<s:property value="%{expertName}" escape="true"/>
					</td>
					<td>
						<s:property value="%{expertMajor1}" escape="true"/>
					</td>
					<td>
						<s:property value="%{expertMajor2}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{expertMajor3}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{expertWork}" escape="true"/>&nbsp;
					</td>
					<td>
						<s:property value="%{expertType}" escape="true"/>&nbsp;
						<%-- <s:property value='%{getText("{0,date,yyyy-MM-dd}",{registerTime})}' escape="true"/>&nbsp; --%>
					</td>
					<td align="center">
						<s:property value="%{expertPrestige}" escape="true"/>
					</td>
				</tr>
			</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<td colspan="8">
					没有查到任何记录!&nbsp;
				</td>
			</tr>
		</s:else>
	</table>
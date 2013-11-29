<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 快捷方式管理列表页面
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
 -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>快捷方式管理 - 列表</title>
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/api_scenter/js/jquery-1.4.4.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/shortcut/js/shortcut_list.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 快捷方式管理 - 列表
			</div>
			<form class="ropt"></form>
			<div class="clear"></div>
		</div>
		<div class="right_boxtable">
			<div class="body-box">
				<div class="search_box">
					<div class="search_title">关键字搜索</div>
					<div class="search_con">
						<form action="${pageContext.request.contextPath}/api/shortcut_list.action" method="post" style="margin-bottom:5px;">
							<div style="search_box">
								<div>
								关键字：
								<input type="text" name="scShortcut.scAuth.authName" value="${scShortcut.scAuth.authName}" style="width: 70px" />
								<input type="hidden" name="pager.pageNumber" value="${pager.pageNumber}" />
								<input type="hidden" name="pager.pageSize" value="${pager.pageSize}" />
								<input type="submit" name="btn_query" value="查询" class="query" />
								</div>
							</div>
						</form>
					</div>
				</div>
				<form id="myform" name="form" method="post" action="${pageContext.request.contextPath}/api/shortcut_list.action">
				<input type="hidden" id="pageContext" name="pageContext" value="${pageContext.request.contextPath}" />
				<input type="hidden" name="redirectUrl" value="${pageContext.request.contextPath}/api/shortcut_list.action?scShortcut.scAuth.authName=${scShortcut.scAuth.authName}&pager.pageNumber=${pager.pageNumber}&pager.pageSize=${pager.pageSize}" />
				<div style="margin-top: 15px;">
					<tag:auth code="sc.shortcut.insert">
					<input type="button" name="insert_btn" value="添加" class="add" onclick="addShortcut();" />
					</tag:auth>
					<input type="button" name="seavr_order" id="seavr_order" value="保存排序" class="save-order" onclick="window.location.href='${pageContext.request.contextPath}/api/shortcut_list.action?scShortcut.scAuth.authName=${scShortcut.scAuth.authName}&pager.pageNumber=${pager.pageNumber}&pager.pageSize=${pager.pageSize}';" />
					<tag:auth code="sc.shortcut.delete">
					<input type="button" name="" value="删除" class="del-button" onclick="deleteClick();" />
					</tag:auth>
				</div><br />
				<table class="pn-ltable" style="" cellspacing="1" cellpadding="0" border="0">
					<thead class="pn-lthead">
						<tr>
							<th width="40">
								<input type='checkbox' name='checked' id='checked'/>
								<input type="hidden" id="checkedtype" name="checkedtype" value="0">
							</th>
							<th  >
								权限名称
							</th>
							<th width="100">
								排序
							</th>
							<th width="80">
								操作选项
							</th>
						</tr>
					</thead>
					<tbody class="pn-ltbody">
						<c:forEach items="${pager.list}" var="shortcut">
						<tr onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
							<td width="40">
								<input type='checkbox' name='ids' value='${shortcut.shorId}' />
							</td>
							<td class="td_left">
								${shortcut.scAuth.authName}
							</td>
							<td class="td_left">
								<input type="text" name="" value="${shortcut.shorOrder}" style="width: 70px" onchange="updateobj(this,'${shortcut.shorId}')" >
							</td>
							<td>
								<tag:auth code="sc.shortcut.delete">
								<a href="javascript:void(0);" onclick="deleteShortcut('${shortcut.shorId}');return false;" class="pn-opt">删除</a>
								</tag:auth>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<div style="margin-top: 15px;">
					<tag:auth code="sc.shortcut.insert">
					<input type="button" name="insert_btn" value="添加" class="add" onclick="addShortcut();" />
					</tag:auth>
					<input type="button" name="seavr_order" id="seavr_order" value="保存排序" class="save-order" onclick="window.location.href='${pageContext.request.contextPath}/api/shortcut_list.action?scShortcut.scAuth.authName=${scShortcut.scAuth.authName}&pager.pageNumber=${pager.pageNumber}&pager.pageSize=${pager.pageSize}';" />
					<tag:auth code="sc.shortcut.delete">
					<input type="button" name="" value="删除" class="del-button" onclick="deleteClick();" />
					</tag:auth>
				</div>
				<%@include file="/api_scenter/public/standard.jsp"%>
				</form>
			</div>
		</div>
	</body>
</html>
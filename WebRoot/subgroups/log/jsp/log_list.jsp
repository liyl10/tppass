<!-- 
@comment 日志列表页面
@author zzze
@date Dec 27, 2012
@version 1.0
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>日志管理</title>
	<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/subgroups/log/js/log.js"></script>
  </head>
  <body>
  <div class="right_boxtable">
  <form id="myform" method="post" action="${pageContext.request.contextPath }/api/log/log_list.action" >
  <input type="hidden" id="id" name="ucLogs.logId" />
  <input type="hidden" id="pageContext" name="pageContext" value="${pageContext.request.contextPath}" />
  <div class="search_box">
    <div>
	操作对象:
	<select name="ucLogs.logObj">
		<option value="">请选择操作对象</option>
		<c:forEach items="${logObj}" var="obj">
			<option value="${obj.desc}" ${ucLogs.logObj==obj.desc?"selected='selected'":"" } >${obj.desc}</option>
		</c:forEach>
	</select> 
	操作结果: 
	<select name="ucLogs.operaResult">
		<option value="">请选择操作结果</option>
		<c:forEach items="${operaResult}" var="result">
			<option value="${result.desc}" ${ucLogs.operaResult==result.desc?"selected='selected'":"" }>${result.desc}</option>
		</c:forEach>
	</select> 
	操作类型:
	<select name="ucLogs.logOpera">
		<option value="">请选择操作类型</option>
		<c:forEach items="${logOpera}" var="operaType">
			<option value="${operaType.desc}" ${ucLogs.logOpera==operaType.desc?"selected='selected'":"" }>${operaType.desc}</option>
		</c:forEach>
	</select>  
	日志来源: 
	<select name="ucLogs.logSource">
		<option value="">请选择日志来源</option>
		<c:forEach items="${logSource}" var="source">
			<option value="${source.desc}" ${ucLogs.logSource==source.desc?"selected='selected'":"" }>${source.desc}</option>
		</c:forEach>
	</select> 
	操作人: <input type="text" name="ucLogs.createUserName" value="${ucLogs.createUserName}" style="width:100px" />
	<input class="query" type="button" id="query" value="查询" />
	</div>
	</div>
    <table class="pn-ltable" style="" width="100%" cellspacing="1" cellpadding="0" border="0">
    	<thead class="pn-lthead">
	    	<tr>
	    		<th>操作人</th>
	    		<th>操作时间</th>
	    		<th>操作地点</th>
	    		<th>操作平台</th>
	    		<th>操作模块</th>
	    		<th>操作数据</th>
	    		<th>操作类型</th>
	    		<th>操作结果</th>
	    		<th>操作</th>
	    	</tr>
		</thead>
		<tbody  class="pn-ltbody">
			<c:forEach items="${pager.list}" var="ucLogs">
				<tr onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
					<td>${ucLogs.createUserName}</td>
					<td>${fn:substring(ucLogs.createDate,0,19)}</td>
					<td>${ucLogs.logIp}</td>
					<td>${ucLogs.logSource}</td>
					<td>${ucLogs.logObj}</td>
					<td>${fn:substring(ucLogs.logDetail,0,fn:indexOf(ucLogs.logDetail,",")==-1?fn:length(ucLogs.logDetail):fn:indexOf(ucLogs.logDetail,","))}</td>
					<td>${ucLogs.logOpera}</td>
					<td>${ucLogs.operaResult}</td>
					<td>
						<a href="#" class="detail" title="${ucLogs.logId}">详细</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
    </table>
    <!-- 分页 -->
    <%@include file="/api_scenter/public/standard.jsp" %>
    <div style="margin-top:15px;">
	</div>
	</form>
	</div>
  </body>
</html>

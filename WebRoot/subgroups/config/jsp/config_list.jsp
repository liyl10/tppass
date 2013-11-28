<!-- 
@comment 系统参数列表页面
@author zzze
@date Dec 27, 2012
@version 1.0
 -->
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>系统参数管理</title>
		<link href="${pageContext.request.contextPath }/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/hopsun.util.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/subgroups/config/js/config.js"></script>
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos"> 
				当前位置: 系统参数管理 - 列表 
			</div>
			<form class="ropt"></form>
			<div class="clear"></div>
		</div>
		<div class="right_boxtable">
			<div class="body-box">
				<div class="search_box">
					<div class="search_title">
						关键字搜索
					</div>
					<div class="search_con">
						<form id="queryform" method="post" action="${pageContext.request.contextPath }/api/config/config_list.action" style="margin-bottom:5px;">
							<table class="pn-searchtable" width="100%">
								  <tr>
									   <td width="800" align="left" >
									   		<div>
												参数名称:
												<input type="text" name="config.paramName" style="width: 100px"  value="${config.paramName}" />
												参数代码:
												<input type="text" name="config.paramCode" style="width: 100px"  value="${config.paramCode}" />
												参数值:
												<input type="text" name="config.paramUseage" style="width: 100px"  value="${config.paramUseage}" />
												<input type="submit" name="btn_query" value="查询" class="query" />	
											<label class="searchClickObj" style="display:none;"><img src="${pageContext.request.contextPath}/resource/images/admin/icon-shouqi.jpg">收起</label><label class="searchClickObj"><img src="${pageContext.request.contextPath}/resource/images/admin/icon-xiala.jpg">显示全部条件</label>
											<div>
											
											<div class="moredo" style="display:none;">
										 		其他搜索条件：
												<select name="dept.enableState">
												<option value="">全部</option>
												<option value="1" <c:if test="${condition.enableState == '1' }">selected</c:if>>启用</option>
												<option value="0" <c:if test="${condition.enableState == '0' }">selected</c:if>>禁用</option>
												</select>
										 	</div>
									   </td>
									   <td align="left" valign="top">
											
									   </td>
								  </tr>
							</table>
						</form>
					</div>
				</div>
				<div class="bntdo-box" style="margin-bottom:10px;">
					<input type="button" value="添加" id="insert2" class="add" />
					<input type="button" name="" value="删除" id="deleteBatch2" class="del-button" />
				</div>
				<form id="myform" method="post" action="${pageContext.request.contextPath }/api/config/config_list.action">
					<input type="hidden" id="id" name="config.paramId" />
					<input type="hidden" id="pageContext" name="pageContext" value="${pageContext.request.contextPath}" />
					<input type="hidden" name="redirectUrl" value="${pageContext.request.contextPath }/api/config/config_list.action?pager.pageNumber=${pager.pageNumber}&pager.pageCount=${pager.pageCount}&pager.pageSize=${pager.pageSize}&config.paramName=${param.config.paramName }&config.paramCode=${param.config.paramCode }&config.paramUseage=${config.paramUseage}" />
					<table class="pn-ltable" style="" width="100%" cellspacing="1"
						cellpadding="0" border="0">
						<thead class="pn-lthead">
							<tr>
								<th width="20">
									<input id="CheckedAll" type='checkbox' />
								</th>
								<th width="120">
									参数名称
								</th>
								<th width="100">
									参数代码
								</th>
								<th>
									参数值
								</th>
								<th width="125">
									添加时间
								</th>
								<th width="130">
									操作
								</th>
							</tr>
						</thead>
						<tbody class="pn-ltbody">
							<c:forEach items="${pager.list}" var="config">
								<tr onmouseover="this.bgColor='#FEF5E0'" onmouseout="this.bgColor='#ffffff'">
									<td>
										<input type='checkbox' name="ids" value='${config.paramId}' />
									</td>
									<td title="${config.paramName}">
										${fn:substring(config.paramName,0,9)}
									</td>
									<td title="${config.paramCode}">
										${fn:substring(config.paramCode,0,14)}
									</td>
									<td style="text-align:left;">
										${config.paramUseage}
									</td>
									<td>
										${fn:substring(config.createDate,0,19)}
									</td>
									<td>
										<a href="#" title="${config.paramId}" class="detail pn-opt">查看</a>&nbsp;|&nbsp;
										<a href="#" title="${config.paramId}" class="modify pn-opt">修改</a>&nbsp;|&nbsp;
										<a href="#" title="${config.paramId}" class="delete pn-opt">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<div class="bntdo-box" style="margin-top:10px;">
						<input type="button" value="添加" id="insert" class="add" />
						<input type="button" name="" value="删除" id="deleteBatch" class="del-button" />
					</div>
					<!-- 分页 -->
					<!--  include file="../util/page.jsp" -->
					<%@include file="/api_scenter/public/standard.jsp"%>
				</form>
			</div>
		</div>
	</body>
</html>

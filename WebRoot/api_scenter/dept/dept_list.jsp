<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 部门管理 - 列表页面
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
 -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>部门管理 - 列表</title>
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/hopsun.util.js"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/RegExp.js" type="text/javascript" ></script>
		
		<style>
		*{margin:0; padding:0;}
		a{ text-decoration:none}
		ul{ list-style:none}
		.menu-title{float:left; list-style:none; margin-top:0px; margin-top:3px\9;}
		.dropdawn{display:none}
		.menu-title:hover .dropdawn{background: #fff;
		border: solid 1px #ccc;
		display: block;
		position: absolute;
			width:80px;
			margin-left:-54px;
		}
		.menu-title:hover .dropdawn li {
			font-size: 12px;
			line-height: 20px;
			color: #666;
			width:80px;
			list-style: none;
			text-align: left;
		}			
		.menu-title:hover .dropdawn li a {
			color: #666;
			text-decoration: none;
			padding-left: 10px;
			padding-right: 10px;
			font-size: 12px;
			line-height: 20px;
			width:60px;
			float: left;
		}
		.menu-title:hover .dropdawn a:hover {
			color: #f60;
			text-decoration: none;
			background: #e1eeff;
			font-size: 12px;
			width:60px;
			line-height: 20px;
		}
		.menu-title.iehover .dropdawn{display:block}
		</style>
		
		<script type="text/javascript">
		var url_cur="${pageContext.request.contextPath}";
			$(function(){
			
				hopsun_util.h_slide();//下拉列表
				
				navHover = function() {
					var lis = document.getElementById("menu").getElementsByTagName("li");
					for (var i=0; i<lis.length; i++) {
						lis[i].onmouseover=function() {
							this.className+=" iehover";
						}
						lis[i].onmouseout=function() {
							this.className=this.className.replace(new RegExp(" iehover\\b"), "");
						}
					}
				}
				
				//搜索提交
			$("#btn_query").click(function(){
					$("#pageNum").attr("value","1"); 
					$("#myform").submit();
				});
			})
		</script>
		<script src="${pageContext.request.contextPath}/api_scenter/dept/js/dept_list.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 部门管理 - 列表
			</div>
			<form class="ropt"></form>
			<div class="clear"></div>
		</div>
		<div class="right_boxtable">
		    <form id="myform" name="form" method="post" action="${pageContext.request.contextPath}/api/dept_list.action">
			<div class="search_box">
				<div class="search_title">关键字搜索</div>
				<div class="search_con">
					<!--   form name="queryform" action="${pageContext.request.contextPath}/api/dept_list.action" method="post" style="margin-bottom:5px;" -->
						<table class="pn-searchtable" width="100%">
							<tr>
								<td width="800" align="left" >
									<div>
										部门名称：
										<input type="text" name="dept.deptName" value="${dept.deptName}" style="width: 70px" />
										<input type="hidden" name="dept.scDept.deptId" value="" />
										部门领导：
										<input type="text" name="dept.deptLeader" value="${dept.deptLeader}" style="width: 70px" />
										部门联系人：
										<input type="text" name="dept.deptLinkman" value="${dept.deptLinkman}" style="width: 70px" />
										启用状态：
										<select name="dept.enableState">
										<option value="">全部</option>
										<option value="1" <c:if test="${condition.enableState == '1' }">selected</c:if>>启用</option>
										<option value="0" <c:if test="${condition.enableState == '0' }">selected</c:if>>禁用</option>
										</select>
										<!-- 
										<input type="hidden" name="pager.pageNumber" value="${pager.pageNumber}" />
										<input type="hidden" name="pager.pageSize" value="${pager.pageSize}" />
										 -->
										<input type="button" name="btn_query" id="btn_query" value="查询" class="query" />
										<label class="searchClickObj" style="display:none;"><img src="${pageContext.request.contextPath}/resource/images/admin/icon-shouqi.jpg">收起</label><label class="searchClickObj"><img src="${pageContext.request.contextPath}/resource/images/admin/icon-xiala.jpg">显示全部条件</label>
									</div>
									<div class="moredo" style="display:none;">
										审核状态：
										<select name="dept.verifyState">
										<option value="">全部</option>
										<option value="0" <c:if test="${condition.verifyState == '0' }">selected</c:if>>未审核</option>
										<option value="1" <c:if test="${condition.verifyState == '1' }">selected</c:if>>审核通过</option>
										<option value="2" <c:if test="${condition.verifyState == '2' }">selected</c:if>>审核不通过</option>
										</select>
									</div>
								</td>
							</tr>
						</table>
					<!--  form-->
				</div>
			</div>
			
				<input type="hidden" id="pageContext" name="pageContext" value="${pageContext.request.contextPath}" />
				<input type="hidden" name="redirectUrl" value="${pageContext.request.contextPath }/api/dept_list.action?pager.pageNumber=${pager.pageNumber}&pager.pageCount=${pager.pageCount}&pager.pageSize=${pager.pageSize}&dept.deptName=${dept.deptName}&dept.deptLeader=${dept.deptLeader}&dept.deptLinkman=${dept.deptLinkman}&dept.enableState=${dept.enableState}&dept.verifyState=${dept.verifyState}" />
				<div style="margin-top: 15px;">
					<tag:auth code="sc.dept.insertdept">
					<input type="button" value="添加" onclick="addObj();" class="add" />
					</tag:auth>
					<tag:auth code="sc.dept.deletedept">
					<input type="button" name="" value="删除" class="del-button" onclick="deleteClick();" />
					</tag:auth>
					<tag:auth code="sc.dept.modifydept">
					<input type="button" name="btn_enable" value="启用" class="btn_enable" id="btn_enable2" />
					<input type="button" name="btn_disable" value="禁用" class="btn_disable" id="btn_disable2" />
				    </tag:auth>
				</div><br />
				<table class="pn-ltable" style="" cellspacing="1" cellpadding="0" border="0">
					<thead class="pn-lthead">
						<tr>
							<th width="20">
								<input type='checkbox' name='CheckedAll' id='CheckedAll' />
							</th>
							<th  >
								部门名称
							</th>
							<th width="90">
								上级部门
							</th>
							<th  width="90">
								部门领导
							</th>
							<th width="90">
								部门联系人
							</th>
							<th width="90">
								联系电话
							</th>
							<th width="90">
								创建人
							</th>
							<th width="90">
								创建时间
							</th>
							<th width="70">
								启用状态
							</th>
							<th width="80">
								审核状态
							</th>
							<th width="85">
								操作选项
							</th>
						</tr>
					</thead>
					<tbody class="pn-ltbody">
						<c:forEach items="${pager.list}" var="dept">
						<tr onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
							<td>
								<input type='checkbox' name='ids' value='${dept.deptId}' />
							</td>
							<td class="td_left" title="${dept.deptName}">
								 ${(fn:length(dept.deptName) > 8)?(fn:substring(dept.deptName, 0, 8)):(dept.deptName)}${(fn:length(dept.deptName) > 8)?("..."):""}
							</td>
							<td title="${dept.scDept.deptName}">
								<c:if test="${dept.scDept == null}">无</c:if>
								<c:if test="${dept.scDept != null}">
								<c:if test="${dept.scDept.deleteState == '0' && dept.scDept.enableState == '1' && dept.scDept.verifyState == '3'}">
								${(fn:length(dept.scDept.deptName) > 6)?(fn:substring(dept.scDept.deptName, 0, 6)):(dept.scDept.deptName)}${(fn:length(dept.scDept.deptName) > 6)?("..."):""}
								</c:if>
								<c:if test="${dept.scDept.deleteState != '0' || dept.scDept.enableState != '1' || dept.scDept.verifyState != '3'}">
								无</c:if>
								</c:if>
							</td>
							<td title="${dept.deptLeader}">
								${(fn:length(dept.deptLeader) > 6)?(fn:substring(dept.deptLeader, 0, 6)):(dept.deptLeader)}${(fn:length(dept.deptLeader) > 6)?("..."):""}
							</td>
							<td title="${dept.deptLinkman}">
								${(fn:length(dept.deptLinkman) > 6)?(fn:substring(dept.deptLinkman, 0, 6)):(dept.deptLinkman)}${(fn:length(dept.deptLinkman) > 6)?("..."):""}
							</td>
							<td>
								${dept.deptPhone}
							</td>
							<td>${dept.createUserName}</td>
							<td>${dept.createDate}</td>
							<td>
								<c:forEach items="${bean.childList }" var="state">
								<c:if test="${state.value == dept.enableState}">${state.desc }</c:if>
								</c:forEach>
							</td>
							<td>
								<c:forEach items="${verify.childList }" var="verify">
								<c:if test="${verify.value == dept.verifyState}">${verify.desc }</c:if>
								</c:forEach>
							</td>
							<td>
								<tag:auth code="sc.dept.details">
								<a href="${pageContext.request.contextPath}/api/dept_details.action?dept.deptId=${dept.deptId}" class="pn-opt fleft">查看|</a>
								</tag:auth>
								<tag:auth code="sc.dept.modifydept">
								<a href="javascript:void(0);" class="pn-opt fleft" onClick="modifyObj('${dept.deptId}');return false;" >修改|</a></tag:auth>
								<li class="menu-title fleft"><a class="slide pn-opt">更多</a>
								<div class="clear"></div>
								<ul class="dropdawn">
										<li>
											<tag:auth code="sc.dept.deletedept">
											<a href="javascript:void(0);" onClick="deleteObj('${dept.deptId}');return false;" class="pn-opt">删除</a>
											</tag:auth>
										</li>
										<li>
											<tag:auth code="sc.dept.verifydept">
											<a href="javascript:void(0);" onClick="verifyObj('${dept.deptId}');return false;" class="pn-opt">审核</a>
											</tag:auth>
										</li>
										<li>
											<tag:auth code="sc.user.user_list">
											<a href="${pageContext.request.contextPath}/api/user_list.action?admin.scDept.deptId=${dept.deptId}&com_from_dept=true" class="pn-opt">成员管理</a>
											</tag:auth>
										</li>
									</ul>
								</li>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<div style="margin-top: 15px;">
					<tag:auth code="sc.dept.insertdept">
					<input type="button" value="添加" onclick="addObj();" class="add" />
					</tag:auth>
					<tag:auth code="sc.dept.deletedept">
					<input type="button" name="" value="删除" class="del-button" onclick="deleteClick();" />
					</tag:auth>
					<tag:auth code="sc.dept.modifydept">
					<input type="button" name="btn_enable" value="启用" class="btn_enable" id="btn_enable" />
					<input type="button" name="btn_disable" value="禁用" class="btn_disable" id="btn_disable" />
				</tag:auth>
				</div>
				<%@include file="/api_scenter/public/standard.jsp"%>
			</form>
		 
		</div>
	</body>
</html>
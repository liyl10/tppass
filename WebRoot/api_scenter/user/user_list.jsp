<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 用户信息管理列表页面
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
-->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户管理 - 列表</title>
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/api_scenter/user/css/user.css" rel="stylesheet" type="text/css"/>
		<link href="${pageContext.request.contextPath}/api_scenter/js/zTree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet"  type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/zTree/js/jquery.ztree.core-3.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/zTree/js/jquery.ztree.excheck-3.1.js"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/pop_box.js" type="text/javascript"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/hopsun.util.js"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/RegExp.js" type="text/javascript" ></script>
		<script src="${pageContext.request.contextPath}/api_scenter/user/js/user_list.js" type="text/javascript"></script>
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
		<SCRIPT type="text/javascript">
				var setting = {
					check: {
						enable: true,
						chkStyle: "radio",
						radioType: "all"
					},
					data: {
						simpleData: {
							enable: true
						}
					}
				};
				//部门树节点
				<c:if test="${supDeptListJson != null}">
					var zNodesDept =${supDeptListJson};
				    zNodesDept.push({id:"",name:"全部",open:"true"});
				</c:if>
				<c:if test="${supDeptListJson == null}"> 
					var zNodesDept = [{id:"",name:"无"}];
				</c:if>
			</SCRIPT>
		
		<script src="${pageContext.request.contextPath}/api_scenter/user/js/user_list.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
			<c:choose> 		
			<c:when test="${com_from_dept != null}">
					当前位置: 部门管理 - 成员管理 - 列表
			</c:when>
			<c:when test="${com_from_puser != null}">
					当前位置: 用户管理- 成员管理 - 列表
			</c:when>	
			<c:otherwise>
 					当前位置: 用户管理 - 列表
			</c:otherwise> 
			</c:choose>
			</div>
		    <form class="ropt"></form>
			<div class="clear"></div>
		</div>
		<div class="right_boxtable">
		<form id="myform" name="form" method="post" action="${pageContext.request.contextPath}/api/user_list.action">
		
			<div class="search_box">
				<div class="search_title">关键字搜索</div>
				<div class="search_con">
					<!--  form action="${pageContext.request.contextPath}/api/user_list.action" method="post" style="margin-bottom: 5px;" -->
						<table class="pn-searchtable" width="100%">
							<tr>
								<td width="800" align="left" >
									<div>
										用户名：
										<input type="text" name="admin.userName" value="${admin.userName}" style="width: 70px" />
										真实姓名：
										<input type="text" name="admin.userRealname" value="${admin.userRealname}" style="width: 70px" />
										所属部门：
										<input type="hidden" name="admin.scDept.deptId" id="userDeptId" value="${admin.scDept.deptId}" />
										<input type="text" name="admin.scDept.deptName" id="userDeptName" value="${admin.scDept.deptName}" readonly="readonly"  />
										启用状态：
										<select name="admin.enableState">
										<option value="">全部</option>
										<option value="1" <c:if test="${condition.enableState == '1' }">selected</c:if>>启用</option>
										<option value="0" <c:if test="${condition.enableState == '0' }">selected</c:if>>禁用</option>
										</select>
										<!-- 
										<input type="hidden" name="pager.pageNumber" value="${pager.pageNumber}" />
										<input type="hidden" name="pager.pageSize" value="${pager.pageSize}" />
										 -->
										<input type="hidden" name="com_from_dept" value="${com_from_dept}" />
										<input type="button" name="btn_query" id="btn_query" value="查询" class="query" />
										<label class="searchClickObj" style="display:none;"><img src="${pageContext.request.contextPath}/resource/images/admin/icon-shouqi.jpg">收起</label><label class="searchClickObj"><img src="${pageContext.request.contextPath}/resource/images/admin/icon-xiala.jpg">显示全部条件</label>
									</div>
									<div class="moredo" style="display:none;" >
										审核状态：
										<select name="admin.verifyState">
										<option value="">全部</option>
										<option value="0" <c:if test="${condition.verifyState == '0' }">selected</c:if>>未审核</option>
										<option value="1" <c:if test="${condition.verifyState == '1' }">selected</c:if>>审核通过</option>
										<option value="2" <c:if test="${condition.verifyState == '2' }">selected</c:if>>审核不通过</option>
										</select>
									</div>
								</td>
							</tr>
						</table>
					<!-- form -->
				</div>
			</div>
			<!--  form id="myform" name="form" method="post" action="${pageContext.request.contextPath}/api/user_list.action" -->
			<input type="hidden" id="pageContext" name="pageContext" value="${pageContext.request.contextPath}" />
			<input type="hidden" name="redirectUrl" value="${pageContext.request.contextPath }/api/user_list.action?pager.pageNumber=${pager.pageNumber}&pager.pageCount=${pager.pageCount}&pager.pageSize=${pager.pageSize}&admin.userName=${admin.userName}&admin.userRealname=${admin.userRealname}&admin.scDept.deptId=${admin.scDept.deptId}&admin.scDept.deptName=${admin.scDept.deptName}&admin.enableState=${admin.enableState}&admin.verifyState=${admin.verifyState}" />
			<div style="margin-top: 15px;">
				<tag:auth code="sc.user.insertuser">
				<input type="button" name="" value="添加" class="add" onclick="addObj();" />
				</tag:auth>
				<tag:auth code="sc.user.deleteuser">
				<input type="button" name="" value="删除" class="del-button" onclick="deleteClick();" />
				</tag:auth>
				<tag:auth code="sc.user.enableuser">
				<input type="button" name="" value="启用" class="btn_enable" onclick="enableClick();" />
				</tag:auth>
				<tag:auth code="sc.user.disableuser">
				<input type="button" name="" value="禁用" class="btn_disable" onclick="disableClick();" />
				</tag:auth>
				<tag:auth code="sc.user.resetuserpwd">
				<input type="button" name="" value="密码重置" class="generate-static" onclick="resetpwdClick();" />
				</tag:auth>
				<c:if test="${com_from_dept != null|| com_from_puser != null}">
				<input type="button" name=""  value="返回" class="reject" onclick="javascript:history.go(-1)"  />
				</c:if>
			</div><br />
			<div class="clear"></div>
			<table class="pn-ltable" style="" cellspacing="1" cellpadding="0" border="0">
				<thead class="pn-lthead">
					<tr>
						<th width="20">
							<input type='checkbox' name='CheckedAll' id='CheckedAll'/>
						</th>
						<th width="90">
							用户名
						</th>
						<th width="90">
							真实姓名
						</th>
						<th width="90">
							联系电话
						</th>
						<th>
							电子邮箱
						</th>
						<th width="90">
							部门
						</th>
                        <th width="90">
							创建人
						</th>
                        <th width="90">
							创建时间
						</th>
						<th width="90">
							最后登录
						</th>
						<th width="60">
							登录
						</th>
						<th width="60">
							启用状态
						</th>
						<th width="60">
							审核状态
						</th>
						<th width="85">
							操作选项
						</th>
					</tr>
				</thead>
				<tbody class="pn-ltbody">
					<c:forEach items="${pager.list}" var="user">
					<tr onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
						<td>
							<input type='checkbox' name='ids' value='${user.userId}' />
						</td>
						<td class="td_left" title="${user.userName}">
							<span style="text-decoration:underline">
							<a href="${pageContext.request.contextPath}/api/user_list.action?optuserid=${user.userId}&com_from_puser=true">${(fn:length(user.userName) > 10)?(fn:substring(user.userName, 0, 10)):(user.userName)}${(fn:length(user.userName) > 10)?("..."):""}</a>
							</span>
						</td>
						<td title="${user.userRealname}">
							${(fn:length(user.userRealname) > 5)?(fn:substring(user.userRealname, 0, 5)):(user.userRealname)}${(fn:length(user.userRealname) > 5)?("..."):""}
						</td>
						<td>
							${user.userPhone}
						</td>
						<td class="td_left" title="${user.userEmail}">
							${(fn:length(user.userEmail) > 20)?(fn:substring(user.userEmail, 0, 20)):(user.userEmail)}${(fn:length(user.userEmail) > 20)?("..."):""}
						</td>
						<td title="${user.scDept.deptName}">
							${(fn:length(user.scDept.deptName) > 5)?(fn:substring(user.scDept.deptName, 0, 5)):(user.scDept.deptName)}${(fn:length(user.scDept.deptName) > 5)?("..."):""}
						</td>
                        <td title="${user.createUserName}">
							${(fn:length(user.createUserName) > 5)?(fn:substring(user.createUserName, 0, 5)):(user.createUserName)}${(fn:length(user.createUserName) > 5)?("..."):""}
						</td>
                        <td >
							${user.createDate}
						</td>
						<td>
							${user.loginDate}<p>${user.lastLoginIp}</p>
						</td>
						<td>
							${user.loginTimes}
						</td>
						<td>
							<c:forEach items="${bean.childList }" var="state">
							<c:if test="${state.value == user.enableState}">${state.desc }</c:if>
							</c:forEach>
						</td>
						<td>
							<c:forEach items="${verify.childList }" var="verify">
							<c:if test="${verify.value == user.verifyState}">${verify.desc }</c:if>
							</c:forEach>
						</td>
						<td>
							<tag:auth code="sc.user.details">
							<a href="user_details.action?admin.userId=${user.userId}" class="pn-opt fleft">查看|</a> 
							</tag:auth>
							<tag:auth code="sc.user.modifyuser">
							<a href="javascript:void(0);" onClick="modifyObj('${user.userId}');return false;" class="pn-opt fleft">修改|</a>
							</tag:auth>
							<li class="menu-title fleft"><a class="slide pn-opt">更多</a>
								<div class="clear"></div>
								<ul class="dropdawn">
									<li>
										<tag:auth code="sc.dept.deletedept">
										<a href="javascript:void(0);" onClick="deleteObj('${user.userId}');return false;" class="pn-opt">删除</a>
										</tag:auth>
									</li>
									<li>
										<tag:auth code="sc.dept.verifydept">
										<a href="javascript:void(0);" onClick="verifyObj('${user.userId}');return false;" class="pn-opt">审核</a>
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
				<tag:auth code="sc.user.insertuser">
				<input type="button" name="" value="添加" class="add" onclick="addObj();" />
				</tag:auth>
				<tag:auth code="sc.user.deleteuser">
				<input type="button" name="" value="删除" class="del-button" onclick="deleteClick();" />
				</tag:auth>
				<tag:auth code="sc.user.enableuser">
				<input type="button" name="" value="启用" class="btn_enable" onclick="enableClick();" />
				</tag:auth>
				<tag:auth code="sc.user.disableuser">
				<input type="button" name="" value="禁用" class="btn_disable" onclick="disableClick();" />
				</tag:auth>
				<tag:auth code="sc.user.resetuserpwd">
				<input type="button" name="" value="密码重置" class="generate-static" onclick="resetpwdClick();" />
				</tag:auth>
				<c:if test="${com_from_dept != null|| com_from_puser != null}">
				<input type="button" name=""  value="返回" class="reject" onclick="javascript:history.go(-1)"  />
				</c:if>
				 <input type="hidden" name="com_from_dept" value="${com_from_dept}" />
				 <input type="hidden" name="com_from_puser" value="${com_from_puser}" />
			</div>
			<%@include file="/api_scenter/public/standard.jsp"%>
             
		</form>
		
		</div>
		
		 <div class="pop_box" id="pop_box_dept">
			<div class="pop_box_handel">
			<div class="pop_box_handel_tit"></div>
			<div class="pop_box_handel_close"></div>
			</div>
			<div class="pop_box_content">
				  <ul id="dept_tree" class="ztree"></ul>
			</div>	
			<div class="pop_box_ctrl">
				<input type="button" name="btn_pop_sure" id="btn_pop_sure_dept"  value="提交" class="submit"  />
				<input type="button" name="btn_pop_cancel"  value="关闭" class="close-button"  />
			</div>
		</div>
	</body>
</html>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>角色管理 - 列表</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/hopsun.util.js"></script>
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
			    //jquery start
				hopsun_util.h_slide();//下拉列表
				
				//内嵌弹出层调用
				$('.inside').click(function(){
					$.webox({
						height:280,
						width:600,
						bgvisibel:true,
						title:'内嵌弹出层调用',
						html:$("#box").html()
					});
				});
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
			//jquery end	
			});
 
			function getTableForm() {
				return document.getElementById('myform');
			} 
			function optAdd(){
					var f = getTableForm();
					f.action="${pageContext.request.contextPath}/api/role/role_goadd.action";
					f.submit();
				} 
			/**
			 * 单个删除
			 */
			function deleteObj(ids){
			var f = getTableForm();
				if (confirm("你确定要删除该信息？")) {
					$('[name=ids]').attr("checked", false );
					f.action = "${pageContext.request.contextPath}/api/role/role_delete.action?id="+ids;
			    	f.submit();
				}
			}
		
			/**
			 * 修改
			 */
			function modifyObj(ids){
			var f = getTableForm();
				$('[name=ids]').attr("checked", false);
				f.action = "${pageContext.request.contextPath}/api/role/role_gomodify.action?id="+ids; 
			   	f.submit();
			}
			
			/**
			 * 审核
			 */
			function verifyObj(ids){
			var f = getTableForm();
				$('[name=ids]').attr("checked", false);
				f.action = "${pageContext.request.contextPath}/api/role/role_verify.action?ids="+ids;
			   	f.submit();
			}	
			/**
			 * 授权
			 */
			function authorizeObj(ids){
			var f = getTableForm();
					$('[name=ids]').attr("checked", false);
					f.action = "${pageContext.request.contextPath}/api/role/role_authorize.action?ids="+ids;
			    	f.submit();
			}																						
		</script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/RegExp.js" type="text/javascript" ></script>
		<script src="${pageContext.request.contextPath}/api_scenter/role/js/role_list.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 角色管理 - 列表 
			</div>
			<div class="clear"></div>
		</div>
		
		
		<div class="right_boxtable">
        <form name="myform" id="myform" action="${pageContext.request.contextPath}/api/role/role_list.action" method="post">
		<div class="search_box">
				<div class="search_title">关键字搜索</div>
				<div class="search_con">
		<!--form name="queryform" action="${pageContext.request.contextPath}/api/role/role_list.action" method="post" style=" margin-bottom: 5px;" -->
			<div>
				 角色名称：
				<input type="text" name="role_name" value="${condition.roleName}" style="width:100px" />
				 启用状态：
				<select name="enable_state">
				<option value="">全部</option>
				<option value="1" <c:if test="${condition.enableState == '1' }">selected</c:if>>启用</option>
				<option value="0" <c:if test="${condition.enableState == '0' }">selected</c:if>>禁用</option>
				</select>
				审核状态：
				<select name="verify_state">
				<option value="">全部</option>
				<option value="0" <c:if test="${condition.verifyState == '0' }">selected</c:if>>未审核</option>
				<option value="1" <c:if test="${condition.verifyState == '1' }">selected</c:if>>审核通过</option>
				<option value="2" <c:if test="${condition.verifyState == '2' }">selected</c:if>>审核不通过</option>
				</select>
				<input type="button" name="btn_query" id="btn_query" value="查询" class="query" />
			</div>
		<!--form-->
		</div></div>
		<div style="margin-bottom: 15px;">
				<tag:auth code="sc.role.role_insert">
			    	<input class="add" type="button" value="添加" onclick="optAdd();"/>	
				</tag:auth>
				<tag:auth code="sc.role.role_delete">
					<input type="button" value="删除" id="btn_delete2" name="btn_delete" class="del-button" />
				</tag:auth>
				<tag:auth code="sc.role.role_save">
					<input type="button" name="btn_enable" value="启用" class="btn_enable" id="btn_enable2" />
					<input type="button" name="btn_disable" value="禁用" class="btn_disable" id="btn_disable2" />
				</tag:auth>
			 
			</div>
		<!--form name="myform" id="myform" action="${pageContext.request.contextPath}/api/role/role_list.action" method="post" -->
			<input type="hidden" name="redirectUrl" value="${pageContext.request.contextPath }/api/role/role_list.action?pager.pageNumber=${pager.pageNumber}&pager.pageCount=${pager.pageCount}&pager.pageSize=${pager.pageSize}&role_name=${condition.roleName}&enable_state=${condition.enableState}&verify_state=${condition.verifyState}" />
			<table width="100%" border="0" cellpadding="0" cellspacing="1" class="pn-ltable" style="">
				<thead class="pn-lthead">
					<tr>
						<th width="20">
							<input type="checkbox" name="checked" id="checked"/>
							<input type="hidden" id="checkedtype" name="checkedtype" value="0">
						</th>
						<th width="140">
							角色名称
						</th>
						<th  >
							角色描述
						</th>
						<th width="90">
							创建人
						</th>
						<th width="90">
							启用状态
						</th>
						 
						<th width="90">
							审核状态
						</th>
						<th width="60">
							排序
						</th>
						<th width="90">
							操作选项
						</th>
					</tr>
				</thead>
				<tbody class="pn-ltbody">
					<c:forEach items="${pager.list}" var="role">
					<tr onMouseOver="this.bgColor='#eeeeee'" onMouseOut="this.bgColor='#ffffff'">
						<td>
							<input type='checkbox' name='ids' value='${role.roleId}' />
						</td>
						<td class="td_left" title="${role.roleName}">
						${(fn:length(role.roleName) > 10)?(fn:substring(role.roleName, 0, 10)):(role.roleName)}${(fn:length(role.roleName) > 10)?("..."):""}
						</td>
						<td title="${role.roleDesc}">
						${(fn:length(role.roleDesc) > 20)?(fn:substring(role.roleDesc, 0, 20)):(role.roleDesc)}${(fn:length(role.roleDesc) > 20)?("..."):""}	
						</td>
						<td>
						 ${role.scUsers.userName} 
						</td>
						<td>
						 <c:forEach items="${enable_state_config.childList}" var="enable">
						 	${(enable.value ==role.enableState)?enable.desc:""} 
						</c:forEach>
						</td>
						<td>
						 <c:forEach items="${verify_state_config.childList}" var="verify">
						 	${(verify.value ==role.verifyState)?verify.desc:""} 
						 </c:forEach>
						</td>
						<td>
						${role.roleOrder}
						</td>
						<td>
							<tag:auth code="sc.role.role_view">
								<a href="${pageContext.request.contextPath}/api/role/role_view.action?id=${role.roleId}" class="pn-opt fleft">查看|</a>
							</tag:auth>
							<tag:auth code="sc.role.role_save">
							<a  onclick="modifyObj('${role.roleId}');return false;" href="javascript:void(0);" class="pn-opt fleft">修改|</a>
							</tag:auth>
							<li class="menu-title fleft"><a class="slide pn-opt">更多</a>
								<div class="clear"></div>
								<ul class="dropdawn">
								<li>
							<tag:auth code="sc.role.role_verifysave">
							<a  onclick="verifyObj('${role.roleId}');return false;" href="javascript:void(0);" class="pn-opt">审核</a>
							</tag:auth>
							   </li><li>
							<tag:auth code="sc.role.role_view">
							<a href="${pageContext.request.contextPath}/api/role/role_viewauth.action?ids=${role.roleId}" class="pn-opt">查看权限</a>
							</tag:auth>
							</li><li>
							<tag:auth code="sc.role.role_authsave">
							<a onclick="authorizeObj('${role.roleId}');return false;" href="javascript:void(0);"  class="pn-opt">授权</a>
							</tag:auth>
							</li><li>
							<tag:auth code="sc.role.role_delete">
							<a onclick="deleteObj('${role.roleId}');return false;" href="javascript:void(0);" class="pn-opt">删除</a>
							</tag:auth>
							</li>
							</ul>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<div style="margin-top: 15px;">
				<tag:auth code="sc.role.role_insert">
			    	<input class="add" type="button" value="添加" onclick="optAdd();"/>	
				</tag:auth>
				<tag:auth code="sc.role.role_delete">
					<input type="button" value="删除" id="btn_delete" name="btn_delete"  class="del-button" />
				</tag:auth>
				<tag:auth code="sc.role.role_save">
					<input type="button" name="btn_enable" value="启用" class="btn_enable" id="btn_enable" />
					<input type="button" name="btn_disable" value="禁用" class="btn_disable" id="btn_disable" />
				</tag:auth>
				<!-- input type="button" name="" value="审核" class="check" onClick="optCheck();" -->
                <!-- input type="button" name="" value="授权" class="check" onClick="optAuthorize();" -->
			</div>
			<%@include file="/api_scenter/public/standard.jsp"%>
			</form>
    </div>
    <div id="dialog" >
			<div id="dialog_content"></div>
	</div>
	<div id="dialog_confirm">
			<div id="dialog_confirm_content"></div>
	</div>
	
	</body>
</html>

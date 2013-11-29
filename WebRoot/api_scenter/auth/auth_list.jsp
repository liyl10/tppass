<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<HEAD>
		<TITLE>权限管理</TITLE>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/api_scenter/js/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/api_scenter/auth/css/authedit.css" type="text/css"></link>
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/zTree/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/zTree/js/jquery.ztree.core-3.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/zTree/js/jquery.ztree.excheck-3.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/zTree/js/jquery.ztree.exedit-3.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/RegExp.js"></script>
		
		
		<script type="text/javascript" >
		var str="";
		var url_cur="${pageContext.request.contextPath}";
		var edit_state_y=false;
		var sele_pid="${pid}";
		//拥有移动权限才可执行操作
		<tag:auth code="sc.auth.auth_ajaxmove">
			edit_state_y=true;
		</tag:auth>
		
		$(document).ready(function(){
		
		//
		  			 
							 
 
			 
		 //jquery end
		});
		</script>
		<script src="${pageContext.request.contextPath}/api_scenter/auth/js/auth_list.js" type="text/javascript"></script>
		
		
	 </HEAD>

	<BODY>
	   <div class="box-positon">
	<div class="rpos">当前位置: 权限管理 </div>
	<form class="ropt">
		 
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">

<form id="form1" name="form1" method="post" action="" target="_self">
 <div class="auth_fl">
	<div ${pid == null ?"class='one_lev_type_per_hover'":"class='one_lev_type_per'"} >
			<a href="${pageContext.request.contextPath}/api/auth/auth_list.action">所有权限</a>
	</div>
	<c:forEach items="${firlevlist}" var="auth_fir">
		<div ${pid==auth_fir.authId?"class='one_lev_type_per_hover'":"class='one_lev_type_per'"}  >
			<a href="${pageContext.request.contextPath}/api/auth/auth_list.action?pid=${auth_fir.authId}">${auth_fir.authName}</a>
		</div>
	</c:forEach>
    </div>
<div class="treeWrap">
	<ul id="treeDemo" class="ztree"></ul>
</div>
<div id="type_contrl" style="display: none">
						<tag:auth code="sc.auth.auth_insertsave">
						 <input type="button" name="goaddchild" value="添加" class="add" />
						&nbsp;
						</tag:auth>
						<tag:auth code="sc.auth.auth_view">
						 <input type="button" name="goview" value="查看" class="edit" />
						&nbsp;	
						</tag:auth>
						<tag:auth code="sc.auth.auth_modifysave">
						 <input type="button" name="gomodify" value="修改" class="edit" />
						&nbsp;
						</tag:auth>
						<tag:auth code="sc.auth.auth_delete">
						 <input type="button" name="godel" value="删除" class="del-button" />
						&nbsp;
						</tag:auth>
						<input type="hidden" name="select_node_id" id="select_node_id" />
						<input type="hidden" name="select_node_name" id="select_node_name" />
						<input type="hidden" name="forward_url" id="forward_url" />
</div>
 
   </form>
 </div>
       <div id="dialog" title="Download complete">
			<div id="dialog_content"></div>
		</div>
	</BODY>
</HTML>
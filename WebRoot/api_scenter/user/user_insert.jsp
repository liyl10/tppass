<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 用户信息添加页面
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
-->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>用户管理 - 添加</title>
		<link href="${pageContext.request.contextPath}/resource/css/yz.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/api_scenter/user/css/user.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/api_scenter/js/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/hcsp_resources.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/validate.js"></script>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/zTree/js/jquery.ztree.core-3.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/zTree/js/jquery.ztree.excheck-3.1.js"></script>
		
		<script src="${pageContext.request.contextPath}/api_scenter/js/RegExp.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/pop_box.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/user/js/user.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/user/js/user_insert.js" type="text/javascript"></script>
<SCRIPT type="text/javascript">
<!--
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

var user_setting = {
					check: {
						enable: true
					},
					data: {
						key:{
							title:"title"
					},
						simpleData: {
							enable: true
						}
					},
					view:{
						showTitle: true
					}
				};
 
//部门树节点
<c:if test="${!empty supDeptListJson}"> 
	var zNodesDept =${supDeptListJson};
</c:if>
<c:if test="${empty supDeptListJson}"> 
	var zNodesDept = [{id:"",name:"无"}];
</c:if>

 //用户树节点
				<c:if test="${!empty supUserListJson}"> 
					var zNodes =${supUserListJson};
				</c:if>
				<c:if test="${empty supUserListJson}"> 
					var zNodes = [{id:"1",name:"无"}];
				</c:if>
 
$(document).ready(function(){

    //全选
     $("#checked").click(function(){
	 	var type = $("#checkedtype").val();
	 	if(type == 0){
		 	$('[name=ids]').attr("checked", "checked" );
	 		$("#checkedtype").val("1")
	 	}else{
	 		$('[name=ids]').attr("checked", "" );
	 		$("#checkedtype").val("0")
	 	}
	 });
	 
	 $('[name=ids]:checkbox').click(function(){
	 	var $tmp=$('[name=ids]:checkbox');
	 	$('#checked').attr('checked',$tmp.length==$tmp.filter(':checked').length?"checked":"");
	  });

	//部门树
	$.fn.zTree.init($("#dept_tree"), setting, zNodesDept);
	var zTreeDept = $.fn.zTree.getZTreeObj("dept_tree");
	
	//用户树
	$.fn.zTree.init($("#sup_user_tree"), user_setting, zNodes);
	var zTree = $.fn.zTree.getZTreeObj("sup_user_tree");
	zTree.setting.check.chkboxType = { "Y" : "s", "N" : "s" };
	// 初始化完成后，回显选中的上级用户
	var nodes_checked_init=zTree.getCheckedNodes(true);
 	if(nodes_checked_init.length>0){
	 	for(var i=0;i<nodes_checked_init.length;i++){
	 		 $("#superuser_seleted_div").append("<input type='checkbox' name='parentId' value='"+nodes_checked_init[i].id+"' checked='checked' />");
	 		 $("#userParentName").attr("value",$('#userParentName').val()+','+nodes_checked_init[i].name);
	 	}
	 		 var str_a=$('#userParentName').val();
	 		 str_a = str_a.substring(1,str_a.length);
	 		 $("#userParentName").attr("value",str_a);
    }
		 	//
				var c_width= $(window).width(); 
				var c_height= $(window).height();
	 
			//选择上级管理员
				$("#userParentName").click(function(){
					//打开层
					$("#pop_box").show();
					$("#pop_box").css("left",(c_width-($("#pop_box").width()))/2+"px");
					$("#pop_box").css("top",(c_height-($("#pop_box").height()))/2+"px");
				});
	   		// 点击确定按钮
					 $("#btn_pop_sure_user").click(function(){	
					 	var nodes_checked=zTree.getCheckedNodes(true);
					 	if(nodes_checked.length>0){
					 	$("#userParentId").attr("value","");
					 	$("#userParentName").attr("value","");
					 	$("#superuser_seleted_div").html("");
						 	for(var i=0;i<nodes_checked.length;i++){
						    $("#userParentName").attr("value",$("#userParentName").val()+','+nodes_checked[i].name);
						    $("#superuser_seleted_div").append("<input type='checkbox' name='parentId' value='"+nodes_checked[i].id+"' checked='checked' />");
						 	}
						 var str_a=$('#userParentName').val();
	 					 str_a = str_a.substring(1,str_a.length);
	 					 $("#userParentName").attr("value",str_a);	
					    $(this).parent().parent().hide();
					    }else{
					    	alert("请选择上级用户！")
					    	}
					 });
	 
	 //选择部门
	$("#userDeptName").click(function(){
		 $("#pop_box_dept").show();
		 $("#pop_box_dept").css("left",(c_width-($("#pop_box_dept").width()))/2+"px");
		 $("#pop_box_dept").css("top",(c_height-($("#pop_box_dept").height()))/2+"px");
	});
	
	// 点击确定按钮
	$("#btn_pop_sure_dept").click(function(){	
	 	var nodes_checked=zTreeDept.getCheckedNodes(true);
	 	if(nodes_checked.length>0){
		 	$("#userDeptId").attr("value",nodes_checked[0].id);
		    $("#userDeptName").attr("value",nodes_checked[0].name);
		    $(this).parent().parent().hide();
	    }else{
	    	alert("请选择部门！")
	    }
	 });
	 
//	ready end
});
//
-->
</SCRIPT>
	</head>

	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 用户管理 - 添加
			</div>
			 
			<div class="clear"></div>
		</div>
		<div class="body-box">
			<form method="post" action="${pageContext.request.contextPath}/api/user_insertUser.action" id="myform">
				<input type="hidden" id="pageContext" name="pageContext" value="${pageContext.request.contextPath}" />
				<input type="hidden" name="redirectUrl" value="${redirectUrl}" />
				<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
					<tr>
						<td class="pn-flabel pn-flabel-h" >
							<span class="pn-frequired">*</span>用户名:
						</td>
						<td class="pn-fcontent" >
							<input type="text" name="admin.userName" class="text_box" id="userName" maxlength="18" />
						</td>
						<td class="pn-flabel pn-flabel-h" >
							<span class="pn-frequired">*</span>真实姓名:
						</td>
						<td class="pn-fcontent" >
							<input type="text" name="admin.userRealname" value="" class="text_box" maxlength="20" id="userRealname" />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							 <span class="pn-frequired">*</span>上级管理员:
						</td>
						<td class="pn-fcontent">
							<!--   input type="hidden" name="parentId" id="userParentId" value="${sysUser.userId}" -->
							<input type="text" name="parentName" id="userParentName" class="text_box" value="" readonly="readonly" />
						</td>
						<td class="pn-flabel pn-flabel-h">
							所属部门:
						</td>
						<td class="pn-fcontent">
							<input type="hidden" name="admin.scDept.deptId" id="userDeptId" value="" />
							<input type="text" name="userDeptName" id="userDeptName" class="text_box" value="" readonly="readonly" />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							<span class="pn-frequired">*</span>密码:
						</td>
						<td class="pn-fcontent">
							<input type="password" name="admin.userPwd"  autocomplete="off" class="text_box" id="userPwd" maxlength="20" />
						</td>
						<td class="pn-flabel pn-flabel-h">
							<span class="pn-frequired">*</span>确认密码:
						</td>
						<td class="pn-fcontent">
							<input type="password" autocomplete="off" class="text_box" id="userPwd2" maxlength="20" />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							<span class="pn-frequired">*</span>角色:
						</td>
						<td class="pn-fcontent">
							<input type="text" name="admin.userNickname" class="text_box" maxlength="20" id="userNickname" />
						</td>
						<td class="pn-flabel pn-flabel-h"><span class="pn-frequired">*</span>性别: </td>
						<td class="pn-fcontent">
							 <c:forEach items="${agent.childList }" var="sex">
							<input type="radio" name="admin.userAgent" value="${sex.value }" />${sex.desc }
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							联系电话:
						</td>
						<td class="pn-fcontent">
							<input type="text" class="text_box"  maxlength="20" value=""   name="admin.userPhone" id="userPhone" />
						</td>
						<td class="pn-flabel pn-flabel-h">
							电子邮箱:
						</td>
						<td class="pn-fcontent">
							<input type="text" class="text_box"  maxlength="50" value=""   name="admin.userEmail" id="userEmail" />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h" >
							<span class="pn-frequired">*</span>启用状态:
						</td>
						<td class="pn-fcontent" colspan="3">
							<c:forEach items="${bean.childList }" var="state">
							<input type="radio" name="admin.enableState" value="${state.value }" />${state.desc }
							</c:forEach>
						</td>
						 
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							用户角色:
						</td>
						<td class="pn-fcontent" colspan="3">
						  <div class="sel_role">
							 <c:forEach items="${roleList}" var="role">
								<label class="per_role" title="${role.roleName}"><input type="checkbox" value="${role.roleId}" name="scRoles" }/>
								${(fn:length(role.roleName) > 6)?(fn:substring(role.roleName, 0, 6)):(role.roleName)}${(fn:length(role.roleName) > 6)?("..."):""}
								</label>
							 </c:forEach>
						</div>
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							<span class="pn-frequired">*</span>用户分类:
						</td>
						<td class="pn-fcontent" colspan="3">
						 	<c:forEach items="${usertype.childList }" var="usertype">
								<input type="radio" name="admin.userType" value="${usertype.value }" />${usertype.desc}
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td colspan="4" class="pn-fbutton">
						<div style="display:none;" id="superuser_seleted_div"></div>
							<tag:auth code="sc.user.insertuser">
							<input type="submit" name="btn_save" id="btn_save" value="提交" class="submit" />
							</tag:auth>
							&nbsp;
							<input type="button" onclick="javascript:history.go(-1)" class="reject" value="返回" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<div class="pop_box" id="pop_box">
			<div class="pop_box_handel">
				<div class="pop_box_handel_tit"></div>
				<div class="pop_box_handel_close"></div>
			</div>
			<div class="pop_box_content">
			<ul id="sup_user_tree" class="ztree"></ul>
			 
			</div>	
			<div class="pop_box_ctrl">
				<input type="hidden" id="checkedtype" name="checkedtype" value="0">
				<input type="button" name="btn_pop_sure" id="btn_pop_sure_user" value="提交" class="submit" />
				<input type="button" name="btn_pop_cancel" value="关闭" class="close-button" />
			</div>
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
				<input type="button" name="btn_pop_sure" id="btn_pop_sure_dept" value="提交" class="submit" />
				<input type="button" name="btn_pop_cancel" value="关闭" class="close-button" />
			</div>
		</div>
	</body>
</html>
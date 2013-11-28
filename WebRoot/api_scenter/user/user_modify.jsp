<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 用户信息修改页面
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
-->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>用户管理 - 修改</title>
		<link href="${pageContext.request.contextPath}/resource/css/yz.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/api_scenter/user/css/user.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/api_scenter/js/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/validate.js"></script>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/zTree/js/jquery.ztree.core-3.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/zTree/js/jquery.ztree.excheck-3.1.js"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/RegExp.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/pop_box.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/user/js/user_modify.js" type="text/javascript"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/hcsp_resources.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/hopsun.util.js"></script>
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
				 
				//用户树节点
				<c:if test="${!empty supUserListJson}"> 
					var zNodes =${supUserListJson};
				</c:if>
				<c:if test="${empty supUserListJson}"> 
					var zNodes = [{id:"1",name:"无"}];
				</c:if>
				
				//部门树节点
				<c:if test="${!empty supDeptListJson}"> 
					var zNodesDept =${supDeptListJson};
				</c:if>
				<c:if test="${empty supDeptListJson}"> 
					var zNodesDept = [{id:"",name:"无"}];
				</c:if>
				 
				$(document).ready(function(){
					//部门树
					$.fn.zTree.init($("#dept_tree"), setting, zNodesDept);
					var zTreeDept = $.fn.zTree.getZTreeObj("dept_tree");
					//用户树
					$.fn.zTree.init($("#treeDemo"), user_setting, zNodes);
					var zTree = $.fn.zTree.getZTreeObj("treeDemo");
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
					 
					//保存时
				    // $("#btn_save").click(function(){	
					//$("#myform").attr("action","${pageContext.request.contextPath}/api/user_insertUser.action");
					//var nodes_checked=zTree.getCheckedNodes(true);
					//$("#userParentId").attr("value",nodes_checked[0].id);
					//$("#userParentName").attr("value",nodes_checked[0].name);
					//$("#myform").submit(); 
					//	});
				 		//重置，清空提示层
						$("input[name='btn_reset']").click(function(){
							hopsun_util.remove_tips();
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
				当前位置: 用户管理 - 修改
			</div>
			
			<div class="clear"></div>
		</div>
		<div class="body-box">
			<form method="post" action="${pageContext.request.contextPath}/api/user_updateUser.action" id="myform">
				<input type="hidden" id="pageContext" name="pageContext" value="${pageContext.request.contextPath}" />
				<input type="hidden" name="redirectUrl" value="${redirectUrl}" />
				<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
					<tr>
						<td class="pn-flabel pn-flabel-h">
							<span class="pn-frequired">*</span>用户名:
						</td>
						<td class="pn-fcontent">
							${admin.userName}
						</td>
						<td class="pn-flabel pn-flabel-h">
							<span class="pn-frequired">*</span>真实姓名:
						</td>
						<td class="pn-fcontent">
							<input type="text" name="admin.userRealname" value="${admin.userRealname }" class="text_box" maxlength="20" id="userRealname"  />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							<span class="pn-frequired">*</span>上级管理员:
						</td>
						<td class="pn-fcontent">
							<input type="text" name="userParentName" value="" class="text_box" id="userParentName" readonly="readonly" />
						</td>
						<td class="pn-flabel pn-flabel-h">
							 所属部门:
						</td>
						<td class="pn-fcontent">
							<input type="hidden" name="admin.scDept.deptId" id="userDeptId" value="${admin.scDept.deptId}" />
							<input type="text" name="userDeptName" value="${admin.scDept.deptName}" class="text_box" id="userDeptName" readonly="readonly" />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							密码:
						</td>
						<td class="pn-fcontent">
							<input type="password" name="admin.userPwd" class="text_box" autocomplete="off" id="userPwd" maxlength="20"   />
						</td>
						<td class="pn-flabel pn-flabel-h">
							确认密码:
						</td>
						<td class="pn-fcontent">
							<input type="password" class="text_box" autocomplete="off" id="userPwd2" maxlength="20"  />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							<span class="pn-frequired">*</span>角色:
						</td>
						<td class="pn-fcontent">
							<input type="text" name="admin.userNickname" id="userNickname" value="${admin.userNickname }" class="text_box" maxlength="20"/>
						</td>
						<td class="pn-flabel pn-flabel-h"><span class="pn-frequired">*</span>性别:</td>
						<td class="pn-fcontent">
                          <c:forEach items="${agent.childList }" var="sex">
							<input type="radio" name="admin.userAgent" value="${sex.value }"  ${sex.value == admin.userAgent?"checked='checked'":""}/>${sex.desc }
						  </c:forEach>
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							联系电话:
						</td>
						<td class="pn-fcontent">
							<input type="text" name="admin.userPhone" value="${admin.userPhone }" class="text_box" id="userPhone" maxlength="20"/>
						</td>
						<td class="pn-flabel pn-flabel-h">
							电子邮箱:
						</td>
						<td class="pn-fcontent">
							<input type="text" value="${admin.userEmail }" name="admin.userEmail" class="text_box" id="userEmail" maxlength="50"  />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							<span class="pn-frequired">*</span>启用状态:
						</td>
						<td class="pn-fcontent" colspan="3">
							<c:forEach items="${bean.childList }" var="state">
							<input type="radio" name="admin.enableState" value="${state.value }"   ${state.value == admin.enableState?"checked='checked'":""}  />${state.desc }
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
								<label class="per_role" title="${role.role.roleName}"><input type="checkbox" value="${role.role.roleId}" name="scRoles" ${role.selected=='true'?"checked='checked'":""}/>
								${(fn:length(role.role.roleName) > 6)?(fn:substring(role.role.roleName, 0, 6)):(role.role.roleName)}${(fn:length(role.role.roleName) > 6)?("..."):""}
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
						 	<c:forEach items="${usertype.childList}" var="usertype">
								<input type="radio" name="admin.userType" value="${usertype.value}" ${usertype.value == admin.userType?"checked='checked'":""}/>${usertype.desc }
							</c:forEach>
						</td>
					</tr>
					
					<tr>
						<td colspan="4" class="pn-fbutton">
						<div style="display:none;" id="superuser_seleted_div"></div>
							<input type="hidden" name="admin.userId" value="${admin.userId }" id="userId" />
							<input type="hidden" name="admin.userName" value="${admin.userName}" id="userName" />
							<input type="hidden" name="admin.loginTimes" value="${admin.loginTimes}" id="loginTimes" />
							<input type="hidden" name="admin.loginDate" value="${admin.loginDate}" id="loginDate" />
							<input type="hidden" name="admin.allowLoginIp" value="${admin.allowLoginIp}" id="allowLoginIp" />
							<input type="hidden" name="admin.lastLoginIp" value="${admin.lastLoginIp}" id="lastLoginIp" />
							<input type="hidden" name="admin.verifyState" value="${admin.verifyState}" id="verifyState" />
							<input type="hidden" name="admin.deleteState" value="${admin.deleteState}" id="deleteState" />
							<input type="hidden" name="admin.createUserName" value="${admin.createUserName}" id="createUserName" />
							<input type="hidden" name="admin.createDate" value="${admin.createDate}" id="createDate" />
							<tag:auth code="sc.user.modifyuser">
							<input type="submit" name="btn_submit" value="保存" class="submit" />
							</tag:auth>
							&nbsp;
							<input type="reset" name="btn_reset" value="重置" class="reset" />&nbsp;
						 	<input type="button" name="" value="返回" class="reject" onclick="javascript:history.go(-1)" />
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
				  <ul id="treeDemo" class="ztree"></ul>
			</div>	
			<div class="pop_box_ctrl">
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
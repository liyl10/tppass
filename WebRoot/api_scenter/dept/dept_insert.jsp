<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 部门管理 - 添加
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
 -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>部门管理 - 添加</title>
		<link href="${pageContext.request.contextPath}/resource/css/yz.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/api_scenter/user/css/user.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/api_scenter/js/zTree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/validate.js"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/RegExp.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/dept/js/dept.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/dept/js/dept_insert.js" type="text/javascript"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/zTree/js/jquery.ztree.core-3.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/zTree/js/jquery.ztree.excheck-3.1.js"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/pop_box.js" type="text/javascript"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/hcsp_resources.js"></script>
<script type="text/javascript">
	
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
		
		var c_width= $(window).width(); 
		var c_height= $(window).height();
		 
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
		 
	});
	//
	-->

</script>
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 部门管理 - 添加
			</div>
			<form class="ropt">
			</form>
			<div class="clear"></div>
		</div>
		<div class="body-box">
			<form method="post" action="${pageContext.request.contextPath}/api/dept_insertDept.action" id="myform">
				<input type="hidden" id="pageContext" name="pageContext" value="${pageContext.request.contextPath}" />
				<input type="hidden" name="redirectUrl" value="${redirectUrl}" />
				<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
					<tr>
						<td class="pn-flabel pn-flabel-h">
							<span class="pn-frequired">*</span>上级部门:
						</td>
						<td class="pn-fcontent" >
							<input type="hidden" name="dept.scDept.deptId" id="userDeptId" value="" />
							<input type="text" name="userDeptName" value="无" id="userDeptName" readonly="readonly" />
						</td>
						<td class="pn-flabel pn-flabel-h">
							<span class="pn-frequired">*</span>是否启用:
						</td>
						<td class="pn-fcontent">
							<c:forEach items="${bean.childList }" var="state">
							<input type="radio" name="dept.enableState" value="${state.value }"/>${state.desc }
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h" >
							<span class="pn-frequired">*</span>部门名称:
						</td>
						<td class="pn-fcontent" >
							<input type="text" value="" name="dept.deptName" id="deptName" maxlength="40" />
						</td>
						<td class="pn-flabel pn-flabel-h" >
							<span class="pn-frequired">*</span>部门代码:
						</td>
						<td class="pn-fcontent" >
							<input type="text" name="dept.deptCode" id="deptCode" maxlength="20" />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							部门领导:
						</td>
						<td class="pn-fcontent">
							<input type="text" name="dept.deptLeader" id="deptLeader" maxlength="20" />
						</td>
						<td class="pn-flabel pn-flabel-h">
							部门联系人:
						</td>
						<td class="pn-fcontent">
							<input type="text" name="dept.deptLinkman" id="deptLinkman" maxlength="20" />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							办公地址:
						</td>
						<td class="pn-fcontent">
							<input type="text" value="" name="dept.deptAddress" id="deptAddress" maxlength="100" />
						</td>
						<td class="pn-flabel pn-flabel-h">
							邮编:
						</td>
						<td class="pn-fcontent">
							<input type="text" value="" name="dept.deptPostcode" id="deptPostcode" maxlength="6" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							联系电话:
						</td>
						<td class="pn-fcontent">
							<input type="text" value="" name="dept.deptPhone" id="deptPhone" maxlength="20" />
						</td>
						<td class="pn-flabel pn-flabel-h">
							传真:
						</td>
						<td class="pn-fcontent">
							<input type="text" value="" name="dept.deptFax" id="deptFax" maxlength="20" />
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							电子邮件:
						</td>
						<td class="pn-fcontent" colspan="3">
							<input type="text" value="" name="dept.deptEmaill" id="deptEmail" maxlength="50" />
							<input type="hidden" value="10" name="dept.deptOrder" id="deptOrder" maxlength="3" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
						</td>
						
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							部门介绍:
						</td>
						<td class="pn-fcontent" colspan="3">
							<textarea rows="6" cols="100" id="deptDesc" name="dept.deptDesc" class="textarea_box" ></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="4" class="pn-fbutton">
							<input type="hidden" value="" name="dept.deptId" id="deptId" />
							<tag:auth code="sc.dept.insertdept">
							<input type="submit" name="btn_submit" value="提交" class="submit" id="btn_submit" />
							</tag:auth>&nbsp;
							<input type="button" name="" value="返回" class="reject" onclick="javascript:history.go(-1)" />
						</td>
					</tr>
				</table>
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
				<input type="button" name="btn_pop_sure" id="btn_pop_sure_dept" value="提交" class="submit" />
				<input type="button" name="btn_pop_cancel" value="关闭" class="close-button" />
			
			</div>
		</div>
	</body>
</html>
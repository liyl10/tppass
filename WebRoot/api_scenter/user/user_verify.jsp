<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
@comment 用户信息审核表页面
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
-->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>用户管理 - 审核</title>
		<link href="${pageContext.request.contextPath}/resource/css/yz.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/validate.js"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/RegExp.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/pop_box.js" type="text/javascript"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/hcsp_resources.js"></script>
<script type="text/javascript">

	$(document).ready(function () {
		/*$("#myForm").bind("submit",function(){
			if(getStringLength($('#verifyNote').val())>200){
				alert("审核备注不超过200字！");
				$('#verifyNote').focus();
				return false;
			}
		});*/
		
		//初始化选中项
		 if($("input[name='admin.verifyState']:checked").length<1){
			 $("input[name='admin.verifyState']:eq(0)").attr("checked","checked");
		 }
		 
		/**
		 * 表单验证
		 */
		var demo=$("#myForm").Validform({
			tiptype:3,
			showAllError:true,
			datatype:{
				"verifyNote2":/^[\w\W]{0,200}$/,
				"verify_note":function(gets,obj,curform,regxp){
						var state=true;
				        //参数gets是获取到的表单元素值， //obj为当前表单元素， //curform为当前验证的表单， //regxp为内置的一些正则表达式的引用。
				        regxp=/^[\s\S]{0,200}$/;
		 				var reg_a=new RegExp(/[<]/g);
						var reg_b=new RegExp(/[>]/g);
						var reg_c=new RegExp(/[\s]{2,}/g);
						var reg_d=new RegExp(/[\s]/g);  //空白字符
				        var gets=trim_val(gets);
						gets=gets.replace(reg_a,"< "); //替换特殊字符
						gets=gets.replace(reg_b," >");
						gets=gets.replace(reg_c," ");
						var getd=gets.replace(reg_d,"**");//将所有的空白字符换为2个占位字符，用于统计字数
						if(getd.length>200){return false}
				        $(obj).attr("value",gets);
				        state=regxp.test(gets);
				        return state;  //表示验证出错，没有return或者return true表示验证通过。
				    }
			}
		});	
		
		demo.addRule([{
			ele:"#verifyNote",
			datatype:"verify_note",
			ignore:"ignore",
			tips:h_res.scenter.user.tips.verify,
			errormsg:h_res.scenter.user.errormsg.verify
		}]);
		
		$("[datatype]").focusin(function(){
		var tips = "<span class='custom_checktip'>"+$(this).attr("tips")+"</span>";
			$(this).parent().append(tips);
			$(this).siblings(".Validform_checktip").hide();
		}).focusout(function(){
			$(this).siblings(".custom_checktip").remove();
			$(this).siblings(".Validform_checktip").css("display","");
		});
	});

</script>
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 用户管理 - 审核
			</div>
			<div class="clear"></div>
		</div>
		<div class="body-box">
			<form method="post" action="${pageContext.request.contextPath}/api/user_verifyUser.action" id="myForm">	
				<input type="hidden" id="pageContext" name="pageContext" value="${pageContext.request.contextPath}" />
				<input type="hidden" name="redirectUrl" value="${redirectUrl}" />
				<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
					<tr>
						<td class="pn-flabel pn-flabel-h" >
							用户名:
						</td>
						<td class="pn-fcontent" >
							${admin.userName}
						</td>
						<td class="pn-flabel pn-flabel-h" >
							真实姓名:
						</td>
						<td class="pn-fcontent" >
							${admin.userRealname }
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h" >
							上级管理员:
						</td>
						<td class="pn-fcontent" >
						<c:if test="${!empty (admin.scUsersesForParentUserId)}">
							<c:forEach items="${admin.scUsersesForParentUserId}" var="parent">
							${parent.userName }
							</c:forEach>
						</c:if>
							
						</td>
						<td class="pn-flabel pn-flabel-h" >
							所属部门:
						</td>
						<td class="pn-fcontent" >
							${admin.scDept.deptName }
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							角色:
						</td>
						<td class="pn-fcontent">
							${admin.userNickname }
						</td>
						<td class="pn-flabel pn-flabel-h">性别: </td>
						<td class="pn-fcontent">
							<c:forEach items="${agent.childList }" var="sex">
							<c:if test="${sex.value == admin.userAgent}">${sex.desc }</c:if>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							联系电话:
						</td>
						<td class="pn-fcontent">
							${admin.userPhone }
						</td>
						<td class="pn-flabel pn-flabel-h">
							电子邮箱:
						</td>
						<td class="pn-fcontent">
							${admin.userEmail }
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							启用状态:
						</td>
						<td class="pn-fcontent" colspan="3">
							<c:forEach items="${bean.childList }" var="state">
							<c:if test="${state.value == admin.enableState}">${state.desc }</c:if>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							用户角色:
						</td>
						<td class="pn-fcontent" colspan="3">
							<c:forEach items="${roleList}" var="role">
							 ${role.selected=='true'?role.role.roleName:""}&nbsp;&nbsp;
						    </c:forEach>
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							用户分类:
						</td>
						<td class="pn-fcontent" colspan="3">
						 	<c:forEach items="${usertype.childList}" var="usertype">
						 		<c:if test="${usertype.value == admin.userType}">${usertype.desc }</c:if>
						 	</c:forEach>
						</td>
					</tr>
					<tr>
						<td class="pn-flabel pn-flabel-h">
							审核:
						</td>
						<td class="pn-fcontent" colspan="3">
							<label><input type="radio" name="admin.verifyState" value="1" ${admin.verifyState == '3'?"checked='checked'":""} />审核通过</label>	 
							<label><input type="radio" name="admin.verifyState" value="2" ${admin.verifyState == '4'?"checked='checked'":""} />审核不通过</label>
						</td>
					</tr>
					<tr id="verifyarea">
						<td class="pn-flabel pn-flabel-h">
							审核备注:
						</td>
						<td class="pn-fcontent" colspan="3">
							<textarea rows="3" cols="100" id="verifyNote" name="admin.verifyNote" class="textarea_box">${admin.verifyNote}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="4" class="pn-fbutton">
							<input type="hidden" value="${admin.userId}" name="admin.userId" id="userId" />
							<tag:auth code="sc.user.verifyuser">
							<input type="submit" name="btn_check" value="审核" class="check" />
							</tag:auth>
							&nbsp;
						 	<input type="button" name="" value="返回" class="reject" onclick="javascript:history.go(-1)" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
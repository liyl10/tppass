/**
 * @comment 用户信息添加、修改页面对应验证的js
 * @author dulei(dulei@hopsun.cn)
 * @date 2013-01-10
 * @version 1.0
 */
$(document).ready(function () {
	
	/**
	 * 表单验证
	 */
	var demo=$("#myform").Validform({
		tiptype:3,
		showAllError:true,
		datatype:{
			"userName":/^\s*[A-Za-z][A-Za-z0-9_]{5,18}\s*$/,
			"userRealname":/^[A-Z|a-z|\d|\s|\u4e00-\u9fa5]{1,20}$/,
			"userNickname":/^[A-Z|a-z|\d|\s|\u4e00-\u9fa5]{1,20}$/,
			"deptLeader":/^[A-Z|a-z|\d|\s|\u4e00-\u9fa5]{1,20}$/,
			"userPhone":/^(0[0-9]{2,3}-)?([2-9][0-9]{6,7})+(-[0-9]{1,4})?$/,
			"userEmail":/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
		}
	});	
	
	$("#userName").focusout(function(){
		demo.addRule([{
			ele:"#userName",
			datatype:"userName",
			ajaxurl:"${pageContext.request.contextPath}/api/user_getUserByName.action?username="+$('#userName').val(),
			tips:h_res.scenter.user.tips.username,
			nullmsg:h_res.scenter.user.nullmsg.username,
			errormsg:h_res.scenter.user.errormsg.username
		}]);
	});
	
	demo.addRule([{
		ele:"#userName",
		datatype:"*",
		tips:h_res.scenter.user.tips.username,
		nullmsg:h_res.scenter.user.nullmsg.username
	},
	{
		ele:"#userRealname",
		datatype:"userRealname",
		tips:h_res.scenter.user.tips.userRealname,
		nullmsg:h_res.scenter.user.nullmsg.userRealname,
		errormsg:h_res.scenter.user.errormsg.userRealname
	},
	{
		ele:"#userNickname",
		datatype:"userNickname",
		tips:h_res.scenter.user.tips.userNickname,
		errormsg:h_res.scenter.user.errormsg.userNickname
	},
	{
		ele:"#userParentName",
		datatype:"*",
		tips:h_res.scenter.user.tips.userParentName,
		nullmsg:h_res.scenter.user.nullmsg.userParentName
	},
	{
		ele:"#userPwd",
		datatype:"*6-20",
		tips:h_res.scenter.user.tips.userPwd,
		nullmsg:h_res.scenter.user.nullmsg.userPwd,
		errormsg:h_res.scenter.user.errormsg.userPwd
	},
	{
		ele:"#userPwd2",
		datatype:"*",
		recheck:"admin.userPwd",
		tips:h_res.scenter.user.tips.userPwd2,
		nullmsg:h_res.scenter.user.nullmsg.userPwd2,
		errormsg:h_res.scenter.user.errormsg.userPwd2
	},
	{
		ele:"#userPhone",
		datatype:"userPhone|m",
		ignore:"ignore",
		tips:h_res.scenter.user.tips.userPhone,
		errormsg:h_res.scenter.user.errormsg.userPhone
	},
	{
		ele:"#userEmail",
		datatype:"userEmail",
		ignore:"ignore",
		tips:h_res.scenter.user.tips.userEmail,
		errormsg:h_res.scenter.user.errormsg.userEmail
	}]);
	
	$("[datatype]").focusin(function(){
		var tips = "<span class='custom_checktip'>"+$(this).attr("tips")+"</span>";
		$(this).parent().append(tips);
		$(this).siblings(".Validform_checktip").hide();
	}).focusout(function(){
		$(this).siblings(".custom_checktip").remove();
		$(this).siblings(".Validform_checktip").css("display","");
	});
	 
})

function showAndHide(obj,types){
	var Layer=window.document.getElementById(obj);
	switch(types){
		case "show":
		Layer.style.display="block";
		break;
		case "hide":
		Layer.style.display="none";
	}
}
function getValue(obj,str){
	var input=window.document.getElementById(obj);
	input.value=str;
}
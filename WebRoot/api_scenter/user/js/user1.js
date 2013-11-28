/**
 * @comment 用户信息添加、修改页面对应验证的js
 * @author dulei(dulei@hopsun.cn)
 * @date 2013-01-10
 * @version 1.0
 */
$(document).ready(function () {
	$("#myform").bind("submit",function(){
		 
		$("#userName").attr("value",trim_val($("#userName").val()));   //去除首尾空格
		if(ifnull($('#userName').val())){
			alert("用户名不能为空！");
			$('#userName').focus();
			return false;
		}else if(!validateUsername($('#userName').val())){
			alert("用户名应为6-18个数字、字母、下划线，以字母开头。");
			$('#userName').focus();
			return false;
		}
		
		$("#userRealname").attr("value",trim_val($("#userRealname").val()));   //去除首尾空格
		if(ifnull($('#userRealname').val())){
			alert("真实姓名不能为空！");
			$('#userRealname').focus();
			return false;
		}else if(!nameValidate($('#userRealname').val(),$('#userRealname'))){
			alert("真实姓名仅支持1-20个汉字、字母、空格！");
			$('#userRealname').focus();
			return false; 
		}
		
		if(!ifnull($('#userNickname').val()) && !nameValidate($('#userNickname').val(),$('#userNickname'))){
			alert("昵称仅支持1-20个汉字、字母、空格！");
			$('#userNickname').focus();
			return false; 
		}
		
	//	if(ifnull($('#deptId').val())){
	//		$("#error_deptId").html("请选择所属部门！");
	//		showAndHide('List3','show');
	//		$('#deptId').focus();
	//		return false;
	//	}else{
	//		$("#error_deptId").html("");
	//		showAndHide('List3','hide');
	//	}
		
		if($("input[name='parentId']").filter(":checked").length<1){
			alert("请选择上级管理员!");
			$('#userParentName').focus();
			return false;
		}
		
		$("#userPwd1").attr("value",trim_val($("#userPwd1").val()));   //去除首尾空格
		
		if(ifnull($('#userId').val())){
			if(ifnull($('#userPwd1').val())){
				alert("密码不能为空!");
				$('#userPwd1').focus();
				return false;
			}else if(!pwdValidate($('#userPwd1').val())){
				//alert("密码仅支持6-20位字符");
				$('#userPwd1').focus();
				return false;
			}
			
			if($('#userPwd1').val() != $('#userPwd2').val()){
				alert("两次密码不一致");
				$('#userPwd2').focus();
				return false;
			}else{
				$('#userPwd').val($('#userPwd1').val());
			}
		}else if(!ifnull($('#userPwd1').val())){
			
			if(ifnull($('#userPwd1').val())){
				alert("密码不能为空！");
				$('#userPwd1').focus();
				return false;
			}
			
			if($('#userPwd1').val() != $('#userPwd2').val()){
				alert("重复密码有误！")
				$('#userPwd2').focus();
				return false;
			}else{
				$('#userPwd').val($('#userPwd1').val());
			}
		}
		
		$("#userPhone").attr("value",trim_val($("#userPhone").val()));   //去除首尾空格    
		var userPhone = $('#userPhone').val();
		if(!ifnull(userPhone)){
			if(!phoneValidate(userPhone) && !mobileValidate(userPhone)){
				alert("电话号码格式不正确，请重新输入！");
				$('#userPhone').focus();
				return false;
			}
		}
		
		$("#userEmail").attr("value",trim_val($("#userEmail").val()));   //去除首尾空格   
		var userEmail = $('#userEmail').val();
		if(!ifnull(userEmail) && !email(userEmail)){
			alert("邮箱格式不正确，请重新输入！");
			$('#userEmail').focus();
			return false;
		}
	});
	
	//根据部门查询用户
	//
	//$("#deptId").bind("blur",function(){
	//	
	//	var deptid = $("#deptId").val();
	//	
	//	$.get("../api/user_getUsersByDept.action",{ deptid: deptid },
	//	 function(data){
	//		var users = eval('(' + data + ')');
	//		var str = "<option value=''>请选择上级管理员..</option>";
	//		for(var i=0;i<users.length;i++){
	//			var user = users[i];
	//			str += "<option value='"+user.userid+"'>"+user.name+" - "+user.realname+"</option>";
	//		}
	//		$("#userParentId").html(str);
 	//	});
	// });
	//
	 //查询用户名是否存在
	 $("#userName").bind("blur",function(){
		var userName = $("#userName").val();
	 	$.ajax({
			type: "post",  
			contentType:"application/x-www-form-urlencoded; charset=UTF-8", //声明编码  
			url: "../api/user_getUserByName.action",  
			data: { username: userName },  
			success: function(data){  
				var flag =  data ;
				if(flag == 'false'){
					alert("用户名已存在！");
				}
			}  
		}); 
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
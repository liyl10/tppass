//var path = "http://localhost:8880/tppass";
var path;

$(function() {
	//var sHost = location.host;//url-127.0.0.1：8080
	//var sProtocol = location.protocol;//协议-http:
	path = $("#loginPath").val();
});
function nTabs(thisObj,index){
	$("#select_dept" + index + " option:first").prop("selected", 'selected');
	$("#select_post" + index + " option:first").prop("selected", 'selected');
	reloadImage(index);
	$("#index").val(index);
	$("#password" + index).val("");
	$("#number" + index).val("");
	
	if(thisObj.className == "active"){
		return;
	}
	var tabObj = thisObj.parentNode.id;
	var tabList = document.getElementById(tabObj).getElementsByTagName("li");
	for(i=0; i <tabList.length; i++){
		if (i == index){
			thisObj.className = "active"; 
			document.getElementById(tabObj+"_Content"+i).style.display = "block";
		}else{
		   tabList[i].className = "normal";
		   document.getElementById(tabObj+"_Content"+i).style.display = "none";
		}
	}
}

function change(obj, index){
	if($("#" + obj.id) != null && (index == 0 || index == 1 || index == 2)){
		$("#password" + index).val("");
		$("#number" + index).val("");
		if($("#" + obj.id).val() != null && $("#" + obj.id).val() != '' && $("#" + obj.id).val() != '请选择'){
			reloadImage(index);
			$("#select_post" + index).empty();
			$("#select_post" + index).append("<option>请选择</option>");
			$.ajax({
				url: path + "/login/getpost.action",
		     	type:'post',
		      	dataType:'json',
		      	data: {userType:index, id:$("#" + obj.id).val()},
		      	success: function(data){
		      		var users = eval(data);
		      		for(var i = 0; i < users.length; i++){
		      			var user = users[i];
		      			if(user.userName != 'admin'){
		      				$("#select_post" + index).append("<option value='" + user.userName + "'>" + user.userNickname + "</option>");
		      			}
		      		}
		      	}
			});
		}else{
			$("#select_post" + index).empty();
			$("#select_post" + index).append("<option value=\"\">请选择</option>");
		}
	}
}

function changepost(obj, index){
	if($("#" + obj.id) != null && (index == 0 || index == 1 || index == 2)){
		$("#password" + index).val("");
		$("#number" + index).val("");
		
		if($("#" + obj.id).val() != null && $("#" + obj.id).val() != '' && $("#" + obj.id).val() != '请选择'){
			reloadImage(index);
		}
	}
}


function reloadImage(index){
	var obj = document.getElementById("img" + index);
   	obj.src= path + "/api_scenter/login/image.jsp?d="+new Date().getTime();
}

/**
 * @comment 管理中心登陆验证对应的js
 * @author dulei(dulei@hopsun.cn)
 * @date 2013-01-10
 * @version 1.0
 */
$(document).ready(function(){
	var submit0 = $("#submit0");
	var submit1 = $("#submit1");
	var submit2 = $("#submit2");
	
	submit0.add(submit1).add(submit2).click(function () {
		var index = $("#index").val();
		var name = $("#select_post" + index).val();
		var pwd = $("#password" + index).val();
		var number = $("#number" + index).val();
		
		if(name == null || name == '' || name == '请选择'){
			if(index == 1){
				alert("请根据部门选择角色!");
			}else{
				alert("请选择角色!");
			}
			
			return false;
		}
		
		if(pwd == null || pwd == ''){
			alert("请输入密码！");
			$("#password" + index).focus();
			return false;
		}
		
		if(number == null || number == ''){
			alert("请输入验证码！");
			$("#number" + index).focus();
			return false;
		}
		
		$.ajax({
			url: path + "/api/login_ajaxLogin.action",
	     	type:'post',
	      	data: { userName: name, userPwd: pwd, number:number},
	      	success: function(data){
	      		if(data == 1){
					if(window.parent.parentt == undefined || window.parent.parentt == null){
						window.parent.parent.location.href="../api/login_index.action";
					}else{
						window.location.href = "../api/login_index.action";
					}
				}else if(data == 2){
					reloadImage(index);
					$("#password" + index).val("");
					$("#number" + index).val("");
					alert("密码有误!");
				}else if(data == 3){
					reloadImage(index);
					$("#password" + index).val("");
					$("#number" + index).val("");
					alert("用户名不存在或为受限用户!");
				}else{
					reloadImage(index);
					$("#password" + index).val("");
					$("#number" + index).val("");
					alert("验证码有误!");
				}
	      	}
		});
	});
});

//按下回车键Reg

$(document).keypress(function(event) {//keydown
	var keycode = event.which;
	if (keycode == 13) {
		var index = $("#index").val();
		$("#password" + index).blur();
		$("#number" + index).blur();
		$("#submit" + index).click();
	}
});
/**
 * @comment 管理中心登陆验证对应的js
 * @author dulei(dulei@hopsun.cn)
 * @date 2013-01-10
 * @version 1.0
 */
$(document).ready(function(){
	 $("#Submit").bind("click",function(){
		   if(ifnull($("#userName").val())){
			   alert("请输入用户名！");
			   $("#userName").focus();
			   return false;
		   }
		   if(ifnull($("#userPwd").val())){
			   alert("请输入密码！");
			   $("#userPwd").focus();
			   return false;
		   }
		  
		  /*if(ifnull($("#number").val())){
			   alert("请输入验证码！");
			   $("#number").focus();
			   return false;
		  }*/
		
		var name = $("#userName").val();
		var pwd = $("#userPwd").val();
		var number = $("#number").val();
		
		$.get("../../api/login_ajaxLogin.action",{ userName: name, userPwd: pwd, number:number },
		 function(data){
			if(data == 1){
				//alert("登陆成功!");
				if(window.parent.parentt == undefined || window.parent.parentt == null){
					window.parent.parent.location.href="../../api/login_index.action";
				}else{
					window.location.href = "../../api/login_index.action";
				}
			}else if(data == 2){
				alert("密码有误!");
			}else if(data == 3){
				alert("用户名不存在或为受限用户!");
			}else{
				alert("验证码有误!");
			}
 		});
	
	 });
	// $("#Submit").click();
});

//按下回车键Reg
$(document).keypress(function(event) {//keydown
	var keycode = event.which;
	if (keycode == 13) {
		$("#Submit").click();
	}
});
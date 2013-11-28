//自定义去除首尾空格
function trim_yxy(str) {
	if(str!=null&&str!='undefind'){
		return str.replace(/(^\s*)|(\s*$)/g, "");
		}
}

$(document).ready(function(){
		 //jquery start
		 //初始化警告信息框
	  			// $("#dialog").dialog({
				//		title:"警告",
				//		autoOpen:false,
				//		modal: true
				//		}
				//	);
		 //添加角色（role_insert_form）提交时进行验证
	 	 $("#role_insert_form").submit(function(e){
	 	 if(!($.checkformes_insert())){ 	  
	 	  return false;
	 	  }
	 	  return true;
	 	 })	
	 	  //修改角色（role_modify_form）提交时进行验证
	 	 $("#role_modify_form").submit(function(e){
	 	 if(!($.checkformes_update())){ 	  
	 	  return false;
	 	  }
	 	  return true;
	 	 })	  
	 	 
	 	  //审核角色（role_verify_form）提交时进行验证
	 	 $("#role_verify_form").submit(function(e){
	 	 if(!($.checkformes_verify())){ 	  
	 	  return false;
	 	  }
	 	  return true;
	 	 })	
	 	 
	   //角色添加表单验证函数开始
	   $.extend({checkformes_insert:function(){
	   		//角色名称不能为空	
 			$("input[name='role_name']").attr("value",trim_val($("input[name='role_name']").val()));   //去除首尾空格
	   		if(ifnull($("input[name='role_name']").val())){
			   	 //$("#dialog_content").html("角色名称不能为空！");
				 //$("#dialog").dialog("open");
				 alert("角色名称不能为空！");
			   	 $("input[name='role_name']").focus();
				 return false;
	   		}else if(!nameValidate_a($("input[name='role_name']"))){
				alert("角色名称仅支持1-40个汉字、字母！");
				$("input[name='role_name']").focus();
				return false;
		   }
		 
	   		
	   		$("#role_desc").attr("value",trim_val($("#role_desc").val()));   //去除首尾空格
	   		if(getStringLength($("#role_desc").val())>200){
	   			 //$("#dialog_content").html("角色描述不能超过200字！");
				 //$("#dialog").dialog("open");
				 alert("角色描述不能超过200字！");
			   	 $("#role_desc").focus();
				 return false;
	   		}
	   		$("#role_order").attr("value",trim_val($("#role_order").val()));   //去除首尾空格
	   		if(isNaN($("#role_order").val())){
	   			//$("#dialog_content").html("排序必须为数字！");
				//$("#dialog").dialog("open");
				alert("排序必须为数字！");
			   	 $("#role_order").focus();
				 return false;
	   		}
	   		//
	   		return true;
		}
		});
		//角色修改表单验证函数开始
	   $.extend({checkformes_update:function(){
	   		//角色名称不能为空	
 			$("input[name='role_name']").attr("value",trim_val($("input[name='role_name']").val()));   //去除首尾空格
	   		if(ifnull($("input[name='role_name']").val())){
	   			//$("#dialog_content").html("角色名称不能为空！");
				//$("#dialog").dialog("open");
				alert("角色名称不能为空！");
			   	 $("input[name='role_name']").focus();
				 return false;
	   		}else if(!nameValidate_a($("input[name='role_name']"))){
				alert("角色名称仅支持1-40个汉字、字母！");
				$("input[name='role_name']").focus();
				return false;
		   }
		    
	   		$("#role_desc").attr("value",trim_val($("#role_desc").val()));   //去除首尾空格
	   		if(getStringLength($("#role_desc").val())>200){
	   			//$("#dialog_content").html("角色描述不能超过200字！");
				//$("#dialog").dialog("open");
				alert("角色描述不能超过200字！");
			   	 $("#role_desc").focus();
				 return false;
	   		}
	   		$("#role_order").attr("value",trim_val($("#role_order").val()));   //去除首尾空格
	   		if(isNaN($("#role_order").val())){
	   			//$("#dialog_content").html("排序必须为数字！");
				//$("#dialog").dialog("open");
				alert("排序必须为数字！");
			   	 $("#role_order").focus();
				 return false;
	   		}
	   		
	   		//
	   		return true;
		}
		});
		
		//角色审核表单验证函数开始
	   $.extend({checkformes_verify:function(){
	   
	   		$("#verify_note").attr("value",trim_val($("#verify_note").val()));   //去除首尾空格
	   		if(!ifnull($("#verify_note").val())){
		   		if(getStringLength($("#verify_note").val())>200){
					 alert("审核备注不能超过200字！");
				   	 $("#verify_note").focus();
					 return false;
		   		} 
		   		}
	   		//
	   		return true;
		}
		});
		
 					/*
						 取消按钮被点击
					 */
					 $("input[name='btn_cancel']").click(function(){										  
							window.history.go(-1);
					 	 });
		   //jquery end						   
 });
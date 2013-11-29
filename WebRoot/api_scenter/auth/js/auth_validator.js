//自定义去除首尾空格
function trim_yxy(str) {
	if(str!=null&&str!='undefind'){
		return str.replace(/(^\s*)|(\s*$)/g, "");
		}
}
//上传图片
function uploadImage(path,formid) {  
    $(document).ready(  
                    function() {  
                    var fileupload =$("#fileupload").val();
                    if(fileupload==null||fileupload==''){
                      alert("请选择图片!");
                      return false;
                    }
                        var options = {  
                            url : path+"/api/auth/uploadImage.action",//跳转到相应的Action  
                            type : "POST",//提交方式  
                            dataType : "script",//数据类型  
                            success : function(data) {
                            //调用Action后返回过来的数据  
                            var r_data=eval(data);
	                            if(r_data[0].flag=='1'){
	                            $("#showImage").html("<img src='"+r_data[0].msg+"' width='60' height='60'/>"); 
	                            $("#up_imgurl").val(r_data[0].msg);
	                            }else{
	                            	alert("上传失败");
	                            }
                            }  
                        };  
                        $("#"+formid+"").ajaxSubmit(options);//绑定页面中form表单的id  
                        return false;  
                    });  
     }
   
     
     
     
      
$(document).ready(function(){
		 //jquery start
		// $("#new_auth_name").qtip({
		//		  	content: "权限名称不能为空！",show: { ready: true}, hide: false,  style:{classes: 'tip_msg',
		//		  	 // tip插件，箭头相关设置
      //tip: {
      //   corner: true,
      //   mimic: false,
     //    width: 8,
     //    height: 8,
     //    border: true,
     //    offset: 0
     // }
		//		  	}
		//		});
		//初始化警告信息框
	  	//		 $("#dialog").dialog({
		//				title:"警告",
		//				autoOpen:false,
		//				modal: true
		//				}
		//			);
		 //添加角色（role_insert_form）提交时进行验证
	 	 $("#form_insert").submit(function(e){
	 	 if(!($.checkformes_insert())){ 	  
	 	  return false;
	 	  }
	 	  return true;
	 	 })	
	 	  //修改（modify_form）提交时进行验证
	 	 $("#form_modify").submit(function(e){
	 	 
	 	 if(!($.checkformes_update())){ 	  
	 	  return false;
	 	  }
	 	  return true;
	 	 })	  
	 	 
	   //添加表单验证函数开始
	   $.extend({checkformes_insert:function(){
	   
	   		  //权限名称不能为空
			$("#new_auth_name").attr("value",trim_val($("#new_auth_name").val()));   //去除首尾空格
			if(ifnull($("#new_auth_name").val())){	
			 	//$("#dialog_content").html("权限名称不能为空！");
				//$("#dialog").dialog("open");	
				alert("权限名称不能为空！");
				$("#new_auth_name").focus();
				//$("#new_auth_name").qtip({
				//  	content: "权限名称不能为空！",show: { ready: true}, hide: false
				//});
				return false;
			} 
			//权限名称不能为空
			$("#new_auth_code").attr("value",trim_val($("#new_auth_code").val().toLowerCase()));   //去除首尾空格,并转化为小写
			if(ifnull($("#new_auth_code").val())){				
				//$("#dialog_content").html("权限code不能为空！");
				//$("#dialog").dialog("open");
				alert("权限code不能为空！");
				$("#new_auth_code").focus();
				return false;
			}
			//权限描述不能超过200字
			$("#new_auth_desc").attr("value",trim_val($("#new_auth_desc").val()));   //去除首尾空格
	   		if($("#new_auth_desc").val().length>200){
				// $("#dialog_content").html("权限描述不能超过200字！");
				// $("#dialog").dialog("open");
				 alert("权限描述不能超过200字！");
			   	 $("#new_auth_desc").focus();
				 return false;
	   		} 	
			
			//排列顺序必须输入整数
			$("#new_auth_order").attr("value",trim_val($("#new_auth_order").val()));   //去除首尾空格
			if(!ifnull($("#new_auth_order").val())){			
				if(!isnumber($("#new_auth_order").val())){
				//  $("#dialog_content").html("权限顺序必须输入整数！");
				//	$("#dialog").dialog("open");
				 
				alert("权限顺序必须输入整数！");
				$("#new_auth_order").focus();
				return false;
				}
				}
	   		//
	   		 
	   		return true;
		}
		});
		// 修改表单验证函数开始
	   $.extend({checkformes_update:function(){
			 //权限名称不能为空
			$("#edit_auth_name").attr("value",trim_val($("#edit_auth_name").val()));   //去除首尾空格
			if(ifnull($("#edit_auth_name").val())){
				  // $("#dialog_content").html("权限名称不能为空！");
				  //  $("#dialog").dialog("open");				
			 	alert("权限名称不能为空！");
				$("#edit_auth_name").focus();
				return false;
			} 
			//权限名称不能为空
			$("#edit_auth_code").attr("value",trim_val($("#edit_auth_code").val().toLowerCase()));   //去除首尾空格,并转化为小写
			if(ifnull($("#edit_auth_code").val())){	
				    //$("#dialog_content").html("权限code不能为空！");
					//$("#dialog").dialog("open");	
				alert("权限code不能为空！");			
				$("#edit_auth_code").focus();
				return false;
			}
			//权限描述不能超过200字
			$("#edit_auth_desc").attr("value",trim_val($("#edit_auth_desc").val()));   //去除首尾空格
	   		if($("#edit_auth_desc").val().length>200){
	   			    //$("#dialog_content").html("权限描述不能超过200字！");
					//$("#dialog").dialog("open");	
		   		 alert("权限描述不能超过200字！");
			   	 $("#edit_auth_desc").focus();
				 return false;
	   		} 	
			
			//排列顺序必须输入整数
			$("#edit_auth_order").attr("value",trim_val($("#edit_auth_order").val()));   //去除首尾空格
			if(!ifnull($("#edit_auth_order").val())){			
				if(!isnumber($("#edit_auth_order").val())){
				  //  $("#dialog_content").html("权限顺序必须输入整数！");
				  //  $("#dialog").dialog("open");
				alert("权限顺序必须输入整数！"); 
				$("#edit_auth_order").focus();
				return false;
				}
				}
	   		//
	   		return true;
		}
		});
 
		   //jquery end						   
 });
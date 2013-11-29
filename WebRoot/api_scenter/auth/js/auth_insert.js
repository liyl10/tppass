
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
		 $("input[name='new_auth_type']:eq(0)").attr("checked","checked");
		 $("input[name='opentype_state']:eq(0)").attr("checked","checked");
		 $("input[name='edit_enable_state']:eq(0)").attr("checked","checked");
		 
	/**
	 * 表单验证
	 */
	var validform=$("#form_insert").Validform({
		tiptype:3,
		showAllError:true,
		datatype:{
			"new_auth_name":/^[A-Z|a-z|\u4e00-\u9fa5]{1,10}$/,
			"new_auth_desc":/^[A-Z|a-z|\u4e00-\u9fa5]{0,200}$/
		}
	});
 	
	validform.addRule([
		{
		ele:"#new_auth_name",
		datatype:"new_auth_name",
		tips:h_res.scenter.auth.nullmsg.new_auth_name,
		nullmsg:h_res.scenter.auth.nullmsg.new_auth_name
		},
		{
		ele:"#new_auth_code",
		datatype:"*",
		tips:h_res.scenter.auth.nullmsg.new_auth_code,
		nullmsg:h_res.scenter.auth.nullmsg.new_auth_code
		},
		{
		ele:"#new_auth_desc",
		datatype:"*0-200",
		tips:h_res.scenter.auth.nullmsg.new_auth_desc,
		nullmsg:h_res.scenter.auth.nullmsg.new_auth_desc
		},
		{
		ele:"#new_auth_order",
		datatype:"n1-10",
		tips:h_res.scenter.auth.nullmsg.new_auth_order,
		nullmsg:h_res.scenter.auth.nullmsg.new_auth_order
		}     
	]);
	
	$("[datatype]").focusin(function(){
		var tips = "<span class='custom_checktip'>"+$(this).attr("tips")+"</span>";
		$(this).parent().append(tips);
		$(this).siblings(".Validform_checktip").hide();
	}).focusout(function(){
		$(this).siblings(".custom_checktip").remove();
		$(this).siblings(".Validform_checktip").css("display","");
		$(this).attr("value",trim_val($(this).val()));   //去除首尾空格
	});
		 //jquery end						   
 });
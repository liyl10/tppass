//自定义去除首尾空格
function trim_yxy(str) {
	if(str!=null&&str!='undefind'){
		return str.replace(/(^\s*)|(\s*$)/g, "");
		}
}

$(document).ready(function(){
	 //jquery start
	 /*
		 取消按钮被点击
	 */
	 $("input[name='btn_cancel']").click(function(){										  
			window.history.go(-1);
	 	 });
	 /*
	 	角色名称验证

	 $("input[name='role_name']").blur(function(){
	 	 var url_go=url_cur+"/api/role/role_ajaxCheckName.action";
	 	$.post(url_go, { Action: "post", role_name: $("#role_name").val(),role_id:'4028b33a3c8fcb8b013c8fce931f0000'}, 
							function (data){
								 if(data!='yes'){alert("角色名称已经存在！");}
							 }
							 );
	 });
	 	 */	
	 
					 	 
	/**
	 * 表单验证
	 */
	var validform=$("#role_insert_form").Validform({
		tiptype:3,
		showAllError:true,
		datatype:{
			"roleName":/^[A-Z|a-z|\d|\u4e00-\u9fa5]{1,40}$/,
			"roleDesc":function(gets,obj,curform,regxp){
						var state=true;
				        //参数gets是获取到的表单元素值， //obj为当前表单元素， //curform为当前验证的表单， //regxp为内置的一些正则表达式的引用。
				        regxp=/^[\s\S]{0,200}$/;
		 				var reg_a=new RegExp(/[<]/g);
						var reg_b=new RegExp(/[>]/g);
						var reg_c=new RegExp(/[\s]{2,}/g);  //连续空格
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
	/*
	 	角色名称验证
	 */ 
	$("input[name='role_name']").focusout(function(){
		validform.addRule([{
			ele:"input[name='role_name']",
			datatype:"roleName",
			ajaxurl:url_cur+"/api/role/role_ajaxCheckName.action?role_name="+$('#role_name').val(),
			nullmsg:h_res.scenter.role.nullmsg.role_name,
			errormsg:h_res.scenter.role.errormsg.role_name
		}]);
	});		
	validform.addRule([
		{
		ele:"input[name='role_name']",
		datatype:"roleName",
		tips:h_res.scenter.role.tips.role_name,
		nullmsg:h_res.scenter.role.nullmsg.role_name,
		errormsg:h_res.scenter.role.errormsg.role_name
		},
		{
		ele:"#role_desc",
		datatype:"roleDesc",
		ignore:"ignore",
		tips:h_res.scenter.role.tips.role_desc,
		errormsg:h_res.scenter.role.errormsg.role_desc
		},
		{
		ele:"#role_order",
		datatype:"n1-10",
		tips:h_res.scenter.role.tips.role_order,
		errormsg:h_res.scenter.role.errormsg.role_order
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
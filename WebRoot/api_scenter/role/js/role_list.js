//自定义去除首尾空格
function trim_yxy(str) {
	if(str!=null&&str!='undefind'){
		return str.replace(/(^\s*)|(\s*$)/g, "");
		}
}
				function onlineuserClick(){
					document.forms[1].action = url_cur+"/api/role/role_view.action";
				   	document.forms[1].submit();
				}
				
$(document).ready(function(){
		 //jquery start
		    //全选
			     $("#checked").click(function(){
				 	var type = $("#checkedtype").val();
				 	if(type == 0){
					 	$('input[name=ids]').attr("checked", true );
				 		$("#checkedtype").val("1")
				 	}else{
				 		$('input[name=ids]').attr("checked", false);
				 		$("#checkedtype").val("0")
				 	}
				 });
				 
				 $('[name=ids]:checkbox').click(function(){
				 	var $tmp=$('[name=ids]:checkbox');
				 	$('#checked').attr('checked',$tmp.length==$tmp.filter(':checked').length?true:false);
				 	if($tmp.length==$tmp.filter(':checked').length){
				 		$("#checkedtype").val("1");
				 	}else{
				 		$("#checkedtype").val("0");
				 	}
				  });
	  
					  
 			//启用
 			
 			 $("input[name='btn_enable']").click(function(){
					 	 if($("input[name='ids']").filter(":checked").length>0){
						 if (confirm("您确定要启用该角色？")) {
						 	$("#myform").attr("action",url_cur+"/api/role/role_enable.action");
							$("#myform").submit();
						 }
						 
					}else{
						alert("请选择要启用的角色！");
					}
					 });
			//禁用
 			 $("input[name='btn_disable']").click(function(){
					 	if($("input[name='ids']").filter(":checked").length>0){
						 if (confirm("您确定要禁用该角色？")) {
						 	$("#myform").attr("action",url_cur+"/api/role/role_disable.action");
							$("#myform").submit();
						 }
						 
					}else{
						alert("请选择要禁用的角色！");
					} 
					 });
			//删除
 			 $("input[name='btn_delete']").click(function(){	 
					 if($("input[name='ids']").filter(":checked").length>0){
						 if (confirm("您确定要删除该角色信息？")) {
								 $("#myform").attr("action",url_cur+"/api/role/role_delete.action");
							     $("#myform").submit();
						 }
					}else{
						alert("请选择要删除的角色！");
					}		 
 			 });
 			 
 		
 		// 搜索验证	 
 		$("form[name='queryform']").submit(function(e){
			  $("form[name='queryform'] :text").each(function(){
				$(this).attr("value",trim_val($(this).val())); //去除首尾空格
			  });
			     
	 	  return true;
	 	 });
		   //jquery end						   
 });
/**
 * @comment 用户信息管理列表页面对应的js
 * @author dulei(dulei@hopsun.cn)
 * @date 2013-01-10
 * @version 1.0
 */

/**
 * 全选、取消
**/
$(function(){
	/**
	 * 全选按钮事件绑定
	 */
	$("#CheckedAll").click(function(){
		//所有checkbox跟着全选的checkbox走。
		$('[name="ids"]:checkbox').attr("checked", this.checked );
	});
	/**
	 * checkbox全选事件触发
	 */
	$('[name="ids"]:checkbox').click(function(){
		//定义一个临时变量，避免重复使用同一个选择器选择页面中的元素，提升程序效率。
		var $tmp=$('[name="ids"]:checkbox');
		//用filter方法筛选出选中的复选框。并直接给CheckedAll赋值。
		$('#CheckedAll').attr('checked',$tmp.length==$tmp.filter(':checked').length);
	});
	  
	  
	//部门树
	$.fn.zTree.init($("#dept_tree"), setting, zNodesDept);
	var zTreeDept = $.fn.zTree.getZTreeObj("dept_tree");
	
	var c_width= $(window).width(); 
	var c_height= $(window).height();
	 
	 //选择部门
	$("#userDeptName").click(function(){
		 $("#pop_box_dept").show();
		 $("#pop_box_dept").css("left",(c_width-($("#pop_box_dept").width()))/2+"px");
		 $("#pop_box_dept").css("top",(c_height-($("#pop_box_dept").height()))/2+"px");
	});
	 	// 点击确定按钮
	$("#btn_pop_sure_dept").click(function(){	
	 	var nodes_checked=zTreeDept.getCheckedNodes(true);
	 	if(nodes_checked.length>0){
	 	$("#userDeptId").attr("value",nodes_checked[0].id);
	    $("#userDeptName").attr("value",nodes_checked[0].name);
	    $(this).parent().parent().hide();
	    }else{
	    	alert("请选择部门！")
	    }
	 });
	  
});
/**
 * 批量删除
**/
function deleteClick(){
	if($("input[name='ids']").filter(":checked").length>0){
		if (confirm("你确定要删除该用户信息？")) {
			document.forms[1].action = $("#pageContext").val()+"/api/user_deleteUser.action";
	    	document.forms[1].submit();
		}
	}else{
		alert("请选择要删除的用户！")
	}
}
/**
 * 单个删除
**/
function deleteObj(ids){
	if (confirm("你确定要删除该用户信息？")) {
		$('[name=ids]').attr("checked", false );
		document.forms[1].action = $("#pageContext").val()+"/api/user_deleteUser.action?ids="+ids;
    	document.forms[1].submit();
	}
}

/**
 * 审核
**/
function verifyObj(ids){
	$('[name=ids]').attr("checked", false );
	document.forms[1].action = $("#pageContext").val()+"/api/user_verify.action?admin.userId="+ids;
   	document.forms[1].submit();
}

/**
 * 添加
**/
function addObj(ids){
	document.forms[1].action = $("#pageContext").val()+"/api/user_insert.action";
   	document.forms[1].submit();
}

/**
 * 修改
**/
function modifyObj(ids){
	document.forms[1].action = $("#pageContext").val()+"/api/user_modify.action?admin.userId="+ids;
   	document.forms[1].submit();
}

/**
 * 启用
**/
function enableClick(){
	if($("input[name='ids']").filter(":checked").length>0){
		if (confirm("你确定要启用该用户？")) {
			document.forms[1].action = $("#pageContext").val()+"/api/user_enableUser.action";
	    	document.forms[1].submit();
		}
	}else{
		alert("请选择要启用的用户！")
	}
}
/**
 * 禁用
**/
function disableClick(){
	if($("input[name='ids']").filter(":checked").length>0){
		if (confirm("你确定要禁用该用户？")) {
			document.forms[1].action = $("#pageContext").val()+"/api/user_disableUser.action";
	    	document.forms[1].submit();
		}
	}else{
		alert("请选择要禁用的用户！")
	}
}
/**
 * 重置密码
**/
function resetpwdClick(){
	if($("input[name='ids']").filter(":checked").length>0){
		if (confirm("你确定要重置该用户密码？")) {
			document.forms[1].action = $("#pageContext").val()+"/api/user_resetUserpwd.action";
	    	document.forms[1].submit();
		}
	}else{
		alert("请选择要重置密码的用户！")
	}
}
/**
 * @comment 部门管理 - 列表页面对应的js
 * @author dulei(dulei@hopsun.cn)
 * @date 2013-01-10
 * @version 1.0
 */
 
 /**
 * 全选、取消
 */
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
	  
	  // 搜索验证	 
 		$("form[name='queryform']").submit(function(e){
			  $("form[name='queryform'] :text").each(function(){
				$(this).attr("value",trim_val($(this).val())); //去除首尾空格
			  });
			     
	 	  return true;
	 	 });
	 	 
	 	 //启用
 			
 			 $("input[name='btn_enable']").click(function(){
					 	 if($("input[name='ids']").filter(":checked").length>0){
						 if (confirm("您确定要启用该部门？")) {
						 	$("#myform").attr("action",url_cur+"/api/dept_enable.action");
							$("#myform").submit();
						 }
						 
					}else{
						alert("请选择要启用的部门！");
					}
					 });
			//禁用
 			 $("input[name='btn_disable']").click(function(){
					 	if($("input[name='ids']").filter(":checked").length>0){
						 if (confirm("您确定要禁用该部门？")) {
						 	$("#myform").attr("action",url_cur+"/api/dept_disable.action");
							$("#myform").submit();
						 }
						 
					}else{
						alert("请选择要禁用的部门！");
					} 
					 });
	  
});

/**
 * 批量删除
 */
function deleteClick(){
	if($("input[name='ids']").filter(":checked").length>0){
		if (confirm("你确定要删除该信息？")) {
			document.forms[1].action = $("#pageContext").val()+"/api/dept_deleteDept.action";
	    	document.forms[1].submit();
		}
	}else{
		alert("请选择要删除的数据！")
	}
}

/**
 * 单个删除
 */
function deleteObj(ids){
	if (confirm("你确定要删除该信息？")) {
		$('[name=ids]').attr("checked", false );
		document.forms[1].action = $("#pageContext").val()+"/api/dept_deleteDept.action?ids="+ids;
    	document.forms[1].submit();
	}
}

/**
 * 添加
 */
function addObj(){
	document.forms[1].action = $("#pageContext").val()+"/api/dept_insert.action";
   	document.forms[1].submit();
}

/**
 * 修改
 */
function modifyObj(ids){
	$('[name=ids]').attr("checked", false );
	document.forms[1].action = $("#pageContext").val()+"/api/dept_modify.action?dept.deptId="+ids;
   	document.forms[1].submit();
}

/**
 * 审核
 */
function verifyObj(ids){
	$('[name=ids]').attr("checked", false );
	document.forms[1].action = $("#pageContext").val()+"/api/dept_verify.action?dept.deptId="+ids;
   	document.forms[1].submit();
}

 			
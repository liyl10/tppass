/**
 * @comment 用户快捷方式列表页面对应的js
 * @author dulei(dulei@hopsun.cn)
 * @date 2013-01-10
 * @version 1.0
 */
/**
 * 全选、取消
 */
$(function(){
     
     $("#checked").click(function(){
	 	var type = $("#checkedtype").val();
	 	if(type == 0){
		 	$('[name=ids]').attr("checked", "checked" );
	 		$("#checkedtype").val("1");
	 	}else{
	 		$('[name=ids]').attr("checked", "" );
	 		$("#checkedtype").val("0");
	 	}
	 });
	 
	 $('[name=ids]:checkbox').click(function(){
	 	var $tmp=$('[name=ids]:checkbox');
	 	$('#checked').attr('checked',$tmp.length==$tmp.filter(':checked').length?"checked":"");
	 	if($tmp.length==$tmp.filter(':checked').length){
	 		$("#checkedtype").val("1");
	 	}else{
	 		$("#checkedtype").val("0");
	 	}
	  });
	  
	 
	 $("#insert_btn").click(function(){
	 	document.forms[2].action = $("#pageContext").val()+"/api/shortcut_insert.action";
	 	document.forms[2].submit();
	 });
	  
});
/**
 * 批量删除
 */
function deleteClick(){
	if($("input[name='ids']").filter(":checked").length>0){
		if (confirm("您确定要删除所选信息?")) {
			document.forms[2].action = $("#pageContext").val()+"/api/shortcut_deleteShortcut.action";
	    	document.forms[2].submit();
		}
	}else{
		alert("请选择要删除的数据！")
	}
}
/**
 * 删除
 */
function deleteShortcut(id){
	if (confirm("您确定要删除所选信息?")) {
		document.forms[2].action = $("#pageContext").val()+"/api/shortcut_deleteShortcut.action?ids="+id;
	   	document.forms[2].submit();
	}
}

/**
 * 添加
 */
function addShortcut(){
	document.forms[2].action = $("#pageContext").val()+"/api/shortcut_insert.action";
   	document.forms[2].submit();
}
/**
 * 更新排序信息
 */
function updateobj(obj,ids){
 	obj.value = obj.value.replace(/\D/g,'')
 	$.get("../api/shortcut_updateShortcut.action",{ ids: ids, shorOrder: $(obj).val()},
	function(data){});
}
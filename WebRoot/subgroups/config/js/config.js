/**
  *@comment 系统参数转发用js
  *@author zzze
  *@date Dec 27, 2012
  *@version 1.0
 */

$(function(){
	hopsun_util.h_slide();//搜索下拉
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
	 /**
	  * 详细页绑定点击
	  */
	$(".detail").click(function(){
		document.getElementById("id").value=$(this).attr("title");
		document.getElementById("myform").action=$("#pageContext").val()+"/api/config/config_goDetail.action";
		document.getElementById("myform").submit();
	});
  /**
   * 修改绑定点击
   */
	$(".modify").click(function(){
		document.getElementById("id").value=$(this).attr("title");
		document.getElementById("myform").action=$("#pageContext").val()+"/api/config/config_goModify.action";
		document.getElementById("myform").submit();
	});
  /**
   * 添加绑定点击
   */
	$("#insert").click(function(){
		document.getElementById("myform").action=$("#pageContext").val()+"/api/config/config_goInsert.action";
		document.getElementById("myform").submit();
	});
	$("#insert2").click(function(){
		document.getElementById("myform").action=$("#pageContext").val()+"/api/config/config_goInsert.action";
		document.getElementById("myform").submit();
	});
	/**
	 * 单条信息删除绑定
	 */
	$(".delete").click(function(){
		document.getElementById("id").value=$(this).attr("title");
		if(confirm("您确认删除所选择信息吗？")){
			document.getElementById("myform").action=$("#pageContext").val()+"/api/config/config_delete.action";
			document.getElementById("myform").submit();
		}
	});
	/**
	 * 批量信息删除绑定
	 */
	$("#deleteBatch").click(function(){
		var bool=false;
		$("input[name='ids']").each(function(){
			if($(this).attr("checked")){
				bool=true;                    
			}             
		})       
		if(!bool){
				alert("请选择需要删除的信息！");
				return;
			}
		if(confirm("您确认删除所选择信息吗？")){
			document.getElementById("myform").action=$("#pageContext").val()+"/api/config/config_delete.action";
			document.getElementById("myform").submit();
		}
	});
	/**
	 * 批量信息删除绑定
	 */
	$("#deleteBatch2").click(function(){
		var bool=false;
		$("input[name='ids']").each(function(){
			if($(this).attr("checked")){
				bool=true;                    
			}             
		})       
		if(!bool){
				alert("请选择需要删除的信息！");
				return;
			}
		if(confirm("您确认删除所选择信息吗？")){
			document.getElementById("myform").action=$("#pageContext").val()+"/api/config/config_delete.action";
			document.getElementById("myform").submit();
		}
	});
	/**
	 * 查询方法绑定
	 */
	$("#query").click(function(){
		document.getElementById("myform").action=$("#pageContext").val()+"/api/config/config_list.action";
		document.getElementById("myform").submit();
	});
});
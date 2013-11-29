/**
  *@comment 日志转发用js
  *@author zzze
  *@date Dec 27, 2012
  *@version 1.0
 */

$(function(){
	/**
	 * 方法返回绑定
	 */
	$(".return-button").click(function(){
		history.back(-1);
	});
	/**
	 * 查询方法绑定
	 */
	$("#query").click(function(){
		document.getElementById("myform").action=$("#pageContext").val()+"/api/log/log_list.action";
		document.getElementById("myform").submit();
	});
	/**
	  * 详细页绑定点击
	  */
	$(".detail").click(function(){
		document.getElementById("id").value=$(this).attr("title");
		document.getElementById("myform").action=$("#pageContext").val()+"/api/log/log_goDetail.action";
		document.getElementById("myform").submit();
	});
})
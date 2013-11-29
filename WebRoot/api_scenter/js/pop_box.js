// JavaScript Document
//弹出层效果
$(document).ready(function () {
	//生成提示层
	$.extend({openbox:function(srcid){
	$("body").append("<div class='pop_box' id='pop_box'><div class='pop_box_handel' id='pop_box_handel'></div><div class='pop_box_content' id='pop_box_content'></div><div class='pop_box_ctrl'><input type='button' name='btn_pop_sure' id='btn_pop_sure' value='确定' class='submit'  /><input type='button' name='btn_pop_sure' id='btn_pop_cancel' value='取消' class='submit'  /></div></div>")
	$("#pop_box").show();
	alert("1");
	$("#pop_box_content").empty();
	alert("2");
	$("#pop_box_content").append($("#"+srcid))
	alert("3");
	$("#pop_box_src").remove("#pop_box_src "+srcid);
	alert("4");
	}})
	
	 //点击关闭层,关闭弹出层
	 $(".pop_box_handel_close").click(function(){	
	 	$(this).parent().parent().hide();
	 });
	 
	 // 点击取消按钮
	 $("input[name='btn_pop_cancel']").click(function(){	
	 	$(this).parent().parent().hide();
	 });
	 
	  
});
 
	
/**
 * @comment 系统参数对应的js
 * @author zzze
 * @date Dec 27, 2012
 * @version 1.0
 */
/**
 * 表单提交验证
 */
$(function(){
	//返回按钮
	$(".return-button").click(function(){
		history.back(-1);
	});
	//选项卡
	$("#paramChoose").keyup(function(){
		var obj = $(this).val(); 
		generate(obj);
	}).trigger("keyup");
	
	/**
	 * 将可选项生成为选择项
	 */
	function generate(obj){
		if(obj!=null){
			//清除子元素
			$("#paramUseageDiv").children().remove();
			var select = "<select name=\"config.paramUseage\" id=\"paramUseage\"></select>";//可选项标签
			$("#paramUseageDiv").append($(select));//选择项加入页面
			if(obj.indexOf(",")!=-1){
				//清除子元素
				$("#paramUseage").children().remove();
				//重新生成子元素
				var useage = obj.split(",");
				for(var i = 0 ; i < useage.length ; i++){//填充选择项
					if(useage[i]==$("input[name='paramUseage']").val()){
						$("#paramUseage").append("<option value=\""+useage[i]+"\" selected=\"selected\">"+useage[i]+"</option>");
					}else{
						$("#paramUseage").append("<option value=\""+useage[i]+"\">"+useage[i]+"</option>");
					}
				}
			}else{
				//清除子元素
				$("#paramUseage").children().remove();
				//重新生成子元素
				$("#paramUseage").append("<option value=\""+obj+"\">"+obj+"</option>");
			}
		}
	}
	/**
	 * 表单验证
	 */
	var demo=$("#myform").Validform({
		tiptype:3,
		showAllError:true,
		datatype:{
			choose:/^([^-,]+-[^-,]+-[^-,]+(,)??)+$/
		}
	});
	var code = $("#paramCode").val();
	demo.addRule([{
		ele:"#paramName",
		datatype:"*",
		nullmsg:h_res.scenter.config.nullmsg.configName
	},
	{
		ele:"#paramCode",
		datatype:"*",
		ajaxurl:"api/ajaxconfig/config_check.action",
		nullmsg:h_res.scenter.config.nullmsg.configCode
	},
	{
		ele:"#paramChoose",
		datatype:"choose",
		nullmsg:h_res.scenter.config.nullmsg.configChoose,
		errormsg:h_res.scenter.config.errormsg.configChoose
	},
	{
		ele:"#description",
		datatype:"*",
		nullmsg:h_res.scenter.config.nullmsg.configDesc
	}]);

	$("[datatype]").focusin(function(){
		var tips = "<span class='custom_checktip'>"+$(this).attr("nullmsg")+"</span>";
		$(this).parent().append(tips);
		$(this).siblings(".Validform_checktip").hide();
	}).focusout(function(){
		$(this).siblings(".custom_checktip").remove();
		$(this).siblings(".Validform_checktip").css("display","");
	});
	
})

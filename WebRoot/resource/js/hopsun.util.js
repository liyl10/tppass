/**
 * @comment 提供浮动层提示
 * @filename hcsp.util.js
 * @date 2013-1-24
 * @version 1.0
 * @auth zzze
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 */
 /**
 * @comment js内置功能扩充
 */
/**
 * @comment 去除字符串首位空格
 * @demo
 * var temp = "          test              ";
 * alert(temp.trim());
 */
String.prototype.trim=function(){         
	return this.replace(/(^\s*)|(\s*$)/g, '');      
} 
/**
 * @comment 工具类
 */
var hopsun_util = function(){};
/**
 * @comment 是否为空
 * @demo
 * var temp = "          test              ";
 * alert(h_util.ifnull(temp));
 */
hopsun_util.ifnull = function(val){
	var renull= new RegExp(/^[ ]*$/);
	if(renull.test(val)||val==null||val==undefined){
  		return true;
 	}else{
 		return false;
 	}
}
/**
 * @comment 实现下拉列表
 */
hopsun_util.h_slide = function(clickObj,hideArea){
	if(this.ifnull(clickObj)){
		clickObj = "searchClickObj";
	}
	if(this.ifnull(hideArea)){
		hideArea = "moredo";
	}
	$("."+clickObj).click(function(){
		$("."+hideArea).toggle();
		$("."+clickObj).toggle();
	});
}

/**
 * @comment 点击后按钮后移除所有validForm的提示信息
 * @demo
 * alert(hopsun_util.remove_tips());
 */
hopsun_util.remove_tips = function(){
	$(".Validform_checktip").each(function(){
		$(this).html("");		
	});
	$(".custom_checktip").each(function(){
		$(this).html("");		
	});
}




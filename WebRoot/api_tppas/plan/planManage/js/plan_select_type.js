// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	// alert(${projecTypeManager});
	// 计划类别
	upms.upmsUtils.initSelect("projectType1", "", 1, 2, 4);
	
	// 项目分类
	upms.upmsUtils.initSelect("projectType2", "", 1, 2, 4);
});

// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	// 项目分组
	upms.upmsUtils.initSelect("projectGroupSon", $("#projectGroupSonValue").val(), 1, 1, 0);
});
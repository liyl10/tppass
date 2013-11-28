
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
		 
		 upms.upmsUtils.initSelect("masterType", $("#masterTypeName").val(), 1 , 1 , 0);
		 
		// 检索跳转处理
		pageDirect();
	});
});

//查询按钮
$("#queryBtn").bind("click", function() {
	// 检索跳转处理
	pageDirect();
});

//画面跳转：一览画面
function pageDirect(){
	var actionUrl= path + "/api/superadmin/mtype!queryType.action?now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var arrParams = [{name:"masterType",targetid:"masterType",type:"text"}];

	var data = upms.transParsToObj(arrParams, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}
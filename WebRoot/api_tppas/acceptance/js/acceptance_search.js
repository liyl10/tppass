// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	// 项目分类
	upms.upmsUtils.initSelect("typeId2",$("#typeId2Value").val(), 1 , 2 , 4);
	upms.upmsUtils.initSelect("typeId3",$("#typeId3Value").val(), 1 , 2 , 4);
	// 验收状态
	upms.upmsUtils.initSelect("acceptanceStatus","", 1, 1, 0);

	// 检索跳转处理
	pageDirect();
});

//查询按钮
$("#queryBtn").bind("click", function() {
	// 检索跳转处理
	pageDirect();
});

//画面跳转：一览画面
function pageDirect(){
	var actionUrl= path + "/api/acceptance/acceptance!getList.action?now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var arrParams = [{name:"tprojectApplication.projectName",targetid:"projectName",type:"text"},
	                 {name:"tprojectApplication.applicationUnit",targetid:"applicationUnit",type:"text"},
	                 {name:"typeId2",targetid:"typeId2",type:"text"},
	                 {name:"typeId3",targetid:"typeId3",type:"text"},
	                 {name:"acceptanceStatus",targetid:"acceptanceStatus",type:"text"}];

	var data = upms.transParsToObj(arrParams, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
 }
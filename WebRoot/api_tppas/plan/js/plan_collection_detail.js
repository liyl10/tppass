// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
	});
});

//返回按钮
$("#backBtn").bind("click", function(){

	var actionUrl = path + "/api/planCollect/tplanCollectAction!initSearch.action"+ "?now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");

	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

//项目申报详细打印    
function printPlanDetail(planId){
	var actionUrl= path + "/api/planCollect/tplanCollectAction!printPlanDetail.action?planCollectId="+ planId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	window.location.href= actionUrl;
	setTimeout(function(){upms.hideOverLay();},1500); 
}

//项目申报修改
function editPlanDetail(planId){
	var actionUrl= path + "/api/planCollect/tplanCollectAction!toUpdataPage.action?planCollectId="+ planId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}
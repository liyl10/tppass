// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		// 下拉列表初期化
		upms.upmsUtils.initSelect("planBatch","", 1 , 1 , 1);
	});
});

//保存按钮
$("#saveBtn").bind("click", function(){
	// 验证text
	var result = upms.upmsUtils.inputCheck();
	// 验证下拉列表
	var idList = new Array("planBatch");
	var result1 = upms.upmsUtils.selectCheck(idList);
	if(result || result1){
		return;
	}
	if(result){
		return;
	}
	if(!confirm("确定要新增该计划汇总吗？")){
		return false;
	}
	
	var actionUrl = path + "/api/planCollect/tplanCollectAction!savePlanColection.action"+ "?now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	
	var params = [  {name:"planCollectionName",targetid:"planCollectName",type:"text"},
	                {name:"planYear",targetid:"planYear",type:"text"},
	                {name:"planBatch",targetid:"planBatch",type:"select"}];
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
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







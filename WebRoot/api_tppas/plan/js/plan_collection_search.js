// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		// 下拉列表初期化
		upms.upmsUtils.initSelect("planBatch","", 1 , 1 , 0);
		
		var actionUrl = path + "/api/planCollect/tplanCollectAction!getPlanColectionList.action"+ "?now=" + new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		
		var params = [  {name:"planCollectionName",targetid:"planCollectName",type:"text"},
		                {name:"planYear",targetid:"planYear",type:"text"},
		                {name:"planBatch",targetid:"planBatch",type:"select"}];
		var data = upms.transParsToObj(params, $("#searchForm"));
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
		
	});
});

//查询按钮
$("#queryBtn").bind("click", function(){

	var actionUrl = path + "/api/planCollect/tplanCollectAction!getPlanColectionList.action"+ "?now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	
	var params = [  {name:"planCollectionName",targetid:"planCollectName",type:"text"},
	                {name:"planYear",targetid:"planYear",type:"text"},
	                {name:"planBatch",targetid:"planBatch",type:"select"}];
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

//新增按钮
$("#addBtn").bind("click", function(){

	var actionUrl = path + "/api/planCollect/tplanCollectAction!toAddNewPlanColection.action"+ "?now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

// 项目申报详细    
function showPlanDetail(planId){
	var actionUrl= path + "/api/plan/plan!showPlanDetail.action?planId="+ planId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}






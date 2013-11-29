// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		// 下拉列表初期化
		upms.upmsUtils.initSelect("planBatch",$("#selectedPlanCollectBatch").val(), 1 , 1 , 1);
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

//删除计划汇总
function deletePlan(planId,planCollectId){
	if(!confirm("您确定要删除这条分计划吗？")){
		return false;
	}
	var actionUrl= path + "/api/planCollect/tplanCollectAction!deletePlan.action?planId="
		+ planId 
		+ "&planCollectId=" 
		+ planCollectId 
		+ "&now="
		+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

// 通过计划类别删除分计划（一次删除该计划类别下所有的分计划）
function deletePlanByType(planFlag,planCollectId){
	if(!confirm("将会删除该计划类别下所有的分计划，您确定要删除这些分计划吗？")){
		return false;
	}
	var actionUrl= path + "/api/planCollect/tplanCollectAction!deletePlanByType.action?planCollectId=" 
		+ planCollectId 
		+ "&planFlag="
		+ planFlag
		+ "&now="
		+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

//选择分计划按钮
function toSelectPlanPage(planCollectId){
	var actionUrl= path + "/api/planCollect/tplanCollectAction!showSelectPlanSearch.action"
		+ "?planCollectId=" 
		+ planCollectId 
		+ "&backFlag="
		+ "edit"
		+ "&now="
		+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

//项目申报修改提交
function updatePlanDetail(planId){
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
	if(!confirm("您确定要修改该计划汇总吗？")){
		return false;
	}
	
	var actionUrl = path + "/api/planCollect/tplanCollectAction!updatePlanColection.action?planCollectId="+ planId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	
	var params = [  {name:"planCollectionName",targetid:"planCollectName",type:"text"},
	                {name:"planYear",targetid:"planYear",type:"text"},
	                {name:"planBatch",targetid:"planBatch",type:"select"}];
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}
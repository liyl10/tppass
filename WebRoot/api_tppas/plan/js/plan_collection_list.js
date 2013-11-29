// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		
	});
});


// 分页初始化
upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"searchForm",
	resultdivid:"resultDiv",
	url:path + "/api/planCollect/tplanCollectAction!getPlanColectionList.action?date=" + new Date().getTime()
});

// 删除计划汇总
function deletePlanDetail(planId){
	if(!confirm("您确定要删除这条分计划汇总吗？")){
		return false;
	}
	
	var actionUrl= path + "/api/planCollect/tplanCollectAction!deletePlanColection.action?planCollectId="+ planId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}
// 项目申报详细    
function showPlanDetail(planId){
	var actionUrl= path + "/api/planCollect/tplanCollectAction!showPlanDetail.action?planCollectId="+ planId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}


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



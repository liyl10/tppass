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
	url:path + "/api/planManage/planManageAction!getPlanManageList.action?date=" + new Date().getTime()
});

/**
 * 删除分计划
 * @param planId
 */
function deletePlan(planId){
	if(confirm($("#comfirmCancel").text())){
		var actionUrl= path + "/api/planManage/planManageAction!deletePlan.action?planId="+ planId+"&now="+new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		var data = {};
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
}
/**
 * 修改分计划
 * @param planId
 */
function updatePlan(planId){
	var actionUrl= path + "/api/planManage/planManageAction!showPlanUpdate.action?planId="+ planId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

/**
 * 详细
 * @param planId
 */
function showDetail(planId){
	var actionUrl= path + "/api/planManage/planManageAction!showPlanDetail.action?planId="+ planId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

/**
 * 下发合同
 * @param planId
 */
function issuedContract(planId){
	
}







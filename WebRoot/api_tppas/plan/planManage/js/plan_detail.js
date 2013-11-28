// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	// 计划批次
	upms.upmsUtils.initSelect("planBatch", $("planBatchValue").val(), 0, 1, 0);
	
	if($("#proAppListCount").val() == 0){
		$("#printBtn").attr("disabled", true);
	}
});


/**
 * 详细
 * @param planId
 */
function back(){
	var actionUrl= path + "/api/planManage/planManageAction!showPlanManage.action?&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

/**
 * 打印
 */
function print(){
	var actionUrl=path + "/api/planManage/planManageAction!printPlan.action?planId=" + $("#planId").val() + "&now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	window.location.href= actionUrl;
	setTimeout(function(){upms.hideOverLay();},1000);
}
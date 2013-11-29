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
	url:path + "/api/report/projectDeployAction!getDeployList.action?date=" + new Date().getTime()
});

//项目查看
function projectReview(projectId, action) {
	// 访问路径替换
	var apiaction = action.replace(/\/server\//,"/api/");
	var actionUrl= path + apiaction + "?projectId=" + projectId + "&now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [];

	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

// 项目调配
function deploy(projectId){
	var actionUrl=path + "/api/report/projectDeployAction!deploy.action?projectId=" 
			+ projectId
			+ "&date=" 
			+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		$("#queryBtn").removeAttr("disabled");
	});
}




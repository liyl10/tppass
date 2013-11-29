
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
		 if($("#count").val() == 0){
			 $("#goExportBtn").attr("disabled",true);
		 }
		 else {
			 $("#goExportBtn").removeAttr("disabled");
		 }
	});
});

// 项目查看
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

upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"searchForm",
	resultdivid:"resultDiv",
	url:path +"/api/statistics/statisticsProject!query.action?now="+new Date().getTime()
});
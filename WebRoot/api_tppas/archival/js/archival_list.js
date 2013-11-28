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
	url:path + "/api/report/tprojectApplicationAction!getArchivalList.action?date=" + new Date().getTime()
});

//项目申报详细
function showProjectDetail(projectId,action){
	// 访问路径替换
	var apiaction = action.replace(/\/server\//,"/api/");
	var actionUrl= path + apiaction + "?projectId=" + projectId + "&now="+ new Date().getTime();
	window.open(actionUrl);
	/*upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});*/

}
//全选
function selectAll(){
	if($("#selectAll").attr("checked")=="checked"){
		$("input[type='checkbox']").attr("checked",true);
	}
	else{
		$("input[type='checkbox']").removeAttr("checked");
	}
}
//企业查看
function showApplicationUnit(projectId) {
	viewCompanyInfo(projectId);
}

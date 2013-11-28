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
	url:path + "/api/expert/texpertScoreWriteAction!getProjectListByGroupId.action?date=" + new Date().getTime()
});



/**
 * 意见填写
 * @param groupId
 */
function opinionWrite(groupId,projectId,projectIndex){
	var actionUrl = path + "/api/expert/texpertScoreWriteAction!getScoreByProjectId.action?groupId="+groupId+"&projectId="+projectId+"&projectIndex="+projectIndex+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}
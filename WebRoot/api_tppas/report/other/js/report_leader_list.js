// 网站根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();
	});
});

upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"frmA",
	resultdivid:"resultDiv",
	url:path + "/api/report/tprojectLeader!list.action?projectId="
		+ $("#projectId").val()
		+"&now="+new Date().getTime()
});


// 修改按钮
function showDetai2(projectId,projectLeaderAId,applyStatus){
	var actionUrl= path + "/api/report/tprojectLeader!showResearcher.action?projectId="+projectId+"&projectLeaderAId="+projectLeaderAId+"&applyStatus="+applyStatus+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		});
}


function nextBtn(projectId,applyStatus){
	// 设置左侧菜单状态
	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/report/tschedulinga!showTschedulingANonTech.action?projectId="+$("#projectId").val()+"&applyStatus="+$("#applyStatus").val()+"&now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [ {} ];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});	
}
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
	url:path + "/api/report/tresearcherActionA!list.action?projectId="+ $("#projectId").val()+"&now="+new Date().getTime()
});

//修改按钮
function showDetai(projectId,researcherId, applyStatus){
	var actionUrl= path + "/api/report/tresearcherActionA!showResearcher.action?projectId="+projectId+"&researcherId="+researcherId+"&applyStatus="+applyStatus+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

// 下一步--详细
function nextBtn(projectId,applyStatus){
	// 设置左侧菜单状态
	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/report/teconomicIndicatorBAction!initHighTech.action?now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"projectId",targetid:"projectId",type:"text"},
	                 {name:"applyStatus",targetid:"applyStatus",type:"text"}];
	
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});	
}
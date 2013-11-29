// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
	});
});

//返回按钮事件
$("#backBtn").bind("click", function() {
	
	var actionUrl= path + "/api/supervisor/supervisorReportAction!getReportList.action?&now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [{name:"supervisorId",targetid:"supervisorId",type:"text"},
	                 			{name:"projectId",targetid:"projectId",type:"text"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

//保存按钮事件
$("#saveBtn").bind("click", function() {
	// 输入项验证
	if(upms.upmsUtils.inputCheck()){
		return;
	}

	if (!confirm($("#comfirmSave").text())) {
		return;
	}
	var actionUrl= path + "/api/supervisor/supervisorPointAction!savePoint.action?now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [{name:"supervisorId",targetid:"supervisorId",type:"text"},
	                 {name:"projectId",targetid:"projectId",type:"text"},
	                 {name:"supervisorPoint.pointContent",targetid:"pointContent",type:"text"},
	                 {name:"supervisorPoint.pointTime",targetid:"pointTime",type:"text"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});
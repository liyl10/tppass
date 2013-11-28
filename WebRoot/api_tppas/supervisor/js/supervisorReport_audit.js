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
		if(upms.upmsUtils.inputCheck()){
			return;
		}
	
		if (!confirm($("#comfirmSave").text())) {
			return;
		}
		var actionUrl= path + "/api/supervisor/supervisorReportAction!auditReport.action?optType=0&now=" + new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		var arrParams = [{name:"supervisorId",targetid:"supervisorId",type:"text"},
		                 {name:"projectId",targetid:"projectId",type:"text"},
		                 {name:"reportId",targetid:"reportId",type:"text"},
		                 {name:"checkInfo",targetid:"checkInfo",type:"textarea"}];
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	});
	
	//提交按钮事件
	$("#submitBtn").bind("click", function() {
		if(upms.upmsUtils.inputCheck()){
			return;
		}
	
		if (!confirm($("#comfirmSubmit").text())) {
			return;
		}
		var actionUrl= path + "/api/supervisor/supervisorReportAction!auditReport.action?optType=1&now=" + new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		var arrParams = [{name:"supervisorId",targetid:"supervisorId",type:"text"},
		                 {name:"projectId",targetid:"projectId",type:"text"},
		                 {name:"reportId",targetid:"reportId",type:"text"},
		                 {name:"checkInfo",targetid:"checkInfo",type:"textarea"}];
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	});

// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});

$("#btnSave").bind("click", function() {
	var actionUrl=path +"/api/superadmin/reportModel!modify.action";
	var val = confirm($("#comfirmSave").text());
	 if (!val) {
	    return; 
	 }
	upms.showOverLay();// 打开遮罩

	var $newPgDiv = $("#mainContent");

	var arrParams = [{
		name : "reportTemplateId",
		targetid : "reportTemplateId",
		type : "text"
	}, {
		name : "tprojectReportTemplate.reportTemplateName",
		targetid : "tprojectReportTemplate\\.reportTemplateName",
		type : "text"
	}, {
		name : "tprojectReportTemplate.saveUrl",
		targetid : "tprojectReportTemplate\\.saveUrl",
		type : "text"
	}, {
		name : "tprojectReportTemplate.updateUrl",
		targetid : "tprojectReportTemplate\\.updateUrl",
		type : "text"
	}, {
		name : "tprojectReportTemplate.viewUrl",
		targetid : "tprojectReportTemplate\\.viewUrl",
		type : "text"
	}, {
		name : "tprojectReportTemplate.deleteUrl",
		targetid : "tprojectReportTemplate\\.deleteUrl",
		type : "text"
	}, {
		name : "tprojectReportTemplate.trialUrl",
		targetid : "tprojectReportTemplate\\.trialUrl",
		type : "text"
	}, {
		name : "tprojectReportTemplate.auditUrl",
		targetid : "tprojectReportTemplate\\.auditUrl",
		type : "text"
	} , {
		name : "tprojectReportTemplate.expertAuditUrl",
		targetid : "tprojectReportTemplate\\.expertAuditUrl",
		type : "text"
	},{
		name : "tprojectReportTemplate.expertProofUrl",
		targetid : "tprojectReportTemplate\\.expertProofUrl",
		type : "text"
	},{
		name : "tprojectReportTemplate.leadershipAuditUrl",
		targetid : "tprojectReportTemplate\\.leadershipAuditUrl",
		type : "text"
	},{
		name : "tprojectReportTemplate.meetingAuditUrl",
		targetid : "tprojectReportTemplate\\.meetingAuditUrl",
		type : "text"
	}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

//返回
$("#reBtn").bind("click", function() {
var actionUrl= path +"/api/superadmin/reportModel!init.action";
var $newPgDiv = $("#mainContent");
var arrParams =[{}];
var data = upms.transParsToObj(arrParams, $newPgDiv);
$newPgDiv.load(actionUrl, data, function() {
	upms.hideOverLay();
});
					});
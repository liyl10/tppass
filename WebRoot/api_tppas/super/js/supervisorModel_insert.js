
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});

$("#btnSave").bind("click", function() {
	var actionUrl=path +"/api/superadmin/supervisorModel!modify.action";
	var val = confirm($("#comfirmSave").text());
	 if (!val) {
	    return; 
	 }
	upms.showOverLay();// 打开遮罩

	var $newPgDiv = $("#mainContent");

	var arrParams = [{
		name : "supervisorTemplateId",
		targetid : "supervisorTemplateId",
		type : "text"
	}, {
		name : "tprojectSupervisionTemplate.supervisionTemplateName",
		targetid : "tprojectSupervisionTemplate\\.supervisionTemplateName",
		type : "text"
	}, {
		name : "tprojectSupervisionTemplate.saveUrl",
		targetid : "tprojectSupervisionTemplate\\.saveUrl",
		type : "text"
	}, {
		name : "tprojectSupervisionTemplate.updateUrl",
		targetid : "tprojectSupervisionTemplate\\.updateUrl",
		type : "text"
	}, {
		name : "tprojectSupervisionTemplate.viewUrl",
		targetid : "tprojectSupervisionTemplate\\.viewUrl",
		type : "text"
	}, {
		name : "tprojectSupervisionTemplate.deleteUrl",
		targetid : "tprojectSupervisionTemplate\\.deleteUrl",
		type : "text"
	}, {
		name : "tprojectSupervisionTemplate.auditUrl",
		targetid : "tprojectSupervisionTemplate\\.auditUrl",
		type : "text"
	}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

//返回
$("#reBtn").bind("click", function() {
var actionUrl= path +"/api/superadmin/supervisorModel!init.action";
var $newPgDiv = $("#mainContent");
var arrParams =[{}];
var data = upms.transParsToObj(arrParams, $newPgDiv);
$newPgDiv.load(actionUrl, data, function() {
	upms.hideOverLay();
});
					});
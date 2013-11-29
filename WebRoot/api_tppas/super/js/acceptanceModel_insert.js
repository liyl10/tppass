
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});

$("#btnSave").bind("click", function() {
	var actionUrl=path +"/api/superadmin/acceptanceModel!modify.action";
	var val = confirm($("#comfirmSave").text());
	 if (!val) {
	    return; 
	 }
	upms.showOverLay();// 打开遮罩

	var $newPgDiv = $("#mainContent");

	var arrParams = [{
		name : "acceptanceTemplateId",
		targetid : "acceptanceTemplateId",
		type : "text"
	}, {
		name : "tprojectcceptanceTemplate.acceptanceTemplateName",
		targetid : "tprojectcceptanceTemplate\\.acceptanceTemplateName",
		type : "text"
	}, {
		name : "tprojectcceptanceTemplate.saveUrl",
		targetid : "tprojectcceptanceTemplate\\.saveUrl",
		type : "text"
	}, {
		name : "tprojectcceptanceTemplate.updateUrl",
		targetid : "tprojectcceptanceTemplate\\.updateUrl",
		type : "text"
	}, {
		name : "tprojectcceptanceTemplate.viewUrl",
		targetid : "tprojectcceptanceTemplate\\.viewUrl",
		type : "text"
	}, {
		name : "tprojectcceptanceTemplate.deleteUrl",
		targetid : "tprojectcceptanceTemplate\\.deleteUrl",
		type : "text"
	}, {
		name : "tprojectcceptanceTemplate.auditUrl",
		targetid : "tprojectcceptanceTemplate\\.auditUrl",
		type : "text"
	}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

//返回
$("#reBtn").bind("click", function() {
var actionUrl= path +"/api/superadmin/acceptanceModel!init.action";
var $newPgDiv = $("#mainContent");
var arrParams =[{}];
var data = upms.transParsToObj(arrParams, $newPgDiv);
$newPgDiv.load(actionUrl, data, function() {
	upms.hideOverLay();
});
					});
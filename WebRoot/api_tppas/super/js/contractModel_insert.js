
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});

$("#btnSave").bind("click", function() {
	var actionUrl=path +"/api/superadmin/contractModel!modify.action";
	var val = confirm($("#comfirmSave").text());
	 if (!val) {
	    return; 
	 }
	upms.showOverLay();// 打开遮罩

	var $newPgDiv = $("#mainContent");

	var arrParams = [{
		name : "contractTemplateId",
		targetid : "contractTemplateId",
		type : "text"
	}, {
		name : "tprojectContractTemplate.contractTemplateName",
		targetid : "tprojectContractTemplate\\.contractTemplateName",
		type : "text"
	}, {
		name : "tprojectContractTemplate.saveUrl",
		targetid : "tprojectContractTemplate\\.saveUrl",
		type : "text"
	}, {
		name : "tprojectContractTemplate.updateUrl",
		targetid : "tprojectContractTemplate\\.updateUrl",
		type : "text"
	}, {
		name : "tprojectContractTemplate.viewUrl",
		targetid : "tprojectContractTemplate\\.viewUrl",
		type : "text"
	}, {
		name : "tprojectContractTemplate.deleteUrl",
		targetid : "tprojectContractTemplate\\.deleteUrl",
		type : "text"
	}, {
		name : "tprojectContractTemplate.auditUrl",
		targetid : "tprojectContractTemplate\\.auditUrl",
		type : "text"
	}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

//返回
$("#reBtn").bind("click", function() {
var actionUrl= path +"/api/superadmin/contractModel!init.action";
var $newPgDiv = $("#mainContent");
var arrParams =[{}];
var data = upms.transParsToObj(arrParams, $newPgDiv);
$newPgDiv.load(actionUrl, data, function() {
	upms.hideOverLay();
});
					});
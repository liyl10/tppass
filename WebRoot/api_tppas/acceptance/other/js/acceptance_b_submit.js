// 网站根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();
	});
	
});

//提交按钮
function submitInfo(submitFlag) {
	if (!confirm($("#comfirmSubmit").text())) {
		return;
	}
	var actionUrl= path + "/api/acceptance/acceptance!submitOtherAcceptance.action?submitFlag=" + submitFlag + "&now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"acceptanceId",targetid:"acceptanceId",type:"text"}];

	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

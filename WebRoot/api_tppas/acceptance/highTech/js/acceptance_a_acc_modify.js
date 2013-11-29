
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		$("input[type='text']").each(function(){
			$(this).attr("disabled",true);
		});
		upms.upmsUtils.initSelect("sex", $("#sexValue").val(), 1, 1, 0);
	});
});

// 返回按钮
$("#backBtn").bind("click", function() {
		var actionUrl= path + "/api/acceptance/accA!accInit.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"acceptanceId",targetid:"acceptanceId",type:"text"},
		                 {name:"acceptanceStatus",targetid:"acceptanceStatus",type:"text"}];

		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
});
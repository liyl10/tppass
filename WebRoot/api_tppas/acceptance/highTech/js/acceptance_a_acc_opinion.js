
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();

		$("input[type='text']").each(function(){
			$(this).attr("disabled",true);
		});
		$("textarea").each(function(){
			$(this).attr("readonly",true);
			$(this).css('background-color','#F0F0F0');
		});
	});
});

// 下一步按钮-详细
$("#nextBtn").bind("click", function() {
	// 设置左边菜单样式
	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/acceptance/opinionA!deptOpinionInit.action?now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"acceptanceId",targetid:"acceptanceId",type:"text"},
	                 {name:"acceptanceStatus",targetid:"acceptanceStatus",type:"text"}];

	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});
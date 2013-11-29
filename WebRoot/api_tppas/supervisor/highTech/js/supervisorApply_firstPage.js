// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
	});
});

function next() {
	// 设置左侧菜单
	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/supervisor/tsupervisorApply!showApplyInstruction.action?&now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();
	});
}
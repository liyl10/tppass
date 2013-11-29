// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
	});
});

$(function() {
    $(document).ready(function () {

		upms.upmsUtils.initLeftMenu("/api/supervisor/tsupervisorApply!showApplyFirstPage.action?&supervisorId="  + $("#supervisorId").val() +"&projectId=" + $("#projectId").val()+ "&now=" + new Date().getTime());
	});
    
    //$("#content").load(path + "/server/supervisor/tsupervisorApply!showApplyFirstPage.action?&supervisorId="  + $("#supervisorId").val() +"&projectId=" + $("#projectId").val()+ "&now=" + new Date().getTime());
}); 

function showDetail(url){
	var actionUrl= path + url + "supervisorId="  + $("#supervisorId").val() +"&projectId=" + $("#projectId").val()+ "&now=" + new Date().getTime();
	rect(actionUrl);
}

function rect(actionUrl) {
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}
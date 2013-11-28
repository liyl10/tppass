// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
	});
});

$(function() {
    $(document).ready(function () {
		upms.upmsUtils.initLeftMenu("/api/statistics/statisticsProject!init.action?now=" + new Date().getTime());
	});
}); 

function showDetail(url){
	var actionUrl= path + url + "now=" + new Date().getTime();
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
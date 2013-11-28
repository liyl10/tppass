// 网站根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();

		var projectId = $("#projectIdTemp").val();
		var applyStatus = $("#applyStatusTemp").val();
		// 初始化下拉列表
		upms.upmsUtils.initLeftMenu("/api/report/tprojectApplicationAction!showUpdateNonTechCover.action?projectId=" 
				+ projectId + "&applyStatus=" + applyStatus);
	});
});


/**
 * 加载右侧页面
 * @param typeFlag
 * @param tacceptanceId
 * @param acceptanceStatus
 * @param url
 */
function showDetail(url){
	var projectId = $("#projectIdTemp").val();
	var applyStatus = $("#applyStatusTemp").val();
	var actionUrl= path + url + "projectId=" + projectId  + "&applyStatus=" + applyStatus + "&now="+ new Date().getTime();
	rect(actionUrl);
}
/**
 * 提交请求到后台
 * @param actionUrl
 */
function rect(actionUrl) {
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}
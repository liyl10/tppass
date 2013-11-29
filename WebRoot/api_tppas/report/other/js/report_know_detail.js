// 网站根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();
	});
});

/**
 * 下一步按钮功能
 */
$("#nextBtn").bind("click", function(){
	// 设置左侧菜单
	upms.upmsUtils.setMenu();
	
	var actionUrl= path + "/api/report/tprojectInfobAction!showProjectInfoB.action?now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"projectId",targetid:"projectId",type:"text"},
	                 {name:"applyStatus",targetid:"applyStatus",type:"text"}];
	arrParams = upms.upmsUtils.setSubmitDatas(arrParams, 1, 0);
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});
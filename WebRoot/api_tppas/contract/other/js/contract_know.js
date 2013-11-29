
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});

function nextBtn(projectId){
	// 设置左侧菜单
	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/contract/tappropriationSingle!init.action?now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"},
	                 {name:"Flag",targetid:"Flag",type:"text"},
	                 {name:"contractStatus",targetid:"contractStatus",type:"text"},
	                 {name:"modelType",targetid:"modelType",type:"text"},];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});	
}

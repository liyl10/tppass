// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	//填写状态
	upms.upmsUtils.initSelect("isWrite", "", 1, 2, 0);
	
	// 查询按钮制域
 	$("#queryBtn").attr("disabled",true);
 	
 	var actionUrl=path + "/api/expert/texpertScoreWriteAction!getProjectListByGroupId.action?date=" + new Date().getTime();
	var params = [{name:"projectName",targetid:"projectName",type:"text"},
	              {name:"isWrite",targetid:"isWrite",type:"select"},
	              {name:"groupId",targetid:"groupId",type:"text"}];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		$("#queryBtn").removeAttr("disabled");
	});
}); 

 $("#queryBtn").bind("click", function() {
	 var actionUrl=path + "/api/expert/texpertScoreWriteAction!getProjectListByGroupId.action?date=" + new Date().getTime();
	 var params = [{name:"projectName",targetid:"projectName",type:"text"},
		           {name:"isWrite",targetid:"isWrite",type:"select"},
		           {name:"groupId",targetid:"groupId",type:"text"}];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});
 

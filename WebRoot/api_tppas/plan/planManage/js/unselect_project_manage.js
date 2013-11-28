// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	// 查询按钮制域
 	$("#queryBtn").attr("disabled",true);
 	var data = "&";
 	data = data + "projectName=" + encodeURIComponent($("#projectName").val());
 	data = data + "&applyCompany=" + encodeURIComponent($("#applyCompany").val());
 	var actionUrl=path + "/api/planManage/planManageAction!getUnselectProject.action?planId=" + $("#planId").val() + data + "&date=" + new Date().getTime();
	/*var params = [{name:"projectName",targetid:"projectName",type:"text"},
	              {name:"applyCompany",targetid:"applyCompany",type:"text"}];*/
	//upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	//var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, null, function() {
		//upms.hideOverLay();
		$("#queryBtn").removeAttr("disabled");
	});
}); 

/**
 * 查询
 */
function queryData(){
	var data = "&";
 	data = data + "projectName=" + encodeURIComponent($("#projectName").val());
 	data = data + "&applyCompany=" + encodeURIComponent($("#applyCompany").val());
 	
	var actionUrl=path + "/api/planManage/planManageAction!getUnselectProject.action?planId=" + $("#planId").val() + data  + "&date=" + new Date().getTime();
	/*var params = [{name:"projectName",targetid:"projectName",type:"text"},
	              {name:"applyCompany",targetid:"applyCompany",type:"text"}];*/
	//upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	//var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, null, function() {
		//upms.hideOverLay();
	});
}
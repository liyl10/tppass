// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	// 查询按钮制域
 	$("#queryBtn").attr("disabled",true);
 	
 	var actionUrl=path + "/api/expert/texpertAction!getExpertStatisticList.action?date=" + new Date().getTime();
	var params = [{name:"expertName",targetid:"expertName",type:"text"}];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		$("#queryBtn").removeAttr("disabled");
	});
}); 

 $("#queryBtn").bind("click", function() {
		var actionUrl=path + "/api/expert/texpertAction!getExpertStatisticList.action?date=" + new Date().getTime();
		var params = [{name:"expertName",targetid:"expertName",type:"text"}];
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		var data = upms.transParsToObj(params, $("#searchForm"));
    	$newPgDiv.load(actionUrl, data, function() {
    		upms.hideOverLay();
    	});
});
 
 /**
  * 批量选择专家
  */
 function printExcel(){
	  	var actionUrl=path + "/api/expert/texpertAction!exportDatas.action?now=" + new Date().getTime();
		upms.showOverLay();// 打开遮罩
		window.location.href= actionUrl;
		setTimeout(function(){upms.hideOverLay();},1000);
 }
	// 项目根目录
	var path="";
	
	$(document).ready(function(){
		path = $("#path").text();
		
	 	$("#queryBtn").attr("disabled",true);
	 	var actionUrl=path + "/api/expert/texpertScoreAction!getAuditList.action?date=" + new Date().getTime();
		var params = [{name:"projectName",targetid:"projectName",type:"text"},
		              {name:"applicationUnit",targetid:"applicationUnit",type:"text"}];
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		var data = upms.transParsToObj(params, $("#searchForm"));
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
			$("#queryBtn").removeAttr("disabled");
		});
	}); 

	 $("#queryBtn").bind("click", function() {
	 	var actionUrl=path + "/api/expert/texpertScoreAction!getAuditList.action?date=" + new Date().getTime();
		var params = [{name:"projectName",targetid:"projectName",type:"text"},
		              {name:"applicationUnit",targetid:"applicationUnit",type:"text"}];
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		var data = upms.transParsToObj(params, $("#searchForm"));
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	});
// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	// 计划类别
	upms.upmsUtils.initSelect("projectType1","", 1, 2, 4);
	// 项目分类
	upms.upmsUtils.initSelect("projectType2","", 1, 2, 4);
	// 分计划状态
	upms.upmsUtils.initSelect("isArchival", "", 1, 1, 0);
	// 查询按钮制域
 	$("#queryBtn").attr("disabled",true);
 	
 	var actionUrl=path + "/api/report/tprojectApplicationAction!getArchivalList.action?date=" + new Date().getTime();
	var params = [{name:"projectName",targetid:"projectName",type:"text"},
	              {name:"applicationUnit",targetid:"applicationUnit",type:"text"},
	              {name:"isArchival",targetid:"isArchival",type:"text"},
	              {name:"projectType1",targetid:"projectType1",type:"text"},
	              {name:"projectType2",targetid:"projectType2",type:"text"}];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		$("#queryBtn").removeAttr("disabled");
	});
}); 
// 查询按钮
 $("#queryBtn").bind("click", function() {
		var actionUrl=path + "/api/report/tprojectApplicationAction!getArchivalList.action?date=" + new Date().getTime();
		var params = [{name:"projectName",targetid:"projectName",type:"text"},
		              {name:"applicationUnit",targetid:"applicationUnit",type:"text"},
		              {name:"isArchival",targetid:"isArchival",type:"text"},
		              {name:"projectType1",targetid:"projectType1",type:"text"},
		              {name:"projectType2",targetid:"projectType2",type:"text"}];
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		var data = upms.transParsToObj(params, $("#searchForm"));
    	$newPgDiv.load(actionUrl, data, function() {
    		upms.hideOverLay();
    	});
});
//批量归档项目
 $("#archivalReport").bind("click", function() {

 	// 取得选中的项目id，组成项目idlist
 	if($(":checkbox:checked").length == 0){
 		alert("没有选中的项目，请选择要归档的项目！");
 		return false;
 	}
 	if (confirm($("#comfirmArchival").text())){
	 	// 组织选中的项目ID
	 	var projectIdList = "";
	 	$(":checkbox:checked").each(function(){
	 		projectIdList = projectIdList + $(this).val() + ",";
	 	});
	
	 	var actionUrl= path + "/api/report/tprojectApplicationAction!archivalReportList.action?projectIdList=" + projectIdList + "&now="+new Date().getTime();
	 	upms.showOverLay();// 打开遮罩
	 	var $newPgDiv = $("#mainContent");
	 	var data = {};
	 	$newPgDiv.load(actionUrl, data, function() {
	 		upms.hideOverLay();
	 	});
 	}
 });

 
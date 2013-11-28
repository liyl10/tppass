
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
		// 分计划状态
		 upms.upmsUtils.initSelect("projectViewType", "", 1, 1, 0);
		 
		 var actionUrl = path + "/api/report/tprojectApplicationAction!getProjectViewList.action?now="+ new Date().getTime();
		 upms.showOverLay();// 打开遮罩
		 var $newPgDiv = $("#resultDiv");
		 var arrParams = [  {name:"projectViewTypeStartTime",targetid:"projectViewTypeStartTime",type:"text"},
				  			{name:"projectViewTypeEndTime",targetid:"projectViewTypeEndTime",type:"text"},
				  			{name:"projectViewType",targetid:"projectViewType",type:"select"}];
		 var data = upms.transParsToObj(arrParams, $("#searchForm"));
		 $newPgDiv.load(actionUrl, data, function() {
			 upms.hideOverLay();
		 });
	});
});
$("#countBtn").bind("click", function() {

	var actionUrl = path + "/api/report/tprojectApplicationAction!getProjectViewList.action?now="+ new Date().getTime();
	
	 var params = [  {name:"projectViewTypeStartTime",targetid:"projectViewTypeStartTime",type:"text"},
			  			{name:"projectViewTypeEndTime",targetid:"projectViewTypeEndTime",type:"text"},
			  			{name:"projectViewType",targetid:"projectViewType",type:"select"}];

	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
 });		 

$("#printBtn").bind("click", function() {
	var actionUrl=path + "/api/report/tprojectApplicationAction!exportDatas.action?now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	window.location.href= actionUrl;
	setTimeout(function(){upms.hideOverLay();},1000);
 });		 
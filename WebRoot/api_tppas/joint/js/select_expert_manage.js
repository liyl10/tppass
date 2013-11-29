// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	// 擅长专业
	upms.upmsUtils.initSelect("goodProfess","", 1, 1, 0);
	
	// 信誉度等级
	upms.upmsUtils.initSelect("credibyLevel", "", 1, 1, 0);
	
	// 查询按钮制域
 	var actionUrl=path + "/api/audit/projectApplicationJoint!getSelectedList.action?projectId="+$("#projectId").val()+"&date=" + new Date().getTime();
	var params = [{name:"expertName",targetid:"expertName",type:"text"},
	              {name:"goodProfess",targetid:"goodProfess",type:"text"},
	              {name:"credibyLevel",targetid:"credibyLevel",type:"text"}];
	
	// 查询按钮制域
 	$("#queryBtn").attr("disabled",true);
	
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		$("#queryBtn").removeAttr("disabled");
	});
}); 

/**
 * 点击查询按钮
 */
 $("#queryBtn").bind("click", function() {
	 var actionUrl=path + "/api/audit/projectApplicationJoint!getSelectedList.action?projectId="+$("#projectId").val()+"&date=" + new Date().getTime();
		var params = [{name:"expertName",targetid:"expertName",type:"text"},
	              {name:"goodProfess",targetid:"goodProfess",type:"text"},
	              {name:"credibyLevel",targetid:"credibyLevel",type:"text"}];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});
 
 function back(){
	var actionUrl=path + "/api/audit/projectApplicationJoint!showJointAuditManage.action?date=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();
	});
 }
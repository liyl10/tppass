// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	// 计划类别
	upms.upmsUtils.initSelect("projectType1", "", 1, 2, 4);
	
	// 项目分类
	upms.upmsUtils.initSelect("projectType2", "", 1, 2, 4);
	
	// 审核状态
	upms.upmsUtils.initSelect("auditStatus", "", 1, 1, 0);
	
	// 项目分组
	upms.upmsUtils.initSelect("projectGroup", "", 1, 1, 0);
	
	// 查询按钮制域
 	$("#queryBtn").attr("disabled",true);
 	
 	var actionUrl=path + "/api/audit/projectApplication!getAuditList.action?date=" + new Date().getTime();
	var params = [{name:"projectName",targetid:"projectName",type:"text"},
	              {name:"applyCompany",targetid:"applyCompany",type:"text"},
	              {name:"projectType1",targetid:"projectType1",type:"text"},
	              {name:"projectType2",targetid:"projectType2",type:"text"},
	              {name:"auditStatus",targetid:"auditStatus",type:"text"},
	              {name:"projectGroup",targetid:"projectGroup",type:"text"}];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		$("#queryBtn").removeAttr("disabled");
	});
}); 

 $("#queryBtn").bind("click", function() {
		var actionUrl=path + "/api/audit/projectApplication!getAuditList.action?date=" + new Date().getTime();
		var params = [{name:"projectName",targetid:"projectName",type:"text"},
		              {name:"applyCompany",targetid:"applyCompany",type:"text"},
		              {name:"projectType1",targetid:"projectType1",type:"text"},
		              {name:"projectType2",targetid:"projectType2",type:"text"},
		              {name:"auditStatus",targetid:"auditStatus",type:"text"},
		              {name:"projectGroup",targetid:"projectGroup",type:"text"}];
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
 function batchSelectExpert(){
 	var selectedId = $("#selectedId").val();
 	var actionUrl= path + "/api/audit/projectApplication!showBatchSelectExpert.action?selectedProjectIds="+ selectedId+"&now="+new Date().getTime();
 	upms.showOverLay();// 打开遮罩
 	var $newPgDiv = $("#mainContent");
 	var data = {};
 	$newPgDiv.load(actionUrl, data, function() {
 		upms.hideOverLay();
 	});
 }
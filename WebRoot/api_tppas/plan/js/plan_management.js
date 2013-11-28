// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	// 计划类别
	upms.upmsUtils.initSelect("projectType1","", 1, 2, 4);
	// 项目分类
	upms.upmsUtils.initSelect("projectType2","", 1, 2, 4);
	// 批次
	upms.upmsUtils.initSelect("planBatch", "", 1, 1, 0);
	// 分计划状态
	upms.upmsUtils.initSelect("planState", "", 1, 1, 0);
	// 查询按钮制域
 	$("#queryBtn").attr("disabled",true);
 	
 	var actionUrl=path + "/api/plan/plan!getPlanList.action?date=" + new Date().getTime();
	var params = [{name:"planName",targetid:"planName",type:"text"},
	              {name:"planYear",targetid:"planYear",type:"text"},
	              {name:"planState",targetid:"planState",type:"text"},
	              {name:"planBatch",targetid:"planBatch",type:"text"},
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
		var actionUrl=path + "/api/plan/plan!getPlanList.action?date=" + new Date().getTime();
		var params = [{name:"planName",targetid:"planName",type:"text"},
		              {name:"planYear",targetid:"planYear",type:"text"},
		              {name:"planState",targetid:"planState",type:"text"},
		              {name:"planBatch",targetid:"planBatch",type:"text"},
		              {name:"projectType1",targetid:"projectType1",type:"text"},
		              {name:"projectType2",targetid:"projectType2",type:"text"}];
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		var data = upms.transParsToObj(params, $("#searchForm"));
    	$newPgDiv.load(actionUrl, data, function() {
    		upms.hideOverLay();
    	});
});

// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	
	// 计划类别
	upms.upmsUtils.initSelect("projectType1", "", 1, 2, 4);
	
	// 项目分类
	upms.upmsUtils.initSelect("projectType2", "", 1, 2, 4);
	
	// 计划状态
	upms.upmsUtils.initSelect("planStatus", "", 1, 1, 0);
	
	// 计划年度
	upms.upmsUtils.initSelect("planYear", "", 1, 1, 0);
	
	// 计划批次
	upms.upmsUtils.initSelect("planBatch", "", 1, 1, 0);
	
	// 查询按钮制域
 	$("#queryBtn").attr("disabled",true);
 	
 	var actionUrl=path + "/api/planManage/planManageAction!getPlanManageList.action?date=" + new Date().getTime();
	var params = [{name:"planName",targetid:"planName",type:"text"},
	              {name:"planStatus",targetid:"planStatus",type:"text"},
	              {name:"projectType1",targetid:"projectType1",type:"text"},
	              {name:"projectType2",targetid:"projectType2",type:"text"},
	              {name:"planYear",targetid:"planYear",type:"text"},
	              {name:"planBatch",targetid:"planBatch",type:"text"}];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		$("#queryBtn").removeAttr("disabled");
	});
}); 

 $("#queryBtn").bind("click", function() {
	 	var actionUrl=path + "/api/planManage/planManageAction!getPlanManageList.action?date=" + new Date().getTime();
		var params = [{name:"planName",targetid:"planName",type:"text"},
		              {name:"planStatus",targetid:"planStatus",type:"text"},
		              {name:"projectType1",targetid:"projectType1",type:"text"},
		              {name:"projectType2",targetid:"projectType2",type:"text"},
		              {name:"planYear",targetid:"planYear",type:"text"},
		              {name:"planBatch",targetid:"planBatch",type:"text"}];
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		var data = upms.transParsToObj(params, $("#searchForm"));
    	$newPgDiv.load(actionUrl, data, function() {
    		upms.hideOverLay();
    	});
});
 
 
/**
 * 创建分计划
 */
function createPlan(){
	// 弹出页面actionUrl
	var actionUrl= path + "/api/planManage/planManageAction!beforeCreatePlan.action?&now="+new Date().getTime();
	art.dialog.open(
		actionUrl,
		{
			title: '选择计划项目类别',
			width: '650px',
			height: '310px',
			left: '40%',
			top: '35%',
			lock:true,
			padding: 0,
			okVal: '保存',
			ok: function(){
				var iframe = this.iframe.contentWindow;
				var projectType1 = iframe.document.getElementById("projectType1");
				var projectType2 = iframe.document.getElementById("projectType2");
				var errprojectType2 = iframe.document.getElementById("errorprojectType2");
				// 项目分组未改变
				if(projectType2.value == ""){
					id = projectType2.id;
					if($("#hiddenprojectType2").length >0){
						if(projectType2.value == ""){
							
							if(errprojectType2 != "undefined"){
								$(errprojectType2).remove();
							}
							var text = $("#hidden" + id).val();
							var span = $("<div id='errorprojectType2'><span style='color:red;font-style: normal;'>"+ text + "不能为空！</span></div>");
							$(projectType2).parent().append(span);
							return false;
						}
					}
				}else{
					var actionUrl= path + "/api/planManage/planManageAction!showNewPlan.action?projectType2=" 
						+ projectType2.value + "&now="+new Date().getTime();
					if(projectType1 != null){
						actionUrl = actionUrl + "&projectType1=" + projectType1.value;
					}
				 	upms.showOverLay();// 打开遮罩
				 	var $newPgDiv = $("#mainContent");
				 	var data = {};
				 	$newPgDiv.load(actionUrl, data, function() {
				 		upms.hideOverLay();
				 	});
				}
			},
			cancelVal: '关闭',
			cancel: true
		}
	 );
}
 
 
 /**
  * 批量选择专家
  */
 function batchSelectExpert(){
	
	var selectFlag = false;
	$("input[type='checkbox']").each(function(){
		if($(this).attr("checked") =="checked"){
			selectFlag = true;
		}
	});
	if(!selectFlag){
		alert("请至少选择一条数据！");
		return;
	}
	 
 	var selectedId = $("#selectedId").val();
 	var actionUrl= path + "/api/audit/projectApplication!showBatchSelectExpert.action?selectedProjectIds="+ selectedId+"&now="+new Date().getTime();
 	upms.showOverLay();// 打开遮罩
 	var $newPgDiv = $("#mainContent");
 	var data = {};
 	$newPgDiv.load(actionUrl, data, function() {
 		upms.hideOverLay();
 	});
 }
 
 /**
  * 创建分组
  */
function createGroup(){
	
 	var actionUrl= path + "/api/audit/projectApplication!showCreateGroup.action?now="+new Date().getTime();
 	upms.showOverLay();// 打开遮罩
 	var $newPgDiv = $("#mainContent");
 	var data = {};
 	$newPgDiv.load(actionUrl, data, function() {
 		upms.hideOverLay();
 	});
}

//下载评审意见表
function downLoadExpertScore(){
	var actionUrl= path + "/api/superadmin/worddocDownload!downloadWord.action?now="+new Date().getTime();
	window.location.href=actionUrl;
}
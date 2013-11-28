// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		var pageCount = $("#pageCount").val();
		if(pageCount == 0){
			$("#auditBtn").attr("disabled",true);
			$("#createGroupBtn").attr("disabled",true);
		}
		else{
			$("#auditBtn").removeAttr("disabled");
			$("#createGroupBtn").removeAttr("disabled");
		}
	});
});

// 分页初始化
upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"searchForm",
	resultdivid:"resultDiv",
	url:path + "/api/report/beforeReviewAction!beforeReviewList.action?date=" + new Date().getTime()
});

// 全选
function selectAll(){
	if($("#selectAll").attr("checked")=="checked"){
		$("input[type='checkbox']").attr("checked",true);
	}
	else{
		$("input[type='checkbox']").removeAttr("checked");
	}
}

// 项目初审
function beforeReview(projectId,action){
	var apiaction = action.replace(/\/server\//,"/api/");
	var actionUrl= path + apiaction + "?projectId=" + projectId + "&now="+ new Date().getTime();
	//var actionUrl= path + "/api/report/beforeReviewAction!projectBeforeReview.action?projectId="+ projectId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [];

	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

//申请调配
function applyRedistribute(projectId){
	if(!confirm("确定要对该项目申请调配吗？")){
		return false;
	}
	upms.showOverLay();// 打开遮罩

	var actionUrlSetData = path + "/api/report/beforeReviewAction!projectApplyRedistribute.action?projectId="+ projectId + "&now="+ new Date().getTime();
	$.post(actionUrlSetData ,function(){
		pageDirect();
	});
}

function pageDirect(){
	var actionUrl=path + "/api/report/beforeReviewAction!beforeReviewList.action?date=" + new Date().getTime();
	var params = [{name:"projectName",targetid:"projectName",type:"text"},
	              {name:"companyType",targetid:"companyType",type:"text"},
	              {name:"projectType",targetid:"projectType",type:"text"},
	              {name:"auditStatus",targetid:"auditStatus",type:"text"}];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		$("#queryBtn").removeAttr("disabled");
	});
}



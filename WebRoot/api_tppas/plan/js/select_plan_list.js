// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		
	});
});

// 分页初始化
upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"searchForm",
	resultdivid:"resultDiv"
	//url:path + "/api/plan/plan!getPlanList.action?date=" + new Date().getTime()
});


// 项目申报详细    
function showPlanDetail(planId){
	var actionUrl= path + "/api/plan/plan!showPlanDetail.action?planId="+ planId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

//返回按钮
$("#backBtn").bind("click", function(){
	var backFlag = $("#backFlag").val();
	var actionUrl;
	if(backFlag == 'add'){		
		actionUrl = path + "/api/planCollect/tplanCollectAction!initSearch.action"+ "?now=" + new Date().getTime();
	}else{
		var planId = $("#planCollectId").val();
		actionUrl= path + "/api/planCollect/tplanCollectAction!toUpdataPage.action?planCollectId="+ planId+"&now="+new Date().getTime();
	}
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");

	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

//提交按钮
$("#commitBtn").bind("click", function(){
	var planIdStr = "";
	$("input[type='checkbox'][name='planList']").each(function(){
		if($(this).attr('checked') == "checked"){
			planIdStr = planIdStr + $(this).val() + ",";
		}
	});
	
	if(planIdStr.length < 1){
		alert("没有选择分计划，请先选择合适的分计划再提交。");
		return false;
	}
	if(!confirm("您确定要提交选择的分计划吗？")){
		return false;
	}
	var planId = $("#planCollectId").val();
	var actionUrl = path + "/api/planCollect/tplanCollectAction!selectPlanSubmit.action?planIdStr=" 
		+ planIdStr 
		+ "&planCollectId="
		+ planId
		+ "&now=" 
		+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");

	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});


$("#allSelect").bind("click", function(){ 
	if($("#allSelect").attr('checked') == "checked"){
		$("input[type='checkbox'][name='planList']").each(function(){
			$(this).attr( 'checked',true);
		});
	}else{
		$("input[type='checkbox'][name='planList']").each(function(){
			$(this).attr( 'checked',false);
		});
		
	}
});




// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
	});
});

// 同意
function agree(projectIdList){
	// 验证text
	var result = upms.upmsUtils.inputCheck();
	if(result){
		return;
	}
	
	if(!confirm("确定同意选中项目通过初审吗？")){
		return false;
	}
	var actionUrl= path + "/api/report/beforeReviewAction!agreeBeforeReviewByList.action?projectIdList="+ projectIdList+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [{name:"beforeReviewComment",targetid:"beforeReviewComment",type:"text"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

// 不同意（可修改）
function disagree(projectIdList){
	// 验证text
	var result = upms.upmsUtils.inputCheck();
	
	if(result){
		return;
	}
	
	if(!confirm("确定不同意选中项目通过初审吗？")){
		return false;
	}
	upms.showOverLay();// 打开遮罩
	var actionUrl = path + "/api/report/beforeReviewAction!disagreeBeforeReviewByList.action?projectIdList="+ projectIdList + "&now="+new Date().getTime();
	var $newPgDiv = $("#mainContent");
	var arrParams = [{name:"beforeReviewComment",targetid:"beforeReviewComment",type:"text"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

//不同意（不可修改）
function disagreeUnedit(projectIdList){
	// 验证text
	var result = upms.upmsUtils.inputCheck();
	
	if(result){
		return;
	}
	
	if(!confirm("确定不同意选中项目通过初审，并让其不可修改吗？")){
		return false;
	}
	upms.showOverLay();// 打开遮罩
	var actionUrl = path + "/api/report/beforeReviewAction!disagreeBeforeReviewByListUnedit.action?projectIdList="+ projectIdList + "&now="+new Date().getTime();
	var $newPgDiv = $("#mainContent");
	var arrParams = [{name:"beforeReviewComment",targetid:"beforeReviewComment",type:"text"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

// 返回
function back(){
	pageDirect();
}

function pageDirect(){
	var actionUrl="";
	actionUrl= path + "/api/report/beforeReviewAction!showBeforeReviewSearch.action?&now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}



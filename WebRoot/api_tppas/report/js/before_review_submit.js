// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
	});
});

// 同意
function agree(projectId){
	// 验证text
	var result = upms.upmsUtils.inputCheck();
	
	if(result){
		return;
	}
	if(!confirm("确定要同意该项目申报吗？")){
		return false;
	}
	var actionUrl= path + "/api/report/beforeReviewAction!agreeBeforeReview.action?projectId="
		+ projectId
		+ "&now="
		+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [{name:"beforeReviewComment",targetid:"beforeReviewComment",type:"text"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

// 不同意
function disagree(projectId){
	// 验证text
	var result = upms.upmsUtils.inputCheck();
	
	if(result){
		return;
	}
	if(!confirm("确定不同意该项目申报吗？")){
		return false;
	}
	upms.showOverLay();// 打开遮罩
	var actionUrl = path + "/api/report/beforeReviewAction!disagreeBeforeReview.action?projectId="
		+ projectId 
		+ "&now="
		+ new Date().getTime();
	var $newPgDiv = $("#mainContent");
	var arrParams = [{name:"beforeReviewComment",targetid:"beforeReviewComment",type:"text"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

//不同意（不可修改）
function disAgreeBeforeReviewUnedit(projectId){
	// 验证text
	var result = upms.upmsUtils.inputCheck();
	
	if(result){
		return;
	}
	if(!confirm("确定不同意该项目申报，并让其不可修改吗？")){
		return false;
	}
	upms.showOverLay();// 打开遮罩
	var actionUrl = path + "/api/report/beforeReviewAction!disAgreeBeforeReviewUnedit.action?projectId="
		+ projectId 
		+ "&now="
		+ new Date().getTime();
	var $newPgDiv = $("#mainContent");
	var arrParams = [{name:"beforeReviewComment",targetid:"beforeReviewComment",type:"text"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

// 保存
function save(projectId){
	// 验证text
	var result = upms.upmsUtils.inputCheck();
	
	if(result){
		return;
	}
	if(!confirm("确定要保存初审意见吗？")){
		return false;
	}
	var actionUrl="";
	actionUrl= path + "/api/report/beforeReviewAction!tempSave.action?&projectId=" 
		+ projectId 
		+ "&now="
		+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [{name:"beforeReviewComment",targetid:"beforeReviewComment",type:"text"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

function pageDirect(){
	var actionUrl="";
	actionUrl= path + "/api/report/beforeReviewAction!showBeforeReviewSearch.action?&now=" 
		+ new Date().getTime();
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
	var actionUrlSetData = path + "/api/report/beforeReviewAction!projectApplyRedistribute.action?projectId="
		+ projectId 
		+ "&now="
		+ new Date().getTime();
	$.post(actionUrlSetData,projectId ,function(){
		pageDirect();
	});
}

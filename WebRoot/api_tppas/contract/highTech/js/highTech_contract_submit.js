
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
		if($("#contractFlag").val() == "0"){
			$("input[type='button']").each(function(){
				$(this).attr("disabled",true);
			});
			$("textarea").each(function(){
				$(this).attr("readonly",true);
				$(this).css('background-color','#F0F0F0');
			});
		 }
	});
});

$("#saveBtn").bind("click", function() {

	if(upms.upmsUtils.inputCheck()){
		return;
	}
	var val = confirm($("#comfirmcontractpass").text());
	if (!val) {
	   return;	
	}
	var actionUrl= path + "/api/contract/tcontracthighTech!statusSave.action?now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [ {
		name : "approvalOpinion",
		targetid : "approvalOpinion",
		type : "text"
	},{
		name : "tcontractId",
		targetid : "tcontractId",
		type : "text"
	}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
	upms.hideOverLay();
	});
});

$("#okBtn").bind("click", function() {

	if(upms.upmsUtils.inputCheck()){
		return;
	}
	var val = confirm($("#comfirmcontractpass").text());
	if (!val) {
	   return;	
	}
	var actionUrl= path + "/api/contract/tcontracthighTech!statusOk.action?now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [ {
		name : "approvalOpinion",
		targetid : "approvalOpinion",
		type : "text"
	},{
		name : "tcontractId",
		targetid : "tcontractId",
		type : "text"
	}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
	upms.hideOverLay();
	});
});
	
$("#noBtnModify").bind("click", function() {

	if(upms.upmsUtils.inputCheck()){
		return;
	}
	var actionUrl= path + "/api/contract/tcontracthighTech!statusNo.action?now="+ new Date().getTime();
	
	var val = confirm($("#comfirmcontractnopass").text());
	if (!val) {
	   return;	
	}
	
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [ {
		name : "approvalOpinion",
		targetid : "approvalOpinion",
		type : "text"
	},{
		name : "tcontractId",
		targetid : "tcontractId",
		type : "text"
	}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
	upms.hideOverLay();
	});
});

$("#noBtnModifyNo").bind("click", function() {

	if(upms.upmsUtils.inputCheck()){
		return;
	}
	var actionUrl= path + "/api/contract/tcontracthighTech!statusNoModify.action?now="+ new Date().getTime();
	
	var val = confirm($("#comfirmcontractnopass").text());
	if (!val) {
	   return;	
	}
	
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [ {
		name : "approvalOpinion",
		targetid : "approvalOpinion",
		type : "text"
	},{
		name : "tcontractId",
		targetid : "tcontractId",
		type : "text"
	}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
	upms.hideOverLay();
	});
});
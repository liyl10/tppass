
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});


$("#okBtn").bind("click", function() {
	
	//获取输入项
	var idList = $("input[type='text']");
	
	if(upms.upmsUtils.inputCheck()){
		return;
	}	
	
	if (confirm($("#comfirmSave").text())){
	var actionUrl= path + "/api/contract/tappropriationSingle!inserttappropriationSingle.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		if ($("#mainFlag").val() == '1'){
			$newPgDiv = $("#mainContent");
		}
		var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"},
		                 {name:"tappropriationSingle.remark",targetid:"remark",type:"text"},
		                 {name:"mainFlag",targetid:"mainFlag",type:"text"}];
		// 添加拨款单新增信息
		for(var i=0; i< idList.length; i++){
			var params = {name:idList.eq(i).attr("name"),targetid:idList.eq(i).attr("id"),type:"text"};
			arrParams[arrParams.length] = params;
		}
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
	});
	
// 文字型焦点进入事件
function focusText(now){
	// 清除错误提示信息
	$("#error" + now.id).remove();
}

$("#okBtn1").bind("click", function() {
	
	//获取输入项
	var idList = $("input[type='text']");
	
	if(upms.upmsUtils.inputCheck()){
		return;
	}	 
	
	if (confirm($("#comfirmSave").text())){
	var actionUrl= path + "/api/contract/tappropriationSingle!updatetappropriationSingle.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		if ($("#mainFlag").val() == '1'){
			$newPgDiv = $("#mainContent");
		}
		var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"},
		                 {name:"tappropriationSingle.remark",targetid:"remark",type:"text"},
		                 {name:"tappropriationSingle.appropriationSingleId",targetid:"appropriationSingleId",type:"text"},
		                 {name:"mainFlag",targetid:"mainFlag",type:"text"}];
		// 添加拨款单新增信息
		for(var i=0; i< idList.length; i++){
			var params = {name:idList.eq(i).attr("name"),targetid:idList.eq(i).attr("id"),type:"text"};
			arrParams[arrParams.length] = params;
		}
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
	});

$("#backBtn").bind("click", function() {
	var actionUrl= path + "/api/contract/tappropriationSingle!init.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		if ($("#mainFlag").val() == '1'){
			$newPgDiv = $("#mainContent");
		}
		var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"},
		                 {name:"mainFlag",targetid:"mainFlag",type:"text"}];
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	});

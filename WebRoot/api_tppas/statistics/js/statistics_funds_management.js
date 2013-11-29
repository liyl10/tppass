
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
		 // 计财处的场合
		 
		 if($("#isPlanningDept").val() == 'true'){
			 upms.upmsUtils.initSelect("typeId1","", 1 , 3 , 3);
			 upms.upmsUtils.initSelect("typeId2","", 1 , 3 , 4);
			 upms.upmsUtils.initSelect("typeId3","", 1 , 3 , 4);
		 } else {
			 upms.upmsUtils.initSelect("typeId2","", 1 , 3 , 4);
			 upms.upmsUtils.initSelect("typeId3","", 1 , 3 , 4);
		 }
		 
		 
		 var actionUrl = path + "/api/statistics/fundsAction!queryList.action?now="+ new Date().getTime();
		 upms.showOverLay();// 打开遮罩
		 var $newPgDiv = $("#resultDiv");
		 var arrParams = [  {name:"projectName",targetid:"projectName",type:"text"},
				  			{name:"applicationUnit",targetid:"applicationUnit",type:"text"},
				  			{name:"bank",targetid:"bank",type:"text"},
				  			{name:"bankAccount",targetid:"bankAccount",type:"text"},
				  			{name:"amountFundingStart",targetid:"amountFundingStart",type:"text"},
				  			{name:"amountFundingEnd",targetid:"amountFundingEnd",type:"text"},
				  			{name:"planFundingStart",targetid:"planFundingStart",type:"text"},
				  			{name:"planFundingEnd",targetid:"planFundingEnd",type:"text"},
				  			{name:"appropriationTimeStart",targetid:"appropriationTimeStart",type:"text"},
				  			{name:"appropriationTimeEnd",targetid:"appropriationTimeEnd",type:"text"},
				  			{name:"remark",targetid:"remark",type:"text"},
			  				{name:"typeId1",targetid:"typeId2",type:"select"},
			  				{name:"typeId2",targetid:"typeId3",type:"select"},
			  				{name:"isPlanningDept",targetid:"isPlanningDept",type:"text"}];
			if ($("#isPlanningDept").val() == 'true'){

				arrParams[arrParams.length] = {name:"selectedDept",targetid:"typeId1",type:"select"};
			}
		var data = upms.transParsToObj(arrParams, $("#searchForm"));
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	});
});
$("#queryBtn").bind("click", function() {

	if(upms.upmsUtils.inputCheck()){
		return;
	}	
	
	var actionUrl = path + "/api/statistics/fundsAction!queryList.action?now="+ new Date().getTime();
	
	var params = [  {name:"projectName",targetid:"projectName",type:"text"},
		  			{name:"applicationUnit",targetid:"applicationUnit",type:"text"},
		  			{name:"bank",targetid:"bank",type:"text"},
		  			{name:"bankAccount",targetid:"bankAccount",type:"text"},
		  			{name:"amountFundingStart",targetid:"amountFundingStart",type:"text"},
		  			{name:"amountFundingEnd",targetid:"amountFundingEnd",type:"text"},
		  			{name:"planFundingStart",targetid:"planFundingStart",type:"text"},
		  			{name:"planFundingEnd",targetid:"planFundingEnd",type:"text"},
		  			{name:"appropriationTimeStart",targetid:"appropriationTimeStart",type:"text"},
		  			{name:"appropriationTimeEnd",targetid:"appropriationTimeEnd",type:"text"},
		  			{name:"remark",targetid:"remark",type:"text"},
	  				{name:"typeId1",targetid:"typeId2",type:"select"},
	  				{name:"typeId2",targetid:"typeId3",type:"select"},
	  				{name:"isPlanningDept",targetid:"isPlanningDept",type:"text"}];
	if ($("#isPlanningDept").val() == 'true'){
		params[params.length] = {name:"selectedDept",targetid:"typeId1",type:"select"};
	}
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
 });		 

$("#printBtn").bind("click", function() {
	if(upms.upmsUtils.inputCheck()){
		return;
	}	
	// 判断是否有数据，如果没有可以导出的数据则提示message
	if($("#printEnableFlag").val() =="false"){
		alert("没有查到任何可以导出的记录，请重新选择检索条件。");
		return false;
	}
	
   	var actionUrl=path + "/api/statistics/fundsAction!exportDatas.action?now=" + new Date().getTime();
   	var data = "";
   	data = data + "projectName=" + encodeURIComponent($("#projectName").val())+"&";
	data = data + "applicationUnit=" + encodeURIComponent($("#applicationUnit").val())+"&";
	data = data + "bank=" + encodeURIComponent($("#bank").val())+"&";
	data = data + "bankAccount=" + encodeURIComponent($("#bankAccount").val())+"&";
	data = data + "amountFundingStart=" + encodeURIComponent($("#amountFundingStart").val())+"&";
	data = data + "amountFundingEnd=" + encodeURIComponent($("#amountFundingEnd").val())+"&";
	data = data + "planFundingStart=" + encodeURIComponent($("#planFundingStart").val())+"&";
	data = data + "planFundingEnd=" + encodeURIComponent($("#planFundingEnd").val())+"&";
	data = data + "appropriationTimeStart=" + encodeURIComponent($("#appropriationTimeStart").val())+"&";
	data = data + "appropriationTimeEnd=" + encodeURIComponent($("#appropriationTimeEnd").val())+"&";
	data = data + "remark=" + encodeURIComponent($("#remark").val())+"&";
	data = data + "isPlanningDept=" + encodeURIComponent($("#isPlanningDept").val());
	if ($("#projecTypeManager").val() == 'true'){
		data = data + "&typeId1=" + encodeURIComponent($("#typeId2").val());
		data = data + "&typeId2=" + encodeURIComponent($("#typeId3").val());
	}
	if ($("#isPlanningDept").val() == 'true'){
		data = data + "&selectedDept=" + encodeURIComponent($("#typeId1").val());
	}
	upms.showOverLay();// 打开遮罩
	window.location.href= actionUrl + "&" + (data);
	setTimeout(function(){upms.hideOverLay();},1000); 
 });		 
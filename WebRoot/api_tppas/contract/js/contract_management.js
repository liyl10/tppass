
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
		 upms.upmsUtils.initSelect("contractStatus","", 1 , 1 , 0);
		 upms.upmsUtils.initSelect("typeId1","", 1 , 2 , 4);
		 upms.upmsUtils.initSelect("typeId2","", 1 , 2 , 4);
		 
		 var actionUrl = path + "/api/contract/tcontract!queryList.action?now="+ new Date().getTime();
		 upms.showOverLay();// 打开遮罩
		 var $newPgDiv = $("#resultDiv");
		 var arrParams = [{name:"projectName",targetid:"projectName",type:"text"},
				  			{name:"applicationUnit",targetid:"applicationUnit",type:"text"},
				  			{name:"contractStatus",targetid:"contractStatus",type:"select"},
			  				{name:"typeId1",targetid:"typeId1",type:"select"},
			  				{name:"typeId2",targetid:"typeId2",type:"select"}];

		var data = upms.transParsToObj(arrParams, $("#searchForm"));
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	});
});
$("#queryBtn").bind("click", function() {

	var actionUrl = path + "/api/contract/tcontract!queryList.action?now="+ new Date().getTime();
	
	var params = [  {name:"projectName",targetid:"projectName",type:"text"},
		  			{name:"applicationUnit",targetid:"applicationUnit",type:"text"},
		  			{name:"contractStatus",targetid:"contractStatus",type:"select"},
	  				{name:"typeId1",targetid:"typeId1",type:"select"},
	  				{name:"typeId2",targetid:"typeId2",type:"select"}];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
 });		 
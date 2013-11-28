
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
		 upms.upmsUtils.initSelect("centralizedType",$("#centralizedTypeValue").val(), 1 , 1 , 0);
		 upms.upmsUtils.initSelect("unitProperties",$("#unitPropertiesValue").val(), 1 , 1 , 0);
		 upms.upmsUtils.initSelect("intellectualProperty",$("#intellectualPropertyValue").val(), 1 , 1 , 0);
		 upms.upmsUtils.initSelect("technologySource",$("#technologySourceValue").val(), 1 , 1 , 0);
		 // 计财处的场合
		 if($("#planningFlag").val() == "1"){
			 upms.upmsUtils.initSelect("typeId1",$("#typeId1Value").val(), 1 , 3 , 3);
			 upms.upmsUtils.initSelect("typeId2",$("#typeId2Value").val(), 1 , 3 , 4);
			 upms.upmsUtils.initSelect("typeId3",$("#typeId3Value").val(), 1 , 3 , 4);
		 } else {
			 upms.upmsUtils.initSelect("typeId2",$("#typeId2Value").val(), 1 , 3 , 4);
			 upms.upmsUtils.initSelect("typeId3",$("#typeId3Value").val(), 1 , 3 , 4);
		 }
		 upms.upmsUtils.initSelect("technicalFisld1",$("#technicalFisld1Value").val(), 1 , 3 , 2);
		 upms.upmsUtils.initSelect("technicalFisld2",$("#technicalFisld2Value").val(), 1 , 3 , 2);
		 upms.upmsUtils.initSelect("technicalFisld3",$("#technicalFisld3Value").val(), 1 , 3 , 2);
		 upms.upmsUtils.initSelect("regionId1",$("#regionId1Value").val(), 1 , 3 , 2);
		 upms.upmsUtils.initSelect("regionId2",$("#regionId2Value").val(), 1 , 3 , 2);
		 upms.upmsUtils.initSelect("regionId3",$("#regionId3Value").val(), 1 , 3 , 2);
		 upms.upmsUtils.initSelect("industries1",$("#industries1Value").val(), 1 , 4 , 2);
		 upms.upmsUtils.initSelect("industries2",$("#industries2Value").val(), 1 , 4 , 2);
		 upms.upmsUtils.initSelect("industries3",$("#industries3Value").val(), 1 , 4 , 2);
		 upms.upmsUtils.initSelect("industries4",$("#industries4Value").val(), 1 , 4 , 2);
		
		//显示导出数据按钮
	    	$("#dcsj").css({ display:""});
	    	//$("#dcsj").disabled=true;
	    	//隐藏全选、全不选、导出按钮
	    	$("#dcAllBut").css({display:"none"});
		 
		// 检索跳转处理
		pageDirect();
	});
});

// 查询按钮
$("#queryBtn").bind("click", function() {
	
	//显示导出数据按钮
	$("#dcsj").css({ display:""});
	//$("#dcsj").disabled=true;
	//隐藏全选、全不选、导出按钮
	$("#dcAllBut").css({display:"none"});
	
	// 检索跳转处理
	pageDirect();
});

// 画面跳转：一览画面
function pageDirect(){
	var actionUrl= path + "/api/statistics/statisticsProject!query.action?now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var arrParams = [{name:"tprojectApplication.projectName",targetid:"projectName",type:"text"},
	                 {name:"tprojectApplication.applicationUnit",targetid:"applicationUnit",type:"text"},
	                 {name:"tprojectApplication.centralizedType",targetid:"centralizedType",type:"text"},
	                 {name:"tprojectApplication.reportYear",targetid:"reportYear",type:"text"},
	                 {name:"planningFlag",targetid:"planningFlag",type:"text"},
	                 {name:"typeId1",targetid:"typeId1",type:"text"},
	                 {name:"typeId2",targetid:"typeId2",type:"text"},
	                 {name:"typeId3",targetid:"typeId3",type:"text"},
	                 {name:"tprojectInfob.regionId1",targetid:"regionId1",type:"text"},
	                 {name:"tprojectInfob.regionId2",targetid:"regionId2",type:"text"},
	                 {name:"tprojectInfob.regionId3",targetid:"regionId3",type:"text"},
	                 {name:"tprojectInfob.unitAddress",targetid:"unitAddress",type:"text"},
	                 {name:"tprojectInfob.industries1",targetid:"industries1",type:"text"},
	                 {name:"tprojectInfob.industries2",targetid:"industries2",type:"text"},
	                 {name:"tprojectInfob.industries3",targetid:"industries3",type:"text"},
	                 {name:"tprojectInfob.industries4",targetid:"industries4",type:"text"},
	                 {name:"tprojectInfob.unitProperties",targetid:"unitProperties",type:"text"},
	                 {name:"tprojectInfob.assistUnit",targetid:"assistUnit",type:"text"},
	                 {name:"tprojectInfob.technicalFisld1",targetid:"technicalFisld1",type:"text"},
	                 {name:"tprojectInfob.technicalFisld2",targetid:"technicalFisld2",type:"text"},
	                 {name:"tprojectInfob.technicalFisld3",targetid:"technicalFisld3",type:"text"},
	                 {name:"tprojectInfob.intellectualProperty",targetid:"intellectualProperty",type:"text"},
	                 {name:"tprojectInfob.technologySource",targetid:"technologySource",type:"text"}];

	var data = upms.transParsToObj(arrParams, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

//画面跳转：一览画面
function exportShow(){
	//显示导出明细按钮
 	$("#dcsj").css({ display:"none"});
	//隐藏全选、全不选、导出按钮
 	$("#dcAllBut").css({ display:""}); 
 	
	var actionUrl= path + "/api/statistics/statisticsProject!initExport.action?now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var arrParams = [{name:"tprojectApplication.projectName",targetid:"projectName",type:"text"},
	                 {name:"tprojectApplication.applicationUnit",targetid:"applicationUnit",type:"text"},
	                 {name:"tprojectApplication.centralizedType",targetid:"centralizedType",type:"text"},
	                 {name:"tprojectApplication.reportYear",targetid:"reportYear",type:"text"},
	                 {name:"planningFlag",targetid:"planningFlag",type:"text"},
	                 {name:"typeId1",targetid:"typeId1",type:"text"},
	                 {name:"typeId2",targetid:"typeId2",type:"text"},
	                 {name:"typeId3",targetid:"typeId3",type:"text"},
	                 {name:"tprojectInfob.regionId1",targetid:"regionId1",type:"text"},
	                 {name:"tprojectInfob.regionId2",targetid:"regionId2",type:"text"},
	                 {name:"tprojectInfob.regionId3",targetid:"regionId3",type:"text"},
	                 {name:"tprojectInfob.unitAddress",targetid:"unitAddress",type:"text"},
	                 {name:"tprojectInfob.industries1",targetid:"industries1",type:"text"},
	                 {name:"tprojectInfob.industries2",targetid:"industries2",type:"text"},
	                 {name:"tprojectInfob.industries3",targetid:"industries3",type:"text"},
	                 {name:"tprojectInfob.industries4",targetid:"industries4",type:"text"},
	                 {name:"tprojectInfob.unitProperties",targetid:"unitProperties",type:"text"},
	                 {name:"tprojectInfob.assistUnit",targetid:"assistUnit",type:"text"},
	                 {name:"tprojectInfob.technicalFisld1",targetid:"technicalFisld1",type:"text"},
	                 {name:"tprojectInfob.technicalFisld2",targetid:"technicalFisld2",type:"text"},
	                 {name:"tprojectInfob.technicalFisld3",targetid:"technicalFisld3",type:"text"},
	                 {name:"tprojectInfob.intellectualProperty",targetid:"intellectualProperty",type:"text"},
	                 {name:"tprojectInfob.technologySource",targetid:"technologySource",type:"text"}];

	var data = upms.transParsToObj(arrParams, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}
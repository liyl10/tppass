
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
		 upms.upmsUtils.initSelect("centralizedType","", 1 , 1 , 0);
		 upms.upmsUtils.initSelect("unitProperties","", 1 , 1 , 0);
    	 upms.upmsUtils.initSelect("technicalFisld1","", 1 , 3 , 2);
    	 upms.upmsUtils.initSelect("technicalFisld2","", 1 , 3 , 2);
    	 upms.upmsUtils.initSelect("technicalFisld3","", 1 , 3 , 2);
		 upms.upmsUtils.initSelect("intellectualProperty","", 1 , 1 , 0);
		 upms.upmsUtils.initSelect("technologySource","", 1 , 1 , 0);
		 // 计财处的场合
		 /*if($("#planningFlag").val() == "1"){
			 upms.upmsUtils.initSelect("typeId1","", 1 , 3 , 3);
			 upms.upmsUtils.initSelect("typeId2","", 1 , 3 , 4);
			 upms.upmsUtils.initSelect("typeId3","", 1 , 3 , 4);
		 } else {*/
			 upms.upmsUtils.initSelect("typeId2","", 1 , 3 , 4);
			 upms.upmsUtils.initSelect("typeId3","", 1 , 3 , 4);
		/* }*/
		 upms.upmsUtils.initSelect("regionId1",$("#regionId1Value").val(), 1 , 3 , 2);
		 upms.upmsUtils.initSelect("regionId2",$("#regionId2Value").val(), 1 , 3 , 2);
		 upms.upmsUtils.initSelect("regionId3","", 1 , 3 , 2);
		 upms.upmsUtils.initSelect("industries1","", 1 , 4 , 2);
		 upms.upmsUtils.initSelect("industries2","", 1 , 4 , 2);
		 upms.upmsUtils.initSelect("industries3","", 1 , 4 , 2);
		 upms.upmsUtils.initSelect("industries4","", 1 , 4 , 2);
		
		// 检索跳转处理
		pageDirect();
	});
});

// 查询按钮
$("#queryBtn").bind("click", function() {
	// 检索跳转处理
	pageDirect();
});

// 画面跳转：一览画面
function pageDirect(){
	var actionUrl= path + "/api/industry/industryAction!getProjectList.action?now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var arrParams = [{name:"projectName",targetid:"projectName",type:"text"},
	                 {name:"applicationUnit",targetid:"applicationUnit",type:"text"},
	                 {name:"centralizedType",targetid:"centralizedType",type:"text"},
	                 {name:"reportYear",targetid:"reportYear",type:"text"},
	                 {name:"planningFlag",targetid:"planningFlag",type:"text"},
	                 /*{name:"typeId1",targetid:"typeId1",type:"text"},*/
	                 {name:"typeId2",targetid:"typeId2",type:"text"},
	                 {name:"typeId3",targetid:"typeId3",type:"text"},
	                 {name:"regionId1",targetid:"regionId1",type:"text"},
	                 {name:"regionId2",targetid:"regionId2",type:"text"},
	                 {name:"regionId3",targetid:"regionId3",type:"text"},
	                 {name:"unitAddress",targetid:"unitAddress",type:"text"},
	                 {name:"industries1",targetid:"industries1",type:"text"},
	                 {name:"industries2",targetid:"industries2",type:"text"},
	                 {name:"industries3",targetid:"industries3",type:"text"},
	                 {name:"industries4",targetid:"industries4",type:"text"},
	                 {name:"unitProperties",targetid:"unitProperties",type:"text"},
	                 {name:"assistUnit",targetid:"assistUnit",type:"text"},
	                 {name:"technicalFisld1",targetid:"technicalFisld1",type:"text"},
	                 {name:"technicalFisld2",targetid:"technicalFisld2",type:"text"},
	                 {name:"technicalFisld3",targetid:"technicalFisld3",type:"text"},
	                 {name:"intellectualProperty",targetid:"intellectualProperty",type:"text"},
	                 {name:"technologySource",targetid:"technologySource",type:"text"}];

	var data = upms.transParsToObj(arrParams, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}


//导出按钮
$("#exportBtn").bind("click", function() {
	
	var actionUrl=path + "/api/industry/industryAction!showExportProject.action?now=" + new Date().getTime();
	//var params = [];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	// var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();
	});
});
// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	
	// 计划类别
	upms.upmsUtils.initSelect("projectType1", "", 1, 2, 4);
	
	// 项目分类
	upms.upmsUtils.initSelect("projectType2", "", 1, 2, 4);

	// 查询按钮制域
 	$("#queryBtn").attr("disabled",true);
 	
 	// 项目企业信息打印按钮显示区分
 	if($("#projectInfoBtnFlag").val() == "true"){
 		$("#projectCompanyBtn").attr("disabled",true);
 	}
 	var actionUrl=path + "/api/audit/projectApplicationProposals!getProposalsList.action?date=" + new Date().getTime();
	var params = [{name:"projectName",targetid:"projectName",type:"text"},
	              {name:"applyCompany",targetid:"applyCompany",type:"text"},
	              {name:"projectType1",targetid:"projectType1",type:"text"},
	              {name:"projectType2",targetid:"projectType2",type:"text"}];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		$("#queryBtn").removeAttr("disabled");
	});
}); 

 $("#queryBtn").bind("click", function() {
		var actionUrl=path + "/api/audit/projectApplicationProposals!getProposalsList.action?date=" + new Date().getTime();
		var params = [{name:"projectName",targetid:"projectName",type:"text"},
		              {name:"applyCompany",targetid:"applyCompany",type:"text"},
		              {name:"projectType1",targetid:"projectType1",type:"text"},
		              {name:"projectType2",targetid:"projectType2",type:"text"}];
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		var data = upms.transParsToObj(params, $("#searchForm"));
    	$newPgDiv.load(actionUrl, data, function() {
    		upms.hideOverLay();
    	});
});
 
 /**
  * 打印评审结果
  */
 function printExpertScoreAll(){
	 //encodeURI
	 //项目名称 projectName
	 var projectName = $("#projectName").val();
	 //申报单位 applyCompany
	 var applyCompany = $("#applyCompany").val();
//	 //项目分组 projectGroup
//	 var projectGroup = $("#projectGroup").val();
//	 //审核状态 auditStatus
//	 var auditStatus = $("#auditStatus").val();
	 //项目分类 projectType1 projectType2
	 var projectType1 = "";
	 if($("#projectType1").length>0){
		 projectType1 = $("#projectType1").val();
	 }
	 var projectType2 = "";
	 if($("#projectType2").length>0){
		 projectType1 = $("#projectType2").val();
	 }
	 var param = "projectName="+encodeURI(projectName)+"&applyCompany="+encodeURI(applyCompany)+"&projectType1="+projectType1+"&projectType2="+projectType2+"&now=" + new Date().getTime();
	 
	 var actionUrl=path + "/api/expert/texpertScoreWriteAction!printExpertScoreAll.action?"+param;
	 upms.showOverLay();// 打开遮罩
	 window.location.href= actionUrl;
	 setTimeout(function(){upms.hideOverLay();},1000);
 }
 
 /**
  * 批量推荐
  */
 function recommendBtn(){
	var selectFlag = false;
	$("input[type='checkbox']").each(function(){
		if($(this).attr("checked") =="checked"){
			selectFlag = true;
		}
	});
	if(!selectFlag){
		alert("请至少选择一条数据！");
		return;
	}
	if(confirm($("#comfirmTj").text())){
		var selectedId = $("#selectedId").val();
		var actionUrl= path + "/api/audit/projectApplicationProposals!recommend.action?selectedProjectIds="+ selectedId+"&now="+new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		var data = {};
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	 }
 }

 /**
  * 批量备选
  */
 function alternativeBtn(){
	
	var selectFlag = false;
	$("input[type='checkbox']").each(function(){
		if($(this).attr("checked") =="checked"){
			selectFlag = true;
		}
	});
	if(!selectFlag){
		alert("请至少选择一条数据！");
		return;
	}
	if(confirm($("#comfirmBx").text())){
		var selectedId = $("#selectedId").val();
		var actionUrl= path + "/api/audit/projectApplicationProposals!alternative.action?selectedProjectIds="+ selectedId+"&now="+new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		var data = {};
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	 }
 }
 
 /**
  * 批量落选
  */
 function unsuccessfulBtn(){
	
	var selectFlag = false;
	$("input[type='checkbox']").each(function(){
		if($(this).attr("checked") =="checked"){
			selectFlag = true;
		}
	});
	if(!selectFlag){
		alert("请至少选择一条数据！");
		return;
	}
	if(confirm($("#comfirmLx").text())){
		var selectedId = $("#selectedId").val();
		var actionUrl= path + "/api/audit/projectApplicationProposals!unsuccessful.action?selectedProjectIds="+ selectedId+"&now="+new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		var data = {};
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	 }
 }

 /**
  * 打印项目企业信息表
  */
 function printProjectResult(){
	 var actionUrl=path + "/api/statistics/vprojectResultCollectAction!exportDatas.action?jumpFlag=" + "joint" +"&now=" + new Date().getTime();
	   upms.showOverLay();// 打开遮罩
	   window.location.href= actionUrl;
	   setTimeout(function(){upms.hideOverLay();},1500);      
 }
// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
	});
});

$("#backBtn").bind("click", function() {
	
	var actionUrl= path + "/server/supervisor/supervisorReportAction!getReportList.action?now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [{name:"supervisorId",targetid:"supervisorId",type:"text"},
	                 {name:"projectId",targetid:"projectId",type:"text"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

$("#saveBtn").bind("click", function() {
	var textareaList = $("textarea");
	var flag = true;
	flag = checkInputData(textareaList);
	
	if(!flag){
		return;
	}
	
	if (!confirm($("#comfirmUpdate").text())) {
		return;
	}
	var actionUrl= path + "/server/supervisor/supervisorReportAction!updateReport.action?now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [{name:"projectId",targetid:"projectId",type:"text"},
	                 {name:"supervisorId",targetid:"supervisorId",type:"text"},
	                 {name:"supervisorReport.reportId",targetid:"reportId",type:"text"},
	                 {name:"supervisorReport.studyContent",targetid:"studyContent",type:"text"},
				     {name:"supervisorReport.everyIndex",targetid:"everyIndex",type:"text"},				    
				     {name:"supervisorReport.knowledgeProperty",targetid:"knowledgeProperty",type:"text"},
				     {name:"supervisorReport.personalDevelop",targetid:"personalDevelop",type:"text"},
				     {name:"supervisorReport.fundCase",targetid:"fundCase",type:"text"},
				     {name:"supervisorReport.fundsCase",targetid:"fundsCase",type:"text"},
				     {name:"supervisorReport.managerExperience",targetid:"managerExperience",type:"text"},
				     {name:"supervisorReport.existQuestion",targetid:"existQuestion",type:"text"},
				     {name:"supervisorReport.reportType",targetid:"reportType",type:"text"},
				     {name:"supervisorReport.submitTime",targetid:"submitTime",type:"text"},
				     {name:"supervisorReport.checkState",targetid:"checkState",type:"text"},
				     {name:"supervisorReport.deleteFlag",targetid:"deleteFlag",type:"text"},
				     {name:"supervisorReport.createTime",targetid:"createTime",type:"text"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		});
	});

function checkInputData(textareaList){
	var flag = true;
	textareaList.each(function(i){
		$("#msg_" + this.id).hide();
		if($(this).text().length>1000)
		{
			$(this).after($("<div/>").attr("id","msg_" + this.id).text($(this).attr("name") + "不能超过1000字！").css("color","red"));
			flag = false;
		}
	});
	return flag;
}

function blurText(now){
	if($(now).text().length>1000)
	{
		$(now).after($("<div/>").attr("id","msg_" + now.id).text($(now).attr("name") + "不能超过1000字！").css("color","red"));
	}
}
	
function focusText(now){
	$("#msg_" + now.id).hide();
}
// 工程根目录
var path="";

$(function() {
	    $(document).ready(function() {
			path = $("#path").text();
	    	$("select").each(function () {
	    		$(this).prepend("<option value=''>----请选择----</option>");
	    		$(this).attr("value",'');
	    		$(this).chosen();
	    	});
	    });
	});

upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"",
	resultdivid:"resultDiv",
	url:path +"/api/reportingunit/TreportingUnitAction!creditInit.action?now="+new Date().getTime()
});

//保存单位信誉度信息
$("#btnSave").bind("click", function() {
	var actionUrl=path +"/api/reportingunit/TreportingUnitAction!creditInfoSave.action";
	var val = confirm($("#comfirmSave").text());
	 if (!val) {
	    return; 
	 }
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");

	var arrParams = 
		[{name : "",targetid : "",type : "text"}, 
		 {name : "",targetid : "",type : "select"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

//返回申报单位管理画面
function goBack(){
		var actionUrl= path + "/api/reportingunit/TreportingUnitAction!list.action?now="+new Date().getTime();
		upms.showOverLay();// 打开遮罩
		upms.clearWebObj();
		var $newPgDiv = upms.createPageDiv();//$("#mainContent");
		$newPgDiv.load(actionUrl, null, function() {
			upms.hideOverLay();});
}

//项目信息
function showProjectDetai1(projectID){
	var actionUrl=path + "/api/reportingunit/TreportingUnitAction!projectInfo.action";
	var arrParams = "&projectID=" + projectID;
	upms.showOverLay();// 打开遮罩
	upms.clearWebObj();
	var $newPgDiv = upms.createPageDiv();//$("#mainContent");
	$newPgDiv.load(actionUrl+"?now="+ new Date().getTime()+arrParams, null, function() {
		upms.hideOverLay();});
}
// 工程根目录
var path="";

$(function() {
	    $(document).ready(function() {
			path = $("#path").text();
	    });
});

upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"",
	resultdivid:"resultDiv",
	url:path + "/api/reportingunit/TreportingUnitAction!creditInit.action?now="+new Date().getTime()
});

//返回单位信誉度画面
function goBack(){
	var actionUrl= path + "/api/reportingunit/TreportingUnitAction!creditInit.action?now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	upms.clearWebObj();
	var $newPgDiv = upms.createPageDiv();//$("#mainContent");
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();});
}
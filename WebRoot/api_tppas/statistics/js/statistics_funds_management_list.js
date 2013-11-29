
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});

//分页
upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({
	pgbtnid : "pgbtn",
	queryformid : "searchForm",
	resultdivid : "resultDiv",
	url : path + "/api/statistics/fundsAction!queryList.action?now="
				+ new Date().getTime()
				+ "&isPlanningDept=" + $("#isPlanningDept").val()
});

function showDetail(tcontractId){
	var actionUrl=path + "/api/contract/tcontract!importTcontract.action?tcontractId="+ tcontractId +"&now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	upms.clearWebObj();
	var $newPgDiv = upms.createPageDiv();//$("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();});
}	


function showBkd(tcontractId){
	var actionUrl=path + "/api/contract/tappropriationSingle!init.action?tcontractId="+ tcontractId 
					   + "&mainFlag=" + "1" 
						+"&now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	upms.clearWebObj();
	var $newPgDiv = upms.createPageDiv();//$("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();});
}	


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
		queryformid:"searchForm",
		resultdivid:"resultDiv",
		url:path +"/api/superadmin/mtype!queryType.action"
});

function doDel(obj){
	var val = confirm($("#comfirmDelete").text());
	if (!val) {
	    return;
	}
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var actionUrl=path +"/api/superadmin/mtype!deleteMtype.action?typeId=" + obj + "&now="+ new Date().getTime();

	$newPgDiv.load(actionUrl,{},function(){
		upms.hideOverLay();
	});

}

function doUpdate(obj){
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var actionUrl=""+ path +"/api/superadmin/mtype!initUpdateType.action";
	var arrParams = "&typeId=" + obj;
	//$("#resultDiv").html("");
	$newPgDiv.load(actionUrl+"?now="+ new Date().getTime()+arrParams,{},function(){
		upms.hideOverLay();
		});

}

$("#addNewItemBtn").bind("click", function() {
	var actionUrl=path +"/api/superadmin/mtype!initNewType.action";
 	upms.showOverLay();// 打开遮罩 
	var $newPgDiv = $("#mainContent");

	$newPgDiv.load(actionUrl+"?now="+ new Date().getTime(), null, function() {
 		upms.hideOverLay(); 
	});
});
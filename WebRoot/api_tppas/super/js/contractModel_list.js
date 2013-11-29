
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
		url:path +"/api/superadmin/contractModel!list.action"
	});
	

function doDel(obj){
	var val = confirm($("#comfirmDelete").text());
	 if (!val) {
	    return; 
	 }
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var actionUrl=path +"/api/superadmin/contractModel!delete.action";
	var arrParams = "&contractTemplateId=" + obj;
	//alert(arrParams);
	$newPgDiv.load(actionUrl+"?now="+ new Date().getTime()+arrParams,{},function(){
		upms.hideOverLay();
		});

}

function doUpdate(obj){
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var actionUrl=path +"/api/superadmin/contractModel!insert.action";
	var arrParams = "&contractTemplateId=" + obj;
	//alert(arrParams);
	$newPgDiv.load(actionUrl+"?now="+ new Date().getTime()+arrParams,{},function(){
		upms.hideOverLay();
		});

}

$("#addNewItemBtn").bind("click", function() {
	
	if($("#addNewItemBtn").attr("disabled")){
		return;
	}
	var actionUrl=path +"/api/superadmin/contractModel!insert.action?date=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩

	var $newPgDiv = $("#mainContent");


	var data = null;
	$newPgDiv.load(actionUrl + "?now="+ new Date().getTime() , data, function() {
		upms.hideOverLay();});
});	

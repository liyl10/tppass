
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
		url:path +"/api/superadmin/typeModel!list.action"
	});
	

function doDel(obj){
	var val = confirm($("#comfirmDelete").text());
	 if (!val) {
	    return; 
	 }
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var actionUrl=path +"/api/superadmin/typeModel!delete.action";
	var arrParams = "&typeId=" + obj;
	//alert(arrParams);
	$newPgDiv.load(actionUrl+"?now="+ new Date().getTime()+arrParams,{},function(){
		upms.hideOverLay();
		});

}

function doUpdate(obj){
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var actionUrl=path +"/api/superadmin/typeModel!insert.action";
	var arrParams = "&typeId=" + obj;
	//alert(arrParams);
	$newPgDiv.load(actionUrl+"?now="+ new Date().getTime()+arrParams,{},function(){
		upms.hideOverLay();
		});

}
// 增加专家评审模板
function doAddExper(typeId,parentTypeId){
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var actionUrl=path +"/api/superadmin/texpertreviewcommentsaction!list.action?typeId=" + typeId +"&parentTypeId="+parentTypeId+"&date=" + new Date().getTime();
	var arrParams = {};
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});

}

$("#addNewItemBtn").bind("click", function() {
	
	if($("#addNewItemBtn").attr("disabled")){
		return;
	}
	var actionUrl=path +"/api/superadmin/typeModel!insert.action?date=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩

	var $newPgDiv = $("#mainContent");


	var data = null;
	$newPgDiv.load(actionUrl + "?now="+ new Date().getTime() , data, function() {
		upms.hideOverLay();});
});	

//分配专员
function assignUser(typeId){
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var actionUrl=path +"/api/superadmin/tprojectTypeManagerAction!getManagerInfo.action?typeId="+typeId+"&now="+new Date().getTime();
	$newPgDiv.load(actionUrl,{},function(){
		upms.hideOverLay();
	});
}

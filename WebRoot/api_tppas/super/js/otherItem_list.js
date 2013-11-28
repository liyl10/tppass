
// 工程根目录
var path="";

$(function() {

	$(document).ready(function() {
		path = $("#path").text();
		if($("#masterType").val()==''){
			$("#addNewItemBtn").attr("disabled",true);
		}
		else{
			$("#addNewItemBtn").removeAttr("disabled");
		}
		
	});
	
});

upms.grid.gridHover($(".t-list"));
	upms.pagequery.initpaging({// 分页
		pgbtnid:"pgbtn",
		queryformid:"searchForm",
		resultdivid:"resultDiv",
		url:path +"/api/superadmin/mitem!queryOtherList.action"
	});
	

function doDel(obj, typeId){
	var val = confirm($("#comfirmDelete").text());
	 if (!val) {
	    return; 
	 }
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var actionUrl=path +"/api/superadmin/mitem!updateDept.action";
	var arrParams = "&masterType=" + $("#masterType option:selected").val() + "&itemId=" + obj;
	//alert(arrParams);
	$newPgDiv.load(actionUrl+"?now="+ new Date().getTime()+arrParams,{},function(){
		upms.hideOverLay();
		});

}

function doUpdate(obj, typeId, typeName){
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var actionUrl=path +"/api/superadmin/mitem!initNewOtherItem.action";
	var arrParams = "&itemType=" + typeId + "&itemId=" + obj + "&masterTypeName="+ encodeURIComponent(typeName);
	arrParams = arrParams + "&masterType=" + $("#masterType option:selected").val();
	//alert(arrParams);
	$newPgDiv.load(actionUrl+"?now="+ new Date().getTime()+arrParams,{},function(){
		upms.hideOverLay();
		});

}

$("#addNewItemBtn").bind("click", function() {
	
	if($("#addNewItemBtn").attr("disabled")){
		return;
	}
	var actionUrl=path +"/api/superadmin/mitem!initNewOtherItem.action";
	upms.showOverLay();// 打开遮罩

	var $newPgDiv = $("#mainContent");


	var data = null;
	$newPgDiv.load(actionUrl + "?now="+ new Date().getTime() +"&masterType="+$("#masterType option:selected").val()+"&itemType="+$("#masterType option:selected").val()+"&masterTypeName="+ encodeURIComponent($("#masterType option:selected").text()) , data, function() {
		upms.hideOverLay();});
});	



$("#masterType").change(function() {
	if($("#masterType").val()==''){
		$("#addNewItemBtn").attr("disabled",true);
	}
	else{
		$("#addNewItemBtn").removeAttr("disabled");
	}
});
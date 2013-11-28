// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
		 
		if("<s:property value='%{allBtn}' escape='true'/>"=="true"){
			$("#allBtn").attr("disabled",false);
		} else {
			$("#allBtn").attr("disabled",true);
		}
	});
});


$(function() {
    $(document).ready(function() {
    	//初始化下拉框
      	$("#unitNature").prepend("<option value=''>----请选择----</option>");
      	$("#unitNature").attr("value",'');
      	$("#unitNature").chosen();
      	
      	//查询数据
      	var actionUrl=path + "/api/reportingunit/TreportingUnitAction!getlist.action?now="+ new Date().getTime();
     	var params = [  {name:"unitName",targetid:"unitName",type:"text"},
     	  				{name:"unitNature",targetid:"unitNature",type:"select"}];
     	upms.showOverLay();// 打开遮罩
     	var $newPgDiv = $("#resultDiv");
     	var data = upms.transParsToObj(params, $("#searchForm"));
     	$newPgDiv.load(actionUrl, data, function() {
     		upms.hideOverLay();
     	});		
    });
});
//单击查询按钮
$("#queryBtn").bind("click", function() {
	var actionUrl = path + "/api/reportingunit/TreportingUnitAction!getlist.action?now="+ new Date().getTime();
	
	var params = [  {name:"unitName",targetid:"unitName",type:"text"},
 	  				{name:"unitNature",targetid:"unitNature",type:"select"}];
 	upms.showOverLay();// 打开遮罩
 	var $newPgDiv = $("#resultDiv");
 	var data = upms.transParsToObj(params, $("#searchForm"));
 	$newPgDiv.load(actionUrl, data, function() {
 		upms.hideOverLay();
 	});	
 });

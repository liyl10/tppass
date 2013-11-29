
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});
$(function() {

	$(document).ready(function() {
		initSelect("departmentId", $("#hiddendepartmentId").val());
		initSelect("isShow", $("#hiddenisShow").val());
			var actionUrl=path +"/api/superadmin/typeModel!list.action?date=" + new Date().getTime();
			var params = [
					{name:"modelName"}
					];
			upms.showOverLay();// 打开遮罩
			var $newPgDiv = $("#resultDiv");
			var data = upms.transParsToObj(params, $("#searchForm"));

			$newPgDiv.load(actionUrl, data, function() {
				upms.hideOverLay();
				$("#querybtn").removeAttr("disabled");
			});
		 
	});
});

$("#querybtn").bind("click", function() {
	
	var actionUrl=path +"/api/superadmin/typeModel!list.action?date="
								+ new Date().getTime();
	var params = [ {
		name : "realName",
		targetid : "realName",
		type : "text"
	},{
		name : "showName",
		targetid : "showName",
		type : "text"
	} ,{
		name : "departmentId",
		targetid : "departmentId",
		type : "select"
	}  ,{
		name : "isShow",
		targetid : "isShow",
		type : "select"
	} ];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms
			.transParsToObj(params, $("#searchForm"));

	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});

});

//初始化下拉列表
function initSelect(selectId,value){
 $("#" + selectId).prepend("<option value=''>----请选择----</option>");
 if(value == ""){
   $("#"+ selectId).attr("value",'');
  }	
	$("#"+selectId).chosen();	
}
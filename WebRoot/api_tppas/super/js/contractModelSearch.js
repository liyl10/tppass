
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});
$(function() {

	$(document).ready(function() {
			var actionUrl=path +"/api/superadmin/contractModel!list.action?date=" + new Date().getTime();
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
	
	var actionUrl=path +"/api/superadmin/contractModel!list.action?date="
								+ new Date().getTime();
	var params = [ {
		name : "modelName",
		targetid : "modelName",
		type : "text"
	} ];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms
			.transParsToObj(params, $("#searchForm"));

	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});

});
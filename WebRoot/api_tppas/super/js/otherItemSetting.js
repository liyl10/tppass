
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});
$(function() {

	$(document).ready(function() {
		$("#querybtn").attr("disabled",true);
		$("#masterType").prepend("<option value=''>----请选择----</option>");
		if($("#masterTypeName").val()==''){
			$("#masterType").attr("value",'');
		}
		 $("#masterType").chosen({allow_single_deselect:true});	
		 
			var actionUrl=path +"/api/superadmin/mitem!queryOtherList.action?date=" + new Date().getTime();
			var params = [
					{name:"masterType",targetid:"masterType",type:"select"}
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
	
	var actionUrl=path +"/api/superadmin/mitem!queryOtherList.action?date="
								+ new Date().getTime();
	var params = [ {
		name : "masterType",
		targetid : "masterType",
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
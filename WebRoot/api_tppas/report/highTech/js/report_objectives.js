// 网站根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();

		$("input[type='text']").each(function(){
			$(this).attr("disabled",true);
		});
	});
});

// 下一步--详细
$("#nextBtn").bind("click", function() {
	// 设置左侧菜单状态
	upms.upmsUtils.setMenu();
	var actionUrl = path + "/api/report/tcostEstimateBAction!list.action?now="+new Date().getTime();
	
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name : "projectId",targetid : "projectId",type : "text"},
	                 {name : "applyStatus",targetid : "applyStatus",type : "text"}
	];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});
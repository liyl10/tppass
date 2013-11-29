// 网站根目录
var path="";

$(function() {
	$(document).ready(function() {
	path=$("#path").text();
		$("textarea").each(function(){
			$("textarea").each(function(){
				$(this).attr("readonly",true);
				$(this).css('background-color','#F0F0F0');
			});
		});
	});
});

/**
 * 下一步按钮功能
 */
$("#nextBtn1").bind("click", function(){
	
	// 设置左侧菜单
	upms.upmsUtils.setMenu();
	
	var actionUrl= path + "/api/report/texpectedResults!showTexpectedResults.action?now="+new Date().getTime();
	//alert(actionUrl);
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"projectId",targetid:"projectId",type:"text"},
	                 {name:"applyStatus",targetid:"applyStatus",type:"text"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});
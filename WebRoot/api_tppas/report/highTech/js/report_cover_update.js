// 网站根目录
var path="";
$(function() {
    $(document).ready(function() {
    	path=$("#path").text();
		// 画面禁止输入
    	$("input[type='text']").each(function(){
			$(this).attr("disabled",true);
		});
    	$("input[type='radio']").each(function(){
			$(this).attr("disabled",true);
		});
    	upms.upmsUtils.initSelect("centralizedType",$("#centralizedTypeValue").val(), 1 , 1 , 0);
	});
 });

$("#nextBtn").bind("click", function() {
	// 设置左边菜单样式
	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/report/tprojectApplicationAction!showReportKnow.action?now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"projectId",targetid:"projectId",type:"text"},
	                 {name:"applyStatus",targetid:"applyStatus",type:"text"}];

	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});	
});
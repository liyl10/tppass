
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});

$(function() {
    $(document).ready(function () {
		$(".subNav >a:first").css('background',"#e2f3fb url(" + path + "/server_tppas/images/bg_sub_list.gif) no-repeat 10px center");
		$(".subNav >a:first").css('color',"#10465f");
		
		var value = $(window).height() - 175;

		$(".leftNav").css("height", value);
		$(".rightWrap").css("height", value);
		$("#content").css("height", value);

			$(".subNav >a").each(function(ind, elem) {
			var aqObj = $(elem);
			aqObj.parent("dd").bind("click", function() {
				$(".subNav >a").css('background',"#87baf0 url(" + path + "/server_tppas/images/bg_sub_list.gif) no-repeat 10px center");
				$(this).find("a").css('background',"#e2f3fb url(" + path + "/server_tppas/images/bg_sub_list.gif) no-repeat 10px center");
				
				$(".subNav >a").css('color',"#fff");
				$(this).find("a").css('color',"#10465f");
				
			});
		}); 
	});

	$("#content").load(path + "/api/acceptance/acceptance!highTechCover.action?acceptanceId=" + $("#acceptanceId").val()
			+ "&acceptanceStatus=" + $("#acceptanceStatus").val() + "&now=" + new Date().getTime());
});

function showDetail(acceptanceId ,acceptanceStatus, url){
	var actionUrl= path + url + "acceptanceId="+acceptanceId+"&acceptanceStatus="+acceptanceStatus+"&now=" + new Date().getTime();
	rect(actionUrl);
}

/* 项目验收申请表封皮
function showDetail1(){
	var actionUrl= path + "/api/acceptance/acceptance!highTechCover.action?acceptanceId=" + $("#acceptanceId").val()
			+ "&acceptanceStatus=" + $("#acceptanceStatus").val() + "&now=" + new Date().getTime();
	rect(actionUrl);
}  */

/* 项目经费落实和使用情况
function showDetail2(){
	var actionUrl= path + "/api/acceptance/implementationA!infoInit.action?acceptanceId=" + $("#acceptanceId").val()
			+ "&acceptanceStatus=" + $("#acceptanceStatus").val() + "&now=" + new Date().getTime();
	rect(actionUrl);
}  */

/* 对照合同项目任务完成情况
function showDetail3(){
	var actionUrl= path + "/api/acceptance/completeA!completeInit.action?acceptanceId=" + $("#acceptanceId").val()
	+ "&acceptanceStatus=" + $("#acceptanceStatus").val() + "&now=" + new Date().getTime();
	rect(actionUrl);
} */

/* 企业获得资金支持情况
function showDetail4(){
	var actionUrl= path + "/api/acceptance/fundsA!fundsInit.action?acceptanceId=" + $("#acceptanceId").val()
	+ "&acceptanceStatus=" + $("#acceptanceStatus").val() + "&now=" + new Date().getTime();
	rect(actionUrl);
} */

/* 企业发展情况
function showDetail5(){
	var actionUrl = path + "/api/acceptance/developingA!developingInit.action?acceptanceId=" + $("#acceptanceId").val()
	+ "&acceptanceStatus=" + $("#acceptanceStatus").val() + "&now=" + new Date().getTime();
	rect(actionUrl);
} */

/* 验收意见
function showDetail6(){
	var actionUrl = path + "/api/acceptance/opinionA!accOpinionInit.action?acceptanceId=" + $("#acceptanceId").val()
	+ "&acceptanceStatus=" + $("#acceptanceStatus").val() + "&now=" + new Date().getTime();
	rect(actionUrl);
} */

/* 单位意见
function showDetail7(){
	var actionUrl = path + "/api/acceptance/opinionA!deptOpinionInit.action?acceptanceId=" + $("#acceptanceId").val()
	+ "&acceptanceStatus=" + $("#acceptanceStatus").val() + "&now=" + new Date().getTime();
	rect(actionUrl);
} */

/* 项目主要参加人员名单
function showDetail8(){
	var actionUrl = path + "/api/acceptance/mainA!mainInit.action?acceptanceId=" + $("#acceptanceId").val()
	+ "&acceptanceStatus=" + $("#acceptanceStatus").val() + "&now=" + new Date().getTime();
	rect(actionUrl);
} */

/* 验收小组名单
function showDetail9(){
	var actionUrl = path + "/api/acceptance/accA!accInit.action?acceptanceId=" + $("#acceptanceId").val()
	+ "&acceptanceStatus=" + $("#acceptanceStatus").val() + "&now=" + new Date().getTime();
	rect(actionUrl);
} */

/* 项目验收经费登记表
function showDetail10(){
	var actionUrl = path + "/api/acceptance/accFundsA!accFundsInit.action?acceptanceId=" + $("#acceptanceId").val()
	+ "&acceptanceStatus=" + $("#acceptanceStatus").val() + "&now=" + new Date().getTime();
	rect(actionUrl);
} */

/* 附件清单
function showDetail11(){
	var actionUrl = path + "/api/acceptance/acceptance!highTechIndex.action?acceptanceId=" + $("#acceptanceId").val()
	+ "&acceptanceStatus=" + $("#acceptanceStatus").val() + "&now=" + new Date().getTime();
	rect(actionUrl);
} */

/* 项目验收提交
function showDetail12(){
	var actionUrl = path + "/api/acceptance/acceptance!highTechSubmit.action?acceptanceId=" + $("#acceptanceId").val()
	+ "&acceptanceStatus=" + $("#acceptanceStatus").val() + "&now=" + new Date().getTime();
	rect(actionUrl);
} */

function rect(actionUrl) {
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}
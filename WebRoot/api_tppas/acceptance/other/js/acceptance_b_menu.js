// 工程根目录
var path="";

$(function() {
    $(document).ready(function () {
		path=$("#path").text();
		$(".subNav >a:first").css('background',"#e2f3fb url("+path+"/server_tppas/images/bg_sub_list.gif) no-repeat 10px center");
		$(".subNav >a:first").addClass("background");
		$(".subNav >a:first").css('color',"#10465f");
		
		
		var value = $(window).height() - 175;

		$(".leftNav").css("height", value);
		$(".rightWrap").css("height", value);
		$("#content").css("height", value);

			$(".subNav >a").each(function(ind, elem) {
			var aqObj = $(elem);
			aqObj.parent("dd").bind("click", function() {
				$(".subNav >a").css('background',"#87baf0 url("+path+"/server_tppas/images/bg_sub_list.gif) no-repeat 10px center");
				$(this).find("a").css('background',"#e2f3fb url("+path+"/server_tppas/images/bg_sub_list.gif) no-repeat 10px center");
				$(this).find("a").addClass("background");
				
				$(".subNav >a").css('color',"#fff");
				$(this).find("a").css('color',"#10465f");
				
			});
		}); 
		
		$("#content").load(path + "/api/acceptance/acceptance!showAcceptanceinfoB.action?acceptanceId="
	    		+ $("#acceptanceId").val()+"&acceptanceStatus="+$("#acceptanceStatus").val()+"&now=" + new Date().getTime());
	});
});

function showDetail(acceptanceId ,acceptanceStatus, url){
	var actionUrl= path + url + "acceptanceId="+acceptanceId+"&acceptanceStatus="+acceptanceStatus+"&now=" + new Date().getTime();
	rect(actionUrl);
}

/*1项目验收基本信息  
function showDetail(acceptanceId, acceptanceStatus, url){
	var actionUrl= path + "/server/acceptance/acceptance!showAcceptanceinfoB.action?acceptanceId=" + acceptanceId+"&acceptanceStatus="+acceptanceStatus + "&now="+ new Date().getTime();
	rect(actionUrl);
}
/*  2项目经费落实和使用情况   
function showDetai2(acceptanceId, acceptanceStatus){
	var actionUrl= path + "/server/acceptance/TacceptanceImplementationBAction!showTacceptanceImplement.action?acceptanceId=" + acceptanceId+"&acceptanceStatus="+acceptanceStatus + "&now="+ new Date().getTime();
	rect(actionUrl);
}
 3项目取得成果情况   
function showDetai3(acceptanceId, acceptanceStatus){
	var actionUrl= path + "/server/acceptance/TacceptanceAchievementBAction!showAchievementB.action?acceptanceId=" + acceptanceId+"&acceptanceStatus="+acceptanceStatus + "&now="+ new Date().getTime();
	rect(actionUrl);
}
 4项目总结说明   
function showDetai4(acceptanceId, acceptanceStatus){
	var actionUrl= path + "/server/acceptance/TacceptanceSummaryBAction!showAcceptanceSummaryB.action?acceptanceId=" + acceptanceId+"&acceptanceStatus="+acceptanceStatus + "&now="+ new Date().getTime();
	rect(actionUrl);
}
 5附件清单   
function showDetai5(acceptanceId, acceptanceStatus){
	var actionUrl= path + "/server/acceptance/acceptance!showIndexList.action?acceptanceId=" + acceptanceId+"&acceptanceStatus="+acceptanceStatus + "&now="+ new Date().getTime();
	rect(actionUrl);
}
 6验收提交   
function showDetai6(acceptanceId, acceptanceStatus){
	var actionUrl= path + "/server/acceptance/acceptance!showOtherAcceptance.action?acceptanceId=" + acceptanceId+"&acceptanceStatus="+acceptanceStatus + "&now="+ new Date().getTime();
	rect(actionUrl);
}*/


function rect(actionUrl) {
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
} 
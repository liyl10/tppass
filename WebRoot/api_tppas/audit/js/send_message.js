// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
});

/**
 * 发送短信
 */
function sendMessage(){
	
	alert("待定");
}

/**
 * 发送Email
 */
function sendEmail(){
	alert("待定");
}

/**
 * 返回
 */
function back(){
	
	var actionUrl=path + "/api/audit/projectApplication!showAuditPropress.action?projectId="
			+ $("#projectId").val()
			+ "&date=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();
	});
}
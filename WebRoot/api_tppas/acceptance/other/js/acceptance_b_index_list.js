
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();
	});
});


// 下载附件
function downfile(attachmentId){
	var actionUrl= path + "/api/superadmin/tattachment!downLoadFile.action?now="+new Date().getTime()
			+ "&attachmentId=" + attachmentId;
	window.location.href=actionUrl;
}

//下一步按钮功能
$("#nextBtn").bind("click", function() {
	// 设置左边菜单样式
	upms.upmsUtils.setMenu();
	var actionUrl = path + "/api/acceptance/acceptance!showOtherAcceptance.action?acceptanceId="+$("#acceptanceId").val()+"&acceptanceStatus="+$("#acceptanceStatus").val()+"&now="+new Date().getTime();
	
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [];
	
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

// 分页信息
upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"frmA",
	resultdivid:"resultDiv",
	url:path + "/api/acceptance/acceptance!showIndexList.action?acceptanceId="
			+ $("#acceptanceId").val()
			+"&acceptanceStatus="+$("#acceptanceStatus").val()
			+ "&tableName=" + $("#tableName").val()
			+"&now="+new Date().getTime()
});
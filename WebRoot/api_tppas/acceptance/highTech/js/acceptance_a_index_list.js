
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});


// 下载附件
function downFile(attachmentId){
	var actionUrl= path + "/api/superadmin/tattachment!downLoadFile.action?now="+new Date().getTime()
			+ "&attachmentId=" + attachmentId;
	window.location.href=actionUrl;
}

//下一步按钮
$("#nextBtn").bind("click", function() {
		// 设置左边菜单样式
		upms.upmsUtils.setMenu();
		var actionUrl= path + "/api/acceptance/acceptance!highTechSubmit.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"acceptanceId",targetid:"acceptanceId",type:"text"},
		                 {name:"acceptanceStatus",targetid:"acceptanceStatus",type:"text"}];

		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
});

upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"searchForm",
	resultdivid:"resultDiv",
	url:path +"/api/acceptance/acceptance!highTechIndex.action?acceptanceId="
			+ $("#acceptanceId").val()
			+ "&acceptanceStatus=" + $("#acceptanceStatus").val()
			+ "&now="+new Date().getTime()
});
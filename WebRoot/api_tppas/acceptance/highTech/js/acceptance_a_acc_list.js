
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});

// 修改按钮
function modifyAcc(accId) {
		var actionUrl= path + "/api/acceptance/accA!accUpdateInit.action?accId=" + accId + "&now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"acceptanceId",targetid:"acceptanceId",type:"text"},
		                 {name:"acceptanceStatus",targetid:"acceptanceStatus",type:"text"}];

		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
}

// 下一步按钮
$("#nextBtn").bind("click", function() {
		// 设置左边菜单样式
		upms.upmsUtils.setMenu();
		var actionUrl= path + "/api/acceptance/accFundsA!accFundsInit.action?now="+ new Date().getTime();
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
	url:path +"/api/acceptance/accA!accInit.action?acceptanceId="
			+ $("#acceptanceId").val()
			+ "&acceptanceStatus=" + $("#acceptanceStatus").val()
			+ "&now="+new Date().getTime()
});
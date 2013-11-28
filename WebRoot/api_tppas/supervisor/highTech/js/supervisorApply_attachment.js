// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
	});
});

function insertIndex() {

	var actionUrl = path + "/api/supervisor/tsupervisorApply!showAttachmentInsert.action?now="
			+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

function downfile(attachmentId) {
	var actionUrl = path + "/api/superadmin/tattachment!downLoadFile.action?now="
			+ new Date().getTime() + "&attachmentId=" + attachmentId;
	window.location.href = actionUrl;
}

function deleteFile(attachmentId) {
	if (!confirm($("#comfirmDelete").html())) {
		return;
	}
	var actionUrl = path + "/api/superadmin/tattachment!deleDataAndFile.action?now="
			+ new Date().getTime() + "&attachmentId=" + attachmentId;
	$("#retUrl")
			.attr(
					"value",
					path + "/api/supervisor/tsupervisorApply!showApplyAttachment.action?now="
							+ new Date().getTime());
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [ {
		name : "retUrl",
		targetid : "retUrl",
		type : "text"
	} ];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

//更新附件
function updateFile(attachmentId){
	var actionUrl= path + "/api/supervisor/tsupervisorApply!showIndexUpdate.action?now="+ new Date().getTime() + "&attachmentId=" + attachmentId;
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

upms.grid.gridHover($(".t-list"));
upms.pagequery
		.initpaging({// 分页
			pgbtnid : "pgbtn",
			queryformid : "frmA",
			resultdivid : "resultDiv",
			url : path + "/api/supervisor/tsupervisorApply!showApplyAttachment.action?now="
					+ new Date().getTime()
		});

$("#nextBtn").bind("click", function() {
	
	upms.upmsUtils.setMenu();
	var actionUrl="";
	
	actionUrl= path + "/api/supervisor/tsupervisorApply!showApplySubmit.action?now=" + new Date().getTime();
	//var actionUrl="";
	//actionUrl= "${pageContext.request.contextPath}/api/supervisor/tsupervisorApply!insertFundInfo.action?nextBtnFlag=" + "true" +"&now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");

	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();
		});
});
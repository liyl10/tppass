
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();
		//var lastNext = $("#lastNext").val();
		if($("#lastNext").length<1){
			$("#nextBtn").hide();
		}
	});
	
});

//下载附件
function downfile(attachmentId){
	var actionUrl= path + "/api/superadmin/tattachment!downLoadFile.action?now="+new Date().getTime()
			+ "&attachmentId=" + attachmentId;
	window.location.href=actionUrl;
}

// 下一步按钮功能
$("#nextBtn").bind("click", function() {
	// 设置左边菜单样式
	upms.upmsUtils.setMenu();
	var actionUrl="";
	/*if($("#highOrOtherFlag").val() == 1){
		actionUrl= path + "/api/report/tprojectApplicationAction!getSubmitHighInfoList.action?now="+ new Date().getTime();
	}
	else{
		actionUrl= path + "/api/report/tprojectApplicationAction!getSubmitInfoList.action?now="+ new Date().getTime();
	}
*/
	var lastNext = $("#lastNext").val();
	if(lastNext!=null&&lastNext!=""){
		if(lastNext=="zjsh"){
			var projectId = $("#projectId").val();
			var applyStatus = $("#applyStatus").val();
			var scoreId = $("#scoreId").val();
			actionUrl = path + "/api/expert/texpertScoreAction!initExpertAudit.action?projectId="+projectId+"&applyStatus="+applyStatus+"&scoreId="+scoreId+"&now=" + new Date().getTime();
		}
		
		// 项目初审
		if(lastNext=="xmcs"){
			var projectId = $("#projectId").val();
			actionUrl= path + "/api/report/beforeReviewAction!initSubmit.action?projectId="+projectId+"&now=" + new Date().getTime();
		}

		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [];
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
});

// 分页信息
upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"frmA",
	resultdivid:"resultDiv",
	url:path + "/api/report/tprojectApplicationAction!showIndexList.action?projectId="
			+ $("#projectId").val()
			+"&applyStatus="+$("#applyStatus").val()
			+ "&tableName=" + $("#tableName").val()
			+"&now="+new Date().getTime()
});
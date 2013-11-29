
// 工程根目录
var path="";

$(function() {

	$(document).ready(function() {
		path = $("#path").text();
		if ($("#addbtnFlaf").val() == 1) {
			$("#addExpertBtn").hide();
			$("#copyExpertBtn").hide();
		}
	});
	
});

upms.grid.gridHover($(".t-list"));
	upms.pagequery.initpaging({// 分页
		pgbtnid:"pgbtn",
		queryformid:"searchForm",
		resultdivid:"resultDiv",
		url:path +"/api/superadmin/texpertreviewcommentsaction!list.action?typeId="+$("#typeId").val()
	});
function doDel(expertReviewCommentsId,typeId){
	var val = confirm($("#comfirmDelete").text());
	 if (!val) {
	    return; 
	 }
	var actionUrl=path +"/api/superadmin/texpertreviewcommentsaction!delete.action?expertReviewCommentsId="+expertReviewCommentsId+"&typeId="+$("#typeId").val()+"&planFlagId="+$("#planFlagId").val()+"&date=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});

}
function doUpdate(expertReviewCommentsId,typeId){
	var actionUrl=path +"/api/superadmin/texpertreviewcommentsaction!modify.action?expertReviewCommentsId="+expertReviewCommentsId+"&typeId="+$("#typeId").val()+"&planFlagId="+$("#planFlagId").val()+"&date=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});

}
// 新增
$("#addExpertBtn").bind("click", function() {
	var actionUrl=path +"/api/superadmin/texpertreviewcommentsaction!insert.action?date=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [ {name : "typeId",targetid : "typeId",type : "text"},
	                  {name : "planFlagId",targetid : "planFlagId",type : "text"}
	];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});	
// 复制
$("#copyExpertBtn").bind("click", function() {
	//$("#copyExperHidden").attr("value","0");
	var actionUrl=path +"/api/superadmin/texpertreviewcommentsaction!copyExpertreview.action?date=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [ {name : "typeId",targetid : "typeId",type : "text"},
	                  {name : "planFlagId",targetid : "planFlagId",type : "text"}
	];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});
/**
 * 返回
 */
function back(){
	var actionUrl= path + "/api/audit/projectApplicationJoint!showJointAuditManage.action?now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [];
	//arrParams = upms.upmsUtils.setSubmitDatas(arrParams, 1, 0);
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}


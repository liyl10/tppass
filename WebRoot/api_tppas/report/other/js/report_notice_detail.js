// 网站根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();
		if($("#lastNext").length<1){
			$("#nextBtn").hide();
		}
	});
});

/**
 * 下一步按钮功能
 */
$("#nextBtn").bind("click", function(){
	// 设置左边菜单样式
	upms.upmsUtils.setMenu();
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

	
	/*// 设置左侧菜单
	upms.upmsUtils.setMenu();
	
	var actionUrl= path + "/api/report/tprojectApplicationAction!getSubmitInfoList.action?now="+new Date().getTime();
	//alert(actionUrl);
	//upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"projectId",targetid:"projectId",type:"text"},
	                 {name:"applyStatus",targetid:"applyStatus",type:"text"}];
	arrParams = upms.upmsUtils.setSubmitDatas(arrParams, 1, 0);
	var data = upms.transParsToObj(arrParams, $newPgDiv);*/
	/*$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});*/
});
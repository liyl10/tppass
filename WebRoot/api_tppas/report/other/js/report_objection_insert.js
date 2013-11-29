// 网站根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();

		$("input[type='text']").each(function(){
			$(this).attr("disabled",true);
		});
		$("textarea").each(function(){
			$(this).attr("readonly",true);
			$(this).css('background-color','#F0F0F0');
		}); 
		$("#uploadfile").each(function(){
			$(this).attr("disabled",true);
		});
		
		var isHighTech = $("#highTechFlg").val();
		// 当该项目为产业处的时候，审查意见为最后一个画面，需要根据情况决定是否需要下一步按钮
		// 在项目初审或者专家评审的时候再审查意见后面还有一个画面，故需要下一步按钮
		if(isHighTech == "1" && $("#lastNext").length<1){
			$("#nextBtn").hide();
		}
	});
});

$("#nextBtn").bind("click", function() {
	var isHighTech = $("#highTechFlg").val();
	var actionUrl;
	// 非产业处下一步，跳转到附件说明
	if(isHighTech != "1"){
		// 设置左侧菜单
		upms.upmsUtils.setMenu();

		actionUrl= path + "/api/report/tprojectApplicationAction!showReportNotice.action?now=" + new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [ {name : "projectId",targetid : "projectId",type : "text"}, 
		                  {name : "applyStatus",targetid : "applyStatus",type : "text"}
						];
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
		
	} else{
		// 设置左边菜单样式
		upms.upmsUtils.setMenu();
		// 产业处的时候，正常是没有下一步的，在初审或者专家评审的时候需要下一步
		// 并分别跳转到相应的画面
		var lastNext = $("#lastNext").val();
		if(lastNext!=null&&lastNext!=""){
			actionUrl = "";
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
/*			var data = upms.transParsToObj(arrParams, $newPgDiv);
			$newPgDiv.load(actionUrl, data, function() {
				upms.hideOverLay();
			});*/
		}
	}
});

//下载
function downfile(attachmentId){
	var actionUrl= path + "/api/superadmin/tattachment!downLoadFile.action?now="+new Date().getTime()
			+ "&attachmentId=" + attachmentId;
	window.location.href=actionUrl;
}

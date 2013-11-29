	// 项目根目录
	var path="";
	
	$(function() {
		$(document).ready(function() {
			path = $("#path").text();
		});
	});
	
	//分页
	upms.grid.gridHover($(".t-list"));
	upms.pagequery.initpaging({// 分页
		pgbtnid:"pgbtn",
		queryformid:"searchForm",
		resultdivid:"resultDiv",
		url:path + "/api/expert/texpertScoreAction!getAuditList.action?now=" + new Date().getTime()
	});
	
	//评审项目
	function auditProject(scoreId,projectId,actionUrl){
	    var arrParams={};
		var actionUrl= path + actionUrl + "?applyStatus=0&scoreId="+scoreId+"&projectId="+projectId+"&now="+new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
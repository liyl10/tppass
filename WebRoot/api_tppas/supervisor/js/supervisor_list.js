	//项目根目录
	var path="";
	
	$(function(){
		$(document).ready(function() {
			path = $("#path").text();
		});
	});
	//分页
	upms.grid.gridHover($(".t-list"));
	upms.pagequery.initpaging({
				pgbtnid : "pgbtn",
				queryformid : "formId",
				resultdivid : "resultDiv",
				url : path + "/api/supervisor/tsupervisorAction!supervisorList.action?now="+ new Date().getTime()
			});
	
	// 监理报告
	function supervisorReportList(supervisorId,projectId) {
		var actionUrl = path + "/api/supervisor/supervisorReportAction!getReportList.action?supervisorId="+supervisorId+"&projectId="+projectId+"&now="+ new Date().getTime();
		upms.showOverLay();
		upms.clearWebObj();
		var $newPgDiv = upms.createPageDiv();
		$newPgDiv.load(actionUrl, null, function() {
			upms.hideOverLay();
		});
	}

	//监理申请
	function supervisorApply(supervisorId,projectId,isEdit,url) {
		var actionUrl = path + url + "?supervisorId="+supervisorId +"&projectId="+projectId+"&isEdit="+isEdit+"&now="+ new Date().getTime();
		// 打开遮罩
		upms.showOverLay();
		upms.clearWebObj();
		var $newPgDiv = upms.createPageDiv();
		$newPgDiv.load(actionUrl, null, function() {
			upms.hideOverLay();
		});
	}
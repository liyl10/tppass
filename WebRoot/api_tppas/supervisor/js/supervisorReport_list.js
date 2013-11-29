	// 项目根目录
	var path="";
	
	$(function() {
		$(document).ready(function() {
			path = $("#path").text();
		});
	});
	
	//分页
	upms.grid.gridHover($(".t-list"));
	upms.pagequery
			.initpaging({// 分页
				pgbtnid : "pgbtn",
				queryformid : "formId",
				resultdivid : "resultDiv",
				url : path + "/api/supervisor/supervisorReportAction!getReportList.action?supervisorId="+ $("#supervisorId").val()+"&now="+new Date().getTime()
			});
	
	//监理点添加
	function showPointInsert(supervisorId,projectId) {
		var actionUrl = path + "/api/supervisor/supervisorPointAction!forwardInsert.action?supervisorId="+supervisorId+"&projectId="+projectId+"&now="+ new Date().getTime();
		rect(actionUrl);
	}
	
	//监理点编辑
	function showPointModify(pointId, supervisorId, projectId) {
		var actionUrl = path + "/api/supervisor/supervisorPointAction!forwardUpdate.action?&pointId="+pointId
				+ "&supervisorId="+supervisorId+"&projectId="+projectId+"&now="+ new Date().getTime();
		rect(actionUrl);
	}
	
	// 监理点删除
	function showPointDelete(pointId, supervisorId,projectId) {
		if (confirm($("#comfirmDelete").text())) {
			var actionUrl = path + "/api/supervisor/supervisorPointAction!deletePoint.action?&pointId="+pointId+"&supervisorId="+supervisorId+"&projectId="+projectId+"&now=" + new Date().getTime();
			rect(actionUrl);
		}
	}
	
	//监理报告详细
	function showReportDetail(reportId, supervisorId, projectId) {
		var actionUrl = path + "/api/supervisor/supervisorReportAction!showReportDetail.action?&reportId="+reportId
				+ "&supervisorId="+supervisorId+"&projectId="+projectId+"&now="+ new Date().getTime();
		rect(actionUrl);
	}
	
	//监理报告审查
	function showReportAudit(reportId, supervisorId, projectId) {
		var actionUrl = path + "/api/supervisor/supervisorReportAction!showReportAudit.action?&reportId="+reportId
				+ "&supervisorId="+supervisorId+"&projectId="+projectId+"&now="+ new Date().getTime();
		rect(actionUrl);
	}
	
	// 跳转共通处理
	function rect(actionUrl) {
		upms.showOverLay();// 打开遮罩
		//upms.clearWebObj();
		var $newPgDiv = $("#mainContent");
		$newPgDiv.load(actionUrl, null, function() {
			upms.hideOverLay();
		});
	}

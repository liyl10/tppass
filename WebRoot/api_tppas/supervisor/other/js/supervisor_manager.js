	//项目根目录
	var path="";
	
	$(function(){
		$(document).ready(function() {
			upms.upmsUtils.initLeftMenu("/api/supervisor/supervisorOtherAction!getCoverInfo.action?supervisorId="+$("#sId").val()+"&projectId="+$("#pId").val()+"&isEdit="+$("#eId").val());
		});
	});
	
	function showDetail(projectId,supervisorId,isEdit,url){
		var actionUrl= path + url + "?supervisorId=" + supervisorId+"&projectId="+projectId+"&isEdit="+isEdit+"&now="+ new Date().getTime();
		rect(actionUrl);
	}

	function rect(actionUrl) {
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var data = {};
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}

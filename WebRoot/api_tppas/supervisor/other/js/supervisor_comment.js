	//项目根目录
	var path="";
	
	$(function(){
		$(document).ready(function() {
			path = $("#path").text();
		});
	});
	
	// 下一步按钮功能
	$("#nextBut").bind("click", function(){
		//选中左边菜单
		upms.upmsUtils.setMenu();
		var actionUrl= path + "/api/supervisor/supervisorOtherAction!nextComment.action?supervisorId="+$("#supervisorId").val()+"&projectId="+$("#projectId").val()+"&isEdit="+$("#isEdit").val()+"&now=" + new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [];
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	});

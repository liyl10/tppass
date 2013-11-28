	// 网站根目录
	var path="";
	
	$(function() {
		$(document).ready(function() {
			path=$("#path").text();
		});
	});
	
	//监理审核
	function supervisorAudit(supervisorState,comfirmText){
		// 输入项验证
		if(upms.upmsUtils.inputCheck()){
			return;
		}
		
		if (!confirm(comfirmText)) {
			return;
		}
		
		var actionUrl = path + "/api/supervisor/supervisorOtherAction!submitOtherSupervisor.action?supervisorState="+supervisorState+"&now="+new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name : "supervisorId",targetid : "supervisorId",type : "text"},
              						{name : "tsupervisorInfo",targetid : "tsupervisorInfo",type : "textarea"}];
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}

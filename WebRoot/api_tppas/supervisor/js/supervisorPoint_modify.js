	// 项目根目录
	var path="";
	
	$(function() {
		$(document).ready(function() {
			path = $("#path").text();
		});
	});
	
	//返回按钮事件
	$("#backBtn").bind("click", function() {
		
		var actionUrl= path + "/api/supervisor/supervisorReportAction!getReportList.action?&now=" + new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		var arrParams = [{name:"supervisorId",targetid:"supervisorId",type:"text"},
		                 {name:"projectId",targetid:"projectId",type:"text"}];
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	});
	
	//保存按钮事件
	$("#saveBtn").bind("click", function() {
		// 输入项验证
		if(upms.upmsUtils.inputCheck()){
			return;
		}
		
		if (confirm($("#comfirmUpdate").text())) {
			//获取隐藏项
			var hiddenList = $("input[type='hidden']");
			
			var actionUrl= path + "/api/supervisor/supervisorPointAction!updatePoint.action?now=" + new Date().getTime();
			upms.showOverLay();// 打开遮罩
			var $newPgDiv = $("#mainContent");
			var arrParams = [{name:"supervisorPoint.pointContent",targetid:"pointContent",type:"textarea"},
			                 			{name:"supervisorPoint.pointTime",targetid:"pointTime",type:"text"}];
			// 添加隐藏项
			for(var i=0; i< hiddenList.length; i++){
				if(hiddenList.eq(i).attr("name") !="hidden"){
					var params = {name:hiddenList.eq(i).attr("name"),targetid:hiddenList.eq(i).attr("id"),type:"text"};
					arrParams[arrParams.length] = params;
				}
			}
			
			var data = upms.transParsToObj(arrParams, $newPgDiv);
			$newPgDiv.load(actionUrl, data, function() {
				upms.hideOverLay();
			});
		}
	});
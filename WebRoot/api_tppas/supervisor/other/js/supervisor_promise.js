	//项目根目录
	var path="";
	
	$(function(){
		$(document).ready(function() {
			path = $("#path").text();
			if($("#isEdit").val() == "0"){
				$("input[type='text']").each(function(){
					$(this).attr("disabled",true);
				});
			 }
		});
	});
	
	// 下一步按钮功能
	$("#nextBut").bind("click", function(){
		//选择左边菜单
		upms.upmsUtils.setMenu();
		
		var actionUrl= path + "/api/supervisor/supervisorOtherAction!showIndexList.action?now=" + new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"supervisorId",targetid:"supervisorId",type:"text"}];
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	});

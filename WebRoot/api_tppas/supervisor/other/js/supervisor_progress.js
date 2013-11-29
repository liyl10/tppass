	//项目根目录
	var path="";
	
	$(function(){
		$(document).ready(function() {
			path = $("#path").text();
			if($("#isEdit").val() == "0"){
				$("input[type='text']").each(function(){
					$(this).attr("disabled",true);
				});
				$("textarea").each(function(){
					$(this).attr("readonly",true);
					$(this).css('background-color','#F0F0F0');
				});
			 }
		});
	});
	
	// 保存按钮功能
	$("#saveBut").bind("click", function(){
		// 输入项验证
		if(upms.upmsUtils.inputCheck()){
			return;
		}
		
		var comfirmInfo = $("#comfirmSave").text();
		//判断是保存还是修改
		if($("#projectIndustrializationId").val()!=null&&$("#projectIndustrializationId").val()!=''){
			comfirmInfo = $("#comfirmUpdate").text();
		}
		
		if (confirm(comfirmInfo)){
			//获取隐藏项
			var hiddenList = $("input[type='hidden']");
			
			var actionUrl= path + "/api/supervisor/projectIndustrializationAction!saveOrNextProjectIndustrialization.action?optType=0&now=" + new Date().getTime();
			upms.showOverLay();// 打开遮罩
			var $newPgDiv = $("#content");
			var arrParams = [{name:"tprojectIndustrialization.industrializationComment",targetid:"industrializationComment",type:"text"}];
			
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
	
	// 下一步按钮功能
	$("#nextBut").bind("click", function(){
		// 输入项验证
		if(upms.upmsUtils.inputCheck()){
			return;
		}
		
		var comfirmInfo = $("#comfirmNext").text();
		//判断是保存还是修改
		/*if($("#projectIndustrializationId").val()!=null&&$("#projectIndustrializationId").val()!=''){
			comfirmInfo = $("#comfirmUpdate").text();
		}*/
		
		if (confirm(comfirmInfo)){
			//选择左边菜单
			upms.upmsUtils.setMenu();
			//获取隐藏项
			var hiddenList = $("input[type='hidden']");
			
			var actionUrl= path + "/api/supervisor/projectIndustrializationAction!saveOrNextProjectIndustrialization.action?optType=1&now=" + new Date().getTime();
			upms.showOverLay();// 打开遮罩
			var $newPgDiv = $("#content");
			var arrParams = [{name:"tprojectIndustrialization.industrializationComment",targetid:"industrializationComment",type:"text"}];
			
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
	
	//不能修改时下一步按钮功能
	$("#nextStep").bind("click", function(){
		//选中左边菜单
		upms.upmsUtils.setMenu();
		var actionUrl= path + "/api/supervisor/projectManagementInfoAction!getProjectManagementInfo.action?supervisorId="+$("#supervisorId").val()+"&isEdit="+$("#isEdit").val()+"&now=" + new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [];
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	});

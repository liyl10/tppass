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
				$("input[type='radio']").each(function(){
					$(this).attr("disabled",true);
				});
				$("input[type='checkbox']").each(function(){
					$(this).attr("disabled",true);
				});
			 }
		});
	});
	
	// 保存按钮功能
	$("#saveBut").bind("click", function(){
		// 输入项验证
		var radioArry = ["tprojectCompleteInfo.projectSchedule"];　
		if(upms.upmsUtils.radioCheck(radioArry)){
			return;
		}
		if(checkProgress("selectedProjectStopReason")){
			return;
		}
		if(upms.upmsUtils.inputCheck()){
			return;
		}
		
		var comfirmInfo = $("#comfirmSave").text();
		//判断是保存还是修改
		if($("#projectCompleteInfoId").val()!=null&&$("#projectCompleteInfoId").val()!=''){
			comfirmInfo = $("#comfirmUpdate").text();
		}
		
		if (confirm(comfirmInfo)){
			//获取隐藏项
			var hiddenList = $("input[type='hidden']");
			//获取文本框项
			var inputList = $("input[type='text']");
			
			var actionUrl= path + "/api/supervisor/projectCompleteInfoAction!saveOrNextProjectCompleteInfo.action?optType=0&now=" + new Date().getTime();
			upms.showOverLay();// 打开遮罩
			var $newPgDiv = $("#content");
			var arrParams = [{name:"tprojectCompleteInfo.commentInfo",targetid:"commentInfo",type:"text"},
			                 {name:"tprojectCompleteInfo.projectSchedule",targetname:"tprojectCompleteInfo.projectSchedule",type:"radio"},
			                 {name:"selectedProjectStopReason",targetname:"selectedProjectStopReason",type:"checkbox"}];
			
			// 添加隐藏项
			for(var i=0; i< hiddenList.length; i++){
				if(hiddenList.eq(i).attr("name") !="hidden"){
					var params = {name:hiddenList.eq(i).attr("name"),targetid:hiddenList.eq(i).attr("id"),type:"text"};
					arrParams[arrParams.length] = params;
				}
			}
			//添加文本框项
			for(var i=0; i< inputList.length; i++){
				var params = {name:inputList.eq(i).attr("name"),targetid:inputList.eq(i).attr("id"),type:"text"};
				arrParams[arrParams.length] = params;
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
		var radioArry = ["tprojectCompleteInfo.projectSchedule"];　
		if(upms.upmsUtils.radioCheck(radioArry)){
			return;
		}
		if(checkProgress("selectedProjectStopReason")){
			return;
		}
		if(upms.upmsUtils.inputCheck()){
			return;
		}
		
		var comfirmInfo = $("#comfirmNext").text();
		//判断是保存还是修改
		/*if($("#projectCompleteInfoId").val()!=null&&$("#projectCompleteInfoId").val()!=''){
			comfirmInfo = $("#comfirmUpdate").text();
		}*/
		
		if (confirm(comfirmInfo)){
			//选择左边菜单
			upms.upmsUtils.setMenu();
			//获取隐藏项
			var hiddenList = $("input[type='hidden']");
			//获取文本框项
			var inputList = $("input[type='text']");
			
			var actionUrl= path + "/api/supervisor/projectCompleteInfoAction!saveOrNextProjectCompleteInfo.action?optType=1&now=" + new Date().getTime();
			upms.showOverLay();// 打开遮罩
			var $newPgDiv = $("#content");
			var arrParams = [{name:"tprojectCompleteInfo.commentInfo",targetid:"commentInfo",type:"text"},
			                 {name:"tprojectCompleteInfo.projectSchedule",targetname:"tprojectCompleteInfo.projectSchedule",type:"radio"},
			                 {name:"selectedProjectStopReason",targetname:"selectedProjectStopReason",type:"checkbox"}];
			
			// 添加隐藏项
			for(var i=0; i< hiddenList.length; i++){
				if(hiddenList.eq(i).attr("name") !="hidden"){
					var params = {name:hiddenList.eq(i).attr("name"),targetid:hiddenList.eq(i).attr("id"),type:"text"};
					arrParams[arrParams.length] = params;
				}
			}
			//添加文本框项
			for(var i=0; i< inputList.length; i++){
				var params = {name:inputList.eq(i).attr("name"),targetid:inputList.eq(i).attr("id"),type:"text"};
				arrParams[arrParams.length] = params;
			}
			var data = upms.transParsToObj(arrParams, $newPgDiv);
			$newPgDiv.load(actionUrl, data, function() {
				upms.hideOverLay();
			});
		}
	});
	
	//验证影响项目进展原因
	function checkProgress(nameValue){
		checkFocus(nameValue);
		var flag = false;
		var i = 0;
		$("[name='"+ nameValue +"']").each(function(){
		   if($(this).attr("checked") == "checked" ){
		    i = i + 1;
		   }
		});
		if(i==0){
			var text = $("#hidden"+ nameValue).val();
			var span = $("<div id='error"+nameValue+"'><span style='color:red;font-style: normal;'>"+ text + "不能为空！</span></div>");
			$("#hidden"+ nameValue).parent().append(span);
			flag = true;
		}else if(i>3){
			var text = $("#hidden"+ nameValue).val();
			var span = $("<div id='error"+nameValue+"'><span style='color:red;font-style: normal;'>"+ text + "不能超过三项！</span></div>");
			$("#hidden"+ nameValue).parent().append(span);
			flag = true;
		}else{
			$("#hidden"+ nameValue).html("");
		}
		return flag;
	}
	
	function checkFocus(nameValue){
		// 清除错误提示信息
		$("#error" + nameValue).remove();
	}
	
	//不能修改时下一步按钮功能
	$("#nextStep").bind("click", function(){
		//选中左边菜单
		upms.upmsUtils.setMenu();
		var actionUrl= path + "/api/supervisor/projectAchievementInfoAction!getProjectAchievementInfo.action?supervisorId="+$("#supervisorId").val()+"&isEdit="+$("#isEdit").val()+"&now=" + new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [];
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	});

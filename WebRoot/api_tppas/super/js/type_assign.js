	
	// 工程根目录
	var path="";
	
	$(function() {
		$(document).ready(function() {
			 path = $("#path").text();
			 
			 upms.upmsUtils.initSelect("userId", $("#userValue").val(), 1 , 1 , 0);
			 
		});
	});
	
	//保存按钮功能
	$("#saveBut").bind("click", function(){
		var comfirmInfo = $("#comfirmSave").text();
		//判断是保存还是修改
		if($("#typeManagerId").val()!=null&&$("#typeManagerId").val()!=''){
			comfirmInfo = $("#comfirmUpdate").text();
		}
		
		if (confirm(comfirmInfo)){
			var actionUrl= path + "/api/superadmin/tprojectTypeManagerAction!saveManagerInfo.action?optType=0&now=" + new Date().getTime();
			upms.showOverLay();// 打开遮罩
			var $newPgDiv = $("#mainContent");
			var arrParams = [{name:"tprojectTypeManager.userId",targetid:"userId",type:"select"}];
			arrParams = upms.upmsUtils.setSubmitDatas(arrParams, 1, 0);
			var data = upms.transParsToObj(arrParams, $newPgDiv);
			$newPgDiv.load(actionUrl, data, function() {
				upms.hideOverLay();
			});
		}
	});
	
	//返回按钮功能
	$("#reBtn").bind("click", function(){
		var actionUrl= path + "/api/superadmin/typeModel!init.action?now=" + new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		var arrParams = [];
		$newPgDiv.load(actionUrl, null, function() {
			upms.hideOverLay();
		});
	});
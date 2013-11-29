	// 项目根目录
	var path="";
	
	$(document).ready(function(){
		path = $("#path").text();
		
		//擅长专业1
		upms.upmsUtils.initSelect("expertMajor1",'', 1 , 1 , 0);
	 	//信用等级
		upms.upmsUtils.initSelect("expertPrestige",'', 1 , 1 , 0);
	
	 	$("#queryBtn").attr("disabled",true);
	 	var actionUrl=path + "/api/expert/texpertAction!list.action?date=" + new Date().getTime();
		var params = [{name:"expertName",targetid:"expertName",type:"text"},
		              {name:"expertMajor1",targetid:"expertMajor1",type:"select"},
		              {name:"expertPrestige",targetid:"expertPrestige",type:"select"}];
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		var data = upms.transParsToObj(params, $("#searchForm"));
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
			$("#queryBtn").removeAttr("disabled");
		});
	}); 

	 $("#queryBtn").bind("click", function() {
	 	var actionUrl=path + "/api/expert/texpertAction!list.action?date=" + new Date().getTime();
		var params = [{name:"expertName",targetid:"expertName",type:"text"},
		              {name:"expertMajor1",targetid:"expertMajor1",type:"select"},
		              {name:"expertPrestige",targetid:"expertPrestige",type:"select"}];
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		var data = upms.transParsToObj(params, $("#searchForm"));
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	});
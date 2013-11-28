// 网站根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();	
		
		if ($("#status").val() != 1) {
			   $("input[type='text']").each(function(){
				$(this).attr("disabled",true);
				});
				upms.upmsUtils.initSelect("sex", $("#hiddensex1").val(),1,1,0);
		} 
		if ($("#revealOrder").val() == "") {
			$("#revealOrder").attr("value","0");
		}

	 });
	
	});	 

//返回
$("#reBtn").bind("click", function() {
	var actionUrl= path + "/api/report/tprojectLeader!list.action?now="+ new Date().getTime();
	var $newPgDiv = $("#content");
	var arrParams =[{name : "projectId",
		targetid : "projectId",
		type : "text"
	}, {
		name : "applyStatus",
		targetid : "applyStatus",
		type : "text"
	}, {
		name : "tprojectLeaderA.projectLeaderAId",
		targetid : "projectLeaderAId",
		type : "text"
	}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});
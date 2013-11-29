// 网站根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();
		// 画面禁止输入
    	$("input[type='text']").each(function(){
			$(this).attr("disabled",true);
		});
		upms.upmsUtils.initSelect("sexFlag", $("#hiddensexFlag1").val(),1,1,0);
	 });
});

//返回
$("#reBtn").bind("click", function() {
	var actionUrl= path + "/api/report/tresearcherActionB!list.action?now="+ new Date().getTime();
	var $newPgDiv = $("#content");
	var arrParams =[{name : "projectId",
		targetid : "projectId",
		type : "text"
	}, {
		name : "applyStatus",
		targetid : "applyStatus",
		type : "text"
	}, {
		name : "tresearcher.researcherId",
		targetid : "researcherId",
		type : "text"
	}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});
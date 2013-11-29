// 网站根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();

		$("input[type='text']").each(function(){
			$(this).attr("disabled",true);
		});
		// 初始化下拉列表
		upms.upmsUtils.initSelect("centralizedType",$("#centralizedTypeValue").val(),1,1,0);
		upms.upmsUtils.initSelect("regionId1",$("#regionId1Value").val(),1,3,0);
		upms.upmsUtils.initSelect("regionId2",$("#regionId2Value").val(),1,3,0);
		upms.upmsUtils.initSelect("regionId3",$("#regionId3Value").val(),1,3,0);
		upms.upmsUtils.initSelect("industries1",$("#industries1Value").val(),1,4,0);
		upms.upmsUtils.initSelect("industries2",$("#industries2Value").val(),1,4,0);
		upms.upmsUtils.initSelect("industries3",$("#industries3Value").val(),1,4,0);
		upms.upmsUtils.initSelect("industries4",$("#industries4Value").val(),1,4,0);
		upms.upmsUtils.initSelect("unitProperties",$("#unitPropertiesValue").val(),1,1,0);
		upms.upmsUtils.initSelect("intellectualProperty",$("#intellectualPropertyValue").val(),1,1,0);
		upms.upmsUtils.initSelect("technologySource",$("#technologySourceValue").val(),1,1,0);
		upms.upmsUtils.initSelect("technicalFisld1",$("#technicalFisld1Value").val(),1,3,0);
		upms.upmsUtils.initSelect("technicalFisld2",$("#technicalFisld2Value").val(),1,3,0);
		upms.upmsUtils.initSelect("technicalFisld3",$("#technicalFisld3Value").val(),1,3,0);
	});
});


/**
 * 下一步按钮功能
 */
$("#nextBtn").bind("click", function(){
		// 设置左侧菜单
		upms.upmsUtils.setMenu();
		
		var actionUrl= path + "/api/report/treportAbstractBAction!showReportAbstractB.action?now="+new Date().getTime();
		//alert(actionUrl);
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"projectId",targetid:"projectId",type:"text"},
		                 {name:"applyStatus",targetid:"applyStatus",type:"text"}];
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
});
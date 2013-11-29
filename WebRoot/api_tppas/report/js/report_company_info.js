
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();

		// 禁用所有控件
		// 获取输入项
		var idList = $("input[type='text']");
		for ( var i = 0; i < idList.length; i++) {
			var id = idList.eq(i).attr("id");
			if (id != "institutesHighTalent" 
				&& id != "recommendation"
				&& id != "averageInvestmentExperts"
				&& id != "averageTechnicalExperts"
				&& id != "investmentExperts"
				&& id != "technicalExperts"){
				$("#" + id).attr("disabled", true);
			}
		}
		
		upms.upmsUtils.initSelect("recommendation", $("#recommendationValue").val(), 1, 1, 0);
	});
});

	
$("#okBtn").bind("click", function() {
	//获取输入项
	var idList = $("input[type='text']");
	//获取隐藏项
	
	//输入项验证
	if(upms.upmsUtils.inputCheck()){
		return;
	}
	if (confirm($("#comfirmSave").text())){
	var actionUrl= path + "/api/report/tcompanyInfoAction!updateTcompanyInfo.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"projectId",targetid:"projectId",type:"text"}];
		arrParams[arrParams.length] = {name:"applyStatus",targetid:"applyStatus",type:"text"};
		arrParams[arrParams.length] = {name:"tcompanyInfo.companyInfoId",targetid:"companyInfoId",type:"text"};
		arrParams[arrParams.length] = {name:"tcompanyInfo.recommendation",targetid:"recommendation",type:"text"};
		
		for(var i=0; i< idList.length; i++){
			var params = {name:idList.eq(i).attr("name"),targetid:idList.eq(i).attr("id"),type:"text"};
			arrParams[arrParams.length] = params;
		}
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
});
	
//$("#nextBtn").bind("click", function() {
//	
//	//获取输入项
//	var idList = $("input[type='text']");
//	//获取隐藏项
//		
//	//输入项验证
//	if(upms.upmsUtils.inputCheck()){
//		return;
//	}
//	if (confirm($("#comfirmSaveNext").text())){
//		// 设置左侧菜单
//		upms.upmsUtils.setMenu();
//		var actionUrl= path + "/api/report/tcompanyInfoAction!next.action?now="+ new Date().getTime();
//		upms.showOverLay();// 打开遮罩
//		var $newPgDiv = $("#content");
//		var arrParams = [{name:"projectId",targetid:"projectId",type:"text"}];
//		arrParams[arrParams.length] = {name:"applyStatus",targetid:"applyStatus",type:"text"};
//		arrParams[arrParams.length] = {name:"tcompanyInfo.companyInfoId",targetid:"companyInfoId",type:"text"};
//		arrParams[arrParams.length] = {name:"tcompanyInfo.recommendation",targetid:"recommendation",type:"text"};
//		
//		for(var i=0; i< idList.length; i++){
//			var params = {name:idList.eq(i).attr("name"),targetid:idList.eq(i).attr("id"),type:"text"};
//			arrParams[arrParams.length] = params;
//		}
//		var data = upms.transParsToObj(arrParams, $newPgDiv);
//		$newPgDiv.load(actionUrl, data, function() {
//			upms.hideOverLay();
//		});
//	}
//});
	
$("#nextBtn").bind("click", function() {
	// 设置左侧菜单
	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/report/treviewCommentsAction!showTreviewCommentsNonTech.action?now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"projectId",targetid:"projectId",type:"text"}];
	arrParams[arrParams.length] = {name:"applyStatus",targetid:"applyStatus",type:"text"};
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

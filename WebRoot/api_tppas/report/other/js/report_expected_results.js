// 网站根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();

		if($("#applyStatus").val() == 0){
			$("textarea").each(function(){
				$("textarea").each(function(){
					$(this).attr("readonly",true);
					$(this).css('background-color','#F0F0F0');
				});
			});
		}
	});
});


/**
 * 保存按钮功能
 */
$("#okBtn").bind("click", function(){
	
	// 验证text
	var result = upms.upmsUtils.inputCheck();
	
	if(result){
		return;
	}
	
	if (confirm($("#comfirmSave").text())){
		
		var actionUrl= path + "/api/report/texpectedResults!saveTexpectedResults.action?now="+new Date().getTime();
		//alert(actionUrl);
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [];
		arrParams = upms.upmsUtils.setSubmitDatas(arrParams, 1, 0);
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
});

/**
 * 下一步按钮功能
 */
$("#nextBtn").bind("click", function(){
	
	// 验证text
	var result = upms.upmsUtils.inputCheck();
	
	if(result){
		return;
	}
	
	if (confirm($("#comfirmSaveNext").text())){
		
		// 设置左侧菜单
		upms.upmsUtils.setMenu();
		
		var actionUrl= path + "/api/report/treportAbstractBAction!nextReportAbstractB.action?now="+new Date().getTime();
		//alert(actionUrl);
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [];
		arrParams = upms.upmsUtils.setSubmitDatas(arrParams, 1, 0);
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
});

/**
 * 下一步按钮功能
 */
$("#nextBtn1").bind("click", function(){
	
	// 设置左侧菜单
	upms.upmsUtils.setMenu();
	
	var actionUrl= path + "/api/report/tresearcherActionB!list.action?now="+new Date().getTime();
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
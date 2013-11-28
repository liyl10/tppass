// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
});

/**
 * 联席会意见
 */
function submitJointAudit(comfirmMsg){
	// 验证radio
	var nameList = new Array("officeStatus");
	var result = upms.upmsUtils.radioCheck(nameList);
	
	if(result){
		return;
	}
	
	if (confirm($("#comfirm").html())){
		
		var actionUrl= path + "/api/audit/projectApplicationOffice!batchSaveOfficeAudit.action?now="+new Date().getTime();
		//alert(actionUrl);
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		var arrParams = [{name:"officeStatus",targetname:"officeStatus",type:"radio"}];
		arrParams = upms.upmsUtils.setSubmitDatas(arrParams, 1, 0);
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
}


/**
 * 返回
 */
function back(){
	var actionUrl= path + "/api/audit/projectApplicationOffice!showOfficeAuditManage.action?&now="+new Date().getTime();
	//alert(actionUrl);
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [];
	arrParams = upms.upmsUtils.setSubmitDatas(arrParams, 1, 0);
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}
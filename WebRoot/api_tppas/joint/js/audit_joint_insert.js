// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	if($("#jointEditFlag").val() == 0){
		upms.upmsUtils.setDisableControl();
		$("#backBtn").removeAttr("disabled");
	}
});

/**
 * 联席会意见
 */
function submitJointAudit(comfirmMsg){
	
	// 验证radio
	var nameList = new Array("jointStatus");
	var result = upms.upmsUtils.radioCheck(nameList);
	if(result){
		return;
	}
	
	if (confirm(comfirmMsg)){
		
		var actionUrl= path + "/api/audit/projectApplicationJoint!saveJointAudit.action?now="+new Date().getTime();
		//alert(actionUrl);
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		var arrParams = [{name:"jointStatus",targetname:"jointStatus",type:"radio"}];
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
	var actionUrl= path + "/api/audit/projectApplicationJoint!showJointAuditManage.action?&now="+new Date().getTime();
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
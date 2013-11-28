// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	// 计划批次
	upms.upmsUtils.initSelect("planBatch", "", 1, 1, 1);
});

function next(){
	var result = upms.upmsUtils.inputCheck();
	var idList = new Array("planBatch");
	var result2 = upms.upmsUtils.selectCheck(idList);
	if(result || result2){
		return;
	}
	if(confirm($("#comfirmNext").text())){
		var actionUrl= path + "/api/planManage/planManageAction!nextAndSelectProject.action?now="+new Date().getTime();
		//alert(actionUrl);
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		var arrParams = [
		                 {name:"tplan.planBatch",targetid:"planBatch",type:"text"}
		                 ];
		arrParams = upms.upmsUtils.setSubmitDatas(arrParams, 1, 0);
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
}

// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
		upms.upmsUtils.initSelect("address1",$("#address1Value").val(),1,3,2);
		upms.upmsUtils.initSelect("address2",$("#address2Value").val(),1,3,2);
		upms.upmsUtils.initSelect("address3",$("#address3Value").val(),1,3,2);
		if($("#Flag").val() == "1"){
			var idList = $("input[type='text']");
			for(var i=0; i<idList.length; i++){
				var id = idList.eq(i).attr("id");
				$("#" + id).attr("disabled",true);
			}
		}
	});
});




$("#nextBtn1").bind("click", function() {
	// 设置左侧菜单
 	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/contract/tcontractContentsB!initContents.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"}];
		arrParams[arrParams.length] = {name:"Flag",targetid:"Flag",type:"text"};
		arrParams[arrParams.length] = {name:"contractStatus",targetid:"contractStatus",type:"text"};
		arrParams[arrParams.length] = {name:"modelType",targetid:"modelType",type:"text"};
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	});
	
// 文字型焦点进入事件
function focusText(now){
	// 清除错误提示信息
	$("#error" + now.id).remove();
}

$("#okBtn").bind("click", function() {
	//获取输入项
	var idList = $("input[type='text']");
	//获取隐藏项
	var flg = 0;
	//输入项验证
	if(upms.upmsUtils.inputCheck()){
		flg = 1;
	}
	
	var idList1 = new Array("address3");
	if (upms.upmsUtils.selectCheck(idList1)){
		flg = 1;
	}
	
	if (flg == 1){
		return;
	}
	
	if (confirm($("#comfirmSave").text())){
	var actionUrl= path + "/api/contract/tcontractCover!updatecontractCover.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"}];
		arrParams[arrParams.length] = {name:"Flag",targetid:"Flag",type:"text"};
		arrParams[arrParams.length] = {name:"contractStatus",targetid:"contractStatus",type:"text"};
		arrParams[arrParams.length] = {name:"tcontractCover.contractCoverId",targetid:"contractCoverId",type:"text"};
		// 添加公民类型股权信息
		for(var i=0; i< idList.length; i++){
			var params = {name:idList.eq(i).attr("name"),targetid:idList.eq(i).attr("id"),type:"text"};
			arrParams[arrParams.length] = params;
		}
		arrParams[arrParams.length] = {name:"tcontractCover.address1",targetid:"address1",type:"select"};
		arrParams[arrParams.length] = {name:"tcontractCover.address2",targetid:"address2",type:"select"};
		arrParams[arrParams.length] = {name:"tcontractCover.address3",targetid:"address3",type:"select"};
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
	});

$("#nextBtn").bind("click", function() {
	//获取输入项
	var idList = $("input[type='text']");
	
	//输入项验证
	if(upms.upmsUtils.inputCheck()){
		return;
	}
	if (confirm($("#comfirmSaveNext").text())){
	// 设置左侧菜单
	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/contract/tcontractCover!next.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"}];
		arrParams[arrParams.length] = {name:"Flag",targetid:"Flag",type:"text"};
		arrParams[arrParams.length] = {name:"contractStatus",targetid:"contractStatus",type:"text"};
		arrParams[arrParams.length] = {name:"tcontractCover.contractCoverId",targetid:"contractCoverId",type:"text"};
		// 添加公民类型股权信息
		for(var i=0; i< idList.length; i++){
			var params = {name:idList.eq(i).attr("name"),targetid:idList.eq(i).attr("id"),type:"text"};
			arrParams[arrParams.length] = params;
		}
		arrParams[arrParams.length] = {name:"tcontractCover.address1",targetid:"address1",type:"select"};
		arrParams[arrParams.length] = {name:"tcontractCover.address2",targetid:"address2",type:"select"};
		arrParams[arrParams.length] = {name:"tcontractCover.address3",targetid:"address3",type:"select"};
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
	});
	

// 输入项验证
function checkInput(idList){
	var result = false;
	for(var i=0;i<idList.length;i++){
		var id = idList.eq(i).attr("id");
		if(typeof(id)=="undefined"){
			continue;
		}
		
		var domObject = idList.eq(i).get(0);
		if($("#hidden"+ id).length >0){
			var str = $("#hidden"+ id).val();
			var datas=str.split(",");
			var flag = blurText(domObject, datas[0], datas[1], datas[2]);
			if(!flag){
				result = true;
			}
		}
	}
	
	if($("#address3 option:selected").val() ==""){
		var domObject = $("#address3").get(0);
		var str = $("#hiddenaddress1").val();
		var datas=str.split(",");
		var flag = blurText(domObject, datas[0], datas[1], datas[2]);
		if(!flag){
			result = true;
		}
	}
	return result;
}
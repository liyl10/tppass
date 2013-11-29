
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
				
		sumequipment();
		sumRow("equipmentSpecial");
		sumRow("purchaseSpecial");
		sumRow("trialSpecial");
		sumRow("renovationSpecial");
		sumRow("materialSpecial");
		sumRow("testSpecial");
		sumRow("meetSpecial");
		sumRow("cooperationSpecial");
		sumRow("publishSpecial");
		sumRow("expertSpecial");
		sumtotal();
		if($("#Flag").val() == "1"){
		// 禁用所有控件
			// 获取输入项
			var idList = $("input[type='text']");
			for ( var i = 0; i < idList.length; i++) {
				var id = idList.eq(i).attr("id");
				$("#" + id).attr("disabled", true);
			}
		}
	});
});

//设置默认画面初期化时金额的默认值为0
function defaultDataSet(id){
	var value = $("#" + id).val();
	if(value == null || value=="")
	{
		$("#" + id).val("0");
	}
}

//合计每行
function sumRow(obj) {
	var i = obj.substr(0,obj.length - 7);
	
	var value1 = parseFloat($("#" + i + "Special").val() == '' ? 0 : $("#" + i + "Special")
			.val());
	var value2 = parseFloat($("#" + i + "Support").val() == '' ? 0 : $("#" + i + "Support")
			.val());
	var total = value1 + value2 ;
	total=total.toFixed(2);
	$("#" + i).val(total);
}

//总合计
function sumtotal(){
	//总合计
	var value2 = parseFloat($("#purchase").val() == '' ? 0 : $("#purchase")
			.val());
	var value3 = parseFloat($("#trial").val() == '' ? 0 : $("#trial")
			.val());
	var value4 = parseFloat($("#renovation").val() == '' ? 0 : $("#renovation")
			.val());
	var value5 = parseFloat($("#material").val() == '' ? 0 : $("#material")
			.val());
	var value6 = parseFloat($("#test").val() == '' ? 0 : $("#test")
			.val());
	var value7 = parseFloat($("#meet").val() == '' ? 0 : $("#meet")
			.val());
	var value8 = parseFloat($("#cooperation").val() == '' ? 0 : $("#cooperation")
			.val());
	var value9 = parseFloat($("#publish").val() == '' ? 0 : $("#publish")
			.val());
	var value10 = parseFloat($("#expert").val() == '' ? 0 : $("#expert")
			.val());
	var total = value2 + value3 + value4 + value5 + value6 + value7 + value8 + value9 + value10 ;
	total=total.toFixed(2);
	$("#total").val(total);
	//合计配套经费
	var value12 = parseFloat($("#purchaseSpecial").val() == '' ? 0 : $("#purchaseSpecial")
			.val());
	var value13 = parseFloat($("#trialSpecial").val() == '' ? 0 : $("#trialSpecial")
			.val());
	var value14 = parseFloat($("#renovationSpecial").val() == '' ? 0 : $("#renovationSpecial")
			.val());
	var value15 = parseFloat($("#materialSpecial").val() == '' ? 0 : $("#materialSpecial")
			.val());
	var value16 = parseFloat($("#testSpecial").val() == '' ? 0 : $("#testSpecial")
			.val());
	var value17 = parseFloat($("#meetSpecial").val() == '' ? 0 : $("#meetSpecial")
			.val());
	var value18 = parseFloat($("#cooperationSpecial").val() == '' ? 0 : $("#cooperationSpecial")
			.val());
	var value19 = parseFloat($("#publishSpecial").val() == '' ? 0 : $("#publishSpecial")
			.val());
	var value110 = parseFloat($("#expertSpecial").val() == '' ? 0 : $("#expertSpecial")
			.val());
	var total1 = value12 + value13 + value14 + value15 + value16 + value17 + value18 + value19 + value110 ;
	total1=total1.toFixed(2);
	$("#totalSpecial").val(total1);
	//合计专项经费
	var value22 = parseFloat($("#purchaseSupport").val() == '' ? 0 : $("#purchaseSupport")
			.val());
	var value23 = parseFloat($("#trialSupport").val() == '' ? 0 : $("#trialSupport")
			.val());
	var value24 = parseFloat($("#renovationSupport").val() == '' ? 0 : $("#renovationSupport")
			.val());
	var value25 = parseFloat($("#materialSupport").val() == '' ? 0 : $("#materialSupport")
			.val());
	var value26 = parseFloat($("#testSupport").val() == '' ? 0 : $("#testSupport")
			.val());
	var value27 = parseFloat($("#meetSupport").val() == '' ? 0 : $("#meetSupport")
			.val());
	var value28 = parseFloat($("#cooperationSupport").val() == '' ? 0 : $("#cooperationSupport")
			.val());
	var value29 = parseFloat($("#publishSupport").val() == '' ? 0 : $("#publishSupport")
			.val());
	var value210 = parseFloat($("#expertSupport").val() == '' ? 0 : $("#expertSupport")
			.val());
	var total2 = value22 + value23 + value24 + value25 + value26 + value27 + value28 + value29 + value210 ;
	total2=total2.toFixed(2);
	$("#totalSupport").val(total2);
}

//合计设备费
function sumequipment() {
	//合计设备费（专项经费）
	var value1 = parseFloat($("#purchaseSpecial").val() == '' ? 0 : $("#purchaseSpecial").val());
	var value2 = parseFloat($("#trialSpecial").val() == '' ? 0 : $("#trialSpecial").val());
	var value3 = parseFloat($("#renovationSpecial").val() == '' ? 0 : $("#renovationSpecial").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(2);
	$("#equipmentSpecial").val(total);
	//合计设备费（配套经费）
	var value4 = parseFloat($("#purchaseSupport").val() == '' ? 0 : $("#purchaseSupport").val());
	var value5 = parseFloat($("#trialSupport").val() == '' ? 0 : $("#trialSupport").val());
	var value6 = parseFloat($("#renovationSupport").val() == '' ? 0 : $("#renovationSupport").val());
	var total1 = value4 + value5 + value6;
	total1=total1.toFixed(2);
	$("#equipmentSupport").val(total1);
	//合计设备费
	sumRow("equipmentSpecial");
}

//文字型焦点进入事件
function focusText(now){
	// 清除错误提示信息
	$("#error" + now.id).remove();
	$("#err" + now.id).html("");
}

// 文字型焦点离开事件
function blurText(now, text, spaceFlag, type, num){
	var flag = true;
	if($.trim(now.value)==""){
		if(spaceFlag==1){
			$("#error" + now.id).remove();
			var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"不能为空！</span></div>");
			now.value="";
			$(now).parent().append(span);
			flag =false;
		}
		else if (spaceFlag==2){
			$("#err" + now.id).html("");
			$("#err" + now.id).html("</br>"+text +UPLANG.input_must);
			flag =false;
		}
	}
	else{
		//6位整数，2位小数验证
		if(type==5){
			/* var pattern = /^[1-9]\d*(\.\d)?|(0\.\d)?$/; */
			//var pattern = /^(([1-9](\d{0,6}))|0)(\.\d{1,2})?$/; 
			var result = upms.checkUtils.isFloatNum2(now.value);
			if(!result){
				$("#error" + now.id).remove();
				var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"格式不正确！(9999999.9999)</span></div>");
				$(now).parent().append(span);
				flag =false;
			}
		}
		// 整数验证
		else if(type==6){
			//var pattern = /^[0-9]*[1-9][0-9]*$/;
			var pattern = /^(([1-9](\d*))|0)$/;
			var result = pattern.test(now.value);
			if(!result){
				$("#error" + now.id).remove();
				var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"格式不正确！必须输入整数</span></div>");
				$(now).parent().append(span);
				flag =false;
			}				
		}
		// 7位整数，2位小数验证
		else if(type==7){
			var pattern = /^(([1-9](\d{0,7}))|0)(\.\d{1,2})?$/; 
			var result = pattern.test(now.value);
			if(!result){
				$("#error" + now.id).remove();
				var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"格式不正确！(9999999.99)</span></div>");
				$(now).parent().append(span);
				flag =false;
			}			
		}
		
		// 整数验证(底下)
		else if(type==8){
			//var pattern = /^[0-9]*[1-9][0-9]*$/;
			var pattern = /^(([1-9](\d*))|0)$/;
			var result = pattern.test(now.value);
			if(!result){
				$("#err" + now.id).html("");
				$("#err" + now.id).html(text + "格式不正确！必须输入整数");
				flag =false;
			}				
		}
	}
	return flag;
	
}	

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
	return result;
}

$("#okBtn").bind("click", function() {
	//获取输入项
	var idList = $("input[type='text']");
	//获取隐藏项
	
	if(checkInput(idList)){
		return;
	}	
	if (confirm($("#comfirmSave").text())){
	var actionUrl= path + "/api/contract/tfundUseA!updatefundUse.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"}];
		arrParams[arrParams.length] = {name:"Flag",targetid:"Flag",type:"text"};
		arrParams[arrParams.length] = {name:"contractStatus",targetid:"contractStatus",type:"text"};
		arrParams[arrParams.length] = {name:"modelType",targetid:"modelType",type:"text"};
		arrParams[arrParams.length] = {name:"tfunduse.fundUseId",targetid:"fundUseId",type:"text"};
		// 添加各个经费
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
	
$("#nextBtn").bind("click", function() {
	
	//获取输入项
	var idList = $("input[type='text']");
	//获取隐藏项
		
	if(checkInput(idList)){
		return;
	}	
	if (confirm($("#comfirmSaveNext").text())){
		upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/contract/tfundUseA!FundUseTodescription.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"}];
		arrParams[arrParams.length] = {name:"Flag",targetid:"Flag",type:"text"};
		arrParams[arrParams.length] = {name:"contractStatus",targetid:"contractStatus",type:"text"};
		arrParams[arrParams.length] = {name:"modelType",targetid:"modelType",type:"text"};
		arrParams[arrParams.length] = {name:"tfunduse.fundUseId",targetid:"fundUseId",type:"text"};
		// 添加各个经费
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

$("#nextBtn1").bind("click", function() {
	// 设置左侧菜单
	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/contract/tcontracthighTech!importDescription.action?now="+ new Date().getTime();
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

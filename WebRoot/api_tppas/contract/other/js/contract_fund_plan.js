
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();

		//合计
		sumInvestment();
		sumpartyFunding();
		sumunitRaised();
		sumotherFunds();
		sumbankLoans();
		sumequipmentCost();
		summaterialFee();
		sumtestFee();
		sumfuel();
		sumtravel();
		sumconferenceFees();
		sumconsultancyServices();
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

//1总投资合计
$("#totalInvestment1").bind("input propertychange", function() {
	sumInvestment();
});
$("#totalInvestment2").bind("input propertychange", function() {
	sumInvestment();
});
$("#totalInvestment3").bind("input propertychange", function() {
	sumInvestment();
});
//1甲方拨款合计
$("#partyFunding1").bind("input propertychange", function() {
	sumpartyFunding();
});
$("#partyFunding2").bind("input propertychange", function() {
	sumpartyFunding();
});
$("#partyFunding3").bind("input propertychange", function() {
	sumpartyFunding();
});
//1单位自筹
$("#unitRaised1").bind("input propertychange", function() {
	sumunitRaised();
});
$("#unitRaised2").bind("input propertychange", function() {
	sumunitRaised();
});
$("#unitRaised3").bind("input propertychange", function() {
	sumunitRaised();
});

//1其他经费
$("#otherFunds1").bind("input propertychange", function() {
	sumotherFunds();
});
$("#otherFunds2").bind("input propertychange", function() {
	sumotherFunds();
});
$("#otherFunds3").bind("input propertychange", function() {
	sumotherFunds();
});
//1银行贷款
$("#bankLoans1").bind("input propertychange", function() {
	sumbankLoans();
});
$("#bankLoans2").bind("input propertychange", function() {
	sumbankLoans();
});
$("#bankLoans3").bind("input propertychange", function() {
	sumbankLoans();
});
//1设备费
$("#equipmentCost1").bind("input propertychange", function() {
	sumequipmentCost();
});
$("#equipmentCost2").bind("input propertychange", function() {
	sumequipmentCost();
});
$("#equipmentCost3").bind("input propertychange", function() {
	sumequipmentCost();
});
//1材料费
$("#materialFee1").bind("input propertychange", function() {
	summaterialFee();
});
$("#materialFee2").bind("input propertychange", function() {
	summaterialFee();
});
$("#materialFee3").bind("input propertychange", function() {
	summaterialFee();
});
//1测试化验加工费
$("#testFee1").bind("input propertychange", function() {
	sumtestFee();
});
$("#testFee2").bind("input propertychange", function() {
	sumtestFee();
});
$("#testFee3").bind("input propertychange", function() {
	sumtestFee();
});
//1材料动力费
$("#fuel1").bind("input propertychange", function() {
	sumfuel();
});
$("#fuel2").bind("input propertychange", function() {
	sumfuel();
});
$("#fuel3").bind("input propertychange", function() {
	sumfuel();
});
//1差旅调研费
$("#travel1").bind("input propertychange", function() {
	sumtravel();
});
$("#travel2").bind("input propertychange", function() {
	sumtravel();
});
$("#travel3").bind("input propertychange", function() {
	sumtravel();
});
//1会议交流费
$("#conferenceFees1").bind("input propertychange", function() {
	sumconferenceFees();
});
$("#conferenceFees2").bind("input propertychange", function() {
	sumconferenceFees();
});
$("#conferenceFees3").bind("input propertychange", function() {
	sumconferenceFees();
});
//1劳务咨询费
$("#consultancyServices1").bind("input propertychange", function() {
	sumconsultancyServices();
});
$("#consultancyServices2").bind("input propertychange", function() {
	sumconsultancyServices();
});
$("#consultancyServices3").bind("input propertychange", function() {
	sumconsultancyServices();
});

//设置默认画面初期化时金额的默认值为0
function defaultDataSet(id){
	var value = $("#" + id).val();
	if(value == null || value=="")
	{
		$("#" + id).val("0");
	}
}

//合计总投资
function sumInvestment() {
	var value1 = parseFloat($("#totalInvestment1").val() == '' ? 0 : $("#totalInvestment1").val());
	var value2 = parseFloat($("#totalInvestment2").val() == '' ? 0 : $("#totalInvestment2").val());
	var value3 = parseFloat($("#totalInvestment3").val() == '' ? 0 : $("#totalInvestment3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(2);
	$("#TotaltotalInvestment").val(total);
}
//合计甲方拨款
function sumpartyFunding() {
	var value1 = parseFloat($("#partyFunding1").val() == '' ? 0 : $("#partyFunding1").val());
	var value2 = parseFloat($("#partyFunding2").val() == '' ? 0 : $("#partyFunding2").val());
	var value3 = parseFloat($("#partyFunding3").val() == '' ? 0 : $("#partyFunding3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(2);
	$("#TotalpartyFunding").val(total);
}
//合计单位自筹
function sumunitRaised() {
	var value1 = parseFloat($("#unitRaised1").val() == '' ? 0 : $("#unitRaised1").val());
	var value2 = parseFloat($("#unitRaised2").val() == '' ? 0 : $("#unitRaised2").val());
	var value3 = parseFloat($("#unitRaised3").val() == '' ? 0 : $("#unitRaised3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(2);
	$("#TotalunitRaised").val(total);
}
//合计其他经费
function sumotherFunds() {
	var value1 = parseFloat($("#otherFunds1").val() == '' ? 0 : $("#otherFunds1").val());
	var value2 = parseFloat($("#otherFunds2").val() == '' ? 0 : $("#otherFunds2").val());
	var value3 = parseFloat($("#otherFunds3").val() == '' ? 0 : $("#otherFunds3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(2);
	$("#TotalotherFunds").val(total);
}
//合计银行贷款
function sumbankLoans() {
	var value1 = parseFloat($("#bankLoans1").val() == '' ? 0 : $("#bankLoans1").val());
	var value2 = parseFloat($("#bankLoans2").val() == '' ? 0 : $("#bankLoans2").val());
	var value3 = parseFloat($("#bankLoans3").val() == '' ? 0 : $("#bankLoans3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(2);
	$("#TotalbankLoans").val(total);
}
//合计设备费
function sumequipmentCost() {
	var value1 = parseFloat($("#equipmentCost1").val() == '' ? 0 : $("#equipmentCost1").val());
	var value2 = parseFloat($("#equipmentCost2").val() == '' ? 0 : $("#equipmentCost2").val());
	var value3 = parseFloat($("#equipmentCost3").val() == '' ? 0 : $("#equipmentCost3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(2);
	$("#TotalequipmentCost").val(total);
}
//合计材料费
function summaterialFee() {
	var value1 = parseFloat($("#materialFee1").val() == '' ? 0 : $("#materialFee1").val());
	var value2 = parseFloat($("#materialFee2").val() == '' ? 0 : $("#materialFee2").val());
	var value3 = parseFloat($("#materialFee3").val() == '' ? 0 : $("#materialFee3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(2);
	$("#TotalmaterialFee").val(total);
}
//合计测试化验加工费
function sumtestFee() {
	var value1 = parseFloat($("#testFee1").val() == '' ? 0 : $("#testFee1").val());
	var value2 = parseFloat($("#testFee2").val() == '' ? 0 : $("#testFee2").val());
	var value3 = parseFloat($("#testFee3").val() == '' ? 0 : $("#testFee3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(2);
	$("#TotaltestFee").val(total);
}
//合计燃料动力费
function sumfuel() {
	var value1 = parseFloat($("#fuel1").val() == '' ? 0 : $("#fuel1").val());
	var value2 = parseFloat($("#fuel2").val() == '' ? 0 : $("#fuel2").val());
	var value3 = parseFloat($("#fuel3").val() == '' ? 0 : $("#fuel3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(2);
	$("#Totalfuel").val(total);
}
//合计差旅调研费
function sumtravel() {
	var value1 = parseFloat($("#travel1").val() == '' ? 0 : $("#travel1").val());
	var value2 = parseFloat($("#travel2").val() == '' ? 0 : $("#travel2").val());
	var value3 = parseFloat($("#travel3").val() == '' ? 0 : $("#travel3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(2);
	$("#Totaltravel").val(total);
}
//合计会议交流费
function sumconferenceFees() {
	var value1 = parseFloat($("#conferenceFees1").val() == '' ? 0 : $("#conferenceFees1").val());
	var value2 = parseFloat($("#conferenceFees2").val() == '' ? 0 : $("#conferenceFees2").val());
	var value3 = parseFloat($("#conferenceFees3").val() == '' ? 0 : $("#conferenceFees3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(2);
	$("#TotalconferenceFees").val(total);
}
//合计劳务咨询费
function sumconsultancyServices() {
	var value1 = parseFloat($("#consultancyServices1").val() == '' ? 0 : $("#consultancyServices1").val());
	var value2 = parseFloat($("#consultancyServices2").val() == '' ? 0 : $("#consultancyServices2").val());
	var value3 = parseFloat($("#consultancyServices3").val() == '' ? 0 : $("#consultancyServices3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(2);
	$("#TotalconsultancyServices").val(total);
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
			$("#err" + now.id).html(text +UPLANG.input_must);
			flag =false;
		}
	}
	else{
		//6位整数，2位小数验证
		if(type==5){
			/* var pattern = /^[1-9]\d*(\.\d)?|(0\.\d)?$/; */
			var pattern = /^(([1-9](\d{0,6}))|0)(\.\d{1,2})?$/; 
			var result = pattern.test(now.value);
			if(!result){
				$("#error" + now.id).remove();
				var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"格式不正确！(9999999.99)</span></div>");
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
	
	//输入项验证
	if(upms.upmsUtils.inputCheck()){
		return;
	}
	if (confirm($("#comfirmSave").text())){
	var actionUrl= path + "/api/contract/tfundingPlanB!updatetfundingPlanB.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"}];
		arrParams[arrParams.length] = {name:"Flag",targetid:"Flag",type:"text"};
		arrParams[arrParams.length] = {name:"contractStatus",targetid:"contractStatus",type:"text"};
		arrParams[arrParams.length] = {name:"tfundingPlanB.fundingPlanBId",targetid:"fundingPlanBId",type:"text"};
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
		
	//输入项验证
	if(upms.upmsUtils.inputCheck()){
		return;
	}
	if (confirm($("#comfirmSaveNext").text())){
		// 设置左侧菜单
		upms.upmsUtils.setMenu();
		var actionUrl= path + "/api/contract/tfundingPlanB!next.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"}];
		arrParams[arrParams.length] = {name:"Flag",targetid:"Flag",type:"text"};
		arrParams[arrParams.length] = {name:"contractStatus",targetid:"contractStatus",type:"text"};
		arrParams[arrParams.length] = {name:"tfundingPlanB.fundingPlanBId",targetid:"fundingPlanBId",type:"text"};
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
	var actionUrl= path + "/api/contract/tcontractContentsB!initObligation.action?now="+ new Date().getTime();
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

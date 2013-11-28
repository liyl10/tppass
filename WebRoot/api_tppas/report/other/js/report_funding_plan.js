
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		// 设定金额的初期值，如果为空的话设置为0
		// 设备费
		defaultDataSet("equipmentCost1");
		defaultDataSet("equipmentCost2");
		defaultDataSet("equipmentCost3");
		// 材料费
		defaultDataSet("materialFee1");
		defaultDataSet("materialFee2");
		defaultDataSet("materialFee3");
		// 测试化验加工费
		defaultDataSet("testFee1");
		defaultDataSet("testFee2");
		defaultDataSet("testFee3");
		// 材料动力费
		defaultDataSet("fuel1");
		defaultDataSet("fuel2");
		defaultDataSet("fuel3");
		// 差旅调研费
		defaultDataSet("travel1");
		defaultDataSet("travel2");
		defaultDataSet("travel3");
		// 会议交流费
		defaultDataSet("conferenceFees1");
		defaultDataSet("conferenceFees2");
		defaultDataSet("conferenceFees3");
		// 劳务咨询费
		defaultDataSet("consultancyServices1");
		defaultDataSet("consultancyServices2");
		defaultDataSet("consultancyServices3");
		// 其他经费
		defaultDataSet("otherFunds1");
		defaultDataSet("otherFunds2");
		defaultDataSet("otherFunds3");
		
		//合计
		sumotherFunds();
		sumequipmentCost();
		summaterialFee();
		sumtestFee();
		sumfuel();
		sumtravel();
		sumconferenceFees();
		sumconsultancyServices();
		sumTotal1();
		sumTotal2();
		sumTotal3();
		sumTotal();
		
		
		// 禁止输入
		var idList = $("input[type='text']");
		for ( var i = 0; i < idList.length; i++) {
			var id = idList.eq(i).attr("id");
			$("#" + id).attr("disabled", true);
		}
	});
});

//1设备费
$("#equipmentCost1").bind("input propertychange", function() {
	sumTotal1();
	sumequipmentCost();
	sumTotal();
});
$("#equipmentCost2").bind("input propertychange", function() {
	sumTotal2();
	sumequipmentCost();
	sumTotal();
});
$("#equipmentCost3").bind("input propertychange", function() {
	sumTotal3();
	sumequipmentCost();
	sumTotal();
});
//1材料费
$("#materialFee1").bind("input propertychange", function() {
	sumTotal1();
	summaterialFee();
	sumTotal();
});
$("#materialFee2").bind("input propertychange", function() {
	sumTotal2();
	summaterialFee();
	sumTotal();
});
$("#materialFee3").bind("input propertychange", function() {
	sumTotal3();
	summaterialFee();
	sumTotal();
});
//1测试化验加工费
$("#testFee1").bind("input propertychange", function() {
	sumTotal1();
	sumtestFee();
	sumTotal();
});
$("#testFee2").bind("input propertychange", function() {
	sumTotal2();
	sumtestFee();
	sumTotal();
});
$("#testFee3").bind("input propertychange", function() {
	sumTotal3();
	sumtestFee();
	sumTotal();
});
//1材料动力费
$("#fuel1").bind("input propertychange", function() {
	sumTotal1();
	sumfuel();
	sumTotal();
});
$("#fuel2").bind("input propertychange", function() {
	sumTotal2();
	sumfuel();
	sumTotal();
});
$("#fuel3").bind("input propertychange", function() {
	sumTotal3();
	sumfuel();
	sumTotal();
});
//1差旅调研费
$("#travel1").bind("input propertychange", function() {
	sumTotal1();
	sumtravel();
	sumTotal();
});
$("#travel2").bind("input propertychange", function() {
	sumTotal2();
	sumtravel();
	sumTotal();
});
$("#travel3").bind("input propertychange", function() {
	sumTotal3();
	sumtravel();
	sumTotal();
});
//1会议交流费
$("#conferenceFees1").bind("input propertychange", function() {
	sumTotal1();
	sumconferenceFees();
	sumTotal();
});
$("#conferenceFees2").bind("input propertychange", function() {
	sumTotal2();
	sumconferenceFees();
	sumTotal();
});
$("#conferenceFees3").bind("input propertychange", function() {
	sumTotal3();
	sumconferenceFees();
	sumTotal();
});
//1劳务咨询费
$("#consultancyServices1").bind("input propertychange", function() {
	sumTotal1();
	sumconsultancyServices();
	sumTotal();
});
$("#consultancyServices2").bind("input propertychange", function() {
	sumTotal2();
	sumconsultancyServices();
	sumTotal();
});
$("#consultancyServices3").bind("input propertychange", function() {
	sumTotal3();
	sumconsultancyServices();
	sumTotal();
});
//1其他经费
$("#otherFunds1").bind("input propertychange", function() {
	sumTotal1();
	sumotherFunds();
	sumTotal();
});
$("#otherFunds2").bind("input propertychange", function() {
	sumTotal2();
	sumotherFunds();
	sumTotal();
});
$("#otherFunds3").bind("input propertychange", function() {
	sumTotal3();
	sumotherFunds();
	sumTotal();
});

//设置默认画面初期化时金额的默认值为0
function defaultDataSet(id){
	var value = $("#" + id).val();
	if(value == null || value=="")
	{
		$("#" + id).val("0");
	}
}

//合计设备费
function sumequipmentCost() {
	var value1 = parseFloat($("#equipmentCost1").val() == '' ? 0 : $("#equipmentCost1").val());
	var value2 = parseFloat($("#equipmentCost2").val() == '' ? 0 : $("#equipmentCost2").val());
	var value3 = parseFloat($("#equipmentCost3").val() == '' ? 0 : $("#equipmentCost3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#TotalequipmentCost").val(total);
}
//合计材料费
function summaterialFee() {
	var value1 = parseFloat($("#materialFee1").val() == '' ? 0 : $("#materialFee1").val());
	var value2 = parseFloat($("#materialFee2").val() == '' ? 0 : $("#materialFee2").val());
	var value3 = parseFloat($("#materialFee3").val() == '' ? 0 : $("#materialFee3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#TotalmaterialFee").val(total);
}
//合计测试化验加工费
function sumtestFee() {
	var value1 = parseFloat($("#testFee1").val() == '' ? 0 : $("#testFee1").val());
	var value2 = parseFloat($("#testFee2").val() == '' ? 0 : $("#testFee2").val());
	var value3 = parseFloat($("#testFee3").val() == '' ? 0 : $("#testFee3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#TotaltestFee").val(total);
}
//合计燃料动力费
function sumfuel() {
	var value1 = parseFloat($("#fuel1").val() == '' ? 0 : $("#fuel1").val());
	var value2 = parseFloat($("#fuel2").val() == '' ? 0 : $("#fuel2").val());
	var value3 = parseFloat($("#fuel3").val() == '' ? 0 : $("#fuel3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#Totalfuel").val(total);
}
//合计差旅调研费
function sumtravel() {
	var value1 = parseFloat($("#travel1").val() == '' ? 0 : $("#travel1").val());
	var value2 = parseFloat($("#travel2").val() == '' ? 0 : $("#travel2").val());
	var value3 = parseFloat($("#travel3").val() == '' ? 0 : $("#travel3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#Totaltravel").val(total);
}
//合计会议交流费
function sumconferenceFees() {
	var value1 = parseFloat($("#conferenceFees1").val() == '' ? 0 : $("#conferenceFees1").val());
	var value2 = parseFloat($("#conferenceFees2").val() == '' ? 0 : $("#conferenceFees2").val());
	var value3 = parseFloat($("#conferenceFees3").val() == '' ? 0 : $("#conferenceFees3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#TotalconferenceFees").val(total);
}
//合计劳务咨询费
function sumconsultancyServices() {
	var value1 = parseFloat($("#consultancyServices1").val() == '' ? 0 : $("#consultancyServices1").val());
	var value2 = parseFloat($("#consultancyServices2").val() == '' ? 0 : $("#consultancyServices2").val());
	var value3 = parseFloat($("#consultancyServices3").val() == '' ? 0 : $("#consultancyServices3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#TotalconsultancyServices").val(total);
}

//合计其他经费
function sumotherFunds() {
	var value1 = parseFloat($("#otherFunds1").val() == '' ? 0 : $("#otherFunds1").val());
	var value2 = parseFloat($("#otherFunds2").val() == '' ? 0 : $("#otherFunds2").val());
	var value3 = parseFloat($("#otherFunds3").val() == '' ? 0 : $("#otherFunds3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#TotalotherFunds").val(total);
}

//合计total1
function sumTotal1() {
	// 设备费
	var value1 = parseFloat($("#equipmentCost1").val() == '' ? 0 : $("#equipmentCost1").val());
	// 材料费
	var value2 = parseFloat($("#materialFee1").val() == '' ? 0 : $("#materialFee1").val());
	// 测试化验加工费
	var value3 = parseFloat($("#testFee1").val() == '' ? 0 : $("#testFee1").val());
	// 燃料动力费
	var value4 = parseFloat($("#fuel1").val() == '' ? 0 : $("#fuel1").val());
	// 差旅调研费
	var value5 = parseFloat($("#travel1").val() == '' ? 0 : $("#travel1").val());
	// 会议交流费
	var value6 = parseFloat($("#conferenceFees1").val() == '' ? 0 : $("#conferenceFees1").val());
	// 劳务咨询费
	var value7 = parseFloat($("#consultancyServices1").val() == '' ? 0 : $("#consultancyServices1").val());
	// 其他经费
	var value8 = parseFloat($("#otherFunds1").val() == '' ? 0 : $("#otherFunds1").val());

	var total = value1 + value2 + value3 + value4 + value5 + value6 + value7 + value8;
	total=total.toFixed(4);
	$("#Total1").val(total);
}

//合计total2
function sumTotal2() {
	// 设备费
	var value1 = parseFloat($("#equipmentCost2").val() == '' ? 0 : $("#equipmentCost2").val());
	// 材料费
	var value2 = parseFloat($("#materialFee2").val() == '' ? 0 : $("#materialFee2").val());
	// 测试化验加工费
	var value3 = parseFloat($("#testFee2").val() == '' ? 0 : $("#testFee2").val());
	// 燃料动力费
	var value4 = parseFloat($("#fuel2").val() == '' ? 0 : $("#fuel2").val());
	// 差旅调研费
	var value5 = parseFloat($("#travel2").val() == '' ? 0 : $("#travel2").val());
	// 会议交流费
	var value6 = parseFloat($("#conferenceFees2").val() == '' ? 0 : $("#conferenceFees2").val());
	// 劳务咨询费
	var value7 = parseFloat($("#consultancyServices2").val() == '' ? 0 : $("#consultancyServices2").val());
	// 其他经费
	var value8 = parseFloat($("#otherFunds2").val() == '' ? 0 : $("#otherFunds2").val());

	var total = value1 + value2 + value3 + value4 + value5 + value6 + value7 + value8;
	total=total.toFixed(4);
	$("#Total2").val(total);
}

//合计total3
function sumTotal3() {
	// 设备费
	var value1 = parseFloat($("#equipmentCost3").val() == '' ? 0 : $("#equipmentCost3").val());
	// 材料费
	var value2 = parseFloat($("#materialFee3").val() == '' ? 0 : $("#materialFee3").val());
	// 测试化验加工费
	var value3 = parseFloat($("#testFee3").val() == '' ? 0 : $("#testFee3").val());
	// 燃料动力费
	var value4 = parseFloat($("#fuel3").val() == '' ? 0 : $("#fuel3").val());
	// 差旅调研费
	var value5 = parseFloat($("#travel3").val() == '' ? 0 : $("#travel3").val());
	// 会议交流费
	var value6 = parseFloat($("#conferenceFees3").val() == '' ? 0 : $("#conferenceFees3").val());
	// 劳务咨询费
	var value7 = parseFloat($("#consultancyServices3").val() == '' ? 0 : $("#consultancyServices3").val());
	// 其他经费
	var value8 = parseFloat($("#otherFunds3").val() == '' ? 0 : $("#otherFunds3").val());

	var total = value1 + value2 + value3 + value4 + value5 + value6 + value7 + value8;
	total=total.toFixed(4);
	$("#Total3").val(total);
}

//总合计
function sumTotal() {
	var value1 = parseFloat($("#Total1").val() == '' ? 0 : $("#Total1").val());
	var value2 = parseFloat($("#Total2").val() == '' ? 0 : $("#Total2").val());
	var value3 = parseFloat($("#Total3").val() == '' ? 0 : $("#Total3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#TotalAll").val(total);
}

	
$("#nextBtn1").bind("click", function() {
	// 设置左侧菜单
	upms.upmsUtils.setMenu();
	var actionUrl;
	if($("#isWriteFlag").val() == 1){
		actionUrl= path + "/api/report/tcompanyInfoAction!showCompanyInfo.action?now=" + new Date().getTime();
	}
	else{
		actionUrl= path + "/api/report/treviewCommentsAction!showTreviewCommentsNonTech.action?now=" + new Date().getTime();
	}

	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"projectId",targetid:"projectId",type:"text"},
	                 {name:"applyStatus",targetid:"applyStatus",type:"text"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

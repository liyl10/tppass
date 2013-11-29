// 网站根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();
		
		$("input[type='text']").each(function(){
			$(this).attr("disabled",true);
		});
		
		// 设定金额的初期值，如果为空的话设置为0
		// 产值
		defaultDataSet("production2");
		defaultDataSet("production1");
		defaultDataSet("production");
		// 所交税金
		defaultDataSet("payTaxes2");
		defaultDataSet("payTaxes1");
		defaultDataSet("payTaxes");
		// 净利润
		defaultDataSet("retainedProfits2");
		defaultDataSet("retainedProfits1");
		defaultDataSet("retainedProfits");
		// 创汇
		defaultDataSet("earnMoney2");
		defaultDataSet("earnMoney1");
		defaultDataSet("earnMoney");
		
		// 合计
		sumLocal();
		sumPay();
		sumProfits();
		sumEarn();
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

//产值近2年
$("#production2").bind("input propertychange", function() {
	sumLocal();
});
//产值近1年
$("#production1").bind("input propertychange", function() {
	sumLocal();
});
//产值当年
$("#production").bind("input propertychange", function() {
	sumLocal();
});
//所交税金近2年
$("#payTaxes2").bind("input propertychange", function() {
	sumPay();
});
//所交税金近1年
$("#payTaxes1").bind("input propertychange", function() {
	sumPay();
});
//所交税金当年
$("#payTaxes").bind("input propertychange", function() {
	sumPay();
});
//净利润近2年
$("#retainedProfits2").bind("input propertychange", function() {
	sumProfits();
});
//净利润近1年
$("#retainedProfits1").bind("input propertychange", function() {
	sumProfits();
});
//净利润当年
$("#retainedProfits").bind("input propertychange", function() {
	sumProfits();
});
//创汇近2年
$("#earnMoney2").bind("input propertychange", function() {
	sumEarn();
});
//创汇近1年
$("#earnMoney1").bind("input propertychange", function() {
	sumEarn();
});
//创汇当年
$("#earnMoney").bind("input propertychange", function() {
	sumEarn();
});

function sumLocal(){
	var value1 = parseFloat($("#production2").val() == '' ? 0 : $("#production2").val());
	var value2 = parseFloat($("#production1").val() == '' ? 0 : $("#production1").val());
	var value3 = parseFloat($("#production").val() == '' ? 0 : $("#production").val());
	var total = value1 + value2 + value3;
	var result=total.toFixed(4);
	$("#outputValueList").val(result);
	$("#summ4").val(result);
}

function sumPay(){
	var value1 = parseFloat($("#payTaxes2").val() == '' ? 0 : $("#payTaxes2").val());
	var value2 = parseFloat($("#payTaxes1").val() == '' ? 0 : $("#payTaxes1").val());
	var value3 = parseFloat($("#payTaxes").val() == '' ? 0 : $("#payTaxes").val());
	var total = value1 + value2 + value3;
	var result=total.toFixed(4);
	$("#payTaxesList").val(result);
	$("#summ3").val(result);
}

function sumProfits(){
	var value1 = parseFloat($("#retainedProfits2").val() == '' ? 0 : $("#retainedProfits2").val());
	var value2 = parseFloat($("#retainedProfits1").val() == '' ? 0 : $("#retainedProfits1").val());
	var value3 = parseFloat($("#retainedProfits").val() == '' ? 0 : $("#retainedProfits").val());
	var total = value1 + value2 + value3;
	var result=total.toFixed(4);
	$("#petainedList").val(result);
	$("#summ2").val(result);
}

function sumEarn(){
	var value1 = parseFloat($("#earnMoney2").val() == '' ? 0 : $("#earnMoney2").val());
	var value2 = parseFloat($("#earnMoney1").val() == '' ? 0 : $("#earnMoney1").val());
	var value3 = parseFloat($("#earnMoney").val() == '' ? 0 : $("#earnMoney").val());
	var total = value1 + value2 + value3;
	var result=total.toFixed(4);
	$("#earnMoneyList").val(result);
	$("#summ1").val(result);
}

//下一步--詳細
$("#nextBtn").bind("click", function() {
	// 设置左侧菜单状态
	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/report/teconomicIndicatorAAction!initHighTech.action?now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name : "projectId",targetid : "projectId",type : "text"}, 
	                 {name : "applyStatus",targetid : "applyStatus",type : "text"}];
	
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});
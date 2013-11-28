// 网站根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();

		$("input[type='text']").each(function(){
			$(this).attr("disabled",true);
		});

		// 设定金额的初期值，如果为空的话设置为0
		// 新增投资
		defaultDataSet("newInvest2");
		defaultDataSet("newInvest1");
		defaultDataSet("newInvest");
		// 缴税
		defaultDataSet("payTaxes2");
		defaultDataSet("payTaxes1");
		defaultDataSet("payTaxes");
		// 净利润
		defaultDataSet("retainedProfits2");
		defaultDataSet("retainedProfits1");
		defaultDataSet("retainedProfits");
		// 资产规模
		defaultDataSet("assetSize2");
		defaultDataSet("assetSize1");
		defaultDataSet("assetSize");
		// 新增就业人数
		defaultDataSet("newEmployment2");
		defaultDataSet("newEmployment1");
		defaultDataSet("newEmployment");

		// 合计
		sumLocal();
		sumPay();
		sumProfits();
		sumEarn();
		sumEmployment();
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
$("#newInvest2").bind("input propertychange", function() {
	sumLocal();
});
//产值近1年
$("#newInvest1").bind("input propertychange", function() {
	sumLocal();
});
//产值当年
$("#newInvest").bind("input propertychange", function() {
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
//资产规模近2年
$("#assetSize2").bind("input propertychange", function() {
	sumEarn();
});
//资产规模近1年
$("#assetSize1").bind("input propertychange", function() {
	sumEarn();
});
//资产规模当年
$("#assetSize").bind("input propertychange", function() {
	sumEarn();
});
//新增就业人数近2年
$("#newEmployment2").bind("input propertychange", function() {
	sumEmployment();
});
//新增就业人数近1年
$("#newEmployment1").bind("input propertychange", function() {
	sumEmployment();
});
//新增就业人数当年
$("#newEmployment").bind("input propertychange", function() {
	sumEmployment();
});

function sumLocal(){
	var value1 = parseFloat($("#newInvest2").val() == '' ? 0 : $("#newInvest2").val());
	var value2 = parseFloat($("#newInvest1").val() == '' ? 0 : $("#newInvest1").val());
	var value3 = parseFloat($("#newInvest").val() == '' ? 0 : $("#newInvest").val());
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
	var value1 = parseFloat($("#assetSize2").val() == '' ? 0 : $("#assetSize2").val());
	var value2 = parseFloat($("#assetSize1").val() == '' ? 0 : $("#assetSize1").val());
	var value3 = parseFloat($("#assetSize").val() == '' ? 0 : $("#assetSize").val());
	var total = value1 + value2 + value3;
	var result=total.toFixed(4);
	$("#earnMoneyList").val(result);
	$("#summ1").val(result);
}

function sumEmployment(){
	var value1 = parseFloat($("#newEmployment2").val() == '' ? 0 : $("#newEmployment2").val());
	var value2 = parseFloat($("#newEmployment1").val() == '' ? 0 : $("#newEmployment1").val());
	var value3 = parseFloat($("#newEmployment").val() == '' ? 0 : $("#newEmployment").val());
	var total = value1 + value2 + value3;
	var result=total.toFixed(4);
	$("#newEmploymentList").val(result);
	$("#summ").val(result);
}

// 下一步--詳細
$("#nextBtn").bind("click", function() {
	// 设置左侧菜单状态
	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/report/treportobjectives!showTreportObjectives.action?now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name : "projectId",targetid : "projectId",type : "text"}, 
	                 {name : "applyStatus",targetid : "applyStatus",type : "text"}];
	
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});
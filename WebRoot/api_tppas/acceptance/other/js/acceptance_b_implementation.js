
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();

		$("input[type='text']").each(function(){
			$(this).attr("disabled",true);
		});

		// 设定金额的初期值，如果为空的话设置为0
		defaultDataSet("planFundsTotalNum");
		defaultDataSet("actualFundsTotalNum");
		defaultDataSet("planFundsCityNum");
		defaultDataSet("actualFundsCityNum");
		defaultDataSet("planRaisedNum");
		defaultDataSet("actualRaisedNum");
		defaultDataSet("planBankNum");
		defaultDataSet("actualBankNum");
		defaultDataSet("planLoanInterestNum");
		defaultDataSet("actualLoanInterestNum");
		defaultDataSet("planOtherNum");
		defaultDataSet("actualOtherNum");
		defaultDataSet("conventionsSales");
		defaultDataSet("completeSales");
		defaultDataSet("conventionsProfitTotal");
		defaultDataSet("completeProfitTotal");
		defaultDataSet("conventionsTaxTotal");
		defaultDataSet("completeTaxTotal");
		defaultDataSet("conventionsForeignExchange");
		defaultDataSet("completeForeignExchange");
		defaultDataSet("totalStaffCosts");
		defaultDataSet("totalDeviceCosts");
		defaultDataSet("totalEnergyCosts");
		defaultDataSet("totalExperimentCosts");
		defaultDataSet("totalResearchCosts");
		defaultDataSet("totalTravelCosts");
		defaultDataSet("totalMeetingCosts");
		defaultDataSet("totalManageCosts");
		defaultDataSet("totalOtherCosts");
		defaultDataSet("cityTotalStaffCosts");
		defaultDataSet("cityDeviceCosts");
		defaultDataSet("cityEnergyCosts");
		defaultDataSet("cityExperimentCosts");
		defaultDataSet("cityResearchCosts");
		defaultDataSet("cityTravelCosts");
		defaultDataSet("cityMeetingCosts");
		defaultDataSet("cityManageCosts");
		defaultDataSet("cityOtherCosts");
		//总经费使用情况合计
		sumtotalment();
		//市拨经费使用情况合计
		sumcityTotalment();
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

//总经费使用情况合计
function sumtotalment(){
	var value1 = parseFloat($("#totalStaffCosts").val() == '' ? 0 : $("#totalStaffCosts").val());
	var value2 = parseFloat($("#totalDeviceCosts").val() == '' ? 0 : $("#totalDeviceCosts").val());
	var value3 = parseFloat($("#totalEnergyCosts").val() == '' ? 0 : $("#totalEnergyCosts").val());
	var value4 = parseFloat($("#totalExperimentCosts").val() == '' ? 0 : $("#totalExperimentCosts").val());
	var value5 = parseFloat($("#totalResearchCosts").val() == '' ? 0 : $("#totalResearchCosts").val());
	var value6 = parseFloat($("#totalTravelCosts").val() == '' ? 0 : $("#totalTravelCosts").val());
	var value7 = parseFloat($("#totalMeetingCosts").val() == '' ? 0 : $("#totalMeetingCosts").val());
	var value8 = parseFloat($("#totalManageCosts").val() == '' ? 0 : $("#totalManageCosts").val());
	var value9 = parseFloat($("#totalOtherCosts").val() == '' ? 0 : $("#totalOtherCosts").val());
	var total = value1+value2+value3+value4+value5+value6+value7+value8+value9;
	var result=total.toFixed(4);
	$("#totalTotalCosts").val(result);
	$("#summ1").val(result);
}

//市拨经费使用情况合计
function sumcityTotalment(){
	var value1 = parseFloat($("#cityTotalStaffCosts").val() == '' ? 0 : $("#cityTotalStaffCosts").val());
	var value2 = parseFloat($("#cityDeviceCosts").val() == '' ? 0 : $("#cityDeviceCosts").val());
	var value3 = parseFloat($("#cityEnergyCosts").val() == '' ? 0 : $("#cityEnergyCosts").val());
	var value4 = parseFloat($("#cityExperimentCosts").val() == '' ? 0 : $("#cityExperimentCosts").val());
	var value5 = parseFloat($("#cityResearchCosts").val() == '' ? 0 : $("#cityResearchCosts").val());
	var value6 = parseFloat($("#cityTravelCosts").val() == '' ? 0 : $("#cityTravelCosts").val());
	var value7 = parseFloat($("#cityMeetingCosts").val() == '' ? 0 : $("#cityMeetingCosts").val());
	var value8 = parseFloat($("#cityManageCosts").val() == '' ? 0 : $("#cityManageCosts").val());
	var value9 = parseFloat($("#cityOtherCosts").val() == '' ? 0 : $("#cityOtherCosts").val());
	var total = value1+value2+value3+value4+value5+value6+value7+value8+value9;
	var result=total.toFixed(4);
	$("#cityTotalCosts").val(result);
	$("#summ2").val(result);
}

//下一步页面跳转
$("#nextBtn").bind("click", function() {
	// 设置左边菜单样式
	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/acceptance/TacceptanceAchievementBAction!showAchievementB.action?acceptanceId="+$("#acceptanceId").val()+"&acceptanceStatus="+$("#acceptanceStatus").val()+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

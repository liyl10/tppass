
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();

		$("input[type='text']").each(function(){
			$(this).attr("disabled",true);
		});
		 
		 // 设定金额的初期值，如果为空时设置为0
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
		 defaultDataSet("totalTotalCosts");
		 defaultDataSet("cityTotalCosts");
		 defaultDataSet("totalStaffCosts");
		 defaultDataSet("cityStaffCosts");
		 defaultDataSet("totalDeviceCosts");
		 defaultDataSet("cityDeviceCosts");
		 defaultDataSet("totalEnergyCosts");
		 defaultDataSet("cityEnergyCosts");
		 defaultDataSet("totalExperimentCosts");
		 defaultDataSet("cityExperimentCosts");
		 defaultDataSet("totalResearchCosts");
		 defaultDataSet("cityResearchCosts");
		 defaultDataSet("totalTravelCosts");
		 defaultDataSet("cityTravelCosts");
		 defaultDataSet("totalMeetingCosts");
		 defaultDataSet("cityMeetingCosts");
		 defaultDataSet("totalManageCosts");
		 defaultDataSet("cityManageCosts");
		 defaultDataSet("totalOtherCosts");
		 defaultDataSet("cityOtherCosts");
		 defaultDataSet("totalRdCosts");
		 defaultDataSet("cityRdCosts");
	});
});

// 设置默认画面初期化时金额的默认值为0
function defaultDataSet(id){
	var value = $("#" + id).val();
	if(value == null || value=="")
	{
		$("#" + id).val("0");
	}
}


// 下一步按钮-详细
$("#nextBtn").bind("click", function() {
		// 设置左边菜单样式
		upms.upmsUtils.setMenu();
		var actionUrl= path + "/api/acceptance/completeA!completeInit.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"acceptanceId",targetid:"acceptanceId",type:"text"},
		                 {name:"acceptanceStatus",targetid:"acceptanceStatus",type:"text"}];

		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
});
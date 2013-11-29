
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();

		$("input[type='text']").each(function(){
			$(this).attr("disabled",true);
		});
		
		defaultDataSet("gudgetTotalInvestment");
		defaultDataSet("accountsTotalInvestment");
		defaultDataSet("gudgetPartyFunding");
		defaultDataSet("accountsPartyFunding");
		defaultDataSet("gudgetOther");
		defaultDataSet("accountsOther");
		defaultDataSet("gudgetRaised");
		defaultDataSet("accountsRaised");
		defaultDataSet("gudgetBank");
		defaultDataSet("accountsBank");
		defaultDataSet("staffCosts1");
		defaultDataSet("staffCosts2");
		defaultDataSet("staffCosts3");
		defaultDataSet("staffCostsTotal");
		defaultDataSet("deviceCosts1");
		defaultDataSet("deviceCosts2");
		defaultDataSet("deviceCosts3");
		defaultDataSet("deviceCostsTotal");
		defaultDataSet("energyCosts1");
		defaultDataSet("energyCosts2");
		defaultDataSet("energyCosts3");
		defaultDataSet("energyCostsTotal");
		defaultDataSet("experimentCosts1");
		defaultDataSet("experimentCosts2");
		defaultDataSet("experimentCosts3");
		defaultDataSet("experimentCostsTotal");
		defaultDataSet("researchCosts1");
		defaultDataSet("researchCosts2");
		defaultDataSet("researchCosts3");
		defaultDataSet("researchCostsTotal");
		defaultDataSet("travelCosts1");
		defaultDataSet("travelCosts2");
		defaultDataSet("travelCosts3");
		defaultDataSet("travelCostsTotal");
		defaultDataSet("meetingCosts1");
		defaultDataSet("meetingCosts2");
		defaultDataSet("meetingCosts3");
		defaultDataSet("meetingCostsTotal");
		defaultDataSet("manageCosts1");
		defaultDataSet("manageCosts2");
		defaultDataSet("manageCosts3");
		defaultDataSet("manageCostsTotal");
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
	var actionUrl= path + "/api/acceptance/acceptance!highTechIndex.action?now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"acceptanceId",targetid:"acceptanceId",type:"text"},
	                 {name:"acceptanceStatus",targetid:"acceptanceStatus",type:"text"}];

	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});
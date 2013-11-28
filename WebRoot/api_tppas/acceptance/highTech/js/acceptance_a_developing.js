
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();

		$("input[type='text']").each(function(){
			$(this).attr("disabled",true);
		});

		 defaultDataSet("projectTotal");
		 defaultDataSet("projectNet");
		 defaultDataSet("projectExport");
		 defaultDataSet("projectSales");
		 defaultDataSet("projectTaxableTotal");
		 defaultDataSet("projectRdInvestment");
		 defaultDataSet("acceptanceTotal");
		 defaultDataSet("acceptanceNet");
		 defaultDataSet("acceptanceExport");
		 defaultDataSet("acceptanceSales");
		 defaultDataSet("acceptanceTaxableTotal");
		 defaultDataSet("acceptanceRdInvestment");
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
	var actionUrl= path + "/api/acceptance/opinionA!accOpinionInit.action?now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"acceptanceId",targetid:"acceptanceId",type:"text"},
	                 {name:"acceptanceStatus",targetid:"acceptanceStatus",type:"text"}];

	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});
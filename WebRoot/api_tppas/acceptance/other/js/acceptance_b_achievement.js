
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();
		
		$("input[type='text']").each(function(){
			$(this).attr("disabled",true);
		});
		$("textarea").each(function(){
			$(this).attr("readonly",true);
			$(this).css('background-color','#F0F0F0');
		});

		// 设定金额的初期值，如果为空的话设置为0
		defaultDataSet("fundsAmount1");
		defaultDataSet("fundsAmount2");
		defaultDataSet("companyAmount1");
		defaultDataSet("companyAmount2");
		defaultDataSet("projectNet");
		defaultDataSet("projectBusinessNet");
		defaultDataSet("projectTotal");
		defaultDataSet("projectExport");
		defaultDataSet("projectSales");
		defaultDataSet("projectMainIncome");
		defaultDataSet("projectTaxableTotal");
		defaultDataSet("projectActualTaxTotal");
		defaultDataSet("projectRdInvestment");
		defaultDataSet("acceptanceTotal");
		defaultDataSet("acceptanceNet");
		defaultDataSet("acceptanceExport");
		defaultDataSet("acceptanceBusinessNet");
		defaultDataSet("acceptanceSales");
		defaultDataSet("acceptanceMainIncome");
		defaultDataSet("acceptanceTaxableTotal");
		defaultDataSet("acceptanceActualTaxTotal");
		defaultDataSet("acceptanceRdInvestment");
		
		//已获得知识产权数量 总数 
		sumReceivement();
		//已申请知识产权数量 总数
		sumTotalment();
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

//已获得知识产权数量 总数
function sumReceivement(){
	var value1 = parseFloat($("#receivePatentNum").val() == '' ? 0 : $("#receivePatentNum").val());
	var value2 = parseFloat($("#receiveUtilityNum").val() == '' ? 0 : $("#receiveUtilityNum").val());
	var value3 = parseFloat($("#receiveDesignsNum").val() == '' ? 0 : $("#receiveDesignsNum").val());
	var value4 = parseFloat($("#receiveCopyrightNum").val() == '' ? 0 : $("#receiveCopyrightNum").val());
	var value5 = parseFloat($("#receiveForeignNum").val() == '' ? 0 : $("#receiveForeignNum").val());
	var total = value1+value2+value3+value4+value5;
	$("#havaNumList").val(total);
	$("#summ1").val(total);
}

//已申请知识产权数量 总数
function sumTotalment(){
	var value1 = parseFloat($("#applyPatentNum").val() == '' ? 0 : $("#applyPatentNum").val());
	var value2 = parseFloat($("#applyUtilityNum").val() == '' ? 0 : $("#applyUtilityNum").val());
	var value3 = parseFloat($("#applyDesignsNum").val() == '' ? 0 : $("#applyDesignsNum").val());
	var value4 = parseFloat($("#applyCopyrightNum").val() == '' ? 0 : $("#applyCopyrightNum").val());
	var value5 = parseFloat($("#applyForeignNum").val() == '' ? 0 : $("#applyForeignNum").val());
	var total = value1+value2+value3+value4+value5;
	$("#reportNumList").val(total);
	$("#summ2").val(total);
}

//下一步页面跳转
$("#nextBtn").bind("click", function() {
	// 设置左边菜单样式
	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/acceptance/TacceptanceSummaryBAction!showAcceptanceSummaryB.action?acceptanceId="+$("#acceptanceId").val()+"&acceptanceStatus="+$("#acceptanceStatus").val()+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});


// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		// 设定金额的初期值，如果为空的话设置为0
		// 总投资
		defaultDataSet("totalInvestment1");
		defaultDataSet("totalInvestment2");
		defaultDataSet("totalInvestment3");
		// 甲方拨款
		defaultDataSet("partyFunding1");
		defaultDataSet("partyFunding2");
		defaultDataSet("partyFunding3");
		// 单位自筹
		defaultDataSet("unitRaised1");
		defaultDataSet("unitRaised2");
		defaultDataSet("unitRaised3");
		// 其他经费
		defaultDataSet("otherFunds1");
		defaultDataSet("otherFunds2");
		defaultDataSet("otherFunds3");
		// 银行贷款
		defaultDataSet("bankLoans1");
		defaultDataSet("bankLoans2");
		defaultDataSet("bankLoans3");
		// 合计
		defaultDataSet("totalInvestmentTotal");
		defaultDataSet("partyFundingTotal");
		defaultDataSet("unitRaisedTotal");
		defaultDataSet("otherFundsTotal");
		defaultDataSet("bankLoansTotal");
		
		//合计
		sumInvestment();
		sumpartyFunding();
		sumunitRaised();
		sumotherFunds();
		sumbankLoans();
		
		// 禁止输入
		var idList = $("input[type='text']");
		for ( var i = 0; i < idList.length; i++) {
			var id = idList.eq(i).attr("id");
			$("#" + id).attr("disabled", true);
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
	$("#totalInvestmentTotal").val(total);
}
//合计甲方拨款
function sumpartyFunding() {
	var value1 = parseFloat($("#partyFunding1").val() == '' ? 0 : $("#partyFunding1").val());
	var value2 = parseFloat($("#partyFunding2").val() == '' ? 0 : $("#partyFunding2").val());
	var value3 = parseFloat($("#partyFunding3").val() == '' ? 0 : $("#partyFunding3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(2);
	$("#partyFundingTotal").val(total);
}
//合计单位自筹
function sumunitRaised() {
	var value1 = parseFloat($("#unitRaised1").val() == '' ? 0 : $("#unitRaised1").val());
	var value2 = parseFloat($("#unitRaised2").val() == '' ? 0 : $("#unitRaised2").val());
	var value3 = parseFloat($("#unitRaised3").val() == '' ? 0 : $("#unitRaised3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(2);
	$("#unitRaisedTotal").val(total);
}
//合计其他经费
function sumotherFunds() {
	var value1 = parseFloat($("#otherFunds1").val() == '' ? 0 : $("#otherFunds1").val());
	var value2 = parseFloat($("#otherFunds2").val() == '' ? 0 : $("#otherFunds2").val());
	var value3 = parseFloat($("#otherFunds3").val() == '' ? 0 : $("#otherFunds3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(2);
	$("#otherFundsTotal").val(total);
}
//合计银行贷款
function sumbankLoans() {
	var value1 = parseFloat($("#bankLoans1").val() == '' ? 0 : $("#bankLoans1").val());
	var value2 = parseFloat($("#bankLoans2").val() == '' ? 0 : $("#bankLoans2").val());
	var value3 = parseFloat($("#bankLoans3").val() == '' ? 0 : $("#bankLoans3").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(2);
	$("#bankLoansTotal").val(total);
}

/**
 * 下一步按钮功能
 */
$("#nextBtn1").bind("click", function(){
	// 设置左侧菜单
	upms.upmsUtils.setMenu();
	
	var actionUrl= path + "/api/report/tfundingPlanReportAction!execute.action?now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"projectId",targetid:"projectId",type:"text"},
	                 {name:"applyStatus",targetid:"applyStatus",type:"text"}];
	
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
	
});
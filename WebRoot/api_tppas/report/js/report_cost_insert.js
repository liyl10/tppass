// 网站根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();
		// 画面禁止输入
		$("input[type='text']").each(function(){
			$(this).attr("disabled",true);
		});
		// 设定金额的初期值，如果为空的话设置为0
		// 总投入
		defaultDataSet("totalInvestment");
		// 申请专项经费
		defaultDataSet("applicationSpecial");
		// 自筹资金金额
		defaultDataSet("selfRaisedFunds");
		// 总额
		defaultDataSet("totalBankersCredit");
		// 其他资金金额
		defaultDataSet("otherFunds");
		// 已落实贷款
		defaultDataSet("bankersCredit");
		// 产业处
		if($("#tempFlg").val() == "1") {
		// 配套资金金额
		defaultDataSet("supportFunds");
		}
		// 绑定值变化事件
		$("input[autoSum]").each(function(){
			bindValueChange(this);
		});
		
		// 自动计算1
		// autoMinus();
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

/**
 * 绑定值变化事件
 */
function bindValueChange(now){
	$("#" + now.id).bind("input propertychange", function() {
		autoMinus();
	});
}

/**
 * 自动计算
 */
function autoMinus(){
	var inValueList;
	if($("#tempFlg").val() == "1") {
		inValueList = new Array("applicationSpecial","totalBankersCredit","supportFunds","otherFunds");
	}
	else{
		inValueList = new Array("applicationSpecial","totalBankersCredit","otherFunds");
	}
	
	var outValue = upms.upmsUtils.autoCal(inValueList, 4);
	var sumValue = parseFloat($("#totalInvestment").val() == '' ? 0 : $("#totalInvestment").val());
	if(outValue > sumValue){
		$("#erroroutValue").remove();
		var span = $("<div id='erroroutValue'><span style='color:red;'>各分项金额总和不能大于总投入！</span></div>");
		$("#totalInvestment").parent().append(span);
		$("#totalInvestmentFlag").attr("value", 1);
	}
	else{
		$("#erroroutValue").remove();
		$("#totalInvestmentFlag").attr("value", 0);
	}
	$("#selfRaisedFunds").attr("value", (sumValue - outValue).toFixed(4));
}

function nextBtn(tempFlg){
	// 设置左侧菜单状态
	upms.upmsUtils.setMenu();
	var actionUrl= path;
	if (tempFlg == "1") {
		// 产业处
		actionUrl = actionUrl + "/api/report/tfinancingUseAction!showTfinancingUse.action?now="+new Date().getTime();
	} else {
		actionUrl = actionUrl + "/api/report/fundplanb!showFundPlanB.action?now="+new Date().getTime();
	}
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name : "projectId",targetid : "projectId",type : "text"},
	                 {name : "applyStatus",targetid : "applyStatus",type : "text"}];
	
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}
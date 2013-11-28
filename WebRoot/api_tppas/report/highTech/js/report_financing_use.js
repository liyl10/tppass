// 网站根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();

		$("input[moneyFlag='money']").each(function(){
			if($(this).val() == ""){
				$(this).attr("value", 0);
			}
		});
		
		// 初始化下拉列表		
		if($("#applyStatus").val() == 0){
			$("input[type='text']").each(function(){
				$(this).attr("disabled",true);
			});
		}
		
		// 绑定值变化事件
		$("input[autoSum]").each(function(){
			bindAutoSum(this.id, $(this).attr("autoSum"));
		});
		
		// 自动计算1 自筹资金
		autoSum1();
		
		// 自动计算2
		autoSum2();
		
		// 自动计算3
		autoSum3();
		
		// 自动计算4
		autoSum4();
		
		// 自动计算5 专项资金
		autoSum5();
		
		// 自动计算6 配套资金
		autoSum6();
		
		// 自动计算7 购置设备费
		autoSum7();
		
		// 自动计算8  试制设备费
		autoSum8();
		
		// 自动计算9  设备改造与租赁费
		autoSum9();
		
		// 自动计算10 材料费
		autoSum10();
		
		// 自动计算11 测试化验加工费
		autoSum11();
		
		// 自动计算12 会议费
		autoSum12();
		
		// 自动计算13国际合作与交流费
		autoSum13();
		
		// 自动计算14 出版/文献/信息传播/知识产权事务费
		autoSum14();
		
		// 自动计算15 专家咨询费
		autoSum15();
		
		// 自动计算16 总合计
		autoSum16();
		
		// 自动计算17 设备费 自筹资金
		autoSum17();
		
		// 自动计算18  设备费 专项资金
		autoSum18();
		
		// 自动计算19  设备费 配套资金
		autoSum19();
		
		// 自动计算20  设备费 合计
		autoSum20();
	});
});

/**
 * 自动计算1()
 */
function autoSum1(自筹资金){
	
	var inValueList = new Array();
	$("input[autoSum='1']").each(function(){
		inValueList[inValueList.length] = this.id;
	});
	var outValue = upms.upmsUtils.autoCal(inValueList, 4);
	$("#selfTotal").attr("value", outValue);
}

/**
 * 自动计算2
 */
function autoSum2(){
	
	var inValueList = new Array("paymentAmount","paymentAmounta","paymentAmountb");
	var outValue = upms.upmsUtils.autoCal(inValueList, 4);
	$("#paymentAmountTotal").attr("value", outValue);
}

/**
 * 自动计算3
 */
function autoSum3(){
	
	var inValueList = new Array("specialAmount","specialAmount1","specialAmount2");
	var outValue = upms.upmsUtils.autoCal(inValueList, 4);
	$("#specialAmountTotal").attr("value", outValue);
}

/**
 * 自动计算4
 */
function autoSum4(){
	
	var inValueList = new Array("otherFunds","otherFunds1","otherFunds2");
	var outValue = upms.upmsUtils.autoCal(inValueList, 4);
	$("#otherFundsTotal").attr("value", outValue);
}

/**
 * 自动计算5(专项资金)
 */
function autoSum5(){
	var inValueList = new Array();
	$("input[autoSum='5']").each(function(){
		inValueList[inValueList.length] = this.id;
	});
	var outValue = upms.upmsUtils.autoCal(inValueList, 4);
	$("#specialTotal").attr("value", outValue);
}

/**
 * 自动计算6(配套资金)
 */
function autoSum6(){
	var inValueList = new Array();
	$("input[autoSum='6']").each(function(){
		inValueList[inValueList.length] = this.id;
	});
	var outValue = upms.upmsUtils.autoCal(inValueList, 4);
	$("#supportTotal").attr("value", outValue);
}

/**
 * 自动计算7( 购置设备费)
 */
function autoSum7(){
	var value1 = parseFloat($("#purchaseSpecial").val() == '' ? 0 : $("#purchaseSpecial").val());
	var value2 = parseFloat($("#purchaseSupport").val() == '' ? 0 : $("#purchaseSupport").val());
	var value3 = parseFloat($("#purchaseSelf").val() == '' ? 0 : $("#purchaseSelf").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#purchaseTotal").val(total);
}

/**
 * 自动计算8( 试制设备费)
 */
function autoSum8(){
	var value1 = parseFloat($("#trialSpecial").val() == '' ? 0 : $("#trialSpecial").val());
	var value2 = parseFloat($("#trialSupport").val() == '' ? 0 : $("#trialSupport").val());
	var value3 = parseFloat($("#trialSelf").val() == '' ? 0 : $("#trialSelf").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#trialTotal").val(total);
}

/**
 * 自动计算9( 设备改造与租赁费)
 */
function autoSum9(){
	var value1 = parseFloat($("#renovationSpecial").val() == '' ? 0 : $("#renovationSpecial").val());
	var value2 = parseFloat($("#renovationSupport").val() == '' ? 0 : $("#renovationSupport").val());
	var value3 = parseFloat($("#renovationSelf").val() == '' ? 0 : $("#renovationSelf").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#renovationTotal").val(total);
}

/**
 * 自动计算10( 材料费)
 */
function autoSum10(){
	var value1 = parseFloat($("#materialSpecial").val() == '' ? 0 : $("#materialSpecial").val());
	var value2 = parseFloat($("#materialSupport").val() == '' ? 0 : $("#materialSupport").val());
	var value3 = parseFloat($("#materialSelf").val() == '' ? 0 : $("#materialSelf").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#materialTotal").val(total);
}

/**
 * 自动计算11( 测试化验加工费)
 */
function autoSum11(){
	var value1 = parseFloat($("#testSpecial").val() == '' ? 0 : $("#testSpecial").val());
	var value2 = parseFloat($("#testSupport").val() == '' ? 0 : $("#testSupport").val());
	var value3 = parseFloat($("#testSelf").val() == '' ? 0 : $("#testSelf").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#testTotal").val(total);
}

// 自动计算12 会议费
function autoSum12(){
	var value1 = parseFloat($("#meetSpecial").val() == '' ? 0 : $("#meetSpecial").val());
	var value2 = parseFloat($("#meetSupport").val() == '' ? 0 : $("#meetSupport").val());
	var value3 = parseFloat($("#meetSelf").val() == '' ? 0 : $("#meetSelf").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#meetTotal").val(total);
}

// 自动计算13国际合作与交流费
function autoSum13(){
	var value1 = parseFloat($("#cooperationSpecial").val() == '' ? 0 : $("#cooperationSpecial").val());
	var value2 = parseFloat($("#cooperationSupport").val() == '' ? 0 : $("#cooperationSupport").val());
	var value3 = parseFloat($("#cooperationSelf").val() == '' ? 0 : $("#cooperationSelf").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#cooperationTotal").val(total);
}

// 自动计算14 出版/文献/信息传播/知识产权事务费
function autoSum14(){
	var value1 = parseFloat($("#publishSpecial").val() == '' ? 0 : $("#publishSpecial").val());
	var value2 = parseFloat($("#publishSupport").val() == '' ? 0 : $("#publishSupport").val());
	var value3 = parseFloat($("#publishSelf").val() == '' ? 0 : $("#publishSelf").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#publishTotal").val(total);
}

// 自动计算15 专家咨询费
function autoSum15(){
	var value1 = parseFloat($("#expertSpecial").val() == '' ? 0 : $("#expertSpecial").val());
	var value2 = parseFloat($("#expertSupport").val() == '' ? 0 : $("#expertSupport").val());
	var value3 = parseFloat($("#expertSelf").val() == '' ? 0 : $("#expertSelf").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#expertTotal").val(total);
}

// 自动计算16 总合计
function autoSum16(){
	var value1 = parseFloat($("#selfTotal").val() == '' ? 0 : $("#selfTotal").val());
	var value2 = parseFloat($("#specialTotal").val() == '' ? 0 : $("#specialTotal").val());
	var value3 = parseFloat($("#supportTotal").val() == '' ? 0 : $("#supportTotal").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#total").val(total);
}

// 自动计算17 设备费 自筹资金
function autoSum17(){
	var value1 = parseFloat($("#purchaseSelf").val() == '' ? 0 : $("#purchaseSelf").val());
	var value2 = parseFloat($("#trialSelf").val() == '' ? 0 : $("#trialSelf").val());
	var value3 = parseFloat($("#renovationSelf").val() == '' ? 0 : $("#renovationSelf").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#equipmentSelf").val(total);
}

// 自动计算18  设备费 专项资金
function autoSum18(){
	var value1 = parseFloat($("#purchaseSpecial").val() == '' ? 0 : $("#purchaseSpecial").val());
	var value2 = parseFloat($("#trialSpecial").val() == '' ? 0 : $("#trialSpecial").val());
	var value3 = parseFloat($("#renovationSpecial").val() == '' ? 0 : $("#renovationSpecial").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#equipmentSpecial").val(total);
}

// 自动计算19  设备费 配套资金
function autoSum19(){
	var value1 = parseFloat($("#purchaseSupport").val() == '' ? 0 : $("#purchaseSupport").val());
	var value2 = parseFloat($("#trialSupport").val() == '' ? 0 : $("#trialSupport").val());
	var value3 = parseFloat($("#renovationSupport").val() == '' ? 0 : $("#renovationSupport").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#equipmentSupport").val(total);
}

// 自动计算20  设备费 合计
function autoSum20(){
	var value1 = parseFloat($("#purchaseTotal").val() == '' ? 0 : $("#purchaseTotal").val());
	var value2 = parseFloat($("#trialTotal").val() == '' ? 0 : $("#trialTotal").val());
	var value3 = parseFloat($("#renovationTotal").val() == '' ? 0 : $("#renovationTotal").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#equipmentTotal").val(total);
}

/**
 * 绑定值变化事件
 * @param id
 * @param type
 */
function bindAutoSum(id, type){
	$("#" + id).bind("input propertychange", function() {
		if(type == 1){
			autoSum1();
		}
		else if(type == 2){
			autoSum2();
		}
		else if(type == 3){
			autoSum3();
		}
		else if(type == 4){
			autoSum4();
		}
		else if(type == 5){
			autoSum5();
		}
		else if(type == 6){
			autoSum6();
		}
		
		if(type == 1 || type == 5 || type == 6){
			// 自动计算7 购置设备费
			autoSum7();
			
			// 自动计算8  试制设备费
			autoSum8();
			
			// 自动计算9  设备改造与租赁费
			autoSum9();
			
			// 自动计算10 材料费
			autoSum10();
			
			// 自动计算11 测试化验加工费
			autoSum11();
			
			// 自动计算12 会议费
			autoSum12();
			
			// 自动计算13国际合作与交流费
			autoSum13();
			
			// 自动计算14 出版/文献/信息传播/知识产权事务费
			autoSum14();
			
			// 自动计算15 专家咨询费
			autoSum15();
			
			// 自动计算16 总合计
			autoSum16();
			
			// 自动计算17 设备费 自筹资金
			autoSum17();
			
			// 自动计算18  设备费 专项资金
			autoSum18();
			
			// 自动计算19  设备费 配套资金
			autoSum19();
			
			// 自动计算20  设备费 合计
			autoSum20();
		}
	});
}

// 删除资金主要用途
var delCapitalIdCount = 0;
function del(nowTr,flag,financingUseId){
	if (confirm($("#comfirmDelete").text())){
		if(flag == 1){
			var hidden = $("<div><input type='hidden' id='inancingUseId"+delCapitalIdCount+"' name='delCapitalIdList["+ delCapitalIdCount+"]' value='"+financingUseId+"'/></div>");
			delCapitalIdCount++;
			var domObject = $("#paymentAmount2").get(0);
			$(domObject).parent().append(hidden);
		}  
		$(nowTr).parent().parent().parent().remove();
		
		// 自动计算
		autoSum1();
		// 自动计算5
		autoSum5();
	}else{
		return false;
	}
} 

/**
 * 下一步按钮功能
 */
$("#nextBtn1").bind("click", function(){
	
	// 设置左侧菜单
	upms.upmsUtils.setMenu();
	var actionUrl;
	if($("#isWriteFlag").val() == 1){
		actionUrl= path + "/api/report/tcompanyInfoAction!showCompanyInfo.action?now=" + new Date().getTime();
	} else{
		actionUrl= path + "/api/report/treviewCommentsAction!showTreviewCommentsNonTech.action?now=" + new Date().getTime();
	}
	//alert(actionUrl);
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"projectId",targetid:"projectId",type:"text"},
	                 {name:"applyStatus",targetid:"applyStatus",type:"text"}];

	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
	
});
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
		$("input[type='text']").each(function(){
			$(this).attr("disabled",true);
		});
		
		// 绑定值变化事件
		$("input[autoSum]").each(function(){
			bindAutoSum(this.id, $(this).attr("autoSum"));
		});
		
		// 自动计算1
		autoSum1();
		
		// 自动计算2
		autoSum2();
		
		// 自动计算3
		autoSum3();
		
		// 自动计算4
		autoSum4();
	});
});

/**
 * 自动计算1
 */
function autoSum1(){
	var inValueList = new Array("selfRaisedFunds","specialAmount0","selfRaisedFundsList");
	var outValue = upms.upmsUtils.autoCal(inValueList, 4);
	$("#specialAmountList").attr("value", outValue);
}

/**
 * 自动计算2
 */
function autoSum2(){
	
	var inValueList = new Array("paymentAmount","paymentAmount1","paymentAmount2");
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
		else{
			autoSum4();
		}
	});
}

/**
 * 下一步按钮功能
 */
$("#nextBtn").bind("click", function(){
	// 设置左侧菜单
	upms.upmsUtils.setMenu();
	
	var actionUrl= path + "/api/report/treviewCommentsAction!showTreviewCommentsNonTech.action?now="+new Date().getTime();
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
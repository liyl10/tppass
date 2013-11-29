// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		// 设定金额的初期值，如果为空的话设置为0
		// 计划投资总额
		defaultDataSet("planInvestment");
		// 目前已完成投资
		defaultDataSet("completeInvestment");
		// 其中:企业自筹
		defaultDataSet("contractSelf");
		// 其中:企业自筹
		defaultDataSet("realSelf");
		// 贷款
		defaultDataSet("contractLoan");
		// 贷款
		defaultDataSet("realLoan");
		// 财政资金
		defaultDataSet("contractFinancial");
		// 财政资金
		defaultDataSet("realFinancial");
		// 配套资金
		defaultDataSet("contractSupporting");
		// 配套资金
		defaultDataSet("realSupporting");
		// 其它
		defaultDataSet("contractOther");
		// 其它
		defaultDataSet("realOther");
		// 人员费
		defaultDataSet("personnelCost");
		// 设备费
		defaultDataSet("equipmentCost");
		// 能源材料费
		defaultDataSet("energyCost");
		// 试验及外协费
		defaultDataSet("testCost");
		// 差旅费
		defaultDataSet("travelCost");
		// 会议费
		defaultDataSet("meetingCost");
		// 管理费
		defaultDataSet("managerCost");
		// 其它费用
		defaultDataSet("otherCost");
		// 合计
		defaultDataSet("totalCost");
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

function sumFunds(){
	var personnelCost = parseFloat($("#personnelCost").val() == '' ? 0 : $("#personnelCost").val());
	var equipmentCost = parseFloat($("#equipmentCost").val() == '' ? 0 : $("#equipmentCost").val());
	var energyCost = parseFloat($("#energyCost").val() == '' ? 0 : $("#energyCost").val());
	var testCost = parseFloat($("#testCost").val() == '' ? 0 : $("#testCost").val());
	var travelCost = parseFloat($("#travelCost").val() == '' ? 0 : $("#travelCost").val());
	var meetingCost = parseFloat($("#meetingCost").val() == '' ? 0 : $("#meetingCost").val());
	var managerCost = parseFloat($("#managerCost").val() == '' ? 0 : $("#managerCost").val());
	var otherCost = parseFloat($("#otherCost").val() == '' ? 0 : $("#otherCost").val());
	var total = personnelCost+equipmentCost+energyCost+testCost+travelCost+meetingCost+managerCost+otherCost;
	var result=total.toFixed(2);
	$("#totalCost").val(result);
} 

$("#saveBtn").bind("click", function() {
	//获取输入项
	var idList = $("input[type='text']");
	//获取隐藏项
	
	//输入项验证
	if(checkInput(idList)){
		return;
	}
	if (!confirm('您确定保存信息吗？')) {
		return;
	}
	var actionUrl="";
	actionUrl= path + "/api/supervisor/tsupervisorApply!insertFundInfo.action?now=" + new Date().getTime();
	pageDirect(actionUrl);
});

$("#nextBtn").bind("click", function() {
	//获取输入项
	var idList = $("input[type='text']");
	//获取隐藏项
	
	//输入项验证
	if(checkInput(idList)){
		return;
	}
	if (!confirm('您确认保存信息并进行下一步操作吗？')) {
		return;
	}
	upms.upmsUtils.setMenu();
	var actionUrl="";
	actionUrl= path + "/api/supervisor/tsupervisorApply!insertFundInfo.action?nextBtnFlag=" + "true" +"&now=" + new Date().getTime();
	pageDirect(actionUrl);
	
});

$("#nextBtn2").bind("click", function() {

	upms.upmsUtils.setMenu();
	var actionUrl="";
	actionUrl= path + "/api/supervisor/tsupervisorApply!showApplySubmit.action?now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();
		});
});

function pageDirect(actionUrl){
	
	var textList = $("input[type='text']");
	
	//var actionUrl="";
	//actionUrl= path + "/server/supervisor/tsupervisorApply!insertFundInfo.action?nextBtnFlag=" + "true" +"&now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"tsupervisorFund.projectSituation",targetid:"projectSituation",type:"text"}];
	
	// 添加文本框信息
	for(var i=0; i< textList.length; i++){
		var params = {name:textList.eq(i).attr("name"),targetid:textList.eq(i).attr("id"),type:"text"};
		arrParams[arrParams.length] = params;
	}

	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		});
}
//文字型焦点进入事件
function focusText(now){
	//if (now.value == "无" || now.value == "0" || now.value == "0.0") {
	//	now.value = "";
	//}
	// 清除错误提示信息
	$("#error" + now.id).remove();
}
//文字型焦点离开事件
function blurText(now, text, spaceFlag, type, num){
	var flag = true;
	if($.trim(now.value)==""){
		if(spaceFlag==1){
			$("#error" + now.id).remove();
			var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"不能为空！</span></div>");
			now.value="";
			$(now).parent().append(span);
			flag =false;
		}
	}else{
		// 数字验证（小数）
		if (type == 3) {
			/* var pattern = /^[1-9]\d*(\.\d)?|(0\.\d)?$/; */
			$("#error" + now.id).remove();
			var pattern = /^(([1-9]\d{0,6})|0)(\.\d{1,2})?$/;
			var result = pattern.test(now.value);
			if (!result) {
				
				var span = $("<div id='error" + now.id
						+ "'><span style='color:red;'>" + text
						+ "格式不正确！(9999999.99)</span></div>");
				$(now).parent().append(span);
				flag = false;
			}
		}
		// 其他验证
		else{
		}
	}
	return flag;
}

//输入项验证
function checkInput(idList){
	var result = false;
	for(var i=0;i<idList.length;i++){
		var id = idList.eq(i).attr("id");
		if(typeof(id)=="undefined"){
			continue;
		}
		
		var domObject = idList.eq(i).get(0);
		if($("#hidden"+ id).length >0){
			var str = $("#hidden"+ id).val();
			var datas=str.split(",");
			var flag = blurText(domObject, datas[0], datas[1], datas[2]);
			if(!flag){
				result = true;
			}
		}
	}
	if($("#projectSituation").val().length>1000){
		$("#errorMsg1").html("<span style='color:red;'>项目及企业情况不能超过1000字！</span>");
		result = true;
	}
	return result;
}

$("#projectSituation").focus(function(){
	$("#errorMsg1").html("");
});

$("#projectSituation").blur(function(){
	if($("#projectSituation").val().length>1000){
		$("#errorMsg1").html("<span style='color:red;'>项目及企业情况不能超过1000字！</span>");
		flag = false;
	}
});
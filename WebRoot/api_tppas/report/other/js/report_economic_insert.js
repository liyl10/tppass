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
		// 产值
		defaultDataSet("outputValue2");
		defaultDataSet("outputValue1");
		defaultDataSet("outputValue");
		// 所交税金
		defaultDataSet("payTaxes2");
		defaultDataSet("payTaxes1");
		defaultDataSet("payTaxes");
		// 净利润
		defaultDataSet("retainedProfits2");
		defaultDataSet("retainedProfits1");
		defaultDataSet("retainedProfits");
		// 创汇
		defaultDataSet("earnMoney2");
		defaultDataSet("earnMoney1");
		defaultDataSet("earnMoney");
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

$("#nextBtn").bind("click", function() {
	// 设置左侧菜单状态
	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/report/tcostEstimateBAction!list.action?now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name : "projectId",targetid : "projectId",type : "text"}, 
	                 {name : "applyStatus",targetid : "applyStatus",type : "text"}];
	
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});
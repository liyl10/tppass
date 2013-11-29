// 网站根目录
var path="";

$(function() {
    $(document).ready(function() {
    	path=$("#path").text();
		// 画面禁止输入
    	$("input[type='text']").each(function(){
			$(this).attr("disabled",true);
		});
    	
    	upms.upmsUtils.initSelect("unitProperties",$("#unitPropertiesValue").val(), 1 , 1 , 0);
		upms.upmsUtils.initSelect("intellectualProperty",$("#intellectualPropertyValue").val(), 1 , 1 , 0);
		upms.upmsUtils.initSelect("technologySource",$("#technologySourceValue").val(), 1 , 1 , 0);
		upms.upmsUtils.initSelect("regionId1",$("#regionId1Value").val(), 1 , 3 , 0);
		upms.upmsUtils.initSelect("regionId2",$("#regionId2Value").val(), 1 , 3 , 0);
		upms.upmsUtils.initSelect("regionId3",$("#regionId3Value").val(), 1 , 3 , 0);
		upms.upmsUtils.initSelect("industries1",$("#industries1Value").val(), 1 , 4 , 0);
		upms.upmsUtils.initSelect("industries2",$("#industries2Value").val(), 1 , 4 , 0);
		upms.upmsUtils.initSelect("industries3",$("#industries3Value").val(), 1 , 4 , 0);
		upms.upmsUtils.initSelect("industries4",$("#industries4Value").val(), 1 , 4 , 0);
		upms.upmsUtils.initSelect("technicalFisld1",$("#technicalFisld1Value").val(), 1 , 3 , 0);
		upms.upmsUtils.initSelect("technicalFisld2",$("#technicalFisld2Value").val(), 1 , 3 , 0);
		upms.upmsUtils.initSelect("technicalFisld3",$("#technicalFisld3Value").val(), 1 , 3 , 0);
		
		// 设定金额的初期值，如果为空的话设置为0
		defaultDataSet("circulatingFund");
		defaultDataSet("fastenFund");
		defaultDataSet("totalValue");
		defaultDataSet("grossIncome");
		defaultDataSet("retainedProfits");
		defaultDataSet("scottare");
		defaultDataSet("investmentTotal");
		defaultDataSet("specialFunds");
		defaultDataSet("selfFinancing");
		defaultDataSet("other");
		defaultDataSet("credit");
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

function nextBtn(){
	// 设置左边菜单样式
	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/report/tenterpriseProfilea!showfileInsert.action?now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"projectId",targetid:"projectId",type:"text"},
	                 {name:"applyStatus",targetid:"applyStatus",type:"text"}];
	
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});	
}
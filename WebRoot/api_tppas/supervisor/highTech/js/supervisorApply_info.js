// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		
		// 设定金额的初期值，如果为空的话设置为0
		// 目前公司资产
		defaultDataSet("companyAssets");
		// 产值
		defaultDataSet("companyOutputThree");
		defaultDataSet("companyOutputTwo");
		defaultDataSet("companyOutputOne");
		
		defaultDataSet("projectOutputThree");
		defaultDataSet("projectOutputTwo");
		defaultDataSet("projectOutputOne");
		
		// 销售收入
		defaultDataSet("companySellThree");
		defaultDataSet("companySellTwo");
		defaultDataSet("companySellOne");
		defaultDataSet("projectSellThree");
		defaultDataSet("projectSellTwo");
		defaultDataSet("projectSellOne");
		// 净利润总额
		defaultDataSet("companyProfitThree");
		defaultDataSet("companyProfitTwo");
		defaultDataSet("companyProfitOne");
		defaultDataSet("projectProfitThree");
		defaultDataSet("projectProfitTwo");
		defaultDataSet("projectProfitOne");
		//交税总额
		defaultDataSet("companyTaxThree");
		defaultDataSet("companyTaxTwo");
		defaultDataSet("companyTaxOne");
		defaultDataSet("projectTaxThree");
		defaultDataSet("projectTaxTwo");
		defaultDataSet("projectTaxOne");
		//出口创汇
		defaultDataSet("companyExportThree");
		defaultDataSet("companyExportTwo");
		defaultDataSet("companyExportOne");
		defaultDataSet("projectExportThree");
		defaultDataSet("projectExportTwo");
		defaultDataSet("projectExportOne");
		// 硬件设施面积
		defaultDataSet("hardwareArea");
		// 设备总值
		defaultDataSet("equipmentTotal");
		// 硬件设备总数
		defaultDataSet("hardwareTotal");
		// 新增加设备数
		defaultDataSet("newHardwareTotal");
		// 员工总数
		defaultDataSet("staffTotal");
		// 本科以上
		defaultDataSet("undergraduateTotal");
		// 为企业培训人数
		defaultDataSet("trainTotal");
		// 技术服务的企业数
		defaultDataSet("serviceTotal");
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

$(document).ready(function(){
	var otherReasonVal = $("#otherReason").val();
	if($("input[value=" + otherReasonVal +"]").attr("CHECKED")=="checked"){
		$("#reason").show();
	}
	else{
		$("#reason").hide();
	}
	var otherField = $("#hiddenOtherField").val();
	if($("input[value=" + otherField +"]").attr("CHECKED")=="checked"){
		$("#otherField").show();
	}
	else{
		$("#otherField").hide();
	}
});
$("#saveBtn").bind("click", function() {

	if(!inputDataCheck()){
		return;
	}

	if (!confirm('您确定保存信息吗？')) {
		return;
	}
	
	var actionUrl="";
	actionUrl= path + "/api/supervisor/tsupervisorApply!insertApplyInfo.action?now=" + new Date().getTime();
	pageDirect(actionUrl);
});

$("#nextBtn").bind("click", function() {
	if(!inputDataCheck()){
		return;
	}
	if (!confirm('您确认保存信息并进行下一步操作吗？')) {
		return;
	}
	upms.upmsUtils.setMenu();
	var actionUrl="";
	actionUrl= path + "/api/supervisor/tsupervisorApply!insertApplyInfo.action?nextBtnFlag=" + "true" +"&now=" + new Date().getTime();
	pageDirect(actionUrl);
});

$("#nextBtn2").bind("click", function() {
	upms.upmsUtils.setMenu();
	var actionUrl="";
	actionUrl= path + "/api/supervisor/tsupervisorApply!showApplyFund.action?now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();
		});
});

// 数据验证
function inputDataCheck(){
	var flag = true;
	var textList = $("input[type='text']");
	flag = checkInput(textList) == false?false:flag;
	
	var checkedItem1 = $("input:radio[name='tsupervisorInfo.field']:checked").val();
	var radioItem1 = $("input:radio[name='tsupervisorInfo.field']");
	var fieldName1 = "项目所属领域";
	flag = checkRadio(checkedItem1,radioItem1,fieldName1) == false?false:flag;

	if($("#supprotFlag").val() == "1"){
		var checkedItem2 = $("input:radio[name='tsupervisorInfo.projectPersonEducation']:checked").val();
		var radioItem2 = $("input:radio[name='tsupervisorInfo.projectPersonEducation']");
		var fieldName2 = "学历";
		flag = checkRadio(checkedItem2,radioItem2,fieldName2) == false?false:flag;
		
		var checkedItem3 = $("input:radio[name='tsupervisorInfo.projectPersonTitle']:checked").val();
		var radioItem3 = $("input:radio[name='tsupervisorInfo.projectPersonTitle']");
		var fieldName3 = "职称";
		flag = checkRadio(checkedItem3,radioItem3,fieldName3) == false?false:flag;
	}
	
	var checkedItem4 = $("input:radio[name='tsupervisorInfo.projectSchedule']:checked").val();
	var radioItem4 = $("input:radio[name='tsupervisorInfo.projectSchedule']");
	var fieldName4 = "项目实施进展情况";
	flag = checkRadio(checkedItem4,radioItem4,fieldName4) == false?false:flag;

	flag = checkCheckBox() == false?false:flag;
    
	// 项目未按计划进行的其它原因的说明
	var otherReasonVal = $("#otherReason").val();
	if($("input[value=" + otherReasonVal +"]").attr("CHECKED")=="checked"){
		if($("#reasonCommand").val().length==0){
			$("#reasonCommandMsg").html("<span style='color:red;'>项目未按计划进行的其它原因必须填写！</span>");
			flag = false;
		}
		if($("#reasonCommand").val().length>200){
			$("#reasonCommandMsg").html("<span style='color:red;'>项目未按计划进行的其它原因不能超过200字！</span>");
			flag = false;
		}
	}
	// 其他项目所属领域的验证
	var otherField = $("#hiddenOtherField").val();
	if($("input[value=" + otherField +"]").attr("CHECKED")=="checked"){
		if($("#otherField").val().length==0){
			$("#otherFieldMsg").html("<span style='color:red;'>其他项目所属领域不能为空！</span>");
			flag = false;
		}
	}
	
    return flag;    
}

// load
function pageDirect(actionUrl){
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"tsupervisorInfo.field",targetname:"tsupervisorInfo.field",type:"radio"},
	                 {name:"tsupervisorInfo.projectPersonEducation",targetname:"tsupervisorInfo.projectPersonEducation",type:"radio"},
	                 {name:"tsupervisorInfo.projectPersonTitle",targetname:"tsupervisorInfo.projectPersonTitle",type:"radio"},
	                 {name:"tsupervisorInfo.projectSchedule",targetname:"tsupervisorInfo.projectSchedule",type:"radio"},
	                 {name:"tsupervisorInfo.projectReasonCommand",targetid:"reasonCommand",type:"text"},
	                 {name:"selectedProjectStopReason",targetname:"selectedProjectStopReason",type:"checkbox"}];

	var textList = $("input[type='text']");
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
// radio验证
function checkRadio(checkedItem,radioItem,fieldName){
	
	var flag = true;
	if(checkedItem==null){
		var attrName = radioItem.attr("name");
		var tempName = "error" + attrName;
		$("div[id='"+tempName+"']").remove();
		var span = $("<div id='error"+attrName+"'><span style='color:red;'>"+ fieldName + "不能为空！</span></div>");
		radioItem.parent().append(span);
		flag = false;
	}
	
		
	return flag;
}

// checkBox选择验证
function checkCheckBox(){
    var flag = true;
	if( $("input[name='selectedProjectStopReason']:checked").length>3){
		$("#errorselectedProjectStopReason").remove();
	    var span = $("<div id='errorselectedProjectStopReason'><span style='color:red;'>"+ "项目未按计划进行的原因不能超过三项！</span></div>");
	    $(":checkbox").parent().append(span);
		 flag = false;
    }
	return flag;
}

//文字型焦点进入事件
function focusText(now){
	// 清除错误提示信息
	$("#error" + now.id).remove();
	if(now.id =="staffTotal" || now.id == "undergraduateTotal"){
		$("#compareErrMsg").html("");
	}
}

// checkbox点击事件
$(":checkbox").click(function(){
	$("#errorselectedProjectStopReason").remove();
    if( $(":checkbox:checked").length>3){
	    var span = $("<div id='errorselectedProjectStopReason'><span style='color:red;'>"+ "项目未按计划进行的原因不能超过三项！</span></div>");
		 $(":checkbox").parent().append(span);
    }
});

// radio选择事件
var otherField = $("#hiddenOtherField").val();
$(":radio[name^=tsupervisorInfo]").change(function(){
	if($(this).attr("name")=="tsupervisorInfo.field"){
		if($(this).val() != otherField){
			$("#otherField").hide();
			$("#otherFieldMsg").html("");
		}
	}
  	var tempName = "error" + $(this).attr("name");
	$("div[id='"+tempName+"']").remove();
});


//文字型焦点离开事件
function blurText(now, text, spaceFlag, type){
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
		// 数字验证（平方米）
		if (type == 2) {
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
		// 数字验证（整数）
		if (type == 4) {
			/* var pattern = /^[1-9]\d*(\.\d)?|(0\.\d)?$/; */
			$("#error" + now.id).remove();
			var pattern = /^(([0]|([1-9]\d{0,11})))?$/;
			var result = pattern.test(now.value);
			if (!result) {
				var span = $("<div id='error" + now.id
						+ "'><span style='color:red;'>" + text
						+ "格式不正确，请输入整数！</span></div>");
				$(now).parent().append(span);
				flag = false;
			}else{
				if(now.id =="staffTotal" || now.id == "undergraduateTotal"){
					$("#compareErrMsg").html("");
					var staffTotalVal = $("#staffTotal").val();
					var graduTotalVal = $("#undergraduateTotal").val();
					if(parseInt(graduTotalVal) > parseInt(staffTotalVal)){
						$("#compareErrMsg").html("<span style='color:red;'>本科以上人数不能超过员工总数！</span>");
						flag = false;
					}
				}
			}
		}
		// 手机号码验证
		if(type==5){
			$("#error" + now.id).remove();
			var reg = /^0?1[358]\d{9}$/;
			if (!reg.test($.trim(now.value))){
				var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text+"格式不正确！(11位数字的手机号码，如：手机号码前3位为138 或 180等)</span></div>");
			    $(now).parent().append(span);
			    return false;
			}
		}
		// 电话验证
		if(type==6){
			var partten=/^((0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;
			$("#error" + now.id).remove();
			if (!partten.test($.trim(now.value))){
				var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text+"格式不正确，例如：029-88888888！</span></div>");
			    $(now).parent().append(span);
			    return false;
			}
		}
		// 文本域长度验证
		if(type==7){
			$("#error" + now.id).remove();
			if($.trim(now.value).length > num){
				var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text+"不能超过"+num+"个汉字！</span></div>");
			    $(now).parent().append(span);
			    return false;
			}
		}
	}
	return flag;
}

//输入项验证
function checkInput(idList){
	var result = true;
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
				result = false;
			}
		}
	}
	return result;
}

var otherReasonVal = $("#otherReason").val();
$("input[value=" + otherReasonVal +"]").click(function(){
	if($(this).attr("CHECKED")=="checked"){
		$("#reason").show();
		$("#reasonCommand").focus();
	}
	else{
		$("#reason").hide();		
	}
	$("#reasonCommand").val("");
});


$("input[value=" + otherField +"]").click(function(){
	if($(this).attr("CHECKED")=="checked"){
		$("#otherField").show();
		$("#otherFieldMsg").html("");
		$("#otherField").focus();
	}
	else{
		$("#otherField").hide();		
	}
	$("#otherField").val("");
});

$("#reasonCommand").focus(function(){
	$("#reasonCommandMsg").html("");
});

$("#otherField").focus(function(){
	$("#otherFieldMsg").html("");
});

$("#reasonCommand").blur(function(){
	if($("#reasonCommand").val()==0){
		$("#reasonCommandMsg").html("<span style='color:red;'>项目未按计划进行的其它原因必须填写！</span>");
	}
	if($("#reasonCommand").val().length>200){
		$("#reasonCommandMsg").html("<span style='color:red;'>项目未按计划进行的其它原因不能超过200字！</span>");
	}
});

$("#otherField").blur(function(){
	if($("#otherField").val().length==0){
		$("#otherFieldMsg").html("<span style='color:red;'>其他项目所属领域不能为空！</span>");
	}
	if($("#otherField").val().length>20){
		$("#otherFieldMsg").html("<span style='color:red;'>其他项目所属领域不能超过20字！</span>");
	}
});
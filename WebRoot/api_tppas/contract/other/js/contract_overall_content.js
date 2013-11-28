
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
		 
		sumAddedValue();
		sumNewTaxes();
		sumAdditionalProfits();
		sumForeignExchange();
		if($("#Flag").val() == "1"){
			//获取输入项
			var idList = $("input[type='text']");
			for(var i=0; i<idList.length; i++){
				var id = idList.eq(i).attr("id");
				$("#" + id).attr("disabled",true);
			}
			$("textarea").each(function(){
				$(this).attr("readonly",true);
				$(this).css('background-color','#F0F0F0');
			});
		}
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

//1新增产值合计
$("#outputValue").bind("input propertychange", function() {
	sumAddedValue();
});
$("#outputValue1").bind("input propertychange", function() {
	sumAddedValue();
});
$("#outputValue2").bind("input propertychange", function() {
	sumAddedValue();
});

//1新增税金合计
$("#payTaxes").bind("input propertychange", function() {
	sumNewTaxes();
});
$("#payTaxes1").bind("input propertychange", function() {
	sumNewTaxes();
});
$("#payTaxes2").bind("input propertychange", function() {
	sumNewTaxes();
});

//1新增利润合计
$("#retainedProfits").bind("input propertychange", function() {
	sumAdditionalProfits();
});
$("#retainedProfits1").bind("input propertychange", function() {
	sumAdditionalProfits();
});
$("#retainedProfits2").bind("input propertychange", function() {
	sumAdditionalProfits();
});

//1创汇合计
$("#earnMoney").bind("input propertychange", function() {
	sumForeignExchange();
});
$("#earnMoney1").bind("input propertychange", function() {
	sumForeignExchange();
});
$("#earnMoney2").bind("input propertychange", function() {
	sumForeignExchange();
});

//合计新增产值
function sumAddedValue() {
	var value1 = parseFloat($("#outputValue").val() == '' ? 0 : $("#outputValue").val());
	var value2 = parseFloat($("#outputValue1").val() == '' ? 0 : $("#outputValue1").val());
	var value3 = parseFloat($("#outputValue2").val() == '' ? 0 : $("#outputValue2").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#totalOutputValue").val(total);
}

//合计新增税金
function sumNewTaxes() {
	var value1 = parseFloat($("#payTaxes").val() == '' ? 0 : $("#payTaxes").val());
	var value2 = parseFloat($("#payTaxes1").val() == '' ? 0 : $("#payTaxes1").val());
	var value3 = parseFloat($("#payTaxes2").val() == '' ? 0 : $("#payTaxes2").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#totalPayTaxes").val(total);
}

//合计新增利润
function sumAdditionalProfits() {
	var value1 = parseFloat($("#retainedProfits").val() == '' ? 0 : $("#retainedProfits").val());
	var value2 = parseFloat($("#retainedProfits1").val() == '' ? 0 : $("#retainedProfits1").val());
	var value3 = parseFloat($("#retainedProfits2").val() == '' ? 0 : $("#retainedProfits2").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#totalRetainedProfits").val(total);
}

//合计创汇
function sumForeignExchange() {
	var value1 = parseFloat($("#earnMoney").val() == '' ? 0 : $("#earnMoney").val());
	var value2 = parseFloat($("#earnMoney1").val() == '' ? 0 : $("#earnMoney1").val());
	var value3 = parseFloat($("#earnMoney2").val() == '' ? 0 : $("#earnMoney2").val());
	var total = value1 + value2 + value3;
	total=total.toFixed(4);
	$("#totalEarnMoney").val(total);
}

	// 文字型焦点进入事件
	function focusText1(now){
		// 清除错误提示信息
		$("#message1").text("");
	}
	
	// 文字型焦点进入事件
	function focusText2(now){
		// 清除错误提示信息
		$("#message2").text("");
	}
	
	// 文字型焦点进入事件
	function focusText3(now){
		// 清除错误提示信息
		$("#error" + now.id).remove();
	}

	// 文字型焦点离开事件
	function blurText(now, text, spaceFlag, type, num){
		var flag = true;
		var textValue = $.trim(now.value);
		if(textValue == ""){
			// 非空验证
			if(spaceFlag == 0){
				$("#error" + now.id).remove();
				var span = $("<em id='error"+ now.id +"'><span style='color:red;font-style:normal;'>"+ text +"不能为空！</span></em>");
				$("#message").append(span);
				flag =false;
			}
		}
		else{
			if(type=="21"){
				return flag;
			}
			else if(type==22){
				var result = upms.checkUtils.isFloatNum2(textValue);
				if(!result){
					$("#error" + now.id).remove();
					var span = $("<em id='error"+ now.id +"'><span style='color:red;font-style: normal;'>"+ text +"格式不正确！(9999999.9999)</span></em>");
					$("#message").append(span);
					flag =false;
				}
			}
			else if(type ==23){
				var result = upms.checkUtils.isYear(textValue);
				if(!result){
					$("#error" + now.id).remove();
					var span = $("<em id='error"+ now.id +"'><span style='color:red;font-style: normal;'>"+ text +"格式不正确（yyyy）！</span></em>");
					$("#message").append(span);
					flag =false;
				}
			}
			// 其他验证
			else{
			}
		}
		return flag;
		
	}	
	
	// 输入项验证
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
		return result;
	}

	//保存
	$("#okBtn").bind("click", function() {
		
		var hidden = $("input[type='hidden']");

		//获取输入项
		var idList = $("input[type='text']");
		
		if(upms.upmsUtils.inputCheck() || checkInput(idList)){
			return;
		}	 
		if (confirm($("#comfirmSave").text())){
		var actionUrl= path + "/api/contract/tcontractContentsB!updatetContents.action?now="+ new Date().getTime();
			upms.showOverLay();// 打开遮罩
			var $newPgDiv = $("#content");
			var arrParams = [{name:"tcontractContentsB.research",targetid:"research",type:"text"},
			                 {name:"tcontractContentsB.technicalSpecifications",targetid:"technicalSpecifications",type:"text"},
			                 {name:"tcontractContentsB.arrangement",targetid:"arrangement",type:"text"},
			                 {name:"tcontractContentsB.resultsForm",targetid:"resultsForm",type:"text"},
			                 {name:"tcontractContentsB.social",targetid:"social",type:"text"}];
			// 添加文本值
			for(var i=0; i< idList.length; i++){
				var params = {name:idList.eq(i).attr("name"),targetid:idList.eq(i).attr("id"),type:"text"};
				arrParams[arrParams.length] = params;
			}//添加隐藏域
			for(var i=0; i<hidden.length; i++){
				if(hidden.eq(i).attr("name") != "hidden"){
					var params = {name:hidden.eq(i).attr("name"),targetid:hidden.eq(i).attr("id"),type:"text"};
					arrParams[arrParams.length] = params;
				}
			}
			var data = upms.transParsToObj(arrParams, $newPgDiv);
			$newPgDiv.load(actionUrl, data, function() {
				upms.hideOverLay();
			});
		}
		});

	//下一页
	$("#nextBtn").bind("click", function() {
		
		var hidden = $("input[type='hidden']");

		//获取输入项
		var idList = $("input[type='text']");
		//获取隐藏项
		
		if(upms.upmsUtils.inputCheck()  || checkInput(idList)){
			return;
		}	
		if (confirm($("#comfirmSaveNext").text())){
			// 设置左侧菜单
			upms.upmsUtils.setMenu();
		var actionUrl= path + "/api/contract/tcontractContentsB!nextContents.action?now="+ new Date().getTime();
			upms.showOverLay();// 打开遮罩
			var $newPgDiv = $("#content");
			var arrParams = [{name:"tcontractContentsB.research",targetid:"research",type:"text"},
			                 {name:"tcontractContentsB.technicalSpecifications",targetid:"technicalSpecifications",type:"text"},
			                 {name:"tcontractContentsB.arrangement",targetid:"arrangement",type:"text"},
			                 {name:"tcontractContentsB.resultsForm",targetid:"resultsForm",type:"text"},
			                 {name:"tcontractContentsB.social",targetid:"social",type:"text"}];
			// 添加文本值
			for(var i=0; i< idList.length; i++){
				var params = {name:idList.eq(i).attr("name"),targetid:idList.eq(i).attr("id"),type:"text"};
				arrParams[arrParams.length] = params;
			}//添加隐藏域
			for(var i=0; i<hidden.length; i++){
				if(hidden.eq(i).attr("name") != "hidden"){
					var params = {name:hidden.eq(i).attr("name"),targetid:hidden.eq(i).attr("id"),type:"text"};
					arrParams[arrParams.length] = params;
				}
			}
			var data = upms.transParsToObj(arrParams, $newPgDiv);
			$newPgDiv.load(actionUrl, data, function() {
				upms.hideOverLay();
			});
		}
		});

//下一页
$("#nextBtn1").bind("click", function() {
	// 设置左侧菜单
	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/contract/tfundingPlanB!execute.action?now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"}];
	arrParams[arrParams.length] = {name:"Flag",targetid:"Flag",type:"text"};
	arrParams[arrParams.length] = {name:"contractStatus",targetid:"contractStatus",type:"text"};
	arrParams[arrParams.length] = {name:"modelType",targetid:"modelType",type:"text"};
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

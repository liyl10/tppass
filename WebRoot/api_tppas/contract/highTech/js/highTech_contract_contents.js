
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
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


	// 文字型焦点进入事件
	function focusText(now){
		// 清除错误提示信息
		$("#err" + now.id).html("");
	}

	// 文字型焦点离开事件
	function blurText(now, text, spaceFlag, type, num){
		var flag = true;
		var textValue = $.trim(now.value);
		if($.trim(now.value)==""){
			if(spaceFlag==1){
				$("#err" + now.id).html("");
				$("#err" + now.id).html("</br>" + text +UPLANG.input_must);
				flag =false;
			}
		}else{
			if(type==5){
				/* var pattern = /^[1-9]\d*(\.\d)?|(0\.\d)?$/; */
				var result = upms.checkUtils.isFloatNum2(textValue);
				if(!result){
					$("#error" + now.id).remove();
					$("#err" + now.id).html("</br>" + text + "格式不正确！(9999999.9999)");
					flag =false;
				}
			}
			// 整数验证
			else if(type==6){
				//var pattern = /^[0-9]*[1-9][0-9]*$/; 
				var pattern = /^(([1-9](\d*))|0)$/;
				var result = pattern.test(now.value);
				if(!result){
					$("#error" + now.id).remove();
					$("#err" + now.id).html("</br>" + text + "格式不正确！必须输入整数");
					flag =false;
				}				
			}
			// 文本域长度验证
			else if(type==7){
				//alert(now.value.length);
				$("#error" + now.id).remove();
				if($.trim(now.value).length > num){
					$("#err" + now.id).html("</br>" + text + "不能超过"+num+"个汉字！");
				    return false;
				}
			}
			// 月份限制
			else if(type==8){
				var pattern = /^[0-9]*[1-9][0-9]*$/; 
				var result = pattern.test(now.value);
				if(!result){
					$("#error" + now.id).remove();
					$("#err" + now.id).html("</br>" + text + "格式不正确！");
					flag =false;
				}
				else{
					if (now.value > 12 || now.value < 1){
						$("#error" + now.id).remove();
						$("#err" + now.id).html("</br>" + text + "格式不正确！");
						flag =false;
					}
				}
			}
			// 年份限制
			else if(type==9){
				var pattern = /^[0-9]*[1-9][0-9]*$/; 
				var result = pattern.test(now.value);
				if(!result){
					$("#error" + now.id).remove();
					$("#err" + now.id).html("</br>" + text + "格式不正确！");
					flag =false;
				}
				else{
					if (now.value.length != 4){
						$("#error" + now.id).remove();
						$("#err" + now.id).html("</br>" + text + "格式不正确！");
						flag =false;
					}
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
		
		if($("#implementationPlan").length > 0){
			var domObject = $("#implementationPlan").get(0);
			var str = $("#hiddenimplementationPlan").val();
			var datas=str.split(",");
			var flag = blurText(domObject, datas[0], datas[1], datas[2],datas[3]);
			if(!flag){
				result = true;
			}
		}
		if($("#technicalSpecifications").length > 0){
			var domObject = $("#technicalSpecifications").get(0);
			var str = $("#hiddentechnicalSpecifications").val();
			var datas=str.split(",");
			var flag = blurText(domObject, datas[0], datas[1], datas[2],datas[3]);
			if(!flag){
				result = true;
			}
		}
		
		return result;
	}
	
	//保存
	$("#okBtn").bind("click", function() {
		
		var hidden = $("input[type='hidden']");

		//获取输入项
		var idList = $("input[type='text']");
		
		if(checkInput(idList)){
			return;
		}	 
		if (confirm($("#comfirmSave").text())){
		var actionUrl= path + "/api/contract/tcontractContentsA!updatecontractContents.action?now="+ new Date().getTime();
			upms.showOverLay();// 打开遮罩
			var $newPgDiv = $("#content");
			var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"},
			                 {name:"tcontractContentsA.implementationPlan",targetid:"implementationPlan",type:"text"},
			                 {name:"tcontractContentsA.technicalSpecifications",targetid:"technicalSpecifications",type:"text"}];
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
		
		if(checkInput(idList)){
			return;
		}	
		if (confirm($("#comfirmSaveNext").text())){
			upms.upmsUtils.setMenu();
		var actionUrl= path + "/api/contract/tcontractContentsA!ContentsTofundUse.action?now="+ new Date().getTime();
			upms.showOverLay();// 打开遮罩
			var $newPgDiv = $("#content");
			var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"},
			                 {name:"tcontractContentsA.implementationPlan",targetid:"implementationPlan",type:"text"},
			                 {name:"tcontractContentsA.technicalSpecifications",targetid:"technicalSpecifications",type:"text"}];
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
	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/contract/tfundUseA!importTfundUse.action?now="+ new Date().getTime();
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

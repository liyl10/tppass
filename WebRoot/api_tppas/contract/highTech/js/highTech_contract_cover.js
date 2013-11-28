
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
		 upms.upmsUtils.initSelect("address1",$("#address1Value").val(),1,3,2);
		 upms.upmsUtils.initSelect("address2",$("#address2Value").val(),1,3,2);
		 upms.upmsUtils.initSelect("address3",$("#address3Value").val(),1,3,2);
		if($("#Flag").val() == "1"){
			var idList = $("input[type='text']");
			for(var i=0; i<idList.length; i++){
				var id = idList.eq(i).attr("id");
				$("#" + id).attr("disabled",true);
			}
		}
	});
});

//下拉列表联动
var secondId = "";
function getSecondData(value, value1){
    var pItemId=$('#'+ value1).val();
   
   	if(value1.substr(value1.length -1) == "3"){
    	$("#error" + value1).remove();
    }
   	else{
   		$("#error" + value1).remove();
   	}
    
    secondId = value;
    $.ajax({
       url:path + "/server/contract/tcontractCoverhighTech!getSecondData.action",
       type:'post',
       dataType:'json',
       data:{pitemId:pItemId},
       success:setSecondData
    });
}

// 下拉列表联动
function setSecondData(json){
    var data=json.backStr;
    //alert(data);
    var datas="";
    if(data!=""){
       datas=data.split(",");
    }
    var tempStr = secondId.substr(0,secondId.length-1);
    var tempIndex = parseInt(secondId.substr(secondId.length-1)) +1;
    for(;tempIndex < 5; tempIndex ++){
    	var s_root1=$("#" +tempStr + tempIndex);
    	if(s_root1.length > 0){
    		s_root1.find("option").remove();
    	    s_root1.append("<option value=''>----请选择----</option>");
    	    s_root1.trigger("liszt:updated");
    	}
    }
    var s_root=$("#" +secondId);
    s_root.find("option").remove();
    s_root.append("<option value=''>----请选择----</option>");
    for(var i=0;i<datas.length;i++){
    	 s_root.append("<option value='"+datas[i]+"'>"+datas[i+1]+"</option>");
       	 i++;
    }
    s_root.trigger("liszt:updated");
    
}


//初始化下拉列表
function initSelect(selectId,value){
	$("#" + selectId).prepend("<option value=''>----请选择----</option>");
	 if(value == ""){
		 $("#"+ selectId).attr("value",'');
	 }
}

$("#okBtn").bind("click", function() {
	//获取输入项
	var idList = $("input[type='text']");
	//获取隐藏项
	
	//输入项验证
	if(checkInput(idList)){
		return;
	}
	if (confirm($("#comfirmSave").text())){
	var actionUrl= path + "/api/contract/tcontractCoverhighTech!updatecontractCover.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"}];
		arrParams[arrParams.length] = {name:"Flag",targetid:"Flag",type:"text"};
		arrParams[arrParams.length] = {name:"contractStatus",targetid:"contractStatus",type:"text"};
		arrParams[arrParams.length] = {name:"tcontractCover.contractCoverId",targetid:"contractCoverId",type:"text"};
		// 添加公民类型股权信息
		for(var i=0; i< idList.length; i++){
			var params = {name:idList.eq(i).attr("name"),targetid:idList.eq(i).attr("id"),type:"text"};
			arrParams[arrParams.length] = params;
		}
		arrParams[arrParams.length] = {name:"tcontractCover.address1",targetid:"address1",type:"select"};
		arrParams[arrParams.length] = {name:"tcontractCover.address2",targetid:"address2",type:"select"};
		arrParams[arrParams.length] = {name:"tcontractCover.address3",targetid:"address3",type:"select"};
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
	});

$("#nextBtn").bind("click", function() {
	//获取输入项
	var idList = $("input[type='text']");
	
	//输入项验证
	if(checkInput(idList)){
		return;
	}
	if (confirm($("#comfirmSaveNext").text())){
		// 设置左侧菜单
		upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/contract/tcontractCoverhighTech!next.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"}];
		arrParams[arrParams.length] = {name:"Flag",targetid:"Flag",type:"text"};
		arrParams[arrParams.length] = {name:"contractStatus",targetid:"contractStatus",type:"text"};
		arrParams[arrParams.length] = {name:"tcontractCover.contractCoverId",targetid:"contractCoverId",type:"text"};
		// 添加公民类型股权信息
		for(var i=0; i< idList.length; i++){
			var params = {name:idList.eq(i).attr("name"),targetid:idList.eq(i).attr("id"),type:"text"};
			arrParams[arrParams.length] = params;
		}
		arrParams[arrParams.length] = {name:"tcontractCover.address1",targetid:"address1",type:"select"};
		arrParams[arrParams.length] = {name:"tcontractCover.address2",targetid:"address2",type:"select"};
		arrParams[arrParams.length] = {name:"tcontractCover.address3",targetid:"address3",type:"select"};
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
	});

$("#nextBtn1").bind("click", function() {
		// 设置左侧菜单
		upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/contract/tcontractContentsA!importContents.action?now="+ new Date().getTime();
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
	
// 文字型焦点进入事件
function focusText(now){
	// 清除错误提示信息
	$("#error" + now.id).remove();
}

// 文字型焦点离开事件
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
		// 手机验证
		if(type==1){
			///var pattern = /^[0-9]{11}$/;
			var result = upms.checkUtils.isMobilePhone(now.value);
			if(!result){
				$("#error" + now.id).remove();
				var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"格式不正确！(11位数字的手机号码，如：手机号码前3位为138 或 180等)</span></div>");
				$(now).parent().append(span);
				flag =false;
			}
		}
		// 电话验证
		else if(type==2){
			var pattern = /^[0-9]{3,4}\-[0-9]{7,8}$/;	
			var result = pattern.test(now.value);
			if(!result){
				$("#error" + now.id).remove();
				var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"格式不正确！(例如：029-88888888)</span></div>");
				$(now).parent().append(span);
				flag =false;
			}
		}
		else if (type == 3){
			var pattern = /^[0-9]*[1-9][0-9]*$/; 
			var result = pattern.test(now.value);
			if(!result){
				$("#error" + now.id).remove();
				var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"格式不正确！必须为整数！</span></div>");
				$(now).parent().append(span);
				flag =false;
			}
		}
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
	
	if($("#address3 option:selected").val() ==""){
		var domObject = $("#address3").get(0);
		var str = $("#hiddenaddress1").val();
		var datas=str.split(",");
		var flag = blurText(domObject, datas[0], datas[1], datas[2]);
		if(!flag){
			result = true;
		}
	}
	return result;
}
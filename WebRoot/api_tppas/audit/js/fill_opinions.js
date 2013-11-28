// 网站根目录
var path="";
var tecCount = 0;

$(function() {
	$(document).ready(function() {
		path=$("#path").text();
		// 绑定值变化事件
		$("input[autoFlag='1']").each(function(){
			
			if($(this).attr("expertType") == "0"){
				$(this).bind("input propertychange", function() {
					expertTecOpinionsChange(this);
				});
			}
			else{
				$(this).bind("input propertychange", function() {
					expertInvOpinionsChange(this);
				});
			}
		});
		
		if($("#expertOpinionFlag").val() == 0){
			upms.upmsUtils.setDisableControl();
			$("#backBtn").removeAttr("disabled");
		}
		
		$("#expert").find("td").each(function(){
			if($.trim(this.innerText) == "技术专家"){
				tecCount ++;
			}
		});
		//alert(tecCount);
	});
});


/**
 * 技术专家意见变化
 */
var tecFlag = true;
function expertTecOpinionsChange(now){
	
	var opinionId = now.id;
	var num = opinionId.substr(14);
	var expertName ="技术专家"+ $("#count" + num).val() + " ：";
	var num1 = $("#count" + num).val();
	//alert(num1);
	var textAreaValue = expertName + now.value + ";<BR>";
	if($.trim(now.value) ==""){
		textAreaValue = "";
	}
	var oldtextAreaValue = $("#expertTecOpinion").html();
	oldtextAreaValue = oldtextAreaValue.replace(/\n/g, "<BR>");
	var value1 = "";
	var value2 = "";
	if(oldtextAreaValue.indexOf(expertName) > -1){
		value1 = oldtextAreaValue.substring(0,oldtextAreaValue.indexOf(expertName));
		value2 = oldtextAreaValue.substr(oldtextAreaValue.indexOf(expertName));
		if(value2.indexOf("<BR>") > -1){
			value2 = value2.substr(value2.indexOf("<BR>") + 4);
		}
		else if(value2.indexOf("\n") > -1){
			value2 = value2.substr(value2.indexOf("\n"));
		}
		else{
			value2 = "";
		}
		value2 = value2.replace(/\n/g,"<BR>");
		
		$("#expertTecOpinion").html(value1 + textAreaValue+ value2);
	}
	else{
		if(tecFlag){
			value2 = $("#expertTecOpinion").get(0).value.replace(/\n/g,"<BR>");
			
			tecFlag = false;
		}
		else{
			value2 = $("#expertTecOpinion").html();
			
			var count = 0;
			for(var i=1; i<num1;i++){
				var flag = "技术专家"+ i + " ：";
				if(value2.indexOf(flag) > -1){
					count = i;
				}
			}
			//alert(count);
			if(count != 0){
				expertName ="技术专家"+ count + " ：";
				value1 = oldtextAreaValue.substring(0,oldtextAreaValue.indexOf(expertName));
				//alert(value1);
				value2 = oldtextAreaValue.substr(oldtextAreaValue.indexOf(expertName));
				//alert(value2);
				//alert(value2.indexOf("<BR>"));
				//alert(value2.indexOf("\n"));
				if(value2.indexOf("<BR>") > -1){
					var value3 = value2.substring(0,value2.indexOf("<BR>") + 4);
					value1 = value1 + value3;
					value2 = value2.substr(value2.indexOf("<BR>") + 4);
				}
				else{
					var value3 = value2.substring(0,value2.indexOf("\n"));
					value1 = value1 + value3;
					value2 = value2.substr(value2.indexOf("\n"));
				}
				//alert(value2);
				value2 = value2.replace(/\n/g,"<BR>");
			}
		}
		$("#expertTecOpinion").html(value1 + textAreaValue+ value2);
	}
}

/**
 * 投资专家意见变化
 */
var invFlag = true;
function expertInvOpinionsChange(now){
	var opinionId = now.id;
	var num = opinionId.substr(14);
	num = num - tecCount;
	var expertName ="投资专家"+ $("#count" + num).val() + " ：";
	var num1 = $("#count" + num).val();
	var textAreaValue = expertName + now.value + ";<BR>";
	if($.trim(now.value) ==""){
		textAreaValue = "";
	}
	var oldtextAreaValue = $("#expertInvOpinion").html();
	var value1 = "";
	var value2 = "";
	if(oldtextAreaValue.indexOf(expertName) > -1){
		value1 = oldtextAreaValue.substring(0,oldtextAreaValue.indexOf(expertName));
		value2 = oldtextAreaValue.substr(oldtextAreaValue.indexOf(expertName));
		if(value2.indexOf("<BR>") > -1){
			value2 = value2.substr(value2.indexOf("<BR>") + 4);
		}
		else if(value2.indexOf("\n") > -1){
			value2 = value2.substr(value2.indexOf("\n"));
		}
		else{
			value2 = "";
		}
		value2 = value2.replace(/\n/g,"<BR>");
		
		$("#expertInvOpinion").html(value1+ textAreaValue + value2);
	}
	else{
		if(invFlag){
			
			value2 = $("#expertInvOpinion").get(0).value.replace(/\n/g,"<BR>");
			invFlag = false;
		}else{
			value2 = $("#expertInvOpinion").html();
			var count = 0;
			for(var i=1; i<num1;i++){
				var flag = "技术专家"+ i + " ：";
				if(value2.indexOf(flag) > -1){
					count = i;
				}
			}
			//alert(count);
			if(count != 0){
				expertName ="技术专家"+ count + " ：";
				value1 = oldtextAreaValue.substring(0,oldtextAreaValue.indexOf(expertName));
				//alert(value1);
				value2 = oldtextAreaValue.substr(oldtextAreaValue.indexOf(expertName));
				//alert(value2);
				//alert(value2.indexOf("<BR>"));
				//alert(value2.indexOf("\n"));
				if(value2.indexOf("<BR>") > -1){
					var value3 = value2.substring(0,value2.indexOf("<BR>") + 4);
					value1 = value1 + value3;
					value2 = value2.substr(value2.indexOf("<BR>") + 4);
				}
				else{
					var value3 = value2.substring(0,value2.indexOf("\n"));
					value1 = value1 + value3;
					value2 = value2.substr(value2.indexOf("\n"));
				}
				//alert(value2);
				value2 = value2.replace(/\n/g,"<BR>");
			}
		}
		$("#expertInvOpinion").html(value1+ textAreaValue + value2);
	}
	
}

/**
 * 保存
 */
function saveBtn(){
	// 验证text
	var result = upms.upmsUtils.inputCheck();
	// radio列表验证
	/*var nameList = new Array("tprojectApplication.expertAuditRecommend", "tprojectApplication.expertTecRecommend", "tprojectApplication.expertInvRecommend");
	var result2 = upms.upmsUtils.radioCheck(nameList);
	if(result || result2){
		return;
	}*/
	if(result){
		return;
	}
	
	if (confirm($("#comfirmSave").text())){
		
		$("#expertTecOpinion").get(0).value = $("#expertTecOpinion").html().replace(/<BR>/g, "\n");
		$("#expertInvOpinion").get(0).value = $("#expertInvOpinion").html().replace(/<BR>/g, "\n");
		
		var actionUrl= path + "/api/audit/projectApplication!saveAuditOpinions.action?now="+new Date().getTime();
		//alert(actionUrl);
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		/*var arrParams = [{name:"tprojectApplication.expertAuditRecommend",targetname:"tprojectApplication.expertAuditRecommend",type:"radio"},
		                 {name:"tprojectApplication.expertTecRecommend",targetname:"tprojectApplication.expertTecRecommend",type:"radio"},
		                 {name:"tprojectApplication.expertInvRecommend",targetname:"tprojectApplication.expertInvRecommend",type:"radio"}];*/
		var arrParams = [];
		arrParams = upms.upmsUtils.setSubmitDatas(arrParams, 1, 0);
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
}


/**
 * 提交
 */
function submitBtn(){
	// 验证text
	var result = upms.upmsUtils.inputCheck();
	// radio列表验证
	/*var nameList = new Array("tprojectApplication.expertAuditRecommend", "tprojectApplication.expertTecRecommend", "tprojectApplication.expertInvRecommend");
	var result2 = upms.upmsUtils.radioCheck(nameList);
	if(result || result2){
		return;
	}*/
	if(result){
		return;
	}
	
	if (confirm($("#comfirmSubmit").text())){
		
		$("#expertTecOpinion").get(0).value = $("#expertTecOpinion").html().replace(/<BR>/g, "\n");
		$("#expertInvOpinion").get(0).value = $("#expertInvOpinion").html().replace(/<BR>/g, "\n");
		
		var actionUrl= path + "/api/audit/projectApplication!submitAuditOpinions.action?now="+new Date().getTime();
		//alert(actionUrl);
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		/*var arrParams = [{name:"tprojectApplication.expertAuditRecommend",targetname:"tprojectApplication.expertAuditRecommend",type:"radio"},
		                 {name:"tprojectApplication.expertTecRecommend",targetname:"tprojectApplication.expertTecRecommend",type:"radio"},
		                 {name:"tprojectApplication.expertInvRecommend",targetname:"tprojectApplication.expertInvRecommend",type:"radio"}];*/
		var arrParams = [];
		arrParams = upms.upmsUtils.setSubmitDatas(arrParams, 1, 0);
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
}


/**
 * 返回
 */
function backBtn(){
	var actionUrl= path + "/api/audit/projectApplicationJoint!showJointAuditManage.action?now="+new Date().getTime();
	//alert(actionUrl);
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();
	});
}
// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	upms.upmsUtils.initSelect("expertId", "", 1, 1,1);
	$("#sendMsg").attr("disabled",true);
	$("#sendEmail").attr("disabled",true);
});

/**
 * 完成按钮事件
 */
function sendEnd(){
	//组ID
	var groupId = $("#groupId").val();
	//专家ID
	var expertId = $("#expertId").val();
	//评审时间
	var sendTime = $("#sendTime").val();
	//评审地址
	var sendAddress = $("#sendAddress").val();
	//评审会议室
	var sendMeeting = $("#sendMeeting").val();
	//评审会期
	var sendDay = $("#sendDay").val();
	//记录选择专家
	$("#selectExpertId").val(expertId);
	
	// 验证下拉列表
	var idList = new Array("expertId");
	var result2 = upms.upmsUtils.selectCheck(idList);	
	// 输入项验证
	if(upms.upmsUtils.inputCheck() || result2){
		return;
	}
	
	 $.ajax({
	       url:path + "/api/audit/projectApplicationJoint!sendEnd.action",
	       type:'post',
	       dataType:'json',
	       data:{groupId:groupId,expertId:expertId,sendTime:sendTime,sendAddress:sendAddress,sendMeeting:sendMeeting,sendDay:sendDay},
	       success:function (json){
	    	   var infoContent=json.infoContent;
	    	   $("#infoContent").text(infoContent);
	    	   $("#infoContentTr").css('display' ,'');
	    	   $("#sendMsg").attr("disabled",false);
	    		$("#sendEmail").attr("disabled",false);
	       }
	    });
}

/**
 * 发送短信
 */
function sendMessage(comfirmMsg){
	// 验证下拉列表
	var idList = new Array("expertId");
	var result2 = upms.upmsUtils.selectCheck(idList);	
	// 输入项验证
	if(upms.upmsUtils.inputCheck() || result2){
		return;
	}
	
	var selectExpertId = $("#selectExpertId").val();
	var expertId = $("#expertId").val();
	if(expertId!=selectExpertId){
		if(confirm("接受通知的用户发生改变，您确认继续发送吗？")){
			if (confirm(comfirmMsg)){
				sendFun("/api/audit/projectApplicationJoint!sendByMessage.action");
			}
		}
	}else{
		if (confirm(comfirmMsg)){
			sendFun("/api/audit/projectApplicationJoint!sendByMessage.action");
		}
	}	
}

/**
 * 发送Email
 */
function sendEmail(comfirmMsg){
	// 验证下拉列表
	var idList = new Array("expertId");
	var result2 = upms.upmsUtils.selectCheck(idList);	
	// 输入项验证
	if(upms.upmsUtils.inputCheck() || result2){
		return;
	}
	
	var selectExpertId = $("#selectExpertId").val();
	var expertId = $("#expertId").val();
	if(expertId!=selectExpertId){
		if(confirm("接受通知的用户发生改变，您确认继续发送吗？")){
			if (confirm(comfirmMsg)){
				sendFun("/api/audit/projectApplicationJoint!sendByEmail.action");
			}
		}
	}else{
		if (confirm(comfirmMsg)){
			sendFun("/api/audit/projectApplicationJoint!sendByEmail.action");
		}
	}
}

//发送通知
function sendFun(actionUrl){
	var actionUrl= path + actionUrl+"?now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [{name:"expertId",targetid:"expertId",type:"select"},
	                 {name:"infoContent",targetid:"infoContent",type:"textarea"},
	                 {name:"groupId",targetid:"groupId",type:"text"}];
	//arrParams = upms.upmsUtils.setSubmitDatas(arrParams, 1, 0);
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

/**
 * 返回
 */
function back(){
	
	var actionUrl=path + "/api/audit/projectApplication!showAuditExpertManage.action?date=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();
	});
}
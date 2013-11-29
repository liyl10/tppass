// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
	});
});


$("#saveFile").bind("click", function() {
	if ($("#onlysequence").val() == "true"){
		return;
	}
	var hidden = $("input[type='hidden']");
	if(chkRequire() == true){
		return;
	}
	if (confirm('您确定保存信息吗？')){	
		
		// 中间页面跳转路径
		$("#retUrl").val(path + "/api/supervisor/tsupervisorApply!showApplyAttachment.action?");
		var actionUrl= path + "/api/superadmin/tattachment!update.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"attachmentName",targetid:"attachmentName",type:"text"},
		                 {name:"sequence",targetid:"sequence",type:"text"}];
		//添加隐藏域
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

// 保存成功后自动跳转路径
function autoRef1(){
	if($("#chkFlg").length >0){
		var actionUrl= path + "/api/supervisor/tsupervisorApply!showApplyAttachment.action?now="+new Date().getTime();
			actionUrl = actionUrl.replace(/\&amp;/g,"&");
		 	upms.showOverLay();// 打开遮罩
			var $newPgDiv = $("#content");
			$newPgDiv.load(actionUrl,"", function() {
				upms.hideOverLay();
			}); 
	}
	else{
		if ($("#hidKey").length >0){
		window.setTimeout("autoRef1()",3000); 
		}
	}
}

// 保存成功后返回按钮跳转路径
function retloadfile(){
	
	// var url = path + "/api/acceptance/tacceptance!showIndexList.action?";
	var actionUrl= path + "/api/supervisor/tsupervisorApply!showApplyAttachment.action?now="+new Date().getTime();
		/* url + "tacceptanceId="+$("#tacceptanceId").val()
						+ "&acceptanceStatus="+$("#acceptanceStatus").val()
						+ "&now=" + new Date().getTime(); */
	actionUrl = actionUrl.replace(/\&amp;/g,"&");
 	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	$newPgDiv.load(actionUrl+"&now="+new Date().getTime(),"", function() {
		upms.hideOverLay();
		}); 
}

//文字型焦点进入事件
function focusText(now){
	// 清除错误提示信息
	$("#error" + now.id).remove();
}
// 文字型焦点离开事件
function blurText(now, text, spaceFlag, type, num){
	var flag = true;
	if($.trim(now.value)==""){
		if(spaceFlag==1){
			if(now.id =="uploadfile"){
				$("#errorSize").remove();
			}
			$("#error" + now.id).remove();
			var span = $("<em id='error"+ now.id +"'><span style='color:red;font-style: normal;'>"+ text +"不能为空！</span></em>");
			now.value="";
			$(now).parent().append(span);
			flag =false;
		}
	}else{
		// 附件格式验证
		if(type==1){
			$("#errorSize").remove();
			var fileName = $.trim(now.value);
			var fileType = $('#fileType').val();
			var type1 = fileName.substring(fileName.lastIndexOf(".") +1).toLowerCase();
			
			if(fileType.indexOf(type1) == '-1'){
				$("#error" + now.id).remove();
				var span = $("<em id='error"+ now.id +"'><span style='color:red;font-style: normal;'>附件格式应为（"+ fileType+"）</span></em>");
				$(now).parent().append(span);
				flag =false;
			}
		}
		else if(type==2){
			$("#errororder").remove();
			var pattern = /^([1-9](\d{0,2}))$/; 
			var result = pattern.test(now.value);
			if(!result){
				$("#error" + now.id).remove();
				var span = $("<em id='error"+ now.id +"'><span style='color:red;font-style: normal;'>"+ text +"格式不正确！(999)</span></em>");
				$(now).parent().append(span);
				flag =false;
			}
			else{
				sequenceOnly(now, text);
			}
		}
		else if(type==3){
			$("#error" + now.id).remove();
			if($.trim(now.value).length > num){
				var span = $("<em id='error"+ now.id +"'><span style='color:red;font-style: normal;'>"+ text+"不能超过"+num+"个汉字！</span></em>");
			    $(now).parent().append(span);
			    return false;
			}
		}
	}
	return flag;
	
} 

// 输入验证
function chkRequire(){
	var flg = false;
	if($("#attachmentName").length > 0){
		var str = $("#hiddenattachmentName").val();
		var datas=str.split(",");
		var flag = blurText($("#attachmentName").get(0), datas[0], datas[1], datas[2]);
		if(!flag){
			flg = true;
		}
	}
	if($("#sequence").length > 0){
		var str = $("#hiddensequence").val();
		var datas=str.split(",");
		var flag = blurText($("#sequence").get(0), datas[0], datas[1], datas[2]);
		if(!flag){
			flg = true;
		}
	}
	return flg;
}


$("#retBack").bind("click", function() {
	var actionUrl= path + "/api/supervisor/tsupervisorApply!showApplyAttachment.action?now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

function sequenceOnly(now, text){
	var sequence = $.trim($("#sequence").val());
	$.ajax({
           url:path + "/api/superadmin/tattachment!sequenceOnly.action?now="+ new Date().getTime(),
           type:'post',
           dataType:'json',
           data:{sequence:sequence, 
        	   tableName:$("#tableName").val(), 
        	   attachmentId:$("#attachmentId").val(), 
        	   dataId:$("#dataId").val()},
           success:function(json){
        	   var data=json.sequenceStr;
        	   $("#error" + now.id).remove();
        	   if(data=='true'){
        		   var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"已存在！</span></div>");
					$(now).parent().append(span);
        		   $("#onlysequence").val("true");
        	   		return;
        	   }else{
        		   $("#onlysequence").val("false");
        	   }
           }
        });
}
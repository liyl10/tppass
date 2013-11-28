// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
	});
});


$("#saveFile").bind("click", function() {
	if(chkRequire() == true){
		return;
	}
	if (!confirm('您确定保存信息吗？')) {
		return;
	}
	var url=$("#uploadfile").val();
	url=url.substring(url.lastIndexOf("\."),url.length);

	$("#upLoadfileName").val(url);
	
	// 中间页面跳转路径
	$("#retUrlTemp").val(path + "/api/superadmin/tattachment!targetUpload.action?");

	// 设置保存按钮状态
	$("#saveFile").attr("disabled",true).css("color", "black");
	window.setTimeout("autoRef1()",3000); 
	// 提交页面
	$("#uploadForm")[0].action = path + "/api/superadmin/tattachment.action?now=" + new Date().getTime();
	$("#uploadForm")[0].submit();
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
	if($("#uploadfile").length > 0){
		var str = $("#hiddenuploadfile").val();
		var datas=str.split(",");
		var flag = blurText($("#uploadfile").get(0), datas[0], datas[1], datas[2]);
		if(!flag){
			flg = true;
		}
	}
	if($("#explanation").length > 0){
		var domObject = $("#explanation").get(0);
		var str = $("#hiddenexplanation").val();
		var datas=str.split(",");
		var flag = blurText(domObject, datas[0], datas[1], datas[2],datas[3]);
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
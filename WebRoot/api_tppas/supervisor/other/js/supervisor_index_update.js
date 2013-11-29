
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		path=$("#path").text();
		if($("#acceptanceStatus").val() == "0"){
			$("input[type='text']").each(function(){
				$(this).attr("disabled",true);
			});
			
		 }
	});
});

$("#saveFile").bind("click", function() {
	if(upms.upmsUtils.inputCheck()){
		return;
	} 
	var hidden = $("input[type='hidden']");
	
	if (confirm($("#comfirmSave").text())){	
		
		// 中间页面跳转路径
		$("#retUrl").val(path + "/api/supervisor/supervisorOtherAction!showIndexList.action?"  + "supervisorId="+$("#supervisorId").val()+ "&isEdit="+$("#eId").val()+ "&now=" + new Date().getTime());
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
		var url = path + "/api/supervisor/supervisorOtherAction!showIndexList.action?";
		var actionUrl= url + "supervisorId="+$("#supervisorId").val()+ "&isEdit="+$("#eId").val()+ "&now=" + new Date().getTime();
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
	
	var url = path + "/api/supervisor/supervisorOtherAction!showIndexList.action?";
	var actionUrl= url + "supervisorId="+$("#supervisorId").val()+ "&acceptanceStatus="+$("#acceptanceStatus").val()+ "&now=" + new Date().getTime();
	actionUrl = actionUrl.replace(/\&amp;/g,"&");
 	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	$newPgDiv.load(actionUrl+"&now="+new Date().getTime(),"", function() {
		upms.hideOverLay();
		}); 
}

// 返回按钮功能
$("#retBack").bind("click", function() {
	var actionUrl= path + "/api/supervisor/supervisorOtherAction!showIndexList.action?isEdit="+$("#eId").val()+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [ {name : "supervisorId",targetid : "supervisorId",type : "text"},
	                  {name : "acceptanceStatus",targetid : "acceptanceStatus",type : "text"}];
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
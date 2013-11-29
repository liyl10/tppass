	// 工程根目录
	var path="";
	
	$(function() {
		$(document).ready(function() {
			path=$("#path").text();
			if($("#acceptanceStatus").val() == "0"){
				$("input[type='text']").each(function(){
					$(this).attr("disabled",true);
				});
				$("textarea").each(function(){
					$(this).attr("readonly",true);
					$(this).css('background-color','#F0F0F0');
				});
				$("#uploadfile").each(function(){
					$(this).attr("disabled",true);
				});
			 }
		});
	});
	
	// 保存按钮功能
	$("#saveFile").bind("click", function() {
		var result = chkRequireFile();
		if(result){
			return;
		} 
		//如果已经上传过评审表附件
		if($("#auditFileTr").length>0){
			if(confirm($("#comfirmNextUpload").text())){
				var attachmentId = $("#attachmentId").val();
				var scoreId = $("#dataId").val();
				 $.ajax({
				       url:path + "/api/expert/texpertScoreAction!deleAuditFile.action",
				       type:'post',
				       dataType:'json',
				       data:{attachmentId:attachmentId,scoreId:scoreId},
				       success:function (){
				    	   $("#auditFileTr").remove();
				       }
				    });
				//if (confirm($("#comfirmSave").text())){
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
				//}
			}
		}else{
			if (confirm($("#comfirmSave").text())){
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
			}
		}
	});
	
	// 保存成功后自动跳转路径
	function autoRef1(){
		if($("#chkFlg").length >0){
			var url = path + "/api/expert/texpertScoreAction!auditManager.action?";
			var actionUrl= url + "now=" + new Date().getTime();
				actionUrl = actionUrl.replace(/\&amp;/g,"&");
			 	upms.showOverLay();// 打开遮罩
				var $newPgDiv = $("#mainContent");
				$newPgDiv.load(actionUrl,"", function() {
					upms.hideOverLay();
				}); 
		}else{
			if ($("#hidKey").length >0){
			window.setTimeout("autoRef1()",3000); 
			}
		}
	}
	
	// 保存成功后返回按钮跳转路径
	function retloadfile(){
		var url = path + "/api/expert/texpertScoreAction!auditManager.action?";
		var actionUrl= url + "now=" + new Date().getTime();
		actionUrl = actionUrl.replace(/\&amp;/g,"&");
	 	upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		$newPgDiv.load(actionUrl+"&now="+new Date().getTime(),"", function() {
			upms.hideOverLay();
			}); 
	}
	
	// 返回按钮功能
	$("#retBack").bind("click", function() {
		var actionUrl= path + "/api/supervisor/supervisorOtherAction!showIndexList.action?now="+new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [ {name : "supervisorId",targetid : "supervisorId",type : "text"}];
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	});
	
	// 下载评审模板
	function downTemplate(){
		var projectId = $("#projectId").val();
		var actionUrl= path + "/api/superadmin/worddocDownload!downloadWord.action?projectId="+projectId+"&now="+new Date().getTime();
		window.location.href=actionUrl;
	}
	
	// 下载之前评审附件
	function downfile(attachmentId){
		var actionUrl= path + "/api/superadmin/tattachment!downLoadFile.action?now="+new Date().getTime()
				+ "&attachmentId=" + attachmentId;
		window.location.href=actionUrl;
	}
	
	// 删除之前评审附件
	function deleteFile(attachmentId,scoreId){
		if(confirm($("#comfirmDelete").text())){
			 $.ajax({
			       url:path + "/api/expert/texpertScoreAction!deleAuditFile.action",
			       type:'post',
			       dataType:'json',
			       data:{attachmentId:attachmentId,scoreId:scoreId},
			       success:function (){
			    	   $("#auditFileTr").remove();
			       }
			    });
		}
	}
	
	//输入验证
	function chkRequireFile(){
		var flg = false;
		if($("#uploadfile").length > 0){
			var str = $("#hiddenuploadfile").val();
			var datas=str.split(",");
			var flag = blurFileText($("#uploadfile").get(0), datas[0], datas[1], datas[2]);
			if(!flag){
				flg = true;
			}
		}
		
		return flg;
	}
	
	//文字型焦点离开事件
	function blurFileText(now, text, spaceFlag, type, num){
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
			
			// 其他验证
			else{
			}
		}
		return flag;
	} 
	
	//文字型焦点进入事件
	function focusFileText(now){
		// 清除错误提示信息
		$("#error" + now.id).remove();
	}
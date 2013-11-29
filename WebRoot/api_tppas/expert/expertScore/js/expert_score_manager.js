	// 项目根目录
	var path = "";
	
	$(document).ready(function() {
		path = $("#path").text();
	
		// 填写状态
		upms.upmsUtils.initSelect("isWrite", '', 1, 1, 0);
		// 项目名称
		upms.upmsUtils.initSelect("projectId", $("#projectIdValue").val(), 1, 1, 0);
		
		var projectId = $("#projectIdValue").val();
		if(projectId!=null&&projectId!=""){
			var actionUrl=path + "/api/expert/texpertScoreWriteAction!getScoreByProjectId.action?projectId="+projectId+"&date="+ new Date().getTime();
			var params = [];
			upms.showOverLay();// 打开遮罩
			var $newPgDiv = $("#resultDiv");
			var data = upms.transParsToObj(params, $newPgDiv);
			$newPgDiv.load(actionUrl, data, function() {
				upms.hideOverLay();
			});
		}
	});
	
	// 填写状态事件
	function isWriteOnchange(id) {
		var isWrite = $("#"+id).val();
		var groupId = $("#groupId").val();
		$.ajax({
		       url: path+'/api/expert/texpertScoreWriteAction!getProjectsByWriteState.action?groupId='+groupId,
		       type:'post',
		       dataType:'json',
		       data:{isWrite:isWrite},
		       success:function(json){
		    	   var data=json.projectListStr; 
				    var datas="";
				    if(data!=""){
				       datas=data.split(",");
				    }
				    var s_root=$("#projectId");
				    s_root.find("option").remove();
				    s_root.append("<option value=''>----请选择----</option>");
				    for(var i=0;i<datas.length;i++){
				    	 s_root.append("<option value='"+datas[i]+"'>"+datas[i+1]+"</option>");
				       	 i++;
				    }
				    s_root.trigger("liszt:updated");
		       },
		       complete:function(){
		    	   $("#dataForm").remove();
		       }
		    });
	}
	
	//项目名称事件
	function projectOnchange() {
		var projectId = $("#projectId").val();
		if(projectId!=null&&projectId!=""){
			var actionUrl = path + "/api/expert/texpertScoreWriteAction!getScoreByProjectId.action?projectId="+projectId+"&date="+ new Date().getTime();
			var params = [];
			upms.showOverLay();// 打开遮罩
			var $newPgDiv = $("#resultDiv");
			var data = upms.transParsToObj(params, $newPgDiv);
			$newPgDiv.load(actionUrl, data, function() {
				upms.hideOverLay();
			});
		}else{
			$("#dataForm").remove();
		}
	}
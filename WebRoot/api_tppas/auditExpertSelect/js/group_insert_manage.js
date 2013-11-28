// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	if($("#projecTypeManager").val()=="true"){
		// 计划类别
		upms.upmsUtils.initSelect("projectType1", "", 1, 2, 4);
		
		// 项目分类
		upms.upmsUtils.initSelect("projectType2", "", 1, 2, 4);
	}
	
});

//返回按钮
$("#backBtn").bind("click", function(){

	var actionUrl = path + "/api/audit/projectApplication!showAuditExpertManage.action?now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");

	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

/**
 * 选择项目
 */
function selectProject(){
	
	if(upms.upmsUtils.inputCheck()){
		return ;
	}	
	
	// 弹出页面actionUrl
	var actionUrl= path + "/api/audit/projectApplication!showGroupSelectProjectManage.action?groupId="+ $("#groupId").val() +"&now="+new Date().getTime();
	art.dialog.open(
		actionUrl,
		{
			title: '项目选择',
			width: '1000px',
			height: '664px',
			left: '40%',
			top: '35%',
			lock:true,
			padding: 0,
			okVal: '保存',
			ok: function(){
				var iframe = this.iframe.contentWindow;
				var selectedProjectIds = iframe.document.getElementById("selectedId");

				$.ajax({
			       url: path + "/api/audit/projectApplication!saveGroupSelectedProject.action?groupName="+encodeURIComponent($("#groupName").val()) +
							"&groupId=" + $("#groupId").val() +"&selectedProjectIds="+ selectedProjectIds.value +"&date=" + new Date().getTime(),
			       type:'post',
			       dataType:'json',
			       data:{},
			       success:function(json){
			    	   refreshQuery(json.groupId);
			       }
				 });
			},
			cancelVal: '关闭',
			cancel: true
		}
	 );
}

/**
 * 刷新列表
 */
function refreshQuery(groupId){
	var actionUrl=path + "/api/audit/projectApplication!getGroupSelectedProjectList.action?groupId="+groupId +
		"&date=" + new Date().getTime();

	upms.showOverLay();// 打开遮罩
	//alert(actionUrl);
	var $newPgDiv = $("#resultDiv");
	//var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();
		return true;
	});
}

/**
 * 保存、更新项目分组
 */
function saveGroup(){
	var result = upms.upmsUtils.inputCheck();
	var idList = new Array("projectType2");
	var result2 = upms.upmsUtils.selectCheck(idList);
	if(result || result2){
		return;
	}
	var groupName=$('#groupName').val();
	var projectType2=$('#projectType2').val();
	$.ajax({
	       url:path + '/api/audit/projectApplication!checkGroupName.action',
	       type:'post',
	       dataType:'json',
	       data:{groupName:groupName,projectType2:projectType2},
	       success:function(json){
        	   var data=json.backStr;
        	   if(data=='false'){
        		   var actionUrl=path + "/api/audit/projectApplication!saveOrUpdateGroup.action?groupName="+encodeURIComponent($("#groupName").val()) + "&date=" + new Date().getTime();
        			var params = [{name:"projectType1",targetid:"projectType1",type:"text"},
        						  {name:"projectType2",targetid:"projectType2",type:"text"},
        			              {name:"groupId",targetid:"groupId",type:"text"}];
        			upms.showOverLay();// 打开遮罩
        			var $newPgDiv = $("#mainContent");
        			var data = upms.transParsToObj(params, $newPgDiv);
        			$newPgDiv.load(actionUrl, data, function() {
        				upms.hideOverLay();
        			});
        	   		return;
        	   }else{        		   
        		   alert("该分组名称已经存在，请重新填写分组名称！");
        		   return;
        	   }
           }
	 });	
}
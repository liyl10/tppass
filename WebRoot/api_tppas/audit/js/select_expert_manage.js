//document.domain = 'xatrm.com';
// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	// 擅长专业
	//upms.upmsUtils.initSelect("goodProfess","", 1, 1, 0);
	
	// 信誉度等级
	//upms.upmsUtils.initSelect("credibyLevel", "", 1, 1, 0);
	
	// 查询按钮制域
 	/*var actionUrl=path + "/api/audit/projectApplication!getSelectedList.action?groupId="+$("#groupId").val()+"&date=" + new Date().getTime();
	var params = [];
	
	// 查询按钮制域
 	$("#queryBtn").attr("disabled",true);
	
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		$("#queryBtn").removeAttr("disabled");
	});*/
}); 

/**
 * 点击查询按钮
 */
 /*$("#queryBtn").bind("click", function() {
	 var actionUrl=path + "/api/audit/projectApplication!getSelectedList.action?projectId="+$("#projectId").val()+"&date=" + new Date().getTime();
		var params = [{name:"expertName",targetid:"expertName",type:"text"},
	              {name:"goodProfess",targetid:"goodProfess",type:"text"},
	              {name:"credibyLevel",targetid:"credibyLevel",type:"text"}];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});*/
/**
 * 继续添加专家
 * @param projectId
 */
function addExpert(groupId){
	var actionUrl= path + "/api/audit/projectApplication!showAuditSelectExpertManage.action?groupId="+ groupId+"&now="+new Date().getTime();
	art.dialog.open(
		actionUrl,
		{
			title: '专家选择',
			width: '1000px',
			height: '664px',
			left: '40%',
			top: '35%',
			lock:true,
			padding: 0,
			okVal: '保存',
			ok: function(){
				var iframe = this.iframe.contentWindow;
				var selectedExpertIds = iframe.document.getElementById("selectedId");
				if(selectedExpertIds.value == ""){
					return true;
				}
				var selectNum = selectedExpertIds.value.split(",").length;
				var selectedExpertNum = iframe.document.getElementById("selectedExpertNum").value;
				if(parseInt(selectNum) + parseInt(selectedExpertNum)-1 > 10){
					alert("您选择的专家数已经超过10个！");
					return false;
				}
				$.ajax({
			       url: path + "/api/audit/projectApplication!saveSelectedExpert.action?groupId="+$("#groupId").val() +
							"&selectedExpertIds="+ selectedExpertIds.value +"&date=" + new Date().getTime(),
			       type:'post',
			       dataType:'json',
			       data:{},
			       success:refreshQuery
				 });
			},
			cancelVal: '关闭',
			cancel: true
		}
	 );
}

/**
 * 刷新已选择的专家列表页面
 */
function refreshQuery(){
	
	var actionUrl=path + "/api/audit/projectApplication!getSelectedList.action?groupId="+$("#groupId").val() +
					"&date=" + new Date().getTime();

	upms.showOverLay();// 打开遮罩
	//alert(actionUrl);
	var $newPgDiv = $("#mainContent");
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();
		return true;
	});
}

//全选
function selectAll(){
	if($("#selectAll").attr("checked")=="checked"){
		$("input[type='checkbox']").attr("checked",true);
		$("#selectedId").attr("value","");
		$("input[type='checkbox']").each(
			function(){
				if(this.value != "true"){
					$("#selectedId").attr("value",$("#selectedId").val() + this.value + ",");
				}
			}
		);
	}
	else{
		$("input[type='checkbox']").removeAttr("checked");
		$("#selectedId").attr("value","");
	}
}

/**
 * 选择或取消选择checkbox
 * @param now
 */
function saveOrDelSelect(now){
	if($(now).attr("checked")=="checked"){
		$("#selectedId").attr("value",$("#selectedId").val() + now.value + ",");
	}
	else{
		$("#selectedId").attr("value",$("#selectedId").val().replace(now.value + ",",""));
	}
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
 /**
  * 锁定分组
  */
function clockExpert(){
	if(!confirm("确定要锁定该分组的专家吗？锁定后将不能解锁，请确认后再操作。")){
		return false;
	}
	if(!confirm("您确认要锁定吗？")){
		return false;
	}
	
	var actionUrl=path + "/api/audit/projectApplication!clockExpert.action?groupId=" 
		+ $("#groupId").val() 
		+ "&date=" 
		+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();
	});
}
 /**
  * 删除已选择的专家
  */
 function deleteExpert(relationId){
	 if(!confirm("确定要从专家列表中删除该专家吗？")){
		 return false;
	 }
 	var actionUrl=path + "/api/audit/projectApplication!deleteExpert.action?relationId="+ relationId
	 	+ "&groupId="
	 	+ $("#groupId").val()
	 	+ "&date=" + new Date().getTime();

 	upms.showOverLay();// 打开遮罩
 	var $newPgDiv = $("#mainContent");

 	$newPgDiv.load(actionUrl, null, function() {
 		upms.hideOverLay();
 	});
 }
 
 /**
  * 批量删除已选择的专家
  */
 function deleteBatchExpert(){
 	var selectFlag = false;
 	$("input[type='checkbox']").each(function(){
 		if($(this).attr("checked") =="checked"){
 			selectFlag = true;
 		}
 	});
 	if(!selectFlag){
 		alert("请至少选择一条数据！");
 		return;
 	}
 	
 	if (confirm("确定要删除选中的专家吗？")){
 		var actionUrl=path + "/api/audit/projectApplication!deleteBatchExpert.action?selectedExpertIds=" + $("#selectedId").val()
 		+ "&groupId="
 		+ $("#groupId").val()
 		+ "&date=" + new Date().getTime();

 		upms.showOverLay();// 打开遮罩
 		var $newPgDiv = $("#mainContent");
 		$newPgDiv.load(actionUrl, null, function() {
 			upms.hideOverLay();
 			$("#queryBtn").removeAttr("disabled");
 		});
 	}
 }
 /**
  * 显示发送通知
  * @param projectId
  */
 function showSendMessage(groupId){
 	var actionUrl= path + "/api/audit/projectApplicationJoint!batchSendMessage.action?groupId="+ groupId+"&now="+new Date().getTime();
 	upms.showOverLay();// 打开遮罩
 	var $newPgDiv = $("#mainContent");
 	var data = {};
 	$newPgDiv.load(actionUrl, data, function() {
 		upms.hideOverLay();
 	});
 }
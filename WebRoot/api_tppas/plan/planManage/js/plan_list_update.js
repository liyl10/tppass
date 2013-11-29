// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		if($("#proAppListCount").val() == 0){
			$("#deleteBatchBtn").attr("disabled", true);
			$("#savePlanBtn").attr("disabled", true);
			$("#selectAll").attr("disabled", true);
		}
		else{
			$("#deleteBatchBtn").removeAttr("disabled");
			$("#savePlanBtn").removeAttr("disabled");
		}
	});
});

// 分页初始化
upms.grid.gridHover($(".t-list"));

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
		//alert($("#selectedId").val());
	}
	else{
		$("input[type='checkbox']").removeAttr("checked");
		$("#selectedId").attr("value","");
		//alert($("#selectedId").val());
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
	//alert($("#selectedId").val());
}

// 项目申报详细
function showProjectDetail(typeFlag,tacceptanceId){
	var actionUrl= path + "/api/planManage/planManageAction!showAuditProjectDetail.action?typeFlag="+ typeFlag+"&tacceptanceId="+ tacceptanceId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

/**
 * 批量取消
 */
function deleteBatchProject(){
	
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
	
	if (confirm($("#comfirmCancel").text())){
		var actionUrl=path + "/api/planManage/planManageAction!deleteBatchProject.action?selectedProjectIds=" + $("#selectedId").val()
			+ "&planId=" + $("#planId").val()
			+ "&date=" + new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		$newPgDiv.load(actionUrl, null, function() {
			upms.hideOverLay();
		});
	}
}

/**
 * 取消
 */
function deleteProject(projectId){
	
	if (confirm($("#comfirmCancel").text())){
		var actionUrl=path + "/api/planManage/planManageAction!deleteProject.action?projectId="+ projectId 
			+ "&planId=" + $("#planId").val()
			+ "&date=" + new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		$newPgDiv.load(actionUrl, null, function() {
			upms.hideOverLay();
		});
	}
}
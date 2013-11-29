// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		if($("#pageCount").val() > 0){
			$("#cancelDiv").show();
		}
		else{
			$("#cancelDiv").hide();
		}
		$("#groupId").attr("value", $("#groupId1").val());
	});
});

// 分页初始化
upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"searchForm",
	resultdivid:"resultDiv",
	url:path + "/api/audit/projectApplication!getGroupSelectedProjectList.action?groupId="+ $("#groupId").val() +"&date=" + new Date().getTime()
});

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
	var actionUrl= path + "/api/audit/projectApplication!showAuditProjectDetail.action?typeFlag="+ typeFlag+"&tacceptanceId="+ tacceptanceId+"&now="+new Date().getTime();
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
function cancelBatchGroupSelect(){
	
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
		var actionUrl=path + "/api/audit/projectApplication!cancelBatchGroupSelect.action?selectedProjectIds=" + $("#selectedId").val()
			+ "&groupId=" + $("#groupId").val()
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
function cancelGroupSelect(projectId){
	
	if (confirm($("#comfirmCancel").text())){
		var actionUrl=path + "/api/audit/projectApplication!cancelGroupSelect.action?projectId="+ projectId 
			+ "&groupId=" + $("#groupId").val()
			+ "&date=" + new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		$newPgDiv.load(actionUrl, null, function() {
			upms.hideOverLay();
		});
	}
}


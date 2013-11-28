// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		var pageCount = $("#pageCount").val();
		if(pageCount == 0){
			$("#batchSendMesBtn").attr("disabled",true);
		}
		else{
			$("#batchSendMesBtn").removeAttr("disabled");
		}
	});
});

// 分页初始化
upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"searchForm",
	resultdivid:"resultDiv",
	url:path + "/api/audit/projectApplicationJoint!getSelectedList.action?projectId="+ $("#projectId").val() +"&date=" + new Date().getTime()
});

// 全选
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
	//alert($("#selectedId").val());
}


/**
 * 批量发送通知
 */
function batchSendMessage(){
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
	
	
	var actionUrl=path + "/api/audit/projectApplicationJoint!batchSendMessage.action?projectId=" + $("#projectId").val()
		+ "&selectedExpertIds=" + $("#selectedId").val()
		+ "&date=" + new Date().getTime();
	
	// 查询按钮制域
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();
	});
	
}


/**
 * 发送通知
 */
function sendMessage(expertId){
	
	var actionUrl=path + "/api/audit/projectApplicationJoint!sendMessage.action?projectId="+ $("#projectId").val()
		+ "&expertId=" + expertId
		+ "&date=" + new Date().getTime();
	
	// 查询按钮制域
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();
	});
	
}





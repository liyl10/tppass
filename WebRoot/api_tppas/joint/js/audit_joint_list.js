// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		var pageCount = $("#pageCount").val();
		if(pageCount == 0){
			$("#auditBtn").attr("disabled",true);
			$("#selectExpertBtn").attr("disabled",true);
			$("#selectAll").attr("disabled",true);
			$("#printauditResultBtn").attr("disabled",true);
			$("#downExpertScoreAndFeeCollection").attr("disabled",true);
			
		}
		else{
			$("#auditBtn").removeAttr("disabled");
			$("#selectExpertBtn").removeAttr("disabled");
			$("#selectAll").removeAttr("disabled");
			$("#printauditResultBtn").removeAttr("disabled");
			$("#downExpertScoreAndFeeCollection").removeAttr("disabled");
		}
	});
});

// 分页初始化
upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"searchForm",
	resultdivid:"resultDiv",
	url:path + "/api/audit/projectApplicationJoint!getJointAuditList.action?date=" + new Date().getTime()
});

/**
 *  全选
 */
function selectAll(){
	if($("#selectAll").attr("checked")=="checked"){
		$("input[type='checkbox']").attr("checked",true);
		$("#selectedId").attr("value","");
		$("input[type='checkbox']").each(function(){
			if($(this).attr("checked") == "checked" 
				&& this.value != "true"){
				$("#selectedId").attr("value",$("#selectedId").val() + this.value + ",");
			}
		});
		disabledBtn();
	}
	else{
		$("input[type='checkbox']").removeAttr("checked");
		$("#selectedId").attr("value","");
		$("#selectExpertBtn").removeAttr("disabled");	
	}
}

/**
 * 分组全选
 * @param now
 */
function selectGroup(now){
	var checkboxName = now.name;
	
	if($(now).attr("checked")=="checked"){
		$("[name='"+ checkboxName +"']").attr("checked",true);
		$("[name='"+ checkboxName +"']").each(function(){
			if($(this).attr("checked") == "checked" 
				&& this.value != "true"){
				$("#selectedId").attr("value",$("#selectedId").val() + this.value + ",");
			}
		});
	}
	else{
		$("[name='"+ checkboxName +"']").removeAttr("checked");
		$("[name='"+ checkboxName +"']").each(function(){
			if(this.value != "false"){
				$("#selectedId").attr("value",$("#selectedId").val().replace(this.value + ","));
			}
		});
	}
	disabledBtn();
}

/**
 * 单条数据选择
 * @param now
 */
function selectCheckbox(now){
	
	if($(now).attr("checked")=="checked"){
		$("#selectedId").attr("value",$("#selectedId").val() + now.value + ",");
	}
	else{
		$("#selectedId").attr("value",$("#selectedId").val().replace(now.value + ","));
	}
	disabledBtn();
}

/**
 * 控制批量处理按钮状态
 */
function disabledBtn(){
	var disabledFlag = false;
	$("input[type='checkbox']").each(function(){
		if($(this).attr("expertFlag") == "1" && $(this).attr("checked") == "checked"){
			disabledFlag = true;
			return;
		}
	});
	if(disabledFlag){
		$("#selectExpertBtn").attr("disabled",true);
	}
	else{
		$("#selectExpertBtn").removeAttr("disabled");
	}
}

/**
 * 批量选择专家按钮按下
 */
function showBatchSelectExpert(){
	
	var selectFlag = false;
	$("input[type='checkbox']").each(function(){
		if($(this).attr("expertFlag") !=""){
			selectFlag = true;
		}
	});
	if(!selectFlag){
		alert("请至少选择一条数据！");
		return;
	}
	else{
		
	}
}




/**------------- 项目 ---------------*/

/**
 * 显示联席会审核
 * @param projectId
 */
function showJointAudit(projectId){
	var actionUrl= path + "/api/audit/projectApplicationJoint!showJointAudit.action?projectId="+ projectId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

/**
 *专家意见
 * @param projectId
 */
function showExpertOpinions(projectId){
	var actionUrl= path + "/api/audit/projectApplication!showOpinions.action?projectId="+ projectId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

/**
 * 下载评审意见表
 * @param groupId
 */
function downloadExpertScore(projectId){
	
}

/**
 * 打印评审结果
 * @param groupId
 */
function printAuditResult(projectId){
	var actionUrl=path + "/api/expert/texpertScoreWriteAction!printExpertScoreByProject.action?projectId=" + projectId + "&now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	window.location.href= actionUrl;
	setTimeout(function(){upms.hideOverLay();},1000);
}

/**------------- 组 ---------------*/
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

/**
 * 填写意见
 * @param groupId
 */
function showFillOpinions(groupId){
	//var actionUrl= path + "/api/audit/projectApplicationJoint!showSendMessage.action?groupId="+ groupId+"&now="+new Date().getTime();
	//var actionUrl = path + "/api/expert/texpertScoreWriteAction!getProjectsByGroupId.action?groupId="+groupId+"&now="+new Date().getTime();
	var actionUrl = path + "/api/expert/texpertScoreWriteAction!projectListManager.action?groupId="+groupId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

/**
 * 打印评审结果
 * @param groupId
 */
function printAuditResultByGroup(groupId){
	var actionUrl=path + "/api/expert/texpertScoreWriteAction!printExpertScoreByGroup.action?groupId=" + groupId + "&now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	window.location.href= actionUrl;
	setTimeout(function(){upms.hideOverLay();},1000);
}

/**
 * 打印专家意见
 * @param groupId
 */
function printExpertOpinions(groupId){
	var actionUrl=path + "/api/audit/projectApplicationJoint!printExpertOpinions.action?groupId=" + groupId + "&now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	window.location.href= actionUrl;
	setTimeout(function(){upms.hideOverLay();},1000);
}

/**
 * 下载评审意见表  
 * @param groupId
 */
function downloadExpertScoreByGroup(groupId){
	var actionUrl=path + "/api/superadmin/worddocDownload!downloadExpertScoreByGroup.action?groupId="+groupId+"&now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	window.location.href= actionUrl;
	setTimeout(function(){upms.hideOverLay();},1000);
}

/**
 * 院所/高端人才录入
 * @param projectId
 */
function highEndInput(projectId){
	// 弹出页面actionUrl
	var actionUrl= path + "/api/audit/projectApplicationJoint!showHighEndInput.action?projectId="+ projectId +"&now="+new Date().getTime();
	art.dialog.open(
		actionUrl,
		{
			title: '院所/高端人才',
			width: '500px',
			height: '300px',
			left: '40%',
			top: '35%',
			lock:true,
			padding: 0,
			okVal: '保存',
			ok: function(){
				var iframe = this.iframe.contentWindow;
				var highEnd = iframe.document.getElementById("highEnd");
				// 项目分组未改变
				$.ajax({
			       url: path + "/api/audit/projectApplicationJoint!updateHighEndInput.action?projectId="+ projectId +
							"&highEnd=" + encodeURI(highEnd.value) +"&date=" + new Date().getTime(),
			       type:'post',
			       dataType:'json',
			       data:{},
			       success:true
				 });
			},
			cancelVal: '关闭',
			cancel: true
		}
	 );
}

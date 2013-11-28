// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		var pageCount = $("#pageCount").val();
		if(pageCount == 0){
			$("#auditBtn").attr("disabled",true);
			//$("#createGroupBtn").attr("disabled",true);
			$("#selectExpertBtn").attr("disabled",true);
		}
		else{
			$("#auditBtn").removeAttr("disabled");
			//$("#createGroupBtn").removeAttr("disabled");
			$("#selectExpertBtn").removeAttr("disabled");
		}
	});
});

// 分页初始化
upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"searchForm",
	resultdivid:"resultDiv",
	url:path + "/api/audit/projectApplication!getAuditExpertList.action?date=" + new Date().getTime()
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

// 编辑分组
function editGroup(groupId){
	var actionUrl= path + "/api/audit/projectApplication!editGroup.action?groupId="
		+ groupId 
		+ "&now="
		+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}
		
//删除项目分组
function deleteGroup(groupId){
	if(!confirm("删除分组会同时删除该分组在项目评审、立项建议、局办公会意见等功能中已有的数据！\n且项目分组删除后将不可恢复，确定要删除该项目分组吗？")){
		return false;
	}
	if(!confirm("确定要删除该项目分组吗？")){
		return false;
	}
	var actionUrl= path + "/api/audit/projectApplication!deleteGroup.action?groupId="+ groupId +"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
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


//企业信息详细
function showCompanyDetail(typeFlag,tacceptanceId){
	var actionUrl= path + "/api/audit/projectApplication!showAuditCompanyDetail.action?typeFlag="+ typeFlag+"&tacceptanceId="+ tacceptanceId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

// 选择专家
function selectExpert(typeFlag,tacceptanceId){
	var actionUrl= path + "/api/audit/expertScore!selectExpertManage.action?typeFlag="+ typeFlag+"&tacceptanceId="+ tacceptanceId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

/**
 * 查看专家评审进度
 * @param typeFlag
 * @param tacceptanceId
 */
function showAuditPropress(projectId){
	var actionUrl= path + "/api/audit/projectApplication!showAuditPropress.action?projectId="+ projectId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

/**
 * 填写意见
 * @param projectId
 */
function showFillOpinions(projectId){
	var actionUrl= path + "/api/audit/projectApplication!showOpinions.action?projectId="+ projectId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

/**------------- 分割线 ---------------*/

/**
 * 选择评审专家
 * @param projectId
 */
function showSelectedExpert(groupId){
	var actionUrl= path + "/api/audit/projectApplication!getSelectedList.action?groupId="+ groupId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}


/**
 * 改变分组
 * @param projectId
 */
function changeGroup(projectId, groupId){
	if(!confirm("改变分组会删除该项目在原分组中已有的数据，\n比如：项目评分、专家意见、立项建议、局办公会意见等，\n确定要改变分组吗？")){
		return false;
	}
	// 弹出页面actionUrl
	var actionUrl= path + "/api/audit/projectApplication!showGroupList.action?projectId="+ projectId +"&now="+new Date().getTime();
	art.dialog.open(
		actionUrl,
		{
			title: '项目分组选择',
			width: '600px',
			height: '400px',
			left: '40%',
			top: '35%',
			lock:true,
			padding: 0,
			okVal: '保存',
			ok: function(){
				var iframe = this.iframe.contentWindow;
				var projectGroupSon = iframe.document.getElementById("projectGroupSon");
				// 项目分组未改变
				if(projectGroupSon.value != groupId || projectGroupSon.value==""){
					$.ajax({
				       url: path + "/api/audit/projectApplication!updateProjectGroup.action?projectId="+ projectId +
								"&groupId=" + projectGroupSon.value +"&date=" + new Date().getTime(),
				       type:'post',
				       dataType:'json',
				       data:{},
				       success:refreshQuery
					 });
				}
			},
			cancelVal: '关闭',
			cancel: true
		}
	 );
}

/**
 * 改变分组页面关闭后刷新列表
 * @param groupId
 */
function refreshQuery(){
	// 查询按钮制域
 	$("#queryBtn").attr("disabled",true);
 	
 	var actionUrl=path + "/api/audit/projectApplication!getAuditExpertList.action?date=" + new Date().getTime();
	var params = [{name:"projectName",targetid:"projectName",type:"text"},
	              {name:"applyCompany",targetid:"applyCompany",type:"text"},
	              {name:"projectType1",targetid:"projectType1",type:"text"},
	              {name:"projectType2",targetid:"projectType2",type:"text"},
	              {name:"auditStatus",targetid:"auditStatus",type:"text"},
	              {name:"projectGroup",targetid:"projectGroup",type:"text"}];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		$("#queryBtn").removeAttr("disabled");
	});
}


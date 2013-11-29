// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		var pageCount = $("#pageCount").val();
		if(pageCount == 0){
			$("#auditBtn").attr("disabled",true);
			$("#createGroupBtn").attr("disabled",true);
			$("#selectExpertBtn").attr("disabled",true);
		}
		else{
			$("#auditBtn").removeAttr("disabled");
			$("#createGroupBtn").removeAttr("disabled");
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
	url:path + "/api/audit/projectApplication!getAuditList.action?date=" + new Date().getTime()
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
		$("#selectedId").attr("value",$("#selectedId").val() + this.value + ",");
	}
	else{
		$("#selectedId").attr("value",$("#selectedId").val().replace(this.value + ","));
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
 * 选择评审专家
 * @param projectId
 */
function showSelectedExpert(projectId){
	var actionUrl= path + "/api/audit/projectApplication!showExpertSelected.action?projectId="+ projectId+"&now="+new Date().getTime();
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

// 下载评审意见表
function downLoadExpertScore(){
	var actionUrl= path + "/api/superadmin/worddocDownload!downloadWord.action?now="+new Date().getTime();
	window.location.href=actionUrl;
}



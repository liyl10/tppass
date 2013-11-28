// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		if ($("#listFlag").val() == '0'){
			$("#selectAll").attr("disabled",true);
		}
		else{
			$("#selectAll").attr("disabled",false);
		}
	});
});

// 分页初始化
upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"searchForm",
	resultdivid:"resultDiv",
	url:path + "/api/audit/projectApplicationProposals!getProposalsList.action?date=" + new Date().getTime()
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
				&& this.value != "true"  && this.value !=""){
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
				&& this.value != "true"  && this.value !=""){
				$("#selectedId").attr("value",$("#selectedId").val() + this.value + ",");
			}
		});
	}
	else{
		$("[name='"+ checkboxName +"']").removeAttr("checked");
		$("[name='"+ checkboxName +"']").each(function(){
			if(this.value != "false" && this.value !=""){
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


/**
 * 其他意见
 * @param projectId
 */
function otherComments(projectId){
	// 弹出页面actionUrl
	var actionUrl= path + "/api/audit/projectApplicationProposals!showOtherComments.action?projectId="+ projectId +"&now="+new Date().getTime();
	art.dialog.open(
		actionUrl,
		{
			title: '其他意见',
			width: '600px',
			height: '400px',
			left: '40%',
			top: '35%',
			lock:true,
			padding: 0,
			okVal: '保存',
			ok: function(){
				var iframe = this.iframe.contentWindow;
				var otherComments = iframe.document.getElementById("otherComments");
				// 项目分组未改变
				if(otherComments.value!=""){
					$.ajax({	
				       url: path + "/api/audit/projectApplicationProposals!updateOtherComments.action?projectId="+ projectId +
								"&otherComments=" + encodeURIComponent(otherComments.value) +"&date=" + new Date().getTime(),
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
 * 其他意见关闭后刷新列表
 * @param groupId
 */
function refreshQuery(){
	// 查询按钮制域
 	$("#queryBtn").attr("disabled",true);
 	
 	var actionUrl=path + "/api/audit/projectApplicationProposals!getProposalsList.action?date=" + new Date().getTime();
	var params = [{name:"projectName",targetid:"projectName",type:"text"},
	              {name:"applyCompany",targetid:"applyCompany",type:"text"},
	              {name:"projectType1",targetid:"projectType1",type:"text"},
	              {name:"projectType2",targetid:"projectType2",type:"text"}];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		$("#queryBtn").removeAttr("disabled");
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

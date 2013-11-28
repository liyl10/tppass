// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		var pageCount = $("#pageCount").val();
		if(pageCount == 0){
			$("#auditBtn").attr("disabled",true);
			$("#createGroupBtn").attr("disabled",true);
		}
		else{
			$("#auditBtn").removeAttr("disabled");
			$("#createGroupBtn").removeAttr("disabled");
		}
	});
});

/*// 分页初始化
upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"searchForm",
	resultdivid:"resultDiv",
	url:path + "/api/audit/projectApplication!getSelectedList.action?projectId="+ $("#projectId").val() +"&date=" + new Date().getTime()
});*/

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
}

/**
 * 继续添加专家
 * @param projectId
 */
function addExpert(projectId){
	var actionUrl= path + "/api/audit/projectApplication!showAuditSelectExpertManage.action?projectId="+ projectId+"&now="+new Date().getTime();
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

				$.ajax({
			       url: path + "/api/audit/projectApplication!saveSelectedExpert.action?projectId="+$("#projectId").val() +
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
	
	var actionUrl=path + "/api/audit/projectApplication!getSelectedList.action?projectId="+$("#projectId").val() +
					"&date=" + new Date().getTime();
	
	var params = [{name:"selectName",targetid:"selectName",type:"text"},
    {name:"goodProfess",targetid:"goodProfess",type:"text"},
    {name:"credibyLevel",targetid:"credibyLevel",type:"text"}];
	upms.showOverLay();// 打开遮罩
	//alert(actionUrl);
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		return true;
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
	
	if (confirm($("#comfirmDelete").text())){
		var actionUrl=path + "/api/audit/projectApplication!deleteBatchExpert.action?projectId=" + $("#projectId").val()
			+ "&selectedExpertIds=" + $("#selectedId").val()
			+ "&date=" + new Date().getTime();
		
		// 查询按钮制域
	 	$("#queryBtn").attr("disabled",true);
		
		var params = [{name:"expertName",targetid:"expertName",type:"text"},
		              {name:"goodProfess",targetid:"goodProfess",type:"text"},
		              {name:"credibyLevel",targetid:"credibyLevel",type:"text"}];
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		var data = upms.transParsToObj(params, $("#searchForm"));
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
			$("#queryBtn").removeAttr("disabled");
		});
	}
}


/**
 * 删除已选择的专家
 */
function deleteExpert(expertId){
	if (confirm($("#comfirmDelete").text())){
		var actionUrl=path + "/api/audit/projectApplication!deleteExpert.action?projectId="+ $("#projectId").val()
			+ "&expertId=" + expertId
			+ "&date=" + new Date().getTime();
		
		// 查询按钮制域
	 	$("#queryBtn").attr("disabled",true);
		
		var params = [{name:"expertName",targetid:"expertName",type:"text"},
		              {name:"goodProfess",targetid:"goodProfess",type:"text"},
		              {name:"credibyLevel",targetid:"credibyLevel",type:"text"}];
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		var data = upms.transParsToObj(params, $("#searchForm"));
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
			$("#queryBtn").removeAttr("disabled");
		});
	}
}

//下载评审意见表
function downLoadExpertScore(){
	var actionUrl= path + "/api/superadmin/worddocDownload!downloadWord.action?projectId="
			+ $("#projectId").val()
			+ "&now="+new Date().getTime();
	window.location.href=actionUrl;
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

// 查看专家评审进度
function showExpertProcess(typeFlag,tacceptanceId){
	var actionUrl= path + "/api/audit/expertScore!showProcessManage.action?typeFlag="+ typeFlag+"&tacceptanceId="+ tacceptanceId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

//专家选择页面
function showSelectedExpert(projectId){
	var actionUrl= path + "/api/audit/projectApplication!showExpertSelected.action?projectId="+ projectId+"&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}




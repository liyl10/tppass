// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		var pageCount = $("#pageCount").val();
		if(pageCount == 0){
			$("#printBtn").attr("disabled",true);
		}
		else{
			$("#printBtn").removeAttr("disabled");
		}
	});
});

// 分页初始化
upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"searchForm",
	resultdivid:"resultDiv",
	url:path + "/api/audit/projectApplication!getAuditProgressList.action?projectId="+ $("#projectId").val() +"&date=" + new Date().getTime()
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
 * 催办
 */
function sendMessage(expertId){
	
	var actionUrl=path + "/api/audit/projectApplication!sendMessage.action?projectId="+ $("#projectId").val()
	+ "&expertId=" + expertId
	+ "&date=" + new Date().getTime();

	// 查询按钮制域
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();
	});
}

//下载评审意见表
function downLoadExpertScore(){
	var actionUrl= path + "/api/superadmin/worddocDownload!downloadWord.action?projectId="
			+ $("#projectId").val()
			+ "&now="+new Date().getTime();
	window.location.href=actionUrl;
}




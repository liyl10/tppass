// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		var pageCount = $("#pageCount").val();
		if(pageCount == 0){
			$("#selectExpertBtn").attr("disabled",true);
			$("#selectAll").attr("disabled",true);

		}
		else{
			$("#selectExpertBtn").removeAttr("disabled");
			$("#selectAll").removeAttr("disabled");
		}
	});
});

// 分页初始化
upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"searchForm",
	resultdivid:"resultDiv",
	url:path + "/api/audit/projectApplicationOffice!getOfficeAuditList.action?date=" + new Date().getTime()
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
				&& this.value != "true" && this.value !=""){
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
				&& this.value != "true" && this.value !=""){
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
	/*var disabledFlag = false;
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
	}*/
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

/**
 * 查看局办公会意见
 * @param projectId
 */
function showDetail(projectId){
	// 弹出页面actionUrl
	var actionUrl= path + "/api/audit/projectApplicationOffice!showDetail.action?projectId="+ projectId +"&now="+new Date().getTime();
	art.dialog.open(
		actionUrl,
		{
			title: '处室意见',
			width: '600px',
			height: '400px',
			left: '40%',
			top: '35%',
			lock:true,
			padding: 0,
			cancelVal: '关闭',
			cancel: true
		}
	 );
}





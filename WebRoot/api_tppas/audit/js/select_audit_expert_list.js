// 项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
	});
});

// 初始化列表样式
upms.grid.gridHover($(".t-list"));


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




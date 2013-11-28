// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	
	// 计划类别
	//upms.upmsUtils.initSelect("projectType1", "", 1, 2, 4);
	
	// 项目分类
	//upms.upmsUtils.initSelect("projectType2", "", 1, 2, 4);
	
	// 审核状态
	//upms.upmsUtils.initSelect("auditStatus", "", 1, 1, 0);
	
	// 项目分组
	upms.upmsUtils.initSelect("projectGroup", "", 1, 1, 0);
	
	// 查询按钮制域
 	$("#queryBtn").attr("disabled",true);
 	
 	/*var data = "";
 	data = data + "projectName=" + encodeURIComponent($("#projectName").val());
 	data = data + "&applyCompany=" + encodeURIComponent($("#applyCompany").val());
 	data = data + "&projectType1=" + $("#projectType1").val();
 	data = data + "&projectType2=" + $("#projectType2").val();
 	data = data + "&auditStatus=" + $("#auditStatus").val();
 	data = data + "&projectGroup=" + $("#projectGroup").val();
 	data = data + "&groupId=" + $("#groupId").val();*/
 	var actionUrl=path + "/api/audit/projectApplication!getGroupSelectProjectList.action?" + data +"&date=" + new Date().getTime();
	var params = [{name:"projectName",targetid:"projectName",type:"text"},
	              {name:"applyCompany",targetid:"applyCompany",type:"text"},
	              {name:"projectType1",targetid:"projectType1",type:"text"},
	              {name:"projectType2",targetid:"projectType2",type:"text"},
	              {name:"auditStatus",targetid:"auditStatus",type:"text"},
	              {name:"groupId",targetid:"groupId",type:"text"}];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		$("#queryBtn").removeAttr("disabled");
	});
}); 

/**
 * 查询
 */
function queryData(){
	/*var data = "";
 	data = data + "projectName=" + encodeURIComponent($("#projectName").val());
 	data = data + "&applyCompany=" + encodeURIComponent($("#applyCompany").val());
 	data = data + "&projectType1=" + $("#projectType1").val();
 	data = data + "&projectType2=" + $("#projectType2").val();
 	data = data + "&auditStatus=" + $("#auditStatus").val();
 	data = data + "&projectGroup=" + $("#projectGroup").val();
 	data = data + "&groupId=" + $("#groupId").val();	*/
	var actionUrl=path + "/api/audit/projectApplication!getGroupSelectProjectList.action?"+ data +"&date=" + new Date().getTime();
	var params = [{name:"projectName",targetid:"projectName",type:"text"},
	              {name:"applyCompany",targetid:"applyCompany",type:"text"},
	              {name:"projectType1",targetid:"projectType1",type:"text"},
	              {name:"projectType2",targetid:"projectType2",type:"text"},
	              {name:"auditStatus",targetid:"auditStatus",type:"text"},
	              {name:"groupId",targetid:"groupId",type:"text"}];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}
/**
 * 保存、更新项目分组
 */
function saveGroup(){
	if($("#selectedId").val().length < 1){
		alert("没有选择项目，请先选择分配到该分组的项目。");
		return false;
	}
	if(!confirm("确定要提交数据吗？")){
		return false;
	}
	var actionUrl=path + "/api/audit/projectApplication!saveGroupSelectedProject.action?groupId=" 
		+ $("#groupId").val() 
		+"&groupName="
		//+ selectedProjectIds.value
		+ encodeURIComponent($("#groupName").val())
		+"&selectedProjectIds="
		//+ selectedProjectIds.value
		+ $("#selectedId").val()
		+ "&projectType1="
		+ $("#projectType1").val()
		+ "&projectType2="
		+ $("#projectType2").val()
		+ "&pageDirectFlag="
		+ $("#pageDirectFlag").val();
		+"&date=" 
		+ new Date().getTime();
	
	var params = [];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = upms.transParsToObj(params, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}
//返回按钮
$("#backBtn").bind("click", function(){
	var backFlag = $("#pageDirectFlag").val();
	var actionUrl = "";
	if(backFlag == "new"){
		actionUrl = path + "/api/audit/projectApplication!showAuditExpertManage.action?now=" + new Date().getTime();
	}else{
		var groupId = $("#groupId").val();
		actionUrl= path + "/api/audit/projectApplication!editGroup.action?groupId="
			+ groupId 
			+ "&now="
			+ new Date().getTime();
	}
	
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");

	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

 